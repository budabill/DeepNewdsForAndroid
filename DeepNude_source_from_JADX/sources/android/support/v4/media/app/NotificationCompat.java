package android.support.v4.media.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.media.session.MediaSession;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.BundleCompat;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v4.app.NotificationCompat.Action;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.app.NotificationCompat.Style;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.widget.RemoteViews;
import p000a.p005b.p010d.C0045a;
import p000a.p005b.p010d.C0046b;
import p000a.p005b.p010d.C0047c;
import p000a.p005b.p010d.C0048d;

public class NotificationCompat {

    public static class MediaStyle extends Style {
        private static final int MAX_MEDIA_BUTTONS = 5;
        private static final int MAX_MEDIA_BUTTONS_IN_COMPACT = 3;
        int[] mActionsToShowInCompact = null;
        PendingIntent mCancelButtonIntent;
        boolean mShowCancelButton;
        Token mToken;

        public MediaStyle(Builder builder) {
            setBuilder(builder);
        }

        private RemoteViews generateMediaActionButton(Action action) {
            Object obj = action.getActionIntent() == null ? 1 : null;
            RemoteViews remoteViews = new RemoteViews(this.mBuilder.mContext.getPackageName(), C0048d.notification_media_action);
            remoteViews.setImageViewResource(C0046b.action0, action.getIcon());
            if (obj == null) {
                remoteViews.setOnClickPendingIntent(C0046b.action0, action.getActionIntent());
            }
            if (VERSION.SDK_INT >= 15) {
                remoteViews.setContentDescription(C0046b.action0, action.getTitle());
            }
            return remoteViews;
        }

        public static Token getMediaSession(Notification notification) {
            Bundle extras = android.support.v4.app.NotificationCompat.getExtras(notification);
            if (extras != null) {
                int i = VERSION.SDK_INT;
                String str = android.support.v4.app.NotificationCompat.EXTRA_MEDIA_SESSION;
                if (i >= 21) {
                    Parcelable parcelable = extras.getParcelable(str);
                    if (parcelable != null) {
                        return Token.fromToken(parcelable);
                    }
                }
                IBinder binder = BundleCompat.getBinder(extras, str);
                if (binder != null) {
                    Parcel obtain = Parcel.obtain();
                    obtain.writeStrongBinder(binder);
                    obtain.setDataPosition(0);
                    Token token = (Token) Token.CREATOR.createFromParcel(obtain);
                    obtain.recycle();
                    return token;
                }
            }
            return null;
        }

        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (VERSION.SDK_INT >= 21) {
                notificationBuilderWithBuilderAccessor.getBuilder().setStyle(fillInMediaStyle(new android.app.Notification.MediaStyle()));
            } else if (this.mShowCancelButton) {
                notificationBuilderWithBuilderAccessor.getBuilder().setOngoing(true);
            }
        }

        android.app.Notification.MediaStyle fillInMediaStyle(android.app.Notification.MediaStyle mediaStyle) {
            int[] iArr = this.mActionsToShowInCompact;
            if (iArr != null) {
                mediaStyle.setShowActionsInCompactView(iArr);
            }
            Token token = this.mToken;
            if (token != null) {
                mediaStyle.setMediaSession((MediaSession.Token) token.getToken());
            }
            return mediaStyle;
        }

        RemoteViews generateBigContentView() {
            int min = Math.min(this.mBuilder.mActions.size(), 5);
            RemoteViews applyStandardTemplate = applyStandardTemplate(false, getBigContentViewLayoutResource(min), false);
            applyStandardTemplate.removeAllViews(C0046b.media_actions);
            if (min > 0) {
                for (int i = 0; i < min; i++) {
                    applyStandardTemplate.addView(C0046b.media_actions, generateMediaActionButton((Action) this.mBuilder.mActions.get(i)));
                }
            }
            if (this.mShowCancelButton) {
                applyStandardTemplate.setViewVisibility(C0046b.cancel_action, 0);
                applyStandardTemplate.setInt(C0046b.cancel_action, "setAlpha", this.mBuilder.mContext.getResources().getInteger(C0047c.cancel_button_image_alpha));
                applyStandardTemplate.setOnClickPendingIntent(C0046b.cancel_action, this.mCancelButtonIntent);
            } else {
                applyStandardTemplate.setViewVisibility(C0046b.cancel_action, 8);
            }
            return applyStandardTemplate;
        }

        RemoteViews generateContentView() {
            RemoteViews applyStandardTemplate = applyStandardTemplate(false, getContentViewLayoutResource(), true);
            int size = this.mBuilder.mActions.size();
            int[] iArr = this.mActionsToShowInCompact;
            int min = iArr == null ? 0 : Math.min(iArr.length, 3);
            applyStandardTemplate.removeAllViews(C0046b.media_actions);
            if (min > 0) {
                int i = 0;
                while (i < min) {
                    if (i < size) {
                        applyStandardTemplate.addView(C0046b.media_actions, generateMediaActionButton((Action) this.mBuilder.mActions.get(this.mActionsToShowInCompact[i])));
                        i++;
                    } else {
                        throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", new Object[]{Integer.valueOf(i), Integer.valueOf(size - 1)}));
                    }
                }
            }
            if (this.mShowCancelButton) {
                applyStandardTemplate.setViewVisibility(C0046b.end_padder, 8);
                applyStandardTemplate.setViewVisibility(C0046b.cancel_action, 0);
                applyStandardTemplate.setOnClickPendingIntent(C0046b.cancel_action, this.mCancelButtonIntent);
                applyStandardTemplate.setInt(C0046b.cancel_action, "setAlpha", this.mBuilder.mContext.getResources().getInteger(C0047c.cancel_button_image_alpha));
            } else {
                applyStandardTemplate.setViewVisibility(C0046b.end_padder, 0);
                applyStandardTemplate.setViewVisibility(C0046b.cancel_action, 8);
            }
            return applyStandardTemplate;
        }

        int getBigContentViewLayoutResource(int i) {
            return i <= 3 ? C0048d.notification_template_big_media_narrow : C0048d.notification_template_big_media;
        }

        int getContentViewLayoutResource() {
            return C0048d.notification_template_media;
        }

        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return VERSION.SDK_INT >= 21 ? null : generateBigContentView();
        }

        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return VERSION.SDK_INT >= 21 ? null : generateContentView();
        }

        public MediaStyle setCancelButtonIntent(PendingIntent pendingIntent) {
            this.mCancelButtonIntent = pendingIntent;
            return this;
        }

        public MediaStyle setMediaSession(Token token) {
            this.mToken = token;
            return this;
        }

        public MediaStyle setShowActionsInCompactView(int... iArr) {
            this.mActionsToShowInCompact = iArr;
            return this;
        }

        public MediaStyle setShowCancelButton(boolean z) {
            if (VERSION.SDK_INT < 21) {
                this.mShowCancelButton = z;
            }
            return this;
        }
    }

    public static class DecoratedMediaCustomViewStyle extends MediaStyle {
        private void setBackgroundColor(RemoteViews remoteViews) {
            remoteViews.setInt(C0046b.status_bar_latest_event_content, "setBackgroundColor", this.mBuilder.getColor() != 0 ? this.mBuilder.getColor() : this.mBuilder.mContext.getResources().getColor(C0045a.notification_material_background_media_default_color));
        }

        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (VERSION.SDK_INT >= 24) {
                notificationBuilderWithBuilderAccessor.getBuilder().setStyle(fillInMediaStyle(new android.app.Notification.DecoratedMediaCustomViewStyle()));
            } else {
                super.apply(notificationBuilderWithBuilderAccessor);
            }
        }

        int getBigContentViewLayoutResource(int i) {
            return i <= 3 ? C0048d.notification_template_big_media_narrow_custom : C0048d.notification_template_big_media_custom;
        }

        int getContentViewLayoutResource() {
            return this.mBuilder.getContentView() != null ? C0048d.notification_template_media_custom : super.getContentViewLayoutResource();
        }

        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (VERSION.SDK_INT >= 24) {
                return null;
            }
            RemoteViews bigContentView = this.mBuilder.getBigContentView() != null ? this.mBuilder.getBigContentView() : this.mBuilder.getContentView();
            if (bigContentView == null) {
                return null;
            }
            RemoteViews generateBigContentView = generateBigContentView();
            buildIntoRemoteViews(generateBigContentView, bigContentView);
            if (VERSION.SDK_INT >= 21) {
                setBackgroundColor(generateBigContentView);
            }
            return generateBigContentView;
        }

        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (VERSION.SDK_INT >= 24) {
                return null;
            }
            Object obj = 1;
            Object obj2 = this.mBuilder.getContentView() != null ? 1 : null;
            if (VERSION.SDK_INT >= 21) {
                if (obj2 == null) {
                    if (this.mBuilder.getBigContentView() == null) {
                        obj = null;
                    }
                }
                if (obj != null) {
                    RemoteViews generateContentView = generateContentView();
                    if (obj2 != null) {
                        buildIntoRemoteViews(generateContentView, this.mBuilder.getContentView());
                    }
                    setBackgroundColor(generateContentView);
                    return generateContentView;
                }
            }
            RemoteViews generateContentView2 = generateContentView();
            if (obj2 != null) {
                buildIntoRemoteViews(generateContentView2, this.mBuilder.getContentView());
                return generateContentView2;
            }
            return null;
        }

        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (VERSION.SDK_INT >= 24) {
                return null;
            }
            RemoteViews headsUpContentView = this.mBuilder.getHeadsUpContentView() != null ? this.mBuilder.getHeadsUpContentView() : this.mBuilder.getContentView();
            if (headsUpContentView == null) {
                return null;
            }
            RemoteViews generateBigContentView = generateBigContentView();
            buildIntoRemoteViews(generateBigContentView, headsUpContentView);
            if (VERSION.SDK_INT >= 21) {
                setBackgroundColor(generateBigContentView);
            }
            return generateBigContentView;
        }
    }

    private NotificationCompat() {
    }
}
