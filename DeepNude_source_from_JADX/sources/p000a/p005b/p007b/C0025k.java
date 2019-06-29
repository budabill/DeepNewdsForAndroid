package p000a.p005b.p007b;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import p000a.p005b.p007b.C0028n.C0742a;

/* renamed from: a.b.b.k */
public abstract class C0025k implements ServiceConnection {
    /* renamed from: a */
    public abstract void mo1397a(ComponentName componentName, C0022h c0022h);

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        mo1397a(componentName, new C0739j(this, C0742a.m2022a(iBinder), componentName));
    }
}
