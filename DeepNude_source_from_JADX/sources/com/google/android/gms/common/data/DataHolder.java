package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzc;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@KeepName
@Hide
public final class DataHolder extends zzbgl implements Closeable {
    public static final Creator<DataHolder> CREATOR = new zzf();
    private static final zza zzgcs = new zze(new String[0], null);
    private boolean mClosed;
    private final int zzcc;
    private int zzehz;
    private final String[] zzgcl;
    private Bundle zzgcm;
    private final CursorWindow[] zzgcn;
    private final Bundle zzgco;
    private int[] zzgcp;
    int zzgcq;
    private boolean zzgcr;

    public static class zza {
        private final String[] zzgcl;
        private final ArrayList<HashMap<String, Object>> zzgct;
        private final String zzgcu;
        private final HashMap<Object, Integer> zzgcv;
        private boolean zzgcw;
        private String zzgcx;

        private zza(String[] strArr, String str) {
            zzbq.checkNotNull(strArr);
            this.zzgcl = strArr;
            this.zzgct = new ArrayList();
            this.zzgcu = str;
            this.zzgcv = new HashMap();
            this.zzgcw = false;
            this.zzgcx = null;
        }

        public zza zza(ContentValues contentValues) {
            zzc.zzv(contentValues);
            HashMap hashMap = new HashMap(contentValues.size());
            for (Entry entry : contentValues.valueSet()) {
                hashMap.put((String) entry.getKey(), entry.getValue());
            }
            return zza(hashMap);
        }

        public zza zza(HashMap<String, Object> hashMap) {
            int intValue;
            zzc.zzv(hashMap);
            String str = this.zzgcu;
            if (str != null) {
                Object obj = hashMap.get(str);
                if (obj != null) {
                    Integer num = (Integer) this.zzgcv.get(obj);
                    if (num == null) {
                        this.zzgcv.put(obj, Integer.valueOf(this.zzgct.size()));
                    } else {
                        intValue = num.intValue();
                        if (intValue != -1) {
                            this.zzgct.add(hashMap);
                        } else {
                            this.zzgct.remove(intValue);
                            this.zzgct.add(intValue, hashMap);
                        }
                        this.zzgcw = false;
                        return this;
                    }
                }
            }
            intValue = -1;
            if (intValue != -1) {
                this.zzgct.remove(intValue);
                this.zzgct.add(intValue, hashMap);
            } else {
                this.zzgct.add(hashMap);
            }
            this.zzgcw = false;
            return this;
        }

        public final DataHolder zzca(int i) {
            return new DataHolder(this);
        }
    }

    public static class zzb extends RuntimeException {
        public zzb(String str) {
            super(str);
        }
    }

    DataHolder(int i, String[] strArr, CursorWindow[] cursorWindowArr, int i2, Bundle bundle) {
        this.mClosed = false;
        this.zzgcr = true;
        this.zzehz = i;
        this.zzgcl = strArr;
        this.zzgcn = cursorWindowArr;
        this.zzcc = i2;
        this.zzgco = bundle;
    }

    private DataHolder(zza zza, int i, Bundle bundle) {
        this(zza.zzgcl, zza(zza, -1), i, null);
    }

    private DataHolder(String[] strArr, CursorWindow[] cursorWindowArr, int i, Bundle bundle) {
        this.mClosed = false;
        this.zzgcr = true;
        this.zzehz = 1;
        zzbq.checkNotNull(strArr);
        this.zzgcl = strArr;
        zzbq.checkNotNull(cursorWindowArr);
        this.zzgcn = cursorWindowArr;
        this.zzcc = i;
        this.zzgco = bundle;
        zzali();
    }

    private static CursorWindow[] zza(zza zza, int i) {
        int i2 = 0;
        if (zza.zzgcl.length == 0) {
            return new CursorWindow[0];
        }
        List zzb = zza.zzgct;
        int size = zzb.size();
        CursorWindow cursorWindow = new CursorWindow(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(cursorWindow);
        cursorWindow.setNumColumns(zza.zzgcl.length);
        CursorWindow cursorWindow2 = cursorWindow;
        int i3 = 0;
        Object obj = null;
        while (i3 < size) {
            String str = "DataHolder";
            if (!cursorWindow2.allocRow()) {
                try {
                    StringBuilder stringBuilder = new StringBuilder(72);
                    stringBuilder.append("Allocating additional cursor window for large data set (row ");
                    stringBuilder.append(i3);
                    stringBuilder.append(")");
                    Log.d(str, stringBuilder.toString());
                    cursorWindow2 = new CursorWindow(false);
                    cursorWindow2.setStartPosition(i3);
                    cursorWindow2.setNumColumns(zza.zzgcl.length);
                    arrayList.add(cursorWindow2);
                    if (!cursorWindow2.allocRow()) {
                        Log.e(str, "Unable to allocate row to hold data.");
                        arrayList.remove(cursorWindow2);
                        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
                    }
                } catch (RuntimeException e) {
                    i = arrayList.size();
                    while (i2 < i) {
                        ((CursorWindow) arrayList.get(i2)).close();
                        i2++;
                    }
                    throw e;
                }
            }
            Map map = (Map) zzb.get(i3);
            boolean z = true;
            for (int i4 = 0; i4 < zza.zzgcl.length && z; i4++) {
                String str2 = zza.zzgcl[i4];
                Object obj2 = map.get(str2);
                if (obj2 == null) {
                    z = cursorWindow2.putNull(i3, i4);
                } else if (obj2 instanceof String) {
                    z = cursorWindow2.putString((String) obj2, i3, i4);
                } else {
                    long longValue;
                    if (obj2 instanceof Long) {
                        longValue = ((Long) obj2).longValue();
                    } else if (obj2 instanceof Integer) {
                        z = cursorWindow2.putLong((long) ((Integer) obj2).intValue(), i3, i4);
                    } else if (obj2 instanceof Boolean) {
                        longValue = ((Boolean) obj2).booleanValue() ? 1 : 0;
                    } else if (obj2 instanceof byte[]) {
                        z = cursorWindow2.putBlob((byte[]) obj2, i3, i4);
                    } else if (obj2 instanceof Double) {
                        z = cursorWindow2.putDouble(((Double) obj2).doubleValue(), i3, i4);
                    } else if (obj2 instanceof Float) {
                        z = cursorWindow2.putDouble((double) ((Float) obj2).floatValue(), i3, i4);
                    } else {
                        String valueOf = String.valueOf(obj2);
                        StringBuilder stringBuilder2 = new StringBuilder((String.valueOf(str2).length() + 32) + String.valueOf(valueOf).length());
                        stringBuilder2.append("Unsupported object for column ");
                        stringBuilder2.append(str2);
                        stringBuilder2.append(": ");
                        stringBuilder2.append(valueOf);
                        throw new IllegalArgumentException(stringBuilder2.toString());
                    }
                    z = cursorWindow2.putLong(longValue, i3, i4);
                }
            }
            if (z) {
                obj = null;
            } else if (obj == null) {
                stringBuilder = new StringBuilder(74);
                stringBuilder.append("Couldn't populate window data for row ");
                stringBuilder.append(i3);
                stringBuilder.append(" - allocating new window.");
                Log.d(str, stringBuilder.toString());
                cursorWindow2.freeLastRow();
                cursorWindow2 = new CursorWindow(false);
                cursorWindow2.setStartPosition(i3);
                cursorWindow2.setNumColumns(zza.zzgcl.length);
                arrayList.add(cursorWindow2);
                i3--;
                obj = 1;
            } else {
                throw new zzb("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
            }
            i3++;
        }
        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
    }

    public static zza zzb(String[] strArr) {
        return new zza(strArr);
    }

    public static DataHolder zzbz(int i) {
        return new DataHolder(zzgcs, i, null);
    }

    private final void zzh(String str, int i) {
        Bundle bundle = this.zzgcm;
        if (bundle != null) {
            if (bundle.containsKey(str)) {
                if (isClosed()) {
                    throw new IllegalArgumentException("Buffer is closed.");
                } else if (i < 0 || i >= this.zzgcq) {
                    throw new CursorIndexOutOfBoundsException(i, this.zzgcq);
                } else {
                    return;
                }
            }
        }
        String str2 = "No such column: ";
        str = String.valueOf(str);
        throw new IllegalArgumentException(str.length() != 0 ? str2.concat(str) : new String(str2));
    }

    public final void close() {
        synchronized (this) {
            if (!this.mClosed) {
                this.mClosed = true;
                for (CursorWindow close : this.zzgcn) {
                    close.close();
                }
            }
        }
    }

    protected final void finalize() {
        try {
            if (this.zzgcr && this.zzgcn.length > 0 && !isClosed()) {
                close();
                String obj = toString();
                StringBuilder stringBuilder = new StringBuilder(String.valueOf(obj).length() + 178);
                stringBuilder.append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: ");
                stringBuilder.append(obj);
                stringBuilder.append(")");
                Log.e("DataBuffer", stringBuilder.toString());
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }

    public final int getCount() {
        return this.zzgcq;
    }

    public final int getStatusCode() {
        return this.zzcc;
    }

    public final boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.mClosed;
        }
        return z;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        zzbgo.zza(parcel, 1, this.zzgcl, false);
        zzbgo.zza(parcel, 2, this.zzgcn, i, false);
        zzbgo.zzc(parcel, 3, this.zzcc);
        zzbgo.zza(parcel, 4, this.zzgco, false);
        zzbgo.zzc(parcel, 1000, this.zzehz);
        zzbgo.zzai(parcel, zze);
        if ((i & 1) != 0) {
            close();
        }
    }

    public final void zza(String str, int i, int i2, CharArrayBuffer charArrayBuffer) {
        zzh(str, i);
        this.zzgcn[i2].copyStringToBuffer(i, this.zzgcm.getInt(str), charArrayBuffer);
    }

    @Hide
    public final Bundle zzahs() {
        return this.zzgco;
    }

    public final void zzali() {
        this.zzgcm = new Bundle();
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr = this.zzgcl;
            if (i2 >= strArr.length) {
                break;
            }
            this.zzgcm.putInt(strArr[i2], i2);
            i2++;
        }
        this.zzgcp = new int[this.zzgcn.length];
        i2 = 0;
        while (true) {
            CursorWindow[] cursorWindowArr = this.zzgcn;
            if (i < cursorWindowArr.length) {
                this.zzgcp[i] = i2;
                i2 += this.zzgcn[i].getNumRows() - (i2 - cursorWindowArr[i].getStartPosition());
                i++;
            } else {
                this.zzgcq = i2;
                return;
            }
        }
    }

    public final long zzb(String str, int i, int i2) {
        zzh(str, i);
        return this.zzgcn[i2].getLong(i, this.zzgcm.getInt(str));
    }

    @Hide
    public final int zzby(int i) {
        int i2 = 0;
        boolean z = i >= 0 && i < this.zzgcq;
        zzbq.checkState(z);
        while (true) {
            int[] iArr = this.zzgcp;
            if (i2 >= iArr.length) {
                break;
            } else if (i < iArr[i2]) {
                break;
            } else {
                i2++;
            }
        }
        i2--;
        return i2 == this.zzgcp.length ? i2 - 1 : i2;
    }

    public final int zzc(String str, int i, int i2) {
        zzh(str, i);
        return this.zzgcn[i2].getInt(i, this.zzgcm.getInt(str));
    }

    public final String zzd(String str, int i, int i2) {
        zzh(str, i);
        return this.zzgcn[i2].getString(i, this.zzgcm.getInt(str));
    }

    public final boolean zze(String str, int i, int i2) {
        zzh(str, i);
        return Long.valueOf(this.zzgcn[i2].getLong(i, this.zzgcm.getInt(str))).longValue() == 1;
    }

    public final float zzf(String str, int i, int i2) {
        zzh(str, i);
        return this.zzgcn[i2].getFloat(i, this.zzgcm.getInt(str));
    }

    public final byte[] zzg(String str, int i, int i2) {
        zzh(str, i);
        return this.zzgcn[i2].getBlob(i, this.zzgcm.getInt(str));
    }

    public final boolean zzgj(String str) {
        return this.zzgcm.containsKey(str);
    }

    public final boolean zzh(String str, int i, int i2) {
        zzh(str, i);
        return this.zzgcn[i2].isNull(i, this.zzgcm.getInt(str));
    }
}
