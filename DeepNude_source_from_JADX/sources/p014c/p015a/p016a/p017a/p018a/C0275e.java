package p014c.p015a.p016a.p017a.p018a;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import p014c.p015a.p016a.p019b.C0282a;

/* renamed from: c.a.a.a.a.e */
public final class C0275e {
    /* renamed from: a */
    static final String[] f134a = new String[]{"UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT"};
    /* renamed from: b */
    static final int[][] f135b = new int[][]{new int[]{0, 327708, 327710, 327709, 656318}, new int[]{590318, 0, 327710, 327709, 656318}, new int[]{262158, 590300, 0, 590301, 932798}, new int[]{327709, 327708, 656318, 0, 327710}, new int[]{327711, 656380, 656382, 656381, 0}};
    /* renamed from: c */
    private static final int[][] f136c;
    /* renamed from: d */
    static final int[][] f137d;
    /* renamed from: e */
    private final byte[] f138e;

    static {
        int i;
        int[][] iArr = (int[][]) Array.newInstance(int.class, new int[]{5, 256});
        f136c = iArr;
        iArr[0][32] = 1;
        for (i = 65; i <= 90; i++) {
            f136c[0][i] = (i - 65) + 2;
        }
        f136c[1][32] = 1;
        for (i = 97; i <= 122; i++) {
            f136c[1][i] = (i - 97) + 2;
        }
        f136c[2][32] = 1;
        for (i = 48; i <= 57; i++) {
            f136c[2][i] = (i - 48) + 2;
        }
        iArr = f136c;
        iArr[2][44] = 12;
        iArr[2][46] = 13;
        int[] iArr2 = new int[]{0, 32, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, 124, 126, 127};
        for (int i2 = 0; i2 < 28; i2++) {
            f136c[3][iArr2[i2]] = i2;
        }
        int[] iArr3 = new int[]{0, 13, 0, 0, 0, 0, 33, 39, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 91, 93, 123, 125};
        for (int i3 = 0; i3 < 31; i3++) {
            if (iArr3[i3] > 0) {
                f136c[4][iArr3[i3]] = i3;
            }
        }
        int[][] iArr4 = (int[][]) Array.newInstance(int.class, new int[]{6, 6});
        f137d = iArr4;
        for (int[] fill : iArr4) {
            Arrays.fill(fill, -1);
        }
        iArr4 = f137d;
        iArr4[0][4] = 0;
        iArr4[1][4] = 0;
        iArr4[1][0] = 28;
        iArr4[3][4] = 0;
        iArr4[2][4] = 0;
        iArr4[2][0] = 15;
    }

    public C0275e(byte[] bArr) {
        this.f138e = bArr;
    }

    /* renamed from: a */
    private static Collection<C0276g> m167a(Iterable<C0276g> iterable) {
        Collection linkedList = new LinkedList();
        for (C0276g c0276g : iterable) {
            Object obj = 1;
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                C0276g c0276g2 = (C0276g) it.next();
                if (c0276g2.m177a(c0276g)) {
                    obj = null;
                    break;
                } else if (c0276g.m177a(c0276g2)) {
                    it.remove();
                }
            }
            if (obj != null) {
                linkedList.add(c0276g);
            }
        }
        return linkedList;
    }

    /* renamed from: a */
    private Collection<C0276g> m168a(Iterable<C0276g> iterable, int i) {
        Collection linkedList = new LinkedList();
        for (C0276g a : iterable) {
            m171a(a, i, linkedList);
        }
        return C0275e.m167a(linkedList);
    }

    /* renamed from: a */
    private static Collection<C0276g> m169a(Iterable<C0276g> iterable, int i, int i2) {
        Iterable linkedList = new LinkedList();
        for (C0276g a : iterable) {
            C0275e.m170a(a, i, i2, linkedList);
        }
        return C0275e.m167a(linkedList);
    }

    /* renamed from: a */
    private static void m170a(C0276g c0276g, int i, int i2, Collection<C0276g> collection) {
        C0276g b = c0276g.m179b(i);
        collection.add(b.m175a(4, i2));
        if (c0276g.m181c() != 4) {
            collection.add(b.m180b(4, i2));
        }
        if (i2 == 3 || i2 == 4) {
            collection.add(b.m175a(2, 16 - i2).m175a(2, 1));
        }
        if (c0276g.m173a() > 0) {
            collection.add(c0276g.m174a(i).m174a(i + 1));
        }
    }

    /* renamed from: a */
    private void m171a(C0276g c0276g, int i, Collection<C0276g> collection) {
        char c = (char) (this.f138e[i] & 255);
        int i2 = 0;
        Object obj = f136c[c0276g.m181c()][c] > 0 ? 1 : null;
        C0276g c0276g2 = null;
        while (i2 <= 4) {
            int i3 = f136c[i2][c];
            if (i3 > 0) {
                if (c0276g2 == null) {
                    c0276g2 = c0276g.m179b(i);
                }
                if (obj == null || i2 == c0276g.m181c() || i2 == 2) {
                    collection.add(c0276g2.m175a(i2, i3));
                }
                if (obj == null && f137d[c0276g.m181c()][i2] >= 0) {
                    collection.add(c0276g2.m180b(i2, i3));
                }
            }
            i2++;
        }
        if (c0276g.m173a() > 0 || f136c[c0276g.m181c()][c] == 0) {
            collection.add(c0276g.m174a(i));
        }
    }

    /* renamed from: a */
    public C0282a m172a() {
        Iterable singletonList = Collections.singletonList(C0276g.f139a);
        int i = 0;
        while (true) {
            byte[] bArr = this.f138e;
            if (i >= bArr.length) {
                return ((C0276g) Collections.min(singletonList, new C0274d(this))).m176a(this.f138e);
            }
            int i2;
            int i3 = i + 1;
            byte b = i3 < bArr.length ? bArr[i3] : (byte) 0;
            byte b2 = this.f138e[i];
            if (b2 != (byte) 13) {
                if (b2 != (byte) 44) {
                    if (b2 != (byte) 46) {
                        if (b2 == (byte) 58 && b == (byte) 32) {
                            i2 = 5;
                            if (i2 > 0) {
                                singletonList = C0275e.m169a(singletonList, i, i2);
                                i = i3;
                            } else {
                                singletonList = m168a(singletonList, i);
                            }
                            i++;
                        }
                    } else if (b == (byte) 32) {
                        i2 = 3;
                        if (i2 > 0) {
                            singletonList = m168a(singletonList, i);
                        } else {
                            singletonList = C0275e.m169a(singletonList, i, i2);
                            i = i3;
                        }
                        i++;
                    }
                } else if (b == (byte) 32) {
                    i2 = 4;
                    if (i2 > 0) {
                        singletonList = C0275e.m169a(singletonList, i, i2);
                        i = i3;
                    } else {
                        singletonList = m168a(singletonList, i);
                    }
                    i++;
                }
            } else if (b == (byte) 10) {
                i2 = 2;
                if (i2 > 0) {
                    singletonList = m168a(singletonList, i);
                } else {
                    singletonList = C0275e.m169a(singletonList, i, i2);
                    i = i3;
                }
                i++;
            }
            i2 = 0;
            if (i2 > 0) {
                singletonList = C0275e.m169a(singletonList, i, i2);
                i = i3;
            } else {
                singletonList = m168a(singletonList, i);
            }
            i++;
        }
    }
}
