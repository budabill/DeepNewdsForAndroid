package com.facebook.internal;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* renamed from: com.facebook.internal.P */
class C0472P implements FilenameFilter {
    C0472P() {
    }

    public boolean accept(File file, String str) {
        return Pattern.matches("cpu[0-9]+", str);
    }
}
