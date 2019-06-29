package com.google.android.gms.common.api.internal;

import android.support.v4.app.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class zzak extends GoogleApiClient {
    private final String zzfxc;

    public zzak(String str) {
        this.zzfxc = str;
    }

    public ConnectionResult blockingConnect() {
        throw new UnsupportedOperationException(this.zzfxc);
    }

    public ConnectionResult blockingConnect(long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException(this.zzfxc);
    }

    public PendingResult<Status> clearDefaultAccountAndReconnect() {
        throw new UnsupportedOperationException(this.zzfxc);
    }

    public void connect() {
        throw new UnsupportedOperationException(this.zzfxc);
    }

    public void disconnect() {
        throw new UnsupportedOperationException(this.zzfxc);
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        throw new UnsupportedOperationException(this.zzfxc);
    }

    public ConnectionResult getConnectionResult(Api<?> api) {
        throw new UnsupportedOperationException(this.zzfxc);
    }

    public boolean hasConnectedApi(Api<?> api) {
        throw new UnsupportedOperationException(this.zzfxc);
    }

    public boolean isConnected() {
        throw new UnsupportedOperationException(this.zzfxc);
    }

    public boolean isConnecting() {
        throw new UnsupportedOperationException(this.zzfxc);
    }

    public boolean isConnectionCallbacksRegistered(ConnectionCallbacks connectionCallbacks) {
        throw new UnsupportedOperationException(this.zzfxc);
    }

    public boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener onConnectionFailedListener) {
        throw new UnsupportedOperationException(this.zzfxc);
    }

    public void reconnect() {
        throw new UnsupportedOperationException(this.zzfxc);
    }

    public void registerConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
        throw new UnsupportedOperationException(this.zzfxc);
    }

    public void registerConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
        throw new UnsupportedOperationException(this.zzfxc);
    }

    public void stopAutoManage(FragmentActivity fragmentActivity) {
        throw new UnsupportedOperationException(this.zzfxc);
    }

    public void unregisterConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
        throw new UnsupportedOperationException(this.zzfxc);
    }

    public void unregisterConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
        throw new UnsupportedOperationException(this.zzfxc);
    }
}
