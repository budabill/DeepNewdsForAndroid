package io.gonative.android;

import android.app.Activity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.View;

/* renamed from: io.gonative.android.J */
class C0919J extends ActionBarDrawerToggle {
    /* renamed from: a */
    final /* synthetic */ MainActivity f1978a;

    C0919J(MainActivity mainActivity, Activity activity, DrawerLayout drawerLayout, int i, int i2) {
        this.f1978a = mainActivity;
        super(activity, drawerLayout, i, i2);
    }

    public void onDrawerClosed(View view) {
        this.f1978a.invalidateOptionsMenu();
    }

    public void onDrawerOpened(View view) {
        this.f1978a.invalidateOptionsMenu();
    }
}
