package android.arch.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.arch.lifecycle.C0058d.C0056a;
import android.os.Bundle;

/* renamed from: android.arch.lifecycle.p */
public class C0069p extends Fragment {
    /* renamed from: a */
    private C0068a f117a;

    /* renamed from: android.arch.lifecycle.p$a */
    interface C0068a {
        void onCreate();

        void onResume();

        void onStart();
    }

    /* renamed from: a */
    public static void m106a(Activity activity) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        String str = "android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag";
        if (fragmentManager.findFragmentByTag(str) == null) {
            fragmentManager.beginTransaction().add(new C0069p(), str).commit();
            fragmentManager.executePendingTransactions();
        }
    }

    /* renamed from: a */
    private void m107a(C0056a c0056a) {
        Activity activity = getActivity();
        if (activity instanceof C0748i) {
            ((C0748i) activity).getLifecycle().m2053b(c0056a);
            return;
        }
        if (activity instanceof C0060f) {
            C0058d lifecycle = ((C0060f) activity).getLifecycle();
            if (lifecycle instanceof C0747h) {
                ((C0747h) lifecycle).m2053b(c0056a);
            }
        }
    }

    /* renamed from: a */
    private void m108a(C0068a c0068a) {
        if (c0068a != null) {
            c0068a.onCreate();
        }
    }

    /* renamed from: b */
    private void m109b(C0068a c0068a) {
        if (c0068a != null) {
            c0068a.onResume();
        }
    }

    /* renamed from: c */
    private void m110c(C0068a c0068a) {
        if (c0068a != null) {
            c0068a.onStart();
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        m108a(this.f117a);
        m107a(C0056a.ON_CREATE);
    }

    public void onDestroy() {
        super.onDestroy();
        m107a(C0056a.ON_DESTROY);
        this.f117a = null;
    }

    public void onPause() {
        super.onPause();
        m107a(C0056a.ON_PAUSE);
    }

    public void onResume() {
        super.onResume();
        m109b(this.f117a);
        m107a(C0056a.ON_RESUME);
    }

    public void onStart() {
        super.onStart();
        m110c(this.f117a);
        m107a(C0056a.ON_START);
    }

    public void onStop() {
        super.onStop();
        m107a(C0056a.ON_STOP);
    }
}
