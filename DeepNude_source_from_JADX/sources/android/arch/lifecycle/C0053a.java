package android.arch.lifecycle;

import android.arch.lifecycle.C0058d.C0056a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: android.arch.lifecycle.a */
class C0053a {
    /* renamed from: a */
    static C0053a f99a = new C0053a();
    /* renamed from: b */
    private final Map<Class, C0051a> f100b = new HashMap();
    /* renamed from: c */
    private final Map<Class, Boolean> f101c = new HashMap();

    /* renamed from: android.arch.lifecycle.a$a */
    static class C0051a {
        /* renamed from: a */
        final Map<C0056a, List<C0052b>> f95a = new HashMap();
        /* renamed from: b */
        final Map<C0052b, C0056a> f96b;

        C0051a(Map<C0052b, C0056a> map) {
            this.f96b = map;
            for (Entry entry : map.entrySet()) {
                C0056a c0056a = (C0056a) entry.getValue();
                List list = (List) this.f95a.get(c0056a);
                if (list == null) {
                    list = new ArrayList();
                    this.f95a.put(c0056a, list);
                }
                list.add(entry.getKey());
            }
        }

        /* renamed from: a */
        private static void m85a(List<C0052b> list, C0060f c0060f, C0056a c0056a, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    ((C0052b) list.get(size)).m87a(c0060f, c0056a, obj);
                }
            }
        }

        /* renamed from: a */
        void m86a(C0060f c0060f, C0056a c0056a, Object obj) {
            C0051a.m85a((List) this.f95a.get(c0056a), c0060f, c0056a, obj);
            C0051a.m85a((List) this.f95a.get(C0056a.ON_ANY), c0060f, c0056a, obj);
        }
    }

    /* renamed from: android.arch.lifecycle.a$b */
    static class C0052b {
        /* renamed from: a */
        final int f97a;
        /* renamed from: b */
        final Method f98b;

        C0052b(int i, Method method) {
            this.f97a = i;
            this.f98b = method;
            this.f98b.setAccessible(true);
        }

        /* renamed from: a */
        void m87a(C0060f c0060f, C0056a c0056a, Object obj) {
            try {
                int i = this.f97a;
                if (i == 0) {
                    this.f98b.invoke(obj, new Object[0]);
                } else if (i == 1) {
                    this.f98b.invoke(obj, new Object[]{c0060f});
                } else if (i == 2) {
                    this.f98b.invoke(obj, new Object[]{c0060f, c0056a});
                }
            } catch (InvocationTargetException e) {
                throw new RuntimeException("Failed to call observer method", e.getCause());
            } catch (Throwable e2) {
                throw new RuntimeException(e2);
            }
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (obj != null) {
                if (C0052b.class == obj.getClass()) {
                    C0052b c0052b = (C0052b) obj;
                    if (this.f97a != c0052b.f97a || !this.f98b.getName().equals(c0052b.f98b.getName())) {
                        z = false;
                    }
                    return z;
                }
            }
            return false;
        }

        public int hashCode() {
            return (this.f97a * 31) + this.f98b.getName().hashCode();
        }
    }

    C0053a() {
    }

    /* renamed from: a */
    private C0051a m88a(Class cls, Method[] methodArr) {
        Class superclass = cls.getSuperclass();
        Map hashMap = new HashMap();
        if (superclass != null) {
            C0051a a = m91a(superclass);
            if (a != null) {
                hashMap.putAll(a.f96b);
            }
        }
        for (Class a2 : cls.getInterfaces()) {
            for (Entry entry : m91a(a2).f96b.entrySet()) {
                m89a(hashMap, (C0052b) entry.getKey(), (C0056a) entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = m90c(cls);
        }
        boolean z = false;
        for (Method method : r13) {
            C0067o c0067o = (C0067o) method.getAnnotation(C0067o.class);
            if (c0067o != null) {
                int i;
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else if (parameterTypes[0].isAssignableFrom(C0060f.class)) {
                    i = 1;
                } else {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                }
                C0056a value = c0067o.value();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(C0056a.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    } else if (value == C0056a.ON_ANY) {
                        i = 2;
                    } else {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                }
                if (parameterTypes.length <= 2) {
                    m89a(hashMap, new C0052b(i, method), value, cls);
                    z = true;
                } else {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
            }
        }
        C0051a c0051a = new C0051a(hashMap);
        this.f100b.put(cls, c0051a);
        this.f101c.put(cls, Boolean.valueOf(z));
        return c0051a;
    }

    /* renamed from: a */
    private void m89a(Map<C0052b, C0056a> map, C0052b c0052b, C0056a c0056a, Class cls) {
        C0056a c0056a2 = (C0056a) map.get(c0052b);
        if (c0056a2 != null) {
            if (c0056a != c0056a2) {
                Method method = c0052b.f98b;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Method ");
                stringBuilder.append(method.getName());
                stringBuilder.append(" in ");
                stringBuilder.append(cls.getName());
                stringBuilder.append(" already declared with different @OnLifecycleEvent value: previous value ");
                stringBuilder.append(c0056a2);
                stringBuilder.append(", new value ");
                stringBuilder.append(c0056a);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        if (c0056a2 == null) {
            map.put(c0052b, c0056a);
        }
    }

    /* renamed from: c */
    private Method[] m90c(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (Throwable e) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
        }
    }

    /* renamed from: a */
    C0051a m91a(Class cls) {
        C0051a c0051a = (C0051a) this.f100b.get(cls);
        return c0051a != null ? c0051a : m88a(cls, null);
    }

    /* renamed from: b */
    boolean m92b(Class cls) {
        if (this.f101c.containsKey(cls)) {
            return ((Boolean) this.f101c.get(cls)).booleanValue();
        }
        Method[] c = m90c(cls);
        for (Method annotation : c) {
            if (((C0067o) annotation.getAnnotation(C0067o.class)) != null) {
                m88a(cls, c);
                return true;
            }
        }
        this.f101c.put(cls, Boolean.valueOf(false));
        return false;
    }
}
