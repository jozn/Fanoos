import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.RatingCompat;

public final class eb implements Creator {
    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }

    public RatingCompat a(Parcel parcel) {
        return new RatingCompat(parcel.readFloat(), null);
    }

    public RatingCompat[] a(int i) {
        return new RatingCompat[i];
    }
}
