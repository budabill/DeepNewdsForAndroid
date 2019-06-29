package com.facebook;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import com.facebook.common.C0445b;
import com.facebook.common.C0446c;
import com.facebook.internal.C0465I;
import com.facebook.internal.C0475Q;
import com.facebook.internal.C0925p;
import com.facebook.login.C0916x;
import com.facebook.share.internal.DeviceShareDialogFragment;
import com.facebook.share.model.ShareContent;

public class FacebookActivity extends FragmentActivity {
    private static final String TAG = "com.facebook.FacebookActivity";
    /* renamed from: a */
    public static String f1984a = "PassThrough";
    /* renamed from: b */
    private static String f1985b = "SingleFragment";
    /* renamed from: c */
    private Fragment f1986c;

    /* renamed from: e */
    private void m2504e() {
        setResult(0, C0465I.m915a(getIntent(), null, C0465I.m919a(C0465I.m926b(getIntent()))));
        finish();
    }

    /* renamed from: c */
    public Fragment m2505c() {
        return this.f1986c;
    }

    /* renamed from: d */
    protected Fragment m2506d() {
        Intent intent = getIntent();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(f1985b);
        if (findFragmentByTag != null) {
            return findFragmentByTag;
        }
        if ("FacebookDialogFragment".equals(intent.getAction())) {
            findFragmentByTag = new C0925p();
            findFragmentByTag.setRetainInstance(true);
        } else {
            if ("DeviceShareDialogFragment".equals(intent.getAction())) {
                findFragmentByTag = new DeviceShareDialogFragment();
                findFragmentByTag.setRetainInstance(true);
                findFragmentByTag.m2547a((ShareContent) intent.getParcelableExtra("content"));
            } else {
                findFragmentByTag = new C0916x();
                findFragmentByTag.setRetainInstance(true);
                supportFragmentManager.beginTransaction().add(C0445b.com_facebook_fragment_container, findFragmentByTag, f1985b).commit();
                return findFragmentByTag;
            }
        }
        findFragmentByTag.show(supportFragmentManager, f1985b);
        return findFragmentByTag;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Fragment fragment = this.f1986c;
        if (fragment != null) {
            fragment.onConfigurationChanged(configuration);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (!C0560t.m1264p()) {
            C0475Q.m984a(TAG, "Facebook SDK not initialized. Make sure you call sdkInitialize inside your Application's onCreate method.");
            C0560t.m1250c(getApplicationContext());
        }
        setContentView(C0446c.com_facebook_activity_layout);
        if (f1984a.equals(intent.getAction())) {
            m2504e();
        } else {
            this.f1986c = m2506d();
        }
    }
}
