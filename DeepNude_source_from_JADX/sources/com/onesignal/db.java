package com.onesignal;

class db extends cb {
    db(String str, boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("email");
        stringBuilder.append(str);
        super(stringBuilder.toString(), z);
    }

    /* renamed from: a */
    protected void mo1371a() {
    }

    /* renamed from: b */
    cb mo1372b(String str) {
        return new db(str, false);
    }

    /* renamed from: b */
    boolean mo1373b() {
        return true;
    }
}
