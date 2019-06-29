package p000a.p005b.p008c.p009a;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

/* renamed from: a.b.c.a.c */
class C0032c implements Callback {
    /* renamed from: a */
    final /* synthetic */ C0891d f49a;

    C0032c(C0891d c0891d) {
        this.f49a = c0891d;
    }

    public void invalidateDrawable(Drawable drawable) {
        this.f49a.invalidateSelf();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        this.f49a.scheduleSelf(runnable, j);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        this.f49a.unscheduleSelf(runnable);
    }
}
