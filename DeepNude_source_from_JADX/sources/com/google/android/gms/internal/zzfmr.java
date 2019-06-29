package com.google.android.gms.internal;

import java.util.Arrays;

public final class zzfmr extends zzflm<zzfmr> implements Cloneable {
    private String tag;
    private int zzaky;
    private boolean zznet;
    private zzfmt zzorb;
    public long zzpyu = 0;
    public long zzpyv = 0;
    private long zzpyw = 0;
    private int zzpyx;
    private zzfms[] zzpyy;
    private byte[] zzpyz;
    private zzfmp zzpza;
    public byte[] zzpzb;
    private String zzpzc;
    private String zzpzd;
    private zzfmo zzpze;
    private String zzpzf;
    public long zzpzg;
    private zzfmq zzpzh;
    public byte[] zzpzi;
    private String zzpzj;
    private int zzpzk;
    private int[] zzpzl;
    private long zzpzm;
    private boolean zzpzn;

    public zzfmr() {
        String str = "";
        this.tag = str;
        this.zzpyx = 0;
        this.zzaky = 0;
        this.zznet = false;
        this.zzpyy = zzfms.zzddf();
        byte[] bArr = zzflv.zzpwe;
        this.zzpyz = bArr;
        this.zzpza = null;
        this.zzpzb = bArr;
        this.zzpzc = str;
        this.zzpzd = str;
        this.zzpze = null;
        this.zzpzf = str;
        this.zzpzg = 180000;
        this.zzpzh = null;
        this.zzpzi = bArr;
        this.zzpzj = str;
        this.zzpzk = 0;
        this.zzpzl = zzflv.zzpvy;
        this.zzpzm = 0;
        this.zzorb = null;
        this.zzpzn = false;
        this.zzpvl = null;
        this.zzpnr = -1;
    }

    private final com.google.android.gms.internal.zzfmr zzbn(com.google.android.gms.internal.zzflj r7) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        r6 = this;
    L_0x0000:
        r0 = r7.zzcxx();
        r1 = 1;
        r2 = 0;
        switch(r0) {
            case 0: goto L_0x01b3;
            case 8: goto L_0x01ab;
            case 18: goto L_0x01a3;
            case 26: goto L_0x0166;
            case 34: goto L_0x015e;
            case 50: goto L_0x0156;
            case 58: goto L_0x0144;
            case 66: goto L_0x013c;
            case 74: goto L_0x012e;
            case 80: goto L_0x0126;
            case 88: goto L_0x011e;
            case 96: goto L_0x0116;
            case 106: goto L_0x010e;
            case 114: goto L_0x0106;
            case 120: goto L_0x00fe;
            case 130: goto L_0x00f0;
            case 136: goto L_0x00e8;
            case 146: goto L_0x00e0;
            case 152: goto L_0x00ab;
            case 160: goto L_0x007a;
            case 162: goto L_0x003b;
            case 168: goto L_0x0034;
            case 176: goto L_0x002d;
            case 186: goto L_0x001e;
            case 194: goto L_0x0017;
            case 200: goto L_0x0010;
            default: goto L_0x0009;
        };
    L_0x0009:
        r0 = super.zza(r7, r0);
        if (r0 != 0) goto L_0x0000;
    L_0x000f:
        return r6;
    L_0x0010:
        r0 = r7.zzcyd();
        r6.zzpzn = r0;
        goto L_0x0000;
    L_0x0017:
        r0 = r7.readString();
        r6.zzpzj = r0;
        goto L_0x0000;
    L_0x001e:
        r0 = r6.zzorb;
        if (r0 != 0) goto L_0x0029;
    L_0x0022:
        r0 = new com.google.android.gms.internal.zzfmt;
        r0.<init>();
        r6.zzorb = r0;
    L_0x0029:
        r0 = r6.zzorb;
        goto L_0x0151;
    L_0x002d:
        r0 = r7.zzcxz();
        r6.zzpzm = r0;
        goto L_0x0000;
    L_0x0034:
        r0 = r7.zzcxz();
        r6.zzpyw = r0;
        goto L_0x0000;
    L_0x003b:
        r0 = r7.zzcym();
        r0 = r7.zzli(r0);
        r1 = r7.getPosition();
        r3 = 0;
    L_0x0048:
        r4 = r7.zzcyo();
        if (r4 <= 0) goto L_0x0054;
    L_0x004e:
        r7.zzcya();
        r3 = r3 + 1;
        goto L_0x0048;
    L_0x0054:
        r7.zzmw(r1);
        r1 = r6.zzpzl;
        if (r1 != 0) goto L_0x005d;
    L_0x005b:
        r1 = 0;
        goto L_0x005e;
    L_0x005d:
        r1 = r1.length;
    L_0x005e:
        r3 = r3 + r1;
        r3 = new int[r3];
        if (r1 == 0) goto L_0x0068;
    L_0x0063:
        r4 = r6.zzpzl;
        java.lang.System.arraycopy(r4, r2, r3, r2, r1);
    L_0x0068:
        r2 = r3.length;
        if (r1 >= r2) goto L_0x0074;
    L_0x006b:
        r2 = r7.zzcya();
        r3[r1] = r2;
        r1 = r1 + 1;
        goto L_0x0068;
    L_0x0074:
        r6.zzpzl = r3;
        r7.zzlj(r0);
        goto L_0x0000;
    L_0x007a:
        r0 = 160; // 0xa0 float:2.24E-43 double:7.9E-322;
        r0 = com.google.android.gms.internal.zzflv.zzb(r7, r0);
        r3 = r6.zzpzl;
        if (r3 != 0) goto L_0x0086;
    L_0x0084:
        r3 = 0;
        goto L_0x0087;
    L_0x0086:
        r3 = r3.length;
    L_0x0087:
        r0 = r0 + r3;
        r0 = new int[r0];
        if (r3 == 0) goto L_0x0091;
    L_0x008c:
        r4 = r6.zzpzl;
        java.lang.System.arraycopy(r4, r2, r0, r2, r3);
    L_0x0091:
        r2 = r0.length;
        r2 = r2 - r1;
        if (r3 >= r2) goto L_0x00a1;
    L_0x0095:
        r2 = r7.zzcya();
        r0[r3] = r2;
        r7.zzcxx();
        r3 = r3 + 1;
        goto L_0x0091;
    L_0x00a1:
        r1 = r7.zzcya();
        r0[r3] = r1;
        r6.zzpzl = r0;
        goto L_0x0000;
    L_0x00ab:
        r2 = r7.getPosition();
        r3 = r7.zzcya();	 Catch:{ IllegalArgumentException -> 0x00d8 }
        if (r3 == 0) goto L_0x00d4;	 Catch:{ IllegalArgumentException -> 0x00d8 }
    L_0x00b5:
        if (r3 == r1) goto L_0x00d4;	 Catch:{ IllegalArgumentException -> 0x00d8 }
    L_0x00b7:
        r1 = 2;	 Catch:{ IllegalArgumentException -> 0x00d8 }
        if (r3 != r1) goto L_0x00bb;	 Catch:{ IllegalArgumentException -> 0x00d8 }
    L_0x00ba:
        goto L_0x00d4;	 Catch:{ IllegalArgumentException -> 0x00d8 }
    L_0x00bb:
        r1 = new java.lang.IllegalArgumentException;	 Catch:{ IllegalArgumentException -> 0x00d8 }
        r4 = 45;	 Catch:{ IllegalArgumentException -> 0x00d8 }
        r5 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x00d8 }
        r5.<init>(r4);	 Catch:{ IllegalArgumentException -> 0x00d8 }
        r5.append(r3);	 Catch:{ IllegalArgumentException -> 0x00d8 }
        r3 = " is not a valid enum InternalEvent";	 Catch:{ IllegalArgumentException -> 0x00d8 }
        r5.append(r3);	 Catch:{ IllegalArgumentException -> 0x00d8 }
        r3 = r5.toString();	 Catch:{ IllegalArgumentException -> 0x00d8 }
        r1.<init>(r3);	 Catch:{ IllegalArgumentException -> 0x00d8 }
        throw r1;	 Catch:{ IllegalArgumentException -> 0x00d8 }
    L_0x00d4:
        r6.zzpzk = r3;	 Catch:{ IllegalArgumentException -> 0x00d8 }
        goto L_0x0000;
    L_0x00d8:
        r7.zzmw(r2);
        r6.zza(r7, r0);
        goto L_0x0000;
    L_0x00e0:
        r0 = r7.readBytes();
        r6.zzpzi = r0;
        goto L_0x0000;
    L_0x00e8:
        r0 = r7.zzcxz();
        r6.zzpyv = r0;
        goto L_0x0000;
    L_0x00f0:
        r0 = r6.zzpzh;
        if (r0 != 0) goto L_0x00fb;
    L_0x00f4:
        r0 = new com.google.android.gms.internal.zzfmq;
        r0.<init>();
        r6.zzpzh = r0;
    L_0x00fb:
        r0 = r6.zzpzh;
        goto L_0x0151;
    L_0x00fe:
        r0 = r7.zzcyl();
        r6.zzpzg = r0;
        goto L_0x0000;
    L_0x0106:
        r0 = r7.readString();
        r6.zzpzf = r0;
        goto L_0x0000;
    L_0x010e:
        r0 = r7.readString();
        r6.zzpzd = r0;
        goto L_0x0000;
    L_0x0116:
        r0 = r7.zzcya();
        r6.zzaky = r0;
        goto L_0x0000;
    L_0x011e:
        r0 = r7.zzcya();
        r6.zzpyx = r0;
        goto L_0x0000;
    L_0x0126:
        r0 = r7.zzcyd();
        r6.zznet = r0;
        goto L_0x0000;
    L_0x012e:
        r0 = r6.zzpza;
        if (r0 != 0) goto L_0x0139;
    L_0x0132:
        r0 = new com.google.android.gms.internal.zzfmp;
        r0.<init>();
        r6.zzpza = r0;
    L_0x0139:
        r0 = r6.zzpza;
        goto L_0x0151;
    L_0x013c:
        r0 = r7.readString();
        r6.zzpzc = r0;
        goto L_0x0000;
    L_0x0144:
        r0 = r6.zzpze;
        if (r0 != 0) goto L_0x014f;
    L_0x0148:
        r0 = new com.google.android.gms.internal.zzfmo;
        r0.<init>();
        r6.zzpze = r0;
    L_0x014f:
        r0 = r6.zzpze;
    L_0x0151:
        r7.zza(r0);
        goto L_0x0000;
    L_0x0156:
        r0 = r7.readBytes();
        r6.zzpzb = r0;
        goto L_0x0000;
    L_0x015e:
        r0 = r7.readBytes();
        r6.zzpyz = r0;
        goto L_0x0000;
    L_0x0166:
        r0 = 26;
        r0 = com.google.android.gms.internal.zzflv.zzb(r7, r0);
        r3 = r6.zzpyy;
        if (r3 != 0) goto L_0x0172;
    L_0x0170:
        r3 = 0;
        goto L_0x0173;
    L_0x0172:
        r3 = r3.length;
    L_0x0173:
        r0 = r0 + r3;
        r0 = new com.google.android.gms.internal.zzfms[r0];
        if (r3 == 0) goto L_0x017d;
    L_0x0178:
        r4 = r6.zzpyy;
        java.lang.System.arraycopy(r4, r2, r0, r2, r3);
    L_0x017d:
        r2 = r0.length;
        r2 = r2 - r1;
        if (r3 >= r2) goto L_0x0193;
    L_0x0181:
        r2 = new com.google.android.gms.internal.zzfms;
        r2.<init>();
        r0[r3] = r2;
        r2 = r0[r3];
        r7.zza(r2);
        r7.zzcxx();
        r3 = r3 + 1;
        goto L_0x017d;
    L_0x0193:
        r1 = new com.google.android.gms.internal.zzfms;
        r1.<init>();
        r0[r3] = r1;
        r1 = r0[r3];
        r7.zza(r1);
        r6.zzpyy = r0;
        goto L_0x0000;
    L_0x01a3:
        r0 = r7.readString();
        r6.tag = r0;
        goto L_0x0000;
    L_0x01ab:
        r0 = r7.zzcxz();
        r6.zzpyu = r0;
        goto L_0x0000;
    L_0x01b3:
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfmr.zzbn(com.google.android.gms.internal.zzflj):com.google.android.gms.internal.zzfmr");
    }

    private final zzfmr zzdde() {
        try {
            zzfmr zzfmr = (zzfmr) super.zzdck();
            zzfms[] zzfmsArr = this.zzpyy;
            if (zzfmsArr != null && zzfmsArr.length > 0) {
                zzfmr.zzpyy = new zzfms[zzfmsArr.length];
                int i = 0;
                while (true) {
                    zzfms[] zzfmsArr2 = this.zzpyy;
                    if (i >= zzfmsArr2.length) {
                        break;
                    }
                    if (zzfmsArr2[i] != null) {
                        zzfmr.zzpyy[i] = (zzfms) zzfmsArr2[i].clone();
                    }
                    i++;
                }
            }
            zzfmp zzfmp = this.zzpza;
            if (zzfmp != null) {
                zzfmr.zzpza = (zzfmp) zzfmp.clone();
            }
            zzfmo zzfmo = this.zzpze;
            if (zzfmo != null) {
                zzfmr.zzpze = (zzfmo) zzfmo.clone();
            }
            zzfmq zzfmq = this.zzpzh;
            if (zzfmq != null) {
                zzfmr.zzpzh = (zzfmq) zzfmq.clone();
            }
            Object obj = this.zzpzl;
            if (obj != null && obj.length > 0) {
                zzfmr.zzpzl = (int[]) obj.clone();
            }
            zzfmt zzfmt = this.zzorb;
            if (zzfmt != null) {
                zzfmr.zzorb = (zzfmt) zzfmt.clone();
            }
            return zzfmr;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final /* synthetic */ Object clone() {
        return zzdde();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfmr)) {
            return false;
        }
        zzfmr zzfmr = (zzfmr) obj;
        if (this.zzpyu != zzfmr.zzpyu || this.zzpyv != zzfmr.zzpyv || this.zzpyw != zzfmr.zzpyw) {
            return false;
        }
        String str = this.tag;
        if (str == null) {
            if (zzfmr.tag != null) {
                return false;
            }
        } else if (!str.equals(zzfmr.tag)) {
            return false;
        }
        if (this.zzpyx != zzfmr.zzpyx || this.zzaky != zzfmr.zzaky || this.zznet != zzfmr.zznet || !zzflq.equals(this.zzpyy, zzfmr.zzpyy) || !Arrays.equals(this.zzpyz, zzfmr.zzpyz)) {
            return false;
        }
        zzfmp zzfmp = this.zzpza;
        if (zzfmp == null) {
            if (zzfmr.zzpza != null) {
                return false;
            }
        } else if (!zzfmp.equals(zzfmr.zzpza)) {
            return false;
        }
        if (!Arrays.equals(this.zzpzb, zzfmr.zzpzb)) {
            return false;
        }
        str = this.zzpzc;
        if (str == null) {
            if (zzfmr.zzpzc != null) {
                return false;
            }
        } else if (!str.equals(zzfmr.zzpzc)) {
            return false;
        }
        str = this.zzpzd;
        if (str == null) {
            if (zzfmr.zzpzd != null) {
                return false;
            }
        } else if (!str.equals(zzfmr.zzpzd)) {
            return false;
        }
        zzfmo zzfmo = this.zzpze;
        if (zzfmo == null) {
            if (zzfmr.zzpze != null) {
                return false;
            }
        } else if (!zzfmo.equals(zzfmr.zzpze)) {
            return false;
        }
        str = this.zzpzf;
        if (str == null) {
            if (zzfmr.zzpzf != null) {
                return false;
            }
        } else if (!str.equals(zzfmr.zzpzf)) {
            return false;
        }
        if (this.zzpzg != zzfmr.zzpzg) {
            return false;
        }
        zzfmq zzfmq = this.zzpzh;
        if (zzfmq == null) {
            if (zzfmr.zzpzh != null) {
                return false;
            }
        } else if (!zzfmq.equals(zzfmr.zzpzh)) {
            return false;
        }
        if (!Arrays.equals(this.zzpzi, zzfmr.zzpzi)) {
            return false;
        }
        str = this.zzpzj;
        if (str == null) {
            if (zzfmr.zzpzj != null) {
                return false;
            }
        } else if (!str.equals(zzfmr.zzpzj)) {
            return false;
        }
        if (this.zzpzk != zzfmr.zzpzk || !zzflq.equals(this.zzpzl, zzfmr.zzpzl) || this.zzpzm != zzfmr.zzpzm) {
            return false;
        }
        zzfmt zzfmt = this.zzorb;
        if (zzfmt == null) {
            if (zzfmr.zzorb != null) {
                return false;
            }
        } else if (!zzfmt.equals(zzfmr.zzorb)) {
            return false;
        }
        if (this.zzpzn != zzfmr.zzpzn) {
            return false;
        }
        zzflo zzflo = this.zzpvl;
        if (zzflo != null) {
            if (!zzflo.isEmpty()) {
                return this.zzpvl.equals(zzfmr.zzpvl);
            }
        }
        zzflo zzflo2 = zzfmr.zzpvl;
        if (zzflo2 != null) {
            if (!zzflo2.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int hashCode = (zzfmr.class.getName().hashCode() + 527) * 31;
        long j = this.zzpyu;
        hashCode = (hashCode + ((int) (j ^ (j >>> 32)))) * 31;
        j = this.zzpyv;
        hashCode = (hashCode + ((int) (j ^ (j >>> 32)))) * 31;
        j = this.zzpyw;
        hashCode = (hashCode + ((int) (j ^ (j >>> 32)))) * 31;
        String str = this.tag;
        int i = 0;
        int i2 = 1231;
        hashCode = ((((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.zzpyx) * 31) + this.zzaky) * 31) + (this.zznet ? 1231 : 1237)) * 31) + zzflq.hashCode(this.zzpyy)) * 31) + Arrays.hashCode(this.zzpyz);
        zzfmp zzfmp = this.zzpza;
        hashCode = ((((hashCode * 31) + (zzfmp == null ? 0 : zzfmp.hashCode())) * 31) + Arrays.hashCode(this.zzpzb)) * 31;
        str = this.zzpzc;
        hashCode = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        str = this.zzpzd;
        hashCode += str == null ? 0 : str.hashCode();
        zzfmo zzfmo = this.zzpze;
        hashCode = ((hashCode * 31) + (zzfmo == null ? 0 : zzfmo.hashCode())) * 31;
        str = this.zzpzf;
        hashCode = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        long j2 = this.zzpzg;
        hashCode += (int) (j2 ^ (j2 >>> 32));
        zzfmq zzfmq = this.zzpzh;
        hashCode = ((((hashCode * 31) + (zzfmq == null ? 0 : zzfmq.hashCode())) * 31) + Arrays.hashCode(this.zzpzi)) * 31;
        str = this.zzpzj;
        hashCode = (((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.zzpzk) * 31) + zzflq.hashCode(this.zzpzl)) * 31;
        j2 = this.zzpzm;
        hashCode += (int) (j2 ^ (j2 >>> 32));
        zzfmt zzfmt = this.zzorb;
        hashCode = ((hashCode * 31) + (zzfmt == null ? 0 : zzfmt.hashCode())) * 31;
        if (!this.zzpzn) {
            i2 = 1237;
        }
        hashCode = (hashCode + i2) * 31;
        zzflo zzflo = this.zzpvl;
        if (zzflo != null) {
            if (!zzflo.isEmpty()) {
                i = this.zzpvl.hashCode();
            }
        }
        return hashCode + i;
    }

    public final /* synthetic */ zzfls zza(zzflj zzflj) {
        zzbn(zzflj);
        return this;
    }

    public final void zza(zzflk zzflk) {
        int i;
        long j = this.zzpyu;
        if (j != 0) {
            zzflk.zzf(1, j);
        }
        String str = this.tag;
        String str2 = "";
        if (!(str == null || str.equals(str2))) {
            zzflk.zzp(2, this.tag);
        }
        zzfms[] zzfmsArr = this.zzpyy;
        int i2 = 0;
        if (zzfmsArr != null && zzfmsArr.length > 0) {
            i = 0;
            while (true) {
                zzfms[] zzfmsArr2 = this.zzpyy;
                if (i >= zzfmsArr2.length) {
                    break;
                }
                zzfls zzfls = zzfmsArr2[i];
                if (zzfls != null) {
                    zzflk.zza(3, zzfls);
                }
                i++;
            }
        }
        if (!Arrays.equals(this.zzpyz, zzflv.zzpwe)) {
            zzflk.zzc(4, this.zzpyz);
        }
        if (!Arrays.equals(this.zzpzb, zzflv.zzpwe)) {
            zzflk.zzc(6, this.zzpzb);
        }
        zzfls zzfls2 = this.zzpze;
        if (zzfls2 != null) {
            zzflk.zza(7, zzfls2);
        }
        str = this.zzpzc;
        if (!(str == null || str.equals(str2))) {
            zzflk.zzp(8, this.zzpzc);
        }
        zzfls2 = this.zzpza;
        if (zzfls2 != null) {
            zzflk.zza(9, zzfls2);
        }
        boolean z = this.zznet;
        if (z) {
            zzflk.zzl(10, z);
        }
        i = this.zzpyx;
        if (i != 0) {
            zzflk.zzad(11, i);
        }
        i = this.zzaky;
        if (i != 0) {
            zzflk.zzad(12, i);
        }
        str = this.zzpzd;
        if (!(str == null || str.equals(str2))) {
            zzflk.zzp(13, this.zzpzd);
        }
        str = this.zzpzf;
        if (!(str == null || str.equals(str2))) {
            zzflk.zzp(14, this.zzpzf);
        }
        long j2 = this.zzpzg;
        if (j2 != 180000) {
            zzflk.zzg(15, j2);
        }
        zzfls2 = this.zzpzh;
        if (zzfls2 != null) {
            zzflk.zza(16, zzfls2);
        }
        j2 = this.zzpyv;
        if (j2 != 0) {
            zzflk.zzf(17, j2);
        }
        if (!Arrays.equals(this.zzpzi, zzflv.zzpwe)) {
            zzflk.zzc(18, this.zzpzi);
        }
        i = this.zzpzk;
        if (i != 0) {
            zzflk.zzad(19, i);
        }
        int[] iArr = this.zzpzl;
        if (iArr != null && iArr.length > 0) {
            while (true) {
                iArr = this.zzpzl;
                if (i2 >= iArr.length) {
                    break;
                }
                zzflk.zzad(20, iArr[i2]);
                i2++;
            }
        }
        long j3 = this.zzpyw;
        if (j3 != 0) {
            zzflk.zzf(21, j3);
        }
        j3 = this.zzpzm;
        if (j3 != 0) {
            zzflk.zzf(22, j3);
        }
        zzfls2 = this.zzorb;
        if (zzfls2 != null) {
            zzflk.zza(23, zzfls2);
        }
        str = this.zzpzj;
        if (!(str == null || str.equals(str2))) {
            zzflk.zzp(24, this.zzpzj);
        }
        z = this.zzpzn;
        if (z) {
            zzflk.zzl(25, z);
        }
        super.zza(zzflk);
    }

    public final /* synthetic */ zzflm zzdck() {
        return (zzfmr) clone();
    }

    public final /* synthetic */ zzfls zzdcl() {
        return (zzfmr) clone();
    }

    protected final int zzq() {
        int i;
        int zzq = super.zzq();
        long j = this.zzpyu;
        if (j != 0) {
            zzq += zzflk.zzc(1, j);
        }
        String str = this.tag;
        String str2 = "";
        if (!(str == null || str.equals(str2))) {
            zzq += zzflk.zzq(2, this.tag);
        }
        zzfms[] zzfmsArr = this.zzpyy;
        int i2 = 0;
        if (zzfmsArr != null && zzfmsArr.length > 0) {
            i = zzq;
            zzq = 0;
            while (true) {
                zzfms[] zzfmsArr2 = this.zzpyy;
                if (zzq >= zzfmsArr2.length) {
                    break;
                }
                zzfls zzfls = zzfmsArr2[zzq];
                if (zzfls != null) {
                    i += zzflk.zzb(3, zzfls);
                }
                zzq++;
            }
            zzq = i;
        }
        if (!Arrays.equals(this.zzpyz, zzflv.zzpwe)) {
            zzq += zzflk.zzd(4, this.zzpyz);
        }
        if (!Arrays.equals(this.zzpzb, zzflv.zzpwe)) {
            zzq += zzflk.zzd(6, this.zzpzb);
        }
        zzfls zzfls2 = this.zzpze;
        if (zzfls2 != null) {
            zzq += zzflk.zzb(7, zzfls2);
        }
        str = this.zzpzc;
        if (!(str == null || str.equals(str2))) {
            zzq += zzflk.zzq(8, this.zzpzc);
        }
        zzfls2 = this.zzpza;
        if (zzfls2 != null) {
            zzq += zzflk.zzb(9, zzfls2);
        }
        if (this.zznet) {
            zzq += zzflk.zzlw(10) + 1;
        }
        i = this.zzpyx;
        if (i != 0) {
            zzq += zzflk.zzag(11, i);
        }
        i = this.zzaky;
        if (i != 0) {
            zzq += zzflk.zzag(12, i);
        }
        str = this.zzpzd;
        if (!(str == null || str.equals(str2))) {
            zzq += zzflk.zzq(13, this.zzpzd);
        }
        str = this.zzpzf;
        if (!(str == null || str.equals(str2))) {
            zzq += zzflk.zzq(14, this.zzpzf);
        }
        long j2 = this.zzpzg;
        if (j2 != 180000) {
            zzq += zzflk.zzh(15, j2);
        }
        zzfls2 = this.zzpzh;
        if (zzfls2 != null) {
            zzq += zzflk.zzb(16, zzfls2);
        }
        j2 = this.zzpyv;
        if (j2 != 0) {
            zzq += zzflk.zzc(17, j2);
        }
        if (!Arrays.equals(this.zzpzi, zzflv.zzpwe)) {
            zzq += zzflk.zzd(18, this.zzpzi);
        }
        i = this.zzpzk;
        if (i != 0) {
            zzq += zzflk.zzag(19, i);
        }
        int[] iArr = this.zzpzl;
        if (iArr != null && iArr.length > 0) {
            int[] iArr2;
            i = 0;
            while (true) {
                iArr2 = this.zzpzl;
                if (i2 >= iArr2.length) {
                    break;
                }
                i += zzflk.zzlx(iArr2[i2]);
                i2++;
            }
            zzq = (zzq + i) + (iArr2.length * 2);
        }
        j = this.zzpyw;
        if (j != 0) {
            zzq += zzflk.zzc(21, j);
        }
        j = this.zzpzm;
        if (j != 0) {
            zzq += zzflk.zzc(22, j);
        }
        zzfls2 = this.zzorb;
        if (zzfls2 != null) {
            zzq += zzflk.zzb(23, zzfls2);
        }
        str = this.zzpzj;
        if (!(str == null || str.equals(str2))) {
            zzq += zzflk.zzq(24, this.zzpzj);
        }
        return this.zzpzn ? zzq + (zzflk.zzlw(25) + 1) : zzq;
    }
}
