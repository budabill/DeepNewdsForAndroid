package com.facebook.p029a.p030a.p031a;

import android.util.Log;

/* renamed from: com.facebook.a.a.a.e */
public class C0354e {
    /* renamed from: a */
    private static final String f555a = "com.facebook.a.a.a.e";
    /* renamed from: b */
    private static Class<?> f556b;

    /* renamed from: a */
    public static void m601a() {
        C0354e.m603a("UnityFacebookSDKPlugin", "CaptureViewHierarchy", "");
    }

    /* renamed from: a */
    public static void m602a(String str) {
        C0354e.m603a("UnityFacebookSDKPlugin", "OnReceiveMapping", str);
    }

    /* renamed from: a */
    public static void m603a(String str, String str2, String str3) {
        try {
            if (f556b == null) {
                f556b = Class.forName("com.unity3d.player.UnityPlayer");
            }
            f556b.getMethod("UnitySendMessage", new Class[]{String.class, String.class, String.class}).invoke(f556b, new Object[]{str, str2, str3});
        } catch (Throwable e) {
            Log.e(f555a, "Failed to send message to Unity", e);
        }
    }
}
