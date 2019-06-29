package androidx.media;

import android.media.AudioAttributes;
import androidx.versionedparcelable.C0269b;

public final class AudioAttributesImplApi21Parcelizer {
    public static AudioAttributesImplApi21 read(C0269b c0269b) {
        AudioAttributesImplApi21 audioAttributesImplApi21 = new AudioAttributesImplApi21();
        audioAttributesImplApi21.mAudioAttributes = (AudioAttributes) c0269b.m125a(audioAttributesImplApi21.mAudioAttributes, 1);
        audioAttributesImplApi21.mLegacyStreamType = c0269b.m124a(audioAttributesImplApi21.mLegacyStreamType, 2);
        return audioAttributesImplApi21;
    }

    public static void write(AudioAttributesImplApi21 audioAttributesImplApi21, C0269b c0269b) {
        c0269b.m132a(false, false);
        c0269b.m139b(audioAttributesImplApi21.mAudioAttributes, 1);
        c0269b.m138b(audioAttributesImplApi21.mLegacyStreamType, 2);
    }
}
