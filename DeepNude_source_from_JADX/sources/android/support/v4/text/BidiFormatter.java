package android.support.v4.text;

import android.text.SpannableStringBuilder;
import java.util.Locale;

public final class BidiFormatter {
    private static final int DEFAULT_FLAGS = 2;
    static final BidiFormatter DEFAULT_LTR_INSTANCE = new BidiFormatter(false, 2, DEFAULT_TEXT_DIRECTION_HEURISTIC);
    static final BidiFormatter DEFAULT_RTL_INSTANCE = new BidiFormatter(true, 2, DEFAULT_TEXT_DIRECTION_HEURISTIC);
    static final TextDirectionHeuristicCompat DEFAULT_TEXT_DIRECTION_HEURISTIC = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
    private static final int DIR_LTR = -1;
    private static final int DIR_RTL = 1;
    private static final int DIR_UNKNOWN = 0;
    private static final String EMPTY_STRING = "";
    private static final int FLAG_STEREO_RESET = 2;
    private static final char LRE = '‪';
    private static final char LRM = '‎';
    private static final String LRM_STRING = Character.toString(LRM);
    private static final char PDF = '‬';
    private static final char RLE = '‫';
    private static final char RLM = '‏';
    private static final String RLM_STRING = Character.toString(RLM);
    private final TextDirectionHeuristicCompat mDefaultTextDirectionHeuristicCompat;
    private final int mFlags;
    private final boolean mIsRtlContext;

    public static final class Builder {
        private int mFlags;
        private boolean mIsRtlContext;
        private TextDirectionHeuristicCompat mTextDirectionHeuristicCompat;

        public Builder() {
            initialize(BidiFormatter.isRtlLocale(Locale.getDefault()));
        }

        public Builder(Locale locale) {
            initialize(BidiFormatter.isRtlLocale(locale));
        }

        public Builder(boolean z) {
            initialize(z);
        }

        private static BidiFormatter getDefaultInstanceFromContext(boolean z) {
            return z ? BidiFormatter.DEFAULT_RTL_INSTANCE : BidiFormatter.DEFAULT_LTR_INSTANCE;
        }

        private void initialize(boolean z) {
            this.mIsRtlContext = z;
            this.mTextDirectionHeuristicCompat = BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC;
            this.mFlags = 2;
        }

        public BidiFormatter build() {
            return (this.mFlags == 2 && this.mTextDirectionHeuristicCompat == BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC) ? getDefaultInstanceFromContext(this.mIsRtlContext) : new BidiFormatter(this.mIsRtlContext, this.mFlags, this.mTextDirectionHeuristicCompat);
        }

        public Builder setTextDirectionHeuristic(TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
            this.mTextDirectionHeuristicCompat = textDirectionHeuristicCompat;
            return this;
        }

        public Builder stereoReset(boolean z) {
            this.mFlags = z ? this.mFlags | 2 : this.mFlags & -3;
            return this;
        }
    }

    private static class DirectionalityEstimator {
        private static final byte[] DIR_TYPE_CACHE = new byte[DIR_TYPE_CACHE_SIZE];
        private static final int DIR_TYPE_CACHE_SIZE = 1792;
        private int charIndex;
        private final boolean isHtml;
        private char lastChar;
        private final int length;
        private final CharSequence text;

        static {
            for (int i = 0; i < DIR_TYPE_CACHE_SIZE; i++) {
                DIR_TYPE_CACHE[i] = Character.getDirectionality(i);
            }
        }

        DirectionalityEstimator(CharSequence charSequence, boolean z) {
            this.text = charSequence;
            this.isHtml = z;
            this.length = charSequence.length();
        }

        private static byte getCachedDirectionality(char c) {
            return c < '܀' ? DIR_TYPE_CACHE[c] : Character.getDirectionality(c);
        }

        private byte skipEntityBackward() {
            int i = this.charIndex;
            char c;
            do {
                int i2 = this.charIndex;
                if (i2 <= 0) {
                    break;
                }
                CharSequence charSequence = this.text;
                i2--;
                this.charIndex = i2;
                this.lastChar = charSequence.charAt(i2);
                c = this.lastChar;
                if (c == '&') {
                    return (byte) 12;
                }
            } while (c != ';');
            this.charIndex = i;
            this.lastChar = ';';
            return (byte) 13;
        }

        private byte skipEntityForward() {
            while (true) {
                int i = this.charIndex;
                if (i >= this.length) {
                    break;
                }
                CharSequence charSequence = this.text;
                this.charIndex = i + 1;
                char charAt = charSequence.charAt(i);
                this.lastChar = charAt;
                if (charAt == ';') {
                    break;
                }
            }
            return (byte) 12;
        }

        private byte skipTagBackward() {
            int i = this.charIndex;
            while (true) {
                int i2 = this.charIndex;
                if (i2 <= 0) {
                    break;
                }
                CharSequence charSequence = this.text;
                i2--;
                this.charIndex = i2;
                this.lastChar = charSequence.charAt(i2);
                char c = this.lastChar;
                if (c == '<') {
                    return (byte) 12;
                }
                if (c == '>') {
                    break;
                } else if (c == '\"' || c == '\'') {
                    c = this.lastChar;
                    while (true) {
                        int i3 = this.charIndex;
                        if (i3 <= 0) {
                            break;
                        }
                        charSequence = this.text;
                        i3--;
                        this.charIndex = i3;
                        char charAt = charSequence.charAt(i3);
                        this.lastChar = charAt;
                        if (charAt == c) {
                            break;
                        }
                    }
                }
            }
            this.charIndex = i;
            this.lastChar = '>';
            return (byte) 13;
        }

        private byte skipTagForward() {
            int i = this.charIndex;
            while (true) {
                int i2 = this.charIndex;
                if (i2 < this.length) {
                    CharSequence charSequence = this.text;
                    this.charIndex = i2 + 1;
                    this.lastChar = charSequence.charAt(i2);
                    char c = this.lastChar;
                    if (c == '>') {
                        return (byte) 12;
                    }
                    if (c == '\"' || c == '\'') {
                        c = this.lastChar;
                        while (true) {
                            int i3 = this.charIndex;
                            if (i3 >= this.length) {
                                break;
                            }
                            CharSequence charSequence2 = this.text;
                            this.charIndex = i3 + 1;
                            char charAt = charSequence2.charAt(i3);
                            this.lastChar = charAt;
                            if (charAt == c) {
                                break;
                            }
                        }
                    }
                } else {
                    this.charIndex = i;
                    this.lastChar = '<';
                    return (byte) 13;
                }
            }
        }

        byte dirTypeBackward() {
            this.lastChar = this.text.charAt(this.charIndex - 1);
            if (Character.isLowSurrogate(this.lastChar)) {
                int codePointBefore = Character.codePointBefore(this.text, this.charIndex);
                this.charIndex -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.charIndex--;
            byte cachedDirectionality = getCachedDirectionality(this.lastChar);
            if (this.isHtml) {
                char c = this.lastChar;
                if (c == '>') {
                    cachedDirectionality = skipTagBackward();
                } else if (c == ';') {
                    cachedDirectionality = skipEntityBackward();
                }
            }
            return cachedDirectionality;
        }

        byte dirTypeForward() {
            this.lastChar = this.text.charAt(this.charIndex);
            if (Character.isHighSurrogate(this.lastChar)) {
                int codePointAt = Character.codePointAt(this.text, this.charIndex);
                this.charIndex += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.charIndex++;
            byte cachedDirectionality = getCachedDirectionality(this.lastChar);
            if (this.isHtml) {
                char c = this.lastChar;
                if (c == '<') {
                    cachedDirectionality = skipTagForward();
                } else if (c == '&') {
                    cachedDirectionality = skipEntityForward();
                }
            }
            return cachedDirectionality;
        }

        int getEntryDir() {
            this.charIndex = 0;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (this.charIndex < this.length && i == 0) {
                byte dirTypeForward = dirTypeForward();
                if (dirTypeForward != (byte) 0) {
                    if (dirTypeForward == (byte) 1 || dirTypeForward == (byte) 2) {
                        if (i3 == 0) {
                            return 1;
                        }
                    } else if (dirTypeForward != (byte) 9) {
                        switch (dirTypeForward) {
                            case (byte) 14:
                            case (byte) 15:
                                i3++;
                                i2 = -1;
                                continue;
                            case (byte) 16:
                            case (byte) 17:
                                i3++;
                                i2 = 1;
                                continue;
                            case (byte) 18:
                                i3--;
                                i2 = 0;
                                continue;
                            default:
                                break;
                        }
                    }
                } else if (i3 == 0) {
                    return -1;
                }
                i = i3;
            }
            if (i == 0) {
                return 0;
            }
            if (i2 != 0) {
                return i2;
            }
            while (this.charIndex > 0) {
                switch (dirTypeBackward()) {
                    case (byte) 14:
                    case (byte) 15:
                        if (i == i3) {
                            return -1;
                        }
                        break;
                    case (byte) 16:
                    case (byte) 17:
                        if (i == i3) {
                            return 1;
                        }
                        break;
                    case (byte) 18:
                        i3++;
                        continue;
                    default:
                        continue;
                }
                i3--;
            }
            return 0;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        int getExitDir() {
            /*
            r7 = this;
            r0 = r7.length;
            r7.charIndex = r0;
            r0 = 0;
            r1 = 0;
            r2 = 0;
        L_0x0007:
            r3 = r7.charIndex;
            if (r3 <= 0) goto L_0x003b;
        L_0x000b:
            r3 = r7.dirTypeBackward();
            r4 = -1;
            if (r3 == 0) goto L_0x0034;
        L_0x0012:
            r5 = 1;
            if (r3 == r5) goto L_0x002e;
        L_0x0015:
            r6 = 2;
            if (r3 == r6) goto L_0x002e;
        L_0x0018:
            r6 = 9;
            if (r3 == r6) goto L_0x0007;
        L_0x001c:
            switch(r3) {
                case 14: goto L_0x0028;
                case 15: goto L_0x0028;
                case 16: goto L_0x0025;
                case 17: goto L_0x0025;
                case 18: goto L_0x0022;
                default: goto L_0x001f;
            };
        L_0x001f:
            if (r1 != 0) goto L_0x0007;
        L_0x0021:
            goto L_0x0039;
        L_0x0022:
            r2 = r2 + 1;
            goto L_0x0007;
        L_0x0025:
            if (r1 != r2) goto L_0x002b;
        L_0x0027:
            return r5;
        L_0x0028:
            if (r1 != r2) goto L_0x002b;
        L_0x002a:
            return r4;
        L_0x002b:
            r2 = r2 + -1;
            goto L_0x0007;
        L_0x002e:
            if (r2 != 0) goto L_0x0031;
        L_0x0030:
            return r5;
        L_0x0031:
            if (r1 != 0) goto L_0x0007;
        L_0x0033:
            goto L_0x0039;
        L_0x0034:
            if (r2 != 0) goto L_0x0037;
        L_0x0036:
            return r4;
        L_0x0037:
            if (r1 != 0) goto L_0x0007;
        L_0x0039:
            r1 = r2;
            goto L_0x0007;
        L_0x003b:
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.text.BidiFormatter.DirectionalityEstimator.getExitDir():int");
        }
    }

    BidiFormatter(boolean z, int i, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        this.mIsRtlContext = z;
        this.mFlags = i;
        this.mDefaultTextDirectionHeuristicCompat = textDirectionHeuristicCompat;
    }

    private static int getEntryDir(CharSequence charSequence) {
        return new DirectionalityEstimator(charSequence, false).getEntryDir();
    }

    private static int getExitDir(CharSequence charSequence) {
        return new DirectionalityEstimator(charSequence, false).getExitDir();
    }

    public static BidiFormatter getInstance() {
        return new Builder().build();
    }

    public static BidiFormatter getInstance(Locale locale) {
        return new Builder(locale).build();
    }

    public static BidiFormatter getInstance(boolean z) {
        return new Builder(z).build();
    }

    static boolean isRtlLocale(Locale locale) {
        return TextUtilsCompat.getLayoutDirectionFromLocale(locale) == 1;
    }

    private String markAfter(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        return (this.mIsRtlContext || !(isRtl || getExitDir(charSequence) == 1)) ? (!this.mIsRtlContext || (isRtl && getExitDir(charSequence) != -1)) ? "" : RLM_STRING : LRM_STRING;
    }

    private String markBefore(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        return (this.mIsRtlContext || !(isRtl || getEntryDir(charSequence) == 1)) ? (!this.mIsRtlContext || (isRtl && getEntryDir(charSequence) != -1)) ? "" : RLM_STRING : LRM_STRING;
    }

    public boolean getStereoReset() {
        return (this.mFlags & 2) != 0;
    }

    public boolean isRtl(CharSequence charSequence) {
        return this.mDefaultTextDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
    }

    public boolean isRtl(String str) {
        return isRtl((CharSequence) str);
    }

    public boolean isRtlContext() {
        return this.mIsRtlContext;
    }

    public CharSequence unicodeWrap(CharSequence charSequence) {
        return unicodeWrap(charSequence, this.mDefaultTextDirectionHeuristicCompat, true);
    }

    public CharSequence unicodeWrap(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        return unicodeWrap(charSequence, textDirectionHeuristicCompat, true);
    }

    public CharSequence unicodeWrap(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z) {
        if (charSequence == null) {
            return null;
        }
        boolean isRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        CharSequence spannableStringBuilder = new SpannableStringBuilder();
        if (getStereoReset() && z) {
            spannableStringBuilder.append(markBefore(charSequence, isRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR));
        }
        if (isRtl != this.mIsRtlContext) {
            spannableStringBuilder.append(isRtl ? RLE : LRE);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append(PDF);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z) {
            spannableStringBuilder.append(markAfter(charSequence, isRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR));
        }
        return spannableStringBuilder;
    }

    public CharSequence unicodeWrap(CharSequence charSequence, boolean z) {
        return unicodeWrap(charSequence, this.mDefaultTextDirectionHeuristicCompat, z);
    }

    public String unicodeWrap(String str) {
        return unicodeWrap(str, this.mDefaultTextDirectionHeuristicCompat, true);
    }

    public String unicodeWrap(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        return unicodeWrap(str, textDirectionHeuristicCompat, true);
    }

    public String unicodeWrap(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z) {
        return str == null ? null : unicodeWrap((CharSequence) str, textDirectionHeuristicCompat, z).toString();
    }

    public String unicodeWrap(String str, boolean z) {
        return unicodeWrap(str, this.mDefaultTextDirectionHeuristicCompat, z);
    }
}
