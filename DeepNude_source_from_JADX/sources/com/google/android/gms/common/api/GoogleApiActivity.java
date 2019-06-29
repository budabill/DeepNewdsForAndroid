package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.internal.zzbm;
import com.google.android.gms.common.internal.Hide;

public class GoogleApiActivity extends Activity implements OnCancelListener {
    @Hide
    private int zzfsu = 0;

    @Hide
    public static PendingIntent zza(Context context, PendingIntent pendingIntent, int i) {
        return PendingIntent.getActivity(context, 0, zza(context, pendingIntent, i, true), 134217728);
    }

    @Hide
    public static Intent zza(Context context, PendingIntent pendingIntent, int i, boolean z) {
        Intent intent = new Intent(context, GoogleApiActivity.class);
        intent.putExtra("pending_intent", pendingIntent);
        intent.putExtra("failing_client_id", i);
        intent.putExtra("notify_manager", z);
        return intent;
    }

    @Hide
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            boolean booleanExtra = getIntent().getBooleanExtra("notify_manager", true);
            this.zzfsu = 0;
            setResult(i2, intent);
            if (booleanExtra) {
                zzbm zzck = zzbm.zzck(this);
                if (i2 == -1) {
                    zzck.zzaih();
                } else if (i2 == 0) {
                    zzck.zza(new ConnectionResult(13, null), getIntent().getIntExtra("failing_client_id", -1));
                }
            }
        } else if (i == 2) {
            this.zzfsu = 0;
            setResult(i2, intent);
        }
        finish();
    }

    @Hide
    public void onCancel(DialogInterface dialogInterface) {
        this.zzfsu = 0;
        setResult(0);
        finish();
    }

    @Hide
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.zzfsu = bundle.getInt("resolution");
        }
        if (this.zzfsu != 1) {
            String str;
            bundle = getIntent().getExtras();
            String str2 = "GoogleApiActivity";
            if (bundle == null) {
                str = "Activity started without extras";
            } else {
                PendingIntent pendingIntent = (PendingIntent) bundle.get("pending_intent");
                Integer num = (Integer) bundle.get("error_code");
                if (pendingIntent == null && num == null) {
                    str = "Activity started without resolution";
                } else if (pendingIntent != null) {
                    try {
                        startIntentSenderForResult(pendingIntent.getIntentSender(), 1, null, 0, 0, 0);
                        this.zzfsu = 1;
                        return;
                    } catch (Throwable e) {
                        Log.e(str2, "Failed to launch pendingIntent", e);
                    }
                } else {
                    GoogleApiAvailability.getInstance().showErrorDialogFragment(this, num.intValue(), 2, this);
                    this.zzfsu = 1;
                }
            }
            Log.e(str2, str);
            finish();
        }
    }

    @Hide
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("resolution", this.zzfsu);
        super.onSaveInstanceState(bundle);
    }
}
