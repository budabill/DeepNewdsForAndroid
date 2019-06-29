package android.support.v7.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v7.appcompat.C0222R;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.util.StateSet;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

class StateListDrawable extends DrawableContainer {
    private static final boolean DEBUG = false;
    private static final String TAG = "StateListDrawable";
    private boolean mMutated;
    private StateListState mStateListState;

    static class StateListState extends DrawableContainerState {
        int[][] mStateSets;

        StateListState(StateListState stateListState, StateListDrawable stateListDrawable, Resources resources) {
            super(stateListState, stateListDrawable, resources);
            if (stateListState != null) {
                this.mStateSets = stateListState.mStateSets;
            } else {
                this.mStateSets = new int[getCapacity()][];
            }
        }

        int addStateSet(int[] iArr, Drawable drawable) {
            int addChild = addChild(drawable);
            this.mStateSets[addChild] = iArr;
            return addChild;
        }

        public void growArray(int i, int i2) {
            super.growArray(i, i2);
            Object obj = new int[i2][];
            System.arraycopy(this.mStateSets, 0, obj, 0, i);
            this.mStateSets = obj;
        }

        int indexOfStateSet(int[] iArr) {
            int[][] iArr2 = this.mStateSets;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (StateSet.stateSetMatches(iArr2[i], iArr)) {
                    return i;
                }
            }
            return -1;
        }

        void mutate() {
            int[][] iArr = this.mStateSets;
            int[][] iArr2 = new int[iArr.length][];
            for (int length = iArr.length - 1; length >= 0; length--) {
                int[][] iArr3 = this.mStateSets;
                iArr2[length] = iArr3[length] != null ? (int[]) iArr3[length].clone() : null;
            }
            this.mStateSets = iArr2;
        }

        public Drawable newDrawable() {
            return new StateListDrawable(this, null);
        }

        public Drawable newDrawable(Resources resources) {
            return new StateListDrawable(this, resources);
        }
    }

    StateListDrawable() {
        this(null, null);
    }

    StateListDrawable(StateListState stateListState) {
        if (stateListState != null) {
            setConstantState(stateListState);
        }
    }

    StateListDrawable(StateListState stateListState, Resources resources) {
        setConstantState(new StateListState(stateListState, this, resources));
        onStateChange(getState());
    }

    private void inflateChildElements(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        StateListState stateListState = this.mStateListState;
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next != 1) {
                int depth2 = xmlPullParser.getDepth();
                if (depth2 < depth && next == 3) {
                    return;
                }
                if (next == 2) {
                    if (depth2 > depth) {
                        continue;
                    } else if (xmlPullParser.getName().equals("item")) {
                        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, C0222R.styleable.StateListDrawableItem);
                        Drawable drawable = null;
                        int resourceId = obtainAttributes.getResourceId(C0222R.styleable.StateListDrawableItem_android_drawable, -1);
                        if (resourceId > 0) {
                            drawable = AppCompatResources.getDrawable(context, resourceId);
                        }
                        obtainAttributes.recycle();
                        int[] extractStateSet = extractStateSet(attributeSet);
                        if (drawable == null) {
                            while (true) {
                                depth2 = xmlPullParser.next();
                                if (depth2 != 4) {
                                    break;
                                }
                            }
                            if (depth2 == 2) {
                                drawable = VERSION.SDK_INT >= 21 ? Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme) : Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
                            } else {
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append(xmlPullParser.getPositionDescription());
                                stringBuilder.append(": <item> tag requires a 'drawable' attribute or ");
                                stringBuilder.append("child tag defining a drawable");
                                throw new XmlPullParserException(stringBuilder.toString());
                            }
                        }
                        stateListState.addStateSet(extractStateSet, drawable);
                    }
                }
            } else {
                return;
            }
        }
    }

    private void updateStateFromTypedArray(TypedArray typedArray) {
        DrawableContainerState drawableContainerState = this.mStateListState;
        if (VERSION.SDK_INT >= 21) {
            drawableContainerState.mChangingConfigurations |= typedArray.getChangingConfigurations();
        }
        drawableContainerState.mVariablePadding = typedArray.getBoolean(C0222R.styleable.StateListDrawable_android_variablePadding, drawableContainerState.mVariablePadding);
        drawableContainerState.mConstantSize = typedArray.getBoolean(C0222R.styleable.StateListDrawable_android_constantSize, drawableContainerState.mConstantSize);
        drawableContainerState.mEnterFadeDuration = typedArray.getInt(C0222R.styleable.StateListDrawable_android_enterFadeDuration, drawableContainerState.mEnterFadeDuration);
        drawableContainerState.mExitFadeDuration = typedArray.getInt(C0222R.styleable.StateListDrawable_android_exitFadeDuration, drawableContainerState.mExitFadeDuration);
        drawableContainerState.mDither = typedArray.getBoolean(C0222R.styleable.StateListDrawable_android_dither, drawableContainerState.mDither);
    }

    public void addState(int[] iArr, Drawable drawable) {
        if (drawable != null) {
            this.mStateListState.addStateSet(iArr, drawable);
            onStateChange(getState());
        }
    }

    public void applyTheme(Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    void clearMutated() {
        super.clearMutated();
        this.mMutated = false;
    }

    StateListState cloneConstantState() {
        return new StateListState(this.mStateListState, this, null);
    }

    int[] extractStateSet(AttributeSet attributeSet) {
        int attributeCount = attributeSet.getAttributeCount();
        int[] iArr = new int[attributeCount];
        int i = 0;
        for (int i2 = 0; i2 < attributeCount; i2++) {
            int attributeNameResource = attributeSet.getAttributeNameResource(i2);
            if (!(attributeNameResource == 0 || attributeNameResource == 16842960 || attributeNameResource == 16843161)) {
                int i3 = i + 1;
                if (!attributeSet.getAttributeBooleanValue(i2, false)) {
                    attributeNameResource = -attributeNameResource;
                }
                iArr[i] = attributeNameResource;
                i = i3;
            }
        }
        return StateSet.trimStateSet(iArr, i);
    }

    int getStateCount() {
        return this.mStateListState.getChildCount();
    }

    Drawable getStateDrawable(int i) {
        return this.mStateListState.getChild(i);
    }

    int getStateDrawableIndex(int[] iArr) {
        return this.mStateListState.indexOfStateSet(iArr);
    }

    StateListState getStateListState() {
        return this.mStateListState;
    }

    int[] getStateSet(int i) {
        return this.mStateListState.mStateSets[i];
    }

    public void inflate(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, C0222R.styleable.StateListDrawable);
        setVisible(obtainAttributes.getBoolean(C0222R.styleable.StateListDrawable_android_visible, true), true);
        updateStateFromTypedArray(obtainAttributes);
        updateDensity(resources);
        obtainAttributes.recycle();
        inflateChildElements(context, resources, xmlPullParser, attributeSet, theme);
        onStateChange(getState());
    }

    public boolean isStateful() {
        return true;
    }

    public Drawable mutate() {
        if (!this.mMutated) {
            super.mutate();
            if (this == this) {
                this.mStateListState.mutate();
                this.mMutated = true;
            }
        }
        return this;
    }

    protected boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        int indexOfStateSet = this.mStateListState.indexOfStateSet(iArr);
        if (indexOfStateSet < 0) {
            indexOfStateSet = this.mStateListState.indexOfStateSet(StateSet.WILD_CARD);
        }
        if (!selectDrawable(indexOfStateSet)) {
            if (!onStateChange) {
                return false;
            }
        }
        return true;
    }

    protected void setConstantState(DrawableContainerState drawableContainerState) {
        super.setConstantState(drawableContainerState);
        if (drawableContainerState instanceof StateListState) {
            this.mStateListState = (StateListState) drawableContainerState;
        }
    }
}
