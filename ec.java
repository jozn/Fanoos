import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.session.MediaSessionCompat.Token;

public final class ec implements Creator {
    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }

    public Token a(Parcel parcel) {
        return new Token(parcel.readParcelable(null));
    }

    public Token[] a(int i) {
        return new Token[i];
    }
}
