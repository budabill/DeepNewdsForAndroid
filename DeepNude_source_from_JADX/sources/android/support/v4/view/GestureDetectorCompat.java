package android.support.v4.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

public final class GestureDetectorCompat {
    private final GestureDetectorCompatImpl mImpl;

    interface GestureDetectorCompatImpl {
        boolean isLongpressEnabled();

        boolean onTouchEvent(MotionEvent motionEvent);

        void setIsLongpressEnabled(boolean z);

        void setOnDoubleTapListener(OnDoubleTapListener onDoubleTapListener);
    }

    static class GestureDetectorCompatImplBase implements GestureDetectorCompatImpl {
        private static final int DOUBLE_TAP_TIMEOUT = ViewConfiguration.getDoubleTapTimeout();
        private static final int LONGPRESS_TIMEOUT = ViewConfiguration.getLongPressTimeout();
        private static final int LONG_PRESS = 2;
        private static final int SHOW_PRESS = 1;
        private static final int TAP = 3;
        private static final int TAP_TIMEOUT = ViewConfiguration.getTapTimeout();
        private boolean mAlwaysInBiggerTapRegion;
        private boolean mAlwaysInTapRegion;
        MotionEvent mCurrentDownEvent;
        boolean mDeferConfirmSingleTap;
        OnDoubleTapListener mDoubleTapListener;
        private int mDoubleTapSlopSquare;
        private float mDownFocusX;
        private float mDownFocusY;
        private final Handler mHandler;
        private boolean mInLongPress;
        private boolean mIsDoubleTapping;
        private boolean mIsLongpressEnabled;
        private float mLastFocusX;
        private float mLastFocusY;
        final OnGestureListener mListener;
        private int mMaximumFlingVelocity;
        private int mMinimumFlingVelocity;
        private MotionEvent mPreviousUpEvent;
        boolean mStillDown;
        private int mTouchSlopSquare;
        private VelocityTracker mVelocityTracker;

        private class GestureHandler extends Handler {
            GestureHandler() {
            }

            GestureHandler(Handler handler) {
                super(handler.getLooper());
            }

            public void handleMessage(Message message) {
                int i = message.what;
                GestureDetectorCompatImplBase gestureDetectorCompatImplBase;
                if (i == 1) {
                    gestureDetectorCompatImplBase = GestureDetectorCompatImplBase.this;
                    gestureDetectorCompatImplBase.mListener.onShowPress(gestureDetectorCompatImplBase.mCurrentDownEvent);
                } else if (i == 2) {
                    GestureDetectorCompatImplBase.this.dispatchLongPress();
                } else if (i == 3) {
                    gestureDetectorCompatImplBase = GestureDetectorCompatImplBase.this;
                    OnDoubleTapListener onDoubleTapListener = gestureDetectorCompatImplBase.mDoubleTapListener;
                    if (onDoubleTapListener == null) {
                        return;
                    }
                    if (gestureDetectorCompatImplBase.mStillDown) {
                        gestureDetectorCompatImplBase.mDeferConfirmSingleTap = true;
                    } else {
                        onDoubleTapListener.onSingleTapConfirmed(gestureDetectorCompatImplBase.mCurrentDownEvent);
                    }
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unknown message ");
                    stringBuilder.append(message);
                    throw new RuntimeException(stringBuilder.toString());
                }
            }
        }

        GestureDetectorCompatImplBase(Context context, OnGestureListener onGestureListener, Handler handler) {
            if (handler != null) {
                this.mHandler = new GestureHandler(handler);
            } else {
                this.mHandler = new GestureHandler();
            }
            this.mListener = onGestureListener;
            if (onGestureListener instanceof OnDoubleTapListener) {
                setOnDoubleTapListener((OnDoubleTapListener) onGestureListener);
            }
            init(context);
        }

        private void cancel() {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.removeMessages(3);
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
            this.mIsDoubleTapping = false;
            this.mStillDown = false;
            this.mAlwaysInTapRegion = false;
            this.mAlwaysInBiggerTapRegion = false;
            this.mDeferConfirmSingleTap = false;
            if (this.mInLongPress) {
                this.mInLongPress = false;
            }
        }

        private void cancelTaps() {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.removeMessages(3);
            this.mIsDoubleTapping = false;
            this.mAlwaysInTapRegion = false;
            this.mAlwaysInBiggerTapRegion = false;
            this.mDeferConfirmSingleTap = false;
            if (this.mInLongPress) {
                this.mInLongPress = false;
            }
        }

        private void init(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null");
            } else if (this.mListener != null) {
                this.mIsLongpressEnabled = true;
                ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
                int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
                this.mMinimumFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
                this.mMaximumFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
                this.mTouchSlopSquare = scaledTouchSlop * scaledTouchSlop;
                this.mDoubleTapSlopSquare = scaledDoubleTapSlop * scaledDoubleTapSlop;
            } else {
                throw new IllegalArgumentException("OnGestureListener must not be null");
            }
        }

        private boolean isConsideredDoubleTap(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
            boolean z = false;
            if (!this.mAlwaysInBiggerTapRegion || motionEvent3.getEventTime() - motionEvent2.getEventTime() > ((long) DOUBLE_TAP_TIMEOUT)) {
                return false;
            }
            int x = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
            int y = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
            if ((x * x) + (y * y) < this.mDoubleTapSlopSquare) {
                z = true;
            }
            return z;
        }

        void dispatchLongPress() {
            this.mHandler.removeMessages(3);
            this.mDeferConfirmSingleTap = false;
            this.mInLongPress = true;
            this.mListener.onLongPress(this.mCurrentDownEvent);
        }

        public boolean isLongpressEnabled() {
            return this.mIsLongpressEnabled;
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
            action &= 255;
            Object obj = action == 6 ? 1 : null;
            int actionIndex = obj != null ? motionEvent.getActionIndex() : -1;
            int pointerCount = motionEvent.getPointerCount();
            float f = 0.0f;
            float f2 = 0.0f;
            for (int i = 0; i < pointerCount; i++) {
                if (actionIndex != i) {
                    f += motionEvent.getX(i);
                    f2 += motionEvent.getY(i);
                }
            }
            float f3 = (float) (obj != null ? pointerCount - 1 : pointerCount);
            f /= f3;
            f2 /= f3;
            MotionEvent motionEvent2;
            if (action != 0) {
                boolean onDoubleTapEvent;
                float xVelocity;
                if (action == 1) {
                    this.mStillDown = false;
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    if (this.mIsDoubleTapping) {
                        onDoubleTapEvent = this.mDoubleTapListener.onDoubleTapEvent(motionEvent) | false;
                    } else {
                        if (this.mInLongPress) {
                            this.mHandler.removeMessages(3);
                            this.mInLongPress = false;
                        } else if (this.mAlwaysInTapRegion) {
                            boolean onSingleTapUp = this.mListener.onSingleTapUp(motionEvent);
                            if (this.mDeferConfirmSingleTap) {
                                OnDoubleTapListener onDoubleTapListener = this.mDoubleTapListener;
                                if (onDoubleTapListener != null) {
                                    onDoubleTapListener.onSingleTapConfirmed(motionEvent);
                                }
                            }
                            onDoubleTapEvent = onSingleTapUp;
                        } else {
                            VelocityTracker velocityTracker = this.mVelocityTracker;
                            actionIndex = motionEvent.getPointerId(0);
                            velocityTracker.computeCurrentVelocity(1000, (float) this.mMaximumFlingVelocity);
                            float yVelocity = velocityTracker.getYVelocity(actionIndex);
                            xVelocity = velocityTracker.getXVelocity(actionIndex);
                            if (Math.abs(yVelocity) <= ((float) this.mMinimumFlingVelocity)) {
                                if (Math.abs(xVelocity) > ((float) this.mMinimumFlingVelocity)) {
                                }
                            }
                            onDoubleTapEvent = this.mListener.onFling(this.mCurrentDownEvent, motionEvent, xVelocity, yVelocity);
                        }
                        onDoubleTapEvent = false;
                    }
                    motionEvent2 = this.mPreviousUpEvent;
                    if (motionEvent2 != null) {
                        motionEvent2.recycle();
                    }
                    this.mPreviousUpEvent = obtain;
                    VelocityTracker velocityTracker2 = this.mVelocityTracker;
                    if (velocityTracker2 != null) {
                        velocityTracker2.recycle();
                        this.mVelocityTracker = null;
                    }
                    this.mIsDoubleTapping = false;
                    this.mDeferConfirmSingleTap = false;
                    this.mHandler.removeMessages(1);
                    this.mHandler.removeMessages(2);
                } else if (action != 2) {
                    if (action == 3) {
                        cancel();
                        return false;
                    } else if (action == 5) {
                        this.mLastFocusX = f;
                        this.mDownFocusX = f;
                        this.mLastFocusY = f2;
                        this.mDownFocusY = f2;
                        cancelTaps();
                        return false;
                    } else if (action != 6) {
                        return false;
                    } else {
                        this.mLastFocusX = f;
                        this.mDownFocusX = f;
                        this.mLastFocusY = f2;
                        this.mDownFocusY = f2;
                        this.mVelocityTracker.computeCurrentVelocity(1000, (float) this.mMaximumFlingVelocity);
                        action = motionEvent.getActionIndex();
                        int pointerId = motionEvent.getPointerId(action);
                        float xVelocity2 = this.mVelocityTracker.getXVelocity(pointerId);
                        xVelocity = this.mVelocityTracker.getYVelocity(pointerId);
                        for (int i2 = 0; i2 < pointerCount; i2++) {
                            if (i2 != action) {
                                actionIndex = motionEvent.getPointerId(i2);
                                if ((this.mVelocityTracker.getXVelocity(actionIndex) * xVelocity2) + (this.mVelocityTracker.getYVelocity(actionIndex) * xVelocity) < 0.0f) {
                                    this.mVelocityTracker.clear();
                                    return false;
                                }
                            }
                        }
                        return false;
                    }
                } else if (this.mInLongPress) {
                    return false;
                } else {
                    float f4 = this.mLastFocusX - f;
                    xVelocity = this.mLastFocusY - f2;
                    if (this.mIsDoubleTapping) {
                        return false | this.mDoubleTapListener.onDoubleTapEvent(motionEvent);
                    }
                    if (this.mAlwaysInTapRegion) {
                        pointerCount = (int) (f - this.mDownFocusX);
                        int i3 = (int) (f2 - this.mDownFocusY);
                        pointerCount = (pointerCount * pointerCount) + (i3 * i3);
                        if (pointerCount > this.mTouchSlopSquare) {
                            onDoubleTapEvent = this.mListener.onScroll(this.mCurrentDownEvent, motionEvent, f4, xVelocity);
                            this.mLastFocusX = f;
                            this.mLastFocusY = f2;
                            this.mAlwaysInTapRegion = false;
                            this.mHandler.removeMessages(3);
                            this.mHandler.removeMessages(1);
                            this.mHandler.removeMessages(2);
                        } else {
                            onDoubleTapEvent = false;
                        }
                        if (pointerCount > this.mTouchSlopSquare) {
                            this.mAlwaysInBiggerTapRegion = false;
                        }
                    } else if (Math.abs(f4) < 1.0f && Math.abs(xVelocity) < 1.0f) {
                        return false;
                    } else {
                        boolean onScroll = this.mListener.onScroll(this.mCurrentDownEvent, motionEvent, f4, xVelocity);
                        this.mLastFocusX = f;
                        this.mLastFocusY = f2;
                        return onScroll;
                    }
                }
                return onDoubleTapEvent;
            }
            if (this.mDoubleTapListener != null) {
                boolean hasMessages = this.mHandler.hasMessages(3);
                if (hasMessages) {
                    this.mHandler.removeMessages(3);
                }
                motionEvent2 = this.mCurrentDownEvent;
                if (motionEvent2 != null) {
                    MotionEvent motionEvent3 = this.mPreviousUpEvent;
                    if (motionEvent3 != null && hasMessages && isConsideredDoubleTap(motionEvent2, motionEvent3, motionEvent)) {
                        this.mIsDoubleTapping = true;
                        action = (this.mDoubleTapListener.onDoubleTap(this.mCurrentDownEvent) | 0) | this.mDoubleTapListener.onDoubleTapEvent(motionEvent);
                        this.mLastFocusX = f;
                        this.mDownFocusX = f;
                        this.mLastFocusY = f2;
                        this.mDownFocusY = f2;
                        motionEvent2 = this.mCurrentDownEvent;
                        if (motionEvent2 != null) {
                            motionEvent2.recycle();
                        }
                        this.mCurrentDownEvent = MotionEvent.obtain(motionEvent);
                        this.mAlwaysInTapRegion = true;
                        this.mAlwaysInBiggerTapRegion = true;
                        this.mStillDown = true;
                        this.mInLongPress = false;
                        this.mDeferConfirmSingleTap = false;
                        if (this.mIsLongpressEnabled) {
                            this.mHandler.removeMessages(2);
                            this.mHandler.sendEmptyMessageAtTime(2, (this.mCurrentDownEvent.getDownTime() + ((long) TAP_TIMEOUT)) + ((long) LONGPRESS_TIMEOUT));
                        }
                        this.mHandler.sendEmptyMessageAtTime(1, this.mCurrentDownEvent.getDownTime() + ((long) TAP_TIMEOUT));
                        return action | this.mListener.onDown(motionEvent);
                    }
                }
                this.mHandler.sendEmptyMessageDelayed(3, (long) DOUBLE_TAP_TIMEOUT);
            }
            action = 0;
            this.mLastFocusX = f;
            this.mDownFocusX = f;
            this.mLastFocusY = f2;
            this.mDownFocusY = f2;
            motionEvent2 = this.mCurrentDownEvent;
            if (motionEvent2 != null) {
                motionEvent2.recycle();
            }
            this.mCurrentDownEvent = MotionEvent.obtain(motionEvent);
            this.mAlwaysInTapRegion = true;
            this.mAlwaysInBiggerTapRegion = true;
            this.mStillDown = true;
            this.mInLongPress = false;
            this.mDeferConfirmSingleTap = false;
            if (this.mIsLongpressEnabled) {
                this.mHandler.removeMessages(2);
                this.mHandler.sendEmptyMessageAtTime(2, (this.mCurrentDownEvent.getDownTime() + ((long) TAP_TIMEOUT)) + ((long) LONGPRESS_TIMEOUT));
            }
            this.mHandler.sendEmptyMessageAtTime(1, this.mCurrentDownEvent.getDownTime() + ((long) TAP_TIMEOUT));
            return action | this.mListener.onDown(motionEvent);
        }

        public void setIsLongpressEnabled(boolean z) {
            this.mIsLongpressEnabled = z;
        }

        public void setOnDoubleTapListener(OnDoubleTapListener onDoubleTapListener) {
            this.mDoubleTapListener = onDoubleTapListener;
        }
    }

    static class GestureDetectorCompatImplJellybeanMr2 implements GestureDetectorCompatImpl {
        private final GestureDetector mDetector;

        GestureDetectorCompatImplJellybeanMr2(Context context, OnGestureListener onGestureListener, Handler handler) {
            this.mDetector = new GestureDetector(context, onGestureListener, handler);
        }

        public boolean isLongpressEnabled() {
            return this.mDetector.isLongpressEnabled();
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            return this.mDetector.onTouchEvent(motionEvent);
        }

        public void setIsLongpressEnabled(boolean z) {
            this.mDetector.setIsLongpressEnabled(z);
        }

        public void setOnDoubleTapListener(OnDoubleTapListener onDoubleTapListener) {
            this.mDetector.setOnDoubleTapListener(onDoubleTapListener);
        }
    }

    public GestureDetectorCompat(Context context, OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    public GestureDetectorCompat(Context context, OnGestureListener onGestureListener, Handler handler) {
        this.mImpl = VERSION.SDK_INT > 17 ? new GestureDetectorCompatImplJellybeanMr2(context, onGestureListener, handler) : new GestureDetectorCompatImplBase(context, onGestureListener, handler);
    }

    public boolean isLongpressEnabled() {
        return this.mImpl.isLongpressEnabled();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mImpl.onTouchEvent(motionEvent);
    }

    public void setIsLongpressEnabled(boolean z) {
        this.mImpl.setIsLongpressEnabled(z);
    }

    public void setOnDoubleTapListener(OnDoubleTapListener onDoubleTapListener) {
        this.mImpl.setOnDoubleTapListener(onDoubleTapListener);
    }
}
