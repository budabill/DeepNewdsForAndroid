package android.support.v4.view;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;

public abstract class AbsSavedState implements Parcelable {
    public static final Creator<AbsSavedState> CREATOR = new C01762();
    public static final AbsSavedState EMPTY_STATE = new C07741();
    private final Parcelable mSuperState;

    /* renamed from: android.support.v4.view.AbsSavedState$2 */
    static class C01762 implements ClassLoaderCreator<AbsSavedState> {
        C01762() {
        }

        public AbsSavedState createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, null);
        }

        public AbsSavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return AbsSavedState.EMPTY_STATE;
            }
            throw new IllegalStateException("superState must be null");
        }

        public AbsSavedState[] newArray(int i) {
            return new AbsSavedState[i];
        }
    }

    /* renamed from: android.support.v4.view.AbsSavedState$1 */
    static class C07741 extends AbsSavedState {
        C07741() {
            super();
        }
    }

    private AbsSavedState() {
        this.mSuperState = null;
    }

    protected AbsSavedState(Parcel parcel) {
        this(parcel, null);
    }

    protected AbsSavedState(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        if (readParcelable == null) {
            readParcelable = EMPTY_STATE;
        }
        this.mSuperState = readParcelable;
    }

    protected AbsSavedState(Parcelable parcelable) {
        if (parcelable != null) {
            if (parcelable == EMPTY_STATE) {
                parcelable = null;
            }
            this.mSuperState = parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    public int describeContents() {
        return 0;
    }

    public final Parcelable getSuperState() {
        return this.mSuperState;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mSuperState, i);
    }
}
