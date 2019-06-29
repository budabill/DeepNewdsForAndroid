package io.gonative.android;

import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import io.gonative.android.azzpro.R;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: io.gonative.android.V */
public class C0691V implements OnItemSelectedListener {
    /* renamed from: a */
    private static final String f1474a = "io.gonative.android.V";
    /* renamed from: b */
    private MainActivity f1475b;
    /* renamed from: c */
    private JSONArray f1476c;
    /* renamed from: d */
    private ArrayList<String> f1477d = new ArrayList();
    /* renamed from: e */
    private ArrayList<String> f1478e = new ArrayList();
    /* renamed from: f */
    private int f1479f;
    /* renamed from: g */
    private ArrayAdapter<String> f1480g;
    /* renamed from: h */
    private Spinner f1481h;
    /* renamed from: i */
    private C0690a f1482i;

    /* renamed from: io.gonative.android.V$a */
    public class C0690a {
        /* renamed from: a */
        final /* synthetic */ C0691V f1473a;

        public C0690a(C0691V c0691v) {
            this.f1473a = c0691v;
        }

        @JavascriptInterface
        public void parseJson(String str) {
            this.f1473a.m1825a(str);
        }
    }

    public C0691V(MainActivity mainActivity, Spinner spinner) {
        this.f1475b = mainActivity;
        this.f1481h = spinner;
        this.f1481h.setAdapter(m1826b());
        this.f1481h.setOnItemSelectedListener(this);
        this.f1482i = new C0690a(this);
    }

    /* renamed from: a */
    private void m1825a(String str) {
        String str2 = "";
        try {
            this.f1476c = new JSONArray(str);
            this.f1477d.clear();
            this.f1478e.clear();
            for (int i = 0; i < this.f1476c.length(); i++) {
                JSONObject jSONObject = this.f1476c.getJSONObject(i);
                this.f1477d.add(jSONObject.optString("name", str2));
                this.f1478e.add(jSONObject.optString("link", str2));
                if (jSONObject.optBoolean("selected", false)) {
                    this.f1479f = i;
                }
            }
            this.f1475b.runOnUiThread(new C0688T(this));
        } catch (Throwable e) {
            Log.e(f1474a, e.getMessage(), e);
        }
    }

    /* renamed from: b */
    private ArrayAdapter<String> m1826b() {
        if (this.f1480g == null) {
            this.f1480g = new C0689U(this, this.f1475b, R.layout.profile_picker_dropdown, this.f1477d);
        }
        return this.f1480g;
    }

    /* renamed from: a */
    public C0690a m1832a() {
        return this.f1482i;
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        if (i != this.f1479f) {
            this.f1475b.m2606d((String) this.f1478e.get(i));
            this.f1475b.m2605d();
            this.f1479f = i;
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
