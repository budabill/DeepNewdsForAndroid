package com.facebook.p029a;

import android.os.Build.VERSION;
import android.os.Bundle;
import com.facebook.C0336G;
import com.facebook.C0506l;
import com.facebook.internal.C0461G;
import com.facebook.internal.C0475Q;
import com.facebook.p029a.p032b.C0383i;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONObject;

/* renamed from: com.facebook.a.f */
class C0409f implements Serializable {
    /* renamed from: a */
    private static final HashSet<String> f688a = new HashSet();
    private static final long serialVersionUID = 1;
    /* renamed from: b */
    private final JSONObject f689b;
    /* renamed from: c */
    private final boolean f690c;
    /* renamed from: d */
    private final String f691d;
    /* renamed from: e */
    private final String f692e;

    /* renamed from: com.facebook.a.f$a */
    static class C0407a implements Serializable {
        private static final long serialVersionUID = -2488473066578201069L;
        /* renamed from: a */
        private final String f683a;
        /* renamed from: b */
        private final boolean f684b;

        private Object readResolve() {
            return new C0409f(this.f683a, this.f684b, null);
        }
    }

    /* renamed from: com.facebook.a.f$b */
    static class C0408b implements Serializable {
        private static final long serialVersionUID = 20160803001L;
        /* renamed from: a */
        private final String f685a;
        /* renamed from: b */
        private final boolean f686b;
        /* renamed from: c */
        private final String f687c;

        private C0408b(String str, boolean z, String str2) {
            this.f685a = str;
            this.f686b = z;
            this.f687c = str2;
        }

        private Object readResolve() {
            return new C0409f(this.f685a, this.f686b, this.f687c);
        }
    }

    public C0409f(String str, String str2, Double d, Bundle bundle, boolean z, UUID uuid) {
        this.f689b = C0409f.m755a(str, str2, d, bundle, z, uuid);
        this.f690c = z;
        this.f691d = str2;
        this.f692e = m757e();
    }

    private C0409f(String str, boolean z, String str2) {
        this.f689b = new JSONObject(str);
        this.f690c = z;
        this.f691d = this.f689b.optString("_eventName");
        this.f692e = str2;
    }

    /* renamed from: a */
    private static String m754a(String str) {
        String str2 = "Failed to generate checksum: ";
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            byte[] bytes = str.getBytes("UTF-8");
            instance.update(bytes, 0, bytes.length);
            return C0383i.m688a(instance.digest());
        } catch (Exception e) {
            C0475Q.m983a(str2, e);
            return "0";
        } catch (Exception e2) {
            C0475Q.m983a(str2, e2);
            return "1";
        }
    }

    /* renamed from: a */
    private static JSONObject m755a(String str, String str2, Double d, Bundle bundle, boolean z, UUID uuid) {
        C0409f.m756b(str2);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("_eventName", str2);
        jSONObject.put("_eventName_md5", C0409f.m754a(str2));
        jSONObject.put("_logTime", System.currentTimeMillis() / 1000);
        jSONObject.put("_ui", str);
        if (uuid != null) {
            jSONObject.put("_session_id", uuid);
        }
        if (d != null) {
            jSONObject.put("_valueToSum", d.doubleValue());
        }
        if (z) {
            jSONObject.put("_implicitlyLogged", "1");
        }
        if (bundle != null) {
            for (String str3 : bundle.keySet()) {
                C0409f.m756b(str3);
                Object obj = bundle.get(str3);
                if (!(obj instanceof String)) {
                    if (!(obj instanceof Number)) {
                        throw new C0506l(String.format("Parameter value '%s' for key '%s' should be a string or a numeric type.", new Object[]{obj, str3}));
                    }
                }
                jSONObject.put(str3, obj.toString());
            }
        }
        if (!z) {
            C0461G.m892a(C0336G.APP_EVENTS, "AppEvents", "Created app event '%s'", jSONObject.toString());
        }
        return jSONObject;
    }

    /* renamed from: b */
    private static void m756b(String str) {
        if (!(str == null || str.length() == 0)) {
            if (str.length() <= 40) {
                boolean contains;
                synchronized (f688a) {
                    contains = f688a.contains(str);
                }
                if (!contains) {
                    if (str.matches("^[0-9a-zA-Z_]+[0-9a-zA-Z _-]*$")) {
                        synchronized (f688a) {
                            f688a.add(str);
                        }
                        return;
                    }
                    throw new C0506l(String.format("Skipping event named '%s' due to illegal name - must be under 40 chars and alphanumeric, _, - or space, and not start with a space or hyphen.", new Object[]{str}));
                }
                return;
            }
        }
        if (str == null) {
            str = "<None Provided>";
        }
        throw new C0506l(String.format(Locale.ROOT, "Identifier '%s' must be less than %d characters", new Object[]{str, Integer.valueOf(40)}));
    }

    /* renamed from: e */
    private String m757e() {
        String jSONObject;
        if (VERSION.SDK_INT > 19) {
            jSONObject = this.f689b.toString();
        } else {
            Object arrayList = new ArrayList();
            Iterator keys = this.f689b.keys();
            while (keys.hasNext()) {
                arrayList.add(keys.next());
            }
            Collections.sort(arrayList);
            StringBuilder stringBuilder = new StringBuilder();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                stringBuilder.append(str);
                stringBuilder.append(" = ");
                stringBuilder.append(this.f689b.optString(str));
                stringBuilder.append('\n');
            }
            jSONObject = stringBuilder.toString();
        }
        return C0409f.m754a(jSONObject);
    }

    private Object writeReplace() {
        return new C0408b(this.f689b.toString(), this.f690c, this.f692e);
    }

    /* renamed from: a */
    public boolean m758a() {
        return this.f690c;
    }

    /* renamed from: b */
    public JSONObject m759b() {
        return this.f689b;
    }

    /* renamed from: c */
    public String m760c() {
        return this.f691d;
    }

    /* renamed from: d */
    public boolean m761d() {
        return this.f692e == null ? true : m757e().equals(this.f692e);
    }

    public String toString() {
        return String.format("\"%s\", implicit: %b, json: %s", new Object[]{this.f689b.optString("_eventName"), Boolean.valueOf(this.f690c), this.f689b.toString()});
    }
}
