import android.os.Parcel;
import android.os.Parcelable.Creator;

class ef implements Creator {
    final eg a;

    public ef(eg egVar) {
        this.a = egVar;
    }

    public Object createFromParcel(Parcel parcel) {
        return this.a.a(parcel, null);
    }

    public Object[] newArray(int i) {
        return this.a.a(i);
    }
}
