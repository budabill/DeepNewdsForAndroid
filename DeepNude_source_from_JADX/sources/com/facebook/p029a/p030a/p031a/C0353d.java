package com.facebook.p029a.p030a.p031a;

import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;

/* renamed from: com.facebook.a.a.a.d */
public class C0353d {
    /* renamed from: a */
    public static boolean m594a(View view) {
        if (!(view instanceof TextView)) {
            return false;
        }
        TextView textView = (TextView) view;
        return C0353d.m597c(textView) || C0353d.m595a(textView) || C0353d.m598d(textView) || C0353d.m600f(textView) || C0353d.m599e(textView) || C0353d.m596b(textView);
    }

    /* renamed from: a */
    private static boolean m595a(TextView textView) {
        String replaceAll = C0355f.m616h(textView).replaceAll("\\s", "");
        int length = replaceAll.length();
        boolean z = false;
        if (length >= 12) {
            if (length <= 19) {
                length--;
                int i = 0;
                int i2 = 0;
                while (length >= 0) {
                    char charAt = replaceAll.charAt(length);
                    if (charAt >= '0') {
                        if (charAt <= '9') {
                            int i3 = charAt - 48;
                            if (i2 != 0) {
                                i3 *= 2;
                                if (i3 > 9) {
                                    i3 = (i3 % 10) + 1;
                                }
                            }
                            i += i3;
                            i2 ^= 1;
                            length--;
                        }
                    }
                    return false;
                }
                if (i % 10 == 0) {
                    z = true;
                }
            }
        }
        return z;
    }

    /* renamed from: b */
    private static boolean m596b(TextView textView) {
        if (textView.getInputType() == 32) {
            return true;
        }
        CharSequence h = C0355f.m616h(textView);
        if (h != null) {
            if (h.length() != 0) {
                return Patterns.EMAIL_ADDRESS.matcher(h).matches();
            }
        }
        return false;
    }

    /* renamed from: c */
    private static boolean m597c(TextView textView) {
        return textView.getInputType() == 128 ? true : textView.getTransformationMethod() instanceof PasswordTransformationMethod;
    }

    /* renamed from: d */
    private static boolean m598d(TextView textView) {
        return textView.getInputType() == 96;
    }

    /* renamed from: e */
    private static boolean m599e(TextView textView) {
        return textView.getInputType() == 3;
    }

    /* renamed from: f */
    private static boolean m600f(TextView textView) {
        return textView.getInputType() == 112;
    }
}
