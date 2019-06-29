package io.gonative.android;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import com.onesignal.sa;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: io.gonative.android.X */
public class C0695X {
    /* renamed from: a */
    private static final String f1488a = "io.gonative.android.X";
    /* renamed from: b */
    private Context f1489b;
    /* renamed from: c */
    private String f1490c;
    /* renamed from: d */
    private String f1491d;
    /* renamed from: e */
    private Boolean f1492e = Boolean.valueOf(false);
    /* renamed from: f */
    private JSONObject f1493f;
    /* renamed from: g */
    private String f1494g;
    /* renamed from: h */
    private List<C0693a> f1495h;

    /* renamed from: io.gonative.android.X$a */
    private class C0693a {
        /* renamed from: a */
        private String f1483a;
        /* renamed from: b */
        private List<Pattern> f1484b;
        /* renamed from: c */
        final /* synthetic */ C0695X f1485c;

        C0693a(C0695X c0695x, String str, List<Pattern> list) {
            this.f1485c = c0695x;
            this.f1483a = str;
            this.f1484b = list;
        }

        /* renamed from: a */
        void m1835a() {
            new C0694b(this, this.f1485c).execute(new Void[0]);
        }
    }

    /* renamed from: io.gonative.android.X$b */
    private static class C0694b extends AsyncTask<Void, Void, Void> {
        /* renamed from: a */
        private C0693a f1486a;
        /* renamed from: b */
        private C0695X f1487b;

        C0694b(C0693a c0693a, C0695X c0695x) {
            this.f1486a = c0693a;
            this.f1487b = c0695x;
        }

        /* renamed from: a */
        protected Void m1836a(Void... voidArr) {
            String a;
            StringBuilder stringBuilder;
            Map hashMap = new HashMap();
            hashMap.putAll(C0723p.m1949a(this.f1487b.f1489b));
            if (this.f1487b.f1490c != null) {
                hashMap.put("oneSignalUserId", this.f1487b.f1490c);
                if (this.f1487b.f1491d != null) {
                    hashMap.put("oneSignalRegistrationId", this.f1487b.f1491d);
                }
                hashMap.put("oneSignalSubscribed", this.f1487b.f1492e);
                hashMap.put("oneSignalRequiresUserPrivacyConsent", Boolean.valueOf(sa.m1626K() ^ true));
            }
            if (this.f1487b.f1493f != null) {
                Iterator keys = this.f1487b.f1493f.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("customData_");
                    stringBuilder2.append(str);
                    hashMap.put(stringBuilder2.toString(), this.f1487b.f1493f.opt(str));
                }
            }
            try {
                JSONObject jSONObject = new JSONObject(hashMap);
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f1486a.f1483a).openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("Content-Type", "application/json");
                httpURLConnection.setDoOutput(true);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8");
                outputStreamWriter.write(jSONObject.toString());
                outputStreamWriter.close();
                httpURLConnection.connect();
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode < 200 || responseCode > 299) {
                    a = C0695X.f1488a;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Recevied status code ");
                    stringBuilder.append(responseCode);
                    stringBuilder.append(" when posting to ");
                    stringBuilder.append(this.f1486a.f1483a);
                    Log.w(a, stringBuilder.toString());
                }
            } catch (Throwable e) {
                a = C0695X.f1488a;
                stringBuilder = new StringBuilder();
                stringBuilder.append("Error posting to ");
                stringBuilder.append(this.f1486a.f1483a);
                Log.e(a, stringBuilder.toString(), e);
            }
            return null;
        }

        protected /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
            return m1836a((Void[]) objArr);
        }
    }

    C0695X(Context context) {
        this.f1489b = context;
        this.f1495h = new LinkedList();
    }

    /* renamed from: c */
    private void m1841c() {
        for (C0693a c0693a : this.f1495h) {
            String str = this.f1494g;
            if (str != null && C0726s.m1972a(str, c0693a.f1484b)) {
                c0693a.m1835a();
            }
        }
    }

    /* renamed from: a */
    public void m1844a(String str) {
        this.f1494g = str;
        for (C0693a c0693a : this.f1495h) {
            if (C0726s.m1972a(str, c0693a.f1484b)) {
                c0693a.m1835a();
            }
        }
    }

    /* renamed from: a */
    public void m1845a(String str, String str2, Boolean bool) {
        this.f1490c = str;
        this.f1491d = str2;
        this.f1492e = bool;
        m1841c();
    }

    /* renamed from: a */
    public void m1846a(JSONArray jSONArray) {
        this.f1495h.clear();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    String a = C0726s.m1968a(optJSONObject, "url");
                    if (a == null) {
                        Log.w(f1488a, "Invalid registration: endpoint url is null");
                    } else {
                        this.f1495h.add(new C0693a(this, a, C0726s.m1969a(optJSONObject.opt("urlRegex"))));
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public void m1847a(JSONObject jSONObject) {
        this.f1493f = jSONObject;
        m1841c();
    }

    /* renamed from: b */
    public void m1848b() {
        for (C0693a a : this.f1495h) {
            a.m1835a();
        }
    }
}
