package com.onesignal;

import java.util.concurrent.ThreadFactory;

class ha implements ThreadFactory {
    ha() {
    }

    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("OS_PENDING_EXECUTOR_");
        stringBuilder.append(thread.getId());
        thread.setName(stringBuilder.toString());
        return thread;
    }
}
