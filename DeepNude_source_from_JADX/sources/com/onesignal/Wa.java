package com.onesignal;

import android.app.job.JobParameters;
import android.app.job.JobService;

class wa implements Runnable {
    /* renamed from: a */
    final /* synthetic */ JobService f1409a;
    /* renamed from: b */
    final /* synthetic */ JobParameters f1410b;
    /* renamed from: c */
    final /* synthetic */ xa f1411c;

    wa(xa xaVar, JobService jobService, JobParameters jobParameters) {
        this.f1411c = xaVar;
        this.f1409a = jobService;
        this.f1410b = jobParameters;
    }

    public void run() {
        this.f1411c.mo1348a(this.f1409a, this.f1410b);
        this.f1411c.jobFinished(this.f1410b, false);
    }
}
