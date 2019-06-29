package io.gonative.android;

import android.app.Activity;
import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.app.ProgressDialog;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.MimeTypeMap;
import android.widget.Toast;
import io.gonative.android.azzpro.R;
import io.gonative.android.p038a.C0700a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* renamed from: io.gonative.android.f */
public class C0713f implements DownloadListener {
    /* renamed from: a */
    private static final String f1590a = DownloadListener.class.getName();
    /* renamed from: b */
    private MainActivity f1591b;
    /* renamed from: c */
    private ProgressDialog f1592c;
    /* renamed from: d */
    private String f1593d;
    /* renamed from: e */
    private C0712d f1594e;
    /* renamed from: f */
    private Map<String, Request> f1595f = new HashMap();

    /* renamed from: io.gonative.android.f$a */
    private class C0709a {
        /* renamed from: a */
        public String f1578a;
        /* renamed from: b */
        public String f1579b;
        /* renamed from: c */
        public String f1580c;
        /* renamed from: d */
        public long f1581d;
        /* renamed from: e */
        final /* synthetic */ C0713f f1582e;

        private C0709a(C0713f c0713f, String str, String str2, String str3, long j) {
            this.f1582e = c0713f;
            this.f1578a = str;
            this.f1579b = str2;
            this.f1580c = str3;
            this.f1581d = j;
        }
    }

    /* renamed from: io.gonative.android.f$b */
    private static class C0710b {
        /* renamed from: a */
        public File f1583a;
        /* renamed from: b */
        public String f1584b;

        private C0710b(File file, String str) {
            this.f1583a = file;
            this.f1584b = str;
        }
    }

    /* renamed from: io.gonative.android.f$c */
    private static class C0711c extends AsyncTask<C0709a, Integer, C0710b> {
        /* renamed from: a */
        private WeakReference<C0713f> f1585a;
        /* renamed from: b */
        private Exception f1586b;

        C0711c(C0713f c0713f) {
            this.f1585a = new WeakReference(c0713f);
        }

        /* renamed from: a */
        protected C0710b m1919a(C0709a... c0709aArr) {
            C0713f c0713f = (C0713f) this.f1585a.get();
            if (c0713f == null) {
                return null;
            }
            C0709a c0709a = c0709aArr[0];
            try {
                URL url = new URL(c0709a.f1578a);
                long j = 0;
                if (c0709a.f1581d > 0) {
                    publishProgress(new Integer[]{Integer.valueOf(0)});
                }
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setInstanceFollowRedirects(true);
                    httpURLConnection.setRequestProperty("User-Agent", c0709a.f1579b);
                    httpURLConnection.connect();
                    if (httpURLConnection.getResponseCode() >= 400) {
                        return null;
                    }
                    String a;
                    StringBuilder stringBuilder;
                    String str;
                    File file = new File(c0713f.f1591b.getCacheDir(), "downloads");
                    if (!file.mkdirs()) {
                        a = C0713f.f1590a;
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("Download directory ");
                        stringBuilder.append(file.toString());
                        stringBuilder.append(" exists");
                        Log.v(a, stringBuilder.toString());
                    }
                    a = C0726s.m1965a(url.toString(), httpURLConnection.getHeaderField("Content-Disposition"), c0709a.f1580c);
                    int lastIndexOf = a.lastIndexOf(46);
                    if (lastIndexOf == -1) {
                        str = "";
                    } else if (lastIndexOf == 0) {
                        str = a.substring(1);
                        a = "download";
                    } else {
                        String substring = a.substring(0, lastIndexOf);
                        str = a.substring(lastIndexOf + 1);
                        a = substring;
                    }
                    if (!str.isEmpty()) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(".");
                        stringBuilder.append(str);
                        str = stringBuilder.toString();
                    }
                    File createTempFile = File.createTempFile(a, str, file);
                    if (!createTempFile.createNewFile()) {
                        str = C0713f.f1590a;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("Error creating download file ");
                        stringBuilder2.append(createTempFile.toString());
                        Log.e(str, stringBuilder2.toString());
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
                    byte[] bArr = new byte[16384];
                    InputStream inputStream = httpURLConnection.getInputStream();
                    long j2 = 0;
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                        j2 += (long) read;
                        if (c0709a.f1581d > j) {
                            publishProgress(new Integer[]{Integer.valueOf((int) ((10000 * j2) / c0709a.f1581d))});
                        }
                        if (isCancelled()) {
                            break;
                        }
                        j = 0;
                    }
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    return new C0710b(createTempFile, c0709a.f1580c);
                } catch (Throwable e) {
                    Log.e(C0713f.f1590a, e.getMessage(), e);
                    return null;
                }
            } catch (Exception e2) {
                r1.f1586b = e2;
                return null;
            }
        }

        /* renamed from: a */
        protected void m1920a(C0710b c0710b) {
            C0713f c0713f = (C0713f) this.f1585a.get();
            if (c0713f != null) {
                Toast.makeText(c0713f.f1591b, R.string.download_canceled, 0).show();
            }
        }

        /* renamed from: a */
        protected void m1921a(Integer... numArr) {
            C0713f c0713f = (C0713f) this.f1585a.get();
            if (c0713f != null) {
                c0713f.f1592c.setProgress(numArr[0].intValue());
            }
        }

        /* renamed from: b */
        protected void m1922b(io.gonative.android.C0713f.C0710b r6) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
            /*
            r5 = this;
            r0 = r5.f1585a;
            r0 = r0.get();
            r0 = (io.gonative.android.C0713f) r0;
            if (r0 != 0) goto L_0x000b;
        L_0x000a:
            return;
        L_0x000b:
            r1 = r0.f1592c;
            r1.dismiss();
            r1 = r5.f1586b;
            r2 = 1;
            if (r1 == 0) goto L_0x0037;
        L_0x0017:
            r1 = io.gonative.android.C0713f.f1590a;
            r3 = r5.f1586b;
            r3 = r3.getMessage();
            r4 = r5.f1586b;
            android.util.Log.e(r1, r3, r4);
            r1 = r0.f1591b;
            r3 = r5.f1586b;
            r3 = r3.getLocalizedMessage();
            r1 = android.widget.Toast.makeText(r1, r3, r2);
            r1.show();
        L_0x0037:
            if (r6 == 0) goto L_0x0085;
        L_0x0039:
            r1 = r6.f1583a;
            if (r1 == 0) goto L_0x0085;
        L_0x003d:
            r1 = r0.f1591b;	 Catch:{ IllegalArgumentException -> 0x007b }
            r3 = "io.gonative.android.azzpro.fileprovider";	 Catch:{ IllegalArgumentException -> 0x007b }
            r4 = r6.f1583a;	 Catch:{ IllegalArgumentException -> 0x007b }
            r1 = android.support.v4.content.FileProvider.getUriForFile(r1, r3, r4);	 Catch:{ IllegalArgumentException -> 0x007b }
            r3 = new android.content.Intent;
            r4 = "android.intent.action.VIEW";
            r3.<init>(r4);
            r6 = r6.f1584b;
            r3.setDataAndType(r1, r6);
            r3.setFlags(r2);
            r6 = r0.f1591b;	 Catch:{ ActivityNotFoundException -> 0x0060 }
            r6.startActivity(r3);	 Catch:{ ActivityNotFoundException -> 0x0060 }
            goto L_0x0085;
        L_0x0060:
            r6 = r0.f1591b;
            r6 = r6.getResources();
            r1 = 2131492954; // 0x7f0c005a float:1.8609374E38 double:1.053097443E-314;
            r6 = r6.getString(r1);
            r0 = r0.f1591b;
            r6 = android.widget.Toast.makeText(r0, r6, r2);
            r6.show();
            goto L_0x0085;
        L_0x007b:
            r6 = move-exception;
            r0 = io.gonative.android.C0713f.f1590a;
            r1 = "Unable to get content url from FileProvider";
            android.util.Log.e(r0, r1, r6);
        L_0x0085:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.gonative.android.f.c.b(io.gonative.android.f$b):void");
        }

        protected /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
            return m1919a((C0709a[]) objArr);
        }

        protected /* bridge */ /* synthetic */ void onCancelled(Object obj) {
            m1920a((C0710b) obj);
        }

        protected /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
            m1922b((C0710b) obj);
        }

        protected void onPreExecute() {
            C0713f c0713f = (C0713f) this.f1585a.get();
            if (c0713f != null) {
                c0713f.f1592c = new ProgressDialog(c0713f.f1591b);
                c0713f.f1592c.setProgressStyle(1);
                c0713f.f1592c.setTitle(R.string.download);
                c0713f.f1592c.setIndeterminate(false);
                c0713f.f1592c.setMax(10000);
                c0713f.f1592c.setProgressNumberFormat(null);
                c0713f.f1592c.setOnCancelListener(new C0716g(this));
                c0713f.f1592c.show();
            }
        }

        protected /* bridge */ /* synthetic */ void onProgressUpdate(Object[] objArr) {
            m1921a((Integer[]) objArr);
        }
    }

    /* renamed from: io.gonative.android.f$d */
    private enum C0712d {
        PUBLIC_DOWNLOADS,
        PRIVATE_INTERNAL
    }

    C0713f(MainActivity mainActivity) {
        this.f1591b = mainActivity;
        this.f1594e = C0700a.m1851a(this.f1591b).Ga ? C0712d.PUBLIC_DOWNLOADS : C0712d.PRIVATE_INTERNAL;
    }

    /* renamed from: a */
    private void m1926a(String str, Request request) {
        this.f1595f.put(str, request);
        this.f1591b.m2611g();
    }

    /* renamed from: a */
    public void m1928a(boolean z) {
        if (z) {
            Toast.makeText(this.f1591b, R.string.starting_download, 0).show();
            DownloadManager downloadManager = (DownloadManager) this.f1591b.getSystemService("download");
            if (downloadManager == null) {
                Log.e(f1590a, "Error getting system download manager");
                return;
            }
            for (Request enqueue : this.f1595f.values()) {
                downloadManager.enqueue(enqueue);
            }
            this.f1595f.clear();
        }
    }

    /* renamed from: b */
    public String m1929b() {
        return this.f1593d;
    }

    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        String str5;
        String str6;
        Request request;
        C0709a c0709a;
        String str7 = str;
        String str8 = str4;
        Activity activity = this.f1591b;
        if (activity != null) {
            activity.runOnUiThread(new C0708e(this));
        }
        r9.f1593d = str7;
        if (str8 == null || str8.equalsIgnoreCase("application/force-download") || str8.equalsIgnoreCase("application/octet-stream")) {
            MimeTypeMap singleton = MimeTypeMap.getSingleton();
            String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
            if (!(fileExtensionFromUrl == null || fileExtensionFromUrl.isEmpty())) {
                String mimeTypeFromExtension = singleton.getMimeTypeFromExtension(fileExtensionFromUrl);
                if (mimeTypeFromExtension != null) {
                    str5 = mimeTypeFromExtension;
                    if (r9.f1594e == C0712d.PUBLIC_DOWNLOADS) {
                        str6 = str2;
                    } else if (Environment.getExternalStorageState().equals("mounted")) {
                        str6 = str2;
                        Log.w(f1590a, "External storage is not mounted. Downloading internally.");
                    } else {
                        try {
                            request = new Request(Uri.parse(str));
                            str6 = str2;
                            request.addRequestHeader("User-Agent", str2);
                            str8 = CookieManager.getInstance().getCookie(str);
                            if (str8 != null) {
                                request.addRequestHeader("Cookie", str8);
                            }
                            request.allowScanningByMediaScanner();
                            str8 = str3;
                            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, C0726s.m1965a(str, str3, str5));
                            request.setMimeType(str5);
                            request.setNotificationVisibility(1);
                            m1926a(str, request);
                        } catch (Throwable e) {
                            Log.e(f1590a, e.getMessage(), e);
                            Toast.makeText(r9.f1591b, e.getLocalizedMessage(), 1).show();
                        }
                        return;
                    }
                    c0709a = new C0709a(str, str2, str5, j);
                    new C0711c(this).execute(new C0709a[]{c0709a});
                }
            }
        }
        str5 = str8;
        if (r9.f1594e == C0712d.PUBLIC_DOWNLOADS) {
            str6 = str2;
        } else if (Environment.getExternalStorageState().equals("mounted")) {
            str6 = str2;
            Log.w(f1590a, "External storage is not mounted. Downloading internally.");
        } else {
            request = new Request(Uri.parse(str));
            str6 = str2;
            request.addRequestHeader("User-Agent", str2);
            str8 = CookieManager.getInstance().getCookie(str);
            if (str8 != null) {
                request.addRequestHeader("Cookie", str8);
            }
            request.allowScanningByMediaScanner();
            str8 = str3;
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, C0726s.m1965a(str, str3, str5));
            request.setMimeType(str5);
            request.setNotificationVisibility(1);
            m1926a(str, request);
            return;
        }
        c0709a = new C0709a(str, str2, str5, j);
        new C0711c(this).execute(new C0709a[]{c0709a});
    }
}
