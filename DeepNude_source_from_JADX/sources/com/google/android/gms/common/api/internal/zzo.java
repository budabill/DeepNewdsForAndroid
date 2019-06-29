package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import java.util.concurrent.atomic.AtomicReference;

public abstract class zzo extends LifecycleCallback implements OnCancelListener {
    protected volatile boolean mStarted;
    protected final GoogleApiAvailability zzftg;
    protected final AtomicReference<zzp> zzfut;
    private final Handler zzfuu;

    protected zzo(zzcf zzcf) {
        this(zzcf, GoogleApiAvailability.getInstance());
    }

    private zzo(zzcf zzcf, GoogleApiAvailability googleApiAvailability) {
        super(zzcf);
        this.zzfut = new AtomicReference(null);
        this.zzfuu = new Handler(Looper.getMainLooper());
        this.zzftg = googleApiAvailability;
    }

    private static int zza(zzp zzp) {
        return zzp == null ? -1 : zzp.zzaim();
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        zzp zzp = (zzp) this.zzfut.get();
        Object obj = 1;
        if (i != 1) {
            if (i == 2) {
                i = this.zzftg.isGooglePlayServicesAvailable(getActivity());
                if (i != 0) {
                    obj = null;
                }
                if (zzp != null) {
                    if (zzp.zzain().getErrorCode() == 18 && i == 18) {
                        return;
                    }
                    if (obj != null) {
                        zzail();
                        return;
                    }
                    if (zzp != null) {
                        zza(zzp.zzain(), zzp.zzaim());
                    }
                }
                return;
            }
        } else if (i2 == -1) {
            if (obj != null) {
                if (zzp != null) {
                    zza(zzp.zzain(), zzp.zzaim());
                }
            }
            zzail();
            return;
        } else if (i2 == 0) {
            i = 13;
            if (intent != null) {
                i = intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13);
            }
            zzp zzp2 = new zzp(new ConnectionResult(i, null), zza(zzp));
            this.zzfut.set(zzp2);
            zzp = zzp2;
        }
        obj = null;
        if (obj != null) {
            zzail();
            return;
        }
        if (zzp != null) {
            zza(zzp.zzain(), zzp.zzaim());
        }
    }

    public void onCancel(DialogInterface dialogInterface) {
        zza(new ConnectionResult(13, null), zza((zzp) this.zzfut.get()));
        zzail();
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.zzfut.set(bundle.getBoolean("resolving_error", false) ? new zzp(new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1)) : null);
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        zzp zzp = (zzp) this.zzfut.get();
        if (zzp != null) {
            bundle.putBoolean("resolving_error", true);
            bundle.putInt("failed_client_id", zzp.zzaim());
            bundle.putInt("failed_status", zzp.zzain().getErrorCode());
            bundle.putParcelable("failed_resolution", zzp.zzain().getResolution());
        }
    }

    public void onStart() {
        super.onStart();
        this.mStarted = true;
    }

    public void onStop() {
        super.onStop();
        this.mStarted = false;
    }

    protected abstract void zza(ConnectionResult connectionResult, int i);

    protected abstract void zzaih();

    protected final void zzail() {
        this.zzfut.set(null);
        zzaih();
    }

    public final void zzb(ConnectionResult connectionResult, int i) {
        zzp zzp = new zzp(connectionResult, i);
        if (this.zzfut.compareAndSet(null, zzp)) {
            this.zzfuu.post(new zzq(this, zzp));
        }
    }
}
