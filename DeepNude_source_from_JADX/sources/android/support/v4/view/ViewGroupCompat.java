package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import p000a.p005b.p006a.C0011e;

public final class ViewGroupCompat {
    public static final int LAYOUT_MODE_CLIP_BOUNDS = 0;
    public static final int LAYOUT_MODE_OPTICAL_BOUNDS = 1;

    private ViewGroupCompat() {
    }

    public static int getLayoutMode(ViewGroup viewGroup) {
        return VERSION.SDK_INT >= 18 ? viewGroup.getLayoutMode() : 0;
    }

    public static int getNestedScrollAxes(ViewGroup viewGroup) {
        return VERSION.SDK_INT >= 21 ? viewGroup.getNestedScrollAxes() : viewGroup instanceof NestedScrollingParent ? ((NestedScrollingParent) viewGroup).getNestedScrollAxes() : 0;
    }

    public static boolean isTransitionGroup(ViewGroup viewGroup) {
        if (VERSION.SDK_INT >= 21) {
            return viewGroup.isTransitionGroup();
        }
        boolean z;
        Boolean bool = (Boolean) viewGroup.getTag(C0011e.tag_transition_group);
        if ((bool == null || !bool.booleanValue()) && viewGroup.getBackground() == null) {
            if (ViewCompat.getTransitionName(viewGroup) == null) {
                z = false;
                return z;
            }
        }
        z = true;
        return z;
    }

    @Deprecated
    public static boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return viewGroup.onRequestSendAccessibilityEvent(view, accessibilityEvent);
    }

    public static void setLayoutMode(ViewGroup viewGroup, int i) {
        if (VERSION.SDK_INT >= 18) {
            viewGroup.setLayoutMode(i);
        }
    }

    @Deprecated
    public static void setMotionEventSplittingEnabled(ViewGroup viewGroup, boolean z) {
        viewGroup.setMotionEventSplittingEnabled(z);
    }

    public static void setTransitionGroup(ViewGroup viewGroup, boolean z) {
        if (VERSION.SDK_INT >= 21) {
            viewGroup.setTransitionGroup(z);
        } else {
            viewGroup.setTag(C0011e.tag_transition_group, Boolean.valueOf(z));
        }
    }
}
