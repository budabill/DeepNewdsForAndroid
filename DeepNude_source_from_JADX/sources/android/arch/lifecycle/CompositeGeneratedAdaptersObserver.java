package android.arch.lifecycle;

import android.arch.lifecycle.C0058d.C0056a;

public class CompositeGeneratedAdaptersObserver implements GenericLifecycleObserver {
    /* renamed from: a */
    private final C0055c[] f1926a;

    CompositeGeneratedAdaptersObserver(C0055c[] c0055cArr) {
        this.f1926a = c0055cArr;
    }

    /* renamed from: a */
    public void mo1442a(C0060f c0060f, C0056a c0056a) {
        C0065l c0065l = new C0065l();
        int i = 0;
        for (C0055c a : this.f1926a) {
            a.m93a(c0060f, c0056a, false, c0065l);
        }
        C0055c[] c0055cArr = this.f1926a;
        int length = c0055cArr.length;
        while (i < length) {
            c0055cArr[i].m93a(c0060f, c0056a, true, c0065l);
            i++;
        }
    }
}
