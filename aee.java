import android.content.Context;
import android.os.Build.VERSION;

public final class aee {
    public static aec a(Context context, aed aed) {
        aec ady;
        int i = VERSION.SDK_INT;
        if (i < 5) {
            ady = new ady(context);
        } else if (i < 8) {
            ady = new adz(context);
        } else {
            ady = new aea(context);
        }
        ady.a(aed);
        return ady;
    }
}
