import android.os.Build.VERSION;

public class ej {
    private static final ek a;

    static {
        if (VERSION.SDK_INT >= 14) {
            a = new em();
        } else {
            a = new el();
        }
    }

    public static String a(String str) {
        return a.a(str);
    }

    public static String b(String str) {
        return a.b(str);
    }
}
