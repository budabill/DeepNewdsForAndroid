package com.facebook.p029a;

import com.facebook.p029a.C0403b.C0375a;
import com.facebook.p029a.C0409f.C0407a;
import com.facebook.p029a.p032b.C0383i;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

/* renamed from: com.facebook.a.o */
class C0418o {
    /* renamed from: a */
    private static final String f704a = "com.facebook.a.o";

    /* renamed from: com.facebook.a.o$a */
    private static class C0417a extends ObjectInputStream {
        public C0417a(InputStream inputStream) {
            super(inputStream);
        }

        protected ObjectStreamClass readClassDescriptor() {
            Class cls;
            ObjectStreamClass readClassDescriptor = super.readClassDescriptor();
            if (readClassDescriptor.getName().equals("com.facebook.appevents.AppEventsLogger$AccessTokenAppIdPair$SerializationProxyV1")) {
                cls = C0375a.class;
            } else if (!readClassDescriptor.getName().equals("com.facebook.appevents.AppEventsLogger$AppEvent$SerializationProxyV1")) {
                return readClassDescriptor;
            } else {
                cls = C0407a.class;
            }
            return ObjectStreamClass.lookup(cls);
        }
    }

    C0418o() {
    }

    /* renamed from: a */
    public static synchronized com.facebook.p029a.C0428w m783a() {
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
        r0 = com.facebook.p029a.C0418o.class;
        monitor-enter(r0);
        com.facebook.p029a.p032b.C0383i.m690b();	 Catch:{ all -> 0x0091 }
        r1 = com.facebook.C0560t.m1252d();	 Catch:{ all -> 0x0091 }
        r2 = 0;
        r3 = "AppEventsLogger.persistedevents";	 Catch:{ FileNotFoundException -> 0x0074, Exception -> 0x003c, all -> 0x003a }
        r3 = r1.openFileInput(r3);	 Catch:{ FileNotFoundException -> 0x0074, Exception -> 0x003c, all -> 0x003a }
        r4 = new com.facebook.a.o$a;	 Catch:{ FileNotFoundException -> 0x0074, Exception -> 0x003c, all -> 0x003a }
        r5 = new java.io.BufferedInputStream;	 Catch:{ FileNotFoundException -> 0x0074, Exception -> 0x003c, all -> 0x003a }
        r5.<init>(r3);	 Catch:{ FileNotFoundException -> 0x0074, Exception -> 0x003c, all -> 0x003a }
        r4.<init>(r5);	 Catch:{ FileNotFoundException -> 0x0074, Exception -> 0x003c, all -> 0x003a }
        r3 = r4.readObject();	 Catch:{ FileNotFoundException -> 0x0075, Exception -> 0x0038 }
        r3 = (com.facebook.p029a.C0428w) r3;	 Catch:{ FileNotFoundException -> 0x0075, Exception -> 0x0038 }
        com.facebook.internal.C0475Q.m981a(r4);	 Catch:{ all -> 0x0091 }
        r2 = "AppEventsLogger.persistedevents";	 Catch:{ Exception -> 0x002e }
        r1 = r1.getFileStreamPath(r2);	 Catch:{ Exception -> 0x002e }
        r1.delete();	 Catch:{ Exception -> 0x002e }
        goto L_0x0036;
    L_0x002e:
        r1 = move-exception;
        r2 = f704a;	 Catch:{ all -> 0x0091 }
        r4 = "Got unexpected exception when removing events file: ";	 Catch:{ all -> 0x0091 }
        android.util.Log.w(r2, r4, r1);	 Catch:{ all -> 0x0091 }
    L_0x0036:
        r2 = r3;
        goto L_0x0088;
    L_0x0038:
        r3 = move-exception;
        goto L_0x003e;
    L_0x003a:
        r3 = move-exception;
        goto L_0x005e;
    L_0x003c:
        r3 = move-exception;
        r4 = r2;
    L_0x003e:
        r5 = f704a;	 Catch:{ all -> 0x005b }
        r6 = "Got unexpected exception while reading events: ";	 Catch:{ all -> 0x005b }
        android.util.Log.w(r5, r6, r3);	 Catch:{ all -> 0x005b }
        com.facebook.internal.C0475Q.m981a(r4);	 Catch:{ all -> 0x0091 }
        r3 = "AppEventsLogger.persistedevents";	 Catch:{ Exception -> 0x0052 }
        r1 = r1.getFileStreamPath(r3);	 Catch:{ Exception -> 0x0052 }
        r1.delete();	 Catch:{ Exception -> 0x0052 }
        goto L_0x0088;
    L_0x0052:
        r1 = move-exception;
        r3 = f704a;	 Catch:{ all -> 0x0091 }
        r4 = "Got unexpected exception when removing events file: ";	 Catch:{ all -> 0x0091 }
    L_0x0057:
        android.util.Log.w(r3, r4, r1);	 Catch:{ all -> 0x0091 }
        goto L_0x0088;	 Catch:{ all -> 0x0091 }
    L_0x005b:
        r2 = move-exception;	 Catch:{ all -> 0x0091 }
        r3 = r2;	 Catch:{ all -> 0x0091 }
        r2 = r4;	 Catch:{ all -> 0x0091 }
    L_0x005e:
        com.facebook.internal.C0475Q.m981a(r2);	 Catch:{ all -> 0x0091 }
        r2 = "AppEventsLogger.persistedevents";	 Catch:{ Exception -> 0x006b }
        r1 = r1.getFileStreamPath(r2);	 Catch:{ Exception -> 0x006b }
        r1.delete();	 Catch:{ Exception -> 0x006b }
        goto L_0x0073;
    L_0x006b:
        r1 = move-exception;
        r2 = f704a;	 Catch:{ all -> 0x0091 }
        r4 = "Got unexpected exception when removing events file: ";	 Catch:{ all -> 0x0091 }
        android.util.Log.w(r2, r4, r1);	 Catch:{ all -> 0x0091 }
    L_0x0073:
        throw r3;	 Catch:{ all -> 0x0091 }
    L_0x0074:
        r4 = r2;	 Catch:{ all -> 0x0091 }
    L_0x0075:
        com.facebook.internal.C0475Q.m981a(r4);	 Catch:{ all -> 0x0091 }
        r3 = "AppEventsLogger.persistedevents";	 Catch:{ Exception -> 0x0082 }
        r1 = r1.getFileStreamPath(r3);	 Catch:{ Exception -> 0x0082 }
        r1.delete();	 Catch:{ Exception -> 0x0082 }
        goto L_0x0088;
    L_0x0082:
        r1 = move-exception;
        r3 = f704a;	 Catch:{ all -> 0x0091 }
        r4 = "Got unexpected exception when removing events file: ";	 Catch:{ all -> 0x0091 }
        goto L_0x0057;	 Catch:{ all -> 0x0091 }
    L_0x0088:
        if (r2 != 0) goto L_0x008f;	 Catch:{ all -> 0x0091 }
    L_0x008a:
        r2 = new com.facebook.a.w;	 Catch:{ all -> 0x0091 }
        r2.<init>();	 Catch:{ all -> 0x0091 }
    L_0x008f:
        monitor-exit(r0);
        return r2;
    L_0x0091:
        r1 = move-exception;
        monitor-exit(r0);
        goto L_0x0095;
    L_0x0094:
        throw r1;
    L_0x0095:
        goto L_0x0094;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.a.o.a():com.facebook.a.w");
    }

    /* renamed from: a */
    public static synchronized void m784a(C0403b c0403b, C0429x c0429x) {
        synchronized (C0418o.class) {
            C0383i.m690b();
            C0428w a = C0418o.m783a();
            if (a.m813a(c0403b)) {
                a.m814b(c0403b).addAll(c0429x.m820b());
            } else {
                a.m812a(c0403b, c0429x.m820b());
            }
            C0418o.m786a(a);
        }
    }

    /* renamed from: a */
    public static synchronized void m785a(C0410g c0410g) {
        synchronized (C0418o.class) {
            C0383i.m690b();
            C0428w a = C0418o.m783a();
            for (C0403b c0403b : c0410g.m767b()) {
                a.m812a(c0403b, c0410g.m764a(c0403b).m820b());
            }
            C0418o.m786a(a);
        }
    }

    /* renamed from: a */
    private static void m786a(com.facebook.p029a.C0428w r6) {
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
        r0 = "AppEventsLogger.persistedevents";
        r1 = com.facebook.C0560t.m1252d();
        r2 = 0;
        r3 = new java.io.ObjectOutputStream;	 Catch:{ Exception -> 0x0025 }
        r4 = new java.io.BufferedOutputStream;	 Catch:{ Exception -> 0x0025 }
        r5 = 0;	 Catch:{ Exception -> 0x0025 }
        r5 = r1.openFileOutput(r0, r5);	 Catch:{ Exception -> 0x0025 }
        r4.<init>(r5);	 Catch:{ Exception -> 0x0025 }
        r3.<init>(r4);	 Catch:{ Exception -> 0x0025 }
        r3.writeObject(r6);	 Catch:{ Exception -> 0x0020, all -> 0x001d }
        com.facebook.internal.C0475Q.m981a(r3);
        goto L_0x0037;
    L_0x001d:
        r6 = move-exception;
        r2 = r3;
        goto L_0x0038;
    L_0x0020:
        r6 = move-exception;
        r2 = r3;
        goto L_0x0026;
    L_0x0023:
        r6 = move-exception;
        goto L_0x0038;
    L_0x0025:
        r6 = move-exception;
    L_0x0026:
        r3 = f704a;	 Catch:{ all -> 0x0023 }
        r4 = "Got unexpected exception while persisting events: ";	 Catch:{ all -> 0x0023 }
        android.util.Log.w(r3, r4, r6);	 Catch:{ all -> 0x0023 }
        r6 = r1.getFileStreamPath(r0);	 Catch:{ Exception -> 0x0034 }
        r6.delete();	 Catch:{ Exception -> 0x0034 }
    L_0x0034:
        com.facebook.internal.C0475Q.m981a(r2);
    L_0x0037:
        return;
    L_0x0038:
        com.facebook.internal.C0475Q.m981a(r2);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.a.o.a(com.facebook.a.w):void");
    }
}
