package io.gonative.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ProgressBar;
import com.onesignal.sa;
import io.gonative.android.azzpro.R;
import io.gonative.android.fa.C0714a;
import io.gonative.android.fa.C0715b;
import io.gonative.android.p038a.C0700a;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;

public class SubscriptionsActivity extends AppCompatActivity {
    private static final String TAG = "io.gonative.android.SubscriptionsActivity";
    /* renamed from: a */
    private ProgressBar f2056a;

    /* renamed from: io.gonative.android.SubscriptionsActivity$a */
    private static class C0686a extends AsyncTask<URL, Void, Void> {
        /* renamed from: a */
        private WeakReference<SubscriptionsActivity> f1469a;

        C0686a(SubscriptionsActivity subscriptionsActivity) {
            this.f1469a = new WeakReference(subscriptionsActivity);
        }

        /* renamed from: a */
        protected Void m1821a(URL... urlArr) {
            SubscriptionsActivity subscriptionsActivity = (SubscriptionsActivity) this.f1469a.get();
            if (subscriptionsActivity == null) {
                return null;
            }
            URL url = urlArr[0];
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.connect();
                if (httpURLConnection.getResponseCode() == 200) {
                    OutputStream byteArrayOutputStream = httpURLConnection.getContentLength() > 0 ? new ByteArrayOutputStream(httpURLConnection.getContentLength()) : new ByteArrayOutputStream();
                    InputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                    C0722o.m1947a(bufferedInputStream, byteArrayOutputStream);
                    bufferedInputStream.close();
                    byteArrayOutputStream.close();
                    fa a = fa.m1930a(byteArrayOutputStream.toString());
                    if (a != null) {
                        sa.m1676b(new da(this, a, subscriptionsActivity));
                        return null;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Error parsing JSON from ");
                    stringBuilder.append(url.toString());
                    throw new Exception(stringBuilder.toString());
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Got status ");
                stringBuilder2.append(httpURLConnection.getResponseCode());
                stringBuilder2.append(" when downloading ");
                stringBuilder2.append(url.toString());
                throw new Error(stringBuilder2.toString());
            } catch (Exception e) {
                subscriptionsActivity.m2637a("Error retrieving tag list", e);
            }
        }

        protected /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
            return m1821a((URL[]) objArr);
        }
    }

    /* renamed from: io.gonative.android.SubscriptionsActivity$b */
    public static class C0687b extends PreferenceFragment {
        /* renamed from: a */
        private fa f1470a;

        /* renamed from: a */
        public void m1822a(fa faVar) {
            this.f1470a = faVar;
        }

        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            Context activity = getActivity();
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity);
            Iterator it = defaultSharedPreferences.getAll().keySet().iterator();
            Editor editor = null;
            while (true) {
                String str = "oneSignalTag:";
                if (!it.hasNext()) {
                    break;
                }
                String str2 = (String) it.next();
                if (str2.startsWith(str)) {
                    if (editor == null) {
                        editor = defaultSharedPreferences.edit();
                    }
                    editor.remove(str2);
                }
            }
            if (editor != null) {
                editor.apply();
            }
            PreferenceScreen createPreferenceScreen = getPreferenceManager().createPreferenceScreen(activity);
            fa faVar = this.f1470a;
            if (faVar != null) {
                for (C0715b c0715b : faVar.f1602b) {
                    Preference preferenceCategory = new PreferenceCategory(activity);
                    preferenceCategory.setTitle(c0715b.f1599a);
                    createPreferenceScreen.addPreference(preferenceCategory);
                    for (C0714a c0714a : c0715b.f1600b) {
                        String str3 = c0714a.f1596a;
                        Preference checkBoxPreference = new CheckBoxPreference(activity);
                        checkBoxPreference.setTitle(c0714a.f1597b);
                        checkBoxPreference.setChecked(c0714a.f1598c);
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(str);
                        stringBuilder.append(str3);
                        checkBoxPreference.setKey(stringBuilder.toString());
                        checkBoxPreference.setOnPreferenceChangeListener(new ea(this, str3));
                        preferenceCategory.addPreference(checkBoxPreference);
                    }
                }
            }
            setPreferenceScreen(createPreferenceScreen);
        }
    }

    /* renamed from: a */
    private void m2637a(String str, Exception exception) {
        if (exception != null) {
            Log.e(TAG, exception.getMessage(), exception);
        }
        runOnUiThread(new ba(this, str));
    }

    /* renamed from: a */
    private void m2638a(URL url) {
        new C0686a(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new URL[]{url});
    }

    protected void onCreate(Bundle bundle) {
        String str = "Error retrieving tag list";
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_subscriptions);
        this.f2056a = (ProgressBar) findViewById(R.id.progress);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        try {
            String str2 = C0700a.m1851a((Context) this).Ma;
            if (str2 == null || str2.isEmpty()) {
                m2637a(str, null);
            }
            m2638a(new URL(str2));
        } catch (Exception e) {
            m2637a(str, e);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }
}
