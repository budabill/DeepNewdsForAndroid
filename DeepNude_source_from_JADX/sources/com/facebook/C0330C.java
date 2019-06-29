package com.facebook;

import android.os.Handler;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.facebook.C */
public class C0330C extends AbstractList<GraphRequest> {
    /* renamed from: a */
    private static AtomicInteger f414a = new AtomicInteger();
    /* renamed from: b */
    private Handler f415b;
    /* renamed from: c */
    private List<GraphRequest> f416c = new ArrayList();
    /* renamed from: d */
    private int f417d = 0;
    /* renamed from: e */
    private final String f418e = Integer.valueOf(f414a.incrementAndGet()).toString();
    /* renamed from: f */
    private List<C0329a> f419f = new ArrayList();
    /* renamed from: g */
    private String f420g;

    /* renamed from: com.facebook.C$a */
    public interface C0329a {
        /* renamed from: a */
        void mo953a(C0330C c0330c);
    }

    /* renamed from: com.facebook.C$b */
    public interface C0816b extends C0329a {
        /* renamed from: a */
        void m2111a(C0330C c0330c, long j, long j2);
    }

    public C0330C(Collection<GraphRequest> collection) {
        this.f416c = new ArrayList(collection);
    }

    public C0330C(GraphRequest... graphRequestArr) {
        this.f416c = Arrays.asList(graphRequestArr);
    }

    /* renamed from: a */
    public final List<C0331D> m463a() {
        return m469b();
    }

    /* renamed from: a */
    public final void m464a(int i, GraphRequest graphRequest) {
        this.f416c.add(i, graphRequest);
    }

    /* renamed from: a */
    final void m465a(Handler handler) {
        this.f415b = handler;
    }

    /* renamed from: a */
    public void m466a(C0329a c0329a) {
        if (!this.f419f.contains(c0329a)) {
            this.f419f.add(c0329a);
        }
    }

    /* renamed from: a */
    public final boolean m467a(GraphRequest graphRequest) {
        return this.f416c.add(graphRequest);
    }

    public /* bridge */ /* synthetic */ void add(int i, Object obj) {
        m464a(i, (GraphRequest) obj);
    }

    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        return m467a((GraphRequest) obj);
    }

    /* renamed from: b */
    public final GraphRequest m468b(int i, GraphRequest graphRequest) {
        return (GraphRequest) this.f416c.set(i, graphRequest);
    }

    /* renamed from: b */
    List<C0331D> m469b() {
        return GraphRequest.m517a(this);
    }

    /* renamed from: c */
    public final C0328B m470c() {
        return m471d();
    }

    public final void clear() {
        this.f416c.clear();
    }

    /* renamed from: d */
    C0328B m471d() {
        return GraphRequest.m533b(this);
    }

    /* renamed from: e */
    public final String m472e() {
        return this.f420g;
    }

    /* renamed from: f */
    final Handler m473f() {
        return this.f415b;
    }

    /* renamed from: g */
    final List<C0329a> m474g() {
        return this.f419f;
    }

    public final GraphRequest get(int i) {
        return (GraphRequest) this.f416c.get(i);
    }

    /* renamed from: h */
    final String m475h() {
        return this.f418e;
    }

    /* renamed from: i */
    final List<GraphRequest> m476i() {
        return this.f416c;
    }

    /* renamed from: j */
    public int m477j() {
        return this.f417d;
    }

    public final GraphRequest remove(int i) {
        return (GraphRequest) this.f416c.remove(i);
    }

    public /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        return m468b(i, (GraphRequest) obj);
    }

    public final int size() {
        return this.f416c.size();
    }
}
