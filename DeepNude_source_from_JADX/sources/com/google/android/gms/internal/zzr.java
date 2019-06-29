package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.Collections;
import java.util.Map;

public abstract class zzr<T> implements Comparable<zzr<T>> {
    private final Object mLock;
    private final zza zzae;
    private final int zzaf;
    private final String zzag;
    private final int zzah;
    private zzy zzai;
    private Integer zzaj;
    private zzv zzak;
    private boolean zzal;
    private boolean zzam;
    private boolean zzan;
    private boolean zzao;
    private zzab zzap;
    private zzc zzaq;
    private zzt zzar;

    public zzr(int i, String str, zzy zzy) {
        this.zzae = zza.zzbk ? new zza() : null;
        this.mLock = new Object();
        this.zzal = true;
        int i2 = 0;
        this.zzam = false;
        this.zzan = false;
        this.zzao = false;
        this.zzaq = null;
        this.zzaf = i;
        this.zzag = str;
        this.zzai = zzy;
        this.zzap = new zzh();
        if (!TextUtils.isEmpty(str)) {
            Uri parse = Uri.parse(str);
            if (parse != null) {
                String host = parse.getHost();
                if (host != null) {
                    i2 = host.hashCode();
                }
            }
        }
        this.zzah = i2;
    }

    public /* synthetic */ int compareTo(Object obj) {
        zzr zzr = (zzr) obj;
        Enum enumR = zzu.NORMAL;
        return enumR == enumR ? this.zzaj.intValue() - zzr.zzaj.intValue() : enumR.ordinal() - enumR.ordinal();
    }

    public Map<String, String> getHeaders() {
        return Collections.emptyMap();
    }

    public final int getMethod() {
        return this.zzaf;
    }

    public final String getUrl() {
        return this.zzag;
    }

    public final boolean isCanceled() {
        synchronized (this.mLock) {
        }
        return false;
    }

    public String toString() {
        String valueOf = String.valueOf(Integer.toHexString(this.zzah));
        String str = "0x";
        valueOf = valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
        String str2 = "[ ] ";
        str = this.zzag;
        String valueOf2 = String.valueOf(zzu.NORMAL);
        String valueOf3 = String.valueOf(this.zzaj);
        StringBuilder stringBuilder = new StringBuilder(((((str2.length() + 3) + String.valueOf(str).length()) + String.valueOf(valueOf).length()) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length());
        stringBuilder.append(str2);
        stringBuilder.append(str);
        str2 = " ";
        stringBuilder.append(str2);
        stringBuilder.append(valueOf);
        stringBuilder.append(str2);
        stringBuilder.append(valueOf2);
        stringBuilder.append(str2);
        stringBuilder.append(valueOf3);
        return stringBuilder.toString();
    }

    public final zzr<?> zza(int i) {
        this.zzaj = Integer.valueOf(i);
        return this;
    }

    public final zzr<?> zza(zzc zzc) {
        this.zzaq = zzc;
        return this;
    }

    public final zzr<?> zza(zzv zzv) {
        this.zzak = zzv;
        return this;
    }

    protected abstract zzx<T> zza(zzp zzp);

    final void zza(zzt zzt) {
        synchronized (this.mLock) {
            this.zzar = zzt;
        }
    }

    final void zza(zzx<?> zzx) {
        synchronized (this.mLock) {
            zzt zzt = this.zzar;
        }
        if (zzt != null) {
            zzt.zza(this, zzx);
        }
    }

    protected abstract void zza(T t);

    public final void zzb(zzae zzae) {
        synchronized (this.mLock) {
            zzy zzy = this.zzai;
        }
        if (zzy != null) {
            zzy.zzd(zzae);
        }
    }

    public final void zzb(String str) {
        if (zza.zzbk) {
            this.zzae.zza(str, Thread.currentThread().getId());
        }
    }

    final void zzc(String str) {
        zzv zzv = this.zzak;
        if (zzv != null) {
            zzv.zzf(this);
        }
        if (zza.zzbk) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new zzs(this, str, id));
            } else {
                this.zzae.zza(str, id);
                this.zzae.zzc(toString());
            }
        }
    }

    public final int zzd() {
        return this.zzah;
    }

    public final zzc zze() {
        return this.zzaq;
    }

    public byte[] zzf() {
        return null;
    }

    public final boolean zzg() {
        return this.zzal;
    }

    public final int zzh() {
        return this.zzap.zzb();
    }

    public final zzab zzi() {
        return this.zzap;
    }

    public final void zzj() {
        synchronized (this.mLock) {
            this.zzan = true;
        }
    }

    public final boolean zzk() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzan;
        }
        return z;
    }

    final void zzl() {
        synchronized (this.mLock) {
            zzt zzt = this.zzar;
        }
        if (zzt != null) {
            zzt.zza(this);
        }
    }
}
