package android.support.v4.os;

import android.os.Build.VERSION;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;

final class LocaleListHelper {
    private static final Locale EN_LATN = LocaleHelper.forLanguageTag("en-Latn");
    private static final Locale LOCALE_AR_XB = new Locale("ar", "XB");
    private static final Locale LOCALE_EN_XA = new Locale("en", "XA");
    private static final int NUM_PSEUDO_LOCALES = 2;
    private static final String STRING_AR_XB = "ar-XB";
    private static final String STRING_EN_XA = "en-XA";
    private static LocaleListHelper sDefaultAdjustedLocaleList = null;
    private static LocaleListHelper sDefaultLocaleList = null;
    private static final Locale[] sEmptyList = new Locale[0];
    private static final LocaleListHelper sEmptyLocaleList = new LocaleListHelper(new Locale[0]);
    private static Locale sLastDefaultLocale = null;
    private static LocaleListHelper sLastExplicitlySetLocaleList = null;
    private static final Object sLock = new Object();
    private final Locale[] mList;
    private final String mStringRepresentation;

    LocaleListHelper(Locale locale, LocaleListHelper localeListHelper) {
        if (locale != null) {
            int i = 0;
            int length = localeListHelper == null ? 0 : localeListHelper.mList.length;
            int i2 = 0;
            while (i2 < length) {
                if (locale.equals(localeListHelper.mList[i2])) {
                    break;
                }
                i2++;
            }
            i2 = -1;
            int i3 = (i2 == -1 ? 1 : 0) + length;
            Locale[] localeArr = new Locale[i3];
            localeArr[0] = (Locale) locale.clone();
            int i4;
            if (i2 == -1) {
                i4 = 0;
                while (i4 < length) {
                    i2 = i4 + 1;
                    localeArr[i2] = (Locale) localeListHelper.mList[i4].clone();
                    i4 = i2;
                }
            } else {
                i4 = 0;
                while (i4 < i2) {
                    int i5 = i4 + 1;
                    localeArr[i5] = (Locale) localeListHelper.mList[i4].clone();
                    i4 = i5;
                }
                for (i2++; i2 < length; i2++) {
                    localeArr[i2] = (Locale) localeListHelper.mList[i2].clone();
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            while (i < i3) {
                stringBuilder.append(LocaleHelper.toLanguageTag(localeArr[i]));
                if (i < i3 - 1) {
                    stringBuilder.append(',');
                }
                i++;
            }
            this.mList = localeArr;
            this.mStringRepresentation = stringBuilder.toString();
            return;
        }
        throw new NullPointerException("topLocale is null");
    }

    LocaleListHelper(Locale... localeArr) {
        String str;
        if (localeArr.length == 0) {
            this.mList = sEmptyList;
            str = "";
        } else {
            Locale[] localeArr2 = new Locale[localeArr.length];
            HashSet hashSet = new HashSet();
            StringBuilder stringBuilder = new StringBuilder();
            int i = 0;
            while (i < localeArr.length) {
                Locale locale = localeArr[i];
                String str2 = "list[";
                StringBuilder stringBuilder2;
                if (locale == null) {
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(str2);
                    stringBuilder2.append(i);
                    stringBuilder2.append("] is null");
                    throw new NullPointerException(stringBuilder2.toString());
                } else if (hashSet.contains(locale)) {
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(str2);
                    stringBuilder2.append(i);
                    stringBuilder2.append("] is a repetition");
                    throw new IllegalArgumentException(stringBuilder2.toString());
                } else {
                    locale = (Locale) locale.clone();
                    localeArr2[i] = locale;
                    stringBuilder.append(LocaleHelper.toLanguageTag(locale));
                    if (i < localeArr.length - 1) {
                        stringBuilder.append(',');
                    }
                    hashSet.add(locale);
                    i++;
                }
            }
            this.mList = localeArr2;
            str = stringBuilder.toString();
        }
        this.mStringRepresentation = str;
    }

    private Locale computeFirstMatch(Collection<String> collection, boolean z) {
        int computeFirstMatchIndex = computeFirstMatchIndex(collection, z);
        return computeFirstMatchIndex == -1 ? null : this.mList[computeFirstMatchIndex];
    }

    private int computeFirstMatchIndex(Collection<String> collection, boolean z) {
        Locale[] localeArr = this.mList;
        if (localeArr.length == 1) {
            return 0;
        }
        if (localeArr.length == 0) {
            return -1;
        }
        int findFirstMatchIndex;
        int findFirstMatchIndex2;
        if (z) {
            findFirstMatchIndex = findFirstMatchIndex(EN_LATN);
            if (findFirstMatchIndex == 0) {
                return 0;
            }
            if (findFirstMatchIndex < ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) {
                for (String forLanguageTag : collection) {
                    findFirstMatchIndex2 = findFirstMatchIndex(LocaleHelper.forLanguageTag(forLanguageTag));
                    if (findFirstMatchIndex2 == 0) {
                        return 0;
                    }
                    if (findFirstMatchIndex2 < findFirstMatchIndex) {
                        findFirstMatchIndex = findFirstMatchIndex2;
                    }
                }
                return findFirstMatchIndex != ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED ? 0 : findFirstMatchIndex;
            }
        }
        findFirstMatchIndex = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        while (r5.hasNext()) {
            findFirstMatchIndex2 = findFirstMatchIndex(LocaleHelper.forLanguageTag(forLanguageTag));
            if (findFirstMatchIndex2 == 0) {
                return 0;
            }
            if (findFirstMatchIndex2 < findFirstMatchIndex) {
                findFirstMatchIndex = findFirstMatchIndex2;
            }
        }
        if (findFirstMatchIndex != ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) {
        }
    }

    private int findFirstMatchIndex(Locale locale) {
        int i = 0;
        while (true) {
            Locale[] localeArr = this.mList;
            if (i >= localeArr.length) {
                return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
            if (matchScore(locale, localeArr[i]) > 0) {
                return i;
            }
            i++;
        }
    }

    static LocaleListHelper forLanguageTags(String str) {
        if (str != null) {
            if (!str.isEmpty()) {
                String[] split = str.split(",", -1);
                Locale[] localeArr = new Locale[split.length];
                for (int i = 0; i < localeArr.length; i++) {
                    localeArr[i] = LocaleHelper.forLanguageTag(split[i]);
                }
                return new LocaleListHelper(localeArr);
            }
        }
        return getEmptyLocaleList();
    }

    static LocaleListHelper getAdjustedDefault() {
        LocaleListHelper localeListHelper;
        getDefault();
        synchronized (sLock) {
            localeListHelper = sDefaultAdjustedLocaleList;
        }
        return localeListHelper;
    }

    static LocaleListHelper getDefault() {
        Locale locale = Locale.getDefault();
        synchronized (sLock) {
            LocaleListHelper localeListHelper;
            if (!locale.equals(sLastDefaultLocale)) {
                sLastDefaultLocale = locale;
                if (sDefaultLocaleList == null || !locale.equals(sDefaultLocaleList.get(0))) {
                    sDefaultLocaleList = new LocaleListHelper(locale, sLastExplicitlySetLocaleList);
                    sDefaultAdjustedLocaleList = sDefaultLocaleList;
                } else {
                    localeListHelper = sDefaultLocaleList;
                    return localeListHelper;
                }
            }
            localeListHelper = sDefaultLocaleList;
            return localeListHelper;
        }
    }

    static LocaleListHelper getEmptyLocaleList() {
        return sEmptyLocaleList;
    }

    private static String getLikelyScript(Locale locale) {
        String str = "";
        if (VERSION.SDK_INT >= 21) {
            String script = locale.getScript();
            if (!script.isEmpty()) {
                return script;
            }
        }
        return str;
    }

    private static boolean isPseudoLocale(String str) {
        if (!STRING_EN_XA.equals(str)) {
            if (!STRING_AR_XB.equals(str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPseudoLocale(Locale locale) {
        if (!LOCALE_EN_XA.equals(locale)) {
            if (!LOCALE_AR_XB.equals(locale)) {
                return false;
            }
        }
        return true;
    }

    static boolean isPseudoLocalesOnly(String[] strArr) {
        if (strArr == null) {
            return true;
        }
        if (strArr.length > 3) {
            return false;
        }
        for (String str : strArr) {
            if (!str.isEmpty() && !isPseudoLocale(str)) {
                return false;
            }
        }
        return true;
    }

    private static int matchScore(Locale locale, Locale locale2) {
        int i = 1;
        if (locale.equals(locale2)) {
            return 1;
        }
        if (locale.getLanguage().equals(locale2.getLanguage()) && !isPseudoLocale(locale)) {
            if (!isPseudoLocale(locale2)) {
                String likelyScript = getLikelyScript(locale);
                if (!likelyScript.isEmpty()) {
                    return likelyScript.equals(getLikelyScript(locale2));
                }
                String country = locale.getCountry();
                if (!country.isEmpty()) {
                    if (!country.equals(locale2.getCountry())) {
                        i = 0;
                    }
                }
                return i;
            }
        }
        return 0;
    }

    static void setDefault(LocaleListHelper localeListHelper) {
        setDefault(localeListHelper, 0);
    }

    static void setDefault(LocaleListHelper localeListHelper, int i) {
        if (localeListHelper == null) {
            throw new NullPointerException("locales is null");
        } else if (localeListHelper.isEmpty()) {
            throw new IllegalArgumentException("locales is empty");
        } else {
            synchronized (sLock) {
                sLastDefaultLocale = localeListHelper.get(i);
                Locale.setDefault(sLastDefaultLocale);
                sLastExplicitlySetLocaleList = localeListHelper;
                sDefaultLocaleList = localeListHelper;
                sDefaultAdjustedLocaleList = i == 0 ? sDefaultLocaleList : new LocaleListHelper(sLastDefaultLocale, sDefaultLocaleList);
            }
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LocaleListHelper)) {
            return false;
        }
        Locale[] localeArr = ((LocaleListHelper) obj).mList;
        if (this.mList.length != localeArr.length) {
            return false;
        }
        int i = 0;
        while (true) {
            Locale[] localeArr2 = this.mList;
            if (i >= localeArr2.length) {
                return true;
            }
            if (!localeArr2[i].equals(localeArr[i])) {
                return false;
            }
            i++;
        }
    }

    Locale get(int i) {
        if (i >= 0) {
            Locale[] localeArr = this.mList;
            if (i < localeArr.length) {
                return localeArr[i];
            }
        }
        return null;
    }

    Locale getFirstMatch(String[] strArr) {
        return computeFirstMatch(Arrays.asList(strArr), false);
    }

    int getFirstMatchIndex(String[] strArr) {
        return computeFirstMatchIndex(Arrays.asList(strArr), false);
    }

    int getFirstMatchIndexWithEnglishSupported(Collection<String> collection) {
        return computeFirstMatchIndex(collection, true);
    }

    int getFirstMatchIndexWithEnglishSupported(String[] strArr) {
        return getFirstMatchIndexWithEnglishSupported(Arrays.asList(strArr));
    }

    Locale getFirstMatchWithEnglishSupported(String[] strArr) {
        return computeFirstMatch(Arrays.asList(strArr), true);
    }

    public int hashCode() {
        int i = 1;
        int i2 = 0;
        while (true) {
            Locale[] localeArr = this.mList;
            if (i2 >= localeArr.length) {
                return i;
            }
            i = (i * 31) + localeArr[i2].hashCode();
            i2++;
        }
    }

    int indexOf(Locale locale) {
        int i = 0;
        while (true) {
            Locale[] localeArr = this.mList;
            if (i >= localeArr.length) {
                return -1;
            }
            if (localeArr[i].equals(locale)) {
                return i;
            }
            i++;
        }
    }

    boolean isEmpty() {
        return this.mList.length == 0;
    }

    int size() {
        return this.mList.length;
    }

    String toLanguageTags() {
        return this.mStringRepresentation;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        int i = 0;
        while (true) {
            Locale[] localeArr = this.mList;
            if (i < localeArr.length) {
                stringBuilder.append(localeArr[i]);
                if (i < this.mList.length - 1) {
                    stringBuilder.append(',');
                }
                i++;
            } else {
                stringBuilder.append("]");
                return stringBuilder.toString();
            }
        }
    }
}
