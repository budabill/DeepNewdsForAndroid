package com.facebook;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Pair;
import com.facebook.C0330C.C0329a;
import com.facebook.C0330C.C0816b;
import com.facebook.internal.C0458D;
import com.facebook.internal.C0461G;
import com.facebook.internal.C0470M;
import com.facebook.internal.C0475Q;
import com.facebook.internal.C0476S;
import java.io.BufferedOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GraphRequest {
    /* renamed from: a */
    public static final String f478a = "GraphRequest";
    /* renamed from: b */
    private static final String f479b;
    /* renamed from: c */
    private static String f480c;
    /* renamed from: d */
    private static Pattern f481d = Pattern.compile("^/?v\\d+\\.\\d+/(.*)");
    /* renamed from: e */
    private static volatile String f482e;
    /* renamed from: f */
    private AccessToken f483f;
    /* renamed from: g */
    private C0332E f484g;
    /* renamed from: h */
    private String f485h;
    /* renamed from: i */
    private JSONObject f486i;
    /* renamed from: j */
    private String f487j;
    /* renamed from: k */
    private String f488k;
    /* renamed from: l */
    private boolean f489l;
    /* renamed from: m */
    private Bundle f490m;
    /* renamed from: n */
    private C0338b f491n;
    /* renamed from: o */
    private String f492o;
    /* renamed from: p */
    private Object f493p;
    /* renamed from: q */
    private String f494q;
    /* renamed from: r */
    private boolean f495r;

    public static class ParcelableResourceWithMimeType<RESOURCE extends Parcelable> implements Parcelable {
        public static final Creator<ParcelableResourceWithMimeType> CREATOR = new C0326A();
        /* renamed from: a */
        private final String f474a;
        /* renamed from: b */
        private final RESOURCE f475b;

        private ParcelableResourceWithMimeType(Parcel parcel) {
            this.f474a = parcel.readString();
            this.f475b = parcel.readParcelable(C0560t.m1252d().getClassLoader());
        }

        public ParcelableResourceWithMimeType(RESOURCE resource, String str) {
            this.f474a = str;
            this.f475b = resource;
        }

        /* renamed from: a */
        public String m505a() {
            return this.f474a;
        }

        /* renamed from: b */
        public RESOURCE m506b() {
            return this.f475b;
        }

        public int describeContents() {
            return 1;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f474a);
            parcel.writeParcelable(this.f475b, i);
        }
    }

    /* renamed from: com.facebook.GraphRequest$a */
    private static class C0337a {
        /* renamed from: a */
        private final GraphRequest f476a;
        /* renamed from: b */
        private final Object f477b;

        public C0337a(GraphRequest graphRequest, Object obj) {
            this.f476a = graphRequest;
            this.f477b = obj;
        }

        /* renamed from: a */
        public GraphRequest m507a() {
            return this.f476a;
        }

        /* renamed from: b */
        public Object m508b() {
            return this.f477b;
        }
    }

    /* renamed from: com.facebook.GraphRequest$b */
    public interface C0338b {
        /* renamed from: a */
        void mo949a(C0331D c0331d);
    }

    /* renamed from: com.facebook.GraphRequest$c */
    private interface C0339c {
        /* renamed from: a */
        void mo945a(String str, String str2);
    }

    /* renamed from: com.facebook.GraphRequest$d */
    public interface C0817d extends C0338b {
        /* renamed from: a */
        void m2112a(long j, long j2);
    }

    /* renamed from: com.facebook.GraphRequest$e */
    private static class C0818e implements C0339c {
        /* renamed from: a */
        private final OutputStream f1733a;
        /* renamed from: b */
        private final C0461G f1734b;
        /* renamed from: c */
        private boolean f1735c = true;
        /* renamed from: d */
        private boolean f1736d = false;

        public C0818e(OutputStream outputStream, C0461G c0461g, boolean z) {
            this.f1733a = outputStream;
            this.f1734b = c0461g;
            this.f1736d = z;
        }

        /* renamed from: b */
        private RuntimeException m2113b() {
            return new IllegalArgumentException("value is not a supported type.");
        }

        /* renamed from: a */
        public void m2114a() {
            if (this.f1736d) {
                this.f1733a.write("&".getBytes());
                return;
            }
            m2124b("--%s", GraphRequest.f479b);
        }

        /* renamed from: a */
        public void m2115a(String str, Bitmap bitmap) {
            m2120a(str, str, "image/png");
            bitmap.compress(CompressFormat.PNG, 100, this.f1733a);
            m2124b("", new Object[0]);
            m2114a();
            C0461G c0461g = this.f1734b;
            if (c0461g != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("    ");
                stringBuilder.append(str);
                c0461g.m899a(stringBuilder.toString(), (Object) "<Image>");
            }
        }

        /* renamed from: a */
        public void m2116a(String str, Uri uri, String str2) {
            int i;
            if (str2 == null) {
                str2 = "content/unknown";
            }
            m2120a(str, str, str2);
            if (this.f1733a instanceof C0820L) {
                ((C0820L) this.f1733a).m2128a(C0475Q.m958a(uri));
                i = 0;
            } else {
                i = C0475Q.m956a(C0560t.m1252d().getContentResolver().openInputStream(uri), this.f1733a) + 0;
            }
            m2124b("", new Object[0]);
            m2114a();
            C0461G c0461g = this.f1734b;
            if (c0461g != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("    ");
                stringBuilder.append(str);
                c0461g.m899a(stringBuilder.toString(), String.format(Locale.ROOT, "<Data: %d>", new Object[]{Integer.valueOf(i)}));
            }
        }

        /* renamed from: a */
        public void m2117a(String str, ParcelFileDescriptor parcelFileDescriptor, String str2) {
            int i;
            if (str2 == null) {
                str2 = "content/unknown";
            }
            m2120a(str, str, str2);
            OutputStream outputStream = this.f1733a;
            if (outputStream instanceof C0820L) {
                ((C0820L) outputStream).m2128a(parcelFileDescriptor.getStatSize());
                i = 0;
            } else {
                i = C0475Q.m956a(new AutoCloseInputStream(parcelFileDescriptor), this.f1733a) + 0;
            }
            m2124b("", new Object[0]);
            m2114a();
            C0461G c0461g = this.f1734b;
            if (c0461g != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("    ");
                stringBuilder.append(str);
                c0461g.m899a(stringBuilder.toString(), String.format(Locale.ROOT, "<Data: %d>", new Object[]{Integer.valueOf(i)}));
            }
        }

        /* renamed from: a */
        public void m2118a(String str, Object obj, GraphRequest graphRequest) {
            OutputStream outputStream = this.f1733a;
            if (outputStream instanceof C0344O) {
                ((C0344O) outputStream).mo948a(graphRequest);
            }
            if (GraphRequest.m542e(obj)) {
                mo945a(str, GraphRequest.m543f(obj));
            } else if (obj instanceof Bitmap) {
                m2115a(str, (Bitmap) obj);
            } else if (obj instanceof byte[]) {
                m2122a(str, (byte[]) obj);
            } else if (obj instanceof Uri) {
                m2116a(str, (Uri) obj, null);
            } else if (obj instanceof ParcelFileDescriptor) {
                m2117a(str, (ParcelFileDescriptor) obj, null);
            } else if (obj instanceof ParcelableResourceWithMimeType) {
                ParcelableResourceWithMimeType parcelableResourceWithMimeType = (ParcelableResourceWithMimeType) obj;
                Parcelable b = parcelableResourceWithMimeType.m506b();
                String a = parcelableResourceWithMimeType.m505a();
                if (b instanceof ParcelFileDescriptor) {
                    m2117a(str, (ParcelFileDescriptor) b, a);
                } else if (b instanceof Uri) {
                    m2116a(str, (Uri) b, a);
                } else {
                    throw m2113b();
                }
            } else {
                throw m2113b();
            }
        }

        /* renamed from: a */
        public void mo945a(String str, String str2) {
            m2120a(str, null, null);
            m2124b("%s", str2);
            m2114a();
            C0461G c0461g = this.f1734b;
            if (c0461g != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("    ");
                stringBuilder.append(str);
                c0461g.m899a(stringBuilder.toString(), (Object) str2);
            }
        }

        /* renamed from: a */
        public void m2120a(String str, String str2, String str3) {
            if (this.f1736d) {
                this.f1733a.write(String.format("%s=", new Object[]{str}).getBytes());
                return;
            }
            m2123a("Content-Disposition: form-data; name=\"%s\"", str);
            if (str2 != null) {
                m2123a("; filename=\"%s\"", str2);
            }
            str2 = "";
            m2124b(str2, new Object[0]);
            if (str3 != null) {
                m2124b("%s: %s", "Content-Type", str3);
            }
            m2124b(str2, new Object[0]);
        }

        /* renamed from: a */
        public void m2121a(String str, JSONArray jSONArray, Collection<GraphRequest> collection) {
            OutputStream outputStream = this.f1733a;
            if (outputStream instanceof C0344O) {
                C0344O c0344o = (C0344O) outputStream;
                m2120a(str, null, null);
                m2123a("[", new Object[0]);
                int i = 0;
                for (GraphRequest graphRequest : collection) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    c0344o.mo948a(graphRequest);
                    if (i > 0) {
                        m2123a(",%s", jSONObject.toString());
                    } else {
                        m2123a("%s", jSONObject.toString());
                    }
                    i++;
                }
                m2123a("]", new Object[0]);
                C0461G c0461g = this.f1734b;
                if (c0461g != null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("    ");
                    stringBuilder.append(str);
                    c0461g.m899a(stringBuilder.toString(), jSONArray.toString());
                }
                return;
            }
            mo945a(str, jSONArray.toString());
        }

        /* renamed from: a */
        public void m2122a(String str, byte[] bArr) {
            m2120a(str, str, "content/unknown");
            this.f1733a.write(bArr);
            m2124b("", new Object[0]);
            m2114a();
            C0461G c0461g = this.f1734b;
            if (c0461g != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("    ");
                stringBuilder.append(str);
                c0461g.m899a(stringBuilder.toString(), String.format(Locale.ROOT, "<Data: %d>", new Object[]{Integer.valueOf(bArr.length)}));
            }
        }

        /* renamed from: a */
        public void m2123a(String str, Object... objArr) {
            if (this.f1736d) {
                this.f1733a.write(URLEncoder.encode(String.format(Locale.US, str, objArr), "UTF-8").getBytes());
                return;
            }
            if (this.f1735c) {
                this.f1733a.write("--".getBytes());
                this.f1733a.write(GraphRequest.f479b.getBytes());
                this.f1733a.write("\r\n".getBytes());
                this.f1735c = false;
            }
            this.f1733a.write(String.format(str, objArr).getBytes());
        }

        /* renamed from: b */
        public void m2124b(String str, Object... objArr) {
            m2123a(str, objArr);
            if (!this.f1736d) {
                m2123a("\r\n", new Object[0]);
            }
        }
    }

    static {
        char[] toCharArray = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        int nextInt = secureRandom.nextInt(11) + 30;
        for (int i = 0; i < nextInt; i++) {
            stringBuilder.append(toCharArray[secureRandom.nextInt(toCharArray.length)]);
        }
        f479b = stringBuilder.toString();
    }

    public GraphRequest() {
        this(null, null, null, null, null);
    }

    public GraphRequest(AccessToken accessToken, String str, Bundle bundle, C0332E c0332e, C0338b c0338b) {
        this(accessToken, str, bundle, c0332e, c0338b, null);
    }

    public GraphRequest(AccessToken accessToken, String str, Bundle bundle, C0332E c0332e, C0338b c0338b, String str2) {
        this.f489l = true;
        this.f495r = false;
        this.f483f = accessToken;
        this.f485h = str;
        this.f494q = str2;
        m552a(c0338b);
        m551a(c0332e);
        this.f490m = bundle != null ? new Bundle(bundle) : new Bundle();
        if (this.f494q == null) {
            this.f494q = C0560t.m1260l();
        }
    }

    /* renamed from: a */
    public static C0331D m511a(GraphRequest graphRequest) {
        List a = m520a(graphRequest);
        if (a != null && a.size() == 1) {
            return (C0331D) a.get(0);
        }
        throw new C0506l("invalid state: expected a single response");
    }

    /* renamed from: a */
    public static GraphRequest m512a(AccessToken accessToken, String str, C0338b c0338b) {
        return new GraphRequest(accessToken, str, null, null, c0338b);
    }

    /* renamed from: a */
    public static GraphRequest m513a(AccessToken accessToken, String str, JSONObject jSONObject, C0338b c0338b) {
        GraphRequest graphRequest = new GraphRequest(accessToken, str, null, C0332E.POST, c0338b);
        graphRequest.m553a(jSONObject);
        return graphRequest;
    }

    /* renamed from: a */
    private String m515a(String str, Boolean bool) {
        if (!bool.booleanValue() && this.f484g == C0332E.POST) {
            return str;
        }
        Builder buildUpon = Uri.parse(str).buildUpon();
        for (String str2 : this.f490m.keySet()) {
            Object obj = this.f490m.get(str2);
            if (obj == null) {
                obj = "";
            }
            if (m542e(obj)) {
                buildUpon.appendQueryParameter(str2, m543f(obj).toString());
            } else if (this.f484g == C0332E.GET) {
                throw new IllegalArgumentException(String.format(Locale.US, "Unsupported parameter type for GET request: %s", new Object[]{obj.getClass().getSimpleName()}));
            }
        }
        return buildUpon.toString();
    }

    /* renamed from: a */
    private static HttpURLConnection m516a(URL url) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestProperty("User-Agent", m549q());
        httpURLConnection.setRequestProperty("Accept-Language", Locale.getDefault().toString());
        httpURLConnection.setChunkedStreamingMode(0);
        return httpURLConnection;
    }

    /* renamed from: a */
    public static List<C0331D> m517a(C0330C c0330c) {
        C0476S.m1024c(c0330c, "requests");
        URLConnection uRLConnection = null;
        try {
            uRLConnection = m538c(c0330c);
            List<C0331D> a = m518a((HttpURLConnection) uRLConnection, c0330c);
            return a;
        } catch (Exception e) {
            Throwable e2 = e;
            List<C0331D> a2 = C0331D.m485a(c0330c.m476i(), (HttpURLConnection) uRLConnection, new C0506l(e2));
            m524a(c0330c, (List) a2);
            return a2;
        } finally {
            C0475Q.m986a(uRLConnection);
        }
    }

    /* renamed from: a */
    public static List<C0331D> m518a(HttpURLConnection httpURLConnection, C0330C c0330c) {
        List a = C0331D.m483a(httpURLConnection, c0330c);
        C0475Q.m986a((URLConnection) httpURLConnection);
        if (c0330c.size() == a.size()) {
            m524a(c0330c, a);
            C0450g.m858d().m864b();
            return a;
        }
        throw new C0506l(String.format(Locale.US, "Received %d responses while expecting %d", new Object[]{Integer.valueOf(a.size()), Integer.valueOf(r4)}));
    }

    /* renamed from: a */
    public static List<C0331D> m519a(Collection<GraphRequest> collection) {
        return m517a(new C0330C((Collection) collection));
    }

    /* renamed from: a */
    public static List<C0331D> m520a(GraphRequest... graphRequestArr) {
        C0476S.m1016a((Object) graphRequestArr, "requests");
        return m519a(Arrays.asList(graphRequestArr));
    }

    /* renamed from: a */
    private static void m521a(Bundle bundle, C0818e c0818e, GraphRequest graphRequest) {
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (m542e(obj)) {
                c0818e.m2118a(str, obj, graphRequest);
            }
        }
    }

    /* renamed from: a */
    private static void m522a(C0330C c0330c, C0461G c0461g, int i, URL url, OutputStream outputStream, boolean z) {
        C0818e c0818e = new C0818e(outputStream, c0461g, z);
        String str = "  Attachments:\n";
        Map hashMap;
        if (i == 1) {
            GraphRequest graphRequest = c0330c.get(0);
            hashMap = new HashMap();
            for (String str2 : graphRequest.f490m.keySet()) {
                Object obj = graphRequest.f490m.get(str2);
                if (m540d(obj)) {
                    hashMap.put(str2, new C0337a(graphRequest, obj));
                }
            }
            if (c0461g != null) {
                c0461g.m898a("  Parameters:\n");
            }
            m521a(graphRequest.f490m, c0818e, graphRequest);
            if (c0461g != null) {
                c0461g.m898a(str);
            }
            m528a(hashMap, c0818e);
            JSONObject jSONObject = graphRequest.f486i;
            if (jSONObject != null) {
                m530a(jSONObject, url.getPath(), (C0339c) c0818e);
                return;
            }
            return;
        }
        String e = m541e(c0330c);
        if (C0475Q.m998b(e)) {
            throw new C0506l("App ID was not specified at the request or Settings.");
        }
        c0818e.mo945a("batch_app_id", e);
        hashMap = new HashMap();
        m525a(c0818e, (Collection) c0330c, hashMap);
        if (c0461g != null) {
            c0461g.m898a(str);
        }
        m528a(hashMap, c0818e);
    }

    /* renamed from: a */
    static final void m523a(C0330C c0330c, HttpURLConnection httpURLConnection) {
        FilterOutputStream gZIPOutputStream;
        Throwable th;
        C0461G c0461g = new C0461G(C0336G.REQUESTS, "Request");
        int size = c0330c.size();
        boolean g = m545g(c0330c);
        int i = 0;
        Enum enumR = size == 1 ? c0330c.get(0).f484g : C0332E.POST;
        httpURLConnection.setRequestMethod(enumR.name());
        m527a(httpURLConnection, g);
        URL url = httpURLConnection.getURL();
        c0461g.m898a("Request:\n");
        c0461g.m899a("Id", c0330c.m475h());
        c0461g.m899a("URL", (Object) url);
        c0461g.m899a("Method", httpURLConnection.getRequestMethod());
        String str = "User-Agent";
        c0461g.m899a(str, httpURLConnection.getRequestProperty(str));
        str = "Content-Type";
        c0461g.m899a(str, httpURLConnection.getRequestProperty(str));
        httpURLConnection.setConnectTimeout(c0330c.m477j());
        httpURLConnection.setReadTimeout(c0330c.m477j());
        if (enumR == C0332E.POST) {
            i = 1;
        }
        if (i == 0) {
            c0461g.m897a();
            return;
        }
        httpURLConnection.setDoOutput(true);
        try {
            OutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
            if (g) {
                try {
                    gZIPOutputStream = new GZIPOutputStream(bufferedOutputStream);
                } catch (Throwable th2) {
                    th = th2;
                    gZIPOutputStream = bufferedOutputStream;
                    if (gZIPOutputStream != null) {
                        gZIPOutputStream.close();
                    }
                    throw th;
                }
            }
            gZIPOutputStream = bufferedOutputStream;
            try {
                OutputStream c0821n;
                if (m544f(c0330c)) {
                    OutputStream c0820l = new C0820L(c0330c.m473f());
                    m522a(c0330c, null, size, url, c0820l, g);
                    c0821n = new C0821N(gZIPOutputStream, c0330c, c0820l.m2130b(), (long) c0820l.m2127a());
                }
                m522a(c0330c, c0461g, size, url, c0821n, g);
                c0821n.close();
                c0461g.m897a();
            } catch (Throwable th3) {
                th = th3;
                if (gZIPOutputStream != null) {
                    gZIPOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            gZIPOutputStream = null;
            if (gZIPOutputStream != null) {
                gZIPOutputStream.close();
            }
            throw th;
        }
    }

    /* renamed from: a */
    static void m524a(C0330C c0330c, List<C0331D> list) {
        int size = c0330c.size();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < size; i++) {
            C0338b c0338b = c0330c.get(i).f491n;
            if (c0338b != null) {
                arrayList.add(new Pair(c0338b, list.get(i)));
            }
        }
        if (arrayList.size() > 0) {
            Runnable c0561y = new C0561y(arrayList, c0330c);
            Handler f = c0330c.m473f();
            if (f == null) {
                c0561y.run();
            } else {
                f.post(c0561y);
            }
        }
    }

    /* renamed from: a */
    private static void m525a(C0818e c0818e, Collection<GraphRequest> collection, Map<String, C0337a> map) {
        JSONArray jSONArray = new JSONArray();
        for (GraphRequest a : collection) {
            a.m529a(jSONArray, (Map) map);
        }
        c0818e.m2121a("batch", jSONArray, (Collection) collection);
    }

    /* renamed from: a */
    private static void m526a(String str, Object obj, C0339c c0339c, boolean z) {
        Class cls = obj.getClass();
        if (JSONObject.class.isAssignableFrom(cls)) {
            JSONObject jSONObject = (JSONObject) obj;
            if (z) {
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    Object[] objArr = new Object[]{str, (String) keys.next()};
                    m526a(String.format("%s[%s]", objArr), jSONObject.opt((String) keys.next()), c0339c, z);
                }
                return;
            }
            String str2 = "id";
            if (!jSONObject.has(str2)) {
                str2 = "url";
                if (!jSONObject.has(str2)) {
                    if (jSONObject.has("fbsdk:create_object")) {
                        obj = jSONObject.toString();
                        m526a(str, obj, c0339c, z);
                    }
                    return;
                }
            }
            obj = jSONObject.optString(str2);
            m526a(str, obj, c0339c, z);
        } else if (JSONArray.class.isAssignableFrom(cls)) {
            JSONArray jSONArray = (JSONArray) obj;
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                m526a(String.format(Locale.ROOT, "%s[%d]", new Object[]{str, Integer.valueOf(i)}), jSONArray.opt(i), c0339c, z);
            }
        } else {
            String format;
            if (!(String.class.isAssignableFrom(cls) || Number.class.isAssignableFrom(cls))) {
                if (!Boolean.class.isAssignableFrom(cls)) {
                    if (Date.class.isAssignableFrom(cls)) {
                        format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format((Date) obj);
                        c0339c.mo945a(str, format);
                    }
                    return;
                }
            }
            format = obj.toString();
            c0339c.mo945a(str, format);
        }
    }

    /* renamed from: a */
    private static void m527a(HttpURLConnection httpURLConnection, boolean z) {
        String str = "Content-Type";
        if (z) {
            httpURLConnection.setRequestProperty(str, "application/x-www-form-urlencoded");
            httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
            return;
        }
        httpURLConnection.setRequestProperty(str, m548p());
    }

    /* renamed from: a */
    private static void m528a(Map<String, C0337a> map, C0818e c0818e) {
        for (String str : map.keySet()) {
            C0337a c0337a = (C0337a) map.get(str);
            if (m540d(c0337a.m508b())) {
                c0818e.m2118a(str, c0337a.m508b(), c0337a.m507a());
            }
        }
    }

    /* renamed from: a */
    private void m529a(JSONArray jSONArray, Map<String, C0337a> map) {
        JSONObject jSONObject = new JSONObject();
        String str = this.f487j;
        if (str != null) {
            jSONObject.put("name", str);
            jSONObject.put("omit_response_on_success", this.f489l);
        }
        str = this.f488k;
        if (str != null) {
            jSONObject.put("depends_on", str);
        }
        str = m564j();
        jSONObject.put("relative_url", str);
        jSONObject.put("method", this.f484g);
        AccessToken accessToken = this.f483f;
        if (accessToken != null) {
            C0461G.m895c(accessToken.m456j());
        }
        Iterable arrayList = new ArrayList();
        for (String str2 : this.f490m.keySet()) {
            Object obj = this.f490m.get(str2);
            if (m540d(obj)) {
                String format = String.format(Locale.ROOT, "%s%d", new Object[]{"file", Integer.valueOf(map.size())});
                arrayList.add(format);
                map.put(format, new C0337a(this, obj));
            }
        }
        if (!arrayList.isEmpty()) {
            jSONObject.put("attached_files", TextUtils.join(",", arrayList));
        }
        if (this.f486i != null) {
            Iterable arrayList2 = new ArrayList();
            m530a(this.f486i, str, new C0868z(this, arrayList2));
            jSONObject.put("body", TextUtils.join("&", arrayList2));
        }
        jSONArray.put(jSONObject);
    }

    /* renamed from: a */
    private static void m530a(JSONObject jSONObject, String str, C0339c c0339c) {
        Object obj;
        Iterator keys;
        if (m532a(str)) {
            int indexOf = str.indexOf(":");
            int indexOf2 = str.indexOf("?");
            if (indexOf > 3 && (indexOf2 == -1 || indexOf < indexOf2)) {
                obj = 1;
                keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    Object opt = jSONObject.opt(str2);
                    boolean z = obj == null && str2.equalsIgnoreCase("image");
                    m526a(str2, opt, c0339c, z);
                }
            }
        }
        obj = null;
        keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str22 = (String) keys.next();
            Object opt2 = jSONObject.opt(str22);
            if (obj == null) {
            }
            m526a(str22, opt2, c0339c, z);
        }
    }

    /* renamed from: a */
    private static boolean m532a(String str) {
        Matcher matcher = f481d.matcher(str);
        if (matcher.matches()) {
            str = matcher.group(1);
        }
        if (!str.startsWith("me/")) {
            if (!str.startsWith("/me/")) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public static C0328B m533b(C0330C c0330c) {
        C0476S.m1024c(c0330c, "requests");
        AsyncTask c0328b = new C0328B(c0330c);
        c0328b.executeOnExecutor(C0560t.m1258j(), new Void[0]);
        return c0328b;
    }

    /* renamed from: b */
    public static C0328B m534b(Collection<GraphRequest> collection) {
        return m533b(new C0330C((Collection) collection));
    }

    /* renamed from: b */
    public static C0328B m535b(GraphRequest... graphRequestArr) {
        C0476S.m1016a((Object) graphRequestArr, "requests");
        return m534b(Arrays.asList(graphRequestArr));
    }

    /* renamed from: b */
    static final boolean m537b(GraphRequest graphRequest) {
        String m = graphRequest.m567m();
        boolean z = true;
        if (C0475Q.m998b(m)) {
            return true;
        }
        if (m.startsWith("v")) {
            m = m.substring(1);
        }
        String[] split = m.split("\\.");
        if (split.length < 2 || Integer.parseInt(split[0]) <= 2) {
            if (Integer.parseInt(split[0]) < 2 || Integer.parseInt(split[1]) < 4) {
                z = false;
            }
        }
        return z;
    }

    /* renamed from: c */
    public static HttpURLConnection m538c(C0330C c0330c) {
        Throwable e;
        m539d(c0330c);
        try {
            URLConnection uRLConnection = null;
            try {
                uRLConnection = m516a(c0330c.size() == 1 ? new URL(c0330c.get(0).m566l()) : new URL(C0470M.m948c()));
                m523a(c0330c, (HttpURLConnection) uRLConnection);
                return uRLConnection;
            } catch (IOException e2) {
                e = e2;
                C0475Q.m986a(uRLConnection);
                throw new C0506l("could not construct request body", e);
            } catch (JSONException e3) {
                e = e3;
                C0475Q.m986a(uRLConnection);
                throw new C0506l("could not construct request body", e);
            }
        } catch (Throwable e4) {
            throw new C0506l("could not construct URL for request", e4);
        }
    }

    /* renamed from: d */
    static final void m539d(C0330C c0330c) {
        Iterator it = c0330c.iterator();
        while (it.hasNext()) {
            GraphRequest graphRequest = (GraphRequest) it.next();
            if (C0332E.GET.equals(graphRequest.m562h()) && m537b(graphRequest)) {
                Bundle i = graphRequest.m563i();
                String str = "fields";
                if (!i.containsKey(str) || C0475Q.m998b(i.getString(str))) {
                    C0461G.m890a(C0336G.DEVELOPER_ERRORS, 5, "Request", "starting with Graph API v2.4, GET requests for /%s should contain an explicit \"fields\" parameter.", graphRequest.m561g());
                }
            }
        }
    }

    /* renamed from: d */
    private static boolean m540d(Object obj) {
        if (!((obj instanceof Bitmap) || (obj instanceof byte[]) || (obj instanceof Uri) || (obj instanceof ParcelFileDescriptor))) {
            if (!(obj instanceof ParcelableResourceWithMimeType)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: e */
    private static String m541e(C0330C c0330c) {
        if (!C0475Q.m998b(c0330c.m472e())) {
            return c0330c.m472e();
        }
        Iterator it = c0330c.iterator();
        while (it.hasNext()) {
            AccessToken accessToken = ((GraphRequest) it.next()).f483f;
            if (accessToken != null) {
                String b = accessToken.m449b();
                if (b != null) {
                    return b;
                }
            }
        }
        return !C0475Q.m998b(f480c) ? f480c : C0560t.m1253e();
    }

    /* renamed from: e */
    private static boolean m542e(Object obj) {
        if (!((obj instanceof String) || (obj instanceof Boolean) || (obj instanceof Number))) {
            if (!(obj instanceof Date)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: f */
    private static String m543f(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (!(obj instanceof Boolean)) {
            if (!(obj instanceof Number)) {
                if (obj instanceof Date) {
                    return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format(obj);
                }
                throw new IllegalArgumentException("Unsupported parameter type.");
            }
        }
        return obj.toString();
    }

    /* renamed from: f */
    private static boolean m544f(C0330C c0330c) {
        for (C0329a c0329a : c0330c.m474g()) {
            if (c0329a instanceof C0816b) {
                return true;
            }
        }
        Iterator it = c0330c.iterator();
        while (it.hasNext()) {
            if (((GraphRequest) it.next()).m559e() instanceof C0817d) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: g */
    private static boolean m545g(C0330C c0330c) {
        Iterator it = c0330c.iterator();
        while (it.hasNext()) {
            GraphRequest graphRequest = (GraphRequest) it.next();
            for (String str : graphRequest.f490m.keySet()) {
                if (m540d(graphRequest.f490m.get(str))) {
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: n */
    private void m546n() {
        String j;
        Bundle bundle;
        String str;
        String str2 = "access_token";
        if (this.f483f != null) {
            if (!this.f490m.containsKey(str2)) {
                j = this.f483f.m456j();
                C0461G.m895c(j);
            }
            this.f490m.putString("sdk", "android");
            this.f490m.putString("format", "json");
            str2 = "debug";
            if (!C0560t.m1246a(C0336G.GRAPH_API_DEBUG_INFO)) {
                bundle = this.f490m;
                str = "info";
            } else if (!C0560t.m1246a(C0336G.GRAPH_API_DEBUG_WARNING)) {
                bundle = this.f490m;
                str = "warning";
            } else {
                return;
            }
            bundle.putString(str2, str);
        }
        if (!(this.f495r || this.f490m.containsKey(str2))) {
            j = C0560t.m1253e();
            str = C0560t.m1256h();
            if (C0475Q.m998b(j) || C0475Q.m998b(str)) {
                C0475Q.m984a(f478a, "Warning: Request without access token missing application ID or client token.");
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(j);
                stringBuilder.append("|");
                stringBuilder.append(str);
                j = stringBuilder.toString();
            }
        }
        this.f490m.putString("sdk", "android");
        this.f490m.putString("format", "json");
        str2 = "debug";
        if (!C0560t.m1246a(C0336G.GRAPH_API_DEBUG_INFO)) {
            bundle = this.f490m;
            str = "info";
        } else if (!C0560t.m1246a(C0336G.GRAPH_API_DEBUG_WARNING)) {
            bundle = this.f490m;
            str = "warning";
        } else {
            return;
        }
        bundle.putString(str2, str);
        this.f490m.putString(str2, j);
        this.f490m.putString("sdk", "android");
        this.f490m.putString("format", "json");
        str2 = "debug";
        if (!C0560t.m1246a(C0336G.GRAPH_API_DEBUG_INFO)) {
            bundle = this.f490m;
            str = "info";
        } else if (!C0560t.m1246a(C0336G.GRAPH_API_DEBUG_WARNING)) {
            bundle = this.f490m;
            str = "warning";
        } else {
            return;
        }
        bundle.putString(str2, str);
    }

    /* renamed from: o */
    private String m547o() {
        if (f481d.matcher(this.f485h).matches()) {
            return this.f485h;
        }
        return String.format("%s/%s", new Object[]{this.f494q, this.f485h});
    }

    /* renamed from: p */
    private static String m548p() {
        return String.format("multipart/form-data; boundary=%s", new Object[]{f479b});
    }

    /* renamed from: q */
    private static String m549q() {
        if (f482e == null) {
            f482e = String.format("%s.%s", new Object[]{"FBAndroidSDK", "4.39.0"});
            if (!C0475Q.m998b(C0458D.m885a())) {
                f482e = String.format(Locale.ROOT, "%s/%s", new Object[]{f482e, r1});
            }
        }
        return f482e;
    }

    /* renamed from: a */
    public final void m550a(Bundle bundle) {
        this.f490m = bundle;
    }

    /* renamed from: a */
    public final void m551a(C0332E c0332e) {
        if (this.f492o != null) {
            if (c0332e != C0332E.GET) {
                throw new C0506l("Can't change HTTP method on request with overridden URL.");
            }
        }
        if (c0332e == null) {
            c0332e = C0332E.GET;
        }
        this.f484g = c0332e;
    }

    /* renamed from: a */
    public final void m552a(C0338b c0338b) {
        if (!C0560t.m1246a(C0336G.GRAPH_API_DEBUG_INFO)) {
            if (!C0560t.m1246a(C0336G.GRAPH_API_DEBUG_WARNING)) {
                this.f491n = c0338b;
                return;
            }
        }
        this.f491n = new C0867x(this, c0338b);
    }

    /* renamed from: a */
    public final void m553a(JSONObject jSONObject) {
        this.f486i = jSONObject;
    }

    /* renamed from: a */
    public final void m554a(boolean z) {
        this.f495r = z;
    }

    /* renamed from: b */
    public final C0331D m555b() {
        return m511a(this);
    }

    /* renamed from: c */
    public final C0328B m556c() {
        return m535b(this);
    }

    /* renamed from: c */
    public final void m557c(Object obj) {
        this.f493p = obj;
    }

    /* renamed from: d */
    public final AccessToken m558d() {
        return this.f483f;
    }

    /* renamed from: e */
    public final C0338b m559e() {
        return this.f491n;
    }

    /* renamed from: f */
    public final JSONObject m560f() {
        return this.f486i;
    }

    /* renamed from: g */
    public final String m561g() {
        return this.f485h;
    }

    /* renamed from: h */
    public final C0332E m562h() {
        return this.f484g;
    }

    /* renamed from: i */
    public final Bundle m563i() {
        return this.f490m;
    }

    /* renamed from: j */
    final String m564j() {
        if (this.f492o == null) {
            String format = String.format("%s/%s", new Object[]{C0470M.m948c(), m547o()});
            m546n();
            Uri parse = Uri.parse(m515a(format, Boolean.valueOf(true)));
            return String.format("%s?%s", new Object[]{parse.getPath(), parse.getQuery()});
        }
        throw new C0506l("Can't override URL for a batch request");
    }

    /* renamed from: k */
    public final Object m565k() {
        return this.f493p;
    }

    /* renamed from: l */
    final String m566l() {
        String str = this.f492o;
        if (str != null) {
            return str.toString();
        }
        if (m562h() == C0332E.POST) {
            str = this.f485h;
            if (str != null && str.endsWith("/videos")) {
                str = C0470M.m949d();
                str = String.format("%s/%s", new Object[]{str, m547o()});
                m546n();
                return m515a(str, Boolean.valueOf(false));
            }
        }
        str = C0470M.m948c();
        str = String.format("%s/%s", new Object[]{str, m547o()});
        m546n();
        return m515a(str, Boolean.valueOf(false));
    }

    /* renamed from: m */
    public final String m567m() {
        return this.f494q;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{Request: ");
        stringBuilder.append(" accessToken: ");
        Object obj = this.f483f;
        if (obj == null) {
            obj = "null";
        }
        stringBuilder.append(obj);
        stringBuilder.append(", graphPath: ");
        stringBuilder.append(this.f485h);
        stringBuilder.append(", graphObject: ");
        stringBuilder.append(this.f486i);
        stringBuilder.append(", httpMethod: ");
        stringBuilder.append(this.f484g);
        stringBuilder.append(", parameters: ");
        stringBuilder.append(this.f490m);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
