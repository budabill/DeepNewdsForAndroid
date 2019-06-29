package com.onesignal;

import android.os.Bundle;
import java.util.ArrayList;
import org.json.JSONObject;

class Za implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ab f1239a;

    Za(ab abVar) {
        this.f1239a = abVar;
    }

    public void run() {
        this.f1239a.f1253j = true;
        try {
            if (this.f1239a.f1248e == null) {
                this.f1239a.f1248e = ab.m1481d(ab.f1245b);
                this.f1239a.f1248e.setAccessible(true);
            }
            Bundle bundle = (Bundle) this.f1239a.f1248e.invoke(this.f1239a.f1247d, new Object[]{Integer.valueOf(3), this.f1239a.f1250g.getPackageName(), "inapp", null});
            if (bundle.getInt("RESPONSE_CODE") == 0) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList stringArrayList2 = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                for (int i = 0; i < stringArrayList2.size(); i++) {
                    String str = (String) stringArrayList.get(i);
                    String string = new JSONObject((String) stringArrayList2.get(i)).getString("purchaseToken");
                    if (!(this.f1239a.f1251h.contains(string) || arrayList2.contains(string))) {
                        arrayList2.add(string);
                        arrayList.add(str);
                    }
                }
                if (arrayList.size() > 0) {
                    this.f1239a.m1471a(arrayList, arrayList2);
                } else if (stringArrayList2.size() == 0) {
                    this.f1239a.f1252i = false;
                    za.m1778b("GTPlayerPurchases", "ExistingPurchases", false);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f1239a.f1253j = false;
    }
}
