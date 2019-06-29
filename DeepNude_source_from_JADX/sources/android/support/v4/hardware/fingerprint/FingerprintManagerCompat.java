package android.support.v4.hardware.fingerprint;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.os.CancellationSignal;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

public final class FingerprintManagerCompat {
    private final Context mContext;

    public static abstract class AuthenticationCallback {
        public void onAuthenticationError(int i, CharSequence charSequence) {
        }

        public void onAuthenticationFailed() {
        }

        public void onAuthenticationHelp(int i, CharSequence charSequence) {
        }

        public void onAuthenticationSucceeded(AuthenticationResult authenticationResult) {
        }
    }

    public static final class AuthenticationResult {
        private final CryptoObject mCryptoObject;

        public AuthenticationResult(CryptoObject cryptoObject) {
            this.mCryptoObject = cryptoObject;
        }

        public CryptoObject getCryptoObject() {
            return this.mCryptoObject;
        }
    }

    public static class CryptoObject {
        private final Cipher mCipher;
        private final Mac mMac;
        private final Signature mSignature;

        public CryptoObject(Signature signature) {
            this.mSignature = signature;
            this.mCipher = null;
            this.mMac = null;
        }

        public CryptoObject(Cipher cipher) {
            this.mCipher = cipher;
            this.mSignature = null;
            this.mMac = null;
        }

        public CryptoObject(Mac mac) {
            this.mMac = mac;
            this.mCipher = null;
            this.mSignature = null;
        }

        public Cipher getCipher() {
            return this.mCipher;
        }

        public Mac getMac() {
            return this.mMac;
        }

        public Signature getSignature() {
            return this.mSignature;
        }
    }

    private FingerprintManagerCompat(Context context) {
        this.mContext = context;
    }

    public static FingerprintManagerCompat from(Context context) {
        return new FingerprintManagerCompat(context);
    }

    private static FingerprintManager getFingerprintManagerOrNull(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.fingerprint") ? (FingerprintManager) context.getSystemService(FingerprintManager.class) : null;
    }

    static CryptoObject unwrapCryptoObject(android.hardware.fingerprint.FingerprintManager.CryptoObject cryptoObject) {
        CryptoObject cryptoObject2 = null;
        if (cryptoObject == null) {
            return null;
        }
        if (cryptoObject.getCipher() != null) {
            return new CryptoObject(cryptoObject.getCipher());
        }
        if (cryptoObject.getSignature() != null) {
            return new CryptoObject(cryptoObject.getSignature());
        }
        if (cryptoObject.getMac() != null) {
            cryptoObject2 = new CryptoObject(cryptoObject.getMac());
        }
        return cryptoObject2;
    }

    private static android.hardware.fingerprint.FingerprintManager.AuthenticationCallback wrapCallback(final AuthenticationCallback authenticationCallback) {
        return new android.hardware.fingerprint.FingerprintManager.AuthenticationCallback() {
            public void onAuthenticationError(int i, CharSequence charSequence) {
                authenticationCallback.onAuthenticationError(i, charSequence);
            }

            public void onAuthenticationFailed() {
                authenticationCallback.onAuthenticationFailed();
            }

            public void onAuthenticationHelp(int i, CharSequence charSequence) {
                authenticationCallback.onAuthenticationHelp(i, charSequence);
            }

            public void onAuthenticationSucceeded(android.hardware.fingerprint.FingerprintManager.AuthenticationResult authenticationResult) {
                authenticationCallback.onAuthenticationSucceeded(new AuthenticationResult(FingerprintManagerCompat.unwrapCryptoObject(authenticationResult.getCryptoObject())));
            }
        };
    }

    private static android.hardware.fingerprint.FingerprintManager.CryptoObject wrapCryptoObject(CryptoObject cryptoObject) {
        android.hardware.fingerprint.FingerprintManager.CryptoObject cryptoObject2 = null;
        if (cryptoObject == null) {
            return null;
        }
        if (cryptoObject.getCipher() != null) {
            return new android.hardware.fingerprint.FingerprintManager.CryptoObject(cryptoObject.getCipher());
        }
        if (cryptoObject.getSignature() != null) {
            return new android.hardware.fingerprint.FingerprintManager.CryptoObject(cryptoObject.getSignature());
        }
        if (cryptoObject.getMac() != null) {
            cryptoObject2 = new android.hardware.fingerprint.FingerprintManager.CryptoObject(cryptoObject.getMac());
        }
        return cryptoObject2;
    }

    public void authenticate(CryptoObject cryptoObject, int i, CancellationSignal cancellationSignal, AuthenticationCallback authenticationCallback, Handler handler) {
        if (VERSION.SDK_INT >= 23) {
            FingerprintManager fingerprintManagerOrNull = getFingerprintManagerOrNull(this.mContext);
            if (fingerprintManagerOrNull != null) {
                fingerprintManagerOrNull.authenticate(wrapCryptoObject(cryptoObject), cancellationSignal != null ? (android.os.CancellationSignal) cancellationSignal.getCancellationSignalObject() : null, i, wrapCallback(authenticationCallback), handler);
            }
        }
    }

    public boolean hasEnrolledFingerprints() {
        if (VERSION.SDK_INT < 23) {
            return false;
        }
        FingerprintManager fingerprintManagerOrNull = getFingerprintManagerOrNull(this.mContext);
        return fingerprintManagerOrNull != null && fingerprintManagerOrNull.hasEnrolledFingerprints();
    }

    public boolean isHardwareDetected() {
        if (VERSION.SDK_INT < 23) {
            return false;
        }
        FingerprintManager fingerprintManagerOrNull = getFingerprintManagerOrNull(this.mContext);
        return fingerprintManagerOrNull != null && fingerprintManagerOrNull.isHardwareDetected();
    }
}
