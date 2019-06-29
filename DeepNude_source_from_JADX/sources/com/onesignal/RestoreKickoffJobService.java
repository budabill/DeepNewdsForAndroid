package com.onesignal;

import android.app.job.JobParameters;
import android.app.job.JobService;

public class RestoreKickoffJobService extends xa {
    /* renamed from: a */
    void mo1348a(JobService jobService, JobParameters jobParameters) {
        Thread.currentThread().setPriority(10);
        C0594K.m1387b(getApplicationContext());
    }

    public /* bridge */ /* synthetic */ boolean onStartJob(JobParameters jobParameters) {
        return super.onStartJob(jobParameters);
    }

    public /* bridge */ /* synthetic */ boolean onStopJob(JobParameters jobParameters) {
        return super.onStopJob(jobParameters);
    }
}
