import android.os.Build.VERSION;
import android.view.ViewGroup.MarginLayoutParams;

public class gh {
    static final gi a;

    static {
        if (VERSION.SDK_INT >= 17) {
            a = new gk();
        } else {
            a = new gj();
        }
    }

    public static int a(MarginLayoutParams marginLayoutParams) {
        return a.a(marginLayoutParams);
    }

    public static int b(MarginLayoutParams marginLayoutParams) {
        return a.b(marginLayoutParams);
    }
}
