package p000a.p005b.p007b;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: a.b.b.m */
public interface C0027m extends IInterface {

    /* renamed from: a.b.b.m$a */
    public static abstract class C0740a extends Binder implements C0027m {
        public C0740a() {
            attachInterface(this, "android.support.customtabs.ICustomTabsCallback");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            Bundle bundle = null;
            String str = "android.support.customtabs.ICustomTabsCallback";
            if (i == 2) {
                parcel.enforceInterface(str);
                i = parcel.readInt();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                mo1420a(i, bundle);
            } else if (i == 3) {
                parcel.enforceInterface(str);
                r5 = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                mo1422a(r5, bundle);
            } else if (i == 4) {
                parcel.enforceInterface(str);
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                mo1421a(bundle);
            } else if (i == 5) {
                parcel.enforceInterface(str);
                r5 = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                mo1423b(r5, bundle);
            } else if (i == 6) {
                parcel.enforceInterface(str);
                i = parcel.readInt();
                Uri uri = parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null;
                boolean z = parcel.readInt() != 0;
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                mo1419a(i, uri, z, bundle);
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString(str);
                return true;
            }
            parcel2.writeNoException();
            return true;
        }
    }

    /* renamed from: a */
    void mo1419a(int i, Uri uri, boolean z, Bundle bundle);

    /* renamed from: a */
    void mo1420a(int i, Bundle bundle);

    /* renamed from: a */
    void mo1421a(Bundle bundle);

    /* renamed from: a */
    void mo1422a(String str, Bundle bundle);

    /* renamed from: b */
    void mo1423b(String str, Bundle bundle);
}
