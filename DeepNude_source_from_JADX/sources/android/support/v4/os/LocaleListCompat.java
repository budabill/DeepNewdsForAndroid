package android.support.v4.os;

import android.os.Build.VERSION;
import android.os.LocaleList;
import java.util.Locale;

public final class LocaleListCompat {
    static final LocaleListInterface IMPL = (VERSION.SDK_INT >= 24 ? new LocaleListCompatApi24Impl() : new LocaleListCompatBaseImpl());
    private static final LocaleListCompat sEmptyLocaleList = new LocaleListCompat();

    static class LocaleListCompatApi24Impl implements LocaleListInterface {
        private LocaleList mLocaleList = new LocaleList(new Locale[0]);

        LocaleListCompatApi24Impl() {
        }

        public boolean equals(Object obj) {
            return this.mLocaleList.equals(((LocaleListCompat) obj).unwrap());
        }

        public Locale get(int i) {
            return this.mLocaleList.get(i);
        }

        public Locale getFirstMatch(String[] strArr) {
            LocaleList localeList = this.mLocaleList;
            return localeList != null ? localeList.getFirstMatch(strArr) : null;
        }

        public Object getLocaleList() {
            return this.mLocaleList;
        }

        public int hashCode() {
            return this.mLocaleList.hashCode();
        }

        public int indexOf(Locale locale) {
            return this.mLocaleList.indexOf(locale);
        }

        public boolean isEmpty() {
            return this.mLocaleList.isEmpty();
        }

        public void setLocaleList(Locale... localeArr) {
            this.mLocaleList = new LocaleList(localeArr);
        }

        public int size() {
            return this.mLocaleList.size();
        }

        public String toLanguageTags() {
            return this.mLocaleList.toLanguageTags();
        }

        public String toString() {
            return this.mLocaleList.toString();
        }
    }

    static class LocaleListCompatBaseImpl implements LocaleListInterface {
        private LocaleListHelper mLocaleList = new LocaleListHelper(new Locale[0]);

        LocaleListCompatBaseImpl() {
        }

        public boolean equals(Object obj) {
            return this.mLocaleList.equals(((LocaleListCompat) obj).unwrap());
        }

        public Locale get(int i) {
            return this.mLocaleList.get(i);
        }

        public Locale getFirstMatch(String[] strArr) {
            LocaleListHelper localeListHelper = this.mLocaleList;
            return localeListHelper != null ? localeListHelper.getFirstMatch(strArr) : null;
        }

        public Object getLocaleList() {
            return this.mLocaleList;
        }

        public int hashCode() {
            return this.mLocaleList.hashCode();
        }

        public int indexOf(Locale locale) {
            return this.mLocaleList.indexOf(locale);
        }

        public boolean isEmpty() {
            return this.mLocaleList.isEmpty();
        }

        public void setLocaleList(Locale... localeArr) {
            this.mLocaleList = new LocaleListHelper(localeArr);
        }

        public int size() {
            return this.mLocaleList.size();
        }

        public String toLanguageTags() {
            return this.mLocaleList.toLanguageTags();
        }

        public String toString() {
            return this.mLocaleList.toString();
        }
    }

    private LocaleListCompat() {
    }

    public static LocaleListCompat create(Locale... localeArr) {
        LocaleListCompat localeListCompat = new LocaleListCompat();
        localeListCompat.setLocaleListArray(localeArr);
        return localeListCompat;
    }

    public static LocaleListCompat forLanguageTags(String str) {
        if (str != null) {
            if (!str.isEmpty()) {
                String[] split = str.split(",", -1);
                Locale[] localeArr = new Locale[split.length];
                for (int i = 0; i < localeArr.length; i++) {
                    localeArr[i] = VERSION.SDK_INT >= 21 ? Locale.forLanguageTag(split[i]) : LocaleHelper.forLanguageTag(split[i]);
                }
                LocaleListCompat localeListCompat = new LocaleListCompat();
                localeListCompat.setLocaleListArray(localeArr);
                return localeListCompat;
            }
        }
        return getEmptyLocaleList();
    }

    public static LocaleListCompat getAdjustedDefault() {
        if (VERSION.SDK_INT >= 24) {
            return wrap(LocaleList.getAdjustedDefault());
        }
        return create(Locale.getDefault());
    }

    public static LocaleListCompat getDefault() {
        if (VERSION.SDK_INT >= 24) {
            return wrap(LocaleList.getDefault());
        }
        return create(Locale.getDefault());
    }

    public static LocaleListCompat getEmptyLocaleList() {
        return sEmptyLocaleList;
    }

    private void setLocaleList(LocaleList localeList) {
        int size = localeList.size();
        if (size > 0) {
            Locale[] localeArr = new Locale[size];
            for (int i = 0; i < size; i++) {
                localeArr[i] = localeList.get(i);
            }
            IMPL.setLocaleList(localeArr);
        }
    }

    private void setLocaleListArray(Locale... localeArr) {
        IMPL.setLocaleList(localeArr);
    }

    public static LocaleListCompat wrap(Object obj) {
        LocaleListCompat localeListCompat = new LocaleListCompat();
        if (obj instanceof LocaleList) {
            localeListCompat.setLocaleList((LocaleList) obj);
        }
        return localeListCompat;
    }

    public boolean equals(Object obj) {
        return IMPL.equals(obj);
    }

    public Locale get(int i) {
        return IMPL.get(i);
    }

    public Locale getFirstMatch(String[] strArr) {
        return IMPL.getFirstMatch(strArr);
    }

    public int hashCode() {
        return IMPL.hashCode();
    }

    public int indexOf(Locale locale) {
        return IMPL.indexOf(locale);
    }

    public boolean isEmpty() {
        return IMPL.isEmpty();
    }

    public int size() {
        return IMPL.size();
    }

    public String toLanguageTags() {
        return IMPL.toLanguageTags();
    }

    public String toString() {
        return IMPL.toString();
    }

    public Object unwrap() {
        return IMPL.getLocaleList();
    }
}
