package com.onesignal;

import android.app.job.JobParameters;
import android.app.job.JobService;

abstract class xa extends JobService {
    xa() {
    }

    /* renamed from: a */
    abstract void mo1348a(JobService jobService, JobParameters jobParameters);

    public boolean onStartJob(JobParameters jobParameters) {
        if (jobParameters.getExtras() == null) {
            return false;
        }
        new Thread(new wa(this, this, jobParameters), "OS_JOBSERVICE_BASE").start();
        return true;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
