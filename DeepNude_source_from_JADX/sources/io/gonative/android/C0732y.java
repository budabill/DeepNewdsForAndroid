package io.gonative.android;

import android.view.MenuItem;
import android.view.View;
import android.view.View.OnFocusChangeListener;

/* renamed from: io.gonative.android.y */
class C0732y implements OnFocusChangeListener {
    /* renamed from: a */
    final /* synthetic */ MenuItem f1671a;
    /* renamed from: b */
    final /* synthetic */ MainActivity f1672b;

    C0732y(MainActivity mainActivity, MenuItem menuItem) {
        this.f1672b = mainActivity;
        this.f1671a = menuItem;
    }

    public void onFocusChange(View view, boolean z) {
        if (!z) {
            this.f1671a.collapseActionView();
        }
    }
}
