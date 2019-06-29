package io.gonative.android;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import io.gonative.android.azzpro.R;
import io.gonative.android.p038a.C0700a;
import java.util.HashSet;

public class SplashActivity extends AppCompatActivity {
    /* renamed from: a */
    private void m2634a(boolean z) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.addFlags(131072);
        if (z) {
            intent.putExtra("noSplash", true);
        }
        startActivity(intent);
        finish();
    }

    protected void onCreate(Bundle bundle) {
        setTheme(R.style.SplashScreen);
        super.onCreate(bundle);
        HashSet hashSet = new HashSet();
        if (C0700a.m1851a((Context) this).f1553y) {
            hashSet.add("android.permission.CAMERA");
            hashSet.add("android.permission.RECORD_AUDIO");
            hashSet.add("android.permission.MODIFY_AUDIO_SETTINGS");
        }
        if (LeanWebView.m2363b()) {
            hashSet.add("android.permission.READ_CONTACTS");
            hashSet.add("android.permission.WRITE_CONTACTS");
        }
        if (hashSet.isEmpty()) {
            m2634a(false);
        } else {
            ActivityCompat.requestPermissions(this, (String[]) hashSet.toArray(new String[0]), 100);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        m2634a(true);
    }
}
