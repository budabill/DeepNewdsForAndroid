package io.gonative.android;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Message;
import android.preference.PreferenceManager;
import android.support.v4.content.LocalBroadcastManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebResourceResponse;
import android.widget.Toast;
import io.gonative.android.azzpro.R;
import io.gonative.android.p038a.C0700a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class wa {
    /* renamed from: a */
    private static final String f1662a = "io.gonative.android.wa";
    /* renamed from: b */
    private MainActivity f1663b;
    /* renamed from: c */
    private String f1664c;
    /* renamed from: d */
    private String f1665d;
    /* renamed from: e */
    private C0721n f1666e;
    /* renamed from: f */
    private boolean f1667f = false;
    /* renamed from: g */
    private boolean f1668g = false;
    /* renamed from: h */
    private boolean f1669h = false;

    wa(MainActivity mainActivity) {
        this.f1663b = mainActivity;
        this.f1666e = new C0721n(mainActivity);
        C0700a a = C0700a.m1851a(this.f1663b);
        if (a.f1518N != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("gonative_profile_picker.parseJson(eval(");
            stringBuilder.append(C0726s.m1973b(a.f1518N));
            stringBuilder.append("))");
            this.f1664c = stringBuilder.toString();
        }
        if (this.f1663b.getIntent().getBooleanExtra("io.gonative.android.MainActivity.Extra.WEBVIEW_WINDOW_OPEN", false)) {
            this.f1668g = true;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private boolean m1988a(android.net.Uri r8) {
        /*
        r7 = this;
        r0 = r8.getScheme();
        r1 = 0;
        if (r0 == 0) goto L_0x0073;
    L_0x0007:
        r2 = "http";
        r2 = r0.equalsIgnoreCase(r2);
        if (r2 != 0) goto L_0x0018;
    L_0x000f:
        r2 = "https";
        r0 = r0.equalsIgnoreCase(r2);
        if (r0 != 0) goto L_0x0018;
    L_0x0017:
        goto L_0x0073;
    L_0x0018:
        r0 = r7.f1663b;
        r0 = io.gonative.android.p038a.C0700a.m1851a(r0);
        r2 = r8.toString();
        r3 = r0.f1519O;
        r4 = r0.f1520P;
        if (r3 == 0) goto L_0x004d;
    L_0x0028:
        r5 = 0;
    L_0x0029:
        r6 = r3.size();
        if (r5 >= r6) goto L_0x004d;
    L_0x002f:
        r6 = r3.get(r5);
        r6 = (java.util.regex.Pattern) r6;
        r6 = r6.matcher(r2);
        r6 = r6.matches();
        if (r6 == 0) goto L_0x004a;
    L_0x003f:
        r8 = r4.get(r5);
        r8 = (java.lang.Boolean) r8;
        r8 = r8.booleanValue();
        return r8;
    L_0x004a:
        r5 = r5 + 1;
        goto L_0x0029;
    L_0x004d:
        r8 = r8.getHost();
        r0 = r0.f1535g;
        if (r8 == 0) goto L_0x0073;
    L_0x0055:
        r2 = r8.equals(r0);
        if (r2 != 0) goto L_0x0072;
    L_0x005b:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = ".";
        r2.append(r3);
        r2.append(r0);
        r0 = r2.toString();
        r8 = r8.endsWith(r0);
        if (r8 == 0) goto L_0x0073;
    L_0x0072:
        r1 = 1;
    L_0x0073:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.gonative.android.wa.a(android.net.Uri):boolean");
    }

    /* renamed from: b */
    private boolean m1990b() {
        Intent intent = new Intent(this.f1663b.getBaseContext(), MainActivity.class);
        intent.putExtra("isRoot", false);
        intent.putExtra("io.gonative.android.MainActivity.Extra.WEBVIEW_WINDOW_OPEN", true);
        this.f1663b.startActivity(intent);
        return true;
    }

    /* renamed from: b */
    private boolean m1991b(java.lang.String[] r17, boolean r18) {
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
        r16 = this;
        r0 = r16;
        r1 = r17;
        r2 = r0.f1663b;
        r3 = 0;
        r2.m2590a(r3);
        r2 = new java.util.HashSet;
        r2.<init>();
        r3 = r1.length;
        r4 = 0;
        r5 = 0;
    L_0x0012:
        r6 = 1;
        if (r5 >= r3) goto L_0x004b;
    L_0x0015:
        r7 = r1[r5];
        r8 = "[,;\\s]";
        r7 = r7.split(r8);
        r8 = r7.length;
        r9 = 0;
    L_0x001f:
        if (r9 >= r8) goto L_0x0048;
    L_0x0021:
        r10 = r7[r9];
        r11 = ".";
        r11 = r10.startsWith(r11);
        if (r11 == 0) goto L_0x003a;
    L_0x002b:
        r11 = android.webkit.MimeTypeMap.getSingleton();
        r10 = r10.substring(r6);
        r10 = r11.getMimeTypeFromExtension(r10);
        if (r10 == 0) goto L_0x0045;
    L_0x0039:
        goto L_0x0042;
    L_0x003a:
        r11 = "/";
        r11 = r10.contains(r11);
        if (r11 == 0) goto L_0x0045;
    L_0x0042:
        r2.add(r10);
    L_0x0045:
        r9 = r9 + 1;
        goto L_0x001f;
    L_0x0048:
        r5 = r5 + 1;
        goto L_0x0012;
    L_0x004b:
        r1 = r2.isEmpty();
        r3 = "*/*";
        if (r1 == 0) goto L_0x0056;
    L_0x0053:
        r2.add(r3);
    L_0x0056:
        r1 = r0.f1663b;
        r1 = io.gonative.android.p038a.C0700a.m1851a(r1);
        r1 = r1.f1547s;
        if (r1 == 0) goto L_0x009f;
    L_0x0060:
        r1 = r2.iterator();
        r5 = 0;
        r7 = 0;
    L_0x0066:
        r8 = r1.hasNext();
        if (r8 == 0) goto L_0x00a1;
    L_0x006c:
        r8 = r1.next();
        r8 = (java.lang.String) r8;
        r9 = r8.equals(r3);
        if (r9 == 0) goto L_0x007b;
    L_0x0078:
        r5 = 1;
    L_0x0079:
        r7 = 1;
        goto L_0x0066;
    L_0x007b:
        r9 = "image/*";
        r9 = r8.equals(r9);
        if (r9 != 0) goto L_0x009d;
    L_0x0083:
        r9 = "image/jpeg";
        r9 = r8.equals(r9);
        if (r9 != 0) goto L_0x009d;
    L_0x008b:
        r9 = "image/jpg";
        r9 = r8.equals(r9);
        if (r9 == 0) goto L_0x0094;
    L_0x0093:
        goto L_0x009d;
    L_0x0094:
        r9 = "video/";
        r8 = r8.startsWith(r9);
        if (r8 == 0) goto L_0x0066;
    L_0x009c:
        goto L_0x0079;
    L_0x009d:
        r5 = 1;
        goto L_0x0066;
    L_0x009f:
        r5 = 0;
        r7 = 0;
    L_0x00a1:
        r1 = new java.util.ArrayList;
        r1.<init>();
        r8 = r0.f1663b;
        r8 = r8.getPackageManager();
        if (r5 == 0) goto L_0x0131;
    L_0x00ae:
        r5 = new java.text.SimpleDateFormat;
        r9 = java.util.Locale.US;
        r10 = "yyyyMMdd_HHmmss";
        r5.<init>(r10, r9);
        r9 = new java.util.Date;
        r9.<init>();
        r5 = r5.format(r9);
        r9 = new java.lang.StringBuilder;
        r9.<init>();
        r10 = "IMG_";
        r9.append(r10);
        r9.append(r5);
        r5 = ".jpg";
        r9.append(r5);
        r5 = r9.toString();
        r9 = android.os.Environment.DIRECTORY_PICTURES;
        r9 = android.os.Environment.getExternalStoragePublicDirectory(r9);
        r10 = new java.io.File;
        r10.<init>(r9, r5);
        r5 = android.net.Uri.fromFile(r10);
        if (r5 == 0) goto L_0x0131;
    L_0x00e7:
        r9 = new android.content.Intent;
        r11 = "android.media.action.IMAGE_CAPTURE";
        r9.<init>(r11);
        r11 = r8.queryIntentActivities(r9, r4);
        r11 = r11.iterator();
    L_0x00f6:
        r12 = r11.hasNext();
        if (r12 == 0) goto L_0x0131;
    L_0x00fc:
        r12 = r11.next();
        r12 = (android.content.pm.ResolveInfo) r12;
        r13 = r12.activityInfo;
        r13 = r13.packageName;
        r14 = new android.content.Intent;
        r14.<init>(r9);
        r15 = new android.content.ComponentName;
        r6 = r12.activityInfo;
        r6 = r6.packageName;
        r12 = r12.activityInfo;
        r12 = r12.name;
        r15.<init>(r6, r12);
        r14.setComponent(r15);
        r14.setPackage(r13);
        r6 = android.net.Uri.fromFile(r10);
        r12 = "output";
        r14.putExtra(r12, r6);
        r6 = r0.f1663b;
        r6.m2590a(r5);
        r1.add(r14);
        r6 = 1;
        goto L_0x00f6;
    L_0x0131:
        if (r7 == 0) goto L_0x016e;
    L_0x0133:
        r5 = new android.content.Intent;
        r6 = "android.media.action.VIDEO_CAPTURE";
        r5.<init>(r6);
        r6 = r8.queryIntentActivities(r5, r4);
        r6 = r6.iterator();
    L_0x0142:
        r7 = r6.hasNext();
        if (r7 == 0) goto L_0x016e;
    L_0x0148:
        r7 = r6.next();
        r7 = (android.content.pm.ResolveInfo) r7;
        r8 = r7.activityInfo;
        r8 = r8.packageName;
        r9 = new android.content.Intent;
        r9.<init>(r5);
        r10 = new android.content.ComponentName;
        r11 = r7.activityInfo;
        r11 = r11.packageName;
        r7 = r7.activityInfo;
        r7 = r7.name;
        r10.<init>(r11, r7);
        r9.setComponent(r10);
        r9.setPackage(r8);
        r1.add(r9);
        goto L_0x0142;
    L_0x016e:
        r5 = new android.content.Intent;
        r5.<init>();
        r6 = "android.intent.action.GET_CONTENT";
        r5.setAction(r6);
        r6 = "android.intent.category.OPENABLE";
        r5.addCategory(r6);
        r6 = r2.size();
        r7 = 1;
        if (r6 != r7) goto L_0x0192;
    L_0x0184:
        r2 = r2.iterator();
        r2 = r2.next();
        r2 = (java.lang.String) r2;
        r5.setType(r2);
        goto L_0x01ac;
    L_0x0192:
        r5.setType(r3);
        r3 = android.os.Build.VERSION.SDK_INT;
        r6 = 19;
        if (r3 < r6) goto L_0x01ac;
    L_0x019b:
        r3 = r2.size();
        r3 = new java.lang.String[r3];
        r2 = r2.toArray(r3);
        r2 = (java.lang.String[]) r2;
        r3 = "android.intent.extra.MIME_TYPES";
        r5.putExtra(r3, r2);
    L_0x01ac:
        if (r18 == 0) goto L_0x01ba;
    L_0x01ae:
        r2 = android.os.Build.VERSION.SDK_INT;
        r3 = 18;
        if (r2 < r3) goto L_0x01ba;
    L_0x01b4:
        r2 = "android.intent.extra.ALLOW_MULTIPLE";
        r3 = 1;
        r5.putExtra(r2, r3);
    L_0x01ba:
        r2 = r1.isEmpty();
        if (r2 == 0) goto L_0x01c1;
    L_0x01c0:
        goto L_0x01d4;
    L_0x01c1:
        r2 = "Choose an action";
        r5 = android.content.Intent.createChooser(r5, r2);
        r2 = new android.os.Parcelable[r4];
        r1 = r1.toArray(r2);
        r1 = (android.os.Parcelable[]) r1;
        r2 = "android.intent.extra.INITIAL_INTENTS";
        r5.putExtra(r2, r1);
    L_0x01d4:
        r1 = r0.f1663b;	 Catch:{ ActivityNotFoundException -> 0x01dd }
        r2 = 100;	 Catch:{ ActivityNotFoundException -> 0x01dd }
        r1.startActivityForResult(r5, r2);	 Catch:{ ActivityNotFoundException -> 0x01dd }
        r1 = 1;
        return r1;
    L_0x01dd:
        r1 = 1;
        r2 = r0.f1663b;
        r2.m2603c();
        r2 = r0.f1663b;
        r3 = 2131492907; // 0x7f0c002b float:1.860928E38 double:1.0530974197E-314;
        r1 = android.widget.Toast.makeText(r2, r3, r1);
        r1.show();
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.gonative.android.wa.b(java.lang.String[], boolean):boolean");
    }

    /* renamed from: c */
    private boolean m1992c(io.gonative.android.C0720m r12, java.lang.String r13, boolean r14) {
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
        r11 = this;
        r0 = 0;
        if (r13 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = "file:///android_asset/";
        r1 = r13.startsWith(r1);
        if (r1 == 0) goto L_0x000d;
    L_0x000c:
        return r0;
    L_0x000d:
        r1 = 1;
        r12.setCheckLoginSignup(r1);
        r2 = android.net.Uri.parse(r13);
        r3 = r2.getScheme();
        if (r3 == 0) goto L_0x007d;
    L_0x001b:
        r3 = r2.getScheme();
        r4 = "gonative-bridge";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x007d;
    L_0x0027:
        if (r14 == 0) goto L_0x002a;
    L_0x0029:
        return r1;
    L_0x002a:
        r12 = "json";	 Catch:{ Exception -> 0x007c }
        r12 = r2.getQueryParameter(r12);	 Catch:{ Exception -> 0x007c }
        r13 = new org.json.JSONArray;	 Catch:{ Exception -> 0x007c }
        r13.<init>(r12);	 Catch:{ Exception -> 0x007c }
    L_0x0035:
        r12 = r13.length();	 Catch:{ Exception -> 0x007c }
        if (r0 >= r12) goto L_0x007c;	 Catch:{ Exception -> 0x007c }
    L_0x003b:
        r12 = r13.optJSONObject(r0);	 Catch:{ Exception -> 0x007c }
        if (r12 != 0) goto L_0x0042;	 Catch:{ Exception -> 0x007c }
    L_0x0041:
        goto L_0x0079;	 Catch:{ Exception -> 0x007c }
    L_0x0042:
        r14 = "command";	 Catch:{ Exception -> 0x007c }
        r12 = r12.optString(r14);	 Catch:{ Exception -> 0x007c }
        if (r12 != 0) goto L_0x004b;	 Catch:{ Exception -> 0x007c }
    L_0x004a:
        goto L_0x0079;	 Catch:{ Exception -> 0x007c }
    L_0x004b:
        r14 = "pop";	 Catch:{ Exception -> 0x007c }
        r14 = r12.equals(r14);	 Catch:{ Exception -> 0x007c }
        if (r14 == 0) goto L_0x0061;	 Catch:{ Exception -> 0x007c }
    L_0x0053:
        r12 = r11.f1663b;	 Catch:{ Exception -> 0x007c }
        r12 = r12.m2626r();	 Catch:{ Exception -> 0x007c }
        if (r12 == 0) goto L_0x0079;	 Catch:{ Exception -> 0x007c }
    L_0x005b:
        r12 = r11.f1663b;	 Catch:{ Exception -> 0x007c }
        r12.finish();	 Catch:{ Exception -> 0x007c }
        goto L_0x0079;	 Catch:{ Exception -> 0x007c }
    L_0x0061:
        r14 = "clearPools";	 Catch:{ Exception -> 0x007c }
        r12 = r12.equals(r14);	 Catch:{ Exception -> 0x007c }
        if (r12 == 0) goto L_0x0079;	 Catch:{ Exception -> 0x007c }
    L_0x0069:
        r12 = r11.f1663b;	 Catch:{ Exception -> 0x007c }
        r12 = android.support.v4.content.LocalBroadcastManager.getInstance(r12);	 Catch:{ Exception -> 0x007c }
        r14 = new android.content.Intent;	 Catch:{ Exception -> 0x007c }
        r2 = "io.gonative.android.webview.clearPools";	 Catch:{ Exception -> 0x007c }
        r14.<init>(r2);	 Catch:{ Exception -> 0x007c }
        r12.sendBroadcast(r14);	 Catch:{ Exception -> 0x007c }
    L_0x0079:
        r0 = r0 + 1;
        goto L_0x0035;
    L_0x007c:
        return r1;
    L_0x007d:
        r3 = r11.f1663b;
        r3 = io.gonative.android.p038a.C0700a.m1851a(r3);
        r4 = r2.getScheme();
        r5 = "gonative";
        r4 = r5.equals(r4);
        if (r4 == 0) goto L_0x00b4;
    L_0x008f:
        r4 = r11.f1665d;
        if (r4 == 0) goto L_0x00b4;
    L_0x0093:
        r6 = r11.f1663b;
        r4 = io.gonative.android.C0726s.m1970a(r4, r6);
        if (r4 != 0) goto L_0x00b4;
    L_0x009b:
        r12 = f1662a;
        r13 = new java.lang.StringBuilder;
        r13.<init>();
        r14 = "URL not authorized for native bridge: ";
        r13.append(r14);
        r14 = r11.f1665d;
        r13.append(r14);
        r13 = r13.toString();
        android.util.Log.e(r12, r13);
        return r1;
    L_0x00b4:
        r4 = r2.getScheme();
        r4 = r5.equals(r4);
        r6 = "Gonative registration error: customData is not JSON object";
        if (r4 == 0) goto L_0x0102;
    L_0x00c0:
        r4 = r2.getHost();
        r7 = "registration";
        r4 = r7.equals(r4);
        if (r4 == 0) goto L_0x0102;
    L_0x00cc:
        r4 = r2.getPath();
        r7 = "/send";
        r4 = r7.equals(r4);
        if (r4 == 0) goto L_0x0102;
    L_0x00d8:
        r12 = r11.f1663b;
        r12 = r12.getApplication();
        r12 = (io.gonative.android.GoNativeApplication) r12;
        r12 = r12.m1813b();
        r13 = "customData";
        r13 = r2.getQueryParameter(r13);
        if (r13 == 0) goto L_0x00fe;
    L_0x00ec:
        r14 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x00f8 }
        r14.<init>(r13);	 Catch:{ JSONException -> 0x00f8 }
        r12.m1847a(r14);	 Catch:{ JSONException -> 0x00f8 }
        r12.m1848b();	 Catch:{ JSONException -> 0x00f8 }
        goto L_0x0101;
    L_0x00f8:
        r12 = f1662a;
        android.util.Log.d(r12, r6);
        goto L_0x0101;
    L_0x00fe:
        r12.m1848b();
    L_0x0101:
        return r1;
    L_0x0102:
        r4 = r2.getScheme();
        r4 = r5.equals(r4);
        r7 = -1082130432; // 0xffffffffbf800000 float:-1.0 double:NaN;
        r8 = "url";
        r9 = 0;
        if (r4 == 0) goto L_0x060b;
    L_0x0111:
        r13 = r2.getHost();
        r4 = "nativebridge";
        r13 = r4.equals(r13);
        r4 = "data";
        if (r13 == 0) goto L_0x0165;
    L_0x011f:
        r13 = r2.getPath();
        r3 = "/multi";
        r13 = r3.equals(r13);
        if (r13 == 0) goto L_0x0164;
    L_0x012b:
        r13 = r2.getQueryParameter(r4);
        if (r13 != 0) goto L_0x0132;
    L_0x0131:
        return r1;
    L_0x0132:
        r2 = new org.json.JSONObject;	 Catch:{ Exception -> 0x015c }
        r2.<init>(r13);	 Catch:{ Exception -> 0x015c }
        r13 = "urls";	 Catch:{ Exception -> 0x015c }
        r13 = r2.getJSONArray(r13);	 Catch:{ Exception -> 0x015c }
    L_0x013d:
        r2 = r13.length();	 Catch:{ Exception -> 0x015c }
        if (r0 >= r2) goto L_0x0164;	 Catch:{ Exception -> 0x015c }
    L_0x0143:
        r2 = r13.getString(r0);	 Catch:{ Exception -> 0x015c }
        r3 = android.net.Uri.parse(r2);	 Catch:{ Exception -> 0x015c }
        r3 = r3.getScheme();	 Catch:{ Exception -> 0x015c }
        r3 = r5.equals(r3);	 Catch:{ Exception -> 0x015c }
        if (r3 != 0) goto L_0x0156;	 Catch:{ Exception -> 0x015c }
    L_0x0155:
        goto L_0x0159;	 Catch:{ Exception -> 0x015c }
    L_0x0156:
        r11.m1992c(r12, r2, r14);	 Catch:{ Exception -> 0x015c }
    L_0x0159:
        r0 = r0 + 1;
        goto L_0x013d;
    L_0x015c:
        r12 = move-exception;
        r13 = f1662a;
        r14 = "Error calling gonative://nativebridge/multi";
        android.util.Log.e(r13, r14, r12);
    L_0x0164:
        return r1;
    L_0x0165:
        r12 = r2.getHost();
        r13 = "config";
        r12 = r13.equals(r12);
        if (r12 == 0) goto L_0x017c;
    L_0x0171:
        r12 = new io.gonative.android.b;
        r13 = r11.f1663b;
        r12.<init>(r13);
        r12.m1913a(r2);
        return r1;
    L_0x017c:
        r12 = r2.getHost();
        r13 = "screen";
        r12 = r13.equals(r12);
        r13 = "true";
        r14 = "1";
        if (r12 == 0) goto L_0x021a;
    L_0x018c:
        r12 = r2.getPath();
        r3 = "/setBrightness";
        r12 = r3.equals(r12);
        if (r12 == 0) goto L_0x0219;
    L_0x0198:
        r12 = "brightness";
        r12 = r2.getQueryParameter(r12);
        if (r12 != 0) goto L_0x01bb;
    L_0x01a0:
        r12 = f1662a;
        r13 = new java.lang.StringBuilder;
        r13.<init>();
        r14 = "Brightness not specified in ";
        r13.append(r14);
        r14 = r2.toString();
        r13.append(r14);
        r13 = r13.toString();
        android.util.Log.e(r12, r13);
        return r1;
    L_0x01bb:
        r3 = "default";
        r3 = r12.equals(r3);
        if (r3 == 0) goto L_0x01cb;
    L_0x01c3:
        r12 = r11.f1663b;
        r12.m2588a(r7);
        r11.f1669h = r0;
        return r1;
    L_0x01cb:
        r12 = java.lang.Float.parseFloat(r12);	 Catch:{ Exception -> 0x0211 }
        r0 = 0;	 Catch:{ Exception -> 0x0211 }
        r0 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1));	 Catch:{ Exception -> 0x0211 }
        if (r0 < 0) goto L_0x01f6;	 Catch:{ Exception -> 0x0211 }
    L_0x01d4:
        r3 = (double) r12;	 Catch:{ Exception -> 0x0211 }
        r5 = 4607182418800017408; // 0x3ff0000000000000 float:0.0 double:1.0;	 Catch:{ Exception -> 0x0211 }
        r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));	 Catch:{ Exception -> 0x0211 }
        if (r0 <= 0) goto L_0x01dc;	 Catch:{ Exception -> 0x0211 }
    L_0x01db:
        goto L_0x01f6;	 Catch:{ Exception -> 0x0211 }
    L_0x01dc:
        r0 = r11.f1663b;	 Catch:{ Exception -> 0x0211 }
        r0.m2588a(r12);	 Catch:{ Exception -> 0x0211 }
        r12 = "restoreOnNavigation";	 Catch:{ Exception -> 0x0211 }
        r12 = r2.getQueryParameter(r12);	 Catch:{ Exception -> 0x0211 }
        r13 = r13.equals(r12);	 Catch:{ Exception -> 0x0211 }
        if (r13 != 0) goto L_0x01f3;	 Catch:{ Exception -> 0x0211 }
    L_0x01ed:
        r12 = r14.equals(r12);	 Catch:{ Exception -> 0x0211 }
        if (r12 == 0) goto L_0x0219;	 Catch:{ Exception -> 0x0211 }
    L_0x01f3:
        r11.f1669h = r1;	 Catch:{ Exception -> 0x0211 }
        goto L_0x0219;	 Catch:{ Exception -> 0x0211 }
    L_0x01f6:
        r12 = f1662a;	 Catch:{ Exception -> 0x0211 }
        r13 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0211 }
        r13.<init>();	 Catch:{ Exception -> 0x0211 }
        r14 = "Invalid brightness value in ";	 Catch:{ Exception -> 0x0211 }
        r13.append(r14);	 Catch:{ Exception -> 0x0211 }
        r14 = r2.toString();	 Catch:{ Exception -> 0x0211 }
        r13.append(r14);	 Catch:{ Exception -> 0x0211 }
        r13 = r13.toString();	 Catch:{ Exception -> 0x0211 }
        android.util.Log.e(r12, r13);	 Catch:{ Exception -> 0x0211 }
        return r1;
    L_0x0211:
        r12 = move-exception;
        r13 = f1662a;
        r14 = "Error parsing brightness";
        android.util.Log.e(r13, r14, r12);
    L_0x0219:
        return r1;
    L_0x021a:
        r12 = r2.getHost();
        r5 = "navigationTitles";
        r12 = r5.equals(r12);
        r5 = "persist";
        r7 = "/set";
        if (r12 == 0) goto L_0x028a;
    L_0x022a:
        r12 = r2.getPath();
        r12 = r7.equals(r12);
        if (r12 == 0) goto L_0x0267;
    L_0x0234:
        r12 = r2.getQueryParameter(r4);
        r2 = r2.getQueryParameter(r5);
        r14 = r14.equals(r2);
        if (r14 != 0) goto L_0x0248;
    L_0x0242:
        r13 = r13.equals(r2);
        if (r13 == 0) goto L_0x0249;
    L_0x0248:
        r0 = 1;
    L_0x0249:
        if (r12 == 0) goto L_0x0263;
    L_0x024b:
        r13 = r12.isEmpty();
        if (r13 != 0) goto L_0x0263;
    L_0x0251:
        r13 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x025a }
        r13.<init>(r12);	 Catch:{ JSONException -> 0x025a }
        r3.m1891b(r13, r0);	 Catch:{ JSONException -> 0x025a }
        goto L_0x0289;
    L_0x025a:
        r12 = move-exception;
        r13 = f1662a;
        r14 = "Error parsing navigationTitles";
        android.util.Log.e(r13, r14, r12);
        goto L_0x0289;
    L_0x0263:
        r3.m1891b(r9, r0);
        goto L_0x0289;
    L_0x0267:
        r12 = r2.getPath();
        r13 = "/setCurrent";
        r12 = r13.equals(r12);
        if (r12 == 0) goto L_0x0289;
    L_0x0273:
        r12 = "title";
        r12 = r2.getQueryParameter(r12);
        if (r12 == 0) goto L_0x0281;
    L_0x027b:
        r13 = r11.f1663b;
        r13.setTitle(r12);
        goto L_0x0289;
    L_0x0281:
        r12 = r11.f1663b;
        r13 = 2131492906; // 0x7f0c002a float:1.8609277E38 double:1.053097419E-314;
        r12.setTitle(r13);
    L_0x0289:
        return r1;
    L_0x028a:
        r12 = r2.getHost();
        r10 = "navigationLevels";
        r12 = r10.equals(r12);
        if (r12 == 0) goto L_0x02d3;
    L_0x0296:
        r12 = r2.getPath();
        r12 = r7.equals(r12);
        if (r12 == 0) goto L_0x02d2;
    L_0x02a0:
        r12 = r2.getQueryParameter(r4);
        r2 = r2.getQueryParameter(r5);
        r14 = r14.equals(r2);
        if (r14 != 0) goto L_0x02b4;
    L_0x02ae:
        r13 = r13.equals(r2);
        if (r13 == 0) goto L_0x02b5;
    L_0x02b4:
        r0 = 1;
    L_0x02b5:
        if (r12 == 0) goto L_0x02cf;
    L_0x02b7:
        r13 = r12.isEmpty();
        if (r13 != 0) goto L_0x02cf;
    L_0x02bd:
        r13 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x02c6 }
        r13.<init>(r12);	 Catch:{ JSONException -> 0x02c6 }
        r3.m1889a(r13, r0);	 Catch:{ JSONException -> 0x02c6 }
        goto L_0x02d2;
    L_0x02c6:
        r12 = move-exception;
        r13 = f1662a;
        r14 = "Error parsing navigationLevels";
        android.util.Log.e(r13, r14, r12);
        goto L_0x02d2;
    L_0x02cf:
        r3.m1889a(r9, r0);
    L_0x02d2:
        return r1;
    L_0x02d3:
        r12 = r2.getHost();
        r5 = "sidebar";
        r12 = r5.equals(r12);
        if (r12 == 0) goto L_0x030c;
    L_0x02df:
        r12 = r2.getPath();
        r13 = "/setItems";
        r12 = r13.equals(r12);
        if (r12 == 0) goto L_0x030b;
    L_0x02eb:
        r12 = "items";
        r12 = r2.getQueryParameter(r12);
        if (r12 == 0) goto L_0x030b;
    L_0x02f3:
        r13 = new org.json.JSONTokener;	 Catch:{ JSONException -> 0x0306 }
        r13.<init>(r12);	 Catch:{ JSONException -> 0x0306 }
        r12 = r13.nextValue();	 Catch:{ JSONException -> 0x0306 }
        r13 = r11.f1663b;	 Catch:{ JSONException -> 0x0306 }
        r13 = io.gonative.android.p038a.C0700a.m1851a(r13);	 Catch:{ JSONException -> 0x0306 }
        r13.m1888a(r12);	 Catch:{ JSONException -> 0x0306 }
        goto L_0x030b;
    L_0x0306:
        r12 = f1662a;
        android.util.Log.d(r12, r6);
    L_0x030b:
        return r1;
    L_0x030c:
        r12 = r2.getHost();
        r5 = "share";
        r12 = r5.equals(r12);
        if (r12 == 0) goto L_0x032e;
    L_0x0318:
        r12 = r2.getPath();
        r13 = "/sharePage";
        r12 = r13.equals(r12);
        if (r12 == 0) goto L_0x032d;
    L_0x0324:
        r12 = r2.getQueryParameter(r8);
        r13 = r11.f1663b;
        r13.m2612g(r12);
    L_0x032d:
        return r1;
    L_0x032e:
        r12 = r2.getHost();
        r5 = "tabs";
        r12 = r5.equals(r12);
        if (r12 == 0) goto L_0x03b0;
    L_0x033a:
        r12 = r11.f1663b;
        r12 = r12.m2621m();
        if (r12 != 0) goto L_0x0343;
    L_0x0342:
        return r1;
    L_0x0343:
        r13 = r2.getPath();
        r14 = "/select/";
        r13 = r13.startsWith(r14);
        if (r13 == 0) goto L_0x0382;
    L_0x034f:
        r13 = r2.getPathSegments();
        r14 = r13.size();
        r0 = 2;
        if (r14 != r0) goto L_0x03af;
    L_0x035a:
        r13 = r13.get(r1);
        r13 = (java.lang.String) r13;
        r14 = java.lang.Integer.parseInt(r13);	 Catch:{ NumberFormatException -> 0x036a }
        if (r14 < 0) goto L_0x03af;	 Catch:{ NumberFormatException -> 0x036a }
    L_0x0366:
        r12.m2385b(r14);	 Catch:{ NumberFormatException -> 0x036a }
        goto L_0x03af;
    L_0x036a:
        r12 = move-exception;
        r14 = f1662a;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r2 = "Invalid tab number ";
        r0.append(r2);
        r0.append(r13);
        r13 = r0.toString();
        android.util.Log.e(r14, r13, r12);
        return r1;
    L_0x0382:
        r13 = r2.getPath();
        r14 = "/deselect";
        r13 = r14.equals(r13);
        if (r13 == 0) goto L_0x0394;
    L_0x038e:
        r12 = r11.f1663b;
        r12.m2607e();
        goto L_0x03af;
    L_0x0394:
        r13 = r2.getPath();
        r14 = "/setTabs";
        r13 = r14.equals(r13);
        if (r13 == 0) goto L_0x03af;
    L_0x03a0:
        r13 = r2.getQueryParameter(r5);
        if (r13 == 0) goto L_0x03af;
    L_0x03a6:
        r14 = r13.isEmpty();
        if (r14 != 0) goto L_0x03af;
    L_0x03ac:
        r12.m2387c(r13);
    L_0x03af:
        return r1;
    L_0x03b0:
        r12 = r2.getHost();
        r5 = "facebook";
        r12 = r5.equals(r12);
        if (r12 == 0) goto L_0x0453;
    L_0x03bc:
        r12 = r3.Wa;
        if (r12 != 0) goto L_0x03c1;
    L_0x03c0:
        return r1;
    L_0x03c1:
        r12 = r2.getPath();
        r13 = "/events/sendPurchase";
        r12 = r13.equals(r12);
        if (r12 != 0) goto L_0x03d9;
    L_0x03cd:
        r13 = r2.getPath();
        r14 = "/events/send";
        r13 = r14.equals(r13);
        if (r13 == 0) goto L_0x0452;
    L_0x03d9:
        r13 = r2.getQueryParameter(r4);
        if (r13 == 0) goto L_0x0452;
    L_0x03df:
        r14 = r13.isEmpty();
        if (r14 == 0) goto L_0x03e6;
    L_0x03e5:
        goto L_0x0452;
    L_0x03e6:
        r14 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x044a, IllegalArgumentException -> 0x0444 }
        r14.<init>(r13);	 Catch:{ JSONException -> 0x044a, IllegalArgumentException -> 0x0444 }
        r13 = "parameters";	 Catch:{ JSONException -> 0x044a, IllegalArgumentException -> 0x0444 }
        r13 = r14.optJSONObject(r13);	 Catch:{ JSONException -> 0x044a, IllegalArgumentException -> 0x0444 }
        if (r13 == 0) goto L_0x03f7;	 Catch:{ JSONException -> 0x044a, IllegalArgumentException -> 0x0444 }
    L_0x03f3:
        r9 = io.gonative.android.C0726s.m1963a(r13);	 Catch:{ JSONException -> 0x044a, IllegalArgumentException -> 0x0444 }
    L_0x03f7:
        if (r12 != 0) goto L_0x041c;	 Catch:{ JSONException -> 0x044a, IllegalArgumentException -> 0x0444 }
    L_0x03f9:
        r12 = "event";	 Catch:{ JSONException -> 0x044a, IllegalArgumentException -> 0x0444 }
        r12 = io.gonative.android.C0726s.m1968a(r14, r12);	 Catch:{ JSONException -> 0x044a, IllegalArgumentException -> 0x0444 }
        if (r12 != 0) goto L_0x0402;	 Catch:{ JSONException -> 0x044a, IllegalArgumentException -> 0x0444 }
    L_0x0401:
        return r1;	 Catch:{ JSONException -> 0x044a, IllegalArgumentException -> 0x0444 }
    L_0x0402:
        r13 = "valueToSum";	 Catch:{ JSONException -> 0x044a, IllegalArgumentException -> 0x0444 }
        r13 = r14.optDouble(r13);	 Catch:{ JSONException -> 0x044a, IllegalArgumentException -> 0x0444 }
        r0 = r11.f1663b;	 Catch:{ JSONException -> 0x044a, IllegalArgumentException -> 0x0444 }
        r0 = com.facebook.p029a.C0422r.m795b(r0);	 Catch:{ JSONException -> 0x044a, IllegalArgumentException -> 0x0444 }
        r2 = java.lang.Double.isNaN(r13);	 Catch:{ JSONException -> 0x044a, IllegalArgumentException -> 0x0444 }
        if (r2 == 0) goto L_0x0418;	 Catch:{ JSONException -> 0x044a, IllegalArgumentException -> 0x0444 }
    L_0x0414:
        r0.m805a(r12, r9);	 Catch:{ JSONException -> 0x044a, IllegalArgumentException -> 0x0444 }
        goto L_0x0452;	 Catch:{ JSONException -> 0x044a, IllegalArgumentException -> 0x0444 }
    L_0x0418:
        r0.m804a(r12, r13, r9);	 Catch:{ JSONException -> 0x044a, IllegalArgumentException -> 0x0444 }
        goto L_0x0452;	 Catch:{ JSONException -> 0x044a, IllegalArgumentException -> 0x0444 }
    L_0x041c:
        r12 = "purchaseAmount";	 Catch:{ JSONException -> 0x044a, IllegalArgumentException -> 0x0444 }
        r12 = r14.optDouble(r12);	 Catch:{ JSONException -> 0x044a, IllegalArgumentException -> 0x0444 }
        r0 = java.lang.Double.isNaN(r12);	 Catch:{ JSONException -> 0x044a, IllegalArgumentException -> 0x0444 }
        if (r0 == 0) goto L_0x0429;	 Catch:{ JSONException -> 0x044a, IllegalArgumentException -> 0x0444 }
    L_0x0428:
        return r1;	 Catch:{ JSONException -> 0x044a, IllegalArgumentException -> 0x0444 }
    L_0x0429:
        r0 = "currency";	 Catch:{ JSONException -> 0x044a, IllegalArgumentException -> 0x0444 }
        r14 = io.gonative.android.C0726s.m1968a(r14, r0);	 Catch:{ JSONException -> 0x044a, IllegalArgumentException -> 0x0444 }
        if (r14 != 0) goto L_0x0432;	 Catch:{ JSONException -> 0x044a, IllegalArgumentException -> 0x0444 }
    L_0x0431:
        return r1;	 Catch:{ JSONException -> 0x044a, IllegalArgumentException -> 0x0444 }
    L_0x0432:
        r14 = java.util.Currency.getInstance(r14);	 Catch:{ JSONException -> 0x044a, IllegalArgumentException -> 0x0444 }
        r0 = r11.f1663b;	 Catch:{ JSONException -> 0x044a, IllegalArgumentException -> 0x0444 }
        r0 = com.facebook.p029a.C0422r.m795b(r0);	 Catch:{ JSONException -> 0x044a, IllegalArgumentException -> 0x0444 }
        r12 = java.math.BigDecimal.valueOf(r12);	 Catch:{ JSONException -> 0x044a, IllegalArgumentException -> 0x0444 }
        r0.m808a(r12, r14, r9);	 Catch:{ JSONException -> 0x044a, IllegalArgumentException -> 0x0444 }
        goto L_0x0452;
    L_0x0444:
        r12 = move-exception;
        r13 = f1662a;
        r14 = "Error creating facebook app event";
        goto L_0x044f;
    L_0x044a:
        r12 = move-exception;
        r13 = f1662a;
        r14 = "Error parsing json for facebook event";
    L_0x044f:
        android.util.Log.e(r13, r14, r12);
    L_0x0452:
        return r1;
    L_0x0453:
        r12 = r2.getHost();
        r3 = "onesignal";
        r12 = r3.equals(r12);
        r3 = "callback";
        if (r12 == 0) goto L_0x04fa;
    L_0x0461:
        r12 = r2.getPath();
        r4 = "/tags/get";
        r12 = r4.equals(r12);
        if (r12 == 0) goto L_0x0483;
    L_0x046d:
        r12 = r2.getQueryParameter(r3);
        if (r12 == 0) goto L_0x0482;
    L_0x0473:
        r13 = r12.isEmpty();
        if (r13 == 0) goto L_0x047a;
    L_0x0479:
        goto L_0x0482;
    L_0x047a:
        r13 = new io.gonative.android.oa;
        r13.<init>(r11, r12);
        com.onesignal.sa.m1676b(r13);
    L_0x0482:
        return r1;
    L_0x0483:
        r12 = r2.getPath();
        r4 = "/tags/set";
        r12 = r4.equals(r12);
        if (r12 == 0) goto L_0x04b0;
    L_0x048f:
        r12 = "tags";
        r12 = r2.getQueryParameter(r12);
        if (r12 == 0) goto L_0x04af;
    L_0x0497:
        r13 = r12.isEmpty();
        if (r13 == 0) goto L_0x049e;
    L_0x049d:
        goto L_0x04af;
    L_0x049e:
        r13 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x04a7 }
        r13.<init>(r12);	 Catch:{ JSONException -> 0x04a7 }
        com.onesignal.sa.m1678b(r13);	 Catch:{ JSONException -> 0x04a7 }
        goto L_0x04af;
    L_0x04a7:
        r12 = move-exception;
        r13 = f1662a;
        r14 = "Error parsing tags JSON";
        android.util.Log.e(r13, r14, r12);
    L_0x04af:
        return r1;
    L_0x04b0:
        r12 = r2.getPath();
        r4 = "/promptLocation";
        r12 = r4.equals(r12);
        if (r12 == 0) goto L_0x04c0;
    L_0x04bc:
        com.onesignal.sa.m1623H();
        return r1;
    L_0x04c0:
        r12 = r2.getPath();
        r4 = "/userPrivacyConsent/grant";
        r12 = r4.equals(r12);
        if (r12 == 0) goto L_0x04d0;
    L_0x04cc:
        com.onesignal.sa.m1714h(r1);
        return r1;
    L_0x04d0:
        r12 = r2.getPath();
        r4 = "/userPrivacyConsent/revoke";
        r12 = r4.equals(r12);
        if (r12 == 0) goto L_0x04e0;
    L_0x04dc:
        com.onesignal.sa.m1714h(r0);
        return r1;
    L_0x04e0:
        r12 = r2.getPath();
        r0 = "/showTagsUI";
        r12 = r0.equals(r12);
        if (r12 == 0) goto L_0x04fa;
    L_0x04ec:
        r12 = new android.content.Intent;
        r0 = r11.f1663b;
        r4 = io.gonative.android.SubscriptionsActivity.class;
        r12.<init>(r0, r4);
        r0 = r11.f1663b;
        r0.startActivity(r12);
    L_0x04fa:
        r12 = r2.getHost();
        r0 = "connectivity";
        r12 = r0.equals(r12);
        if (r12 == 0) goto L_0x054f;
    L_0x0506:
        r12 = r2.getQueryParameter(r3);
        r0 = r2.getPath();
        r3 = "/get";
        r0 = r3.equals(r0);
        if (r0 == 0) goto L_0x0524;
    L_0x0516:
        if (r12 == 0) goto L_0x054f;
    L_0x0518:
        r0 = r12.isEmpty();
        if (r0 != 0) goto L_0x054f;
    L_0x051e:
        r0 = r11.f1663b;
        r0.m2610f(r12);
        goto L_0x054f;
    L_0x0524:
        r0 = r2.getPath();
        r3 = "/subscribe";
        r0 = r3.equals(r0);
        if (r0 == 0) goto L_0x053e;
    L_0x0530:
        if (r12 == 0) goto L_0x054f;
    L_0x0532:
        r0 = r12.isEmpty();
        if (r0 != 0) goto L_0x054f;
    L_0x0538:
        r0 = r11.f1663b;
        r0.m2614h(r12);
        goto L_0x054f;
    L_0x053e:
        r12 = r2.getPath();
        r0 = "/unsubscribe";
        r12 = r0.equals(r12);
        if (r12 == 0) goto L_0x054f;
    L_0x054a:
        r12 = r11.f1663b;
        r12.m2631w();
    L_0x054f:
        r12 = r2.getHost();
        r0 = "statusbar";
        r12 = r0.equals(r12);
        if (r12 == 0) goto L_0x060a;
    L_0x055b:
        r12 = r2.getPath();
        r12 = r7.equals(r12);
        if (r12 == 0) goto L_0x060a;
    L_0x0565:
        r12 = "style";
        r12 = r2.getQueryParameter(r12);
        if (r12 == 0) goto L_0x05ae;
    L_0x056d:
        r0 = r12.isEmpty();
        if (r0 != 0) goto L_0x05ae;
    L_0x0573:
        r0 = android.os.Build.VERSION.SDK_INT;
        r3 = 23;
        if (r0 < r3) goto L_0x05ae;
    L_0x0579:
        r0 = "light";
        r0 = r12.equals(r0);
        if (r0 == 0) goto L_0x0595;
    L_0x0581:
        r12 = r11.f1663b;
        r12 = r12.getWindow();
        r12 = r12.getDecorView();
        r0 = r12.getSystemUiVisibility();
        r0 = r0 & -8193;
    L_0x0591:
        r12.setSystemUiVisibility(r0);
        goto L_0x05ae;
    L_0x0595:
        r0 = "dark";
        r12 = r12.equals(r0);
        if (r12 == 0) goto L_0x05ae;
    L_0x059d:
        r12 = r11.f1663b;
        r12 = r12.getWindow();
        r12 = r12.getDecorView();
        r0 = r12.getSystemUiVisibility();
        r0 = r0 | 8192;
        goto L_0x0591;
    L_0x05ae:
        r12 = "color";
        r12 = r2.getQueryParameter(r12);
        r12 = io.gonative.android.C0726s.m1974c(r12);
        if (r12 == 0) goto L_0x05cd;
    L_0x05ba:
        r0 = android.os.Build.VERSION.SDK_INT;
        r3 = 21;
        if (r0 < r3) goto L_0x05cd;
    L_0x05c0:
        r0 = r11.f1663b;
        r0 = r0.getWindow();
        r12 = r12.intValue();
        r0.setStatusBarColor(r12);
    L_0x05cd:
        r12 = "overlay";
        r12 = r2.getQueryParameter(r12);
        if (r12 == 0) goto L_0x060a;
    L_0x05d5:
        r13 = r12.equals(r13);
        if (r13 != 0) goto L_0x05f5;
    L_0x05db:
        r12 = r12.equals(r14);
        if (r12 == 0) goto L_0x05e2;
    L_0x05e1:
        goto L_0x05f5;
    L_0x05e2:
        r12 = r11.f1663b;
        r12 = r12.getWindow();
        r12 = r12.getDecorView();
        r13 = r12.getSystemUiVisibility();
        r13 = r13 & -1025;
        r13 = r13 & -257;
        goto L_0x0607;
    L_0x05f5:
        r12 = r11.f1663b;
        r12 = r12.getWindow();
        r12 = r12.getDecorView();
        r13 = r12.getSystemUiVisibility();
        r13 = r13 | 1024;
        r13 = r13 | 256;
    L_0x0607:
        r12.setSystemUiVisibility(r13);
    L_0x060a:
        return r1;
    L_0x060b:
        r4 = r3.f1521Q;
        if (r4 == 0) goto L_0x0637;
    L_0x060f:
        r4 = r4.get(r13);
        r4 = (java.lang.String) r4;
        if (r4 != 0) goto L_0x0621;
    L_0x0617:
        r4 = r3.f1521Q;
        r5 = "*";
        r4 = r4.get(r5);
        r4 = (java.lang.String) r4;
    L_0x0621:
        if (r4 == 0) goto L_0x0637;
    L_0x0623:
        r5 = r4.equals(r13);
        if (r5 != 0) goto L_0x0637;
    L_0x0629:
        if (r14 == 0) goto L_0x062c;
    L_0x062b:
        return r1;
    L_0x062c:
        r12 = r11.f1663b;
        r13 = new io.gonative.android.pa;
        r13.<init>(r11, r4);
        r12.runOnUiThread(r13);
        return r1;
    L_0x0637:
        r4 = r11.m1988a(r2);
        if (r4 != 0) goto L_0x0658;
    L_0x063d:
        if (r14 == 0) goto L_0x0640;
    L_0x063f:
        return r1;
    L_0x0640:
        r12 = new android.content.Intent;
        r13 = "android.intent.action.VIEW";
        r12.<init>(r13, r2);
        r13 = r11.f1663b;	 Catch:{ ActivityNotFoundException -> 0x064d }
        r13.startActivity(r12);	 Catch:{ ActivityNotFoundException -> 0x064d }
        goto L_0x0657;
    L_0x064d:
        r12 = move-exception;
        r13 = f1662a;
        r14 = r12.getMessage();
        android.util.Log.e(r13, r14, r12);
    L_0x0657:
        return r1;
    L_0x0658:
        r2 = r11.f1669h;
        if (r2 == 0) goto L_0x0663;
    L_0x065c:
        r2 = r11.f1663b;
        r2.m2588a(r7);
        r11.f1669h = r0;
    L_0x0663:
        r2 = r11.f1663b;
        r2 = r2.m2622n();
        r4 = r11.f1663b;
        r4 = r4.m2618j(r13);
        if (r2 < 0) goto L_0x06d6;
    L_0x0671:
        if (r4 < 0) goto L_0x06d6;
    L_0x0673:
        r5 = "postLoadJavascript";
        if (r4 <= r2) goto L_0x06a9;
    L_0x0677:
        if (r14 == 0) goto L_0x067a;
    L_0x0679:
        return r1;
    L_0x067a:
        r12 = new android.content.Intent;
        r14 = r11.f1663b;
        r14 = r14.getBaseContext();
        r3 = io.gonative.android.MainActivity.class;
        r12.<init>(r14, r3);
        r14 = "isRoot";
        r12.putExtra(r14, r0);
        r12.putExtra(r8, r13);
        r13 = "parentUrlLevel";
        r12.putExtra(r13, r2);
        r13 = r11.f1663b;
        r13 = r13.f2020N;
        r12.putExtra(r5, r13);
        r13 = r11.f1663b;
        r14 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        r13.startActivityForResult(r12, r14);
        r12 = r11.f1663b;
        r12.f2020N = r9;
        r12.f2021O = r9;
        return r1;
    L_0x06a9:
        if (r4 >= r2) goto L_0x06d6;
    L_0x06ab:
        r2 = r11.f1663b;
        r2 = r2.m2617j();
        if (r4 > r2) goto L_0x06d6;
    L_0x06b3:
        if (r14 == 0) goto L_0x06b6;
    L_0x06b5:
        return r1;
    L_0x06b6:
        r12 = new android.content.Intent;
        r12.<init>();
        r12.putExtra(r8, r13);
        r13 = "urlLevel";
        r12.putExtra(r13, r4);
        r13 = r11.f1663b;
        r13 = r13.f2020N;
        r12.putExtra(r5, r13);
        r13 = r11.f1663b;
        r14 = -1;
        r13.setResult(r14, r12);
        r12 = r11.f1663b;
        r12.finish();
        return r1;
    L_0x06d6:
        if (r4 < 0) goto L_0x06dd;
    L_0x06d8:
        r2 = r11.f1663b;
        r2.m2589a(r4);
    L_0x06dd:
        r2 = r11.f1663b;
        r2 = r2.m2616i(r13);
        if (r2 == 0) goto L_0x06f1;
    L_0x06e5:
        if (r14 != 0) goto L_0x06f1;
    L_0x06e7:
        r4 = r11.f1663b;
        r5 = new io.gonative.android.qa;
        r5.<init>(r11, r2);
        r4.runOnUiThread(r5);
    L_0x06f1:
        if (r14 != 0) goto L_0x06fd;
    L_0x06f3:
        r2 = r11.f1663b;
        r4 = new io.gonative.android.ra;
        r4.<init>(r11, r3, r13);
        r2.runOnUiThread(r4);
    L_0x06fd:
        r2 = r11.f1663b;
        r2 = r2.getApplication();
        r2 = (io.gonative.android.GoNativeApplication) r2;
        r2 = r2.m1814c();
        r3 = r2.m1799a(r13);
        r4 = r3.first;
        r4 = (io.gonative.android.C0720m) r4;
        r3 = r3.second;
        r3 = (io.gonative.android.Ba) r3;
        if (r14 == 0) goto L_0x071a;
    L_0x0717:
        if (r4 == 0) goto L_0x071a;
    L_0x0719:
        return r1;
    L_0x071a:
        if (r4 == 0) goto L_0x073e;
    L_0x071c:
        r14 = io.gonative.android.Ba.Always;
        if (r3 != r14) goto L_0x073e;
    L_0x0720:
        r12 = r11.f1663b;
        r14 = new io.gonative.android.sa;
        r14.<init>(r11, r4, r13);
        r12.runOnUiThread(r14);
        r2.m1801a(r4);
        r12 = r11.f1663b;
        r12 = android.support.v4.content.LocalBroadcastManager.getInstance(r12);
        r13 = new android.content.Intent;
        r14 = "io.gonative.android.webview.finished";
        r13.<init>(r14);
        r12.sendBroadcast(r13);
        return r1;
    L_0x073e:
        if (r4 == 0) goto L_0x074f;
    L_0x0740:
        r14 = io.gonative.android.Ba.Never;
        if (r3 != r14) goto L_0x074f;
    L_0x0744:
        r12 = r11.f1663b;
        r14 = new io.gonative.android.ta;
        r14.<init>(r11, r4, r13);
        r12.runOnUiThread(r14);
        return r1;
    L_0x074f:
        if (r4 == 0) goto L_0x0768;
    L_0x0751:
        r14 = io.gonative.android.Ba.Reload;
        if (r3 != r14) goto L_0x0768;
    L_0x0755:
        r14 = r11.f1665d;
        r14 = io.gonative.android.C0726s.m1971a(r13, r14);
        if (r14 != 0) goto L_0x0768;
    L_0x075d:
        r12 = r11.f1663b;
        r14 = new io.gonative.android.ua;
        r14.<init>(r11, r4, r13);
        r12.runOnUiThread(r14);
        return r1;
    L_0x0768:
        r13 = r11.f1663b;
        r13 = r13.f2032c;
        if (r13 == 0) goto L_0x0775;
    L_0x076e:
        r2.m1801a(r12);
        r12 = r11.f1663b;
        r12.f2032c = r0;
    L_0x0775:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.gonative.android.wa.c(io.gonative.android.m, java.lang.String, boolean):boolean");
    }

    /* renamed from: a */
    public WebResourceResponse m1993a(LeanWebView leanWebView, String str) {
        return this.f1666e.m1944a(leanWebView, str, this.f1665d);
    }

    /* renamed from: a */
    public void m1994a(SslError sslError) {
        int primaryError = sslError.getPrimaryError();
        if (primaryError != 0) {
            if (primaryError == 1) {
                primaryError = R.string.ssl_error_expired;
            } else if (!(primaryError == 2 || primaryError == 3 || primaryError == 4)) {
                primaryError = R.string.ssl_error_generic;
            }
            Toast.makeText(this.f1663b, primaryError, 1).show();
        }
        primaryError = R.string.ssl_error_cert;
        Toast.makeText(this.f1663b, primaryError, 1).show();
    }

    /* renamed from: a */
    public void m1995a(C0720m c0720m, int i) {
        this.f1663b.runOnUiThread(new ma(this));
        if (C0700a.m1851a(this.f1663b).f1523S && this.f1663b.m2625q()) {
            c0720m.mo1404b("file:///android_asset/offline.html");
        }
    }

    @SuppressLint({"ApplySharedPref"})
    /* renamed from: a */
    public void m1996a(C0720m c0720m, String str) {
        this.f1665d = str;
        C0700a a = C0700a.m1851a(this.f1663b);
        if (str != null) {
            ArrayList arrayList = a.aa;
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    if (((Pattern) it.next()).matcher(str).matches()) {
                        return;
                    }
                }
            }
        }
        this.f1663b.runOnUiThread(new va(this));
        ka.m1932a().m1935a(str);
        if (m1988a(Uri.parse(str))) {
            CookieSyncManager.getInstance().sync();
        }
        if (a.f1512H != null) {
            boolean z;
            if (this.f1667f) {
                this.f1663b.m2632x();
            }
            if (!C0726s.m1971a(str, a.Aa)) {
                if (!C0726s.m1971a(str, a.Da)) {
                    z = false;
                    this.f1667f = z;
                }
            }
            z = true;
            this.f1667f = z;
        }
        String str2 = a.wb;
        if (str2 != null) {
            c0720m.mo1402a(str2);
        }
        str2 = this.f1664c;
        if (str2 != null) {
            c0720m.mo1402a(str2);
        }
        this.f1663b.m2601b(str);
        MainActivity mainActivity = this.f1663b;
        str = mainActivity.f2020N;
        if (str != null) {
            mainActivity.f2020N = null;
            mainActivity.m2608e(str);
        }
        LocalBroadcastManager.getInstance(this.f1663b).sendBroadcast(new Intent("io.gonative.android.webview.finished"));
        String str3 = this.f1665d;
        if (str3 != null ? C0726s.m1970a(str3, this.f1663b) : true) {
            Object valueOf;
            Map a2 = C0723p.m1949a(this.f1663b);
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f1663b);
            str2 = "hasLaunched";
            String str4 = "isFirstLaunch";
            if (defaultSharedPreferences.getBoolean(str2, false)) {
                valueOf = Boolean.valueOf(false);
            } else {
                defaultSharedPreferences.edit().putBoolean(str2, true).commit();
                valueOf = Boolean.valueOf(true);
            }
            a2.put(str4, valueOf);
            this.f1663b.m2608e(C0726s.m1966a("gonative_device_info", new JSONObject(a2)));
        }
    }

    /* renamed from: a */
    public void m1997a(C0720m c0720m, String str, boolean z) {
        if (!z && !str.equals("file:///android_asset/offline.html")) {
            this.f1663b.m2594a(str);
        }
    }

    /* renamed from: a */
    public void m1998a(String str) {
        this.f1666e.m1945a(str);
        ka.m1932a().m1935a(str);
        Uri parse = Uri.parse(str);
        if (C0700a.m1851a(this.f1663b).f1512H != null && m1988a(parse)) {
            this.f1663b.m2632x();
        }
        this.f1663b.m2630v();
        this.f1663b.m2604c(str);
        LocalBroadcastManager.getInstance(this.f1663b).sendBroadcast(new Intent("io.gonative.android.webview.started"));
        if ("file:///android_asset/offline.html".equals(str)) {
            this.f1663b.m2609f();
        } else {
            this.f1663b.m2627s();
        }
    }

    /* renamed from: a */
    public boolean m1999a(Message message) {
        ((GoNativeApplication) this.f1663b.getApplication()).m1812a(message);
        return m1990b();
    }

    /* renamed from: a */
    public boolean m2000a(String[] strArr, boolean z) {
        this.f1663b.m2599a(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, new na(this, strArr, z));
        return true;
    }

    /* renamed from: b */
    public void m2001b(String str) {
        this.f1665d = str;
    }

    /* renamed from: b */
    public boolean m2002b(C0720m c0720m, String str) {
        return m2003b(c0720m, str, false);
    }

    /* renamed from: b */
    public boolean m2003b(C0720m c0720m, String str, boolean z) {
        if (str == null) {
            return false;
        }
        if (m1992c(c0720m, str, false)) {
            if (this.f1668g) {
                this.f1663b.finish();
            }
            return true;
        }
        this.f1668g = false;
        this.f1666e.m1945a(str);
        this.f1663b.m2624p();
        return false;
    }
}
