import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.widget.StaggeredGridLayoutManager.SavedState;

public final class ur implements Creator {
    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }

    public SavedState a(Parcel parcel) {
        return new SavedState(parcel);
    }

    public SavedState[] a(int i) {
        return new SavedState[i];
    }
}
