package com.onesignal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.SystemClock;
import com.onesignal.sa.C0650i;
import java.util.ArrayList;
import java.util.List;

public class va extends SQLiteOpenHelper {
    /* renamed from: a */
    private static va f1408a;

    private va(Context context) {
        super(context, "OneSignal.db", null, 2);
    }

    /* renamed from: a */
    public static synchronized va m1748a(Context context) {
        va vaVar;
        synchronized (va.class) {
            if (f1408a == null) {
                f1408a = new va(context.getApplicationContext());
            }
            vaVar = f1408a;
        }
        return vaVar;
    }

    /* renamed from: a */
    private static void m1749a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i < 2) {
            sQLiteDatabase.execSQL("ALTER TABLE notification ADD COLUMN collapse_id TEXT;");
            sQLiteDatabase.execSQL("CREATE INDEX notification_group_id_idx ON notification(group_id); ");
        }
    }

    /* renamed from: a */
    synchronized SQLiteDatabase m1750a() {
        int i;
        i = 0;
        while (true) {
            try {
                i = getReadableDatabase();
                break;
            } catch (Throwable th) {
                i++;
                if (i < 5) {
                    SystemClock.sleep((long) (i * 400));
                }
            }
        }
        return i;
    }

    /* renamed from: b */
    synchronized SQLiteDatabase m1751b() {
        int i;
        i = 0;
        while (true) {
            try {
                i = getWritableDatabase();
                break;
            } catch (Throwable th) {
                i++;
                if (i < 5) {
                    SystemClock.sleep((long) (i * 400));
                }
            }
        }
        return i;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE notification (_id INTEGER PRIMARY KEY,notification_id TEXT,android_notification_id INTEGER,group_id TEXT,collapse_id TEXT,is_summary INTEGER DEFAULT 0,opened INTEGER DEFAULT 0,dismissed INTEGER DEFAULT 0,title TEXT,message TEXT,full_data TEXT,created_time TIMESTAMP DEFAULT (strftime('%s', 'now')));");
        sQLiteDatabase.execSQL("CREATE INDEX notification_notification_id_idx ON notification(notification_id); CREATE INDEX notification_android_notification_id_idx ON notification(android_notification_id); CREATE INDEX notification_group_id_idx ON notification(group_id); CREATE INDEX notification_collapse_id_idx ON notification(collapse_id); CREATE INDEX notification_created_time_idx ON notification(created_time); ");
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sa.m1656a(C0650i.WARN, "SDK version rolled back! Clearing OneSignal.db as it could be in an unexpected state.");
        Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);
        try {
            List<String> arrayList = new ArrayList(rawQuery.getCount());
            while (rawQuery.moveToNext()) {
                arrayList.add(rawQuery.getString(0));
            }
            for (String str : arrayList) {
                if (!str.startsWith("sqlite_")) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("DROP TABLE IF EXISTS ");
                    stringBuilder.append(str);
                    sQLiteDatabase.execSQL(stringBuilder.toString());
                }
            }
            onCreate(sQLiteDatabase);
        } finally {
            rawQuery.close();
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            m1749a(sQLiteDatabase, i, i2);
        } catch (Throwable e) {
            sa.m1657a(C0650i.ERROR, "Error in upgrade, migration may have already run! Skipping!", e);
        }
    }
}
