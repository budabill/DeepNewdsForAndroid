package androidx.media;

import android.support.v4.media.AudioAttributesCompat;
import androidx.versionedparcelable.C0269b;

public final class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(C0269b c0269b) {
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        audioAttributesCompat.mImpl = (AudioAttributesImpl) c0269b.m126a(audioAttributesCompat.mImpl, 1);
        return audioAttributesCompat;
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, C0269b c0269b) {
        c0269b.m132a(false, false);
        c0269b.m140b(audioAttributesCompat.mImpl, 1);
    }
}
