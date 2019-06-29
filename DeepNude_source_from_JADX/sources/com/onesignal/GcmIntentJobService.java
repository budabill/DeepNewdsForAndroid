package com.onesignal;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;

public class GcmIntentJobService extends xa {
    /* renamed from: a */
    void mo1348a(JobService jobService, JobParameters jobParameters) {
        C0585D.m1294a((Context) jobService, new C0877n(jobParameters.getExtras()), null);
    }

    public /* bridge */ /* synthetic */ boolean onStartJob(JobParameters jobParameters) {
        return super.onStartJob(jobParameters);
    }

    public /* bridge */ /* synthetic */ boolean onStopJob(JobParameters jobParameters) {
        return super.onStopJob(jobParameters);
    }
}
