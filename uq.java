import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem;

public final class uq implements Creator {
    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }

    public FullSpanItem a(Parcel parcel) {
        return new FullSpanItem(parcel);
    }

    public FullSpanItem[] a(int i) {
        return new FullSpanItem[i];
    }
}
