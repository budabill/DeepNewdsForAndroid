package android.support.v4.text;

import android.os.Build.VERSION;
import android.text.TextUtils;
import java.util.Locale;

public final class TextUtilsCompat {
    private static final String ARAB_SCRIPT_SUBTAG = "Arab";
    private static final String HEBR_SCRIPT_SUBTAG = "Hebr";
    private static final Locale ROOT;

    static {
        String str = "";
        ROOT = new Locale(str, str);
    }

    private TextUtilsCompat() {
    }

    private static int getLayoutDirectionFromFirstChar(Locale locale) {
        byte directionality = Character.getDirectionality(locale.getDisplayName(locale).charAt(0));
        return (directionality == (byte) 1 || directionality == (byte) 2) ? 1 : 0;
    }

    public static int getLayoutDirectionFromLocale(Locale locale) {
        if (VERSION.SDK_INT >= 17) {
            return TextUtils.getLayoutDirectionFromLocale(locale);
        }
        if (!(locale == null || locale.equals(ROOT))) {
            String maximizeAndGetScript = ICUCompat.maximizeAndGetScript(locale);
            if (maximizeAndGetScript == null) {
                return getLayoutDirectionFromFirstChar(locale);
            }
            if (maximizeAndGetScript.equalsIgnoreCase(ARAB_SCRIPT_SUBTAG) || maximizeAndGetScript.equalsIgnoreCase(HEBR_SCRIPT_SUBTAG)) {
                return 1;
            }
        }
        return 0;
    }

    public static String htmlEncode(String str) {
        if (VERSION.SDK_INT >= 17) {
            return TextUtils.htmlEncode(str);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            String str2;
            char charAt = str.charAt(i);
            if (charAt == '\"') {
                str2 = "&quot;";
            } else if (charAt == '<') {
                str2 = "&lt;";
            } else if (charAt == '>') {
                str2 = "&gt;";
            } else if (charAt == '&') {
                str2 = "&amp;";
            } else if (charAt != '\'') {
                stringBuilder.append(charAt);
            } else {
                str2 = "&#39;";
            }
            stringBuilder.append(str2);
        }
        return stringBuilder.toString();
    }
}
