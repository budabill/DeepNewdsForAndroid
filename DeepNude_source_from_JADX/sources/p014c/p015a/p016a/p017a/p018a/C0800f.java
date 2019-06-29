package p014c.p015a.p016a.p017a.p018a;

import p014c.p015a.p016a.p019b.C0282a;

/* renamed from: c.a.a.a.a.f */
final class C0800f extends C0277h {
    /* renamed from: c */
    private final short f1727c;
    /* renamed from: d */
    private final short f1728d;

    C0800f(C0277h c0277h, int i, int i2) {
        super(c0277h);
        this.f1727c = (short) i;
        this.f1728d = (short) i2;
    }

    /* renamed from: a */
    void mo940a(C0282a c0282a, byte[] bArr) {
        c0282a.m207a(this.f1727c, this.f1728d);
    }

    public String toString() {
        short s = this.f1727c;
        short s2 = this.f1728d;
        int i = (s & ((1 << s2) - 1)) | (1 << s2);
        StringBuilder stringBuilder = new StringBuilder("<");
        stringBuilder.append(Integer.toBinaryString(i | (1 << this.f1728d)).substring(1));
        stringBuilder.append('>');
        return stringBuilder.toString();
    }
}
