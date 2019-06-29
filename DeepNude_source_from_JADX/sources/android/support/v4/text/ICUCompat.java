package android.support.v4.text;

import android.os.Build.VERSION;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

public final class ICUCompat {
    private static final String TAG = "ICUCompat";
    private static Method sAddLikelySubtagsMethod;
    private static Method sGetScriptMethod;

    static {
        String str = "addLikelySubtags";
        if (VERSION.SDK_INT >= 21) {
            try {
                sAddLikelySubtagsMethod = Class.forName("libcore.icu.ICU").getMethod(str, new Class[]{Locale.class});
                return;
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
        try {
            Class cls = Class.forName("libcore.icu.ICU");
            if (cls != null) {
                sGetScriptMethod = cls.getMethod("getScript", new Class[]{String.class});
                sAddLikelySubtagsMethod = cls.getMethod(str, new Class[]{String.class});
            }
        } catch (Throwable e2) {
            sGetScriptMethod = null;
            sAddLikelySubtagsMethod = null;
            Log.w(TAG, e2);
        }
    }

    private ICUCompat() {
    }

    private static String addLikelySubtags(Locale locale) {
        Throwable e;
        String str = TAG;
        String locale2 = locale.toString();
        try {
            if (sAddLikelySubtagsMethod != null) {
                return (String) sAddLikelySubtagsMethod.invoke(null, new Object[]{locale2});
            }
        } catch (IllegalAccessException e2) {
            e = e2;
            Log.w(str, e);
            return locale2;
        } catch (InvocationTargetException e3) {
            e = e3;
            Log.w(str, e);
            return locale2;
        }
        return locale2;
    }

    private static String getScript(String str) {
        Throwable e;
        try {
            if (sGetScriptMethod != null) {
                return (String) sGetScriptMethod.invoke(null, new Object[]{str});
            }
        } catch (IllegalAccessException e2) {
            e = e2;
            Log.w(TAG, e);
            return null;
        } catch (InvocationTargetException e3) {
            e = e3;
            Log.w(TAG, e);
            return null;
        }
        return null;
    }

    public static String maximizeAndGetScript(Locale locale) {
        Throwable e;
        String str = TAG;
        if (VERSION.SDK_INT >= 21) {
            try {
                locale = ((Locale) sAddLikelySubtagsMethod.invoke(null, new Object[]{locale})).getScript();
                return locale;
            } catch (InvocationTargetException e2) {
                e = e2;
                Log.w(str, e);
                return locale.getScript();
            } catch (IllegalAccessException e3) {
                e = e3;
                Log.w(str, e);
                return locale.getScript();
            }
        }
        String addLikelySubtags = addLikelySubtags(locale);
        return addLikelySubtags != null ? getScript(addLikelySubtags) : null;
    }
}
