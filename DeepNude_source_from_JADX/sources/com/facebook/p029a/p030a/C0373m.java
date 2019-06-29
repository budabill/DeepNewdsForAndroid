package com.facebook.p029a.p030a;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

/* renamed from: com.facebook.a.a.m */
public class C0373m implements SensorEventListener {
    /* renamed from: a */
    private C0372a f607a;

    /* renamed from: com.facebook.a.a.m$a */
    public interface C0372a {
        /* renamed from: a */
        void mo950a();
    }

    /* renamed from: a */
    public void m659a(C0372a c0372a) {
        this.f607a = c0372a;
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (this.f607a != null) {
            float[] fArr = sensorEvent.values;
            float f = fArr[0];
            double d = (double) (f / 9.80665f);
            double d2 = (double) (fArr[1] / 9.80665f);
            double d3 = (double) (fArr[2] / 9.80665f);
            Double.isNaN(d);
            Double.isNaN(d);
            d *= d;
            Double.isNaN(d2);
            Double.isNaN(d2);
            d += d2 * d2;
            Double.isNaN(d3);
            Double.isNaN(d3);
            if (Math.sqrt(d + (d3 * d3)) > 2.299999952316284d) {
                this.f607a.mo950a();
            }
        }
    }
}
