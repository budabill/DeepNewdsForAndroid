package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;

/* renamed from: androidx.versionedparcelable.c */
class C0798c extends C0269b {
    /* renamed from: a */
    private final SparseIntArray f1718a;
    /* renamed from: b */
    private final Parcel f1719b;
    /* renamed from: c */
    private final int f1720c;
    /* renamed from: d */
    private final int f1721d;
    /* renamed from: e */
    private final String f1722e;
    /* renamed from: f */
    private int f1723f;
    /* renamed from: g */
    private int f1724g;

    C0798c(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "");
    }

    C0798c(Parcel parcel, int i, int i2, String str) {
        this.f1718a = new SparseIntArray();
        this.f1723f = -1;
        this.f1724g = 0;
        this.f1719b = parcel;
        this.f1720c = i;
        this.f1721d = i2;
        this.f1724g = this.f1720c;
        this.f1722e = str;
    }

    /* renamed from: d */
    private int m2055d(int i) {
        int readInt;
        do {
            int i2 = this.f1724g;
            if (i2 >= this.f1721d) {
                return -1;
            }
            this.f1719b.setDataPosition(i2);
            i2 = this.f1719b.readInt();
            readInt = this.f1719b.readInt();
            this.f1724g += i2;
        } while (readInt != i);
        return this.f1719b.dataPosition();
    }

    /* renamed from: a */
    public void mo928a() {
        int i = this.f1723f;
        if (i >= 0) {
            i = this.f1718a.get(i);
            int dataPosition = this.f1719b.dataPosition();
            int i2 = dataPosition - i;
            this.f1719b.setDataPosition(i);
            this.f1719b.writeInt(i2);
            this.f1719b.setDataPosition(dataPosition);
        }
    }

    /* renamed from: a */
    public void mo929a(Parcelable parcelable) {
        this.f1719b.writeParcelable(parcelable, 0);
    }

    /* renamed from: a */
    public void mo930a(String str) {
        this.f1719b.writeString(str);
    }

    /* renamed from: a */
    public void mo931a(byte[] bArr) {
        if (bArr != null) {
            this.f1719b.writeInt(bArr.length);
            this.f1719b.writeByteArray(bArr);
            return;
        }
        this.f1719b.writeInt(-1);
    }

    /* renamed from: a */
    public boolean mo932a(int i) {
        i = m2055d(i);
        if (i == -1) {
            return false;
        }
        this.f1719b.setDataPosition(i);
        return true;
    }

    /* renamed from: b */
    protected C0269b mo933b() {
        Parcel parcel = this.f1719b;
        int dataPosition = parcel.dataPosition();
        int i = this.f1724g;
        if (i == this.f1720c) {
            i = this.f1721d;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f1722e);
        stringBuilder.append("  ");
        return new C0798c(parcel, dataPosition, i, stringBuilder.toString());
    }

    /* renamed from: b */
    public void mo934b(int i) {
        mo928a();
        this.f1723f = i;
        this.f1718a.put(i, this.f1719b.dataPosition());
        mo935c(0);
        mo935c(i);
    }

    /* renamed from: c */
    public void mo935c(int i) {
        this.f1719b.writeInt(i);
    }

    /* renamed from: d */
    public byte[] mo936d() {
        int readInt = this.f1719b.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.f1719b.readByteArray(bArr);
        return bArr;
    }

    /* renamed from: e */
    public int mo937e() {
        return this.f1719b.readInt();
    }

    /* renamed from: f */
    public <T extends Parcelable> T mo938f() {
        return this.f1719b.readParcelable(C0798c.class.getClassLoader());
    }

    /* renamed from: g */
    public String mo939g() {
        return this.f1719b.readString();
    }
}
