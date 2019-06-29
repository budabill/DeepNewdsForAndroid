package android.support.v4.graphics;

import android.graphics.Typeface;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TypefaceCompatApi28Impl extends TypefaceCompatApi26Impl {
    private static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
    private static final String DEFAULT_FAMILY = "sans-serif";
    private static final int RESOLVE_BY_FONT_TABLE = -1;
    private static final String TAG = "TypefaceCompatApi28Impl";

    protected Typeface createFromFamiliesWithDefault(Object obj) {
        Throwable e;
        try {
            Array.set(Array.newInstance(this.mFontFamily, 1), 0, obj);
            return (Typeface) this.mCreateFromFamiliesWithDefault.invoke(null, new Object[]{r0, DEFAULT_FAMILY, Integer.valueOf(-1), Integer.valueOf(-1)});
        } catch (IllegalAccessException e2) {
            e = e2;
            throw new RuntimeException(e);
        } catch (InvocationTargetException e3) {
            e = e3;
            throw new RuntimeException(e);
        }
    }

    protected Method obtainCreateFromFamiliesWithDefaultMethod(Class cls) {
        r2 = new Class[4];
        cls = Integer.TYPE;
        r2[2] = cls;
        r2[3] = cls;
        Method declaredMethod = Typeface.class.getDeclaredMethod(CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD, r2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
