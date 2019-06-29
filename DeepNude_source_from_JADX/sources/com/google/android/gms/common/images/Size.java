package com.google.android.gms.common.images;

public final class Size {
    private final int zzalt;
    private final int zzalu;

    public Size(int i, int i2) {
        this.zzalt = i;
        this.zzalu = i2;
    }

    public static com.google.android.gms.common.images.Size parseSize(java.lang.String r4) {
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
        if (r4 == 0) goto L_0x0034;
    L_0x0002:
        r0 = 42;
        r0 = r4.indexOf(r0);
        if (r0 >= 0) goto L_0x0010;
    L_0x000a:
        r0 = 120; // 0x78 float:1.68E-43 double:5.93E-322;
        r0 = r4.indexOf(r0);
    L_0x0010:
        r1 = 0;
        if (r0 < 0) goto L_0x0030;
    L_0x0013:
        r2 = new com.google.android.gms.common.images.Size;	 Catch:{ NumberFormatException -> 0x002c }
        r3 = 0;	 Catch:{ NumberFormatException -> 0x002c }
        r3 = r4.substring(r3, r0);	 Catch:{ NumberFormatException -> 0x002c }
        r3 = java.lang.Integer.parseInt(r3);	 Catch:{ NumberFormatException -> 0x002c }
        r0 = r0 + 1;	 Catch:{ NumberFormatException -> 0x002c }
        r0 = r4.substring(r0);	 Catch:{ NumberFormatException -> 0x002c }
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ NumberFormatException -> 0x002c }
        r2.<init>(r3, r0);	 Catch:{ NumberFormatException -> 0x002c }
        return r2;
    L_0x002c:
        zzgm(r4);
        throw r1;
    L_0x0030:
        zzgm(r4);
        throw r1;
    L_0x0034:
        r4 = new java.lang.IllegalArgumentException;
        r0 = "string must not be null";
        r4.<init>(r0);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.images.Size.parseSize(java.lang.String):com.google.android.gms.common.images.Size");
    }

    private static NumberFormatException zzgm(String str) {
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 16);
        stringBuilder.append("Invalid Size: \"");
        stringBuilder.append(str);
        stringBuilder.append("\"");
        throw new NumberFormatException(stringBuilder.toString());
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof Size) {
            Size size = (Size) obj;
            return this.zzalt == size.zzalt && this.zzalu == size.zzalu;
        }
    }

    public final int getHeight() {
        return this.zzalu;
    }

    public final int getWidth() {
        return this.zzalt;
    }

    public final int hashCode() {
        int i = this.zzalu;
        int i2 = this.zzalt;
        return i ^ ((i2 >>> 16) | (i2 << 16));
    }

    public final String toString() {
        int i = this.zzalt;
        int i2 = this.zzalu;
        StringBuilder stringBuilder = new StringBuilder(23);
        stringBuilder.append(i);
        stringBuilder.append("x");
        stringBuilder.append(i2);
        return stringBuilder.toString();
    }
}
