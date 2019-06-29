package android.support.v4.media;

import android.media.Rating;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class RatingCompat implements Parcelable {
    public static final Creator<RatingCompat> CREATOR = new C01451();
    public static final int RATING_3_STARS = 3;
    public static final int RATING_4_STARS = 4;
    public static final int RATING_5_STARS = 5;
    public static final int RATING_HEART = 1;
    public static final int RATING_NONE = 0;
    private static final float RATING_NOT_RATED = -1.0f;
    public static final int RATING_PERCENTAGE = 6;
    public static final int RATING_THUMB_UP_DOWN = 2;
    private static final String TAG = "Rating";
    private Object mRatingObj;
    private final int mRatingStyle;
    private final float mRatingValue;

    /* renamed from: android.support.v4.media.RatingCompat$1 */
    static class C01451 implements Creator<RatingCompat> {
        C01451() {
        }

        public RatingCompat createFromParcel(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }

        public RatingCompat[] newArray(int i) {
            return new RatingCompat[i];
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface StarStyle {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Style {
    }

    RatingCompat(int i, float f) {
        this.mRatingStyle = i;
        this.mRatingValue = f;
    }

    public static RatingCompat fromRating(Object obj) {
        RatingCompat ratingCompat = null;
        if (obj != null && VERSION.SDK_INT >= 19) {
            Rating rating = (Rating) obj;
            int ratingStyle = rating.getRatingStyle();
            if (rating.isRated()) {
                switch (ratingStyle) {
                    case 1:
                        ratingCompat = newHeartRating(rating.hasHeart());
                        break;
                    case 2:
                        ratingCompat = newThumbRating(rating.isThumbUp());
                        break;
                    case 3:
                    case 4:
                    case 5:
                        ratingCompat = newStarRating(ratingStyle, rating.getStarRating());
                        break;
                    case 6:
                        ratingCompat = newPercentageRating(rating.getPercentRating());
                        break;
                    default:
                        return null;
                }
            }
            ratingCompat = newUnratedRating(ratingStyle);
            ratingCompat.mRatingObj = obj;
        }
        return ratingCompat;
    }

    public static RatingCompat newHeartRating(boolean z) {
        return new RatingCompat(1, z ? 1.0f : 0.0f);
    }

    public static RatingCompat newPercentageRating(float f) {
        if (f >= 0.0f) {
            if (f <= 100.0f) {
                return new RatingCompat(6, f);
            }
        }
        Log.e(TAG, "Invalid percentage-based rating value");
        return null;
    }

    public static RatingCompat newStarRating(int i, float f) {
        String stringBuilder;
        String str = TAG;
        float f2;
        if (i != 3) {
            if (i == 4) {
                f2 = 4.0f;
            } else if (i != 5) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Invalid rating style (");
                stringBuilder2.append(i);
                stringBuilder2.append(") for a star rating");
                stringBuilder = stringBuilder2.toString();
            } else {
                f2 = 5.0f;
            }
            if (f >= 0.0f) {
                if (f > f2) {
                    return new RatingCompat(i, f);
                }
            }
            stringBuilder = "Trying to set out of range star-based rating";
        } else {
            f2 = 3.0f;
            if (f >= 0.0f) {
                if (f > f2) {
                    return new RatingCompat(i, f);
                }
            }
            stringBuilder = "Trying to set out of range star-based rating";
        }
        Log.e(str, stringBuilder);
        return null;
    }

    public static RatingCompat newThumbRating(boolean z) {
        return new RatingCompat(2, z ? 1.0f : 0.0f);
    }

    public static RatingCompat newUnratedRating(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return new RatingCompat(i, RATING_NOT_RATED);
            default:
                return null;
        }
    }

    public int describeContents() {
        return this.mRatingStyle;
    }

    public float getPercentRating() {
        if (this.mRatingStyle == 6) {
            if (isRated()) {
                return this.mRatingValue;
            }
        }
        return RATING_NOT_RATED;
    }

    public Object getRating() {
        if (this.mRatingObj == null && VERSION.SDK_INT >= 19) {
            Object newHeartRating;
            if (isRated()) {
                int i = this.mRatingStyle;
                switch (i) {
                    case 1:
                        newHeartRating = Rating.newHeartRating(hasHeart());
                        break;
                    case 2:
                        newHeartRating = Rating.newThumbRating(isThumbUp());
                        break;
                    case 3:
                    case 4:
                    case 5:
                        newHeartRating = Rating.newStarRating(i, getStarRating());
                        break;
                    case 6:
                        newHeartRating = Rating.newPercentageRating(getPercentRating());
                        break;
                    default:
                        return null;
                }
            }
            newHeartRating = Rating.newUnratedRating(this.mRatingStyle);
            this.mRatingObj = newHeartRating;
        }
        return this.mRatingObj;
    }

    public int getRatingStyle() {
        return this.mRatingStyle;
    }

    public float getStarRating() {
        int i = this.mRatingStyle;
        if (i == 3 || i == 4 || i == 5) {
            if (isRated()) {
                return this.mRatingValue;
            }
        }
        return RATING_NOT_RATED;
    }

    public boolean hasHeart() {
        boolean z = false;
        if (this.mRatingStyle != 1) {
            return false;
        }
        if (this.mRatingValue == 1.0f) {
            z = true;
        }
        return z;
    }

    public boolean isRated() {
        return this.mRatingValue >= 0.0f;
    }

    public boolean isThumbUp() {
        boolean z = false;
        if (this.mRatingStyle != 2) {
            return false;
        }
        if (this.mRatingValue == 1.0f) {
            z = true;
        }
        return z;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Rating:style=");
        stringBuilder.append(this.mRatingStyle);
        stringBuilder.append(" rating=");
        float f = this.mRatingValue;
        stringBuilder.append(f < 0.0f ? "unrated" : String.valueOf(f));
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mRatingStyle);
        parcel.writeFloat(this.mRatingValue);
    }
}
