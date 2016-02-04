import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.FragmentState;

public final class ab implements Creator {
    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }

    public FragmentState a(Parcel parcel) {
        return new FragmentState(parcel);
    }

    public FragmentState[] a(int i) {
        return new FragmentState[i];
    }
}
