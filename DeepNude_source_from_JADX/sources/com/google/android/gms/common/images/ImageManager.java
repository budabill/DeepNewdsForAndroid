package com.google.android.gms.common.images;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.util.LruCache;
import android.widget.ImageView;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbgk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageManager {
    private static final Object zzgdb = new Object();
    private static HashSet<Uri> zzgdc = new HashSet();
    private static ImageManager zzgdd;
    private final Context mContext;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final ExecutorService zzgde = Executors.newFixedThreadPool(4);
    private final zza zzgdf = null;
    private final zzbgk zzgdg = new zzbgk();
    private final Map<zza, ImageReceiver> zzgdh = new HashMap();
    private final Map<Uri, ImageReceiver> zzgdi = new HashMap();
    private final Map<Uri, Long> zzgdj = new HashMap();

    @KeepName
    final class ImageReceiver extends ResultReceiver {
        private final Uri mUri;
        private final ArrayList<zza> zzgdk = new ArrayList();
        private /* synthetic */ ImageManager zzgdl;

        ImageReceiver(ImageManager imageManager, Uri uri) {
            this.zzgdl = imageManager;
            super(new Handler(Looper.getMainLooper()));
            this.mUri = uri;
        }

        public final void onReceiveResult(int i, Bundle bundle) {
            this.zzgdl.zzgde.execute(new zzb(this.zzgdl, this.mUri, (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }

        public final void zzalm() {
            Intent intent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
            intent.putExtra("com.google.android.gms.extras.uri", this.mUri);
            intent.putExtra("com.google.android.gms.extras.resultReceiver", this);
            intent.putExtra("com.google.android.gms.extras.priority", 3);
            this.zzgdl.mContext.sendBroadcast(intent);
        }

        public final void zzb(zza zza) {
            com.google.android.gms.common.internal.zzc.zzgn("ImageReceiver.addImageRequest() must be called in the main thread");
            this.zzgdk.add(zza);
        }

        public final void zzc(zza zza) {
            com.google.android.gms.common.internal.zzc.zzgn("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.zzgdk.remove(zza);
        }
    }

    public interface OnImageLoadedListener {
        void onImageLoaded(Uri uri, Drawable drawable, boolean z);
    }

    final class zzb implements Runnable {
        private final Uri mUri;
        private /* synthetic */ ImageManager zzgdl;
        private final ParcelFileDescriptor zzgdm;

        public zzb(ImageManager imageManager, Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.zzgdl = imageManager;
            this.mUri = uri;
            this.zzgdm = parcelFileDescriptor;
        }

        public final void run() {
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
            r12 = this;
            r0 = android.os.Looper.getMainLooper();
            r0 = r0.getThread();
            r1 = java.lang.Thread.currentThread();
            if (r0 == r1) goto L_0x0099;
        L_0x000e:
            r0 = 0;
            r1 = 0;
            r2 = r12.zzgdm;
            r3 = 1;
            r4 = "ImageManager";
            if (r2 == 0) goto L_0x0055;
        L_0x0017:
            r2 = r2.getFileDescriptor();	 Catch:{ OutOfMemoryError -> 0x0020 }
            r1 = android.graphics.BitmapFactory.decodeFileDescriptor(r2);	 Catch:{ OutOfMemoryError -> 0x0020 }
            goto L_0x0046;
        L_0x0020:
            r0 = move-exception;
            r2 = r12.mUri;
            r2 = java.lang.String.valueOf(r2);
            r5 = java.lang.String.valueOf(r2);
            r5 = r5.length();
            r5 = r5 + 34;
            r6 = new java.lang.StringBuilder;
            r6.<init>(r5);
            r5 = "OOM while loading bitmap for uri: ";
            r6.append(r5);
            r6.append(r2);
            r2 = r6.toString();
            android.util.Log.e(r4, r2, r0);
            r0 = 1;
        L_0x0046:
            r2 = r12.zzgdm;	 Catch:{ IOException -> 0x004c }
            r2.close();	 Catch:{ IOException -> 0x004c }
            goto L_0x0052;
        L_0x004c:
            r2 = move-exception;
            r5 = "closed failed";
            android.util.Log.e(r4, r5, r2);
        L_0x0052:
            r10 = r0;
            r9 = r1;
            goto L_0x0057;
        L_0x0055:
            r9 = r1;
            r10 = 0;
        L_0x0057:
            r0 = new java.util.concurrent.CountDownLatch;
            r0.<init>(r3);
            r1 = r12.zzgdl;
            r1 = r1.mHandler;
            r2 = new com.google.android.gms.common.images.ImageManager$zzd;
            r7 = r12.zzgdl;
            r8 = r12.mUri;
            r6 = r2;
            r11 = r0;
            r6.<init>(r7, r8, r9, r10, r11);
            r1.post(r2);
            r0.await();	 Catch:{ InterruptedException -> 0x0074 }
            return;
        L_0x0074:
            r0 = r12.mUri;
            r0 = java.lang.String.valueOf(r0);
            r1 = java.lang.String.valueOf(r0);
            r1 = r1.length();
            r1 = r1 + 32;
            r2 = new java.lang.StringBuilder;
            r2.<init>(r1);
            r1 = "Latch interrupted while posting ";
            r2.append(r1);
            r2.append(r0);
            r0 = r2.toString();
            android.util.Log.w(r4, r0);
            return;
        L_0x0099:
            r0 = java.lang.Thread.currentThread();
            r0 = java.lang.String.valueOf(r0);
            r1 = android.os.Looper.getMainLooper();
            r1 = r1.getThread();
            r1 = java.lang.String.valueOf(r1);
            r2 = java.lang.String.valueOf(r0);
            r2 = r2.length();
            r2 = r2 + 56;
            r3 = java.lang.String.valueOf(r1);
            r3 = r3.length();
            r2 = r2 + r3;
            r3 = new java.lang.StringBuilder;
            r3.<init>(r2);
            r2 = "checkNotMainThread: current thread ";
            r3.append(r2);
            r3.append(r0);
            r0 = " IS the main thread ";
            r3.append(r0);
            r3.append(r1);
            r0 = "!";
            r3.append(r0);
            r0 = r3.toString();
            r1 = "Asserts";
            android.util.Log.e(r1, r0);
            r0 = new java.lang.IllegalStateException;
            r1 = "LoadBitmapFromDiskRunnable can't be executed in the main thread";
            r0.<init>(r1);
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.images.ImageManager.zzb.run():void");
        }
    }

    final class zzc implements Runnable {
        private /* synthetic */ ImageManager zzgdl;
        private final zza zzgdn;

        public zzc(ImageManager imageManager, zza zza) {
            this.zzgdl = imageManager;
            this.zzgdn = zza;
        }

        public final void run() {
            com.google.android.gms.common.internal.zzc.zzgn("LoadImageRunnable must be executed on the main thread");
            ImageReceiver imageReceiver = (ImageReceiver) this.zzgdl.zzgdh.get(this.zzgdn);
            if (imageReceiver != null) {
                this.zzgdl.zzgdh.remove(this.zzgdn);
                imageReceiver.zzc(this.zzgdn);
            }
            zza zza = this.zzgdn;
            zzb zzb = zza.zzgdp;
            if (zzb.uri == null) {
                zza.zza(this.zzgdl.mContext, this.zzgdl.zzgdg, true);
                return;
            }
            Bitmap zza2 = this.zzgdl.zza(zzb);
            if (zza2 != null) {
                this.zzgdn.zza(this.zzgdl.mContext, zza2, true);
                return;
            }
            Long l = (Long) this.zzgdl.zzgdj.get(zzb.uri);
            if (l != null) {
                if (SystemClock.elapsedRealtime() - l.longValue() < 3600000) {
                    this.zzgdn.zza(this.zzgdl.mContext, this.zzgdl.zzgdg, true);
                    return;
                }
                this.zzgdl.zzgdj.remove(zzb.uri);
            }
            this.zzgdn.zza(this.zzgdl.mContext, this.zzgdl.zzgdg);
            imageReceiver = (ImageReceiver) this.zzgdl.zzgdi.get(zzb.uri);
            if (imageReceiver == null) {
                imageReceiver = new ImageReceiver(this.zzgdl, zzb.uri);
                this.zzgdl.zzgdi.put(zzb.uri, imageReceiver);
            }
            imageReceiver.zzb(this.zzgdn);
            if (!(this.zzgdn instanceof zzd)) {
                this.zzgdl.zzgdh.put(this.zzgdn, imageReceiver);
            }
            synchronized (ImageManager.zzgdb) {
                if (!ImageManager.zzgdc.contains(zzb.uri)) {
                    ImageManager.zzgdc.add(zzb.uri);
                    imageReceiver.zzalm();
                }
            }
        }
    }

    final class zzd implements Runnable {
        private final Bitmap mBitmap;
        private final Uri mUri;
        private final CountDownLatch zzapc;
        private /* synthetic */ ImageManager zzgdl;
        private boolean zzgdo;

        public zzd(ImageManager imageManager, Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.zzgdl = imageManager;
            this.mUri = uri;
            this.mBitmap = bitmap;
            this.zzgdo = z;
            this.zzapc = countDownLatch;
        }

        public final void run() {
            com.google.android.gms.common.internal.zzc.zzgn("OnBitmapLoadedRunnable must be executed in the main thread");
            Object obj = this.mBitmap != null ? 1 : null;
            if (this.zzgdl.zzgdf != null) {
                if (this.zzgdo) {
                    this.zzgdl.zzgdf.evictAll();
                    System.gc();
                    this.zzgdo = false;
                    this.zzgdl.mHandler.post(this);
                    return;
                } else if (obj != null) {
                    this.zzgdl.zzgdf.put(new zzb(this.mUri), this.mBitmap);
                }
            }
            ImageReceiver imageReceiver = (ImageReceiver) this.zzgdl.zzgdi.remove(this.mUri);
            if (imageReceiver != null) {
                ArrayList zza = imageReceiver.zzgdk;
                int size = zza.size();
                for (int i = 0; i < size; i++) {
                    zza zza2 = (zza) zza.get(i);
                    if (obj != null) {
                        zza2.zza(this.zzgdl.mContext, this.mBitmap, false);
                    } else {
                        this.zzgdl.zzgdj.put(this.mUri, Long.valueOf(SystemClock.elapsedRealtime()));
                        zza2.zza(this.zzgdl.mContext, this.zzgdl.zzgdg, false);
                    }
                    if (!(zza2 instanceof zzd)) {
                        this.zzgdl.zzgdh.remove(zza2);
                    }
                }
            }
            this.zzapc.countDown();
            synchronized (ImageManager.zzgdb) {
                ImageManager.zzgdc.remove(this.mUri);
            }
        }
    }

    static final class zza extends LruCache<zzb, Bitmap> {
        protected final /* synthetic */ void entryRemoved(boolean z, Object obj, Object obj2, Object obj3) {
            super.entryRemoved(z, (zzb) obj, (Bitmap) obj2, (Bitmap) obj3);
        }

        protected final /* synthetic */ int sizeOf(Object obj, Object obj2) {
            Bitmap bitmap = (Bitmap) obj2;
            return bitmap.getHeight() * bitmap.getRowBytes();
        }
    }

    private ImageManager(Context context, boolean z) {
        this.mContext = context.getApplicationContext();
    }

    public static ImageManager create(Context context) {
        if (zzgdd == null) {
            zzgdd = new ImageManager(context, false);
        }
        return zzgdd;
    }

    private final Bitmap zza(zzb zzb) {
        LruCache lruCache = this.zzgdf;
        return lruCache == null ? null : (Bitmap) lruCache.get(zzb);
    }

    @Hide
    private final void zza(zza zza) {
        com.google.android.gms.common.internal.zzc.zzgn("ImageManager.loadImage() must be called in the main thread");
        new zzc(this, zza).run();
    }

    public final void loadImage(ImageView imageView, int i) {
        zza(new zzc(imageView, i));
    }

    public final void loadImage(ImageView imageView, Uri uri) {
        zza(new zzc(imageView, uri));
    }

    public final void loadImage(ImageView imageView, Uri uri, int i) {
        zza zzc = new zzc(imageView, uri);
        zzc.zzgdr = i;
        zza(zzc);
    }

    public final void loadImage(OnImageLoadedListener onImageLoadedListener, Uri uri) {
        zza(new zzd(onImageLoadedListener, uri));
    }

    public final void loadImage(OnImageLoadedListener onImageLoadedListener, Uri uri, int i) {
        zza zzd = new zzd(onImageLoadedListener, uri);
        zzd.zzgdr = i;
        zza(zzd);
    }
}
