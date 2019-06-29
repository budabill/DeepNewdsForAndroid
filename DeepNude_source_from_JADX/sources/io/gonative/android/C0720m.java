package io.gonative.android;

import android.os.Bundle;
import android.view.ViewParent;
import io.gonative.android.LeanWebView.C0674a;

/* renamed from: io.gonative.android.m */
public interface C0720m {
    /* renamed from: a */
    void mo1401a(Bundle bundle);

    /* renamed from: a */
    void mo1402a(String str);

    /* renamed from: a */
    boolean mo1403a();

    /* renamed from: b */
    void mo1404b(String str);

    boolean canGoBack();

    void clearCache(boolean z);

    void clearFocus();

    void destroy();

    ViewParent getParent();

    int getProgress();

    int getScrollY();

    String getTitle();

    String getUrl();

    int getWidth();

    void goBack();

    void loadUrl(String str);

    void onPause();

    void onResume();

    void setCheckLoginSignup(boolean z);

    void setOnSwipeListener(C0674a c0674a);

    void stopLoading();
}
