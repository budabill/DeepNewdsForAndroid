package android.support.v4.content;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

abstract class ModernAsyncTask<Params, Progress, Result> {
    private static final int CORE_POOL_SIZE = 5;
    private static final int KEEP_ALIVE = 1;
    private static final String LOG_TAG = "AsyncTask";
    private static final int MAXIMUM_POOL_SIZE = 128;
    private static final int MESSAGE_POST_PROGRESS = 2;
    private static final int MESSAGE_POST_RESULT = 1;
    public static final Executor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory);
    private static volatile Executor sDefaultExecutor = THREAD_POOL_EXECUTOR;
    private static InternalHandler sHandler;
    private static final BlockingQueue<Runnable> sPoolWorkQueue = new LinkedBlockingQueue(10);
    private static final ThreadFactory sThreadFactory = new C01041();
    final AtomicBoolean mCancelled = new AtomicBoolean();
    private final FutureTask<Result> mFuture = new FutureTask<Result>(this.mWorker) {
        protected void done() {
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
            r3 = this;
            r0 = "An error occurred while executing doInBackground()";
            r1 = r3.get();	 Catch:{ InterruptedException -> 0x0025, ExecutionException -> 0x001a, CancellationException -> 0x0013, Throwable -> 0x000c }
            r2 = android.support.v4.content.ModernAsyncTask.this;	 Catch:{ InterruptedException -> 0x0025, ExecutionException -> 0x001a, CancellationException -> 0x0013, Throwable -> 0x000c }
            r2.postResultIfNotInvoked(r1);	 Catch:{ InterruptedException -> 0x0025, ExecutionException -> 0x001a, CancellationException -> 0x0013, Throwable -> 0x000c }
            goto L_0x002b;
        L_0x000c:
            r1 = move-exception;
            r2 = new java.lang.RuntimeException;
            r2.<init>(r0, r1);
            throw r2;
        L_0x0013:
            r0 = android.support.v4.content.ModernAsyncTask.this;
            r1 = 0;
            r0.postResultIfNotInvoked(r1);
            goto L_0x002b;
        L_0x001a:
            r1 = move-exception;
            r2 = new java.lang.RuntimeException;
            r1 = r1.getCause();
            r2.<init>(r0, r1);
            throw r2;
        L_0x0025:
            r0 = move-exception;
            r1 = "AsyncTask";
            android.util.Log.w(r1, r0);
        L_0x002b:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.content.ModernAsyncTask.3.done():void");
        }
    };
    private volatile Status mStatus = Status.PENDING;
    final AtomicBoolean mTaskInvoked = new AtomicBoolean();
    private final WorkerRunnable<Params, Result> mWorker = new C07552();

    /* renamed from: android.support.v4.content.ModernAsyncTask$1 */
    static class C01041 implements ThreadFactory {
        private final AtomicInteger mCount = new AtomicInteger(1);

        C01041() {
        }

        public Thread newThread(Runnable runnable) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ModernAsyncTask #");
            stringBuilder.append(this.mCount.getAndIncrement());
            return new Thread(runnable, stringBuilder.toString());
        }
    }

    /* renamed from: android.support.v4.content.ModernAsyncTask$4 */
    static /* synthetic */ class C01064 {
        static final /* synthetic */ int[] $SwitchMap$androidx$loader$content$ModernAsyncTask$Status = new int[Status.values().length];

        static {
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
            r0 = android.support.v4.content.ModernAsyncTask.Status.values();
            r0 = r0.length;
            r0 = new int[r0];
            $SwitchMap$androidx$loader$content$ModernAsyncTask$Status = r0;
            r0 = $SwitchMap$androidx$loader$content$ModernAsyncTask$Status;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = android.support.v4.content.ModernAsyncTask.Status.RUNNING;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r0 = $SwitchMap$androidx$loader$content$ModernAsyncTask$Status;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = android.support.v4.content.ModernAsyncTask.Status.FINISHED;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2;	 Catch:{ NoSuchFieldError -> 0x001f }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.content.ModernAsyncTask.4.<clinit>():void");
        }
    }

    private static class AsyncTaskResult<Data> {
        final Data[] mData;
        final ModernAsyncTask mTask;

        AsyncTaskResult(ModernAsyncTask modernAsyncTask, Data... dataArr) {
            this.mTask = modernAsyncTask;
            this.mData = dataArr;
        }
    }

    private static class InternalHandler extends Handler {
        InternalHandler() {
            super(Looper.getMainLooper());
        }

        public void handleMessage(Message message) {
            AsyncTaskResult asyncTaskResult = (AsyncTaskResult) message.obj;
            int i = message.what;
            if (i == 1) {
                asyncTaskResult.mTask.finish(asyncTaskResult.mData[0]);
            } else if (i == 2) {
                asyncTaskResult.mTask.onProgressUpdate(asyncTaskResult.mData);
            }
        }
    }

    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    private static abstract class WorkerRunnable<Params, Result> implements Callable<Result> {
        Params[] mParams;

        WorkerRunnable() {
        }
    }

    /* renamed from: android.support.v4.content.ModernAsyncTask$2 */
    class C07552 extends WorkerRunnable<Params, Result> {
        C07552() {
        }

        public Result call() {
            ModernAsyncTask.this.mTaskInvoked.set(true);
            Object obj = null;
            try {
                Process.setThreadPriority(10);
                obj = ModernAsyncTask.this.doInBackground(this.mParams);
                Binder.flushPendingCommands();
                ModernAsyncTask.this.postResult(obj);
                return obj;
            } catch (Throwable th) {
                ModernAsyncTask.this.postResult(obj);
            }
        }
    }

    ModernAsyncTask() {
    }

    public static void execute(Runnable runnable) {
        sDefaultExecutor.execute(runnable);
    }

    private static Handler getHandler() {
        Handler handler;
        synchronized (ModernAsyncTask.class) {
            if (sHandler == null) {
                sHandler = new InternalHandler();
            }
            handler = sHandler;
        }
        return handler;
    }

    public static void setDefaultExecutor(Executor executor) {
        sDefaultExecutor = executor;
    }

    public final boolean cancel(boolean z) {
        this.mCancelled.set(true);
        return this.mFuture.cancel(z);
    }

    protected abstract Result doInBackground(Params... paramsArr);

    public final ModernAsyncTask<Params, Progress, Result> execute(Params... paramsArr) {
        return executeOnExecutor(sDefaultExecutor, paramsArr);
    }

    public final ModernAsyncTask<Params, Progress, Result> executeOnExecutor(Executor executor, Params... paramsArr) {
        if (this.mStatus != Status.PENDING) {
            int i = C01064.$SwitchMap$androidx$loader$content$ModernAsyncTask$Status[this.mStatus.ordinal()];
            if (i == 1) {
                throw new IllegalStateException("Cannot execute task: the task is already running.");
            } else if (i != 2) {
                throw new IllegalStateException("We should never reach this state");
            } else {
                throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.mStatus = Status.RUNNING;
        onPreExecute();
        this.mWorker.mParams = paramsArr;
        executor.execute(this.mFuture);
        return this;
    }

    void finish(Result result) {
        if (isCancelled()) {
            onCancelled(result);
        } else {
            onPostExecute(result);
        }
        this.mStatus = Status.FINISHED;
    }

    public final Result get() {
        return this.mFuture.get();
    }

    public final Result get(long j, TimeUnit timeUnit) {
        return this.mFuture.get(j, timeUnit);
    }

    public final Status getStatus() {
        return this.mStatus;
    }

    public final boolean isCancelled() {
        return this.mCancelled.get();
    }

    protected void onCancelled() {
    }

    protected void onCancelled(Result result) {
        onCancelled();
    }

    protected void onPostExecute(Result result) {
    }

    protected void onPreExecute() {
    }

    protected void onProgressUpdate(Progress... progressArr) {
    }

    Result postResult(Result result) {
        getHandler().obtainMessage(1, new AsyncTaskResult(this, result)).sendToTarget();
        return result;
    }

    void postResultIfNotInvoked(Result result) {
        if (!this.mTaskInvoked.get()) {
            postResult(result);
        }
    }

    protected final void publishProgress(Progress... progressArr) {
        if (!isCancelled()) {
            getHandler().obtainMessage(2, new AsyncTaskResult(this, progressArr)).sendToTarget();
        }
    }
}
