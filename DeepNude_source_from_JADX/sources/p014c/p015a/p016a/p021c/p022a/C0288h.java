package p014c.p015a.p016a.p021c.p022a;

import java.nio.charset.Charset;
import p014c.p015a.p016a.C0285b;

/* renamed from: c.a.a.c.a.h */
final class C0288h {
    /* renamed from: a */
    private final String f227a;
    /* renamed from: b */
    private C0292l f228b;
    /* renamed from: c */
    private C0285b f229c;
    /* renamed from: d */
    private C0285b f230d;
    /* renamed from: e */
    private final StringBuilder f231e;
    /* renamed from: f */
    int f232f;
    /* renamed from: g */
    private int f233g;
    /* renamed from: h */
    private C0291k f234h;
    /* renamed from: i */
    private int f235i;

    C0288h(String str) {
        byte[] bytes = str.getBytes(Charset.forName("ISO-8859-1"));
        StringBuilder stringBuilder = new StringBuilder(bytes.length);
        int length = bytes.length;
        for (int i = 0; i < length; i++) {
            char c = (char) (bytes[i] & 255);
            if (c == '?') {
                if (str.charAt(i) != '?') {
                    throw new IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
                }
            }
            stringBuilder.append(c);
        }
        this.f227a = stringBuilder.toString();
        this.f228b = C0292l.FORCE_NONE;
        this.f231e = new StringBuilder(str.length());
        this.f233g = -1;
    }

    /* renamed from: l */
    private int m237l() {
        return this.f227a.length() - this.f235i;
    }

    /* renamed from: a */
    public int m238a() {
        return this.f231e.length();
    }

    /* renamed from: a */
    public void m239a(char c) {
        this.f231e.append(c);
    }

    /* renamed from: a */
    public void m240a(int i) {
        this.f235i = i;
    }

    /* renamed from: a */
    public void m241a(C0285b c0285b, C0285b c0285b2) {
        this.f229c = c0285b;
        this.f230d = c0285b2;
    }

    /* renamed from: a */
    public void m242a(C0292l c0292l) {
        this.f228b = c0292l;
    }

    /* renamed from: a */
    public void m243a(String str) {
        this.f231e.append(str);
    }

    /* renamed from: b */
    public StringBuilder m244b() {
        return this.f231e;
    }

    /* renamed from: b */
    public void m245b(int i) {
        this.f233g = i;
    }

    /* renamed from: c */
    public char m246c() {
        return this.f227a.charAt(this.f232f);
    }

    /* renamed from: c */
    public void m247c(int i) {
        C0291k c0291k = this.f234h;
        if (c0291k == null || i > c0291k.m277a()) {
            this.f234h = C0291k.m274a(i, this.f228b, this.f229c, this.f230d, true);
        }
    }

    /* renamed from: d */
    public String m248d() {
        return this.f227a;
    }

    /* renamed from: e */
    public int m249e() {
        return this.f233g;
    }

    /* renamed from: f */
    public int m250f() {
        return m237l() - this.f232f;
    }

    /* renamed from: g */
    public C0291k m251g() {
        return this.f234h;
    }

    /* renamed from: h */
    public boolean m252h() {
        return this.f232f < m237l();
    }

    /* renamed from: i */
    public void m253i() {
        this.f233g = -1;
    }

    /* renamed from: j */
    public void m254j() {
        this.f234h = null;
    }

    /* renamed from: k */
    public void m255k() {
        m247c(m238a());
    }
}
