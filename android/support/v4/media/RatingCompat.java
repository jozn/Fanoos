package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import eb;

public final class RatingCompat implements Parcelable {
    public static final Creator CREATOR;
    private final int a;
    private final float b;

    private RatingCompat(int i, float f) {
        this.a = i;
        this.b = f;
    }

    public String toString() {
        return "Rating:style=" + this.a + " rating=" + (this.b < 0.0f ? "unrated" : String.valueOf(this.b));
    }

    public int describeContents() {
        return this.a;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeFloat(this.b);
    }

    static {
        CREATOR = new eb();
    }
}
