package com.facebook.internal;

import android.util.Log;
import com.facebook.C0336G;
import com.facebook.C0560t;
import java.util.HashMap;
import java.util.Map.Entry;

/* renamed from: com.facebook.internal.G */
public class C0461G {
    /* renamed from: a */
    private static final HashMap<String, String> f807a = new HashMap();
    /* renamed from: b */
    private final C0336G f808b;
    /* renamed from: c */
    private final String f809c;
    /* renamed from: d */
    private StringBuilder f810d;
    /* renamed from: e */
    private int f811e = 3;

    public C0461G(C0336G c0336g, String str) {
        C0476S.m1017a(str, "tag");
        this.f808b = c0336g;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FacebookSDK.");
        stringBuilder.append(str);
        this.f809c = stringBuilder.toString();
        this.f810d = new StringBuilder();
    }

    /* renamed from: a */
    public static void m889a(C0336G c0336g, int i, String str, String str2) {
        if (C0560t.m1246a(c0336g)) {
            str2 = C0461G.m896d(str2);
            String str3 = "FacebookSDK.";
            if (!str.startsWith(str3)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str3);
                stringBuilder.append(str);
                str = stringBuilder.toString();
            }
            Log.println(i, str, str2);
            if (c0336g == C0336G.DEVELOPER_ERRORS) {
                new Exception().printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public static void m890a(C0336G c0336g, int i, String str, String str2, Object... objArr) {
        if (C0560t.m1246a(c0336g)) {
            C0461G.m889a(c0336g, i, str, String.format(str2, objArr));
        }
    }

    /* renamed from: a */
    public static void m891a(C0336G c0336g, String str, String str2) {
        C0461G.m889a(c0336g, 3, str, str2);
    }

    /* renamed from: a */
    public static void m892a(C0336G c0336g, String str, String str2, Object... objArr) {
        if (C0560t.m1246a(c0336g)) {
            C0461G.m889a(c0336g, 3, str, String.format(str2, objArr));
        }
    }

    /* renamed from: a */
    public static synchronized void m893a(String str, String str2) {
        synchronized (C0461G.class) {
            f807a.put(str, str2);
        }
    }

    /* renamed from: b */
    private boolean m894b() {
        return C0560t.m1246a(this.f808b);
    }

    /* renamed from: c */
    public static synchronized void m895c(String str) {
        synchronized (C0461G.class) {
            if (!C0560t.m1246a(C0336G.INCLUDE_ACCESS_TOKENS)) {
                C0461G.m893a(str, "ACCESS_TOKEN_REMOVED");
            }
        }
    }

    /* renamed from: d */
    private static synchronized String m896d(String str) {
        synchronized (C0461G.class) {
            for (Entry entry : f807a.entrySet()) {
                str = str.replace((CharSequence) entry.getKey(), (CharSequence) entry.getValue());
            }
        }
        return str;
    }

    /* renamed from: a */
    public void m897a() {
        m901b(this.f810d.toString());
        this.f810d = new StringBuilder();
    }

    /* renamed from: a */
    public void m898a(String str) {
        if (m894b()) {
            this.f810d.append(str);
        }
    }

    /* renamed from: a */
    public void m899a(String str, Object obj) {
        m900a("  %s:\t%s\n", str, obj);
    }

    /* renamed from: a */
    public void m900a(String str, Object... objArr) {
        if (m894b()) {
            this.f810d.append(String.format(str, objArr));
        }
    }

    /* renamed from: b */
    public void m901b(String str) {
        C0461G.m889a(this.f808b, this.f811e, this.f809c, str);
    }
}
