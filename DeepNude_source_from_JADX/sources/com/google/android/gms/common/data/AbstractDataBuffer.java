package com.google.android.gms.common.data;

import android.os.Bundle;
import com.google.android.gms.common.internal.Hide;
import java.util.Iterator;

public abstract class AbstractDataBuffer<T> implements DataBuffer<T> {
    @Hide
    protected final DataHolder zzfxb;

    @Hide
    protected AbstractDataBuffer(DataHolder dataHolder) {
        this.zzfxb = dataHolder;
    }

    @Deprecated
    public final void close() {
        release();
    }

    public abstract T get(int i);

    public int getCount() {
        DataHolder dataHolder = this.zzfxb;
        return dataHolder == null ? 0 : dataHolder.zzgcq;
    }

    @Deprecated
    public boolean isClosed() {
        DataHolder dataHolder = this.zzfxb;
        if (dataHolder != null) {
            if (!dataHolder.isClosed()) {
                return false;
            }
        }
        return true;
    }

    public Iterator<T> iterator() {
        return new zzb(this);
    }

    public void release() {
        DataHolder dataHolder = this.zzfxb;
        if (dataHolder != null) {
            dataHolder.close();
        }
    }

    public Iterator<T> singleRefIterator() {
        return new zzh(this);
    }

    @Hide
    public final Bundle zzahs() {
        return this.zzfxb.zzahs();
    }
}
