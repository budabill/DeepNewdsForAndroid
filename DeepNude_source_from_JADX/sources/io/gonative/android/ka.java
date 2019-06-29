package io.gonative.android;

import android.content.Context;
import android.util.Log;
import io.gonative.android.p038a.C0700a;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ka {
    /* renamed from: a */
    private static final String f1613a = "io.gonative.android.ka";
    /* renamed from: b */
    private static ka f1614b;
    /* renamed from: c */
    private Pattern f1615c = null;
    /* renamed from: d */
    private String f1616d = null;

    private ka() {
    }

    /* renamed from: a */
    public static ka m1932a() {
        if (f1614b == null) {
            f1614b = new ka();
        }
        return f1614b;
    }

    /* renamed from: b */
    private void m1933b(String str) {
        this.f1616d = str;
    }

    /* renamed from: a */
    public void m1934a(Context context) {
        String str = C0700a.m1851a(context).f1511G;
        if (str != null && !str.isEmpty()) {
            try {
                this.f1615c = Pattern.compile(str);
            } catch (Throwable e) {
                Log.e(f1613a, e.getMessage(), e);
            }
        }
    }

    /* renamed from: a */
    public void m1935a(String str) {
        Pattern pattern = this.f1615c;
        if (pattern != null) {
            Matcher matcher = pattern.matcher(str);
            if (matcher.groupCount() > 0 && matcher.find()) {
                m1933b(matcher.group(1));
            }
        }
    }

    /* renamed from: b */
    public String m1936b() {
        return this.f1616d;
    }
}
