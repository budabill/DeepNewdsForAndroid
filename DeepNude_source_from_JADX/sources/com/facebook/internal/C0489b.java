package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.util.Log;
import com.facebook.C0506l;
import com.facebook.C0560t;
import java.lang.reflect.Method;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.facebook.internal.b */
public class C0489b {
    /* renamed from: a */
    private static final String f883a = "com.facebook.internal.b";
    /* renamed from: b */
    private static C0489b f884b;
    /* renamed from: c */
    private String f885c;
    /* renamed from: d */
    private String f886d;
    /* renamed from: e */
    private String f887e;
    /* renamed from: f */
    private boolean f888f;
    /* renamed from: g */
    private long f889g;

    /* renamed from: com.facebook.internal.b$a */
    private static final class C0487a implements IInterface {
        /* renamed from: a */
        private IBinder f880a;

        C0487a(IBinder iBinder) {
            this.f880a = iBinder;
        }

        /* renamed from: a */
        public String m1062a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f880a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                String readString = obtain2.readString();
                return readString;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public IBinder asBinder() {
            return this.f880a;
        }

        /* renamed from: b */
        public boolean m1063b() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                boolean z = true;
                obtain.writeInt(1);
                this.f880a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z = false;
                }
                obtain2.recycle();
                obtain.recycle();
                return z;
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    /* renamed from: com.facebook.internal.b$b */
    private static final class C0488b implements ServiceConnection {
        /* renamed from: a */
        private AtomicBoolean f881a;
        /* renamed from: b */
        private final BlockingQueue<IBinder> f882b;

        private C0488b() {
            this.f881a = new AtomicBoolean(false);
            this.f882b = new LinkedBlockingDeque();
        }

        /* renamed from: a */
        public IBinder m1064a() {
            if (!this.f881a.compareAndSet(true, true)) {
                return (IBinder) this.f882b.take();
            }
            throw new IllegalStateException("Binder already consumed");
        }

        public void onServiceConnected(android.content.ComponentName r1, android.os.IBinder r2) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
            /*
            r0 = this;
            if (r2 == 0) goto L_0x0007;
        L_0x0002:
            r1 = r0.f882b;	 Catch:{ InterruptedException -> 0x0007 }
            r1.put(r2);	 Catch:{ InterruptedException -> 0x0007 }
        L_0x0007:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.b.b.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* renamed from: a */
    public static C0489b m1065a(Context context) {
        Cursor cursor;
        Exception exception;
        StringBuilder stringBuilder;
        Throwable th;
        String str = "limit_tracking";
        String str2 = "androidid";
        String str3 = "aid";
        if (Looper.myLooper() == Looper.getMainLooper()) {
            Log.e(f883a, "getAttributionIdentifiers should not be called from the main thread");
        }
        if (f884b != null) {
            long currentTimeMillis = System.currentTimeMillis();
            C0489b c0489b = f884b;
            if (currentTimeMillis - c0489b.f889g < 3600000) {
                return c0489b;
            }
        }
        C0489b b = C0489b.m1067b(context);
        Cursor cursor2 = null;
        try {
            String str4;
            Uri uri;
            Cursor query;
            int columnIndex;
            int columnIndex2;
            int columnIndex3;
            String[] strArr = new String[]{str3, str2, str};
            if (context.getPackageManager().resolveContentProvider("com.facebook.katana.provider.AttributionIdProvider", 0) != null) {
                str4 = "content://com.facebook.katana.provider.AttributionIdProvider";
            } else if (context.getPackageManager().resolveContentProvider("com.facebook.wakizashi.provider.AttributionIdProvider", 0) != null) {
                str4 = "content://com.facebook.wakizashi.provider.AttributionIdProvider";
            } else {
                uri = null;
                str4 = C0489b.m1071e(context);
                if (str4 != null) {
                    b.f887e = str4;
                }
                if (uri != null) {
                    C0489b.m1066a(b);
                    return b;
                }
                query = context.getContentResolver().query(uri, strArr, null, null, null);
                if (query != null) {
                    try {
                        if (!query.moveToFirst()) {
                            columnIndex = query.getColumnIndex(str3);
                            columnIndex2 = query.getColumnIndex(str2);
                            columnIndex3 = query.getColumnIndex(str);
                            b.f885c = query.getString(columnIndex);
                            if (columnIndex2 > 0 && columnIndex3 > 0 && b.m1072a() == null) {
                                b.f886d = query.getString(columnIndex2);
                                b.f888f = Boolean.parseBoolean(query.getString(columnIndex3));
                            }
                            if (query != null) {
                                query.close();
                            }
                            C0489b.m1066a(b);
                            return b;
                        }
                    } catch (Exception e) {
                        Exception exception2 = e;
                        cursor = query;
                        exception = exception2;
                        try {
                            str2 = f883a;
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("Caught unexpected exception in getAttributionId(): ");
                            stringBuilder.append(exception.toString());
                            C0475Q.m984a(str2, stringBuilder.toString());
                            if (cursor != null) {
                                cursor.close();
                            }
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            cursor2 = cursor;
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        cursor2 = query;
                        th = th3;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                }
                C0489b.m1066a(b);
                if (query != null) {
                    query.close();
                }
                return b;
            }
            uri = Uri.parse(str4);
            str4 = C0489b.m1071e(context);
            if (str4 != null) {
                b.f887e = str4;
            }
            if (uri != null) {
                query = context.getContentResolver().query(uri, strArr, null, null, null);
                if (query != null) {
                    if (!query.moveToFirst()) {
                        columnIndex = query.getColumnIndex(str3);
                        columnIndex2 = query.getColumnIndex(str2);
                        columnIndex3 = query.getColumnIndex(str);
                        b.f885c = query.getString(columnIndex);
                        b.f886d = query.getString(columnIndex2);
                        b.f888f = Boolean.parseBoolean(query.getString(columnIndex3));
                        if (query != null) {
                            query.close();
                        }
                        C0489b.m1066a(b);
                        return b;
                    }
                }
                C0489b.m1066a(b);
                if (query != null) {
                    query.close();
                }
                return b;
            }
            C0489b.m1066a(b);
            return b;
        } catch (Exception e2) {
            exception = e2;
            cursor = null;
            str2 = f883a;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Caught unexpected exception in getAttributionId(): ");
            stringBuilder.append(exception.toString());
            C0475Q.m984a(str2, stringBuilder.toString());
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    /* renamed from: a */
    private static C0489b m1066a(C0489b c0489b) {
        c0489b.f889g = System.currentTimeMillis();
        f884b = c0489b;
        return c0489b;
    }

    /* renamed from: b */
    private static C0489b m1067b(Context context) {
        C0489b c = C0489b.m1068c(context);
        if (c != null) {
            return c;
        }
        c = C0489b.m1070d(context);
        return c == null ? new C0489b() : c;
    }

    /* renamed from: c */
    private static C0489b m1068c(Context context) {
        try {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                Method a = C0475Q.m969a("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", Context.class);
                if (a == null) {
                    return null;
                }
                Object a2 = C0475Q.m961a(null, a, context);
                if (a2 instanceof Integer) {
                    if (((Integer) a2).intValue() == 0) {
                        a = C0475Q.m969a("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", Context.class);
                        if (a == null) {
                            return null;
                        }
                        Object a3 = C0475Q.m961a(null, a, context);
                        if (a3 == null) {
                            return null;
                        }
                        a = C0475Q.m968a(a3.getClass(), "getId", new Class[0]);
                        Method a4 = C0475Q.m968a(a3.getClass(), "isLimitAdTrackingEnabled", new Class[0]);
                        if (a != null) {
                            if (a4 != null) {
                                C0489b c0489b = new C0489b();
                                c0489b.f886d = (String) C0475Q.m961a(a3, a, new Object[0]);
                                c0489b.f888f = ((Boolean) C0475Q.m961a(a3, a4, new Object[0])).booleanValue();
                                return c0489b;
                            }
                        }
                    }
                }
                return null;
            }
            throw new C0506l("getAndroidId cannot be called on the main thread.");
        } catch (Exception e) {
            C0475Q.m983a("android_id", e);
            return null;
        }
    }

    /* renamed from: d */
    public static C0489b m1069d() {
        return f884b;
    }

    /* renamed from: d */
    private static C0489b m1070d(Context context) {
        ServiceConnection c0488b = new C0488b();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        C0489b c0489b = true;
        if (context.bindService(intent, c0488b, 1)) {
            try {
                C0487a c0487a = new C0487a(c0488b.m1064a());
                c0489b = new C0489b();
                c0489b.f886d = c0487a.m1062a();
                c0489b.f888f = c0487a.m1063b();
                return c0489b;
            } catch (Exception e) {
                c0489b = "android_id";
                C0475Q.m983a((String) c0489b, e);
            } finally {
                context.unbindService(c0488b);
            }
        }
        return null;
    }

    /* renamed from: e */
    private static String m1071e(Context context) {
        PackageManager packageManager = context.getPackageManager();
        return packageManager != null ? packageManager.getInstallerPackageName(context.getPackageName()) : null;
    }

    /* renamed from: a */
    public String m1072a() {
        return (C0560t.m1264p() && C0560t.m1251c()) ? this.f886d : null;
    }

    /* renamed from: b */
    public String m1073b() {
        return this.f887e;
    }

    /* renamed from: c */
    public String m1074c() {
        return this.f885c;
    }

    /* renamed from: e */
    public boolean m1075e() {
        return this.f888f;
    }
}
