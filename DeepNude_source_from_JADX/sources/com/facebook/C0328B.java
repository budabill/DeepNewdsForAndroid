package com.facebook;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.facebook.internal.C0475Q;
import java.net.HttpURLConnection;
import java.util.List;

/* renamed from: com.facebook.B */
public class C0328B extends AsyncTask<Void, Void, List<C0331D>> {
    /* renamed from: a */
    private static final String f410a = "com.facebook.B";
    /* renamed from: b */
    private final HttpURLConnection f411b;
    /* renamed from: c */
    private final C0330C f412c;
    /* renamed from: d */
    private Exception f413d;

    public C0328B(C0330C c0330c) {
        this(null, c0330c);
    }

    public C0328B(HttpURLConnection httpURLConnection, C0330C c0330c) {
        this.f412c = c0330c;
        this.f411b = httpURLConnection;
    }

    /* renamed from: a */
    protected List<C0331D> m460a(Void... voidArr) {
        try {
            return this.f411b == null ? this.f412c.m463a() : GraphRequest.m518a(this.f411b, this.f412c);
        } catch (Exception e) {
            this.f413d = e;
            return null;
        }
    }

    /* renamed from: a */
    protected void m461a(List<C0331D> list) {
        super.onPostExecute(list);
        if (this.f413d != null) {
            C0475Q.m984a(f410a, String.format("onPostExecute: exception encountered during request: %s", new Object[]{r4.getMessage()}));
        }
    }

    protected /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
        return m460a((Void[]) objArr);
    }

    protected /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        m461a((List) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
        if (C0560t.m1263o()) {
            C0475Q.m984a(f410a, String.format("execute async task: %s", new Object[]{this}));
        }
        if (this.f412c.m473f() == null) {
            this.f412c.m465a(Thread.currentThread() instanceof HandlerThread ? new Handler() : new Handler(Looper.getMainLooper()));
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{RequestAsyncTask: ");
        stringBuilder.append(" connection: ");
        stringBuilder.append(this.f411b);
        stringBuilder.append(", requests: ");
        stringBuilder.append(this.f412c);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
