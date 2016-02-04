import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.FragmentManagerState;

public final class aa implements Creator {
    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }

    public FragmentManagerState a(Parcel parcel) {
        return new FragmentManagerState(parcel);
    }

    public FragmentManagerState[] a(int i) {
        return new FragmentManagerState[i];
    }
}
