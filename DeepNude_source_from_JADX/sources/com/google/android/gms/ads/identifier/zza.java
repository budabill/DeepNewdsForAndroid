package com.google.android.gms.ads.identifier;

import android.net.Uri;
import android.net.Uri.Builder;
import android.util.Log;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

final class zza extends Thread {
    private /* synthetic */ Map zzamz;

    zza(AdvertisingIdClient advertisingIdClient, Map map) {
        this.zzamz = map;
    }

    public final void run() {
        StringBuilder stringBuilder;
        Throwable e;
        String message;
        String str = ". ";
        String str2 = "HttpUrlPinger";
        zzc zzc = new zzc();
        Map map = this.zzamz;
        Builder buildUpon = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204?id=gmob-apps").buildUpon();
        for (String str3 : map.keySet()) {
            String str32;
            buildUpon.appendQueryParameter(str32, (String) map.get(str32));
        }
        String uri = buildUpon.build().toString();
        HttpURLConnection httpURLConnection;
        try {
            httpURLConnection = (HttpURLConnection) new URL(uri).openConnection();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode < 200 || responseCode >= 300) {
                stringBuilder = new StringBuilder(String.valueOf(uri).length() + 65);
                stringBuilder.append("Received non-success response code ");
                stringBuilder.append(responseCode);
                stringBuilder.append(" from pinging URL: ");
                stringBuilder.append(uri);
                Log.w(str2, stringBuilder.toString());
            }
            httpURLConnection.disconnect();
        } catch (IndexOutOfBoundsException e2) {
            e = e2;
            message = e.getMessage();
            stringBuilder = new StringBuilder((String.valueOf(uri).length() + 32) + String.valueOf(message).length());
            str32 = "Error while parsing ping URL: ";
            stringBuilder.append(str32);
            stringBuilder.append(uri);
            stringBuilder.append(str);
            stringBuilder.append(message);
            Log.w(str2, stringBuilder.toString(), e);
        } catch (IOException e3) {
            e = e3;
            message = e.getMessage();
            stringBuilder = new StringBuilder((String.valueOf(uri).length() + 27) + String.valueOf(message).length());
            str32 = "Error while pinging URL: ";
            stringBuilder.append(str32);
            stringBuilder.append(uri);
            stringBuilder.append(str);
            stringBuilder.append(message);
            Log.w(str2, stringBuilder.toString(), e);
        } catch (RuntimeException e4) {
            e = e4;
            message = e.getMessage();
            stringBuilder = new StringBuilder((String.valueOf(uri).length() + 27) + String.valueOf(message).length());
            str32 = "Error while pinging URL: ";
            stringBuilder.append(str32);
            stringBuilder.append(uri);
            stringBuilder.append(str);
            stringBuilder.append(message);
            Log.w(str2, stringBuilder.toString(), e);
        } catch (Throwable th) {
            httpURLConnection.disconnect();
        }
    }
}
