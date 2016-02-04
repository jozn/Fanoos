import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.session.PlaybackStateCompat;

public final class ed implements Creator {
    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }

    public PlaybackStateCompat a(Parcel parcel) {
        return new PlaybackStateCompat(null);
    }

    public PlaybackStateCompat[] a(int i) {
        return new PlaybackStateCompat[i];
    }
}
