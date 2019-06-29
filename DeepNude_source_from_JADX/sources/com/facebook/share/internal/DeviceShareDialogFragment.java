package com.facebook.share.internal;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.DialogFragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.C0332E;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.common.C0445b;
import com.facebook.common.C0446c;
import com.facebook.common.C0447d;
import com.facebook.common.C0448e;
import com.facebook.internal.C0476S;
import com.facebook.p033b.p034a.C0438b;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DeviceShareDialogFragment extends DialogFragment {
    /* renamed from: a */
    private static ScheduledThreadPoolExecutor f2000a;
    /* renamed from: b */
    private ProgressBar f2001b;
    /* renamed from: c */
    private TextView f2002c;
    /* renamed from: d */
    private Dialog f2003d;
    /* renamed from: e */
    private volatile RequestState f2004e;
    /* renamed from: f */
    private volatile ScheduledFuture f2005f;
    /* renamed from: g */
    private ShareContent f2006g;

    private static class RequestState implements Parcelable {
        public static final Creator<RequestState> CREATOR = new C0548d();
        /* renamed from: a */
        private String f1045a;
        /* renamed from: b */
        private long f1046b;

        RequestState() {
        }

        protected RequestState(Parcel parcel) {
            this.f1045a = parcel.readString();
            this.f1046b = parcel.readLong();
        }

        /* renamed from: a */
        public long m1222a() {
            return this.f1046b;
        }

        /* renamed from: a */
        public void m1223a(long j) {
            this.f1046b = j;
        }

        /* renamed from: a */
        public void m1224a(String str) {
            this.f1045a = str;
        }

        /* renamed from: b */
        public String m1225b() {
            return this.f1045a;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f1045a);
            parcel.writeLong(this.f1046b);
        }
    }

    /* renamed from: a */
    private void m2538a() {
        if (isAdded()) {
            getFragmentManager().beginTransaction().remove(this).commit();
        }
    }

    /* renamed from: a */
    private void m2539a(int i, Intent intent) {
        if (this.f2004e != null) {
            C0438b.m835a(this.f2004e.m1225b());
        }
        FacebookRequestError facebookRequestError = (FacebookRequestError) intent.getParcelableExtra("error");
        if (facebookRequestError != null) {
            Toast.makeText(getContext(), facebookRequestError.m500c(), 0).show();
        }
        if (isAdded()) {
            Activity activity = getActivity();
            activity.setResult(i, intent);
            activity.finish();
        }
    }

    /* renamed from: a */
    private void m2540a(FacebookRequestError facebookRequestError) {
        m2538a();
        Intent intent = new Intent();
        intent.putExtra("error", facebookRequestError);
        m2539a(-1, intent);
    }

    /* renamed from: a */
    private void m2541a(RequestState requestState) {
        this.f2004e = requestState;
        this.f2002c.setText(requestState.m1225b());
        this.f2002c.setVisibility(0);
        this.f2001b.setVisibility(8);
        this.f2005f = m2544b().schedule(new C0547c(this), requestState.m1222a(), TimeUnit.SECONDS);
    }

    /* renamed from: b */
    private static synchronized ScheduledThreadPoolExecutor m2544b() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        synchronized (DeviceShareDialogFragment.class) {
            if (f2000a == null) {
                f2000a = new ScheduledThreadPoolExecutor(1);
            }
            scheduledThreadPoolExecutor = f2000a;
        }
        return scheduledThreadPoolExecutor;
    }

    /* renamed from: c */
    private Bundle m2545c() {
        ShareContent shareContent = this.f2006g;
        return shareContent == null ? null : shareContent instanceof ShareLinkContent ? C0552h.m1238a((ShareLinkContent) shareContent) : shareContent instanceof ShareOpenGraphContent ? C0552h.m1239a((ShareOpenGraphContent) shareContent) : null;
    }

    /* renamed from: d */
    private void m2546d() {
        Bundle c = m2545c();
        if (c == null || c.size() == 0) {
            m2540a(new FacebookRequestError(0, "", "Failed to get share content"));
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(C0476S.m1014a());
        stringBuilder.append("|");
        stringBuilder.append(C0476S.m1020b());
        c.putString("access_token", stringBuilder.toString());
        c.putString("device_info", C0438b.m834a());
        new GraphRequest(null, "device/share", c, C0332E.POST, new C0861b(this)).m556c();
    }

    /* renamed from: a */
    public void m2547a(ShareContent shareContent) {
        this.f2006g = shareContent;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        this.f2003d = new Dialog(getActivity(), C0448e.com_facebook_auth_dialog);
        View inflate = getActivity().getLayoutInflater().inflate(C0446c.com_facebook_device_auth_dialog_fragment, null);
        this.f2001b = (ProgressBar) inflate.findViewById(C0445b.progress_bar);
        this.f2002c = (TextView) inflate.findViewById(C0445b.confirmation_code);
        ((Button) inflate.findViewById(C0445b.cancel_button)).setOnClickListener(new C0546a(this));
        ((TextView) inflate.findViewById(C0445b.com_facebook_device_auth_instructions)).setText(Html.fromHtml(getString(C0447d.com_facebook_device_auth_instructions)));
        this.f2003d.setContentView(inflate);
        m2546d();
        return this.f2003d;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        if (bundle != null) {
            RequestState requestState = (RequestState) bundle.getParcelable("request_state");
            if (requestState != null) {
                m2541a(requestState);
            }
        }
        return onCreateView;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (this.f2005f != null) {
            this.f2005f.cancel(true);
        }
        m2539a(-1, new Intent());
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.f2004e != null) {
            bundle.putParcelable("request_state", this.f2004e);
        }
    }
}
