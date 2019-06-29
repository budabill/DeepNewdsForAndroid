package io.gonative.android;

import android.content.Context;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import com.astuetz.PagerSlidingTabStrip.C0320b;
import io.gonative.android.azzpro.R;
import io.gonative.android.p038a.C0700a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class ja extends PagerAdapter implements C0320b {
    /* renamed from: a */
    private MainActivity f1880a;
    /* renamed from: b */
    private ViewPager f1881b;
    /* renamed from: c */
    private String f1882c;
    /* renamed from: d */
    private String f1883d;
    /* renamed from: e */
    private JSONArray f1884e;
    /* renamed from: f */
    private Map<JSONObject, List<Pattern>> f1885f = new HashMap();
    /* renamed from: g */
    private boolean f1886g;

    ja(MainActivity mainActivity, ViewPager viewPager) {
        this.f1880a = mainActivity;
        this.f1881b = viewPager;
        LocalBroadcastManager.getInstance(this.f1880a).registerReceiver(new ga(this), new IntentFilter("io.gonative.android.AppConfig.processedTabNavigation"));
    }

    /* renamed from: a */
    private List<Pattern> m2375a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Object opt = jSONObject.opt("regex");
        return opt == null ? null : C0726s.m1969a(opt);
    }

    /* renamed from: a */
    private void m2376a() {
        this.f1880a.runOnUiThread(new ia(this));
    }

    /* renamed from: a */
    private void m2377a(JSONArray jSONArray) {
        this.f1884e = jSONArray;
        notifyDataSetChanged();
        int i = -1;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                if (optJSONObject.optBoolean("selected")) {
                    i = i2;
                }
            }
        }
        if (i > -1) {
            m2385b(i);
        }
    }

    /* renamed from: b */
    private void m2379b() {
        this.f1880a.runOnUiThread(new ha(this));
    }

    /* renamed from: c */
    private List<Pattern> m2380c(int i) {
        JSONArray jSONArray = this.f1884e;
        if (jSONArray != null && i >= 0) {
            if (i < jSONArray.length()) {
                JSONObject optJSONObject = this.f1884e.optJSONObject(i);
                if (optJSONObject == null) {
                    return null;
                }
                if (this.f1885f.containsKey(optJSONObject)) {
                    return (List) this.f1885f.get(optJSONObject);
                }
                List<Pattern> a = m2375a(optJSONObject);
                this.f1885f.put(optJSONObject, a);
                return a;
            }
        }
        return null;
    }

    /* renamed from: d */
    private void m2381d(String str) {
        if (str == null) {
            this.f1882c = null;
            m2376a();
            return;
        }
        String str2 = this.f1882c;
        if (str2 == null || !str2.equals(str)) {
            this.f1882c = str;
            m2377a((JSONArray) C0700a.m1851a(this.f1880a).f1525U.get(str));
            m2379b();
        }
    }

    /* renamed from: a */
    public void mo1412a(int i) {
        JSONArray jSONArray = this.f1884e;
        if (jSONArray != null && i < jSONArray.length()) {
            JSONObject optJSONObject = this.f1884e.optJSONObject(i);
            String optString = optJSONObject.optString("url");
            String optString2 = optJSONObject.optString("javascript");
            if (optString != null && !optString.isEmpty()) {
                if (optString2 != null) {
                    this.f1880a.m2596a(optString, optString2, true);
                } else {
                    this.f1880a.m2597a(optString, true);
                }
            }
        }
    }

    /* renamed from: a */
    public void m2383a(String str) {
        if (this.f1884e != null) {
            for (int i = 0; i < this.f1884e.length(); i++) {
                List<Pattern> c = m2380c(i);
                if (c != null) {
                    for (Pattern matcher : c) {
                        if (matcher.matcher(str).matches()) {
                            this.f1881b.setCurrentItem(i);
                            return;
                        }
                    }
                    continue;
                }
            }
        }
    }

    /* renamed from: a */
    public boolean m2384a(String str, String str2) {
        if (str == null) {
            return false;
        }
        String str3 = "";
        if (str2 == null) {
            str2 = str3;
        }
        if (this.f1884e != null) {
            for (int i = 0; i < this.f1884e.length(); i++) {
                JSONObject optJSONObject = this.f1884e.optJSONObject(i);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("url");
                    Object optString2 = optJSONObject.optString("javascript");
                    if (optString != null) {
                        if (optString2 == null) {
                            optString2 = str3;
                        }
                        if (str.equals(optString) && r8.equals(r3)) {
                            ViewPager viewPager = this.f1881b;
                            if (viewPager != null) {
                                viewPager.setCurrentItem(i);
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: b */
    public void m2385b(int i) {
        if (i < 0) {
            return;
        }
        if (i < getCount()) {
            this.f1881b.setCurrentItem(i);
        }
    }

    /* renamed from: b */
    public void m2386b(String str) {
        this.f1883d = str;
        Context context = this.f1880a;
        if (context != null) {
            if (str != null) {
                if (this.f1886g) {
                    m2383a(str);
                    return;
                }
                C0700a a = C0700a.m1851a(context);
                ArrayList arrayList = a.f1526V;
                ArrayList arrayList2 = a.f1527W;
                if (arrayList != null) {
                    if (arrayList2 != null) {
                        String str2 = null;
                        for (int i = 0; i < arrayList.size(); i++) {
                            if (((Pattern) arrayList.get(i)).matcher(str).matches()) {
                                str2 = (String) arrayList2.get(i);
                                break;
                            }
                        }
                        m2381d(str2);
                        if (str2 != null) {
                            m2383a(str);
                        }
                        return;
                    }
                }
                m2376a();
            }
        }
    }

    /* renamed from: c */
    public void m2387c(java.lang.String r2) {
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
        r1 = this;
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x002c }
        r0.<init>(r2);	 Catch:{ JSONException -> 0x002c }
        r2 = 1;
        r1.f1886g = r2;
        r2 = "items";
        r2 = r0.optJSONArray(r2);
        if (r2 == 0) goto L_0x0013;
    L_0x0010:
        r1.m2377a(r2);
    L_0x0013:
        r2 = "enabled";
        r2 = r0.opt(r2);
        r0 = r2 instanceof java.lang.Boolean;
        if (r0 == 0) goto L_0x002c;
    L_0x001d:
        r2 = (java.lang.Boolean) r2;
        r2 = r2.booleanValue();
        if (r2 == 0) goto L_0x0029;
    L_0x0025:
        r1.m2379b();
        goto L_0x002c;
    L_0x0029:
        r1.m2376a();
    L_0x002c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.gonative.android.ja.c(java.lang.String):void");
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (obj instanceof View) {
            viewGroup.removeView((View) obj);
        }
    }

    public int getCount() {
        JSONArray jSONArray = this.f1884e;
        return jSONArray != null ? jSONArray.length() : 0;
    }

    public CharSequence getPageTitle(int i) {
        JSONArray jSONArray = this.f1884e;
        CharSequence charSequence = "";
        if (jSONArray == null || i >= jSONArray.length()) {
            return charSequence;
        }
        JSONObject optJSONObject = this.f1884e.optJSONObject(i);
        return optJSONObject != null ? optJSONObject.optString("label", charSequence) : charSequence;
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        return this.f1880a.getLayoutInflater().inflate(R.layout.empty, viewGroup);
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
