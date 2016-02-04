import android.os.Build.VERSION;
import android.os.Parcelable.Creator;

public class ee {
    public static Creator a(eg egVar) {
        if (VERSION.SDK_INT >= 13) {
            ei.a(egVar);
        }
        return new ef(egVar);
    }
}
