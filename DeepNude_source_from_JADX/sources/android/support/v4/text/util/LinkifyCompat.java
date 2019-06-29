package android.support.v4.text.util;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.support.v4.util.PatternsCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.text.util.Linkify.MatchFilter;
import android.text.util.Linkify.TransformFilter;
import android.webkit.WebView;
import android.widget.TextView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class LinkifyCompat {
    private static final Comparator<LinkSpec> COMPARATOR = new C01751();
    private static final String[] EMPTY_STRING = new String[0];

    /* renamed from: android.support.v4.text.util.LinkifyCompat$1 */
    static class C01751 implements Comparator<LinkSpec> {
        C01751() {
        }

        public int compare(LinkSpec linkSpec, LinkSpec linkSpec2) {
            int i = linkSpec.start;
            int i2 = linkSpec2.start;
            if (i < i2) {
                return -1;
            }
            if (i > i2) {
                return 1;
            }
            int i3 = linkSpec.end;
            int i4 = linkSpec2.end;
            return i3 < i4 ? 1 : i3 > i4 ? -1 : 0;
        }
    }

    private static class LinkSpec {
        int end;
        URLSpan frameworkAddedSpan;
        int start;
        String url;

        LinkSpec() {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LinkifyMask {
    }

    private LinkifyCompat() {
    }

    private static void addLinkMovementMethod(TextView textView) {
        MovementMethod movementMethod = textView.getMovementMethod();
        if ((movementMethod == null || !(movementMethod instanceof LinkMovementMethod)) && textView.getLinksClickable()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public static void addLinks(TextView textView, Pattern pattern, String str) {
        if (shouldAddLinksFallbackToFramework()) {
            Linkify.addLinks(textView, pattern, str);
        } else {
            addLinks(textView, pattern, str, null, null, null);
        }
    }

    public static void addLinks(TextView textView, Pattern pattern, String str, MatchFilter matchFilter, TransformFilter transformFilter) {
        if (shouldAddLinksFallbackToFramework()) {
            Linkify.addLinks(textView, pattern, str, matchFilter, transformFilter);
        } else {
            addLinks(textView, pattern, str, null, matchFilter, transformFilter);
        }
    }

    @SuppressLint({"NewApi"})
    public static void addLinks(TextView textView, Pattern pattern, String str, String[] strArr, MatchFilter matchFilter, TransformFilter transformFilter) {
        if (shouldAddLinksFallbackToFramework()) {
            Linkify.addLinks(textView, pattern, str, strArr, matchFilter, transformFilter);
            return;
        }
        CharSequence valueOf = SpannableString.valueOf(textView.getText());
        if (addLinks((Spannable) valueOf, pattern, str, strArr, matchFilter, transformFilter)) {
            textView.setText(valueOf);
            addLinkMovementMethod(textView);
        }
    }

    public static boolean addLinks(Spannable spannable, int i) {
        if (shouldAddLinksFallbackToFramework()) {
            return Linkify.addLinks(spannable, i);
        }
        if (i == 0) {
            return false;
        }
        URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class);
        for (int length = uRLSpanArr.length - 1; length >= 0; length--) {
            spannable.removeSpan(uRLSpanArr[length]);
        }
        if ((i & 4) != 0) {
            Linkify.addLinks(spannable, 4);
        }
        ArrayList arrayList = new ArrayList();
        if ((i & 1) != 0) {
            ArrayList arrayList2 = arrayList;
            Spannable spannable2 = spannable;
            gatherLinks(arrayList2, spannable2, PatternsCompat.AUTOLINK_WEB_URL, new String[]{"http://", "https://", "rtsp://"}, Linkify.sUrlMatchFilter, null);
        }
        if ((i & 2) != 0) {
            gatherLinks(arrayList, spannable, PatternsCompat.AUTOLINK_EMAIL_ADDRESS, new String[]{"mailto:"}, null, null);
        }
        if ((i & 8) != 0) {
            gatherMapLinks(arrayList, spannable);
        }
        pruneOverlaps(arrayList, spannable);
        if (arrayList.size() == 0) {
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            LinkSpec linkSpec = (LinkSpec) it.next();
            if (linkSpec.frameworkAddedSpan == null) {
                applyLink(linkSpec.url, linkSpec.start, linkSpec.end, spannable);
            }
        }
        return true;
    }

    public static boolean addLinks(Spannable spannable, Pattern pattern, String str) {
        return shouldAddLinksFallbackToFramework() ? Linkify.addLinks(spannable, pattern, str) : addLinks(spannable, pattern, str, null, null, null);
    }

    public static boolean addLinks(Spannable spannable, Pattern pattern, String str, MatchFilter matchFilter, TransformFilter transformFilter) {
        return shouldAddLinksFallbackToFramework() ? Linkify.addLinks(spannable, pattern, str, matchFilter, transformFilter) : addLinks(spannable, pattern, str, null, matchFilter, transformFilter);
    }

    @SuppressLint({"NewApi"})
    public static boolean addLinks(Spannable spannable, Pattern pattern, String str, String[] strArr, MatchFilter matchFilter, TransformFilter transformFilter) {
        if (shouldAddLinksFallbackToFramework()) {
            return Linkify.addLinks(spannable, pattern, str, strArr, matchFilter, transformFilter);
        }
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        if (strArr == null || strArr.length < 1) {
            strArr = EMPTY_STRING;
        }
        String[] strArr2 = new String[(strArr.length + 1)];
        strArr2[0] = str.toLowerCase(Locale.ROOT);
        int i = 0;
        while (i < strArr.length) {
            String str3 = strArr[i];
            i++;
            strArr2[i] = str3 == null ? str2 : str3.toLowerCase(Locale.ROOT);
        }
        Matcher matcher = pattern.matcher(spannable);
        boolean z = false;
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            if (matchFilter != null ? matchFilter.acceptMatch(spannable, start, end) : true) {
                applyLink(makeUrl(matcher.group(0), strArr2, matcher, transformFilter), start, end, spannable);
                z = true;
            }
        }
        return z;
    }

    public static boolean addLinks(TextView textView, int i) {
        if (shouldAddLinksFallbackToFramework()) {
            return Linkify.addLinks(textView, i);
        }
        if (i == 0) {
            return false;
        }
        CharSequence text = textView.getText();
        if (!(text instanceof Spannable)) {
            Spannable valueOf = SpannableString.valueOf(text);
            if (!addLinks(valueOf, i)) {
                return false;
            }
            addLinkMovementMethod(textView);
            textView.setText(valueOf);
            return true;
        } else if (!addLinks((Spannable) text, i)) {
            return false;
        } else {
            addLinkMovementMethod(textView);
            return true;
        }
    }

    private static void applyLink(String str, int i, int i2, Spannable spannable) {
        spannable.setSpan(new URLSpan(str), i, i2, 33);
    }

    private static String findAddress(String str) {
        return VERSION.SDK_INT >= 28 ? WebView.findAddress(str) : FindAddress.findAddress(str);
    }

    private static void gatherLinks(ArrayList<LinkSpec> arrayList, Spannable spannable, Pattern pattern, String[] strArr, MatchFilter matchFilter, TransformFilter transformFilter) {
        Matcher matcher = pattern.matcher(spannable);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            if (matchFilter == null || matchFilter.acceptMatch(spannable, start, end)) {
                LinkSpec linkSpec = new LinkSpec();
                linkSpec.url = makeUrl(matcher.group(0), strArr, matcher, transformFilter);
                linkSpec.start = start;
                linkSpec.end = end;
                arrayList.add(linkSpec);
            }
        }
    }

    private static void gatherMapLinks(java.util.ArrayList<android.support.v4.text.util.LinkifyCompat.LinkSpec> r5, android.text.Spannable r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        r6 = r6.toString();
        r0 = 0;
    L_0x0005:
        r1 = findAddress(r6);	 Catch:{ UnsupportedOperationException -> 0x0043 }
        if (r1 == 0) goto L_0x0043;	 Catch:{ UnsupportedOperationException -> 0x0043 }
    L_0x000b:
        r2 = r6.indexOf(r1);	 Catch:{ UnsupportedOperationException -> 0x0043 }
        if (r2 >= 0) goto L_0x0012;	 Catch:{ UnsupportedOperationException -> 0x0043 }
    L_0x0011:
        goto L_0x0043;	 Catch:{ UnsupportedOperationException -> 0x0043 }
    L_0x0012:
        r3 = new android.support.v4.text.util.LinkifyCompat$LinkSpec;	 Catch:{ UnsupportedOperationException -> 0x0043 }
        r3.<init>();	 Catch:{ UnsupportedOperationException -> 0x0043 }
        r4 = r1.length();	 Catch:{ UnsupportedOperationException -> 0x0043 }
        r4 = r4 + r2;	 Catch:{ UnsupportedOperationException -> 0x0043 }
        r2 = r2 + r0;	 Catch:{ UnsupportedOperationException -> 0x0043 }
        r3.start = r2;	 Catch:{ UnsupportedOperationException -> 0x0043 }
        r0 = r0 + r4;	 Catch:{ UnsupportedOperationException -> 0x0043 }
        r3.end = r0;	 Catch:{ UnsupportedOperationException -> 0x0043 }
        r6 = r6.substring(r4);	 Catch:{ UnsupportedOperationException -> 0x0043 }
        r2 = "UTF-8";	 Catch:{ UnsupportedEncodingException -> 0x0005 }
        r1 = java.net.URLEncoder.encode(r1, r2);	 Catch:{ UnsupportedEncodingException -> 0x0005 }
        r2 = new java.lang.StringBuilder;	 Catch:{ UnsupportedOperationException -> 0x0043 }
        r2.<init>();	 Catch:{ UnsupportedOperationException -> 0x0043 }
        r4 = "geo:0,0?q=";	 Catch:{ UnsupportedOperationException -> 0x0043 }
        r2.append(r4);	 Catch:{ UnsupportedOperationException -> 0x0043 }
        r2.append(r1);	 Catch:{ UnsupportedOperationException -> 0x0043 }
        r1 = r2.toString();	 Catch:{ UnsupportedOperationException -> 0x0043 }
        r3.url = r1;	 Catch:{ UnsupportedOperationException -> 0x0043 }
        r5.add(r3);	 Catch:{ UnsupportedOperationException -> 0x0043 }
        goto L_0x0005;
    L_0x0043:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.text.util.LinkifyCompat.gatherMapLinks(java.util.ArrayList, android.text.Spannable):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String makeUrl(java.lang.String r7, java.lang.String[] r8, java.util.regex.Matcher r9, android.text.util.Linkify.TransformFilter r10) {
        /*
        if (r10 == 0) goto L_0x0006;
    L_0x0002:
        r7 = r10.transformUrl(r9, r7);
    L_0x0006:
        r9 = 0;
        r10 = 0;
    L_0x0008:
        r0 = r8.length;
        r6 = 1;
        if (r10 >= r0) goto L_0x004f;
    L_0x000c:
        r1 = 1;
        r2 = 0;
        r3 = r8[r10];
        r4 = 0;
        r0 = r8[r10];
        r5 = r0.length();
        r0 = r7;
        r0 = r0.regionMatches(r1, r2, r3, r4, r5);
        if (r0 == 0) goto L_0x004c;
    L_0x001e:
        r1 = 0;
        r2 = 0;
        r3 = r8[r10];
        r4 = 0;
        r0 = r8[r10];
        r5 = r0.length();
        r0 = r7;
        r0 = r0.regionMatches(r1, r2, r3, r4, r5);
        if (r0 != 0) goto L_0x0050;
    L_0x0030:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = r8[r10];
        r0.append(r1);
        r10 = r8[r10];
        r10 = r10.length();
        r7 = r7.substring(r10);
        r0.append(r7);
        r7 = r0.toString();
        goto L_0x0050;
    L_0x004c:
        r10 = r10 + 1;
        goto L_0x0008;
    L_0x004f:
        r6 = 0;
    L_0x0050:
        if (r6 != 0) goto L_0x0066;
    L_0x0052:
        r10 = r8.length;
        if (r10 <= 0) goto L_0x0066;
    L_0x0055:
        r10 = new java.lang.StringBuilder;
        r10.<init>();
        r8 = r8[r9];
        r10.append(r8);
        r10.append(r7);
        r7 = r10.toString();
    L_0x0066:
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.text.util.LinkifyCompat.makeUrl(java.lang.String, java.lang.String[], java.util.regex.Matcher, android.text.util.Linkify$TransformFilter):java.lang.String");
    }

    private static void pruneOverlaps(ArrayList<LinkSpec> arrayList, Spannable spannable) {
        int i;
        int i2 = 0;
        URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class);
        for (i = 0; i < uRLSpanArr.length; i++) {
            LinkSpec linkSpec = new LinkSpec();
            linkSpec.frameworkAddedSpan = uRLSpanArr[i];
            linkSpec.start = spannable.getSpanStart(uRLSpanArr[i]);
            linkSpec.end = spannable.getSpanEnd(uRLSpanArr[i]);
            arrayList.add(linkSpec);
        }
        Collections.sort(arrayList, COMPARATOR);
        int size = arrayList.size();
        while (i2 < size - 1) {
            LinkSpec linkSpec2 = (LinkSpec) arrayList.get(i2);
            int i3 = i2 + 1;
            LinkSpec linkSpec3 = (LinkSpec) arrayList.get(i3);
            int i4 = linkSpec2.start;
            int i5 = linkSpec3.start;
            if (i4 <= i5) {
                i = linkSpec2.end;
                if (i > i5) {
                    URLSpan uRLSpan;
                    int i6 = linkSpec3.end;
                    if (i6 > i) {
                        if (i - i4 <= i6 - i5) {
                            i = i - i4 < i6 - i5 ? i2 : -1;
                            if (i != -1) {
                                uRLSpan = ((LinkSpec) arrayList.get(i)).frameworkAddedSpan;
                                if (uRLSpan != null) {
                                    spannable.removeSpan(uRLSpan);
                                }
                                arrayList.remove(i);
                                size--;
                            }
                        }
                    }
                    i = i3;
                    if (i != -1) {
                        uRLSpan = ((LinkSpec) arrayList.get(i)).frameworkAddedSpan;
                        if (uRLSpan != null) {
                            spannable.removeSpan(uRLSpan);
                        }
                        arrayList.remove(i);
                        size--;
                    }
                }
            }
            i2 = i3;
        }
    }

    private static boolean shouldAddLinksFallbackToFramework() {
        return VERSION.SDK_INT >= 28;
    }
}
