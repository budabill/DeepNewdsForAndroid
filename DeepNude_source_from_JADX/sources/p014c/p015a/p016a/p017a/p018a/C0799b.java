package p014c.p015a.p016a.p017a.p018a;

import p014c.p015a.p016a.p019b.C0282a;

/* renamed from: c.a.a.a.a.b */
final class C0799b extends C0277h {
    /* renamed from: c */
    private final short f1725c;
    /* renamed from: d */
    private final short f1726d;

    C0799b(C0277h c0277h, int i, int i2) {
        super(c0277h);
        this.f1725c = (short) i;
        this.f1726d = (short) i2;
    }

    /* renamed from: a */
    public void mo940a(C0282a c0282a, byte[] bArr) {
        short s = (short) 0;
        while (true) {
            short s2 = this.f1726d;
            if (s < s2) {
                if (s == (short) 0 || (s == (short) 31 && s2 <= (short) 62)) {
                    int i;
                    int i2 = 5;
                    c0282a.m207a(31, 5);
                    short s3 = this.f1726d;
                    if (s3 > (short) 62) {
                        i = s3 - 31;
                        i2 = 16;
                    } else if (s == (short) 0) {
                        c0282a.m207a(Math.min(s3, 31), 5);
                    } else {
                        i = s3 - 31;
                    }
                    c0282a.m207a(i, i2);
                }
                c0282a.m207a(bArr[this.f1725c + s], 8);
                s++;
            } else {
                return;
            }
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        stringBuilder.append(this.f1725c);
        stringBuilder.append("::");
        stringBuilder.append((this.f1725c + this.f1726d) - 1);
        stringBuilder.append('>');
        return stringBuilder.toString();
    }
}
