package com.onesignal;

import android.os.PersistableBundle;

/* renamed from: com.onesignal.n */
class C0877n implements C0632k<PersistableBundle> {
    /* renamed from: a */
    private PersistableBundle f1849a;

    C0877n() {
        this.f1849a = new PersistableBundle();
    }

    C0877n(PersistableBundle persistableBundle) {
        this.f1849a = persistableBundle;
    }

    /* renamed from: a */
    public PersistableBundle mo1384a() {
        return this.f1849a;
    }

    /* renamed from: a */
    public void mo1385a(String str, Long l) {
        this.f1849a.putLong(str, l.longValue());
    }

    /* renamed from: a */
    public boolean mo1386a(String str) {
        return this.f1849a.containsKey(str);
    }

    public boolean getBoolean(String str, boolean z) {
        return this.f1849a.getBoolean(str, z);
    }

    public Integer getInt(String str) {
        return Integer.valueOf(this.f1849a.getInt(str));
    }

    public Long getLong(String str) {
        return Long.valueOf(this.f1849a.getLong(str));
    }

    public String getString(String str) {
        return this.f1849a.getString(str);
    }

    public void putString(String str, String str2) {
        this.f1849a.putString(str, str2);
    }
}
