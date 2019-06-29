package com.facebook;

import com.facebook.GraphRequest.C0338b;
import com.facebook.internal.C0461G;
import com.facebook.internal.C0475Q;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.facebook.x */
class C0867x implements C0338b {
    /* renamed from: a */
    final /* synthetic */ C0338b f1817a;
    /* renamed from: b */
    final /* synthetic */ GraphRequest f1818b;

    C0867x(GraphRequest graphRequest, C0338b c0338b) {
        this.f1818b = graphRequest;
        this.f1817a = c0338b;
    }

    /* renamed from: a */
    public void mo949a(C0331D c0331d) {
        JSONObject b = c0331d.m487b();
        b = b != null ? b.optJSONObject("__debug__") : null;
        JSONArray optJSONArray = b != null ? b.optJSONArray("messages") : null;
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                String optString = optJSONObject != null ? optJSONObject.optString("message") : null;
                String optString2 = optJSONObject != null ? optJSONObject.optString("type") : null;
                String optString3 = optJSONObject != null ? optJSONObject.optString("link") : null;
                if (!(optString == null || optString2 == null)) {
                    C0336G c0336g = C0336G.GRAPH_API_DEBUG_INFO;
                    if (optString2.equals("warning")) {
                        c0336g = C0336G.GRAPH_API_DEBUG_WARNING;
                    }
                    if (!C0475Q.m998b(optString3)) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(optString);
                        stringBuilder.append(" Link: ");
                        stringBuilder.append(optString3);
                        optString = stringBuilder.toString();
                    }
                    C0461G.m891a(c0336g, GraphRequest.f478a, optString);
                }
            }
        }
        C0338b c0338b = this.f1817a;
        if (c0338b != null) {
            c0338b.mo949a(c0331d);
        }
    }
}
