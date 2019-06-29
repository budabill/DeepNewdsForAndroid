package android.support.v4.os;

import java.util.Locale;

final class LocaleHelper {
    private LocaleHelper() {
    }

    static Locale forLanguageTag(String str) {
        Object obj = "-";
        String[] split;
        if (str.contains(obj)) {
            split = str.split(obj, -1);
            if (split.length > 2) {
                return new Locale(split[0], split[1], split[2]);
            }
            if (split.length > 1) {
                return new Locale(split[0], split[1]);
            }
            if (split.length == 1) {
                return new Locale(split[0]);
            }
        }
        obj = "_";
        if (!str.contains(obj)) {
            return new Locale(str);
        }
        split = str.split(obj, -1);
        if (split.length > 2) {
            return new Locale(split[0], split[1], split[2]);
        }
        if (split.length > 1) {
            return new Locale(split[0], split[1]);
        }
        if (split.length == 1) {
            return new Locale(split[0]);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Can not parse language tag: [");
        stringBuilder.append(str);
        stringBuilder.append("]");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    static String toLanguageTag(Locale locale) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(locale.getLanguage());
        String country = locale.getCountry();
        if (!(country == null || country.isEmpty())) {
            stringBuilder.append("-");
            stringBuilder.append(locale.getCountry());
        }
        return stringBuilder.toString();
    }
}
