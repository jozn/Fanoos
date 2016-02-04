import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;

public class dg {
    private static final dh a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 15) {
            a = new dk();
        } else if (i >= 11) {
            a = new dj();
        } else {
            a = new di();
        }
    }

    public static Intent a(ComponentName componentName) {
        return a.a(componentName);
    }
}
