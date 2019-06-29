package android.support.v4.media;

import android.content.Context;

class MediaSessionManagerImplApi21 extends MediaSessionManagerImplBase {
    MediaSessionManagerImplApi21(Context context) {
        super(context);
        this.mContext = context;
    }

    private boolean hasMediaControlPermission(RemoteUserInfoImpl remoteUserInfoImpl) {
        return getContext().checkPermission("android.permission.MEDIA_CONTENT_CONTROL", remoteUserInfoImpl.getPid(), remoteUserInfoImpl.getUid()) == 0;
    }

    public boolean isTrustedForMediaControl(RemoteUserInfoImpl remoteUserInfoImpl) {
        if (!hasMediaControlPermission(remoteUserInfoImpl)) {
            if (!super.isTrustedForMediaControl(remoteUserInfoImpl)) {
                return false;
            }
        }
        return true;
    }
}
