package android.support.v4.media;

import android.os.Bundle;
import androidx.versionedparcelable.C0270d;

interface AudioAttributesImpl extends C0270d {
    Object getAudioAttributes();

    int getContentType();

    int getFlags();

    int getLegacyStreamType();

    int getRawLegacyStreamType();

    int getUsage();

    int getVolumeControlStream();

    Bundle toBundle();
}
