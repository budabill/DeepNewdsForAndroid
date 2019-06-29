package androidx.media;

import androidx.versionedparcelable.C0269b;

public final class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(C0269b c0269b) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.mUsage = c0269b.m124a(audioAttributesImplBase.mUsage, 1);
        audioAttributesImplBase.mContentType = c0269b.m124a(audioAttributesImplBase.mContentType, 2);
        audioAttributesImplBase.mFlags = c0269b.m124a(audioAttributesImplBase.mFlags, 3);
        audioAttributesImplBase.mLegacyStream = c0269b.m124a(audioAttributesImplBase.mLegacyStream, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, C0269b c0269b) {
        c0269b.m132a(false, false);
        c0269b.m138b(audioAttributesImplBase.mUsage, 1);
        c0269b.m138b(audioAttributesImplBase.mContentType, 2);
        c0269b.m138b(audioAttributesImplBase.mFlags, 3);
        c0269b.m138b(audioAttributesImplBase.mLegacyStream, 4);
    }
}
