package com.facebook.marketing.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.facebook.C0560t;
import com.facebook.GraphRequest;
import com.facebook.internal.C0489b;
import com.facebook.p029a.p030a.p031a.C0353d;
import com.facebook.p029a.p030a.p031a.C0355f;
import com.facebook.p029a.p032b.C0383i;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.facebook.marketing.internal.f */
public class C0535f {
    /* renamed from: a */
    private static final String f1033a = "com.facebook.marketing.internal.f";
    /* renamed from: b */
    private static volatile Set<String> f1034b = new HashSet();
    /* renamed from: c */
    private static volatile Set<String> f1035c = new HashSet();

    /* renamed from: a */
    private static JSONObject m1210a(View view, String str, boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            String[] split = str.split("\\.", -1);
            int length = split.length - 1;
            View view2 = view;
            while (view2 != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("classname", view2.getClass().getCanonicalName());
                jSONObject2.put("index", split[length]);
                jSONObject2.put("id", view2.getId());
                Object obj = "";
                jSONObject2.put("text", C0353d.m594a(view2) ? obj : C0355f.m616h(view2));
                jSONObject2.put("tag", view2.getTag() == null ? obj : String.valueOf(view2.getTag()));
                String str2 = "description";
                if (view2.getContentDescription() != null) {
                    obj = String.valueOf(view2.getContentDescription());
                }
                jSONObject2.put(str2, obj);
                jSONArray.put(jSONObject2);
                view2 = C0355f.m615g(view2);
                length--;
            }
            JSONArray jSONArray2 = new JSONArray();
            for (int length2 = jSONArray.length() - 1; length2 >= 0; length2--) {
                jSONArray2.put(jSONArray.get(length2));
            }
            jSONObject.put("path", jSONArray2);
            jSONObject.put("is_from_click", z);
            if (view instanceof ImageView) {
                Bitmap bitmap = ((BitmapDrawable) ((ImageView) view).getDrawable()).getBitmap();
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                jSONObject.put("image", Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0));
            }
            return jSONObject;
        } catch (Throwable e) {
            Log.e(f1033a, "Log button indexing error", e);
            return new JSONObject();
        }
    }

    /* renamed from: a */
    private static void m1211a(Context context, String str, String str2) {
        C0489b a = C0489b.m1065a(context);
        if (a != null && a.m1072a() != null) {
            String a2 = a.m1072a();
            String c = C0383i.m691c();
            Bundle bundle = new Bundle();
            try {
                bundle.putString("app_version", c);
                bundle.putString("device_id", a2);
                bundle.putString("indexed_button_list", str);
                GraphRequest a3 = GraphRequest.m513a(null, String.format(Locale.US, "%s/button_indexing", new Object[]{str2}), null, null);
                a3.m550a(bundle);
                a3.m555b();
            } catch (Throwable e) {
                Log.e(f1033a, "failed to send button indexing request", e);
            }
        }
    }

    /* renamed from: a */
    public static void m1212a(String str, View view, String str2, Context context) {
        if (!f1034b.contains(str2)) {
            f1034b.add(str2);
            if (C0535f.m1210a(view, str2, true).length() > 0) {
                C0535f.m1211a(context, new JSONArray(Arrays.asList(new String[]{C0535f.m1210a(view, str2, true).toString()})).toString(), str);
            }
        }
    }

    /* renamed from: a */
    public static void m1213a(JSONObject jSONObject, String str) {
        C0560t.m1258j().execute(new C0534e(str, jSONObject));
    }
}
