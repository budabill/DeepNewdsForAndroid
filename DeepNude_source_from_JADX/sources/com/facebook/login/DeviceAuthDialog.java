package com.facebook.login;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.DialogFragment;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.AccessToken;
import com.facebook.C0328B;
import com.facebook.C0332E;
import com.facebook.C0451h;
import com.facebook.C0506l;
import com.facebook.C0560t;
import com.facebook.FacebookActivity;
import com.facebook.GraphRequest;
import com.facebook.common.C0445b;
import com.facebook.common.C0446c;
import com.facebook.common.C0447d;
import com.facebook.common.C0448e;
import com.facebook.internal.C0475Q.C0474b;
import com.facebook.internal.C0476S;
import com.facebook.login.LoginClient.Request;
import com.facebook.p029a.C0422r;
import com.facebook.p033b.p034a.C0438b;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class DeviceAuthDialog extends DialogFragment {
    /* renamed from: a */
    private View f1988a;
    /* renamed from: b */
    private TextView f1989b;
    /* renamed from: c */
    private TextView f1990c;
    /* renamed from: d */
    private DeviceAuthMethodHandler f1991d;
    /* renamed from: e */
    private AtomicBoolean f1992e = new AtomicBoolean();
    /* renamed from: f */
    private volatile C0328B f1993f;
    /* renamed from: g */
    private volatile ScheduledFuture f1994g;
    /* renamed from: h */
    private volatile RequestState f1995h;
    /* renamed from: i */
    private Dialog f1996i;
    /* renamed from: j */
    private boolean f1997j = false;
    /* renamed from: k */
    private boolean f1998k = false;
    /* renamed from: l */
    private Request f1999l = null;

    private static class RequestState implements Parcelable {
        public static final Creator<RequestState> CREATOR = new C0518j();
        /* renamed from: a */
        private String f943a;
        /* renamed from: b */
        private String f944b;
        /* renamed from: c */
        private String f945c;
        /* renamed from: d */
        private long f946d;
        /* renamed from: e */
        private long f947e;

        RequestState() {
        }

        protected RequestState(Parcel parcel) {
            this.f943a = parcel.readString();
            this.f944b = parcel.readString();
            this.f945c = parcel.readString();
            this.f946d = parcel.readLong();
            this.f947e = parcel.readLong();
        }

        /* renamed from: a */
        public String m1111a() {
            return this.f943a;
        }

        /* renamed from: a */
        public void m1112a(long j) {
            this.f946d = j;
        }

        /* renamed from: a */
        public void m1113a(String str) {
            this.f945c = str;
        }

        /* renamed from: b */
        public long m1114b() {
            return this.f946d;
        }

        /* renamed from: b */
        public void m1115b(long j) {
            this.f947e = j;
        }

        /* renamed from: b */
        public void m1116b(String str) {
            this.f944b = str;
            this.f943a = String.format(Locale.ENGLISH, "https://facebook.com/device?user_code=%1$s&qr=1", new Object[]{str});
        }

        /* renamed from: c */
        public String m1117c() {
            return this.f945c;
        }

        /* renamed from: d */
        public String m1118d() {
            return this.f944b;
        }

        public int describeContents() {
            return 0;
        }

        /* renamed from: e */
        public boolean m1119e() {
            boolean z = false;
            if (this.f947e == 0) {
                return false;
            }
            if ((new Date().getTime() - this.f947e) - (this.f946d * 1000) < 0) {
                z = true;
            }
            return z;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f943a);
            parcel.writeString(this.f944b);
            parcel.writeString(this.f945c);
            parcel.writeLong(this.f946d);
            parcel.writeLong(this.f947e);
        }
    }

    /* renamed from: a */
    private void m2512a(RequestState requestState) {
        this.f1995h = requestState;
        this.f1989b.setText(requestState.m1118d());
        this.f1990c.setCompoundDrawablesWithIntrinsicBounds(null, new BitmapDrawable(getResources(), C0438b.m836b(requestState.m1111a())), null, null);
        this.f1989b.setVisibility(0);
        this.f1988a.setVisibility(8);
        if (!this.f1998k && C0438b.m838c(requestState.m1118d())) {
            C0422r.m795b(getContext()).m806a("fb_smart_login_service", null, null);
        }
        if (requestState.m1119e()) {
            m2527d();
        } else {
            m2524c();
        }
    }

    /* renamed from: a */
    private void m2517a(String str, C0474b c0474b, String str2, String str3, Date date, Date date2) {
        CharSequence string = getResources().getString(C0447d.com_facebook_smart_login_confirmation_title);
        String string2 = getResources().getString(C0447d.com_facebook_smart_login_confirmation_continue_as);
        CharSequence string3 = getResources().getString(C0447d.com_facebook_smart_login_confirmation_cancel);
        CharSequence format = String.format(string2, new Object[]{str3});
        Builder builder = new Builder(getContext());
        DeviceAuthDialog deviceAuthDialog = this;
        builder.setMessage(string).setCancelable(true).setNegativeButton(format, new C0517h(this, str, c0474b, str2, date, date2)).setPositiveButton(string3, new C0516g(this));
        builder.create().show();
    }

    /* renamed from: a */
    private void m2518a(String str, C0474b c0474b, String str2, Date date, Date date2) {
        this.f1991d.m2175a(str2, C0560t.m1253e(), str, c0474b.m955b(), c0474b.m954a(), C0451h.DEVICE_AUTH, date, null, date2);
        this.f1996i.dismiss();
    }

    /* renamed from: a */
    private void m2519a(String str, Long l, Long l2) {
        Bundle bundle = new Bundle();
        bundle.putString("fields", "id,permissions,name");
        Date date = null;
        Date date2 = l.longValue() != 0 ? new Date(new Date().getTime() + (l.longValue() * 1000)) : null;
        if (!(l2.longValue() == 0 || l2 == null)) {
            date = new Date(l2.longValue() * 1000);
        }
        new GraphRequest(new AccessToken(str, C0560t.m1253e(), "0", null, null, null, date2, null, date), "me", bundle, C0332E.GET, new C0851i(this, str, date2, date)).m556c();
    }

    /* renamed from: b */
    private GraphRequest m2522b() {
        Bundle bundle = new Bundle();
        bundle.putString("code", this.f1995h.m1117c());
        return new GraphRequest(null, "device/login_status", bundle, C0332E.POST, new C0850f(this));
    }

    /* renamed from: c */
    private void m2524c() {
        this.f1995h.m1115b(new Date().getTime());
        this.f1993f = m2522b().m556c();
    }

    /* renamed from: d */
    private void m2527d() {
        this.f1994g = DeviceAuthMethodHandler.m2173e().schedule(new C0515e(this), this.f1995h.m1114b(), TimeUnit.SECONDS);
    }

    /* renamed from: a */
    protected int m2532a(boolean z) {
        return z ? C0446c.com_facebook_smart_device_dialog_fragment : C0446c.com_facebook_device_auth_dialog_fragment;
    }

    /* renamed from: a */
    protected void m2533a() {
        if (this.f1992e.compareAndSet(false, true)) {
            if (this.f1995h != null) {
                C0438b.m835a(this.f1995h.m1118d());
            }
            DeviceAuthMethodHandler deviceAuthMethodHandler = this.f1991d;
            if (deviceAuthMethodHandler != null) {
                deviceAuthMethodHandler.m2179f();
            }
            this.f1996i.dismiss();
        }
    }

    /* renamed from: a */
    protected void m2534a(C0506l c0506l) {
        if (this.f1992e.compareAndSet(false, true)) {
            if (this.f1995h != null) {
                C0438b.m835a(this.f1995h.m1118d());
            }
            this.f1991d.m2174a((Exception) c0506l);
            this.f1996i.dismiss();
        }
    }

    /* renamed from: a */
    public void m2535a(Request request) {
        this.f1999l = request;
        Bundle bundle = new Bundle();
        bundle.putString("scope", TextUtils.join(",", request.m1128h()));
        String f = request.m1126f();
        if (f != null) {
            bundle.putString("redirect_uri", f);
        }
        String e = request.m1125e();
        if (e != null) {
            bundle.putString("target_user_id", e);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(C0476S.m1014a());
        stringBuilder.append("|");
        stringBuilder.append(C0476S.m1020b());
        bundle.putString("access_token", stringBuilder.toString());
        bundle.putString("device_info", C0438b.m834a());
        new GraphRequest(null, "device/login", bundle, C0332E.POST, new C0849c(this)).m556c();
    }

    /* renamed from: b */
    protected View m2536b(boolean z) {
        View inflate = getActivity().getLayoutInflater().inflate(m2532a(z), null);
        this.f1988a = inflate.findViewById(C0445b.progress_bar);
        this.f1989b = (TextView) inflate.findViewById(C0445b.confirmation_code);
        ((Button) inflate.findViewById(C0445b.cancel_button)).setOnClickListener(new C0514d(this));
        this.f1990c = (TextView) inflate.findViewById(C0445b.com_facebook_device_auth_instructions);
        this.f1990c.setText(Html.fromHtml(getString(C0447d.com_facebook_device_auth_instructions)));
        return inflate;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        this.f1996i = new Dialog(getActivity(), C0448e.com_facebook_auth_dialog);
        boolean z = C0438b.m837b() && !this.f1998k;
        this.f1996i.setContentView(m2536b(z));
        return this.f1996i;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.f1991d = (DeviceAuthMethodHandler) ((C0916x) ((FacebookActivity) getActivity()).m2505c()).m2479c().m1161d();
        if (bundle != null) {
            RequestState requestState = (RequestState) bundle.getParcelable("request_state");
            if (requestState != null) {
                m2512a(requestState);
            }
        }
        return onCreateView;
    }

    public void onDestroy() {
        this.f1997j = true;
        this.f1992e.set(true);
        super.onDestroy();
        if (this.f1993f != null) {
            this.f1993f.cancel(true);
        }
        if (this.f1994g != null) {
            this.f1994g.cancel(true);
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (!this.f1997j) {
            m2533a();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.f1995h != null) {
            bundle.putParcelable("request_state", this.f1995h);
        }
    }
}
