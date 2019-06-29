package io.gonative.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.preference.PreferenceManager;

/* renamed from: io.gonative.android.b */
public class C0704b {
    /* renamed from: a */
    private Context f1567a;
    /* renamed from: b */
    private SharedPreferences f1568b;

    public C0704b(Context context) {
        this.f1567a = context;
    }

    /* renamed from: a */
    private String m1909a(String str) {
        if (str != null) {
            if (str.length() != 0) {
                if (str.indexOf("://") == -1) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("http://");
                    stringBuilder.append(str);
                    str = stringBuilder.toString();
                }
                return str;
            }
        }
        return null;
    }

    /* renamed from: b */
    private SharedPreferences m1910b() {
        if (this.f1568b == null) {
            this.f1568b = PreferenceManager.getDefaultSharedPreferences(this.f1567a);
        }
        return this.f1568b;
    }

    /* renamed from: b */
    private void m1911b(String str) {
        Editor putString;
        str = m1909a(str);
        SharedPreferences b = m1910b();
        String str2 = "io.gonative.android.initialUrl";
        if (str != null) {
            if (str.length() != 0) {
                putString = b.edit().putString(str2, str);
                putString.commit();
            }
        }
        putString = b.edit().remove(str2);
        putString.commit();
    }

    /* renamed from: a */
    public String m1912a() {
        return m1909a(m1910b().getString("io.gonative.android.initialUrl", null));
    }

    /* renamed from: a */
    public void m1913a(Uri uri) {
        if ("gonative".equals(uri.getScheme())) {
            if ("config".equals(uri.getHost())) {
                if ("/set".equals(uri.getPath())) {
                    String queryParameter = uri.getQueryParameter("initialUrl");
                    if (queryParameter != null) {
                        m1911b(queryParameter);
                    }
                }
            }
        }
    }
}
