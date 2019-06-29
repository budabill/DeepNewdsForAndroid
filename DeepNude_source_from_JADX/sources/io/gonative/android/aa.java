package io.gonative.android;

import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import io.gonative.android.p038a.C0700a;
import java.util.ArrayList;
import org.json.JSONObject;

public class aa implements OnItemSelectedListener {
    /* renamed from: a */
    private MainActivity f1561a;
    /* renamed from: b */
    private ArrayList<String> f1562b = new ArrayList();
    /* renamed from: c */
    private ArrayList<String> f1563c = new ArrayList();
    /* renamed from: d */
    private int f1564d;
    /* renamed from: e */
    private ArrayAdapter<String> f1565e;
    /* renamed from: f */
    private Spinner f1566f;

    aa(MainActivity mainActivity, Spinner spinner) {
        this.f1561a = mainActivity;
        this.f1566f = spinner;
        this.f1566f.setAdapter(m1902a());
        this.f1566f.setOnItemSelectedListener(this);
        LocalBroadcastManager.getInstance(this.f1561a).registerReceiver(new C0696Y(this), new IntentFilter("io.gonative.android.AppConfig.processedSegmentedControl"));
        m1905b();
    }

    /* renamed from: a */
    private ArrayAdapter<String> m1902a() {
        ArrayAdapter<String> arrayAdapter = this.f1565e;
        if (arrayAdapter != null) {
            return arrayAdapter;
        }
        arrayAdapter = new ArrayAdapter(this.f1561a, 17367048, this.f1562b);
        arrayAdapter.setDropDownViewResource(17367049);
        this.f1565e = arrayAdapter;
        return arrayAdapter;
    }

    /* renamed from: b */
    private void m1905b() {
        this.f1562b.clear();
        this.f1563c.clear();
        this.f1564d = -1;
        C0700a a = C0700a.m1851a(this.f1561a);
        if (a.f1524T != null) {
            for (int i = 0; i < a.f1524T.size(); i++) {
                JSONObject jSONObject = (JSONObject) a.f1524T.get(i);
                String optString = jSONObject.optString("label", "Invalid");
                String optString2 = jSONObject.optString("url", "");
                Boolean valueOf = Boolean.valueOf(jSONObject.optBoolean("selected"));
                this.f1562b.add(i, optString);
                this.f1563c.add(i, optString2);
                if (valueOf.booleanValue()) {
                    this.f1564d = i;
                }
            }
            this.f1561a.runOnUiThread(new C0697Z(this));
        }
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        if (i != this.f1564d) {
            String str = (String) this.f1563c.get(i);
            if (str != null && str.length() > 0) {
                this.f1561a.m2606d(str);
            }
            this.f1561a.m2605d();
            this.f1564d = i;
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
