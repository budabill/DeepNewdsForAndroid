package android.support.v4.provider;

import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.CancellationSignal;
import android.os.Handler;
import android.provider.BaseColumns;
import android.support.v4.content.res.FontResourcesParserCompat;
import android.support.v4.graphics.TypefaceCompat;
import android.support.v4.graphics.TypefaceCompatUtil;
import android.support.v4.provider.SelfDestructiveThread.ReplyCallback;
import android.support.v4.util.LruCache;
import android.support.v4.util.Preconditions;
import android.support.v4.util.SimpleArrayMap;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FontsContractCompat {
    private static final int BACKGROUND_THREAD_KEEP_ALIVE_DURATION_MS = 10000;
    public static final String PARCEL_FONT_RESULTS = "font_results";
    static final int RESULT_CODE_PROVIDER_NOT_FOUND = -1;
    static final int RESULT_CODE_WRONG_CERTIFICATES = -2;
    private static final String TAG = "FontsContractCompat";
    private static final SelfDestructiveThread sBackgroundThread = new SelfDestructiveThread("fonts", 10, BACKGROUND_THREAD_KEEP_ALIVE_DURATION_MS);
    private static final Comparator<byte[]> sByteArrayComparator = new C01705();
    static final Object sLock = new Object();
    static final SimpleArrayMap<String, ArrayList<ReplyCallback<TypefaceResult>>> sPendingReplies = new SimpleArrayMap();
    static final LruCache<String, Typeface> sTypefaceCache = new LruCache(16);

    /* renamed from: android.support.v4.provider.FontsContractCompat$5 */
    static class C01705 implements Comparator<byte[]> {
        C01705() {
        }

        public int compare(byte[] bArr, byte[] bArr2) {
            int length;
            int length2;
            if (bArr.length != bArr2.length) {
                length = bArr.length;
                length2 = bArr2.length;
            } else {
                int i = 0;
                while (i < bArr.length) {
                    if (bArr[i] != bArr2[i]) {
                        length = bArr[i];
                        length2 = bArr2[i];
                    } else {
                        i++;
                    }
                }
                return 0;
            }
            return length - length2;
        }
    }

    public static final class Columns implements BaseColumns {
        public static final String FILE_ID = "file_id";
        public static final String ITALIC = "font_italic";
        public static final String RESULT_CODE = "result_code";
        public static final int RESULT_CODE_FONT_NOT_FOUND = 1;
        public static final int RESULT_CODE_FONT_UNAVAILABLE = 2;
        public static final int RESULT_CODE_MALFORMED_QUERY = 3;
        public static final int RESULT_CODE_OK = 0;
        public static final String TTC_INDEX = "font_ttc_index";
        public static final String VARIATION_SETTINGS = "font_variation_settings";
        public static final String WEIGHT = "font_weight";
    }

    public static class FontFamilyResult {
        public static final int STATUS_OK = 0;
        public static final int STATUS_UNEXPECTED_DATA_PROVIDED = 2;
        public static final int STATUS_WRONG_CERTIFICATES = 1;
        private final FontInfo[] mFonts;
        private final int mStatusCode;

        public FontFamilyResult(int i, FontInfo[] fontInfoArr) {
            this.mStatusCode = i;
            this.mFonts = fontInfoArr;
        }

        public FontInfo[] getFonts() {
            return this.mFonts;
        }

        public int getStatusCode() {
            return this.mStatusCode;
        }
    }

    public static class FontInfo {
        private final boolean mItalic;
        private final int mResultCode;
        private final int mTtcIndex;
        private final Uri mUri;
        private final int mWeight;

        public FontInfo(Uri uri, int i, int i2, boolean z, int i3) {
            Preconditions.checkNotNull(uri);
            this.mUri = uri;
            this.mTtcIndex = i;
            this.mWeight = i2;
            this.mItalic = z;
            this.mResultCode = i3;
        }

        public int getResultCode() {
            return this.mResultCode;
        }

        public int getTtcIndex() {
            return this.mTtcIndex;
        }

        public Uri getUri() {
            return this.mUri;
        }

        public int getWeight() {
            return this.mWeight;
        }

        public boolean isItalic() {
            return this.mItalic;
        }
    }

    public static class FontRequestCallback {
        public static final int FAIL_REASON_FONT_LOAD_ERROR = -3;
        public static final int FAIL_REASON_FONT_NOT_FOUND = 1;
        public static final int FAIL_REASON_FONT_UNAVAILABLE = 2;
        public static final int FAIL_REASON_MALFORMED_QUERY = 3;
        public static final int FAIL_REASON_PROVIDER_NOT_FOUND = -1;
        public static final int FAIL_REASON_SECURITY_VIOLATION = -4;
        public static final int FAIL_REASON_WRONG_CERTIFICATES = -2;
        public static final int RESULT_OK = 0;

        @Retention(RetentionPolicy.SOURCE)
        public @interface FontRequestFailReason {
        }

        public void onTypefaceRequestFailed(int i) {
        }

        public void onTypefaceRetrieved(Typeface typeface) {
        }
    }

    private static final class TypefaceResult {
        final int mResult;
        final Typeface mTypeface;

        TypefaceResult(Typeface typeface, int i) {
            this.mTypeface = typeface;
            this.mResult = i;
        }
    }

    private FontsContractCompat() {
    }

    public static Typeface buildTypeface(Context context, CancellationSignal cancellationSignal, FontInfo[] fontInfoArr) {
        return TypefaceCompat.createFromFontInfo(context, cancellationSignal, fontInfoArr, 0);
    }

    private static List<byte[]> convertToByteArrayList(Signature[] signatureArr) {
        List<byte[]> arrayList = new ArrayList();
        for (Signature toByteArray : signatureArr) {
            arrayList.add(toByteArray.toByteArray());
        }
        return arrayList;
    }

    private static boolean equalsByteArrayList(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals((byte[]) list.get(i), (byte[]) list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static FontFamilyResult fetchFonts(Context context, CancellationSignal cancellationSignal, FontRequest fontRequest) {
        ProviderInfo provider = getProvider(context.getPackageManager(), fontRequest, context.getResources());
        return provider == null ? new FontFamilyResult(1, null) : new FontFamilyResult(0, getFontFromProvider(context, fontRequest, provider.authority, cancellationSignal));
    }

    private static List<List<byte[]>> getCertificates(FontRequest fontRequest, Resources resources) {
        return fontRequest.getCertificates() != null ? fontRequest.getCertificates() : FontResourcesParserCompat.readCerts(resources, fontRequest.getCertificatesArrayResId());
    }

    static FontInfo[] getFontFromProvider(Context context, FontRequest fontRequest, String str, CancellationSignal cancellationSignal) {
        Throwable th;
        String str2 = str;
        ArrayList arrayList = new ArrayList();
        String str3 = "content";
        Uri build = new Builder().scheme(str3).authority(str2).build();
        Uri build2 = new Builder().scheme(str3).authority(str2).appendPath("file").build();
        Cursor query;
        try {
            ArrayList arrayList2;
            int i;
            ArrayList arrayList3;
            int i2 = VERSION.SDK_INT;
            String str4 = Columns.VARIATION_SETTINGS;
            String str5 = Columns.RESULT_CODE;
            String str6 = Columns.ITALIC;
            String str7 = Columns.WEIGHT;
            String str8 = Columns.TTC_INDEX;
            String str9 = Columns.FILE_ID;
            str3 = "_id";
            if (i2 > 16) {
                arrayList2 = arrayList;
                i = 0;
                query = context.getContentResolver().query(build, new String[]{str3, str9, str8, str4, str7, str6, str5}, "query = ?", new String[]{fontRequest.getQuery()}, null, cancellationSignal);
            } else {
                arrayList2 = arrayList;
                i = 0;
                query = context.getContentResolver().query(build, new String[]{str3, str9, str8, str4, str7, str6, str5}, "query = ?", new String[]{fontRequest.getQuery()}, null);
            }
            if (query != null) {
                try {
                    if (query.getCount() > 0) {
                        int columnIndex = query.getColumnIndex(str5);
                        arrayList3 = new ArrayList();
                        int columnIndex2 = query.getColumnIndex(str3);
                        int columnIndex3 = query.getColumnIndex(str9);
                        int columnIndex4 = query.getColumnIndex(str8);
                        int columnIndex5 = query.getColumnIndex(str7);
                        int columnIndex6 = query.getColumnIndex(str6);
                        while (query.moveToNext()) {
                            boolean z;
                            int i3 = columnIndex != -1 ? query.getInt(columnIndex) : 0;
                            int i4 = columnIndex4 != -1 ? query.getInt(columnIndex4) : 0;
                            Uri withAppendedId = columnIndex3 == -1 ? ContentUris.withAppendedId(build, query.getLong(columnIndex2)) : ContentUris.withAppendedId(build2, query.getLong(columnIndex3));
                            int i5 = columnIndex5 != -1 ? query.getInt(columnIndex5) : 400;
                            if (columnIndex6 != -1) {
                                if (query.getInt(columnIndex6) == 1) {
                                    z = true;
                                    arrayList3.add(new FontInfo(withAppendedId, i4, i5, z, i3));
                                }
                            }
                            z = false;
                            arrayList3.add(new FontInfo(withAppendedId, i4, i5, z, i3));
                        }
                        if (query != null) {
                            query.close();
                        }
                        return (FontInfo[]) arrayList3.toArray(new FontInfo[i]);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
            arrayList3 = arrayList2;
            if (query != null) {
                query.close();
            }
            return (FontInfo[]) arrayList3.toArray(new FontInfo[i]);
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    static android.support.v4.provider.FontsContractCompat.TypefaceResult getFontInternal(android.content.Context r3, android.support.v4.provider.FontRequest r4, int r5) {
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
        r0 = 0;
        r4 = fetchFonts(r3, r0, r4);	 Catch:{ NameNotFoundException -> 0x002b }
        r1 = r4.getStatusCode();
        r2 = -3;
        if (r1 != 0) goto L_0x001d;
    L_0x000c:
        r4 = r4.getFonts();
        r3 = android.support.v4.graphics.TypefaceCompat.createFromFontInfo(r3, r0, r4, r5);
        r4 = new android.support.v4.provider.FontsContractCompat$TypefaceResult;
        if (r3 == 0) goto L_0x0019;
    L_0x0018:
        r2 = 0;
    L_0x0019:
        r4.<init>(r3, r2);
        return r4;
    L_0x001d:
        r3 = r4.getStatusCode();
        r4 = 1;
        if (r3 != r4) goto L_0x0025;
    L_0x0024:
        r2 = -2;
    L_0x0025:
        r3 = new android.support.v4.provider.FontsContractCompat$TypefaceResult;
        r3.<init>(r0, r2);
        return r3;
    L_0x002b:
        r3 = new android.support.v4.provider.FontsContractCompat$TypefaceResult;
        r4 = -1;
        r3.<init>(r0, r4);
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.provider.FontsContractCompat.getFontInternal(android.content.Context, android.support.v4.provider.FontRequest, int):android.support.v4.provider.FontsContractCompat$TypefaceResult");
    }

    public static android.graphics.Typeface getFontSync(final android.content.Context r2, final android.support.v4.provider.FontRequest r3, final android.support.v4.content.res.ResourcesCompat.FontCallback r4, final android.os.Handler r5, boolean r6, int r7, final int r8) {
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
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = r3.getIdentifier();
        r0.append(r1);
        r1 = "-";
        r0.append(r1);
        r0.append(r8);
        r0 = r0.toString();
        r1 = sTypefaceCache;
        r1 = r1.get(r0);
        r1 = (android.graphics.Typeface) r1;
        if (r1 == 0) goto L_0x0028;
    L_0x0022:
        if (r4 == 0) goto L_0x0027;
    L_0x0024:
        r4.onFontRetrieved(r1);
    L_0x0027:
        return r1;
    L_0x0028:
        if (r6 == 0) goto L_0x0043;
    L_0x002a:
        r1 = -1;
        if (r7 != r1) goto L_0x0043;
    L_0x002d:
        r2 = getFontInternal(r2, r3, r8);
        if (r4 == 0) goto L_0x0040;
    L_0x0033:
        r3 = r2.mResult;
        if (r3 != 0) goto L_0x003d;
    L_0x0037:
        r3 = r2.mTypeface;
        r4.callbackSuccessAsync(r3, r5);
        goto L_0x0040;
    L_0x003d:
        r4.callbackFailAsync(r3, r5);
    L_0x0040:
        r2 = r2.mTypeface;
        return r2;
    L_0x0043:
        r1 = new android.support.v4.provider.FontsContractCompat$1;
        r1.<init>(r2, r3, r8, r0);
        r2 = 0;
        if (r6 == 0) goto L_0x0056;
    L_0x004b:
        r3 = sBackgroundThread;	 Catch:{ InterruptedException -> 0x0055 }
        r3 = r3.postAndWait(r1, r7);	 Catch:{ InterruptedException -> 0x0055 }
        r3 = (android.support.v4.provider.FontsContractCompat.TypefaceResult) r3;	 Catch:{ InterruptedException -> 0x0055 }
        r2 = r3.mTypeface;	 Catch:{ InterruptedException -> 0x0055 }
    L_0x0055:
        return r2;
    L_0x0056:
        if (r4 != 0) goto L_0x005a;
    L_0x0058:
        r3 = r2;
        goto L_0x005f;
    L_0x005a:
        r3 = new android.support.v4.provider.FontsContractCompat$2;
        r3.<init>(r4, r5);
    L_0x005f:
        r4 = sLock;
        monitor-enter(r4);
        r5 = sPendingReplies;	 Catch:{ all -> 0x0094 }
        r5 = r5.containsKey(r0);	 Catch:{ all -> 0x0094 }
        if (r5 == 0) goto L_0x0079;	 Catch:{ all -> 0x0094 }
    L_0x006a:
        if (r3 == 0) goto L_0x0077;	 Catch:{ all -> 0x0094 }
    L_0x006c:
        r5 = sPendingReplies;	 Catch:{ all -> 0x0094 }
        r5 = r5.get(r0);	 Catch:{ all -> 0x0094 }
        r5 = (java.util.ArrayList) r5;	 Catch:{ all -> 0x0094 }
        r5.add(r3);	 Catch:{ all -> 0x0094 }
    L_0x0077:
        monitor-exit(r4);	 Catch:{ all -> 0x0094 }
        return r2;	 Catch:{ all -> 0x0094 }
    L_0x0079:
        if (r3 == 0) goto L_0x0088;	 Catch:{ all -> 0x0094 }
    L_0x007b:
        r5 = new java.util.ArrayList;	 Catch:{ all -> 0x0094 }
        r5.<init>();	 Catch:{ all -> 0x0094 }
        r5.add(r3);	 Catch:{ all -> 0x0094 }
        r3 = sPendingReplies;	 Catch:{ all -> 0x0094 }
        r3.put(r0, r5);	 Catch:{ all -> 0x0094 }
    L_0x0088:
        monitor-exit(r4);	 Catch:{ all -> 0x0094 }
        r3 = sBackgroundThread;
        r4 = new android.support.v4.provider.FontsContractCompat$3;
        r4.<init>(r0);
        r3.postAndReply(r1, r4);
        return r2;
    L_0x0094:
        r2 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0094 }
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.provider.FontsContractCompat.getFontSync(android.content.Context, android.support.v4.provider.FontRequest, android.support.v4.content.res.ResourcesCompat$FontCallback, android.os.Handler, boolean, int, int):android.graphics.Typeface");
    }

    public static ProviderInfo getProvider(PackageManager packageManager, FontRequest fontRequest, Resources resources) {
        String providerAuthority = fontRequest.getProviderAuthority();
        int i = 0;
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(providerAuthority, 0);
        if (resolveContentProvider == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("No package found for authority: ");
            stringBuilder.append(providerAuthority);
            throw new NameNotFoundException(stringBuilder.toString());
        } else if (resolveContentProvider.packageName.equals(fontRequest.getProviderPackage())) {
            List convertToByteArrayList = convertToByteArrayList(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
            Collections.sort(convertToByteArrayList, sByteArrayComparator);
            List certificates = getCertificates(fontRequest, resources);
            while (i < certificates.size()) {
                List arrayList = new ArrayList((Collection) certificates.get(i));
                Collections.sort(arrayList, sByteArrayComparator);
                if (equalsByteArrayList(convertToByteArrayList, arrayList)) {
                    return resolveContentProvider;
                }
                i++;
            }
            return null;
        } else {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Found content provider ");
            stringBuilder2.append(providerAuthority);
            stringBuilder2.append(", but package was not ");
            stringBuilder2.append(fontRequest.getProviderPackage());
            throw new NameNotFoundException(stringBuilder2.toString());
        }
    }

    public static Map<Uri, ByteBuffer> prepareFontData(Context context, FontInfo[] fontInfoArr, CancellationSignal cancellationSignal) {
        Map hashMap = new HashMap();
        for (FontInfo fontInfo : fontInfoArr) {
            if (fontInfo.getResultCode() == 0) {
                Uri uri = fontInfo.getUri();
                if (!hashMap.containsKey(uri)) {
                    hashMap.put(uri, TypefaceCompatUtil.mmap(context, cancellationSignal, uri));
                }
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public static void requestFont(final Context context, final FontRequest fontRequest, final FontRequestCallback fontRequestCallback, Handler handler) {
        final Handler handler2 = new Handler();
        handler.post(new Runnable() {

            /* renamed from: android.support.v4.provider.FontsContractCompat$4$1 */
            class C01601 implements Runnable {
                C01601() {
                }

                public void run() {
                    fontRequestCallback.onTypefaceRequestFailed(-1);
                }
            }

            /* renamed from: android.support.v4.provider.FontsContractCompat$4$2 */
            class C01612 implements Runnable {
                C01612() {
                }

                public void run() {
                    fontRequestCallback.onTypefaceRequestFailed(-2);
                }
            }

            /* renamed from: android.support.v4.provider.FontsContractCompat$4$3 */
            class C01623 implements Runnable {
                C01623() {
                }

                public void run() {
                    fontRequestCallback.onTypefaceRequestFailed(-3);
                }
            }

            /* renamed from: android.support.v4.provider.FontsContractCompat$4$4 */
            class C01634 implements Runnable {
                C01634() {
                }

                public void run() {
                    fontRequestCallback.onTypefaceRequestFailed(-3);
                }
            }

            /* renamed from: android.support.v4.provider.FontsContractCompat$4$5 */
            class C01645 implements Runnable {
                C01645() {
                }

                public void run() {
                    fontRequestCallback.onTypefaceRequestFailed(1);
                }
            }

            /* renamed from: android.support.v4.provider.FontsContractCompat$4$6 */
            class C01656 implements Runnable {
                C01656() {
                }

                public void run() {
                    fontRequestCallback.onTypefaceRequestFailed(-3);
                }
            }

            /* renamed from: android.support.v4.provider.FontsContractCompat$4$8 */
            class C01678 implements Runnable {
                C01678() {
                }

                public void run() {
                    fontRequestCallback.onTypefaceRequestFailed(-3);
                }
            }

            public void run() {
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
                r6 = this;
                r0 = r2;	 Catch:{ NameNotFoundException -> 0x0098 }
                r1 = r3;	 Catch:{ NameNotFoundException -> 0x0098 }
                r2 = 0;	 Catch:{ NameNotFoundException -> 0x0098 }
                r0 = android.support.v4.provider.FontsContractCompat.fetchFonts(r0, r2, r1);	 Catch:{ NameNotFoundException -> 0x0098 }
                r1 = r0.getStatusCode();
                if (r1 == 0) goto L_0x003a;
            L_0x000f:
                r0 = r0.getStatusCode();
                r1 = 1;
                if (r0 == r1) goto L_0x002f;
            L_0x0016:
                r1 = 2;
                if (r0 == r1) goto L_0x0024;
            L_0x0019:
                r0 = r0;
                r1 = new android.support.v4.provider.FontsContractCompat$4$4;
                r1.<init>();
                r0.post(r1);
                return;
            L_0x0024:
                r0 = r0;
                r1 = new android.support.v4.provider.FontsContractCompat$4$3;
                r1.<init>();
                r0.post(r1);
                return;
            L_0x002f:
                r0 = r0;
                r1 = new android.support.v4.provider.FontsContractCompat$4$2;
                r1.<init>();
                r0.post(r1);
                return;
            L_0x003a:
                r0 = r0.getFonts();
                if (r0 == 0) goto L_0x008d;
            L_0x0040:
                r1 = r0.length;
                if (r1 != 0) goto L_0x0044;
            L_0x0043:
                goto L_0x008d;
            L_0x0044:
                r1 = r0.length;
                r3 = 0;
            L_0x0046:
                if (r3 >= r1) goto L_0x006f;
            L_0x0048:
                r4 = r0[r3];
                r5 = r4.getResultCode();
                if (r5 == 0) goto L_0x006c;
            L_0x0050:
                r0 = r4.getResultCode();
                if (r0 >= 0) goto L_0x0061;
            L_0x0056:
                r0 = r0;
                r1 = new android.support.v4.provider.FontsContractCompat$4$6;
                r1.<init>();
                r0.post(r1);
                goto L_0x006b;
            L_0x0061:
                r1 = r0;
                r2 = new android.support.v4.provider.FontsContractCompat$4$7;
                r2.<init>(r0);
                r1.post(r2);
            L_0x006b:
                return;
            L_0x006c:
                r3 = r3 + 1;
                goto L_0x0046;
            L_0x006f:
                r1 = r2;
                r0 = android.support.v4.provider.FontsContractCompat.buildTypeface(r1, r2, r0);
                if (r0 != 0) goto L_0x0082;
            L_0x0077:
                r0 = r0;
                r1 = new android.support.v4.provider.FontsContractCompat$4$8;
                r1.<init>();
                r0.post(r1);
                return;
            L_0x0082:
                r1 = r0;
                r2 = new android.support.v4.provider.FontsContractCompat$4$9;
                r2.<init>(r0);
                r1.post(r2);
                return;
            L_0x008d:
                r0 = r0;
                r1 = new android.support.v4.provider.FontsContractCompat$4$5;
                r1.<init>();
                r0.post(r1);
                return;
            L_0x0098:
                r0 = r0;
                r1 = new android.support.v4.provider.FontsContractCompat$4$1;
                r1.<init>();
                r0.post(r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: android.support.v4.provider.FontsContractCompat.4.run():void");
            }
        });
    }

    public static void resetCache() {
        sTypefaceCache.evictAll();
    }
}
