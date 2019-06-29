package com.onesignal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.amazon.device.messaging.ADMMessageHandlerBase;
import com.onesignal.sa.C0650i;

public class ADMMessageHandler extends ADMMessageHandlerBase {
    public ADMMessageHandler() {
        super("ADMMessageHandler");
    }

    protected void onMessage(Intent intent) {
        Context applicationContext = getApplicationContext();
        Bundle extras = intent.getExtras();
        if (!C0585D.m1290a(applicationContext, extras).m1288a()) {
            C0588G c0588g = new C0588G(applicationContext);
            c0588g.f1120b = C0585D.m1303b(extras);
            C0585D.m1289a(c0588g);
        }
    }

    protected void onRegistered(String str) {
        C0650i c0650i = C0650i.INFO;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ADM registration ID: ");
        stringBuilder.append(str);
        sa.m1656a(c0650i, stringBuilder.toString());
        Na.m2242a(str);
    }

    protected void onRegistrationError(String str) {
        C0650i c0650i = C0650i.ERROR;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ADM:onRegistrationError: ");
        stringBuilder.append(str);
        sa.m1656a(c0650i, stringBuilder.toString());
        if ("INVALID_SENDER".equals(str)) {
            sa.m1656a(C0650i.ERROR, "Please double check that you have a matching package name (NOTE: Case Sensitive), api_key.txt, and the apk was signed with the same Keystore and Alias.");
        }
        Na.m2242a(null);
    }

    protected void onUnregistered(String str) {
        C0650i c0650i = C0650i.INFO;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ADM:onUnregistered: ");
        stringBuilder.append(str);
        sa.m1656a(c0650i, stringBuilder.toString());
    }
}
