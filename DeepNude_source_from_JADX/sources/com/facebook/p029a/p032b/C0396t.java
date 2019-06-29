package com.facebook.p029a.p032b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import com.facebook.C0560t;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

/* renamed from: com.facebook.a.b.t */
class C0396t {
    /* renamed from: a */
    private static final String f652a = "com.facebook.a.b.t";
    /* renamed from: b */
    private static final HashMap<String, Method> f653b = new HashMap();
    /* renamed from: c */
    private static final HashMap<String, Class<?>> f654c = new HashMap();
    /* renamed from: d */
    private static final String f655d = C0560t.m1252d().getPackageName();
    /* renamed from: e */
    private static final SharedPreferences f656e = C0560t.m1252d().getSharedPreferences("com.facebook.internal.SKU_DETAILS", 0);
    /* renamed from: f */
    private static final SharedPreferences f657f = C0560t.m1252d().getSharedPreferences("com.facebook.internal.PURCHASE", 0);
    /* renamed from: g */
    private static final SharedPreferences f658g = C0560t.m1252d().getSharedPreferences("com.facebook.internal.PURCHASE_SUBS", 0);

    /* renamed from: a */
    private static C0402z m711a(String str) {
        String str2 = "autoRenewing";
        String str3 = "purchaseToken";
        C0402z c0402z = null;
        try {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            JSONObject jSONObject = new JSONObject(str);
            str = jSONObject.getString("productId");
            String string = f658g.getString(str, "");
            JSONObject jSONObject2 = string.isEmpty() ? new JSONObject() : new JSONObject(string);
            if (!jSONObject2.optString(str3).equals(jSONObject.get(str3))) {
                c0402z = currentTimeMillis - (jSONObject.getLong("purchaseTime") / 1000) < 43200 ? C0402z.NEW : C0402z.HEARTBEAT;
            }
            if (c0402z == null && !string.isEmpty()) {
                boolean z = jSONObject2.getBoolean(str2);
                boolean z2 = jSONObject.getBoolean(str2);
                if (!z2 && z) {
                    c0402z = C0402z.CANCEL;
                } else if (!z && z2) {
                    c0402z = C0402z.RESTORE;
                }
            }
            str2 = "LAST_LOGGED_TIME_SEC";
            if (c0402z == null) {
                if (!string.isEmpty()) {
                    c0402z = currentTimeMillis - jSONObject2.getLong(str2) > 86400 ? C0402z.HEARTBEAT : C0402z.DUPLICATED;
                }
            }
            if (c0402z != C0402z.DUPLICATED) {
                jSONObject.put(str2, currentTimeMillis);
                f658g.edit().putString(str, jSONObject.toString()).apply();
            }
            return c0402z;
        } catch (Throwable e) {
            Log.e(f652a, "parsing purchase failure: ", e);
            return C0402z.UNKNOWN;
        }
    }

    /* renamed from: a */
    private static Class<?> m712a(Context context, String str) {
        Class<?> cls = (Class) f654c.get(str);
        if (cls != null) {
            return cls;
        }
        try {
            cls = context.getClassLoader().loadClass(str);
            f654c.put(str, cls);
        } catch (Throwable e) {
            String str2 = f652a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(" is not available, please add ");
            stringBuilder.append(str);
            stringBuilder.append(" to the project.");
            Log.e(str2, stringBuilder.toString(), e);
        }
        return cls;
    }

    /* renamed from: a */
    public static Object m713a(Context context, IBinder iBinder) {
        return C0396t.m714a(context, "com.android.vending.billing.IInAppBillingService$Stub", "asInterface", null, new Object[]{iBinder});
    }

    /* renamed from: a */
    private static Object m714a(Context context, String str, String str2, Object obj, Object[] objArr) {
        Throwable e;
        String str3;
        StringBuilder stringBuilder;
        String str4;
        String str5 = ".";
        Class a = C0396t.m712a(context, str);
        if (a == null) {
            return null;
        }
        Method a2 = C0396t.m715a(a, str2);
        if (a2 == null) {
            return null;
        }
        if (obj != null) {
            obj = a.cast(obj);
        }
        try {
            a = a2.invoke(obj, objArr);
            return a;
        } catch (IllegalAccessException e2) {
            e = e2;
            str3 = f652a;
            stringBuilder = new StringBuilder();
            str4 = "Illegal access to method ";
            stringBuilder.append(str4);
            stringBuilder.append(a.getName());
            stringBuilder.append(str5);
            stringBuilder.append(a2.getName());
            Log.e(str3, stringBuilder.toString(), e);
            return null;
        } catch (InvocationTargetException e3) {
            e = e3;
            str3 = f652a;
            stringBuilder = new StringBuilder();
            str4 = "Invocation target exception in ";
            stringBuilder.append(str4);
            stringBuilder.append(a.getName());
            stringBuilder.append(str5);
            stringBuilder.append(a2.getName());
            Log.e(str3, stringBuilder.toString(), e);
            return null;
        }
    }

    /* renamed from: a */
    private static Method m715a(Class<?> cls, String str) {
        Method method = (Method) f653b.get(str);
        if (method != null) {
            return method;
        }
        Class[] clsArr = null;
        Object obj = -1;
        try {
            switch (str.hashCode()) {
                case -1801122596:
                    if (str.equals("getPurchases")) {
                        obj = 3;
                        break;
                    }
                    break;
                case -1450694211:
                    if (str.equals("isBillingSupported")) {
                        obj = 2;
                        break;
                    }
                    break;
                case -1123215065:
                    if (str.equals("asInterface")) {
                        obj = null;
                        break;
                    }
                    break;
                case -594356707:
                    if (str.equals("getPurchaseHistory")) {
                        obj = 4;
                        break;
                    }
                    break;
                case -573310373:
                    if (str.equals("getSkuDetails")) {
                        obj = 1;
                        break;
                    }
                    break;
                default:
                    break;
            }
            if (obj == null) {
                clsArr = new Class[]{IBinder.class};
            } else if (obj == 1) {
                clsArr = new Class[]{Integer.TYPE, String.class, String.class, Bundle.class};
            } else if (obj == 2) {
                clsArr = new Class[]{Integer.TYPE, String.class, String.class};
            } else if (obj == 3) {
                clsArr = new Class[]{Integer.TYPE, String.class, String.class, String.class};
            } else if (obj == 4) {
                clsArr = new Class[]{Integer.TYPE, String.class, String.class, String.class, Bundle.class};
            }
            method = cls.getDeclaredMethod(str, clsArr);
            f653b.put(str, method);
        } catch (Throwable e) {
            String str2 = f652a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(cls.getName());
            stringBuilder.append(".");
            stringBuilder.append(str);
            stringBuilder.append(" method not found");
            Log.e(str2, stringBuilder.toString(), e);
        }
        return method;
    }

    /* renamed from: a */
    public static ArrayList<String> m716a(Context context, Object obj) {
        ArrayList<String> arrayList = new ArrayList();
        if (obj == null) {
            return arrayList;
        }
        Class a = C0396t.m712a(context, "com.android.vending.billing.IInAppBillingService");
        return (a == null || C0396t.m715a(a, "getPurchaseHistory") == null) ? arrayList : C0396t.m718a(C0396t.m717a(context, obj, "inapp"));
    }

    /* renamed from: a */
    private static ArrayList<String> m717a(Context context, Object obj, String str) {
        ArrayList<String> arrayList = new ArrayList();
        if (C0396t.m726c(context, obj, str).booleanValue()) {
            int i = 0;
            Boolean valueOf = Boolean.valueOf(false);
            String str2 = null;
            int i2 = 0;
            while (true) {
                Context context2 = context;
                Object a = C0396t.m714a(context2, "com.android.vending.billing.IInAppBillingService", "getPurchaseHistory", obj, new Object[]{Integer.valueOf(6), f655d, str, str2, new Bundle()});
                if (a != null) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    Bundle bundle = (Bundle) a;
                    if (bundle.getInt("RESPONSE_CODE") == 0) {
                        Iterator it = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST").iterator();
                        while (it.hasNext()) {
                            str2 = (String) it.next();
                            try {
                                if (currentTimeMillis - (new JSONObject(str2).getLong("purchaseTime") / 1000) > 1200) {
                                    valueOf = Boolean.valueOf(true);
                                    break;
                                }
                                arrayList.add(str2);
                                i2++;
                            } catch (Throwable e) {
                                Log.e(f652a, "parsing purchase failure: ", e);
                            }
                        }
                        str2 = bundle.getString("INAPP_CONTINUATION_TOKEN");
                        if (i2 >= 30 || r0 == null) {
                            break;
                        } else if (valueOf.booleanValue()) {
                            break;
                        } else {
                            i = 0;
                        }
                    }
                }
                str2 = null;
                if (valueOf.booleanValue()) {
                    break;
                }
                i = 0;
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static ArrayList<String> m718a(ArrayList<String> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList();
        Editor edit = f657f.edit();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("productId");
                long j = jSONObject.getLong("purchaseTime");
                String string2 = jSONObject.getString("purchaseToken");
                if (currentTimeMillis - (j / 1000) <= 43200) {
                    if (!f657f.getString(string, "").equals(string2)) {
                        edit.putString(string, string2);
                        arrayList2.add(str);
                    }
                }
            } catch (Throwable e) {
                Log.e(f652a, "parsing purchase failure: ", e);
            }
        }
        edit.apply();
        return arrayList2;
    }

    /* renamed from: a */
    public static Map<String, String> m719a(Context context, ArrayList<String> arrayList, Object obj, boolean z) {
        Map<String, String> b = C0396t.m725b(arrayList);
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!b.containsKey(str)) {
                arrayList2.add(str);
            }
        }
        b.putAll(C0396t.m724b(context, arrayList2, obj, z));
        return b;
    }

    /* renamed from: a */
    public static void m720a() {
        Editor edit;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        String str = "LAST_CLEARED_TIME";
        long j = f656e.getLong(str, 0);
        if (j == 0) {
            edit = f656e.edit();
        } else if (currentTimeMillis - j > 604800) {
            edit = f656e.edit().clear();
        } else {
            return;
        }
        edit.putLong(str, currentTimeMillis).apply();
    }

    /* renamed from: a */
    private static void m721a(Map<String, String> map) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        Editor edit = f656e.edit();
        for (Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(currentTimeMillis);
            stringBuilder.append(";");
            stringBuilder.append((String) entry.getValue());
            edit.putString(str, stringBuilder.toString());
        }
        edit.apply();
    }

    /* renamed from: b */
    public static ArrayList<String> m722b(Context context, Object obj) {
        return C0396t.m718a(C0396t.m723b(context, obj, "inapp"));
    }

    /* renamed from: b */
    private static ArrayList<String> m723b(Context context, Object obj, String str) {
        ArrayList<String> arrayList = new ArrayList();
        if (obj != null && C0396t.m726c(context, obj, str).booleanValue()) {
            String str2 = null;
            int i = 0;
            do {
                Object a = C0396t.m714a(context, "com.android.vending.billing.IInAppBillingService", "getPurchases", obj, new Object[]{Integer.valueOf(3), f655d, str, str2});
                if (a != null) {
                    Bundle bundle = (Bundle) a;
                    if (bundle.getInt("RESPONSE_CODE") == 0) {
                        Collection stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                        if (stringArrayList == null) {
                            break;
                        }
                        i += stringArrayList.size();
                        arrayList.addAll(stringArrayList);
                        str2 = bundle.getString("INAPP_CONTINUATION_TOKEN");
                        if (i >= 30) {
                            break;
                        }
                    }
                }
                str2 = null;
                if (i >= 30) {
                    break;
                }
                break;
            } while (str2 != null);
        }
        return arrayList;
    }

    /* renamed from: b */
    private static Map<String, String> m724b(Context context, ArrayList<String> arrayList, Object obj, boolean z) {
        Map hashMap = new HashMap();
        if (obj != null) {
            if (!arrayList.isEmpty()) {
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("ITEM_ID_LIST", arrayList);
                Object[] objArr = new Object[4];
                int i = 0;
                objArr[0] = Integer.valueOf(3);
                objArr[1] = f655d;
                objArr[2] = z ? "subs" : "inapp";
                objArr[3] = bundle;
                Object a = C0396t.m714a(context, "com.android.vending.billing.IInAppBillingService", "getSkuDetails", obj, objArr);
                if (a != null) {
                    Bundle bundle2 = (Bundle) a;
                    if (bundle2.getInt("RESPONSE_CODE") == 0) {
                        ArrayList stringArrayList = bundle2.getStringArrayList("DETAILS_LIST");
                        if (stringArrayList != null && arrayList.size() == stringArrayList.size()) {
                            while (i < arrayList.size()) {
                                hashMap.put(arrayList.get(i), stringArrayList.get(i));
                                i++;
                            }
                        }
                        C0396t.m721a(hashMap);
                    }
                }
            }
        }
        return hashMap;
    }

    /* renamed from: b */
    private static Map<String, String> m725b(ArrayList<String> arrayList) {
        Map<String, String> hashMap = new HashMap();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            String string = f656e.getString(str, null);
            if (string != null) {
                String[] split = string.split(";", 2);
                if (currentTimeMillis - Long.parseLong(split[0]) < 43200) {
                    hashMap.put(str, split[1]);
                }
            }
        }
        return hashMap;
    }

    /* renamed from: c */
    private static Boolean m726c(Context context, Object obj, String str) {
        boolean z = false;
        if (obj == null) {
            return Boolean.valueOf(false);
        }
        Object a = C0396t.m714a(context, "com.android.vending.billing.IInAppBillingService", "isBillingSupported", obj, new Object[]{Integer.valueOf(3), f655d, str});
        if (a != null && ((Integer) a).intValue() == 0) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    /* renamed from: c */
    public static Map<String, C0402z> m727c(Context context, Object obj) {
        Map<String, C0402z> hashMap = new HashMap();
        Iterator it = C0396t.m723b(context, obj, "subs").iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            C0402z a = C0396t.m711a(str);
            if (!(a == C0402z.DUPLICATED || a == C0402z.UNKNOWN)) {
                hashMap.put(str, a);
            }
        }
        return hashMap;
    }

    /* renamed from: d */
    public static ArrayList<String> m728d(Context context, Object obj) {
        ArrayList<String> arrayList = new ArrayList();
        Map all = f658g.getAll();
        if (all.isEmpty()) {
            return arrayList;
        }
        ArrayList b = C0396t.m723b(context, obj, "subs");
        Set hashSet = new HashSet();
        Iterator it = b.iterator();
        while (it.hasNext()) {
            try {
                hashSet.add(new JSONObject((String) it.next()).getString("productId"));
            } catch (Throwable e) {
                Log.e(f652a, "Error parsing purchase json", e);
            }
        }
        Set<String> hashSet2 = new HashSet();
        for (Entry key : all.entrySet()) {
            String str = (String) key.getKey();
            if (!hashSet.contains(str)) {
                hashSet2.add(str);
            }
        }
        Editor edit = f658g.edit();
        for (String str2 : hashSet2) {
            String str3 = "";
            str = f658g.getString(str2, str3);
            edit.remove(str2);
            if (!str.isEmpty()) {
                arrayList.add(f658g.getString(str2, str3));
            }
        }
        edit.apply();
        return arrayList;
    }
}
