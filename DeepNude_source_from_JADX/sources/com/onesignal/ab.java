package com.onesignal;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import com.onesignal.sa.C0650i;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ab {
    /* renamed from: a */
    private static int f1244a = -99;
    /* renamed from: b */
    private static Class<?> f1245b;
    /* renamed from: c */
    private ServiceConnection f1246c;
    /* renamed from: d */
    private Object f1247d;
    /* renamed from: e */
    private Method f1248e;
    /* renamed from: f */
    private Method f1249f;
    /* renamed from: g */
    private Context f1250g;
    /* renamed from: h */
    private ArrayList<String> f1251h;
    /* renamed from: i */
    private boolean f1252i = true;
    /* renamed from: j */
    private boolean f1253j;

    ab(Context context) {
        String str = "GTPlayerPurchases";
        boolean z = false;
        this.f1253j = false;
        this.f1250g = context;
        this.f1251h = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(za.m1770a(str, "purchaseTokens", "[]"));
            for (int i = 0; i < jSONArray.length(); i++) {
                this.f1251h.add(jSONArray.get(i).toString());
            }
            if (jSONArray.length() == 0) {
                z = true;
            }
            this.f1252i = z;
            if (this.f1252i) {
                this.f1252i = za.m1773a(str, "ExistingPurchases", true);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m1484b();
    }

    /* renamed from: a */
    private void m1471a(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        try {
            if (this.f1249f == null) {
                this.f1249f = m1482e(f1245b);
                this.f1249f.setAccessible(true);
            }
            new Bundle().putStringArrayList("ITEM_ID_LIST", arrayList);
            Bundle bundle = (Bundle) this.f1249f.invoke(this.f1247d, new Object[]{Integer.valueOf(3), this.f1250g.getPackageName(), "inapp", bundle});
            if (bundle.getInt("RESPONSE_CODE") == 0) {
                String string;
                ArrayList stringArrayList = bundle.getStringArrayList("DETAILS_LIST");
                Map hashMap = new HashMap();
                Iterator it = stringArrayList.iterator();
                while (it.hasNext()) {
                    JSONObject jSONObject = new JSONObject((String) it.next());
                    string = jSONObject.getString("productId");
                    BigDecimal divide = new BigDecimal(jSONObject.getString("price_amount_micros")).divide(new BigDecimal(1000000));
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("sku", string);
                    jSONObject2.put("iso", jSONObject.getString("price_currency_code"));
                    jSONObject2.put("amount", divide.toString());
                    hashMap.put(string, jSONObject2);
                }
                JSONArray jSONArray = new JSONArray();
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    string = (String) it2.next();
                    if (hashMap.containsKey(string)) {
                        jSONArray.put(hashMap.get(string));
                    }
                }
                if (jSONArray.length() > 0) {
                    sa.m1665a(jSONArray, this.f1252i, new _a(this, arrayList2));
                }
            }
        } catch (Throwable th) {
            sa.m1657a(C0650i.WARN, "Failed to track IAP purchases", th);
        }
    }

    /* renamed from: a */
    static boolean m1472a(android.content.Context r2) {
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
        r0 = f1244a;
        r1 = -99;
        if (r0 != r1) goto L_0x000e;
    L_0x0006:
        r0 = "com.android.vending.BILLING";
        r2 = r2.checkCallingOrSelfPermission(r0);
        f1244a = r2;
    L_0x000e:
        r2 = 0;
        r0 = f1244a;	 Catch:{ Throwable -> 0x0021 }
        if (r0 != 0) goto L_0x001b;
    L_0x0013:
        r0 = "com.android.vending.billing.IInAppBillingService";
        r0 = java.lang.Class.forName(r0);	 Catch:{ Throwable -> 0x0021 }
        f1245b = r0;	 Catch:{ Throwable -> 0x0021 }
    L_0x001b:
        r0 = f1244a;
        if (r0 != 0) goto L_0x0020;
    L_0x001f:
        r2 = 1;
    L_0x0020:
        return r2;
    L_0x0021:
        f1244a = r2;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.ab.a(android.content.Context):boolean");
    }

    /* renamed from: c */
    private static Method m1478c(Class cls) {
        for (Method method : cls.getMethods()) {
            Class[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length == 1 && parameterTypes[0] == IBinder.class) {
                return method;
            }
        }
        return null;
    }

    /* renamed from: c */
    private void m1479c() {
        if (!this.f1253j) {
            new Thread(new Za(this)).start();
        }
    }

    /* renamed from: d */
    private static Method m1481d(Class cls) {
        for (Method method : cls.getMethods()) {
            Class[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length == 4 && parameterTypes[0] == Integer.TYPE && parameterTypes[1] == String.class && parameterTypes[2] == String.class && parameterTypes[3] == String.class) {
                return method;
            }
        }
        return null;
    }

    /* renamed from: e */
    private static Method m1482e(Class cls) {
        for (Method method : cls.getMethods()) {
            Class[] parameterTypes = method.getParameterTypes();
            Class returnType = method.getReturnType();
            if (parameterTypes.length == 4 && parameterTypes[0] == Integer.TYPE && parameterTypes[1] == String.class && parameterTypes[2] == String.class && parameterTypes[3] == Bundle.class && returnType == Bundle.class) {
                return method;
            }
        }
        return null;
    }

    /* renamed from: b */
    void m1484b() {
        if (this.f1246c == null) {
            this.f1246c = new Ya(this);
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage("com.android.vending");
            this.f1250g.bindService(intent, this.f1246c, 1);
        } else if (this.f1247d != null) {
            m1479c();
        }
    }
}
