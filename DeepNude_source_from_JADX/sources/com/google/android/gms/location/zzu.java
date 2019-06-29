package com.google.android.gms.location;

import android.os.IInterface;
import com.google.android.gms.common.internal.Hide;

@Hide
public interface zzu extends IInterface {
    void onLocationAvailability(LocationAvailability locationAvailability);

    void onLocationResult(LocationResult locationResult);
}
