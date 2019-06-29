package com.facebook.internal;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.facebook.AccessToken;
import com.facebook.C0506l;
import com.facebook.C0560t;
import com.facebook.C0846k;
import com.facebook.C0860n;
import com.facebook.common.C0444a;
import com.facebook.common.C0447d;
import com.facebook.common.C0448e;
import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;
import org.json.JSONArray;

/* renamed from: com.facebook.internal.X */
public class C0485X extends Dialog {
    /* renamed from: a */
    private static final int f866a = C0448e.com_facebook_activity_theme;
    /* renamed from: b */
    private static volatile int f867b;
    /* renamed from: c */
    private String f868c;
    /* renamed from: d */
    private String f869d;
    /* renamed from: e */
    private C0483c f870e;
    /* renamed from: f */
    private WebView f871f;
    /* renamed from: g */
    private ProgressDialog f872g;
    /* renamed from: h */
    private ImageView f873h;
    /* renamed from: i */
    private FrameLayout f874i;
    /* renamed from: j */
    private C0484d f875j;
    /* renamed from: k */
    private boolean f876k;
    /* renamed from: l */
    private boolean f877l;
    /* renamed from: m */
    private boolean f878m;
    /* renamed from: n */
    private LayoutParams f879n;

    /* renamed from: com.facebook.internal.X$a */
    public static class C0481a {
        /* renamed from: a */
        private Context f854a;
        /* renamed from: b */
        private String f855b;
        /* renamed from: c */
        private String f856c;
        /* renamed from: d */
        private int f857d;
        /* renamed from: e */
        private C0483c f858e;
        /* renamed from: f */
        private Bundle f859f;
        /* renamed from: g */
        private AccessToken f860g;

        public C0481a(Context context, String str, Bundle bundle) {
            this.f860g = AccessToken.m446c();
            if (!AccessToken.m447l()) {
                String c = C0475Q.m999c(context);
                if (c != null) {
                    this.f855b = c;
                } else {
                    throw new C0506l("Attempted to create a builder without a valid access token or a valid default Application ID.");
                }
            }
            m1025a(context, str, bundle);
        }

        public C0481a(Context context, String str, String str2, Bundle bundle) {
            if (str == null) {
                str = C0475Q.m999c(context);
            }
            C0476S.m1017a(str, "applicationId");
            this.f855b = str;
            m1025a(context, str2, bundle);
        }

        /* renamed from: a */
        private void m1025a(Context context, String str, Bundle bundle) {
            this.f854a = context;
            this.f856c = str;
            if (bundle != null) {
                this.f859f = bundle;
            } else {
                this.f859f = new Bundle();
            }
        }

        /* renamed from: a */
        public C0481a m1026a(C0483c c0483c) {
            this.f858e = c0483c;
            return this;
        }

        /* renamed from: a */
        public C0485X mo966a() {
            AccessToken accessToken = this.f860g;
            String str = "app_id";
            if (accessToken != null) {
                this.f859f.putString(str, accessToken.m449b());
                this.f859f.putString("access_token", this.f860g.m456j());
            } else {
                this.f859f.putString(str, this.f855b);
            }
            return C0485X.m1039a(this.f854a, this.f856c, this.f859f, this.f857d, this.f858e);
        }

        /* renamed from: b */
        public String m1028b() {
            return this.f855b;
        }

        /* renamed from: c */
        public Context m1029c() {
            return this.f854a;
        }

        /* renamed from: d */
        public C0483c m1030d() {
            return this.f858e;
        }

        /* renamed from: e */
        public Bundle m1031e() {
            return this.f859f;
        }

        /* renamed from: f */
        public int m1032f() {
            return this.f857d;
        }
    }

    /* renamed from: com.facebook.internal.X$b */
    private class C0482b extends WebViewClient {
        /* renamed from: a */
        final /* synthetic */ C0485X f861a;

        private C0482b(C0485X c0485x) {
            this.f861a = c0485x;
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (!this.f861a.f877l) {
                this.f861a.f872g.dismiss();
            }
            this.f861a.f874i.setBackgroundColor(0);
            this.f861a.f871f.setVisibility(0);
            this.f861a.f873h.setVisibility(0);
            this.f861a.f878m = true;
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Webview loading URL: ");
            stringBuilder.append(str);
            C0475Q.m984a("FacebookSDK.WebDialog", stringBuilder.toString());
            super.onPageStarted(webView, str, bitmap);
            if (!this.f861a.f877l) {
                this.f861a.f872g.show();
            }
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            this.f861a.m1056a(new C0846k(str, i, str2));
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            sslErrorHandler.cancel();
            this.f861a.m1056a(new C0846k(null, -11, null));
        }

        public boolean shouldOverrideUrlLoading(android.webkit.WebView r6, java.lang.String r7) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
            /*
            r5 = this;
            r6 = new java.lang.StringBuilder;
            r6.<init>();
            r0 = "Redirect URL: ";
            r6.append(r0);
            r6.append(r7);
            r6 = r6.toString();
            r0 = "FacebookSDK.WebDialog";
            com.facebook.internal.C0475Q.m984a(r0, r6);
            r6 = r5.f861a;
            r6 = r6.f869d;
            r6 = r7.startsWith(r6);
            r0 = 1;
            if (r6 == 0) goto L_0x00a1;
        L_0x0023:
            r6 = r5.f861a;
            r6 = r6.mo958a(r7);
            r7 = "error";
            r7 = r6.getString(r7);
            if (r7 != 0) goto L_0x0037;
        L_0x0031:
            r7 = "error_type";
            r7 = r6.getString(r7);
        L_0x0037:
            r1 = "error_msg";
            r1 = r6.getString(r1);
            if (r1 != 0) goto L_0x0045;
        L_0x003f:
            r1 = "error_message";
            r1 = r6.getString(r1);
        L_0x0045:
            if (r1 != 0) goto L_0x004d;
        L_0x0047:
            r1 = "error_description";
            r1 = r6.getString(r1);
        L_0x004d:
            r2 = "error_code";
            r2 = r6.getString(r2);
            r3 = com.facebook.internal.C0475Q.m998b(r2);
            r4 = -1;
            if (r3 != 0) goto L_0x005f;
        L_0x005a:
            r2 = java.lang.Integer.parseInt(r2);	 Catch:{ NumberFormatException -> 0x005f }
            goto L_0x0060;
        L_0x005f:
            r2 = -1;
        L_0x0060:
            r3 = com.facebook.internal.C0475Q.m998b(r7);
            if (r3 == 0) goto L_0x0074;
        L_0x0066:
            r3 = com.facebook.internal.C0475Q.m998b(r1);
            if (r3 == 0) goto L_0x0074;
        L_0x006c:
            if (r2 != r4) goto L_0x0074;
        L_0x006e:
            r7 = r5.f861a;
            r7.m1054a(r6);
            goto L_0x00a0;
        L_0x0074:
            if (r7 == 0) goto L_0x0087;
        L_0x0076:
            r6 = "access_denied";
            r6 = r7.equals(r6);
            if (r6 != 0) goto L_0x008b;
        L_0x007e:
            r6 = "OAuthAccessDeniedException";
            r6 = r7.equals(r6);
            if (r6 == 0) goto L_0x0087;
        L_0x0086:
            goto L_0x008b;
        L_0x0087:
            r6 = 4201; // 0x1069 float:5.887E-42 double:2.0756E-320;
            if (r2 != r6) goto L_0x0091;
        L_0x008b:
            r6 = r5.f861a;
            r6.cancel();
            goto L_0x00a0;
        L_0x0091:
            r6 = new com.facebook.FacebookRequestError;
            r6.<init>(r2, r7, r1);
            r7 = r5.f861a;
            r2 = new com.facebook.v;
            r2.<init>(r6, r1);
            r7.m1056a(r2);
        L_0x00a0:
            return r0;
        L_0x00a1:
            r6 = "fbconnect://cancel";
            r6 = r7.startsWith(r6);
            if (r6 == 0) goto L_0x00af;
        L_0x00a9:
            r6 = r5.f861a;
            r6.cancel();
            return r0;
        L_0x00af:
            r6 = "touch";
            r6 = r7.contains(r6);
            r1 = 0;
            if (r6 == 0) goto L_0x00b9;
        L_0x00b8:
            return r1;
        L_0x00b9:
            r6 = r5.f861a;	 Catch:{ ActivityNotFoundException -> 0x00ce }
            r6 = r6.getContext();	 Catch:{ ActivityNotFoundException -> 0x00ce }
            r2 = new android.content.Intent;	 Catch:{ ActivityNotFoundException -> 0x00ce }
            r3 = "android.intent.action.VIEW";	 Catch:{ ActivityNotFoundException -> 0x00ce }
            r7 = android.net.Uri.parse(r7);	 Catch:{ ActivityNotFoundException -> 0x00ce }
            r2.<init>(r3, r7);	 Catch:{ ActivityNotFoundException -> 0x00ce }
            r6.startActivity(r2);	 Catch:{ ActivityNotFoundException -> 0x00ce }
            return r0;
        L_0x00ce:
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.X.b.shouldOverrideUrlLoading(android.webkit.WebView, java.lang.String):boolean");
        }
    }

    /* renamed from: com.facebook.internal.X$c */
    public interface C0483c {
        /* renamed from: a */
        void mo957a(Bundle bundle, C0506l c0506l);
    }

    /* renamed from: com.facebook.internal.X$d */
    private class C0484d extends AsyncTask<Void, Void, String[]> {
        /* renamed from: a */
        private String f862a;
        /* renamed from: b */
        private Bundle f863b;
        /* renamed from: c */
        private Exception[] f864c;
        /* renamed from: d */
        final /* synthetic */ C0485X f865d;

        C0484d(C0485X c0485x, String str, Bundle bundle) {
            this.f865d = c0485x;
            this.f862a = str;
            this.f863b = bundle;
        }

        /* renamed from: a */
        protected void m1035a(String[] strArr) {
            this.f865d.f872g.dismiss();
            for (Throwable th : this.f864c) {
                if (th != null) {
                    this.f865d.m1056a(th);
                    return;
                }
            }
            String str = "Failed to stage photos for web dialog";
            if (strArr == null) {
                this.f865d.m1056a(new C0506l(str));
                return;
            }
            Collection asList = Arrays.asList(strArr);
            if (asList.contains(null)) {
                this.f865d.m1056a(new C0506l(str));
                return;
            }
            C0475Q.m989a(this.f863b, "media", new JSONArray(asList));
            String b = C0470M.m947b();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(C0560t.m1260l());
            stringBuilder.append("/");
            stringBuilder.append("dialog/");
            stringBuilder.append(this.f862a);
            this.f865d.f868c = C0475Q.m959a(b, stringBuilder.toString(), this.f863b).toString();
            this.f865d.m1046b((this.f865d.f873h.getDrawable().getIntrinsicWidth() / 2) + 1);
        }

        /* renamed from: a */
        protected java.lang.String[] m1036a(java.lang.Void... r10) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
            /*
            r9 = this;
            r10 = r9.f863b;
            r0 = "media";
            r10 = r10.getStringArray(r0);
            r0 = r10.length;
            r0 = new java.lang.String[r0];
            r1 = r10.length;
            r1 = new java.lang.Exception[r1];
            r9.f864c = r1;
            r1 = new java.util.concurrent.CountDownLatch;
            r2 = r10.length;
            r1.<init>(r2);
            r2 = new java.util.concurrent.ConcurrentLinkedQueue;
            r2.<init>();
            r3 = com.facebook.AccessToken.m446c();
            r4 = 0;
        L_0x0020:
            r5 = 0;
            r6 = 1;
            r7 = r10.length;	 Catch:{ Exception -> 0x006d }
            if (r4 >= r7) goto L_0x0069;	 Catch:{ Exception -> 0x006d }
        L_0x0025:
            r7 = r9.isCancelled();	 Catch:{ Exception -> 0x006d }
            if (r7 == 0) goto L_0x0040;	 Catch:{ Exception -> 0x006d }
        L_0x002b:
            r10 = r2.iterator();	 Catch:{ Exception -> 0x006d }
        L_0x002f:
            r0 = r10.hasNext();	 Catch:{ Exception -> 0x006d }
            if (r0 == 0) goto L_0x003f;	 Catch:{ Exception -> 0x006d }
        L_0x0035:
            r0 = r10.next();	 Catch:{ Exception -> 0x006d }
            r0 = (android.os.AsyncTask) r0;	 Catch:{ Exception -> 0x006d }
            r0.cancel(r6);	 Catch:{ Exception -> 0x006d }
            goto L_0x002f;	 Catch:{ Exception -> 0x006d }
        L_0x003f:
            return r5;	 Catch:{ Exception -> 0x006d }
        L_0x0040:
            r7 = r10[r4];	 Catch:{ Exception -> 0x006d }
            r7 = android.net.Uri.parse(r7);	 Catch:{ Exception -> 0x006d }
            r8 = com.facebook.internal.C0475Q.m1006d(r7);	 Catch:{ Exception -> 0x006d }
            if (r8 == 0) goto L_0x0056;	 Catch:{ Exception -> 0x006d }
        L_0x004c:
            r7 = r7.toString();	 Catch:{ Exception -> 0x006d }
            r0[r4] = r7;	 Catch:{ Exception -> 0x006d }
            r1.countDown();	 Catch:{ Exception -> 0x006d }
            goto L_0x0066;	 Catch:{ Exception -> 0x006d }
        L_0x0056:
            r8 = new com.facebook.internal.Y;	 Catch:{ Exception -> 0x006d }
            r8.<init>(r9, r0, r4, r1);	 Catch:{ Exception -> 0x006d }
            r7 = com.facebook.share.internal.C0551g.m1232a(r3, r7, r8);	 Catch:{ Exception -> 0x006d }
            r7 = r7.m556c();	 Catch:{ Exception -> 0x006d }
            r2.add(r7);	 Catch:{ Exception -> 0x006d }
        L_0x0066:
            r4 = r4 + 1;	 Catch:{ Exception -> 0x006d }
            goto L_0x0020;	 Catch:{ Exception -> 0x006d }
        L_0x0069:
            r1.await();	 Catch:{ Exception -> 0x006d }
            return r0;
        L_0x006d:
            r10 = r2.iterator();
        L_0x0071:
            r0 = r10.hasNext();
            if (r0 == 0) goto L_0x0081;
        L_0x0077:
            r0 = r10.next();
            r0 = (android.os.AsyncTask) r0;
            r0.cancel(r6);
            goto L_0x0071;
        L_0x0081:
            return r5;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.X.d.a(java.lang.Void[]):java.lang.String[]");
        }

        protected /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
            return m1036a((Void[]) objArr);
        }

        protected /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
            m1035a((String[]) obj);
        }
    }

    protected C0485X(Context context, String str) {
        this(context, str, C0485X.m1037a());
    }

    private C0485X(Context context, String str, int i) {
        if (i == 0) {
            i = C0485X.m1037a();
        }
        super(context, i);
        this.f869d = "fbconnect://success";
        this.f876k = false;
        this.f877l = false;
        this.f878m = false;
        this.f868c = str;
    }

    private C0485X(Context context, String str, Bundle bundle, int i, C0483c c0483c) {
        if (i == 0) {
            i = C0485X.m1037a();
        }
        super(context, i);
        String str2 = "fbconnect://success";
        this.f869d = str2;
        this.f876k = false;
        this.f877l = false;
        this.f878m = false;
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (C0475Q.m1009e(context)) {
            str2 = "fbconnect://chrome_os_success";
        }
        this.f869d = str2;
        bundle.putString("redirect_uri", this.f869d);
        bundle.putString("display", "touch");
        bundle.putString("client_id", C0560t.m1253e());
        bundle.putString("sdk", String.format(Locale.ROOT, "android-%s", new Object[]{C0560t.m1262n()}));
        this.f870e = c0483c;
        if (str.equals("share") && bundle.containsKey("media")) {
            this.f875j = new C0484d(this, str, bundle);
            return;
        }
        String b = C0470M.m947b();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(C0560t.m1260l());
        stringBuilder.append("/");
        stringBuilder.append("dialog/");
        stringBuilder.append(str);
        this.f868c = C0475Q.m959a(b, stringBuilder.toString(), bundle).toString();
    }

    /* renamed from: a */
    public static int m1037a() {
        C0476S.m1023c();
        return f867b;
    }

    /* renamed from: a */
    private int m1038a(int i, float f, int i2, int i3) {
        int i4 = (int) (((float) i) / f);
        double d = 0.5d;
        if (i4 <= i2) {
            d = 1.0d;
        } else if (i4 < i3) {
            double d2 = (double) (i3 - i4);
            double d3 = (double) (i3 - i2);
            Double.isNaN(d2);
            Double.isNaN(d3);
            d = 0.5d + ((d2 / d3) * 0.5d);
        }
        double d4 = (double) i;
        Double.isNaN(d4);
        return (int) (d4 * d);
    }

    /* renamed from: a */
    public static C0485X m1039a(Context context, String str, Bundle bundle, int i, C0483c c0483c) {
        C0485X.m1043a(context);
        return new C0485X(context, str, bundle, i, c0483c);
    }

    /* renamed from: a */
    public static void m1042a(int i) {
        if (i == 0) {
            i = f866a;
        }
        f867b = i;
    }

    /* renamed from: a */
    protected static void m1043a(android.content.Context r2) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        if (r2 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r0 = r2.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0027 }
        r2 = r2.getPackageName();	 Catch:{ NameNotFoundException -> 0x0027 }
        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;	 Catch:{ NameNotFoundException -> 0x0027 }
        r2 = r0.getApplicationInfo(r2, r1);	 Catch:{ NameNotFoundException -> 0x0027 }
        if (r2 == 0) goto L_0x0027;
    L_0x0013:
        r0 = r2.metaData;
        if (r0 != 0) goto L_0x0018;
    L_0x0017:
        goto L_0x0027;
    L_0x0018:
        r0 = f867b;
        if (r0 != 0) goto L_0x0027;
    L_0x001c:
        r2 = r2.metaData;
        r0 = "com.facebook.sdk.WebDialogTheme";
        r2 = r2.getInt(r0);
        com.facebook.internal.C0485X.m1042a(r2);
    L_0x0027:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.X.a(android.content.Context):void");
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    /* renamed from: b */
    private void m1046b(int i) {
        View linearLayout = new LinearLayout(getContext());
        this.f871f = new C0479V(this, getContext());
        this.f871f.setVerticalScrollBarEnabled(false);
        this.f871f.setHorizontalScrollBarEnabled(false);
        this.f871f.setWebViewClient(new C0482b());
        this.f871f.getSettings().setJavaScriptEnabled(true);
        this.f871f.loadUrl(this.f868c);
        this.f871f.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f871f.setVisibility(4);
        this.f871f.getSettings().setSavePassword(false);
        this.f871f.getSettings().setSaveFormData(false);
        this.f871f.setFocusable(true);
        this.f871f.setFocusableInTouchMode(true);
        this.f871f.setOnTouchListener(new C0480W(this));
        linearLayout.setPadding(i, i, i, i);
        linearLayout.addView(this.f871f);
        linearLayout.setBackgroundColor(-872415232);
        this.f874i.addView(linearLayout);
    }

    /* renamed from: f */
    private void m1052f() {
        this.f873h = new ImageView(getContext());
        this.f873h.setOnClickListener(new C0478U(this));
        this.f873h.setImageDrawable(getContext().getResources().getDrawable(C0444a.com_facebook_close));
        this.f873h.setVisibility(4);
    }

    /* renamed from: a */
    protected Bundle mo958a(String str) {
        Uri parse = Uri.parse(str);
        Bundle d = C0475Q.m1004d(parse.getQuery());
        d.putAll(C0475Q.m1004d(parse.getFragment()));
        return d;
    }

    /* renamed from: a */
    protected void m1054a(Bundle bundle) {
        C0483c c0483c = this.f870e;
        if (c0483c != null && !this.f876k) {
            this.f876k = true;
            c0483c.mo957a(bundle, null);
            dismiss();
        }
    }

    /* renamed from: a */
    public void m1055a(C0483c c0483c) {
        this.f870e = c0483c;
    }

    /* renamed from: a */
    protected void m1056a(Throwable th) {
        if (this.f870e != null && !this.f876k) {
            this.f876k = true;
            this.f870e.mo957a(null, th instanceof C0506l ? (C0506l) th : new C0506l(th));
            dismiss();
        }
    }

    /* renamed from: b */
    protected WebView m1057b() {
        return this.f871f;
    }

    /* renamed from: b */
    protected void m1058b(String str) {
        this.f869d = str;
    }

    /* renamed from: c */
    protected boolean m1059c() {
        return this.f876k;
    }

    public void cancel() {
        if (this.f870e != null && !this.f876k) {
            m1056a(new C0860n());
        }
    }

    /* renamed from: d */
    protected boolean m1060d() {
        return this.f878m;
    }

    public void dismiss() {
        WebView webView = this.f871f;
        if (webView != null) {
            webView.stopLoading();
        }
        if (!this.f877l) {
            ProgressDialog progressDialog = this.f872g;
            if (progressDialog != null && progressDialog.isShowing()) {
                this.f872g.dismiss();
            }
        }
        super.dismiss();
    }

    /* renamed from: e */
    public void m1061e() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        if (i >= i2) {
            i = i2;
        }
        i2 = displayMetrics.widthPixels;
        int i3 = displayMetrics.heightPixels;
        if (i2 < i3) {
            i2 = i3;
        }
        getWindow().setLayout(Math.min(m1038a(i, displayMetrics.density, 480, 800), displayMetrics.widthPixels), Math.min(m1038a(i2, displayMetrics.density, 800, 1280), displayMetrics.heightPixels));
    }

    public void onAttachedToWindow() {
        this.f877l = false;
        if (C0475Q.m1011f(getContext())) {
            LayoutParams layoutParams = this.f879n;
            if (layoutParams != null && layoutParams.token == null) {
                layoutParams.token = getOwnerActivity().getWindow().getAttributes().token;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Set token on onAttachedToWindow(): ");
                stringBuilder.append(this.f879n.token);
                C0475Q.m984a("FacebookSDK.WebDialog", stringBuilder.toString());
            }
        }
        super.onAttachedToWindow();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f872g = new ProgressDialog(getContext());
        this.f872g.requestWindowFeature(1);
        this.f872g.setMessage(getContext().getString(C0447d.com_facebook_loading));
        this.f872g.setCanceledOnTouchOutside(false);
        this.f872g.setOnCancelListener(new C0477T(this));
        requestWindowFeature(1);
        this.f874i = new FrameLayout(getContext());
        m1061e();
        getWindow().setGravity(17);
        getWindow().setSoftInputMode(16);
        m1052f();
        if (this.f868c != null) {
            m1046b((this.f873h.getDrawable().getIntrinsicWidth() / 2) + 1);
        }
        this.f874i.addView(this.f873h, new ViewGroup.LayoutParams(-2, -2));
        setContentView(this.f874i);
    }

    public void onDetachedFromWindow() {
        this.f877l = true;
        super.onDetachedFromWindow();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            cancel();
        }
        return super.onKeyDown(i, keyEvent);
    }

    protected void onStart() {
        super.onStart();
        AsyncTask asyncTask = this.f875j;
        if (asyncTask == null || asyncTask.getStatus() != Status.PENDING) {
            m1061e();
            return;
        }
        this.f875j.execute(new Void[0]);
        this.f872g.show();
    }

    protected void onStop() {
        AsyncTask asyncTask = this.f875j;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            this.f872g.dismiss();
        }
        super.onStop();
    }

    public void onWindowAttributesChanged(LayoutParams layoutParams) {
        if (layoutParams.token == null) {
            this.f879n = layoutParams;
        }
        super.onWindowAttributesChanged(layoutParams);
    }
}
