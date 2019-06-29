package com.google.android.gms.iid;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.tasks.Tasks;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Hide
public final class zzaa {
    private static int zzino = 0;
    private static zzae<Boolean> zzinr = zzad.zzawy().zzf("gcm_iid_use_messenger_ipc", true);
    private static String zzins = null;
    private static boolean zzint = false;
    private static int zzinu = 0;
    private static int zzinv = 0;
    private static BroadcastReceiver zzinw = null;
    private Context zzaiq;
    private PendingIntent zzikb;
    private Messenger zzikf;
    private Map<String, Object> zzinx = new ArrayMap();
    private Messenger zziny;
    private MessengerCompat zzinz;

    public zzaa(Context context) {
        this.zzaiq = context;
    }

    private static String zza(KeyPair keyPair, String... strArr) {
        Throwable e;
        String str;
        String str2 = "InstanceID/Rpc";
        try {
            byte[] bytes = TextUtils.join("\n", strArr).getBytes("UTF-8");
            try {
                PrivateKey privateKey = keyPair.getPrivate();
                Signature instance = Signature.getInstance(privateKey instanceof RSAPrivateKey ? "SHA256withRSA" : "SHA256withECDSA");
                instance.initSign(privateKey);
                instance.update(bytes);
                return InstanceID.zzp(instance.sign());
            } catch (GeneralSecurityException e2) {
                e = e2;
                str = "Unable to sign registration request";
                Log.e(str2, str, e);
                return null;
            }
        } catch (UnsupportedEncodingException e3) {
            e = e3;
            str = "Unable to encode string";
            Log.e(str2, str, e);
            return null;
        }
    }

    private static boolean zza(PackageManager packageManager) {
        String str = "com.google.iid.TOKEN_REQUEST";
        for (ResolveInfo resolveInfo : packageManager.queryBroadcastReceivers(new Intent(str), 0)) {
            if (zza(packageManager, resolveInfo.activityInfo.packageName, str)) {
                zzint = true;
                return true;
            }
        }
        return false;
    }

    private static boolean zza(PackageManager packageManager, String str, String str2) {
        if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", str) == 0) {
            return zzb(packageManager, str);
        }
        StringBuilder stringBuilder = new StringBuilder((String.valueOf(str).length() + 56) + String.valueOf(str2).length());
        stringBuilder.append("Possible malicious package ");
        stringBuilder.append(str);
        stringBuilder.append(" declares ");
        stringBuilder.append(str2);
        stringBuilder.append(" without permission");
        Log.w("InstanceID/Rpc", stringBuilder.toString());
        return false;
    }

    private final Bundle zzaa(Bundle bundle) {
        Bundle bundle2;
        ConditionVariable conditionVariable = new ConditionVariable();
        String zzawx = zzawx();
        synchronized (zzaa.class) {
            this.zzinx.put(zzawx, conditionVariable);
        }
        zzf(bundle, zzawx);
        conditionVariable.block(30000);
        synchronized (zzaa.class) {
            Object remove = this.zzinx.remove(zzawx);
            if (remove instanceof Bundle) {
                bundle2 = (Bundle) remove;
            } else if (remove instanceof String) {
                throw new IOException((String) remove);
            } else {
                String valueOf = String.valueOf(remove);
                StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 12);
                stringBuilder.append("No response ");
                stringBuilder.append(valueOf);
                Log.w("InstanceID/Rpc", stringBuilder.toString());
                throw new IOException(InstanceID.ERROR_TIMEOUT);
            }
        }
        return bundle2;
    }

    private final void zzae(Object obj) {
        synchronized (zzaa.class) {
            for (String str : this.zzinx.keySet()) {
                Object obj2 = this.zzinx.get(str);
                this.zzinx.put(str, obj);
                zze(obj2, obj);
            }
        }
    }

    private static synchronized String zzawx() {
        String num;
        synchronized (zzaa.class) {
            int i = zzino;
            zzino = i + 1;
            num = Integer.toString(i);
        }
        return num;
    }

    private static boolean zzb(android.content.pm.PackageManager r1, java.lang.String r2) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        r0 = 0;
        r1 = r1.getApplicationInfo(r2, r0);	 Catch:{ NameNotFoundException -> 0x000f }
        r2 = r1.packageName;	 Catch:{ NameNotFoundException -> 0x000f }
        zzins = r2;	 Catch:{ NameNotFoundException -> 0x000f }
        r1 = r1.uid;	 Catch:{ NameNotFoundException -> 0x000f }
        zzinv = r1;	 Catch:{ NameNotFoundException -> 0x000f }
        r1 = 1;
        return r1;
    L_0x000f:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.iid.zzaa.zzb(android.content.pm.PackageManager, java.lang.String):boolean");
    }

    public static boolean zzdq(Context context) {
        if (zzins != null) {
            zzdr(context);
        }
        return zzint;
    }

    @Hide
    public static String zzdr(Context context) {
        String str = zzins;
        if (str != null) {
            return str;
        }
        zzinu = Process.myUid();
        PackageManager packageManager = context.getPackageManager();
        if (!zzs.isAtLeastO()) {
            Object obj;
            String str2 = "com.google.android.c2dm.intent.REGISTER";
            for (ResolveInfo resolveInfo : packageManager.queryIntentServices(new Intent(str2), 0)) {
                if (zza(packageManager, resolveInfo.serviceInfo.packageName, str2)) {
                    zzint = false;
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj != null) {
                return zzins;
            }
        }
        if (zza(packageManager)) {
            return zzins;
        }
        str = "InstanceID/Rpc";
        Log.w(str, "Failed to resolve IID implementation package, falling back");
        if (zzb(packageManager, "com.google.android.gms")) {
            zzint = zzs.isAtLeastO();
            return zzins;
        } else if (zzs.zzanx() || !zzb(packageManager, "com.google.android.gsf")) {
            Log.w(str, "Google Play services is missing, unable to get tokens");
            return null;
        } else {
            zzint = false;
            return zzins;
        }
    }

    private static int zzds(android.content.Context r2) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        r0 = r2.getPackageManager();
        r2 = zzdr(r2);	 Catch:{ NameNotFoundException -> 0x0010 }
        r1 = 0;	 Catch:{ NameNotFoundException -> 0x0010 }
        r2 = r0.getPackageInfo(r2, r1);	 Catch:{ NameNotFoundException -> 0x0010 }
        r2 = r2.versionCode;	 Catch:{ NameNotFoundException -> 0x0010 }
        return r2;
    L_0x0010:
        r2 = -1;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.iid.zzaa.zzds(android.content.Context):int");
    }

    private static void zze(Object obj, Object obj2) {
        if (obj instanceof ConditionVariable) {
            ((ConditionVariable) obj).open();
        }
        if (obj instanceof Messenger) {
            Messenger messenger = (Messenger) obj;
            Message obtain = Message.obtain();
            obtain.obj = obj2;
            try {
                messenger.send(obtain);
            } catch (RemoteException e) {
                String valueOf = String.valueOf(e);
                StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 24);
                stringBuilder.append("Failed to send response ");
                stringBuilder.append(valueOf);
                Log.w("InstanceID/Rpc", stringBuilder.toString());
            }
        }
    }

    private final void zzf(android.os.Bundle r5, java.lang.String r6) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        r4 = this;
        r0 = r4.zzikf;
        if (r0 != 0) goto L_0x0019;
    L_0x0004:
        r0 = r4.zzaiq;
        zzdr(r0);
        r0 = new android.os.Messenger;
        r1 = new com.google.android.gms.iid.zzab;
        r2 = android.os.Looper.getMainLooper();
        r1.<init>(r4, r2);
        r0.<init>(r1);
        r4.zzikf = r0;
    L_0x0019:
        r0 = zzins;
        if (r0 == 0) goto L_0x016b;
    L_0x001d:
        r0 = new android.content.Intent;
        r1 = zzint;
        if (r1 == 0) goto L_0x0026;
    L_0x0023:
        r1 = "com.google.iid.TOKEN_REQUEST";
        goto L_0x0028;
    L_0x0026:
        r1 = "com.google.android.c2dm.intent.REGISTER";
    L_0x0028:
        r0.<init>(r1);
        r1 = zzins;
        r0.setPackage(r1);
        r0.putExtras(r5);
        r4.zzi(r0);
        r5 = java.lang.String.valueOf(r6);
        r5 = r5.length();
        r5 = r5 + 5;
        r1 = new java.lang.StringBuilder;
        r1.<init>(r5);
        r5 = "|ID|";
        r1.append(r5);
        r1.append(r6);
        r5 = "|";
        r1.append(r5);
        r5 = r1.toString();
        r1 = "kid";
        r0.putExtra(r1, r5);
        r5 = java.lang.String.valueOf(r6);
        r5 = r5.length();
        r5 = r5 + 5;
        r1 = new java.lang.StringBuilder;
        r1.<init>(r5);
        r5 = "|ID|";
        r1.append(r5);
        r1.append(r6);
        r5 = "|";
        r1.append(r5);
        r5 = r1.toString();
        r6 = "X-kid";
        r0.putExtra(r6, r5);
        r5 = zzins;
        r6 = "com.google.android.gsf";
        r5 = r6.equals(r5);
        r6 = "useGsf";
        r6 = r0.getStringExtra(r6);
        if (r6 == 0) goto L_0x0096;
    L_0x0090:
        r5 = "1";
        r5 = r5.equals(r6);
    L_0x0096:
        r6 = 3;
        r1 = "InstanceID/Rpc";
        r1 = android.util.Log.isLoggable(r1, r6);
        if (r1 == 0) goto L_0x00c7;
    L_0x009f:
        r1 = r0.getExtras();
        r1 = java.lang.String.valueOf(r1);
        r2 = java.lang.String.valueOf(r1);
        r2 = r2.length();
        r2 = r2 + 8;
        r3 = new java.lang.StringBuilder;
        r3.<init>(r2);
        r2 = "Sending ";
        r3.append(r2);
        r3.append(r1);
        r1 = r3.toString();
        r2 = "InstanceID/Rpc";
        android.util.Log.d(r2, r1);
    L_0x00c7:
        r1 = r4.zziny;
        if (r1 == 0) goto L_0x00ed;
    L_0x00cb:
        r1 = r4.zzikf;
        r2 = "google.messenger";
        r0.putExtra(r2, r1);
        r1 = android.os.Message.obtain();
        r1.obj = r0;
        r2 = r4.zziny;	 Catch:{ RemoteException -> 0x00de }
        r2.send(r1);	 Catch:{ RemoteException -> 0x00de }
        return;
    L_0x00de:
        r1 = "InstanceID/Rpc";
        r1 = android.util.Log.isLoggable(r1, r6);
        if (r1 == 0) goto L_0x00ed;
    L_0x00e6:
        r1 = "InstanceID/Rpc";
        r2 = "Messenger failed, fallback to startService";
        android.util.Log.d(r1, r2);
    L_0x00ed:
        if (r5 == 0) goto L_0x012e;
    L_0x00ef:
        monitor-enter(r4);
        r5 = zzinw;	 Catch:{ all -> 0x012b }
        if (r5 != 0) goto L_0x0124;	 Catch:{ all -> 0x012b }
    L_0x00f4:
        r5 = new com.google.android.gms.iid.zzac;	 Catch:{ all -> 0x012b }
        r5.<init>(r4);	 Catch:{ all -> 0x012b }
        zzinw = r5;	 Catch:{ all -> 0x012b }
        r5 = "InstanceID/Rpc";	 Catch:{ all -> 0x012b }
        r5 = android.util.Log.isLoggable(r5, r6);	 Catch:{ all -> 0x012b }
        if (r5 == 0) goto L_0x010a;	 Catch:{ all -> 0x012b }
    L_0x0103:
        r5 = "InstanceID/Rpc";	 Catch:{ all -> 0x012b }
        r6 = "Registered GSF callback receiver";	 Catch:{ all -> 0x012b }
        android.util.Log.d(r5, r6);	 Catch:{ all -> 0x012b }
    L_0x010a:
        r5 = new android.content.IntentFilter;	 Catch:{ all -> 0x012b }
        r6 = "com.google.android.c2dm.intent.REGISTRATION";	 Catch:{ all -> 0x012b }
        r5.<init>(r6);	 Catch:{ all -> 0x012b }
        r6 = r4.zzaiq;	 Catch:{ all -> 0x012b }
        r6 = r6.getPackageName();	 Catch:{ all -> 0x012b }
        r5.addCategory(r6);	 Catch:{ all -> 0x012b }
        r6 = r4.zzaiq;	 Catch:{ all -> 0x012b }
        r1 = zzinw;	 Catch:{ all -> 0x012b }
        r2 = "com.google.android.c2dm.permission.SEND";	 Catch:{ all -> 0x012b }
        r3 = 0;	 Catch:{ all -> 0x012b }
        r6.registerReceiver(r1, r5, r2, r3);	 Catch:{ all -> 0x012b }
    L_0x0124:
        monitor-exit(r4);	 Catch:{ all -> 0x012b }
        r5 = r4.zzaiq;
        r5.sendBroadcast(r0);
        return;
    L_0x012b:
        r5 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x012b }
        throw r5;
    L_0x012e:
        r5 = r4.zzikf;
        r1 = "google.messenger";
        r0.putExtra(r1, r5);
        r5 = "messenger2";
        r1 = "1";
        r0.putExtra(r5, r1);
        r5 = r4.zzinz;
        if (r5 == 0) goto L_0x015b;
    L_0x0140:
        r5 = android.os.Message.obtain();
        r5.obj = r0;
        r1 = r4.zzinz;	 Catch:{ RemoteException -> 0x014c }
        r1.send(r5);	 Catch:{ RemoteException -> 0x014c }
        return;
    L_0x014c:
        r5 = "InstanceID/Rpc";
        r5 = android.util.Log.isLoggable(r5, r6);
        if (r5 == 0) goto L_0x015b;
    L_0x0154:
        r5 = "InstanceID/Rpc";
        r6 = "Messenger failed, fallback to startService";
        android.util.Log.d(r5, r6);
    L_0x015b:
        r5 = zzint;
        if (r5 == 0) goto L_0x0165;
    L_0x015f:
        r5 = r4.zzaiq;
        r5.sendBroadcast(r0);
        return;
    L_0x0165:
        r5 = r4.zzaiq;
        r5.startService(r0);
        return;
    L_0x016b:
        r5 = new java.io.IOException;
        r6 = "MISSING_INSTANCEID_SERVICE";
        r5.<init>(r6);
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.iid.zzaa.zzf(android.os.Bundle, java.lang.String):void");
    }

    private final synchronized void zzi(Intent intent) {
        if (this.zzikb == null) {
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            this.zzikb = PendingIntent.getBroadcast(this.zzaiq, 0, intent2, 0);
        }
        intent.putExtra("app", this.zzikb);
    }

    private final void zzi(String str, Object obj) {
        synchronized (zzaa.class) {
            Object obj2 = this.zzinx.get(str);
            this.zzinx.put(str, obj);
            zze(obj2, obj);
        }
    }

    static String zzy(Bundle bundle) {
        String str = "SERVICE_NOT_AVAILABLE";
        if (bundle != null) {
            String string = bundle.getString("registration_id");
            if (string == null) {
                string = bundle.getString("unregistered");
            }
            if (string != null) {
                return string;
            }
            string = bundle.getString("error");
            if (string != null) {
                throw new IOException(string);
            }
            String valueOf = String.valueOf(bundle);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 29);
            stringBuilder.append("Unexpected response from GCM ");
            stringBuilder.append(valueOf);
            Log.w("InstanceID/Rpc", stringBuilder.toString(), new Throwable());
            throw new IOException(str);
        }
        throw new IOException(str);
    }

    private final Bundle zzz(Bundle bundle) {
        Bundle zzaa = zzaa(bundle);
        if (zzaa == null) {
            return zzaa;
        }
        String str = "google.messenger";
        if (!zzaa.containsKey(str)) {
            return zzaa;
        }
        zzaa = zzaa(bundle);
        return (zzaa == null || !zzaa.containsKey(str)) ? zzaa : null;
    }

    final Bundle zza(Bundle bundle, KeyPair keyPair) {
        String str;
        Exception e;
        String valueOf;
        StringBuilder stringBuilder;
        int zzds = zzds(this.zzaiq);
        bundle.putString("gmsv", Integer.toString(zzds));
        bundle.putString("osv", Integer.toString(VERSION.SDK_INT));
        bundle.putString("app_ver", Integer.toString(InstanceID.zzdo(this.zzaiq)));
        bundle.putString("app_ver_name", InstanceID.zzdp(this.zzaiq));
        bundle.putString("cliv", "iid-12211000");
        bundle.putString("appid", InstanceID.zza(keyPair));
        bundle.putString("pub2", InstanceID.zzp(keyPair.getPublic().getEncoded()));
        bundle.putString("sig", zza(keyPair, this.zzaiq.getPackageName(), str));
        if (zzds < 12000000 || !((Boolean) zzinr.get()).booleanValue()) {
            return zzz(bundle);
        }
        try {
            return (Bundle) Tasks.await(new zzm(this.zzaiq).zzj(1, bundle));
        } catch (InterruptedException e2) {
            e = e2;
            str = "InstanceID/Rpc";
            if (Log.isLoggable(str, 3)) {
                valueOf = String.valueOf(e);
                stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 22);
                stringBuilder.append("Error making request: ");
                stringBuilder.append(valueOf);
                Log.d(str, stringBuilder.toString());
            }
            return ((e.getCause() instanceof zzv) || ((zzv) e.getCause()).getErrorCode() != 4) ? null : zzz(bundle);
        } catch (ExecutionException e3) {
            e = e3;
            str = "InstanceID/Rpc";
            if (Log.isLoggable(str, 3)) {
                valueOf = String.valueOf(e);
                stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 22);
                stringBuilder.append("Error making request: ");
                stringBuilder.append(valueOf);
                Log.d(str, stringBuilder.toString());
            }
            if (e.getCause() instanceof zzv) {
            }
        }
    }

    public final void zzd(Message message) {
        if (message != null) {
            Object obj = message.obj;
            if (obj instanceof Intent) {
                Intent intent = (Intent) obj;
                intent.setExtrasClassLoader(MessengerCompat.class.getClassLoader());
                String str = "google.messenger";
                if (intent.hasExtra(str)) {
                    Parcelable parcelableExtra = intent.getParcelableExtra(str);
                    if (parcelableExtra instanceof MessengerCompat) {
                        this.zzinz = (MessengerCompat) parcelableExtra;
                    }
                    if (parcelableExtra instanceof Messenger) {
                        this.zziny = (Messenger) parcelableExtra;
                    }
                }
                zzj((Intent) message.obj);
                return;
            }
            Log.w("InstanceID/Rpc", "Dropping invalid message");
        }
    }

    @Hide
    public final void zzj(Intent intent) {
        String str = "InstanceID/Rpc";
        if (intent == null) {
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Unexpected response: null");
            }
            return;
        }
        String action = intent.getAction();
        String valueOf;
        String str2;
        if ("com.google.android.c2dm.intent.REGISTRATION".equals(action) || "com.google.android.gms.iid.InstanceID".equals(action)) {
            action = "registration_id";
            CharSequence stringExtra = intent.getStringExtra(action);
            if (stringExtra == null) {
                stringExtra = intent.getStringExtra("unregistered");
            }
            if (stringExtra == null) {
                action = "error";
                Object stringExtra2 = intent.getStringExtra(action);
                if (stringExtra2 == null) {
                    valueOf = String.valueOf(intent.getExtras());
                    StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 49);
                    stringBuilder.append("Unexpected response, no error or registration id ");
                    stringBuilder.append(valueOf);
                    Log.w(str, stringBuilder.toString());
                    return;
                }
                String str3;
                if (Log.isLoggable(str, 3)) {
                    str3 = "Received InstanceID error ";
                    String valueOf2 = String.valueOf(stringExtra2);
                    Log.d(str, valueOf2.length() != 0 ? str3.concat(valueOf2) : new String(str3));
                }
                str3 = null;
                if (stringExtra2.startsWith("|")) {
                    String[] split = stringExtra2.split("\\|");
                    if (!"ID".equals(split[1])) {
                        String str4 = "Unexpected structured response ";
                        String valueOf3 = String.valueOf(stringExtra2);
                        Log.w(str, valueOf3.length() != 0 ? str4.concat(valueOf3) : new String(str4));
                    }
                    if (split.length > 2) {
                        str = split[2];
                        str2 = split[3];
                        if (str2.startsWith(":")) {
                            str2 = str2.substring(1);
                        }
                        stringExtra2 = str2;
                        str3 = str;
                    } else {
                        stringExtra2 = "UNKNOWN";
                    }
                    intent.putExtra(action, stringExtra2);
                }
                if (str3 == null) {
                    zzae(stringExtra2);
                    return;
                } else {
                    zzi(str3, stringExtra2);
                    return;
                }
            }
            Matcher matcher = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.+)").matcher(stringExtra);
            if (matcher.matches()) {
                str2 = matcher.group(1);
                str = matcher.group(2);
                Bundle extras = intent.getExtras();
                extras.putString(action, str);
                zzi(str2, extras);
                return;
            }
            if (Log.isLoggable(str, 3)) {
                valueOf = "Unexpected response string: ";
                str2 = String.valueOf(stringExtra);
                Log.d(str, str2.length() != 0 ? valueOf.concat(str2) : new String(valueOf));
            }
            return;
        }
        if (Log.isLoggable(str, 3)) {
            str2 = "Unexpected response ";
            valueOf = String.valueOf(intent.getAction());
            Log.d(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        }
    }
}
