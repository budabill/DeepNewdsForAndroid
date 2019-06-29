package com.onesignal;

import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.onesignal.U */
class C0608U<ObserverType, StateType> {
    /* renamed from: a */
    private String f1212a;
    /* renamed from: b */
    private List<Object> f1213b = new ArrayList();
    /* renamed from: c */
    private boolean f1214c;

    C0608U(String str, boolean z) {
        this.f1212a = str;
        this.f1214c = z;
    }

    /* renamed from: a */
    void m1412a(ObserverType observerType) {
        this.f1213b.add(new WeakReference(observerType));
    }

    /* renamed from: b */
    void m1413b(ObserverType observerType) {
        this.f1213b.add(observerType);
    }

    /* renamed from: c */
    boolean m1414c(StateType stateType) {
        boolean z = false;
        for (Object next : this.f1213b) {
            Object next2;
            if (next2 instanceof WeakReference) {
                next2 = ((WeakReference) next2).get();
            }
            if (next2 != null) {
                try {
                    Method declaredMethod = next2.getClass().getDeclaredMethod(this.f1212a, new Class[]{stateType.getClass()});
                    declaredMethod.setAccessible(true);
                    if (this.f1214c) {
                        aa.m1446a(new C0607T(this, declaredMethod, next2, stateType));
                    } else {
                        declaredMethod.invoke(next2, new Object[]{stateType});
                    }
                    z = true;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        return z;
    }
}
