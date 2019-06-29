package p014c.p015a.p016a.p023d;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import p014c.p015a.p016a.C0278a;
import p014c.p015a.p016a.C0293c;
import p014c.p015a.p016a.p019b.C0283b;

/* renamed from: c.a.a.d.d */
public final class C0907d extends C0809o {

    /* renamed from: c.a.a.d.d$a */
    private enum C0294a {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    /* renamed from: a */
    private static int m2436a(CharSequence charSequence, int i, int i2) {
        C0294a a = C0907d.m2437a(charSequence, i);
        if (a != C0294a.UNCODABLE) {
            if (a != C0294a.ONE_DIGIT) {
                if (i2 == 99) {
                    return i2;
                }
                if (i2 != 100) {
                    if (a == C0294a.FNC_1) {
                        a = C0907d.m2437a(charSequence, i + 1);
                    }
                    if (a == C0294a.TWO_DIGITS) {
                        return 99;
                    }
                } else if (a == C0294a.FNC_1) {
                    return i2;
                } else {
                    a = C0907d.m2437a(charSequence, i + 2);
                    if (a != C0294a.UNCODABLE) {
                        if (a != C0294a.ONE_DIGIT) {
                            if (a == C0294a.FNC_1) {
                                return C0907d.m2437a(charSequence, i + 3) == C0294a.TWO_DIGITS ? 99 : 100;
                            } else {
                                C0294a a2;
                                i += 4;
                                while (true) {
                                    a2 = C0907d.m2437a(charSequence, i);
                                    if (a2 != C0294a.TWO_DIGITS) {
                                        break;
                                    }
                                    i += 2;
                                }
                                return a2 == C0294a.ONE_DIGIT ? 100 : 99;
                            }
                        }
                    }
                    return i2;
                }
            }
        }
        return 100;
    }

    /* renamed from: a */
    private static C0294a m2437a(CharSequence charSequence, int i) {
        int length = charSequence.length();
        if (i >= length) {
            return C0294a.UNCODABLE;
        }
        char charAt = charSequence.charAt(i);
        if (charAt == 'ñ') {
            return C0294a.FNC_1;
        }
        if (charAt >= '0') {
            if (charAt <= '9') {
                i++;
                if (i >= length) {
                    return C0294a.ONE_DIGIT;
                }
                char charAt2 = charSequence.charAt(i);
                if (charAt2 >= '0') {
                    if (charAt2 <= '9') {
                        return C0294a.TWO_DIGITS;
                    }
                }
                return C0294a.ONE_DIGIT;
            }
        }
        return C0294a.UNCODABLE;
    }

    /* renamed from: a */
    public C0283b mo941a(String str, C0278a c0278a, int i, int i2, Map<C0293c, ?> map) {
        if (c0278a == C0278a.CODE_128) {
            return super.mo941a(str, c0278a, i, i2, map);
        }
        StringBuilder stringBuilder = new StringBuilder("Can only encode CODE_128, but got ");
        stringBuilder.append(c0278a);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: a */
    public boolean[] mo1603a(String str) {
        int length = str.length();
        if (length <= 0 || length > 80) {
            StringBuilder stringBuilder = new StringBuilder("Contents length should be between 1 and 80 characters, but got ");
            stringBuilder.append(length);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt < ' ' || charAt > '~') {
                switch (charAt) {
                    case 'ñ':
                    case 'ò':
                    case 'ó':
                    case 'ô':
                        break;
                    default:
                        StringBuilder stringBuilder2 = new StringBuilder("Bad character in input: ");
                        stringBuilder2.append(charAt);
                        throw new IllegalArgumentException(stringBuilder2.toString());
                }
            }
        }
        Collection<int[]> arrayList = new ArrayList();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1;
        while (i3 < length) {
            int a = C0907d.m2436a(str, i3, i5);
            int i7 = 100;
            if (a == i5) {
                switch (str.charAt(i3)) {
                    case 'ñ':
                        i7 = 102;
                        break;
                    case 'ò':
                        i7 = 97;
                        break;
                    case 'ó':
                        i7 = 96;
                        break;
                    case 'ô':
                        break;
                    default:
                        if (i5 != 100) {
                            i7 = Integer.parseInt(str.substring(i3, i3 + 2));
                            i3++;
                            break;
                        }
                        i7 = str.charAt(i3) - 32;
                        break;
                }
                i3++;
            } else {
                i7 = i5 == 0 ? a == 100 ? 104 : 105 : a;
                i5 = a;
            }
            arrayList.add(C0906c.f1940a[i7]);
            i4 += i7 * i6;
            if (i3 != 0) {
                i6++;
            }
        }
        arrayList.add(C0906c.f1940a[i4 % 103]);
        arrayList.add(C0906c.f1940a[106]);
        length = 0;
        for (int[] iArr : arrayList) {
            i4 = length;
            for (int i52 : (int[]) r12.next()) {
                i4 += i52;
            }
            length = i4;
        }
        boolean[] zArr = new boolean[length];
        for (int[] a2 : arrayList) {
            i += C0809o.m2096a(zArr, i, a2, true);
        }
        return zArr;
    }
}
