package io.gonative.android;

import android.support.v7.widget.SearchView.OnQueryTextListener;
import android.view.MenuItem;

/* renamed from: io.gonative.android.x */
class C0887x implements OnQueryTextListener {
    /* renamed from: a */
    final /* synthetic */ MenuItem f1892a;
    /* renamed from: b */
    final /* synthetic */ MainActivity f1893b;

    C0887x(MainActivity mainActivity, MenuItem menuItem) {
        this.f1893b = mainActivity;
        this.f1892a = menuItem;
    }

    public boolean onQueryTextChange(String str) {
        return true;
    }

    public boolean onQueryTextSubmit(java.lang.String r5) {
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
        r4 = this;
        r0 = r4.f1892a;
        r0.collapseActionView();
        r0 = 1;
        r1 = "UTF-8";	 Catch:{ UnsupportedEncodingException -> 0x002c }
        r5 = java.net.URLEncoder.encode(r5, r1);	 Catch:{ UnsupportedEncodingException -> 0x002c }
        r1 = r4.f1893b;	 Catch:{ UnsupportedEncodingException -> 0x002c }
        r2 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x002c }
        r2.<init>();	 Catch:{ UnsupportedEncodingException -> 0x002c }
        r3 = r4.f1893b;	 Catch:{ UnsupportedEncodingException -> 0x002c }
        r3 = r3.getApplicationContext();	 Catch:{ UnsupportedEncodingException -> 0x002c }
        r3 = io.gonative.android.p038a.C0700a.m1851a(r3);	 Catch:{ UnsupportedEncodingException -> 0x002c }
        r3 = r3.za;	 Catch:{ UnsupportedEncodingException -> 0x002c }
        r2.append(r3);	 Catch:{ UnsupportedEncodingException -> 0x002c }
        r2.append(r5);	 Catch:{ UnsupportedEncodingException -> 0x002c }
        r5 = r2.toString();	 Catch:{ UnsupportedEncodingException -> 0x002c }
        r1.m2606d(r5);	 Catch:{ UnsupportedEncodingException -> 0x002c }
    L_0x002c:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.gonative.android.x.onQueryTextSubmit(java.lang.String):boolean");
    }
}
