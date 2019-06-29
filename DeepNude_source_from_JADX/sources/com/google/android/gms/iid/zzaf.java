package com.google.android.gms.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.util.zzx;
import java.io.File;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

@Hide
public final class zzaf {
    private Context zzaiq;
    private SharedPreferences zzioc;

    public zzaf(Context context) {
        this(context, "com.google.android.gms.appid");
    }

    private zzaf(Context context, String str) {
        String str2 = "InstanceID/Store";
        this.zzaiq = context;
        this.zzioc = context.getSharedPreferences(str, 0);
        String valueOf = String.valueOf(str);
        str = "-no-backup";
        File file = new File(zzx.getNoBackupFilesDir(this.zzaiq), str.length() != 0 ? valueOf.concat(str) : new String(valueOf));
        if (!file.exists()) {
            try {
                if (file.createNewFile() && !isEmpty()) {
                    Log.i(str2, "App restored, clearing state");
                    InstanceIDListenerService.zza(this.zzaiq, this);
                }
            } catch (IOException e) {
                if (Log.isLoggable(str2, 3)) {
                    str = "Error creating file in no backup dir: ";
                    valueOf = String.valueOf(e.getMessage());
                    Log.d(str2, valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                }
            }
        }
    }

    private final synchronized void zza(Editor editor, String str, String str2, String str3) {
        StringBuilder stringBuilder = new StringBuilder((String.valueOf(str).length() + 3) + String.valueOf(str2).length());
        stringBuilder.append(str);
        stringBuilder.append("|S|");
        stringBuilder.append(str2);
        editor.putString(stringBuilder.toString(), str3);
    }

    private static String zze(String str, String str2, String str3) {
        StringBuilder stringBuilder = new StringBuilder(((String.valueOf(str).length() + 4) + String.valueOf(str2).length()) + String.valueOf(str3).length());
        stringBuilder.append(str);
        stringBuilder.append("|T|");
        stringBuilder.append(str2);
        stringBuilder.append("|");
        stringBuilder.append(str3);
        return stringBuilder.toString();
    }

    final synchronized String get(String str) {
        return this.zzioc.getString(str, null);
    }

    final synchronized String get(String str, String str2) {
        SharedPreferences sharedPreferences;
        StringBuilder stringBuilder;
        sharedPreferences = this.zzioc;
        stringBuilder = new StringBuilder((String.valueOf(str).length() + 3) + String.valueOf(str2).length());
        stringBuilder.append(str);
        stringBuilder.append("|S|");
        stringBuilder.append(str2);
        return sharedPreferences.getString(stringBuilder.toString(), null);
    }

    @Hide
    public final boolean isEmpty() {
        return this.zzioc.getAll().isEmpty();
    }

    public final synchronized void zza(String str, String str2, String str3, String str4, String str5) {
        str = zze(str, str2, str3);
        Editor edit = this.zzioc.edit();
        edit.putString(str, str4);
        edit.putString("appVersion", str5);
        edit.putString("lastToken", Long.toString(System.currentTimeMillis() / 1000));
        edit.commit();
    }

    public final synchronized void zzawz() {
        this.zzioc.edit().clear().commit();
    }

    final synchronized KeyPair zzc(String str, long j) {
        KeyPair zzawn;
        zzawn = zza.zzawn();
        Editor edit = this.zzioc.edit();
        zza(edit, str, "|P|", InstanceID.zzp(zzawn.getPublic().getEncoded()));
        zza(edit, str, "|K|", InstanceID.zzp(zzawn.getPrivate().getEncoded()));
        zza(edit, str, "cre", Long.toString(j));
        edit.commit();
        return zzawn;
    }

    public final synchronized String zzf(String str, String str2, String str3) {
        return this.zzioc.getString(zze(str, str2, str3), null);
    }

    public final synchronized void zzg(String str, String str2, String str3) {
        str = zze(str, str2, str3);
        Editor edit = this.zzioc.edit();
        edit.remove(str);
        edit.commit();
    }

    public final synchronized void zzih(String str) {
        Editor edit = this.zzioc.edit();
        for (String str2 : this.zzioc.getAll().keySet()) {
            if (str2.startsWith(str)) {
                edit.remove(str2);
            }
        }
        edit.commit();
    }

    final KeyPair zzii(String str) {
        Object e;
        StringBuilder stringBuilder;
        String str2 = get(str, "|P|");
        str = get(str, "|K|");
        if (str2 != null) {
            if (str != null) {
                try {
                    byte[] decode = Base64.decode(str2, 8);
                    byte[] decode2 = Base64.decode(str, 8);
                    KeyFactory instance = KeyFactory.getInstance("RSA");
                    return new KeyPair(instance.generatePublic(new X509EncodedKeySpec(decode)), instance.generatePrivate(new PKCS8EncodedKeySpec(decode2)));
                } catch (InvalidKeySpecException e2) {
                    e = e2;
                    str = String.valueOf(e);
                    stringBuilder = new StringBuilder(String.valueOf(str).length() + 19);
                    stringBuilder.append("Invalid key stored ");
                    stringBuilder.append(str);
                    Log.w("InstanceID/Store", stringBuilder.toString());
                    InstanceIDListenerService.zza(this.zzaiq, this);
                    return null;
                } catch (NoSuchAlgorithmException e3) {
                    e = e3;
                    str = String.valueOf(e);
                    stringBuilder = new StringBuilder(String.valueOf(str).length() + 19);
                    stringBuilder.append("Invalid key stored ");
                    stringBuilder.append(str);
                    Log.w("InstanceID/Store", stringBuilder.toString());
                    InstanceIDListenerService.zza(this.zzaiq, this);
                    return null;
                }
            }
        }
        return null;
    }
}
