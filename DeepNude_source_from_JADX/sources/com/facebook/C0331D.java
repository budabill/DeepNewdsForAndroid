package com.facebook;

import android.util.Log;
import com.facebook.internal.C0461G;
import com.facebook.internal.C0475Q;
import java.io.Closeable;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

/* renamed from: com.facebook.D */
public class C0331D {
    /* renamed from: a */
    private static final String f430a = "D";
    /* renamed from: b */
    private final HttpURLConnection f431b;
    /* renamed from: c */
    private final JSONObject f432c;
    /* renamed from: d */
    private final JSONArray f433d;
    /* renamed from: e */
    private final FacebookRequestError f434e;
    /* renamed from: f */
    private final String f435f;
    /* renamed from: g */
    private final GraphRequest f436g;

    C0331D(GraphRequest graphRequest, HttpURLConnection httpURLConnection, FacebookRequestError facebookRequestError) {
        this(graphRequest, httpURLConnection, null, null, null, facebookRequestError);
    }

    C0331D(GraphRequest graphRequest, HttpURLConnection httpURLConnection, String str, JSONArray jSONArray) {
        this(graphRequest, httpURLConnection, str, null, jSONArray, null);
    }

    C0331D(GraphRequest graphRequest, HttpURLConnection httpURLConnection, String str, JSONObject jSONObject) {
        this(graphRequest, httpURLConnection, str, jSONObject, null, null);
    }

    C0331D(GraphRequest graphRequest, HttpURLConnection httpURLConnection, String str, JSONObject jSONObject, JSONArray jSONArray, FacebookRequestError facebookRequestError) {
        this.f436g = graphRequest;
        this.f431b = httpURLConnection;
        this.f435f = str;
        this.f432c = jSONObject;
        this.f433d = jSONArray;
        this.f434e = facebookRequestError;
    }

    /* renamed from: a */
    private static C0331D m480a(GraphRequest graphRequest, HttpURLConnection httpURLConnection, Object obj, Object obj2) {
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            FacebookRequestError a = FacebookRequestError.m497a(jSONObject, obj2, httpURLConnection);
            if (a != null) {
                Log.e(f430a, a.toString());
                if (a.m499b() == 190 && C0475Q.m990a(graphRequest.m558d())) {
                    if (a.m504g() != 493) {
                        AccessToken.m445b(null);
                    } else if (!AccessToken.m446c().m458m()) {
                        AccessToken.m443a();
                    }
                }
                return new C0331D(graphRequest, httpURLConnection, a);
            }
            obj = C0475Q.m962a(jSONObject, "body", "FACEBOOK_NON_JSON_RESULT");
            if (obj instanceof JSONObject) {
                return new C0331D(graphRequest, httpURLConnection, obj.toString(), (JSONObject) obj);
            }
            if (obj instanceof JSONArray) {
                return new C0331D(graphRequest, httpURLConnection, obj.toString(), (JSONArray) obj);
            }
            obj = JSONObject.NULL;
        }
        if (obj == JSONObject.NULL) {
            return new C0331D(graphRequest, httpURLConnection, obj.toString(), null);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Got unexpected object type in response, class: ");
        stringBuilder.append(obj.getClass().getSimpleName());
        throw new C0506l(stringBuilder.toString());
    }

    /* renamed from: a */
    static List<C0331D> m481a(InputStream inputStream, HttpURLConnection httpURLConnection, C0330C c0330c) {
        String a = C0475Q.m964a(inputStream);
        C0461G.m892a(C0336G.INCLUDE_RAW_RESPONSES, "Response", "Response (raw)\n  Size: %d\n  Response:\n%s\n", Integer.valueOf(a.length()), a);
        return C0331D.m482a(a, httpURLConnection, c0330c);
    }

    /* renamed from: a */
    static List<C0331D> m482a(String str, HttpURLConnection httpURLConnection, C0330C c0330c) {
        List<C0331D> a = C0331D.m484a(httpURLConnection, (List) c0330c, new JSONTokener(str).nextValue());
        C0461G.m892a(C0336G.REQUESTS, "Response", "Response\n  Id: %s\n  Size: %d\n  Responses:\n%s\n", c0330c.m475h(), Integer.valueOf(str.length()), a);
        return a;
    }

    /* renamed from: a */
    static List<C0331D> m483a(HttpURLConnection httpURLConnection, C0330C c0330c) {
        String str = "Response <Error>: %s";
        String str2 = "Response";
        Closeable closeable = null;
        List<C0331D> a;
        try {
            closeable = httpURLConnection.getResponseCode() >= 400 ? httpURLConnection.getErrorStream() : httpURLConnection.getInputStream();
            a = C0331D.m481a((InputStream) closeable, httpURLConnection, c0330c);
            return a;
        } catch (C0506l e) {
            C0461G.m892a(C0336G.REQUESTS, str2, str, e);
            a = C0331D.m485a((List) c0330c, httpURLConnection, e);
            return a;
        } catch (Throwable e2) {
            C0461G.m892a(C0336G.REQUESTS, str2, str, e2);
            a = C0331D.m485a((List) c0330c, httpURLConnection, new C0506l(e2));
            return a;
        } finally {
            C0475Q.m981a(closeable);
        }
    }

    /* renamed from: a */
    private static List<C0331D> m484a(HttpURLConnection httpURLConnection, List<GraphRequest> list, Object obj) {
        JSONArray jSONArray;
        Object c0331d;
        GraphRequest graphRequest;
        Object c0331d2;
        int size = list.size();
        List<C0331D> arrayList = new ArrayList(size);
        int i = 0;
        if (size == 1) {
            GraphRequest graphRequest2 = (GraphRequest) list.get(0);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("body", obj);
                jSONObject.put("code", httpURLConnection != null ? httpURLConnection.getResponseCode() : 200);
                jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
            } catch (Exception e) {
                c0331d = new C0331D(graphRequest2, httpURLConnection, new FacebookRequestError(httpURLConnection, e));
                arrayList.add(c0331d);
                jSONArray = obj;
                if (jSONArray instanceof JSONArray) {
                    jSONArray = jSONArray;
                    if (jSONArray.length() == size) {
                        while (i < jSONArray.length()) {
                            graphRequest = (GraphRequest) list.get(i);
                            try {
                                arrayList.add(C0331D.m480a(graphRequest, httpURLConnection, jSONArray.get(i), obj));
                            } catch (Exception e2) {
                                c0331d2 = new C0331D(graphRequest, httpURLConnection, new FacebookRequestError(httpURLConnection, e2));
                                arrayList.add(c0331d2);
                                i++;
                            } catch (Exception e22) {
                                c0331d2 = new C0331D(graphRequest, httpURLConnection, new FacebookRequestError(httpURLConnection, e22));
                                arrayList.add(c0331d2);
                                i++;
                            }
                            i++;
                        }
                        return arrayList;
                    }
                }
                throw new C0506l("Unexpected number of results");
            } catch (Exception e3) {
                c0331d = new C0331D(graphRequest2, httpURLConnection, new FacebookRequestError(httpURLConnection, e3));
                arrayList.add(c0331d);
                jSONArray = obj;
                if (jSONArray instanceof JSONArray) {
                    jSONArray = jSONArray;
                    if (jSONArray.length() == size) {
                        while (i < jSONArray.length()) {
                            graphRequest = (GraphRequest) list.get(i);
                            arrayList.add(C0331D.m480a(graphRequest, httpURLConnection, jSONArray.get(i), obj));
                            i++;
                        }
                        return arrayList;
                    }
                }
                throw new C0506l("Unexpected number of results");
            }
            if (jSONArray instanceof JSONArray) {
                jSONArray = jSONArray;
                if (jSONArray.length() == size) {
                    while (i < jSONArray.length()) {
                        graphRequest = (GraphRequest) list.get(i);
                        arrayList.add(C0331D.m480a(graphRequest, httpURLConnection, jSONArray.get(i), obj));
                        i++;
                    }
                    return arrayList;
                }
            }
            throw new C0506l("Unexpected number of results");
        }
        jSONArray = obj;
        if (jSONArray instanceof JSONArray) {
            jSONArray = jSONArray;
            if (jSONArray.length() == size) {
                while (i < jSONArray.length()) {
                    graphRequest = (GraphRequest) list.get(i);
                    arrayList.add(C0331D.m480a(graphRequest, httpURLConnection, jSONArray.get(i), obj));
                    i++;
                }
                return arrayList;
            }
        }
        throw new C0506l("Unexpected number of results");
    }

    /* renamed from: a */
    static List<C0331D> m485a(List<GraphRequest> list, HttpURLConnection httpURLConnection, C0506l c0506l) {
        int size = list.size();
        List<C0331D> arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new C0331D((GraphRequest) list.get(i), httpURLConnection, new FacebookRequestError(httpURLConnection, (Exception) c0506l)));
        }
        return arrayList;
    }

    /* renamed from: a */
    public final FacebookRequestError m486a() {
        return this.f434e;
    }

    /* renamed from: b */
    public final JSONObject m487b() {
        return this.f432c;
    }

    public java.lang.String toString() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        r5 = this;
        r0 = java.util.Locale.US;	 Catch:{ IOException -> 0x0020 }
        r1 = "%d";	 Catch:{ IOException -> 0x0020 }
        r2 = 1;	 Catch:{ IOException -> 0x0020 }
        r2 = new java.lang.Object[r2];	 Catch:{ IOException -> 0x0020 }
        r3 = 0;	 Catch:{ IOException -> 0x0020 }
        r4 = r5.f431b;	 Catch:{ IOException -> 0x0020 }
        if (r4 == 0) goto L_0x0013;	 Catch:{ IOException -> 0x0020 }
    L_0x000c:
        r4 = r5.f431b;	 Catch:{ IOException -> 0x0020 }
        r4 = r4.getResponseCode();	 Catch:{ IOException -> 0x0020 }
        goto L_0x0015;	 Catch:{ IOException -> 0x0020 }
    L_0x0013:
        r4 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;	 Catch:{ IOException -> 0x0020 }
    L_0x0015:
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ IOException -> 0x0020 }
        r2[r3] = r4;	 Catch:{ IOException -> 0x0020 }
        r0 = java.lang.String.format(r0, r1, r2);	 Catch:{ IOException -> 0x0020 }
        goto L_0x0022;
    L_0x0020:
        r0 = "unknown";
    L_0x0022:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "{Response: ";
        r1.append(r2);
        r2 = " responseCode: ";
        r1.append(r2);
        r1.append(r0);
        r0 = ", graphObject: ";
        r1.append(r0);
        r0 = r5.f432c;
        r1.append(r0);
        r0 = ", error: ";
        r1.append(r0);
        r0 = r5.f434e;
        r1.append(r0);
        r0 = "}";
        r1.append(r0);
        r0 = r1.toString();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.D.toString():java.lang.String");
    }
}
