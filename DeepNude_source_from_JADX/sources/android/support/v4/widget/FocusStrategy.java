package android.support.v4.widget;

import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class FocusStrategy {

    public interface BoundsAdapter<T> {
        void obtainBounds(T t, Rect rect);
    }

    public interface CollectionAdapter<T, V> {
        V get(T t, int i);

        int size(T t);
    }

    private static class SequentialComparator<T> implements Comparator<T> {
        private final BoundsAdapter<T> mAdapter;
        private final boolean mIsLayoutRtl;
        private final Rect mTemp1 = new Rect();
        private final Rect mTemp2 = new Rect();

        SequentialComparator(boolean z, BoundsAdapter<T> boundsAdapter) {
            this.mIsLayoutRtl = z;
            this.mAdapter = boundsAdapter;
        }

        public int compare(T t, T t2) {
            Rect rect = this.mTemp1;
            Rect rect2 = this.mTemp2;
            this.mAdapter.obtainBounds(t, rect);
            this.mAdapter.obtainBounds(t2, rect2);
            int i = rect.top;
            int i2 = rect2.top;
            int i3 = -1;
            if (i < i2) {
                return -1;
            }
            if (i > i2) {
                return 1;
            }
            i = rect.left;
            i2 = rect2.left;
            if (i < i2) {
                if (this.mIsLayoutRtl) {
                    i3 = 1;
                }
                return i3;
            } else if (i > i2) {
                if (!this.mIsLayoutRtl) {
                    i3 = 1;
                }
                return i3;
            } else {
                i = rect.bottom;
                i2 = rect2.bottom;
                if (i < i2) {
                    return -1;
                }
                if (i > i2) {
                    return 1;
                }
                i = rect.right;
                i2 = rect2.right;
                if (i < i2) {
                    if (this.mIsLayoutRtl) {
                        i3 = 1;
                    }
                    return i3;
                } else if (i <= i2) {
                    return 0;
                } else {
                    if (!this.mIsLayoutRtl) {
                        i3 = 1;
                    }
                    return i3;
                }
            }
        }
    }

    private FocusStrategy() {
    }

    private static boolean beamBeats(int i, Rect rect, Rect rect2, Rect rect3) {
        boolean beamsOverlap = beamsOverlap(i, rect, rect2);
        if (!beamsOverlap(i, rect, rect3)) {
            if (beamsOverlap) {
                boolean z = true;
                if (!isToDirectionOf(i, rect, rect3)) {
                    return true;
                }
                if (i != 17) {
                    if (i != 66) {
                        if (majorAxisDistance(i, rect, rect2) >= majorAxisDistanceToFarEdge(i, rect, rect3)) {
                            z = false;
                        }
                    }
                }
                return z;
            }
        }
        return false;
    }

    private static boolean beamsOverlap(int i, Rect rect, Rect rect2) {
        boolean z = true;
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    if (i != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            if (rect2.right < rect.left || rect2.left > rect.right) {
                z = false;
            }
            return z;
        }
        if (rect2.bottom < rect.top || rect2.top > rect.bottom) {
            z = false;
        }
        return z;
    }

    public static <L, T> T findNextFocusInAbsoluteDirection(L l, CollectionAdapter<L, T> collectionAdapter, BoundsAdapter<T> boundsAdapter, T t, Rect rect, int i) {
        int height;
        T t2;
        int size;
        Rect rect2;
        Rect rect3 = new Rect(rect);
        int i2 = 0;
        T t3;
        if (i != 17) {
            if (i == 33) {
                height = rect.height() + 1;
            } else if (i == 66) {
                height = -(rect.width() + 1);
            } else if (i == 130) {
                height = -(rect.height() + 1);
            } else {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            rect3.offset(0, height);
            t2 = null;
            size = collectionAdapter.size(l);
            rect2 = new Rect();
            while (i2 < size) {
                t3 = collectionAdapter.get(l, i2);
                if (t3 == t) {
                    boundsAdapter.obtainBounds(t3, rect2);
                    if (isBetterCandidate(i, rect, rect2, rect3)) {
                        rect3.set(rect2);
                        t2 = t3;
                    }
                }
                i2++;
            }
            return t2;
        }
        height = rect.width() + 1;
        rect3.offset(height, 0);
        t2 = null;
        size = collectionAdapter.size(l);
        rect2 = new Rect();
        while (i2 < size) {
            t3 = collectionAdapter.get(l, i2);
            if (t3 == t) {
                boundsAdapter.obtainBounds(t3, rect2);
                if (isBetterCandidate(i, rect, rect2, rect3)) {
                    rect3.set(rect2);
                    t2 = t3;
                }
            }
            i2++;
        }
        return t2;
    }

    public static <L, T> T findNextFocusInRelativeDirection(L l, CollectionAdapter<L, T> collectionAdapter, BoundsAdapter<T> boundsAdapter, T t, int i, boolean z, boolean z2) {
        int size = collectionAdapter.size(l);
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(collectionAdapter.get(l, i2));
        }
        Collections.sort(arrayList, new SequentialComparator(z, boundsAdapter));
        if (i == 1) {
            return getPreviousFocusable(t, arrayList, z2);
        }
        if (i == 2) {
            return getNextFocusable(t, arrayList, z2);
        }
        throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
    }

    private static <T> T getNextFocusable(T t, ArrayList<T> arrayList, boolean z) {
        int size = arrayList.size();
        int lastIndexOf = (t == null ? -1 : arrayList.lastIndexOf(t)) + 1;
        return lastIndexOf < size ? arrayList.get(lastIndexOf) : (!z || size <= 0) ? null : arrayList.get(0);
    }

    private static <T> T getPreviousFocusable(T t, ArrayList<T> arrayList, boolean z) {
        int size = arrayList.size();
        int indexOf = (t == null ? size : arrayList.indexOf(t)) - 1;
        return indexOf >= 0 ? arrayList.get(indexOf) : (!z || size <= 0) ? null : arrayList.get(size - 1);
    }

    private static int getWeightedDistanceFor(int i, int i2) {
        return ((i * 13) * i) + (i2 * i2);
    }

    private static boolean isBetterCandidate(int i, Rect rect, Rect rect2, Rect rect3) {
        boolean z = false;
        if (!isCandidate(rect, rect2, i)) {
            return false;
        }
        if (!isCandidate(rect, rect3, i) || beamBeats(i, rect, rect2, rect3)) {
            return true;
        }
        if (beamBeats(i, rect, rect3, rect2)) {
            return false;
        }
        if (getWeightedDistanceFor(majorAxisDistance(i, rect, rect2), minorAxisDistance(i, rect, rect2)) < getWeightedDistanceFor(majorAxisDistance(i, rect, rect3), minorAxisDistance(i, rect, rect3))) {
            z = true;
        }
        return z;
    }

    private static boolean isCandidate(Rect rect, Rect rect2, int i) {
        boolean z = true;
        int i2;
        if (i == 17) {
            i = rect.right;
            i2 = rect2.right;
            if ((i <= i2 && rect.left < i2) || rect.left <= rect2.left) {
                z = false;
            }
            return z;
        } else if (i == 33) {
            i = rect.bottom;
            i2 = rect2.bottom;
            if ((i <= i2 && rect.top < i2) || rect.top <= rect2.top) {
                z = false;
            }
            return z;
        } else if (i == 66) {
            i = rect.left;
            i2 = rect2.left;
            if ((i >= i2 && rect.right > i2) || rect.right >= rect2.right) {
                z = false;
            }
            return z;
        } else if (i == 130) {
            i = rect.top;
            i2 = rect2.top;
            if ((i >= i2 && rect.bottom > i2) || rect.bottom >= rect2.bottom) {
                z = false;
            }
            return z;
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
    }

    private static boolean isToDirectionOf(int i, Rect rect, Rect rect2) {
        boolean z = true;
        if (i == 17) {
            if (rect.left < rect2.right) {
                z = false;
            }
            return z;
        } else if (i == 33) {
            if (rect.top < rect2.bottom) {
                z = false;
            }
            return z;
        } else if (i == 66) {
            if (rect.right > rect2.left) {
                z = false;
            }
            return z;
        } else if (i == 130) {
            if (rect.bottom > rect2.top) {
                z = false;
            }
            return z;
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
    }

    private static int majorAxisDistance(int i, Rect rect, Rect rect2) {
        return Math.max(0, majorAxisDistanceRaw(i, rect, rect2));
    }

    private static int majorAxisDistanceRaw(int i, Rect rect, Rect rect2) {
        int i2;
        if (i == 17) {
            i = rect.left;
            i2 = rect2.right;
        } else if (i == 33) {
            i = rect.top;
            i2 = rect2.bottom;
        } else if (i == 66) {
            i = rect2.left;
            i2 = rect.right;
        } else if (i == 130) {
            i = rect2.top;
            i2 = rect.bottom;
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return i - i2;
    }

    private static int majorAxisDistanceToFarEdge(int i, Rect rect, Rect rect2) {
        return Math.max(1, majorAxisDistanceToFarEdgeRaw(i, rect, rect2));
    }

    private static int majorAxisDistanceToFarEdgeRaw(int i, Rect rect, Rect rect2) {
        int i2;
        if (i == 17) {
            i = rect.left;
            i2 = rect2.left;
        } else if (i == 33) {
            i = rect.top;
            i2 = rect2.top;
        } else if (i == 66) {
            i = rect2.right;
            i2 = rect.right;
        } else if (i == 130) {
            i = rect2.bottom;
            i2 = rect.bottom;
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return i - i2;
    }

    private static int minorAxisDistance(int i, Rect rect, Rect rect2) {
        int i2;
        int width;
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    if (i != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            i = rect.left + (rect.width() / 2);
            i2 = rect2.left;
            width = rect2.width();
            return Math.abs(i - (i2 + (width / 2)));
        }
        i = rect.top + (rect.height() / 2);
        i2 = rect2.top;
        width = rect2.height();
        return Math.abs(i - (i2 + (width / 2)));
    }
}
