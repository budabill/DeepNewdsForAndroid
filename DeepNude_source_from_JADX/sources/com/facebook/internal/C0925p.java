package com.facebook.internal;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import com.facebook.C0506l;
import com.facebook.C0560t;
import com.facebook.internal.C0485X.C0481a;

/* renamed from: com.facebook.internal.p */
public class C0925p extends DialogFragment {
    /* renamed from: a */
    private Dialog f1987a;

    /* renamed from: a */
    private void m2507a(Bundle bundle) {
        Activity activity = getActivity();
        Intent intent = new Intent();
        if (bundle == null) {
            bundle = new Bundle();
        }
        intent.putExtras(bundle);
        activity.setResult(-1, intent);
        activity.finish();
    }

    /* renamed from: a */
    private void m2508a(Bundle bundle, C0506l c0506l) {
        Activity activity = getActivity();
        activity.setResult(c0506l == null ? -1 : 0, C0465I.m915a(activity.getIntent(), bundle, c0506l));
        activity.finish();
    }

    /* renamed from: a */
    public void m2511a(Dialog dialog) {
        this.f1987a = dialog;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if ((this.f1987a instanceof C0485X) && isResumed()) {
            ((C0485X) this.f1987a).m1061e();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.f1987a == null) {
            String string;
            Context activity = getActivity();
            Bundle b = C0465I.m926b(activity.getIntent());
            String str = "FacebookDialogFragment";
            Dialog a;
            if (b.getBoolean("is_fallback", false)) {
                string = b.getString("url");
                if (C0475Q.m998b(string)) {
                    string = "Cannot start a fallback WebDialog with an empty/missing 'url'";
                } else {
                    a = C0845w.m2166a(activity, string, String.format("fb%s://bridge/", new Object[]{C0560t.m1253e()}));
                    a.m1055a(new C0844o(this));
                    this.f1987a = a;
                }
            } else {
                String string2 = b.getString("action");
                b = b.getBundle("params");
                if (C0475Q.m998b(string2)) {
                    string = "Cannot start a WebDialog with an empty/missing 'actionName'";
                } else {
                    C0481a c0481a = new C0481a(activity, string2, b);
                    c0481a.m1026a(new C0843n(this));
                    a = c0481a.mo966a();
                    this.f1987a = a;
                }
            }
            C0475Q.m984a(str, string);
            activity.finish();
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        if (this.f1987a == null) {
            m2508a(null, null);
            setShowsDialog(false);
        }
        return this.f1987a;
    }

    public void onDestroyView() {
        if (getDialog() != null && getRetainInstance()) {
            getDialog().setDismissMessage(null);
        }
        super.onDestroyView();
    }

    public void onResume() {
        super.onResume();
        Dialog dialog = this.f1987a;
        if (dialog instanceof C0485X) {
            ((C0485X) dialog).m1061e();
        }
    }
}
