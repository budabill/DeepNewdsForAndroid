package p014c.p015a.p016a.p019b;

import java.util.Arrays;

/* renamed from: c.a.a.b.a */
public final class C0282a implements Cloneable {
    /* renamed from: a */
    private int[] f183a;
    /* renamed from: b */
    private int f184b;

    public C0282a() {
        this.f184b = 0;
        this.f183a = new int[1];
    }

    C0282a(int[] iArr, int i) {
        this.f183a = iArr;
        this.f184b = i;
    }

    /* renamed from: b */
    private void m204b(int i) {
        if (i > (this.f183a.length << 5)) {
            Object c = C0282a.m205c(i);
            Object obj = this.f183a;
            System.arraycopy(obj, 0, c, 0, obj.length);
            this.f183a = c;
        }
    }

    /* renamed from: c */
    private static int[] m205c(int i) {
        return new int[((i + 31) / 32)];
    }

    /* renamed from: a */
    public int m206a() {
        return this.f184b;
    }

    /* renamed from: a */
    public void m207a(int i, int i2) {
        if (i2 < 0 || i2 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        m204b(this.f184b + i2);
        while (i2 > 0) {
            boolean z = true;
            if (((i >> (i2 - 1)) & 1) != 1) {
                z = false;
            }
            m210a(z);
            i2--;
        }
    }

    /* renamed from: a */
    public void m208a(int i, byte[] bArr, int i2, int i3) {
        int i4 = i;
        i = 0;
        while (i < i3) {
            int i5 = i4;
            int i6 = 0;
            for (i4 = 0; i4 < 8; i4++) {
                if (m211a(i5)) {
                    i6 |= 1 << (7 - i4);
                }
                i5++;
            }
            bArr[i2 + i] = (byte) i6;
            i++;
            i4 = i5;
        }
    }

    /* renamed from: a */
    public void m209a(C0282a c0282a) {
        int i = c0282a.f184b;
        m204b(this.f184b + i);
        for (int i2 = 0; i2 < i; i2++) {
            m210a(c0282a.m211a(i2));
        }
    }

    /* renamed from: a */
    public void m210a(boolean z) {
        m204b(this.f184b + 1);
        if (z) {
            int[] iArr = this.f183a;
            int i = this.f184b;
            int i2 = i / 32;
            iArr[i2] = (1 << (i & 31)) | iArr[i2];
        }
        this.f184b++;
    }

    /* renamed from: a */
    public boolean m211a(int i) {
        return ((1 << (i & 31)) & this.f183a[i / 32]) != 0;
    }

    /* renamed from: b */
    public int m212b() {
        return (this.f184b + 7) / 8;
    }

    /* renamed from: b */
    public void m213b(C0282a c0282a) {
        if (this.f184b == c0282a.f184b) {
            int i = 0;
            while (true) {
                int[] iArr = this.f183a;
                if (i < iArr.length) {
                    iArr[i] = iArr[i] ^ c0282a.f183a[i];
                    i++;
                } else {
                    return;
                }
            }
        }
        throw new IllegalArgumentException("Sizes don't match");
    }

    public C0282a clone() {
        return new C0282a((int[]) this.f183a.clone(), this.f184b);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0282a)) {
            return false;
        }
        C0282a c0282a = (C0282a) obj;
        return this.f184b == c0282a.f184b && Arrays.equals(this.f183a, c0282a.f183a);
    }

    public int hashCode() {
        return (this.f184b * 31) + Arrays.hashCode(this.f183a);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(this.f184b);
        for (int i = 0; i < this.f184b; i++) {
            if ((i & 7) == 0) {
                stringBuilder.append(' ');
            }
            stringBuilder.append(m211a(i) ? 'X' : '.');
        }
        return stringBuilder.toString();
    }
}
