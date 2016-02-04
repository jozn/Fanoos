import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.BackStackState;

public final class k implements Creator {
    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }

    public BackStackState a(Parcel parcel) {
        return new BackStackState(parcel);
    }

    public BackStackState[] a(int i) {
        return new BackStackState[i];
    }
}
