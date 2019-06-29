package android.support.v4.print;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.CancellationSignal.OnCancelListener;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintAttributes.Margins;
import android.print.PrintAttributes.MediaSize;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentAdapter.LayoutResultCallback;
import android.print.PrintDocumentAdapter.WriteResultCallback;
import android.print.PrintDocumentInfo.Builder;
import android.print.PrintManager;
import android.util.Log;
import java.io.InputStream;

public final class PrintHelper {
    @SuppressLint({"InlinedApi"})
    public static final int COLOR_MODE_COLOR = 2;
    @SuppressLint({"InlinedApi"})
    public static final int COLOR_MODE_MONOCHROME = 1;
    static final boolean IS_MIN_MARGINS_HANDLING_CORRECT;
    private static final String LOG_TAG = "PrintHelper";
    private static final int MAX_PRINT_SIZE = 3500;
    public static final int ORIENTATION_LANDSCAPE = 1;
    public static final int ORIENTATION_PORTRAIT = 2;
    static final boolean PRINT_ACTIVITY_RESPECTS_ORIENTATION;
    public static final int SCALE_MODE_FILL = 2;
    public static final int SCALE_MODE_FIT = 1;
    int mColorMode = 2;
    final Context mContext;
    Options mDecodeOptions = null;
    final Object mLock = new Object();
    int mOrientation = 1;
    int mScaleMode = 2;

    public interface OnPrintFinishCallback {
        void onFinish();
    }

    private class PrintBitmapAdapter extends PrintDocumentAdapter {
        private PrintAttributes mAttributes;
        private final Bitmap mBitmap;
        private final OnPrintFinishCallback mCallback;
        private final int mFittingMode;
        private final String mJobName;

        PrintBitmapAdapter(String str, int i, Bitmap bitmap, OnPrintFinishCallback onPrintFinishCallback) {
            this.mJobName = str;
            this.mFittingMode = i;
            this.mBitmap = bitmap;
            this.mCallback = onPrintFinishCallback;
        }

        public void onFinish() {
            OnPrintFinishCallback onPrintFinishCallback = this.mCallback;
            if (onPrintFinishCallback != null) {
                onPrintFinishCallback.onFinish();
            }
        }

        public void onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, LayoutResultCallback layoutResultCallback, Bundle bundle) {
            this.mAttributes = printAttributes2;
            layoutResultCallback.onLayoutFinished(new Builder(this.mJobName).setContentType(1).setPageCount(1).build(), printAttributes2.equals(printAttributes) ^ true);
        }

        public void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, WriteResultCallback writeResultCallback) {
            PrintHelper.this.writeBitmap(this.mAttributes, this.mFittingMode, this.mBitmap, parcelFileDescriptor, cancellationSignal, writeResultCallback);
        }
    }

    private class PrintUriAdapter extends PrintDocumentAdapter {
        PrintAttributes mAttributes;
        Bitmap mBitmap = null;
        final OnPrintFinishCallback mCallback;
        final int mFittingMode;
        final Uri mImageFile;
        final String mJobName;
        AsyncTask<Uri, Boolean, Bitmap> mLoadBitmap;

        PrintUriAdapter(String str, Uri uri, OnPrintFinishCallback onPrintFinishCallback, int i) {
            this.mJobName = str;
            this.mImageFile = uri;
            this.mCallback = onPrintFinishCallback;
            this.mFittingMode = i;
        }

        void cancelLoad() {
            synchronized (PrintHelper.this.mLock) {
                if (PrintHelper.this.mDecodeOptions != null) {
                    if (VERSION.SDK_INT < 24) {
                        PrintHelper.this.mDecodeOptions.requestCancelDecode();
                    }
                    PrintHelper.this.mDecodeOptions = null;
                }
            }
        }

        public void onFinish() {
            super.onFinish();
            cancelLoad();
            AsyncTask asyncTask = this.mLoadBitmap;
            if (asyncTask != null) {
                asyncTask.cancel(true);
            }
            OnPrintFinishCallback onPrintFinishCallback = this.mCallback;
            if (onPrintFinishCallback != null) {
                onPrintFinishCallback.onFinish();
            }
            Bitmap bitmap = this.mBitmap;
            if (bitmap != null) {
                bitmap.recycle();
                this.mBitmap = null;
            }
        }

        public void onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, LayoutResultCallback layoutResultCallback, Bundle bundle) {
            synchronized (this) {
                this.mAttributes = printAttributes2;
            }
            if (cancellationSignal.isCanceled()) {
                layoutResultCallback.onLayoutCancelled();
            } else if (this.mBitmap != null) {
                layoutResultCallback.onLayoutFinished(new Builder(this.mJobName).setContentType(1).setPageCount(1).build(), printAttributes2.equals(printAttributes) ^ true);
            } else {
                final CancellationSignal cancellationSignal2 = cancellationSignal;
                final PrintAttributes printAttributes3 = printAttributes2;
                final PrintAttributes printAttributes4 = printAttributes;
                final LayoutResultCallback layoutResultCallback2 = layoutResultCallback;
                this.mLoadBitmap = new AsyncTask<Uri, Boolean, Bitmap>() {

                    /* renamed from: android.support.v4.print.PrintHelper$PrintUriAdapter$1$1 */
                    class C01571 implements OnCancelListener {
                        C01571() {
                        }

                        public void onCancel() {
                            PrintUriAdapter.this.cancelLoad();
                            C01581.this.cancel(false);
                        }
                    }

                    protected android.graphics.Bitmap doInBackground(android.net.Uri... r2) {
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
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
                        /*
                        r1 = this;
                        r2 = android.support.v4.print.PrintHelper.PrintUriAdapter.this;	 Catch:{ FileNotFoundException -> 0x000d }
                        r2 = android.support.v4.print.PrintHelper.this;	 Catch:{ FileNotFoundException -> 0x000d }
                        r0 = android.support.v4.print.PrintHelper.PrintUriAdapter.this;	 Catch:{ FileNotFoundException -> 0x000d }
                        r0 = r0.mImageFile;	 Catch:{ FileNotFoundException -> 0x000d }
                        r2 = r2.loadConstrainedBitmap(r0);	 Catch:{ FileNotFoundException -> 0x000d }
                        return r2;
                    L_0x000d:
                        r2 = 0;
                        return r2;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.print.PrintHelper.PrintUriAdapter.1.doInBackground(android.net.Uri[]):android.graphics.Bitmap");
                    }

                    protected void onCancelled(Bitmap bitmap) {
                        layoutResultCallback2.onLayoutCancelled();
                        PrintUriAdapter.this.mLoadBitmap = null;
                    }

                    protected void onPostExecute(Bitmap bitmap) {
                        super.onPostExecute(bitmap);
                        if (bitmap != null && (!PrintHelper.PRINT_ACTIVITY_RESPECTS_ORIENTATION || PrintHelper.this.mOrientation == 0)) {
                            MediaSize mediaSize;
                            synchronized (this) {
                                mediaSize = PrintUriAdapter.this.mAttributes.getMediaSize();
                            }
                            if (!(mediaSize == null || mediaSize.isPortrait() == PrintHelper.isPortrait(bitmap))) {
                                Matrix matrix = new Matrix();
                                matrix.postRotate(90.0f);
                                bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                            }
                        }
                        PrintUriAdapter printUriAdapter = PrintUriAdapter.this;
                        printUriAdapter.mBitmap = bitmap;
                        if (bitmap != null) {
                            layoutResultCallback2.onLayoutFinished(new Builder(printUriAdapter.mJobName).setContentType(1).setPageCount(1).build(), true ^ printAttributes3.equals(printAttributes4));
                        } else {
                            layoutResultCallback2.onLayoutFailed(null);
                        }
                        PrintUriAdapter.this.mLoadBitmap = null;
                    }

                    protected void onPreExecute() {
                        cancellationSignal2.setOnCancelListener(new C01571());
                    }
                }.execute(new Uri[0]);
            }
        }

        public void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, WriteResultCallback writeResultCallback) {
            PrintHelper.this.writeBitmap(this.mAttributes, this.mFittingMode, this.mBitmap, parcelFileDescriptor, cancellationSignal, writeResultCallback);
        }
    }

    static {
        boolean z;
        int i = VERSION.SDK_INT;
        boolean z2 = false;
        if (i >= 20) {
            if (i <= 23) {
                z = false;
                PRINT_ACTIVITY_RESPECTS_ORIENTATION = z;
                if (VERSION.SDK_INT != 23) {
                    z2 = true;
                }
                IS_MIN_MARGINS_HANDLING_CORRECT = z2;
            }
        }
        z = true;
        PRINT_ACTIVITY_RESPECTS_ORIENTATION = z;
        if (VERSION.SDK_INT != 23) {
            z2 = true;
        }
        IS_MIN_MARGINS_HANDLING_CORRECT = z2;
    }

    public PrintHelper(Context context) {
        this.mContext = context;
    }

    static Bitmap convertBitmapForColorMode(Bitmap bitmap, int i) {
        if (i != 1) {
            return bitmap;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        canvas.setBitmap(null);
        return createBitmap;
    }

    private static PrintAttributes.Builder copyAttributes(PrintAttributes printAttributes) {
        PrintAttributes.Builder minMargins = new PrintAttributes.Builder().setMediaSize(printAttributes.getMediaSize()).setResolution(printAttributes.getResolution()).setMinMargins(printAttributes.getMinMargins());
        if (printAttributes.getColorMode() != 0) {
            minMargins.setColorMode(printAttributes.getColorMode());
        }
        if (VERSION.SDK_INT >= 23 && printAttributes.getDuplexMode() != 0) {
            minMargins.setDuplexMode(printAttributes.getDuplexMode());
        }
        return minMargins;
    }

    static Matrix getMatrix(int i, int i2, RectF rectF, int i3) {
        Matrix matrix = new Matrix();
        float f = (float) i;
        float width = rectF.width() / f;
        float max = i3 == 2 ? Math.max(width, rectF.height() / ((float) i2)) : Math.min(width, rectF.height() / ((float) i2));
        matrix.postScale(max, max);
        matrix.postTranslate((rectF.width() - (f * max)) / 2.0f, (rectF.height() - (((float) i2) * max)) / 2.0f);
        return matrix;
    }

    static boolean isPortrait(Bitmap bitmap) {
        return bitmap.getWidth() <= bitmap.getHeight();
    }

    private Bitmap loadBitmap(Uri uri, Options options) {
        Throwable th;
        String str = "close fail ";
        String str2 = LOG_TAG;
        if (uri != null) {
            Context context = this.mContext;
            if (context != null) {
                InputStream inputStream = null;
                try {
                    InputStream openInputStream = context.getContentResolver().openInputStream(uri);
                    try {
                        Bitmap decodeStream = BitmapFactory.decodeStream(openInputStream, null, options);
                        if (openInputStream != null) {
                            try {
                                openInputStream.close();
                            } catch (Throwable e) {
                                Log.w(str2, str, e);
                            }
                        }
                        return decodeStream;
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = openInputStream;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable e2) {
                                Log.w(str2, str, e2);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    throw th;
                }
            }
        }
        throw new IllegalArgumentException("bad argument to loadBitmap");
    }

    public static boolean systemSupportsPrint() {
        return VERSION.SDK_INT >= 19;
    }

    public int getColorMode() {
        return this.mColorMode;
    }

    public int getOrientation() {
        return (VERSION.SDK_INT < 19 || this.mOrientation != 0) ? this.mOrientation : 1;
    }

    public int getScaleMode() {
        return this.mScaleMode;
    }

    Bitmap loadConstrainedBitmap(Uri uri) {
        if (uri == null || this.mContext == null) {
            throw new IllegalArgumentException("bad argument to getScaledBitmap");
        }
        Options options = new Options();
        options.inJustDecodeBounds = true;
        loadBitmap(uri, options);
        int i = options.outWidth;
        int i2 = options.outHeight;
        if (i > 0) {
            if (i2 > 0) {
                int max = Math.max(i, i2);
                int i3 = 1;
                while (max > MAX_PRINT_SIZE) {
                    max >>>= 1;
                    i3 <<= 1;
                }
                if (i3 > 0) {
                    if (Math.min(i, i2) / i3 > 0) {
                        Options options2;
                        synchronized (this.mLock) {
                            this.mDecodeOptions = new Options();
                            this.mDecodeOptions.inMutable = true;
                            this.mDecodeOptions.inSampleSize = i3;
                            options2 = this.mDecodeOptions;
                        }
                        try {
                            Bitmap loadBitmap = loadBitmap(uri, options2);
                            synchronized (this.mLock) {
                                this.mDecodeOptions = null;
                            }
                            return loadBitmap;
                        } catch (Throwable th) {
                            synchronized (this.mLock) {
                                this.mDecodeOptions = null;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public void printBitmap(String str, Bitmap bitmap) {
        printBitmap(str, bitmap, null);
    }

    public void printBitmap(String str, Bitmap bitmap, OnPrintFinishCallback onPrintFinishCallback) {
        if (VERSION.SDK_INT < 19) {
            return;
        }
        if (bitmap != null) {
            ((PrintManager) this.mContext.getSystemService("print")).print(str, new PrintBitmapAdapter(str, this.mScaleMode, bitmap, onPrintFinishCallback), new PrintAttributes.Builder().setMediaSize(isPortrait(bitmap) ? MediaSize.UNKNOWN_PORTRAIT : MediaSize.UNKNOWN_LANDSCAPE).setColorMode(this.mColorMode).build());
        }
    }

    public void printBitmap(String str, Uri uri) {
        printBitmap(str, uri, null);
    }

    public void printBitmap(String str, Uri uri, OnPrintFinishCallback onPrintFinishCallback) {
        if (VERSION.SDK_INT >= 19) {
            MediaSize mediaSize;
            PrintDocumentAdapter printUriAdapter = new PrintUriAdapter(str, uri, onPrintFinishCallback, this.mScaleMode);
            PrintManager printManager = (PrintManager) this.mContext.getSystemService("print");
            PrintAttributes.Builder builder = new PrintAttributes.Builder();
            builder.setColorMode(this.mColorMode);
            int i = this.mOrientation;
            if (i != 1) {
                if (i != 0) {
                    if (i == 2) {
                        mediaSize = MediaSize.UNKNOWN_PORTRAIT;
                        builder.setMediaSize(mediaSize);
                    }
                    printManager.print(str, printUriAdapter, builder.build());
                }
            }
            mediaSize = MediaSize.UNKNOWN_LANDSCAPE;
            builder.setMediaSize(mediaSize);
            printManager.print(str, printUriAdapter, builder.build());
        }
    }

    public void setColorMode(int i) {
        this.mColorMode = i;
    }

    public void setOrientation(int i) {
        this.mOrientation = i;
    }

    public void setScaleMode(int i) {
        this.mScaleMode = i;
    }

    void writeBitmap(PrintAttributes printAttributes, int i, Bitmap bitmap, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, WriteResultCallback writeResultCallback) {
        final PrintAttributes build = IS_MIN_MARGINS_HANDLING_CORRECT ? printAttributes : copyAttributes(printAttributes).setMinMargins(new Margins(0, 0, 0, 0)).build();
        final CancellationSignal cancellationSignal2 = cancellationSignal;
        final Bitmap bitmap2 = bitmap;
        final PrintAttributes printAttributes2 = printAttributes;
        final int i2 = i;
        final ParcelFileDescriptor parcelFileDescriptor2 = parcelFileDescriptor;
        final WriteResultCallback writeResultCallback2 = writeResultCallback;
        new AsyncTask<Void, Void, Throwable>() {
            protected java.lang.Throwable doInBackground(java.lang.Void... r8) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
                /*
                r7 = this;
                r8 = r4;	 Catch:{ Throwable -> 0x00e2 }
                r8 = r8.isCanceled();	 Catch:{ Throwable -> 0x00e2 }
                r0 = 0;	 Catch:{ Throwable -> 0x00e2 }
                if (r8 == 0) goto L_0x000a;	 Catch:{ Throwable -> 0x00e2 }
            L_0x0009:
                return r0;	 Catch:{ Throwable -> 0x00e2 }
            L_0x000a:
                r8 = new android.print.pdf.PrintedPdfDocument;	 Catch:{ Throwable -> 0x00e2 }
                r1 = android.support.v4.print.PrintHelper.this;	 Catch:{ Throwable -> 0x00e2 }
                r1 = r1.mContext;	 Catch:{ Throwable -> 0x00e2 }
                r2 = r5;	 Catch:{ Throwable -> 0x00e2 }
                r8.<init>(r1, r2);	 Catch:{ Throwable -> 0x00e2 }
                r1 = r6;	 Catch:{ Throwable -> 0x00e2 }
                r2 = r5;	 Catch:{ Throwable -> 0x00e2 }
                r2 = r2.getColorMode();	 Catch:{ Throwable -> 0x00e2 }
                r1 = android.support.v4.print.PrintHelper.convertBitmapForColorMode(r1, r2);	 Catch:{ Throwable -> 0x00e2 }
                r2 = r4;	 Catch:{ Throwable -> 0x00e2 }
                r2 = r2.isCanceled();	 Catch:{ Throwable -> 0x00e2 }
                if (r2 == 0) goto L_0x002a;
            L_0x0029:
                return r0;
            L_0x002a:
                r2 = 1;
                r3 = r8.startPage(r2);	 Catch:{ all -> 0x00cd }
                r4 = android.support.v4.print.PrintHelper.IS_MIN_MARGINS_HANDLING_CORRECT;	 Catch:{ all -> 0x00cd }
                if (r4 == 0) goto L_0x0041;	 Catch:{ all -> 0x00cd }
            L_0x0033:
                r2 = new android.graphics.RectF;	 Catch:{ all -> 0x00cd }
                r4 = r3.getInfo();	 Catch:{ all -> 0x00cd }
                r4 = r4.getContentRect();	 Catch:{ all -> 0x00cd }
                r2.<init>(r4);	 Catch:{ all -> 0x00cd }
                goto L_0x0064;	 Catch:{ all -> 0x00cd }
            L_0x0041:
                r4 = new android.print.pdf.PrintedPdfDocument;	 Catch:{ all -> 0x00cd }
                r5 = android.support.v4.print.PrintHelper.this;	 Catch:{ all -> 0x00cd }
                r5 = r5.mContext;	 Catch:{ all -> 0x00cd }
                r6 = r7;	 Catch:{ all -> 0x00cd }
                r4.<init>(r5, r6);	 Catch:{ all -> 0x00cd }
                r2 = r4.startPage(r2);	 Catch:{ all -> 0x00cd }
                r5 = new android.graphics.RectF;	 Catch:{ all -> 0x00cd }
                r6 = r2.getInfo();	 Catch:{ all -> 0x00cd }
                r6 = r6.getContentRect();	 Catch:{ all -> 0x00cd }
                r5.<init>(r6);	 Catch:{ all -> 0x00cd }
                r4.finishPage(r2);	 Catch:{ all -> 0x00cd }
                r4.close();	 Catch:{ all -> 0x00cd }
                r2 = r5;	 Catch:{ all -> 0x00cd }
            L_0x0064:
                r4 = r1.getWidth();	 Catch:{ all -> 0x00cd }
                r5 = r1.getHeight();	 Catch:{ all -> 0x00cd }
                r6 = r8;	 Catch:{ all -> 0x00cd }
                r4 = android.support.v4.print.PrintHelper.getMatrix(r4, r5, r2, r6);	 Catch:{ all -> 0x00cd }
                r5 = android.support.v4.print.PrintHelper.IS_MIN_MARGINS_HANDLING_CORRECT;	 Catch:{ all -> 0x00cd }
                if (r5 == 0) goto L_0x0077;	 Catch:{ all -> 0x00cd }
            L_0x0076:
                goto L_0x0085;	 Catch:{ all -> 0x00cd }
            L_0x0077:
                r5 = r2.left;	 Catch:{ all -> 0x00cd }
                r6 = r2.top;	 Catch:{ all -> 0x00cd }
                r4.postTranslate(r5, r6);	 Catch:{ all -> 0x00cd }
                r5 = r3.getCanvas();	 Catch:{ all -> 0x00cd }
                r5.clipRect(r2);	 Catch:{ all -> 0x00cd }
            L_0x0085:
                r2 = r3.getCanvas();	 Catch:{ all -> 0x00cd }
                r2.drawBitmap(r1, r4, r0);	 Catch:{ all -> 0x00cd }
                r8.finishPage(r3);	 Catch:{ all -> 0x00cd }
                r2 = r4;	 Catch:{ all -> 0x00cd }
                r2 = r2.isCanceled();	 Catch:{ all -> 0x00cd }
                if (r2 == 0) goto L_0x00ab;
            L_0x0097:
                r8.close();	 Catch:{ Throwable -> 0x00e2 }
                r8 = r9;	 Catch:{ Throwable -> 0x00e2 }
                if (r8 == 0) goto L_0x00a3;
            L_0x009e:
                r8 = r9;	 Catch:{ IOException -> 0x00a3 }
                r8.close();	 Catch:{ IOException -> 0x00a3 }
            L_0x00a3:
                r8 = r6;	 Catch:{ Throwable -> 0x00e2 }
                if (r1 == r8) goto L_0x00aa;	 Catch:{ Throwable -> 0x00e2 }
            L_0x00a7:
                r1.recycle();	 Catch:{ Throwable -> 0x00e2 }
            L_0x00aa:
                return r0;
            L_0x00ab:
                r2 = new java.io.FileOutputStream;	 Catch:{ all -> 0x00cd }
                r3 = r9;	 Catch:{ all -> 0x00cd }
                r3 = r3.getFileDescriptor();	 Catch:{ all -> 0x00cd }
                r2.<init>(r3);	 Catch:{ all -> 0x00cd }
                r8.writeTo(r2);	 Catch:{ all -> 0x00cd }
                r8.close();	 Catch:{ Throwable -> 0x00e2 }
                r8 = r9;	 Catch:{ Throwable -> 0x00e2 }
                if (r8 == 0) goto L_0x00c5;
            L_0x00c0:
                r8 = r9;	 Catch:{ IOException -> 0x00c5 }
                r8.close();	 Catch:{ IOException -> 0x00c5 }
            L_0x00c5:
                r8 = r6;	 Catch:{ Throwable -> 0x00e2 }
                if (r1 == r8) goto L_0x00cc;	 Catch:{ Throwable -> 0x00e2 }
            L_0x00c9:
                r1.recycle();	 Catch:{ Throwable -> 0x00e2 }
            L_0x00cc:
                return r0;	 Catch:{ Throwable -> 0x00e2 }
            L_0x00cd:
                r0 = move-exception;	 Catch:{ Throwable -> 0x00e2 }
                r8.close();	 Catch:{ Throwable -> 0x00e2 }
                r8 = r9;	 Catch:{ Throwable -> 0x00e2 }
                if (r8 == 0) goto L_0x00da;
            L_0x00d5:
                r8 = r9;	 Catch:{ IOException -> 0x00da }
                r8.close();	 Catch:{ IOException -> 0x00da }
            L_0x00da:
                r8 = r6;	 Catch:{ Throwable -> 0x00e2 }
                if (r1 == r8) goto L_0x00e1;	 Catch:{ Throwable -> 0x00e2 }
            L_0x00de:
                r1.recycle();	 Catch:{ Throwable -> 0x00e2 }
            L_0x00e1:
                throw r0;	 Catch:{ Throwable -> 0x00e2 }
            L_0x00e2:
                r8 = move-exception;
                return r8;
                */
                throw new UnsupportedOperationException("Method not decompiled: android.support.v4.print.PrintHelper.1.doInBackground(java.lang.Void[]):java.lang.Throwable");
            }

            protected void onPostExecute(Throwable th) {
                if (cancellationSignal2.isCanceled()) {
                    writeResultCallback2.onWriteCancelled();
                } else if (th == null) {
                    writeResultCallback2.onWriteFinished(new PageRange[]{PageRange.ALL_PAGES});
                } else {
                    Log.e(PrintHelper.LOG_TAG, "Error writing printed content", th);
                    writeResultCallback2.onWriteFailed(null);
                }
            }
        }.execute(new Void[0]);
    }
}
