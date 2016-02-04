package android.support.v4.app;

import aa;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class FragmentManagerState implements Parcelable {
    public static final Creator CREATOR;
    public FragmentState[] a;
    public int[] b;
    public BackStackState[] c;

    public FragmentManagerState(Parcel parcel) {
        this.a = (FragmentState[]) parcel.createTypedArray(FragmentState.CREATOR);
        this.b = parcel.createIntArray();
        this.c = (BackStackState[]) parcel.createTypedArray(BackStackState.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.a, i);
        parcel.writeIntArray(this.b);
        parcel.writeTypedArray(this.c, i);
    }

    static {
        CREATOR = new aa();
    }
}
