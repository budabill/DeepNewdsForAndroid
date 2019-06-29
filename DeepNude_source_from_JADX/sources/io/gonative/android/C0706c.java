package io.gonative.android;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import io.gonative.android.p038a.C0700a;
import java.io.OutputStreamWriter;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/* renamed from: io.gonative.android.c */
public class C0706c {
    /* renamed from: a */
    private static final String f1572a = "io.gonative.android.c";
    /* renamed from: b */
    private Context f1573b;

    /* renamed from: io.gonative.android.c$a */
    private static class C0705a extends AsyncTask<Void, Void, Void> {
        /* renamed from: a */
        WeakReference<Context> f1571a;

        C0705a(Context context) {
            this.f1571a = new WeakReference(context);
        }

        /* renamed from: a */
        protected Void m1914a(Void... voidArr) {
            Context context = (Context) this.f1571a.get();
            if (context == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(C0723p.m1949a(context));
            try {
                jSONObject.put(NotificationCompat.CATEGORY_EVENT, "launch");
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://events.gonative.io/api/events/new").openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setRequestProperty("Content-Type", "application/json");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(false);
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8");
                    outputStreamWriter.write(jSONObject.toString());
                    outputStreamWriter.close();
                    httpURLConnection.connect();
                    httpURLConnection.getResponseCode();
                    httpURLConnection.disconnect();
                } catch (Throwable e) {
                    Log.e(C0706c.f1572a, e.getMessage(), e);
                }
                return null;
            } catch (Throwable e2) {
                Log.e(C0706c.f1572a, e2.getMessage(), e2);
                return null;
            }
        }

        protected /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
            return m1914a((Void[]) objArr);
        }
    }

    C0706c(Context context) {
        this.f1573b = context;
    }

    /* renamed from: b */
    public void m1916b() {
        if (!C0700a.m1851a(this.f1573b).f1546r) {
            new C0705a(this.f1573b).execute(new Void[0]);
        }
    }
}
