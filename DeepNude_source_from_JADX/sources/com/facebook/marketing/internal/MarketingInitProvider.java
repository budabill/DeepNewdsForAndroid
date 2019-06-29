package com.facebook.marketing.internal;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.facebook.C0560t;
import com.facebook.p035c.C0441b;

public final class MarketingInitProvider extends ContentProvider {
    /* renamed from: a */
    private static final String f1013a = "MarketingInitProvider";

    /* renamed from: a */
    private void m1195a() {
        C0441b.m850a((Application) C0560t.m1252d());
        C0539k.m1218a();
        new C0536h((Application) C0560t.m1252d(), C0560t.m1253e()).m1214a();
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        try {
            if (C0560t.m1264p()) {
                m1195a();
            } else {
                C0560t.m1242a(getContext(), new C0859g(this));
            }
        } catch (Throwable e) {
            Log.i(f1013a, "Failed to auto initialize the Marketing SDK", e);
        }
        return false;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
