package p014c.p015a.p016a.p026f.p028b;

import java.lang.reflect.Array;

/* renamed from: c.a.a.f.b.b */
public final class C0309b {
    /* renamed from: a */
    private final byte[][] f334a;
    /* renamed from: b */
    private final int f335b;
    /* renamed from: c */
    private final int f336c;

    public C0309b(int i, int i2) {
        this.f334a = (byte[][]) Array.newInstance(byte.class, new int[]{i2, i});
        this.f335b = i;
        this.f336c = i2;
    }

    /* renamed from: a */
    public byte m340a(int i, int i2) {
        return this.f334a[i2][i];
    }

    /* renamed from: a */
    public void m341a(byte b) {
        for (int i = 0; i < this.f336c; i++) {
            for (int i2 = 0; i2 < this.f335b; i2++) {
                this.f334a[i][i2] = b;
            }
        }
    }

    /* renamed from: a */
    public void m342a(int i, int i2, int i3) {
        this.f334a[i2][i] = (byte) i3;
    }

    /* renamed from: a */
    public void m343a(int i, int i2, boolean z) {
        this.f334a[i2][i] = (byte) z;
    }

    /* renamed from: a */
    public byte[][] m344a() {
        return this.f334a;
    }

    /* renamed from: b */
    public int m345b() {
        return this.f336c;
    }

    /* renamed from: c */
    public int m346c() {
        return this.f335b;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(((this.f335b * 2) * this.f336c) + 2);
        for (int i = 0; i < this.f336c; i++) {
            for (int i2 = 0; i2 < this.f335b; i2++) {
                byte b = this.f334a[i][i2];
                String str = b != (byte) 0 ? b != (byte) 1 ? "  " : " 1" : " 0";
                stringBuilder.append(str);
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }
}
