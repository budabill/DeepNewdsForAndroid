package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.DialogFragment;
import com.facebook.AccessToken;
import com.facebook.C0451h;
import com.facebook.login.LoginClient.Request;
import com.facebook.login.LoginClient.Result;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;

class DeviceAuthMethodHandler extends LoginMethodHandler {
    public static final Creator<DeviceAuthMethodHandler> CREATOR = new C0519k();
    /* renamed from: c */
    private static ScheduledThreadPoolExecutor f1782c;

    protected DeviceAuthMethodHandler(Parcel parcel) {
        super(parcel);
    }

    DeviceAuthMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    /* renamed from: b */
    private void m2172b(Request request) {
        DialogFragment d = m2178d();
        d.show(this.f980b.m1158c().getSupportFragmentManager(), "login_with_facebook");
        d.m2535a(request);
    }

    /* renamed from: e */
    public static synchronized ScheduledThreadPoolExecutor m2173e() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        synchronized (DeviceAuthMethodHandler.class) {
            if (f1782c == null) {
                f1782c = new ScheduledThreadPoolExecutor(1);
            }
            scheduledThreadPoolExecutor = f1782c;
        }
        return scheduledThreadPoolExecutor;
    }

    /* renamed from: a */
    public void m2174a(Exception exception) {
        this.f980b.m1155b(Result.m1134a(this.f980b.m1164i(), null, exception.getMessage()));
    }

    /* renamed from: a */
    public void m2175a(String str, String str2, String str3, Collection<String> collection, Collection<String> collection2, C0451h c0451h, Date date, Date date2, Date date3) {
        this.f980b.m1155b(Result.m1132a(this.f980b.m1164i(), new AccessToken(str, str2, str3, collection, collection2, c0451h, date, date2, date3)));
    }

    /* renamed from: a */
    boolean mo961a(Request request) {
        m2172b(request);
        return true;
    }

    /* renamed from: b */
    String mo962b() {
        return "device_auth";
    }

    /* renamed from: d */
    protected DeviceAuthDialog m2178d() {
        return new DeviceAuthDialog();
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: f */
    public void m2179f() {
        this.f980b.m1155b(Result.m1133a(this.f980b.m1164i(), "User canceled log in."));
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }
}
