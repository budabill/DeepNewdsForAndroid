package com.google.android.gms.internal;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class zzflp implements Cloneable {
    private Object value;
    private zzfln<?, ?> zzpvr;
    private List<zzflu> zzpvs = new ArrayList();

    zzflp() {
    }

    private final byte[] toByteArray() {
        byte[] bArr = new byte[zzq()];
        zza(zzflk.zzbf(bArr));
        return bArr;
    }

    private zzflp zzdcm() {
        zzflp zzflp = new zzflp();
        try {
            zzflp.zzpvr = this.zzpvr;
            if (this.zzpvs == null) {
                zzflp.zzpvs = null;
            } else {
                zzflp.zzpvs.addAll(this.zzpvs);
            }
            if (this.value != null) {
                Object obj;
                if (this.value instanceof zzfls) {
                    obj = (zzfls) ((zzfls) this.value).clone();
                } else if (this.value instanceof byte[]) {
                    obj = ((byte[]) this.value).clone();
                } else {
                    int i = 0;
                    Object obj2;
                    if (this.value instanceof byte[][]) {
                        byte[][] bArr = (byte[][]) this.value;
                        obj2 = new byte[bArr.length][];
                        zzflp.value = obj2;
                        while (i < bArr.length) {
                            obj2[i] = (byte[]) bArr[i].clone();
                            i++;
                        }
                    } else if (this.value instanceof boolean[]) {
                        obj = ((boolean[]) this.value).clone();
                    } else if (this.value instanceof int[]) {
                        obj = ((int[]) this.value).clone();
                    } else if (this.value instanceof long[]) {
                        obj = ((long[]) this.value).clone();
                    } else if (this.value instanceof float[]) {
                        obj = ((float[]) this.value).clone();
                    } else if (this.value instanceof double[]) {
                        obj = ((double[]) this.value).clone();
                    } else if (this.value instanceof zzfls[]) {
                        zzfls[] zzflsArr = (zzfls[]) this.value;
                        obj2 = new zzfls[zzflsArr.length];
                        zzflp.value = obj2;
                        while (i < zzflsArr.length) {
                            obj2[i] = (zzfls) zzflsArr[i].clone();
                            i++;
                        }
                    }
                }
                zzflp.value = obj;
            }
            return zzflp;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final /* synthetic */ Object clone() {
        return zzdcm();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzflp)) {
            return false;
        }
        zzflp zzflp = (zzflp) obj;
        if (this.value == null || zzflp.value == null) {
            List list = this.zzpvs;
            if (list != null) {
                List list2 = zzflp.zzpvs;
                if (list2 != null) {
                    return list.equals(list2);
                }
            }
            try {
                return Arrays.equals(toByteArray(), zzflp.toByteArray());
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
        zzfln zzfln = this.zzpvr;
        if (zzfln != zzflp.zzpvr) {
            return false;
        }
        if (!zzfln.zznro.isArray()) {
            return this.value.equals(zzflp.value);
        }
        Object obj2 = this.value;
        return obj2 instanceof byte[] ? Arrays.equals((byte[]) obj2, (byte[]) zzflp.value) : obj2 instanceof int[] ? Arrays.equals((int[]) obj2, (int[]) zzflp.value) : obj2 instanceof long[] ? Arrays.equals((long[]) obj2, (long[]) zzflp.value) : obj2 instanceof float[] ? Arrays.equals((float[]) obj2, (float[]) zzflp.value) : obj2 instanceof double[] ? Arrays.equals((double[]) obj2, (double[]) zzflp.value) : obj2 instanceof boolean[] ? Arrays.equals((boolean[]) obj2, (boolean[]) zzflp.value) : Arrays.deepEquals((Object[]) obj2, (Object[]) zzflp.value);
    }

    public final int hashCode() {
        try {
            return Arrays.hashCode(toByteArray()) + 527;
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    final void zza(zzflk zzflk) {
        Object obj = this.value;
        if (obj != null) {
            zzfln zzfln = this.zzpvr;
            if (zzfln.zzpvm) {
                int length = Array.getLength(obj);
                for (int i = 0; i < length; i++) {
                    Object obj2 = Array.get(obj, i);
                    if (obj2 != null) {
                        zzfln.zza(obj2, zzflk);
                    }
                }
                return;
            }
            zzfln.zza(obj, zzflk);
            return;
        }
        for (zzflu zzflu : this.zzpvs) {
            zzflk.zzmy(zzflu.tag);
            zzflk.zzbh(zzflu.zzjwl);
        }
    }

    final void zza(zzflu zzflu) {
        this.zzpvs.add(zzflu);
    }

    final <T> T zzb(zzfln<?, T> zzfln) {
        if (this.value == null) {
            this.zzpvr = zzfln;
            this.value = zzfln.zzbq(this.zzpvs);
            this.zzpvs = null;
        } else if (!this.zzpvr.equals(zzfln)) {
            throw new IllegalStateException("Tried to getExtension with a different Extension.");
        }
        return this.value;
    }

    final int zzq() {
        Object obj = this.value;
        int i = 0;
        int i2;
        if (obj != null) {
            zzfln zzfln = this.zzpvr;
            if (!zzfln.zzpvm) {
                return zzfln.zzcw(obj);
            }
            int length = Array.getLength(obj);
            i2 = 0;
            while (i < length) {
                if (Array.get(obj, i) != null) {
                    i2 += zzfln.zzcw(Array.get(obj, i));
                }
                i++;
            }
            return i2;
        }
        i2 = 0;
        for (zzflu zzflu : this.zzpvs) {
            i2 += (zzflk.zzmf(zzflu.tag) + 0) + zzflu.zzjwl.length;
        }
        return i2;
    }
}
