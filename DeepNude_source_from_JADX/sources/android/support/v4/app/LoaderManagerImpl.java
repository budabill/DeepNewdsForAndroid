package android.support.v4.app;

import android.arch.lifecycle.C0060f;
import android.arch.lifecycle.C0066n;
import android.arch.lifecycle.C0070q;
import android.arch.lifecycle.C0072r;
import android.arch.lifecycle.C0072r.C0071a;
import android.arch.lifecycle.C0073s;
import android.arch.lifecycle.C0749m;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.support.v4.content.Loader.OnLoadCompleteListener;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.SparseArrayCompat;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

class LoaderManagerImpl extends LoaderManager {
    static boolean DEBUG = false;
    static final String TAG = "LoaderManager";
    private final C0060f mLifecycleOwner;
    private final LoaderViewModel mLoaderViewModel;

    static class LoaderObserver<D> implements C0066n<D> {
        private final LoaderCallbacks<D> mCallback;
        private boolean mDeliveredData = false;
        private final Loader<D> mLoader;

        LoaderObserver(Loader<D> loader, LoaderCallbacks<D> loaderCallbacks) {
            this.mLoader = loader;
            this.mCallback = loaderCallbacks;
        }

        public void dump(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.mDeliveredData);
        }

        boolean hasDeliveredData() {
            return this.mDeliveredData;
        }

        public void onChanged(D d) {
            if (LoaderManagerImpl.DEBUG) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("  onLoadFinished in ");
                stringBuilder.append(this.mLoader);
                stringBuilder.append(": ");
                stringBuilder.append(this.mLoader.dataToString(d));
                Log.v(LoaderManagerImpl.TAG, stringBuilder.toString());
            }
            this.mCallback.onLoadFinished(this.mLoader, d);
            this.mDeliveredData = true;
        }

        void reset() {
            if (this.mDeliveredData) {
                if (LoaderManagerImpl.DEBUG) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("  Resetting: ");
                    stringBuilder.append(this.mLoader);
                    Log.v(LoaderManagerImpl.TAG, stringBuilder.toString());
                }
                this.mCallback.onLoaderReset(this.mLoader);
            }
        }

        public String toString() {
            return this.mCallback.toString();
        }
    }

    static class LoaderViewModel extends C0070q {
        private static final C0071a FACTORY = new C07541();
        private boolean mCreatingLoader = false;
        private SparseArrayCompat<LoaderInfo> mLoaders = new SparseArrayCompat();

        /* renamed from: android.support.v4.app.LoaderManagerImpl$LoaderViewModel$1 */
        static class C07541 implements C0071a {
            C07541() {
            }

            public <T extends C0070q> T create(Class<T> cls) {
                return new LoaderViewModel();
            }
        }

        LoaderViewModel() {
        }

        static LoaderViewModel getInstance(C0073s c0073s) {
            return (LoaderViewModel) new C0072r(c0073s, FACTORY).m111a(LoaderViewModel.class);
        }

        public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.mLoaders.size() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append("    ");
                String stringBuilder2 = stringBuilder.toString();
                for (int i = 0; i < this.mLoaders.size(); i++) {
                    LoaderInfo loaderInfo = (LoaderInfo) this.mLoaders.valueAt(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.mLoaders.keyAt(i));
                    printWriter.print(": ");
                    printWriter.println(loaderInfo.toString());
                    loaderInfo.dump(stringBuilder2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        void finishCreatingLoader() {
            this.mCreatingLoader = false;
        }

        <D> LoaderInfo<D> getLoader(int i) {
            return (LoaderInfo) this.mLoaders.get(i);
        }

        boolean hasRunningLoaders() {
            int size = this.mLoaders.size();
            for (int i = 0; i < size; i++) {
                if (((LoaderInfo) this.mLoaders.valueAt(i)).isCallbackWaitingForData()) {
                    return true;
                }
            }
            return false;
        }

        boolean isCreatingLoader() {
            return this.mCreatingLoader;
        }

        void markForRedelivery() {
            int size = this.mLoaders.size();
            for (int i = 0; i < size; i++) {
                ((LoaderInfo) this.mLoaders.valueAt(i)).markForRedelivery();
            }
        }

        protected void onCleared() {
            super.onCleared();
            int size = this.mLoaders.size();
            for (int i = 0; i < size; i++) {
                ((LoaderInfo) this.mLoaders.valueAt(i)).destroy(true);
            }
            this.mLoaders.clear();
        }

        void putLoader(int i, LoaderInfo loaderInfo) {
            this.mLoaders.put(i, loaderInfo);
        }

        void removeLoader(int i) {
            this.mLoaders.remove(i);
        }

        void startCreatingLoader() {
            this.mCreatingLoader = true;
        }
    }

    public static class LoaderInfo<D> extends C0749m<D> implements OnLoadCompleteListener<D> {
        private final Bundle mArgs;
        private final int mId;
        private C0060f mLifecycleOwner;
        private final Loader<D> mLoader;
        private LoaderObserver<D> mObserver;
        private Loader<D> mPriorLoader;

        LoaderInfo(int i, Bundle bundle, Loader<D> loader, Loader<D> loader2) {
            this.mId = i;
            this.mArgs = bundle;
            this.mLoader = loader;
            this.mPriorLoader = loader2;
            this.mLoader.registerListener(i, this);
        }

        Loader<D> destroy(boolean z) {
            if (LoaderManagerImpl.DEBUG) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("  Destroying: ");
                stringBuilder.append(this);
                Log.v(LoaderManagerImpl.TAG, stringBuilder.toString());
            }
            this.mLoader.cancelLoad();
            this.mLoader.abandon();
            LoaderObserver loaderObserver = this.mObserver;
            if (loaderObserver != null) {
                removeObserver(loaderObserver);
                if (z) {
                    loaderObserver.reset();
                }
            }
            this.mLoader.unregisterListener(this);
            if ((loaderObserver == null || loaderObserver.hasDeliveredData()) && !z) {
                return this.mLoader;
            }
            this.mLoader.reset();
            return this.mPriorLoader;
        }

        public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.mId);
            printWriter.print(" mArgs=");
            printWriter.println(this.mArgs);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.mLoader);
            Loader loader = this.mLoader;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            String str2 = "  ";
            stringBuilder.append(str2);
            loader.dump(stringBuilder.toString(), fileDescriptor, printWriter, strArr);
            if (this.mObserver != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.mObserver);
                LoaderObserver loaderObserver = this.mObserver;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(str);
                stringBuilder2.append(str2);
                loaderObserver.dump(stringBuilder2.toString(), printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(getLoader().dataToString(getValue()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(hasActiveObservers());
        }

        Loader<D> getLoader() {
            return this.mLoader;
        }

        boolean isCallbackWaitingForData() {
            boolean z = false;
            if (!hasActiveObservers()) {
                return false;
            }
            LoaderObserver loaderObserver = this.mObserver;
            if (!(loaderObserver == null || loaderObserver.hasDeliveredData())) {
                z = true;
            }
            return z;
        }

        void markForRedelivery() {
            C0060f c0060f = this.mLifecycleOwner;
            C0066n c0066n = this.mObserver;
            if (c0060f != null && c0066n != null) {
                super.removeObserver(c0066n);
                observe(c0060f, c0066n);
            }
        }

        protected void onActive() {
            if (LoaderManagerImpl.DEBUG) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("  Starting: ");
                stringBuilder.append(this);
                Log.v(LoaderManagerImpl.TAG, stringBuilder.toString());
            }
            this.mLoader.startLoading();
        }

        protected void onInactive() {
            if (LoaderManagerImpl.DEBUG) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("  Stopping: ");
                stringBuilder.append(this);
                Log.v(LoaderManagerImpl.TAG, stringBuilder.toString());
            }
            this.mLoader.stopLoading();
        }

        public void onLoadComplete(Loader<D> loader, D d) {
            boolean z = LoaderManagerImpl.DEBUG;
            String str = LoaderManagerImpl.TAG;
            if (z) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onLoadComplete: ");
                stringBuilder.append(this);
                Log.v(str, stringBuilder.toString());
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                setValue(d);
                return;
            }
            if (LoaderManagerImpl.DEBUG) {
                Log.w(str, "onLoadComplete was incorrectly called on a background thread");
            }
            postValue(d);
        }

        public void removeObserver(C0066n<? super D> c0066n) {
            super.removeObserver(c0066n);
            this.mLifecycleOwner = null;
            this.mObserver = null;
        }

        Loader<D> setCallback(C0060f c0060f, LoaderCallbacks<D> loaderCallbacks) {
            Object loaderObserver = new LoaderObserver(this.mLoader, loaderCallbacks);
            observe(c0060f, loaderObserver);
            C0066n c0066n = this.mObserver;
            if (c0066n != null) {
                removeObserver(c0066n);
            }
            this.mLifecycleOwner = c0060f;
            this.mObserver = loaderObserver;
            return this.mLoader;
        }

        public void setValue(D d) {
            super.setValue(d);
            Loader loader = this.mPriorLoader;
            if (loader != null) {
                loader.reset();
                this.mPriorLoader = null;
            }
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(64);
            stringBuilder.append("LoaderInfo{");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append(" #");
            stringBuilder.append(this.mId);
            stringBuilder.append(" : ");
            DebugUtils.buildShortClassTag(this.mLoader, stringBuilder);
            stringBuilder.append("}}");
            return stringBuilder.toString();
        }
    }

    LoaderManagerImpl(C0060f c0060f, C0073s c0073s) {
        this.mLifecycleOwner = c0060f;
        this.mLoaderViewModel = LoaderViewModel.getInstance(c0073s);
    }

    private <D> Loader<D> createAndInstallLoader(int i, Bundle bundle, LoaderCallbacks<D> loaderCallbacks, Loader<D> loader) {
        try {
            this.mLoaderViewModel.startCreatingLoader();
            Loader onCreateLoader = loaderCallbacks.onCreateLoader(i, bundle);
            if (onCreateLoader != null) {
                if (onCreateLoader.getClass().isMemberClass()) {
                    if (!Modifier.isStatic(onCreateLoader.getClass().getModifiers())) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Object returned from onCreateLoader must not be a non-static inner member class: ");
                        stringBuilder.append(onCreateLoader);
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                }
                LoaderInfo loaderInfo = new LoaderInfo(i, bundle, onCreateLoader, loader);
                if (DEBUG) {
                    String str = TAG;
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("  Created new loader ");
                    stringBuilder2.append(loaderInfo);
                    Log.v(str, stringBuilder2.toString());
                }
                this.mLoaderViewModel.putLoader(i, loaderInfo);
                return loaderInfo.setCallback(this.mLifecycleOwner, loaderCallbacks);
            }
            throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
        } finally {
            this.mLoaderViewModel.finishCreatingLoader();
        }
    }

    public void destroyLoader(int i) {
        if (this.mLoaderViewModel.isCreatingLoader()) {
            throw new IllegalStateException("Called while creating a loader");
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            if (DEBUG) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("destroyLoader in ");
                stringBuilder.append(this);
                stringBuilder.append(" of ");
                stringBuilder.append(i);
                Log.v(TAG, stringBuilder.toString());
            }
            LoaderInfo loader = this.mLoaderViewModel.getLoader(i);
            if (loader != null) {
                loader.destroy(true);
                this.mLoaderViewModel.removeLoader(i);
            }
        } else {
            throw new IllegalStateException("destroyLoader must be called on the main thread");
        }
    }

    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.mLoaderViewModel.dump(str, fileDescriptor, printWriter, strArr);
    }

    public <D> Loader<D> getLoader(int i) {
        if (this.mLoaderViewModel.isCreatingLoader()) {
            throw new IllegalStateException("Called while creating a loader");
        }
        LoaderInfo loader = this.mLoaderViewModel.getLoader(i);
        return loader != null ? loader.getLoader() : null;
    }

    public boolean hasRunningLoaders() {
        return this.mLoaderViewModel.hasRunningLoaders();
    }

    public <D> Loader<D> initLoader(int i, Bundle bundle, LoaderCallbacks<D> loaderCallbacks) {
        if (this.mLoaderViewModel.isCreatingLoader()) {
            throw new IllegalStateException("Called while creating a loader");
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            LoaderInfo loader = this.mLoaderViewModel.getLoader(i);
            boolean z = DEBUG;
            String str = TAG;
            if (z) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("initLoader in ");
                stringBuilder.append(this);
                stringBuilder.append(": args=");
                stringBuilder.append(bundle);
                Log.v(str, stringBuilder.toString());
            }
            if (loader == null) {
                return createAndInstallLoader(i, bundle, loaderCallbacks, null);
            }
            if (DEBUG) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("  Re-using existing loader ");
                stringBuilder2.append(loader);
                Log.v(str, stringBuilder2.toString());
            }
            return loader.setCallback(this.mLifecycleOwner, loaderCallbacks);
        } else {
            throw new IllegalStateException("initLoader must be called on the main thread");
        }
    }

    public void markForRedelivery() {
        this.mLoaderViewModel.markForRedelivery();
    }

    public <D> Loader<D> restartLoader(int i, Bundle bundle, LoaderCallbacks<D> loaderCallbacks) {
        if (this.mLoaderViewModel.isCreatingLoader()) {
            throw new IllegalStateException("Called while creating a loader");
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            if (DEBUG) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("restartLoader in ");
                stringBuilder.append(this);
                stringBuilder.append(": args=");
                stringBuilder.append(bundle);
                Log.v(TAG, stringBuilder.toString());
            }
            LoaderInfo loader = this.mLoaderViewModel.getLoader(i);
            Loader loader2 = null;
            if (loader != null) {
                loader2 = loader.destroy(false);
            }
            return createAndInstallLoader(i, bundle, loaderCallbacks, loader2);
        } else {
            throw new IllegalStateException("restartLoader must be called on the main thread");
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("LoaderManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        DebugUtils.buildShortClassTag(this.mLifecycleOwner, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }
}
