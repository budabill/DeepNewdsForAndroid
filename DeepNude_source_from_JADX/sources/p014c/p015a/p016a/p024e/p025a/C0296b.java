package p014c.p015a.p016a.p024e.p025a;

/* renamed from: c.a.a.e.a.b */
final class C0296b {
    /* renamed from: a */
    private final byte[] f275a;
    /* renamed from: b */
    private int f276b = 0;

    C0296b(int i) {
        this.f275a = new byte[i];
    }

    /* renamed from: a */
    private void m289a(int i, boolean z) {
        this.f275a[i] = (byte) z;
    }

    /* renamed from: a */
    void m290a(boolean z, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.f276b;
            this.f276b = i3 + 1;
            m289a(i3, z);
        }
    }

    /* renamed from: a */
    byte[] m291a(int i) {
        byte[] bArr = new byte[(this.f275a.length * i)];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = this.f275a[i2 / i];
        }
        return bArr;
    }
}
