package com.onesignal;

import android.content.Context;
import com.onesignal.La.C0596a;

public class Na implements La {
    /* renamed from: a */
    private static C0596a f1826a = null;
    /* renamed from: b */
    private static boolean f1827b = false;

    /* renamed from: a */
    public static void m2242a(String str) {
        C0596a c0596a = f1826a;
        if (c0596a != null) {
            f1827b = true;
            c0596a.mo1392a(str, 1);
        }
    }

    /* renamed from: a */
    public void mo1363a(Context context, String str, C0596a c0596a) {
        f1826a = c0596a;
        new Thread(new Ma(this, context, c0596a)).start();
    }
}
