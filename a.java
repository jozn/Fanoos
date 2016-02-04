import android.app.Activity;
import android.os.Build.VERSION;

public class a extends da {
    public static void a(Activity activity) {
        if (VERSION.SDK_INT >= 16) {
            d.a(activity);
        } else {
            activity.finish();
        }
    }

    public static void b(Activity activity) {
        if (VERSION.SDK_INT >= 21) {
            b.a(activity);
        } else {
            activity.finish();
        }
    }
}
