package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ParcelImpl implements Parcelable {
    public static final Creator<ParcelImpl> CREATOR = new C0268a();
    /* renamed from: a */
    private final C0270d f126a;

    protected ParcelImpl(Parcel parcel) {
        this.f126a = new C0798c(parcel).m149h();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        new C0798c(parcel).m130a(this.f126a);
    }
}
