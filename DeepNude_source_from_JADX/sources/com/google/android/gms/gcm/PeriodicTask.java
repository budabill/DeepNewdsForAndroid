package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public class PeriodicTask extends Task {
    public static final Creator<PeriodicTask> CREATOR = new zzh();
    protected long mFlexInSeconds;
    protected long mIntervalInSeconds;

    public static class Builder extends com.google.android.gms.gcm.Task.Builder {
        private long zzikl = -1;
        private long zzikm = -1;

        public PeriodicTask build() {
            checkConditions();
            return new PeriodicTask();
        }

        protected void checkConditions() {
            super.checkConditions();
            long j = this.zzikl;
            if (j == -1) {
                throw new IllegalArgumentException("Must call setPeriod(long) to establish an execution interval for this periodic task.");
            } else if (j > 0) {
                long j2 = this.zzikm;
                if (j2 == -1) {
                    this.zzikm = (long) (((float) j) * 0.1f);
                    return;
                }
                if (j2 > j) {
                    this.zzikm = j;
                }
            } else {
                StringBuilder stringBuilder = new StringBuilder(66);
                stringBuilder.append("Period set cannot be less than or equal to 0: ");
                stringBuilder.append(j);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }

        public Builder setExtras(Bundle bundle) {
            this.extras = bundle;
            return this;
        }

        public Builder setFlex(long j) {
            this.zzikm = j;
            return this;
        }

        public Builder setPeriod(long j) {
            this.zzikl = j;
            return this;
        }

        public Builder setPersisted(boolean z) {
            this.isPersisted = z;
            return this;
        }

        public Builder setRequiredNetwork(int i) {
            this.requiredNetworkState = i;
            return this;
        }

        public Builder setRequiresCharging(boolean z) {
            this.requiresCharging = z;
            return this;
        }

        public Builder setService(Class<? extends GcmTaskService> cls) {
            this.gcmTaskService = cls.getName();
            return this;
        }

        public Builder setTag(String str) {
            this.tag = str;
            return this;
        }

        public Builder setUpdateCurrent(boolean z) {
            this.updateCurrent = z;
            return this;
        }
    }

    @Deprecated
    private PeriodicTask(Parcel parcel) {
        super(parcel);
        this.mIntervalInSeconds = -1;
        this.mFlexInSeconds = -1;
        this.mIntervalInSeconds = parcel.readLong();
        this.mFlexInSeconds = Math.min(parcel.readLong(), this.mIntervalInSeconds);
    }

    private PeriodicTask(Builder builder) {
        super((com.google.android.gms.gcm.Task.Builder) builder);
        this.mIntervalInSeconds = -1;
        this.mFlexInSeconds = -1;
        this.mIntervalInSeconds = builder.zzikl;
        this.mFlexInSeconds = Math.min(builder.zzikm, this.mIntervalInSeconds);
    }

    public long getFlex() {
        return this.mFlexInSeconds;
    }

    public long getPeriod() {
        return this.mIntervalInSeconds;
    }

    public void toBundle(Bundle bundle) {
        super.toBundle(bundle);
        bundle.putLong("period", this.mIntervalInSeconds);
        bundle.putLong("period_flex", this.mFlexInSeconds);
    }

    public String toString() {
        String obj = super.toString();
        long period = getPeriod();
        long flex = getFlex();
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(obj).length() + 54);
        stringBuilder.append(obj);
        stringBuilder.append(" period=");
        stringBuilder.append(period);
        stringBuilder.append(" flex=");
        stringBuilder.append(flex);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeLong(this.mIntervalInSeconds);
        parcel.writeLong(this.mFlexInSeconds);
    }
}
