package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbq;

public class Task implements ReflectedParcelable {
    public static final int EXTRAS_LIMIT_BYTES = 10240;
    public static final int NETWORK_STATE_ANY = 2;
    public static final int NETWORK_STATE_CONNECTED = 0;
    public static final int NETWORK_STATE_UNMETERED = 1;
    protected static final long UNINITIALIZED = -1;
    private final Bundle mExtras;
    private final String mTag;
    private final String zziks;
    private final boolean zzikt;
    private final boolean zziku;
    private final int zzikv;
    private final boolean zzikw;
    private final boolean zzikx;
    private final zzi zziky;

    public static abstract class Builder {
        protected Bundle extras;
        protected String gcmTaskService;
        protected boolean isPersisted = true;
        protected int requiredNetworkState;
        protected boolean requiresCharging;
        protected String tag;
        protected boolean updateCurrent;
        @Hide
        protected zzi zzikz = zzi.zzikn;

        public abstract Task build();

        protected void checkConditions() {
            zzbq.checkArgument(this.gcmTaskService != null, "Must provide an endpoint for this task by calling setService(ComponentName).");
            GcmNetworkManager.zzid(this.tag);
            zzi zzi = this.zzikz;
            if (zzi != null) {
                StringBuilder stringBuilder;
                int zzawi = zzi.zzawi();
                if (zzawi != 1) {
                    if (zzawi != 0) {
                        stringBuilder = new StringBuilder(45);
                        stringBuilder.append("Must provide a valid RetryPolicy: ");
                        stringBuilder.append(zzawi);
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                }
                int zzawj = zzi.zzawj();
                int zzawk = zzi.zzawk();
                if (zzawi == 0) {
                    if (zzawj < 0) {
                        StringBuilder stringBuilder2 = new StringBuilder(52);
                        stringBuilder2.append("InitialBackoffSeconds can't be negative: ");
                        stringBuilder2.append(zzawj);
                        throw new IllegalArgumentException(stringBuilder2.toString());
                    }
                }
                if (zzawi == 1) {
                    if (zzawj < 10) {
                        throw new IllegalArgumentException("RETRY_POLICY_LINEAR must have an initial backoff at least 10 seconds.");
                    }
                }
                if (zzawk < zzawj) {
                    int zzawk2 = zzi.zzawk();
                    stringBuilder = new StringBuilder(77);
                    stringBuilder.append("MaximumBackoffSeconds must be greater than InitialBackoffSeconds: ");
                    stringBuilder.append(zzawk2);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
            if (this.isPersisted) {
                Task.zzw(this.extras);
            }
        }

        public abstract Builder setExtras(Bundle bundle);

        public abstract Builder setPersisted(boolean z);

        public abstract Builder setRequiredNetwork(int i);

        public abstract Builder setRequiresCharging(boolean z);

        public abstract Builder setService(Class<? extends GcmTaskService> cls);

        public abstract Builder setTag(String str);

        public abstract Builder setUpdateCurrent(boolean z);
    }

    @Deprecated
    Task(Parcel parcel) {
        Log.e("Task", "Constructing a Task object using a parcel.");
        this.zziks = parcel.readString();
        this.mTag = parcel.readString();
        boolean z = true;
        this.zzikt = parcel.readInt() == 1;
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.zziku = z;
        this.zzikv = 2;
        this.zzikw = false;
        this.zzikx = false;
        this.zziky = zzi.zzikn;
        this.mExtras = null;
    }

    Task(Builder builder) {
        this.zziks = builder.gcmTaskService;
        this.mTag = builder.tag;
        this.zzikt = builder.updateCurrent;
        this.zziku = builder.isPersisted;
        this.zzikv = builder.requiredNetworkState;
        this.zzikw = builder.requiresCharging;
        this.zzikx = false;
        this.mExtras = builder.extras;
        zzi zzi = builder.zzikz;
        if (zzi == null) {
            zzi = zzi.zzikn;
        }
        this.zziky = zzi;
    }

    @Hide
    public static void zzw(Bundle bundle) {
        if (bundle != null) {
            Parcel obtain = Parcel.obtain();
            bundle.writeToParcel(obtain, 0);
            int dataSize = obtain.dataSize();
            obtain.recycle();
            if (dataSize <= EXTRAS_LIMIT_BYTES) {
                for (String str : bundle.keySet()) {
                    Object obj;
                    Object obj2 = bundle.get(str);
                    if (!((obj2 instanceof Integer) || (obj2 instanceof Long) || (obj2 instanceof Double) || (obj2 instanceof String))) {
                        if (!(obj2 instanceof Boolean)) {
                            obj = null;
                            if (obj != null) {
                                if (obj2 instanceof Bundle) {
                                    throw new IllegalArgumentException("Only the following extra parameter types are supported: Integer, Long, Double, String, Boolean, and nested Bundles with the same restrictions.");
                                }
                                zzw((Bundle) obj2);
                            }
                        }
                    }
                    obj = 1;
                    if (obj != null) {
                        if (obj2 instanceof Bundle) {
                            throw new IllegalArgumentException("Only the following extra parameter types are supported: Integer, Long, Double, String, Boolean, and nested Bundles with the same restrictions.");
                        }
                        zzw((Bundle) obj2);
                    }
                }
                return;
            }
            StringBuilder stringBuilder = new StringBuilder(55);
            stringBuilder.append("Extras exceeding maximum size(10240 bytes): ");
            stringBuilder.append(dataSize);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public int describeContents() {
        return 0;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public int getRequiredNetwork() {
        return this.zzikv;
    }

    public boolean getRequiresCharging() {
        return this.zzikw;
    }

    public String getServiceName() {
        return this.zziks;
    }

    public String getTag() {
        return this.mTag;
    }

    public boolean isPersisted() {
        return this.zziku;
    }

    public boolean isUpdateCurrent() {
        return this.zzikt;
    }

    @Hide
    public void toBundle(Bundle bundle) {
        bundle.putString("tag", this.mTag);
        bundle.putBoolean("update_current", this.zzikt);
        bundle.putBoolean("persisted", this.zziku);
        bundle.putString(NotificationCompat.CATEGORY_SERVICE, this.zziks);
        bundle.putInt("requiredNetwork", this.zzikv);
        bundle.putBoolean("requiresCharging", this.zzikw);
        bundle.putBoolean("requiresIdle", false);
        bundle.putBundle("retryStrategy", this.zziky.zzv(new Bundle()));
        bundle.putBundle("extras", this.mExtras);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zziks);
        parcel.writeString(this.mTag);
        parcel.writeInt(this.zzikt);
        parcel.writeInt(this.zziku);
    }
}
