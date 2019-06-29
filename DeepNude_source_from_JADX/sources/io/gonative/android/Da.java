package io.gonative.android;

import io.gonative.android.p038a.C0700a;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Da extends CookieManager {
    /* renamed from: a */
    private android.webkit.CookieManager f1443a;

    public Da() {
        this(null, null);
    }

    Da(CookieStore cookieStore, CookiePolicy cookiePolicy) {
        super(null, cookiePolicy);
        this.f1443a = android.webkit.CookieManager.getInstance();
    }

    public Map<String, List<String>> get(URI uri, Map<String, List<String>> map) {
        if (uri == null || map == null) {
            throw new IllegalArgumentException("Argument is null");
        }
        String uri2 = uri.toString();
        map = new HashMap();
        if (this.f1443a.getCookie(uri2) != null) {
            map.put("Cookie", Arrays.asList(new String[]{this.f1443a.getCookie(uri2)}));
        }
        return map;
    }

    public CookieStore getCookieStore() {
        throw new UnsupportedOperationException();
    }

    public void put(URI uri, Map<String, List<String>> map) {
        Da da = this;
        Map<String, List<String>> map2 = map;
        if (uri == null) {
            return;
        }
        if (map2 != null) {
            String uri2 = uri.toString();
            String str = null;
            int i = C0700a.m1851a(null).f1542n;
            for (String str2 : map.keySet()) {
                if (str2 != null) {
                    if (str2.equalsIgnoreCase("Set-Cookie2") || str2.equalsIgnoreCase("Set-Cookie")) {
                        for (String str3 : (List) map2.get(str2)) {
                            Object obj = 1;
                            if (i > 0) {
                                for (HttpCookie httpCookie : HttpCookie.parse(str3)) {
                                    if (httpCookie.getMaxAge() < 0 || httpCookie.getDiscard()) {
                                        StringBuilder stringBuilder;
                                        httpCookie.setMaxAge((long) i);
                                        httpCookie.setDiscard(false);
                                        if (str == null) {
                                            Calendar instance = Calendar.getInstance();
                                            instance.add(13, i);
                                            Date time = instance.getTime();
                                            stringBuilder = new StringBuilder();
                                            stringBuilder.append("; expires=");
                                            stringBuilder.append(C0726s.m1967a(time));
                                            stringBuilder.append("; Max-Age=");
                                            stringBuilder.append(Integer.toString(i));
                                            str = stringBuilder.toString();
                                        }
                                        stringBuilder = new StringBuilder();
                                        stringBuilder.append(httpCookie.toString());
                                        stringBuilder.append(str);
                                        if (httpCookie.getPath() != null) {
                                            stringBuilder.append("; path=");
                                            stringBuilder.append(httpCookie.getPath());
                                        }
                                        if (httpCookie.getDomain() != null) {
                                            stringBuilder.append("; domain=");
                                            stringBuilder.append(httpCookie.getDomain());
                                        }
                                        if (httpCookie.getSecure()) {
                                            stringBuilder.append("; secure");
                                        }
                                        da.f1443a.setCookie(uri2, stringBuilder.toString());
                                        obj = null;
                                    }
                                }
                            }
                            if (obj != null) {
                                da.f1443a.setCookie(uri2, str3);
                            }
                        }
                    }
                }
            }
        }
    }
}
