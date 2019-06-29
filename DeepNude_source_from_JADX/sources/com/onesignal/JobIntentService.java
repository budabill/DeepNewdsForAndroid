package com.onesignal;

import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobInfo.Builder;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import java.util.ArrayList;
import java.util.HashMap;

abstract class JobIntentService extends Service {
    /* renamed from: a */
    static final Object f1137a = new Object();
    /* renamed from: b */
    static final HashMap<ComponentName, WorkEnqueuer> f1138b = new HashMap();
    /* renamed from: c */
    CompatJobEngine f1139c;
    /* renamed from: d */
    WorkEnqueuer f1140d;
    /* renamed from: e */
    CommandProcessor f1141e;
    /* renamed from: f */
    boolean f1142f = false;
    /* renamed from: g */
    boolean f1143g = false;
    /* renamed from: h */
    final ArrayList<CompatWorkItem> f1144h;

    final class CommandProcessor extends AsyncTask<Void, Void, Void> {
        CommandProcessor() {
        }

        protected Void doInBackground(Void... voidArr) {
            while (true) {
                GenericWorkItem a = JobIntentService.this.m1377a();
                if (a == null) {
                    return null;
                }
                JobIntentService.this.mo1364a(a.getIntent());
                a.complete();
            }
        }

        protected void onCancelled(Void voidR) {
            JobIntentService.this.m1382e();
        }

        protected void onPostExecute(Void voidR) {
            JobIntentService.this.m1382e();
        }
    }

    interface CompatJobEngine {
        IBinder compatGetBinder();

        GenericWorkItem dequeueWork();
    }

    interface GenericWorkItem {
        void complete();

        Intent getIntent();
    }

    static abstract class WorkEnqueuer {
        final ComponentName mComponentName;
        boolean mHasJobId;
        int mJobId;

        WorkEnqueuer(Context context, ComponentName componentName) {
            this.mComponentName = componentName;
        }

        abstract void enqueueWork(Intent intent);

        void ensureJobId(int i) {
            if (!this.mHasJobId) {
                this.mHasJobId = true;
                this.mJobId = i;
            } else if (this.mJobId != i) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Given job ID ");
                stringBuilder.append(i);
                stringBuilder.append(" is different than previous ");
                stringBuilder.append(this.mJobId);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }

        public void serviceCreated() {
        }

        public void serviceDestroyed() {
        }

        public void serviceStartReceived() {
        }
    }

    static final class CompatWorkEnqueuer extends WorkEnqueuer {
        private final Context mContext;
        private final WakeLock mLaunchWakeLock;
        boolean mLaunchingService;
        private final WakeLock mRunWakeLock;
        boolean mServiceRunning;

        CompatWorkEnqueuer(Context context, ComponentName componentName) {
            super(context, componentName);
            this.mContext = context.getApplicationContext();
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(componentName.getClassName());
            stringBuilder.append(":launch");
            this.mLaunchWakeLock = powerManager.newWakeLock(1, stringBuilder.toString());
            this.mLaunchWakeLock.setReferenceCounted(false);
            stringBuilder = new StringBuilder();
            stringBuilder.append(componentName.getClassName());
            stringBuilder.append(":run");
            this.mRunWakeLock = powerManager.newWakeLock(1, stringBuilder.toString());
            this.mRunWakeLock.setReferenceCounted(false);
        }

        void enqueueWork(Intent intent) {
            Intent intent2 = new Intent(intent);
            intent2.setComponent(this.mComponentName);
            if (this.mContext.startService(intent2) != null) {
                synchronized (this) {
                    if (!this.mLaunchingService) {
                        this.mLaunchingService = true;
                        if (!this.mServiceRunning) {
                            this.mLaunchWakeLock.acquire(60000);
                        }
                    }
                }
            }
        }

        public void serviceCreated() {
            synchronized (this) {
                if (!this.mServiceRunning) {
                    this.mServiceRunning = true;
                    this.mRunWakeLock.acquire();
                    this.mLaunchWakeLock.release();
                }
            }
        }

        public void serviceDestroyed() {
            synchronized (this) {
                if (this.mLaunchingService) {
                    this.mLaunchWakeLock.acquire(60000);
                }
                this.mServiceRunning = false;
                this.mRunWakeLock.release();
            }
        }

        public void serviceStartReceived() {
            synchronized (this) {
                this.mLaunchingService = false;
            }
        }
    }

    final class CompatWorkItem implements GenericWorkItem {
        final Intent mIntent;
        final int mStartId;

        CompatWorkItem(Intent intent, int i) {
            this.mIntent = intent;
            this.mStartId = i;
        }

        public void complete() {
            JobIntentService.this.stopSelf(this.mStartId);
        }

        public Intent getIntent() {
            return this.mIntent;
        }
    }

    static final class JobServiceEngineImpl extends JobServiceEngine implements CompatJobEngine {
        static final boolean DEBUG = false;
        static final String TAG = "JobServiceEngineImpl";
        final Object mLock = new Object();
        JobParameters mParams;
        final JobIntentService mService;

        final class WrapperWorkItem implements GenericWorkItem {
            final JobWorkItem mJobWork;

            WrapperWorkItem(JobWorkItem jobWorkItem) {
                this.mJobWork = jobWorkItem;
            }

            public void complete() {
                synchronized (JobServiceEngineImpl.this.mLock) {
                    if (JobServiceEngineImpl.this.mParams != null) {
                        JobServiceEngineImpl.this.mParams.completeWork(this.mJobWork);
                    }
                }
            }

            public Intent getIntent() {
                return this.mJobWork.getIntent();
            }
        }

        JobServiceEngineImpl(JobIntentService jobIntentService) {
            super(jobIntentService);
            this.mService = jobIntentService;
        }

        public IBinder compatGetBinder() {
            return getBinder();
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.onesignal.JobIntentService.GenericWorkItem dequeueWork() {
            /*
            r3 = this;
            r0 = r3.mLock;
            monitor-enter(r0);
            r1 = r3.mParams;	 Catch:{ all -> 0x0027 }
            r2 = 0;
            if (r1 != 0) goto L_0x000a;
        L_0x0008:
            monitor-exit(r0);	 Catch:{ all -> 0x0027 }
            return r2;
        L_0x000a:
            r1 = r3.mParams;	 Catch:{ all -> 0x0027 }
            r1 = r1.dequeueWork();	 Catch:{ all -> 0x0027 }
            monitor-exit(r0);	 Catch:{ all -> 0x0027 }
            if (r1 == 0) goto L_0x0026;
        L_0x0013:
            r0 = r1.getIntent();
            r2 = r3.mService;
            r2 = r2.getClassLoader();
            r0.setExtrasClassLoader(r2);
            r0 = new com.onesignal.JobIntentService$JobServiceEngineImpl$WrapperWorkItem;
            r0.<init>(r1);
            return r0;
        L_0x0026:
            return r2;
        L_0x0027:
            r1 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x0027 }
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.onesignal.JobIntentService.JobServiceEngineImpl.dequeueWork():com.onesignal.JobIntentService$GenericWorkItem");
        }

        public boolean onStartJob(JobParameters jobParameters) {
            this.mParams = jobParameters;
            this.mService.m1380c();
            return true;
        }

        public boolean onStopJob(JobParameters jobParameters) {
            boolean b = this.mService.m1379b();
            synchronized (this.mLock) {
                this.mParams = null;
            }
            return b;
        }
    }

    static final class JobWorkEnqueuer extends WorkEnqueuer {
        private final JobInfo mJobInfo;
        private final JobScheduler mJobScheduler;

        JobWorkEnqueuer(Context context, ComponentName componentName, int i) {
            super(context, componentName);
            ensureJobId(i);
            this.mJobInfo = new Builder(i, this.mComponentName).setOverrideDeadline(0).build();
            this.mJobScheduler = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
        }

        void enqueueWork(Intent intent) {
            this.mJobScheduler.enqueue(this.mJobInfo, new JobWorkItem(intent));
        }
    }

    public JobIntentService() {
        this.f1144h = VERSION.SDK_INT >= 26 ? null : new ArrayList();
    }

    /* renamed from: a */
    static WorkEnqueuer m1375a(Context context, ComponentName componentName, boolean z, int i) {
        WorkEnqueuer workEnqueuer = (WorkEnqueuer) f1138b.get(componentName);
        if (workEnqueuer != null) {
            return workEnqueuer;
        }
        WorkEnqueuer compatWorkEnqueuer;
        if (VERSION.SDK_INT < 26) {
            compatWorkEnqueuer = new CompatWorkEnqueuer(context, componentName);
        } else if (z) {
            compatWorkEnqueuer = new JobWorkEnqueuer(context, componentName, i);
        } else {
            throw new IllegalArgumentException("Can't be here without a job id");
        }
        workEnqueuer = compatWorkEnqueuer;
        f1138b.put(componentName, workEnqueuer);
        return workEnqueuer;
    }

    /* renamed from: a */
    public static void m1376a(Context context, ComponentName componentName, int i, Intent intent) {
        if (intent != null) {
            synchronized (f1137a) {
                WorkEnqueuer a = m1375a(context, componentName, true, i);
                a.ensureJobId(i);
                a.enqueueWork(intent);
            }
            return;
        }
        throw new IllegalArgumentException("work must not be null");
    }

    /* renamed from: a */
    GenericWorkItem m1377a() {
        CompatJobEngine compatJobEngine = this.f1139c;
        if (compatJobEngine != null) {
            return compatJobEngine.dequeueWork();
        }
        synchronized (this.f1144h) {
            if (this.f1144h.size() > 0) {
                GenericWorkItem genericWorkItem = (GenericWorkItem) this.f1144h.remove(0);
                return genericWorkItem;
            }
            return null;
        }
    }

    /* renamed from: a */
    protected abstract void mo1364a(Intent intent);

    /* renamed from: b */
    boolean m1379b() {
        AsyncTask asyncTask = this.f1141e;
        if (asyncTask != null) {
            asyncTask.cancel(this.f1142f);
        }
        this.f1143g = true;
        return mo1365d();
    }

    /* renamed from: c */
    void m1380c() {
        if (this.f1141e == null) {
            this.f1141e = new CommandProcessor();
            this.f1141e.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    /* renamed from: d */
    public boolean mo1365d() {
        return true;
    }

    /* renamed from: e */
    void m1382e() {
        ArrayList arrayList = this.f1144h;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f1141e = null;
                if (this.f1144h != null && this.f1144h.size() > 0) {
                    m1380c();
                }
            }
        }
    }

    public IBinder onBind(Intent intent) {
        CompatJobEngine compatJobEngine = this.f1139c;
        return compatJobEngine != null ? compatJobEngine.compatGetBinder() : null;
    }

    public void onCreate() {
        super.onCreate();
        if (VERSION.SDK_INT >= 26) {
            this.f1139c = new JobServiceEngineImpl(this);
            this.f1140d = null;
            return;
        }
        this.f1139c = null;
        this.f1140d = m1375a((Context) this, new ComponentName(this, getClass()), false, 0);
        this.f1140d.serviceCreated();
    }

    public void onDestroy() {
        super.onDestroy();
        WorkEnqueuer workEnqueuer = this.f1140d;
        if (workEnqueuer != null) {
            workEnqueuer.serviceDestroyed();
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (this.f1144h == null) {
            return 2;
        }
        this.f1140d.serviceStartReceived();
        synchronized (this.f1144h) {
            ArrayList arrayList = this.f1144h;
            if (intent == null) {
                intent = new Intent();
            }
            arrayList.add(new CompatWorkItem(intent, i2));
            m1380c();
        }
        return 3;
    }
}
