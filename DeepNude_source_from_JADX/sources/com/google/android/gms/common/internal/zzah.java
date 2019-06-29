package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import java.util.Arrays;

public final class zzah {
    private final ComponentName mComponentName;
    private final String zzdxe;
    private final String zzggu;
    private final int zzggv;

    public zzah(ComponentName componentName, int i) {
        this.zzdxe = null;
        this.zzggu = null;
        zzbq.checkNotNull(componentName);
        this.mComponentName = componentName;
        this.zzggv = 129;
    }

    public zzah(String str, String str2, int i) {
        zzbq.zzgv(str);
        this.zzdxe = str;
        zzbq.zzgv(str2);
        this.zzggu = str2;
        this.mComponentName = null;
        this.zzggv = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzah)) {
            return false;
        }
        zzah zzah = (zzah) obj;
        return zzbg.equal(this.zzdxe, zzah.zzdxe) && zzbg.equal(this.zzggu, zzah.zzggu) && zzbg.equal(this.mComponentName, zzah.mComponentName) && this.zzggv == zzah.zzggv;
    }

    public final ComponentName getComponentName() {
        return this.mComponentName;
    }

    public final String getPackage() {
        return this.zzggu;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzdxe, this.zzggu, this.mComponentName, Integer.valueOf(this.zzggv)});
    }

    public final String toString() {
        String str = this.zzdxe;
        return str == null ? this.mComponentName.flattenToString() : str;
    }

    public final int zzamu() {
        return this.zzggv;
    }

    public final Intent zzcq(Context context) {
        String str = this.zzdxe;
        return str != null ? new Intent(str).setPackage(this.zzggu) : new Intent().setComponent(this.mComponentName);
    }
}
