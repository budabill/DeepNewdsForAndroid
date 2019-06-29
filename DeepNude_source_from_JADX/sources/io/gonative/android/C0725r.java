package io.gonative.android;

import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import io.gonative.android.p038a.C0700a;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: io.gonative.android.r */
public class C0725r extends BaseExpandableListAdapter implements OnGroupClickListener, OnChildClickListener {
    /* renamed from: a */
    private static final String f1634a = "io.gonative.android.r";
    /* renamed from: b */
    private MainActivity f1635b;
    /* renamed from: c */
    private JSONArray f1636c;
    /* renamed from: d */
    private boolean f1637d = false;
    /* renamed from: e */
    private boolean f1638e = false;
    /* renamed from: f */
    private String f1639f;

    C0725r(MainActivity mainActivity) {
        this.f1635b = mainActivity;
        this.f1636c = null;
        LocalBroadcastManager.getInstance(this.f1635b).registerReceiver(new C0724q(this), new IntentFilter("io.gonative.android.AppConfig.processedMenu"));
    }

    /* renamed from: a */
    private String m1952a(int i) {
        return m1954a("label", i);
    }

    /* renamed from: a */
    private String m1953a(int i, int i2) {
        return m1955a("label", i, i2);
    }

    /* renamed from: a */
    private String m1954a(String str, int i) {
        try {
            JSONObject jSONObject = (JSONObject) this.f1636c.get(i);
            return !jSONObject.isNull(str) ? jSONObject.getString(str).trim() : null;
        } catch (Throwable e) {
            Log.e(f1634a, e.getMessage(), e);
            return null;
        }
    }

    /* renamed from: a */
    private String m1955a(String str, int i, int i2) {
        try {
            JSONObject jSONObject = ((JSONObject) this.f1636c.get(i)).getJSONArray("subLinks").getJSONObject(i2);
            return !jSONObject.isNull(str) ? jSONObject.getString(str).trim() : null;
        } catch (Throwable e) {
            Log.e(f1634a, e.getMessage(), e);
            return null;
        }
    }

    /* renamed from: a */
    private synchronized void m1956a() {
        m1962a(this.f1639f);
    }

    /* renamed from: a */
    private void m1958a(String str, String str2) {
        if (ka.m1932a().m1936b() != null) {
            str = str.replaceAll("GONATIVE_USERID", ka.m1932a().m1936b());
        }
        if (str2 == null) {
            this.f1635b.m2606d(str);
        } else {
            this.f1635b.m2595a(str, str2);
        }
        this.f1635b.m2605d();
    }

    /* renamed from: b */
    private Pair<String, String> m1959b(int i) {
        return new Pair(m1954a("url", i), m1954a("javascript", i));
    }

    /* renamed from: b */
    private Pair<String, String> m1960b(int i, int i2) {
        return new Pair(m1955a("url", i, i2), m1955a("javascript", i, i2));
    }

    /* renamed from: c */
    private boolean m1961c(int i) {
        try {
            return ((JSONObject) this.f1636c.get(i)).optBoolean("isGrouping", false);
        } catch (Throwable e) {
            Log.e(f1634a, e.getMessage(), e);
            return false;
        }
    }

    /* renamed from: a */
    public synchronized void m1962a(String str) {
        if (str == null) {
            str = "default";
        }
        this.f1639f = str;
        this.f1636c = (JSONArray) C0700a.m1851a(this.f1635b).f1507C.get(str);
        if (this.f1636c == null) {
            this.f1636c = new JSONArray();
        }
        this.f1637d = false;
        this.f1638e = false;
        for (int i = 0; i < this.f1636c.length(); i++) {
            JSONObject optJSONObject = this.f1636c.optJSONObject(i);
            if (optJSONObject != null) {
                if (!(optJSONObject.isNull("icon") || optJSONObject.optString("icon").isEmpty())) {
                    this.f1637d = true;
                }
                if (optJSONObject.optBoolean("isGrouping", false)) {
                    JSONArray optJSONArray = optJSONObject.optJSONArray("subLinks");
                    if (optJSONArray != null) {
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                            if (optJSONObject2 != null && !optJSONObject2.isNull("icon") && !optJSONObject2.optString("icon").isEmpty()) {
                                this.f1638e = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        notifyDataSetChanged();
    }

    public Object getChild(int i, int i2) {
        return null;
    }

    public long getChildId(int i, int i2) {
        return 0;
    }

    public int getChildType(int i, int i2) {
        if (!this.f1637d) {
            if (!this.f1638e) {
                return 1;
            }
        }
        return 0;
    }

    public int getChildTypeCount() {
        return 2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View getChildView(int r3, int r4, boolean r5, android.view.View r6, android.view.ViewGroup r7) {
        /*
        r2 = this;
        r5 = 2131165297; // 0x7f070071 float:1.7944807E38 double:1.052935559E-314;
        r0 = 0;
        if (r6 != 0) goto L_0x003f;
    L_0x0006:
        r6 = r2.f1635b;
        r6 = r6.getLayoutInflater();
        r1 = r2.f1637d;
        if (r1 != 0) goto L_0x0019;
    L_0x0010:
        r1 = r2.f1638e;
        if (r1 == 0) goto L_0x0015;
    L_0x0014:
        goto L_0x0019;
    L_0x0015:
        r1 = 2131296296; // 0x7f090028 float:1.8210505E38 double:1.053000281E-314;
        goto L_0x001c;
    L_0x0019:
        r1 = 2131296295; // 0x7f090027 float:1.8210503E38 double:1.0530002805E-314;
    L_0x001c:
        r6 = r6.inflate(r1, r7, r0);
        r7 = r2.f1635b;
        r7 = io.gonative.android.p038a.C0700a.m1851a(r7);
        r7 = r7.ca;
        if (r7 == 0) goto L_0x003f;
    L_0x002a:
        r7 = r6.findViewById(r5);
        r7 = (android.widget.TextView) r7;
        r1 = r2.f1635b;
        r1 = io.gonative.android.p038a.C0700a.m1851a(r1);
        r1 = r1.ca;
        r1 = r1.intValue();
        r7.setTextColor(r1);
    L_0x003f:
        r5 = r6.findViewById(r5);
        r5 = (android.widget.TextView) r5;
        r7 = r2.m1953a(r3, r4);
        r5.setText(r7);
        r5 = "icon";
        r3 = r2.m1955a(r5, r3, r4);
        r4 = 2131165296; // 0x7f070070 float:1.7944805E38 double:1.0529355584E-314;
        r4 = r6.findViewById(r4);
        r4 = (android.widget.ImageView) r4;
        r5 = 4;
        if (r3 == 0) goto L_0x00aa;
    L_0x005e:
        r7 = r3.isEmpty();
        if (r7 != 0) goto L_0x00aa;
    L_0x0064:
        r7 = "-";
        r1 = "_";
        r3 = r3.replaceAll(r7, r1);
        r7 = new com.joanzapata.iconify.IconDrawable;	 Catch:{ IllegalArgumentException -> 0x009f }
        r1 = r2.f1635b;	 Catch:{ IllegalArgumentException -> 0x009f }
        r3 = com.joanzapata.iconify.fonts.FontAwesomeIcons.valueOf(r3);	 Catch:{ IllegalArgumentException -> 0x009f }
        r7.<init>(r1, r3);	 Catch:{ IllegalArgumentException -> 0x009f }
        r3 = 2131034242; // 0x7f050082 float:1.7678996E38 double:1.052870809E-314;
        r3 = r7.sizeRes(r3);	 Catch:{ IllegalArgumentException -> 0x009f }
        r7 = r2.f1635b;	 Catch:{ IllegalArgumentException -> 0x009f }
        r7 = io.gonative.android.p038a.C0700a.m1851a(r7);	 Catch:{ IllegalArgumentException -> 0x009f }
        r7 = r7.ca;	 Catch:{ IllegalArgumentException -> 0x009f }
        if (r7 == 0) goto L_0x0098;
    L_0x0088:
        r7 = r2.f1635b;	 Catch:{ IllegalArgumentException -> 0x009f }
        r7 = io.gonative.android.p038a.C0700a.m1851a(r7);	 Catch:{ IllegalArgumentException -> 0x009f }
        r7 = r7.ca;	 Catch:{ IllegalArgumentException -> 0x009f }
        r7 = r7.intValue();	 Catch:{ IllegalArgumentException -> 0x009f }
        r3 = r3.color(r7);	 Catch:{ IllegalArgumentException -> 0x009f }
    L_0x0098:
        r4.setImageDrawable(r3);	 Catch:{ IllegalArgumentException -> 0x009f }
        r4.setVisibility(r0);	 Catch:{ IllegalArgumentException -> 0x009f }
        goto L_0x00af;
    L_0x009f:
        r3 = move-exception;
        r7 = f1634a;
        r0 = r3.getMessage();
        android.util.Log.e(r7, r0, r3);
        goto L_0x00ac;
    L_0x00aa:
        if (r4 == 0) goto L_0x00af;
    L_0x00ac:
        r4.setVisibility(r5);
    L_0x00af:
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.gonative.android.r.getChildView(int, int, boolean, android.view.View, android.view.ViewGroup):android.view.View");
    }

    public int getChildrenCount(int i) {
        try {
            JSONObject jSONObject = (JSONObject) this.f1636c.get(i);
            return jSONObject.optBoolean("isGrouping", false) ? jSONObject.getJSONArray("subLinks").length() : 0;
        } catch (Throwable e) {
            Log.e(f1634a, e.getMessage(), e);
            return 0;
        }
    }

    public Object getGroup(int i) {
        return null;
    }

    public int getGroupCount() {
        return this.f1636c.length();
    }

    public long getGroupId(int i) {
        return 0;
    }

    public int getGroupType(int i) {
        return this.f1637d ? 0 : 1;
    }

    public int getGroupTypeCount() {
        return 2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View getGroupView(int r5, boolean r6, android.view.View r7, android.view.ViewGroup r8) {
        /*
        r4 = this;
        r8 = 2131165297; // 0x7f070071 float:1.7944807E38 double:1.052935559E-314;
        if (r7 != 0) goto L_0x003a;
    L_0x0005:
        r7 = r4.f1635b;
        r7 = r7.getLayoutInflater();
        r0 = r4.f1637d;
        if (r0 == 0) goto L_0x0013;
    L_0x000f:
        r0 = 2131296297; // 0x7f090029 float:1.8210507E38 double:1.0530002815E-314;
        goto L_0x0016;
    L_0x0013:
        r0 = 2131296298; // 0x7f09002a float:1.8210509E38 double:1.053000282E-314;
    L_0x0016:
        r1 = 0;
        r7 = r7.inflate(r0, r1);
        r0 = r4.f1635b;
        r0 = io.gonative.android.p038a.C0700a.m1851a(r0);
        r0 = r0.ca;
        if (r0 == 0) goto L_0x003a;
    L_0x0025:
        r0 = r7.findViewById(r8);
        r0 = (android.widget.TextView) r0;
        r1 = r4.f1635b;
        r1 = io.gonative.android.p038a.C0700a.m1851a(r1);
        r1 = r1.ca;
        r1 = r1.intValue();
        r0.setTextColor(r1);
    L_0x003a:
        r0 = 2131165295; // 0x7f07006f float:1.7944803E38 double:1.052935558E-314;
        r0 = r7.findViewById(r0);
        r0 = (android.widget.ImageView) r0;
        r1 = r4.m1961c(r5);
        r2 = 0;
        if (r1 == 0) goto L_0x0087;
    L_0x004a:
        if (r6 == 0) goto L_0x0056;
    L_0x004c:
        r6 = new com.joanzapata.iconify.IconDrawable;
        r1 = r4.f1635b;
        r3 = com.joanzapata.iconify.fonts.FontAwesomeIcons.fa_angle_up;
        r6.<init>(r1, r3);
        goto L_0x005f;
    L_0x0056:
        r6 = new com.joanzapata.iconify.IconDrawable;
        r1 = r4.f1635b;
        r3 = com.joanzapata.iconify.fonts.FontAwesomeIcons.fa_angle_down;
        r6.<init>(r1, r3);
    L_0x005f:
        r1 = 2131034241; // 0x7f050081 float:1.7678994E38 double:1.0528708086E-314;
        r6 = r6.sizeRes(r1);
        r1 = r4.f1635b;
        r1 = io.gonative.android.p038a.C0700a.m1851a(r1);
        r1 = r1.ca;
        if (r1 == 0) goto L_0x0080;
    L_0x0070:
        r1 = r4.f1635b;
        r1 = io.gonative.android.p038a.C0700a.m1851a(r1);
        r1 = r1.ca;
        r1 = r1.intValue();
        r6 = r6.color(r1);
    L_0x0080:
        r0.setImageDrawable(r6);
        r0.setVisibility(r2);
        goto L_0x008c;
    L_0x0087:
        r6 = 8;
        r0.setVisibility(r6);
    L_0x008c:
        r6 = r7.findViewById(r8);
        r6 = (android.widget.TextView) r6;
        r8 = r4.m1952a(r5);
        r6.setText(r8);
        r6 = "icon";
        r5 = r4.m1954a(r6, r5);
        r6 = 2131165296; // 0x7f070070 float:1.7944805E38 double:1.0529355584E-314;
        r6 = r7.findViewById(r6);
        r6 = (android.widget.ImageView) r6;
        r8 = 4;
        if (r5 == 0) goto L_0x00f7;
    L_0x00ab:
        r0 = r5.isEmpty();
        if (r0 != 0) goto L_0x00f7;
    L_0x00b1:
        r0 = "-";
        r1 = "_";
        r5 = r5.replaceAll(r0, r1);
        r0 = new com.joanzapata.iconify.IconDrawable;	 Catch:{ IllegalArgumentException -> 0x00ec }
        r1 = r4.f1635b;	 Catch:{ IllegalArgumentException -> 0x00ec }
        r5 = com.joanzapata.iconify.fonts.FontAwesomeIcons.valueOf(r5);	 Catch:{ IllegalArgumentException -> 0x00ec }
        r0.<init>(r1, r5);	 Catch:{ IllegalArgumentException -> 0x00ec }
        r5 = 2131034242; // 0x7f050082 float:1.7678996E38 double:1.052870809E-314;
        r5 = r0.sizeRes(r5);	 Catch:{ IllegalArgumentException -> 0x00ec }
        r0 = r4.f1635b;	 Catch:{ IllegalArgumentException -> 0x00ec }
        r0 = io.gonative.android.p038a.C0700a.m1851a(r0);	 Catch:{ IllegalArgumentException -> 0x00ec }
        r0 = r0.ca;	 Catch:{ IllegalArgumentException -> 0x00ec }
        if (r0 == 0) goto L_0x00e5;
    L_0x00d5:
        r0 = r4.f1635b;	 Catch:{ IllegalArgumentException -> 0x00ec }
        r0 = io.gonative.android.p038a.C0700a.m1851a(r0);	 Catch:{ IllegalArgumentException -> 0x00ec }
        r0 = r0.ca;	 Catch:{ IllegalArgumentException -> 0x00ec }
        r0 = r0.intValue();	 Catch:{ IllegalArgumentException -> 0x00ec }
        r5 = r5.color(r0);	 Catch:{ IllegalArgumentException -> 0x00ec }
    L_0x00e5:
        r6.setImageDrawable(r5);	 Catch:{ IllegalArgumentException -> 0x00ec }
        r6.setVisibility(r2);	 Catch:{ IllegalArgumentException -> 0x00ec }
        goto L_0x00fc;
    L_0x00ec:
        r5 = move-exception;
        r0 = f1634a;
        r1 = r5.getMessage();
        android.util.Log.e(r0, r1, r5);
        goto L_0x00f9;
    L_0x00f7:
        if (r6 == 0) goto L_0x00fc;
    L_0x00f9:
        r6.setVisibility(r8);
    L_0x00fc:
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.gonative.android.r.getGroupView(int, boolean, android.view.View, android.view.ViewGroup):android.view.View");
    }

    public boolean hasStableIds() {
        return false;
    }

    public boolean isChildSelectable(int i, int i2) {
        return true;
    }

    public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
        Pair b = m1960b(i, i2);
        m1958a((String) b.first, (String) b.second);
        return true;
    }

    public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
        try {
            if (m1961c(i)) {
                return false;
            }
            Pair b = m1959b(i);
            m1958a((String) b.first, (String) b.second);
            return true;
        } catch (Throwable e) {
            Log.e(f1634a, e.getMessage(), e);
            return false;
        }
    }
}
