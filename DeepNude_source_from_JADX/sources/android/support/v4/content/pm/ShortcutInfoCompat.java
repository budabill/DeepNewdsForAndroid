package android.support.v4.content.pm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.support.v4.graphics.drawable.IconCompat;
import android.text.TextUtils;
import java.util.Arrays;

public class ShortcutInfoCompat {
    ComponentName mActivity;
    Context mContext;
    CharSequence mDisabledMessage;
    IconCompat mIcon;
    String mId;
    Intent[] mIntents;
    boolean mIsAlwaysBadged;
    CharSequence mLabel;
    CharSequence mLongLabel;

    public static class Builder {
        private final ShortcutInfoCompat mInfo = new ShortcutInfoCompat();

        public Builder(Context context, String str) {
            ShortcutInfoCompat shortcutInfoCompat = this.mInfo;
            shortcutInfoCompat.mContext = context;
            shortcutInfoCompat.mId = str;
        }

        public ShortcutInfoCompat build() {
            if (TextUtils.isEmpty(this.mInfo.mLabel)) {
                throw new IllegalArgumentException("Shortcut must have a non-empty label");
            }
            ShortcutInfoCompat shortcutInfoCompat = this.mInfo;
            Intent[] intentArr = shortcutInfoCompat.mIntents;
            if (intentArr != null && intentArr.length != 0) {
                return shortcutInfoCompat;
            }
            throw new IllegalArgumentException("Shortcut must have an intent");
        }

        public Builder setActivity(ComponentName componentName) {
            this.mInfo.mActivity = componentName;
            return this;
        }

        public Builder setAlwaysBadged() {
            this.mInfo.mIsAlwaysBadged = true;
            return this;
        }

        public Builder setDisabledMessage(CharSequence charSequence) {
            this.mInfo.mDisabledMessage = charSequence;
            return this;
        }

        public Builder setIcon(IconCompat iconCompat) {
            this.mInfo.mIcon = iconCompat;
            return this;
        }

        public Builder setIntent(Intent intent) {
            return setIntents(new Intent[]{intent});
        }

        public Builder setIntents(Intent[] intentArr) {
            this.mInfo.mIntents = intentArr;
            return this;
        }

        public Builder setLongLabel(CharSequence charSequence) {
            this.mInfo.mLongLabel = charSequence;
            return this;
        }

        public Builder setShortLabel(CharSequence charSequence) {
            this.mInfo.mLabel = charSequence;
            return this;
        }
    }

    ShortcutInfoCompat() {
    }

    android.content.Intent addToIntent(android.content.Intent r4) {
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
        r3 = this;
        r0 = r3.mIntents;
        r1 = r0.length;
        r1 = r1 + -1;
        r0 = r0[r1];
        r1 = "android.intent.extra.shortcut.INTENT";
        r0 = r4.putExtra(r1, r0);
        r1 = r3.mLabel;
        r1 = r1.toString();
        r2 = "android.intent.extra.shortcut.NAME";
        r0.putExtra(r2, r1);
        r0 = r3.mIcon;
        if (r0 == 0) goto L_0x0042;
    L_0x001c:
        r0 = 0;
        r1 = r3.mIsAlwaysBadged;
        if (r1 == 0) goto L_0x003b;
    L_0x0021:
        r1 = r3.mContext;
        r1 = r1.getPackageManager();
        r2 = r3.mActivity;
        if (r2 == 0) goto L_0x002f;
    L_0x002b:
        r0 = r1.getActivityIcon(r2);	 Catch:{ NameNotFoundException -> 0x002f }
    L_0x002f:
        if (r0 != 0) goto L_0x003b;
    L_0x0031:
        r0 = r3.mContext;
        r0 = r0.getApplicationInfo();
        r0 = r0.loadIcon(r1);
    L_0x003b:
        r1 = r3.mIcon;
        r2 = r3.mContext;
        r1.addToShortcutIntent(r4, r0, r2);
    L_0x0042:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.content.pm.ShortcutInfoCompat.addToIntent(android.content.Intent):android.content.Intent");
    }

    public ComponentName getActivity() {
        return this.mActivity;
    }

    public CharSequence getDisabledMessage() {
        return this.mDisabledMessage;
    }

    public String getId() {
        return this.mId;
    }

    public Intent getIntent() {
        Intent[] intentArr = this.mIntents;
        return intentArr[intentArr.length - 1];
    }

    public Intent[] getIntents() {
        Intent[] intentArr = this.mIntents;
        return (Intent[]) Arrays.copyOf(intentArr, intentArr.length);
    }

    public CharSequence getLongLabel() {
        return this.mLongLabel;
    }

    public CharSequence getShortLabel() {
        return this.mLabel;
    }

    public ShortcutInfo toShortcutInfo() {
        android.content.pm.ShortcutInfo.Builder intents = new android.content.pm.ShortcutInfo.Builder(this.mContext, this.mId).setShortLabel(this.mLabel).setIntents(this.mIntents);
        IconCompat iconCompat = this.mIcon;
        if (iconCompat != null) {
            intents.setIcon(iconCompat.toIcon());
        }
        if (!TextUtils.isEmpty(this.mLongLabel)) {
            intents.setLongLabel(this.mLongLabel);
        }
        if (!TextUtils.isEmpty(this.mDisabledMessage)) {
            intents.setDisabledMessage(this.mDisabledMessage);
        }
        ComponentName componentName = this.mActivity;
        if (componentName != null) {
            intents.setActivity(componentName);
        }
        return intents.build();
    }
}
