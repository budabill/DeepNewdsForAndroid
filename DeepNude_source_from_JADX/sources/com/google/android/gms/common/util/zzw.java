package com.google.android.gms.common.util;

import java.util.regex.Pattern;

public final class zzw {
    private static final Pattern zzglh = Pattern.compile("\\$\\{(.*?)\\}");

    public static boolean zzhb(String str) {
        if (str != null) {
            if (!str.trim().isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
