import android.os.Build.VERSION;

public class fv {
    static final fw a;

    static {
        if (VERSION.SDK_INT >= 17) {
            a = new fy();
        } else {
            a = new fx();
        }
    }

    public static int a(int i, int i2) {
        return a.a(i, i2);
    }
}
