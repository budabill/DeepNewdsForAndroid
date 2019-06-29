package io.gonative.android.p038a;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: io.gonative.android.a.a */
public class C0700a {
    /* renamed from: a */
    private static final String f1503a = "io.gonative.android.a.a";
    /* renamed from: b */
    private static C0700a f1504b;
    /* renamed from: A */
    public boolean f1505A;
    public String Aa;
    private HashMap<String, String> Ab;
    /* renamed from: B */
    public boolean f1506B;
    public JSONObject Ba;
    private ArrayList<Pattern> Bb;
    /* renamed from: C */
    public HashMap<String, JSONArray> f1507C;
    public boolean Ca;
    private ArrayList<Boolean> Cb;
    /* renamed from: D */
    public boolean f1508D;
    public String Da;
    private HashMap<String, JSONArray> Db;
    /* renamed from: E */
    public List<Pattern> f1509E;
    public JSONObject Ea;
    private HashMap<String, JSONArray> Eb;
    /* renamed from: F */
    public List<Boolean> f1510F;
    public boolean Fa;
    private boolean Fb;
    /* renamed from: G */
    public String f1511G;
    public boolean Ga;
    /* renamed from: H */
    public String f1512H;
    public boolean Ha;
    /* renamed from: I */
    public ArrayList<Pattern> f1513I;
    public int Ia;
    /* renamed from: J */
    public ArrayList<JSONObject> f1514J;
    public int Ja;
    /* renamed from: K */
    public ArrayList<Pattern> f1515K;
    public boolean Ka;
    /* renamed from: L */
    public ArrayList<Integer> f1516L;
    public String La;
    /* renamed from: M */
    public ArrayList<HashMap<String, Object>> f1517M;
    public String Ma;
    /* renamed from: N */
    public String f1518N;
    public boolean Na;
    /* renamed from: O */
    public ArrayList<Pattern> f1519O;
    public boolean Oa;
    /* renamed from: P */
    public ArrayList<Boolean> f1520P;
    public String Pa;
    /* renamed from: Q */
    public HashMap<String, String> f1521Q;
    public String Qa;
    /* renamed from: R */
    public boolean f1522R;
    public boolean Ra;
    /* renamed from: S */
    public boolean f1523S;
    public String Sa;
    /* renamed from: T */
    public ArrayList<JSONObject> f1524T;
    public boolean Ta;
    /* renamed from: U */
    public HashMap<String, JSONArray> f1525U;
    public boolean Ua;
    /* renamed from: V */
    public ArrayList<Pattern> f1526V;
    public JSONObject Va;
    /* renamed from: W */
    public ArrayList<String> f1527W;
    public boolean Wa;
    /* renamed from: X */
    public HashMap<String, JSONArray> f1528X;
    public String Xa;
    /* renamed from: Y */
    public ArrayList<Pattern> f1529Y;
    public String Ya;
    /* renamed from: Z */
    public ArrayList<String> f1530Z;
    public boolean Za;
    public String _a;
    public ArrayList<Pattern> aa;
    public String ab;
    public Integer ba;
    public String bb;
    /* renamed from: c */
    private Context f1531c;
    public Integer ca;
    public boolean cb;
    /* renamed from: d */
    private JSONObject f1532d;
    public Integer da;
    public List<Pattern> db;
    /* renamed from: e */
    public Exception f1533e;
    public Integer ea;
    public String eb;
    /* renamed from: f */
    public String f1534f;
    public Integer fa;
    public JSONArray fb;
    /* renamed from: g */
    public String f1535g;
    public Integer ga;
    public JSONArray gb;
    /* renamed from: h */
    public String f1536h;
    public String ha;
    public boolean hb;
    /* renamed from: i */
    public String f1537i;
    public double ia;
    public String ib;
    /* renamed from: j */
    public String f1538j;
    public boolean ja;
    public String jb;
    /* renamed from: k */
    private String f1539k;
    public String ka;
    public boolean kb;
    /* renamed from: l */
    private String f1540l;
    public Integer la;
    public boolean lb;
    /* renamed from: m */
    public String f1541m;
    public boolean ma = true;
    public String mb;
    /* renamed from: n */
    public int f1542n;
    public double na;
    public ArrayList<Pattern> nb;
    /* renamed from: o */
    public ArrayList<Pattern> f1543o;
    public String oa;
    public boolean ob;
    /* renamed from: p */
    public ArrayList<String> f1544p;
    public boolean pa;
    public ArrayList<Pattern> pb;
    /* renamed from: q */
    public boolean f1545q;
    public boolean qa;
    public boolean qb;
    /* renamed from: r */
    public boolean f1546r;
    public boolean ra;
    public String rb;
    /* renamed from: s */
    public boolean f1547s = true;
    public ArrayList<Pattern> sa;
    public boolean sb;
    /* renamed from: t */
    public boolean f1548t;
    public float ta;
    public String tb;
    /* renamed from: u */
    public boolean f1549u;
    public Integer ua;
    public boolean ub;
    /* renamed from: v */
    public C0698a f1550v;
    public boolean va;
    public boolean vb;
    /* renamed from: w */
    public boolean f1551w;
    public double wa;
    public String wb;
    /* renamed from: x */
    public Map<String, String> f1552x;
    public double xa;
    private long xb;
    /* renamed from: y */
    public boolean f1553y;
    public boolean ya;
    private boolean yb;
    /* renamed from: z */
    public List<Pattern> f1554z;
    public String za;
    private boolean zb;

    /* renamed from: io.gonative.android.a.a$a */
    public enum C0698a {
        UNSPECIFIED,
        PORTRAIT,
        LANDSCAPE
    }

    /* renamed from: io.gonative.android.a.a$b */
    private class C0699b extends AsyncTask<Void, Void, JSONObject> {
        /* renamed from: a */
        private /* synthetic */ C0700a f1502a;

        private C0699b(C0700a c0700a) {
            this.f1502a = c0700a;
        }

        /* renamed from: a */
        private org.json.JSONObject m1849a() {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
            /*
            r21 = this;
            r0 = r21;
            r1 = r0.f1502a;
            r2 = android.os.SystemClock.elapsedRealtime();
            r1.xb = r2;
            r1 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0243 }
            r2 = r0.f1502a;	 Catch:{ Exception -> 0x0243 }
            r2 = r2.m1862b();	 Catch:{ Exception -> 0x0243 }
            r1.<init>(r2);	 Catch:{ Exception -> 0x0243 }
            r2 = 40;	 Catch:{ Exception -> 0x0243 }
            r3 = new byte[r2];	 Catch:{ Exception -> 0x0243 }
            r4 = -21;	 Catch:{ Exception -> 0x0243 }
            r5 = 0;	 Catch:{ Exception -> 0x0243 }
            r3[r5] = r4;	 Catch:{ Exception -> 0x0243 }
            r4 = 41;	 Catch:{ Exception -> 0x0243 }
            r6 = 1;	 Catch:{ Exception -> 0x0243 }
            r3[r6] = r4;	 Catch:{ Exception -> 0x0243 }
            r4 = 13;	 Catch:{ Exception -> 0x0243 }
            r7 = 2;	 Catch:{ Exception -> 0x0243 }
            r3[r7] = r4;	 Catch:{ Exception -> 0x0243 }
            r8 = 3;	 Catch:{ Exception -> 0x0243 }
            r9 = -62;	 Catch:{ Exception -> 0x0243 }
            r3[r8] = r9;	 Catch:{ Exception -> 0x0243 }
            r8 = 113; // 0x71 float:1.58E-43 double:5.6E-322;	 Catch:{ Exception -> 0x0243 }
            r9 = 4;	 Catch:{ Exception -> 0x0243 }
            r3[r9] = r8;	 Catch:{ Exception -> 0x0243 }
            r8 = 5;	 Catch:{ Exception -> 0x0243 }
            r10 = 29;	 Catch:{ Exception -> 0x0243 }
            r3[r8] = r10;	 Catch:{ Exception -> 0x0243 }
            r8 = 6;	 Catch:{ Exception -> 0x0243 }
            r11 = -7;	 Catch:{ Exception -> 0x0243 }
            r3[r8] = r11;	 Catch:{ Exception -> 0x0243 }
            r8 = 7;	 Catch:{ Exception -> 0x0243 }
            r11 = 48;	 Catch:{ Exception -> 0x0243 }
            r3[r8] = r11;	 Catch:{ Exception -> 0x0243 }
            r8 = 8;	 Catch:{ Exception -> 0x0243 }
            r11 = 26;	 Catch:{ Exception -> 0x0243 }
            r3[r8] = r11;	 Catch:{ Exception -> 0x0243 }
            r8 = 9;	 Catch:{ Exception -> 0x0243 }
            r12 = -97;	 Catch:{ Exception -> 0x0243 }
            r3[r8] = r12;	 Catch:{ Exception -> 0x0243 }
            r8 = 10;	 Catch:{ Exception -> 0x0243 }
            r3[r8] = r9;	 Catch:{ Exception -> 0x0243 }
            r8 = 11;	 Catch:{ Exception -> 0x0243 }
            r12 = 125; // 0x7d float:1.75E-43 double:6.2E-322;	 Catch:{ Exception -> 0x0243 }
            r3[r8] = r12;	 Catch:{ Exception -> 0x0243 }
            r8 = 12;	 Catch:{ Exception -> 0x0243 }
            r12 = -107; // 0xffffffffffffff95 float:NaN double:NaN;	 Catch:{ Exception -> 0x0243 }
            r3[r8] = r12;	 Catch:{ Exception -> 0x0243 }
            r3[r4] = r9;	 Catch:{ Exception -> 0x0243 }
            r8 = 14;	 Catch:{ Exception -> 0x0243 }
            r13 = -80;	 Catch:{ Exception -> 0x0243 }
            r3[r8] = r13;	 Catch:{ Exception -> 0x0243 }
            r8 = 15;	 Catch:{ Exception -> 0x0243 }
            r13 = 115; // 0x73 float:1.61E-43 double:5.7E-322;	 Catch:{ Exception -> 0x0243 }
            r3[r8] = r13;	 Catch:{ Exception -> 0x0243 }
            r8 = 16;	 Catch:{ Exception -> 0x0243 }
            r3[r8] = r11;	 Catch:{ Exception -> 0x0243 }
            r8 = 17;	 Catch:{ Exception -> 0x0243 }
            r13 = -127; // 0xffffffffffffff81 float:NaN double:NaN;	 Catch:{ Exception -> 0x0243 }
            r3[r8] = r13;	 Catch:{ Exception -> 0x0243 }
            r8 = 18;	 Catch:{ Exception -> 0x0243 }
            r13 = 22;	 Catch:{ Exception -> 0x0243 }
            r3[r8] = r13;	 Catch:{ Exception -> 0x0243 }
            r8 = 19;	 Catch:{ Exception -> 0x0243 }
            r14 = 50;	 Catch:{ Exception -> 0x0243 }
            r3[r8] = r14;	 Catch:{ Exception -> 0x0243 }
            r8 = -39;	 Catch:{ Exception -> 0x0243 }
            r14 = 20;	 Catch:{ Exception -> 0x0243 }
            r3[r14] = r8;	 Catch:{ Exception -> 0x0243 }
            r8 = 21;	 Catch:{ Exception -> 0x0243 }
            r15 = -33;	 Catch:{ Exception -> 0x0243 }
            r3[r8] = r15;	 Catch:{ Exception -> 0x0243 }
            r8 = 96;	 Catch:{ Exception -> 0x0243 }
            r3[r13] = r8;	 Catch:{ Exception -> 0x0243 }
            r8 = 23;	 Catch:{ Exception -> 0x0243 }
            r15 = -105; // 0xffffffffffffff97 float:NaN double:NaN;	 Catch:{ Exception -> 0x0243 }
            r3[r8] = r15;	 Catch:{ Exception -> 0x0243 }
            r8 = 25;	 Catch:{ Exception -> 0x0243 }
            r15 = 24;	 Catch:{ Exception -> 0x0243 }
            r3[r15] = r8;	 Catch:{ Exception -> 0x0243 }
            r16 = -46;	 Catch:{ Exception -> 0x0243 }
            r3[r8] = r16;	 Catch:{ Exception -> 0x0243 }
            r16 = 123; // 0x7b float:1.72E-43 double:6.1E-322;	 Catch:{ Exception -> 0x0243 }
            r3[r11] = r16;	 Catch:{ Exception -> 0x0243 }
            r16 = 27;	 Catch:{ Exception -> 0x0243 }
            r17 = -62;	 Catch:{ Exception -> 0x0243 }
            r3[r16] = r17;	 Catch:{ Exception -> 0x0243 }
            r16 = 28;	 Catch:{ Exception -> 0x0243 }
            r17 = -90;	 Catch:{ Exception -> 0x0243 }
            r3[r16] = r17;	 Catch:{ Exception -> 0x0243 }
            r16 = 109; // 0x6d float:1.53E-43 double:5.4E-322;	 Catch:{ Exception -> 0x0243 }
            r3[r10] = r16;	 Catch:{ Exception -> 0x0243 }
            r16 = 30;	 Catch:{ Exception -> 0x0243 }
            r17 = -33;	 Catch:{ Exception -> 0x0243 }
            r3[r16] = r17;	 Catch:{ Exception -> 0x0243 }
            r16 = 58;	 Catch:{ Exception -> 0x0243 }
            r17 = 31;	 Catch:{ Exception -> 0x0243 }
            r3[r17] = r16;	 Catch:{ Exception -> 0x0243 }
            r16 = 32;	 Catch:{ Exception -> 0x0243 }
            r18 = 71;	 Catch:{ Exception -> 0x0243 }
            r3[r16] = r18;	 Catch:{ Exception -> 0x0243 }
            r16 = 33;	 Catch:{ Exception -> 0x0243 }
            r18 = -100;	 Catch:{ Exception -> 0x0243 }
            r3[r16] = r18;	 Catch:{ Exception -> 0x0243 }
            r16 = 34;	 Catch:{ Exception -> 0x0243 }
            r3[r16] = r12;	 Catch:{ Exception -> 0x0243 }
            r16 = 35;	 Catch:{ Exception -> 0x0243 }
            r18 = 56;	 Catch:{ Exception -> 0x0243 }
            r3[r16] = r18;	 Catch:{ Exception -> 0x0243 }
            r16 = 36;	 Catch:{ Exception -> 0x0243 }
            r18 = -20;	 Catch:{ Exception -> 0x0243 }
            r3[r16] = r18;	 Catch:{ Exception -> 0x0243 }
            r16 = 37;	 Catch:{ Exception -> 0x0243 }
            r18 = -16;	 Catch:{ Exception -> 0x0243 }
            r3[r16] = r18;	 Catch:{ Exception -> 0x0243 }
            r16 = 38;	 Catch:{ Exception -> 0x0243 }
            r18 = -5;	 Catch:{ Exception -> 0x0243 }
            r3[r16] = r18;	 Catch:{ Exception -> 0x0243 }
            r16 = 116; // 0x74 float:1.63E-43 double:5.73E-322;	 Catch:{ Exception -> 0x0243 }
            r18 = 39;	 Catch:{ Exception -> 0x0243 }
            r3[r18] = r16;	 Catch:{ Exception -> 0x0243 }
            r12 = new byte[r2];	 Catch:{ Exception -> 0x0243 }
            r19 = -125; // 0xffffffffffffff83 float:NaN double:NaN;	 Catch:{ Exception -> 0x0243 }
            r12[r5] = r19;	 Catch:{ Exception -> 0x0243 }
            r19 = 93;	 Catch:{ Exception -> 0x0243 }
            r12[r6] = r19;	 Catch:{ Exception -> 0x0243 }
            r19 = 121; // 0x79 float:1.7E-43 double:6.0E-322;	 Catch:{ Exception -> 0x0243 }
            r12[r7] = r19;	 Catch:{ Exception -> 0x0243 }
            r19 = 3;	 Catch:{ Exception -> 0x0243 }
            r20 = -78;	 Catch:{ Exception -> 0x0243 }
            r12[r19] = r20;	 Catch:{ Exception -> 0x0243 }
            r12[r9] = r7;	 Catch:{ Exception -> 0x0243 }
            r7 = 5;	 Catch:{ Exception -> 0x0243 }
            r12[r7] = r18;	 Catch:{ Exception -> 0x0243 }
            r7 = 6;	 Catch:{ Exception -> 0x0243 }
            r19 = -42;	 Catch:{ Exception -> 0x0243 }
            r12[r7] = r19;	 Catch:{ Exception -> 0x0243 }
            r7 = 7;	 Catch:{ Exception -> 0x0243 }
            r12[r7] = r17;	 Catch:{ Exception -> 0x0243 }
            r7 = 8;	 Catch:{ Exception -> 0x0243 }
            r19 = 118; // 0x76 float:1.65E-43 double:5.83E-322;	 Catch:{ Exception -> 0x0243 }
            r12[r7] = r19;	 Catch:{ Exception -> 0x0243 }
            r7 = 9;	 Catch:{ Exception -> 0x0243 }
            r19 = -10;	 Catch:{ Exception -> 0x0243 }
            r12[r7] = r19;	 Catch:{ Exception -> 0x0243 }
            r7 = 10;	 Catch:{ Exception -> 0x0243 }
            r19 = 103; // 0x67 float:1.44E-43 double:5.1E-322;	 Catch:{ Exception -> 0x0243 }
            r12[r7] = r19;	 Catch:{ Exception -> 0x0243 }
            r7 = 11;	 Catch:{ Exception -> 0x0243 }
            r12[r7] = r15;	 Catch:{ Exception -> 0x0243 }
            r7 = 12;	 Catch:{ Exception -> 0x0243 }
            r19 = -5;	 Catch:{ Exception -> 0x0243 }
            r12[r7] = r19;	 Catch:{ Exception -> 0x0243 }
            r7 = 119; // 0x77 float:1.67E-43 double:5.9E-322;	 Catch:{ Exception -> 0x0243 }
            r12[r4] = r7;	 Catch:{ Exception -> 0x0243 }
            r4 = 14;	 Catch:{ Exception -> 0x0243 }
            r7 = -43;	 Catch:{ Exception -> 0x0243 }
            r12[r4] = r7;	 Catch:{ Exception -> 0x0243 }
            r4 = 15;	 Catch:{ Exception -> 0x0243 }
            r7 = 93;	 Catch:{ Exception -> 0x0243 }
            r12[r4] = r7;	 Catch:{ Exception -> 0x0243 }
            r4 = 16;	 Catch:{ Exception -> 0x0243 }
            r7 = 125; // 0x7d float:1.75E-43 double:6.2E-322;	 Catch:{ Exception -> 0x0243 }
            r12[r4] = r7;	 Catch:{ Exception -> 0x0243 }
            r4 = 17;	 Catch:{ Exception -> 0x0243 }
            r7 = -18;	 Catch:{ Exception -> 0x0243 }
            r12[r4] = r7;	 Catch:{ Exception -> 0x0243 }
            r4 = 18;	 Catch:{ Exception -> 0x0243 }
            r7 = 120; // 0x78 float:1.68E-43 double:5.93E-322;	 Catch:{ Exception -> 0x0243 }
            r12[r4] = r7;	 Catch:{ Exception -> 0x0243 }
            r4 = 19;	 Catch:{ Exception -> 0x0243 }
            r7 = 83;	 Catch:{ Exception -> 0x0243 }
            r12[r4] = r7;	 Catch:{ Exception -> 0x0243 }
            r4 = -83;	 Catch:{ Exception -> 0x0243 }
            r12[r14] = r4;	 Catch:{ Exception -> 0x0243 }
            r4 = 21;	 Catch:{ Exception -> 0x0243 }
            r7 = -74;	 Catch:{ Exception -> 0x0243 }
            r12[r4] = r7;	 Catch:{ Exception -> 0x0243 }
            r12[r13] = r13;	 Catch:{ Exception -> 0x0243 }
            r4 = 23;	 Catch:{ Exception -> 0x0243 }
            r7 = -14;	 Catch:{ Exception -> 0x0243 }
            r12[r4] = r7;	 Catch:{ Exception -> 0x0243 }
            r4 = 55;	 Catch:{ Exception -> 0x0243 }
            r12[r15] = r4;	 Catch:{ Exception -> 0x0243 }
            r4 = -69;	 Catch:{ Exception -> 0x0243 }
            r12[r8] = r4;	 Catch:{ Exception -> 0x0243 }
            r12[r11] = r14;	 Catch:{ Exception -> 0x0243 }
            r4 = 27;	 Catch:{ Exception -> 0x0243 }
            r7 = -19;	 Catch:{ Exception -> 0x0243 }
            r12[r4] = r7;	 Catch:{ Exception -> 0x0243 }
            r4 = 28;	 Catch:{ Exception -> 0x0243 }
            r7 = -54;	 Catch:{ Exception -> 0x0243 }
            r12[r4] = r7;	 Catch:{ Exception -> 0x0243 }
            r12[r10] = r9;	 Catch:{ Exception -> 0x0243 }
            r4 = 30;	 Catch:{ Exception -> 0x0243 }
            r7 = -68;	 Catch:{ Exception -> 0x0243 }
            r12[r4] = r7;	 Catch:{ Exception -> 0x0243 }
            r4 = 95;	 Catch:{ Exception -> 0x0243 }
            r12[r17] = r4;	 Catch:{ Exception -> 0x0243 }
            r4 = 32;	 Catch:{ Exception -> 0x0243 }
            r7 = 41;	 Catch:{ Exception -> 0x0243 }
            r12[r4] = r7;	 Catch:{ Exception -> 0x0243 }
            r4 = 33;	 Catch:{ Exception -> 0x0243 }
            r7 = -17;	 Catch:{ Exception -> 0x0243 }
            r12[r4] = r7;	 Catch:{ Exception -> 0x0243 }
            r4 = 34;	 Catch:{ Exception -> 0x0243 }
            r7 = -16;	 Catch:{ Exception -> 0x0243 }
            r12[r4] = r7;	 Catch:{ Exception -> 0x0243 }
            r4 = 35;	 Catch:{ Exception -> 0x0243 }
            r7 = 91;	 Catch:{ Exception -> 0x0243 }
            r12[r4] = r7;	 Catch:{ Exception -> 0x0243 }
            r4 = 36;	 Catch:{ Exception -> 0x0243 }
            r7 = -124; // 0xffffffffffffff84 float:NaN double:NaN;	 Catch:{ Exception -> 0x0243 }
            r12[r4] = r7;	 Catch:{ Exception -> 0x0243 }
            r4 = 37;	 Catch:{ Exception -> 0x0243 }
            r7 = -107; // 0xffffffffffffff95 float:NaN double:NaN;	 Catch:{ Exception -> 0x0243 }
            r12[r4] = r7;	 Catch:{ Exception -> 0x0243 }
            r4 = 38;	 Catch:{ Exception -> 0x0243 }
            r7 = -104; // 0xffffffffffffff98 float:NaN double:NaN;	 Catch:{ Exception -> 0x0243 }
            r12[r4] = r7;	 Catch:{ Exception -> 0x0243 }
            r12[r18] = r17;	 Catch:{ Exception -> 0x0243 }
            r4 = new byte[r2];	 Catch:{ Exception -> 0x0243 }
        L_0x01b6:
            if (r5 >= r2) goto L_0x01c3;	 Catch:{ Exception -> 0x0243 }
        L_0x01b8:
            r7 = r3[r5];	 Catch:{ Exception -> 0x0243 }
            r8 = r12[r5];	 Catch:{ Exception -> 0x0243 }
            r7 = r7 ^ r8;	 Catch:{ Exception -> 0x0243 }
            r7 = (byte) r7;	 Catch:{ Exception -> 0x0243 }
            r4[r5] = r7;	 Catch:{ Exception -> 0x0243 }
            r5 = r5 + 1;	 Catch:{ Exception -> 0x0243 }
            goto L_0x01b6;	 Catch:{ Exception -> 0x0243 }
        L_0x01c3:
            r2 = new java.net.URL;	 Catch:{ Exception -> 0x0243 }
            r3 = new java.lang.String;	 Catch:{ Exception -> 0x0243 }
            r5 = "US-ASCII";	 Catch:{ Exception -> 0x0243 }
            r5 = java.nio.charset.Charset.forName(r5);	 Catch:{ Exception -> 0x0243 }
            r3.<init>(r4, r5);	 Catch:{ Exception -> 0x0243 }
            r2.<init>(r3);	 Catch:{ Exception -> 0x0243 }
            r2 = r2.openConnection();	 Catch:{ Exception -> 0x0243 }
            r2 = (java.net.HttpURLConnection) r2;	 Catch:{ Exception -> 0x0243 }
            r3 = "POST";	 Catch:{ Exception -> 0x0243 }
            r2.setRequestMethod(r3);	 Catch:{ Exception -> 0x0243 }
            r3 = "Content-Type";	 Catch:{ Exception -> 0x0243 }
            r4 = "application/json";	 Catch:{ Exception -> 0x0243 }
            r2.setRequestProperty(r3, r4);	 Catch:{ Exception -> 0x0243 }
            r2.setDoOutput(r6);	 Catch:{ Exception -> 0x0243 }
            r3 = new java.io.OutputStreamWriter;	 Catch:{ Exception -> 0x0243 }
            r4 = r2.getOutputStream();	 Catch:{ Exception -> 0x0243 }
            r5 = "UTF-8";	 Catch:{ Exception -> 0x0243 }
            r3.<init>(r4, r5);	 Catch:{ Exception -> 0x0243 }
            r1 = r1.toString();	 Catch:{ Exception -> 0x0243 }
            r3.write(r1);	 Catch:{ Exception -> 0x0243 }
            r3.close();	 Catch:{ Exception -> 0x0243 }
            r2.connect();	 Catch:{ Exception -> 0x0243 }
            r1 = r2.getResponseCode();	 Catch:{ Exception -> 0x0243 }
            r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;	 Catch:{ Exception -> 0x0243 }
            if (r1 != r3) goto L_0x023b;	 Catch:{ Exception -> 0x0243 }
        L_0x0208:
            r1 = r2.getContentLength();	 Catch:{ Exception -> 0x0243 }
            if (r1 <= 0) goto L_0x0218;	 Catch:{ Exception -> 0x0243 }
        L_0x020e:
            r1 = new java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x0243 }
            r3 = r2.getContentLength();	 Catch:{ Exception -> 0x0243 }
            r1.<init>(r3);	 Catch:{ Exception -> 0x0243 }
            goto L_0x021d;	 Catch:{ Exception -> 0x0243 }
        L_0x0218:
            r1 = new java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x0243 }
            r1.<init>();	 Catch:{ Exception -> 0x0243 }
        L_0x021d:
            r3 = new java.io.BufferedInputStream;	 Catch:{ Exception -> 0x0243 }
            r2 = r2.getInputStream();	 Catch:{ Exception -> 0x0243 }
            r3.<init>(r2);	 Catch:{ Exception -> 0x0243 }
            io.gonative.android.p038a.C0701b.m1895a(r3, r1);	 Catch:{ Exception -> 0x0243 }
            r3.close();	 Catch:{ Exception -> 0x0243 }
            r1.close();	 Catch:{ Exception -> 0x0243 }
            r2 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0243 }
            r3 = "UTF-8";	 Catch:{ Exception -> 0x0243 }
            r1 = r1.toString(r3);	 Catch:{ Exception -> 0x0243 }
            r2.<init>(r1);	 Catch:{ Exception -> 0x0243 }
            return r2;	 Catch:{ Exception -> 0x0243 }
        L_0x023b:
            r1 = new java.lang.Exception;	 Catch:{ Exception -> 0x0243 }
            r2 = "Non-200 response";	 Catch:{ Exception -> 0x0243 }
            r1.<init>(r2);	 Catch:{ Exception -> 0x0243 }
            throw r1;	 Catch:{ Exception -> 0x0243 }
        L_0x0243:
            r1 = 0;
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.gonative.android.a.a.b.a():org.json.JSONObject");
        }

        protected final /* synthetic */ Object doInBackground(Object[] objArr) {
            return m1849a();
        }

        protected final /* synthetic */ void onPostExecute(java.lang.Object r15) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
            /*
            r14 = this;
            r15 = (org.json.JSONObject) r15;
            if (r15 == 0) goto L_0x01e5;
        L_0x0004:
            r0 = 1;
            r1 = "isLicensed";
            r1 = r15.optBoolean(r1, r0);
            r2 = "isLicensedForPush";
            r2 = r15.optBoolean(r2, r0);
            r3 = "alert";
            r3 = io.gonative.android.p038a.C0700a.m1852a(r15, r3);
            if (r3 == 0) goto L_0x002c;
        L_0x0019:
            r4 = r3.isEmpty();
            if (r4 != 0) goto L_0x002c;
        L_0x001f:
            r4 = r14.f1502a;
            r4 = r4.f1531c;
            r3 = android.widget.Toast.makeText(r4, r3, r0);
            r3.show();
        L_0x002c:
            r3 = 0;
            if (r1 != 0) goto L_0x0030;
        L_0x002f:
            r2 = 0;
        L_0x0030:
            r4 = "io.gonative.android.AppConfig.processedTabNavigation";
            r5 = "io.gonative.android.AppConfig.processedMenu";
            if (r1 != 0) goto L_0x0159;
        L_0x0036:
            r6 = r14.f1502a;
            r6 = r6.yb;
            if (r6 == 0) goto L_0x0159;
        L_0x003e:
            r6 = r14.f1502a;
            r6.yb = r3;
            r6 = "unlicensedUrl";
            r6 = io.gonative.android.p038a.C0702c.m1897a(r15, r6);
            if (r6 != 0) goto L_0x004d;
        L_0x004b:
            r6 = "https://gonative.io/unlicensed";
        L_0x004d:
            r7 = "unlicensedLabel";
            r15 = io.gonative.android.p038a.C0702c.m1897a(r15, r7);
            if (r15 != 0) goto L_0x0057;
        L_0x0055:
            r15 = "Disabled";
        L_0x0057:
            r7 = r14.f1502a;
            r8 = r7.f1521Q;
            r7.Ab = r8;
            r7 = r14.f1502a;
            r8 = new java.util.HashMap;
            r8.<init>();
            r7.f1521Q = r8;
            r7 = r14.f1502a;
            r7 = r7.f1521Q;
            r8 = "*";
            r7.put(r8, r6);
            r7 = r14.f1502a;
            r8 = r7.f1519O;
            r7.Bb = r8;
            r7 = r14.f1502a;
            r8 = r7.f1520P;
            r7.Cb = r8;
            r7 = r14.f1502a;
            r8 = new java.util.ArrayList;
            r8.<init>();
            r7.f1519O = r8;
            r7 = r14.f1502a;
            r8 = new java.util.ArrayList;
            r8.<init>();
            r7.f1520P = r8;
            r7 = r14.f1502a;
            r7 = r7.f1519O;
            r8 = ".*";
            r8 = java.util.regex.Pattern.compile(r8);
            r7.add(r8);
            r7 = r14.f1502a;
            r7 = r7.f1520P;
            r8 = java.lang.Boolean.valueOf(r0);
            r7.add(r8);
            r7 = r14.f1502a;
            r8 = new java.util.HashMap;
            r9 = r7.f1507C;
            r8.<init>(r9);
            r7.Db = r8;
            r7 = r14.f1502a;
            r7 = r7.f1507C;
            r7 = r7.keySet();
            r7 = r7.iterator();
        L_0x00c0:
            r8 = r7.hasNext();
            r9 = "label";
            r10 = "url";
            if (r8 == 0) goto L_0x00ed;
        L_0x00ca:
            r8 = r7.next();
            r8 = (java.lang.String) r8;
            r11 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x00eb }
            r11.<init>();	 Catch:{ JSONException -> 0x00eb }
            r11.put(r10, r6);	 Catch:{ JSONException -> 0x00eb }
            r11.put(r9, r15);	 Catch:{ JSONException -> 0x00eb }
            r9 = new org.json.JSONArray;	 Catch:{ JSONException -> 0x00eb }
            r9.<init>();	 Catch:{ JSONException -> 0x00eb }
            r9.put(r11);	 Catch:{ JSONException -> 0x00eb }
            r10 = r14.f1502a;	 Catch:{ JSONException -> 0x00eb }
            r10 = r10.f1507C;	 Catch:{ JSONException -> 0x00eb }
            r10.put(r8, r9);	 Catch:{ JSONException -> 0x00eb }
            goto L_0x00c0;
            goto L_0x00c0;
        L_0x00ed:
            r7 = r14.f1502a;
            r8 = new java.util.HashMap;
            r11 = r7.f1525U;
            r8.<init>(r11);
            r7.Eb = r8;
            r7 = r14.f1502a;
            r7 = r7.f1525U;
            r7 = r7.keySet();
            r7 = r7.iterator();
        L_0x0105:
            r8 = r7.hasNext();
            if (r8 == 0) goto L_0x0135;
        L_0x010b:
            r8 = r7.next();
            r8 = (java.lang.String) r8;
            r11 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0133 }
            r11.<init>();	 Catch:{ JSONException -> 0x0133 }
            r11.put(r10, r6);	 Catch:{ JSONException -> 0x0133 }
            r11.put(r9, r15);	 Catch:{ JSONException -> 0x0133 }
            r12 = "icon";	 Catch:{ JSONException -> 0x0133 }
            r13 = "fa-ban";	 Catch:{ JSONException -> 0x0133 }
            r11.put(r12, r13);	 Catch:{ JSONException -> 0x0133 }
            r12 = new org.json.JSONArray;	 Catch:{ JSONException -> 0x0133 }
            r12.<init>();	 Catch:{ JSONException -> 0x0133 }
            r12.put(r11);	 Catch:{ JSONException -> 0x0133 }
            r11 = r14.f1502a;	 Catch:{ JSONException -> 0x0133 }
            r11 = r11.f1525U;	 Catch:{ JSONException -> 0x0133 }
            r11.put(r8, r12);	 Catch:{ JSONException -> 0x0133 }
            goto L_0x0105;
            goto L_0x0105;
        L_0x0135:
            r15 = r14.f1502a;
            r15 = r15.f1531c;
            r15 = android.support.v4.content.LocalBroadcastManager.getInstance(r15);
            r6 = new android.content.Intent;
            r6.<init>(r5);
            r15.sendBroadcast(r6);
            r15 = r14.f1502a;
            r15 = r15.f1531c;
            r15 = android.support.v4.content.LocalBroadcastManager.getInstance(r15);
            r6 = new android.content.Intent;
            r6.<init>(r4);
            r15.sendBroadcast(r6);
        L_0x0159:
            if (r2 != 0) goto L_0x0173;
        L_0x015b:
            r15 = r14.f1502a;
            r15 = r15.zb;
            if (r15 == 0) goto L_0x0173;
        L_0x0163:
            r15 = r14.f1502a;
            r15.zb = r3;
            r15 = r14.f1502a;
            r6 = r15.Ka;
            r15.Fb = r6;
            r15 = r14.f1502a;
            r15.Ka = r3;
        L_0x0173:
            if (r1 == 0) goto L_0x01ce;
        L_0x0175:
            r15 = r14.f1502a;
            r15 = r15.yb;
            if (r15 != 0) goto L_0x01ce;
        L_0x017d:
            r15 = r14.f1502a;
            r15.yb = r0;
            r15 = r14.f1502a;
            r1 = r15.Ab;
            r15.f1521Q = r1;
            r15 = r14.f1502a;
            r1 = r15.Bb;
            r15.f1519O = r1;
            r15 = r14.f1502a;
            r1 = r15.Cb;
            r15.f1520P = r1;
            r15 = r14.f1502a;
            r1 = r15.Db;
            r15.f1507C = r1;
            r15 = r14.f1502a;
            r1 = r15.Eb;
            r15.f1525U = r1;
            r15 = r14.f1502a;
            r15 = r15.f1531c;
            r15 = android.support.v4.content.LocalBroadcastManager.getInstance(r15);
            r1 = new android.content.Intent;
            r1.<init>(r5);
            r15.sendBroadcast(r1);
            r15 = r14.f1502a;
            r15 = r15.f1531c;
            r15 = android.support.v4.content.LocalBroadcastManager.getInstance(r15);
            r1 = new android.content.Intent;
            r1.<init>(r4);
            r15.sendBroadcast(r1);
        L_0x01ce:
            if (r2 == 0) goto L_0x01e5;
        L_0x01d0:
            r15 = r14.f1502a;
            r15 = r15.zb;
            if (r15 != 0) goto L_0x01e5;
        L_0x01d8:
            r15 = r14.f1502a;
            r15.zb = r0;
            r15 = r14.f1502a;
            r0 = r15.Fb;
            r15.Ka = r0;
        L_0x01e5:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.gonative.android.a.a.b.onPostExecute(java.lang.Object):void");
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private C0700a(android.content.Context r14) {
        /*
        r13 = this;
        r0 = "internal";
        r1 = "regex";
        r13.<init>();
        r2 = 1;
        r13.f1547s = r2;
        r13.ma = r2;
        r3 = 0;
        r13.Fa = r3;
        r13.Ga = r3;
        r13.Ha = r3;
        r4 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r13.Ia = r4;
        r13.Ja = r4;
        r13.Ka = r3;
        r13.Na = r3;
        r13.Oa = r3;
        r13.Ra = r3;
        r13.Ta = r2;
        r13.Ua = r3;
        r13.Wa = r3;
        r13.Za = r3;
        r13.cb = r3;
        r13.hb = r3;
        r13.kb = r3;
        r13.lb = r3;
        r5 = new java.util.ArrayList;
        r5.<init>();
        r13.nb = r5;
        r13.ob = r3;
        r5 = new java.util.ArrayList;
        r5.<init>();
        r13.pb = r5;
        r13.qb = r3;
        r5 = 0;
        r13.rb = r5;
        r13.sb = r3;
        r13.tb = r5;
        r13.ub = r2;
        r13.vb = r3;
        r6 = 0;
        r13.xb = r6;
        r13.yb = r2;
        r13.zb = r2;
        r13.f1531c = r14;
        r6 = r13.m1887a();	 Catch:{ Exception -> 0x082c, all -> 0x0829 }
        r6 = r6.exists();	 Catch:{ Exception -> 0x082c, all -> 0x0829 }
        r7 = "UTF-8";
        if (r6 == 0) goto L_0x0099;
    L_0x0064:
        r6 = new java.io.BufferedInputStream;	 Catch:{ Exception -> 0x008b, all -> 0x0829 }
        r8 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x008b, all -> 0x0829 }
        r9 = r13.m1887a();	 Catch:{ Exception -> 0x008b, all -> 0x0829 }
        r8.<init>(r9);	 Catch:{ Exception -> 0x008b, all -> 0x0829 }
        r6.<init>(r8);	 Catch:{ Exception -> 0x008b, all -> 0x0829 }
        r8 = new java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x0089, all -> 0x0829 }
        r8.<init>();	 Catch:{ Exception -> 0x0089, all -> 0x0829 }
        io.gonative.android.p038a.C0701b.m1895a(r6, r8);	 Catch:{ Exception -> 0x0089, all -> 0x0829 }
        r8.close();	 Catch:{ Exception -> 0x0089, all -> 0x0829 }
        r9 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0089, all -> 0x0829 }
        r8 = r8.toString(r7);	 Catch:{ Exception -> 0x0089, all -> 0x0829 }
        r9.<init>(r8);	 Catch:{ Exception -> 0x0089, all -> 0x0829 }
        r13.f1532d = r9;	 Catch:{ Exception -> 0x0089, all -> 0x0829 }
        goto L_0x0099;
    L_0x0089:
        r8 = move-exception;
        goto L_0x008d;
    L_0x008b:
        r8 = move-exception;
        r6 = r5;
    L_0x008d:
        r9 = f1503a;	 Catch:{ Exception -> 0x082c, all -> 0x0829 }
        r10 = r8.getMessage();	 Catch:{ Exception -> 0x082c, all -> 0x0829 }
        android.util.Log.e(r9, r10, r8);	 Catch:{ Exception -> 0x082c, all -> 0x0829 }
        io.gonative.android.p038a.C0701b.m1894a(r6);	 Catch:{ Exception -> 0x082c, all -> 0x0829 }
    L_0x0099:
        r6 = r13.f1532d;	 Catch:{ Exception -> 0x082c, all -> 0x0829 }
        if (r6 != 0) goto L_0x00be;
    L_0x009d:
        r6 = r14.getAssets();	 Catch:{ Exception -> 0x082c, all -> 0x0829 }
        r8 = "appConfig.json";
        r6 = r6.open(r8);	 Catch:{ Exception -> 0x082c, all -> 0x0829 }
        r8 = new java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x0827 }
        r8.<init>();	 Catch:{ Exception -> 0x0827 }
        io.gonative.android.p038a.C0701b.m1895a(r6, r8);	 Catch:{ Exception -> 0x0827 }
        io.gonative.android.p038a.C0701b.m1894a(r8);	 Catch:{ Exception -> 0x0827 }
        r9 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0827 }
        r7 = r8.toString(r7);	 Catch:{ Exception -> 0x0827 }
        r9.<init>(r7);	 Catch:{ Exception -> 0x0827 }
        r13.f1532d = r9;	 Catch:{ Exception -> 0x0827 }
        goto L_0x00bf;
    L_0x00be:
        r6 = r5;
    L_0x00bf:
        r7 = new java.util.ArrayList;	 Catch:{ Exception -> 0x0827 }
        r7.<init>();	 Catch:{ Exception -> 0x0827 }
        r13.f1519O = r7;	 Catch:{ Exception -> 0x0827 }
        r7 = new java.util.ArrayList;	 Catch:{ Exception -> 0x0827 }
        r7.<init>();	 Catch:{ Exception -> 0x0827 }
        r13.f1520P = r7;	 Catch:{ Exception -> 0x0827 }
        r7 = r13.f1532d;	 Catch:{ Exception -> 0x0827 }
        r8 = "general";
        r7 = r7.optJSONObject(r8);	 Catch:{ Exception -> 0x0827 }
        if (r7 == 0) goto L_0x022f;
    L_0x00d7:
        r8 = "initialUrl";
        r8 = io.gonative.android.p038a.C0700a.m1852a(r7, r8);	 Catch:{ Exception -> 0x0827 }
        r13.f1534f = r8;	 Catch:{ Exception -> 0x0827 }
        r8 = r13.f1534f;	 Catch:{ Exception -> 0x0827 }
        r8 = android.net.Uri.parse(r8);	 Catch:{ Exception -> 0x0827 }
        r8 = r8.getHost();	 Catch:{ Exception -> 0x0827 }
        r13.f1535g = r8;	 Catch:{ Exception -> 0x0827 }
        r8 = r13.f1535g;	 Catch:{ Exception -> 0x0827 }
        r9 = "www.";
        r8 = r8.startsWith(r9);	 Catch:{ Exception -> 0x0827 }
        if (r8 == 0) goto L_0x00fe;
    L_0x00f5:
        r8 = r13.f1535g;	 Catch:{ Exception -> 0x0827 }
        r9 = 4;
        r8 = r8.substring(r9);	 Catch:{ Exception -> 0x0827 }
        r13.f1535g = r8;	 Catch:{ Exception -> 0x0827 }
    L_0x00fe:
        r8 = "appName";
        r8 = io.gonative.android.p038a.C0700a.m1852a(r7, r8);	 Catch:{ Exception -> 0x0827 }
        r13.f1536h = r8;	 Catch:{ Exception -> 0x0827 }
        r8 = "forceUserAgent";
        r8 = io.gonative.android.p038a.C0700a.m1852a(r7, r8);	 Catch:{ Exception -> 0x0827 }
        r13.f1539k = r8;	 Catch:{ Exception -> 0x0827 }
        r8 = r13.f1539k;	 Catch:{ Exception -> 0x0827 }
        if (r8 == 0) goto L_0x011f;
    L_0x0112:
        r8 = r13.f1539k;	 Catch:{ Exception -> 0x0827 }
        r8 = r8.isEmpty();	 Catch:{ Exception -> 0x0827 }
        if (r8 != 0) goto L_0x011f;
    L_0x011a:
        r14 = r13.f1539k;	 Catch:{ Exception -> 0x0827 }
    L_0x011c:
        r13.f1541m = r14;	 Catch:{ Exception -> 0x0827 }
        goto L_0x015f;
    L_0x011f:
        r8 = "userAgentAdd";
        r8 = io.gonative.android.p038a.C0700a.m1852a(r7, r8);	 Catch:{ Exception -> 0x0827 }
        r13.f1540l = r8;	 Catch:{ Exception -> 0x0827 }
        r8 = r13.f1540l;	 Catch:{ Exception -> 0x0827 }
        r9 = "gonative";
        if (r8 != 0) goto L_0x012f;
    L_0x012d:
        r13.f1540l = r9;	 Catch:{ Exception -> 0x0827 }
    L_0x012f:
        r8 = r13.f1540l;	 Catch:{ Exception -> 0x0827 }
        r8 = r8.equals(r9);	 Catch:{ Exception -> 0x0827 }
        if (r8 == 0) goto L_0x013b;
    L_0x0137:
        r8 = "GoNativeAndroid/1.0 gonative";
        r13.f1540l = r8;	 Catch:{ Exception -> 0x0827 }
    L_0x013b:
        r8 = new android.webkit.WebView;	 Catch:{ Exception -> 0x0827 }
        r8.<init>(r14);	 Catch:{ Exception -> 0x0827 }
        r14 = r8.getSettings();	 Catch:{ Exception -> 0x0827 }
        r14 = r14.getUserAgentString();	 Catch:{ Exception -> 0x0827 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0827 }
        r8.<init>();	 Catch:{ Exception -> 0x0827 }
        r8.append(r14);	 Catch:{ Exception -> 0x0827 }
        r14 = " ";
        r8.append(r14);	 Catch:{ Exception -> 0x0827 }
        r14 = r13.f1540l;	 Catch:{ Exception -> 0x0827 }
        r8.append(r14);	 Catch:{ Exception -> 0x0827 }
        r14 = r8.toString();	 Catch:{ Exception -> 0x0827 }
        goto L_0x011c;
    L_0x015f:
        r14 = "publicKey";
        r14 = io.gonative.android.p038a.C0700a.m1852a(r7, r14);	 Catch:{ Exception -> 0x0827 }
        r13.f1537i = r14;	 Catch:{ Exception -> 0x0827 }
        r14 = "deviceRegKey";
        r14 = io.gonative.android.p038a.C0700a.m1852a(r7, r14);	 Catch:{ Exception -> 0x0827 }
        r13.f1538j = r14;	 Catch:{ Exception -> 0x0827 }
        r14 = "forceSessionCookieExpiry";
        r14 = r7.optInt(r14, r3);	 Catch:{ Exception -> 0x0827 }
        r13.f1542n = r14;	 Catch:{ Exception -> 0x0827 }
        r14 = r13.f1542n;	 Catch:{ Exception -> 0x0827 }
        if (r14 <= 0) goto L_0x017d;
    L_0x017b:
        r13.vb = r2;	 Catch:{ Exception -> 0x0827 }
    L_0x017d:
        r14 = "userAgentRegexes";
        r14 = r7.optJSONArray(r14);	 Catch:{ Exception -> 0x0827 }
        r13.m1856a(r14);	 Catch:{ Exception -> 0x0827 }
        r14 = "disableConfigUpdater";
        r14 = r7.optBoolean(r14, r3);	 Catch:{ Exception -> 0x0827 }
        r13.f1545q = r14;	 Catch:{ Exception -> 0x0827 }
        r14 = "disableEventRecorder";
        r14 = r7.optBoolean(r14, r3);	 Catch:{ Exception -> 0x0827 }
        r13.f1546r = r14;	 Catch:{ Exception -> 0x0827 }
        r14 = "androidDirectCameraUploads";
        r14 = r7.optBoolean(r14, r2);	 Catch:{ Exception -> 0x0827 }
        r13.f1547s = r14;	 Catch:{ Exception -> 0x0827 }
        r14 = "androidClearCache";
        r14 = r7.optBoolean(r14, r3);	 Catch:{ Exception -> 0x0827 }
        r13.f1548t = r14;	 Catch:{ Exception -> 0x0827 }
        r14 = "enableWindowOpen";
        r14 = r7.optBoolean(r14, r3);	 Catch:{ Exception -> 0x0827 }
        r13.f1549u = r14;	 Catch:{ Exception -> 0x0827 }
        r14 = "forceScreenOrientation";
        r14 = io.gonative.android.p038a.C0700a.m1852a(r7, r14);	 Catch:{ Exception -> 0x0827 }
        r8 = io.gonative.android.p038a.C0700a.C0698a.UNSPECIFIED;	 Catch:{ Exception -> 0x0827 }
        r13.f1550v = r8;	 Catch:{ Exception -> 0x0827 }
        if (r14 == 0) goto L_0x01d2;
    L_0x01ba:
        r8 = "portrait";
        r8 = r14.equalsIgnoreCase(r8);	 Catch:{ Exception -> 0x0827 }
        if (r8 == 0) goto L_0x01c7;
    L_0x01c2:
        r14 = io.gonative.android.p038a.C0700a.C0698a.PORTRAIT;	 Catch:{ Exception -> 0x0827 }
    L_0x01c4:
        r13.f1550v = r14;	 Catch:{ Exception -> 0x0827 }
        goto L_0x01d2;
    L_0x01c7:
        r8 = "landscape";
        r14 = r14.equalsIgnoreCase(r8);	 Catch:{ Exception -> 0x0827 }
        if (r14 == 0) goto L_0x01d2;
    L_0x01cf:
        r14 = io.gonative.android.p038a.C0700a.C0698a.LANDSCAPE;	 Catch:{ Exception -> 0x0827 }
        goto L_0x01c4;
    L_0x01d2:
        r14 = "keepScreenOn";
        r14 = r7.optBoolean(r14, r3);	 Catch:{ Exception -> 0x0827 }
        r13.f1551w = r14;	 Catch:{ Exception -> 0x0827 }
        r14 = "androidCustomHeaders";
        r14 = r7.optJSONObject(r14);	 Catch:{ Exception -> 0x0827 }
        if (r14 != 0) goto L_0x01e8;
    L_0x01e2:
        r14 = "customHeaders";
        r14 = r7.optJSONObject(r14);	 Catch:{ Exception -> 0x0827 }
    L_0x01e8:
        if (r14 == 0) goto L_0x021b;
    L_0x01ea:
        r8 = new java.util.HashMap;	 Catch:{ Exception -> 0x0827 }
        r8.<init>();	 Catch:{ Exception -> 0x0827 }
        r13.f1552x = r8;	 Catch:{ Exception -> 0x0827 }
        r8 = r14.keys();	 Catch:{ Exception -> 0x0827 }
    L_0x01f5:
        r9 = r8.hasNext();	 Catch:{ Exception -> 0x0827 }
        if (r9 == 0) goto L_0x021b;
    L_0x01fb:
        r9 = r8.next();	 Catch:{ Exception -> 0x0827 }
        r9 = (java.lang.String) r9;	 Catch:{ Exception -> 0x0827 }
        r10 = io.gonative.android.p038a.C0700a.m1852a(r14, r9);	 Catch:{ Exception -> 0x0827 }
        if (r9 == 0) goto L_0x01f5;
    L_0x0207:
        if (r10 == 0) goto L_0x01f5;
    L_0x0209:
        r11 = r9.isEmpty();	 Catch:{ Exception -> 0x0827 }
        if (r11 != 0) goto L_0x01f5;
    L_0x020f:
        r11 = r10.isEmpty();	 Catch:{ Exception -> 0x0827 }
        if (r11 != 0) goto L_0x01f5;
    L_0x0215:
        r11 = r13.f1552x;	 Catch:{ Exception -> 0x0827 }
        r11.put(r9, r10);	 Catch:{ Exception -> 0x0827 }
        goto L_0x01f5;
    L_0x021b:
        r14 = "postLoadJavascript";
        r14 = io.gonative.android.p038a.C0700a.m1852a(r7, r14);	 Catch:{ Exception -> 0x0827 }
        r13.wb = r14;	 Catch:{ Exception -> 0x0827 }
        r14 = "nativeBridgeUrls";
        r14 = r7.opt(r14);	 Catch:{ Exception -> 0x0827 }
        r14 = io.gonative.android.p038a.C0700a.m1868c(r14);	 Catch:{ Exception -> 0x0827 }
        r13.f1554z = r14;	 Catch:{ Exception -> 0x0827 }
    L_0x022f:
        r14 = r13.f1532d;	 Catch:{ Exception -> 0x0827 }
        r7 = "forms";
        r14 = r14.optJSONObject(r7);	 Catch:{ Exception -> 0x0827 }
        r7 = "active";
        if (r14 == 0) goto L_0x0287;
    L_0x023b:
        r8 = "search";
        r8 = r14.optJSONObject(r8);	 Catch:{ Exception -> 0x0827 }
        if (r8 == 0) goto L_0x0251;
    L_0x0243:
        r9 = r8.optBoolean(r7, r3);	 Catch:{ Exception -> 0x0827 }
        if (r9 == 0) goto L_0x0251;
    L_0x0249:
        r9 = "searchTemplateURL";
        r8 = io.gonative.android.p038a.C0700a.m1852a(r8, r9);	 Catch:{ Exception -> 0x0827 }
        r13.za = r8;	 Catch:{ Exception -> 0x0827 }
    L_0x0251:
        r8 = "loginConfig";
        r8 = r14.optJSONObject(r8);	 Catch:{ Exception -> 0x0827 }
        r9 = "interceptUrl";
        if (r8 == 0) goto L_0x0271;
    L_0x025b:
        r10 = r8.optBoolean(r7, r3);	 Catch:{ Exception -> 0x0827 }
        if (r10 == 0) goto L_0x0271;
    L_0x0261:
        r13.Ba = r8;	 Catch:{ Exception -> 0x0827 }
        r10 = io.gonative.android.p038a.C0700a.m1852a(r8, r9);	 Catch:{ Exception -> 0x0827 }
        r13.Aa = r10;	 Catch:{ Exception -> 0x0827 }
        r10 = "loginIsFirstPage";
        r8 = r8.optBoolean(r10, r3);	 Catch:{ Exception -> 0x0827 }
        r13.Ca = r8;	 Catch:{ Exception -> 0x0827 }
    L_0x0271:
        r8 = "signupConfig";
        r14 = r14.optJSONObject(r8);	 Catch:{ Exception -> 0x0827 }
        if (r14 == 0) goto L_0x0287;
    L_0x0279:
        r8 = r14.optBoolean(r7, r3);	 Catch:{ Exception -> 0x0827 }
        if (r8 == 0) goto L_0x0287;
    L_0x027f:
        r13.Ea = r14;	 Catch:{ Exception -> 0x0827 }
        r14 = io.gonative.android.p038a.C0700a.m1852a(r14, r9);	 Catch:{ Exception -> 0x0827 }
        r13.Da = r14;	 Catch:{ Exception -> 0x0827 }
    L_0x0287:
        r14 = r13.f1532d;	 Catch:{ Exception -> 0x0827 }
        r8 = "navigation";
        r14 = r14.optJSONObject(r8);	 Catch:{ Exception -> 0x0827 }
        if (r14 == 0) goto L_0x03ce;
    L_0x0291:
        r8 = "androidPullToRefresh";
        r8 = r14.optBoolean(r8);	 Catch:{ Exception -> 0x0827 }
        r13.f1505A = r8;	 Catch:{ Exception -> 0x0827 }
        r8 = "swipeGestures";
        r8 = r14.optBoolean(r8);	 Catch:{ Exception -> 0x0827 }
        r13.f1506B = r8;	 Catch:{ Exception -> 0x0827 }
        r8 = "sidebarNavigation";
        r8 = r14.optJSONObject(r8);	 Catch:{ Exception -> 0x0827 }
        r13.m1870c(r8);	 Catch:{ Exception -> 0x0827 }
        r8 = "navlevels.json";
        r8 = r13.m1873d(r8);	 Catch:{ Exception -> 0x0827 }
        if (r8 != 0) goto L_0x02b8;
    L_0x02b2:
        r8 = "androidNavigationLevels";
        r8 = r14.optJSONObject(r8);	 Catch:{ Exception -> 0x0827 }
    L_0x02b8:
        if (r8 != 0) goto L_0x02c0;
    L_0x02ba:
        r8 = "navigationLevels";
        r8 = r14.optJSONObject(r8);	 Catch:{ Exception -> 0x0827 }
    L_0x02c0:
        r13.m1864b(r8);	 Catch:{ Exception -> 0x0827 }
        r8 = "navtitles.json";
        r8 = r13.m1873d(r8);	 Catch:{ Exception -> 0x0827 }
        if (r8 != 0) goto L_0x02d1;
    L_0x02cb:
        r8 = "navigationTitles";
        r8 = r14.optJSONObject(r8);	 Catch:{ Exception -> 0x0827 }
    L_0x02d1:
        r13.m1857a(r8);	 Catch:{ Exception -> 0x0827 }
        r8 = "profilePickerJS";
        r8 = io.gonative.android.p038a.C0700a.m1852a(r14, r8);	 Catch:{ Exception -> 0x0827 }
        r13.f1518N = r8;	 Catch:{ Exception -> 0x0827 }
        r8 = "regexInternalExternal";
        r8 = r14.optJSONObject(r8);	 Catch:{ Exception -> 0x0827 }
        if (r8 == 0) goto L_0x0324;
    L_0x02e4:
        r9 = "rules";
        r8 = r8.optJSONArray(r9);	 Catch:{ Exception -> 0x0827 }
        if (r8 == 0) goto L_0x0324;
    L_0x02ec:
        r9 = 0;
    L_0x02ed:
        r10 = r8.length();	 Catch:{ Exception -> 0x0827 }
        if (r9 >= r10) goto L_0x0324;
    L_0x02f3:
        r10 = r8.optJSONObject(r9);	 Catch:{ Exception -> 0x0827 }
        if (r10 == 0) goto L_0x0321;
    L_0x02f9:
        r11 = r10.has(r1);	 Catch:{ Exception -> 0x0827 }
        if (r11 == 0) goto L_0x0321;
    L_0x02ff:
        r11 = r10.has(r0);	 Catch:{ Exception -> 0x0827 }
        if (r11 == 0) goto L_0x0321;
    L_0x0305:
        r11 = io.gonative.android.p038a.C0700a.m1852a(r10, r1);	 Catch:{ Exception -> 0x0827 }
        r10 = r10.optBoolean(r0, r2);	 Catch:{ Exception -> 0x0827 }
        if (r11 == 0) goto L_0x0321;
    L_0x030f:
        r12 = r13.f1519O;	 Catch:{ Exception -> 0x0827 }
        r11 = java.util.regex.Pattern.compile(r11);	 Catch:{ Exception -> 0x0827 }
        r12.add(r11);	 Catch:{ Exception -> 0x0827 }
        r11 = r13.f1520P;	 Catch:{ Exception -> 0x0827 }
        r10 = java.lang.Boolean.valueOf(r10);	 Catch:{ Exception -> 0x0827 }
        r11.add(r10);	 Catch:{ Exception -> 0x0827 }
    L_0x0321:
        r9 = r9 + 1;
        goto L_0x02ed;
    L_0x0324:
        r0 = "tabNavigation";
        r0 = r14.optJSONObject(r0);	 Catch:{ Exception -> 0x0827 }
        r13.m1878e(r0);	 Catch:{ Exception -> 0x0827 }
        r0 = "actionConfig";
        r0 = r14.optJSONObject(r0);	 Catch:{ Exception -> 0x0827 }
        r13.m1881f(r0);	 Catch:{ Exception -> 0x0827 }
        r0 = "androidShowRefreshButton";
        r0 = r14.optBoolean(r0, r2);	 Catch:{ Exception -> 0x0827 }
        r13.ra = r0;	 Catch:{ Exception -> 0x0827 }
        r0 = "ignorePageFinishedRegexes";
        r0 = r14.optJSONArray(r0);	 Catch:{ Exception -> 0x0827 }
        r1 = new java.util.ArrayList;	 Catch:{ Exception -> 0x0827 }
        r1.<init>();	 Catch:{ Exception -> 0x0827 }
        r13.aa = r1;	 Catch:{ Exception -> 0x0827 }
        if (r0 == 0) goto L_0x0381;
    L_0x034d:
        r1 = 0;
    L_0x034e:
        r8 = r0.length();	 Catch:{ Exception -> 0x0827 }
        if (r1 >= r8) goto L_0x0381;
    L_0x0354:
        r8 = r0.isNull(r1);	 Catch:{ Exception -> 0x0827 }
        if (r8 != 0) goto L_0x037e;
    L_0x035a:
        r8 = r0.optString(r1);	 Catch:{ Exception -> 0x0827 }
        if (r8 == 0) goto L_0x037e;
    L_0x0360:
        r9 = java.util.regex.Pattern.compile(r8);	 Catch:{ PatternSyntaxException -> 0x036a }
        r10 = r13.aa;	 Catch:{ PatternSyntaxException -> 0x036a }
        r10.add(r9);	 Catch:{ PatternSyntaxException -> 0x036a }
        goto L_0x037e;
    L_0x036a:
        r9 = move-exception;
        r10 = f1503a;	 Catch:{ Exception -> 0x0827 }
        r11 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0827 }
        r12 = "Error parsing regex ";
        r11.<init>(r12);	 Catch:{ Exception -> 0x0827 }
        r11.append(r8);	 Catch:{ Exception -> 0x0827 }
        r8 = r11.toString();	 Catch:{ Exception -> 0x0827 }
        android.util.Log.e(r10, r8, r9);	 Catch:{ Exception -> 0x0827 }
    L_0x037e:
        r1 = r1 + 1;
        goto L_0x034e;
    L_0x0381:
        r0 = "redirects";
        r0 = r14.optJSONArray(r0);	 Catch:{ Exception -> 0x0827 }
        if (r0 == 0) goto L_0x03bb;
    L_0x0389:
        r1 = new java.util.HashMap;	 Catch:{ Exception -> 0x0827 }
        r8 = r0.length();	 Catch:{ Exception -> 0x0827 }
        r1.<init>(r8);	 Catch:{ Exception -> 0x0827 }
        r13.f1521Q = r1;	 Catch:{ Exception -> 0x0827 }
        r1 = 0;
    L_0x0395:
        r8 = r0.length();	 Catch:{ Exception -> 0x0827 }
        if (r1 >= r8) goto L_0x03bd;
    L_0x039b:
        r8 = r0.optJSONObject(r1);	 Catch:{ Exception -> 0x0827 }
        r9 = "from";
        r8 = io.gonative.android.p038a.C0702c.m1897a(r8, r9);	 Catch:{ Exception -> 0x0827 }
        r9 = r0.optJSONObject(r1);	 Catch:{ Exception -> 0x0827 }
        r10 = "to";
        r9 = io.gonative.android.p038a.C0702c.m1897a(r9, r10);	 Catch:{ Exception -> 0x0827 }
        if (r8 == 0) goto L_0x03b8;
    L_0x03b1:
        if (r9 == 0) goto L_0x03b8;
    L_0x03b3:
        r10 = r13.f1521Q;	 Catch:{ Exception -> 0x0827 }
        r10.put(r8, r9);	 Catch:{ Exception -> 0x0827 }
    L_0x03b8:
        r1 = r1 + 1;
        goto L_0x0395;
    L_0x03bb:
        r13.f1521Q = r5;	 Catch:{ Exception -> 0x0827 }
    L_0x03bd:
        r0 = "segmentedControl";
        r0 = r14.optJSONObject(r0);	 Catch:{ Exception -> 0x0827 }
        r13.m1874d(r0);	 Catch:{ Exception -> 0x0827 }
        r0 = "androidShowOfflinePage";
        r14 = r14.optBoolean(r0, r2);	 Catch:{ Exception -> 0x0827 }
        r13.f1523S = r14;	 Catch:{ Exception -> 0x0827 }
    L_0x03ce:
        r14 = r13.f1532d;	 Catch:{ Exception -> 0x0827 }
        r0 = "styling";
        r14 = r14.optJSONObject(r0);	 Catch:{ Exception -> 0x0827 }
        r0 = "customCSS";
        r0 = io.gonative.android.p038a.C0700a.m1852a(r14, r0);	 Catch:{ Exception -> 0x0827 }
        r13.ha = r0;	 Catch:{ Exception -> 0x0827 }
        r0 = r13.ha;	 Catch:{ Exception -> 0x0827 }
        if (r0 == 0) goto L_0x03ec;
    L_0x03e2:
        r0 = r13.ha;	 Catch:{ Exception -> 0x0827 }
        r0 = r0.isEmpty();	 Catch:{ Exception -> 0x0827 }
        if (r0 != 0) goto L_0x03ec;
    L_0x03ea:
        r13.vb = r2;	 Catch:{ Exception -> 0x0827 }
    L_0x03ec:
        r0 = "forceViewportWidth";
        r8 = 9221120237041090560; // 0x7ff8000000000000 float:0.0 double:NaN;
        r0 = r14.optDouble(r0, r8);	 Catch:{ Exception -> 0x0827 }
        r13.ia = r0;	 Catch:{ Exception -> 0x0827 }
        r0 = r13.ia;	 Catch:{ Exception -> 0x0827 }
        r0 = java.lang.Double.isNaN(r0);	 Catch:{ Exception -> 0x0827 }
        if (r0 != 0) goto L_0x0400;
    L_0x03fe:
        r13.vb = r2;	 Catch:{ Exception -> 0x0827 }
    L_0x0400:
        r0 = "zoomableForceViewport";
        r0 = r14.optBoolean(r0, r3);	 Catch:{ Exception -> 0x0827 }
        r13.ja = r0;	 Catch:{ Exception -> 0x0827 }
        r0 = "showActionBar";
        r0 = r14.optBoolean(r0, r2);	 Catch:{ Exception -> 0x0827 }
        r13.ma = r0;	 Catch:{ Exception -> 0x0827 }
        r0 = "androidTheme";
        r0 = io.gonative.android.p038a.C0700a.m1852a(r14, r0);	 Catch:{ Exception -> 0x0827 }
        r13.ka = r0;	 Catch:{ Exception -> 0x0827 }
        r0 = "androidSidebarBackgroundColor";
        r0 = io.gonative.android.p038a.C0700a.m1852a(r14, r0);	 Catch:{ Exception -> 0x0827 }
        r0 = io.gonative.android.p038a.C0702c.m1896a(r0);	 Catch:{ Exception -> 0x0827 }
        r13.ba = r0;	 Catch:{ Exception -> 0x0827 }
        r0 = "androidSidebarForegroundColor";
        r0 = io.gonative.android.p038a.C0700a.m1852a(r14, r0);	 Catch:{ Exception -> 0x0827 }
        r0 = io.gonative.android.p038a.C0702c.m1896a(r0);	 Catch:{ Exception -> 0x0827 }
        r13.ca = r0;	 Catch:{ Exception -> 0x0827 }
        r0 = "androidTintColor";
        r0 = io.gonative.android.p038a.C0700a.m1852a(r14, r0);	 Catch:{ Exception -> 0x0827 }
        r0 = io.gonative.android.p038a.C0702c.m1896a(r0);	 Catch:{ Exception -> 0x0827 }
        r13.da = r0;	 Catch:{ Exception -> 0x0827 }
        r0 = "androidTabBarBackgroundColor";
        r0 = io.gonative.android.p038a.C0700a.m1852a(r14, r0);	 Catch:{ Exception -> 0x0827 }
        r0 = io.gonative.android.p038a.C0702c.m1896a(r0);	 Catch:{ Exception -> 0x0827 }
        r13.fa = r0;	 Catch:{ Exception -> 0x0827 }
        r0 = "androidTabBarTextColor";
        r0 = io.gonative.android.p038a.C0700a.m1852a(r14, r0);	 Catch:{ Exception -> 0x0827 }
        r0 = io.gonative.android.p038a.C0702c.m1896a(r0);	 Catch:{ Exception -> 0x0827 }
        r13.ea = r0;	 Catch:{ Exception -> 0x0827 }
        r0 = "androidTabBarIndicatorColor";
        r0 = io.gonative.android.p038a.C0700a.m1852a(r14, r0);	 Catch:{ Exception -> 0x0827 }
        r0 = io.gonative.android.p038a.C0702c.m1896a(r0);	 Catch:{ Exception -> 0x0827 }
        r13.ga = r0;	 Catch:{ Exception -> 0x0827 }
        r0 = "transitionInteractiveDelayMax";
        r0 = r14.optDouble(r0, r8);	 Catch:{ Exception -> 0x0827 }
        r13.na = r0;	 Catch:{ Exception -> 0x0827 }
        r0 = "androidHideTitleInActionBar";
        r0 = r14.optBoolean(r0, r3);	 Catch:{ Exception -> 0x0827 }
        r13.pa = r0;	 Catch:{ Exception -> 0x0827 }
        r0 = "androidShowLogoInActionBar";
        r1 = r13.pa;	 Catch:{ Exception -> 0x0827 }
        r0 = r14.optBoolean(r0, r1);	 Catch:{ Exception -> 0x0827 }
        r13.qa = r0;	 Catch:{ Exception -> 0x0827 }
        r0 = "androidActionBarForegroundColor";
        r0 = io.gonative.android.p038a.C0700a.m1852a(r14, r0);	 Catch:{ Exception -> 0x0827 }
        r0 = io.gonative.android.p038a.C0702c.m1896a(r0);	 Catch:{ Exception -> 0x0827 }
        r13.la = r0;	 Catch:{ Exception -> 0x0827 }
        r0 = r13.la;	 Catch:{ Exception -> 0x0827 }
        if (r0 != 0) goto L_0x04a7;
    L_0x048a:
        r0 = r13.ka;	 Catch:{ Exception -> 0x0827 }
        if (r0 == 0) goto L_0x04a1;
    L_0x048e:
        r0 = r13.ka;	 Catch:{ Exception -> 0x0827 }
        r1 = "light";
        r0 = r0.equalsIgnoreCase(r1);	 Catch:{ Exception -> 0x0827 }
        if (r0 == 0) goto L_0x04a1;
    L_0x0498:
        r0 = -16777216; // 0xffffffffff000000 float:-1.7014118E38 double:NaN;
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x0827 }
    L_0x049e:
        r13.la = r0;	 Catch:{ Exception -> 0x0827 }
        goto L_0x04a7;
    L_0x04a1:
        r0 = -1;
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x0827 }
        goto L_0x049e;
    L_0x04a7:
        r0 = "navigationTitleImage";
        r0 = r14.opt(r0);	 Catch:{ Exception -> 0x0827 }
        r13.m1863b(r0);	 Catch:{ Exception -> 0x0827 }
        r0 = "hideWebviewAlpha";
        r10 = 0;
        r0 = r14.optDouble(r0, r10);	 Catch:{ Exception -> 0x0827 }
        r0 = (float) r0;	 Catch:{ Exception -> 0x0827 }
        r13.ta = r0;	 Catch:{ Exception -> 0x0827 }
        r0 = "androidPullToRefreshColor";
        r0 = io.gonative.android.p038a.C0700a.m1852a(r14, r0);	 Catch:{ Exception -> 0x0827 }
        r0 = io.gonative.android.p038a.C0702c.m1896a(r0);	 Catch:{ Exception -> 0x0827 }
        r13.ua = r0;	 Catch:{ Exception -> 0x0827 }
        r0 = "androidShowSplash";
        r0 = r14.optBoolean(r0, r3);	 Catch:{ Exception -> 0x0827 }
        r13.va = r0;	 Catch:{ Exception -> 0x0827 }
        r0 = "androidShowSplashMaxTime";
        r10 = 4609434218613702656; // 0x3ff8000000000000 float:0.0 double:1.5;
        r0 = r14.optDouble(r0, r10);	 Catch:{ Exception -> 0x0827 }
        r13.wa = r0;	 Catch:{ Exception -> 0x0827 }
        r0 = "androidShowSplashForceTime";
        r0 = r14.optDouble(r0, r8);	 Catch:{ Exception -> 0x0827 }
        r13.xa = r0;	 Catch:{ Exception -> 0x0827 }
        r0 = "disableAnimations";
        r14 = r14.optBoolean(r0, r3);	 Catch:{ Exception -> 0x0827 }
        r13.ya = r14;	 Catch:{ Exception -> 0x0827 }
        r14 = r13.f1532d;	 Catch:{ Exception -> 0x0827 }
        r0 = "permissions";
        r14 = r14.optJSONObject(r0);	 Catch:{ Exception -> 0x0827 }
        if (r14 == 0) goto L_0x050b;
    L_0x04f3:
        r0 = "usesGeolocation";
        r0 = r14.optBoolean(r0, r3);	 Catch:{ Exception -> 0x0827 }
        r13.Fa = r0;	 Catch:{ Exception -> 0x0827 }
        r0 = "androidDownloadToPublicStorage";
        r0 = r14.optBoolean(r0, r3);	 Catch:{ Exception -> 0x0827 }
        r13.Ga = r0;	 Catch:{ Exception -> 0x0827 }
        r0 = "enableWebRTC";
        r14 = r14.optBoolean(r0, r3);	 Catch:{ Exception -> 0x0827 }
        r13.f1553y = r14;	 Catch:{ Exception -> 0x0827 }
    L_0x050b:
        r14 = r13.f1532d;	 Catch:{ Exception -> 0x0827 }
        r0 = "services";
        r14 = r14.optJSONObject(r0);	 Catch:{ Exception -> 0x0827 }
        if (r14 == 0) goto L_0x07f8;
    L_0x0515:
        r0 = "analytics";
        r0 = r14.optJSONObject(r0);	 Catch:{ Exception -> 0x0827 }
        if (r0 == 0) goto L_0x0548;
    L_0x051d:
        r1 = r0.optBoolean(r7, r3);	 Catch:{ Exception -> 0x0827 }
        if (r1 == 0) goto L_0x0548;
    L_0x0523:
        r1 = "idsite_test";
        r1 = r0.optInt(r1, r4);	 Catch:{ Exception -> 0x0827 }
        r13.Ia = r1;	 Catch:{ Exception -> 0x0827 }
        r1 = "idsite_prod";
        r0 = r0.optInt(r1, r4);	 Catch:{ Exception -> 0x0827 }
        r13.Ja = r0;	 Catch:{ Exception -> 0x0827 }
        r0 = r13.Ia;	 Catch:{ Exception -> 0x0827 }
        if (r0 == r4) goto L_0x053f;
    L_0x0537:
        r0 = r13.Ja;	 Catch:{ Exception -> 0x0827 }
        if (r0 != r4) goto L_0x053c;
    L_0x053b:
        goto L_0x053f;
    L_0x053c:
        r13.Ha = r2;	 Catch:{ Exception -> 0x0827 }
        goto L_0x0548;
    L_0x053f:
        r0 = f1503a;	 Catch:{ Exception -> 0x0827 }
        r1 = "Analytics requires idsite_test and idsite_prod";
        android.util.Log.w(r0, r1);	 Catch:{ Exception -> 0x0827 }
        r13.Ha = r3;	 Catch:{ Exception -> 0x0827 }
    L_0x0548:
        r0 = "oneSignal";
        r0 = r14.optJSONObject(r0);	 Catch:{ Exception -> 0x0827 }
        r1 = "applicationId";
        if (r0 == 0) goto L_0x0577;
    L_0x0552:
        r4 = r0.optBoolean(r7);	 Catch:{ Exception -> 0x0827 }
        if (r4 == 0) goto L_0x0577;
    L_0x0558:
        r4 = io.gonative.android.p038a.C0700a.m1852a(r0, r1);	 Catch:{ Exception -> 0x0827 }
        r13.La = r4;	 Catch:{ Exception -> 0x0827 }
        r4 = r13.La;	 Catch:{ Exception -> 0x0827 }
        if (r4 == 0) goto L_0x0564;
    L_0x0562:
        r4 = 1;
        goto L_0x0565;
    L_0x0564:
        r4 = 0;
    L_0x0565:
        r13.Ka = r4;	 Catch:{ Exception -> 0x0827 }
        r4 = "tagsJsonUrl";
        r4 = io.gonative.android.p038a.C0700a.m1852a(r0, r4);	 Catch:{ Exception -> 0x0827 }
        r13.Ma = r4;	 Catch:{ Exception -> 0x0827 }
        r4 = "requiresUserPrivacyConsent";
        r0 = r0.optBoolean(r4);	 Catch:{ Exception -> 0x0827 }
        r13.Na = r0;	 Catch:{ Exception -> 0x0827 }
    L_0x0577:
        r0 = "xtremepushAndroid";
        r0 = r14.optJSONObject(r0);	 Catch:{ Exception -> 0x0827 }
        if (r0 != 0) goto L_0x0585;
    L_0x057f:
        r0 = "xtremepush";
        r0 = r14.optJSONObject(r0);	 Catch:{ Exception -> 0x0827 }
    L_0x0585:
        if (r0 == 0) goto L_0x05a6;
    L_0x0587:
        r4 = r0.optBoolean(r7);	 Catch:{ Exception -> 0x0827 }
        if (r4 == 0) goto L_0x05a6;
    L_0x058d:
        r4 = "appKey";
        r4 = io.gonative.android.p038a.C0700a.m1852a(r0, r4);	 Catch:{ Exception -> 0x0827 }
        r13.Pa = r4;	 Catch:{ Exception -> 0x0827 }
        r4 = r13.Pa;	 Catch:{ Exception -> 0x0827 }
        if (r4 == 0) goto L_0x059b;
    L_0x0599:
        r4 = 1;
        goto L_0x059c;
    L_0x059b:
        r4 = 0;
    L_0x059c:
        r13.Oa = r4;	 Catch:{ Exception -> 0x0827 }
        r4 = "googleProjectId";
        r0 = io.gonative.android.p038a.C0700a.m1852a(r0, r4);	 Catch:{ Exception -> 0x0827 }
        r13.Qa = r0;	 Catch:{ Exception -> 0x0827 }
    L_0x05a6:
        r0 = "cleverpush";
        r0 = r14.optJSONObject(r0);	 Catch:{ Exception -> 0x0827 }
        if (r0 == 0) goto L_0x05c6;
    L_0x05ae:
        r4 = r0.optBoolean(r7);	 Catch:{ Exception -> 0x0827 }
        if (r4 == 0) goto L_0x05c6;
    L_0x05b4:
        r13.Ra = r2;	 Catch:{ Exception -> 0x0827 }
        r4 = "channelId";
        r4 = io.gonative.android.p038a.C0700a.m1852a(r0, r4);	 Catch:{ Exception -> 0x0827 }
        r13.Sa = r4;	 Catch:{ Exception -> 0x0827 }
        r4 = "autoRegister";
        r0 = r0.optBoolean(r4, r2);	 Catch:{ Exception -> 0x0827 }
        r13.Ta = r0;	 Catch:{ Exception -> 0x0827 }
    L_0x05c6:
        r0 = "ibmpushAndroid";
        r0 = r14.optJSONObject(r0);	 Catch:{ Exception -> 0x0827 }
        if (r0 != 0) goto L_0x05d4;
    L_0x05ce:
        r0 = "ibmpush";
        r0 = r14.optJSONObject(r0);	 Catch:{ Exception -> 0x0827 }
    L_0x05d4:
        if (r0 == 0) goto L_0x05e0;
    L_0x05d6:
        r4 = r0.optBoolean(r7);	 Catch:{ Exception -> 0x0827 }
        if (r4 == 0) goto L_0x05e0;
    L_0x05dc:
        r13.Ua = r2;	 Catch:{ Exception -> 0x0827 }
        r13.Va = r0;	 Catch:{ Exception -> 0x0827 }
    L_0x05e0:
        r0 = "facebook";
        r0 = r14.optJSONObject(r0);	 Catch:{ Exception -> 0x0827 }
        if (r0 == 0) goto L_0x0607;
    L_0x05e8:
        r4 = r0.optBoolean(r7);	 Catch:{ Exception -> 0x0827 }
        if (r4 == 0) goto L_0x0607;
    L_0x05ee:
        r4 = "appId";
        r4 = io.gonative.android.p038a.C0700a.m1852a(r0, r4);	 Catch:{ Exception -> 0x0827 }
        r13.Xa = r4;	 Catch:{ Exception -> 0x0827 }
        r4 = "displayName";
        r0 = io.gonative.android.p038a.C0700a.m1852a(r0, r4);	 Catch:{ Exception -> 0x0827 }
        r13.Ya = r0;	 Catch:{ Exception -> 0x0827 }
        r0 = r13.Xa;	 Catch:{ Exception -> 0x0827 }
        if (r0 == 0) goto L_0x0604;
    L_0x0602:
        r0 = 1;
        goto L_0x0605;
    L_0x0604:
        r0 = 0;
    L_0x0605:
        r13.Wa = r0;	 Catch:{ Exception -> 0x0827 }
    L_0x0607:
        r0 = "adjust";
        r0 = r14.optJSONObject(r0);	 Catch:{ Exception -> 0x0827 }
        if (r0 == 0) goto L_0x0627;
    L_0x060f:
        r4 = r0.optBoolean(r7);	 Catch:{ Exception -> 0x0827 }
        if (r4 == 0) goto L_0x0627;
    L_0x0615:
        r13.Za = r2;	 Catch:{ Exception -> 0x0827 }
        r4 = "appToken";
        r4 = io.gonative.android.p038a.C0700a.m1852a(r0, r4);	 Catch:{ Exception -> 0x0827 }
        r13._a = r4;	 Catch:{ Exception -> 0x0827 }
        r4 = "environment";
        r0 = io.gonative.android.p038a.C0700a.m1852a(r0, r4);	 Catch:{ Exception -> 0x0827 }
        r13.ab = r0;	 Catch:{ Exception -> 0x0827 }
    L_0x0627:
        r0 = "appsflyer";
        r0 = r14.optJSONObject(r0);	 Catch:{ Exception -> 0x0827 }
        if (r0 == 0) goto L_0x063f;
    L_0x062f:
        r4 = r0.optBoolean(r7);	 Catch:{ Exception -> 0x0827 }
        if (r4 == 0) goto L_0x063f;
    L_0x0635:
        r13.cb = r2;	 Catch:{ Exception -> 0x0827 }
        r4 = "devKey";
        r0 = io.gonative.android.p038a.C0700a.m1852a(r0, r4);	 Catch:{ Exception -> 0x0827 }
        r13.bb = r0;	 Catch:{ Exception -> 0x0827 }
    L_0x063f:
        r0 = "identity";
        r0 = r14.optJSONObject(r0);	 Catch:{ Exception -> 0x0827 }
        if (r0 == 0) goto L_0x0697;
    L_0x0647:
        r4 = r0.optBoolean(r7);	 Catch:{ Exception -> 0x0827 }
        if (r4 == 0) goto L_0x0697;
    L_0x064d:
        r4 = new java.util.LinkedList;	 Catch:{ Exception -> 0x0827 }
        r4.<init>();	 Catch:{ Exception -> 0x0827 }
        r13.db = r4;	 Catch:{ Exception -> 0x0827 }
        r8 = "checkIdentityUrl";
        r8 = r0.opt(r8);	 Catch:{ Exception -> 0x0827 }
        if (r8 == 0) goto L_0x066a;
    L_0x065c:
        r9 = r8 instanceof java.lang.String;	 Catch:{ Exception -> 0x0827 }
        if (r9 == 0) goto L_0x066a;
    L_0x0660:
        r8 = (java.lang.String) r8;	 Catch:{ Exception -> 0x0827 }
        r8 = java.util.regex.Pattern.compile(r8);	 Catch:{ Exception -> 0x0827 }
        r4.add(r8);	 Catch:{ Exception -> 0x0827 }
        goto L_0x068f;
    L_0x066a:
        if (r8 == 0) goto L_0x068f;
    L_0x066c:
        r9 = r8 instanceof org.json.JSONArray;	 Catch:{ Exception -> 0x0827 }
        if (r9 == 0) goto L_0x068f;
    L_0x0670:
        r8 = (org.json.JSONArray) r8;	 Catch:{ Exception -> 0x0827 }
        r9 = 0;
    L_0x0673:
        r10 = r8.length();	 Catch:{ Exception -> 0x0827 }
        if (r9 >= r10) goto L_0x068f;
    L_0x0679:
        r10 = r8.optString(r9);	 Catch:{ Exception -> 0x0827 }
        if (r10 == 0) goto L_0x068c;
    L_0x067f:
        r11 = r10.isEmpty();	 Catch:{ Exception -> 0x0827 }
        if (r11 != 0) goto L_0x068c;
    L_0x0685:
        r10 = java.util.regex.Pattern.compile(r10);	 Catch:{ Exception -> 0x0827 }
        r4.add(r10);	 Catch:{ Exception -> 0x0827 }
    L_0x068c:
        r9 = r9 + 1;
        goto L_0x0673;
    L_0x068f:
        r4 = "identityEndpointUrl";
        r0 = io.gonative.android.p038a.C0700a.m1852a(r0, r4);	 Catch:{ Exception -> 0x0827 }
        r13.eb = r0;	 Catch:{ Exception -> 0x0827 }
    L_0x0697:
        r0 = "registration";
        r0 = r14.optJSONObject(r0);	 Catch:{ Exception -> 0x0827 }
        if (r0 == 0) goto L_0x06ad;
    L_0x069f:
        r4 = r0.optBoolean(r7);	 Catch:{ Exception -> 0x0827 }
        if (r4 == 0) goto L_0x06ad;
    L_0x06a5:
        r4 = "endpoints";
        r0 = r0.optJSONArray(r4);	 Catch:{ Exception -> 0x0827 }
        r13.fb = r0;	 Catch:{ Exception -> 0x0827 }
    L_0x06ad:
        r0 = "admobAndroid";
        r0 = r14.optJSONObject(r0);	 Catch:{ Exception -> 0x0827 }
        if (r0 == 0) goto L_0x06f5;
    L_0x06b5:
        r4 = r0.optBoolean(r7);	 Catch:{ Exception -> 0x0827 }
        if (r4 == 0) goto L_0x06f5;
    L_0x06bb:
        r1 = io.gonative.android.p038a.C0700a.m1852a(r0, r1);	 Catch:{ Exception -> 0x0827 }
        if (r1 == 0) goto L_0x06f5;
    L_0x06c1:
        r1 = r1.isEmpty();	 Catch:{ Exception -> 0x0827 }
        if (r1 != 0) goto L_0x06f5;
    L_0x06c7:
        r13.hb = r2;	 Catch:{ Exception -> 0x0827 }
        r1 = "bannerAdUnitId";
        r1 = io.gonative.android.p038a.C0700a.m1852a(r0, r1);	 Catch:{ Exception -> 0x0827 }
        r13.ib = r1;	 Catch:{ Exception -> 0x0827 }
        r1 = r13.ib;	 Catch:{ Exception -> 0x0827 }
        if (r1 == 0) goto L_0x06df;
    L_0x06d5:
        r1 = r13.ib;	 Catch:{ Exception -> 0x0827 }
        r1 = r1.isEmpty();	 Catch:{ Exception -> 0x0827 }
        if (r1 == 0) goto L_0x06df;
    L_0x06dd:
        r13.ib = r5;	 Catch:{ Exception -> 0x0827 }
    L_0x06df:
        r1 = "interstitialAdUnitId";
        r0 = io.gonative.android.p038a.C0700a.m1852a(r0, r1);	 Catch:{ Exception -> 0x0827 }
        r13.jb = r0;	 Catch:{ Exception -> 0x0827 }
        r0 = r13.jb;	 Catch:{ Exception -> 0x0827 }
        if (r0 == 0) goto L_0x06f5;
    L_0x06eb:
        r0 = r13.jb;	 Catch:{ Exception -> 0x0827 }
        r0 = r0.isEmpty();	 Catch:{ Exception -> 0x0827 }
        if (r0 == 0) goto L_0x06f5;
    L_0x06f3:
        r13.jb = r5;	 Catch:{ Exception -> 0x0827 }
    L_0x06f5:
        r0 = "cardIO";
        r0 = r14.optJSONObject(r0);	 Catch:{ Exception -> 0x0827 }
        if (r0 == 0) goto L_0x0705;
    L_0x06fd:
        r0 = r0.optBoolean(r7);	 Catch:{ Exception -> 0x0827 }
        if (r0 == 0) goto L_0x0705;
    L_0x0703:
        r13.kb = r2;	 Catch:{ Exception -> 0x0827 }
    L_0x0705:
        r0 = "auth";
        r0 = r14.optJSONObject(r0);	 Catch:{ Exception -> 0x0827 }
        if (r0 == 0) goto L_0x074a;
    L_0x070d:
        r1 = r0.optBoolean(r7);	 Catch:{ Exception -> 0x0827 }
        if (r1 == 0) goto L_0x074a;
    L_0x0713:
        r13.ob = r2;	 Catch:{ Exception -> 0x0827 }
        r1 = "allowdUrls";
        r0 = r0.opt(r1);	 Catch:{ Exception -> 0x0827 }
        r1 = r0 instanceof java.lang.String;	 Catch:{ Exception -> 0x0827 }
        if (r1 == 0) goto L_0x072b;
    L_0x071f:
        r1 = r13.pb;	 Catch:{ Exception -> 0x0827 }
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x0827 }
        r0 = java.util.regex.Pattern.compile(r0);	 Catch:{ Exception -> 0x0827 }
        r1.add(r0);	 Catch:{ Exception -> 0x0827 }
        goto L_0x074a;
    L_0x072b:
        r1 = r0 instanceof org.json.JSONArray;	 Catch:{ Exception -> 0x0827 }
        if (r1 == 0) goto L_0x074a;
    L_0x072f:
        r0 = (org.json.JSONArray) r0;	 Catch:{ Exception -> 0x0827 }
        r1 = 0;
    L_0x0732:
        r4 = r0.length();	 Catch:{ Exception -> 0x0827 }
        if (r1 >= r4) goto L_0x074a;
    L_0x0738:
        r4 = r0.optString(r1);	 Catch:{ Exception -> 0x0827 }
        if (r4 == 0) goto L_0x0747;
    L_0x073e:
        r8 = r13.pb;	 Catch:{ Exception -> 0x0827 }
        r4 = java.util.regex.Pattern.compile(r4);	 Catch:{ Exception -> 0x0827 }
        r8.add(r4);	 Catch:{ Exception -> 0x0827 }
    L_0x0747:
        r1 = r1 + 1;
        goto L_0x0732;
    L_0x074a:
        r0 = "chromecast";
        r0 = r14.optJSONObject(r0);	 Catch:{ Exception -> 0x0827 }
        if (r0 == 0) goto L_0x0762;
    L_0x0752:
        r1 = r0.optBoolean(r7);	 Catch:{ Exception -> 0x0827 }
        if (r1 == 0) goto L_0x0762;
    L_0x0758:
        r13.lb = r2;	 Catch:{ Exception -> 0x0827 }
        r1 = "receiverAppId";
        r1 = io.gonative.android.p038a.C0700a.m1852a(r0, r1);	 Catch:{ Exception -> 0x0827 }
        r13.mb = r1;	 Catch:{ Exception -> 0x0827 }
    L_0x0762:
        r1 = r13.lb;	 Catch:{ Exception -> 0x0827 }
        if (r1 == 0) goto L_0x07ac;
    L_0x0766:
        r1 = new java.util.ArrayList;	 Catch:{ Exception -> 0x0827 }
        r1.<init>();	 Catch:{ Exception -> 0x0827 }
        r13.nb = r1;	 Catch:{ Exception -> 0x0827 }
        r1 = "showCastButtonRegex";
        r0 = r0.opt(r1);	 Catch:{ Exception -> 0x0827 }
        r1 = r0 instanceof java.lang.String;	 Catch:{ Exception -> 0x0827 }
        if (r1 == 0) goto L_0x0783;
    L_0x0777:
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x0827 }
        r0 = java.util.regex.Pattern.compile(r0);	 Catch:{ Exception -> 0x0827 }
        r1 = r13.nb;	 Catch:{ Exception -> 0x0827 }
        r1.add(r0);	 Catch:{ Exception -> 0x0827 }
        goto L_0x07ac;
    L_0x0783:
        r1 = r0 instanceof org.json.JSONArray;	 Catch:{ Exception -> 0x0827 }
        if (r1 == 0) goto L_0x07a1;
    L_0x0787:
        r0 = (org.json.JSONArray) r0;	 Catch:{ Exception -> 0x0827 }
    L_0x0789:
        r1 = r0.length();	 Catch:{ Exception -> 0x0827 }
        if (r3 >= r1) goto L_0x07ac;
    L_0x078f:
        r1 = r0.optString(r3);	 Catch:{ Exception -> 0x0827 }
        if (r1 == 0) goto L_0x079e;
    L_0x0795:
        r4 = r13.nb;	 Catch:{ Exception -> 0x0827 }
        r1 = java.util.regex.Pattern.compile(r1);	 Catch:{ Exception -> 0x0827 }
        r4.add(r1);	 Catch:{ Exception -> 0x0827 }
    L_0x079e:
        r3 = r3 + 1;
        goto L_0x0789;
    L_0x07a1:
        r0 = r13.nb;	 Catch:{ Exception -> 0x0827 }
        r1 = ".*";
        r1 = java.util.regex.Pattern.compile(r1);	 Catch:{ Exception -> 0x0827 }
        r0.add(r1);	 Catch:{ Exception -> 0x0827 }
    L_0x07ac:
        r0 = "documentScanner";
        r0 = r14.optJSONObject(r0);	 Catch:{ Exception -> 0x0827 }
        if (r0 == 0) goto L_0x07d0;
    L_0x07b4:
        r1 = r0.optBoolean(r7);	 Catch:{ Exception -> 0x0827 }
        if (r1 == 0) goto L_0x07d0;
    L_0x07ba:
        r13.qb = r2;	 Catch:{ Exception -> 0x0827 }
        r1 = "androidAnylineLicenseKey";
        r1 = io.gonative.android.p038a.C0700a.m1852a(r0, r1);	 Catch:{ Exception -> 0x0827 }
        r13.rb = r1;	 Catch:{ Exception -> 0x0827 }
        r1 = r13.rb;	 Catch:{ Exception -> 0x0827 }
        if (r1 != 0) goto L_0x07d0;
    L_0x07c8:
        r1 = "anylineLicenseKey";
        r0 = io.gonative.android.p038a.C0700a.m1852a(r0, r1);	 Catch:{ Exception -> 0x0827 }
        r13.rb = r0;	 Catch:{ Exception -> 0x0827 }
    L_0x07d0:
        r0 = "scandit";
        r14 = r14.optJSONObject(r0);	 Catch:{ Exception -> 0x0827 }
        if (r14 == 0) goto L_0x07f8;
    L_0x07d8:
        r0 = r14.optBoolean(r7);	 Catch:{ Exception -> 0x0827 }
        if (r0 == 0) goto L_0x07f8;
    L_0x07de:
        r0 = "androidLicenseKey";
        r0 = io.gonative.android.p038a.C0700a.m1852a(r14, r0);	 Catch:{ Exception -> 0x0827 }
        r13.tb = r0;	 Catch:{ Exception -> 0x0827 }
        r0 = r13.tb;	 Catch:{ Exception -> 0x0827 }
        if (r0 != 0) goto L_0x07f2;
    L_0x07ea:
        r0 = "licenseKey";
        r14 = io.gonative.android.p038a.C0700a.m1852a(r14, r0);	 Catch:{ Exception -> 0x0827 }
        r13.tb = r14;	 Catch:{ Exception -> 0x0827 }
    L_0x07f2:
        r14 = r13.tb;	 Catch:{ Exception -> 0x0827 }
        if (r14 == 0) goto L_0x07f8;
    L_0x07f6:
        r13.sb = r2;	 Catch:{ Exception -> 0x0827 }
    L_0x07f8:
        r14 = r13.f1532d;	 Catch:{ Exception -> 0x0827 }
        r0 = "performance";
        r14 = r14.optJSONObject(r0);	 Catch:{ Exception -> 0x0827 }
        if (r14 == 0) goto L_0x081c;
    L_0x0802:
        r0 = "webviewPools";
        r14 = r14.optJSONArray(r0);	 Catch:{ Exception -> 0x0827 }
        if (r14 == 0) goto L_0x081c;
    L_0x080a:
        r13.gb = r14;	 Catch:{ Exception -> 0x0827 }
        r14 = r13.f1531c;	 Catch:{ Exception -> 0x0827 }
        r14 = android.support.v4.content.LocalBroadcastManager.getInstance(r14);	 Catch:{ Exception -> 0x0827 }
        r0 = new android.content.Intent;	 Catch:{ Exception -> 0x0827 }
        r1 = "io.gonative.android.AppConfig.processedWebViewPools";
        r0.<init>(r1);	 Catch:{ Exception -> 0x0827 }
        r14.sendBroadcast(r0);	 Catch:{ Exception -> 0x0827 }
    L_0x081c:
        r14 = r13.f1532d;	 Catch:{ Exception -> 0x0827 }
        r0 = "allowZoom";
        r14 = r14.optBoolean(r0, r2);	 Catch:{ Exception -> 0x0827 }
        r13.ub = r14;	 Catch:{ Exception -> 0x0827 }
        goto L_0x0839;
    L_0x0827:
        r14 = move-exception;
        goto L_0x082e;
    L_0x0829:
        r14 = move-exception;
        r6 = r5;
        goto L_0x0844;
    L_0x082c:
        r14 = move-exception;
        r6 = r5;
    L_0x082e:
        r0 = f1503a;	 Catch:{ all -> 0x0843 }
        r1 = r14.getMessage();	 Catch:{ all -> 0x0843 }
        android.util.Log.e(r0, r1, r14);	 Catch:{ all -> 0x0843 }
        r13.f1533e = r14;	 Catch:{ all -> 0x0843 }
    L_0x0839:
        io.gonative.android.p038a.C0701b.m1894a(r5);
        io.gonative.android.p038a.C0701b.m1894a(r6);
        r13.m1869c();
        return;
    L_0x0843:
        r14 = move-exception;
    L_0x0844:
        io.gonative.android.p038a.C0701b.m1894a(r5);
        io.gonative.android.p038a.C0701b.m1894a(r6);
        goto L_0x084c;
    L_0x084b:
        throw r14;
    L_0x084c:
        goto L_0x084b;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.gonative.android.a.a.<init>(android.content.Context):void");
    }

    /* renamed from: a */
    public static synchronized C0700a m1851a(Context context) {
        C0700a c0700a;
        synchronized (C0700a.class) {
            if (f1504b == null) {
                f1504b = new C0700a(context.getApplicationContext());
            }
            c0700a = f1504b;
        }
        return c0700a;
    }

    /* renamed from: a */
    public static String m1852a(JSONObject jSONObject, String str) {
        return jSONObject.isNull(str) ? null : jSONObject.optString(str, null);
    }

    /* renamed from: a */
    private void m1856a(JSONArray jSONArray) {
        if (jSONArray != null) {
            this.f1543o = new ArrayList(jSONArray.length());
            this.f1544p = new ArrayList(jSONArray.length());
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    String a = C0700a.m1852a(optJSONObject, "regex");
                    String a2 = C0700a.m1852a(optJSONObject, "userAgent");
                    if (!(a == null || a2 == null)) {
                        try {
                            this.f1543o.add(Pattern.compile(a));
                            this.f1544p.add(a2);
                            this.vb = true;
                        } catch (Throwable e) {
                            Log.e(f1503a, "Syntax error with user agent regex", e);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m1857a(JSONObject jSONObject) {
        String str = "urlChompWords";
        String str2 = "urlRegex";
        String str3 = "title";
        this.f1517M = null;
        if (jSONObject != null && jSONObject.optBoolean("active")) {
            this.f1517M = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("titles");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        String str4 = "regex";
                        String a = C0700a.m1852a(optJSONObject, str4);
                        if (a != null) {
                            try {
                                HashMap hashMap = new HashMap();
                                hashMap.put(str4, Pattern.compile(a));
                                str4 = C0700a.m1852a(optJSONObject, str3);
                                a = C0700a.m1852a(optJSONObject, str2);
                                int optInt = optJSONObject.optInt(str, -1);
                                if (str4 != null) {
                                    hashMap.put(str3, str4);
                                }
                                if (a != null) {
                                    hashMap.put(str2, Pattern.compile(a));
                                }
                                if (optInt >= 0) {
                                    hashMap.put(str, Integer.valueOf(optInt));
                                }
                                this.f1517M.add(hashMap);
                            } catch (Throwable e) {
                                Log.e(f1503a, e.getMessage(), e);
                            }
                        }
                    }
                }
            }
        }
        LocalBroadcastManager.getInstance(this.f1531c).sendBroadcast(new Intent("io.gonative.android.AppConfig.processedNavigationTitles"));
    }

    /* renamed from: b */
    private java.util.Map<java.lang.String, java.lang.Object> m1862b() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        r7 = this;
        r0 = new java.util.HashMap;
        r0.<init>();
        r1 = "platform";
        r2 = "android";
        r0.put(r1, r2);
        r1 = r7.f1537i;
        if (r1 == 0) goto L_0x0015;
    L_0x0010:
        r2 = "publicKey";
        r0.put(r2, r1);
    L_0x0015:
        r1 = r7.f1538j;
        if (r1 == 0) goto L_0x001e;
    L_0x0019:
        r2 = "deviceRegKey";
        r0.put(r2, r1);
    L_0x001e:
        r1 = r7.f1531c;
        r1 = r1.getPackageName();
        r2 = "appId";
        r0.put(r2, r1);
        r2 = r7.f1531c;
        r2 = r2.getPackageManager();
        r3 = 0;
        r4 = r7.f1531c;	 Catch:{ NameNotFoundException -> 0x004c }
        r4 = r4.getPackageName();	 Catch:{ NameNotFoundException -> 0x004c }
        r4 = r2.getPackageInfo(r4, r3);	 Catch:{ NameNotFoundException -> 0x004c }
        r5 = "appVersion";	 Catch:{ NameNotFoundException -> 0x004c }
        r6 = r4.versionName;	 Catch:{ NameNotFoundException -> 0x004c }
        r0.put(r5, r6);	 Catch:{ NameNotFoundException -> 0x004c }
        r5 = "appVersionCode";	 Catch:{ NameNotFoundException -> 0x004c }
        r4 = r4.versionCode;	 Catch:{ NameNotFoundException -> 0x004c }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ NameNotFoundException -> 0x004c }
        r0.put(r5, r4);	 Catch:{ NameNotFoundException -> 0x004c }
    L_0x004c:
        r4 = r7.f1531c;
        r4 = r4.getApplicationInfo();
        r4 = r4.flags;
        r4 = r4 & 2;
        if (r4 == 0) goto L_0x0059;
    L_0x0058:
        r3 = 1;
    L_0x0059:
        r3 = java.lang.Boolean.valueOf(r3);
        r4 = "isDebuggable";
        r0.put(r4, r3);
        r1 = r2.getInstallerPackageName(r1);
        if (r1 != 0) goto L_0x006a;
    L_0x0068:
        r1 = "none";
    L_0x006a:
        r2 = "installer";
        r0.put(r2, r1);
        r1 = java.util.Locale.getDefault();
        r1 = r1.getLanguage();
        r2 = "language";
        r0.put(r2, r1);
        r1 = "os";
        r2 = "Android";
        r0.put(r1, r2);
        r1 = android.os.Build.VERSION.RELEASE;
        r2 = "osVersion";
        r0.put(r2, r1);
        r1 = new java.lang.StringBuilder;
        r2 = android.os.Build.MANUFACTURER;
        r1.<init>(r2);
        r2 = " ";
        r1.append(r2);
        r2 = android.os.Build.MODEL;
        r1.append(r2);
        r1 = r1.toString();
        r2 = "model";
        r0.put(r2, r1);
        r1 = android.os.Build.FINGERPRINT;
        r2 = "hardware";
        r0.put(r2, r1);
        r1 = java.util.TimeZone.getDefault();
        r1 = r1.getID();
        r2 = "timeZone";
        r0.put(r2, r1);
        r1 = r7.f1534f;
        r2 = "initialUrl";
        r0.put(r2, r1);
        r1 = r7.Ka;
        r1 = java.lang.Boolean.valueOf(r1);
        r2 = "oneSignalEnabled";
        r0.put(r2, r1);
        r1 = r7.yb;
        r1 = java.lang.Boolean.valueOf(r1);
        r2 = "isLicensed";
        r0.put(r2, r1);
        r1 = new java.util.HashMap;
        r1.<init>();
        r2 = r7.Ka;
        r2 = java.lang.Boolean.valueOf(r2);
        r3 = "onesignal";
        r1.put(r3, r2);
        r2 = r7.Oa;
        r2 = java.lang.Boolean.valueOf(r2);
        r3 = "xtremepush";
        r1.put(r3, r2);
        r2 = r7.Ra;
        r2 = java.lang.Boolean.valueOf(r2);
        r3 = "cleverpush";
        r1.put(r3, r2);
        r2 = r7.Wa;
        r2 = java.lang.Boolean.valueOf(r2);
        r3 = "facebook";
        r1.put(r3, r2);
        r2 = r7.Za;
        r2 = java.lang.Boolean.valueOf(r2);
        r3 = "adjust";
        r1.put(r3, r2);
        r2 = r7.hb;
        r2 = java.lang.Boolean.valueOf(r2);
        r3 = "admob";
        r1.put(r3, r2);
        r2 = r7.kb;
        r2 = java.lang.Boolean.valueOf(r2);
        r3 = "cardIO";
        r1.put(r3, r2);
        r2 = r7.lb;
        r2 = java.lang.Boolean.valueOf(r2);
        r3 = "chromecast";
        r1.put(r3, r2);
        r2 = r7.ob;
        r2 = java.lang.Boolean.valueOf(r2);
        r3 = "auth";
        r1.put(r3, r2);
        r2 = r7.qb;
        r2 = java.lang.Boolean.valueOf(r2);
        r3 = "documentScanner";
        r1.put(r3, r2);
        r2 = r7.sb;
        r2 = java.lang.Boolean.valueOf(r2);
        r3 = "scandit";
        r1.put(r3, r2);
        r2 = "activeServices";
        r0.put(r2, r1);
        r1 = new java.util.HashMap;
        r1.<init>();
        r2 = "io.gonative.android.CardScanner";
        r3 = io.gonative.android.p038a.C0700a.m1883g(r2);
        r3 = java.lang.Boolean.valueOf(r3);
        r1.put(r2, r3);
        r2 = "io.gonative.android.CastManager";
        r3 = io.gonative.android.p038a.C0700a.m1883g(r2);
        r3 = java.lang.Boolean.valueOf(r3);
        r1.put(r2, r3);
        r2 = "io.gonative.android.Authentication";
        r3 = io.gonative.android.p038a.C0700a.m1883g(r2);
        r3 = java.lang.Boolean.valueOf(r3);
        r1.put(r2, r3);
        r2 = "io.gonative.android.ScanditBarcodeScannerActivity";
        r3 = io.gonative.android.p038a.C0700a.m1883g(r2);
        r3 = java.lang.Boolean.valueOf(r3);
        r1.put(r2, r3);
        r2 = "io.gonative.android.downloadmanager.DownloadsActivity";
        r3 = io.gonative.android.p038a.C0700a.m1883g(r2);
        r3 = java.lang.Boolean.valueOf(r3);
        r1.put(r2, r3);
        r2 = "io.gonative.android.documentscanner.ScanDocumentActivity";
        r3 = io.gonative.android.p038a.C0700a.m1883g(r2);
        r3 = java.lang.Boolean.valueOf(r3);
        r1.put(r2, r3);
        r2 = "io.gonative.android.SharingUtils";
        r3 = io.gonative.android.p038a.C0700a.m1883g(r2);
        r3 = java.lang.Boolean.valueOf(r3);
        r1.put(r2, r3);
        r2 = "gonativeClasses";
        r0.put(r2, r1);
        r1 = "io.gonative.android.LeanWebView";
        r1 = java.lang.Class.forName(r1);	 Catch:{ ClassNotFoundException -> 0x01d2 }
        r1 = r1.getSuperclass();	 Catch:{ ClassNotFoundException -> 0x01d2 }
        if (r1 == 0) goto L_0x01d2;	 Catch:{ ClassNotFoundException -> 0x01d2 }
    L_0x01c9:
        r2 = "webviewParentClass";	 Catch:{ ClassNotFoundException -> 0x01d2 }
        r1 = r1.getName();	 Catch:{ ClassNotFoundException -> 0x01d2 }
        r0.put(r2, r1);	 Catch:{ ClassNotFoundException -> 0x01d2 }
    L_0x01d2:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.gonative.android.a.a.b():java.util.Map<java.lang.String, java.lang.Object>");
    }

    /* renamed from: b */
    private void m1863b(Object obj) {
        if (obj != null && !(obj instanceof Boolean)) {
            this.sa = new ArrayList();
            if (obj instanceof JSONArray) {
                JSONArray jSONArray = (JSONArray) obj;
                for (int i = 0; i < jSONArray.length(); i++) {
                    String optString = jSONArray.optString(i);
                    if (optString != null) {
                        try {
                            this.sa.add(Pattern.compile(optString));
                        } catch (Throwable e) {
                            String str = f1503a;
                            StringBuilder stringBuilder = new StringBuilder("Problem with navigation title image regex: ");
                            stringBuilder.append(e.getMessage());
                            Log.e(str, stringBuilder.toString(), e);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: b */
    private void m1864b(JSONObject jSONObject) {
        this.f1516L = null;
        this.f1515K = null;
        if (jSONObject != null && jSONObject.optBoolean("active")) {
            this.f1515K = new ArrayList();
            this.f1516L = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("levels");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        String a = C0700a.m1852a(optJSONObject, "regex");
                        int optInt = optJSONObject.optInt("level", -1);
                        if (!(a == null || optInt == -1)) {
                            this.f1515K.add(Pattern.compile(a));
                            this.f1516L.add(Integer.valueOf(optInt));
                        }
                    }
                }
            }
        }
        LocalBroadcastManager.getInstance(this.f1531c).sendBroadcast(new Intent("io.gonative.android.AppConfig.processedNavigationLevels"));
    }

    /* renamed from: b */
    private void m1865b(JSONObject jSONObject, String str) {
        try {
            Writer bufferedWriter = new BufferedWriter(new FileWriter(m1879f(str)));
            bufferedWriter.write(jSONObject.toString(4));
            bufferedWriter.close();
        } catch (Throwable e) {
            String str2 = f1503a;
            StringBuilder stringBuilder = new StringBuilder("Error writing to file ");
            stringBuilder.append(str);
            Log.e(str2, stringBuilder.toString(), e);
            m1877e(str);
        }
    }

    /* renamed from: c */
    private static java.util.List<java.util.regex.Pattern> m1868c(java.lang.Object r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1 = r4 instanceof java.lang.String;
        if (r1 == 0) goto L_0x0013;
    L_0x0009:
        r4 = (java.lang.String) r4;
        r4 = java.util.regex.Pattern.compile(r4);	 Catch:{ Exception -> 0x0034 }
        r0.add(r4);	 Catch:{ Exception -> 0x0034 }
        goto L_0x0034;
    L_0x0013:
        r1 = r4 instanceof org.json.JSONArray;
        if (r1 == 0) goto L_0x0034;
    L_0x0017:
        r4 = (org.json.JSONArray) r4;
        r1 = 0;
    L_0x001a:
        r2 = r4.length();
        if (r1 >= r2) goto L_0x0034;
    L_0x0020:
        r2 = r4.get(r1);	 Catch:{ Exception -> 0x0031 }
        r3 = r2 instanceof java.lang.String;	 Catch:{ Exception -> 0x0031 }
        if (r3 == 0) goto L_0x0031;	 Catch:{ Exception -> 0x0031 }
    L_0x0028:
        r2 = (java.lang.String) r2;	 Catch:{ Exception -> 0x0031 }
        r2 = java.util.regex.Pattern.compile(r2);	 Catch:{ Exception -> 0x0031 }
        r0.add(r2);	 Catch:{ Exception -> 0x0031 }
    L_0x0031:
        r1 = r1 + 1;
        goto L_0x001a;
    L_0x0034:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.gonative.android.a.a.c(java.lang.Object):java.util.List<java.util.regex.Pattern>");
    }

    /* renamed from: c */
    private void m1869c() {
        if (this.yb && this.xb > 0 && SystemClock.elapsedRealtime() - this.xb < 1800000) {
            return;
        }
        if (this.yb || this.xb <= 0 || SystemClock.elapsedRealtime() - this.xb >= 60000) {
            new C0699b().execute(new Void[0]);
        }
    }

    /* renamed from: c */
    private void m1870c(JSONObject jSONObject) {
        if (jSONObject != null) {
            int i;
            JSONObject optJSONObject;
            String a;
            this.f1507C = new HashMap();
            this.f1513I = new ArrayList();
            this.f1514J = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("menus");
            int i2 = 0;
            if (optJSONArray != null) {
                i = 0;
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    optJSONObject = optJSONArray.optJSONObject(i3);
                    if (optJSONObject != null && optJSONObject.optBoolean("active", false)) {
                        i++;
                        a = C0700a.m1852a(optJSONObject, "name");
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray("items");
                        if (!(a == null || optJSONArray2 == null)) {
                            this.f1507C.put(a, optJSONArray2);
                            if (a.equals("default")) {
                                this.f1508D = true;
                            }
                        }
                    }
                }
            } else {
                i = 0;
            }
            LocalBroadcastManager.getInstance(this.f1531c).sendBroadcast(new Intent("io.gonative.android.AppConfig.processedMenu"));
            this.f1511G = C0700a.m1852a(jSONObject, "userIdRegex");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("menuSelectionConfig");
            String str = "regex";
            if ((i > 1 || this.Ca) && optJSONObject2 != null) {
                this.f1512H = C0700a.m1852a(optJSONObject2, "testURL");
                optJSONArray = optJSONObject2.optJSONArray("redirectLocations");
                if (optJSONArray != null) {
                    for (i = 0; i < optJSONArray.length(); i++) {
                        optJSONObject = optJSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            a = C0700a.m1852a(optJSONObject, str);
                            if (a != null) {
                                this.f1513I.add(Pattern.compile(a));
                                this.f1514J.add(optJSONObject);
                            }
                        }
                    }
                }
            }
            this.f1509E = new ArrayList();
            this.f1510F = new ArrayList();
            Object opt = jSONObject.opt("sidebarEnabledRegex");
            if (opt != null) {
                if (opt instanceof String) {
                    try {
                        this.f1509E.add(Pattern.compile((String) opt));
                        this.f1510F.add(Boolean.valueOf(true));
                    } catch (Throwable e) {
                        Log.e(f1503a, "Invalid regex for sidebarEnabledRegex", e);
                    }
                } else if (opt instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) opt;
                    while (i2 < jSONArray.length()) {
                        Object opt2 = jSONArray.opt(i2);
                        if (opt2 != null) {
                            String str2 = null;
                            Object valueOf = Boolean.valueOf(true);
                            if (opt2 instanceof String) {
                                str2 = (String) opt2;
                            } else if (opt2 instanceof JSONObject) {
                                optJSONObject2 = (JSONObject) opt2;
                                str2 = C0700a.m1852a(optJSONObject2, str);
                                valueOf = Boolean.valueOf(optJSONObject2.optBoolean("value", true));
                            }
                            if (str2 != null) {
                                try {
                                    this.f1509E.add(Pattern.compile(str2));
                                    this.f1510F.add(valueOf);
                                } catch (Throwable e2) {
                                    Log.e(f1503a, "Invalid regex in sidebarEnabledRegex", e2);
                                }
                            }
                        }
                        i2++;
                    }
                }
            }
        }
    }

    /* renamed from: d */
    private org.json.JSONObject m1873d(java.lang.String r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        r5 = this;
        r0 = r5.m1879f(r6);
        r1 = 0;
        r2 = new java.io.FileInputStream;	 Catch:{ FileNotFoundException -> 0x003a, Exception -> 0x0023 }
        r2.<init>(r0);	 Catch:{ FileNotFoundException -> 0x003a, Exception -> 0x0023 }
        r0 = r2.available();	 Catch:{ FileNotFoundException -> 0x003a, Exception -> 0x0023 }
        r0 = new byte[r0];	 Catch:{ FileNotFoundException -> 0x003a, Exception -> 0x0023 }
        r2.read(r0);	 Catch:{ FileNotFoundException -> 0x003a, Exception -> 0x0023 }
        r2.close();	 Catch:{ FileNotFoundException -> 0x003a, Exception -> 0x0023 }
        r2 = new java.lang.String;	 Catch:{ FileNotFoundException -> 0x003a, Exception -> 0x0023 }
        r3 = "UTF-8";	 Catch:{ FileNotFoundException -> 0x003a, Exception -> 0x0023 }
        r2.<init>(r0, r3);	 Catch:{ FileNotFoundException -> 0x003a, Exception -> 0x0023 }
        r0 = new org.json.JSONObject;	 Catch:{ FileNotFoundException -> 0x003a, Exception -> 0x0023 }
        r0.<init>(r2);	 Catch:{ FileNotFoundException -> 0x003a, Exception -> 0x0023 }
        return r0;
    L_0x0023:
        r0 = move-exception;
        r2 = f1503a;
        r3 = new java.lang.StringBuilder;
        r4 = "Error reading ";
        r3.<init>(r4);
        r3.append(r6);
        r3 = r3.toString();
        android.util.Log.e(r2, r3, r0);
        r5.m1877e(r6);
    L_0x003a:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.gonative.android.a.a.d(java.lang.String):org.json.JSONObject");
    }

    /* renamed from: d */
    private void m1874d(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f1524T = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("items");
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    this.f1524T.add(optJSONObject);
                }
            }
            LocalBroadcastManager.getInstance(this.f1531c).sendBroadcast(new Intent("io.gonative.android.AppConfig.processedSegmentedControl"));
        }
    }

    /* renamed from: e */
    private void m1877e(String str) {
        m1879f(str).delete();
    }

    /* renamed from: e */
    private void m1878e(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f1525U = new HashMap();
            this.f1527W = new ArrayList();
            this.f1526V = new ArrayList();
            if (jSONObject.optBoolean("active")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("tabMenus");
                String str = "id";
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            String a = C0700a.m1852a(optJSONObject, str);
                            JSONArray optJSONArray2 = optJSONObject.optJSONArray("items");
                            if (!(a == null || optJSONArray2 == null)) {
                                this.f1525U.put(a, optJSONArray2);
                            }
                        }
                    }
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("tabSelectionConfig");
                if (optJSONArray3 != null) {
                    for (int i2 = 0; i2 < optJSONArray3.length(); i2++) {
                        JSONObject optJSONObject2 = optJSONArray3.optJSONObject(i2);
                        if (optJSONObject2 != null) {
                            String a2 = C0700a.m1852a(optJSONObject2, "regex");
                            String a3 = C0700a.m1852a(optJSONObject2, str);
                            if (!(a2 == null || a3 == null)) {
                                try {
                                    this.f1526V.add(Pattern.compile(a2));
                                    this.f1527W.add(a3);
                                } catch (PatternSyntaxException e) {
                                    a2 = f1503a;
                                    StringBuilder stringBuilder = new StringBuilder("Problem with tabSelectionConfig pattern. ");
                                    stringBuilder.append(e.getMessage());
                                    Log.w(a2, stringBuilder.toString());
                                }
                            }
                        }
                    }
                }
                LocalBroadcastManager.getInstance(this.f1531c).sendBroadcast(new Intent("io.gonative.android.AppConfig.processedTabNavigation"));
            }
        }
    }

    /* renamed from: f */
    private File m1879f(String str) {
        File file = new File(this.f1531c.getFilesDir(), "gonative-config");
        file.mkdirs();
        return new File(file, str);
    }

    /* renamed from: f */
    private void m1881f(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f1528X = new HashMap();
            this.f1530Z = new ArrayList();
            this.f1529Y = new ArrayList();
            if (jSONObject.optBoolean("active")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("actions");
                String str = "id";
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            String a = C0700a.m1852a(optJSONObject, str);
                            JSONArray optJSONArray2 = optJSONObject.optJSONArray("items");
                            if (!(a == null || optJSONArray2 == null)) {
                                this.f1528X.put(a, optJSONArray2);
                            }
                        }
                    }
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("actionSelection");
                if (optJSONArray3 != null) {
                    for (int i2 = 0; i2 < optJSONArray3.length(); i2++) {
                        JSONObject optJSONObject2 = optJSONArray3.optJSONObject(i2);
                        if (optJSONObject2 != null) {
                            String a2 = C0700a.m1852a(optJSONObject2, "regex");
                            String a3 = C0700a.m1852a(optJSONObject2, str);
                            if (!(a2 == null || a3 == null)) {
                                try {
                                    this.f1529Y.add(Pattern.compile(a2));
                                    this.f1530Z.add(a3);
                                } catch (PatternSyntaxException e) {
                                    a2 = f1503a;
                                    StringBuilder stringBuilder = new StringBuilder("Problem with actionSelection pattern. ");
                                    stringBuilder.append(e.getMessage());
                                    Log.w(a2, stringBuilder.toString());
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: g */
    private static boolean m1883g(java.lang.String r0) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x0005 }
        r0 = 1;
        return r0;
    L_0x0005:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.gonative.android.a.a.g(java.lang.String):boolean");
    }

    /* renamed from: a */
    public File m1887a() {
        return new File(this.f1531c.getFilesDir(), "appConfig.json");
    }

    /* renamed from: a */
    public void m1888a(Object obj) {
        if (obj != null) {
            if (obj instanceof Boolean) {
                this.f1508D = ((Boolean) obj).booleanValue();
            } else if (obj instanceof JSONArray) {
                r1 = new String[2];
                int i = 0;
                r1[0] = "default";
                r1[1] = "loggedIn";
                ArrayList arrayList = new ArrayList(Arrays.asList(r1));
                if (this.f1514J != null) {
                    for (int i2 = 0; i2 < this.f1514J.size(); i2++) {
                        String a = C0700a.m1852a((JSONObject) this.f1514J.get(i2), NotificationCompat.CATEGORY_STATUS);
                        if (a != null) {
                            arrayList.add(a);
                        }
                    }
                }
                this.f1507C = new HashMap();
                while (i < arrayList.size()) {
                    this.f1507C.put(arrayList.get(i), (JSONArray) obj);
                    i++;
                }
            }
            LocalBroadcastManager.getInstance(this.f1531c).sendBroadcast(new Intent("io.gonative.android.AppConfig.processedMenu"));
        }
    }

    /* renamed from: a */
    public void m1889a(JSONObject jSONObject, boolean z) {
        String str = "navlevels.json";
        if (jSONObject != null) {
            m1864b(jSONObject);
            if (z) {
                m1865b(jSONObject, str);
                return;
            }
        }
        jSONObject = this.f1532d.optJSONObject("navigation");
        JSONObject optJSONObject = jSONObject.optJSONObject("androidNaviationLevels");
        if (optJSONObject == null) {
            optJSONObject = jSONObject.optJSONObject("navigationLevels");
        }
        m1864b(optJSONObject);
        if (z) {
            m1877e(str);
        }
    }

    /* renamed from: a */
    public boolean m1890a(String str) {
        m1869c();
        if (str != null) {
            ArrayList arrayList = this.sa;
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    if (((Pattern) it.next()).matcher(str).matches()) {
                        return true;
                    }
                }
                return false;
            }
        }
        return this.qa;
    }

    /* renamed from: b */
    public void m1891b(JSONObject jSONObject, boolean z) {
        String str = "navtitles.json";
        if (jSONObject != null) {
            m1857a(jSONObject);
            if (z) {
                m1865b(jSONObject, str);
                return;
            }
        }
        jSONObject = this.f1532d.optJSONObject("navigation");
        m1857a(jSONObject != null ? jSONObject.optJSONObject("navigationTitles") : null);
        if (z) {
            m1877e(str);
        }
    }

    /* renamed from: b */
    public boolean m1892b(String str) {
        List list = this.f1509E;
        if (list != null) {
            if (!list.isEmpty()) {
                CharSequence charSequence;
                if (str == null) {
                    charSequence = "";
                }
                for (int i = 0; i < this.f1509E.size(); i++) {
                    if (((Pattern) this.f1509E.get(i)).matcher(charSequence).matches()) {
                        return ((Boolean) this.f1510F.get(i)).booleanValue();
                    }
                }
                return false;
            }
        }
        return true;
    }

    /* renamed from: c */
    public String m1893c(String str) {
        if (str == null) {
            CharSequence charSequence = "";
        }
        if (this.f1543o != null) {
            for (int i = 0; i < this.f1543o.size(); i++) {
                if (((Pattern) this.f1543o.get(i)).matcher(charSequence).matches()) {
                    return (String) this.f1544p.get(i);
                }
            }
        }
        return this.f1541m;
    }
}
