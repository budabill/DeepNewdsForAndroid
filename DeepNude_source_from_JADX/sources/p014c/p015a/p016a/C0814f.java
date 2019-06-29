package p014c.p015a.p016a;

import java.util.Map;
import p014c.p015a.p016a.p017a.C0801a;
import p014c.p015a.p016a.p019b.C0283b;
import p014c.p015a.p016a.p021c.C0807a;
import p014c.p015a.p016a.p023d.C0810p;
import p014c.p015a.p016a.p023d.C0905b;
import p014c.p015a.p016a.p023d.C0907d;
import p014c.p015a.p016a.p023d.C0909f;
import p014c.p015a.p016a.p023d.C0911h;
import p014c.p015a.p016a.p023d.C0913m;
import p014c.p015a.p016a.p023d.C0921j;
import p014c.p015a.p016a.p023d.C0922k;
import p014c.p015a.p016a.p023d.C0924t;
import p014c.p015a.p016a.p024e.C0812a;
import p014c.p015a.p016a.p026f.C0813a;

/* renamed from: c.a.a.f */
public final class C0814f implements C0317i {
    /* renamed from: a */
    public C0283b mo941a(String str, C0278a c0278a, int i, int i2, Map<C0293c, ?> map) {
        C0801a c0922k;
        switch (C0302e.f301a[c0278a.ordinal()]) {
            case 1:
                c0922k = new C0922k();
                break;
            case 2:
                c0922k = new C0924t();
                break;
            case 3:
                c0922k = new C0921j();
                break;
            case 4:
                c0922k = new C0810p();
                break;
            case 5:
                c0922k = new C0813a();
                break;
            case 6:
                c0922k = new C0909f();
                break;
            case 7:
                c0922k = new C0911h();
                break;
            case 8:
                c0922k = new C0907d();
                break;
            case 9:
                c0922k = new C0913m();
                break;
            case 10:
                c0922k = new C0812a();
                break;
            case 11:
                c0922k = new C0905b();
                break;
            case 12:
                c0922k = new C0807a();
                break;
            case 13:
                c0922k = new C0801a();
                break;
            default:
                StringBuilder stringBuilder = new StringBuilder("No encoder available for format ");
                stringBuilder.append(c0278a);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
        return c0922k.mo941a(str, c0278a, i, i2, map);
    }
}
