package android.support.v4.app;

import android.app.Activity;
import android.arch.lifecycle.C0058d;
import android.arch.lifecycle.C0058d.C0057b;
import android.arch.lifecycle.C0060f;
import android.arch.lifecycle.C0069p;
import android.arch.lifecycle.C0747h;
import android.os.Bundle;
import android.support.v4.util.SimpleArrayMap;
import android.support.v4.view.KeyEventDispatcher;
import android.support.v4.view.KeyEventDispatcher.Component;
import android.view.KeyEvent;
import android.view.View;

public class SupportActivity extends Activity implements C0060f, Component {
    private SimpleArrayMap<Class<? extends ExtraData>, ExtraData> mExtraDataMap = new SimpleArrayMap();
    private C0747h mLifecycleRegistry = new C0747h(this);

    public static class ExtraData {
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        return (decorView == null || !KeyEventDispatcher.dispatchBeforeHierarchy(decorView, keyEvent)) ? KeyEventDispatcher.dispatchKeyEvent(this, decorView, this, keyEvent) : true;
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        return (decorView == null || !KeyEventDispatcher.dispatchBeforeHierarchy(decorView, keyEvent)) ? super.dispatchKeyShortcutEvent(keyEvent) : true;
    }

    public <T extends ExtraData> T getExtraData(Class<T> cls) {
        return (ExtraData) this.mExtraDataMap.get(cls);
    }

    public C0058d getLifecycle() {
        return this.mLifecycleRegistry;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C0069p.m106a((Activity) this);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        this.mLifecycleRegistry.m2051a(C0057b.CREATED);
        super.onSaveInstanceState(bundle);
    }

    public void putExtraData(ExtraData extraData) {
        this.mExtraDataMap.put(extraData.getClass(), extraData);
    }

    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }
}
