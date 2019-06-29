package p014c.p015a.p016a.p019b.p020a;

import java.util.ArrayList;
import java.util.List;

/* renamed from: c.a.a.b.a.c */
public final class C0281c {
    /* renamed from: a */
    private final C0279a f181a;
    /* renamed from: b */
    private final List<C0280b> f182b = new ArrayList();

    public C0281c(C0279a c0279a) {
        this.f181a = c0279a;
        this.f182b.add(new C0280b(c0279a, new int[]{1}));
    }

    /* renamed from: a */
    private C0280b m202a(int i) {
        if (i >= this.f182b.size()) {
            List list = this.f182b;
            C0280b c0280b = (C0280b) list.get(list.size() - 1);
            for (int size = this.f182b.size(); size <= i; size++) {
                c0280b = c0280b.m200c(new C0280b(this.f181a, new int[]{1, r4.m188a((size - 1) + this.f181a.m187a())}));
                this.f182b.add(c0280b);
            }
        }
        return (C0280b) this.f182b.get(i);
    }

    /* renamed from: a */
    public void m203a(int[] iArr, int i) {
        if (i != 0) {
            int length = iArr.length - i;
            if (length > 0) {
                C0280b a = m202a(i);
                Object obj = new int[length];
                System.arraycopy(iArr, 0, obj, 0, length);
                Object a2 = new C0280b(this.f181a, obj).m195a(i, 1).m199b(a)[1].m197a();
                i -= a2.length;
                for (int i2 = 0; i2 < i; i2++) {
                    iArr[length + i2] = 0;
                }
                System.arraycopy(a2, 0, iArr, length + i, a2.length);
                return;
            }
            throw new IllegalArgumentException("No data bytes provided");
        }
        throw new IllegalArgumentException("No error correction bytes");
    }
}
