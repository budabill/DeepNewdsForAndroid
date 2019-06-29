package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.HashSet;
import java.util.Set;

final class zzaj implements ServiceConnection {
    private ComponentName mComponentName;
    private int mState = 2;
    private IBinder zzgfp;
    private final Set<ServiceConnection> zzgha = new HashSet();
    private boolean zzghb;
    private final zzah zzghc;
    private /* synthetic */ zzai zzghd;

    public zzaj(zzai zzai, zzah zzah) {
        this.zzghd = zzai;
        this.zzghc = zzah;
    }

    public final IBinder getBinder() {
        return this.zzgfp;
    }

    public final ComponentName getComponentName() {
        return this.mComponentName;
    }

    public final int getState() {
        return this.mState;
    }

    public final boolean isBound() {
        return this.zzghb;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.zzghd.zzggw) {
            this.zzghd.mHandler.removeMessages(1, this.zzghc);
            this.zzgfp = iBinder;
            this.mComponentName = componentName;
            for (ServiceConnection onServiceConnected : this.zzgha) {
                onServiceConnected.onServiceConnected(componentName, iBinder);
            }
            this.mState = 1;
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.zzghd.zzggw) {
            this.zzghd.mHandler.removeMessages(1, this.zzghc);
            this.zzgfp = null;
            this.mComponentName = componentName;
            for (ServiceConnection onServiceDisconnected : this.zzgha) {
                onServiceDisconnected.onServiceDisconnected(componentName);
            }
            this.mState = 2;
        }
    }

    public final void zza(ServiceConnection serviceConnection, String str) {
        this.zzghd.zzggx;
        this.zzghd.mApplicationContext;
        this.zzghc.zzcq(this.zzghd.mApplicationContext);
        this.zzgha.add(serviceConnection);
    }

    public final boolean zza(ServiceConnection serviceConnection) {
        return this.zzgha.contains(serviceConnection);
    }

    public final boolean zzamv() {
        return this.zzgha.isEmpty();
    }

    public final void zzb(ServiceConnection serviceConnection, String str) {
        this.zzghd.zzggx;
        this.zzghd.mApplicationContext;
        this.zzgha.remove(serviceConnection);
    }

    public final void zzgr(java.lang.String r8) {
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
        r7 = this;
        r0 = 3;
        r7.mState = r0;
        r0 = r7.zzghd;
        r1 = r0.zzggx;
        r0 = r7.zzghd;
        r2 = r0.mApplicationContext;
        r0 = r7.zzghc;
        r3 = r7.zzghd;
        r3 = r3.mApplicationContext;
        r4 = r0.zzcq(r3);
        r0 = r7.zzghc;
        r6 = r0.zzamu();
        r3 = r8;
        r5 = r7;
        r8 = r1.zza(r2, r3, r4, r5, r6);
        r7.zzghb = r8;
        r8 = r7.zzghb;
        if (r8 == 0) goto L_0x004a;
    L_0x002d:
        r8 = r7.zzghd;
        r8 = r8.mHandler;
        r0 = 1;
        r1 = r7.zzghc;
        r8 = r8.obtainMessage(r0, r1);
        r0 = r7.zzghd;
        r0 = r0.mHandler;
        r1 = r7.zzghd;
        r1 = r1.zzggz;
        r0.sendMessageDelayed(r8, r1);
        return;
    L_0x004a:
        r8 = 2;
        r7.mState = r8;
        r8 = r7.zzghd;	 Catch:{ IllegalArgumentException -> 0x005b }
        r8.zzggx;	 Catch:{ IllegalArgumentException -> 0x005b }
        r8 = r7.zzghd;	 Catch:{ IllegalArgumentException -> 0x005b }
        r8 = r8.mApplicationContext;	 Catch:{ IllegalArgumentException -> 0x005b }
        r8.unbindService(r7);	 Catch:{ IllegalArgumentException -> 0x005b }
    L_0x005b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.zzaj.zzgr(java.lang.String):void");
    }

    public final void zzgs(String str) {
        this.zzghd.mHandler.removeMessages(1, this.zzghc);
        this.zzghd.zzggx;
        this.zzghd.mApplicationContext.unbindService(this);
        this.zzghb = false;
        this.mState = 2;
    }
}
