package com.onesignal;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import com.onesignal.Ia.C0874b;

public class SyncJobService extends JobService {
    public boolean onStartJob(JobParameters jobParameters) {
        Ia.m1365a((Context) this, new C0874b(this, jobParameters));
        return true;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        return Ia.m1368b();
    }
}
