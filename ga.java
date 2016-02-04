import android.os.Build.VERSION;
import android.view.KeyEvent;

public class ga {
    static final ge a;

    static {
        if (VERSION.SDK_INT >= 11) {
            a = new gd();
        } else {
            a = new gb();
        }
    }

    public static boolean a(KeyEvent keyEvent, int i) {
        return a.a(keyEvent.getMetaState(), i);
    }

    public static boolean a(KeyEvent keyEvent) {
        return a.b(keyEvent.getMetaState());
    }

    public static void b(KeyEvent keyEvent) {
        a.a(keyEvent);
    }
}
