package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.Rating;
import android.media.RemoteControlClient;
import android.media.RemoteControlClient.MetadataEditor;
import android.media.RemoteControlClient.OnMetadataUpdateListener;
import android.media.RemoteControlClient.OnPlaybackPositionUpdateListener;
import android.media.session.MediaSession;
import android.net.Uri;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteCallbackList;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.app.BundleCompat;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.MediaMetadataCompat.Builder;
import android.support.v4.media.MediaSessionManager.RemoteUserInfo;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.VolumeProviderCompat;
import android.support.v4.media.session.IMediaSession.Stub;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MediaSessionCompat {
    public static final String ACTION_ARGUMENT_CAPTIONING_ENABLED = "android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED";
    public static final String ACTION_ARGUMENT_EXTRAS = "android.support.v4.media.session.action.ARGUMENT_EXTRAS";
    public static final String ACTION_ARGUMENT_MEDIA_ID = "android.support.v4.media.session.action.ARGUMENT_MEDIA_ID";
    public static final String ACTION_ARGUMENT_QUERY = "android.support.v4.media.session.action.ARGUMENT_QUERY";
    public static final String ACTION_ARGUMENT_RATING = "android.support.v4.media.session.action.ARGUMENT_RATING";
    public static final String ACTION_ARGUMENT_REPEAT_MODE = "android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE";
    public static final String ACTION_ARGUMENT_SHUFFLE_MODE = "android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE";
    public static final String ACTION_ARGUMENT_URI = "android.support.v4.media.session.action.ARGUMENT_URI";
    public static final String ACTION_FLAG_AS_INAPPROPRIATE = "android.support.v4.media.session.action.FLAG_AS_INAPPROPRIATE";
    public static final String ACTION_FOLLOW = "android.support.v4.media.session.action.FOLLOW";
    public static final String ACTION_PLAY_FROM_URI = "android.support.v4.media.session.action.PLAY_FROM_URI";
    public static final String ACTION_PREPARE = "android.support.v4.media.session.action.PREPARE";
    public static final String ACTION_PREPARE_FROM_MEDIA_ID = "android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID";
    public static final String ACTION_PREPARE_FROM_SEARCH = "android.support.v4.media.session.action.PREPARE_FROM_SEARCH";
    public static final String ACTION_PREPARE_FROM_URI = "android.support.v4.media.session.action.PREPARE_FROM_URI";
    public static final String ACTION_SET_CAPTIONING_ENABLED = "android.support.v4.media.session.action.SET_CAPTIONING_ENABLED";
    public static final String ACTION_SET_RATING = "android.support.v4.media.session.action.SET_RATING";
    public static final String ACTION_SET_REPEAT_MODE = "android.support.v4.media.session.action.SET_REPEAT_MODE";
    public static final String ACTION_SET_SHUFFLE_MODE = "android.support.v4.media.session.action.SET_SHUFFLE_MODE";
    public static final String ACTION_SKIP_AD = "android.support.v4.media.session.action.SKIP_AD";
    public static final String ACTION_UNFOLLOW = "android.support.v4.media.session.action.UNFOLLOW";
    public static final String ARGUMENT_MEDIA_ATTRIBUTE = "android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE";
    public static final String ARGUMENT_MEDIA_ATTRIBUTE_VALUE = "android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE_VALUE";
    private static final String DATA_CALLING_PACKAGE = "data_calling_pkg";
    private static final String DATA_CALLING_PID = "data_calling_pid";
    private static final String DATA_CALLING_UID = "data_calling_uid";
    private static final String DATA_EXTRAS = "data_extras";
    public static final int FLAG_HANDLES_MEDIA_BUTTONS = 1;
    public static final int FLAG_HANDLES_QUEUE_COMMANDS = 4;
    public static final int FLAG_HANDLES_TRANSPORT_CONTROLS = 2;
    public static final String KEY_EXTRA_BINDER = "android.support.v4.media.session.EXTRA_BINDER";
    public static final String KEY_SESSION_TOKEN2_BUNDLE = "android.support.v4.media.session.SESSION_TOKEN2_BUNDLE";
    public static final String KEY_TOKEN = "android.support.v4.media.session.TOKEN";
    private static final int MAX_BITMAP_SIZE_IN_DP = 320;
    public static final int MEDIA_ATTRIBUTE_ALBUM = 1;
    public static final int MEDIA_ATTRIBUTE_ARTIST = 0;
    public static final int MEDIA_ATTRIBUTE_PLAYLIST = 2;
    static final String TAG = "MediaSessionCompat";
    static int sMaxBitmapSize;
    private final ArrayList<OnActiveChangeListener> mActiveListeners;
    private final MediaControllerCompat mController;
    private final MediaSessionImpl mImpl;

    public static abstract class Callback {
        private CallbackHandler mCallbackHandler = null;
        final Object mCallbackObj;
        private boolean mMediaPlayPauseKeyPending;
        WeakReference<MediaSessionImpl> mSessionImpl;

        private class CallbackHandler extends Handler {
            private static final int MSG_MEDIA_PLAY_PAUSE_KEY_DOUBLE_TAP_TIMEOUT = 1;

            CallbackHandler(Looper looper) {
                super(looper);
            }

            public void handleMessage(Message message) {
                if (message.what == 1) {
                    Callback.this.handleMediaPlayPauseKeySingleTapIfPending((RemoteUserInfo) message.obj);
                }
            }
        }

        private class StubApi21 implements Callback {
            StubApi21() {
            }

            public void onCommand(java.lang.String r5, android.os.Bundle r6, android.os.ResultReceiver r7) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
                /*
                r4 = this;
                r0 = "android.support.v4.media.session.command.GET_EXTRA_BINDER";	 Catch:{ BadParcelableException -> 0x00c1 }
                r0 = r5.equals(r0);	 Catch:{ BadParcelableException -> 0x00c1 }
                r1 = 0;	 Catch:{ BadParcelableException -> 0x00c1 }
                if (r0 == 0) goto L_0x003d;	 Catch:{ BadParcelableException -> 0x00c1 }
            L_0x0009:
                r5 = android.support.v4.media.session.MediaSessionCompat.Callback.this;	 Catch:{ BadParcelableException -> 0x00c1 }
                r5 = r5.mSessionImpl;	 Catch:{ BadParcelableException -> 0x00c1 }
                r5 = r5.get();	 Catch:{ BadParcelableException -> 0x00c1 }
                r5 = (android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21) r5;	 Catch:{ BadParcelableException -> 0x00c1 }
                if (r5 == 0) goto L_0x00c8;	 Catch:{ BadParcelableException -> 0x00c1 }
            L_0x0015:
                r6 = new android.os.Bundle;	 Catch:{ BadParcelableException -> 0x00c1 }
                r6.<init>();	 Catch:{ BadParcelableException -> 0x00c1 }
                r5 = r5.getSessionToken();	 Catch:{ BadParcelableException -> 0x00c1 }
                r0 = r5.getExtraBinder();	 Catch:{ BadParcelableException -> 0x00c1 }
                r2 = "android.support.v4.media.session.EXTRA_BINDER";	 Catch:{ BadParcelableException -> 0x00c1 }
                if (r0 != 0) goto L_0x0027;	 Catch:{ BadParcelableException -> 0x00c1 }
            L_0x0026:
                goto L_0x002b;	 Catch:{ BadParcelableException -> 0x00c1 }
            L_0x0027:
                r1 = r0.asBinder();	 Catch:{ BadParcelableException -> 0x00c1 }
            L_0x002b:
                android.support.v4.app.BundleCompat.putBinder(r6, r2, r1);	 Catch:{ BadParcelableException -> 0x00c1 }
                r5 = r5.getSessionToken2Bundle();	 Catch:{ BadParcelableException -> 0x00c1 }
                r0 = "android.support.v4.media.session.SESSION_TOKEN2_BUNDLE";	 Catch:{ BadParcelableException -> 0x00c1 }
                r6.putBundle(r0, r5);	 Catch:{ BadParcelableException -> 0x00c1 }
                r5 = 0;	 Catch:{ BadParcelableException -> 0x00c1 }
                r7.send(r5, r6);	 Catch:{ BadParcelableException -> 0x00c1 }
                goto L_0x00c8;	 Catch:{ BadParcelableException -> 0x00c1 }
            L_0x003d:
                r0 = "android.support.v4.media.session.command.ADD_QUEUE_ITEM";	 Catch:{ BadParcelableException -> 0x00c1 }
                r0 = r5.equals(r0);	 Catch:{ BadParcelableException -> 0x00c1 }
                r2 = "android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION";
                if (r0 == 0) goto L_0x0054;
            L_0x0047:
                r5 = android.support.v4.media.session.MediaSessionCompat.Callback.this;	 Catch:{ BadParcelableException -> 0x00c1 }
                r6 = r6.getParcelable(r2);	 Catch:{ BadParcelableException -> 0x00c1 }
                r6 = (android.support.v4.media.MediaDescriptionCompat) r6;	 Catch:{ BadParcelableException -> 0x00c1 }
                r5.onAddQueueItem(r6);	 Catch:{ BadParcelableException -> 0x00c1 }
                goto L_0x00c8;	 Catch:{ BadParcelableException -> 0x00c1 }
            L_0x0054:
                r0 = "android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT";	 Catch:{ BadParcelableException -> 0x00c1 }
                r0 = r5.equals(r0);	 Catch:{ BadParcelableException -> 0x00c1 }
                r3 = "android.support.v4.media.session.command.ARGUMENT_INDEX";
                if (r0 == 0) goto L_0x006e;
            L_0x005e:
                r5 = android.support.v4.media.session.MediaSessionCompat.Callback.this;	 Catch:{ BadParcelableException -> 0x00c1 }
                r7 = r6.getParcelable(r2);	 Catch:{ BadParcelableException -> 0x00c1 }
                r7 = (android.support.v4.media.MediaDescriptionCompat) r7;	 Catch:{ BadParcelableException -> 0x00c1 }
                r6 = r6.getInt(r3);	 Catch:{ BadParcelableException -> 0x00c1 }
                r5.onAddQueueItem(r7, r6);	 Catch:{ BadParcelableException -> 0x00c1 }
                goto L_0x00c8;	 Catch:{ BadParcelableException -> 0x00c1 }
            L_0x006e:
                r0 = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM";	 Catch:{ BadParcelableException -> 0x00c1 }
                r0 = r5.equals(r0);	 Catch:{ BadParcelableException -> 0x00c1 }
                if (r0 == 0) goto L_0x0082;	 Catch:{ BadParcelableException -> 0x00c1 }
            L_0x0076:
                r5 = android.support.v4.media.session.MediaSessionCompat.Callback.this;	 Catch:{ BadParcelableException -> 0x00c1 }
                r6 = r6.getParcelable(r2);	 Catch:{ BadParcelableException -> 0x00c1 }
                r6 = (android.support.v4.media.MediaDescriptionCompat) r6;	 Catch:{ BadParcelableException -> 0x00c1 }
            L_0x007e:
                r5.onRemoveQueueItem(r6);	 Catch:{ BadParcelableException -> 0x00c1 }
                goto L_0x00c8;	 Catch:{ BadParcelableException -> 0x00c1 }
            L_0x0082:
                r0 = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT";	 Catch:{ BadParcelableException -> 0x00c1 }
                r0 = r5.equals(r0);	 Catch:{ BadParcelableException -> 0x00c1 }
                if (r0 == 0) goto L_0x00bb;	 Catch:{ BadParcelableException -> 0x00c1 }
            L_0x008a:
                r5 = android.support.v4.media.session.MediaSessionCompat.Callback.this;	 Catch:{ BadParcelableException -> 0x00c1 }
                r5 = r5.mSessionImpl;	 Catch:{ BadParcelableException -> 0x00c1 }
                r5 = r5.get();	 Catch:{ BadParcelableException -> 0x00c1 }
                r5 = (android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21) r5;	 Catch:{ BadParcelableException -> 0x00c1 }
                if (r5 == 0) goto L_0x00c8;	 Catch:{ BadParcelableException -> 0x00c1 }
            L_0x0096:
                r7 = r5.mQueue;	 Catch:{ BadParcelableException -> 0x00c1 }
                if (r7 == 0) goto L_0x00c8;	 Catch:{ BadParcelableException -> 0x00c1 }
            L_0x009a:
                r7 = -1;	 Catch:{ BadParcelableException -> 0x00c1 }
                r6 = r6.getInt(r3, r7);	 Catch:{ BadParcelableException -> 0x00c1 }
                if (r6 < 0) goto L_0x00b2;	 Catch:{ BadParcelableException -> 0x00c1 }
            L_0x00a1:
                r7 = r5.mQueue;	 Catch:{ BadParcelableException -> 0x00c1 }
                r7 = r7.size();	 Catch:{ BadParcelableException -> 0x00c1 }
                if (r6 >= r7) goto L_0x00b2;	 Catch:{ BadParcelableException -> 0x00c1 }
            L_0x00a9:
                r5 = r5.mQueue;	 Catch:{ BadParcelableException -> 0x00c1 }
                r5 = r5.get(r6);	 Catch:{ BadParcelableException -> 0x00c1 }
                r1 = r5;	 Catch:{ BadParcelableException -> 0x00c1 }
                r1 = (android.support.v4.media.session.MediaSessionCompat.QueueItem) r1;	 Catch:{ BadParcelableException -> 0x00c1 }
            L_0x00b2:
                if (r1 == 0) goto L_0x00c8;	 Catch:{ BadParcelableException -> 0x00c1 }
            L_0x00b4:
                r5 = android.support.v4.media.session.MediaSessionCompat.Callback.this;	 Catch:{ BadParcelableException -> 0x00c1 }
                r6 = r1.getDescription();	 Catch:{ BadParcelableException -> 0x00c1 }
                goto L_0x007e;	 Catch:{ BadParcelableException -> 0x00c1 }
            L_0x00bb:
                r0 = android.support.v4.media.session.MediaSessionCompat.Callback.this;	 Catch:{ BadParcelableException -> 0x00c1 }
                r0.onCommand(r5, r6, r7);	 Catch:{ BadParcelableException -> 0x00c1 }
                goto L_0x00c8;
            L_0x00c1:
                r5 = "MediaSessionCompat";
                r6 = "Could not unparcel the extra data.";
                android.util.Log.e(r5, r6);
            L_0x00c8:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.Callback.StubApi21.onCommand(java.lang.String, android.os.Bundle, android.os.ResultReceiver):void");
            }

            public void onCustomAction(String str, Bundle bundle) {
                Bundle bundle2 = bundle.getBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS);
                MediaSessionCompat.ensureClassLoader(bundle2);
                boolean equals = str.equals(MediaSessionCompat.ACTION_PLAY_FROM_URI);
                String str2 = MediaSessionCompat.ACTION_ARGUMENT_URI;
                if (equals) {
                    Callback.this.onPlayFromUri((Uri) bundle.getParcelable(str2), bundle2);
                } else if (str.equals(MediaSessionCompat.ACTION_PREPARE)) {
                    Callback.this.onPrepare();
                } else if (str.equals(MediaSessionCompat.ACTION_PREPARE_FROM_MEDIA_ID)) {
                    Callback.this.onPrepareFromMediaId(bundle.getString(MediaSessionCompat.ACTION_ARGUMENT_MEDIA_ID), bundle2);
                } else if (str.equals(MediaSessionCompat.ACTION_PREPARE_FROM_SEARCH)) {
                    Callback.this.onPrepareFromSearch(bundle.getString(MediaSessionCompat.ACTION_ARGUMENT_QUERY), bundle2);
                } else if (str.equals(MediaSessionCompat.ACTION_PREPARE_FROM_URI)) {
                    Callback.this.onPrepareFromUri((Uri) bundle.getParcelable(str2), bundle2);
                } else if (str.equals(MediaSessionCompat.ACTION_SET_CAPTIONING_ENABLED)) {
                    Callback.this.onSetCaptioningEnabled(bundle.getBoolean(MediaSessionCompat.ACTION_ARGUMENT_CAPTIONING_ENABLED));
                } else if (str.equals(MediaSessionCompat.ACTION_SET_REPEAT_MODE)) {
                    Callback.this.onSetRepeatMode(bundle.getInt(MediaSessionCompat.ACTION_ARGUMENT_REPEAT_MODE));
                } else if (str.equals(MediaSessionCompat.ACTION_SET_SHUFFLE_MODE)) {
                    Callback.this.onSetShuffleMode(bundle.getInt(MediaSessionCompat.ACTION_ARGUMENT_SHUFFLE_MODE));
                } else if (str.equals(MediaSessionCompat.ACTION_SET_RATING)) {
                    Callback.this.onSetRating((RatingCompat) bundle.getParcelable(MediaSessionCompat.ACTION_ARGUMENT_RATING), bundle2);
                } else {
                    Callback.this.onCustomAction(str, bundle);
                }
            }

            public void onFastForward() {
                Callback.this.onFastForward();
            }

            public boolean onMediaButtonEvent(Intent intent) {
                return Callback.this.onMediaButtonEvent(intent);
            }

            public void onPause() {
                Callback.this.onPause();
            }

            public void onPlay() {
                Callback.this.onPlay();
            }

            public void onPlayFromMediaId(String str, Bundle bundle) {
                Callback.this.onPlayFromMediaId(str, bundle);
            }

            public void onPlayFromSearch(String str, Bundle bundle) {
                Callback.this.onPlayFromSearch(str, bundle);
            }

            public void onRewind() {
                Callback.this.onRewind();
            }

            public void onSeekTo(long j) {
                Callback.this.onSeekTo(j);
            }

            public void onSetRating(Object obj) {
                Callback.this.onSetRating(RatingCompat.fromRating(obj));
            }

            public void onSetRating(Object obj, Bundle bundle) {
            }

            public void onSkipToNext() {
                Callback.this.onSkipToNext();
            }

            public void onSkipToPrevious() {
                Callback.this.onSkipToPrevious();
            }

            public void onSkipToQueueItem(long j) {
                Callback.this.onSkipToQueueItem(j);
            }

            public void onStop() {
                Callback.this.onStop();
            }
        }

        private class StubApi23 extends StubApi21 implements android.support.v4.media.session.MediaSessionCompatApi23.Callback {
            StubApi23() {
                super();
            }

            public void onPlayFromUri(Uri uri, Bundle bundle) {
                Callback.this.onPlayFromUri(uri, bundle);
            }
        }

        private class StubApi24 extends StubApi23 implements android.support.v4.media.session.MediaSessionCompatApi24.Callback {
            StubApi24() {
                super();
            }

            public void onPrepare() {
                Callback.this.onPrepare();
            }

            public void onPrepareFromMediaId(String str, Bundle bundle) {
                Callback.this.onPrepareFromMediaId(str, bundle);
            }

            public void onPrepareFromSearch(String str, Bundle bundle) {
                Callback.this.onPrepareFromSearch(str, bundle);
            }

            public void onPrepareFromUri(Uri uri, Bundle bundle) {
                Callback.this.onPrepareFromUri(uri, bundle);
            }
        }

        public Callback() {
            Object obj = null;
            int i = VERSION.SDK_INT;
            if (i >= 24) {
                obj = MediaSessionCompatApi24.createCallback(new StubApi24());
            } else if (i >= 23) {
                obj = MediaSessionCompatApi23.createCallback(new StubApi23());
            } else if (i >= 21) {
                obj = MediaSessionCompatApi21.createCallback(new StubApi21());
            }
            this.mCallbackObj = obj;
        }

        void handleMediaPlayPauseKeySingleTapIfPending(RemoteUserInfo remoteUserInfo) {
            if (this.mMediaPlayPauseKeyPending) {
                boolean z = false;
                this.mMediaPlayPauseKeyPending = false;
                this.mCallbackHandler.removeMessages(1);
                MediaSessionImpl mediaSessionImpl = (MediaSessionImpl) this.mSessionImpl.get();
                if (mediaSessionImpl != null) {
                    PlaybackStateCompat playbackState = mediaSessionImpl.getPlaybackState();
                    long actions = playbackState == null ? 0 : playbackState.getActions();
                    Object obj = (playbackState == null || playbackState.getState() != 3) ? null : 1;
                    Object obj2 = (516 & actions) != 0 ? 1 : null;
                    if ((actions & 514) != 0) {
                        z = true;
                    }
                    mediaSessionImpl.setCurrentControllerInfo(remoteUserInfo);
                    if (obj != null && r0) {
                        onPause();
                    } else if (obj == null && obj2 != null) {
                        onPlay();
                    }
                    mediaSessionImpl.setCurrentControllerInfo(null);
                }
            }
        }

        public void onAddQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        }

        public void onAddQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int i) {
        }

        public void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
        }

        public void onCustomAction(String str, Bundle bundle) {
        }

        public void onFastForward() {
        }

        public boolean onMediaButtonEvent(Intent intent) {
            if (VERSION.SDK_INT >= 27) {
                return false;
            }
            MediaSessionImpl mediaSessionImpl = (MediaSessionImpl) this.mSessionImpl.get();
            if (mediaSessionImpl != null) {
                if (this.mCallbackHandler != null) {
                    KeyEvent keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
                    if (keyEvent != null) {
                        if (keyEvent.getAction() == 0) {
                            RemoteUserInfo currentControllerInfo = mediaSessionImpl.getCurrentControllerInfo();
                            int keyCode = keyEvent.getKeyCode();
                            if (keyCode == 79 || keyCode == 85) {
                                if (keyEvent.getRepeatCount() > 0) {
                                    handleMediaPlayPauseKeySingleTapIfPending(currentControllerInfo);
                                } else if (this.mMediaPlayPauseKeyPending) {
                                    this.mCallbackHandler.removeMessages(1);
                                    this.mMediaPlayPauseKeyPending = false;
                                    PlaybackStateCompat playbackState = mediaSessionImpl.getPlaybackState();
                                    if (((playbackState == null ? 0 : playbackState.getActions()) & 32) != 0) {
                                        onSkipToNext();
                                    }
                                } else {
                                    this.mMediaPlayPauseKeyPending = true;
                                    Handler handler = this.mCallbackHandler;
                                    handler.sendMessageDelayed(handler.obtainMessage(1, currentControllerInfo), (long) ViewConfiguration.getDoubleTapTimeout());
                                }
                                return true;
                            }
                            handleMediaPlayPauseKeySingleTapIfPending(currentControllerInfo);
                            return false;
                        }
                    }
                }
            }
            return false;
        }

        public void onPause() {
        }

        public void onPlay() {
        }

        public void onPlayFromMediaId(String str, Bundle bundle) {
        }

        public void onPlayFromSearch(String str, Bundle bundle) {
        }

        public void onPlayFromUri(Uri uri, Bundle bundle) {
        }

        public void onPrepare() {
        }

        public void onPrepareFromMediaId(String str, Bundle bundle) {
        }

        public void onPrepareFromSearch(String str, Bundle bundle) {
        }

        public void onPrepareFromUri(Uri uri, Bundle bundle) {
        }

        public void onRemoveQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        }

        @Deprecated
        public void onRemoveQueueItemAt(int i) {
        }

        public void onRewind() {
        }

        public void onSeekTo(long j) {
        }

        public void onSetCaptioningEnabled(boolean z) {
        }

        public void onSetRating(RatingCompat ratingCompat) {
        }

        public void onSetRating(RatingCompat ratingCompat, Bundle bundle) {
        }

        public void onSetRepeatMode(int i) {
        }

        public void onSetShuffleMode(int i) {
        }

        public void onSkipToNext() {
        }

        public void onSkipToPrevious() {
        }

        public void onSkipToQueueItem(long j) {
        }

        public void onStop() {
        }

        void setSessionImpl(MediaSessionImpl mediaSessionImpl, Handler handler) {
            this.mSessionImpl = new WeakReference(mediaSessionImpl);
            Handler handler2 = this.mCallbackHandler;
            if (handler2 != null) {
                handler2.removeCallbacksAndMessages(null);
            }
            this.mCallbackHandler = new CallbackHandler(handler.getLooper());
        }
    }

    interface MediaSessionImpl {
        String getCallingPackage();

        RemoteUserInfo getCurrentControllerInfo();

        Object getMediaSession();

        PlaybackStateCompat getPlaybackState();

        Object getRemoteControlClient();

        Token getSessionToken();

        boolean isActive();

        void release();

        void sendSessionEvent(String str, Bundle bundle);

        void setActive(boolean z);

        void setCallback(Callback callback, Handler handler);

        void setCaptioningEnabled(boolean z);

        void setCurrentControllerInfo(RemoteUserInfo remoteUserInfo);

        void setExtras(Bundle bundle);

        void setFlags(int i);

        void setMediaButtonReceiver(PendingIntent pendingIntent);

        void setMetadata(MediaMetadataCompat mediaMetadataCompat);

        void setPlaybackState(PlaybackStateCompat playbackStateCompat);

        void setPlaybackToLocal(int i);

        void setPlaybackToRemote(VolumeProviderCompat volumeProviderCompat);

        void setQueue(List<QueueItem> list);

        void setQueueTitle(CharSequence charSequence);

        void setRatingType(int i);

        void setRepeatMode(int i);

        void setSessionActivity(PendingIntent pendingIntent);

        void setShuffleMode(int i);
    }

    public interface OnActiveChangeListener {
        void onActiveChanged();
    }

    public static final class QueueItem implements Parcelable {
        public static final Creator<QueueItem> CREATOR = new C01491();
        public static final int UNKNOWN_ID = -1;
        private final MediaDescriptionCompat mDescription;
        private final long mId;
        private Object mItem;

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$QueueItem$1 */
        static class C01491 implements Creator<QueueItem> {
            C01491() {
            }

            public QueueItem createFromParcel(Parcel parcel) {
                return new QueueItem(parcel);
            }

            public QueueItem[] newArray(int i) {
                return new QueueItem[i];
            }
        }

        QueueItem(Parcel parcel) {
            this.mDescription = (MediaDescriptionCompat) MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.mId = parcel.readLong();
        }

        public QueueItem(MediaDescriptionCompat mediaDescriptionCompat, long j) {
            this(null, mediaDescriptionCompat, j);
        }

        private QueueItem(Object obj, MediaDescriptionCompat mediaDescriptionCompat, long j) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("Description cannot be null.");
            } else if (j != -1) {
                this.mDescription = mediaDescriptionCompat;
                this.mId = j;
                this.mItem = obj;
            } else {
                throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
            }
        }

        public static QueueItem fromQueueItem(Object obj) {
            if (obj != null) {
                if (VERSION.SDK_INT >= 21) {
                    return new QueueItem(obj, MediaDescriptionCompat.fromMediaDescription(QueueItem.getDescription(obj)), QueueItem.getQueueId(obj));
                }
            }
            return null;
        }

        public static List<QueueItem> fromQueueItemList(List<?> list) {
            if (list != null) {
                if (VERSION.SDK_INT >= 21) {
                    List<QueueItem> arrayList = new ArrayList();
                    for (Object fromQueueItem : list) {
                        arrayList.add(fromQueueItem(fromQueueItem));
                    }
                    return arrayList;
                }
            }
            return null;
        }

        public int describeContents() {
            return 0;
        }

        public MediaDescriptionCompat getDescription() {
            return this.mDescription;
        }

        public long getQueueId() {
            return this.mId;
        }

        public Object getQueueItem() {
            if (this.mItem == null) {
                if (VERSION.SDK_INT >= 21) {
                    this.mItem = QueueItem.createItem(this.mDescription.getMediaDescription(), this.mId);
                    return this.mItem;
                }
            }
            return this.mItem;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("MediaSession.QueueItem {Description=");
            stringBuilder.append(this.mDescription);
            stringBuilder.append(", Id=");
            stringBuilder.append(this.mId);
            stringBuilder.append(" }");
            return stringBuilder.toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            this.mDescription.writeToParcel(parcel, i);
            parcel.writeLong(this.mId);
        }
    }

    public static final class ResultReceiverWrapper implements Parcelable {
        public static final Creator<ResultReceiverWrapper> CREATOR = new C01501();
        ResultReceiver mResultReceiver;

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper$1 */
        static class C01501 implements Creator<ResultReceiverWrapper> {
            C01501() {
            }

            public ResultReceiverWrapper createFromParcel(Parcel parcel) {
                return new ResultReceiverWrapper(parcel);
            }

            public ResultReceiverWrapper[] newArray(int i) {
                return new ResultReceiverWrapper[i];
            }
        }

        ResultReceiverWrapper(Parcel parcel) {
            this.mResultReceiver = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        public ResultReceiverWrapper(ResultReceiver resultReceiver) {
            this.mResultReceiver = resultReceiver;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            this.mResultReceiver.writeToParcel(parcel, i);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SessionFlags {
    }

    public static final class Token implements Parcelable {
        public static final Creator<Token> CREATOR = new C01511();
        private IMediaSession mExtraBinder;
        private final Object mInner;
        private Bundle mSessionToken2Bundle;

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$Token$1 */
        static class C01511 implements Creator<Token> {
            C01511() {
            }

            public Token createFromParcel(Parcel parcel) {
                return new Token(VERSION.SDK_INT >= 21 ? parcel.readParcelable(null) : parcel.readStrongBinder());
            }

            public Token[] newArray(int i) {
                return new Token[i];
            }
        }

        Token(Object obj) {
            this(obj, null, null);
        }

        Token(Object obj, IMediaSession iMediaSession) {
            this(obj, iMediaSession, null);
        }

        Token(Object obj, IMediaSession iMediaSession, Bundle bundle) {
            this.mInner = obj;
            this.mExtraBinder = iMediaSession;
            this.mSessionToken2Bundle = bundle;
        }

        public static Token fromBundle(Bundle bundle) {
            Token token = null;
            if (bundle == null) {
                return null;
            }
            IMediaSession asInterface = Stub.asInterface(BundleCompat.getBinder(bundle, MediaSessionCompat.KEY_EXTRA_BINDER));
            Bundle bundle2 = bundle.getBundle(MediaSessionCompat.KEY_SESSION_TOKEN2_BUNDLE);
            Token token2 = (Token) bundle.getParcelable(MediaSessionCompat.KEY_TOKEN);
            if (token2 != null) {
                token = new Token(token2.mInner, asInterface, bundle2);
            }
            return token;
        }

        public static Token fromToken(Object obj) {
            return fromToken(obj, null);
        }

        public static Token fromToken(Object obj, IMediaSession iMediaSession) {
            if (obj == null || VERSION.SDK_INT < 21) {
                return null;
            }
            MediaSessionCompatApi21.verifyToken(obj);
            return new Token(obj, iMediaSession);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Token)) {
                return false;
            }
            Token token = (Token) obj;
            Object obj2 = this.mInner;
            if (obj2 == null) {
                if (token.mInner != null) {
                    z = false;
                }
                return z;
            }
            obj = token.mInner;
            return obj == null ? false : obj2.equals(obj);
        }

        public IMediaSession getExtraBinder() {
            return this.mExtraBinder;
        }

        public Bundle getSessionToken2Bundle() {
            return this.mSessionToken2Bundle;
        }

        public Object getToken() {
            return this.mInner;
        }

        public int hashCode() {
            Object obj = this.mInner;
            return obj == null ? 0 : obj.hashCode();
        }

        public void setExtraBinder(IMediaSession iMediaSession) {
            this.mExtraBinder = iMediaSession;
        }

        public void setSessionToken2Bundle(Bundle bundle) {
            this.mSessionToken2Bundle = bundle;
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putParcelable(MediaSessionCompat.KEY_TOKEN, this);
            IInterface iInterface = this.mExtraBinder;
            if (iInterface != null) {
                BundleCompat.putBinder(bundle, MediaSessionCompat.KEY_EXTRA_BINDER, iInterface.asBinder());
            }
            Bundle bundle2 = this.mSessionToken2Bundle;
            if (bundle2 != null) {
                bundle.putBundle(MediaSessionCompat.KEY_SESSION_TOKEN2_BUNDLE, bundle2);
            }
            return bundle;
        }

        public void writeToParcel(Parcel parcel, int i) {
            if (VERSION.SDK_INT >= 21) {
                parcel.writeParcelable((Parcelable) this.mInner, i);
            } else {
                parcel.writeStrongBinder((IBinder) this.mInner);
            }
        }
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$1 */
    class C07661 extends Callback {
        C07661() {
        }
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$2 */
    class C07672 extends Callback {
        C07672() {
        }
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$3 */
    class C07683 extends Callback {
        C07683() {
        }
    }

    static class MediaSessionImplApi21 implements MediaSessionImpl {
        boolean mCaptioningEnabled;
        boolean mDestroyed = false;
        final RemoteCallbackList<IMediaControllerCallback> mExtraControllerCallbacks = new RemoteCallbackList();
        MediaMetadataCompat mMetadata;
        PlaybackStateCompat mPlaybackState;
        List<QueueItem> mQueue;
        int mRatingType;
        int mRepeatMode;
        final Object mSessionObj;
        int mShuffleMode;
        final Token mToken;

        class ExtraSession extends Stub {
            ExtraSession() {
            }

            public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
                throw new AssertionError();
            }

            public void addQueueItemAt(MediaDescriptionCompat mediaDescriptionCompat, int i) {
                throw new AssertionError();
            }

            public void adjustVolume(int i, int i2, String str) {
                throw new AssertionError();
            }

            public void fastForward() {
                throw new AssertionError();
            }

            public Bundle getExtras() {
                throw new AssertionError();
            }

            public long getFlags() {
                throw new AssertionError();
            }

            public PendingIntent getLaunchPendingIntent() {
                throw new AssertionError();
            }

            public MediaMetadataCompat getMetadata() {
                throw new AssertionError();
            }

            public String getPackageName() {
                throw new AssertionError();
            }

            public PlaybackStateCompat getPlaybackState() {
                MediaSessionImplApi21 mediaSessionImplApi21 = MediaSessionImplApi21.this;
                return MediaSessionCompat.getStateWithUpdatedPosition(mediaSessionImplApi21.mPlaybackState, mediaSessionImplApi21.mMetadata);
            }

            public List<QueueItem> getQueue() {
                return null;
            }

            public CharSequence getQueueTitle() {
                throw new AssertionError();
            }

            public int getRatingType() {
                return MediaSessionImplApi21.this.mRatingType;
            }

            public int getRepeatMode() {
                return MediaSessionImplApi21.this.mRepeatMode;
            }

            public int getShuffleMode() {
                return MediaSessionImplApi21.this.mShuffleMode;
            }

            public String getTag() {
                throw new AssertionError();
            }

            public ParcelableVolumeInfo getVolumeAttributes() {
                throw new AssertionError();
            }

            public boolean isCaptioningEnabled() {
                return MediaSessionImplApi21.this.mCaptioningEnabled;
            }

            public boolean isShuffleModeEnabledRemoved() {
                return false;
            }

            public boolean isTransportControlEnabled() {
                throw new AssertionError();
            }

            public void next() {
                throw new AssertionError();
            }

            public void pause() {
                throw new AssertionError();
            }

            public void play() {
                throw new AssertionError();
            }

            public void playFromMediaId(String str, Bundle bundle) {
                throw new AssertionError();
            }

            public void playFromSearch(String str, Bundle bundle) {
                throw new AssertionError();
            }

            public void playFromUri(Uri uri, Bundle bundle) {
                throw new AssertionError();
            }

            public void prepare() {
                throw new AssertionError();
            }

            public void prepareFromMediaId(String str, Bundle bundle) {
                throw new AssertionError();
            }

            public void prepareFromSearch(String str, Bundle bundle) {
                throw new AssertionError();
            }

            public void prepareFromUri(Uri uri, Bundle bundle) {
                throw new AssertionError();
            }

            public void previous() {
                throw new AssertionError();
            }

            public void rate(RatingCompat ratingCompat) {
                throw new AssertionError();
            }

            public void rateWithExtras(RatingCompat ratingCompat, Bundle bundle) {
                throw new AssertionError();
            }

            public void registerCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
                MediaSessionImplApi21 mediaSessionImplApi21 = MediaSessionImplApi21.this;
                if (!mediaSessionImplApi21.mDestroyed) {
                    String callingPackage = mediaSessionImplApi21.getCallingPackage();
                    if (callingPackage == null) {
                        callingPackage = RemoteUserInfo.LEGACY_CONTROLLER;
                    }
                    MediaSessionImplApi21.this.mExtraControllerCallbacks.register(iMediaControllerCallback, new RemoteUserInfo(callingPackage, Binder.getCallingPid(), Binder.getCallingUid()));
                }
            }

            public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
                throw new AssertionError();
            }

            public void removeQueueItemAt(int i) {
                throw new AssertionError();
            }

            public void rewind() {
                throw new AssertionError();
            }

            public void seekTo(long j) {
                throw new AssertionError();
            }

            public void sendCommand(String str, Bundle bundle, ResultReceiverWrapper resultReceiverWrapper) {
                throw new AssertionError();
            }

            public void sendCustomAction(String str, Bundle bundle) {
                throw new AssertionError();
            }

            public boolean sendMediaButton(KeyEvent keyEvent) {
                throw new AssertionError();
            }

            public void setCaptioningEnabled(boolean z) {
                throw new AssertionError();
            }

            public void setRepeatMode(int i) {
                throw new AssertionError();
            }

            public void setShuffleMode(int i) {
                throw new AssertionError();
            }

            public void setShuffleModeEnabledRemoved(boolean z) {
            }

            public void setVolumeTo(int i, int i2, String str) {
                throw new AssertionError();
            }

            public void skipToQueueItem(long j) {
                throw new AssertionError();
            }

            public void stop() {
                throw new AssertionError();
            }

            public void unregisterCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
                MediaSessionImplApi21.this.mExtraControllerCallbacks.unregister(iMediaControllerCallback);
            }
        }

        MediaSessionImplApi21(Context context, String str, Bundle bundle) {
            this.mSessionObj = MediaSessionCompatApi21.createSession(context, str);
            this.mToken = new Token(MediaSessionCompatApi21.getSessionToken(this.mSessionObj), new ExtraSession(), bundle);
        }

        MediaSessionImplApi21(Object obj) {
            MediaSessionCompatApi21.verifySession(obj);
            this.mSessionObj = obj;
            this.mToken = new Token(MediaSessionCompatApi21.getSessionToken(this.mSessionObj), new ExtraSession());
        }

        public String getCallingPackage() {
            return VERSION.SDK_INT < 24 ? null : MediaSessionCompatApi24.getCallingPackage(this.mSessionObj);
        }

        public RemoteUserInfo getCurrentControllerInfo() {
            return null;
        }

        public Object getMediaSession() {
            return this.mSessionObj;
        }

        public PlaybackStateCompat getPlaybackState() {
            return this.mPlaybackState;
        }

        public Object getRemoteControlClient() {
            return null;
        }

        public Token getSessionToken() {
            return this.mToken;
        }

        public boolean isActive() {
            return MediaSessionCompatApi21.isActive(this.mSessionObj);
        }

        public void release() {
            this.mDestroyed = true;
            MediaSessionCompatApi21.release(this.mSessionObj);
        }

        public void sendSessionEvent(java.lang.String r3, android.os.Bundle r4) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
            /*
            r2 = this;
            r0 = android.os.Build.VERSION.SDK_INT;
            r1 = 23;
            if (r0 >= r1) goto L_0x0023;
        L_0x0006:
            r0 = r2.mExtraControllerCallbacks;
            r0 = r0.beginBroadcast();
            r0 = r0 + -1;
        L_0x000e:
            if (r0 < 0) goto L_0x001e;
        L_0x0010:
            r1 = r2.mExtraControllerCallbacks;
            r1 = r1.getBroadcastItem(r0);
            r1 = (android.support.v4.media.session.IMediaControllerCallback) r1;
            r1.onEvent(r3, r4);	 Catch:{ RemoteException -> 0x001b }
        L_0x001b:
            r0 = r0 + -1;
            goto L_0x000e;
        L_0x001e:
            r0 = r2.mExtraControllerCallbacks;
            r0.finishBroadcast();
        L_0x0023:
            r0 = r2.mSessionObj;
            android.support.v4.media.session.MediaSessionCompatApi21.sendSessionEvent(r0, r3, r4);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21.sendSessionEvent(java.lang.String, android.os.Bundle):void");
        }

        public void setActive(boolean z) {
            MediaSessionCompatApi21.setActive(this.mSessionObj, z);
        }

        public void setCallback(Callback callback, Handler handler) {
            MediaSessionCompatApi21.setCallback(this.mSessionObj, callback == null ? null : callback.mCallbackObj, handler);
            if (callback != null) {
                callback.setSessionImpl(this, handler);
            }
        }

        public void setCaptioningEnabled(boolean r3) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
            /*
            r2 = this;
            r0 = r2.mCaptioningEnabled;
            if (r0 == r3) goto L_0x0023;
        L_0x0004:
            r2.mCaptioningEnabled = r3;
            r0 = r2.mExtraControllerCallbacks;
            r0 = r0.beginBroadcast();
            r0 = r0 + -1;
        L_0x000e:
            if (r0 < 0) goto L_0x001e;
        L_0x0010:
            r1 = r2.mExtraControllerCallbacks;
            r1 = r1.getBroadcastItem(r0);
            r1 = (android.support.v4.media.session.IMediaControllerCallback) r1;
            r1.onCaptioningEnabledChanged(r3);	 Catch:{ RemoteException -> 0x001b }
        L_0x001b:
            r0 = r0 + -1;
            goto L_0x000e;
        L_0x001e:
            r3 = r2.mExtraControllerCallbacks;
            r3.finishBroadcast();
        L_0x0023:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21.setCaptioningEnabled(boolean):void");
        }

        public void setCurrentControllerInfo(RemoteUserInfo remoteUserInfo) {
        }

        public void setExtras(Bundle bundle) {
            MediaSessionCompatApi21.setExtras(this.mSessionObj, bundle);
        }

        public void setFlags(int i) {
            MediaSessionCompatApi21.setFlags(this.mSessionObj, i);
        }

        public void setMediaButtonReceiver(PendingIntent pendingIntent) {
            MediaSessionCompatApi21.setMediaButtonReceiver(this.mSessionObj, pendingIntent);
        }

        public void setMetadata(MediaMetadataCompat mediaMetadataCompat) {
            this.mMetadata = mediaMetadataCompat;
            MediaSessionCompatApi21.setMetadata(this.mSessionObj, mediaMetadataCompat == null ? null : mediaMetadataCompat.getMediaMetadata());
        }

        public void setPlaybackState(android.support.v4.media.session.PlaybackStateCompat r3) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
            /*
            r2 = this;
            r2.mPlaybackState = r3;
            r0 = r2.mExtraControllerCallbacks;
            r0 = r0.beginBroadcast();
            r0 = r0 + -1;
        L_0x000a:
            if (r0 < 0) goto L_0x001a;
        L_0x000c:
            r1 = r2.mExtraControllerCallbacks;
            r1 = r1.getBroadcastItem(r0);
            r1 = (android.support.v4.media.session.IMediaControllerCallback) r1;
            r1.onPlaybackStateChanged(r3);	 Catch:{ RemoteException -> 0x0017 }
        L_0x0017:
            r0 = r0 + -1;
            goto L_0x000a;
        L_0x001a:
            r0 = r2.mExtraControllerCallbacks;
            r0.finishBroadcast();
            r0 = r2.mSessionObj;
            if (r3 != 0) goto L_0x0025;
        L_0x0023:
            r3 = 0;
            goto L_0x0029;
        L_0x0025:
            r3 = r3.getPlaybackState();
        L_0x0029:
            android.support.v4.media.session.MediaSessionCompatApi21.setPlaybackState(r0, r3);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21.setPlaybackState(android.support.v4.media.session.PlaybackStateCompat):void");
        }

        public void setPlaybackToLocal(int i) {
            MediaSessionCompatApi21.setPlaybackToLocal(this.mSessionObj, i);
        }

        public void setPlaybackToRemote(VolumeProviderCompat volumeProviderCompat) {
            MediaSessionCompatApi21.setPlaybackToRemote(this.mSessionObj, volumeProviderCompat.getVolumeProvider());
        }

        public void setQueue(List<QueueItem> list) {
            List arrayList;
            this.mQueue = list;
            if (list != null) {
                arrayList = new ArrayList();
                for (QueueItem queueItem : list) {
                    arrayList.add(queueItem.getQueueItem());
                }
            } else {
                arrayList = null;
            }
            MediaSessionCompatApi21.setQueue(this.mSessionObj, arrayList);
        }

        public void setQueueTitle(CharSequence charSequence) {
            MediaSessionCompatApi21.setQueueTitle(this.mSessionObj, charSequence);
        }

        public void setRatingType(int i) {
            if (VERSION.SDK_INT < 22) {
                this.mRatingType = i;
            } else {
                MediaSessionCompatApi22.setRatingType(this.mSessionObj, i);
            }
        }

        public void setRepeatMode(int r3) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
            /*
            r2 = this;
            r0 = r2.mRepeatMode;
            if (r0 == r3) goto L_0x0023;
        L_0x0004:
            r2.mRepeatMode = r3;
            r0 = r2.mExtraControllerCallbacks;
            r0 = r0.beginBroadcast();
            r0 = r0 + -1;
        L_0x000e:
            if (r0 < 0) goto L_0x001e;
        L_0x0010:
            r1 = r2.mExtraControllerCallbacks;
            r1 = r1.getBroadcastItem(r0);
            r1 = (android.support.v4.media.session.IMediaControllerCallback) r1;
            r1.onRepeatModeChanged(r3);	 Catch:{ RemoteException -> 0x001b }
        L_0x001b:
            r0 = r0 + -1;
            goto L_0x000e;
        L_0x001e:
            r3 = r2.mExtraControllerCallbacks;
            r3.finishBroadcast();
        L_0x0023:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21.setRepeatMode(int):void");
        }

        public void setSessionActivity(PendingIntent pendingIntent) {
            MediaSessionCompatApi21.setSessionActivity(this.mSessionObj, pendingIntent);
        }

        public void setShuffleMode(int r3) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
            /*
            r2 = this;
            r0 = r2.mShuffleMode;
            if (r0 == r3) goto L_0x0023;
        L_0x0004:
            r2.mShuffleMode = r3;
            r0 = r2.mExtraControllerCallbacks;
            r0 = r0.beginBroadcast();
            r0 = r0 + -1;
        L_0x000e:
            if (r0 < 0) goto L_0x001e;
        L_0x0010:
            r1 = r2.mExtraControllerCallbacks;
            r1 = r1.getBroadcastItem(r0);
            r1 = (android.support.v4.media.session.IMediaControllerCallback) r1;
            r1.onShuffleModeChanged(r3);	 Catch:{ RemoteException -> 0x001b }
        L_0x001b:
            r0 = r0 + -1;
            goto L_0x000e;
        L_0x001e:
            r3 = r2.mExtraControllerCallbacks;
            r3.finishBroadcast();
        L_0x0023:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21.setShuffleMode(int):void");
        }
    }

    static class MediaSessionImplBase implements MediaSessionImpl {
        static final int RCC_PLAYSTATE_NONE = 0;
        final AudioManager mAudioManager;
        volatile Callback mCallback;
        boolean mCaptioningEnabled;
        private final Context mContext;
        final RemoteCallbackList<IMediaControllerCallback> mControllerCallbacks = new RemoteCallbackList();
        boolean mDestroyed = false;
        Bundle mExtras;
        int mFlags;
        private MessageHandler mHandler;
        boolean mIsActive = false;
        private boolean mIsMbrRegistered = false;
        private boolean mIsRccRegistered = false;
        int mLocalStream;
        final Object mLock = new Object();
        private final ComponentName mMediaButtonReceiverComponentName;
        private final PendingIntent mMediaButtonReceiverIntent;
        MediaMetadataCompat mMetadata;
        final String mPackageName;
        List<QueueItem> mQueue;
        CharSequence mQueueTitle;
        int mRatingType;
        final RemoteControlClient mRcc;
        private RemoteUserInfo mRemoteUserInfo;
        int mRepeatMode;
        PendingIntent mSessionActivity;
        int mShuffleMode;
        PlaybackStateCompat mState;
        private final MediaSessionStub mStub;
        final String mTag;
        private final Token mToken;
        private android.support.v4.media.VolumeProviderCompat.Callback mVolumeCallback = new C07691();
        VolumeProviderCompat mVolumeProvider;
        int mVolumeType;

        private static final class Command {
            public final String command;
            public final Bundle extras;
            public final ResultReceiver stub;

            public Command(String str, Bundle bundle, ResultReceiver resultReceiver) {
                this.command = str;
                this.extras = bundle;
                this.stub = resultReceiver;
            }
        }

        class MessageHandler extends Handler {
            private static final int KEYCODE_MEDIA_PAUSE = 127;
            private static final int KEYCODE_MEDIA_PLAY = 126;
            private static final int MSG_ADD_QUEUE_ITEM = 25;
            private static final int MSG_ADD_QUEUE_ITEM_AT = 26;
            private static final int MSG_ADJUST_VOLUME = 2;
            private static final int MSG_COMMAND = 1;
            private static final int MSG_CUSTOM_ACTION = 20;
            private static final int MSG_FAST_FORWARD = 16;
            private static final int MSG_MEDIA_BUTTON = 21;
            private static final int MSG_NEXT = 14;
            private static final int MSG_PAUSE = 12;
            private static final int MSG_PLAY = 7;
            private static final int MSG_PLAY_MEDIA_ID = 8;
            private static final int MSG_PLAY_SEARCH = 9;
            private static final int MSG_PLAY_URI = 10;
            private static final int MSG_PREPARE = 3;
            private static final int MSG_PREPARE_MEDIA_ID = 4;
            private static final int MSG_PREPARE_SEARCH = 5;
            private static final int MSG_PREPARE_URI = 6;
            private static final int MSG_PREVIOUS = 15;
            private static final int MSG_RATE = 19;
            private static final int MSG_RATE_EXTRA = 31;
            private static final int MSG_REMOVE_QUEUE_ITEM = 27;
            private static final int MSG_REMOVE_QUEUE_ITEM_AT = 28;
            private static final int MSG_REWIND = 17;
            private static final int MSG_SEEK_TO = 18;
            private static final int MSG_SET_CAPTIONING_ENABLED = 29;
            private static final int MSG_SET_REPEAT_MODE = 23;
            private static final int MSG_SET_SHUFFLE_MODE = 30;
            private static final int MSG_SET_VOLUME = 22;
            private static final int MSG_SKIP_TO_ITEM = 11;
            private static final int MSG_STOP = 13;

            public MessageHandler(Looper looper) {
                super(looper);
            }

            private void onMediaButtonEvent(KeyEvent keyEvent, Callback callback) {
                if (keyEvent == null) {
                    return;
                }
                if (keyEvent.getAction() == 0) {
                    PlaybackStateCompat playbackStateCompat = MediaSessionImplBase.this.mState;
                    long actions = playbackStateCompat == null ? 0 : playbackStateCompat.getActions();
                    int keyCode = keyEvent.getKeyCode();
                    if (keyCode != 79) {
                        if (keyCode != KEYCODE_MEDIA_PLAY) {
                            if (keyCode != KEYCODE_MEDIA_PAUSE) {
                                switch (keyCode) {
                                    case 85:
                                        break;
                                    case 86:
                                        if ((actions & 1) != 0) {
                                            callback.onStop();
                                            return;
                                        }
                                        return;
                                    case 87:
                                        if ((actions & 32) != 0) {
                                            callback.onSkipToNext();
                                            return;
                                        }
                                        return;
                                    case 88:
                                        if ((actions & 16) != 0) {
                                            callback.onSkipToPrevious();
                                            return;
                                        }
                                        return;
                                    case 89:
                                        if ((actions & 8) != 0) {
                                            callback.onRewind();
                                            return;
                                        }
                                        return;
                                    case 90:
                                        if ((actions & 64) != 0) {
                                            callback.onFastForward();
                                            return;
                                        }
                                        return;
                                    default:
                                        return;
                                }
                            } else if ((actions & 2) != 0) {
                                callback.onPause();
                                return;
                            } else {
                                return;
                            }
                        } else if ((actions & 4) != 0) {
                            callback.onPlay();
                            return;
                        } else {
                            return;
                        }
                    }
                    Log.w(MediaSessionCompat.TAG, "KEYCODE_MEDIA_PLAY_PAUSE and KEYCODE_HEADSETHOOK are handled already");
                }
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void handleMessage(android.os.Message r8) {
                /*
                r7 = this;
                r0 = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this;
                r0 = r0.mCallback;
                if (r0 != 0) goto L_0x0007;
            L_0x0006:
                return;
            L_0x0007:
                r1 = r8.getData();
                android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(r1);
                r2 = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this;
                r3 = new android.support.v4.media.MediaSessionManager$RemoteUserInfo;
                r4 = "data_calling_pkg";
                r4 = r1.getString(r4);
                r5 = "data_calling_pid";
                r5 = r1.getInt(r5);
                r6 = "data_calling_uid";
                r6 = r1.getInt(r6);
                r3.<init>(r4, r5, r6);
                r2.setCurrentControllerInfo(r3);
                r2 = "data_extras";
                r1 = r1.getBundle(r2);
                android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(r1);
                r2 = 0;
                r3 = r8.what;	 Catch:{ all -> 0x0165 }
                r4 = 0;
                switch(r3) {
                    case 1: goto L_0x0152;
                    case 2: goto L_0x014a;
                    case 3: goto L_0x0146;
                    case 4: goto L_0x013e;
                    case 5: goto L_0x0136;
                    case 6: goto L_0x012e;
                    case 7: goto L_0x012a;
                    case 8: goto L_0x0122;
                    case 9: goto L_0x011a;
                    case 10: goto L_0x0112;
                    case 11: goto L_0x0106;
                    case 12: goto L_0x0102;
                    case 13: goto L_0x00fe;
                    case 14: goto L_0x00fa;
                    case 15: goto L_0x00f5;
                    case 16: goto L_0x00f0;
                    case 17: goto L_0x00eb;
                    case 18: goto L_0x00de;
                    case 19: goto L_0x00d5;
                    case 20: goto L_0x00cc;
                    case 21: goto L_0x00b1;
                    case 22: goto L_0x00a8;
                    case 23: goto L_0x00a1;
                    case 24: goto L_0x003a;
                    case 25: goto L_0x0098;
                    case 26: goto L_0x008d;
                    case 27: goto L_0x0088;
                    case 28: goto L_0x0059;
                    case 29: goto L_0x004c;
                    case 30: goto L_0x0045;
                    case 31: goto L_0x003c;
                    default: goto L_0x003a;
                };	 Catch:{ all -> 0x0165 }
            L_0x003a:
                goto L_0x015f;
            L_0x003c:
                r8 = r8.obj;	 Catch:{ all -> 0x0165 }
                r8 = (android.support.v4.media.RatingCompat) r8;	 Catch:{ all -> 0x0165 }
                r0.onSetRating(r8, r1);	 Catch:{ all -> 0x0165 }
                goto L_0x015f;
            L_0x0045:
                r8 = r8.arg1;	 Catch:{ all -> 0x0165 }
                r0.onSetShuffleMode(r8);	 Catch:{ all -> 0x0165 }
                goto L_0x015f;
            L_0x004c:
                r8 = r8.obj;	 Catch:{ all -> 0x0165 }
                r8 = (java.lang.Boolean) r8;	 Catch:{ all -> 0x0165 }
                r8 = r8.booleanValue();	 Catch:{ all -> 0x0165 }
                r0.onSetCaptioningEnabled(r8);	 Catch:{ all -> 0x0165 }
                goto L_0x015f;
            L_0x0059:
                r1 = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this;	 Catch:{ all -> 0x0165 }
                r1 = r1.mQueue;	 Catch:{ all -> 0x0165 }
                if (r1 == 0) goto L_0x015f;
            L_0x005f:
                r1 = r8.arg1;	 Catch:{ all -> 0x0165 }
                if (r1 < 0) goto L_0x007c;
            L_0x0063:
                r1 = r8.arg1;	 Catch:{ all -> 0x0165 }
                r3 = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this;	 Catch:{ all -> 0x0165 }
                r3 = r3.mQueue;	 Catch:{ all -> 0x0165 }
                r3 = r3.size();	 Catch:{ all -> 0x0165 }
                if (r1 >= r3) goto L_0x007c;
            L_0x006f:
                r1 = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this;	 Catch:{ all -> 0x0165 }
                r1 = r1.mQueue;	 Catch:{ all -> 0x0165 }
                r8 = r8.arg1;	 Catch:{ all -> 0x0165 }
                r8 = r1.get(r8);	 Catch:{ all -> 0x0165 }
                r8 = (android.support.v4.media.session.MediaSessionCompat.QueueItem) r8;	 Catch:{ all -> 0x0165 }
                goto L_0x007d;
            L_0x007c:
                r8 = r2;
            L_0x007d:
                if (r8 == 0) goto L_0x015f;
            L_0x007f:
                r8 = r8.getDescription();	 Catch:{ all -> 0x0165 }
            L_0x0083:
                r0.onRemoveQueueItem(r8);	 Catch:{ all -> 0x0165 }
                goto L_0x015f;
            L_0x0088:
                r8 = r8.obj;	 Catch:{ all -> 0x0165 }
                r8 = (android.support.v4.media.MediaDescriptionCompat) r8;	 Catch:{ all -> 0x0165 }
                goto L_0x0083;
            L_0x008d:
                r1 = r8.obj;	 Catch:{ all -> 0x0165 }
                r1 = (android.support.v4.media.MediaDescriptionCompat) r1;	 Catch:{ all -> 0x0165 }
                r8 = r8.arg1;	 Catch:{ all -> 0x0165 }
                r0.onAddQueueItem(r1, r8);	 Catch:{ all -> 0x0165 }
                goto L_0x015f;
            L_0x0098:
                r8 = r8.obj;	 Catch:{ all -> 0x0165 }
                r8 = (android.support.v4.media.MediaDescriptionCompat) r8;	 Catch:{ all -> 0x0165 }
                r0.onAddQueueItem(r8);	 Catch:{ all -> 0x0165 }
                goto L_0x015f;
            L_0x00a1:
                r8 = r8.arg1;	 Catch:{ all -> 0x0165 }
                r0.onSetRepeatMode(r8);	 Catch:{ all -> 0x0165 }
                goto L_0x015f;
            L_0x00a8:
                r0 = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this;	 Catch:{ all -> 0x0165 }
                r8 = r8.arg1;	 Catch:{ all -> 0x0165 }
                r0.setVolumeTo(r8, r4);	 Catch:{ all -> 0x0165 }
                goto L_0x015f;
            L_0x00b1:
                r8 = r8.obj;	 Catch:{ all -> 0x0165 }
                r8 = (android.view.KeyEvent) r8;	 Catch:{ all -> 0x0165 }
                r1 = new android.content.Intent;	 Catch:{ all -> 0x0165 }
                r3 = "android.intent.action.MEDIA_BUTTON";
                r1.<init>(r3);	 Catch:{ all -> 0x0165 }
                r3 = "android.intent.extra.KEY_EVENT";
                r1.putExtra(r3, r8);	 Catch:{ all -> 0x0165 }
                r1 = r0.onMediaButtonEvent(r1);	 Catch:{ all -> 0x0165 }
                if (r1 != 0) goto L_0x015f;
            L_0x00c7:
                r7.onMediaButtonEvent(r8, r0);	 Catch:{ all -> 0x0165 }
                goto L_0x015f;
            L_0x00cc:
                r8 = r8.obj;	 Catch:{ all -> 0x0165 }
                r8 = (java.lang.String) r8;	 Catch:{ all -> 0x0165 }
                r0.onCustomAction(r8, r1);	 Catch:{ all -> 0x0165 }
                goto L_0x015f;
            L_0x00d5:
                r8 = r8.obj;	 Catch:{ all -> 0x0165 }
                r8 = (android.support.v4.media.RatingCompat) r8;	 Catch:{ all -> 0x0165 }
                r0.onSetRating(r8);	 Catch:{ all -> 0x0165 }
                goto L_0x015f;
            L_0x00de:
                r8 = r8.obj;	 Catch:{ all -> 0x0165 }
                r8 = (java.lang.Long) r8;	 Catch:{ all -> 0x0165 }
                r3 = r8.longValue();	 Catch:{ all -> 0x0165 }
                r0.onSeekTo(r3);	 Catch:{ all -> 0x0165 }
                goto L_0x015f;
            L_0x00eb:
                r0.onRewind();	 Catch:{ all -> 0x0165 }
                goto L_0x015f;
            L_0x00f0:
                r0.onFastForward();	 Catch:{ all -> 0x0165 }
                goto L_0x015f;
            L_0x00f5:
                r0.onSkipToPrevious();	 Catch:{ all -> 0x0165 }
                goto L_0x015f;
            L_0x00fa:
                r0.onSkipToNext();	 Catch:{ all -> 0x0165 }
                goto L_0x015f;
            L_0x00fe:
                r0.onStop();	 Catch:{ all -> 0x0165 }
                goto L_0x015f;
            L_0x0102:
                r0.onPause();	 Catch:{ all -> 0x0165 }
                goto L_0x015f;
            L_0x0106:
                r8 = r8.obj;	 Catch:{ all -> 0x0165 }
                r8 = (java.lang.Long) r8;	 Catch:{ all -> 0x0165 }
                r3 = r8.longValue();	 Catch:{ all -> 0x0165 }
                r0.onSkipToQueueItem(r3);	 Catch:{ all -> 0x0165 }
                goto L_0x015f;
            L_0x0112:
                r8 = r8.obj;	 Catch:{ all -> 0x0165 }
                r8 = (android.net.Uri) r8;	 Catch:{ all -> 0x0165 }
                r0.onPlayFromUri(r8, r1);	 Catch:{ all -> 0x0165 }
                goto L_0x015f;
            L_0x011a:
                r8 = r8.obj;	 Catch:{ all -> 0x0165 }
                r8 = (java.lang.String) r8;	 Catch:{ all -> 0x0165 }
                r0.onPlayFromSearch(r8, r1);	 Catch:{ all -> 0x0165 }
                goto L_0x015f;
            L_0x0122:
                r8 = r8.obj;	 Catch:{ all -> 0x0165 }
                r8 = (java.lang.String) r8;	 Catch:{ all -> 0x0165 }
                r0.onPlayFromMediaId(r8, r1);	 Catch:{ all -> 0x0165 }
                goto L_0x015f;
            L_0x012a:
                r0.onPlay();	 Catch:{ all -> 0x0165 }
                goto L_0x015f;
            L_0x012e:
                r8 = r8.obj;	 Catch:{ all -> 0x0165 }
                r8 = (android.net.Uri) r8;	 Catch:{ all -> 0x0165 }
                r0.onPrepareFromUri(r8, r1);	 Catch:{ all -> 0x0165 }
                goto L_0x015f;
            L_0x0136:
                r8 = r8.obj;	 Catch:{ all -> 0x0165 }
                r8 = (java.lang.String) r8;	 Catch:{ all -> 0x0165 }
                r0.onPrepareFromSearch(r8, r1);	 Catch:{ all -> 0x0165 }
                goto L_0x015f;
            L_0x013e:
                r8 = r8.obj;	 Catch:{ all -> 0x0165 }
                r8 = (java.lang.String) r8;	 Catch:{ all -> 0x0165 }
                r0.onPrepareFromMediaId(r8, r1);	 Catch:{ all -> 0x0165 }
                goto L_0x015f;
            L_0x0146:
                r0.onPrepare();	 Catch:{ all -> 0x0165 }
                goto L_0x015f;
            L_0x014a:
                r0 = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this;	 Catch:{ all -> 0x0165 }
                r8 = r8.arg1;	 Catch:{ all -> 0x0165 }
                r0.adjustVolume(r8, r4);	 Catch:{ all -> 0x0165 }
                goto L_0x015f;
            L_0x0152:
                r8 = r8.obj;	 Catch:{ all -> 0x0165 }
                r8 = (android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.Command) r8;	 Catch:{ all -> 0x0165 }
                r1 = r8.command;	 Catch:{ all -> 0x0165 }
                r3 = r8.extras;	 Catch:{ all -> 0x0165 }
                r8 = r8.stub;	 Catch:{ all -> 0x0165 }
                r0.onCommand(r1, r3, r8);	 Catch:{ all -> 0x0165 }
            L_0x015f:
                r8 = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this;
                r8.setCurrentControllerInfo(r2);
                return;
            L_0x0165:
                r8 = move-exception;
                r0 = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this;
                r0.setCurrentControllerInfo(r2);
                goto L_0x016d;
            L_0x016c:
                throw r8;
            L_0x016d:
                goto L_0x016c;
                */
                throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.MessageHandler.handleMessage(android.os.Message):void");
            }
        }

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase$1 */
        class C07691 extends android.support.v4.media.VolumeProviderCompat.Callback {
            C07691() {
            }

            public void onVolumeChanged(VolumeProviderCompat volumeProviderCompat) {
                MediaSessionImplBase mediaSessionImplBase = MediaSessionImplBase.this;
                if (mediaSessionImplBase.mVolumeProvider == volumeProviderCompat) {
                    MediaSessionImplBase.this.sendVolumeInfoChanged(new ParcelableVolumeInfo(mediaSessionImplBase.mVolumeType, mediaSessionImplBase.mLocalStream, volumeProviderCompat.getVolumeControl(), volumeProviderCompat.getMaxVolume(), volumeProviderCompat.getCurrentVolume()));
                }
            }
        }

        class MediaSessionStub extends Stub {
            MediaSessionStub() {
            }

            public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
                postToHandler(25, (Object) mediaDescriptionCompat);
            }

            public void addQueueItemAt(MediaDescriptionCompat mediaDescriptionCompat, int i) {
                postToHandler(26, (Object) mediaDescriptionCompat, i);
            }

            public void adjustVolume(int i, int i2, String str) {
                MediaSessionImplBase.this.adjustVolume(i, i2);
            }

            public void fastForward() {
                postToHandler(16);
            }

            public Bundle getExtras() {
                Bundle bundle;
                synchronized (MediaSessionImplBase.this.mLock) {
                    bundle = MediaSessionImplBase.this.mExtras;
                }
                return bundle;
            }

            public long getFlags() {
                long j;
                synchronized (MediaSessionImplBase.this.mLock) {
                    j = (long) MediaSessionImplBase.this.mFlags;
                }
                return j;
            }

            public PendingIntent getLaunchPendingIntent() {
                PendingIntent pendingIntent;
                synchronized (MediaSessionImplBase.this.mLock) {
                    pendingIntent = MediaSessionImplBase.this.mSessionActivity;
                }
                return pendingIntent;
            }

            public MediaMetadataCompat getMetadata() {
                return MediaSessionImplBase.this.mMetadata;
            }

            public String getPackageName() {
                return MediaSessionImplBase.this.mPackageName;
            }

            public PlaybackStateCompat getPlaybackState() {
                PlaybackStateCompat playbackStateCompat;
                MediaMetadataCompat mediaMetadataCompat;
                synchronized (MediaSessionImplBase.this.mLock) {
                    playbackStateCompat = MediaSessionImplBase.this.mState;
                    mediaMetadataCompat = MediaSessionImplBase.this.mMetadata;
                }
                return MediaSessionCompat.getStateWithUpdatedPosition(playbackStateCompat, mediaMetadataCompat);
            }

            public List<QueueItem> getQueue() {
                List<QueueItem> list;
                synchronized (MediaSessionImplBase.this.mLock) {
                    list = MediaSessionImplBase.this.mQueue;
                }
                return list;
            }

            public CharSequence getQueueTitle() {
                return MediaSessionImplBase.this.mQueueTitle;
            }

            public int getRatingType() {
                return MediaSessionImplBase.this.mRatingType;
            }

            public int getRepeatMode() {
                return MediaSessionImplBase.this.mRepeatMode;
            }

            public int getShuffleMode() {
                return MediaSessionImplBase.this.mShuffleMode;
            }

            public String getTag() {
                return MediaSessionImplBase.this.mTag;
            }

            public ParcelableVolumeInfo getVolumeAttributes() {
                int i;
                int i2;
                int maxVolume;
                int currentVolume;
                int i3;
                synchronized (MediaSessionImplBase.this.mLock) {
                    i = MediaSessionImplBase.this.mVolumeType;
                    i2 = MediaSessionImplBase.this.mLocalStream;
                    VolumeProviderCompat volumeProviderCompat = MediaSessionImplBase.this.mVolumeProvider;
                    if (i == 2) {
                        int volumeControl = volumeProviderCompat.getVolumeControl();
                        maxVolume = volumeProviderCompat.getMaxVolume();
                        currentVolume = volumeProviderCompat.getCurrentVolume();
                        i3 = maxVolume;
                        maxVolume = volumeControl;
                    } else {
                        i3 = MediaSessionImplBase.this.mAudioManager.getStreamMaxVolume(i2);
                        currentVolume = MediaSessionImplBase.this.mAudioManager.getStreamVolume(i2);
                        maxVolume = 2;
                    }
                }
                return new ParcelableVolumeInfo(i, i2, maxVolume, i3, currentVolume);
            }

            public boolean isCaptioningEnabled() {
                return MediaSessionImplBase.this.mCaptioningEnabled;
            }

            public boolean isShuffleModeEnabledRemoved() {
                return false;
            }

            public boolean isTransportControlEnabled() {
                return (MediaSessionImplBase.this.mFlags & 2) != 0;
            }

            public void next() {
                postToHandler(14);
            }

            public void pause() {
                postToHandler(12);
            }

            public void play() {
                postToHandler(7);
            }

            public void playFromMediaId(String str, Bundle bundle) {
                postToHandler(8, (Object) str, bundle);
            }

            public void playFromSearch(String str, Bundle bundle) {
                postToHandler(9, (Object) str, bundle);
            }

            public void playFromUri(Uri uri, Bundle bundle) {
                postToHandler(10, (Object) uri, bundle);
            }

            void postToHandler(int i) {
                MediaSessionImplBase.this.postToHandler(i, 0, 0, null, null);
            }

            void postToHandler(int i, int i2) {
                MediaSessionImplBase.this.postToHandler(i, i2, 0, null, null);
            }

            void postToHandler(int i, Object obj) {
                MediaSessionImplBase.this.postToHandler(i, 0, 0, obj, null);
            }

            void postToHandler(int i, Object obj, int i2) {
                MediaSessionImplBase.this.postToHandler(i, i2, 0, obj, null);
            }

            void postToHandler(int i, Object obj, Bundle bundle) {
                MediaSessionImplBase.this.postToHandler(i, 0, 0, obj, bundle);
            }

            public void prepare() {
                postToHandler(3);
            }

            public void prepareFromMediaId(String str, Bundle bundle) {
                postToHandler(4, (Object) str, bundle);
            }

            public void prepareFromSearch(String str, Bundle bundle) {
                postToHandler(5, (Object) str, bundle);
            }

            public void prepareFromUri(Uri uri, Bundle bundle) {
                postToHandler(6, (Object) uri, bundle);
            }

            public void previous() {
                postToHandler(15);
            }

            public void rate(RatingCompat ratingCompat) {
                postToHandler(19, (Object) ratingCompat);
            }

            public void rateWithExtras(RatingCompat ratingCompat, Bundle bundle) {
                postToHandler(31, (Object) ratingCompat, bundle);
            }

            public void registerCallbackListener(android.support.v4.media.session.IMediaControllerCallback r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
                /*
                r4 = this;
                r0 = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this;
                r0 = r0.mDestroyed;
                if (r0 == 0) goto L_0x000a;
            L_0x0006:
                r5.onSessionDestroyed();	 Catch:{ Exception -> 0x0009 }
            L_0x0009:
                return;
            L_0x000a:
                r0 = new android.support.v4.media.MediaSessionManager$RemoteUserInfo;
                r1 = android.os.Binder.getCallingPid();
                r2 = android.os.Binder.getCallingUid();
                r3 = "android.media.session.MediaController";
                r0.<init>(r3, r1, r2);
                r1 = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this;
                r1 = r1.mControllerCallbacks;
                r1.register(r5, r0);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.MediaSessionStub.registerCallbackListener(android.support.v4.media.session.IMediaControllerCallback):void");
            }

            public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
                postToHandler(27, (Object) mediaDescriptionCompat);
            }

            public void removeQueueItemAt(int i) {
                postToHandler(28, i);
            }

            public void rewind() {
                postToHandler(17);
            }

            public void seekTo(long j) {
                postToHandler(18, Long.valueOf(j));
            }

            public void sendCommand(String str, Bundle bundle, ResultReceiverWrapper resultReceiverWrapper) {
                postToHandler(1, new Command(str, bundle, resultReceiverWrapper.mResultReceiver));
            }

            public void sendCustomAction(String str, Bundle bundle) {
                postToHandler(20, (Object) str, bundle);
            }

            public boolean sendMediaButton(KeyEvent keyEvent) {
                boolean z = true;
                if ((MediaSessionImplBase.this.mFlags & 1) == 0) {
                    z = false;
                }
                if (z) {
                    postToHandler(21, (Object) keyEvent);
                }
                return z;
            }

            public void setCaptioningEnabled(boolean z) {
                postToHandler(29, Boolean.valueOf(z));
            }

            public void setRepeatMode(int i) {
                postToHandler(23, i);
            }

            public void setShuffleMode(int i) {
                postToHandler(30, i);
            }

            public void setShuffleModeEnabledRemoved(boolean z) {
            }

            public void setVolumeTo(int i, int i2, String str) {
                MediaSessionImplBase.this.setVolumeTo(i, i2);
            }

            public void skipToQueueItem(long j) {
                postToHandler(11, Long.valueOf(j));
            }

            public void stop() {
                postToHandler(13);
            }

            public void unregisterCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
                MediaSessionImplBase.this.mControllerCallbacks.unregister(iMediaControllerCallback);
            }
        }

        public MediaSessionImplBase(Context context, String str, ComponentName componentName, PendingIntent pendingIntent) {
            if (componentName != null) {
                this.mContext = context;
                this.mPackageName = context.getPackageName();
                this.mAudioManager = (AudioManager) context.getSystemService("audio");
                this.mTag = str;
                this.mMediaButtonReceiverComponentName = componentName;
                this.mMediaButtonReceiverIntent = pendingIntent;
                this.mStub = new MediaSessionStub();
                this.mToken = new Token(this.mStub);
                this.mRatingType = 0;
                this.mVolumeType = 1;
                this.mLocalStream = 3;
                this.mRcc = new RemoteControlClient(pendingIntent);
                return;
            }
            throw new IllegalArgumentException("MediaButtonReceiver component may not be null.");
        }

        private void sendCaptioningEnabled(boolean r3) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
            /*
            r2 = this;
            r0 = r2.mControllerCallbacks;
            r0 = r0.beginBroadcast();
            r0 = r0 + -1;
        L_0x0008:
            if (r0 < 0) goto L_0x0018;
        L_0x000a:
            r1 = r2.mControllerCallbacks;
            r1 = r1.getBroadcastItem(r0);
            r1 = (android.support.v4.media.session.IMediaControllerCallback) r1;
            r1.onCaptioningEnabledChanged(r3);	 Catch:{ RemoteException -> 0x0015 }
        L_0x0015:
            r0 = r0 + -1;
            goto L_0x0008;
        L_0x0018:
            r3 = r2.mControllerCallbacks;
            r3.finishBroadcast();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.sendCaptioningEnabled(boolean):void");
        }

        private void sendEvent(java.lang.String r3, android.os.Bundle r4) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
            /*
            r2 = this;
            r0 = r2.mControllerCallbacks;
            r0 = r0.beginBroadcast();
            r0 = r0 + -1;
        L_0x0008:
            if (r0 < 0) goto L_0x0018;
        L_0x000a:
            r1 = r2.mControllerCallbacks;
            r1 = r1.getBroadcastItem(r0);
            r1 = (android.support.v4.media.session.IMediaControllerCallback) r1;
            r1.onEvent(r3, r4);	 Catch:{ RemoteException -> 0x0015 }
        L_0x0015:
            r0 = r0 + -1;
            goto L_0x0008;
        L_0x0018:
            r3 = r2.mControllerCallbacks;
            r3.finishBroadcast();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.sendEvent(java.lang.String, android.os.Bundle):void");
        }

        private void sendExtras(android.os.Bundle r3) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
            /*
            r2 = this;
            r0 = r2.mControllerCallbacks;
            r0 = r0.beginBroadcast();
            r0 = r0 + -1;
        L_0x0008:
            if (r0 < 0) goto L_0x0018;
        L_0x000a:
            r1 = r2.mControllerCallbacks;
            r1 = r1.getBroadcastItem(r0);
            r1 = (android.support.v4.media.session.IMediaControllerCallback) r1;
            r1.onExtrasChanged(r3);	 Catch:{ RemoteException -> 0x0015 }
        L_0x0015:
            r0 = r0 + -1;
            goto L_0x0008;
        L_0x0018:
            r3 = r2.mControllerCallbacks;
            r3.finishBroadcast();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.sendExtras(android.os.Bundle):void");
        }

        private void sendMetadata(android.support.v4.media.MediaMetadataCompat r3) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
            /*
            r2 = this;
            r0 = r2.mControllerCallbacks;
            r0 = r0.beginBroadcast();
            r0 = r0 + -1;
        L_0x0008:
            if (r0 < 0) goto L_0x0018;
        L_0x000a:
            r1 = r2.mControllerCallbacks;
            r1 = r1.getBroadcastItem(r0);
            r1 = (android.support.v4.media.session.IMediaControllerCallback) r1;
            r1.onMetadataChanged(r3);	 Catch:{ RemoteException -> 0x0015 }
        L_0x0015:
            r0 = r0 + -1;
            goto L_0x0008;
        L_0x0018:
            r3 = r2.mControllerCallbacks;
            r3.finishBroadcast();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.sendMetadata(android.support.v4.media.MediaMetadataCompat):void");
        }

        private void sendQueue(java.util.List<android.support.v4.media.session.MediaSessionCompat.QueueItem> r3) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
            /*
            r2 = this;
            r0 = r2.mControllerCallbacks;
            r0 = r0.beginBroadcast();
            r0 = r0 + -1;
        L_0x0008:
            if (r0 < 0) goto L_0x0018;
        L_0x000a:
            r1 = r2.mControllerCallbacks;
            r1 = r1.getBroadcastItem(r0);
            r1 = (android.support.v4.media.session.IMediaControllerCallback) r1;
            r1.onQueueChanged(r3);	 Catch:{ RemoteException -> 0x0015 }
        L_0x0015:
            r0 = r0 + -1;
            goto L_0x0008;
        L_0x0018:
            r3 = r2.mControllerCallbacks;
            r3.finishBroadcast();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.sendQueue(java.util.List):void");
        }

        private void sendQueueTitle(java.lang.CharSequence r3) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
            /*
            r2 = this;
            r0 = r2.mControllerCallbacks;
            r0 = r0.beginBroadcast();
            r0 = r0 + -1;
        L_0x0008:
            if (r0 < 0) goto L_0x0018;
        L_0x000a:
            r1 = r2.mControllerCallbacks;
            r1 = r1.getBroadcastItem(r0);
            r1 = (android.support.v4.media.session.IMediaControllerCallback) r1;
            r1.onQueueTitleChanged(r3);	 Catch:{ RemoteException -> 0x0015 }
        L_0x0015:
            r0 = r0 + -1;
            goto L_0x0008;
        L_0x0018:
            r3 = r2.mControllerCallbacks;
            r3.finishBroadcast();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.sendQueueTitle(java.lang.CharSequence):void");
        }

        private void sendRepeatMode(int r3) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
            /*
            r2 = this;
            r0 = r2.mControllerCallbacks;
            r0 = r0.beginBroadcast();
            r0 = r0 + -1;
        L_0x0008:
            if (r0 < 0) goto L_0x0018;
        L_0x000a:
            r1 = r2.mControllerCallbacks;
            r1 = r1.getBroadcastItem(r0);
            r1 = (android.support.v4.media.session.IMediaControllerCallback) r1;
            r1.onRepeatModeChanged(r3);	 Catch:{ RemoteException -> 0x0015 }
        L_0x0015:
            r0 = r0 + -1;
            goto L_0x0008;
        L_0x0018:
            r3 = r2.mControllerCallbacks;
            r3.finishBroadcast();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.sendRepeatMode(int):void");
        }

        private void sendSessionDestroyed() {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
            /*
            r2 = this;
            r0 = r2.mControllerCallbacks;
            r0 = r0.beginBroadcast();
            r0 = r0 + -1;
        L_0x0008:
            if (r0 < 0) goto L_0x0018;
        L_0x000a:
            r1 = r2.mControllerCallbacks;
            r1 = r1.getBroadcastItem(r0);
            r1 = (android.support.v4.media.session.IMediaControllerCallback) r1;
            r1.onSessionDestroyed();	 Catch:{ RemoteException -> 0x0015 }
        L_0x0015:
            r0 = r0 + -1;
            goto L_0x0008;
        L_0x0018:
            r0 = r2.mControllerCallbacks;
            r0.finishBroadcast();
            r0 = r2.mControllerCallbacks;
            r0.kill();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.sendSessionDestroyed():void");
        }

        private void sendShuffleMode(int r3) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
            /*
            r2 = this;
            r0 = r2.mControllerCallbacks;
            r0 = r0.beginBroadcast();
            r0 = r0 + -1;
        L_0x0008:
            if (r0 < 0) goto L_0x0018;
        L_0x000a:
            r1 = r2.mControllerCallbacks;
            r1 = r1.getBroadcastItem(r0);
            r1 = (android.support.v4.media.session.IMediaControllerCallback) r1;
            r1.onShuffleModeChanged(r3);	 Catch:{ RemoteException -> 0x0015 }
        L_0x0015:
            r0 = r0 + -1;
            goto L_0x0008;
        L_0x0018:
            r3 = r2.mControllerCallbacks;
            r3.finishBroadcast();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.sendShuffleMode(int):void");
        }

        private void sendState(android.support.v4.media.session.PlaybackStateCompat r3) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
            /*
            r2 = this;
            r0 = r2.mControllerCallbacks;
            r0 = r0.beginBroadcast();
            r0 = r0 + -1;
        L_0x0008:
            if (r0 < 0) goto L_0x0018;
        L_0x000a:
            r1 = r2.mControllerCallbacks;
            r1 = r1.getBroadcastItem(r0);
            r1 = (android.support.v4.media.session.IMediaControllerCallback) r1;
            r1.onPlaybackStateChanged(r3);	 Catch:{ RemoteException -> 0x0015 }
        L_0x0015:
            r0 = r0 + -1;
            goto L_0x0008;
        L_0x0018:
            r3 = r2.mControllerCallbacks;
            r3.finishBroadcast();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.sendState(android.support.v4.media.session.PlaybackStateCompat):void");
        }

        void adjustVolume(int i, int i2) {
            if (this.mVolumeType == 2) {
                VolumeProviderCompat volumeProviderCompat = this.mVolumeProvider;
                if (volumeProviderCompat != null) {
                    volumeProviderCompat.onAdjustVolume(i);
                    return;
                }
                return;
            }
            this.mAudioManager.adjustStreamVolume(this.mLocalStream, i, i2);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        android.media.RemoteControlClient.MetadataEditor buildRccMetadata(android.os.Bundle r7) {
            /*
            r6 = this;
            r0 = r6.mRcc;
            r1 = 1;
            r0 = r0.editMetadata(r1);
            if (r7 != 0) goto L_0x000a;
        L_0x0009:
            return r0;
        L_0x000a:
            r2 = "android.media.metadata.ART";
            r3 = r7.containsKey(r2);
            r4 = 100;
            r5 = 0;
            if (r3 == 0) goto L_0x0029;
        L_0x0015:
            r2 = r7.getParcelable(r2);
            r2 = (android.graphics.Bitmap) r2;
            if (r2 == 0) goto L_0x0025;
        L_0x001d:
            r3 = r2.getConfig();
            r2 = r2.copy(r3, r5);
        L_0x0025:
            r0.putBitmap(r4, r2);
            goto L_0x003a;
        L_0x0029:
            r2 = "android.media.metadata.ALBUM_ART";
            r3 = r7.containsKey(r2);
            if (r3 == 0) goto L_0x003a;
        L_0x0031:
            r2 = r7.getParcelable(r2);
            r2 = (android.graphics.Bitmap) r2;
            if (r2 == 0) goto L_0x0025;
        L_0x0039:
            goto L_0x001d;
        L_0x003a:
            r2 = "android.media.metadata.ALBUM";
            r3 = r7.containsKey(r2);
            if (r3 == 0) goto L_0x0049;
        L_0x0042:
            r2 = r7.getString(r2);
            r0.putString(r1, r2);
        L_0x0049:
            r1 = "android.media.metadata.ALBUM_ARTIST";
            r2 = r7.containsKey(r1);
            if (r2 == 0) goto L_0x005a;
        L_0x0051:
            r2 = 13;
            r1 = r7.getString(r1);
            r0.putString(r2, r1);
        L_0x005a:
            r1 = "android.media.metadata.ARTIST";
            r2 = r7.containsKey(r1);
            if (r2 == 0) goto L_0x006a;
        L_0x0062:
            r2 = 2;
            r1 = r7.getString(r1);
            r0.putString(r2, r1);
        L_0x006a:
            r1 = "android.media.metadata.AUTHOR";
            r2 = r7.containsKey(r1);
            if (r2 == 0) goto L_0x007a;
        L_0x0072:
            r2 = 3;
            r1 = r7.getString(r1);
            r0.putString(r2, r1);
        L_0x007a:
            r1 = "android.media.metadata.COMPILATION";
            r2 = r7.containsKey(r1);
            if (r2 == 0) goto L_0x008b;
        L_0x0082:
            r2 = 15;
            r1 = r7.getString(r1);
            r0.putString(r2, r1);
        L_0x008b:
            r1 = "android.media.metadata.COMPOSER";
            r2 = r7.containsKey(r1);
            if (r2 == 0) goto L_0x009b;
        L_0x0093:
            r2 = 4;
            r1 = r7.getString(r1);
            r0.putString(r2, r1);
        L_0x009b:
            r1 = "android.media.metadata.DATE";
            r2 = r7.containsKey(r1);
            if (r2 == 0) goto L_0x00ab;
        L_0x00a3:
            r2 = 5;
            r1 = r7.getString(r1);
            r0.putString(r2, r1);
        L_0x00ab:
            r1 = "android.media.metadata.DISC_NUMBER";
            r2 = r7.containsKey(r1);
            if (r2 == 0) goto L_0x00bc;
        L_0x00b3:
            r2 = 14;
            r3 = r7.getLong(r1);
            r0.putLong(r2, r3);
        L_0x00bc:
            r1 = "android.media.metadata.DURATION";
            r2 = r7.containsKey(r1);
            if (r2 == 0) goto L_0x00cd;
        L_0x00c4:
            r2 = 9;
            r3 = r7.getLong(r1);
            r0.putLong(r2, r3);
        L_0x00cd:
            r1 = "android.media.metadata.GENRE";
            r2 = r7.containsKey(r1);
            if (r2 == 0) goto L_0x00dd;
        L_0x00d5:
            r2 = 6;
            r1 = r7.getString(r1);
            r0.putString(r2, r1);
        L_0x00dd:
            r1 = "android.media.metadata.TITLE";
            r1 = r7.containsKey(r1);
            if (r1 == 0) goto L_0x00ef;
        L_0x00e5:
            r1 = 7;
            r2 = "android.media.metadata.TITLE";
            r2 = r7.getString(r2);
            r0.putString(r1, r2);
        L_0x00ef:
            r1 = "android.media.metadata.TRACK_NUMBER";
            r1 = r7.containsKey(r1);
            if (r1 == 0) goto L_0x0100;
        L_0x00f7:
            r1 = "android.media.metadata.TRACK_NUMBER";
            r1 = r7.getLong(r1);
            r0.putLong(r5, r1);
        L_0x0100:
            r1 = "android.media.metadata.WRITER";
            r1 = r7.containsKey(r1);
            if (r1 == 0) goto L_0x0113;
        L_0x0108:
            r1 = 11;
            r2 = "android.media.metadata.WRITER";
            r7 = r7.getString(r2);
            r0.putString(r1, r7);
        L_0x0113:
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.buildRccMetadata(android.os.Bundle):android.media.RemoteControlClient$MetadataEditor");
        }

        public String getCallingPackage() {
            return null;
        }

        public RemoteUserInfo getCurrentControllerInfo() {
            RemoteUserInfo remoteUserInfo;
            synchronized (this.mLock) {
                remoteUserInfo = this.mRemoteUserInfo;
            }
            return remoteUserInfo;
        }

        public Object getMediaSession() {
            return null;
        }

        public PlaybackStateCompat getPlaybackState() {
            PlaybackStateCompat playbackStateCompat;
            synchronized (this.mLock) {
                playbackStateCompat = this.mState;
            }
            return playbackStateCompat;
        }

        int getRccStateFromState(int i) {
            switch (i) {
                case 0:
                    return 0;
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                case 4:
                    return 4;
                case 5:
                    return 5;
                case 6:
                case 8:
                    return 8;
                case 7:
                    return 9;
                case 9:
                    return 7;
                case 10:
                case 11:
                    return 6;
                default:
                    return -1;
            }
        }

        int getRccTransportControlFlagsFromActions(long j) {
            int i = (1 & j) != 0 ? 32 : 0;
            if ((2 & j) != 0) {
                i |= 16;
            }
            if ((4 & j) != 0) {
                i |= 4;
            }
            if ((8 & j) != 0) {
                i |= 2;
            }
            if ((16 & j) != 0) {
                i |= 1;
            }
            if ((32 & j) != 0) {
                i |= 128;
            }
            if ((64 & j) != 0) {
                i |= 64;
            }
            return (j & 512) != 0 ? i | 8 : i;
        }

        public Object getRemoteControlClient() {
            return null;
        }

        public Token getSessionToken() {
            return this.mToken;
        }

        public boolean isActive() {
            return this.mIsActive;
        }

        void postToHandler(int i, int i2, int i3, Object obj, Bundle bundle) {
            synchronized (this.mLock) {
                if (this.mHandler != null) {
                    Message obtainMessage = this.mHandler.obtainMessage(i, i2, i3, obj);
                    Bundle bundle2 = new Bundle();
                    bundle2.putString(MediaSessionCompat.DATA_CALLING_PACKAGE, RemoteUserInfo.LEGACY_CONTROLLER);
                    bundle2.putInt("data_calling_pid", Binder.getCallingPid());
                    bundle2.putInt("data_calling_uid", Binder.getCallingUid());
                    if (bundle != null) {
                        bundle2.putBundle(MediaSessionCompat.DATA_EXTRAS, bundle);
                    }
                    obtainMessage.setData(bundle2);
                    obtainMessage.sendToTarget();
                }
            }
        }

        void registerMediaButtonEventReceiver(PendingIntent pendingIntent, ComponentName componentName) {
            this.mAudioManager.registerMediaButtonEventReceiver(componentName);
        }

        public void release() {
            this.mIsActive = false;
            this.mDestroyed = true;
            update();
            sendSessionDestroyed();
        }

        public void sendSessionEvent(String str, Bundle bundle) {
            sendEvent(str, bundle);
        }

        void sendVolumeInfoChanged(android.support.v4.media.session.ParcelableVolumeInfo r3) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
            /*
            r2 = this;
            r0 = r2.mControllerCallbacks;
            r0 = r0.beginBroadcast();
            r0 = r0 + -1;
        L_0x0008:
            if (r0 < 0) goto L_0x0018;
        L_0x000a:
            r1 = r2.mControllerCallbacks;
            r1 = r1.getBroadcastItem(r0);
            r1 = (android.support.v4.media.session.IMediaControllerCallback) r1;
            r1.onVolumeInfoChanged(r3);	 Catch:{ RemoteException -> 0x0015 }
        L_0x0015:
            r0 = r0 + -1;
            goto L_0x0008;
        L_0x0018:
            r3 = r2.mControllerCallbacks;
            r3.finishBroadcast();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.sendVolumeInfoChanged(android.support.v4.media.session.ParcelableVolumeInfo):void");
        }

        public void setActive(boolean z) {
            if (z != this.mIsActive) {
                this.mIsActive = z;
                if (update()) {
                    setMetadata(this.mMetadata);
                    setPlaybackState(this.mState);
                }
            }
        }

        public void setCallback(Callback callback, Handler handler) {
            this.mCallback = callback;
            if (callback != null) {
                if (handler == null) {
                    handler = new Handler();
                }
                synchronized (this.mLock) {
                    if (this.mHandler != null) {
                        this.mHandler.removeCallbacksAndMessages(null);
                    }
                    this.mHandler = new MessageHandler(handler.getLooper());
                    this.mCallback.setSessionImpl(this, handler);
                }
            }
        }

        public void setCaptioningEnabled(boolean z) {
            if (this.mCaptioningEnabled != z) {
                this.mCaptioningEnabled = z;
                sendCaptioningEnabled(z);
            }
        }

        public void setCurrentControllerInfo(RemoteUserInfo remoteUserInfo) {
            synchronized (this.mLock) {
                this.mRemoteUserInfo = remoteUserInfo;
            }
        }

        public void setExtras(Bundle bundle) {
            this.mExtras = bundle;
            sendExtras(bundle);
        }

        public void setFlags(int i) {
            synchronized (this.mLock) {
                this.mFlags = i;
            }
            update();
        }

        public void setMediaButtonReceiver(PendingIntent pendingIntent) {
        }

        public void setMetadata(MediaMetadataCompat mediaMetadataCompat) {
            if (mediaMetadataCompat != null) {
                mediaMetadataCompat = new Builder(mediaMetadataCompat, MediaSessionCompat.sMaxBitmapSize).build();
            }
            synchronized (this.mLock) {
                this.mMetadata = mediaMetadataCompat;
            }
            sendMetadata(mediaMetadataCompat);
            if (this.mIsActive) {
                buildRccMetadata(mediaMetadataCompat == null ? null : mediaMetadataCompat.getBundle()).apply();
            }
        }

        public void setPlaybackState(PlaybackStateCompat playbackStateCompat) {
            synchronized (this.mLock) {
                this.mState = playbackStateCompat;
            }
            sendState(playbackStateCompat);
            if (this.mIsActive) {
                if (playbackStateCompat == null) {
                    this.mRcc.setPlaybackState(0);
                    this.mRcc.setTransportControlFlags(0);
                } else {
                    setRccState(playbackStateCompat);
                    this.mRcc.setTransportControlFlags(getRccTransportControlFlagsFromActions(playbackStateCompat.getActions()));
                }
            }
        }

        public void setPlaybackToLocal(int i) {
            VolumeProviderCompat volumeProviderCompat = this.mVolumeProvider;
            if (volumeProviderCompat != null) {
                volumeProviderCompat.setCallback(null);
            }
            this.mLocalStream = i;
            this.mVolumeType = 1;
            int i2 = this.mVolumeType;
            int i3 = this.mLocalStream;
            sendVolumeInfoChanged(new ParcelableVolumeInfo(i2, i3, 2, this.mAudioManager.getStreamMaxVolume(i3), this.mAudioManager.getStreamVolume(this.mLocalStream)));
        }

        public void setPlaybackToRemote(VolumeProviderCompat volumeProviderCompat) {
            if (volumeProviderCompat != null) {
                VolumeProviderCompat volumeProviderCompat2 = this.mVolumeProvider;
                if (volumeProviderCompat2 != null) {
                    volumeProviderCompat2.setCallback(null);
                }
                this.mVolumeType = 2;
                this.mVolumeProvider = volumeProviderCompat;
                sendVolumeInfoChanged(new ParcelableVolumeInfo(this.mVolumeType, this.mLocalStream, this.mVolumeProvider.getVolumeControl(), this.mVolumeProvider.getMaxVolume(), this.mVolumeProvider.getCurrentVolume()));
                volumeProviderCompat.setCallback(this.mVolumeCallback);
                return;
            }
            throw new IllegalArgumentException("volumeProvider may not be null");
        }

        public void setQueue(List<QueueItem> list) {
            this.mQueue = list;
            sendQueue(list);
        }

        public void setQueueTitle(CharSequence charSequence) {
            this.mQueueTitle = charSequence;
            sendQueueTitle(charSequence);
        }

        public void setRatingType(int i) {
            this.mRatingType = i;
        }

        void setRccState(PlaybackStateCompat playbackStateCompat) {
            this.mRcc.setPlaybackState(getRccStateFromState(playbackStateCompat.getState()));
        }

        public void setRepeatMode(int i) {
            if (this.mRepeatMode != i) {
                this.mRepeatMode = i;
                sendRepeatMode(i);
            }
        }

        public void setSessionActivity(PendingIntent pendingIntent) {
            synchronized (this.mLock) {
                this.mSessionActivity = pendingIntent;
            }
        }

        public void setShuffleMode(int i) {
            if (this.mShuffleMode != i) {
                this.mShuffleMode = i;
                sendShuffleMode(i);
            }
        }

        void setVolumeTo(int i, int i2) {
            if (this.mVolumeType == 2) {
                VolumeProviderCompat volumeProviderCompat = this.mVolumeProvider;
                if (volumeProviderCompat != null) {
                    volumeProviderCompat.onSetVolumeTo(i);
                    return;
                }
                return;
            }
            this.mAudioManager.setStreamVolume(this.mLocalStream, i, i2);
        }

        void unregisterMediaButtonEventReceiver(PendingIntent pendingIntent, ComponentName componentName) {
            this.mAudioManager.unregisterMediaButtonEventReceiver(componentName);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        boolean update() {
            /*
            r4 = this;
            r0 = r4.mIsActive;
            r1 = 1;
            r2 = 0;
            if (r0 == 0) goto L_0x004a;
        L_0x0006:
            r0 = r4.mIsMbrRegistered;
            if (r0 != 0) goto L_0x0019;
        L_0x000a:
            r0 = r4.mFlags;
            r0 = r0 & r1;
            if (r0 == 0) goto L_0x0019;
        L_0x000f:
            r0 = r4.mMediaButtonReceiverIntent;
            r3 = r4.mMediaButtonReceiverComponentName;
            r4.registerMediaButtonEventReceiver(r0, r3);
            r4.mIsMbrRegistered = r1;
            goto L_0x002b;
        L_0x0019:
            r0 = r4.mIsMbrRegistered;
            if (r0 == 0) goto L_0x002b;
        L_0x001d:
            r0 = r4.mFlags;
            r0 = r0 & r1;
            if (r0 != 0) goto L_0x002b;
        L_0x0022:
            r0 = r4.mMediaButtonReceiverIntent;
            r3 = r4.mMediaButtonReceiverComponentName;
            r4.unregisterMediaButtonEventReceiver(r0, r3);
            r4.mIsMbrRegistered = r2;
        L_0x002b:
            r0 = r4.mIsRccRegistered;
            if (r0 != 0) goto L_0x003f;
        L_0x002f:
            r0 = r4.mFlags;
            r0 = r0 & 2;
            if (r0 == 0) goto L_0x003f;
        L_0x0035:
            r0 = r4.mAudioManager;
            r2 = r4.mRcc;
            r0.registerRemoteControlClient(r2);
            r4.mIsRccRegistered = r1;
            goto L_0x006a;
        L_0x003f:
            r0 = r4.mIsRccRegistered;
            if (r0 == 0) goto L_0x0069;
        L_0x0043:
            r0 = r4.mFlags;
            r0 = r0 & 2;
            if (r0 != 0) goto L_0x0069;
        L_0x0049:
            goto L_0x005b;
        L_0x004a:
            r0 = r4.mIsMbrRegistered;
            if (r0 == 0) goto L_0x0057;
        L_0x004e:
            r0 = r4.mMediaButtonReceiverIntent;
            r1 = r4.mMediaButtonReceiverComponentName;
            r4.unregisterMediaButtonEventReceiver(r0, r1);
            r4.mIsMbrRegistered = r2;
        L_0x0057:
            r0 = r4.mIsRccRegistered;
            if (r0 == 0) goto L_0x0069;
        L_0x005b:
            r0 = r4.mRcc;
            r0.setPlaybackState(r2);
            r0 = r4.mAudioManager;
            r1 = r4.mRcc;
            r0.unregisterRemoteControlClient(r1);
            r4.mIsRccRegistered = r2;
        L_0x0069:
            r1 = 0;
        L_0x006a:
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.update():boolean");
        }
    }

    static class MediaSessionImplApi18 extends MediaSessionImplBase {
        private static boolean sIsMbrPendingIntentSupported = true;

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi18$1 */
        class C01471 implements OnPlaybackPositionUpdateListener {
            C01471() {
            }

            public void onPlaybackPositionUpdate(long j) {
                MediaSessionImplApi18.this.postToHandler(18, -1, -1, Long.valueOf(j), null);
            }
        }

        MediaSessionImplApi18(Context context, String str, ComponentName componentName, PendingIntent pendingIntent) {
            super(context, str, componentName, pendingIntent);
        }

        int getRccTransportControlFlagsFromActions(long j) {
            int rccTransportControlFlagsFromActions = super.getRccTransportControlFlagsFromActions(j);
            return (j & 256) != 0 ? rccTransportControlFlagsFromActions | 256 : rccTransportControlFlagsFromActions;
        }

        void registerMediaButtonEventReceiver(android.app.PendingIntent r3, android.content.ComponentName r4) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
            /*
            r2 = this;
            r0 = sIsMbrPendingIntentSupported;
            if (r0 == 0) goto L_0x0014;
        L_0x0004:
            r0 = r2.mAudioManager;	 Catch:{ NullPointerException -> 0x000a }
            r0.registerMediaButtonEventReceiver(r3);	 Catch:{ NullPointerException -> 0x000a }
            goto L_0x0014;
        L_0x000a:
            r0 = "MediaSessionCompat";
            r1 = "Unable to register media button event receiver with PendingIntent, falling back to ComponentName.";
            android.util.Log.w(r0, r1);
            r0 = 0;
            sIsMbrPendingIntentSupported = r0;
        L_0x0014:
            r0 = sIsMbrPendingIntentSupported;
            if (r0 != 0) goto L_0x001b;
        L_0x0018:
            super.registerMediaButtonEventReceiver(r3, r4);
        L_0x001b:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi18.registerMediaButtonEventReceiver(android.app.PendingIntent, android.content.ComponentName):void");
        }

        public void setCallback(Callback callback, Handler handler) {
            super.setCallback(callback, handler);
            if (callback == null) {
                this.mRcc.setPlaybackPositionUpdateListener(null);
                return;
            }
            this.mRcc.setPlaybackPositionUpdateListener(new C01471());
        }

        void setRccState(PlaybackStateCompat playbackStateCompat) {
            long position = playbackStateCompat.getPosition();
            float playbackSpeed = playbackStateCompat.getPlaybackSpeed();
            long lastPositionUpdateTime = playbackStateCompat.getLastPositionUpdateTime();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (playbackStateCompat.getState() == 3) {
                long j = 0;
                if (position > 0) {
                    if (lastPositionUpdateTime > 0) {
                        j = elapsedRealtime - lastPositionUpdateTime;
                        if (playbackSpeed > 0.0f && playbackSpeed != 1.0f) {
                            j = (long) (((float) j) * playbackSpeed);
                        }
                    }
                    position += j;
                }
            }
            this.mRcc.setPlaybackState(getRccStateFromState(playbackStateCompat.getState()), position, playbackSpeed);
        }

        void unregisterMediaButtonEventReceiver(PendingIntent pendingIntent, ComponentName componentName) {
            if (sIsMbrPendingIntentSupported) {
                this.mAudioManager.unregisterMediaButtonEventReceiver(pendingIntent);
            } else {
                super.unregisterMediaButtonEventReceiver(pendingIntent, componentName);
            }
        }
    }

    static class MediaSessionImplApi28 extends MediaSessionImplApi21 {
        MediaSessionImplApi28(Context context, String str, Bundle bundle) {
            super(context, str, bundle);
        }

        MediaSessionImplApi28(Object obj) {
            super(obj);
        }

        public final RemoteUserInfo getCurrentControllerInfo() {
            return new RemoteUserInfo(((MediaSession) this.mSessionObj).getCurrentControllerInfo());
        }

        public void setCurrentControllerInfo(RemoteUserInfo remoteUserInfo) {
        }
    }

    static class MediaSessionImplApi19 extends MediaSessionImplApi18 {

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi19$1 */
        class C01481 implements OnMetadataUpdateListener {
            C01481() {
            }

            public void onMetadataUpdate(int i, Object obj) {
                if (i == 268435457 && (obj instanceof Rating)) {
                    MediaSessionImplApi19.this.postToHandler(19, -1, -1, RatingCompat.fromRating(obj), null);
                }
            }
        }

        MediaSessionImplApi19(Context context, String str, ComponentName componentName, PendingIntent pendingIntent) {
            super(context, str, componentName, pendingIntent);
        }

        MetadataEditor buildRccMetadata(Bundle bundle) {
            MetadataEditor buildRccMetadata = super.buildRccMetadata(bundle);
            PlaybackStateCompat playbackStateCompat = this.mState;
            if (((playbackStateCompat == null ? 0 : playbackStateCompat.getActions()) & 128) != 0) {
                buildRccMetadata.addEditableKey(268435457);
            }
            if (bundle == null) {
                return buildRccMetadata;
            }
            String str = MediaMetadataCompat.METADATA_KEY_YEAR;
            if (bundle.containsKey(str)) {
                buildRccMetadata.putLong(8, bundle.getLong(str));
            }
            str = MediaMetadataCompat.METADATA_KEY_RATING;
            if (bundle.containsKey(str)) {
                buildRccMetadata.putObject(101, bundle.getParcelable(str));
            }
            str = MediaMetadataCompat.METADATA_KEY_USER_RATING;
            if (bundle.containsKey(str)) {
                buildRccMetadata.putObject(268435457, bundle.getParcelable(str));
            }
            return buildRccMetadata;
        }

        int getRccTransportControlFlagsFromActions(long j) {
            int rccTransportControlFlagsFromActions = super.getRccTransportControlFlagsFromActions(j);
            return (j & 128) != 0 ? rccTransportControlFlagsFromActions | 512 : rccTransportControlFlagsFromActions;
        }

        public void setCallback(Callback callback, Handler handler) {
            super.setCallback(callback, handler);
            if (callback == null) {
                this.mRcc.setMetadataUpdateListener(null);
                return;
            }
            this.mRcc.setMetadataUpdateListener(new C01481());
        }
    }

    private MediaSessionCompat(Context context, MediaSessionImpl mediaSessionImpl) {
        this.mActiveListeners = new ArrayList();
        this.mImpl = mediaSessionImpl;
        if (VERSION.SDK_INT >= 21 && !MediaSessionCompatApi21.hasCallback(mediaSessionImpl.getMediaSession())) {
            setCallback(new C07683());
        }
        this.mController = new MediaControllerCompat(context, this);
    }

    public MediaSessionCompat(Context context, String str) {
        this(context, str, null, null);
    }

    public MediaSessionCompat(Context context, String str, ComponentName componentName, PendingIntent pendingIntent) {
        this(context, str, componentName, pendingIntent, null);
    }

    private MediaSessionCompat(Context context, String str, ComponentName componentName, PendingIntent pendingIntent, Bundle bundle) {
        this.mActiveListeners = new ArrayList();
        if (context == null) {
            throw new IllegalArgumentException("context must not be null");
        } else if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("tag must not be null or empty");
        } else {
            Callback c07661;
            if (componentName == null) {
                componentName = MediaButtonReceiver.getMediaButtonReceiverComponent(context);
                if (componentName == null) {
                    Log.w(TAG, "Couldn't find a unique registered media button receiver in the given context.");
                }
            }
            if (componentName != null && pendingIntent == null) {
                Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
                intent.setComponent(componentName);
                pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
            }
            int i = VERSION.SDK_INT;
            if (i >= 28) {
                this.mImpl = new MediaSessionImplApi28(context, str, bundle);
                c07661 = new C07661();
            } else if (i >= 21) {
                this.mImpl = new MediaSessionImplApi21(context, str, bundle);
                c07661 = new C07672();
            } else {
                MediaSessionImpl mediaSessionImplApi19 = i >= 19 ? new MediaSessionImplApi19(context, str, componentName, pendingIntent) : i >= 18 ? new MediaSessionImplApi18(context, str, componentName, pendingIntent) : new MediaSessionImplBase(context, str, componentName, pendingIntent);
                this.mImpl = mediaSessionImplApi19;
                this.mController = new MediaControllerCompat(context, this);
                if (sMaxBitmapSize == 0) {
                    sMaxBitmapSize = (int) (TypedValue.applyDimension(1, 320.0f, context.getResources().getDisplayMetrics()) + 0.5f);
                }
            }
            setCallback(c07661);
            this.mImpl.setMediaButtonReceiver(pendingIntent);
            this.mController = new MediaControllerCompat(context, this);
            if (sMaxBitmapSize == 0) {
                sMaxBitmapSize = (int) (TypedValue.applyDimension(1, 320.0f, context.getResources().getDisplayMetrics()) + 0.5f);
            }
        }
    }

    public MediaSessionCompat(Context context, String str, Bundle bundle) {
        this(context, str, null, null, bundle);
    }

    public static void ensureClassLoader(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MediaSessionCompat.class.getClassLoader());
        }
    }

    public static MediaSessionCompat fromMediaSession(Context context, Object obj) {
        return (context == null || obj == null || VERSION.SDK_INT < 21) ? null : new MediaSessionCompat(context, new MediaSessionImplApi21(obj));
    }

    static PlaybackStateCompat getStateWithUpdatedPosition(PlaybackStateCompat playbackStateCompat, MediaMetadataCompat mediaMetadataCompat) {
        if (playbackStateCompat == null) {
            return playbackStateCompat;
        }
        long j = -1;
        if (playbackStateCompat.getPosition() == -1) {
            return playbackStateCompat;
        }
        if (playbackStateCompat.getState() != 3 && playbackStateCompat.getState() != 4 && playbackStateCompat.getState() != 5) {
            return playbackStateCompat;
        }
        long lastPositionUpdateTime = playbackStateCompat.getLastPositionUpdateTime();
        if (lastPositionUpdateTime <= 0) {
            return playbackStateCompat;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        lastPositionUpdateTime = ((long) (playbackStateCompat.getPlaybackSpeed() * ((float) (elapsedRealtime - lastPositionUpdateTime)))) + playbackStateCompat.getPosition();
        if (mediaMetadataCompat != null) {
            String str = MediaMetadataCompat.METADATA_KEY_DURATION;
            if (mediaMetadataCompat.containsKey(str)) {
                j = mediaMetadataCompat.getLong(str);
            }
        }
        long j2 = (j < 0 || lastPositionUpdateTime <= j) ? lastPositionUpdateTime < 0 ? 0 : lastPositionUpdateTime : j;
        return new PlaybackStateCompat.Builder(playbackStateCompat).setState(playbackStateCompat.getState(), j2, playbackStateCompat.getPlaybackSpeed(), elapsedRealtime).build();
    }

    public void addOnActiveChangeListener(OnActiveChangeListener onActiveChangeListener) {
        if (onActiveChangeListener != null) {
            this.mActiveListeners.add(onActiveChangeListener);
            return;
        }
        throw new IllegalArgumentException("Listener may not be null");
    }

    public String getCallingPackage() {
        return this.mImpl.getCallingPackage();
    }

    public MediaControllerCompat getController() {
        return this.mController;
    }

    public final RemoteUserInfo getCurrentControllerInfo() {
        return this.mImpl.getCurrentControllerInfo();
    }

    public Object getMediaSession() {
        return this.mImpl.getMediaSession();
    }

    public Object getRemoteControlClient() {
        return this.mImpl.getRemoteControlClient();
    }

    public Token getSessionToken() {
        return this.mImpl.getSessionToken();
    }

    public boolean isActive() {
        return this.mImpl.isActive();
    }

    public void release() {
        this.mImpl.release();
    }

    public void removeOnActiveChangeListener(OnActiveChangeListener onActiveChangeListener) {
        if (onActiveChangeListener != null) {
            this.mActiveListeners.remove(onActiveChangeListener);
            return;
        }
        throw new IllegalArgumentException("Listener may not be null");
    }

    public void sendSessionEvent(String str, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("event cannot be null or empty");
        }
        this.mImpl.sendSessionEvent(str, bundle);
    }

    public void setActive(boolean z) {
        this.mImpl.setActive(z);
        Iterator it = this.mActiveListeners.iterator();
        while (it.hasNext()) {
            ((OnActiveChangeListener) it.next()).onActiveChanged();
        }
    }

    public void setCallback(Callback callback) {
        setCallback(callback, null);
    }

    public void setCallback(Callback callback, Handler handler) {
        if (callback == null) {
            this.mImpl.setCallback(null, null);
            return;
        }
        MediaSessionImpl mediaSessionImpl = this.mImpl;
        if (handler == null) {
            handler = new Handler();
        }
        mediaSessionImpl.setCallback(callback, handler);
    }

    public void setCaptioningEnabled(boolean z) {
        this.mImpl.setCaptioningEnabled(z);
    }

    public void setExtras(Bundle bundle) {
        this.mImpl.setExtras(bundle);
    }

    public void setFlags(int i) {
        this.mImpl.setFlags(i);
    }

    public void setMediaButtonReceiver(PendingIntent pendingIntent) {
        this.mImpl.setMediaButtonReceiver(pendingIntent);
    }

    public void setMetadata(MediaMetadataCompat mediaMetadataCompat) {
        this.mImpl.setMetadata(mediaMetadataCompat);
    }

    public void setPlaybackState(PlaybackStateCompat playbackStateCompat) {
        this.mImpl.setPlaybackState(playbackStateCompat);
    }

    public void setPlaybackToLocal(int i) {
        this.mImpl.setPlaybackToLocal(i);
    }

    public void setPlaybackToRemote(VolumeProviderCompat volumeProviderCompat) {
        if (volumeProviderCompat != null) {
            this.mImpl.setPlaybackToRemote(volumeProviderCompat);
            return;
        }
        throw new IllegalArgumentException("volumeProvider may not be null!");
    }

    public void setQueue(List<QueueItem> list) {
        this.mImpl.setQueue(list);
    }

    public void setQueueTitle(CharSequence charSequence) {
        this.mImpl.setQueueTitle(charSequence);
    }

    public void setRatingType(int i) {
        this.mImpl.setRatingType(i);
    }

    public void setRepeatMode(int i) {
        this.mImpl.setRepeatMode(i);
    }

    public void setSessionActivity(PendingIntent pendingIntent) {
        this.mImpl.setSessionActivity(pendingIntent);
    }

    public void setShuffleMode(int i) {
        this.mImpl.setShuffleMode(i);
    }
}
