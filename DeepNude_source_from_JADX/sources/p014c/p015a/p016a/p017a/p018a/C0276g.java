package p014c.p015a.p016a.p017a.p018a;

import android.support.v4.internal.view.SupportMenu;
import java.util.Deque;
import java.util.LinkedList;
import p014c.p015a.p016a.p019b.C0282a;

/* renamed from: c.a.a.a.a.g */
final class C0276g {
    /* renamed from: a */
    static final C0276g f139a = new C0276g(C0277h.f144a, 0, 0, 0);
    /* renamed from: b */
    private final int f140b;
    /* renamed from: c */
    private final C0277h f141c;
    /* renamed from: d */
    private final int f142d;
    /* renamed from: e */
    private final int f143e;

    private C0276g(C0277h c0277h, int i, int i2, int i3) {
        this.f141c = c0277h;
        this.f140b = i;
        this.f142d = i2;
        this.f143e = i3;
    }

    /* renamed from: a */
    int m173a() {
        return this.f142d;
    }

    /* renamed from: a */
    C0276g m174a(int i) {
        C0276g c0276g;
        C0277h c0277h = this.f141c;
        int i2 = this.f140b;
        int i3 = this.f143e;
        if (i2 == 4 || i2 == 2) {
            i2 = C0275e.f135b[i2][0];
            int i4 = SupportMenu.USER_MASK & i2;
            i2 >>= 16;
            c0277h = c0277h.m183a(i4, i2);
            i3 += i2;
            i2 = 0;
        }
        int i5 = this.f142d;
        if (i5 != 0) {
            if (i5 != 31) {
                i5 = i5 == 62 ? 9 : 8;
                c0276g = new C0276g(c0277h, i2, this.f142d + 1, i3 + i5);
                return c0276g.f142d != 2078 ? c0276g.m179b(i + 1) : c0276g;
            }
        }
        i5 = 18;
        c0276g = new C0276g(c0277h, i2, this.f142d + 1, i3 + i5);
        if (c0276g.f142d != 2078) {
        }
    }

    /* renamed from: a */
    C0276g m175a(int i, int i2) {
        int i3 = this.f143e;
        C0277h c0277h = this.f141c;
        int i4 = this.f140b;
        if (i != i4) {
            i4 = C0275e.f135b[i4][i];
            int i5 = SupportMenu.USER_MASK & i4;
            i4 >>= 16;
            c0277h = c0277h.m183a(i5, i4);
            i3 += i4;
        }
        i4 = i == 2 ? 4 : 5;
        return new C0276g(c0277h.m183a(i2, i4), i, 0, i3 + i4);
    }

    /* renamed from: a */
    C0282a m176a(byte[] bArr) {
        Deque<C0277h> linkedList = new LinkedList();
        for (C0277h c0277h = m179b(bArr.length).f141c; c0277h != null; c0277h = c0277h.m182a()) {
            linkedList.addFirst(c0277h);
        }
        C0282a c0282a = new C0282a();
        for (C0277h a : linkedList) {
            a.mo940a(c0282a, bArr);
        }
        return c0282a;
    }

    /* renamed from: a */
    boolean m177a(C0276g c0276g) {
        int i = this.f143e + (C0275e.f135b[this.f140b][c0276g.f140b] >> 16);
        int i2 = c0276g.f142d;
        if (i2 > 0) {
            int i3 = this.f142d;
            if (i3 == 0 || i3 > i2) {
                i += 10;
            }
        }
        return i <= c0276g.f143e;
    }

    /* renamed from: b */
    int m178b() {
        return this.f143e;
    }

    /* renamed from: b */
    C0276g m179b(int i) {
        int i2 = this.f142d;
        return i2 == 0 ? this : new C0276g(this.f141c.m185b(i - i2, i2), this.f140b, 0, this.f143e);
    }

    /* renamed from: b */
    C0276g m180b(int i, int i2) {
        C0277h c0277h = this.f141c;
        int i3 = this.f140b == 2 ? 4 : 5;
        return new C0276g(c0277h.m183a(C0275e.f137d[this.f140b][i], i3).m183a(i2, 5), this.f140b, 0, (this.f143e + i3) + 5);
    }

    /* renamed from: c */
    int m181c() {
        return this.f140b;
    }

    public String toString() {
        return String.format("%s bits=%d bytes=%d", new Object[]{C0275e.f134a[this.f140b], Integer.valueOf(this.f143e), Integer.valueOf(this.f142d)});
    }
}
