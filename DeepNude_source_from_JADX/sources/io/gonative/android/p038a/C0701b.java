package io.gonative.android.p038a;

import android.util.Log;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: io.gonative.android.a.b */
public class C0701b {
    /* renamed from: a */
    private static final String f1555a = "io.gonative.android.a.b";

    /* renamed from: a */
    public static void m1894a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                Log.e(f1555a, e.toString());
            }
        }
    }

    /* renamed from: a */
    public static void m1895a(InputStream inputStream, OutputStream outputStream) {
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
