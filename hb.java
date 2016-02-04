import android.os.Build.VERSION;
import android.view.VelocityTracker;

public class hb {
    static final he a;

    static {
        if (VERSION.SDK_INT >= 11) {
            a = new hd();
        } else {
            a = new hc();
        }
    }

    public static float a(VelocityTracker velocityTracker, int i) {
        return a.a(velocityTracker, i);
    }

    public static float b(VelocityTracker velocityTracker, int i) {
        return a.b(velocityTracker, i);
    }
}
