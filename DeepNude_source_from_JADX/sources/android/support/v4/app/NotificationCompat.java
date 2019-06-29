package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.text.BidiFormatter;
import android.support.v4.view.ViewCompat;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import p000a.p005b.p006a.C0008b;
import p000a.p005b.p006a.C0009c;
import p000a.p005b.p006a.C0010d;
import p000a.p005b.p006a.C0011e;
import p000a.p005b.p006a.C0012f;
import p000a.p005b.p006a.C0013g;
import p000a.p005b.p006a.C0014h;

public class NotificationCompat {
    public static final int BADGE_ICON_LARGE = 2;
    public static final int BADGE_ICON_NONE = 0;
    public static final int BADGE_ICON_SMALL = 1;
    public static final String CATEGORY_ALARM = "alarm";
    public static final String CATEGORY_CALL = "call";
    public static final String CATEGORY_EMAIL = "email";
    public static final String CATEGORY_ERROR = "err";
    public static final String CATEGORY_EVENT = "event";
    public static final String CATEGORY_MESSAGE = "msg";
    public static final String CATEGORY_PROGRESS = "progress";
    public static final String CATEGORY_PROMO = "promo";
    public static final String CATEGORY_RECOMMENDATION = "recommendation";
    public static final String CATEGORY_REMINDER = "reminder";
    public static final String CATEGORY_SERVICE = "service";
    public static final String CATEGORY_SOCIAL = "social";
    public static final String CATEGORY_STATUS = "status";
    public static final String CATEGORY_SYSTEM = "sys";
    public static final String CATEGORY_TRANSPORT = "transport";
    public static final int COLOR_DEFAULT = 0;
    public static final int DEFAULT_ALL = -1;
    public static final int DEFAULT_LIGHTS = 4;
    public static final int DEFAULT_SOUND = 1;
    public static final int DEFAULT_VIBRATE = 2;
    public static final String EXTRA_AUDIO_CONTENTS_URI = "android.audioContents";
    public static final String EXTRA_BACKGROUND_IMAGE_URI = "android.backgroundImageUri";
    public static final String EXTRA_BIG_TEXT = "android.bigText";
    public static final String EXTRA_COMPACT_ACTIONS = "android.compactActions";
    public static final String EXTRA_CONVERSATION_TITLE = "android.conversationTitle";
    public static final String EXTRA_HIDDEN_CONVERSATION_TITLE = "android.hiddenConversationTitle";
    public static final String EXTRA_INFO_TEXT = "android.infoText";
    public static final String EXTRA_IS_GROUP_CONVERSATION = "android.isGroupConversation";
    public static final String EXTRA_LARGE_ICON = "android.largeIcon";
    public static final String EXTRA_LARGE_ICON_BIG = "android.largeIcon.big";
    public static final String EXTRA_MEDIA_SESSION = "android.mediaSession";
    public static final String EXTRA_MESSAGES = "android.messages";
    public static final String EXTRA_MESSAGING_STYLE_USER = "android.messagingStyleUser";
    public static final String EXTRA_PEOPLE = "android.people";
    public static final String EXTRA_PICTURE = "android.picture";
    public static final String EXTRA_PROGRESS = "android.progress";
    public static final String EXTRA_PROGRESS_INDETERMINATE = "android.progressIndeterminate";
    public static final String EXTRA_PROGRESS_MAX = "android.progressMax";
    public static final String EXTRA_REMOTE_INPUT_HISTORY = "android.remoteInputHistory";
    public static final String EXTRA_SELF_DISPLAY_NAME = "android.selfDisplayName";
    public static final String EXTRA_SHOW_CHRONOMETER = "android.showChronometer";
    public static final String EXTRA_SHOW_WHEN = "android.showWhen";
    public static final String EXTRA_SMALL_ICON = "android.icon";
    public static final String EXTRA_SUB_TEXT = "android.subText";
    public static final String EXTRA_SUMMARY_TEXT = "android.summaryText";
    public static final String EXTRA_TEMPLATE = "android.template";
    public static final String EXTRA_TEXT = "android.text";
    public static final String EXTRA_TEXT_LINES = "android.textLines";
    public static final String EXTRA_TITLE = "android.title";
    public static final String EXTRA_TITLE_BIG = "android.title.big";
    public static final int FLAG_AUTO_CANCEL = 16;
    public static final int FLAG_FOREGROUND_SERVICE = 64;
    public static final int FLAG_GROUP_SUMMARY = 512;
    @Deprecated
    public static final int FLAG_HIGH_PRIORITY = 128;
    public static final int FLAG_INSISTENT = 4;
    public static final int FLAG_LOCAL_ONLY = 256;
    public static final int FLAG_NO_CLEAR = 32;
    public static final int FLAG_ONGOING_EVENT = 2;
    public static final int FLAG_ONLY_ALERT_ONCE = 8;
    public static final int FLAG_SHOW_LIGHTS = 1;
    public static final int GROUP_ALERT_ALL = 0;
    public static final int GROUP_ALERT_CHILDREN = 2;
    public static final int GROUP_ALERT_SUMMARY = 1;
    public static final int PRIORITY_DEFAULT = 0;
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_LOW = -1;
    public static final int PRIORITY_MAX = 2;
    public static final int PRIORITY_MIN = -2;
    public static final int STREAM_DEFAULT = -1;
    public static final int VISIBILITY_PRIVATE = 0;
    public static final int VISIBILITY_PUBLIC = 1;
    public static final int VISIBILITY_SECRET = -1;

    public static class Action {
        static final String EXTRA_SEMANTIC_ACTION = "android.support.action.semanticAction";
        static final String EXTRA_SHOWS_USER_INTERFACE = "android.support.action.showsUserInterface";
        public static final int SEMANTIC_ACTION_ARCHIVE = 5;
        public static final int SEMANTIC_ACTION_CALL = 10;
        public static final int SEMANTIC_ACTION_DELETE = 4;
        public static final int SEMANTIC_ACTION_MARK_AS_READ = 2;
        public static final int SEMANTIC_ACTION_MARK_AS_UNREAD = 3;
        public static final int SEMANTIC_ACTION_MUTE = 6;
        public static final int SEMANTIC_ACTION_NONE = 0;
        public static final int SEMANTIC_ACTION_REPLY = 1;
        public static final int SEMANTIC_ACTION_THUMBS_DOWN = 9;
        public static final int SEMANTIC_ACTION_THUMBS_UP = 8;
        public static final int SEMANTIC_ACTION_UNMUTE = 7;
        public PendingIntent actionIntent;
        public int icon;
        private boolean mAllowGeneratedReplies;
        private final RemoteInput[] mDataOnlyRemoteInputs;
        final Bundle mExtras;
        private final RemoteInput[] mRemoteInputs;
        private final int mSemanticAction;
        boolean mShowsUserInterface;
        public CharSequence title;

        public static final class Builder {
            private boolean mAllowGeneratedReplies;
            private final Bundle mExtras;
            private final int mIcon;
            private final PendingIntent mIntent;
            private ArrayList<RemoteInput> mRemoteInputs;
            private int mSemanticAction;
            private boolean mShowsUserInterface;
            private final CharSequence mTitle;

            public Builder(int i, CharSequence charSequence, PendingIntent pendingIntent) {
                this(i, charSequence, pendingIntent, new Bundle(), null, true, 0, true);
            }

            private Builder(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInput[] remoteInputArr, boolean z, int i2, boolean z2) {
                this.mAllowGeneratedReplies = true;
                this.mShowsUserInterface = true;
                this.mIcon = i;
                this.mTitle = Builder.limitCharSequenceLength(charSequence);
                this.mIntent = pendingIntent;
                this.mExtras = bundle;
                this.mRemoteInputs = remoteInputArr == null ? null : new ArrayList(Arrays.asList(remoteInputArr));
                this.mAllowGeneratedReplies = z;
                this.mSemanticAction = i2;
                this.mShowsUserInterface = z2;
            }

            public Builder(Action action) {
                this(action.icon, action.title, action.actionIntent, new Bundle(action.mExtras), action.getRemoteInputs(), action.getAllowGeneratedReplies(), action.getSemanticAction(), action.mShowsUserInterface);
            }

            public Builder addExtras(Bundle bundle) {
                if (bundle != null) {
                    this.mExtras.putAll(bundle);
                }
                return this;
            }

            public Builder addRemoteInput(RemoteInput remoteInput) {
                if (this.mRemoteInputs == null) {
                    this.mRemoteInputs = new ArrayList();
                }
                this.mRemoteInputs.add(remoteInput);
                return this;
            }

            public Action build() {
                List arrayList = new ArrayList();
                List arrayList2 = new ArrayList();
                ArrayList arrayList3 = this.mRemoteInputs;
                if (arrayList3 != null) {
                    Iterator it = arrayList3.iterator();
                    while (it.hasNext()) {
                        RemoteInput remoteInput = (RemoteInput) it.next();
                        if (remoteInput.isDataOnly()) {
                            arrayList.add(remoteInput);
                        } else {
                            arrayList2.add(remoteInput);
                        }
                    }
                }
                RemoteInput[] remoteInputArr = null;
                RemoteInput[] remoteInputArr2 = arrayList.isEmpty() ? null : (RemoteInput[]) arrayList.toArray(new RemoteInput[arrayList.size()]);
                if (!arrayList2.isEmpty()) {
                    remoteInputArr = (RemoteInput[]) arrayList2.toArray(new RemoteInput[arrayList2.size()]);
                }
                return new Action(this.mIcon, this.mTitle, this.mIntent, this.mExtras, remoteInputArr, remoteInputArr2, this.mAllowGeneratedReplies, this.mSemanticAction, this.mShowsUserInterface);
            }

            public Builder extend(Extender extender) {
                extender.extend(this);
                return this;
            }

            public Bundle getExtras() {
                return this.mExtras;
            }

            public Builder setAllowGeneratedReplies(boolean z) {
                this.mAllowGeneratedReplies = z;
                return this;
            }

            public Builder setSemanticAction(int i) {
                this.mSemanticAction = i;
                return this;
            }

            public Builder setShowsUserInterface(boolean z) {
                this.mShowsUserInterface = z;
                return this;
            }
        }

        public interface Extender {
            Builder extend(Builder builder);
        }

        @Retention(RetentionPolicy.SOURCE)
        public @interface SemanticAction {
        }

        public static final class WearableExtender implements Extender {
            private static final int DEFAULT_FLAGS = 1;
            private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
            private static final int FLAG_AVAILABLE_OFFLINE = 1;
            private static final int FLAG_HINT_DISPLAY_INLINE = 4;
            private static final int FLAG_HINT_LAUNCHES_ACTIVITY = 2;
            private static final String KEY_CANCEL_LABEL = "cancelLabel";
            private static final String KEY_CONFIRM_LABEL = "confirmLabel";
            private static final String KEY_FLAGS = "flags";
            private static final String KEY_IN_PROGRESS_LABEL = "inProgressLabel";
            private CharSequence mCancelLabel;
            private CharSequence mConfirmLabel;
            private int mFlags = 1;
            private CharSequence mInProgressLabel;

            public WearableExtender(Action action) {
                Bundle bundle = action.getExtras().getBundle(EXTRA_WEARABLE_EXTENSIONS);
                if (bundle != null) {
                    this.mFlags = bundle.getInt(KEY_FLAGS, 1);
                    this.mInProgressLabel = bundle.getCharSequence(KEY_IN_PROGRESS_LABEL);
                    this.mConfirmLabel = bundle.getCharSequence(KEY_CONFIRM_LABEL);
                    this.mCancelLabel = bundle.getCharSequence(KEY_CANCEL_LABEL);
                }
            }

            private void setFlag(int i, boolean z) {
                if (z) {
                    i |= this.mFlags;
                } else {
                    i = (i ^ -1) & this.mFlags;
                }
                this.mFlags = i;
            }

            public WearableExtender clone() {
                WearableExtender wearableExtender = new WearableExtender();
                wearableExtender.mFlags = this.mFlags;
                wearableExtender.mInProgressLabel = this.mInProgressLabel;
                wearableExtender.mConfirmLabel = this.mConfirmLabel;
                wearableExtender.mCancelLabel = this.mCancelLabel;
                return wearableExtender;
            }

            public Builder extend(Builder builder) {
                Bundle bundle = new Bundle();
                int i = this.mFlags;
                if (i != 1) {
                    bundle.putInt(KEY_FLAGS, i);
                }
                CharSequence charSequence = this.mInProgressLabel;
                if (charSequence != null) {
                    bundle.putCharSequence(KEY_IN_PROGRESS_LABEL, charSequence);
                }
                charSequence = this.mConfirmLabel;
                if (charSequence != null) {
                    bundle.putCharSequence(KEY_CONFIRM_LABEL, charSequence);
                }
                charSequence = this.mCancelLabel;
                if (charSequence != null) {
                    bundle.putCharSequence(KEY_CANCEL_LABEL, charSequence);
                }
                builder.getExtras().putBundle(EXTRA_WEARABLE_EXTENSIONS, bundle);
                return builder;
            }

            @Deprecated
            public CharSequence getCancelLabel() {
                return this.mCancelLabel;
            }

            @Deprecated
            public CharSequence getConfirmLabel() {
                return this.mConfirmLabel;
            }

            public boolean getHintDisplayActionInline() {
                return (this.mFlags & 4) != 0;
            }

            public boolean getHintLaunchesActivity() {
                return (this.mFlags & 2) != 0;
            }

            @Deprecated
            public CharSequence getInProgressLabel() {
                return this.mInProgressLabel;
            }

            public boolean isAvailableOffline() {
                return (this.mFlags & 1) != 0;
            }

            public WearableExtender setAvailableOffline(boolean z) {
                setFlag(1, z);
                return this;
            }

            @Deprecated
            public WearableExtender setCancelLabel(CharSequence charSequence) {
                this.mCancelLabel = charSequence;
                return this;
            }

            @Deprecated
            public WearableExtender setConfirmLabel(CharSequence charSequence) {
                this.mConfirmLabel = charSequence;
                return this;
            }

            public WearableExtender setHintDisplayActionInline(boolean z) {
                setFlag(4, z);
                return this;
            }

            public WearableExtender setHintLaunchesActivity(boolean z) {
                setFlag(2, z);
                return this;
            }

            @Deprecated
            public WearableExtender setInProgressLabel(CharSequence charSequence) {
                this.mInProgressLabel = charSequence;
                return this;
            }
        }

        public Action(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i, charSequence, pendingIntent, new Bundle(), null, null, true, 0, true);
        }

        Action(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInput[] remoteInputArr, RemoteInput[] remoteInputArr2, boolean z, int i2, boolean z2) {
            this.mShowsUserInterface = true;
            this.icon = i;
            this.title = Builder.limitCharSequenceLength(charSequence);
            this.actionIntent = pendingIntent;
            if (bundle == null) {
                bundle = new Bundle();
            }
            this.mExtras = bundle;
            this.mRemoteInputs = remoteInputArr;
            this.mDataOnlyRemoteInputs = remoteInputArr2;
            this.mAllowGeneratedReplies = z;
            this.mSemanticAction = i2;
            this.mShowsUserInterface = z2;
        }

        public PendingIntent getActionIntent() {
            return this.actionIntent;
        }

        public boolean getAllowGeneratedReplies() {
            return this.mAllowGeneratedReplies;
        }

        public RemoteInput[] getDataOnlyRemoteInputs() {
            return this.mDataOnlyRemoteInputs;
        }

        public Bundle getExtras() {
            return this.mExtras;
        }

        public int getIcon() {
            return this.icon;
        }

        public RemoteInput[] getRemoteInputs() {
            return this.mRemoteInputs;
        }

        public int getSemanticAction() {
            return this.mSemanticAction;
        }

        public boolean getShowsUserInterface() {
            return this.mShowsUserInterface;
        }

        public CharSequence getTitle() {
            return this.title;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface BadgeIconType {
    }

    public static class Builder {
        private static final int MAX_CHARSEQUENCE_LENGTH = 5120;
        public ArrayList<Action> mActions;
        int mBadgeIcon;
        RemoteViews mBigContentView;
        String mCategory;
        String mChannelId;
        int mColor;
        boolean mColorized;
        boolean mColorizedSet;
        CharSequence mContentInfo;
        PendingIntent mContentIntent;
        CharSequence mContentText;
        CharSequence mContentTitle;
        RemoteViews mContentView;
        public Context mContext;
        Bundle mExtras;
        PendingIntent mFullScreenIntent;
        int mGroupAlertBehavior;
        String mGroupKey;
        boolean mGroupSummary;
        RemoteViews mHeadsUpContentView;
        ArrayList<Action> mInvisibleActions;
        Bitmap mLargeIcon;
        boolean mLocalOnly;
        Notification mNotification;
        int mNumber;
        @Deprecated
        public ArrayList<String> mPeople;
        int mPriority;
        int mProgress;
        boolean mProgressIndeterminate;
        int mProgressMax;
        Notification mPublicVersion;
        CharSequence[] mRemoteInputHistory;
        String mShortcutId;
        boolean mShowWhen;
        String mSortKey;
        Style mStyle;
        CharSequence mSubText;
        RemoteViews mTickerView;
        long mTimeout;
        boolean mUseChronometer;
        int mVisibility;

        @Deprecated
        public Builder(Context context) {
            this(context, null);
        }

        public Builder(Context context, String str) {
            this.mActions = new ArrayList();
            this.mInvisibleActions = new ArrayList();
            this.mShowWhen = true;
            this.mLocalOnly = false;
            this.mColor = 0;
            this.mVisibility = 0;
            this.mBadgeIcon = 0;
            this.mGroupAlertBehavior = 0;
            this.mNotification = new Notification();
            this.mContext = context;
            this.mChannelId = str;
            this.mNotification.when = System.currentTimeMillis();
            this.mNotification.audioStreamType = -1;
            this.mPriority = 0;
            this.mPeople = new ArrayList();
        }

        protected static CharSequence limitCharSequenceLength(CharSequence charSequence) {
            if (charSequence == null) {
                return charSequence;
            }
            if (charSequence.length() > MAX_CHARSEQUENCE_LENGTH) {
                charSequence = charSequence.subSequence(0, MAX_CHARSEQUENCE_LENGTH);
            }
            return charSequence;
        }

        private Bitmap reduceLargeIconSize(Bitmap bitmap) {
            if (bitmap != null) {
                if (VERSION.SDK_INT < 27) {
                    Resources resources = this.mContext.getResources();
                    int dimensionPixelSize = resources.getDimensionPixelSize(C0009c.compat_notification_large_icon_max_width);
                    int dimensionPixelSize2 = resources.getDimensionPixelSize(C0009c.compat_notification_large_icon_max_height);
                    if (bitmap.getWidth() <= dimensionPixelSize && bitmap.getHeight() <= dimensionPixelSize2) {
                        return bitmap;
                    }
                    double d = (double) dimensionPixelSize;
                    double max = (double) Math.max(1, bitmap.getWidth());
                    Double.isNaN(d);
                    Double.isNaN(max);
                    d /= max;
                    max = (double) dimensionPixelSize2;
                    double max2 = (double) Math.max(1, bitmap.getHeight());
                    Double.isNaN(max);
                    Double.isNaN(max2);
                    double min = Math.min(d, max / max2);
                    double width = (double) bitmap.getWidth();
                    Double.isNaN(width);
                    int ceil = (int) Math.ceil(width * min);
                    max = (double) bitmap.getHeight();
                    Double.isNaN(max);
                    bitmap = Bitmap.createScaledBitmap(bitmap, ceil, (int) Math.ceil(max * min), true);
                }
            }
            return bitmap;
        }

        private void setFlag(int i, boolean z) {
            Notification notification;
            if (z) {
                notification = this.mNotification;
                i |= notification.flags;
            } else {
                notification = this.mNotification;
                i = (i ^ -1) & notification.flags;
            }
            notification.flags = i;
        }

        public Builder addAction(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this.mActions.add(new Action(i, charSequence, pendingIntent));
            return this;
        }

        public Builder addAction(Action action) {
            this.mActions.add(action);
            return this;
        }

        public Builder addExtras(Bundle bundle) {
            if (bundle != null) {
                Bundle bundle2 = this.mExtras;
                if (bundle2 == null) {
                    this.mExtras = new Bundle(bundle);
                } else {
                    bundle2.putAll(bundle);
                }
            }
            return this;
        }

        public Builder addInvisibleAction(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            return addInvisibleAction(new Action(i, charSequence, pendingIntent));
        }

        public Builder addInvisibleAction(Action action) {
            this.mInvisibleActions.add(action);
            return this;
        }

        public Builder addPerson(String str) {
            this.mPeople.add(str);
            return this;
        }

        public Notification build() {
            return new NotificationCompatBuilder(this).build();
        }

        public Builder extend(Extender extender) {
            extender.extend(this);
            return this;
        }

        public RemoteViews getBigContentView() {
            return this.mBigContentView;
        }

        public int getColor() {
            return this.mColor;
        }

        public RemoteViews getContentView() {
            return this.mContentView;
        }

        public Bundle getExtras() {
            if (this.mExtras == null) {
                this.mExtras = new Bundle();
            }
            return this.mExtras;
        }

        public RemoteViews getHeadsUpContentView() {
            return this.mHeadsUpContentView;
        }

        @Deprecated
        public Notification getNotification() {
            return build();
        }

        public int getPriority() {
            return this.mPriority;
        }

        public long getWhenIfShowing() {
            return this.mShowWhen ? this.mNotification.when : 0;
        }

        public Builder setAutoCancel(boolean z) {
            setFlag(16, z);
            return this;
        }

        public Builder setBadgeIconType(int i) {
            this.mBadgeIcon = i;
            return this;
        }

        public Builder setCategory(String str) {
            this.mCategory = str;
            return this;
        }

        public Builder setChannelId(String str) {
            this.mChannelId = str;
            return this;
        }

        public Builder setColor(int i) {
            this.mColor = i;
            return this;
        }

        public Builder setColorized(boolean z) {
            this.mColorized = z;
            this.mColorizedSet = true;
            return this;
        }

        public Builder setContent(RemoteViews remoteViews) {
            this.mNotification.contentView = remoteViews;
            return this;
        }

        public Builder setContentInfo(CharSequence charSequence) {
            this.mContentInfo = limitCharSequenceLength(charSequence);
            return this;
        }

        public Builder setContentIntent(PendingIntent pendingIntent) {
            this.mContentIntent = pendingIntent;
            return this;
        }

        public Builder setContentText(CharSequence charSequence) {
            this.mContentText = limitCharSequenceLength(charSequence);
            return this;
        }

        public Builder setContentTitle(CharSequence charSequence) {
            this.mContentTitle = limitCharSequenceLength(charSequence);
            return this;
        }

        public Builder setCustomBigContentView(RemoteViews remoteViews) {
            this.mBigContentView = remoteViews;
            return this;
        }

        public Builder setCustomContentView(RemoteViews remoteViews) {
            this.mContentView = remoteViews;
            return this;
        }

        public Builder setCustomHeadsUpContentView(RemoteViews remoteViews) {
            this.mHeadsUpContentView = remoteViews;
            return this;
        }

        public Builder setDefaults(int i) {
            Notification notification = this.mNotification;
            notification.defaults = i;
            if ((i & 4) != 0) {
                notification.flags |= 1;
            }
            return this;
        }

        public Builder setDeleteIntent(PendingIntent pendingIntent) {
            this.mNotification.deleteIntent = pendingIntent;
            return this;
        }

        public Builder setExtras(Bundle bundle) {
            this.mExtras = bundle;
            return this;
        }

        public Builder setFullScreenIntent(PendingIntent pendingIntent, boolean z) {
            this.mFullScreenIntent = pendingIntent;
            setFlag(128, z);
            return this;
        }

        public Builder setGroup(String str) {
            this.mGroupKey = str;
            return this;
        }

        public Builder setGroupAlertBehavior(int i) {
            this.mGroupAlertBehavior = i;
            return this;
        }

        public Builder setGroupSummary(boolean z) {
            this.mGroupSummary = z;
            return this;
        }

        public Builder setLargeIcon(Bitmap bitmap) {
            this.mLargeIcon = reduceLargeIconSize(bitmap);
            return this;
        }

        public Builder setLights(int i, int i2, int i3) {
            Notification notification = this.mNotification;
            notification.ledARGB = i;
            notification.ledOnMS = i2;
            notification.ledOffMS = i3;
            i = (notification.ledOnMS == 0 || notification.ledOffMS == 0) ? 0 : 1;
            Notification notification2 = this.mNotification;
            notification2.flags = i | (notification2.flags & -2);
            return this;
        }

        public Builder setLocalOnly(boolean z) {
            this.mLocalOnly = z;
            return this;
        }

        public Builder setNumber(int i) {
            this.mNumber = i;
            return this;
        }

        public Builder setOngoing(boolean z) {
            setFlag(2, z);
            return this;
        }

        public Builder setOnlyAlertOnce(boolean z) {
            setFlag(8, z);
            return this;
        }

        public Builder setPriority(int i) {
            this.mPriority = i;
            return this;
        }

        public Builder setProgress(int i, int i2, boolean z) {
            this.mProgressMax = i;
            this.mProgress = i2;
            this.mProgressIndeterminate = z;
            return this;
        }

        public Builder setPublicVersion(Notification notification) {
            this.mPublicVersion = notification;
            return this;
        }

        public Builder setRemoteInputHistory(CharSequence[] charSequenceArr) {
            this.mRemoteInputHistory = charSequenceArr;
            return this;
        }

        public Builder setShortcutId(String str) {
            this.mShortcutId = str;
            return this;
        }

        public Builder setShowWhen(boolean z) {
            this.mShowWhen = z;
            return this;
        }

        public Builder setSmallIcon(int i) {
            this.mNotification.icon = i;
            return this;
        }

        public Builder setSmallIcon(int i, int i2) {
            Notification notification = this.mNotification;
            notification.icon = i;
            notification.iconLevel = i2;
            return this;
        }

        public Builder setSortKey(String str) {
            this.mSortKey = str;
            return this;
        }

        public Builder setSound(Uri uri) {
            Notification notification = this.mNotification;
            notification.sound = uri;
            notification.audioStreamType = -1;
            if (VERSION.SDK_INT >= 21) {
                notification.audioAttributes = new android.media.AudioAttributes.Builder().setContentType(4).setUsage(5).build();
            }
            return this;
        }

        public Builder setSound(Uri uri, int i) {
            Notification notification = this.mNotification;
            notification.sound = uri;
            notification.audioStreamType = i;
            if (VERSION.SDK_INT >= 21) {
                notification.audioAttributes = new android.media.AudioAttributes.Builder().setContentType(4).setLegacyStreamType(i).build();
            }
            return this;
        }

        public Builder setStyle(Style style) {
            if (this.mStyle != style) {
                this.mStyle = style;
                style = this.mStyle;
                if (style != null) {
                    style.setBuilder(this);
                }
            }
            return this;
        }

        public Builder setSubText(CharSequence charSequence) {
            this.mSubText = limitCharSequenceLength(charSequence);
            return this;
        }

        public Builder setTicker(CharSequence charSequence) {
            this.mNotification.tickerText = limitCharSequenceLength(charSequence);
            return this;
        }

        public Builder setTicker(CharSequence charSequence, RemoteViews remoteViews) {
            this.mNotification.tickerText = limitCharSequenceLength(charSequence);
            this.mTickerView = remoteViews;
            return this;
        }

        public Builder setTimeoutAfter(long j) {
            this.mTimeout = j;
            return this;
        }

        public Builder setUsesChronometer(boolean z) {
            this.mUseChronometer = z;
            return this;
        }

        public Builder setVibrate(long[] jArr) {
            this.mNotification.vibrate = jArr;
            return this;
        }

        public Builder setVisibility(int i) {
            this.mVisibility = i;
            return this;
        }

        public Builder setWhen(long j) {
            this.mNotification.when = j;
            return this;
        }
    }

    public interface Extender {
        Builder extend(Builder builder);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface GroupAlertBehavior {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface NotificationVisibility {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface StreamType {
    }

    public static abstract class Style {
        CharSequence mBigContentTitle;
        protected Builder mBuilder;
        CharSequence mSummaryText;
        boolean mSummaryTextSet = false;

        private int calculateTopPadding() {
            Resources resources = this.mBuilder.mContext.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(C0009c.notification_top_pad);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(C0009c.notification_top_pad_large_text);
            float constrain = (constrain(resources.getConfiguration().fontScale, 1.0f, 1.3f) - 1.0f) / 0.29999995f;
            return Math.round(((1.0f - constrain) * ((float) dimensionPixelSize)) + (constrain * ((float) dimensionPixelSize2)));
        }

        private static float constrain(float f, float f2, float f3) {
            return f < f2 ? f2 : f > f3 ? f3 : f;
        }

        private Bitmap createColoredBitmap(int i, int i2, int i3) {
            Drawable drawable = this.mBuilder.mContext.getResources().getDrawable(i);
            int intrinsicWidth = i3 == 0 ? drawable.getIntrinsicWidth() : i3;
            if (i3 == 0) {
                i3 = drawable.getIntrinsicHeight();
            }
            Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, i3, Config.ARGB_8888);
            drawable.setBounds(0, 0, intrinsicWidth, i3);
            if (i2 != 0) {
                drawable.mutate().setColorFilter(new PorterDuffColorFilter(i2, Mode.SRC_IN));
            }
            drawable.draw(new Canvas(createBitmap));
            return createBitmap;
        }

        private Bitmap createIconWithBackground(int i, int i2, int i3, int i4) {
            int i5 = C0010d.notification_icon_background;
            if (i4 == 0) {
                i4 = 0;
            }
            Bitmap createColoredBitmap = createColoredBitmap(i5, i4, i2);
            Canvas canvas = new Canvas(createColoredBitmap);
            Drawable mutate = this.mBuilder.mContext.getResources().getDrawable(i).mutate();
            mutate.setFilterBitmap(true);
            i2 = (i2 - i3) / 2;
            i3 += i2;
            mutate.setBounds(i2, i2, i3, i3);
            mutate.setColorFilter(new PorterDuffColorFilter(-1, Mode.SRC_ATOP));
            mutate.draw(canvas);
            return createColoredBitmap;
        }

        private void hideNormalContent(RemoteViews remoteViews) {
            remoteViews.setViewVisibility(C0011e.title, 8);
            remoteViews.setViewVisibility(C0011e.text2, 8);
            remoteViews.setViewVisibility(C0011e.text, 8);
        }

        public void addCompatExtras(Bundle bundle) {
        }

        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        }

        public RemoteViews applyStandardTemplate(boolean z, int i, boolean z2) {
            Builder builder;
            Object obj;
            CharSequence charSequence;
            Object obj2;
            Resources resources = this.mBuilder.mContext.getResources();
            RemoteViews remoteViews = new RemoteViews(this.mBuilder.mContext.getPackageName(), i);
            int i2 = 0;
            Object obj3 = this.mBuilder.getPriority() < -1 ? 1 : null;
            int i3 = VERSION.SDK_INT;
            if (i3 >= 16 && i3 < 21) {
                int i4;
                String str = "setBackgroundResource";
                if (obj3 != null) {
                    remoteViews.setInt(C0011e.notification_background, str, C0010d.notification_bg_low);
                    i = C0011e.icon;
                    i4 = C0010d.notification_template_icon_low_bg;
                } else {
                    remoteViews.setInt(C0011e.notification_background, str, C0010d.notification_bg);
                    i = C0011e.icon;
                    i4 = C0010d.notification_template_icon_bg;
                }
                remoteViews.setInt(i, str, i4);
            }
            Builder builder2 = this.mBuilder;
            int dimensionPixelSize;
            if (builder2.mLargeIcon != null) {
                if (VERSION.SDK_INT >= 16) {
                    remoteViews.setViewVisibility(C0011e.icon, 0);
                    remoteViews.setImageViewBitmap(C0011e.icon, this.mBuilder.mLargeIcon);
                } else {
                    remoteViews.setViewVisibility(C0011e.icon, 8);
                }
                if (z && this.mBuilder.mNotification.icon != 0) {
                    dimensionPixelSize = resources.getDimensionPixelSize(C0009c.notification_right_icon_size);
                    i = dimensionPixelSize - (resources.getDimensionPixelSize(C0009c.notification_small_icon_background_padding) * 2);
                    if (VERSION.SDK_INT >= 21) {
                        builder = this.mBuilder;
                        remoteViews.setImageViewBitmap(C0011e.right_icon, createIconWithBackground(builder.mNotification.icon, dimensionPixelSize, i, builder.getColor()));
                    } else {
                        remoteViews.setImageViewBitmap(C0011e.right_icon, createColoredBitmap(this.mBuilder.mNotification.icon, -1));
                    }
                    remoteViews.setViewVisibility(C0011e.right_icon, 0);
                }
            } else if (z && builder2.mNotification.icon != 0) {
                remoteViews.setViewVisibility(C0011e.icon, 0);
                if (VERSION.SDK_INT >= 21) {
                    dimensionPixelSize = resources.getDimensionPixelSize(C0009c.notification_large_icon_width) - resources.getDimensionPixelSize(C0009c.notification_big_circle_margin);
                    i = resources.getDimensionPixelSize(C0009c.notification_small_icon_size_as_large);
                    builder = this.mBuilder;
                    remoteViews.setImageViewBitmap(C0011e.icon, createIconWithBackground(builder.mNotification.icon, dimensionPixelSize, i, builder.getColor()));
                } else {
                    remoteViews.setImageViewBitmap(C0011e.icon, createColoredBitmap(this.mBuilder.mNotification.icon, -1));
                }
            }
            CharSequence charSequence2 = this.mBuilder.mContentTitle;
            if (charSequence2 != null) {
                remoteViews.setTextViewText(C0011e.title, charSequence2);
            }
            charSequence2 = this.mBuilder.mContentText;
            if (charSequence2 != null) {
                remoteViews.setTextViewText(C0011e.text, charSequence2);
                obj = 1;
            } else {
                obj = null;
            }
            obj3 = (VERSION.SDK_INT >= 21 || this.mBuilder.mLargeIcon == null) ? null : 1;
            builder = this.mBuilder;
            CharSequence charSequence3 = builder.mContentInfo;
            if (charSequence3 != null) {
                remoteViews.setTextViewText(C0011e.info, charSequence3);
            } else if (builder.mNumber > 0) {
                if (this.mBuilder.mNumber > resources.getInteger(C0012f.status_bar_notification_info_maxnum)) {
                    remoteViews.setTextViewText(C0011e.info, resources.getString(C0014h.status_bar_notification_info_overflow));
                } else {
                    remoteViews.setTextViewText(C0011e.info, NumberFormat.getIntegerInstance().format((long) this.mBuilder.mNumber));
                }
            } else {
                remoteViews.setViewVisibility(C0011e.info, 8);
                charSequence = this.mBuilder.mSubText;
                if (charSequence != null && VERSION.SDK_INT >= 16) {
                    remoteViews.setTextViewText(C0011e.text, charSequence);
                    charSequence = this.mBuilder.mContentText;
                    if (charSequence == null) {
                        remoteViews.setTextViewText(C0011e.text2, charSequence);
                        remoteViews.setViewVisibility(C0011e.text2, 0);
                        obj2 = 1;
                        if (obj2 != null && VERSION.SDK_INT >= 16) {
                            if (z2) {
                                remoteViews.setTextViewTextSize(C0011e.text, 0, (float) resources.getDimensionPixelSize(C0009c.notification_subtext_size));
                            }
                            remoteViews.setViewPadding(C0011e.line1, 0, 0, 0, 0);
                        }
                        if (this.mBuilder.getWhenIfShowing() != 0) {
                            if (this.mBuilder.mUseChronometer || VERSION.SDK_INT < 16) {
                                remoteViews.setViewVisibility(C0011e.time, 0);
                                remoteViews.setLong(C0011e.time, "setTime", this.mBuilder.getWhenIfShowing());
                            } else {
                                remoteViews.setViewVisibility(C0011e.chronometer, 0);
                                remoteViews.setLong(C0011e.chronometer, "setBase", this.mBuilder.getWhenIfShowing() + (SystemClock.elapsedRealtime() - System.currentTimeMillis()));
                                remoteViews.setBoolean(C0011e.chronometer, "setStarted", true);
                            }
                            obj3 = 1;
                        }
                        remoteViews.setViewVisibility(C0011e.right_side, obj3 == null ? 0 : 8);
                        i = C0011e.line3;
                        if (obj == null) {
                            i2 = 8;
                        }
                        remoteViews.setViewVisibility(i, i2);
                        return remoteViews;
                    }
                    remoteViews.setViewVisibility(C0011e.text2, 8);
                }
                obj2 = null;
                if (z2) {
                    remoteViews.setTextViewTextSize(C0011e.text, 0, (float) resources.getDimensionPixelSize(C0009c.notification_subtext_size));
                }
                remoteViews.setViewPadding(C0011e.line1, 0, 0, 0, 0);
                if (this.mBuilder.getWhenIfShowing() != 0) {
                    if (this.mBuilder.mUseChronometer) {
                    }
                    remoteViews.setViewVisibility(C0011e.time, 0);
                    remoteViews.setLong(C0011e.time, "setTime", this.mBuilder.getWhenIfShowing());
                    obj3 = 1;
                }
                if (obj3 == null) {
                }
                remoteViews.setViewVisibility(C0011e.right_side, obj3 == null ? 0 : 8);
                i = C0011e.line3;
                if (obj == null) {
                    i2 = 8;
                }
                remoteViews.setViewVisibility(i, i2);
                return remoteViews;
            }
            remoteViews.setViewVisibility(C0011e.info, 0);
            obj = 1;
            obj3 = 1;
            charSequence = this.mBuilder.mSubText;
            remoteViews.setTextViewText(C0011e.text, charSequence);
            charSequence = this.mBuilder.mContentText;
            if (charSequence == null) {
                remoteViews.setViewVisibility(C0011e.text2, 8);
                obj2 = null;
                if (z2) {
                    remoteViews.setTextViewTextSize(C0011e.text, 0, (float) resources.getDimensionPixelSize(C0009c.notification_subtext_size));
                }
                remoteViews.setViewPadding(C0011e.line1, 0, 0, 0, 0);
                if (this.mBuilder.getWhenIfShowing() != 0) {
                    if (this.mBuilder.mUseChronometer) {
                    }
                    remoteViews.setViewVisibility(C0011e.time, 0);
                    remoteViews.setLong(C0011e.time, "setTime", this.mBuilder.getWhenIfShowing());
                    obj3 = 1;
                }
                if (obj3 == null) {
                }
                remoteViews.setViewVisibility(C0011e.right_side, obj3 == null ? 0 : 8);
                i = C0011e.line3;
                if (obj == null) {
                    i2 = 8;
                }
                remoteViews.setViewVisibility(i, i2);
                return remoteViews;
            }
            remoteViews.setTextViewText(C0011e.text2, charSequence);
            remoteViews.setViewVisibility(C0011e.text2, 0);
            obj2 = 1;
            if (z2) {
                remoteViews.setTextViewTextSize(C0011e.text, 0, (float) resources.getDimensionPixelSize(C0009c.notification_subtext_size));
            }
            remoteViews.setViewPadding(C0011e.line1, 0, 0, 0, 0);
            if (this.mBuilder.getWhenIfShowing() != 0) {
                if (this.mBuilder.mUseChronometer) {
                }
                remoteViews.setViewVisibility(C0011e.time, 0);
                remoteViews.setLong(C0011e.time, "setTime", this.mBuilder.getWhenIfShowing());
                obj3 = 1;
            }
            if (obj3 == null) {
            }
            remoteViews.setViewVisibility(C0011e.right_side, obj3 == null ? 0 : 8);
            i = C0011e.line3;
            if (obj == null) {
                i2 = 8;
            }
            remoteViews.setViewVisibility(i, i2);
            return remoteViews;
        }

        public Notification build() {
            Builder builder = this.mBuilder;
            return builder != null ? builder.build() : null;
        }

        public void buildIntoRemoteViews(RemoteViews remoteViews, RemoteViews remoteViews2) {
            hideNormalContent(remoteViews);
            remoteViews.removeAllViews(C0011e.notification_main_column);
            remoteViews.addView(C0011e.notification_main_column, remoteViews2.clone());
            remoteViews.setViewVisibility(C0011e.notification_main_column, 0);
            if (VERSION.SDK_INT >= 21) {
                remoteViews.setViewPadding(C0011e.notification_main_column_container, 0, calculateTopPadding(), 0, 0);
            }
        }

        public Bitmap createColoredBitmap(int i, int i2) {
            return createColoredBitmap(i, i2, 0);
        }

        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        protected void restoreFromCompatExtras(Bundle bundle) {
        }

        public void setBuilder(Builder builder) {
            if (this.mBuilder != builder) {
                this.mBuilder = builder;
                builder = this.mBuilder;
                if (builder != null) {
                    builder.setStyle(this);
                }
            }
        }
    }

    public static class BigPictureStyle extends Style {
        private Bitmap mBigLargeIcon;
        private boolean mBigLargeIconSet;
        private Bitmap mPicture;

        public BigPictureStyle(Builder builder) {
            setBuilder(builder);
        }

        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (VERSION.SDK_INT >= 16) {
                android.app.Notification.BigPictureStyle bigPicture = new android.app.Notification.BigPictureStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(this.mBigContentTitle).bigPicture(this.mPicture);
                if (this.mBigLargeIconSet) {
                    bigPicture.bigLargeIcon(this.mBigLargeIcon);
                }
                if (this.mSummaryTextSet) {
                    bigPicture.setSummaryText(this.mSummaryText);
                }
            }
        }

        public BigPictureStyle bigLargeIcon(Bitmap bitmap) {
            this.mBigLargeIcon = bitmap;
            this.mBigLargeIconSet = true;
            return this;
        }

        public BigPictureStyle bigPicture(Bitmap bitmap) {
            this.mPicture = bitmap;
            return this;
        }

        public BigPictureStyle setBigContentTitle(CharSequence charSequence) {
            this.mBigContentTitle = Builder.limitCharSequenceLength(charSequence);
            return this;
        }

        public BigPictureStyle setSummaryText(CharSequence charSequence) {
            this.mSummaryText = Builder.limitCharSequenceLength(charSequence);
            this.mSummaryTextSet = true;
            return this;
        }
    }

    public static class BigTextStyle extends Style {
        private CharSequence mBigText;

        public BigTextStyle(Builder builder) {
            setBuilder(builder);
        }

        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (VERSION.SDK_INT >= 16) {
                android.app.Notification.BigTextStyle bigText = new android.app.Notification.BigTextStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(this.mBigContentTitle).bigText(this.mBigText);
                if (this.mSummaryTextSet) {
                    bigText.setSummaryText(this.mSummaryText);
                }
            }
        }

        public BigTextStyle bigText(CharSequence charSequence) {
            this.mBigText = Builder.limitCharSequenceLength(charSequence);
            return this;
        }

        public BigTextStyle setBigContentTitle(CharSequence charSequence) {
            this.mBigContentTitle = Builder.limitCharSequenceLength(charSequence);
            return this;
        }

        public BigTextStyle setSummaryText(CharSequence charSequence) {
            this.mSummaryText = Builder.limitCharSequenceLength(charSequence);
            this.mSummaryTextSet = true;
            return this;
        }
    }

    public static final class CarExtender implements Extender {
        static final String EXTRA_CAR_EXTENDER = "android.car.EXTENSIONS";
        private static final String EXTRA_COLOR = "app_color";
        private static final String EXTRA_CONVERSATION = "car_conversation";
        static final String EXTRA_INVISIBLE_ACTIONS = "invisible_actions";
        private static final String EXTRA_LARGE_ICON = "large_icon";
        private static final String KEY_AUTHOR = "author";
        private static final String KEY_MESSAGES = "messages";
        private static final String KEY_ON_READ = "on_read";
        private static final String KEY_ON_REPLY = "on_reply";
        private static final String KEY_PARTICIPANTS = "participants";
        private static final String KEY_REMOTE_INPUT = "remote_input";
        private static final String KEY_TEXT = "text";
        private static final String KEY_TIMESTAMP = "timestamp";
        private int mColor = 0;
        private Bitmap mLargeIcon;
        private UnreadConversation mUnreadConversation;

        public static class UnreadConversation {
            private final long mLatestTimestamp;
            private final String[] mMessages;
            private final String[] mParticipants;
            private final PendingIntent mReadPendingIntent;
            private final RemoteInput mRemoteInput;
            private final PendingIntent mReplyPendingIntent;

            public static class Builder {
                private long mLatestTimestamp;
                private final List<String> mMessages = new ArrayList();
                private final String mParticipant;
                private PendingIntent mReadPendingIntent;
                private RemoteInput mRemoteInput;
                private PendingIntent mReplyPendingIntent;

                public Builder(String str) {
                    this.mParticipant = str;
                }

                public Builder addMessage(String str) {
                    this.mMessages.add(str);
                    return this;
                }

                public UnreadConversation build() {
                    List list = this.mMessages;
                    return new UnreadConversation((String[]) list.toArray(new String[list.size()]), this.mRemoteInput, this.mReplyPendingIntent, this.mReadPendingIntent, new String[]{this.mParticipant}, this.mLatestTimestamp);
                }

                public Builder setLatestTimestamp(long j) {
                    this.mLatestTimestamp = j;
                    return this;
                }

                public Builder setReadPendingIntent(PendingIntent pendingIntent) {
                    this.mReadPendingIntent = pendingIntent;
                    return this;
                }

                public Builder setReplyAction(PendingIntent pendingIntent, RemoteInput remoteInput) {
                    this.mRemoteInput = remoteInput;
                    this.mReplyPendingIntent = pendingIntent;
                    return this;
                }
            }

            UnreadConversation(String[] strArr, RemoteInput remoteInput, PendingIntent pendingIntent, PendingIntent pendingIntent2, String[] strArr2, long j) {
                this.mMessages = strArr;
                this.mRemoteInput = remoteInput;
                this.mReadPendingIntent = pendingIntent2;
                this.mReplyPendingIntent = pendingIntent;
                this.mParticipants = strArr2;
                this.mLatestTimestamp = j;
            }

            public long getLatestTimestamp() {
                return this.mLatestTimestamp;
            }

            public String[] getMessages() {
                return this.mMessages;
            }

            public String getParticipant() {
                String[] strArr = this.mParticipants;
                return strArr.length > 0 ? strArr[0] : null;
            }

            public String[] getParticipants() {
                return this.mParticipants;
            }

            public PendingIntent getReadPendingIntent() {
                return this.mReadPendingIntent;
            }

            public RemoteInput getRemoteInput() {
                return this.mRemoteInput;
            }

            public PendingIntent getReplyPendingIntent() {
                return this.mReplyPendingIntent;
            }
        }

        public CarExtender(Notification notification) {
            if (VERSION.SDK_INT >= 21) {
                Bundle bundle = NotificationCompat.getExtras(notification) == null ? null : NotificationCompat.getExtras(notification).getBundle(EXTRA_CAR_EXTENDER);
                if (bundle != null) {
                    this.mLargeIcon = (Bitmap) bundle.getParcelable(EXTRA_LARGE_ICON);
                    this.mColor = bundle.getInt(EXTRA_COLOR, 0);
                    this.mUnreadConversation = getUnreadConversationFromBundle(bundle.getBundle(EXTRA_CONVERSATION));
                }
            }
        }

        private static Bundle getBundleForUnreadConversation(UnreadConversation unreadConversation) {
            Bundle bundle = new Bundle();
            int i = 0;
            String str = (unreadConversation.getParticipants() == null || unreadConversation.getParticipants().length <= 1) ? null : unreadConversation.getParticipants()[0];
            Parcelable[] parcelableArr = new Parcelable[unreadConversation.getMessages().length];
            while (i < parcelableArr.length) {
                Bundle bundle2 = new Bundle();
                bundle2.putString(KEY_TEXT, unreadConversation.getMessages()[i]);
                bundle2.putString(KEY_AUTHOR, str);
                parcelableArr[i] = bundle2;
                i++;
            }
            bundle.putParcelableArray(KEY_MESSAGES, parcelableArr);
            RemoteInput remoteInput = unreadConversation.getRemoteInput();
            if (remoteInput != null) {
                bundle.putParcelable(KEY_REMOTE_INPUT, new android.app.RemoteInput.Builder(remoteInput.getResultKey()).setLabel(remoteInput.getLabel()).setChoices(remoteInput.getChoices()).setAllowFreeFormInput(remoteInput.getAllowFreeFormInput()).addExtras(remoteInput.getExtras()).build());
            }
            bundle.putParcelable(KEY_ON_REPLY, unreadConversation.getReplyPendingIntent());
            bundle.putParcelable(KEY_ON_READ, unreadConversation.getReadPendingIntent());
            bundle.putStringArray(KEY_PARTICIPANTS, unreadConversation.getParticipants());
            bundle.putLong(KEY_TIMESTAMP, unreadConversation.getLatestTimestamp());
            return bundle;
        }

        private static UnreadConversation getUnreadConversationFromBundle(Bundle bundle) {
            Bundle bundle2 = bundle;
            UnreadConversation unreadConversation = null;
            if (bundle2 == null) {
                return null;
            }
            String[] strArr;
            Parcelable[] parcelableArray = bundle2.getParcelableArray(KEY_MESSAGES);
            if (parcelableArray != null) {
                String[] strArr2 = new String[parcelableArray.length];
                Object obj = null;
                for (int i = 0; i < strArr2.length; i++) {
                    if (!(parcelableArray[i] instanceof Bundle)) {
                        break;
                    }
                    strArr2[i] = ((Bundle) parcelableArray[i]).getString(KEY_TEXT);
                    if (strArr2[i] == null) {
                        break;
                    }
                }
                obj = 1;
                if (obj == null) {
                    return null;
                }
                strArr = strArr2;
            } else {
                strArr = null;
            }
            PendingIntent pendingIntent = (PendingIntent) bundle2.getParcelable(KEY_ON_READ);
            PendingIntent pendingIntent2 = (PendingIntent) bundle2.getParcelable(KEY_ON_REPLY);
            RemoteInput remoteInput = (RemoteInput) bundle2.getParcelable(KEY_REMOTE_INPUT);
            String[] stringArray = bundle2.getStringArray(KEY_PARTICIPANTS);
            if (stringArray != null) {
                if (stringArray.length == 1) {
                    if (remoteInput != null) {
                        UnreadConversation remoteInput2 = new RemoteInput(remoteInput.getResultKey(), remoteInput.getLabel(), remoteInput.getChoices(), remoteInput.getAllowFreeFormInput(), remoteInput.getExtras(), null);
                    }
                    UnreadConversation unreadConversation2 = new UnreadConversation(strArr, unreadConversation, pendingIntent2, pendingIntent, stringArray, bundle2.getLong(KEY_TIMESTAMP));
                }
            }
            return unreadConversation;
        }

        public Builder extend(Builder builder) {
            if (VERSION.SDK_INT < 21) {
                return builder;
            }
            Bundle bundle = new Bundle();
            Parcelable parcelable = this.mLargeIcon;
            if (parcelable != null) {
                bundle.putParcelable(EXTRA_LARGE_ICON, parcelable);
            }
            int i = this.mColor;
            if (i != 0) {
                bundle.putInt(EXTRA_COLOR, i);
            }
            UnreadConversation unreadConversation = this.mUnreadConversation;
            if (unreadConversation != null) {
                bundle.putBundle(EXTRA_CONVERSATION, getBundleForUnreadConversation(unreadConversation));
            }
            builder.getExtras().putBundle(EXTRA_CAR_EXTENDER, bundle);
            return builder;
        }

        public int getColor() {
            return this.mColor;
        }

        public Bitmap getLargeIcon() {
            return this.mLargeIcon;
        }

        public UnreadConversation getUnreadConversation() {
            return this.mUnreadConversation;
        }

        public CarExtender setColor(int i) {
            this.mColor = i;
            return this;
        }

        public CarExtender setLargeIcon(Bitmap bitmap) {
            this.mLargeIcon = bitmap;
            return this;
        }

        public CarExtender setUnreadConversation(UnreadConversation unreadConversation) {
            this.mUnreadConversation = unreadConversation;
            return this;
        }
    }

    public static class DecoratedCustomViewStyle extends Style {
        private static final int MAX_ACTION_BUTTONS = 3;

        private RemoteViews createRemoteViews(RemoteViews remoteViews, boolean z) {
            boolean z2 = true;
            int i = 0;
            RemoteViews applyStandardTemplate = applyStandardTemplate(true, C0013g.notification_template_custom_big, false);
            applyStandardTemplate.removeAllViews(C0011e.actions);
            if (z) {
                ArrayList arrayList = this.mBuilder.mActions;
                if (arrayList != null) {
                    int min = Math.min(arrayList.size(), 3);
                    if (min > 0) {
                        for (int i2 = 0; i2 < min; i2++) {
                            applyStandardTemplate.addView(C0011e.actions, generateActionButton((Action) this.mBuilder.mActions.get(i2)));
                        }
                        if (z2) {
                            i = 8;
                        }
                        applyStandardTemplate.setViewVisibility(C0011e.actions, i);
                        applyStandardTemplate.setViewVisibility(C0011e.action_divider, i);
                        buildIntoRemoteViews(applyStandardTemplate, remoteViews);
                        return applyStandardTemplate;
                    }
                }
            }
            z2 = false;
            if (z2) {
                i = 8;
            }
            applyStandardTemplate.setViewVisibility(C0011e.actions, i);
            applyStandardTemplate.setViewVisibility(C0011e.action_divider, i);
            buildIntoRemoteViews(applyStandardTemplate, remoteViews);
            return applyStandardTemplate;
        }

        private RemoteViews generateActionButton(Action action) {
            Object obj = action.actionIntent == null ? 1 : null;
            RemoteViews remoteViews = new RemoteViews(this.mBuilder.mContext.getPackageName(), obj != null ? C0013g.notification_action_tombstone : C0013g.notification_action);
            remoteViews.setImageViewBitmap(C0011e.action_image, createColoredBitmap(action.getIcon(), this.mBuilder.mContext.getResources().getColor(C0008b.notification_action_color_filter)));
            remoteViews.setTextViewText(C0011e.action_text, action.title);
            if (obj == null) {
                remoteViews.setOnClickPendingIntent(C0011e.action_container, action.actionIntent);
            }
            if (VERSION.SDK_INT >= 15) {
                remoteViews.setContentDescription(C0011e.action_container, action.title);
            }
            return remoteViews;
        }

        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (VERSION.SDK_INT >= 24) {
                notificationBuilderWithBuilderAccessor.getBuilder().setStyle(new android.app.Notification.DecoratedCustomViewStyle());
            }
        }

        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (VERSION.SDK_INT >= 24) {
                return null;
            }
            RemoteViews bigContentView = this.mBuilder.getBigContentView();
            if (bigContentView == null) {
                bigContentView = this.mBuilder.getContentView();
            }
            return bigContentView == null ? null : createRemoteViews(bigContentView, true);
        }

        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return (VERSION.SDK_INT < 24 && this.mBuilder.getContentView() != null) ? createRemoteViews(this.mBuilder.getContentView(), false) : null;
        }

        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (VERSION.SDK_INT >= 24) {
                return null;
            }
            RemoteViews headsUpContentView = this.mBuilder.getHeadsUpContentView();
            return headsUpContentView == null ? null : createRemoteViews(headsUpContentView != null ? headsUpContentView : this.mBuilder.getContentView(), true);
        }
    }

    public static class InboxStyle extends Style {
        private ArrayList<CharSequence> mTexts = new ArrayList();

        public InboxStyle(Builder builder) {
            setBuilder(builder);
        }

        public InboxStyle addLine(CharSequence charSequence) {
            this.mTexts.add(Builder.limitCharSequenceLength(charSequence));
            return this;
        }

        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (VERSION.SDK_INT >= 16) {
                android.app.Notification.InboxStyle bigContentTitle = new android.app.Notification.InboxStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(this.mBigContentTitle);
                if (this.mSummaryTextSet) {
                    bigContentTitle.setSummaryText(this.mSummaryText);
                }
                Iterator it = this.mTexts.iterator();
                while (it.hasNext()) {
                    bigContentTitle.addLine((CharSequence) it.next());
                }
            }
        }

        public InboxStyle setBigContentTitle(CharSequence charSequence) {
            this.mBigContentTitle = Builder.limitCharSequenceLength(charSequence);
            return this;
        }

        public InboxStyle setSummaryText(CharSequence charSequence) {
            this.mSummaryText = Builder.limitCharSequenceLength(charSequence);
            this.mSummaryTextSet = true;
            return this;
        }
    }

    public static class MessagingStyle extends Style {
        public static final int MAXIMUM_RETAINED_MESSAGES = 25;
        private CharSequence mConversationTitle;
        private Boolean mIsGroupConversation;
        private final List<Message> mMessages = new ArrayList();
        private Person mUser;

        public static final class Message {
            static final String KEY_DATA_MIME_TYPE = "type";
            static final String KEY_DATA_URI = "uri";
            static final String KEY_EXTRAS_BUNDLE = "extras";
            static final String KEY_NOTIFICATION_PERSON = "sender_person";
            static final String KEY_PERSON = "person";
            static final String KEY_SENDER = "sender";
            static final String KEY_TEXT = "text";
            static final String KEY_TIMESTAMP = "time";
            private String mDataMimeType;
            private Uri mDataUri;
            private Bundle mExtras;
            private final Person mPerson;
            private final CharSequence mText;
            private final long mTimestamp;

            public Message(CharSequence charSequence, long j, Person person) {
                this.mExtras = new Bundle();
                this.mText = charSequence;
                this.mTimestamp = j;
                this.mPerson = person;
            }

            @Deprecated
            public Message(CharSequence charSequence, long j, CharSequence charSequence2) {
                this(charSequence, j, new android.support.v4.app.Person.Builder().setName(charSequence2).build());
            }

            static Bundle[] getBundleArrayForMessages(List<Message> list) {
                Bundle[] bundleArr = new Bundle[list.size()];
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    bundleArr[i] = ((Message) list.get(i)).toBundle();
                }
                return bundleArr;
            }

            static android.support.v4.app.NotificationCompat.MessagingStyle.Message getMessageFromBundle(android.os.Bundle r10) {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
                /*
                r0 = "uri";
                r1 = "extras";
                r2 = "type";
                r3 = "sender";
                r4 = "sender_person";
                r5 = "person";
                r6 = "time";
                r7 = "text";
                r8 = 0;
                r9 = r10.containsKey(r7);	 Catch:{ ClassCastException -> 0x0096 }
                if (r9 == 0) goto L_0x0096;	 Catch:{ ClassCastException -> 0x0096 }
            L_0x0017:
                r9 = r10.containsKey(r6);	 Catch:{ ClassCastException -> 0x0096 }
                if (r9 != 0) goto L_0x001f;	 Catch:{ ClassCastException -> 0x0096 }
            L_0x001d:
                goto L_0x0096;	 Catch:{ ClassCastException -> 0x0096 }
            L_0x001f:
                r9 = r10.containsKey(r5);	 Catch:{ ClassCastException -> 0x0096 }
                if (r9 == 0) goto L_0x002e;	 Catch:{ ClassCastException -> 0x0096 }
            L_0x0025:
                r3 = r10.getBundle(r5);	 Catch:{ ClassCastException -> 0x0096 }
                r3 = android.support.v4.app.Person.fromBundle(r3);	 Catch:{ ClassCastException -> 0x0096 }
                goto L_0x005e;	 Catch:{ ClassCastException -> 0x0096 }
            L_0x002e:
                r5 = r10.containsKey(r4);	 Catch:{ ClassCastException -> 0x0096 }
                if (r5 == 0) goto L_0x0045;	 Catch:{ ClassCastException -> 0x0096 }
            L_0x0034:
                r5 = android.os.Build.VERSION.SDK_INT;	 Catch:{ ClassCastException -> 0x0096 }
                r9 = 28;	 Catch:{ ClassCastException -> 0x0096 }
                if (r5 < r9) goto L_0x0045;	 Catch:{ ClassCastException -> 0x0096 }
            L_0x003a:
                r3 = r10.getParcelable(r4);	 Catch:{ ClassCastException -> 0x0096 }
                r3 = (android.app.Person) r3;	 Catch:{ ClassCastException -> 0x0096 }
                r3 = android.support.v4.app.Person.fromAndroidPerson(r3);	 Catch:{ ClassCastException -> 0x0096 }
                goto L_0x005e;	 Catch:{ ClassCastException -> 0x0096 }
            L_0x0045:
                r4 = r10.containsKey(r3);	 Catch:{ ClassCastException -> 0x0096 }
                if (r4 == 0) goto L_0x005d;	 Catch:{ ClassCastException -> 0x0096 }
            L_0x004b:
                r4 = new android.support.v4.app.Person$Builder;	 Catch:{ ClassCastException -> 0x0096 }
                r4.<init>();	 Catch:{ ClassCastException -> 0x0096 }
                r3 = r10.getCharSequence(r3);	 Catch:{ ClassCastException -> 0x0096 }
                r3 = r4.setName(r3);	 Catch:{ ClassCastException -> 0x0096 }
                r3 = r3.build();	 Catch:{ ClassCastException -> 0x0096 }
                goto L_0x005e;	 Catch:{ ClassCastException -> 0x0096 }
            L_0x005d:
                r3 = r8;	 Catch:{ ClassCastException -> 0x0096 }
            L_0x005e:
                r4 = new android.support.v4.app.NotificationCompat$MessagingStyle$Message;	 Catch:{ ClassCastException -> 0x0096 }
                r5 = r10.getCharSequence(r7);	 Catch:{ ClassCastException -> 0x0096 }
                r6 = r10.getLong(r6);	 Catch:{ ClassCastException -> 0x0096 }
                r4.<init>(r5, r6, r3);	 Catch:{ ClassCastException -> 0x0096 }
                r3 = r10.containsKey(r2);	 Catch:{ ClassCastException -> 0x0096 }
                if (r3 == 0) goto L_0x0084;	 Catch:{ ClassCastException -> 0x0096 }
            L_0x0071:
                r3 = r10.containsKey(r0);	 Catch:{ ClassCastException -> 0x0096 }
                if (r3 == 0) goto L_0x0084;	 Catch:{ ClassCastException -> 0x0096 }
            L_0x0077:
                r2 = r10.getString(r2);	 Catch:{ ClassCastException -> 0x0096 }
                r0 = r10.getParcelable(r0);	 Catch:{ ClassCastException -> 0x0096 }
                r0 = (android.net.Uri) r0;	 Catch:{ ClassCastException -> 0x0096 }
                r4.setData(r2, r0);	 Catch:{ ClassCastException -> 0x0096 }
            L_0x0084:
                r0 = r10.containsKey(r1);	 Catch:{ ClassCastException -> 0x0096 }
                if (r0 == 0) goto L_0x0095;	 Catch:{ ClassCastException -> 0x0096 }
            L_0x008a:
                r0 = r4.getExtras();	 Catch:{ ClassCastException -> 0x0096 }
                r10 = r10.getBundle(r1);	 Catch:{ ClassCastException -> 0x0096 }
                r0.putAll(r10);	 Catch:{ ClassCastException -> 0x0096 }
            L_0x0095:
                return r4;
            L_0x0096:
                return r8;
                */
                throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.NotificationCompat.MessagingStyle.Message.getMessageFromBundle(android.os.Bundle):android.support.v4.app.NotificationCompat$MessagingStyle$Message");
            }

            static List<Message> getMessagesFromBundleArray(Parcelable[] parcelableArr) {
                List<Message> arrayList = new ArrayList(parcelableArr.length);
                for (int i = 0; i < parcelableArr.length; i++) {
                    if (parcelableArr[i] instanceof Bundle) {
                        Message messageFromBundle = getMessageFromBundle((Bundle) parcelableArr[i]);
                        if (messageFromBundle != null) {
                            arrayList.add(messageFromBundle);
                        }
                    }
                }
                return arrayList;
            }

            private Bundle toBundle() {
                Bundle bundle = new Bundle();
                CharSequence charSequence = this.mText;
                if (charSequence != null) {
                    bundle.putCharSequence(KEY_TEXT, charSequence);
                }
                bundle.putLong(KEY_TIMESTAMP, this.mTimestamp);
                Person person = this.mPerson;
                if (person != null) {
                    bundle.putCharSequence(KEY_SENDER, person.getName());
                    if (VERSION.SDK_INT >= 28) {
                        bundle.putParcelable(KEY_NOTIFICATION_PERSON, this.mPerson.toAndroidPerson());
                    } else {
                        bundle.putBundle(KEY_PERSON, this.mPerson.toBundle());
                    }
                }
                String str = this.mDataMimeType;
                if (str != null) {
                    bundle.putString(KEY_DATA_MIME_TYPE, str);
                }
                Parcelable parcelable = this.mDataUri;
                if (parcelable != null) {
                    bundle.putParcelable(KEY_DATA_URI, parcelable);
                }
                Bundle bundle2 = this.mExtras;
                if (bundle2 != null) {
                    bundle.putBundle(KEY_EXTRAS_BUNDLE, bundle2);
                }
                return bundle;
            }

            public String getDataMimeType() {
                return this.mDataMimeType;
            }

            public Uri getDataUri() {
                return this.mDataUri;
            }

            public Bundle getExtras() {
                return this.mExtras;
            }

            public Person getPerson() {
                return this.mPerson;
            }

            @Deprecated
            public CharSequence getSender() {
                Person person = this.mPerson;
                return person == null ? null : person.getName();
            }

            public CharSequence getText() {
                return this.mText;
            }

            public long getTimestamp() {
                return this.mTimestamp;
            }

            public Message setData(String str, Uri uri) {
                this.mDataMimeType = str;
                this.mDataUri = uri;
                return this;
            }
        }

        private MessagingStyle() {
        }

        public MessagingStyle(Person person) {
            if (TextUtils.isEmpty(person.getName())) {
                throw new IllegalArgumentException("User's name must not be empty.");
            }
            this.mUser = person;
        }

        @Deprecated
        public MessagingStyle(CharSequence charSequence) {
            this.mUser = new android.support.v4.app.Person.Builder().setName(charSequence).build();
        }

        public static android.support.v4.app.NotificationCompat.MessagingStyle extractMessagingStyleFromNotification(android.app.Notification r2) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
            /*
            r2 = android.support.v4.app.NotificationCompat.getExtras(r2);
            r0 = 0;
            if (r2 == 0) goto L_0x0018;
        L_0x0007:
            r1 = "android.selfDisplayName";
            r1 = r2.containsKey(r1);
            if (r1 != 0) goto L_0x0018;
        L_0x000f:
            r1 = "android.messagingStyleUser";
            r1 = r2.containsKey(r1);
            if (r1 != 0) goto L_0x0018;
        L_0x0017:
            return r0;
        L_0x0018:
            r1 = new android.support.v4.app.NotificationCompat$MessagingStyle;	 Catch:{ ClassCastException -> 0x0021 }
            r1.<init>();	 Catch:{ ClassCastException -> 0x0021 }
            r1.restoreFromCompatExtras(r2);	 Catch:{ ClassCastException -> 0x0021 }
            return r1;
        L_0x0021:
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.NotificationCompat.MessagingStyle.extractMessagingStyleFromNotification(android.app.Notification):android.support.v4.app.NotificationCompat$MessagingStyle");
        }

        private Message findLatestIncomingMessage() {
            for (int size = this.mMessages.size() - 1; size >= 0; size--) {
                Message message = (Message) this.mMessages.get(size);
                if (message.getPerson() != null && !TextUtils.isEmpty(message.getPerson().getName())) {
                    return message;
                }
            }
            if (this.mMessages.isEmpty()) {
                return null;
            }
            List list = this.mMessages;
            return (Message) list.get(list.size() - 1);
        }

        private boolean hasMessagesWithoutSender() {
            for (int size = this.mMessages.size() - 1; size >= 0; size--) {
                Message message = (Message) this.mMessages.get(size);
                if (message.getPerson() != null && message.getPerson().getName() == null) {
                    return true;
                }
            }
            return false;
        }

        private TextAppearanceSpan makeFontColorSpan(int i) {
            return new TextAppearanceSpan(null, 0, 0, ColorStateList.valueOf(i), null);
        }

        private CharSequence makeMessageLine(Message message) {
            BidiFormatter instance = BidiFormatter.getInstance();
            CharSequence spannableStringBuilder = new SpannableStringBuilder();
            Object obj = VERSION.SDK_INT >= 21 ? 1 : null;
            int i = obj != null ? ViewCompat.MEASURED_STATE_MASK : -1;
            CharSequence charSequence = "";
            CharSequence name = message.getPerson() == null ? charSequence : message.getPerson().getName();
            if (TextUtils.isEmpty(name)) {
                name = this.mUser.getName();
                if (!(obj == null || this.mBuilder.getColor() == 0)) {
                    i = this.mBuilder.getColor();
                }
            }
            CharSequence unicodeWrap = instance.unicodeWrap(name);
            spannableStringBuilder.append(unicodeWrap);
            spannableStringBuilder.setSpan(makeFontColorSpan(i), spannableStringBuilder.length() - unicodeWrap.length(), spannableStringBuilder.length(), 33);
            if (message.getText() != null) {
                charSequence = message.getText();
            }
            spannableStringBuilder.append("  ").append(instance.unicodeWrap(charSequence));
            return spannableStringBuilder;
        }

        public void addCompatExtras(Bundle bundle) {
            super.addCompatExtras(bundle);
            bundle.putCharSequence(NotificationCompat.EXTRA_SELF_DISPLAY_NAME, this.mUser.getName());
            bundle.putBundle(NotificationCompat.EXTRA_MESSAGING_STYLE_USER, this.mUser.toBundle());
            bundle.putCharSequence(NotificationCompat.EXTRA_HIDDEN_CONVERSATION_TITLE, this.mConversationTitle);
            if (this.mConversationTitle != null && this.mIsGroupConversation.booleanValue()) {
                bundle.putCharSequence(NotificationCompat.EXTRA_CONVERSATION_TITLE, this.mConversationTitle);
            }
            if (!this.mMessages.isEmpty()) {
                bundle.putParcelableArray(NotificationCompat.EXTRA_MESSAGES, Message.getBundleArrayForMessages(this.mMessages));
            }
            Boolean bool = this.mIsGroupConversation;
            if (bool != null) {
                bundle.putBoolean(NotificationCompat.EXTRA_IS_GROUP_CONVERSATION, bool.booleanValue());
            }
        }

        public MessagingStyle addMessage(Message message) {
            this.mMessages.add(message);
            if (this.mMessages.size() > 25) {
                this.mMessages.remove(0);
            }
            return this;
        }

        public MessagingStyle addMessage(CharSequence charSequence, long j, Person person) {
            addMessage(new Message(charSequence, j, person));
            return this;
        }

        @Deprecated
        public MessagingStyle addMessage(CharSequence charSequence, long j, CharSequence charSequence2) {
            this.mMessages.add(new Message(charSequence, j, new android.support.v4.app.Person.Builder().setName(charSequence2).build()));
            if (this.mMessages.size() > 25) {
                this.mMessages.remove(0);
            }
            return this;
        }

        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            setGroupConversation(isGroupConversation());
            int i = VERSION.SDK_INT;
            if (i >= 24) {
                android.app.Notification.MessagingStyle messagingStyle = i >= 28 ? new android.app.Notification.MessagingStyle(this.mUser.toAndroidPerson()) : new android.app.Notification.MessagingStyle(this.mUser.getName());
                if (this.mIsGroupConversation.booleanValue() || VERSION.SDK_INT >= 28) {
                    messagingStyle.setConversationTitle(this.mConversationTitle);
                }
                if (VERSION.SDK_INT >= 28) {
                    messagingStyle.setGroupConversation(this.mIsGroupConversation.booleanValue());
                }
                for (Message message : this.mMessages) {
                    android.app.Notification.MessagingStyle.Message message2;
                    if (VERSION.SDK_INT >= 28) {
                        Person person = message.getPerson();
                        message2 = new android.app.Notification.MessagingStyle.Message(message.getText(), message.getTimestamp(), person == null ? null : person.toAndroidPerson());
                    } else {
                        message2 = new android.app.Notification.MessagingStyle.Message(message.getText(), message.getTimestamp(), message.getPerson() != null ? message.getPerson().getName() : null);
                    }
                    if (message.getDataMimeType() != null) {
                        message2.setData(message.getDataMimeType(), message.getDataUri());
                    }
                    messagingStyle.addMessage(message2);
                }
                messagingStyle.setBuilder(notificationBuilderWithBuilderAccessor.getBuilder());
                return;
            }
            android.app.Notification.Builder builder;
            CharSequence name;
            CharSequence spannableStringBuilder;
            CharSequence makeMessageLine;
            Message findLatestIncomingMessage = findLatestIncomingMessage();
            Object obj;
            int size;
            Message message3;
            if (this.mConversationTitle == null || !this.mIsGroupConversation.booleanValue()) {
                if (findLatestIncomingMessage != null) {
                    notificationBuilderWithBuilderAccessor.getBuilder().setContentTitle("");
                    if (findLatestIncomingMessage.getPerson() != null) {
                        builder = notificationBuilderWithBuilderAccessor.getBuilder();
                        name = findLatestIncomingMessage.getPerson().getName();
                    }
                }
                if (findLatestIncomingMessage != null) {
                    notificationBuilderWithBuilderAccessor.getBuilder().setContentText(this.mConversationTitle == null ? makeMessageLine(findLatestIncomingMessage) : findLatestIncomingMessage.getText());
                }
                if (VERSION.SDK_INT >= 16) {
                    spannableStringBuilder = new SpannableStringBuilder();
                    if (this.mConversationTitle == null) {
                        if (hasMessagesWithoutSender()) {
                            obj = null;
                            for (size = this.mMessages.size() - 1; size >= 0; size--) {
                                message3 = (Message) this.mMessages.get(size);
                                makeMessageLine = obj == null ? makeMessageLine(message3) : message3.getText();
                                if (size == this.mMessages.size() - 1) {
                                    spannableStringBuilder.insert(0, "\n");
                                }
                                spannableStringBuilder.insert(0, makeMessageLine);
                            }
                            new android.app.Notification.BigTextStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(null).bigText(spannableStringBuilder);
                        }
                    }
                    obj = 1;
                    for (size = this.mMessages.size() - 1; size >= 0; size--) {
                        message3 = (Message) this.mMessages.get(size);
                        if (obj == null) {
                        }
                        if (size == this.mMessages.size() - 1) {
                            spannableStringBuilder.insert(0, "\n");
                        }
                        spannableStringBuilder.insert(0, makeMessageLine);
                    }
                    new android.app.Notification.BigTextStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(null).bigText(spannableStringBuilder);
                }
            }
            builder = notificationBuilderWithBuilderAccessor.getBuilder();
            name = this.mConversationTitle;
            builder.setContentTitle(name);
            if (findLatestIncomingMessage != null) {
                if (this.mConversationTitle == null) {
                }
                notificationBuilderWithBuilderAccessor.getBuilder().setContentText(this.mConversationTitle == null ? makeMessageLine(findLatestIncomingMessage) : findLatestIncomingMessage.getText());
            }
            if (VERSION.SDK_INT >= 16) {
                spannableStringBuilder = new SpannableStringBuilder();
                if (this.mConversationTitle == null) {
                    if (hasMessagesWithoutSender()) {
                        obj = null;
                        for (size = this.mMessages.size() - 1; size >= 0; size--) {
                            message3 = (Message) this.mMessages.get(size);
                            if (obj == null) {
                            }
                            if (size == this.mMessages.size() - 1) {
                                spannableStringBuilder.insert(0, "\n");
                            }
                            spannableStringBuilder.insert(0, makeMessageLine);
                        }
                        new android.app.Notification.BigTextStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(null).bigText(spannableStringBuilder);
                    }
                }
                obj = 1;
                for (size = this.mMessages.size() - 1; size >= 0; size--) {
                    message3 = (Message) this.mMessages.get(size);
                    if (obj == null) {
                    }
                    if (size == this.mMessages.size() - 1) {
                        spannableStringBuilder.insert(0, "\n");
                    }
                    spannableStringBuilder.insert(0, makeMessageLine);
                }
                new android.app.Notification.BigTextStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(null).bigText(spannableStringBuilder);
            }
        }

        public CharSequence getConversationTitle() {
            return this.mConversationTitle;
        }

        public List<Message> getMessages() {
            return this.mMessages;
        }

        public Person getUser() {
            return this.mUser;
        }

        @Deprecated
        public CharSequence getUserDisplayName() {
            return this.mUser.getName();
        }

        public boolean isGroupConversation() {
            Builder builder = this.mBuilder;
            boolean z = false;
            if (builder == null || builder.mContext.getApplicationInfo().targetSdkVersion >= 28 || this.mIsGroupConversation != null) {
                Boolean bool = this.mIsGroupConversation;
                if (bool != null) {
                    z = bool.booleanValue();
                }
                return z;
            }
            if (this.mConversationTitle != null) {
                z = true;
            }
            return z;
        }

        protected void restoreFromCompatExtras(Bundle bundle) {
            this.mMessages.clear();
            String str = NotificationCompat.EXTRA_MESSAGING_STYLE_USER;
            this.mUser = bundle.containsKey(str) ? Person.fromBundle(bundle.getBundle(str)) : new android.support.v4.app.Person.Builder().setName(bundle.getString(NotificationCompat.EXTRA_SELF_DISPLAY_NAME)).build();
            this.mConversationTitle = bundle.getCharSequence(NotificationCompat.EXTRA_CONVERSATION_TITLE);
            if (this.mConversationTitle == null) {
                this.mConversationTitle = bundle.getCharSequence(NotificationCompat.EXTRA_HIDDEN_CONVERSATION_TITLE);
            }
            Parcelable[] parcelableArray = bundle.getParcelableArray(NotificationCompat.EXTRA_MESSAGES);
            if (parcelableArray != null) {
                this.mMessages.addAll(Message.getMessagesFromBundleArray(parcelableArray));
            }
            str = NotificationCompat.EXTRA_IS_GROUP_CONVERSATION;
            if (bundle.containsKey(str)) {
                this.mIsGroupConversation = Boolean.valueOf(bundle.getBoolean(str));
            }
        }

        public MessagingStyle setConversationTitle(CharSequence charSequence) {
            this.mConversationTitle = charSequence;
            return this;
        }

        public MessagingStyle setGroupConversation(boolean z) {
            this.mIsGroupConversation = Boolean.valueOf(z);
            return this;
        }
    }

    public static final class WearableExtender implements Extender {
        private static final int DEFAULT_CONTENT_ICON_GRAVITY = 8388613;
        private static final int DEFAULT_FLAGS = 1;
        private static final int DEFAULT_GRAVITY = 80;
        private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
        private static final int FLAG_BIG_PICTURE_AMBIENT = 32;
        private static final int FLAG_CONTENT_INTENT_AVAILABLE_OFFLINE = 1;
        private static final int FLAG_HINT_AVOID_BACKGROUND_CLIPPING = 16;
        private static final int FLAG_HINT_CONTENT_INTENT_LAUNCHES_ACTIVITY = 64;
        private static final int FLAG_HINT_HIDE_ICON = 2;
        private static final int FLAG_HINT_SHOW_BACKGROUND_ONLY = 4;
        private static final int FLAG_START_SCROLL_BOTTOM = 8;
        private static final String KEY_ACTIONS = "actions";
        private static final String KEY_BACKGROUND = "background";
        private static final String KEY_BRIDGE_TAG = "bridgeTag";
        private static final String KEY_CONTENT_ACTION_INDEX = "contentActionIndex";
        private static final String KEY_CONTENT_ICON = "contentIcon";
        private static final String KEY_CONTENT_ICON_GRAVITY = "contentIconGravity";
        private static final String KEY_CUSTOM_CONTENT_HEIGHT = "customContentHeight";
        private static final String KEY_CUSTOM_SIZE_PRESET = "customSizePreset";
        private static final String KEY_DISMISSAL_ID = "dismissalId";
        private static final String KEY_DISPLAY_INTENT = "displayIntent";
        private static final String KEY_FLAGS = "flags";
        private static final String KEY_GRAVITY = "gravity";
        private static final String KEY_HINT_SCREEN_TIMEOUT = "hintScreenTimeout";
        private static final String KEY_PAGES = "pages";
        public static final int SCREEN_TIMEOUT_LONG = -1;
        public static final int SCREEN_TIMEOUT_SHORT = 0;
        public static final int SIZE_DEFAULT = 0;
        public static final int SIZE_FULL_SCREEN = 5;
        public static final int SIZE_LARGE = 4;
        public static final int SIZE_MEDIUM = 3;
        public static final int SIZE_SMALL = 2;
        public static final int SIZE_XSMALL = 1;
        public static final int UNSET_ACTION_INDEX = -1;
        private ArrayList<Action> mActions = new ArrayList();
        private Bitmap mBackground;
        private String mBridgeTag;
        private int mContentActionIndex = -1;
        private int mContentIcon;
        private int mContentIconGravity = 8388613;
        private int mCustomContentHeight;
        private int mCustomSizePreset = 0;
        private String mDismissalId;
        private PendingIntent mDisplayIntent;
        private int mFlags = 1;
        private int mGravity = 80;
        private int mHintScreenTimeout;
        private ArrayList<Notification> mPages = new ArrayList();

        public WearableExtender(Notification notification) {
            Bundle extras = NotificationCompat.getExtras(notification);
            extras = extras != null ? extras.getBundle(EXTRA_WEARABLE_EXTENSIONS) : null;
            if (extras != null) {
                ArrayList parcelableArrayList = extras.getParcelableArrayList(KEY_ACTIONS);
                if (VERSION.SDK_INT >= 16 && parcelableArrayList != null) {
                    Action[] actionArr = new Action[parcelableArrayList.size()];
                    for (int i = 0; i < actionArr.length; i++) {
                        int i2 = VERSION.SDK_INT;
                        if (i2 >= 20) {
                            actionArr[i] = NotificationCompat.getActionCompatFromAction((android.app.Notification.Action) parcelableArrayList.get(i));
                        } else if (i2 >= 16) {
                            actionArr[i] = NotificationCompatJellybean.getActionFromBundle((Bundle) parcelableArrayList.get(i));
                        }
                    }
                    Collections.addAll(this.mActions, actionArr);
                }
                this.mFlags = extras.getInt(KEY_FLAGS, 1);
                this.mDisplayIntent = (PendingIntent) extras.getParcelable(KEY_DISPLAY_INTENT);
                Notification[] notificationArrayFromBundle = NotificationCompat.getNotificationArrayFromBundle(extras, KEY_PAGES);
                if (notificationArrayFromBundle != null) {
                    Collections.addAll(this.mPages, notificationArrayFromBundle);
                }
                this.mBackground = (Bitmap) extras.getParcelable(KEY_BACKGROUND);
                this.mContentIcon = extras.getInt(KEY_CONTENT_ICON);
                this.mContentIconGravity = extras.getInt(KEY_CONTENT_ICON_GRAVITY, 8388613);
                this.mContentActionIndex = extras.getInt(KEY_CONTENT_ACTION_INDEX, -1);
                this.mCustomSizePreset = extras.getInt(KEY_CUSTOM_SIZE_PRESET, 0);
                this.mCustomContentHeight = extras.getInt(KEY_CUSTOM_CONTENT_HEIGHT);
                this.mGravity = extras.getInt(KEY_GRAVITY, 80);
                this.mHintScreenTimeout = extras.getInt(KEY_HINT_SCREEN_TIMEOUT);
                this.mDismissalId = extras.getString(KEY_DISMISSAL_ID);
                this.mBridgeTag = extras.getString(KEY_BRIDGE_TAG);
            }
        }

        private static android.app.Notification.Action getActionFromActionCompat(Action action) {
            android.app.Notification.Action.Builder builder = new android.app.Notification.Action.Builder(action.getIcon(), action.getTitle(), action.getActionIntent());
            Bundle bundle = action.getExtras() != null ? new Bundle(action.getExtras()) : new Bundle();
            bundle.putBoolean("android.support.allowGeneratedReplies", action.getAllowGeneratedReplies());
            if (VERSION.SDK_INT >= 24) {
                builder.setAllowGeneratedReplies(action.getAllowGeneratedReplies());
            }
            builder.addExtras(bundle);
            RemoteInput[] remoteInputs = action.getRemoteInputs();
            if (remoteInputs != null) {
                for (RemoteInput addRemoteInput : RemoteInput.fromCompat(remoteInputs)) {
                    builder.addRemoteInput(addRemoteInput);
                }
            }
            return builder.build();
        }

        private void setFlag(int i, boolean z) {
            if (z) {
                i |= this.mFlags;
            } else {
                i = (i ^ -1) & this.mFlags;
            }
            this.mFlags = i;
        }

        public WearableExtender addAction(Action action) {
            this.mActions.add(action);
            return this;
        }

        public WearableExtender addActions(List<Action> list) {
            this.mActions.addAll(list);
            return this;
        }

        public WearableExtender addPage(Notification notification) {
            this.mPages.add(notification);
            return this;
        }

        public WearableExtender addPages(List<Notification> list) {
            this.mPages.addAll(list);
            return this;
        }

        public WearableExtender clearActions() {
            this.mActions.clear();
            return this;
        }

        public WearableExtender clearPages() {
            this.mPages.clear();
            return this;
        }

        public WearableExtender clone() {
            WearableExtender wearableExtender = new WearableExtender();
            wearableExtender.mActions = new ArrayList(this.mActions);
            wearableExtender.mFlags = this.mFlags;
            wearableExtender.mDisplayIntent = this.mDisplayIntent;
            wearableExtender.mPages = new ArrayList(this.mPages);
            wearableExtender.mBackground = this.mBackground;
            wearableExtender.mContentIcon = this.mContentIcon;
            wearableExtender.mContentIconGravity = this.mContentIconGravity;
            wearableExtender.mContentActionIndex = this.mContentActionIndex;
            wearableExtender.mCustomSizePreset = this.mCustomSizePreset;
            wearableExtender.mCustomContentHeight = this.mCustomContentHeight;
            wearableExtender.mGravity = this.mGravity;
            wearableExtender.mHintScreenTimeout = this.mHintScreenTimeout;
            wearableExtender.mDismissalId = this.mDismissalId;
            wearableExtender.mBridgeTag = this.mBridgeTag;
            return wearableExtender;
        }

        public Builder extend(Builder builder) {
            int i;
            ArrayList arrayList;
            Bundle bundle = new Bundle();
            if (!this.mActions.isEmpty()) {
                i = VERSION.SDK_INT;
                String str = KEY_ACTIONS;
                if (i >= 16) {
                    arrayList = new ArrayList(this.mActions.size());
                    Iterator it = this.mActions.iterator();
                    while (it.hasNext()) {
                        Object actionFromActionCompat;
                        Action action = (Action) it.next();
                        int i2 = VERSION.SDK_INT;
                        if (i2 >= 20) {
                            actionFromActionCompat = getActionFromActionCompat(action);
                        } else if (i2 >= 16) {
                            actionFromActionCompat = NotificationCompatJellybean.getBundleForAction(action);
                        }
                        arrayList.add(actionFromActionCompat);
                    }
                } else {
                    arrayList = null;
                }
                bundle.putParcelableArrayList(str, arrayList);
            }
            i = this.mFlags;
            if (i != 1) {
                bundle.putInt(KEY_FLAGS, i);
            }
            Parcelable parcelable = this.mDisplayIntent;
            if (parcelable != null) {
                bundle.putParcelable(KEY_DISPLAY_INTENT, parcelable);
            }
            if (!this.mPages.isEmpty()) {
                arrayList = this.mPages;
                bundle.putParcelableArray(KEY_PAGES, (Parcelable[]) arrayList.toArray(new Notification[arrayList.size()]));
            }
            parcelable = this.mBackground;
            if (parcelable != null) {
                bundle.putParcelable(KEY_BACKGROUND, parcelable);
            }
            i = this.mContentIcon;
            if (i != 0) {
                bundle.putInt(KEY_CONTENT_ICON, i);
            }
            i = this.mContentIconGravity;
            if (i != 8388613) {
                bundle.putInt(KEY_CONTENT_ICON_GRAVITY, i);
            }
            i = this.mContentActionIndex;
            if (i != -1) {
                bundle.putInt(KEY_CONTENT_ACTION_INDEX, i);
            }
            i = this.mCustomSizePreset;
            if (i != 0) {
                bundle.putInt(KEY_CUSTOM_SIZE_PRESET, i);
            }
            i = this.mCustomContentHeight;
            if (i != 0) {
                bundle.putInt(KEY_CUSTOM_CONTENT_HEIGHT, i);
            }
            i = this.mGravity;
            if (i != 80) {
                bundle.putInt(KEY_GRAVITY, i);
            }
            i = this.mHintScreenTimeout;
            if (i != 0) {
                bundle.putInt(KEY_HINT_SCREEN_TIMEOUT, i);
            }
            String str2 = this.mDismissalId;
            if (str2 != null) {
                bundle.putString(KEY_DISMISSAL_ID, str2);
            }
            str2 = this.mBridgeTag;
            if (str2 != null) {
                bundle.putString(KEY_BRIDGE_TAG, str2);
            }
            builder.getExtras().putBundle(EXTRA_WEARABLE_EXTENSIONS, bundle);
            return builder;
        }

        public List<Action> getActions() {
            return this.mActions;
        }

        public Bitmap getBackground() {
            return this.mBackground;
        }

        public String getBridgeTag() {
            return this.mBridgeTag;
        }

        public int getContentAction() {
            return this.mContentActionIndex;
        }

        @Deprecated
        public int getContentIcon() {
            return this.mContentIcon;
        }

        @Deprecated
        public int getContentIconGravity() {
            return this.mContentIconGravity;
        }

        public boolean getContentIntentAvailableOffline() {
            return (this.mFlags & 1) != 0;
        }

        @Deprecated
        public int getCustomContentHeight() {
            return this.mCustomContentHeight;
        }

        @Deprecated
        public int getCustomSizePreset() {
            return this.mCustomSizePreset;
        }

        public String getDismissalId() {
            return this.mDismissalId;
        }

        public PendingIntent getDisplayIntent() {
            return this.mDisplayIntent;
        }

        @Deprecated
        public int getGravity() {
            return this.mGravity;
        }

        public boolean getHintAmbientBigPicture() {
            return (this.mFlags & 32) != 0;
        }

        @Deprecated
        public boolean getHintAvoidBackgroundClipping() {
            return (this.mFlags & 16) != 0;
        }

        public boolean getHintContentIntentLaunchesActivity() {
            return (this.mFlags & 64) != 0;
        }

        @Deprecated
        public boolean getHintHideIcon() {
            return (this.mFlags & 2) != 0;
        }

        @Deprecated
        public int getHintScreenTimeout() {
            return this.mHintScreenTimeout;
        }

        @Deprecated
        public boolean getHintShowBackgroundOnly() {
            return (this.mFlags & 4) != 0;
        }

        public List<Notification> getPages() {
            return this.mPages;
        }

        public boolean getStartScrollBottom() {
            return (this.mFlags & 8) != 0;
        }

        public WearableExtender setBackground(Bitmap bitmap) {
            this.mBackground = bitmap;
            return this;
        }

        public WearableExtender setBridgeTag(String str) {
            this.mBridgeTag = str;
            return this;
        }

        public WearableExtender setContentAction(int i) {
            this.mContentActionIndex = i;
            return this;
        }

        @Deprecated
        public WearableExtender setContentIcon(int i) {
            this.mContentIcon = i;
            return this;
        }

        @Deprecated
        public WearableExtender setContentIconGravity(int i) {
            this.mContentIconGravity = i;
            return this;
        }

        public WearableExtender setContentIntentAvailableOffline(boolean z) {
            setFlag(1, z);
            return this;
        }

        @Deprecated
        public WearableExtender setCustomContentHeight(int i) {
            this.mCustomContentHeight = i;
            return this;
        }

        @Deprecated
        public WearableExtender setCustomSizePreset(int i) {
            this.mCustomSizePreset = i;
            return this;
        }

        public WearableExtender setDismissalId(String str) {
            this.mDismissalId = str;
            return this;
        }

        public WearableExtender setDisplayIntent(PendingIntent pendingIntent) {
            this.mDisplayIntent = pendingIntent;
            return this;
        }

        @Deprecated
        public WearableExtender setGravity(int i) {
            this.mGravity = i;
            return this;
        }

        public WearableExtender setHintAmbientBigPicture(boolean z) {
            setFlag(32, z);
            return this;
        }

        @Deprecated
        public WearableExtender setHintAvoidBackgroundClipping(boolean z) {
            setFlag(16, z);
            return this;
        }

        public WearableExtender setHintContentIntentLaunchesActivity(boolean z) {
            setFlag(64, z);
            return this;
        }

        @Deprecated
        public WearableExtender setHintHideIcon(boolean z) {
            setFlag(2, z);
            return this;
        }

        @Deprecated
        public WearableExtender setHintScreenTimeout(int i) {
            this.mHintScreenTimeout = i;
            return this;
        }

        @Deprecated
        public WearableExtender setHintShowBackgroundOnly(boolean z) {
            setFlag(4, z);
            return this;
        }

        public WearableExtender setStartScrollBottom(boolean z) {
            setFlag(8, z);
            return this;
        }
    }

    public static Action getAction(Notification notification, int i) {
        int i2 = VERSION.SDK_INT;
        if (i2 >= 20) {
            return getActionCompatFromAction(notification.actions[i]);
        }
        Bundle bundle = null;
        if (i2 < 19) {
            return i2 >= 16 ? NotificationCompatJellybean.getAction(notification, i) : null;
        } else {
            android.app.Notification.Action action = notification.actions[i];
            SparseArray sparseParcelableArray = notification.extras.getSparseParcelableArray(NotificationCompatExtras.EXTRA_ACTION_EXTRAS);
            if (sparseParcelableArray != null) {
                bundle = (Bundle) sparseParcelableArray.get(i);
            }
            return NotificationCompatJellybean.readAction(action.icon, action.title, action.actionIntent, bundle);
        }
    }

    static Action getActionCompatFromAction(android.app.Notification.Action action) {
        RemoteInput[] remoteInputArr;
        boolean z;
        RemoteInput[] remoteInputs = action.getRemoteInputs();
        if (remoteInputs == null) {
            remoteInputArr = null;
        } else {
            RemoteInput[] remoteInputArr2 = new RemoteInput[remoteInputs.length];
            for (int i = 0; i < remoteInputs.length; i++) {
                RemoteInput remoteInput = remoteInputs[i];
                remoteInputArr2[i] = new RemoteInput(remoteInput.getResultKey(), remoteInput.getLabel(), remoteInput.getChoices(), remoteInput.getAllowFreeFormInput(), remoteInput.getExtras(), null);
            }
            remoteInputArr = remoteInputArr2;
        }
        String str = "android.support.allowGeneratedReplies";
        if (VERSION.SDK_INT >= 24) {
            if (!action.getExtras().getBoolean(str)) {
                if (!action.getAllowGeneratedReplies()) {
                    z = false;
                }
            }
            z = true;
        } else {
            z = action.getExtras().getBoolean(str);
        }
        return new Action(action.icon, action.title, action.actionIntent, action.getExtras(), remoteInputArr, null, z, VERSION.SDK_INT >= 28 ? action.getSemanticAction() : action.getExtras().getInt("android.support.action.semanticAction", 0), action.getExtras().getBoolean("android.support.action.showsUserInterface", true));
    }

    public static int getActionCount(Notification notification) {
        int i = VERSION.SDK_INT;
        int i2 = 0;
        if (i < 19) {
            return i >= 16 ? NotificationCompatJellybean.getActionCount(notification) : 0;
        } else {
            android.app.Notification.Action[] actionArr = notification.actions;
            if (actionArr != null) {
                i2 = actionArr.length;
            }
            return i2;
        }
    }

    public static int getBadgeIconType(Notification notification) {
        return VERSION.SDK_INT >= 26 ? notification.getBadgeIconType() : 0;
    }

    public static String getCategory(Notification notification) {
        return VERSION.SDK_INT >= 21 ? notification.category : null;
    }

    public static String getChannelId(Notification notification) {
        return VERSION.SDK_INT >= 26 ? notification.getChannelId() : null;
    }

    public static CharSequence getContentTitle(Notification notification) {
        return notification.extras.getCharSequence(EXTRA_TITLE);
    }

    public static Bundle getExtras(Notification notification) {
        int i = VERSION.SDK_INT;
        return i >= 19 ? notification.extras : i >= 16 ? NotificationCompatJellybean.getExtras(notification) : null;
    }

    public static String getGroup(Notification notification) {
        int i = VERSION.SDK_INT;
        if (i >= 20) {
            return notification.getGroup();
        }
        Bundle bundle;
        String str = NotificationCompatExtras.EXTRA_GROUP_KEY;
        if (i >= 19) {
            bundle = notification.extras;
        } else if (i < 16) {
            return null;
        } else {
            bundle = NotificationCompatJellybean.getExtras(notification);
        }
        return bundle.getString(str);
    }

    public static int getGroupAlertBehavior(Notification notification) {
        return VERSION.SDK_INT >= 26 ? notification.getGroupAlertBehavior() : 0;
    }

    public static List<Action> getInvisibleActions(Notification notification) {
        List<Action> arrayList = new ArrayList();
        Bundle bundle = notification.extras.getBundle("android.car.EXTENSIONS");
        if (bundle == null) {
            return arrayList;
        }
        bundle = bundle.getBundle("invisible_actions");
        if (bundle != null) {
            for (int i = 0; i < bundle.size(); i++) {
                arrayList.add(NotificationCompatJellybean.getActionFromBundle(bundle.getBundle(Integer.toString(i))));
            }
        }
        return arrayList;
    }

    public static boolean getLocalOnly(Notification notification) {
        int i = VERSION.SDK_INT;
        boolean z = false;
        if (i >= 20) {
            if ((notification.flags & 256) != 0) {
                z = true;
            }
            return z;
        }
        Bundle bundle;
        String str = NotificationCompatExtras.EXTRA_LOCAL_ONLY;
        if (i >= 19) {
            bundle = notification.extras;
        } else if (i < 16) {
            return false;
        } else {
            bundle = NotificationCompatJellybean.getExtras(notification);
        }
        return bundle.getBoolean(str);
    }

    static Notification[] getNotificationArrayFromBundle(Bundle bundle, String str) {
        Parcelable[] parcelableArray = bundle.getParcelableArray(str);
        if (!(parcelableArray instanceof Notification[])) {
            if (parcelableArray != null) {
                Object[] objArr = new Notification[parcelableArray.length];
                for (int i = 0; i < parcelableArray.length; i++) {
                    objArr[i] = (Notification) parcelableArray[i];
                }
                bundle.putParcelableArray(str, objArr);
                return objArr;
            }
        }
        return (Notification[]) parcelableArray;
    }

    public static String getShortcutId(Notification notification) {
        return VERSION.SDK_INT >= 26 ? notification.getShortcutId() : null;
    }

    public static String getSortKey(Notification notification) {
        int i = VERSION.SDK_INT;
        if (i >= 20) {
            return notification.getSortKey();
        }
        Bundle bundle;
        String str = NotificationCompatExtras.EXTRA_SORT_KEY;
        if (i >= 19) {
            bundle = notification.extras;
        } else if (i < 16) {
            return null;
        } else {
            bundle = NotificationCompatJellybean.getExtras(notification);
        }
        return bundle.getString(str);
    }

    public static long getTimeoutAfter(Notification notification) {
        return VERSION.SDK_INT >= 26 ? notification.getTimeoutAfter() : 0;
    }

    public static boolean isGroupSummary(Notification notification) {
        int i = VERSION.SDK_INT;
        boolean z = false;
        if (i >= 20) {
            if ((notification.flags & 512) != 0) {
                z = true;
            }
            return z;
        }
        Bundle bundle;
        String str = NotificationCompatExtras.EXTRA_GROUP_SUMMARY;
        if (i >= 19) {
            bundle = notification.extras;
        } else if (i < 16) {
            return false;
        } else {
            bundle = NotificationCompatJellybean.getExtras(notification);
        }
        return bundle.getBoolean(str);
    }
}
