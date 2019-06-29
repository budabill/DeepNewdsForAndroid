package com.facebook.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.C0506l;
import com.facebook.C0560t;
import com.facebook.C0860n;
import com.facebook.login.C0513b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.facebook.internal.I */
public final class C0465I {
    /* renamed from: a */
    private static final String f815a = "com.facebook.internal.I";
    /* renamed from: b */
    private static final List<C0463e> f816b = C0465I.m935g();
    /* renamed from: c */
    private static final List<C0463e> f817c = C0465I.m934f();
    /* renamed from: d */
    private static final Map<String, List<C0463e>> f818d = C0465I.m933e();
    /* renamed from: e */
    private static final AtomicBoolean f819e = new AtomicBoolean(false);
    /* renamed from: f */
    private static final List<Integer> f820f = Arrays.asList(new Integer[]{Integer.valueOf(20170417), Integer.valueOf(20160327), Integer.valueOf(20141218), Integer.valueOf(20141107), Integer.valueOf(20141028), Integer.valueOf(20141001), Integer.valueOf(20140701), Integer.valueOf(20140324), Integer.valueOf(20140204), Integer.valueOf(20131107), Integer.valueOf(20130618), Integer.valueOf(20130502), Integer.valueOf(20121101)});

    /* renamed from: com.facebook.internal.I$e */
    private static abstract class C0463e {
        /* renamed from: a */
        private TreeSet<Integer> f812a;

        private C0463e() {
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        private synchronized void m903a(boolean r1) {
            /*
            r0 = this;
            monitor-enter(r0);
            if (r1 != 0) goto L_0x000f;
        L_0x0003:
            r1 = r0.f812a;	 Catch:{ all -> 0x0017 }
            if (r1 == 0) goto L_0x000f;
        L_0x0007:
            r1 = r0.f812a;	 Catch:{ all -> 0x0017 }
            r1 = r1.isEmpty();	 Catch:{ all -> 0x0017 }
            if (r1 == 0) goto L_0x0015;
        L_0x000f:
            r1 = com.facebook.internal.C0465I.m931c(r0);	 Catch:{ all -> 0x0017 }
            r0.f812a = r1;	 Catch:{ all -> 0x0017 }
        L_0x0015:
            monitor-exit(r0);
            return;
        L_0x0017:
            r1 = move-exception;
            monitor-exit(r0);
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.I.e.a(boolean):void");
        }

        /* renamed from: a */
        public TreeSet<Integer> m904a() {
            TreeSet treeSet = this.f812a;
            if (treeSet == null || treeSet.isEmpty()) {
                m903a(false);
            }
            return this.f812a;
        }

        /* renamed from: b */
        protected abstract String mo954b();

        /* renamed from: c */
        protected abstract String mo955c();
    }

    /* renamed from: com.facebook.internal.I$f */
    public static class C0464f {
        /* renamed from: a */
        private C0463e f813a;
        /* renamed from: b */
        private int f814b;

        private C0464f() {
        }

        /* renamed from: a */
        public static C0464f m907a() {
            C0464f c0464f = new C0464f();
            c0464f.f814b = -1;
            return c0464f;
        }

        /* renamed from: a */
        public static C0464f m908a(C0463e c0463e, int i) {
            C0464f c0464f = new C0464f();
            c0464f.f813a = c0463e;
            c0464f.f814b = i;
            return c0464f;
        }

        /* renamed from: b */
        public int m909b() {
            return this.f814b;
        }
    }

    /* renamed from: com.facebook.internal.I$a */
    private static class C0829a extends C0463e {
        private C0829a() {
            super();
        }

        /* renamed from: b */
        protected String mo954b() {
            return null;
        }

        /* renamed from: c */
        protected String mo955c() {
            return "com.facebook.arstudio.player";
        }
    }

    /* renamed from: com.facebook.internal.I$b */
    private static class C0830b extends C0463e {
        private C0830b() {
            super();
        }

        /* renamed from: b */
        protected String mo954b() {
            return "com.facebook.lite.platform.LoginGDPDialogActivity";
        }

        /* renamed from: c */
        protected String mo955c() {
            return "com.facebook.lite";
        }
    }

    /* renamed from: com.facebook.internal.I$c */
    private static class C0831c extends C0463e {
        private C0831c() {
            super();
        }

        /* renamed from: b */
        protected String mo954b() {
            return "com.facebook.katana.ProxyAuth";
        }

        /* renamed from: c */
        protected String mo955c() {
            return "com.facebook.katana";
        }
    }

    /* renamed from: com.facebook.internal.I$d */
    private static class C0832d extends C0463e {
        private C0832d() {
            super();
        }

        /* renamed from: b */
        protected String mo954b() {
            return null;
        }

        /* renamed from: c */
        protected String mo955c() {
            return "com.facebook.orca";
        }
    }

    /* renamed from: com.facebook.internal.I$g */
    private static class C0833g extends C0463e {
        private C0833g() {
            super();
        }

        /* renamed from: b */
        protected String mo954b() {
            return "com.facebook.katana.ProxyAuth";
        }

        /* renamed from: c */
        protected String mo955c() {
            return "com.facebook.wakizashi";
        }
    }

    /* renamed from: a */
    public static int m910a(int i) {
        return C0465I.m918a(f816b, new int[]{i}).m909b();
    }

    /* renamed from: a */
    public static int m911a(TreeSet<Integer> treeSet, int i, int[] iArr) {
        int length = iArr.length - 1;
        Iterator descendingIterator = treeSet.descendingIterator();
        int i2 = -1;
        int i3 = length;
        length = -1;
        while (descendingIterator.hasNext()) {
            int intValue = ((Integer) descendingIterator.next()).intValue();
            length = Math.max(length, intValue);
            while (i3 >= 0 && iArr[i3] > intValue) {
                i3--;
            }
            if (i3 < 0) {
                return -1;
            }
            if (iArr[i3] == intValue) {
                if (i3 % 2 == 0) {
                    i2 = Math.min(length, i);
                }
                return i2;
            }
        }
        return i2;
    }

    /* renamed from: a */
    public static Intent m912a(Context context) {
        for (C0463e c0463e : f816b) {
            Intent b = C0465I.m923b(context, new Intent("com.facebook.platform.PLATFORM_SERVICE").setPackage(c0463e.mo955c()).addCategory("android.intent.category.DEFAULT"), c0463e);
            if (b != null) {
                return b;
            }
        }
        return null;
    }

    /* renamed from: a */
    static Intent m913a(Context context, Intent intent, C0463e c0463e) {
        if (intent == null) {
            return null;
        }
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 0);
        return (resolveActivity != null && C0499u.m1090a(context, resolveActivity.activityInfo.packageName)) ? intent : null;
    }

    /* renamed from: a */
    public static Intent m914a(Context context, String str, Collection<String> collection, String str2, boolean z, boolean z2, C0513b c0513b, String str3, String str4) {
        C0463e c0830b = new C0830b();
        Context context2 = context;
        return C0465I.m913a(context, C0465I.m916a(c0830b, str, (Collection) collection, str2, z, z2, c0513b, str3, str4), c0830b);
    }

    /* renamed from: a */
    public static Intent m915a(Intent intent, Bundle bundle, C0506l c0506l) {
        UUID a = C0465I.m921a(intent);
        if (a == null) {
            return null;
        }
        Intent intent2 = new Intent();
        intent2.putExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", C0465I.m930c(intent));
        Bundle bundle2 = new Bundle();
        bundle2.putString("action_id", a.toString());
        if (c0506l != null) {
            bundle2.putBundle("error", C0465I.m917a(c0506l));
        }
        intent2.putExtra("com.facebook.platform.protocol.BRIDGE_ARGS", bundle2);
        if (bundle != null) {
            intent2.putExtra("com.facebook.platform.protocol.RESULT_ARGS", bundle);
        }
        return intent2;
    }

    /* renamed from: a */
    private static Intent m916a(C0463e c0463e, String str, Collection<String> collection, String str2, boolean z, boolean z2, C0513b c0513b, String str3, String str4) {
        String b = c0463e.mo954b();
        if (b == null) {
            return null;
        }
        Intent putExtra = new Intent().setClassName(c0463e.mo955c(), b).putExtra("client_id", str);
        putExtra.putExtra("facebook_sdk_version", C0560t.m1262n());
        if (!C0475Q.m992a((Collection) collection)) {
            putExtra.putExtra("scope", TextUtils.join(",", collection));
        }
        if (!C0475Q.m998b(str2)) {
            putExtra.putExtra("e2e", str2);
        }
        putExtra.putExtra("state", str3);
        putExtra.putExtra("response_type", "token,signed_request");
        putExtra.putExtra("return_scopes", "true");
        if (z2) {
            putExtra.putExtra("default_audience", c0513b.m1182a());
        }
        putExtra.putExtra("legacy_override", C0560t.m1260l());
        putExtra.putExtra("auth_type", str4);
        return putExtra;
    }

    /* renamed from: a */
    public static Bundle m917a(C0506l c0506l) {
        if (c0506l == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("error_description", c0506l.toString());
        if (c0506l instanceof C0860n) {
            bundle.putString("error_type", "UserCanceled");
        }
        return bundle;
    }

    /* renamed from: a */
    private static C0464f m918a(List<C0463e> list, int[] iArr) {
        C0465I.m932d();
        if (list == null) {
            return C0464f.m907a();
        }
        for (C0463e c0463e : list) {
            int a = C0465I.m911a(c0463e.m904a(), C0465I.m929c(), iArr);
            if (a != -1) {
                return C0464f.m908a(c0463e, a);
            }
        }
        return C0464f.m907a();
    }

    /* renamed from: a */
    public static C0506l m919a(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        String string = bundle.getString("error_type");
        if (string == null) {
            string = bundle.getString("com.facebook.platform.status.ERROR_TYPE");
        }
        String string2 = bundle.getString("error_description");
        if (string2 == null) {
            string2 = bundle.getString("com.facebook.platform.status.ERROR_DESCRIPTION");
        }
        return (string == null || !string.equalsIgnoreCase("UserCanceled")) ? new C0506l(string2) : new C0860n(string2);
    }

    /* renamed from: a */
    public static java.util.UUID m921a(android.content.Intent r2) {
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
        r0 = 0;
        if (r2 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = com.facebook.internal.C0465I.m930c(r2);
        r1 = com.facebook.internal.C0465I.m928b(r1);
        if (r1 == 0) goto L_0x001f;
    L_0x000e:
        r1 = "com.facebook.platform.protocol.BRIDGE_ARGS";
        r2 = r2.getBundleExtra(r1);
        if (r2 == 0) goto L_0x001d;
    L_0x0016:
        r1 = "action_id";
        r2 = r2.getString(r1);
        goto L_0x0025;
    L_0x001d:
        r2 = r0;
        goto L_0x0025;
    L_0x001f:
        r1 = "com.facebook.platform.protocol.CALL_ID";
        r2 = r2.getStringExtra(r1);
    L_0x0025:
        if (r2 == 0) goto L_0x002b;
    L_0x0027:
        r0 = java.util.UUID.fromString(r2);	 Catch:{ IllegalArgumentException -> 0x002b }
    L_0x002b:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.I.a(android.content.Intent):java.util.UUID");
    }

    /* renamed from: b */
    static Intent m923b(Context context, Intent intent, C0463e c0463e) {
        if (intent == null) {
            return null;
        }
        ResolveInfo resolveService = context.getPackageManager().resolveService(intent, 0);
        return (resolveService != null && C0499u.m1090a(context, resolveService.serviceInfo.packageName)) ? intent : null;
    }

    /* renamed from: b */
    public static Intent m924b(Context context, String str, Collection<String> collection, String str2, boolean z, boolean z2, C0513b c0513b, String str3, String str4) {
        for (C0463e c0463e : f816b) {
            Context context2 = context;
            Intent a = C0465I.m913a(context, C0465I.m916a(c0463e, str, (Collection) collection, str2, z, z2, c0513b, str3, str4), c0463e);
            if (a != null) {
                return a;
            }
        }
        return null;
    }

    /* renamed from: b */
    private static Uri m925b(C0463e c0463e) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("content://");
        stringBuilder.append(c0463e.mo955c());
        stringBuilder.append(".provider.PlatformProvider/versions");
        return Uri.parse(stringBuilder.toString());
    }

    /* renamed from: b */
    public static Bundle m926b(Intent intent) {
        return !C0465I.m928b(C0465I.m930c(intent)) ? intent.getExtras() : intent.getBundleExtra("com.facebook.platform.protocol.METHOD_ARGS");
    }

    /* renamed from: b */
    public static boolean m928b(int i) {
        return f820f.contains(Integer.valueOf(i)) && i >= 20140701;
    }

    /* renamed from: c */
    public static final int m929c() {
        return ((Integer) f820f.get(0)).intValue();
    }

    /* renamed from: c */
    public static int m930c(Intent intent) {
        return intent.getIntExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", 0);
    }

    /* renamed from: c */
    private static java.util.TreeSet<java.lang.Integer> m931c(com.facebook.internal.C0465I.C0463e r10) {
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
        r0 = "Failed to query content resolver.";
        r1 = new java.util.TreeSet;
        r1.<init>();
        r2 = com.facebook.C0560t.m1252d();
        r3 = r2.getContentResolver();
        r2 = 1;
        r5 = new java.lang.String[r2];
        r2 = "version";
        r4 = 0;
        r5[r4] = r2;
        r6 = com.facebook.internal.C0465I.m925b(r10);
        r9 = 0;
        r7 = com.facebook.C0560t.m1252d();	 Catch:{ all -> 0x0075 }
        r7 = r7.getPackageManager();	 Catch:{ all -> 0x0075 }
        r8 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0075 }
        r8.<init>();	 Catch:{ all -> 0x0075 }
        r10 = r10.mo955c();	 Catch:{ all -> 0x0075 }
        r8.append(r10);	 Catch:{ all -> 0x0075 }
        r10 = ".provider.PlatformProvider";	 Catch:{ all -> 0x0075 }
        r8.append(r10);	 Catch:{ all -> 0x0075 }
        r10 = r8.toString();	 Catch:{ all -> 0x0075 }
        r10 = r7.resolveContentProvider(r10, r4);	 Catch:{ RuntimeException -> 0x003e }
        goto L_0x0045;
    L_0x003e:
        r10 = move-exception;
        r4 = f815a;	 Catch:{ all -> 0x0075 }
        android.util.Log.e(r4, r0, r10);	 Catch:{ all -> 0x0075 }
        r10 = r9;
    L_0x0045:
        if (r10 == 0) goto L_0x006f;
    L_0x0047:
        r10 = 0;
        r7 = 0;
        r8 = 0;
        r4 = r6;
        r6 = r10;
        r10 = r3.query(r4, r5, r6, r7, r8);	 Catch:{ NullPointerException -> 0x0052, NullPointerException -> 0x0052, NullPointerException -> 0x0052 }
        r9 = r10;
        goto L_0x0057;
    L_0x0052:
        r10 = f815a;	 Catch:{ all -> 0x0075 }
        android.util.Log.e(r10, r0);	 Catch:{ all -> 0x0075 }
    L_0x0057:
        if (r9 == 0) goto L_0x006f;	 Catch:{ all -> 0x0075 }
    L_0x0059:
        r10 = r9.moveToNext();	 Catch:{ all -> 0x0075 }
        if (r10 == 0) goto L_0x006f;	 Catch:{ all -> 0x0075 }
    L_0x005f:
        r10 = r9.getColumnIndex(r2);	 Catch:{ all -> 0x0075 }
        r10 = r9.getInt(r10);	 Catch:{ all -> 0x0075 }
        r10 = java.lang.Integer.valueOf(r10);	 Catch:{ all -> 0x0075 }
        r1.add(r10);	 Catch:{ all -> 0x0075 }
        goto L_0x0059;
    L_0x006f:
        if (r9 == 0) goto L_0x0074;
    L_0x0071:
        r9.close();
    L_0x0074:
        return r1;
    L_0x0075:
        r10 = move-exception;
        if (r9 == 0) goto L_0x007b;
    L_0x0078:
        r9.close();
    L_0x007b:
        goto L_0x007d;
    L_0x007c:
        throw r10;
    L_0x007d:
        goto L_0x007c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.I.c(com.facebook.internal.I$e):java.util.TreeSet<java.lang.Integer>");
    }

    /* renamed from: d */
    public static void m932d() {
        if (f819e.compareAndSet(false, true)) {
            C0560t.m1258j().execute(new C0462H());
        }
    }

    /* renamed from: e */
    private static Map<String, List<C0463e>> m933e() {
        Map<String, List<C0463e>> hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C0832d());
        hashMap.put("com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG", f816b);
        hashMap.put("com.facebook.platform.action.request.FEED_DIALOG", f816b);
        hashMap.put("com.facebook.platform.action.request.LIKE_DIALOG", f816b);
        hashMap.put("com.facebook.platform.action.request.APPINVITES_DIALOG", f816b);
        hashMap.put("com.facebook.platform.action.request.MESSAGE_DIALOG", arrayList);
        hashMap.put("com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG", arrayList);
        hashMap.put("com.facebook.platform.action.request.CAMERA_EFFECT", f817c);
        hashMap.put("com.facebook.platform.action.request.SHARE_STORY", f816b);
        return hashMap;
    }

    /* renamed from: f */
    private static List<C0463e> m934f() {
        List<C0463e> arrayList = new ArrayList(C0465I.m935g());
        arrayList.add(0, new C0829a());
        return arrayList;
    }

    /* renamed from: g */
    private static List<C0463e> m935g() {
        List<C0463e> arrayList = new ArrayList();
        arrayList.add(new C0831c());
        arrayList.add(new C0833g());
        return arrayList;
    }
}
