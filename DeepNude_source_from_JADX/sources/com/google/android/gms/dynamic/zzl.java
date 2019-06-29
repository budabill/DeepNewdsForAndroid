package com.google.android.gms.dynamic;

import com.google.android.gms.internal.zzew;

public abstract class zzl extends zzew implements zzk {
    public zzl() {
        attachInterface(this, "com.google.android.gms.dynamic.IFragmentWrapper");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTransact(int r3, android.os.Parcel r4, android.os.Parcel r5, int r6) {
        /*
        r2 = this;
        r6 = r2.zza(r3, r4, r5, r6);
        r0 = 1;
        if (r6 == 0) goto L_0x0008;
    L_0x0007:
        return r0;
    L_0x0008:
        r6 = 0;
        r1 = "com.google.android.gms.dynamic.IObjectWrapper";
        switch(r3) {
            case 2: goto L_0x00f5;
            case 3: goto L_0x00ea;
            case 4: goto L_0x00df;
            case 5: goto L_0x00da;
            case 6: goto L_0x00d5;
            case 7: goto L_0x00ca;
            case 8: goto L_0x00bf;
            case 9: goto L_0x00ba;
            case 10: goto L_0x00b5;
            case 11: goto L_0x00b0;
            case 12: goto L_0x00ab;
            case 13: goto L_0x00a6;
            case 14: goto L_0x00a1;
            case 15: goto L_0x009c;
            case 16: goto L_0x0097;
            case 17: goto L_0x0092;
            case 18: goto L_0x008d;
            case 19: goto L_0x0088;
            case 20: goto L_0x006c;
            case 21: goto L_0x0060;
            case 22: goto L_0x0058;
            case 23: goto L_0x0050;
            case 24: goto L_0x0048;
            case 25: goto L_0x003c;
            case 26: goto L_0x002c;
            case 27: goto L_0x0010;
            default: goto L_0x000e;
        };
    L_0x000e:
        r3 = 0;
        return r3;
    L_0x0010:
        r3 = r4.readStrongBinder();
        if (r3 != 0) goto L_0x0017;
    L_0x0016:
        goto L_0x0028;
    L_0x0017:
        r4 = r3.queryLocalInterface(r1);
        r6 = r4 instanceof com.google.android.gms.dynamic.IObjectWrapper;
        if (r6 == 0) goto L_0x0023;
    L_0x001f:
        r6 = r4;
        r6 = (com.google.android.gms.dynamic.IObjectWrapper) r6;
        goto L_0x0028;
    L_0x0023:
        r6 = new com.google.android.gms.dynamic.zzm;
        r6.<init>(r3);
    L_0x0028:
        r2.zzx(r6);
        goto L_0x0067;
    L_0x002c:
        r3 = android.content.Intent.CREATOR;
        r3 = com.google.android.gms.internal.zzex.zza(r4, r3);
        r3 = (android.content.Intent) r3;
        r4 = r4.readInt();
        r2.startActivityForResult(r3, r4);
        goto L_0x0067;
    L_0x003c:
        r3 = android.content.Intent.CREATOR;
        r3 = com.google.android.gms.internal.zzex.zza(r4, r3);
        r3 = (android.content.Intent) r3;
        r2.startActivity(r3);
        goto L_0x0067;
    L_0x0048:
        r3 = com.google.android.gms.internal.zzex.zza(r4);
        r2.setUserVisibleHint(r3);
        goto L_0x0067;
    L_0x0050:
        r3 = com.google.android.gms.internal.zzex.zza(r4);
        r2.setRetainInstance(r3);
        goto L_0x0067;
    L_0x0058:
        r3 = com.google.android.gms.internal.zzex.zza(r4);
        r2.setMenuVisibility(r3);
        goto L_0x0067;
    L_0x0060:
        r3 = com.google.android.gms.internal.zzex.zza(r4);
        r2.setHasOptionsMenu(r3);
    L_0x0067:
        r5.writeNoException();
        goto L_0x00ff;
    L_0x006c:
        r3 = r4.readStrongBinder();
        if (r3 != 0) goto L_0x0073;
    L_0x0072:
        goto L_0x0084;
    L_0x0073:
        r4 = r3.queryLocalInterface(r1);
        r6 = r4 instanceof com.google.android.gms.dynamic.IObjectWrapper;
        if (r6 == 0) goto L_0x007f;
    L_0x007b:
        r6 = r4;
        r6 = (com.google.android.gms.dynamic.IObjectWrapper) r6;
        goto L_0x0084;
    L_0x007f:
        r6 = new com.google.android.gms.dynamic.zzm;
        r6.<init>(r3);
    L_0x0084:
        r2.zzw(r6);
        goto L_0x0067;
    L_0x0088:
        r3 = r2.isVisible();
        goto L_0x00ce;
    L_0x008d:
        r3 = r2.isResumed();
        goto L_0x00ce;
    L_0x0092:
        r3 = r2.isRemoving();
        goto L_0x00ce;
    L_0x0097:
        r3 = r2.isInLayout();
        goto L_0x00ce;
    L_0x009c:
        r3 = r2.isHidden();
        goto L_0x00ce;
    L_0x00a1:
        r3 = r2.isDetached();
        goto L_0x00ce;
    L_0x00a6:
        r3 = r2.isAdded();
        goto L_0x00ce;
    L_0x00ab:
        r3 = r2.getView();
        goto L_0x00f9;
    L_0x00b0:
        r3 = r2.getUserVisibleHint();
        goto L_0x00ce;
    L_0x00b5:
        r3 = r2.getTargetRequestCode();
        goto L_0x00e3;
    L_0x00ba:
        r3 = r2.zzark();
        goto L_0x00f9;
    L_0x00bf:
        r3 = r2.getTag();
        r5.writeNoException();
        r5.writeString(r3);
        goto L_0x00ff;
    L_0x00ca:
        r3 = r2.getRetainInstance();
    L_0x00ce:
        r5.writeNoException();
        com.google.android.gms.internal.zzex.zza(r5, r3);
        goto L_0x00ff;
    L_0x00d5:
        r3 = r2.zzarj();
        goto L_0x00f9;
    L_0x00da:
        r3 = r2.zzari();
        goto L_0x00f9;
    L_0x00df:
        r3 = r2.getId();
    L_0x00e3:
        r5.writeNoException();
        r5.writeInt(r3);
        goto L_0x00ff;
    L_0x00ea:
        r3 = r2.getArguments();
        r5.writeNoException();
        com.google.android.gms.internal.zzex.zzb(r5, r3);
        goto L_0x00ff;
    L_0x00f5:
        r3 = r2.zzarh();
    L_0x00f9:
        r5.writeNoException();
        com.google.android.gms.internal.zzex.zza(r5, r3);
    L_0x00ff:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamic.zzl.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
