package com.facebook.internal;

import android.os.Bundle;
import com.facebook.internal.C0492k.C0491a;
import java.util.ArrayList;
import org.json.JSONArray;

/* renamed from: com.facebook.internal.j */
class C0842j implements C0491a {
    C0842j() {
    }

    /* renamed from: a */
    public void mo956a(Bundle bundle, String str, Object obj) {
        JSONArray jSONArray = (JSONArray) obj;
        ArrayList arrayList = new ArrayList();
        if (jSONArray.length() == 0) {
            bundle.putStringArrayList(str, arrayList);
            return;
        }
        int i = 0;
        while (i < jSONArray.length()) {
            Object obj2 = jSONArray.get(i);
            if (obj2 instanceof String) {
                arrayList.add((String) obj2);
                i++;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unexpected type in an array: ");
                stringBuilder.append(obj2.getClass());
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        bundle.putStringArrayList(str, arrayList);
    }
}
