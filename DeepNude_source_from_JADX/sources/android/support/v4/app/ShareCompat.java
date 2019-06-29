package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.v4.content.IntentCompat;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.ActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ShareActionProvider;
import java.util.ArrayList;

public final class ShareCompat {
    public static final String EXTRA_CALLING_ACTIVITY = "android.support.v4.app.EXTRA_CALLING_ACTIVITY";
    public static final String EXTRA_CALLING_PACKAGE = "android.support.v4.app.EXTRA_CALLING_PACKAGE";
    private static final String HISTORY_FILENAME_PREFIX = ".sharecompat_";

    public static class IntentBuilder {
        private Activity mActivity;
        private ArrayList<String> mBccAddresses;
        private ArrayList<String> mCcAddresses;
        private CharSequence mChooserTitle;
        private Intent mIntent = new Intent().setAction("android.intent.action.SEND");
        private ArrayList<Uri> mStreams;
        private ArrayList<String> mToAddresses;

        private IntentBuilder(Activity activity) {
            this.mActivity = activity;
            this.mIntent.putExtra(ShareCompat.EXTRA_CALLING_PACKAGE, activity.getPackageName());
            this.mIntent.putExtra(ShareCompat.EXTRA_CALLING_ACTIVITY, activity.getComponentName());
            this.mIntent.addFlags(524288);
        }

        private void combineArrayExtra(String str, ArrayList<String> arrayList) {
            Object stringArrayExtra = this.mIntent.getStringArrayExtra(str);
            int length = stringArrayExtra != null ? stringArrayExtra.length : 0;
            Object obj = new String[(arrayList.size() + length)];
            arrayList.toArray(obj);
            if (stringArrayExtra != null) {
                System.arraycopy(stringArrayExtra, 0, obj, arrayList.size(), length);
            }
            this.mIntent.putExtra(str, obj);
        }

        private void combineArrayExtra(String str, String[] strArr) {
            Intent intent = getIntent();
            Object stringArrayExtra = intent.getStringArrayExtra(str);
            int length = stringArrayExtra != null ? stringArrayExtra.length : 0;
            Object obj = new String[(strArr.length + length)];
            if (stringArrayExtra != null) {
                System.arraycopy(stringArrayExtra, 0, obj, 0, length);
            }
            System.arraycopy(strArr, 0, obj, length, strArr.length);
            intent.putExtra(str, obj);
        }

        public static IntentBuilder from(Activity activity) {
            return new IntentBuilder(activity);
        }

        public IntentBuilder addEmailBcc(String str) {
            if (this.mBccAddresses == null) {
                this.mBccAddresses = new ArrayList();
            }
            this.mBccAddresses.add(str);
            return this;
        }

        public IntentBuilder addEmailBcc(String[] strArr) {
            combineArrayExtra("android.intent.extra.BCC", strArr);
            return this;
        }

        public IntentBuilder addEmailCc(String str) {
            if (this.mCcAddresses == null) {
                this.mCcAddresses = new ArrayList();
            }
            this.mCcAddresses.add(str);
            return this;
        }

        public IntentBuilder addEmailCc(String[] strArr) {
            combineArrayExtra("android.intent.extra.CC", strArr);
            return this;
        }

        public IntentBuilder addEmailTo(String str) {
            if (this.mToAddresses == null) {
                this.mToAddresses = new ArrayList();
            }
            this.mToAddresses.add(str);
            return this;
        }

        public IntentBuilder addEmailTo(String[] strArr) {
            combineArrayExtra("android.intent.extra.EMAIL", strArr);
            return this;
        }

        public IntentBuilder addStream(Uri uri) {
            String str = "android.intent.extra.STREAM";
            Uri uri2 = (Uri) this.mIntent.getParcelableExtra(str);
            if (this.mStreams == null && uri2 == null) {
                return setStream(uri);
            }
            if (this.mStreams == null) {
                this.mStreams = new ArrayList();
            }
            if (uri2 != null) {
                this.mIntent.removeExtra(str);
                this.mStreams.add(uri2);
            }
            this.mStreams.add(uri);
            return this;
        }

        public Intent createChooserIntent() {
            return Intent.createChooser(getIntent(), this.mChooserTitle);
        }

        Activity getActivity() {
            return this.mActivity;
        }

        public Intent getIntent() {
            ArrayList arrayList = this.mToAddresses;
            if (arrayList != null) {
                combineArrayExtra("android.intent.extra.EMAIL", arrayList);
                this.mToAddresses = null;
            }
            arrayList = this.mCcAddresses;
            if (arrayList != null) {
                combineArrayExtra("android.intent.extra.CC", arrayList);
                this.mCcAddresses = null;
            }
            arrayList = this.mBccAddresses;
            if (arrayList != null) {
                combineArrayExtra("android.intent.extra.BCC", arrayList);
                this.mBccAddresses = null;
            }
            arrayList = this.mStreams;
            Object obj = 1;
            if (arrayList == null || arrayList.size() <= 1) {
                obj = null;
            }
            String str = "android.intent.action.SEND_MULTIPLE";
            boolean equals = this.mIntent.getAction().equals(str);
            String str2 = "android.intent.extra.STREAM";
            if (obj == null && equals) {
                this.mIntent.setAction("android.intent.action.SEND");
                ArrayList arrayList2 = this.mStreams;
                if (arrayList2 == null || arrayList2.isEmpty()) {
                    this.mIntent.removeExtra(str2);
                } else {
                    this.mIntent.putExtra(str2, (Parcelable) this.mStreams.get(0));
                }
                this.mStreams = null;
            }
            if (!(obj == null || equals)) {
                this.mIntent.setAction(str);
                arrayList = this.mStreams;
                if (arrayList == null || arrayList.isEmpty()) {
                    this.mIntent.removeExtra(str2);
                } else {
                    this.mIntent.putParcelableArrayListExtra(str2, this.mStreams);
                }
            }
            return this.mIntent;
        }

        public IntentBuilder setChooserTitle(int i) {
            return setChooserTitle(this.mActivity.getText(i));
        }

        public IntentBuilder setChooserTitle(CharSequence charSequence) {
            this.mChooserTitle = charSequence;
            return this;
        }

        public IntentBuilder setEmailBcc(String[] strArr) {
            this.mIntent.putExtra("android.intent.extra.BCC", strArr);
            return this;
        }

        public IntentBuilder setEmailCc(String[] strArr) {
            this.mIntent.putExtra("android.intent.extra.CC", strArr);
            return this;
        }

        public IntentBuilder setEmailTo(String[] strArr) {
            if (this.mToAddresses != null) {
                this.mToAddresses = null;
            }
            this.mIntent.putExtra("android.intent.extra.EMAIL", strArr);
            return this;
        }

        public IntentBuilder setHtmlText(String str) {
            this.mIntent.putExtra(IntentCompat.EXTRA_HTML_TEXT, str);
            if (!this.mIntent.hasExtra("android.intent.extra.TEXT")) {
                setText(Html.fromHtml(str));
            }
            return this;
        }

        public IntentBuilder setStream(Uri uri) {
            String str = "android.intent.action.SEND";
            if (!this.mIntent.getAction().equals(str)) {
                this.mIntent.setAction(str);
            }
            this.mStreams = null;
            this.mIntent.putExtra("android.intent.extra.STREAM", uri);
            return this;
        }

        public IntentBuilder setSubject(String str) {
            this.mIntent.putExtra("android.intent.extra.SUBJECT", str);
            return this;
        }

        public IntentBuilder setText(CharSequence charSequence) {
            this.mIntent.putExtra("android.intent.extra.TEXT", charSequence);
            return this;
        }

        public IntentBuilder setType(String str) {
            this.mIntent.setType(str);
            return this;
        }

        public void startChooser() {
            this.mActivity.startActivity(createChooserIntent());
        }
    }

    public static class IntentReader {
        private static final String TAG = "IntentReader";
        private Activity mActivity;
        private ComponentName mCallingActivity;
        private String mCallingPackage;
        private Intent mIntent;
        private ArrayList<Uri> mStreams;

        private IntentReader(Activity activity) {
            this.mActivity = activity;
            this.mIntent = activity.getIntent();
            this.mCallingPackage = ShareCompat.getCallingPackage(activity);
            this.mCallingActivity = ShareCompat.getCallingActivity(activity);
        }

        public static IntentReader from(Activity activity) {
            return new IntentReader(activity);
        }

        private static void withinStyle(StringBuilder stringBuilder, CharSequence charSequence, int i, int i2) {
            while (i < i2) {
                String str;
                char charAt = charSequence.charAt(i);
                if (charAt == '<') {
                    str = "&lt;";
                } else if (charAt == '>') {
                    str = "&gt;";
                } else if (charAt == '&') {
                    str = "&amp;";
                } else {
                    if (charAt <= '~') {
                        if (charAt >= ' ') {
                            if (charAt == ' ') {
                                while (true) {
                                    int i3 = i + 1;
                                    if (i3 >= i2 || charSequence.charAt(i3) != ' ') {
                                        stringBuilder.append(' ');
                                    } else {
                                        stringBuilder.append("&nbsp;");
                                        i = i3;
                                    }
                                }
                                stringBuilder.append(' ');
                            } else {
                                stringBuilder.append(charAt);
                            }
                            i++;
                        }
                    }
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("&#");
                    stringBuilder2.append(charAt);
                    stringBuilder2.append(";");
                    str = stringBuilder2.toString();
                }
                stringBuilder.append(str);
                i++;
            }
        }

        public ComponentName getCallingActivity() {
            return this.mCallingActivity;
        }

        public Drawable getCallingActivityIcon() {
            if (this.mCallingActivity == null) {
                return null;
            }
            try {
                return this.mActivity.getPackageManager().getActivityIcon(this.mCallingActivity);
            } catch (Throwable e) {
                Log.e(TAG, "Could not retrieve icon for calling activity", e);
                return null;
            }
        }

        public Drawable getCallingApplicationIcon() {
            if (this.mCallingPackage == null) {
                return null;
            }
            try {
                return this.mActivity.getPackageManager().getApplicationIcon(this.mCallingPackage);
            } catch (Throwable e) {
                Log.e(TAG, "Could not retrieve icon for calling application", e);
                return null;
            }
        }

        public CharSequence getCallingApplicationLabel() {
            if (this.mCallingPackage == null) {
                return null;
            }
            PackageManager packageManager = this.mActivity.getPackageManager();
            try {
                return packageManager.getApplicationLabel(packageManager.getApplicationInfo(this.mCallingPackage, 0));
            } catch (Throwable e) {
                Log.e(TAG, "Could not retrieve label for calling application", e);
                return null;
            }
        }

        public String getCallingPackage() {
            return this.mCallingPackage;
        }

        public String[] getEmailBcc() {
            return this.mIntent.getStringArrayExtra("android.intent.extra.BCC");
        }

        public String[] getEmailCc() {
            return this.mIntent.getStringArrayExtra("android.intent.extra.CC");
        }

        public String[] getEmailTo() {
            return this.mIntent.getStringArrayExtra("android.intent.extra.EMAIL");
        }

        public String getHtmlText() {
            String stringExtra = this.mIntent.getStringExtra(IntentCompat.EXTRA_HTML_TEXT);
            if (stringExtra != null) {
                return stringExtra;
            }
            CharSequence text = getText();
            if (text instanceof Spanned) {
                return Html.toHtml((Spanned) text);
            }
            if (text == null) {
                return stringExtra;
            }
            if (VERSION.SDK_INT >= 16) {
                return Html.escapeHtml(text);
            }
            StringBuilder stringBuilder = new StringBuilder();
            withinStyle(stringBuilder, text, 0, text.length());
            return stringBuilder.toString();
        }

        public Uri getStream() {
            return (Uri) this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
        }

        public Uri getStream(int i) {
            Object obj;
            String str = "android.intent.extra.STREAM";
            if (this.mStreams == null && isMultipleShare()) {
                this.mStreams = this.mIntent.getParcelableArrayListExtra(str);
            }
            ArrayList arrayList = this.mStreams;
            if (arrayList != null) {
                obj = arrayList.get(i);
            } else if (i == 0) {
                obj = this.mIntent.getParcelableExtra(str);
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Stream items available: ");
                stringBuilder.append(getStreamCount());
                stringBuilder.append(" index requested: ");
                stringBuilder.append(i);
                throw new IndexOutOfBoundsException(stringBuilder.toString());
            }
            return (Uri) obj;
        }

        public int getStreamCount() {
            String str = "android.intent.extra.STREAM";
            if (this.mStreams == null && isMultipleShare()) {
                this.mStreams = this.mIntent.getParcelableArrayListExtra(str);
            }
            ArrayList arrayList = this.mStreams;
            return arrayList != null ? arrayList.size() : this.mIntent.hasExtra(str);
        }

        public String getSubject() {
            return this.mIntent.getStringExtra("android.intent.extra.SUBJECT");
        }

        public CharSequence getText() {
            return this.mIntent.getCharSequenceExtra("android.intent.extra.TEXT");
        }

        public String getType() {
            return this.mIntent.getType();
        }

        public boolean isMultipleShare() {
            return "android.intent.action.SEND_MULTIPLE".equals(this.mIntent.getAction());
        }

        public boolean isShareIntent() {
            String action = this.mIntent.getAction();
            if (!"android.intent.action.SEND".equals(action)) {
                if (!"android.intent.action.SEND_MULTIPLE".equals(action)) {
                    return false;
                }
            }
            return true;
        }

        public boolean isSingleShare() {
            return "android.intent.action.SEND".equals(this.mIntent.getAction());
        }
    }

    private ShareCompat() {
    }

    public static void configureMenuItem(Menu menu, int i, IntentBuilder intentBuilder) {
        MenuItem findItem = menu.findItem(i);
        if (findItem != null) {
            configureMenuItem(findItem, intentBuilder);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Could not find menu item with id ");
        stringBuilder.append(i);
        stringBuilder.append(" in the supplied menu");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static void configureMenuItem(MenuItem menuItem, IntentBuilder intentBuilder) {
        ActionProvider actionProvider = menuItem.getActionProvider();
        actionProvider = !(actionProvider instanceof ShareActionProvider) ? new ShareActionProvider(intentBuilder.getActivity()) : (ShareActionProvider) actionProvider;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(HISTORY_FILENAME_PREFIX);
        stringBuilder.append(intentBuilder.getActivity().getClass().getName());
        actionProvider.setShareHistoryFileName(stringBuilder.toString());
        actionProvider.setShareIntent(intentBuilder.getIntent());
        menuItem.setActionProvider(actionProvider);
        if (VERSION.SDK_INT < 16 && !menuItem.hasSubMenu()) {
            menuItem.setIntent(intentBuilder.createChooserIntent());
        }
    }

    public static ComponentName getCallingActivity(Activity activity) {
        ComponentName callingActivity = activity.getCallingActivity();
        return callingActivity == null ? (ComponentName) activity.getIntent().getParcelableExtra(EXTRA_CALLING_ACTIVITY) : callingActivity;
    }

    public static String getCallingPackage(Activity activity) {
        String callingPackage = activity.getCallingPackage();
        return callingPackage == null ? activity.getIntent().getStringExtra(EXTRA_CALLING_PACKAGE) : callingPackage;
    }
}
