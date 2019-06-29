package io.gonative.android;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import io.gonative.android.p038a.C0700a;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Observable;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* renamed from: io.gonative.android.u */
public class C0729u extends Observable {
    /* renamed from: a */
    private static final String f1652a = "io.gonative.android.u";
    /* renamed from: b */
    private Context f1653b;
    /* renamed from: c */
    private C0728a f1654c = null;
    /* renamed from: d */
    private boolean f1655d = false;

    /* renamed from: io.gonative.android.u$a */
    private static class C0728a extends AsyncTask<String, Void, String> {
        /* renamed from: a */
        private WeakReference<C0729u> f1651a;

        public C0728a(C0729u c0729u) {
            this.f1651a = new WeakReference(c0729u);
        }

        /* renamed from: a */
        protected String m1976a(String... strArr) {
            C0729u c0729u = (C0729u) this.f1651a.get();
            if (c0729u == null) {
                return null;
            }
            try {
                String url;
                URL url2 = new URL(strArr[0]);
                HttpURLConnection httpURLConnection = null;
                int i = 0;
                do {
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    httpURLConnection = (HttpURLConnection) url2.openConnection();
                    boolean z = true;
                    httpURLConnection.setInstanceFollowRedirects(true);
                    httpURLConnection.setRequestProperty("User-Agent", C0700a.m1851a(c0729u.f1653b).f1541m);
                    httpURLConnection.connect();
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode != 301) {
                        if (responseCode != 302) {
                            z = false;
                            if (!isCancelled() || !r5) {
                                url = httpURLConnection.getURL().toString();
                                httpURLConnection.disconnect();
                            }
                        }
                    }
                    i++;
                    url2 = new URL(url2, httpURLConnection.getHeaderField("Location"));
                    if (!isCancelled()) {
                        break;
                    }
                    break;
                } while (i < 10);
                url = httpURLConnection.getURL().toString();
                httpURLConnection.disconnect();
                return url;
            } catch (Throwable e) {
                Log.e(C0729u.f1652a, e.getMessage(), e);
                return null;
            }
        }

        /* renamed from: a */
        protected void m1977a(String str) {
            C0729u c0729u = (C0729u) this.f1651a.get();
            if (c0729u != null) {
                ka.m1932a().m1935a(str);
                if (str == null) {
                    c0729u.f1655d = false;
                    c0729u.setChanged();
                    c0729u.notifyObservers();
                    return;
                }
                C0700a a = C0700a.m1851a(c0729u.f1653b);
                List list = a.f1513I;
                for (int i = 0; i < list.size(); i++) {
                    if (((Pattern) list.get(i)).matcher(str).matches()) {
                        JSONObject jSONObject = (JSONObject) a.f1514J.get(i);
                        c0729u.f1655d = jSONObject.optBoolean("loggedIn", false);
                        if (C0700a.m1852a(jSONObject, "menuName") == null) {
                            boolean b = c0729u.f1655d;
                        }
                        c0729u.setChanged();
                        c0729u.notifyObservers();
                    }
                }
            }
        }

        protected /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
            return m1976a((String[]) objArr);
        }

        protected /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
            m1977a((String) obj);
        }
    }

    C0729u(Context context) {
        this.f1653b = context;
        m1984b();
    }

    /* renamed from: b */
    public void m1984b() {
        AsyncTask asyncTask = this.f1654c;
        if (asyncTask != null) {
            asyncTask.cancel(true);
        }
        if (C0700a.m1851a(this.f1653b).f1512H == null) {
            Log.w(f1652a, "Trying to detect login without a testURL");
            return;
        }
        this.f1654c = new C0728a(this);
        this.f1654c.execute(new String[]{C0700a.m1851a(this.f1653b).f1512H});
    }

    /* renamed from: c */
    public boolean m1985c() {
        return this.f1655d;
    }
}
