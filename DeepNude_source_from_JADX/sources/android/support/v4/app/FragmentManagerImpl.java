package android.support.v4.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.arch.lifecycle.C0073s;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.app.Fragment.SavedState;
import android.support.v4.app.FragmentManager.BackStackEntry;
import android.support.v4.app.FragmentManager.FragmentLifecycleCallbacks;
import android.support.v4.app.FragmentManager.OnBackStackChangedListener;
import android.support.v4.util.ArraySet;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.LogWriter;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

final class FragmentManagerImpl extends FragmentManager implements Factory2 {
    static final Interpolator ACCELERATE_CUBIC = new AccelerateInterpolator(1.5f);
    static final Interpolator ACCELERATE_QUINT = new AccelerateInterpolator(2.5f);
    static final int ANIM_DUR = 220;
    public static final int ANIM_STYLE_CLOSE_ENTER = 3;
    public static final int ANIM_STYLE_CLOSE_EXIT = 4;
    public static final int ANIM_STYLE_FADE_ENTER = 5;
    public static final int ANIM_STYLE_FADE_EXIT = 6;
    public static final int ANIM_STYLE_OPEN_ENTER = 1;
    public static final int ANIM_STYLE_OPEN_EXIT = 2;
    static boolean DEBUG = false;
    static final Interpolator DECELERATE_CUBIC = new DecelerateInterpolator(1.5f);
    static final Interpolator DECELERATE_QUINT = new DecelerateInterpolator(2.5f);
    static final String TAG = "FragmentManager";
    static final String TARGET_REQUEST_CODE_STATE_TAG = "android:target_req_state";
    static final String TARGET_STATE_TAG = "android:target_state";
    static final String USER_VISIBLE_HINT_TAG = "android:user_visible_hint";
    static final String VIEW_STATE_TAG = "android:view_state";
    static Field sAnimationListenerField;
    SparseArray<Fragment> mActive;
    final ArrayList<Fragment> mAdded = new ArrayList();
    ArrayList<Integer> mAvailBackStackIndices;
    ArrayList<BackStackRecord> mBackStack;
    ArrayList<OnBackStackChangedListener> mBackStackChangeListeners;
    ArrayList<BackStackRecord> mBackStackIndices;
    FragmentContainer mContainer;
    ArrayList<Fragment> mCreatedMenus;
    int mCurState = 0;
    boolean mDestroyed;
    Runnable mExecCommit = new C00811();
    boolean mExecutingActions;
    boolean mHavePendingDeferredStart;
    FragmentHostCallback mHost;
    private final CopyOnWriteArrayList<FragmentLifecycleCallbacksHolder> mLifecycleCallbacks = new CopyOnWriteArrayList();
    boolean mNeedMenuInvalidate;
    int mNextFragmentIndex = 0;
    String mNoTransactionsBecause;
    Fragment mParent;
    ArrayList<OpGenerator> mPendingActions;
    ArrayList<StartEnterTransitionListener> mPostponedTransactions;
    Fragment mPrimaryNav;
    FragmentManagerNonConfig mSavedNonConfig;
    SparseArray<Parcelable> mStateArray = null;
    Bundle mStateBundle = null;
    boolean mStateSaved;
    boolean mStopped;
    ArrayList<Fragment> mTmpAddedFragments;
    ArrayList<Boolean> mTmpIsPop;
    ArrayList<BackStackRecord> mTmpRecords;

    /* renamed from: android.support.v4.app.FragmentManagerImpl$1 */
    class C00811 implements Runnable {
        C00811() {
        }

        public void run() {
            FragmentManagerImpl.this.execPendingActions();
        }
    }

    private static class AnimationListenerWrapper implements AnimationListener {
        private final AnimationListener mWrapped;

        AnimationListenerWrapper(AnimationListener animationListener) {
            this.mWrapped = animationListener;
        }

        public void onAnimationEnd(Animation animation) {
            AnimationListener animationListener = this.mWrapped;
            if (animationListener != null) {
                animationListener.onAnimationEnd(animation);
            }
        }

        public void onAnimationRepeat(Animation animation) {
            AnimationListener animationListener = this.mWrapped;
            if (animationListener != null) {
                animationListener.onAnimationRepeat(animation);
            }
        }

        public void onAnimationStart(Animation animation) {
            AnimationListener animationListener = this.mWrapped;
            if (animationListener != null) {
                animationListener.onAnimationStart(animation);
            }
        }
    }

    private static class AnimationOrAnimator {
        public final Animation animation;
        public final Animator animator;

        AnimationOrAnimator(Animator animator) {
            this.animation = null;
            this.animator = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }

        AnimationOrAnimator(Animation animation) {
            this.animation = animation;
            this.animator = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }
    }

    private static class AnimatorOnHWLayerIfNeededListener extends AnimatorListenerAdapter {
        View mView;

        AnimatorOnHWLayerIfNeededListener(View view) {
            this.mView = view;
        }

        public void onAnimationEnd(Animator animator) {
            this.mView.setLayerType(0, null);
            animator.removeListener(this);
        }

        public void onAnimationStart(Animator animator) {
            this.mView.setLayerType(2, null);
        }
    }

    private static class EndViewTransitionAnimator extends AnimationSet implements Runnable {
        private boolean mAnimating = true;
        private final View mChild;
        private boolean mEnded;
        private final ViewGroup mParent;
        private boolean mTransitionEnded;

        EndViewTransitionAnimator(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.mParent = viewGroup;
            this.mChild = view;
            addAnimation(animation);
            this.mParent.post(this);
        }

        public boolean getTransformation(long j, Transformation transformation) {
            this.mAnimating = true;
            if (this.mEnded) {
                return this.mTransitionEnded ^ true;
            }
            if (!super.getTransformation(j, transformation)) {
                this.mEnded = true;
                OneShotPreDrawListener.add(this.mParent, this);
            }
            return true;
        }

        public boolean getTransformation(long j, Transformation transformation, float f) {
            this.mAnimating = true;
            if (this.mEnded) {
                return this.mTransitionEnded ^ true;
            }
            if (!super.getTransformation(j, transformation, f)) {
                this.mEnded = true;
                OneShotPreDrawListener.add(this.mParent, this);
            }
            return true;
        }

        public void run() {
            if (this.mEnded || !this.mAnimating) {
                this.mParent.endViewTransition(this.mChild);
                this.mTransitionEnded = true;
                return;
            }
            this.mAnimating = false;
            this.mParent.post(this);
        }
    }

    private static final class FragmentLifecycleCallbacksHolder {
        final FragmentLifecycleCallbacks mCallback;
        final boolean mRecursive;

        FragmentLifecycleCallbacksHolder(FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean z) {
            this.mCallback = fragmentLifecycleCallbacks;
            this.mRecursive = z;
        }
    }

    static class FragmentTag {
        public static final int[] Fragment = new int[]{16842755, 16842960, 16842961};
        public static final int Fragment_id = 1;
        public static final int Fragment_name = 0;
        public static final int Fragment_tag = 2;

        private FragmentTag() {
        }
    }

    interface OpGenerator {
        boolean generateOps(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2);
    }

    private static class AnimateOnHWLayerIfNeededListener extends AnimationListenerWrapper {
        View mView;

        /* renamed from: android.support.v4.app.FragmentManagerImpl$AnimateOnHWLayerIfNeededListener$1 */
        class C00851 implements Runnable {
            C00851() {
            }

            public void run() {
                AnimateOnHWLayerIfNeededListener.this.mView.setLayerType(0, null);
            }
        }

        AnimateOnHWLayerIfNeededListener(View view, AnimationListener animationListener) {
            super(animationListener);
            this.mView = view;
        }

        public void onAnimationEnd(Animation animation) {
            if (!ViewCompat.isAttachedToWindow(this.mView)) {
                if (VERSION.SDK_INT < 24) {
                    this.mView.setLayerType(0, null);
                    super.onAnimationEnd(animation);
                }
            }
            this.mView.post(new C00851());
            super.onAnimationEnd(animation);
        }
    }

    private class PopBackStackState implements OpGenerator {
        final int mFlags;
        final int mId;
        final String mName;

        PopBackStackState(String str, int i, int i2) {
            this.mName = str;
            this.mId = i;
            this.mFlags = i2;
        }

        public boolean generateOps(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
            Fragment fragment = FragmentManagerImpl.this.mPrimaryNav;
            if (fragment != null && this.mId < 0 && this.mName == null) {
                FragmentManager peekChildFragmentManager = fragment.peekChildFragmentManager();
                if (peekChildFragmentManager != null && peekChildFragmentManager.popBackStackImmediate()) {
                    return false;
                }
            }
            return FragmentManagerImpl.this.popBackStackState(arrayList, arrayList2, this.mName, this.mId, this.mFlags);
        }
    }

    static class StartEnterTransitionListener implements OnStartEnterTransitionListener {
        final boolean mIsBack;
        private int mNumPostponed;
        final BackStackRecord mRecord;

        StartEnterTransitionListener(BackStackRecord backStackRecord, boolean z) {
            this.mIsBack = z;
            this.mRecord = backStackRecord;
        }

        public void cancelTransaction() {
            BackStackRecord backStackRecord = this.mRecord;
            backStackRecord.mManager.completeExecute(backStackRecord, this.mIsBack, false, false);
        }

        public void completeTransaction() {
            int i = this.mNumPostponed > 0 ? 1 : 0;
            FragmentManagerImpl fragmentManagerImpl = this.mRecord.mManager;
            int size = fragmentManagerImpl.mAdded.size();
            for (int i2 = 0; i2 < size; i2++) {
                Fragment fragment = (Fragment) fragmentManagerImpl.mAdded.get(i2);
                fragment.setOnStartEnterTransitionListener(null);
                if (i != 0 && fragment.isPostponed()) {
                    fragment.startPostponedEnterTransition();
                }
            }
            BackStackRecord backStackRecord = this.mRecord;
            backStackRecord.mManager.completeExecute(backStackRecord, this.mIsBack, i ^ true, true);
        }

        public boolean isReady() {
            return this.mNumPostponed == 0;
        }

        public void onStartEnterTransition() {
            this.mNumPostponed--;
            if (this.mNumPostponed == 0) {
                this.mRecord.mManager.scheduleCommit();
            }
        }

        public void startListening() {
            this.mNumPostponed++;
        }
    }

    FragmentManagerImpl() {
    }

    private void addAddedFragments(ArraySet<Fragment> arraySet) {
        int i = this.mCurState;
        if (i >= 1) {
            i = Math.min(i, 3);
            int size = this.mAdded.size();
            for (int i2 = 0; i2 < size; i2++) {
                Fragment fragment = (Fragment) this.mAdded.get(i2);
                if (fragment.mState < i) {
                    moveToState(fragment, i, fragment.getNextAnim(), fragment.getNextTransition(), false);
                    if (!(fragment.mView == null || fragment.mHidden || !fragment.mIsNewlyAdded)) {
                        arraySet.add(fragment);
                    }
                }
            }
        }
    }

    private void animateRemoveFragment(final Fragment fragment, AnimationOrAnimator animationOrAnimator, int i) {
        final View view = fragment.mView;
        final ViewGroup viewGroup = fragment.mContainer;
        viewGroup.startViewTransition(view);
        fragment.setStateAfterAnimating(i);
        Animation animation = animationOrAnimator.animation;
        if (animation != null) {
            Animation endViewTransitionAnimator = new EndViewTransitionAnimator(animation, viewGroup, view);
            fragment.setAnimatingAway(fragment.mView);
            endViewTransitionAnimator.setAnimationListener(new AnimationListenerWrapper(getAnimationListener(endViewTransitionAnimator)) {

                /* renamed from: android.support.v4.app.FragmentManagerImpl$2$1 */
                class C00821 implements Runnable {
                    C00821() {
                    }

                    public void run() {
                        if (fragment.getAnimatingAway() != null) {
                            fragment.setAnimatingAway(null);
                            C07532 c07532 = C07532.this;
                            FragmentManagerImpl fragmentManagerImpl = FragmentManagerImpl.this;
                            Fragment fragment = fragment;
                            fragmentManagerImpl.moveToState(fragment, fragment.getStateAfterAnimating(), 0, 0, false);
                        }
                    }
                }

                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    viewGroup.post(new C00821());
                }
            });
            setHWLayerAnimListenerIfAlpha(view, animationOrAnimator);
            fragment.mView.startAnimation(endViewTransitionAnimator);
            return;
        }
        Animator animator = animationOrAnimator.animator;
        fragment.setAnimator(animator);
        animator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                viewGroup.endViewTransition(view);
                animator = fragment.getAnimator();
                fragment.setAnimator(null);
                if (animator != null && viewGroup.indexOfChild(view) < 0) {
                    FragmentManagerImpl fragmentManagerImpl = FragmentManagerImpl.this;
                    Fragment fragment = fragment;
                    fragmentManagerImpl.moveToState(fragment, fragment.getStateAfterAnimating(), 0, 0, false);
                }
            }
        });
        animator.setTarget(fragment.mView);
        setHWLayerAnimListenerIfAlpha(fragment.mView, animationOrAnimator);
        animator.start();
    }

    private void burpActive() {
        SparseArray sparseArray = this.mActive;
        if (sparseArray != null) {
            for (int size = sparseArray.size() - 1; size >= 0; size--) {
                if (this.mActive.valueAt(size) == null) {
                    SparseArray sparseArray2 = this.mActive;
                    sparseArray2.delete(sparseArray2.keyAt(size));
                }
            }
        }
    }

    private void checkStateLoss() {
        if (isStateSaved()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        } else if (this.mNoTransactionsBecause != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Can not perform this action inside of ");
            stringBuilder.append(this.mNoTransactionsBecause);
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    private void cleanupExec() {
        this.mExecutingActions = false;
        this.mTmpIsPop.clear();
        this.mTmpRecords.clear();
    }

    private void dispatchStateChange(int i) {
        try {
            this.mExecutingActions = true;
            moveToState(i, false);
            execPendingActions();
        } finally {
            this.mExecutingActions = false;
        }
    }

    private void endAnimatingAwayFragments() {
        SparseArray sparseArray = this.mActive;
        int i = 0;
        int size = sparseArray == null ? 0 : sparseArray.size();
        while (i < size) {
            Fragment fragment = (Fragment) this.mActive.valueAt(i);
            if (fragment != null) {
                if (fragment.getAnimatingAway() != null) {
                    int stateAfterAnimating = fragment.getStateAfterAnimating();
                    View animatingAway = fragment.getAnimatingAway();
                    Animation animation = animatingAway.getAnimation();
                    if (animation != null) {
                        animation.cancel();
                        animatingAway.clearAnimation();
                    }
                    fragment.setAnimatingAway(null);
                    moveToState(fragment, stateAfterAnimating, 0, 0, false);
                } else if (fragment.getAnimator() != null) {
                    fragment.getAnimator().end();
                }
            }
            i++;
        }
    }

    private void ensureExecReady(boolean z) {
        if (this.mExecutingActions) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (this.mHost == null) {
            throw new IllegalStateException("Fragment host has been destroyed");
        } else if (Looper.myLooper() == this.mHost.getHandler().getLooper()) {
            if (!z) {
                checkStateLoss();
            }
            if (this.mTmpRecords == null) {
                this.mTmpRecords = new ArrayList();
                this.mTmpIsPop = new ArrayList();
            }
            this.mExecutingActions = true;
            try {
                executePostponedTransaction(null, null);
            } finally {
                this.mExecutingActions = false;
            }
        } else {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
    }

    private static void executeOps(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        while (i < i2) {
            BackStackRecord backStackRecord = (BackStackRecord) arrayList.get(i);
            boolean z = true;
            if (((Boolean) arrayList2.get(i)).booleanValue()) {
                backStackRecord.bumpBackStackNesting(-1);
                if (i != i2 - 1) {
                    z = false;
                }
                backStackRecord.executePopOps(z);
            } else {
                backStackRecord.bumpBackStackNesting(1);
                backStackRecord.executeOps();
            }
            i++;
        }
    }

    private void executeOpsTogether(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        int i3;
        int i4;
        ArrayList<BackStackRecord> arrayList3 = arrayList;
        ArrayList<Boolean> arrayList4 = arrayList2;
        int i5 = i;
        int i6 = i2;
        boolean z = ((BackStackRecord) arrayList3.get(i5)).mReorderingAllowed;
        ArrayList arrayList5 = this.mTmpAddedFragments;
        if (arrayList5 == null) {
            r6.mTmpAddedFragments = new ArrayList();
        } else {
            arrayList5.clear();
        }
        r6.mTmpAddedFragments.addAll(r6.mAdded);
        Fragment primaryNavigationFragment = getPrimaryNavigationFragment();
        Object obj = null;
        for (i3 = i5; i3 < i6; i3++) {
            BackStackRecord backStackRecord = (BackStackRecord) arrayList3.get(i3);
            primaryNavigationFragment = !((Boolean) arrayList4.get(i3)).booleanValue() ? backStackRecord.expandOps(r6.mTmpAddedFragments, primaryNavigationFragment) : backStackRecord.trackAddedFragmentsInPop(r6.mTmpAddedFragments, primaryNavigationFragment);
            if (obj == null) {
                if (!backStackRecord.mAddToBackStack) {
                    obj = null;
                }
            }
            obj = 1;
        }
        r6.mTmpAddedFragments.clear();
        if (!z) {
            FragmentTransition.startTransitions(this, arrayList, arrayList2, i, i2, false);
        }
        executeOps(arrayList, arrayList2, i, i2);
        if (z) {
            ArraySet arraySet = new ArraySet();
            addAddedFragments(arraySet);
            i3 = postponePostponableTransactions(arrayList, arrayList2, i, i2, arraySet);
            makeRemovedFragmentsInvisible(arraySet);
            i4 = i3;
        } else {
            i4 = i6;
        }
        if (i4 != i5 && z) {
            FragmentTransition.startTransitions(this, arrayList, arrayList2, i, i4, true);
            moveToState(r6.mCurState, true);
        }
        while (i5 < i6) {
            BackStackRecord backStackRecord2 = (BackStackRecord) arrayList3.get(i5);
            if (((Boolean) arrayList4.get(i5)).booleanValue()) {
                int i7 = backStackRecord2.mIndex;
                if (i7 >= 0) {
                    freeBackStackIndex(i7);
                    backStackRecord2.mIndex = -1;
                }
            }
            backStackRecord2.runOnCommitRunnables();
            i5++;
        }
        if (obj != null) {
            reportBackStackChanged();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void executePostponedTransaction(java.util.ArrayList<android.support.v4.app.BackStackRecord> r8, java.util.ArrayList<java.lang.Boolean> r9) {
        /*
        r7 = this;
        r0 = r7.mPostponedTransactions;
        r1 = 0;
        if (r0 != 0) goto L_0x0007;
    L_0x0005:
        r0 = 0;
        goto L_0x000b;
    L_0x0007:
        r0 = r0.size();
    L_0x000b:
        r2 = r0;
        r0 = 0;
    L_0x000d:
        if (r0 >= r2) goto L_0x0074;
    L_0x000f:
        r3 = r7.mPostponedTransactions;
        r3 = r3.get(r0);
        r3 = (android.support.v4.app.FragmentManagerImpl.StartEnterTransitionListener) r3;
        r4 = -1;
        if (r8 == 0) goto L_0x0036;
    L_0x001a:
        r5 = r3.mIsBack;
        if (r5 != 0) goto L_0x0036;
    L_0x001e:
        r5 = r3.mRecord;
        r5 = r8.indexOf(r5);
        if (r5 == r4) goto L_0x0036;
    L_0x0026:
        r5 = r9.get(r5);
        r5 = (java.lang.Boolean) r5;
        r5 = r5.booleanValue();
        if (r5 == 0) goto L_0x0036;
    L_0x0032:
        r3.cancelTransaction();
        goto L_0x0071;
    L_0x0036:
        r5 = r3.isReady();
        if (r5 != 0) goto L_0x004a;
    L_0x003c:
        if (r8 == 0) goto L_0x0071;
    L_0x003e:
        r5 = r3.mRecord;
        r6 = r8.size();
        r5 = r5.interactsWith(r8, r1, r6);
        if (r5 == 0) goto L_0x0071;
    L_0x004a:
        r5 = r7.mPostponedTransactions;
        r5.remove(r0);
        r0 = r0 + -1;
        r2 = r2 + -1;
        if (r8 == 0) goto L_0x006e;
    L_0x0055:
        r5 = r3.mIsBack;
        if (r5 != 0) goto L_0x006e;
    L_0x0059:
        r5 = r3.mRecord;
        r5 = r8.indexOf(r5);
        if (r5 == r4) goto L_0x006e;
    L_0x0061:
        r4 = r9.get(r5);
        r4 = (java.lang.Boolean) r4;
        r4 = r4.booleanValue();
        if (r4 == 0) goto L_0x006e;
    L_0x006d:
        goto L_0x0032;
    L_0x006e:
        r3.completeTransaction();
    L_0x0071:
        r0 = r0 + 1;
        goto L_0x000d;
    L_0x0074:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.FragmentManagerImpl.executePostponedTransaction(java.util.ArrayList, java.util.ArrayList):void");
    }

    private Fragment findFragmentUnder(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        View view = fragment.mView;
        if (viewGroup != null) {
            if (view != null) {
                for (int indexOf = this.mAdded.indexOf(fragment) - 1; indexOf >= 0; indexOf--) {
                    Fragment fragment2 = (Fragment) this.mAdded.get(indexOf);
                    if (fragment2.mContainer == viewGroup && fragment2.mView != null) {
                        return fragment2;
                    }
                }
            }
        }
        return null;
    }

    private void forcePostponedTransactions() {
        if (this.mPostponedTransactions != null) {
            while (!this.mPostponedTransactions.isEmpty()) {
                ((StartEnterTransitionListener) this.mPostponedTransactions.remove(0)).completeTransaction();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean generateOpsForPendingActions(java.util.ArrayList<android.support.v4.app.BackStackRecord> r5, java.util.ArrayList<java.lang.Boolean> r6) {
        /*
        r4 = this;
        monitor-enter(r4);
        r0 = r4.mPendingActions;	 Catch:{ all -> 0x003c }
        r1 = 0;
        if (r0 == 0) goto L_0x003a;
    L_0x0006:
        r0 = r4.mPendingActions;	 Catch:{ all -> 0x003c }
        r0 = r0.size();	 Catch:{ all -> 0x003c }
        if (r0 != 0) goto L_0x000f;
    L_0x000e:
        goto L_0x003a;
    L_0x000f:
        r0 = r4.mPendingActions;	 Catch:{ all -> 0x003c }
        r0 = r0.size();	 Catch:{ all -> 0x003c }
        r2 = 0;
    L_0x0016:
        if (r1 >= r0) goto L_0x0028;
    L_0x0018:
        r3 = r4.mPendingActions;	 Catch:{ all -> 0x003c }
        r3 = r3.get(r1);	 Catch:{ all -> 0x003c }
        r3 = (android.support.v4.app.FragmentManagerImpl.OpGenerator) r3;	 Catch:{ all -> 0x003c }
        r3 = r3.generateOps(r5, r6);	 Catch:{ all -> 0x003c }
        r2 = r2 | r3;
        r1 = r1 + 1;
        goto L_0x0016;
    L_0x0028:
        r5 = r4.mPendingActions;	 Catch:{ all -> 0x003c }
        r5.clear();	 Catch:{ all -> 0x003c }
        r5 = r4.mHost;	 Catch:{ all -> 0x003c }
        r5 = r5.getHandler();	 Catch:{ all -> 0x003c }
        r6 = r4.mExecCommit;	 Catch:{ all -> 0x003c }
        r5.removeCallbacks(r6);	 Catch:{ all -> 0x003c }
        monitor-exit(r4);	 Catch:{ all -> 0x003c }
        return r2;
    L_0x003a:
        monitor-exit(r4);	 Catch:{ all -> 0x003c }
        return r1;
    L_0x003c:
        r5 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x003c }
        goto L_0x0040;
    L_0x003f:
        throw r5;
    L_0x0040:
        goto L_0x003f;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.FragmentManagerImpl.generateOpsForPendingActions(java.util.ArrayList, java.util.ArrayList):boolean");
    }

    private static AnimationListener getAnimationListener(Animation animation) {
        Throwable e;
        String str;
        try {
            if (sAnimationListenerField == null) {
                sAnimationListenerField = Animation.class.getDeclaredField("mListener");
                sAnimationListenerField.setAccessible(true);
            }
            return (AnimationListener) sAnimationListenerField.get(animation);
        } catch (NoSuchFieldException e2) {
            e = e2;
            str = "No field with the name mListener is found in Animation class";
            Log.e(TAG, str, e);
            return null;
        } catch (IllegalAccessException e3) {
            e = e3;
            str = "Cannot access Animation's mListener field";
            Log.e(TAG, str, e);
            return null;
        }
    }

    static AnimationOrAnimator makeFadeAnimation(Context context, float f, float f2) {
        Animation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(DECELERATE_CUBIC);
        alphaAnimation.setDuration(220);
        return new AnimationOrAnimator(alphaAnimation);
    }

    static AnimationOrAnimator makeOpenCloseAnimation(Context context, float f, float f2, float f3, float f4) {
        Animation animationSet = new AnimationSet(false);
        Animation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(DECELERATE_QUINT);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        Animation alphaAnimation = new AlphaAnimation(f3, f4);
        alphaAnimation.setInterpolator(DECELERATE_CUBIC);
        alphaAnimation.setDuration(220);
        animationSet.addAnimation(alphaAnimation);
        return new AnimationOrAnimator(animationSet);
    }

    private void makeRemovedFragmentsInvisible(ArraySet<Fragment> arraySet) {
        int size = arraySet.size();
        for (int i = 0; i < size; i++) {
            Fragment fragment = (Fragment) arraySet.valueAt(i);
            if (!fragment.mAdded) {
                View view = fragment.getView();
                fragment.mPostponedAlpha = view.getAlpha();
                view.setAlpha(0.0f);
            }
        }
    }

    static boolean modifiesAlpha(Animator animator) {
        if (animator == null) {
            return false;
        }
        int i;
        if (animator instanceof ValueAnimator) {
            PropertyValuesHolder[] values = ((ValueAnimator) animator).getValues();
            for (PropertyValuesHolder propertyName : values) {
                if ("alpha".equals(propertyName.getPropertyName())) {
                    return true;
                }
            }
        } else if (animator instanceof AnimatorSet) {
            List childAnimations = ((AnimatorSet) animator).getChildAnimations();
            for (i = 0; i < childAnimations.size(); i++) {
                if (modifiesAlpha((Animator) childAnimations.get(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean modifiesAlpha(AnimationOrAnimator animationOrAnimator) {
        Animation animation = animationOrAnimator.animation;
        if (animation instanceof AlphaAnimation) {
            return true;
        }
        if (!(animation instanceof AnimationSet)) {
            return modifiesAlpha(animationOrAnimator.animator);
        }
        List animations = ((AnimationSet) animation).getAnimations();
        for (int i = 0; i < animations.size(); i++) {
            if (animations.get(i) instanceof AlphaAnimation) {
                return true;
            }
        }
        return false;
    }

    private boolean popBackStackImmediate(String str, int i, int i2) {
        execPendingActions();
        ensureExecReady(true);
        Fragment fragment = this.mPrimaryNav;
        if (fragment != null && i < 0 && str == null) {
            FragmentManager peekChildFragmentManager = fragment.peekChildFragmentManager();
            if (peekChildFragmentManager != null && peekChildFragmentManager.popBackStackImmediate()) {
                return true;
            }
        }
        boolean popBackStackState = popBackStackState(this.mTmpRecords, this.mTmpIsPop, str, i, i2);
        if (popBackStackState) {
            this.mExecutingActions = true;
            try {
                removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
            } finally {
                cleanupExec();
            }
        }
        doPendingDeferredStart();
        burpActive();
        return popBackStackState;
    }

    private int postponePostponableTransactions(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, ArraySet<Fragment> arraySet) {
        int i3 = i2;
        for (int i4 = i2 - 1; i4 >= i; i4--) {
            BackStackRecord backStackRecord = (BackStackRecord) arrayList.get(i4);
            boolean booleanValue = ((Boolean) arrayList2.get(i4)).booleanValue();
            Object obj = (!backStackRecord.isPostponed() || backStackRecord.interactsWith(arrayList, i4 + 1, i2)) ? null : 1;
            if (obj != null) {
                if (this.mPostponedTransactions == null) {
                    this.mPostponedTransactions = new ArrayList();
                }
                OnStartEnterTransitionListener startEnterTransitionListener = new StartEnterTransitionListener(backStackRecord, booleanValue);
                this.mPostponedTransactions.add(startEnterTransitionListener);
                backStackRecord.setOnStartPostponedListener(startEnterTransitionListener);
                if (booleanValue) {
                    backStackRecord.executeOps();
                } else {
                    backStackRecord.executePopOps(false);
                }
                i3--;
                if (i4 != i3) {
                    arrayList.remove(i4);
                    arrayList.add(i3, backStackRecord);
                }
                addAddedFragments(arraySet);
            }
        }
        return i3;
    }

    private void removeRedundantOperationsAndExecute(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList != null) {
            if (!arrayList.isEmpty()) {
                if (arrayList2 == null || arrayList.size() != arrayList2.size()) {
                    throw new IllegalStateException("Internal error with the back stack records");
                }
                executePostponedTransaction(arrayList, arrayList2);
                int size = arrayList.size();
                int i = 0;
                int i2 = 0;
                while (i < size) {
                    if (!((BackStackRecord) arrayList.get(i)).mReorderingAllowed) {
                        if (i2 != i) {
                            executeOpsTogether(arrayList, arrayList2, i2, i);
                        }
                        i2 = i + 1;
                        if (((Boolean) arrayList2.get(i)).booleanValue()) {
                            while (i2 < size && ((Boolean) arrayList2.get(i2)).booleanValue() && !((BackStackRecord) arrayList.get(i2)).mReorderingAllowed) {
                                i2++;
                            }
                        }
                        executeOpsTogether(arrayList, arrayList2, i, i2);
                        i = i2 - 1;
                    }
                    i++;
                }
                if (i2 != size) {
                    executeOpsTogether(arrayList, arrayList2, i2, size);
                }
            }
        }
    }

    public static int reverseTransit(int i) {
        return i != FragmentTransaction.TRANSIT_FRAGMENT_OPEN ? i != FragmentTransaction.TRANSIT_FRAGMENT_FADE ? i != 8194 ? 0 : FragmentTransaction.TRANSIT_FRAGMENT_OPEN : FragmentTransaction.TRANSIT_FRAGMENT_FADE : 8194;
    }

    private static void setHWLayerAnimListenerIfAlpha(View view, AnimationOrAnimator animationOrAnimator) {
        if (view == null) {
            return;
        }
        if (animationOrAnimator != null) {
            if (shouldRunOnHWLayer(view, animationOrAnimator)) {
                Animator animator = animationOrAnimator.animator;
                if (animator != null) {
                    animator.addListener(new AnimatorOnHWLayerIfNeededListener(view));
                    return;
                }
                AnimationListener animationListener = getAnimationListener(animationOrAnimator.animation);
                view.setLayerType(2, null);
                animationOrAnimator.animation.setAnimationListener(new AnimateOnHWLayerIfNeededListener(view, animationListener));
            }
        }
    }

    private static void setRetaining(FragmentManagerNonConfig fragmentManagerNonConfig) {
        if (fragmentManagerNonConfig != null) {
            List<Fragment> fragments = fragmentManagerNonConfig.getFragments();
            if (fragments != null) {
                for (Fragment fragment : fragments) {
                    fragment.mRetaining = true;
                }
            }
            List<FragmentManagerNonConfig> childNonConfigs = fragmentManagerNonConfig.getChildNonConfigs();
            if (childNonConfigs != null) {
                for (FragmentManagerNonConfig retaining : childNonConfigs) {
                    setRetaining(retaining);
                }
            }
        }
    }

    static boolean shouldRunOnHWLayer(View view, AnimationOrAnimator animationOrAnimator) {
        return view != null ? animationOrAnimator == null ? false : VERSION.SDK_INT >= 19 && view.getLayerType() == 0 && ViewCompat.hasOverlappingRendering(view) && modifiesAlpha(animationOrAnimator) : false;
    }

    private void throwException(RuntimeException runtimeException) {
        String message = runtimeException.getMessage();
        String str = TAG;
        Log.e(str, message);
        Log.e(str, "Activity state:");
        PrintWriter printWriter = new PrintWriter(new LogWriter(str));
        FragmentHostCallback fragmentHostCallback = this.mHost;
        String str2 = "Failed dumping state";
        String str3 = "  ";
        if (fragmentHostCallback != null) {
            try {
                fragmentHostCallback.onDump(str3, null, printWriter, new String[0]);
            } catch (Throwable e) {
                Log.e(str, str2, e);
            }
        } else {
            dump(str3, null, printWriter, new String[0]);
        }
        throw runtimeException;
    }

    public static int transitToStyleIndex(int i, boolean z) {
        return i != FragmentTransaction.TRANSIT_FRAGMENT_OPEN ? i != FragmentTransaction.TRANSIT_FRAGMENT_FADE ? i != 8194 ? -1 : z ? 3 : 4 : z ? 5 : 6 : z ? 1 : 2;
    }

    void addBackStackState(BackStackRecord backStackRecord) {
        if (this.mBackStack == null) {
            this.mBackStack = new ArrayList();
        }
        this.mBackStack.add(backStackRecord);
    }

    public void addFragment(Fragment fragment, boolean z) {
        if (DEBUG) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("add: ");
            stringBuilder.append(fragment);
            Log.v(TAG, stringBuilder.toString());
        }
        makeActive(fragment);
        if (!fragment.mDetached) {
            if (this.mAdded.contains(fragment)) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Fragment already added: ");
                stringBuilder.append(fragment);
                throw new IllegalStateException(stringBuilder.toString());
            }
            synchronized (this.mAdded) {
                this.mAdded.add(fragment);
            }
            fragment.mAdded = true;
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (fragment.mHasMenu && fragment.mMenuVisible) {
                this.mNeedMenuInvalidate = true;
            }
            if (z) {
                moveToState(fragment);
            }
        }
    }

    public void addOnBackStackChangedListener(OnBackStackChangedListener onBackStackChangedListener) {
        if (this.mBackStackChangeListeners == null) {
            this.mBackStackChangeListeners = new ArrayList();
        }
        this.mBackStackChangeListeners.add(onBackStackChangedListener);
    }

    public int allocBackStackIndex(BackStackRecord backStackRecord) {
        synchronized (this) {
            int intValue;
            if (this.mAvailBackStackIndices != null) {
                if (this.mAvailBackStackIndices.size() > 0) {
                    intValue = ((Integer) this.mAvailBackStackIndices.remove(this.mAvailBackStackIndices.size() - 1)).intValue();
                    if (DEBUG) {
                        String str = TAG;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Adding back stack index ");
                        stringBuilder.append(intValue);
                        stringBuilder.append(" with ");
                        stringBuilder.append(backStackRecord);
                        Log.v(str, stringBuilder.toString());
                    }
                    this.mBackStackIndices.set(intValue, backStackRecord);
                    return intValue;
                }
            }
            if (this.mBackStackIndices == null) {
                this.mBackStackIndices = new ArrayList();
            }
            intValue = this.mBackStackIndices.size();
            if (DEBUG) {
                str = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("Setting back stack index ");
                stringBuilder.append(intValue);
                stringBuilder.append(" to ");
                stringBuilder.append(backStackRecord);
                Log.v(str, stringBuilder.toString());
            }
            this.mBackStackIndices.add(backStackRecord);
            return intValue;
        }
    }

    public void attachController(FragmentHostCallback fragmentHostCallback, FragmentContainer fragmentContainer, Fragment fragment) {
        if (this.mHost == null) {
            this.mHost = fragmentHostCallback;
            this.mContainer = fragmentContainer;
            this.mParent = fragment;
            return;
        }
        throw new IllegalStateException("Already attached");
    }

    public void attachFragment(Fragment fragment) {
        if (DEBUG) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("attach: ");
            stringBuilder.append(fragment);
            Log.v(TAG, stringBuilder.toString());
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (!fragment.mAdded) {
                if (this.mAdded.contains(fragment)) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("Fragment already added: ");
                    stringBuilder2.append(fragment);
                    throw new IllegalStateException(stringBuilder2.toString());
                }
                if (DEBUG) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("add from attach: ");
                    stringBuilder.append(fragment);
                    Log.v(TAG, stringBuilder.toString());
                }
                synchronized (this.mAdded) {
                    this.mAdded.add(fragment);
                }
                fragment.mAdded = true;
                if (fragment.mHasMenu && fragment.mMenuVisible) {
                    this.mNeedMenuInvalidate = true;
                }
            }
        }
    }

    public FragmentTransaction beginTransaction() {
        return new BackStackRecord(this);
    }

    void completeExecute(BackStackRecord backStackRecord, boolean z, boolean z2, boolean z3) {
        if (z) {
            backStackRecord.executePopOps(z3);
        } else {
            backStackRecord.executeOps();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(backStackRecord);
        arrayList2.add(Boolean.valueOf(z));
        if (z2) {
            FragmentTransition.startTransitions(this, arrayList, arrayList2, 0, 1, true);
        }
        if (z3) {
            moveToState(this.mCurState, true);
        }
        SparseArray sparseArray = this.mActive;
        if (sparseArray != null) {
            int size = sparseArray.size();
            for (int i = 0; i < size; i++) {
                Fragment fragment = (Fragment) this.mActive.valueAt(i);
                if (fragment != null && fragment.mView != null && fragment.mIsNewlyAdded && backStackRecord.interactsWith(fragment.mContainerId)) {
                    float f = fragment.mPostponedAlpha;
                    if (f > 0.0f) {
                        fragment.mView.setAlpha(f);
                    }
                    if (z3) {
                        fragment.mPostponedAlpha = 0.0f;
                    } else {
                        fragment.mPostponedAlpha = -1.0f;
                        fragment.mIsNewlyAdded = false;
                    }
                }
            }
        }
    }

    void completeShowHideFragment(final Fragment fragment) {
        if (fragment.mView != null) {
            AnimationOrAnimator loadAnimation = loadAnimation(fragment, fragment.getNextTransition(), fragment.mHidden ^ true, fragment.getNextTransitionStyle());
            if (loadAnimation != null) {
                Animator animator = loadAnimation.animator;
                if (animator != null) {
                    animator.setTarget(fragment.mView);
                    if (!fragment.mHidden) {
                        fragment.mView.setVisibility(0);
                    } else if (fragment.isHideReplaced()) {
                        fragment.setHideReplaced(false);
                    } else {
                        final ViewGroup viewGroup = fragment.mContainer;
                        final View view = fragment.mView;
                        viewGroup.startViewTransition(view);
                        loadAnimation.animator.addListener(new AnimatorListenerAdapter() {
                            public void onAnimationEnd(Animator animator) {
                                viewGroup.endViewTransition(view);
                                animator.removeListener(this);
                                View view = fragment.mView;
                                if (view != null) {
                                    view.setVisibility(8);
                                }
                            }
                        });
                    }
                    setHWLayerAnimListenerIfAlpha(fragment.mView, loadAnimation);
                    loadAnimation.animator.start();
                }
            }
            if (loadAnimation != null) {
                setHWLayerAnimListenerIfAlpha(fragment.mView, loadAnimation);
                fragment.mView.startAnimation(loadAnimation.animation);
                loadAnimation.animation.start();
            }
            int i = (!fragment.mHidden || fragment.isHideReplaced()) ? 0 : 8;
            fragment.mView.setVisibility(i);
            if (fragment.isHideReplaced()) {
                fragment.setHideReplaced(false);
            }
        }
        if (fragment.mAdded && fragment.mHasMenu && fragment.mMenuVisible) {
            this.mNeedMenuInvalidate = true;
        }
        fragment.mHiddenChanged = false;
        fragment.onHiddenChanged(fragment.mHidden);
    }

    public void detachFragment(Fragment fragment) {
        if (DEBUG) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("detach: ");
            stringBuilder.append(fragment);
            Log.v(TAG, stringBuilder.toString());
        }
        if (!fragment.mDetached) {
            fragment.mDetached = true;
            if (fragment.mAdded) {
                if (DEBUG) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("remove from detach: ");
                    stringBuilder2.append(fragment);
                    Log.v(TAG, stringBuilder2.toString());
                }
                synchronized (this.mAdded) {
                    this.mAdded.remove(fragment);
                }
                if (fragment.mHasMenu && fragment.mMenuVisible) {
                    this.mNeedMenuInvalidate = true;
                }
                fragment.mAdded = false;
            }
        }
    }

    public void dispatchActivityCreated() {
        this.mStateSaved = false;
        this.mStopped = false;
        dispatchStateChange(2);
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
        for (int i = 0; i < this.mAdded.size(); i++) {
            Fragment fragment = (Fragment) this.mAdded.get(i);
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
            }
        }
    }

    public boolean dispatchContextItemSelected(MenuItem menuItem) {
        if (this.mCurState < 1) {
            return false;
        }
        for (int i = 0; i < this.mAdded.size(); i++) {
            Fragment fragment = (Fragment) this.mAdded.get(i);
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void dispatchCreate() {
        this.mStateSaved = false;
        this.mStopped = false;
        dispatchStateChange(1);
    }

    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        int i = 0;
        if (this.mCurState < 1) {
            return false;
        }
        ArrayList arrayList = null;
        boolean z = false;
        for (int i2 = 0; i2 < this.mAdded.size(); i2++) {
            Fragment fragment = (Fragment) this.mAdded.get(i2);
            if (fragment != null && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(fragment);
                z = true;
            }
        }
        if (this.mCreatedMenus != null) {
            while (i < this.mCreatedMenus.size()) {
                Fragment fragment2 = (Fragment) this.mCreatedMenus.get(i);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
                i++;
            }
        }
        this.mCreatedMenus = arrayList;
        return z;
    }

    public void dispatchDestroy() {
        this.mDestroyed = true;
        execPendingActions();
        dispatchStateChange(0);
        this.mHost = null;
        this.mContainer = null;
        this.mParent = null;
    }

    public void dispatchDestroyView() {
        dispatchStateChange(1);
    }

    public void dispatchLowMemory() {
        for (int i = 0; i < this.mAdded.size(); i++) {
            Fragment fragment = (Fragment) this.mAdded.get(i);
            if (fragment != null) {
                fragment.performLowMemory();
            }
        }
    }

    public void dispatchMultiWindowModeChanged(boolean z) {
        for (int size = this.mAdded.size() - 1; size >= 0; size--) {
            Fragment fragment = (Fragment) this.mAdded.get(size);
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z);
            }
        }
    }

    void dispatchOnFragmentActivityCreated(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.mParent;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentActivityCreated(fragment, bundle, true);
            }
        }
        Iterator it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder) it.next();
            if (!z || fragmentLifecycleCallbacksHolder.mRecursive) {
                fragmentLifecycleCallbacksHolder.mCallback.onFragmentActivityCreated(this, fragment, bundle);
            }
        }
    }

    void dispatchOnFragmentAttached(Fragment fragment, Context context, boolean z) {
        Fragment fragment2 = this.mParent;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentAttached(fragment, context, true);
            }
        }
        Iterator it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder) it.next();
            if (!z || fragmentLifecycleCallbacksHolder.mRecursive) {
                fragmentLifecycleCallbacksHolder.mCallback.onFragmentAttached(this, fragment, context);
            }
        }
    }

    void dispatchOnFragmentCreated(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.mParent;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentCreated(fragment, bundle, true);
            }
        }
        Iterator it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder) it.next();
            if (!z || fragmentLifecycleCallbacksHolder.mRecursive) {
                fragmentLifecycleCallbacksHolder.mCallback.onFragmentCreated(this, fragment, bundle);
            }
        }
    }

    void dispatchOnFragmentDestroyed(Fragment fragment, boolean z) {
        Fragment fragment2 = this.mParent;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentDestroyed(fragment, true);
            }
        }
        Iterator it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder) it.next();
            if (!z || fragmentLifecycleCallbacksHolder.mRecursive) {
                fragmentLifecycleCallbacksHolder.mCallback.onFragmentDestroyed(this, fragment);
            }
        }
    }

    void dispatchOnFragmentDetached(Fragment fragment, boolean z) {
        Fragment fragment2 = this.mParent;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentDetached(fragment, true);
            }
        }
        Iterator it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder) it.next();
            if (!z || fragmentLifecycleCallbacksHolder.mRecursive) {
                fragmentLifecycleCallbacksHolder.mCallback.onFragmentDetached(this, fragment);
            }
        }
    }

    void dispatchOnFragmentPaused(Fragment fragment, boolean z) {
        Fragment fragment2 = this.mParent;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentPaused(fragment, true);
            }
        }
        Iterator it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder) it.next();
            if (!z || fragmentLifecycleCallbacksHolder.mRecursive) {
                fragmentLifecycleCallbacksHolder.mCallback.onFragmentPaused(this, fragment);
            }
        }
    }

    void dispatchOnFragmentPreAttached(Fragment fragment, Context context, boolean z) {
        Fragment fragment2 = this.mParent;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentPreAttached(fragment, context, true);
            }
        }
        Iterator it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder) it.next();
            if (!z || fragmentLifecycleCallbacksHolder.mRecursive) {
                fragmentLifecycleCallbacksHolder.mCallback.onFragmentPreAttached(this, fragment, context);
            }
        }
    }

    void dispatchOnFragmentPreCreated(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.mParent;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentPreCreated(fragment, bundle, true);
            }
        }
        Iterator it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder) it.next();
            if (!z || fragmentLifecycleCallbacksHolder.mRecursive) {
                fragmentLifecycleCallbacksHolder.mCallback.onFragmentPreCreated(this, fragment, bundle);
            }
        }
    }

    void dispatchOnFragmentResumed(Fragment fragment, boolean z) {
        Fragment fragment2 = this.mParent;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentResumed(fragment, true);
            }
        }
        Iterator it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder) it.next();
            if (!z || fragmentLifecycleCallbacksHolder.mRecursive) {
                fragmentLifecycleCallbacksHolder.mCallback.onFragmentResumed(this, fragment);
            }
        }
    }

    void dispatchOnFragmentSaveInstanceState(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.mParent;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentSaveInstanceState(fragment, bundle, true);
            }
        }
        Iterator it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder) it.next();
            if (!z || fragmentLifecycleCallbacksHolder.mRecursive) {
                fragmentLifecycleCallbacksHolder.mCallback.onFragmentSaveInstanceState(this, fragment, bundle);
            }
        }
    }

    void dispatchOnFragmentStarted(Fragment fragment, boolean z) {
        Fragment fragment2 = this.mParent;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentStarted(fragment, true);
            }
        }
        Iterator it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder) it.next();
            if (!z || fragmentLifecycleCallbacksHolder.mRecursive) {
                fragmentLifecycleCallbacksHolder.mCallback.onFragmentStarted(this, fragment);
            }
        }
    }

    void dispatchOnFragmentStopped(Fragment fragment, boolean z) {
        Fragment fragment2 = this.mParent;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentStopped(fragment, true);
            }
        }
        Iterator it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder) it.next();
            if (!z || fragmentLifecycleCallbacksHolder.mRecursive) {
                fragmentLifecycleCallbacksHolder.mCallback.onFragmentStopped(this, fragment);
            }
        }
    }

    void dispatchOnFragmentViewCreated(Fragment fragment, View view, Bundle bundle, boolean z) {
        Fragment fragment2 = this.mParent;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentViewCreated(fragment, view, bundle, true);
            }
        }
        Iterator it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder) it.next();
            if (!z || fragmentLifecycleCallbacksHolder.mRecursive) {
                fragmentLifecycleCallbacksHolder.mCallback.onFragmentViewCreated(this, fragment, view, bundle);
            }
        }
    }

    void dispatchOnFragmentViewDestroyed(Fragment fragment, boolean z) {
        Fragment fragment2 = this.mParent;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentViewDestroyed(fragment, true);
            }
        }
        Iterator it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder) it.next();
            if (!z || fragmentLifecycleCallbacksHolder.mRecursive) {
                fragmentLifecycleCallbacksHolder.mCallback.onFragmentViewDestroyed(this, fragment);
            }
        }
    }

    public boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        if (this.mCurState < 1) {
            return false;
        }
        for (int i = 0; i < this.mAdded.size(); i++) {
            Fragment fragment = (Fragment) this.mAdded.get(i);
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void dispatchOptionsMenuClosed(Menu menu) {
        if (this.mCurState >= 1) {
            for (int i = 0; i < this.mAdded.size(); i++) {
                Fragment fragment = (Fragment) this.mAdded.get(i);
                if (fragment != null) {
                    fragment.performOptionsMenuClosed(menu);
                }
            }
        }
    }

    public void dispatchPause() {
        dispatchStateChange(3);
    }

    public void dispatchPictureInPictureModeChanged(boolean z) {
        for (int size = this.mAdded.size() - 1; size >= 0; size--) {
            Fragment fragment = (Fragment) this.mAdded.get(size);
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z);
            }
        }
    }

    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        int i = 0;
        if (this.mCurState < 1) {
            return false;
        }
        boolean z = false;
        while (i < this.mAdded.size()) {
            Fragment fragment = (Fragment) this.mAdded.get(i);
            if (fragment != null && fragment.performPrepareOptionsMenu(menu)) {
                z = true;
            }
            i++;
        }
        return z;
    }

    public void dispatchResume() {
        this.mStateSaved = false;
        this.mStopped = false;
        dispatchStateChange(4);
    }

    public void dispatchStart() {
        this.mStateSaved = false;
        this.mStopped = false;
        dispatchStateChange(3);
    }

    public void dispatchStop() {
        this.mStopped = true;
        dispatchStateChange(2);
    }

    void doPendingDeferredStart() {
        if (this.mHavePendingDeferredStart) {
            this.mHavePendingDeferredStart = false;
            startPendingDeferredFragments();
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int i;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("    ");
        String stringBuilder2 = stringBuilder.toString();
        SparseArray sparseArray = this.mActive;
        if (sparseArray != null) {
            size = sparseArray.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.print("Active Fragments in ");
                printWriter.print(Integer.toHexString(System.identityHashCode(this)));
                printWriter.println(":");
                for (i = 0; i < size; i++) {
                    Fragment fragment;
                    fragment = (Fragment) this.mActive.valueAt(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment);
                    if (fragment != null) {
                        fragment.dump(stringBuilder2, fileDescriptor, printWriter, strArr);
                    }
                }
            }
        }
        size = this.mAdded.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (i = 0; i < size; i++) {
                fragment = (Fragment) this.mAdded.get(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
        ArrayList arrayList = this.mCreatedMenus;
        if (arrayList != null) {
            size = arrayList.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Fragments Created Menus:");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.mCreatedMenus.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment.toString());
                }
            }
        }
        arrayList = this.mBackStack;
        if (arrayList != null) {
            size = arrayList.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack:");
                for (i = 0; i < size; i++) {
                    BackStackRecord backStackRecord = (BackStackRecord) this.mBackStack.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(backStackRecord.toString());
                    backStackRecord.dump(stringBuilder2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        synchronized (this) {
            int size2;
            if (this.mBackStackIndices != null) {
                size2 = this.mBackStackIndices.size();
                if (size2 > 0) {
                    printWriter.print(str);
                    printWriter.println("Back Stack Indices:");
                    for (int i2 = 0; i2 < size2; i2++) {
                        BackStackRecord backStackRecord2 = (BackStackRecord) this.mBackStackIndices.get(i2);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i2);
                        printWriter.print(": ");
                        printWriter.println(backStackRecord2);
                    }
                }
            }
            if (this.mAvailBackStackIndices != null && this.mAvailBackStackIndices.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.mAvailBackStackIndices.toArray()));
            }
        }
        ArrayList arrayList2 = this.mPendingActions;
        if (arrayList2 != null) {
            size2 = arrayList2.size();
            if (size2 > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                for (int i3 = 0; i3 < size2; i3++) {
                    OpGenerator opGenerator = (OpGenerator) this.mPendingActions.get(i3);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i3);
                    printWriter.print(": ");
                    printWriter.println(opGenerator);
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.mHost);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.mContainer);
        if (this.mParent != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.mParent);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.mCurState);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.mStateSaved);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.mDestroyed);
        if (this.mNeedMenuInvalidate) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.mNeedMenuInvalidate);
        }
        if (this.mNoTransactionsBecause != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.mNoTransactionsBecause);
        }
    }

    public void enqueueAction(OpGenerator opGenerator, boolean z) {
        if (!z) {
            checkStateLoss();
        }
        synchronized (this) {
            if (!this.mDestroyed) {
                if (this.mHost != null) {
                    if (this.mPendingActions == null) {
                        this.mPendingActions = new ArrayList();
                    }
                    this.mPendingActions.add(opGenerator);
                    scheduleCommit();
                    return;
                }
            }
            if (z) {
                return;
            }
            throw new IllegalStateException("Activity has been destroyed");
        }
    }

    void ensureInflatedFragmentView(Fragment fragment) {
        if (fragment.mFromLayout && !fragment.mPerformedCreateView) {
            fragment.performCreateView(fragment.performGetLayoutInflater(fragment.mSavedFragmentState), null, fragment.mSavedFragmentState);
            View view = fragment.mView;
            if (view != null) {
                fragment.mInnerView = view;
                view.setSaveFromParentEnabled(false);
                if (fragment.mHidden) {
                    fragment.mView.setVisibility(8);
                }
                fragment.onViewCreated(fragment.mView, fragment.mSavedFragmentState);
                dispatchOnFragmentViewCreated(fragment, fragment.mView, fragment.mSavedFragmentState, false);
                return;
            }
            fragment.mInnerView = null;
        }
    }

    public boolean execPendingActions() {
        ensureExecReady(true);
        boolean z = false;
        while (generateOpsForPendingActions(this.mTmpRecords, this.mTmpIsPop)) {
            this.mExecutingActions = true;
            try {
                removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
                cleanupExec();
                z = true;
            } catch (Throwable th) {
                cleanupExec();
                throw th;
            }
        }
        doPendingDeferredStart();
        burpActive();
        return z;
    }

    public void execSingleAction(OpGenerator opGenerator, boolean z) {
        if (!z || (this.mHost != null && !this.mDestroyed)) {
            ensureExecReady(z);
            if (opGenerator.generateOps(this.mTmpRecords, this.mTmpIsPop)) {
                this.mExecutingActions = true;
                try {
                    removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
                } finally {
                    cleanupExec();
                }
            }
            doPendingDeferredStart();
            burpActive();
        }
    }

    public boolean executePendingTransactions() {
        boolean execPendingActions = execPendingActions();
        forcePostponedTransactions();
        return execPendingActions;
    }

    public Fragment findFragmentById(int i) {
        int size;
        for (size = this.mAdded.size() - 1; size >= 0; size--) {
            Fragment fragment = (Fragment) this.mAdded.get(size);
            if (fragment != null && fragment.mFragmentId == i) {
                return fragment;
            }
        }
        SparseArray sparseArray = this.mActive;
        if (sparseArray != null) {
            for (size = sparseArray.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.mActive.valueAt(size);
                if (fragment != null && fragment.mFragmentId == i) {
                    return fragment;
                }
            }
        }
        return null;
    }

    public Fragment findFragmentByTag(String str) {
        int size;
        Fragment fragment;
        if (str != null) {
            for (size = this.mAdded.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.mAdded.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        SparseArray sparseArray = this.mActive;
        if (!(sparseArray == null || str == null)) {
            for (size = sparseArray.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.mActive.valueAt(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        return null;
    }

    public Fragment findFragmentByWho(String str) {
        SparseArray sparseArray = this.mActive;
        if (!(sparseArray == null || str == null)) {
            for (int size = sparseArray.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) this.mActive.valueAt(size);
                if (fragment != null) {
                    fragment = fragment.findFragmentByWho(str);
                    if (fragment != null) {
                        return fragment;
                    }
                }
            }
        }
        return null;
    }

    public void freeBackStackIndex(int i) {
        synchronized (this) {
            this.mBackStackIndices.set(i, null);
            if (this.mAvailBackStackIndices == null) {
                this.mAvailBackStackIndices = new ArrayList();
            }
            if (DEBUG) {
                String str = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Freeing back stack index ");
                stringBuilder.append(i);
                Log.v(str, stringBuilder.toString());
            }
            this.mAvailBackStackIndices.add(Integer.valueOf(i));
        }
    }

    int getActiveFragmentCount() {
        SparseArray sparseArray = this.mActive;
        return sparseArray == null ? 0 : sparseArray.size();
    }

    List<Fragment> getActiveFragments() {
        SparseArray sparseArray = this.mActive;
        if (sparseArray == null) {
            return null;
        }
        int size = sparseArray.size();
        List arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(this.mActive.valueAt(i));
        }
        return arrayList;
    }

    public BackStackEntry getBackStackEntryAt(int i) {
        return (BackStackEntry) this.mBackStack.get(i);
    }

    public int getBackStackEntryCount() {
        ArrayList arrayList = this.mBackStack;
        return arrayList != null ? arrayList.size() : 0;
    }

    public Fragment getFragment(Bundle bundle, String str) {
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        Fragment fragment = (Fragment) this.mActive.get(i);
        if (fragment != null) {
            return fragment;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment no longer exists for key ");
        stringBuilder.append(str);
        stringBuilder.append(": index ");
        stringBuilder.append(i);
        throwException(new IllegalStateException(stringBuilder.toString()));
        throw null;
    }

    public List<Fragment> getFragments() {
        if (this.mAdded.isEmpty()) {
            return Collections.emptyList();
        }
        List<Fragment> list;
        synchronized (this.mAdded) {
            list = (List) this.mAdded.clone();
        }
        return list;
    }

    Factory2 getLayoutInflaterFactory() {
        return this;
    }

    public Fragment getPrimaryNavigationFragment() {
        return this.mPrimaryNav;
    }

    public void hideFragment(Fragment fragment) {
        if (DEBUG) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("hide: ");
            stringBuilder.append(fragment);
            Log.v(TAG, stringBuilder.toString());
        }
        if (!fragment.mHidden) {
            fragment.mHidden = true;
            fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
        }
    }

    public boolean isDestroyed() {
        return this.mDestroyed;
    }

    boolean isStateAtLeast(int i) {
        return this.mCurState >= i;
    }

    public boolean isStateSaved() {
        if (!this.mStateSaved) {
            if (!this.mStopped) {
                return false;
            }
        }
        return true;
    }

    android.support.v4.app.FragmentManagerImpl.AnimationOrAnimator loadAnimation(android.support.v4.app.Fragment r5, int r6, boolean r7, int r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        r4 = this;
        r0 = r5.getNextAnim();
        r1 = r5.onCreateAnimation(r6, r7, r0);
        if (r1 == 0) goto L_0x0010;
    L_0x000a:
        r5 = new android.support.v4.app.FragmentManagerImpl$AnimationOrAnimator;
        r5.<init>(r1);
        return r5;
    L_0x0010:
        r5 = r5.onCreateAnimator(r6, r7, r0);
        if (r5 == 0) goto L_0x001c;
    L_0x0016:
        r6 = new android.support.v4.app.FragmentManagerImpl$AnimationOrAnimator;
        r6.<init>(r5);
        return r6;
    L_0x001c:
        if (r0 == 0) goto L_0x0075;
    L_0x001e:
        r5 = r4.mHost;
        r5 = r5.getContext();
        r5 = r5.getResources();
        r5 = r5.getResourceTypeName(r0);
        r1 = "anim";
        r5 = r1.equals(r5);
        r1 = 0;
        if (r5 == 0) goto L_0x004b;
    L_0x0035:
        r2 = r4.mHost;	 Catch:{ NotFoundException -> 0x0049, RuntimeException -> 0x004b }
        r2 = r2.getContext();	 Catch:{ NotFoundException -> 0x0049, RuntimeException -> 0x004b }
        r2 = android.view.animation.AnimationUtils.loadAnimation(r2, r0);	 Catch:{ NotFoundException -> 0x0049, RuntimeException -> 0x004b }
        if (r2 == 0) goto L_0x0047;	 Catch:{ NotFoundException -> 0x0049, RuntimeException -> 0x004b }
    L_0x0041:
        r3 = new android.support.v4.app.FragmentManagerImpl$AnimationOrAnimator;	 Catch:{ NotFoundException -> 0x0049, RuntimeException -> 0x004b }
        r3.<init>(r2);	 Catch:{ NotFoundException -> 0x0049, RuntimeException -> 0x004b }
        return r3;
    L_0x0047:
        r1 = 1;
        goto L_0x004b;
    L_0x0049:
        r5 = move-exception;
        throw r5;
    L_0x004b:
        if (r1 != 0) goto L_0x0075;
    L_0x004d:
        r1 = r4.mHost;	 Catch:{ RuntimeException -> 0x005f }
        r1 = r1.getContext();	 Catch:{ RuntimeException -> 0x005f }
        r1 = android.animation.AnimatorInflater.loadAnimator(r1, r0);	 Catch:{ RuntimeException -> 0x005f }
        if (r1 == 0) goto L_0x0075;	 Catch:{ RuntimeException -> 0x005f }
    L_0x0059:
        r2 = new android.support.v4.app.FragmentManagerImpl$AnimationOrAnimator;	 Catch:{ RuntimeException -> 0x005f }
        r2.<init>(r1);	 Catch:{ RuntimeException -> 0x005f }
        return r2;
    L_0x005f:
        r1 = move-exception;
        if (r5 != 0) goto L_0x0074;
    L_0x0062:
        r5 = r4.mHost;
        r5 = r5.getContext();
        r5 = android.view.animation.AnimationUtils.loadAnimation(r5, r0);
        if (r5 == 0) goto L_0x0075;
    L_0x006e:
        r6 = new android.support.v4.app.FragmentManagerImpl$AnimationOrAnimator;
        r6.<init>(r5);
        return r6;
    L_0x0074:
        throw r1;
    L_0x0075:
        r5 = 0;
        if (r6 != 0) goto L_0x0079;
    L_0x0078:
        return r5;
    L_0x0079:
        r6 = transitToStyleIndex(r6, r7);
        if (r6 >= 0) goto L_0x0080;
    L_0x007f:
        return r5;
    L_0x0080:
        r7 = 1064933786; // 0x3f79999a float:0.975 double:5.26147199E-315;
        r0 = 0;
        r1 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        switch(r6) {
            case 1: goto L_0x00d4;
            case 2: goto L_0x00c9;
            case 3: goto L_0x00be;
            case 4: goto L_0x00b0;
            case 5: goto L_0x00a5;
            case 6: goto L_0x009a;
            default: goto L_0x0089;
        };
    L_0x0089:
        if (r8 != 0) goto L_0x00e1;
    L_0x008b:
        r6 = r4.mHost;
        r6 = r6.onHasWindowAnimations();
        if (r6 == 0) goto L_0x00e1;
    L_0x0093:
        r6 = r4.mHost;
        r8 = r6.onGetWindowAnimations();
        goto L_0x00e1;
    L_0x009a:
        r5 = r4.mHost;
        r5 = r5.getContext();
        r5 = makeFadeAnimation(r5, r1, r0);
        return r5;
    L_0x00a5:
        r5 = r4.mHost;
        r5 = r5.getContext();
        r5 = makeFadeAnimation(r5, r0, r1);
        return r5;
    L_0x00b0:
        r5 = r4.mHost;
        r5 = r5.getContext();
        r6 = 1065982362; // 0x3f89999a float:1.075 double:5.26665264E-315;
        r5 = makeOpenCloseAnimation(r5, r1, r6, r1, r0);
        return r5;
    L_0x00be:
        r5 = r4.mHost;
        r5 = r5.getContext();
        r5 = makeOpenCloseAnimation(r5, r7, r1, r0, r1);
        return r5;
    L_0x00c9:
        r5 = r4.mHost;
        r5 = r5.getContext();
        r5 = makeOpenCloseAnimation(r5, r1, r7, r1, r0);
        return r5;
    L_0x00d4:
        r5 = r4.mHost;
        r5 = r5.getContext();
        r6 = 1066401792; // 0x3f900000 float:1.125 double:5.2687249E-315;
        r5 = makeOpenCloseAnimation(r5, r6, r1, r0, r1);
        return r5;
    L_0x00e1:
        if (r8 != 0) goto L_0x00e3;
    L_0x00e3:
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.FragmentManagerImpl.loadAnimation(android.support.v4.app.Fragment, int, boolean, int):android.support.v4.app.FragmentManagerImpl$AnimationOrAnimator");
    }

    void makeActive(Fragment fragment) {
        if (fragment.mIndex < 0) {
            int i = this.mNextFragmentIndex;
            this.mNextFragmentIndex = i + 1;
            fragment.setIndex(i, this.mParent);
            if (this.mActive == null) {
                this.mActive = new SparseArray();
            }
            this.mActive.put(fragment.mIndex, fragment);
            if (DEBUG) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Allocated fragment index ");
                stringBuilder.append(fragment);
                Log.v(TAG, stringBuilder.toString());
            }
        }
    }

    void makeInactive(Fragment fragment) {
        if (fragment.mIndex >= 0) {
            if (DEBUG) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Freeing fragment index ");
                stringBuilder.append(fragment);
                Log.v(TAG, stringBuilder.toString());
            }
            this.mActive.put(fragment.mIndex, null);
            fragment.initState();
        }
    }

    void moveFragmentToExpectedState(Fragment fragment) {
        if (fragment != null) {
            int i = this.mCurState;
            if (fragment.mRemoving) {
                i = fragment.isInBackStack() ? Math.min(i, 1) : Math.min(i, 0);
            }
            moveToState(fragment, i, fragment.getNextTransition(), fragment.getNextTransitionStyle(), false);
            if (fragment.mView != null) {
                Fragment findFragmentUnder = findFragmentUnder(fragment);
                if (findFragmentUnder != null) {
                    View view = findFragmentUnder.mView;
                    ViewGroup viewGroup = fragment.mContainer;
                    i = viewGroup.indexOfChild(view);
                    int indexOfChild = viewGroup.indexOfChild(fragment.mView);
                    if (indexOfChild < i) {
                        viewGroup.removeViewAt(indexOfChild);
                        viewGroup.addView(fragment.mView, i);
                    }
                }
                if (fragment.mIsNewlyAdded && fragment.mContainer != null) {
                    float f = fragment.mPostponedAlpha;
                    if (f > 0.0f) {
                        fragment.mView.setAlpha(f);
                    }
                    fragment.mPostponedAlpha = 0.0f;
                    fragment.mIsNewlyAdded = false;
                    AnimationOrAnimator loadAnimation = loadAnimation(fragment, fragment.getNextTransition(), true, fragment.getNextTransitionStyle());
                    if (loadAnimation != null) {
                        setHWLayerAnimListenerIfAlpha(fragment.mView, loadAnimation);
                        Animation animation = loadAnimation.animation;
                        if (animation != null) {
                            fragment.mView.startAnimation(animation);
                        } else {
                            loadAnimation.animator.setTarget(fragment.mView);
                            loadAnimation.animator.start();
                        }
                    }
                }
            }
            if (fragment.mHiddenChanged) {
                completeShowHideFragment(fragment);
            }
        }
    }

    void moveToState(int i, boolean z) {
        if (this.mHost == null) {
            if (i != 0) {
                throw new IllegalStateException("No activity");
            }
        }
        if (z || i != this.mCurState) {
            this.mCurState = i;
            if (this.mActive != null) {
                int i2;
                i = this.mAdded.size();
                for (i2 = 0; i2 < i; i2++) {
                    moveFragmentToExpectedState((Fragment) this.mAdded.get(i2));
                }
                i = this.mActive.size();
                for (i2 = 0; i2 < i; i2++) {
                    Fragment fragment = (Fragment) this.mActive.valueAt(i2);
                    if (fragment != null && ((fragment.mRemoving || fragment.mDetached) && !fragment.mIsNewlyAdded)) {
                        moveFragmentToExpectedState(fragment);
                    }
                }
                startPendingDeferredFragments();
                if (this.mNeedMenuInvalidate) {
                    FragmentHostCallback fragmentHostCallback = this.mHost;
                    if (fragmentHostCallback != null && this.mCurState == 4) {
                        fragmentHostCallback.onSupportInvalidateOptionsMenu();
                        this.mNeedMenuInvalidate = false;
                    }
                }
            }
        }
    }

    void moveToState(Fragment fragment) {
        moveToState(fragment, this.mCurState, 0, 0, false);
    }

    void moveToState(android.support.v4.app.Fragment r17, int r18, int r19, int r20, boolean r21) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        r16 = this;
        r6 = r16;
        r7 = r17;
        r0 = r7.mAdded;
        r8 = 1;
        if (r0 == 0) goto L_0x0011;
    L_0x0009:
        r0 = r7.mDetached;
        if (r0 == 0) goto L_0x000e;
    L_0x000d:
        goto L_0x0011;
    L_0x000e:
        r0 = r18;
        goto L_0x0016;
    L_0x0011:
        r0 = r18;
        if (r0 <= r8) goto L_0x0016;
    L_0x0015:
        r0 = 1;
    L_0x0016:
        r1 = r7.mRemoving;
        if (r1 == 0) goto L_0x002a;
    L_0x001a:
        r1 = r7.mState;
        if (r0 <= r1) goto L_0x002a;
    L_0x001e:
        if (r1 != 0) goto L_0x0028;
    L_0x0020:
        r0 = r17.isInBackStack();
        if (r0 == 0) goto L_0x0028;
    L_0x0026:
        r0 = 1;
        goto L_0x002a;
    L_0x0028:
        r0 = r7.mState;
    L_0x002a:
        r1 = r7.mDeferStart;
        r9 = 3;
        r10 = 2;
        if (r1 == 0) goto L_0x0038;
    L_0x0030:
        r1 = r7.mState;
        if (r1 >= r9) goto L_0x0038;
    L_0x0034:
        if (r0 <= r10) goto L_0x0038;
    L_0x0036:
        r11 = 2;
        goto L_0x0039;
    L_0x0038:
        r11 = r0;
    L_0x0039:
        r0 = r7.mState;
        r12 = "FragmentManager";
        r13 = 0;
        r14 = 0;
        if (r0 > r11) goto L_0x02d8;
    L_0x0041:
        r0 = r7.mFromLayout;
        if (r0 == 0) goto L_0x004a;
    L_0x0045:
        r0 = r7.mInLayout;
        if (r0 != 0) goto L_0x004a;
    L_0x0049:
        return;
    L_0x004a:
        r0 = r17.getAnimatingAway();
        if (r0 != 0) goto L_0x0056;
    L_0x0050:
        r0 = r17.getAnimator();
        if (r0 == 0) goto L_0x006a;
    L_0x0056:
        r7.setAnimatingAway(r14);
        r7.setAnimator(r14);
        r2 = r17.getStateAfterAnimating();
        r3 = 0;
        r4 = 0;
        r5 = 1;
        r0 = r16;
        r1 = r17;
        r0.moveToState(r1, r2, r3, r4, r5);
    L_0x006a:
        r0 = r7.mState;
        if (r0 == 0) goto L_0x0076;
    L_0x006e:
        if (r0 == r8) goto L_0x01a0;
    L_0x0070:
        if (r0 == r10) goto L_0x0292;
    L_0x0072:
        if (r0 == r9) goto L_0x02b2;
    L_0x0074:
        goto L_0x041a;
    L_0x0076:
        if (r11 <= 0) goto L_0x01a0;
    L_0x0078:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x0090;
    L_0x007c:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "moveto CREATED: ";
        r0.append(r1);
        r0.append(r7);
        r0 = r0.toString();
        android.util.Log.v(r12, r0);
    L_0x0090:
        r0 = r7.mSavedFragmentState;
        if (r0 == 0) goto L_0x00e3;
    L_0x0094:
        r1 = r6.mHost;
        r1 = r1.getContext();
        r1 = r1.getClassLoader();
        r0.setClassLoader(r1);
        r0 = r7.mSavedFragmentState;
        r1 = "android:view_state";
        r0 = r0.getSparseParcelableArray(r1);
        r7.mSavedViewState = r0;
        r0 = r7.mSavedFragmentState;
        r1 = "android:target_state";
        r0 = r6.getFragment(r0, r1);
        r7.mTarget = r0;
        r0 = r7.mTarget;
        if (r0 == 0) goto L_0x00c3;
    L_0x00b9:
        r0 = r7.mSavedFragmentState;
        r1 = "android:target_req_state";
        r0 = r0.getInt(r1, r13);
        r7.mTargetRequestCode = r0;
    L_0x00c3:
        r0 = r7.mSavedUserVisibleHint;
        if (r0 == 0) goto L_0x00d0;
    L_0x00c7:
        r0 = r0.booleanValue();
        r7.mUserVisibleHint = r0;
        r7.mSavedUserVisibleHint = r14;
        goto L_0x00da;
    L_0x00d0:
        r0 = r7.mSavedFragmentState;
        r1 = "android:user_visible_hint";
        r0 = r0.getBoolean(r1, r8);
        r7.mUserVisibleHint = r0;
    L_0x00da:
        r0 = r7.mUserVisibleHint;
        if (r0 != 0) goto L_0x00e3;
    L_0x00de:
        r7.mDeferStart = r8;
        if (r11 <= r10) goto L_0x00e3;
    L_0x00e2:
        r11 = 2;
    L_0x00e3:
        r0 = r6.mHost;
        r7.mHost = r0;
        r1 = r6.mParent;
        r7.mParentFragment = r1;
        if (r1 == 0) goto L_0x00f0;
    L_0x00ed:
        r0 = r1.mChildFragmentManager;
        goto L_0x00f4;
    L_0x00f0:
        r0 = r0.getFragmentManagerImpl();
    L_0x00f4:
        r7.mFragmentManager = r0;
        r0 = r7.mTarget;
        r15 = "Fragment ";
        if (r0 == 0) goto L_0x013a;
    L_0x00fc:
        r1 = r6.mActive;
        r0 = r0.mIndex;
        r0 = r1.get(r0);
        r1 = r7.mTarget;
        if (r0 != r1) goto L_0x0116;
    L_0x0108:
        r0 = r1.mState;
        if (r0 >= r8) goto L_0x013a;
    L_0x010c:
        r2 = 1;
        r3 = 0;
        r4 = 0;
        r5 = 1;
        r0 = r16;
        r0.moveToState(r1, r2, r3, r4, r5);
        goto L_0x013a;
    L_0x0116:
        r0 = new java.lang.IllegalStateException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1.append(r15);
        r1.append(r7);
        r2 = " declared target fragment ";
        r1.append(r2);
        r2 = r7.mTarget;
        r1.append(r2);
        r2 = " that does not belong to this FragmentManager!";
        r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x013a:
        r0 = r6.mHost;
        r0 = r0.getContext();
        r6.dispatchOnFragmentPreAttached(r7, r0, r13);
        r7.mCalled = r13;
        r0 = r6.mHost;
        r0 = r0.getContext();
        r7.onAttach(r0);
        r0 = r7.mCalled;
        if (r0 == 0) goto L_0x0186;
    L_0x0152:
        r0 = r7.mParentFragment;
        if (r0 != 0) goto L_0x015c;
    L_0x0156:
        r0 = r6.mHost;
        r0.onAttachFragment(r7);
        goto L_0x015f;
    L_0x015c:
        r0.onAttachFragment(r7);
    L_0x015f:
        r0 = r6.mHost;
        r0 = r0.getContext();
        r6.dispatchOnFragmentAttached(r7, r0, r13);
        r0 = r7.mIsCreated;
        if (r0 != 0) goto L_0x017c;
    L_0x016c:
        r0 = r7.mSavedFragmentState;
        r6.dispatchOnFragmentPreCreated(r7, r0, r13);
        r0 = r7.mSavedFragmentState;
        r7.performCreate(r0);
        r0 = r7.mSavedFragmentState;
        r6.dispatchOnFragmentCreated(r7, r0, r13);
        goto L_0x0183;
    L_0x017c:
        r0 = r7.mSavedFragmentState;
        r7.restoreChildFragmentState(r0);
        r7.mState = r8;
    L_0x0183:
        r7.mRetaining = r13;
        goto L_0x01a0;
    L_0x0186:
        r0 = new android.support.v4.app.SuperNotCalledException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1.append(r15);
        r1.append(r7);
        r2 = " did not call through to super.onAttach()";
        r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x01a0:
        r16.ensureInflatedFragmentView(r17);
        if (r11 <= r8) goto L_0x0292;
    L_0x01a5:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x01bd;
    L_0x01a9:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "moveto ACTIVITY_CREATED: ";
        r0.append(r1);
        r0.append(r7);
        r0 = r0.toString();
        android.util.Log.v(r12, r0);
    L_0x01bd:
        r0 = r7.mFromLayout;
        if (r0 != 0) goto L_0x027d;
    L_0x01c1:
        r0 = r7.mContainerId;
        if (r0 == 0) goto L_0x0233;
    L_0x01c5:
        r1 = -1;
        if (r0 == r1) goto L_0x0214;
    L_0x01c8:
        r1 = r6.mContainer;
        r0 = r1.onFindViewById(r0);
        r0 = (android.view.ViewGroup) r0;
        if (r0 != 0) goto L_0x0234;
    L_0x01d2:
        r1 = r7.mRestored;
        if (r1 == 0) goto L_0x01d7;
    L_0x01d6:
        goto L_0x0234;
    L_0x01d7:
        r0 = r17.getResources();	 Catch:{ NotFoundException -> 0x01e2 }
        r1 = r7.mContainerId;	 Catch:{ NotFoundException -> 0x01e2 }
        r0 = r0.getResourceName(r1);	 Catch:{ NotFoundException -> 0x01e2 }
        goto L_0x01e4;
    L_0x01e2:
        r0 = "unknown";
    L_0x01e4:
        r1 = new java.lang.IllegalArgumentException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "No view found for id 0x";
        r2.append(r3);
        r3 = r7.mContainerId;
        r3 = java.lang.Integer.toHexString(r3);
        r2.append(r3);
        r3 = " (";
        r2.append(r3);
        r2.append(r0);
        r0 = ") for fragment ";
        r2.append(r0);
        r2.append(r7);
        r0 = r2.toString();
        r1.<init>(r0);
        r6.throwException(r1);
        throw r14;
    L_0x0214:
        r0 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Cannot create fragment ";
        r1.append(r2);
        r1.append(r7);
        r2 = " for a container view with no id";
        r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        r6.throwException(r0);
        throw r14;
    L_0x0233:
        r0 = r14;
    L_0x0234:
        r7.mContainer = r0;
        r1 = r7.mSavedFragmentState;
        r1 = r7.performGetLayoutInflater(r1);
        r2 = r7.mSavedFragmentState;
        r7.performCreateView(r1, r0, r2);
        r1 = r7.mView;
        if (r1 == 0) goto L_0x027b;
    L_0x0245:
        r7.mInnerView = r1;
        r1.setSaveFromParentEnabled(r13);
        if (r0 == 0) goto L_0x0251;
    L_0x024c:
        r1 = r7.mView;
        r0.addView(r1);
    L_0x0251:
        r0 = r7.mHidden;
        if (r0 == 0) goto L_0x025c;
    L_0x0255:
        r0 = r7.mView;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x025c:
        r0 = r7.mView;
        r1 = r7.mSavedFragmentState;
        r7.onViewCreated(r0, r1);
        r0 = r7.mView;
        r1 = r7.mSavedFragmentState;
        r6.dispatchOnFragmentViewCreated(r7, r0, r1, r13);
        r0 = r7.mView;
        r0 = r0.getVisibility();
        if (r0 != 0) goto L_0x0277;
    L_0x0272:
        r0 = r7.mContainer;
        if (r0 == 0) goto L_0x0277;
    L_0x0276:
        goto L_0x0278;
    L_0x0277:
        r8 = 0;
    L_0x0278:
        r7.mIsNewlyAdded = r8;
        goto L_0x027d;
    L_0x027b:
        r7.mInnerView = r14;
    L_0x027d:
        r0 = r7.mSavedFragmentState;
        r7.performActivityCreated(r0);
        r0 = r7.mSavedFragmentState;
        r6.dispatchOnFragmentActivityCreated(r7, r0, r13);
        r0 = r7.mView;
        if (r0 == 0) goto L_0x0290;
    L_0x028b:
        r0 = r7.mSavedFragmentState;
        r7.restoreViewState(r0);
    L_0x0290:
        r7.mSavedFragmentState = r14;
    L_0x0292:
        if (r11 <= r10) goto L_0x02b2;
    L_0x0294:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x02ac;
    L_0x0298:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "moveto STARTED: ";
        r0.append(r1);
        r0.append(r7);
        r0 = r0.toString();
        android.util.Log.v(r12, r0);
    L_0x02ac:
        r17.performStart();
        r6.dispatchOnFragmentStarted(r7, r13);
    L_0x02b2:
        if (r11 <= r9) goto L_0x041a;
    L_0x02b4:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x02cc;
    L_0x02b8:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "moveto RESUMED: ";
        r0.append(r1);
        r0.append(r7);
        r0 = r0.toString();
        android.util.Log.v(r12, r0);
    L_0x02cc:
        r17.performResume();
        r6.dispatchOnFragmentResumed(r7, r13);
        r7.mSavedFragmentState = r14;
        r7.mSavedViewState = r14;
        goto L_0x041a;
    L_0x02d8:
        if (r0 <= r11) goto L_0x041a;
    L_0x02da:
        if (r0 == r8) goto L_0x03a6;
    L_0x02dc:
        if (r0 == r10) goto L_0x0325;
    L_0x02de:
        if (r0 == r9) goto L_0x0305;
    L_0x02e0:
        r1 = 4;
        if (r0 == r1) goto L_0x02e5;
    L_0x02e3:
        goto L_0x041a;
    L_0x02e5:
        if (r11 >= r1) goto L_0x0305;
    L_0x02e7:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x02ff;
    L_0x02eb:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "movefrom RESUMED: ";
        r0.append(r1);
        r0.append(r7);
        r0 = r0.toString();
        android.util.Log.v(r12, r0);
    L_0x02ff:
        r17.performPause();
        r6.dispatchOnFragmentPaused(r7, r13);
    L_0x0305:
        if (r11 >= r9) goto L_0x0325;
    L_0x0307:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x031f;
    L_0x030b:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "movefrom STARTED: ";
        r0.append(r1);
        r0.append(r7);
        r0 = r0.toString();
        android.util.Log.v(r12, r0);
    L_0x031f:
        r17.performStop();
        r6.dispatchOnFragmentStopped(r7, r13);
    L_0x0325:
        if (r11 >= r10) goto L_0x03a6;
    L_0x0327:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x033f;
    L_0x032b:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "movefrom ACTIVITY_CREATED: ";
        r0.append(r1);
        r0.append(r7);
        r0 = r0.toString();
        android.util.Log.v(r12, r0);
    L_0x033f:
        r0 = r7.mView;
        if (r0 == 0) goto L_0x0352;
    L_0x0343:
        r0 = r6.mHost;
        r0 = r0.onShouldSaveFragmentState(r7);
        if (r0 == 0) goto L_0x0352;
    L_0x034b:
        r0 = r7.mSavedViewState;
        if (r0 != 0) goto L_0x0352;
    L_0x034f:
        r16.saveFragmentViewState(r17);
    L_0x0352:
        r17.performDestroyView();
        r6.dispatchOnFragmentViewDestroyed(r7, r13);
        r0 = r7.mView;
        if (r0 == 0) goto L_0x0397;
    L_0x035c:
        r1 = r7.mContainer;
        if (r1 == 0) goto L_0x0397;
    L_0x0360:
        r1.endViewTransition(r0);
        r0 = r7.mView;
        r0.clearAnimation();
        r0 = r6.mCurState;
        r1 = 0;
        if (r0 <= 0) goto L_0x0388;
    L_0x036d:
        r0 = r6.mDestroyed;
        if (r0 != 0) goto L_0x0388;
    L_0x0371:
        r0 = r7.mView;
        r0 = r0.getVisibility();
        if (r0 != 0) goto L_0x0388;
    L_0x0379:
        r0 = r7.mPostponedAlpha;
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 < 0) goto L_0x0388;
    L_0x037f:
        r0 = r19;
        r2 = r20;
        r0 = r6.loadAnimation(r7, r0, r13, r2);
        goto L_0x0389;
    L_0x0388:
        r0 = r14;
    L_0x0389:
        r7.mPostponedAlpha = r1;
        if (r0 == 0) goto L_0x0390;
    L_0x038d:
        r6.animateRemoveFragment(r7, r0, r11);
    L_0x0390:
        r0 = r7.mContainer;
        r1 = r7.mView;
        r0.removeView(r1);
    L_0x0397:
        r7.mContainer = r14;
        r7.mView = r14;
        r7.mViewLifecycleOwner = r14;
        r0 = r7.mViewLifecycleOwnerLiveData;
        r0.setValue(r14);
        r7.mInnerView = r14;
        r7.mInLayout = r13;
    L_0x03a6:
        if (r11 >= r8) goto L_0x041a;
    L_0x03a8:
        r0 = r6.mDestroyed;
        if (r0 == 0) goto L_0x03cd;
    L_0x03ac:
        r0 = r17.getAnimatingAway();
        if (r0 == 0) goto L_0x03bd;
    L_0x03b2:
        r0 = r17.getAnimatingAway();
        r7.setAnimatingAway(r14);
        r0.clearAnimation();
        goto L_0x03cd;
    L_0x03bd:
        r0 = r17.getAnimator();
        if (r0 == 0) goto L_0x03cd;
    L_0x03c3:
        r0 = r17.getAnimator();
        r7.setAnimator(r14);
        r0.cancel();
    L_0x03cd:
        r0 = r17.getAnimatingAway();
        if (r0 != 0) goto L_0x0416;
    L_0x03d3:
        r0 = r17.getAnimator();
        if (r0 == 0) goto L_0x03da;
    L_0x03d9:
        goto L_0x0416;
    L_0x03da:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x03f2;
    L_0x03de:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "movefrom CREATED: ";
        r0.append(r1);
        r0.append(r7);
        r0 = r0.toString();
        android.util.Log.v(r12, r0);
    L_0x03f2:
        r0 = r7.mRetaining;
        if (r0 != 0) goto L_0x03fd;
    L_0x03f6:
        r17.performDestroy();
        r6.dispatchOnFragmentDestroyed(r7, r13);
        goto L_0x03ff;
    L_0x03fd:
        r7.mState = r13;
    L_0x03ff:
        r17.performDetach();
        r6.dispatchOnFragmentDetached(r7, r13);
        if (r21 != 0) goto L_0x041a;
    L_0x0407:
        r0 = r7.mRetaining;
        if (r0 != 0) goto L_0x040f;
    L_0x040b:
        r16.makeInactive(r17);
        goto L_0x041a;
    L_0x040f:
        r7.mHost = r14;
        r7.mParentFragment = r14;
        r7.mFragmentManager = r14;
        goto L_0x041a;
    L_0x0416:
        r7.setStateAfterAnimating(r11);
        goto L_0x041b;
    L_0x041a:
        r8 = r11;
    L_0x041b:
        r0 = r7.mState;
        if (r0 == r8) goto L_0x044c;
    L_0x041f:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "moveToState: Fragment state for ";
        r0.append(r1);
        r0.append(r7);
        r1 = " not updated inline; ";
        r0.append(r1);
        r1 = "expected state ";
        r0.append(r1);
        r0.append(r8);
        r1 = " found ";
        r0.append(r1);
        r1 = r7.mState;
        r0.append(r1);
        r0 = r0.toString();
        android.util.Log.w(r12, r0);
        r7.mState = r8;
    L_0x044c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.FragmentManagerImpl.moveToState(android.support.v4.app.Fragment, int, int, int, boolean):void");
    }

    public void noteStateNotSaved() {
        this.mSavedNonConfig = null;
        int i = 0;
        this.mStateSaved = false;
        this.mStopped = false;
        int size = this.mAdded.size();
        while (i < size) {
            Fragment fragment = (Fragment) this.mAdded.get(i);
            if (fragment != null) {
                fragment.noteStateNotSaved();
            }
            i++;
        }
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        FragmentManagerImpl fragmentManagerImpl = this;
        Context context2 = context;
        AttributeSet attributeSet2 = attributeSet;
        String str2 = str;
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet2.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet2, FragmentTag.Fragment);
        int i = 0;
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(0);
        }
        String str3 = attributeValue;
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (!Fragment.isSupportFragmentClass(fragmentManagerImpl.mHost.getContext(), str3)) {
            return null;
        }
        Fragment fragment;
        if (view != null) {
            i = view.getId();
        }
        if (i == -1 && resourceId == -1) {
            if (string == null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(attributeSet.getPositionDescription());
                stringBuilder.append(": Must specify unique android:id, android:tag, or have a parent with an id for ");
                stringBuilder.append(str3);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        Fragment findFragmentById = resourceId != -1 ? findFragmentById(resourceId) : null;
        if (findFragmentById == null && string != null) {
            findFragmentById = findFragmentByTag(string);
        }
        if (findFragmentById == null && i != -1) {
            findFragmentById = findFragmentById(i);
        }
        if (DEBUG) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("onCreateView: id=0x");
            stringBuilder.append(Integer.toHexString(resourceId));
            stringBuilder.append(" fname=");
            stringBuilder.append(str3);
            stringBuilder.append(" existing=");
            stringBuilder.append(findFragmentById);
            Log.v(TAG, stringBuilder.toString());
        }
        if (findFragmentById == null) {
            Fragment instantiate = fragmentManagerImpl.mContainer.instantiate(context, str3, null);
            instantiate.mFromLayout = true;
            instantiate.mFragmentId = resourceId != 0 ? resourceId : i;
            instantiate.mContainerId = i;
            instantiate.mTag = string;
            instantiate.mInLayout = true;
            instantiate.mFragmentManager = fragmentManagerImpl;
            FragmentHostCallback fragmentHostCallback = fragmentManagerImpl.mHost;
            instantiate.mHost = fragmentHostCallback;
            instantiate.onInflate(fragmentHostCallback.getContext(), attributeSet2, instantiate.mSavedFragmentState);
            addFragment(instantiate, true);
            fragment = instantiate;
        } else if (findFragmentById.mInLayout) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(attributeSet.getPositionDescription());
            stringBuilder.append(": Duplicate id 0x");
            stringBuilder.append(Integer.toHexString(resourceId));
            stringBuilder.append(", tag ");
            stringBuilder.append(string);
            stringBuilder.append(", or parent id 0x");
            stringBuilder.append(Integer.toHexString(i));
            stringBuilder.append(" with another fragment for ");
            stringBuilder.append(str3);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else {
            findFragmentById.mInLayout = true;
            FragmentHostCallback fragmentHostCallback2 = fragmentManagerImpl.mHost;
            findFragmentById.mHost = fragmentHostCallback2;
            if (!findFragmentById.mRetaining) {
                findFragmentById.onInflate(fragmentHostCallback2.getContext(), attributeSet2, findFragmentById.mSavedFragmentState);
            }
            fragment = findFragmentById;
        }
        if (fragmentManagerImpl.mCurState >= 1 || !fragment.mFromLayout) {
            moveToState(fragment);
        } else {
            moveToState(fragment, 1, 0, 0, false);
        }
        View view2 = fragment.mView;
        if (view2 != null) {
            if (resourceId != 0) {
                view2.setId(resourceId);
            }
            if (fragment.mView.getTag() == null) {
                fragment.mView.setTag(string);
            }
            return fragment.mView;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Fragment ");
        stringBuilder2.append(str3);
        stringBuilder2.append(" did not create a view.");
        throw new IllegalStateException(stringBuilder2.toString());
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    public void performPendingDeferredStart(Fragment fragment) {
        if (fragment.mDeferStart) {
            if (this.mExecutingActions) {
                this.mHavePendingDeferredStart = true;
                return;
            }
            fragment.mDeferStart = false;
            moveToState(fragment, this.mCurState, 0, 0, false);
        }
    }

    public void popBackStack() {
        enqueueAction(new PopBackStackState(null, -1, 0), false);
    }

    public void popBackStack(int i, int i2) {
        if (i >= 0) {
            enqueueAction(new PopBackStackState(null, i, i2), false);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Bad id: ");
        stringBuilder.append(i);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public void popBackStack(String str, int i) {
        enqueueAction(new PopBackStackState(str, -1, i), false);
    }

    public boolean popBackStackImmediate() {
        checkStateLoss();
        return popBackStackImmediate(null, -1, 0);
    }

    public boolean popBackStackImmediate(int i, int i2) {
        checkStateLoss();
        execPendingActions();
        if (i >= 0) {
            return popBackStackImmediate(null, i, i2);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Bad id: ");
        stringBuilder.append(i);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public boolean popBackStackImmediate(String str, int i) {
        checkStateLoss();
        return popBackStackImmediate(str, -1, i);
    }

    boolean popBackStackState(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, String str, int i, int i2) {
        ArrayList arrayList3 = this.mBackStack;
        if (arrayList3 == null) {
            return false;
        }
        int size;
        if (str == null && i < 0 && (i2 & 1) == 0) {
            size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.mBackStack.remove(size));
            arrayList2.add(Boolean.valueOf(true));
        } else {
            int i3;
            if (str == null) {
                if (i < 0) {
                    i3 = -1;
                    if (i3 == this.mBackStack.size() - 1) {
                        return false;
                    }
                    for (size = this.mBackStack.size() - 1; size > i3; size--) {
                        arrayList.add(this.mBackStack.remove(size));
                        arrayList2.add(Boolean.valueOf(true));
                    }
                }
            }
            i3 = this.mBackStack.size() - 1;
            while (i3 >= 0) {
                BackStackRecord backStackRecord = (BackStackRecord) this.mBackStack.get(i3);
                if (str == null || !str.equals(backStackRecord.getName())) {
                    if (i >= 0 && i == backStackRecord.mIndex) {
                        break;
                    }
                    i3--;
                } else {
                    break;
                }
            }
            if (i3 < 0) {
                return false;
            }
            if ((i2 & 1) != 0) {
                while (true) {
                    i3--;
                    if (i3 < 0) {
                        break;
                    }
                    BackStackRecord backStackRecord2 = (BackStackRecord) this.mBackStack.get(i3);
                    if (str == null || !str.equals(backStackRecord2.getName())) {
                        if (i < 0 || i != backStackRecord2.mIndex) {
                            break;
                        }
                    }
                }
            }
            if (i3 == this.mBackStack.size() - 1) {
                return false;
            }
            for (size = this.mBackStack.size() - 1; size > i3; size--) {
                arrayList.add(this.mBackStack.remove(size));
                arrayList2.add(Boolean.valueOf(true));
            }
        }
        return true;
    }

    public void putFragment(Bundle bundle, String str, Fragment fragment) {
        int i = fragment.mIndex;
        if (i >= 0) {
            bundle.putInt(str, i);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment ");
        stringBuilder.append(fragment);
        stringBuilder.append(" is not currently in the FragmentManager");
        throwException(new IllegalStateException(stringBuilder.toString()));
        throw null;
    }

    public void registerFragmentLifecycleCallbacks(FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean z) {
        this.mLifecycleCallbacks.add(new FragmentLifecycleCallbacksHolder(fragmentLifecycleCallbacks, z));
    }

    public void removeFragment(Fragment fragment) {
        if (DEBUG) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("remove: ");
            stringBuilder.append(fragment);
            stringBuilder.append(" nesting=");
            stringBuilder.append(fragment.mBackStackNesting);
            Log.v(TAG, stringBuilder.toString());
        }
        int isInBackStack = fragment.isInBackStack() ^ 1;
        if (!fragment.mDetached || isInBackStack != 0) {
            synchronized (this.mAdded) {
                this.mAdded.remove(fragment);
            }
            if (fragment.mHasMenu && fragment.mMenuVisible) {
                this.mNeedMenuInvalidate = true;
            }
            fragment.mAdded = false;
            fragment.mRemoving = true;
        }
    }

    public void removeOnBackStackChangedListener(OnBackStackChangedListener onBackStackChangedListener) {
        ArrayList arrayList = this.mBackStackChangeListeners;
        if (arrayList != null) {
            arrayList.remove(onBackStackChangedListener);
        }
    }

    void reportBackStackChanged() {
        if (this.mBackStackChangeListeners != null) {
            for (int i = 0; i < this.mBackStackChangeListeners.size(); i++) {
                ((OnBackStackChangedListener) this.mBackStackChangeListeners.get(i)).onBackStackChanged();
            }
        }
    }

    void restoreAllState(Parcelable parcelable, FragmentManagerNonConfig fragmentManagerNonConfig) {
        if (parcelable != null) {
            FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
            if (fragmentManagerState.mActive != null) {
                List childNonConfigs;
                List viewModelStores;
                int size;
                int i;
                StringBuilder stringBuilder;
                if (fragmentManagerNonConfig != null) {
                    List fragments = fragmentManagerNonConfig.getFragments();
                    childNonConfigs = fragmentManagerNonConfig.getChildNonConfigs();
                    viewModelStores = fragmentManagerNonConfig.getViewModelStores();
                    size = fragments != null ? fragments.size() : 0;
                    int i2 = 0;
                    while (i2 < size) {
                        FragmentState[] fragmentStateArr;
                        Fragment fragment = (Fragment) fragments.get(i2);
                        if (DEBUG) {
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append("restoreAllState: re-attaching retained ");
                            stringBuilder2.append(fragment);
                            Log.v(TAG, stringBuilder2.toString());
                        }
                        int i3 = 0;
                        while (true) {
                            fragmentStateArr = fragmentManagerState.mActive;
                            if (i3 >= fragmentStateArr.length || fragmentStateArr[i3].mIndex == fragment.mIndex) {
                                fragmentStateArr = fragmentManagerState.mActive;
                            } else {
                                i3++;
                            }
                        }
                        fragmentStateArr = fragmentManagerState.mActive;
                        if (i3 != fragmentStateArr.length) {
                            FragmentState fragmentState = fragmentStateArr[i3];
                            fragmentState.mInstance = fragment;
                            fragment.mSavedViewState = null;
                            fragment.mBackStackNesting = 0;
                            fragment.mInLayout = false;
                            fragment.mAdded = false;
                            fragment.mTarget = null;
                            Bundle bundle = fragmentState.mSavedFragmentState;
                            if (bundle != null) {
                                bundle.setClassLoader(this.mHost.getContext().getClassLoader());
                                fragment.mSavedViewState = fragmentState.mSavedFragmentState.getSparseParcelableArray(VIEW_STATE_TAG);
                                fragment.mSavedFragmentState = fragmentState.mSavedFragmentState;
                            }
                            i2++;
                        } else {
                            StringBuilder stringBuilder3 = new StringBuilder();
                            stringBuilder3.append("Could not find active fragment with index ");
                            stringBuilder3.append(fragment.mIndex);
                            throwException(new IllegalStateException(stringBuilder3.toString()));
                            throw null;
                        }
                    }
                }
                childNonConfigs = null;
                viewModelStores = childNonConfigs;
                this.mActive = new SparseArray(fragmentManagerState.mActive.length);
                int i4 = 0;
                while (true) {
                    FragmentState[] fragmentStateArr2 = fragmentManagerState.mActive;
                    if (i4 >= fragmentStateArr2.length) {
                        break;
                    }
                    FragmentState fragmentState2 = fragmentStateArr2[i4];
                    if (fragmentState2 != null) {
                        FragmentManagerNonConfig fragmentManagerNonConfig2 = (childNonConfigs == null || i4 >= childNonConfigs.size()) ? null : (FragmentManagerNonConfig) childNonConfigs.get(i4);
                        C0073s c0073s = (viewModelStores == null || i4 >= viewModelStores.size()) ? null : (C0073s) viewModelStores.get(i4);
                        Fragment instantiate = fragmentState2.instantiate(this.mHost, this.mContainer, this.mParent, fragmentManagerNonConfig2, c0073s);
                        if (DEBUG) {
                            StringBuilder stringBuilder4 = new StringBuilder();
                            stringBuilder4.append("restoreAllState: active #");
                            stringBuilder4.append(i4);
                            stringBuilder4.append(": ");
                            stringBuilder4.append(instantiate);
                            Log.v(TAG, stringBuilder4.toString());
                        }
                        this.mActive.put(instantiate.mIndex, instantiate);
                        fragmentState2.mInstance = null;
                    }
                    i4++;
                }
                if (fragmentManagerNonConfig != null) {
                    List fragments2 = fragmentManagerNonConfig.getFragments();
                    i4 = fragments2 != null ? fragments2.size() : 0;
                    for (int i5 = 0; i5 < i4; i5++) {
                        Fragment fragment2 = (Fragment) fragments2.get(i5);
                        size = fragment2.mTargetIndex;
                        if (size >= 0) {
                            fragment2.mTarget = (Fragment) this.mActive.get(size);
                            if (fragment2.mTarget == null) {
                                StringBuilder stringBuilder5 = new StringBuilder();
                                stringBuilder5.append("Re-attaching retained fragment ");
                                stringBuilder5.append(fragment2);
                                stringBuilder5.append(" target no longer exists: ");
                                stringBuilder5.append(fragment2.mTargetIndex);
                                Log.w(TAG, stringBuilder5.toString());
                            }
                        }
                    }
                }
                this.mAdded.clear();
                if (fragmentManagerState.mAdded != null) {
                    i = 0;
                    while (true) {
                        int[] iArr = fragmentManagerState.mAdded;
                        if (i >= iArr.length) {
                            break;
                        }
                        Fragment fragment3 = (Fragment) this.mActive.get(iArr[i]);
                        if (fragment3 != null) {
                            fragment3.mAdded = true;
                            if (DEBUG) {
                                StringBuilder stringBuilder6 = new StringBuilder();
                                stringBuilder6.append("restoreAllState: added #");
                                stringBuilder6.append(i);
                                stringBuilder6.append(": ");
                                stringBuilder6.append(fragment3);
                                Log.v(TAG, stringBuilder6.toString());
                            }
                            if (this.mAdded.contains(fragment3)) {
                                throw new IllegalStateException("Already added!");
                            }
                            synchronized (this.mAdded) {
                                this.mAdded.add(fragment3);
                            }
                            i++;
                        } else {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("No instantiated fragment for index #");
                            stringBuilder.append(fragmentManagerState.mAdded[i]);
                            throwException(new IllegalStateException(stringBuilder.toString()));
                            throw null;
                        }
                    }
                }
                BackStackState[] backStackStateArr = fragmentManagerState.mBackStack;
                if (backStackStateArr != null) {
                    this.mBackStack = new ArrayList(backStackStateArr.length);
                    i = 0;
                    while (true) {
                        BackStackState[] backStackStateArr2 = fragmentManagerState.mBackStack;
                        if (i >= backStackStateArr2.length) {
                            break;
                        }
                        BackStackRecord instantiate2 = backStackStateArr2[i].instantiate(this);
                        if (DEBUG) {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("restoreAllState: back stack #");
                            stringBuilder.append(i);
                            stringBuilder.append(" (index ");
                            stringBuilder.append(instantiate2.mIndex);
                            stringBuilder.append("): ");
                            stringBuilder.append(instantiate2);
                            Log.v(TAG, stringBuilder.toString());
                            PrintWriter printWriter = new PrintWriter(new LogWriter(TAG));
                            instantiate2.dump("  ", printWriter, false);
                            printWriter.close();
                        }
                        this.mBackStack.add(instantiate2);
                        i4 = instantiate2.mIndex;
                        if (i4 >= 0) {
                            setBackStackIndex(i4, instantiate2);
                        }
                        i++;
                    }
                } else {
                    this.mBackStack = null;
                }
                i = fragmentManagerState.mPrimaryNavActiveIndex;
                if (i >= 0) {
                    this.mPrimaryNav = (Fragment) this.mActive.get(i);
                }
                this.mNextFragmentIndex = fragmentManagerState.mNextFragmentIndex;
            }
        }
    }

    FragmentManagerNonConfig retainNonConfig() {
        setRetaining(this.mSavedNonConfig);
        return this.mSavedNonConfig;
    }

    Parcelable saveAllState() {
        forcePostponedTransactions();
        endAnimatingAwayFragments();
        execPendingActions();
        this.mStateSaved = true;
        BackStackState[] backStackStateArr = null;
        this.mSavedNonConfig = null;
        SparseArray sparseArray = this.mActive;
        if (sparseArray != null) {
            if (sparseArray.size() > 0) {
                String str;
                String str2;
                String str3;
                String str4;
                int size = this.mActive.size();
                FragmentState[] fragmentStateArr = new FragmentState[size];
                int i = 0;
                Object obj = null;
                while (true) {
                    str = " has cleared index: ";
                    str2 = "Failure saving state: active ";
                    str3 = ": ";
                    str4 = TAG;
                    if (i >= size) {
                        break;
                    }
                    Fragment fragment = (Fragment) this.mActive.valueAt(i);
                    if (fragment != null) {
                        StringBuilder stringBuilder;
                        if (fragment.mIndex >= 0) {
                            FragmentState fragmentState = new FragmentState(fragment);
                            fragmentStateArr[i] = fragmentState;
                            if (fragment.mState <= 0 || fragmentState.mSavedFragmentState != null) {
                                fragmentState.mSavedFragmentState = fragment.mSavedFragmentState;
                            } else {
                                fragmentState.mSavedFragmentState = saveFragmentBasicState(fragment);
                                Fragment fragment2 = fragment.mTarget;
                                if (fragment2 != null) {
                                    if (fragment2.mIndex >= 0) {
                                        if (fragmentState.mSavedFragmentState == null) {
                                            fragmentState.mSavedFragmentState = new Bundle();
                                        }
                                        putFragment(fragmentState.mSavedFragmentState, TARGET_STATE_TAG, fragment.mTarget);
                                        int i2 = fragment.mTargetRequestCode;
                                        if (i2 != 0) {
                                            fragmentState.mSavedFragmentState.putInt(TARGET_REQUEST_CODE_STATE_TAG, i2);
                                        }
                                    } else {
                                        stringBuilder = new StringBuilder();
                                        stringBuilder.append("Failure saving state: ");
                                        stringBuilder.append(fragment);
                                        stringBuilder.append(" has target not in fragment manager: ");
                                        stringBuilder.append(fragment.mTarget);
                                        throwException(new IllegalStateException(stringBuilder.toString()));
                                        throw null;
                                    }
                                }
                            }
                            if (DEBUG) {
                                StringBuilder stringBuilder2 = new StringBuilder();
                                stringBuilder2.append("Saved state of ");
                                stringBuilder2.append(fragment);
                                stringBuilder2.append(str3);
                                stringBuilder2.append(fragmentState.mSavedFragmentState);
                                Log.v(str4, stringBuilder2.toString());
                            }
                            obj = 1;
                        } else {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(str2);
                            stringBuilder.append(fragment);
                            stringBuilder.append(str);
                            stringBuilder.append(fragment.mIndex);
                            throwException(new IllegalStateException(stringBuilder.toString()));
                            throw null;
                        }
                    }
                    i++;
                }
                if (obj == null) {
                    if (DEBUG) {
                        Log.v(str4, "saveAllState: no fragments!");
                    }
                    return null;
                }
                int[] iArr;
                int size2 = this.mAdded.size();
                if (size2 > 0) {
                    iArr = new int[size2];
                    i = 0;
                    while (i < size2) {
                        iArr[i] = ((Fragment) this.mAdded.get(i)).mIndex;
                        if (iArr[i] >= 0) {
                            if (DEBUG) {
                                StringBuilder stringBuilder3 = new StringBuilder();
                                stringBuilder3.append("saveAllState: adding fragment #");
                                stringBuilder3.append(i);
                                stringBuilder3.append(str3);
                                stringBuilder3.append(this.mAdded.get(i));
                                Log.v(str4, stringBuilder3.toString());
                            }
                            i++;
                        } else {
                            StringBuilder stringBuilder4 = new StringBuilder();
                            stringBuilder4.append(str2);
                            stringBuilder4.append(this.mAdded.get(i));
                            stringBuilder4.append(str);
                            stringBuilder4.append(iArr[i]);
                            throwException(new IllegalStateException(stringBuilder4.toString()));
                            throw null;
                        }
                    }
                }
                iArr = null;
                ArrayList arrayList = this.mBackStack;
                if (arrayList != null) {
                    size2 = arrayList.size();
                    if (size2 > 0) {
                        backStackStateArr = new BackStackState[size2];
                        for (int i3 = 0; i3 < size2; i3++) {
                            backStackStateArr[i3] = new BackStackState((BackStackRecord) this.mBackStack.get(i3));
                            if (DEBUG) {
                                StringBuilder stringBuilder5 = new StringBuilder();
                                stringBuilder5.append("saveAllState: adding back stack #");
                                stringBuilder5.append(i3);
                                stringBuilder5.append(str3);
                                stringBuilder5.append(this.mBackStack.get(i3));
                                Log.v(str4, stringBuilder5.toString());
                            }
                        }
                    }
                }
                Parcelable fragmentManagerState = new FragmentManagerState();
                fragmentManagerState.mActive = fragmentStateArr;
                fragmentManagerState.mAdded = iArr;
                fragmentManagerState.mBackStack = backStackStateArr;
                Fragment fragment3 = this.mPrimaryNav;
                if (fragment3 != null) {
                    fragmentManagerState.mPrimaryNavActiveIndex = fragment3.mIndex;
                }
                fragmentManagerState.mNextFragmentIndex = this.mNextFragmentIndex;
                saveNonConfig();
                return fragmentManagerState;
            }
        }
        return null;
    }

    Bundle saveFragmentBasicState(Fragment fragment) {
        Bundle bundle;
        if (this.mStateBundle == null) {
            this.mStateBundle = new Bundle();
        }
        fragment.performSaveInstanceState(this.mStateBundle);
        dispatchOnFragmentSaveInstanceState(fragment, this.mStateBundle, false);
        if (this.mStateBundle.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.mStateBundle;
            this.mStateBundle = null;
        }
        if (fragment.mView != null) {
            saveFragmentViewState(fragment);
        }
        if (fragment.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray(VIEW_STATE_TAG, fragment.mSavedViewState);
        }
        if (!fragment.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean(USER_VISIBLE_HINT_TAG, fragment.mUserVisibleHint);
        }
        return bundle;
    }

    public SavedState saveFragmentInstanceState(Fragment fragment) {
        if (fragment.mIndex < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Fragment ");
            stringBuilder.append(fragment);
            stringBuilder.append(" is not currently in the FragmentManager");
            throwException(new IllegalStateException(stringBuilder.toString()));
            throw null;
        } else if (fragment.mState <= 0) {
            return null;
        } else {
            Bundle saveFragmentBasicState = saveFragmentBasicState(fragment);
            return saveFragmentBasicState != null ? new SavedState(saveFragmentBasicState) : null;
        }
    }

    void saveFragmentViewState(Fragment fragment) {
        if (fragment.mInnerView != null) {
            SparseArray sparseArray = this.mStateArray;
            if (sparseArray == null) {
                this.mStateArray = new SparseArray();
            } else {
                sparseArray.clear();
            }
            fragment.mInnerView.saveHierarchyState(this.mStateArray);
            if (this.mStateArray.size() > 0) {
                fragment.mSavedViewState = this.mStateArray;
                this.mStateArray = null;
            }
        }
    }

    void saveNonConfig() {
        List list;
        List list2;
        List list3;
        if (this.mActive != null) {
            list = null;
            list2 = list;
            list3 = list2;
            for (int i = 0; i < this.mActive.size(); i++) {
                Fragment fragment = (Fragment) this.mActive.valueAt(i);
                if (fragment != null) {
                    Object obj;
                    if (fragment.mRetainInstance) {
                        if (list == null) {
                            list = new ArrayList();
                        }
                        list.add(fragment);
                        Fragment fragment2 = fragment.mTarget;
                        fragment.mTargetIndex = fragment2 != null ? fragment2.mIndex : -1;
                        if (DEBUG) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("retainNonConfig: keeping retained ");
                            stringBuilder.append(fragment);
                            Log.v(TAG, stringBuilder.toString());
                        }
                    }
                    FragmentManagerImpl fragmentManagerImpl = fragment.mChildFragmentManager;
                    if (fragmentManagerImpl != null) {
                        fragmentManagerImpl.saveNonConfig();
                        obj = fragment.mChildFragmentManager.mSavedNonConfig;
                    } else {
                        obj = fragment.mChildNonConfig;
                    }
                    if (list2 == null && obj != null) {
                        list2 = new ArrayList(this.mActive.size());
                        for (int i2 = 0; i2 < i; i2++) {
                            list2.add(null);
                        }
                    }
                    if (list2 != null) {
                        list2.add(obj);
                    }
                    if (list3 == null && fragment.mViewModelStore != null) {
                        list3 = new ArrayList(this.mActive.size());
                        for (int i3 = 0; i3 < i; i3++) {
                            list3.add(null);
                        }
                    }
                    if (list3 != null) {
                        list3.add(fragment.mViewModelStore);
                    }
                }
            }
        } else {
            list = null;
            list2 = list;
            list3 = list2;
        }
        if (list == null && list2 == null && list3 == null) {
            this.mSavedNonConfig = null;
        } else {
            this.mSavedNonConfig = new FragmentManagerNonConfig(list, list2, list3);
        }
    }

    void scheduleCommit() {
        synchronized (this) {
            Object obj = null;
            Object obj2 = (this.mPostponedTransactions == null || this.mPostponedTransactions.isEmpty()) ? null : 1;
            if (this.mPendingActions != null && this.mPendingActions.size() == 1) {
                obj = 1;
            }
            if (!(obj2 == null && r1 == null)) {
                this.mHost.getHandler().removeCallbacks(this.mExecCommit);
                this.mHost.getHandler().post(this.mExecCommit);
            }
        }
    }

    public void setBackStackIndex(int i, BackStackRecord backStackRecord) {
        synchronized (this) {
            if (this.mBackStackIndices == null) {
                this.mBackStackIndices = new ArrayList();
            }
            int size = this.mBackStackIndices.size();
            String str;
            StringBuilder stringBuilder;
            if (i < size) {
                if (DEBUG) {
                    str = TAG;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Setting back stack index ");
                    stringBuilder.append(i);
                    stringBuilder.append(" to ");
                    stringBuilder.append(backStackRecord);
                    Log.v(str, stringBuilder.toString());
                }
                this.mBackStackIndices.set(i, backStackRecord);
            } else {
                while (size < i) {
                    this.mBackStackIndices.add(null);
                    if (this.mAvailBackStackIndices == null) {
                        this.mAvailBackStackIndices = new ArrayList();
                    }
                    if (DEBUG) {
                        String str2 = TAG;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("Adding available back stack index ");
                        stringBuilder2.append(size);
                        Log.v(str2, stringBuilder2.toString());
                    }
                    this.mAvailBackStackIndices.add(Integer.valueOf(size));
                    size++;
                }
                if (DEBUG) {
                    str = TAG;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Adding back stack index ");
                    stringBuilder.append(i);
                    stringBuilder.append(" with ");
                    stringBuilder.append(backStackRecord);
                    Log.v(str, stringBuilder.toString());
                }
                this.mBackStackIndices.add(backStackRecord);
            }
        }
    }

    public void setPrimaryNavigationFragment(Fragment fragment) {
        if (fragment != null) {
            if (this.mActive.get(fragment.mIndex) == fragment) {
                if (fragment.mHost != null) {
                    if (fragment.getFragmentManager() == this) {
                    }
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Fragment ");
            stringBuilder.append(fragment);
            stringBuilder.append(" is not an active fragment of FragmentManager ");
            stringBuilder.append(this);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        this.mPrimaryNav = fragment;
    }

    public void showFragment(Fragment fragment) {
        if (DEBUG) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("show: ");
            stringBuilder.append(fragment);
            Log.v(TAG, stringBuilder.toString());
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged ^= 1;
        }
    }

    void startPendingDeferredFragments() {
        if (this.mActive != null) {
            for (int i = 0; i < this.mActive.size(); i++) {
                Fragment fragment = (Fragment) this.mActive.valueAt(i);
                if (fragment != null) {
                    performPendingDeferredStart(fragment);
                }
            }
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("FragmentManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        Object obj = this.mParent;
        if (obj == null) {
            obj = this.mHost;
        }
        DebugUtils.buildShortClassTag(obj, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public void unregisterFragmentLifecycleCallbacks(FragmentLifecycleCallbacks fragmentLifecycleCallbacks) {
        synchronized (this.mLifecycleCallbacks) {
            int size = this.mLifecycleCallbacks.size();
            for (int i = 0; i < size; i++) {
                if (((FragmentLifecycleCallbacksHolder) this.mLifecycleCallbacks.get(i)).mCallback == fragmentLifecycleCallbacks) {
                    this.mLifecycleCallbacks.remove(i);
                    break;
                }
            }
        }
    }
}
