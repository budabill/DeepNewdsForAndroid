package com.facebook.login;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.C0445b;
import com.facebook.common.C0446c;
import com.facebook.login.LoginClient.Request;
import com.facebook.login.LoginClient.Result;
import com.facebook.login.LoginClient.Result.C0509a;

/* renamed from: com.facebook.login.x */
public class C0916x extends Fragment {
    /* renamed from: a */
    private String f1962a;
    /* renamed from: b */
    private LoginClient f1963b;
    /* renamed from: c */
    private Request f1964c;

    /* renamed from: a */
    private void m2474a(Activity activity) {
        ComponentName callingActivity = activity.getCallingActivity();
        if (callingActivity != null) {
            this.f1962a = callingActivity.getPackageName();
        }
    }

    /* renamed from: a */
    private void m2475a(Result result) {
        this.f1964c = null;
        int i = result.f962a == C0509a.CANCEL ? 0 : -1;
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.facebook.LoginFragment:Result", result);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        if (isAdded()) {
            getActivity().setResult(i, intent);
            getActivity().finish();
        }
    }

    /* renamed from: a */
    protected LoginClient m2477a() {
        return new LoginClient((Fragment) this);
    }

    /* renamed from: b */
    protected int m2478b() {
        return C0446c.com_facebook_login_fragment;
    }

    /* renamed from: c */
    LoginClient m2479c() {
        return this.f1963b;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.f1963b.m1154a(i, i2, intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f1963b = (LoginClient) bundle.getParcelable("loginClient");
            this.f1963b.m1149a((Fragment) this);
        } else {
            this.f1963b = m2477a();
        }
        this.f1963b.m1153a(new C0855v(this));
        Activity activity = getActivity();
        if (activity != null) {
            m2474a(activity);
            Intent intent = activity.getIntent();
            if (intent != null) {
                bundle = intent.getBundleExtra("com.facebook.LoginFragment:Request");
                if (bundle != null) {
                    this.f1964c = (Request) bundle.getParcelable("request");
                }
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(m2478b(), viewGroup, false);
        this.f1963b.m1152a(new C0856w(this, inflate.findViewById(C0445b.com_facebook_login_fragment_progress_bar)));
        return inflate;
    }

    public void onDestroy() {
        this.f1963b.m1148a();
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
        View findViewById = getView() == null ? null : getView().findViewById(C0445b.com_facebook_login_fragment_progress_bar);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
    }

    public void onResume() {
        super.onResume();
        if (this.f1962a == null) {
            Log.e("LoginFragment", "Cannot call LoginFragment with a null calling package. This can occur if the launchMode of the caller is singleInstance.");
            getActivity().finish();
            return;
        }
        this.f1963b.m1159c(this.f1964c);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("loginClient", this.f1963b);
    }
}
