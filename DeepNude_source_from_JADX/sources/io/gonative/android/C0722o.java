package io.gonative.android;

import android.util.Log;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: io.gonative.android.o */
public class C0722o {
    /* renamed from: a */
    private static final String f1626a = "io.gonative.android.o";

    /* renamed from: a */
    public static void m1946a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                Log.e(f1626a, e.toString());
            }
        }
    }

    /* renamed from: a */
    public static void m1947a(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read > 0) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }
}
