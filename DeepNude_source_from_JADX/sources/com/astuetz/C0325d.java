package com.astuetz;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.astuetz.d */
class C0325d implements Creator<SavedState> {
    C0325d() {
    }

    public SavedState createFromParcel(Parcel parcel) {
        return new SavedState(parcel);
    }

    public SavedState[] newArray(int i) {
        return new SavedState[i];
    }
}
