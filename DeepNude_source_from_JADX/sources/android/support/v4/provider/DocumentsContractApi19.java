package android.support.v4.provider;

import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.util.Log;

class DocumentsContractApi19 {
    private static final int FLAG_VIRTUAL_DOCUMENT = 512;
    private static final String TAG = "DocumentFile";

    private DocumentsContractApi19() {
    }

    public static boolean canRead(Context context, Uri uri) {
        return context.checkCallingOrSelfUriPermission(uri, 1) == 0 && !TextUtils.isEmpty(getRawType(context, uri));
    }

    public static boolean canWrite(Context context, Uri uri) {
        if (context.checkCallingOrSelfUriPermission(uri, 2) != 0) {
            return false;
        }
        CharSequence rawType = getRawType(context, uri);
        int queryForInt = queryForInt(context, uri, "flags", 0);
        return TextUtils.isEmpty(rawType) ? false : (queryForInt & 4) != 0 ? true : (!"vnd.android.document/directory".equals(rawType) || (queryForInt & 8) == 0) ? (TextUtils.isEmpty(rawType) || (queryForInt & 2) == 0) ? false : true : true;
    }

    private static void closeQuietly(java.lang.AutoCloseable r0) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        if (r0 == 0) goto L_0x0008;
    L_0x0002:
        r0.close();	 Catch:{ RuntimeException -> 0x0006, Exception -> 0x0008 }
        goto L_0x0008;
    L_0x0006:
        r0 = move-exception;
        throw r0;
    L_0x0008:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.provider.DocumentsContractApi19.closeQuietly(java.lang.AutoCloseable):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean exists(android.content.Context r8, android.net.Uri r9) {
        /*
        r0 = r8.getContentResolver();
        r8 = 1;
        r6 = 0;
        r7 = 0;
        r2 = new java.lang.String[r8];	 Catch:{ Exception -> 0x0023 }
        r1 = "document_id";
        r2[r6] = r1;	 Catch:{ Exception -> 0x0023 }
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r1 = r9;
        r7 = r0.query(r1, r2, r3, r4, r5);	 Catch:{ Exception -> 0x0023 }
        r9 = r7.getCount();	 Catch:{ Exception -> 0x0023 }
        if (r9 <= 0) goto L_0x001c;
    L_0x001b:
        goto L_0x001d;
    L_0x001c:
        r8 = 0;
    L_0x001d:
        closeQuietly(r7);
        return r8;
    L_0x0021:
        r8 = move-exception;
        goto L_0x003e;
    L_0x0023:
        r8 = move-exception;
        r9 = "DocumentFile";
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0021 }
        r0.<init>();	 Catch:{ all -> 0x0021 }
        r1 = "Failed query: ";
        r0.append(r1);	 Catch:{ all -> 0x0021 }
        r0.append(r8);	 Catch:{ all -> 0x0021 }
        r8 = r0.toString();	 Catch:{ all -> 0x0021 }
        android.util.Log.w(r9, r8);	 Catch:{ all -> 0x0021 }
        closeQuietly(r7);
        return r6;
    L_0x003e:
        closeQuietly(r7);
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.provider.DocumentsContractApi19.exists(android.content.Context, android.net.Uri):boolean");
    }

    public static long getFlags(Context context, Uri uri) {
        return queryForLong(context, uri, "flags", 0);
    }

    public static String getName(Context context, Uri uri) {
        return queryForString(context, uri, "_display_name", null);
    }

    private static String getRawType(Context context, Uri uri) {
        return queryForString(context, uri, "mime_type", null);
    }

    public static String getType(Context context, Uri uri) {
        String rawType = getRawType(context, uri);
        return "vnd.android.document/directory".equals(rawType) ? null : rawType;
    }

    public static boolean isDirectory(Context context, Uri uri) {
        return "vnd.android.document/directory".equals(getRawType(context, uri));
    }

    public static boolean isFile(Context context, Uri uri) {
        CharSequence rawType = getRawType(context, uri);
        if (!"vnd.android.document/directory".equals(rawType)) {
            if (!TextUtils.isEmpty(rawType)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isVirtual(Context context, Uri uri) {
        boolean z = false;
        if (!DocumentsContract.isDocumentUri(context, uri)) {
            return false;
        }
        if ((getFlags(context, uri) & 512) != 0) {
            z = true;
        }
        return z;
    }

    public static long lastModified(Context context, Uri uri) {
        return queryForLong(context, uri, "last_modified", 0);
    }

    public static long length(Context context, Uri uri) {
        return queryForLong(context, uri, "_size", 0);
    }

    private static int queryForInt(Context context, Uri uri, String str, int i) {
        return (int) queryForLong(context, uri, str, (long) i);
    }

    private static long queryForLong(Context context, Uri uri, String str, long j) {
        long j2;
        AutoCloseable autoCloseable = null;
        try {
            autoCloseable = context.getContentResolver().query(uri, new String[]{str}, null, null, null);
            if (!autoCloseable.moveToFirst() || autoCloseable.isNull(0)) {
                closeQuietly(autoCloseable);
                return j;
            }
            j2 = autoCloseable.getLong(0);
            return j2;
        } catch (Exception e) {
            String str2 = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed query: ");
            stringBuilder.append(e);
            j2 = stringBuilder.toString();
            Log.w(str2, j2);
            return j;
        } finally {
            closeQuietly(autoCloseable);
        }
    }

    private static String queryForString(Context context, Uri uri, String str, String str2) {
        AutoCloseable autoCloseable = null;
        String string;
        try {
            autoCloseable = context.getContentResolver().query(uri, new String[]{str}, null, null, null);
            if (!autoCloseable.moveToFirst() || autoCloseable.isNull(0)) {
                closeQuietly(autoCloseable);
                return str2;
            }
            string = autoCloseable.getString(0);
            return string;
        } catch (Exception e) {
            String str3 = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed query: ");
            stringBuilder.append(e);
            string = stringBuilder.toString();
            Log.w(str3, string);
            return str2;
        } finally {
            closeQuietly(autoCloseable);
        }
    }
}
