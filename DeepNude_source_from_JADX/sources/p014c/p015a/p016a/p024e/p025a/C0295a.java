package p014c.p015a.p016a.p024e.p025a;

import java.lang.reflect.Array;

/* renamed from: c.a.a.e.a.a */
public final class C0295a {
    /* renamed from: a */
    private final C0296b[] f271a;
    /* renamed from: b */
    private int f272b;
    /* renamed from: c */
    private final int f273c;
    /* renamed from: d */
    private final int f274d;

    C0295a(int i, int i2) {
        this.f271a = new C0296b[i];
        int length = this.f271a.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.f271a[i3] = new C0296b(((i2 + 4) * 17) + 1);
        }
        this.f274d = i2 * 17;
        this.f273c = i;
        this.f272b = -1;
    }

    /* renamed from: a */
    C0296b m286a() {
        return this.f271a[this.f272b];
    }

    /* renamed from: a */
    public byte[][] m287a(int i, int i2) {
        byte[][] bArr = (byte[][]) Array.newInstance(byte.class, new int[]{this.f273c * i2, this.f274d * i});
        int i3 = this.f273c * i2;
        for (int i4 = 0; i4 < i3; i4++) {
            bArr[(i3 - i4) - 1] = this.f271a[i4 / i2].m291a(i);
        }
        return bArr;
    }

    /* renamed from: b */
    void m288b() {
        this.f272b++;
    }
}
