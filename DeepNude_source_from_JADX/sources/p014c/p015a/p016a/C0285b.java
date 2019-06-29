package p014c.p015a.p016a;

/* renamed from: c.a.a.b */
public final class C0285b {
    /* renamed from: a */
    private final int f221a;
    /* renamed from: b */
    private final int f222b;

    /* renamed from: a */
    public int m224a() {
        return this.f222b;
    }

    /* renamed from: b */
    public int m225b() {
        return this.f221a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C0285b) {
            C0285b c0285b = (C0285b) obj;
            if (this.f221a == c0285b.f221a && this.f222b == c0285b.f222b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.f221a * 32713) + this.f222b;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f221a);
        stringBuilder.append("x");
        stringBuilder.append(this.f222b);
        return stringBuilder.toString();
    }
}
