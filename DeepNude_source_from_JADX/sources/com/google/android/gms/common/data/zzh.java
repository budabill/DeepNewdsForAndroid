package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.Hide;
import java.util.NoSuchElementException;

@Hide
public final class zzh<T> extends zzb<T> {
    private T zzgda;

    public zzh(DataBuffer<T> dataBuffer) {
        super(dataBuffer);
    }

    public final T next() {
        if (hasNext()) {
            this.zzgcf++;
            int i = this.zzgcf;
            if (i == 0) {
                this.zzgda = this.zzgce.get(0);
                Object obj = this.zzgda;
                if (!(obj instanceof zzc)) {
                    String valueOf = String.valueOf(obj.getClass());
                    StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 44);
                    stringBuilder.append("DataBuffer reference of type ");
                    stringBuilder.append(valueOf);
                    stringBuilder.append(" is not movable");
                    throw new IllegalStateException(stringBuilder.toString());
                }
            } else {
                ((zzc) this.zzgda).zzbw(i);
            }
            return this.zzgda;
        }
        int i2 = this.zzgcf;
        stringBuilder = new StringBuilder(46);
        stringBuilder.append("Cannot advance the iterator beyond ");
        stringBuilder.append(i2);
        throw new NoSuchElementException(stringBuilder.toString());
    }
}
