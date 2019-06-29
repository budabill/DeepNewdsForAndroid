package android.arch.lifecycle;

/* renamed from: android.arch.lifecycle.r */
public class C0072r {
    /* renamed from: a */
    private final C0071a f118a;
    /* renamed from: b */
    private final C0073s f119b;

    /* renamed from: android.arch.lifecycle.r$a */
    public interface C0071a {
        <T extends C0070q> T create(Class<T> cls);
    }

    public C0072r(C0073s c0073s, C0071a c0071a) {
        this.f118a = c0071a;
        this.f119b = c0073s;
    }

    /* renamed from: a */
    public <T extends C0070q> T m111a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("android.arch.lifecycle.ViewModelProvider.DefaultKey:");
            stringBuilder.append(canonicalName);
            return m112a(stringBuilder.toString(), cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    /* renamed from: a */
    public <T extends C0070q> T m112a(String str, Class<T> cls) {
        T a = this.f119b.m113a(str);
        if (cls.isInstance(a)) {
            return a;
        }
        T create = this.f118a.create(cls);
        this.f119b.m115a(str, create);
        return create;
    }
}
