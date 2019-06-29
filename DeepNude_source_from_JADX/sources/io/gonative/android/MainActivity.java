package io.gonative.android;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SearchView.SearchAutoComplete;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager.LayoutParams;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.FileChooserParams;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;
import com.astuetz.PagerSlidingTabStrip;
import com.facebook.applinks.C0435b;
import com.onesignal.C0612X;
import com.onesignal.sa;
import io.gonative.android.LeanWebView.C0674a;
import io.gonative.android.azzpro.R;
import io.gonative.android.p038a.C0700a;
import java.io.File;
import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements Observer, OnRefreshListener, C0674a {
    private static final String TAG = "io.gonative.android.MainActivity";
    /* renamed from: A */
    private boolean f2007A = false;
    /* renamed from: B */
    private int f2008B = -1;
    /* renamed from: C */
    private int f2009C = -1;
    /* renamed from: D */
    private Handler f2010D = new Handler();
    /* renamed from: E */
    private Runnable f2011E = new C0670E(this);
    /* renamed from: F */
    private C0713f f2012F = new C0713f(this);
    /* renamed from: G */
    private boolean f2013G = false;
    /* renamed from: H */
    private C0729u f2014H;
    /* renamed from: I */
    private C0695X f2015I;
    /* renamed from: J */
    private C0676a f2016J;
    /* renamed from: K */
    private BroadcastReceiver f2017K;
    /* renamed from: L */
    private BroadcastReceiver f2018L;
    /* renamed from: M */
    private BroadcastReceiver f2019M;
    /* renamed from: N */
    protected String f2020N;
    /* renamed from: O */
    protected String f2021O;
    /* renamed from: P */
    private Stack<Bundle> f2022P;
    /* renamed from: Q */
    private C0677b f2023Q;
    /* renamed from: R */
    private ArrayList<C0679d> f2024R = new ArrayList();
    /* renamed from: S */
    private ArrayList<Intent> f2025S = new ArrayList();
    /* renamed from: T */
    private String f2026T;
    /* renamed from: U */
    private String f2027U;
    /* renamed from: V */
    private PhoneStateListener f2028V;
    /* renamed from: W */
    private SignalStrength f2029W;
    /* renamed from: a */
    private C0720m f2030a;
    /* renamed from: b */
    private View f2031b;
    /* renamed from: c */
    boolean f2032c = false;
    /* renamed from: d */
    private Stack<String> f2033d = new Stack();
    /* renamed from: e */
    private ValueCallback<Uri> f2034e;
    /* renamed from: f */
    private ValueCallback<Uri[]> f2035f;
    /* renamed from: g */
    private Uri f2036g;
    /* renamed from: h */
    private DrawerLayout f2037h;
    /* renamed from: i */
    private View f2038i;
    /* renamed from: j */
    private ExpandableListView f2039j;
    /* renamed from: k */
    private ProgressBar f2040k;
    /* renamed from: l */
    private Dialog f2041l;
    /* renamed from: m */
    private boolean f2042m;
    /* renamed from: n */
    private MySwipeRefreshLayout f2043n;
    /* renamed from: o */
    private RelativeLayout f2044o;
    /* renamed from: p */
    private C0725r f2045p = null;
    /* renamed from: q */
    private ActionBarDrawerToggle f2046q;
    /* renamed from: r */
    private PagerSlidingTabStrip f2047r;
    /* renamed from: s */
    private ImageView f2048s;
    /* renamed from: t */
    private ConnectivityManager f2049t = null;
    /* renamed from: u */
    private C0691V f2050u = null;
    /* renamed from: v */
    private ja f2051v;
    /* renamed from: w */
    private C0703a f2052w;
    /* renamed from: x */
    private boolean f2053x;
    /* renamed from: y */
    private float f2054y = 0.0f;
    /* renamed from: z */
    private boolean f2055z = true;

    /* renamed from: io.gonative.android.MainActivity$a */
    private class C0676a extends BroadcastReceiver {
        /* renamed from: a */
        final /* synthetic */ MainActivity f1458a;

        private C0676a(MainActivity mainActivity) {
            this.f1458a = mainActivity;
        }

        public void onReceive(Context context, Intent intent) {
            this.f1458a.m2559H();
            if (this.f1458a.f2026T != null) {
                MainActivity mainActivity = this.f1458a;
                mainActivity.m2585l(mainActivity.f2026T);
            }
        }
    }

    /* renamed from: io.gonative.android.MainActivity$b */
    public interface C0677b {
        /* renamed from: a */
        void mo1399a(boolean z);
    }

    /* renamed from: io.gonative.android.MainActivity$c */
    public interface C0678c {
        /* renamed from: a */
        void mo1411a(String[] strArr, int[] iArr);
    }

    /* renamed from: io.gonative.android.MainActivity$d */
    private class C0679d {
        /* renamed from: a */
        String[] f1459a;
        /* renamed from: b */
        C0678c f1460b;
        /* renamed from: c */
        final /* synthetic */ MainActivity f1461c;

        C0679d(MainActivity mainActivity, String[] strArr, C0678c c0678c) {
            this.f1461c = mainActivity;
            this.f1459a = strArr;
            this.f1460b = c0678c;
        }
    }

    /* renamed from: io.gonative.android.MainActivity$e */
    public class C0680e {
        /* renamed from: a */
        final /* synthetic */ MainActivity f1462a;

        public C0680e(MainActivity mainActivity) {
            this.f1462a = mainActivity;
        }

        @JavascriptInterface
        public void onReadyState(String str) {
            this.f1462a.runOnUiThread(new C0683O(this, str));
        }
    }

    /* renamed from: A */
    private void m2552A() {
        this.f2030a.mo1402a("if (gonative_status_checker && typeof gonative_status_checker.onReadyState === 'function') gonative_status_checker.onReadyState(document.readyState);");
    }

    /* renamed from: B */
    private void m2553B() {
        if (LeanWebView.m2363b()) {
            m2624p();
        }
        this.f2030a.goBack();
    }

    /* renamed from: C */
    private void m2554C() {
        C0700a a = C0700a.m1851a((Context) this);
        String str = a.ha;
        if (str == null) {
            return;
        }
        if (!str.isEmpty()) {
            try {
                String encodeToString = Base64.encodeToString(a.ha.getBytes("utf-8"), 2);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("(function() {var parent = document.getElementsByTagName('head').item(0);var style = document.createElement('style');style.type = 'text/css';style.innerHTML = window.atob('");
                stringBuilder.append(encodeToString);
                stringBuilder.append("');parent.appendChild(style)})()");
                m2608e(stringBuilder.toString());
            } catch (Throwable e) {
                Log.e(TAG, "Error injecting customCSS via javascript", e);
            }
        }
    }

    /* renamed from: D */
    private boolean m2555D() {
        DrawerLayout drawerLayout = this.f2037h;
        return drawerLayout != null && drawerLayout.isDrawerOpen(this.f2038i);
    }

    /* renamed from: E */
    private void m2556E() {
        if (this.f2028V == null) {
            this.f2028V = new C0665A(this);
            try {
                TelephonyManager telephonyManager = (TelephonyManager) getSystemService("phone");
                if (telephonyManager == null) {
                    Log.e(TAG, "Error getting system telephony manager");
                } else {
                    telephonyManager.listen(this.f2028V, 256);
                }
            } catch (Throwable e) {
                Log.e(TAG, "Error listening for signal strength", e);
            }
        }
    }

    /* renamed from: F */
    private void m2557F() {
        this.f2030a.stopLoading();
        CookieManager.getInstance().removeAllCookie();
        CookieSyncManager.getInstance().sync();
        m2579e(false);
        this.f2014H.m1984b();
        this.f2030a.loadUrl(C0700a.m1851a((Context) this).f1534f);
    }

    /* renamed from: G */
    private void m2558G() {
        String url = this.f2030a.getUrl();
        if (url == null || !url.startsWith("file:///android_asset/offline")) {
            this.f2020N = this.f2021O;
            this.f2030a.loadUrl(url);
            return;
        }
        this.f2030a.goBack();
        m2632x();
    }

    /* renamed from: H */
    private void m2559H() {
        if (this.f2030a.getProgress() >= 100) {
            String url = this.f2030a.getUrl();
            if ((url == null || url.equals("file:///android_asset/offline.html")) && !this.f2033d.isEmpty() && !m2625q()) {
                m2606d((String) this.f2033d.pop());
            }
        }
    }

    /* renamed from: I */
    private void m2560I() {
        String str = this.f2027U;
        if (str != null) {
            m2585l(str);
            this.f2027U = null;
        }
    }

    /* renamed from: J */
    private void m2561J() {
        String url = this.f2030a.getUrl();
        boolean z = true;
        boolean a = url != null ? C0726s.m1970a(url, (Context) this) : true;
        if (C0700a.m1851a((Context) this).Ka && a) {
            try {
                Object obj;
                C0612X w = sa.m1740w();
                Object obj2 = null;
                if (w == null || w.m1424a() == null) {
                    obj = null;
                    a = false;
                } else {
                    obj2 = w.m1424a().m1407c();
                    obj = w.m1424a().m1402a();
                    a = w.m1424a().m1406b();
                }
                JSONObject jSONObject = new JSONObject(C0723p.m1949a((Context) this));
                if (obj2 != null) {
                    jSONObject.put("oneSignalUserId", obj2);
                }
                if (obj != null) {
                    jSONObject.put("oneSignalregistrationId", obj);
                    jSONObject.put("oneSignalPushToken", obj);
                }
                jSONObject.put("oneSignalSubscribed", a);
                url = "oneSignalRequiresUserPrivacyConsent";
                if (sa.m1626K()) {
                    z = false;
                }
                jSONObject.put(url, z);
                m2608e(C0726s.m1966a("gonative_onesignal_info", jSONObject));
            } catch (Throwable e) {
                Log.e(TAG, "Error with onesignal javscript callback", e);
            }
        }
    }

    /* renamed from: K */
    private void m2562K() {
        int i = C0669D.f1442a[C0700a.m1851a((Context) this).f1550v.ordinal()];
        if (i == 1) {
            i = -1;
        } else if (i == 2) {
            setRequestedOrientation(1);
            return;
        } else if (i == 3) {
            i = 6;
        } else {
            return;
        }
        setRequestedOrientation(i);
    }

    /* renamed from: L */
    private void m2563L() {
        this.f2045p = new C0725r(this);
        try {
            this.f2045p.m1962a("default");
            this.f2039j.setAdapter(this.f2045p);
        } catch (Throwable e) {
            Log.e(TAG, "Error setting up menu", e);
        }
        this.f2039j.setOnGroupClickListener(this.f2045p);
        this.f2039j.setOnChildClickListener(this.f2045p);
    }

    /* renamed from: M */
    private void m2564M() {
        this.f2010D.removeCallbacks(this.f2011E);
    }

    /* renamed from: a */
    private void m2566a(double d) {
        m2575c(false);
        if (d > 0.0d) {
            this.f2010D.postDelayed(new C0731w(this), (long) ((int) (d * 1000.0d)));
        } else {
            m2629u();
        }
    }

    /* renamed from: a */
    private void m2567a(double d, double d2) {
        this.f2041l = new Dialog(this, R.style.SplashScreen);
        if (this.f2041l.getWindow() != null) {
            this.f2041l.getWindow().getAttributes().windowAnimations = R.style.SplashScreenAnimation;
        }
        this.f2041l.setContentView(R.layout.splash_screen);
        this.f2041l.setCancelable(false);
        this.f2041l.show();
        if (d2 > 0.0d) {
            this.f2042m = true;
            d = d2;
        } else {
            this.f2042m = false;
        }
        new Handler().postDelayed(new C0682N(this), (long) (d * 1000.0d));
    }

    /* renamed from: a */
    private void m2571a(C0720m c0720m) {
        Ca.m1805a(c0720m, this);
    }

    /* renamed from: c */
    private void m2575c(boolean z) {
        if (this.f2041l == null) {
            return;
        }
        if (!this.f2042m || z) {
            this.f2041l.dismiss();
            this.f2041l = null;
        }
    }

    /* renamed from: d */
    private void m2577d(boolean z) {
        if (this.f2053x && C0700a.m1851a((Context) this).f1508D) {
            DrawerLayout drawerLayout = this.f2037h;
            if (drawerLayout != null) {
                drawerLayout.setDrawerLockMode(z ^ 1);
            }
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setDisplayHomeAsUpEnabled(z);
            }
        }
    }

    /* renamed from: e */
    private void m2579e(boolean z) {
        C0725r c0725r;
        String str;
        if (this.f2045p == null) {
            m2563L();
        }
        if (z) {
            try {
                c0725r = this.f2045p;
                str = "loggedIn";
            } catch (Throwable e) {
                Log.e(TAG, e.getMessage(), e);
                return;
            }
        }
        c0725r = this.f2045p;
        str = "default";
        c0725r.m1962a(str);
    }

    /* renamed from: k */
    private void m2584k(String str) {
        double d = C0700a.m1851a((Context) this).na;
        if (!str.equals("loading")) {
            String str2 = "interactive";
            if (!Double.isNaN(d) || !str.equals(str2)) {
                if ((!Double.isNaN(d) && str.equals(str2)) || (this.f2013G && str.equals("complete"))) {
                    if (str.equals(str2)) {
                        m2566a(d);
                        return;
                    } else {
                        m2629u();
                        return;
                    }
                }
                return;
            }
        }
        this.f2013G = true;
    }

    /* renamed from: l */
    private void m2585l(String str) {
        NetworkInfo activeNetworkInfo = this.f2049t.getActiveNetworkInfo();
        boolean z = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        Object typeName = activeNetworkInfo != null ? activeNetworkInfo.getTypeName() : "DISCONNECTED";
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("connected", z);
            jSONObject.put("type", typeName);
            if (this.f2029W != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("cdmaDbm", this.f2029W.getCdmaDbm());
                jSONObject2.put("cdmaEcio", this.f2029W.getCdmaEcio());
                jSONObject2.put("evdoDbm", this.f2029W.getEvdoDbm());
                jSONObject2.put("evdoEcio", this.f2029W.getEvdoEcio());
                jSONObject2.put("evdoSnr", this.f2029W.getEvdoSnr());
                jSONObject2.put("gsmBitErrorRate", this.f2029W.getGsmBitErrorRate());
                jSONObject2.put("gsmSignalStrength", this.f2029W.getGsmSignalStrength());
                if (VERSION.SDK_INT >= 23) {
                    jSONObject2.put("level", this.f2029W.getLevel());
                }
                jSONObject.put("cellSignalStrength", jSONObject2);
            }
            m2608e(C0726s.m1966a(str, jSONObject));
        } catch (Throwable e) {
            Log.e(TAG, "JSON error sending connectivity", e);
        }
    }

    /* renamed from: z */
    private boolean m2586z() {
        return this.f2030a.canGoBack();
    }

    /* renamed from: a */
    public void mo1815a() {
    }

    /* renamed from: a */
    public void m2588a(float f) {
        LayoutParams attributes = getWindow().getAttributes();
        attributes.screenBrightness = f;
        getWindow().setAttributes(attributes);
    }

    /* renamed from: a */
    public void m2589a(int i) {
        this.f2008B = i;
    }

    /* renamed from: a */
    public void m2590a(Uri uri) {
        this.f2036g = uri;
    }

    /* renamed from: a */
    public void m2591a(ValueCallback<Uri[]> valueCallback) {
        this.f2035f = valueCallback;
    }

    /* renamed from: a */
    public void m2592a(C0677b c0677b) {
        String str = "android.permission.ACCESS_FINE_LOCATION";
        int checkSelfPermission = ContextCompat.checkSelfPermission(this, str);
        String str2 = "android.permission.ACCESS_COARSE_LOCATION";
        int checkSelfPermission2 = ContextCompat.checkSelfPermission(this, str2);
        if (checkSelfPermission == 0 && checkSelfPermission2 == 0) {
            c0677b.mo1399a(true);
        }
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, str) || ActivityCompat.shouldShowRequestPermissionRationale(this, str2)) {
            Toast.makeText(this, R.string.request_permission_explanation_geolocation, 0).show();
        }
        this.f2023Q = c0677b;
        ActivityCompat.requestPermissions(this, new String[]{str, str2}, 102);
    }

    /* renamed from: a */
    public void m2593a(C0720m c0720m, boolean z, boolean z2) {
        m2571a(c0720m);
        View view = (View) c0720m;
        view.scrollTo(0, 0);
        Object obj = (View) this.f2030a;
        if (!z2) {
            Bundle bundle = new Bundle();
            this.f2030a.mo1401a(bundle);
            this.f2022P.add(bundle);
        }
        if (c0720m != obj) {
            ViewParent parent = c0720m.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
            ViewGroup viewGroup = (ViewGroup) obj.getParent();
            int indexOfChild = viewGroup.indexOfChild(obj);
            viewGroup.removeView(obj);
            viewGroup.addView(view, indexOfChild);
            view.setLayoutParams(obj.getLayoutParams());
            Ca.m1803a((LeanWebView) obj);
            if (!this.f2032c) {
                ((C0720m) obj).destroy();
            }
            ((C0720m) obj).setOnSwipeListener(null);
            if (C0700a.m1851a((Context) this).f1506B) {
                c0720m.setOnSwipeListener(this);
            }
        }
        this.f2032c = z;
        this.f2030a = c0720m;
        String str = this.f2020N;
        if (str != null) {
            m2608e(str);
            this.f2020N = null;
        }
    }

    /* renamed from: a */
    public void m2594a(String str) {
        if (str != null) {
            if (this.f2033d.isEmpty() || !((String) this.f2033d.peek()).equals(str)) {
                this.f2033d.push(str);
            }
            m2601b(str);
            m2566a(0.3d);
        }
    }

    /* renamed from: a */
    public void m2595a(String str, String str2) {
        m2596a(str, str2, false);
    }

    /* renamed from: a */
    public void m2596a(String str, String str2, boolean z) {
        String url = this.f2030a.getUrl();
        if (str == null || url == null || !str.equals(url)) {
            this.f2020N = str2;
            this.f2021O = str2;
            this.f2030a.loadUrl(str);
        } else {
            m2608e(str2);
            this.f2021O = str2;
        }
        if (!z) {
            ja jaVar = this.f2051v;
            if (jaVar != null) {
                jaVar.m2384a(str, str2);
            }
        }
    }

    /* renamed from: a */
    public void m2597a(String str, boolean z) {
        if (str != null) {
            this.f2020N = null;
            this.f2021O = null;
            if (str.equalsIgnoreCase("gonative_logout")) {
                m2557F();
            } else {
                this.f2030a.loadUrl(str);
            }
            if (!z) {
                ja jaVar = this.f2051v;
                if (jaVar != null) {
                    jaVar.m2384a(str, null);
                }
            }
        }
    }

    /* renamed from: a */
    public void m2598a(boolean z) {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayOptions(z ? 0 : 8, 8);
            if (z) {
                supportActionBar.setDisplayOptions(0, 8);
                supportActionBar.setDisplayShowCustomEnabled(true);
                if (this.f2048s == null) {
                    this.f2048s = new ImageView(this);
                    this.f2048s.setImageResource(R.drawable.ic_actionbar);
                }
                supportActionBar.setCustomView(this.f2048s);
            } else {
                supportActionBar.setDisplayOptions(8, 8);
                supportActionBar.setDisplayShowCustomEnabled(false);
            }
        }
    }

    /* renamed from: a */
    public void m2599a(String[] strArr, C0678c c0678c) {
        int i;
        Object obj;
        for (String checkSelfPermission : strArr) {
            if (ContextCompat.checkSelfPermission(this, checkSelfPermission) != 0) {
                obj = 1;
                break;
            }
        }
        obj = null;
        if (obj != null) {
            if (c0678c != null) {
                this.f2024R.add(new C0679d(this, strArr, c0678c));
            }
            ActivityCompat.requestPermissions(this, strArr, 199);
        } else if (c0678c != null) {
            int[] iArr = new int[strArr.length];
            for (i = 0; i < iArr.length; i++) {
                iArr[i] = 0;
            }
            c0678c.mo1411a(strArr, iArr);
        }
    }

    /* renamed from: b */
    public void mo1816b() {
        if (C0700a.m1851a((Context) this).f1506B && m2586z()) {
            m2553B();
        }
    }

    /* renamed from: b */
    public void m2601b(String str) {
        if (!str.equals(this.f2012F.m1929b())) {
            ja jaVar = this.f2051v;
            if (jaVar != null) {
                jaVar.m2386b(str);
            }
            C0703a c0703a = this.f2052w;
            if (c0703a != null) {
                c0703a.m1900a(str);
            }
            C0695X c0695x = this.f2015I;
            if (c0695x != null) {
                c0695x.m1844a(str);
            }
            m2561J();
        }
    }

    /* renamed from: b */
    public void m2602b(boolean z) {
        ActionBar supportActionBar = getSupportActionBar();
        View decorView = getWindow().getDecorView();
        int systemUiVisibility = decorView.getSystemUiVisibility();
        int i = VERSION.SDK_INT >= 16 ? 519 : 3;
        if (VERSION.SDK_INT >= 19) {
            i |= 6144;
        }
        if (z) {
            systemUiVisibility |= i;
            if (supportActionBar != null) {
                supportActionBar.hide();
            }
        } else {
            systemUiVisibility &= i ^ -1;
            if (supportActionBar != null && C0700a.m1851a((Context) this).ma) {
                supportActionBar.show();
            }
            this.f2030a.clearFocus();
        }
        decorView.setSystemUiVisibility(systemUiVisibility);
        if (z) {
            setRequestedOrientation(4);
        } else {
            m2562K();
        }
    }

    /* renamed from: c */
    public void m2603c() {
        ValueCallback valueCallback = this.f2034e;
        if (valueCallback != null) {
            valueCallback.onReceiveValue(null);
            this.f2034e = null;
        }
        valueCallback = this.f2035f;
        if (valueCallback != null) {
            valueCallback.onReceiveValue(null);
            this.f2035f = null;
        }
        this.f2036g = null;
    }

    /* renamed from: c */
    public void m2604c(String str) {
        ja jaVar = this.f2051v;
        if (jaVar != null) {
            jaVar.m2383a(str);
        }
        m2577d(C0700a.m1851a((Context) this).m1892b(str));
    }

    /* renamed from: d */
    public void m2605d() {
        this.f2037h.closeDrawers();
    }

    /* renamed from: d */
    public void m2606d(String str) {
        m2597a(str, false);
    }

    /* renamed from: e */
    public void m2607e() {
        this.f2047r.m435a();
    }

    /* renamed from: e */
    public void m2608e(String str) {
        if (str != null) {
            this.f2030a.mo1402a(str);
        }
    }

    /* renamed from: f */
    public void m2609f() {
        SwipeRefreshLayout swipeRefreshLayout = this.f2043n;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setEnabled(true);
        }
    }

    /* renamed from: f */
    public void m2610f(String str) {
        if (str != null) {
            this.f2027U = str;
            if (this.f2028V != null) {
                m2585l(str);
            } else {
                m2556E();
                new Handler().postDelayed(new C0667B(this), 500);
            }
        }
    }

    /* renamed from: g */
    public void m2611g() {
        String str = "android.permission.WRITE_EXTERNAL_STORAGE";
        if (ContextCompat.checkSelfPermission(this, str) != 0) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, str)) {
                Toast.makeText(this, R.string.request_permission_explanation_storage, 1).show();
            }
            ActivityCompat.requestPermissions(this, new String[]{str}, 103);
            return;
        }
        this.f2012F.m1928a(true);
    }

    /* renamed from: g */
    public void m2612g(java.lang.String r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        r3 = this;
        r0 = r3.f2030a;
        r0 = r0.getUrl();
        if (r4 == 0) goto L_0x002b;
    L_0x0008:
        r1 = r4.isEmpty();
        if (r1 == 0) goto L_0x000f;
    L_0x000e:
        goto L_0x002b;
    L_0x000f:
        r1 = new java.net.URI;	 Catch:{ URISyntaxException -> 0x0029 }
        r1.<init>(r4);	 Catch:{ URISyntaxException -> 0x0029 }
        r2 = r1.isAbsolute();	 Catch:{ URISyntaxException -> 0x0029 }
        if (r2 == 0) goto L_0x001b;	 Catch:{ URISyntaxException -> 0x0029 }
    L_0x001a:
        goto L_0x002c;	 Catch:{ URISyntaxException -> 0x0029 }
    L_0x001b:
        r2 = new java.net.URI;	 Catch:{ URISyntaxException -> 0x0029 }
        r2.<init>(r0);	 Catch:{ URISyntaxException -> 0x0029 }
        r0 = r2.resolve(r1);	 Catch:{ URISyntaxException -> 0x0029 }
        r4 = r0.toString();	 Catch:{ URISyntaxException -> 0x0029 }
        goto L_0x002c;
        goto L_0x002c;
    L_0x002b:
        r4 = r0;
    L_0x002c:
        if (r4 == 0) goto L_0x0054;
    L_0x002e:
        r0 = r4.isEmpty();
        if (r0 == 0) goto L_0x0035;
    L_0x0034:
        goto L_0x0054;
    L_0x0035:
        r0 = new android.content.Intent;
        r1 = "android.intent.action.SEND";
        r0.<init>(r1);
        r1 = "text/plain";
        r0.setType(r1);
        r1 = "android.intent.extra.TEXT";
        r0.putExtra(r1, r4);
        r4 = 2131492905; // 0x7f0c0029 float:1.8609275E38 double:1.0530974187E-314;
        r4 = r3.getString(r4);
        r4 = android.content.Intent.createChooser(r0, r4);
        r3.startActivity(r4);
    L_0x0054:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.gonative.android.MainActivity.g(java.lang.String):void");
    }

    /* renamed from: h */
    public C0713f m2613h() {
        return this.f2012F;
    }

    /* renamed from: h */
    public void m2614h(String str) {
        this.f2026T = str;
        m2556E();
        new Handler().postDelayed(new C0668C(this, str), 500);
    }

    /* renamed from: i */
    public RelativeLayout m2615i() {
        return this.f2044o;
    }

    /* renamed from: i */
    public String m2616i(String str) {
        ArrayList arrayList = C0700a.m1851a((Context) this).f1517M;
        String str2 = null;
        if (arrayList == null) {
            return null;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            HashMap hashMap = (HashMap) it.next();
            if (((Pattern) hashMap.get("regex")).matcher(str).matches()) {
                String str3 = "title";
                if (hashMap.containsKey(str3)) {
                    str2 = (String) hashMap.get(str3);
                }
                if (str2 != null) {
                    return str2;
                }
                str3 = "urlRegex";
                if (!hashMap.containsKey(str3)) {
                    return str2;
                }
                Matcher matcher = ((Pattern) hashMap.get(str3)).matcher(str);
                Object obj = " ";
                if (matcher.find() && matcher.groupCount() >= 1) {
                    str2 = C0726s.m1964a(matcher.group(1).replace("-", obj));
                }
                if (str2 == null) {
                    return str2;
                }
                str = "urlChompWords";
                if (!hashMap.containsKey(str) || ((Integer) hashMap.get(str)).intValue() <= 0) {
                    return str2;
                }
                int intValue = ((Integer) hashMap.get(str)).intValue();
                String[] split = str2.split("\\s+");
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < (split.length - intValue) - 1; i++) {
                    stringBuilder.append(split[i]);
                    stringBuilder.append(obj);
                }
                if (split.length > intValue) {
                    stringBuilder.append(split[(split.length - intValue) - 1]);
                }
                return stringBuilder.toString();
            }
        }
        return null;
    }

    /* renamed from: j */
    public int m2617j() {
        return this.f2009C;
    }

    /* renamed from: j */
    public int m2618j(String str) {
        ArrayList arrayList = C0700a.m1851a((Context) this).f1515K;
        if (arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                if (((Pattern) arrayList.get(i)).matcher(str).matches()) {
                    return ((Integer) C0700a.m1851a((Context) this).f1516L.get(i)).intValue();
                }
            }
        }
        return -1;
    }

    /* renamed from: k */
    public C0691V m2619k() {
        return this.f2050u;
    }

    /* renamed from: l */
    public C0680e m2620l() {
        return new C0680e(this);
    }

    /* renamed from: m */
    public ja m2621m() {
        return this.f2051v;
    }

    /* renamed from: n */
    public int m2622n() {
        return this.f2008B;
    }

    /* renamed from: o */
    public void m2623o() {
        this.f2047r.setVisibility(8);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setElevation(12.0f);
        }
    }

    @TargetApi(21)
    protected void onActivityResult(int i, int i2, Intent intent) {
        String stringExtra;
        boolean booleanExtra;
        if (intent != null && intent.getBooleanExtra("exit", false)) {
            finish();
        }
        if (intent != null) {
            stringExtra = intent.getStringExtra("url");
            booleanExtra = intent.getBooleanExtra("success", false);
        } else {
            stringExtra = null;
            booleanExtra = false;
        }
        if (i == 300 && i2 == -1) {
            if (stringExtra != null) {
                m2606d(stringExtra);
            } else {
                this.f2030a.setCheckLoginSignup(false);
                this.f2030a.loadUrl(C0700a.m1851a((Context) this).f1534f);
            }
            if (C0700a.m1851a((Context) this).f1508D) {
                m2579e(booleanExtra);
            }
        }
        if (i == 400 && i2 == -1 && stringExtra != null) {
            int intExtra = intent.getIntExtra("urlLevel", -1);
            if (intExtra != -1) {
                int i3 = this.f2009C;
                if (i3 != -1) {
                    if (intExtra <= i3) {
                        setResult(-1, intent);
                        finish();
                    }
                }
            }
            this.f2020N = intent.getStringExtra("postLoadJavascript");
            m2606d(stringExtra);
        }
        if (i == 100) {
            if (i2 != -1) {
                m2603c();
            } else if (intent != null && intent.getData() != null) {
                r8 = this.f2034e;
                if (r8 != null) {
                    r8.onReceiveValue(intent.getData());
                    this.f2034e = null;
                }
                r8 = this.f2035f;
                if (r8 != null) {
                    r8.onReceiveValue(FileChooserParams.parseResult(i2, intent));
                    this.f2035f = null;
                }
            } else if (intent != null && intent.getClipData() != null) {
                ClipData clipData = intent.getClipData();
                ArrayList arrayList = new ArrayList(clipData.getItemCount());
                for (int i4 = 0; i4 < clipData.getItemCount(); i4++) {
                    Item itemAt = clipData.getItemAt(i4);
                    if (itemAt.getUri() != null) {
                        arrayList.add(itemAt.getUri());
                    }
                }
                if (this.f2034e != null) {
                    if (arrayList.size() > 0) {
                        this.f2034e.onReceiveValue(arrayList.get(0));
                    } else {
                        this.f2034e.onReceiveValue(null);
                    }
                    this.f2034e = null;
                }
                r8 = this.f2035f;
                if (r8 != null) {
                    r8.onReceiveValue(arrayList.toArray(new Uri[arrayList.size()]));
                    this.f2035f = null;
                }
            } else if (this.f2036g != null) {
                String str = "android.permission.READ_EXTERNAL_STORAGE";
                if (ContextCompat.checkSelfPermission(this, str) != 0) {
                    if (ActivityCompat.shouldShowRequestPermissionRationale(this, str)) {
                        Toast.makeText(this, R.string.external_storage_explanation, 1).show();
                    }
                    ActivityCompat.requestPermissions(this, new String[]{str}, 101);
                    return;
                }
                r8 = this.f2034e;
                if (r8 != null) {
                    r8.onReceiveValue(this.f2036g);
                    this.f2034e = null;
                }
                r8 = this.f2035f;
                if (r8 != null) {
                    r8.onReceiveValue(new Uri[]{this.f2036g});
                    this.f2035f = null;
                }
                this.f2036g = null;
            } else {
                m2603c();
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionBarDrawerToggle actionBarDrawerToggle = this.f2046q;
        if (actionBarDrawerToggle != null) {
            actionBarDrawerToggle.onConfigurationChanged(configuration);
        }
    }

    protected void onCreate(Bundle bundle) {
        String str;
        String str2;
        C0700a a = C0700a.m1851a((Context) this);
        GoNativeApplication goNativeApplication = (GoNativeApplication) getApplication();
        m2562K();
        if (a.f1551w) {
            getWindow().addFlags(128);
        }
        this.f2054y = a.ta;
        super.onCreate(bundle);
        this.f2053x = getIntent().getBooleanExtra("isRoot", true);
        this.f2009C = getIntent().getIntExtra("parentUrlLevel", -1);
        if (this.f2053x) {
            StringBuilder stringBuilder;
            boolean hasCategory = getIntent().hasCategory("android.intent.category.LAUNCHER");
            Object obj = (getIntent().getFlags() & 1048576) != 0 ? 1 : null;
            if (!getIntent().getBooleanExtra("noSplash", false) && hasCategory && obj == null) {
                m2567a(a.wa, a.xa);
            }
            File file = new File(getCacheDir(), "webviewAppCache");
            str = " exists";
            if (!file.mkdirs()) {
                str2 = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("cachePath ");
                stringBuilder.append(file.toString());
                stringBuilder.append(str);
                Log.v(str2, stringBuilder.toString());
            }
            file = new File(getCacheDir(), "webviewDatabase");
            if (file.mkdirs()) {
                str2 = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("databasePath ");
                stringBuilder.append(file.toString());
                stringBuilder.append(str);
                Log.v(str2, stringBuilder.toString());
            }
            ka.m1932a().m1934a((Context) this);
            new C0706c(this).m1916b();
            this.f2015I = goNativeApplication.m1813b();
        }
        this.f2014H = goNativeApplication.m1811a();
        goNativeApplication.m1814c().m1800a((Activity) this);
        this.f2049t = (ConnectivityManager) getSystemService("connectivity");
        int i = (this.f2053x && C0700a.m1851a((Context) this).f1508D) ? R.layout.activity_gonative : R.layout.activity_gonative_nonav;
        setContentView(i);
        this.f2040k = (ProgressBar) findViewById(R.id.progress);
        this.f2044o = (RelativeLayout) findViewById(R.id.fullscreen);
        this.f2043n = (MySwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        this.f2043n.setEnabled(a.f1505A);
        this.f2043n.setOnRefreshListener(this);
        this.f2043n.setCanChildScrollUpCallback(new C0880F(this));
        if (a.ua != null) {
            this.f2043n.setColorSchemeColors(a.ua.intValue());
        }
        this.f2031b = findViewById(R.id.webviewOverlay);
        this.f2030a = (C0720m) findViewById(R.id.webview);
        m2571a(this.f2030a);
        if (a.f1506B) {
            this.f2030a.setOnSwipeListener(this);
        }
        if (this.f2053x && C0700a.m1851a((Context) this).f1508D) {
            this.f2050u = new C0691V(this, (Spinner) findViewById(R.id.profile_picker));
            aa aaVar = new aa(this, (Spinner) findViewById(R.id.segmented_control));
        }
        CookieSyncManager.createInstance(getApplicationContext());
        CookieHandler.setDefault(new Da());
        this.f2020N = getIntent().getStringExtra("postLoadJavascript");
        this.f2021O = this.f2020N;
        this.f2022P = new Stack();
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        this.f2047r = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        this.f2051v = new ja(this, viewPager);
        viewPager.setAdapter(this.f2051v);
        this.f2047r.setViewPager(viewPager);
        this.f2047r.setTabClickListener(this.f2051v);
        Integer num = a.fa;
        if (num != null) {
            this.f2047r.setBackgroundColor(num.intValue());
        }
        num = a.ea;
        if (num != null) {
            this.f2047r.setTextColor(num.intValue());
        }
        num = a.ga;
        if (num != null) {
            this.f2047r.setIndicatorColor(num.intValue());
        }
        m2623o();
        if (!(a.ma || getSupportActionBar() == null)) {
            getSupportActionBar().hide();
        }
        this.f2052w = new C0703a(this);
        Intent intent = getIntent();
        String str3 = null;
        str2 = intent.getStringExtra("targetUrl");
        if (!(str2 == null || str2.isEmpty())) {
            str3 = str2;
        }
        if ("android.intent.action.VIEW".equals(intent.getAction())) {
            Uri data = intent.getData();
            if (data != null) {
                str = ".http";
                String str4 = ".https";
                if (data.getScheme().endsWith(str) || data.getScheme().endsWith(str4)) {
                    Builder buildUpon = data.buildUpon();
                    if (data.getScheme().endsWith(str4)) {
                        str3 = "https";
                    } else {
                        if (data.getScheme().endsWith(str)) {
                            str3 = "http";
                        }
                        str3 = buildUpon.build().toString();
                    }
                    buildUpon.scheme(str3);
                    str3 = buildUpon.build().toString();
                }
            }
            str3 = intent.getDataString();
        }
        str2 = "url";
        if (str3 == null && bundle != null) {
            str3 = bundle.getString(str2);
        }
        if (str3 == null && this.f2053x) {
            str3 = new C0704b(this).m1912a();
        }
        if (str3 == null && this.f2053x) {
            str3 = a.f1534f;
        }
        if (str3 == null) {
            str3 = intent.getStringExtra(str2);
        }
        if (str3 != null) {
            if (LeanWebView.m2363b() && a.Fa) {
                m2592a(new C0881G(this, str3));
            } else {
                this.f2030a.loadUrl(str3);
            }
        } else if (!intent.getBooleanExtra("io.gonative.android.MainActivity.Extra.WEBVIEW_WINDOW_OPEN", false)) {
            Log.e(TAG, "No url specified for MainActivity");
        }
        if (this.f2053x && a.Wa) {
            C0435b.m828a(this, new C0883I(this));
        }
        if (this.f2053x && a.f1508D) {
            this.f2037h = (DrawerLayout) findViewById(R.id.drawer_layout);
            this.f2038i = findViewById(R.id.left_drawer);
            this.f2039j = (ExpandableListView) findViewById(R.id.drawer_list);
            this.f2037h.setDrawerShadow((int) R.drawable.drawer_shadow, (int) GravityCompat.START);
            this.f2046q = new C0919J(this, this, this.f2037h, R.string.drawer_open, R.string.drawer_close);
            this.f2037h.addDrawerListener(this.f2046q);
            m2563L();
            if (a.f1512H != null) {
                this.f2014H.addObserver(this);
            }
        }
        if (getSupportActionBar() != null) {
            if (!this.f2053x || a.f1508D) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }
            m2598a(a.m1890a(str3));
        }
        if (!(this.f2038i == null || C0700a.m1851a((Context) this).ba == null)) {
            this.f2038i.setBackgroundColor(C0700a.m1851a((Context) this).ba.intValue());
        }
        this.f2017K = new C0672K(this);
        LocalBroadcastManager.getInstance(this).registerReceiver(this.f2017K, new IntentFilter("io.gonative.android.onesignal.statuschanged"));
        this.f2018L = new C0673L(this);
        LocalBroadcastManager.getInstance(this).registerReceiver(this.f2018L, new IntentFilter("io.gonative.android.AppConfig.processedNavigationTitles"));
        this.f2019M = new C0675M(this);
        LocalBroadcastManager.getInstance(this).registerReceiver(this.f2019M, new IntentFilter("io.gonative.android.AppConfig.processedNavigationLevels"));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.topmenu, menu);
        C0700a a = C0700a.m1851a((Context) this);
        MenuItem findItem = menu.findItem(R.id.action_search);
        if (a.za != null) {
            findItem.setVisible(true);
            SearchView searchView = (SearchView) findItem.getActionView();
            if (searchView != null) {
                SearchAutoComplete searchAutoComplete = (SearchAutoComplete) searchView.findViewById(R.id.search_src_text);
                if (searchAutoComplete != null) {
                    searchAutoComplete.setTextColor(a.la.intValue());
                    int intValue = a.la.intValue();
                    searchAutoComplete.setHintTextColor(Color.argb(192, Color.red(intValue), Color.green(intValue), Color.blue(intValue)));
                }
                ImageView imageView = (ImageView) searchView.findViewById(R.id.search_close_btn);
                if (imageView != null) {
                    imageView.setColorFilter(a.la.intValue());
                }
                searchView.setOnQueryTextListener(new C0887x(this, findItem));
                searchView.setOnQueryTextFocusChangeListener(new C0732y(this, findItem));
            }
        }
        if (!a.ra) {
            MenuItem findItem2 = menu.findItem(R.id.action_refresh);
            if (findItem2 != null) {
                findItem2.setVisible(false);
            }
        }
        C0703a c0703a = this.f2052w;
        if (c0703a != null) {
            c0703a.m1899a(menu);
        }
        return true;
    }

    protected void onDestroy() {
        super.onDestroy();
        C0720m c0720m = this.f2030a;
        if (c0720m != null) {
            c0720m.stopLoading();
            ViewGroup viewGroup = (ViewGroup) this.f2030a.getParent();
            if (viewGroup != null) {
                viewGroup.removeView((View) this.f2030a);
            }
            if (!this.f2032c) {
                this.f2030a.destroy();
            }
        }
        this.f2014H.deleteObserver(this);
        if (this.f2017K != null) {
            LocalBroadcastManager.getInstance(this).unregisterReceiver(this.f2017K);
        }
        if (this.f2018L != null) {
            LocalBroadcastManager.getInstance(this).unregisterReceiver(this.f2018L);
        }
        if (this.f2019M != null) {
            LocalBroadcastManager.getInstance(this).unregisterReceiver(this.f2019M);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.f2030a.mo1403a()) {
                return true;
            }
            if (m2555D()) {
                this.f2037h.closeDrawers();
                return true;
            } else if (m2586z()) {
                m2553B();
                return true;
            } else if (!this.f2022P.isEmpty()) {
                Bundle bundle = (Bundle) this.f2022P.pop();
                C0720m leanWebView = new LeanWebView(this);
                leanWebView.m2367b(bundle);
                m2593a(leanWebView, false, true);
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    protected void onNewIntent(Intent intent) {
        String stringExtra = intent.getStringExtra("targetUrl");
        if (stringExtra != null && !stringExtra.isEmpty()) {
            m2606d(stringExtra);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        ActionBarDrawerToggle actionBarDrawerToggle = this.f2046q;
        if (actionBarDrawerToggle != null && actionBarDrawerToggle.onOptionsItemSelected(menuItem)) {
            return true;
        }
        C0703a c0703a = this.f2052w;
        if (c0703a != null && c0703a.m1901a(menuItem)) {
            return true;
        }
        switch (menuItem.getItemId()) {
            case 16908332:
                finish();
                return true;
            case R.id.action_refresh:
                onRefresh();
                return true;
            case R.id.action_search:
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    protected void onPause() {
        super.onPause();
        m2564M();
        this.f2030a.onPause();
        BroadcastReceiver broadcastReceiver = this.f2016J;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
        }
        if (VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().flush();
        }
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        ActionBarDrawerToggle actionBarDrawerToggle = this.f2046q;
        if (actionBarDrawerToggle != null) {
            actionBarDrawerToggle.syncState();
        }
    }

    public void onRefresh() {
        m2558G();
        if (C0700a.m1851a((Context) this).ya) {
            new Handler().postDelayed(new C0733z(this), 1000);
        } else {
            this.f2043n.setRefreshing(false);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onRequestPermissionsResult(int r7, java.lang.String[] r8, int[] r9) {
        /*
        r6 = this;
        r0 = 199; // 0xc7 float:2.79E-43 double:9.83E-322;
        r1 = 1;
        r2 = 0;
        if (r7 == r0) goto L_0x0067;
    L_0x0006:
        r8 = 0;
        switch(r7) {
            case 101: goto L_0x0037;
            case 102: goto L_0x001a;
            case 103: goto L_0x000c;
            default: goto L_0x000a;
        };
    L_0x000a:
        goto L_0x00d0;
    L_0x000c:
        r7 = r9.length;
        if (r7 <= 0) goto L_0x00d0;
    L_0x000f:
        r7 = r9[r2];
        if (r7 != 0) goto L_0x00d0;
    L_0x0013:
        r7 = r6.f2012F;
        r7.m1928a(r1);
        goto L_0x00d0;
    L_0x001a:
        r7 = r6.f2023Q;
        if (r7 == 0) goto L_0x00d0;
    L_0x001e:
        r0 = r9.length;
        r3 = 2;
        if (r0 < r3) goto L_0x002e;
    L_0x0022:
        r0 = r9[r2];
        if (r0 != 0) goto L_0x002e;
    L_0x0026:
        r9 = r9[r1];
        if (r9 != 0) goto L_0x002e;
    L_0x002a:
        r7.mo1399a(r1);
        goto L_0x0033;
    L_0x002e:
        r7 = r6.f2023Q;
        r7.mo1399a(r2);
    L_0x0033:
        r6.f2023Q = r8;
        goto L_0x00d0;
    L_0x0037:
        r7 = r9.length;
        if (r7 <= 0) goto L_0x0062;
    L_0x003a:
        r7 = r9[r2];
        if (r7 != 0) goto L_0x0062;
    L_0x003e:
        r7 = r6.f2036g;
        if (r7 != 0) goto L_0x0046;
    L_0x0042:
        r6.m2603c();
        return;
    L_0x0046:
        r9 = r6.f2034e;
        if (r9 == 0) goto L_0x004f;
    L_0x004a:
        r9.onReceiveValue(r7);
        r6.f2034e = r8;
    L_0x004f:
        r7 = r6.f2035f;
        if (r7 == 0) goto L_0x005e;
    L_0x0053:
        r9 = new android.net.Uri[r1];
        r0 = r6.f2036g;
        r9[r2] = r0;
        r7.onReceiveValue(r9);
        r6.f2035f = r8;
    L_0x005e:
        r6.f2036g = r8;
        goto L_0x00d0;
    L_0x0062:
        r6.m2603c();
        goto L_0x00d0;
    L_0x0067:
        r7 = r6.f2024R;
        r7 = r7.iterator();
    L_0x006d:
        r0 = r7.hasNext();
        if (r0 == 0) goto L_0x00a7;
    L_0x0073:
        r0 = r7.next();
        r0 = (io.gonative.android.MainActivity.C0679d) r0;
        r3 = r0.f1459a;
        r3 = r3.length;
        r4 = r8.length;
        if (r3 == r4) goto L_0x0080;
    L_0x007f:
        goto L_0x006d;
    L_0x0080:
        r3 = 0;
    L_0x0081:
        r4 = r0.f1459a;
        r5 = r4.length;
        if (r3 >= r5) goto L_0x0098;
    L_0x0086:
        r5 = r8.length;
        if (r3 >= r5) goto L_0x0098;
    L_0x0089:
        r4 = r4[r3];
        r5 = r8[r3];
        r4 = r4.equals(r5);
        if (r4 != 0) goto L_0x0095;
    L_0x0093:
        r3 = 1;
        goto L_0x0099;
    L_0x0095:
        r3 = r3 + 1;
        goto L_0x0081;
    L_0x0098:
        r3 = 0;
    L_0x0099:
        if (r3 == 0) goto L_0x009c;
    L_0x009b:
        goto L_0x006d;
    L_0x009c:
        r0 = r0.f1460b;
        if (r0 == 0) goto L_0x00a3;
    L_0x00a0:
        r0.mo1411a(r8, r9);
    L_0x00a3:
        r7.remove();
        goto L_0x006d;
    L_0x00a7:
        r7 = r6.f2024R;
        r7 = r7.size();
        if (r7 != 0) goto L_0x00d0;
    L_0x00af:
        r7 = r6.f2025S;
        r7 = r7.size();
        if (r7 <= 0) goto L_0x00d0;
    L_0x00b7:
        r7 = r6.f2025S;
        r7 = r7.iterator();
    L_0x00bd:
        r8 = r7.hasNext();
        if (r8 == 0) goto L_0x00d0;
    L_0x00c3:
        r8 = r7.next();
        r8 = (android.content.Intent) r8;
        r6.startActivity(r8);
        r7.remove();
        goto L_0x00bd;
    L_0x00d0:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.gonative.android.MainActivity.onRequestPermissionsResult(int, java.lang.String[], int[]):void");
    }

    protected void onResume() {
        super.onResume();
        this.f2030a.onResume();
        m2559H();
        this.f2016J = new C0676a();
        registerReceiver(this.f2016J, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.f2014H.m1984b();
    }

    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("url", this.f2030a.getUrl());
        bundle.putInt("urlLevel", this.f2008B);
        super.onSaveInstanceState(bundle);
    }

    protected void onStart() {
        super.onStart();
        if (C0700a.m1851a((Context) this).Ka) {
            sa.m1729n();
        }
    }

    protected void onStop() {
        super.onStop();
        if (this.f2053x && C0700a.m1851a((Context) this).f1548t) {
            this.f2030a.clearCache(true);
        }
    }

    /* renamed from: p */
    public void m2624p() {
        if (!C0700a.m1851a((Context) this).ya) {
            View view;
            this.f2007A = true;
            float f = 1.0f;
            this.f2040k.setAlpha(1.0f);
            this.f2040k.setVisibility(0);
            if (this.f2055z) {
                view = this.f2031b;
            } else {
                view = this.f2031b;
                f = 1.0f - this.f2054y;
            }
            view.setAlpha(f);
        }
    }

    /* renamed from: q */
    public boolean m2625q() {
        NetworkInfo activeNetworkInfo = this.f2049t.getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            if (activeNetworkInfo.isConnected()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: r */
    public boolean m2626r() {
        return this.f2053x ^ 1;
    }

    /* renamed from: s */
    public void m2627s() {
        if (this.f2043n != null) {
            this.f2043n.setEnabled(C0700a.m1851a((Context) this).f1505A);
        }
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(charSequence);
        }
    }

    /* renamed from: t */
    public void m2628t() {
        this.f2047r.setVisibility(0);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setElevation(0.0f);
        }
        ViewCompat.setElevation(this.f2047r, 12.0f);
    }

    /* renamed from: u */
    public void m2629u() {
        m2575c(false);
        this.f2055z = false;
        this.f2013G = false;
        m2564M();
        if (this.f2007A) {
            if (VERSION.SDK_INT == 19) {
                m2554C();
            }
            this.f2007A = false;
            this.f2031b.animate().alpha(0.0f).setDuration(300).setStartDelay(150);
            this.f2040k.animate().alpha(0.0f).setDuration(60);
            return;
        }
        this.f2040k.setVisibility(4);
    }

    public void update(Observable observable, Object obj) {
        if (observable instanceof C0729u) {
            m2579e(((C0729u) observable).m1985c());
        }
    }

    /* renamed from: v */
    public void m2630v() {
        this.f2011E.run();
    }

    /* renamed from: w */
    public void m2631w() {
        this.f2026T = null;
    }

    /* renamed from: x */
    public void m2632x() {
        this.f2014H.m1984b();
    }

    /* renamed from: y */
    public void m2633y() {
        if (C0700a.m1851a((Context) this).f1522R) {
            setTitle(this.f2030a.getTitle());
        }
    }
}
