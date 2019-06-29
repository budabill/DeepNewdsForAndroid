package android.arch.lifecycle;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: android.arch.lifecycle.j */
public class C0063j {
    /* renamed from: a */
    private static Map<Class, Integer> f113a = new HashMap();
    /* renamed from: b */
    private static Map<Class, List<Constructor<? extends C0055c>>> f114b = new HashMap();

    /* renamed from: a */
    static GenericLifecycleObserver m99a(Object obj) {
        if (obj instanceof FullLifecycleObserver) {
            return new FullLifecycleObserverAdapter((FullLifecycleObserver) obj);
        }
        if (obj instanceof GenericLifecycleObserver) {
            return (GenericLifecycleObserver) obj;
        }
        Class cls = obj.getClass();
        if (C0063j.m103b(cls) != 2) {
            return new ReflectiveGenericLifecycleObserver(obj);
        }
        List list = (List) f114b.get(cls);
        int i = 0;
        if (list.size() == 1) {
            return new SingleGeneratedAdapterObserver(C0063j.m100a((Constructor) list.get(0), obj));
        }
        C0055c[] c0055cArr = new C0055c[list.size()];
        while (i < list.size()) {
            c0055cArr[i] = C0063j.m100a((Constructor) list.get(i), obj);
            i++;
        }
        return new CompositeGeneratedAdaptersObserver(c0055cArr);
    }

    /* renamed from: a */
    private static C0055c m100a(Constructor<? extends C0055c> constructor, Object obj) {
        try {
            return (C0055c) constructor.newInstance(new Object[]{obj});
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } catch (Throwable e2) {
            throw new RuntimeException(e2);
        } catch (Throwable e22) {
            throw new RuntimeException(e22);
        }
    }

    /* renamed from: a */
    public static String m101a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str.replace(".", "_"));
        stringBuilder.append("_LifecycleAdapter");
        return stringBuilder.toString();
    }

    /* renamed from: a */
    private static java.lang.reflect.Constructor<? extends android.arch.lifecycle.C0055c> m102a(java.lang.Class<?> r4) {
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
        r0 = r4.getPackage();	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
        r1 = r4.getCanonicalName();	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
        if (r0 == 0) goto L_0x000f;	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
    L_0x000a:
        r0 = r0.getName();	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
        goto L_0x0011;	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
    L_0x000f:
        r0 = "";	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
    L_0x0011:
        r2 = r0.isEmpty();	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
        r3 = 1;	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
        if (r2 == 0) goto L_0x0019;	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
    L_0x0018:
        goto L_0x0022;	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
    L_0x0019:
        r2 = r0.length();	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
        r2 = r2 + r3;	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
        r1 = r1.substring(r2);	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
    L_0x0022:
        r1 = android.arch.lifecycle.C0063j.m101a(r1);	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
        r2 = r0.isEmpty();	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
        if (r2 == 0) goto L_0x002d;	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
    L_0x002c:
        goto L_0x0041;	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
    L_0x002d:
        r2 = new java.lang.StringBuilder;	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
        r2.<init>();	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
        r2.append(r0);	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
        r0 = ".";	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
        r2.append(r0);	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
        r2.append(r1);	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
        r1 = r2.toString();	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
    L_0x0041:
        r0 = java.lang.Class.forName(r1);	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
        r1 = new java.lang.Class[r3];	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
        r2 = 0;	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
        r1[r2] = r4;	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
        r4 = r0.getDeclaredConstructor(r1);	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
        r0 = r4.isAccessible();	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
        if (r0 != 0) goto L_0x0057;	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
    L_0x0054:
        r4.setAccessible(r3);	 Catch:{ ClassNotFoundException -> 0x005f, NoSuchMethodException -> 0x0058 }
    L_0x0057:
        return r4;
    L_0x0058:
        r4 = move-exception;
        r0 = new java.lang.RuntimeException;
        r0.<init>(r4);
        throw r0;
    L_0x005f:
        r4 = 0;
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.arch.lifecycle.j.a(java.lang.Class):java.lang.reflect.Constructor<? extends android.arch.lifecycle.c>");
    }

    /* renamed from: b */
    private static int m103b(Class<?> cls) {
        if (f113a.containsKey(cls)) {
            return ((Integer) f113a.get(cls)).intValue();
        }
        int d = C0063j.m105d(cls);
        f113a.put(cls, Integer.valueOf(d));
        return d;
    }

    /* renamed from: c */
    private static boolean m104c(Class<?> cls) {
        return cls != null && C0059e.class.isAssignableFrom(cls);
    }

    /* renamed from: d */
    private static int m105d(Class<?> cls) {
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor a = C0063j.m102a((Class) cls);
        if (a != null) {
            f114b.put(cls, Collections.singletonList(a));
            return 2;
        } else if (C0053a.f99a.m92b(cls)) {
            return 1;
        } else {
            Class superclass = cls.getSuperclass();
            Object obj = null;
            if (C0063j.m104c(superclass)) {
                if (C0063j.m103b(superclass) == 1) {
                    return 1;
                }
                obj = new ArrayList((Collection) f114b.get(superclass));
            }
            for (Class cls2 : cls.getInterfaces()) {
                if (C0063j.m104c(cls2)) {
                    if (C0063j.m103b(cls2) == 1) {
                        return 1;
                    }
                    if (obj == null) {
                        obj = new ArrayList();
                    }
                    obj.addAll((Collection) f114b.get(cls2));
                }
            }
            if (obj == null) {
                return 1;
            }
            f114b.put(cls, obj);
            return 2;
        }
    }
}
