package com.onesignal;

import android.os.Bundle;

/* renamed from: com.onesignal.l */
class C0876l implements C0632k<Bundle> {
    /* renamed from: a */
    private Bundle f1840a;

    C0876l() {
        this.f1840a = new Bundle();
    }

    C0876l(Bundle bundle) {
        this.f1840a = bundle;
    }

    /* renamed from: a */
    public Bundle mo1384a() {
        return this.f1840a;
    }

    /* renamed from: a */
    public void mo1385a(String str, Long l) {
        this.f1840a.putLong(str, l.longValue());
    }

    /* renamed from: a */
    public boolean mo1386a(String str) {
        return this.f1840a.containsKey(str);
    }

    public boolean getBoolean(String str, boolean z) {
        return this.f1840a.getBoolean(str, z);
    }

    public Integer getInt(String str) {
        return Integer.valueOf(this.f1840a.getInt(str));
    }

    public Long getLong(String str) {
        return Long.valueOf(this.f1840a.getLong(str));
    }

    public String getString(String str) {
        return this.f1840a.getString(str);
    }

    public void putString(String str, String str2) {
        this.f1840a.putString(str, str2);
    }
}
