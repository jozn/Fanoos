package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import ec;

public class MediaSessionCompat {

    public final class Token implements Parcelable {
        public static final Creator CREATOR;
        private final Parcelable a;

        public Token(Parcelable parcelable) {
            this.a = parcelable;
        }

        public int describeContents() {
            return this.a.describeContents();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.a, i);
        }

        static {
            CREATOR = new ec();
        }
    }
}
