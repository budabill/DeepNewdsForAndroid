package p014c.p015a.p016a.p026f.p028b;

import p014c.p015a.p016a.p026f.p027a.C0303a;
import p014c.p015a.p016a.p026f.p027a.C0304b;
import p014c.p015a.p016a.p026f.p027a.C0307c;

/* renamed from: c.a.a.f.b.g */
public final class C0314g {
    /* renamed from: a */
    private C0304b f343a;
    /* renamed from: b */
    private C0303a f344b;
    /* renamed from: c */
    private C0307c f345c;
    /* renamed from: d */
    private int f346d = -1;
    /* renamed from: e */
    private C0309b f347e;

    /* renamed from: a */
    public static boolean m396a(int i) {
        return i >= 0 && i < 8;
    }

    /* renamed from: a */
    public C0309b m397a() {
        return this.f347e;
    }

    /* renamed from: a */
    public void m398a(C0303a c0303a) {
        this.f344b = c0303a;
    }

    /* renamed from: a */
    public void m399a(C0304b c0304b) {
        this.f343a = c0304b;
    }

    /* renamed from: a */
    public void m400a(C0307c c0307c) {
        this.f345c = c0307c;
    }

    /* renamed from: a */
    public void m401a(C0309b c0309b) {
        this.f347e = c0309b;
    }

    /* renamed from: b */
    public void m402b(int i) {
        this.f346d = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(200);
        stringBuilder.append("<<\n");
        stringBuilder.append(" mode: ");
        stringBuilder.append(this.f343a);
        stringBuilder.append("\n ecLevel: ");
        stringBuilder.append(this.f344b);
        stringBuilder.append("\n version: ");
        stringBuilder.append(this.f345c);
        stringBuilder.append("\n maskPattern: ");
        stringBuilder.append(this.f346d);
        if (this.f347e == null) {
            stringBuilder.append("\n matrix: null\n");
        } else {
            stringBuilder.append("\n matrix:\n");
            stringBuilder.append(this.f347e);
        }
        stringBuilder.append(">>\n");
        return stringBuilder.toString();
    }
}
