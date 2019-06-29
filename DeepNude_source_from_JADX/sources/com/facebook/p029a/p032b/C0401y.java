package com.facebook.p029a.p032b;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import com.facebook.C0560t;
import p013b.C0271a;

/* renamed from: com.facebook.a.b.y */
class C0401y {
    /* renamed from: a */
    private String f667a;
    /* renamed from: b */
    private boolean f668b;

    /* renamed from: com.facebook.a.b.y$a */
    public static class C0400a {
        /* renamed from: a */
        public static C0401y m744a(Activity activity) {
            String packageName;
            ComponentName callingActivity = activity.getCallingActivity();
            if (callingActivity != null) {
                packageName = callingActivity.getPackageName();
                if (packageName.equals(activity.getPackageName())) {
                    return null;
                }
            }
            packageName = "";
            Intent intent = activity.getIntent();
            boolean z = false;
            String str = "_fbSourceApplicationHasBeenSet";
            if (!(intent == null || intent.getBooleanExtra(str, false))) {
                intent.putExtra(str, true);
                Bundle a = C0271a.m150a(intent);
                if (a != null) {
                    Bundle bundle = a.getBundle("referer_app_link");
                    if (bundle != null) {
                        packageName = bundle.getString("package");
                    }
                    z = true;
                }
            }
            intent.putExtra(str, true);
            return new C0401y(packageName, z);
        }
    }

    private C0401y(String str, boolean z) {
        this.f667a = str;
        this.f668b = z;
    }

    /* renamed from: a */
    public static void m745a() {
        Editor edit = PreferenceManager.getDefaultSharedPreferences(C0560t.m1252d()).edit();
        edit.remove("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage");
        edit.remove("com.facebook.appevents.SourceApplicationInfo.openedByApplink");
        edit.apply();
    }

    /* renamed from: b */
    public static C0401y m746b() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(C0560t.m1252d());
        String str = "com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage";
        return !defaultSharedPreferences.contains(str) ? null : new C0401y(defaultSharedPreferences.getString(str, null), defaultSharedPreferences.getBoolean("com.facebook.appevents.SourceApplicationInfo.openedByApplink", false));
    }

    /* renamed from: c */
    public void m747c() {
        Editor edit = PreferenceManager.getDefaultSharedPreferences(C0560t.m1252d()).edit();
        edit.putString("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage", this.f667a);
        edit.putBoolean("com.facebook.appevents.SourceApplicationInfo.openedByApplink", this.f668b);
        edit.apply();
    }

    public String toString() {
        String str = this.f668b ? "Applink" : "Unclassified";
        if (this.f667a == null) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("(");
        stringBuilder.append(this.f667a);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
