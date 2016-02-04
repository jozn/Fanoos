import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.MediaMetadataCompat;

public final class ea implements Creator {
    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }

    public MediaMetadataCompat a(Parcel parcel) {
        return new MediaMetadataCompat(null);
    }

    public MediaMetadataCompat[] a(int i) {
        return new MediaMetadataCompat[i];
    }
}
