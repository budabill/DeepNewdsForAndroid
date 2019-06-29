package com.google.android.gms.gcm;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.iid.InstanceID;
import com.google.android.gms.iid.zzaa;
import com.google.android.gms.iid.zzaf;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class GoogleCloudMessaging {
    public static final String ERROR_MAIN_THREAD = "MAIN_THREAD";
    public static final String ERROR_SERVICE_NOT_AVAILABLE = "SERVICE_NOT_AVAILABLE";
    public static final String INSTANCE_ID_SCOPE = "GCM";
    @Deprecated
    public static final String MESSAGE_TYPE_DELETED = "deleted_messages";
    @Deprecated
    public static final String MESSAGE_TYPE_MESSAGE = "gcm";
    @Deprecated
    public static final String MESSAGE_TYPE_SEND_ERROR = "send_error";
    @Deprecated
    public static final String MESSAGE_TYPE_SEND_EVENT = "send_event";
    private static GoogleCloudMessaging zzika;
    private static final AtomicInteger zzikd = new AtomicInteger(1);
    private Context zzaiq;
    private PendingIntent zzikb;
    private final Map<String, Handler> zzikc = Collections.synchronizedMap(new ArrayMap());
    private final BlockingQueue<Intent> zzike = new LinkedBlockingQueue();
    private Messenger zzikf = new Messenger(new zzc(this, Looper.getMainLooper()));

    public static synchronized GoogleCloudMessaging getInstance(Context context) {
        GoogleCloudMessaging googleCloudMessaging;
        synchronized (GoogleCloudMessaging.class) {
            if (zzika == null) {
                GoogleCloudMessaging googleCloudMessaging2 = new GoogleCloudMessaging();
                zzika = googleCloudMessaging2;
                googleCloudMessaging2.zzaiq = context.getApplicationContext();
            }
            googleCloudMessaging = zzika;
        }
        return googleCloudMessaging;
    }

    @Deprecated
    private final Intent zza(Bundle bundle, boolean z) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        } else if (zzdn(this.zzaiq) >= 0) {
            Intent intent = new Intent(z ? "com.google.iid.TOKEN_REQUEST" : "com.google.android.c2dm.intent.REGISTER");
            intent.setPackage(zzaa.zzdr(this.zzaiq));
            zzg(intent);
            int andIncrement = zzikd.getAndIncrement();
            StringBuilder stringBuilder = new StringBuilder(21);
            stringBuilder.append("google.rpc");
            stringBuilder.append(andIncrement);
            intent.putExtra("google.message_id", stringBuilder.toString());
            intent.putExtras(bundle);
            intent.putExtra("google.messenger", this.zzikf);
            if (z) {
                this.zzaiq.sendBroadcast(intent);
            } else {
                this.zzaiq.startService(intent);
            }
            try {
                return (Intent) this.zzike.poll(30000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                throw new IOException(e.getMessage());
            }
        } else {
            throw new IOException("Google Play Services missing");
        }
    }

    @Hide
    @Deprecated
    private final synchronized String zza(boolean z, String... strArr) {
        String zzdr = zzaa.zzdr(this.zzaiq);
        if (zzdr != null) {
            String zzd = zzd(strArr);
            Bundle bundle = new Bundle();
            if (zzdr.contains(".gsf")) {
                bundle.putString("legacy.sender", zzd);
                return InstanceID.getInstance(this.zzaiq).getToken(zzd, INSTANCE_ID_SCOPE, bundle);
            }
            bundle.putString("sender", zzd);
            Intent zza = zza(bundle, z);
            zzd = "registration_id";
            if (zza != null) {
                zzd = zza.getStringExtra(zzd);
                if (zzd != null) {
                    return zzd;
                }
                String stringExtra = zza.getStringExtra("error");
                if (stringExtra != null) {
                    throw new IOException(stringExtra);
                }
                throw new IOException("SERVICE_NOT_AVAILABLE");
            }
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    private final synchronized void zzawh() {
        if (this.zzikb != null) {
            this.zzikb.cancel();
            this.zzikb = null;
        }
    }

    private static String zzd(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            throw new IllegalArgumentException("No senderIds");
        }
        StringBuilder stringBuilder = new StringBuilder(strArr[0]);
        for (int i = 1; i < strArr.length; i++) {
            stringBuilder.append(',');
            stringBuilder.append(strArr[i]);
        }
        return stringBuilder.toString();
    }

    @com.google.android.gms.common.internal.Hide
    public static int zzdn(android.content.Context r2) {
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
        r0 = com.google.android.gms.iid.zzaa.zzdr(r2);
        if (r0 == 0) goto L_0x0014;
    L_0x0006:
        r2 = r2.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0014 }
        r1 = 0;	 Catch:{ NameNotFoundException -> 0x0014 }
        r2 = r2.getPackageInfo(r0, r1);	 Catch:{ NameNotFoundException -> 0x0014 }
        if (r2 == 0) goto L_0x0014;	 Catch:{ NameNotFoundException -> 0x0014 }
    L_0x0011:
        r2 = r2.versionCode;	 Catch:{ NameNotFoundException -> 0x0014 }
        return r2;
    L_0x0014:
        r2 = -1;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.gcm.GoogleCloudMessaging.zzdn(android.content.Context):int");
    }

    private final boolean zzf(Intent intent) {
        Object stringExtra = intent.getStringExtra("In-Reply-To");
        if (stringExtra == null && intent.hasExtra("error")) {
            stringExtra = intent.getStringExtra("google.message_id");
        }
        if (stringExtra != null) {
            Handler handler = (Handler) this.zzikc.remove(stringExtra);
            if (handler != null) {
                Message obtain = Message.obtain();
                obtain.obj = intent;
                return handler.sendMessage(obtain);
            }
        }
        return false;
    }

    private final synchronized void zzg(Intent intent) {
        if (this.zzikb == null) {
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            this.zzikb = PendingIntent.getBroadcast(this.zzaiq, 0, intent2, 0);
        }
        intent.putExtra("app", this.zzikb);
    }

    public void close() {
        zzika = null;
        zza.zzijk = null;
        zzawh();
    }

    public String getMessageType(Intent intent) {
        if (!"com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction())) {
            return null;
        }
        String stringExtra = intent.getStringExtra("message_type");
        return stringExtra != null ? stringExtra : MESSAGE_TYPE_MESSAGE;
    }

    @Deprecated
    public synchronized String register(String... strArr) {
        return zza(zzaa.zzdq(this.zzaiq), strArr);
    }

    public void send(String str, String str2, long j, Bundle bundle) {
        if (str != null) {
            String zzdr = zzaa.zzdr(this.zzaiq);
            if (zzdr != null) {
                Intent intent = new Intent("com.google.android.gcm.intent.SEND");
                if (bundle != null) {
                    intent.putExtras(bundle);
                }
                zzg(intent);
                intent.setPackage(zzdr);
                String str3 = "google.to";
                intent.putExtra(str3, str);
                String str4 = "google.message_id";
                intent.putExtra(str4, str2);
                intent.putExtra("google.ttl", Long.toString(j));
                int indexOf = str.indexOf(64);
                String substring = indexOf > 0 ? str.substring(0, indexOf) : str;
                InstanceID.getInstance(this.zzaiq);
                zzaf zzawr = InstanceID.zzawr();
                String str5 = INSTANCE_ID_SCOPE;
                intent.putExtra("google.from", zzawr.zzf("", substring, str5));
                if (zzdr.contains(".gsf")) {
                    Bundle bundle2 = new Bundle();
                    for (String zzdr2 : bundle.keySet()) {
                        Object obj = bundle.get(zzdr2);
                        if (obj instanceof String) {
                            String str6 = "gcm.";
                            zzdr2 = String.valueOf(zzdr2);
                            bundle2.putString(zzdr2.length() != 0 ? str6.concat(zzdr2) : new String(str6), (String) obj);
                        }
                    }
                    bundle2.putString(str3, str);
                    bundle2.putString(str4, str2);
                    InstanceID.getInstance(this.zzaiq).zzb(str5, "upstream", bundle2);
                    return;
                }
                this.zzaiq.sendOrderedBroadcast(intent, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
                return;
            }
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        throw new IllegalArgumentException("Missing 'to'");
    }

    public void send(String str, String str2, Bundle bundle) {
        send(str, str2, -1, bundle);
    }

    @Deprecated
    public synchronized void unregister() {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            InstanceID.getInstance(this.zzaiq).deleteInstanceID();
        } else {
            throw new IOException("MAIN_THREAD");
        }
    }
}
