package androidx.versionedparcelable;

import android.os.Parcelable;

/* renamed from: androidx.versionedparcelable.b */
public abstract class C0269b {
    /* renamed from: a */
    protected static <T extends C0270d> T m119a(String str, C0269b c0269b) {
        try {
            return (C0270d) Class.forName(str, true, C0269b.class.getClassLoader()).getDeclaredMethod("read", new Class[]{C0269b.class}).invoke(null, new Object[]{c0269b});
        } catch (Throwable e) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e);
        } catch (Throwable e2) {
            if (e2.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e2.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e2);
        } catch (Throwable e22) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e22);
        } catch (Throwable e222) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e222);
        }
    }

    /* renamed from: a */
    private static Class m120a(Class<? extends C0270d> cls) {
        return Class.forName(String.format("%s.%sParcelizer", new Object[]{cls.getPackage().getName(), cls.getSimpleName()}), false, cls.getClassLoader());
    }

    /* renamed from: a */
    protected static <T extends C0270d> void m121a(T t, C0269b c0269b) {
        try {
            C0269b.m122b((C0270d) t).getDeclaredMethod("write", new Class[]{t.getClass(), C0269b.class}).invoke(null, new Object[]{t, c0269b});
        } catch (Throwable e) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e);
        } catch (Throwable e2) {
            if (e2.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e2.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e2);
        } catch (Throwable e22) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e22);
        } catch (Throwable e222) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e222);
        }
    }

    /* renamed from: b */
    private static <T extends C0270d> Class m122b(T t) {
        return C0269b.m120a(t.getClass());
    }

    /* renamed from: c */
    private void m123c(C0270d c0270d) {
        Object a;
        try {
            a = C0269b.m120a(c0270d.getClass());
            mo930a(a.getName());
        } catch (Throwable e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a.getClass().getSimpleName());
            stringBuilder.append(" does not have a Parcelizer");
            throw new RuntimeException(stringBuilder.toString(), e);
        }
    }

    /* renamed from: a */
    public int m124a(int i, int i2) {
        return !mo932a(i2) ? i : mo937e();
    }

    /* renamed from: a */
    public <T extends Parcelable> T m125a(T t, int i) {
        return !mo932a(i) ? t : mo938f();
    }

    /* renamed from: a */
    public <T extends C0270d> T m126a(T t, int i) {
        return !mo932a(i) ? t : m149h();
    }

    /* renamed from: a */
    public String m127a(String str, int i) {
        return !mo932a(i) ? str : mo939g();
    }

    /* renamed from: a */
    protected abstract void mo928a();

    /* renamed from: a */
    protected abstract void mo929a(Parcelable parcelable);

    /* renamed from: a */
    protected void m130a(C0270d c0270d) {
        if (c0270d == null) {
            mo930a(null);
            return;
        }
        m123c(c0270d);
        C0269b b = mo933b();
        C0269b.m121a(c0270d, b);
        b.mo928a();
    }

    /* renamed from: a */
    protected abstract void mo930a(String str);

    /* renamed from: a */
    public void m132a(boolean z, boolean z2) {
    }

    /* renamed from: a */
    protected abstract void mo931a(byte[] bArr);

    /* renamed from: a */
    protected abstract boolean mo932a(int i);

    /* renamed from: a */
    public byte[] m135a(byte[] bArr, int i) {
        return !mo932a(i) ? bArr : mo936d();
    }

    /* renamed from: b */
    protected abstract C0269b mo933b();

    /* renamed from: b */
    protected abstract void mo934b(int i);

    /* renamed from: b */
    public void m138b(int i, int i2) {
        mo934b(i2);
        mo935c(i);
    }

    /* renamed from: b */
    public void m139b(Parcelable parcelable, int i) {
        mo934b(i);
        mo929a(parcelable);
    }

    /* renamed from: b */
    public void m140b(C0270d c0270d, int i) {
        mo934b(i);
        m130a(c0270d);
    }

    /* renamed from: b */
    public void m141b(String str, int i) {
        mo934b(i);
        mo930a(str);
    }

    /* renamed from: b */
    public void m142b(byte[] bArr, int i) {
        mo934b(i);
        mo931a(bArr);
    }

    /* renamed from: c */
    protected abstract void mo935c(int i);

    /* renamed from: c */
    public boolean m144c() {
        return false;
    }

    /* renamed from: d */
    protected abstract byte[] mo936d();

    /* renamed from: e */
    protected abstract int mo937e();

    /* renamed from: f */
    protected abstract <T extends Parcelable> T mo938f();

    /* renamed from: g */
    protected abstract String mo939g();

    /* renamed from: h */
    protected <T extends C0270d> T m149h() {
        String g = mo939g();
        return g == null ? null : C0269b.m119a(g, mo933b());
    }
}
