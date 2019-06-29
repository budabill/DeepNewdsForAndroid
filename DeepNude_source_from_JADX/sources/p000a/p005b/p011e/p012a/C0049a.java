package p000a.p005b.p011e.p012a;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;

/* renamed from: a.b.e.a.a */
public final class C0049a {
    /* renamed from: a */
    private Object f90a;

    private C0049a(Object obj) {
        this.f90a = obj;
    }

    /* renamed from: a */
    public static C0049a m80a(Activity activity, DragEvent dragEvent) {
        if (VERSION.SDK_INT >= 24) {
            DragAndDropPermissions requestDragAndDropPermissions = activity.requestDragAndDropPermissions(dragEvent);
            if (requestDragAndDropPermissions != null) {
                return new C0049a(requestDragAndDropPermissions);
            }
        }
        return null;
    }
}
