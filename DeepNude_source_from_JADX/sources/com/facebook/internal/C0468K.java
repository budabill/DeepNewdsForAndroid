package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Messenger;

/* renamed from: com.facebook.internal.K */
public abstract class C0468K implements ServiceConnection {
    /* renamed from: a */
    private final Context f822a;
    /* renamed from: b */
    private final Handler f823b;
    /* renamed from: c */
    private C0467a f824c;
    /* renamed from: d */
    private boolean f825d;
    /* renamed from: e */
    private Messenger f826e;
    /* renamed from: f */
    private int f827f;
    /* renamed from: g */
    private int f828g;
    /* renamed from: h */
    private final String f829h;
    /* renamed from: i */
    private final int f830i;

    /* renamed from: com.facebook.internal.K$a */
    public interface C0467a {
        /* renamed from: a */
        void mo968a(Bundle bundle);
    }

    public C0468K(Context context, int i, int i2, int i3, String str) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        this.f822a = context;
        this.f827f = i;
        this.f828g = i2;
        this.f829h = str;
        this.f830i = i3;
        this.f823b = new C0466J(this);
    }

    /* renamed from: b */
    private void m937b(Bundle bundle) {
        if (this.f825d) {
            this.f825d = false;
            C0467a c0467a = this.f824c;
            if (c0467a != null) {
                c0467a.mo968a(bundle);
            }
        }
    }

    /* renamed from: c */
    private void m938c() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        r4 = this;
        r0 = new android.os.Bundle;
        r0.<init>();
        r1 = r4.f829h;
        r2 = "com.facebook.platform.extra.APPLICATION_ID";
        r0.putString(r2, r1);
        r4.mo967a(r0);
        r1 = r4.f827f;
        r2 = 0;
        r1 = android.os.Message.obtain(r2, r1);
        r3 = r4.f830i;
        r1.arg1 = r3;
        r1.setData(r0);
        r0 = new android.os.Messenger;
        r3 = r4.f823b;
        r0.<init>(r3);
        r1.replyTo = r0;
        r0 = r4.f826e;	 Catch:{ RemoteException -> 0x002c }
        r0.send(r1);	 Catch:{ RemoteException -> 0x002c }
        goto L_0x002f;
    L_0x002c:
        r4.m937b(r2);
    L_0x002f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.K.c():void");
    }

    /* renamed from: a */
    public void m939a() {
        this.f825d = false;
    }

    /* renamed from: a */
    protected abstract void mo967a(Bundle bundle);

    /* renamed from: a */
    protected void m941a(android.os.Message r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        r2 = this;
        r0 = r3.what;
        r1 = r2.f828g;
        if (r0 != r1) goto L_0x001b;
    L_0x0006:
        r3 = r3.getData();
        r0 = "com.facebook.platform.status.ERROR_TYPE";
        r0 = r3.getString(r0);
        if (r0 == 0) goto L_0x0013;
    L_0x0012:
        r3 = 0;
    L_0x0013:
        r2.m937b(r3);
        r3 = r2.f822a;	 Catch:{ IllegalArgumentException -> 0x001b }
        r3.unbindService(r2);	 Catch:{ IllegalArgumentException -> 0x001b }
    L_0x001b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.K.a(android.os.Message):void");
    }

    /* renamed from: a */
    public void m942a(C0467a c0467a) {
        this.f824c = c0467a;
    }

    /* renamed from: b */
    public boolean m943b() {
        if (this.f825d || C0465I.m910a(this.f830i) == -1) {
            return false;
        }
        Intent a = C0465I.m912a(this.f822a);
        if (a == null) {
            return false;
        }
        this.f825d = true;
        this.f822a.bindService(a, this, 1);
        return true;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f826e = new Messenger(iBinder);
        m938c();
    }

    public void onServiceDisconnected(android.content.ComponentName r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        r1 = this;
        r2 = 0;
        r1.f826e = r2;
        r0 = r1.f822a;	 Catch:{ IllegalArgumentException -> 0x0008 }
        r0.unbindService(r1);	 Catch:{ IllegalArgumentException -> 0x0008 }
    L_0x0008:
        r1.m937b(r2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.K.onServiceDisconnected(android.content.ComponentName):void");
    }
}
