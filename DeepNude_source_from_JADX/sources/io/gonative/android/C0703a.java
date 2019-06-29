package io.gonative.android;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import com.joanzapata.iconify.IconDrawable;
import com.joanzapata.iconify.fonts.FontAwesomeIcons;
import io.gonative.android.azzpro.R;
import io.gonative.android.p038a.C0700a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: io.gonative.android.a */
public class C0703a {
    /* renamed from: a */
    private static final String f1557a = "io.gonative.android.a";
    /* renamed from: b */
    private MainActivity f1558b;
    /* renamed from: c */
    private String f1559c;
    /* renamed from: d */
    private HashMap<MenuItem, String> f1560d = new HashMap();

    C0703a(MainActivity mainActivity) {
        this.f1558b = mainActivity;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private void m1898b(java.lang.String r4) {
        /*
        r3 = this;
        r0 = r3.f1559c;
        r1 = 0;
        r2 = 1;
        if (r0 != 0) goto L_0x000a;
    L_0x0006:
        if (r4 == 0) goto L_0x0013;
    L_0x0008:
        r1 = 1;
        goto L_0x0013;
    L_0x000a:
        if (r4 == 0) goto L_0x0008;
    L_0x000c:
        r0 = r0.equals(r4);
        if (r0 != 0) goto L_0x0013;
    L_0x0012:
        goto L_0x0008;
    L_0x0013:
        if (r1 == 0) goto L_0x001c;
    L_0x0015:
        r3.f1559c = r4;
        r4 = r3.f1558b;
        r4.invalidateOptionsMenu();
    L_0x001c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.gonative.android.a.b(java.lang.String):void");
    }

    /* renamed from: a */
    public void m1899a(Menu menu) {
        this.f1560d.clear();
        if (this.f1559c != null) {
            C0700a a = C0700a.m1851a(this.f1558b);
            HashMap hashMap = a.f1528X;
            if (hashMap != null) {
                JSONArray jSONArray = (JSONArray) hashMap.get(this.f1559c);
                if (jSONArray != null) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            String str;
                            String a2 = C0700a.m1852a(optJSONObject, "system");
                            if (a2 != null) {
                                str = "share";
                                if (a2.equals(str)) {
                                    TypedArray obtainStyledAttributes = this.f1558b.getTheme().obtainStyledAttributes(new int[]{R.attr.ic_action_share});
                                    Drawable drawable = obtainStyledAttributes.getDrawable(0);
                                    obtainStyledAttributes.recycle();
                                    this.f1560d.put(menu.add(0, i, 0, R.string.action_share).setIcon(drawable).setShowAsActionFlags(1), str);
                                }
                            }
                            CharSequence a3 = C0700a.m1852a(optJSONObject, "label");
                            str = C0700a.m1852a(optJSONObject, "icon");
                            String a4 = C0700a.m1852a(optJSONObject, "url");
                            Drawable drawable2 = null;
                            if (str != null) {
                                try {
                                    drawable2 = new IconDrawable(this.f1558b, FontAwesomeIcons.valueOf(str.replaceAll("-", "_"))).actionBarSize().color(a.la.intValue());
                                } catch (Throwable e) {
                                    Log.e(f1557a, e.getMessage(), e);
                                }
                            }
                            MenuItem showAsActionFlags = menu.add(0, i, 0, a3).setIcon(drawable2).setShowAsActionFlags(1);
                            if (a4 != null) {
                                this.f1560d.put(showAsActionFlags, a4);
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public void m1900a(String str) {
        Context context = this.f1558b;
        if (context != null) {
            if (str != null) {
                C0700a a = C0700a.m1851a(context);
                ArrayList arrayList = a.f1529Y;
                ArrayList arrayList2 = a.f1530Z;
                if (arrayList != null) {
                    if (arrayList2 != null) {
                        for (int i = 0; i < arrayList.size(); i++) {
                            if (((Pattern) arrayList.get(i)).matcher(str).matches()) {
                                m1898b((String) arrayList2.get(i));
                                return;
                            }
                        }
                        m1898b(null);
                        return;
                    }
                }
                m1898b(null);
            }
        }
    }

    /* renamed from: a */
    public boolean m1901a(MenuItem menuItem) {
        String str = (String) this.f1560d.get(menuItem);
        if (str == null) {
            return false;
        }
        if (str.equals("share")) {
            this.f1558b.m2612g(null);
            return true;
        }
        this.f1558b.m2606d(str);
        return true;
    }
}
