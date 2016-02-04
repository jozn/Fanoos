import android.os.Build.VERSION;
import android.view.ViewConfiguration;

public class hz {
    static final ie a;

    static {
        if (VERSION.SDK_INT >= 14) {
            a = new id();
        } else if (VERSION.SDK_INT >= 11) {
            a = new ic();
        } else if (VERSION.SDK_INT >= 8) {
            a = new ib();
        } else {
            a = new ia();
        }
    }

    public static int a(ViewConfiguration viewConfiguration) {
        return a.a(viewConfiguration);
    }

    public static boolean b(ViewConfiguration viewConfiguration) {
        return a.b(viewConfiguration);
    }
}
