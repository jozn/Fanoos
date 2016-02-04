import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

class eh implements ClassLoaderCreator {
    private final eg a;

    public eh(eg egVar) {
        this.a = egVar;
    }

    public Object createFromParcel(Parcel parcel) {
        return this.a.a(parcel, null);
    }

    public Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return this.a.a(parcel, classLoader);
    }

    public Object[] newArray(int i) {
        return this.a.a(i);
    }
}
