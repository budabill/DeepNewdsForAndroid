package android.support.v7.graphics.drawable;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.util.LongSparseArray;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.appcompat.C0222R;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.Xml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p000a.p005b.p008c.p009a.C0891d;
import p000a.p005b.p008c.p009a.C0894k;

public class AnimatedStateListDrawableCompat extends StateListDrawable {
    private static final String ELEMENT_ITEM = "item";
    private static final String ELEMENT_TRANSITION = "transition";
    private static final String ITEM_MISSING_DRAWABLE_ERROR = ": <item> tag requires a 'drawable' attribute or child tag defining a drawable";
    private static final String LOGTAG = "AnimatedStateListDrawableCompat";
    private static final String TRANSITION_MISSING_DRAWABLE_ERROR = ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable";
    private static final String TRANSITION_MISSING_FROM_TO_ID = ": <transition> tag requires 'fromId' & 'toId' attributes";
    private boolean mMutated;
    private AnimatedStateListState mState;
    private Transition mTransition;
    private int mTransitionFromIndex;
    private int mTransitionToIndex;

    private static class FrameInterpolator implements TimeInterpolator {
        private int[] mFrameTimes;
        private int mFrames;
        private int mTotalDuration;

        FrameInterpolator(AnimationDrawable animationDrawable, boolean z) {
            updateFrames(animationDrawable, z);
        }

        public float getInterpolation(float f) {
            int i = (int) ((f * ((float) this.mTotalDuration)) + 0.5f);
            int i2 = this.mFrames;
            int[] iArr = this.mFrameTimes;
            int i3 = 0;
            while (i3 < i2 && i >= iArr[i3]) {
                i -= iArr[i3];
                i3++;
            }
            return (((float) i3) / ((float) i2)) + (i3 < i2 ? ((float) i) / ((float) this.mTotalDuration) : 0.0f);
        }

        int getTotalDuration() {
            return this.mTotalDuration;
        }

        int updateFrames(AnimationDrawable animationDrawable, boolean z) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.mFrames = numberOfFrames;
            int[] iArr = this.mFrameTimes;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.mFrameTimes = new int[numberOfFrames];
            }
            iArr = this.mFrameTimes;
            int i = 0;
            for (int i2 = 0; i2 < numberOfFrames; i2++) {
                int duration = animationDrawable.getDuration(z ? (numberOfFrames - i2) - 1 : i2);
                iArr[i2] = duration;
                i += duration;
            }
            this.mTotalDuration = i;
            return i;
        }
    }

    private static abstract class Transition {
        private Transition() {
        }

        public boolean canReverse() {
            return false;
        }

        public void reverse() {
        }

        public abstract void start();

        public abstract void stop();
    }

    private static class AnimatableTransition extends Transition {
        private final Animatable mA;

        AnimatableTransition(Animatable animatable) {
            super();
            this.mA = animatable;
        }

        public void start() {
            this.mA.start();
        }

        public void stop() {
            this.mA.stop();
        }
    }

    private static class AnimatedVectorDrawableTransition extends Transition {
        private final C0891d mAvd;

        AnimatedVectorDrawableTransition(C0891d c0891d) {
            super();
            this.mAvd = c0891d;
        }

        public void start() {
            this.mAvd.start();
        }

        public void stop() {
            this.mAvd.stop();
        }
    }

    private static class AnimationDrawableTransition extends Transition {
        private final ObjectAnimator mAnim;
        private final boolean mHasReversibleFlag;

        AnimationDrawableTransition(AnimationDrawable animationDrawable, boolean z, boolean z2) {
            super();
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i = z ? numberOfFrames - 1 : 0;
            numberOfFrames = z ? 0 : numberOfFrames - 1;
            TimeInterpolator frameInterpolator = new FrameInterpolator(animationDrawable, z);
            ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", new int[]{i, numberOfFrames});
            if (VERSION.SDK_INT >= 18) {
                ofInt.setAutoCancel(true);
            }
            ofInt.setDuration((long) frameInterpolator.getTotalDuration());
            ofInt.setInterpolator(frameInterpolator);
            this.mHasReversibleFlag = z2;
            this.mAnim = ofInt;
        }

        public boolean canReverse() {
            return this.mHasReversibleFlag;
        }

        public void reverse() {
            this.mAnim.reverse();
        }

        public void start() {
            this.mAnim.start();
        }

        public void stop() {
            this.mAnim.cancel();
        }
    }

    static class AnimatedStateListState extends StateListState {
        private static final long REVERSED_BIT = 4294967296L;
        private static final long REVERSIBLE_FLAG_BIT = 8589934592L;
        SparseArrayCompat<Integer> mStateIds;
        LongSparseArray<Long> mTransitions;

        AnimatedStateListState(AnimatedStateListState animatedStateListState, AnimatedStateListDrawableCompat animatedStateListDrawableCompat, Resources resources) {
            SparseArrayCompat sparseArrayCompat;
            super(animatedStateListState, animatedStateListDrawableCompat, resources);
            if (animatedStateListState != null) {
                this.mTransitions = animatedStateListState.mTransitions;
                sparseArrayCompat = animatedStateListState.mStateIds;
            } else {
                this.mTransitions = new LongSparseArray();
                sparseArrayCompat = new SparseArrayCompat();
            }
            this.mStateIds = sparseArrayCompat;
        }

        private static long generateTransitionKey(int i, int i2) {
            return ((long) i2) | (((long) i) << 32);
        }

        int addStateSet(int[] iArr, Drawable drawable, int i) {
            int addStateSet = super.addStateSet(iArr, drawable);
            this.mStateIds.put(addStateSet, Integer.valueOf(i));
            return addStateSet;
        }

        int addTransition(int i, int i2, Drawable drawable, boolean z) {
            int addChild = super.addChild(drawable);
            long generateTransitionKey = generateTransitionKey(i, i2);
            long j = z ? REVERSIBLE_FLAG_BIT : 0;
            long j2 = (long) addChild;
            this.mTransitions.append(generateTransitionKey, Long.valueOf(j2 | j));
            if (z) {
                this.mTransitions.append(generateTransitionKey(i2, i), Long.valueOf((REVERSED_BIT | j2) | j));
            }
            return addChild;
        }

        int getKeyframeIdAt(int i) {
            return i < 0 ? 0 : ((Integer) this.mStateIds.get(i, Integer.valueOf(0))).intValue();
        }

        int indexOfKeyframe(int[] iArr) {
            int indexOfStateSet = super.indexOfStateSet(iArr);
            return indexOfStateSet >= 0 ? indexOfStateSet : super.indexOfStateSet(StateSet.WILD_CARD);
        }

        int indexOfTransition(int i, int i2) {
            return (int) ((Long) this.mTransitions.get(generateTransitionKey(i, i2), Long.valueOf(-1))).longValue();
        }

        boolean isTransitionReversed(int i, int i2) {
            return (((Long) this.mTransitions.get(generateTransitionKey(i, i2), Long.valueOf(-1))).longValue() & REVERSED_BIT) != 0;
        }

        void mutate() {
            this.mTransitions = this.mTransitions.clone();
            this.mStateIds = this.mStateIds.clone();
        }

        public Drawable newDrawable() {
            return new AnimatedStateListDrawableCompat(this, null);
        }

        public Drawable newDrawable(Resources resources) {
            return new AnimatedStateListDrawableCompat(this, resources);
        }

        boolean transitionHasReversibleFlag(int i, int i2) {
            return (((Long) this.mTransitions.get(generateTransitionKey(i, i2), Long.valueOf(-1))).longValue() & REVERSIBLE_FLAG_BIT) != 0;
        }
    }

    public AnimatedStateListDrawableCompat() {
        this(null, null);
    }

    AnimatedStateListDrawableCompat(AnimatedStateListState animatedStateListState, Resources resources) {
        super(null);
        this.mTransitionToIndex = -1;
        this.mTransitionFromIndex = -1;
        setConstantState(new AnimatedStateListState(animatedStateListState, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }

    public static AnimatedStateListDrawableCompat create(Context context, int i, Theme theme) {
        Throwable e;
        try {
            int next;
            Resources resources = context.getResources();
            XmlPullParser xml = resources.getXml(i);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            while (true) {
                next = xml.next();
                if (next == 2 || next == 1) {
                    if (next == 2) {
                        return createFromXmlInner(context, resources, xml, asAttributeSet, theme);
                    }
                    throw new XmlPullParserException("No start tag found");
                }
            }
            if (next == 2) {
                return createFromXmlInner(context, resources, xml, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (XmlPullParserException e2) {
            e = e2;
            Log.e(LOGTAG, "parser error", e);
            return null;
        } catch (IOException e3) {
            e = e3;
            Log.e(LOGTAG, "parser error", e);
            return null;
        }
    }

    public static AnimatedStateListDrawableCompat createFromXmlInner(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        String name = xmlPullParser.getName();
        if (name.equals("animated-selector")) {
            AnimatedStateListDrawableCompat animatedStateListDrawableCompat = new AnimatedStateListDrawableCompat();
            animatedStateListDrawableCompat.inflate(context, resources, xmlPullParser, attributeSet, theme);
            return animatedStateListDrawableCompat;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(xmlPullParser.getPositionDescription());
        stringBuilder.append(": invalid animated-selector tag ");
        stringBuilder.append(name);
        throw new XmlPullParserException(stringBuilder.toString());
    }

    private void inflateChildElements(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next != 1) {
                int depth2 = xmlPullParser.getDepth();
                if (depth2 < depth && next == 3) {
                    return;
                }
                if (next == 2) {
                    if (depth2 <= depth) {
                        if (xmlPullParser.getName().equals(ELEMENT_ITEM)) {
                            parseItem(context, resources, xmlPullParser, attributeSet, theme);
                        } else if (xmlPullParser.getName().equals(ELEMENT_TRANSITION)) {
                            parseTransition(context, resources, xmlPullParser, attributeSet, theme);
                        }
                    }
                }
            } else {
                return;
            }
        }
    }

    private void init() {
        onStateChange(getState());
    }

    private int parseItem(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, C0222R.styleable.AnimatedStateListDrawableItem);
        int resourceId = obtainAttributes.getResourceId(C0222R.styleable.AnimatedStateListDrawableItem_android_id, 0);
        int resourceId2 = obtainAttributes.getResourceId(C0222R.styleable.AnimatedStateListDrawableItem_android_drawable, -1);
        Drawable drawable = resourceId2 > 0 ? AppCompatResources.getDrawable(context, resourceId2) : null;
        obtainAttributes.recycle();
        int[] extractStateSet = extractStateSet(attributeSet);
        String str = ITEM_MISSING_DRAWABLE_ERROR;
        if (drawable == null) {
            int next;
            while (true) {
                next = xmlPullParser.next();
                if (next != 4) {
                    break;
                }
            }
            if (next == 2) {
                drawable = xmlPullParser.getName().equals("vector") ? C0894k.createFromXmlInner(resources, xmlPullParser, attributeSet, theme) : VERSION.SDK_INT >= 21 ? Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme) : Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(xmlPullParser.getPositionDescription());
                stringBuilder.append(str);
                throw new XmlPullParserException(stringBuilder.toString());
            }
        }
        if (drawable != null) {
            return this.mState.addStateSet(extractStateSet, drawable, resourceId);
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(xmlPullParser.getPositionDescription());
        stringBuilder.append(str);
        throw new XmlPullParserException(stringBuilder.toString());
    }

    private int parseTransition(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, C0222R.styleable.AnimatedStateListDrawableTransition);
        int resourceId = obtainAttributes.getResourceId(C0222R.styleable.AnimatedStateListDrawableTransition_android_fromId, -1);
        int resourceId2 = obtainAttributes.getResourceId(C0222R.styleable.AnimatedStateListDrawableTransition_android_toId, -1);
        int resourceId3 = obtainAttributes.getResourceId(C0222R.styleable.AnimatedStateListDrawableTransition_android_drawable, -1);
        Drawable drawable = resourceId3 > 0 ? AppCompatResources.getDrawable(context, resourceId3) : null;
        boolean z = obtainAttributes.getBoolean(C0222R.styleable.AnimatedStateListDrawableTransition_android_reversible, false);
        obtainAttributes.recycle();
        String str = TRANSITION_MISSING_DRAWABLE_ERROR;
        if (drawable == null) {
            while (true) {
                resourceId3 = xmlPullParser.next();
                if (resourceId3 != 4) {
                    break;
                }
            }
            if (resourceId3 == 2) {
                drawable = xmlPullParser.getName().equals("animated-vector") ? C0891d.m2399a(context, resources, xmlPullParser, attributeSet, theme) : VERSION.SDK_INT >= 21 ? Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme) : Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(xmlPullParser.getPositionDescription());
                stringBuilder.append(str);
                throw new XmlPullParserException(stringBuilder.toString());
            }
        }
        if (drawable == null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(xmlPullParser.getPositionDescription());
            stringBuilder.append(str);
            throw new XmlPullParserException(stringBuilder.toString());
        } else if (resourceId != -1 && resourceId2 != -1) {
            return this.mState.addTransition(resourceId, resourceId2, drawable, z);
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(xmlPullParser.getPositionDescription());
            stringBuilder.append(TRANSITION_MISSING_FROM_TO_ID);
            throw new XmlPullParserException(stringBuilder.toString());
        }
    }

    private boolean selectTransition(int i) {
        int currentIndex;
        Transition transition = this.mTransition;
        if (transition == null) {
            currentIndex = getCurrentIndex();
        } else if (i == this.mTransitionToIndex) {
            return true;
        } else {
            if (i == this.mTransitionFromIndex && transition.canReverse()) {
                transition.reverse();
                this.mTransitionToIndex = this.mTransitionFromIndex;
                this.mTransitionFromIndex = i;
                return true;
            }
            currentIndex = this.mTransitionToIndex;
            transition.stop();
        }
        this.mTransition = null;
        this.mTransitionFromIndex = -1;
        this.mTransitionToIndex = -1;
        AnimatedStateListState animatedStateListState = this.mState;
        int keyframeIdAt = animatedStateListState.getKeyframeIdAt(currentIndex);
        int keyframeIdAt2 = animatedStateListState.getKeyframeIdAt(i);
        if (keyframeIdAt2 != 0) {
            if (keyframeIdAt != 0) {
                int indexOfTransition = animatedStateListState.indexOfTransition(keyframeIdAt, keyframeIdAt2);
                if (indexOfTransition < 0) {
                    return false;
                }
                Transition animationDrawableTransition;
                boolean transitionHasReversibleFlag = animatedStateListState.transitionHasReversibleFlag(keyframeIdAt, keyframeIdAt2);
                selectDrawable(indexOfTransition);
                Drawable current = getCurrent();
                if (current instanceof AnimationDrawable) {
                    animationDrawableTransition = new AnimationDrawableTransition((AnimationDrawable) current, animatedStateListState.isTransitionReversed(keyframeIdAt, keyframeIdAt2), transitionHasReversibleFlag);
                } else if (current instanceof C0891d) {
                    animationDrawableTransition = new AnimatedVectorDrawableTransition((C0891d) current);
                } else if (current instanceof Animatable) {
                    animationDrawableTransition = new AnimatableTransition((Animatable) current);
                }
                animationDrawableTransition.start();
                this.mTransition = animationDrawableTransition;
                this.mTransitionFromIndex = currentIndex;
                this.mTransitionToIndex = i;
                return true;
            }
        }
        return false;
    }

    private void updateStateFromTypedArray(TypedArray typedArray) {
        DrawableContainerState drawableContainerState = this.mState;
        if (VERSION.SDK_INT >= 21) {
            drawableContainerState.mChangingConfigurations |= typedArray.getChangingConfigurations();
        }
        drawableContainerState.setVariablePadding(typedArray.getBoolean(C0222R.styleable.AnimatedStateListDrawableCompat_android_variablePadding, drawableContainerState.mVariablePadding));
        drawableContainerState.setConstantSize(typedArray.getBoolean(C0222R.styleable.AnimatedStateListDrawableCompat_android_constantSize, drawableContainerState.mConstantSize));
        drawableContainerState.setEnterFadeDuration(typedArray.getInt(C0222R.styleable.AnimatedStateListDrawableCompat_android_enterFadeDuration, drawableContainerState.mEnterFadeDuration));
        drawableContainerState.setExitFadeDuration(typedArray.getInt(C0222R.styleable.AnimatedStateListDrawableCompat_android_exitFadeDuration, drawableContainerState.mExitFadeDuration));
        setDither(typedArray.getBoolean(C0222R.styleable.AnimatedStateListDrawableCompat_android_dither, drawableContainerState.mDither));
    }

    public /* bridge */ /* synthetic */ void addState(int[] iArr, Drawable drawable) {
        super.addState(iArr, drawable);
    }

    public void addState(int[] iArr, Drawable drawable, int i) {
        if (drawable != null) {
            this.mState.addStateSet(iArr, drawable, i);
            onStateChange(getState());
            return;
        }
        throw new IllegalArgumentException("Drawable must not be null");
    }

    public <T extends Drawable & Animatable> void addTransition(int i, int i2, T t, boolean z) {
        if (t != null) {
            this.mState.addTransition(i, i2, t, z);
            return;
        }
        throw new IllegalArgumentException("Transition drawable must not be null");
    }

    public /* bridge */ /* synthetic */ void applyTheme(Theme theme) {
        super.applyTheme(theme);
    }

    public /* bridge */ /* synthetic */ boolean canApplyTheme() {
        return super.canApplyTheme();
    }

    void clearMutated() {
        super.clearMutated();
        this.mMutated = false;
    }

    AnimatedStateListState cloneConstantState() {
        return new AnimatedStateListState(this.mState, this, null);
    }

    public /* bridge */ /* synthetic */ void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    public /* bridge */ /* synthetic */ int getChangingConfigurations() {
        return super.getChangingConfigurations();
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public /* bridge */ /* synthetic */ void getHotspotBounds(Rect rect) {
        super.getHotspotBounds(rect);
    }

    public /* bridge */ /* synthetic */ int getIntrinsicHeight() {
        return super.getIntrinsicHeight();
    }

    public /* bridge */ /* synthetic */ int getIntrinsicWidth() {
        return super.getIntrinsicWidth();
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    public /* bridge */ /* synthetic */ void getOutline(Outline outline) {
        super.getOutline(outline);
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public void inflate(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, C0222R.styleable.AnimatedStateListDrawableCompat);
        setVisible(obtainAttributes.getBoolean(C0222R.styleable.AnimatedStateListDrawableCompat_android_visible, true), true);
        updateStateFromTypedArray(obtainAttributes);
        updateDensity(resources);
        obtainAttributes.recycle();
        inflateChildElements(context, resources, xmlPullParser, attributeSet, theme);
        init();
    }

    public /* bridge */ /* synthetic */ void invalidateDrawable(Drawable drawable) {
        super.invalidateDrawable(drawable);
    }

    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    public boolean isStateful() {
        return true;
    }

    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        Transition transition = this.mTransition;
        if (transition != null) {
            transition.stop();
            this.mTransition = null;
            selectDrawable(this.mTransitionToIndex);
            this.mTransitionToIndex = -1;
            this.mTransitionFromIndex = -1;
        }
    }

    public Drawable mutate() {
        if (!this.mMutated) {
            super.mutate();
            if (this == this) {
                this.mState.mutate();
                this.mMutated = true;
            }
        }
        return this;
    }

    public /* bridge */ /* synthetic */ boolean onLayoutDirectionChanged(int i) {
        return super.onLayoutDirectionChanged(i);
    }

    protected boolean onStateChange(int[] iArr) {
        int indexOfKeyframe = this.mState.indexOfKeyframe(iArr);
        boolean z = indexOfKeyframe != getCurrentIndex() && (selectTransition(indexOfKeyframe) || selectDrawable(indexOfKeyframe));
        Drawable current = getCurrent();
        return current != null ? z | current.setState(iArr) : z;
    }

    public /* bridge */ /* synthetic */ void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        super.scheduleDrawable(drawable, runnable, j);
    }

    public /* bridge */ /* synthetic */ void setAlpha(int i) {
        super.setAlpha(i);
    }

    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
        super.setAutoMirrored(z);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    protected void setConstantState(DrawableContainerState drawableContainerState) {
        super.setConstantState(drawableContainerState);
        if (drawableContainerState instanceof AnimatedStateListState) {
            this.mState = (AnimatedStateListState) drawableContainerState;
        }
    }

    public /* bridge */ /* synthetic */ void setDither(boolean z) {
        super.setDither(z);
    }

    public /* bridge */ /* synthetic */ void setEnterFadeDuration(int i) {
        super.setEnterFadeDuration(i);
    }

    public /* bridge */ /* synthetic */ void setExitFadeDuration(int i) {
        super.setExitFadeDuration(i);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ void setTintList(ColorStateList colorStateList) {
        super.setTintList(colorStateList);
    }

    public /* bridge */ /* synthetic */ void setTintMode(Mode mode) {
        super.setTintMode(mode);
    }

    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (this.mTransition != null && (visible || z2)) {
            if (z) {
                this.mTransition.start();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    public /* bridge */ /* synthetic */ void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        super.unscheduleDrawable(drawable, runnable);
    }
}
