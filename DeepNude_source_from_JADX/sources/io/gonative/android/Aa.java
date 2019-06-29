package io.gonative.android;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Pair;
import android.webkit.WebResourceResponse;
import io.gonative.android.p038a.C0700a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class Aa {
    /* renamed from: a */
    private Activity f1420a;
    /* renamed from: b */
    private C0721n f1421b;
    /* renamed from: c */
    private boolean f1422c;
    /* renamed from: d */
    private Map<String, C0720m> f1423d;
    /* renamed from: e */
    private Map<String, Ba> f1424e;
    /* renamed from: f */
    private C0666a f1425f = new C0666a(this);
    /* renamed from: g */
    private List<Set<String>> f1426g;
    /* renamed from: h */
    private Set<String> f1427h;
    /* renamed from: i */
    private C0720m f1428i;
    /* renamed from: j */
    private String f1429j;
    /* renamed from: k */
    private boolean f1430k;
    /* renamed from: l */
    private String f1431l;
    /* renamed from: m */
    private boolean f1432m;

    /* renamed from: io.gonative.android.Aa$a */
    public class C0666a {
        /* renamed from: a */
        final /* synthetic */ Aa f1419a;

        public C0666a(Aa aa) {
            this.f1419a = aa;
        }

        /* renamed from: a */
        public WebResourceResponse m1779a(C0720m c0720m, String str) {
            return this.f1419a.f1421b.m1944a(c0720m, str, null);
        }

        /* renamed from: b */
        public void m1780b(C0720m c0720m, String str) {
            Aa aa = this.f1419a;
            aa.f1423d.put(aa.f1429j, aa.f1428i);
            aa.f1429j = null;
            aa.f1428i = null;
            aa.f1430k = false;
            aa.f1421b.m1945a(null);
            aa.m1791c();
        }
    }

    /* renamed from: a */
    private void m1784a() {
        C0720m c0720m = this.f1428i;
        if (c0720m != null) {
            c0720m.stopLoading();
        }
        this.f1430k = false;
        this.f1428i = null;
        this.f1429j = null;
        this.f1431l = null;
        this.f1423d.clear();
    }

    /* renamed from: b */
    private HashSet<String> m1787b(String str) {
        HashSet<String> hashSet = new HashSet();
        for (Set set : this.f1426g) {
            if (set.contains(str)) {
                hashSet.addAll(set);
            }
        }
        return hashSet;
    }

    /* renamed from: b */
    private void m1788b() {
        JSONArray jSONArray = C0700a.m1851a(this.f1420a).gb;
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    JSONArray optJSONArray = optJSONObject.optJSONArray("urls");
                    if (optJSONArray != null) {
                        HashSet hashSet = new HashSet();
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            if (!optJSONArray.isNull(i2)) {
                                Object obj = null;
                                Object obj2 = Ba.f1437d;
                                Object opt = optJSONArray.opt(i2);
                                if (opt instanceof String) {
                                    obj = (String) opt;
                                }
                                if (obj == null && (opt instanceof JSONObject)) {
                                    JSONObject jSONObject = (JSONObject) opt;
                                    obj = jSONObject.optString("url");
                                    String a = C0700a.m1852a(jSONObject, "disown");
                                    if (a != null) {
                                        if (a.equalsIgnoreCase("reload")) {
                                            obj2 = Ba.Reload;
                                        } else if (a.equalsIgnoreCase("never")) {
                                            obj2 = Ba.Never;
                                        } else if (a.equalsIgnoreCase("always")) {
                                            obj2 = Ba.Always;
                                        }
                                    }
                                }
                                if (obj != null) {
                                    hashSet.add(obj);
                                    this.f1424e.put(obj, obj2);
                                }
                            }
                        }
                        this.f1426g.add(hashSet);
                    }
                }
            }
            String str = this.f1431l;
            if (str != null) {
                m1799a(str);
            }
            m1791c();
        }
    }

    /* renamed from: c */
    private void m1791c() {
        if (!this.f1432m) {
            if (!this.f1430k) {
                if (this.f1428i != null && this.f1429j != null) {
                    this.f1420a.runOnUiThread(new ya(this));
                    this.f1430k = true;
                } else if (!this.f1427h.isEmpty()) {
                    String str = (String) this.f1427h.iterator().next();
                    this.f1429j = str;
                    this.f1421b.m1945a(str);
                    this.f1420a.runOnUiThread(new za(this, str));
                }
            }
        }
    }

    /* renamed from: a */
    public Pair<C0720m, Ba> m1799a(String str) {
        this.f1431l = str;
        Collection b = m1787b(str);
        if (b.size() > 0) {
            Collection hashSet = new HashSet(b);
            String str2 = this.f1429j;
            if (str2 != null) {
                hashSet.remove(str2);
            }
            hashSet.removeAll(this.f1423d.keySet());
            this.f1427h.addAll(hashSet);
        }
        C0720m c0720m = (C0720m) this.f1423d.get(str);
        return c0720m == null ? new Pair(null, null) : new Pair(c0720m, (Ba) this.f1424e.get(str));
    }

    /* renamed from: a */
    public void m1800a(Activity activity) {
        if (!this.f1422c) {
            this.f1422c = true;
            this.f1420a = activity;
            this.f1421b = new C0721n(activity);
            this.f1423d = new HashMap();
            this.f1424e = new HashMap();
            this.f1426g = new ArrayList();
            this.f1427h = new HashSet();
            BroadcastReceiver xaVar = new xa(this);
            LocalBroadcastManager.getInstance(this.f1420a).registerReceiver(xaVar, new IntentFilter("io.gonative.android.webview.started"));
            LocalBroadcastManager.getInstance(this.f1420a).registerReceiver(xaVar, new IntentFilter("io.gonative.android.webview.finished"));
            LocalBroadcastManager.getInstance(this.f1420a).registerReceiver(xaVar, new IntentFilter("io.gonative.android.webview.clearPools"));
            LocalBroadcastManager.getInstance(this.f1420a).registerReceiver(xaVar, new IntentFilter("io.gonative.android.AppConfig.processedWebViewPools"));
            m1788b();
        }
    }

    /* renamed from: a */
    public void m1801a(C0720m c0720m) {
        Iterator it = this.f1423d.keySet().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (this.f1423d.get(str) == c0720m) {
                it.remove();
                this.f1427h.add(str);
            }
        }
    }
}
