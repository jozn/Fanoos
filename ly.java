import android.os.Build.VERSION;
import android.view.View;
import android.widget.PopupWindow;

public class ly {
    static final mb a;

    static {
        if (VERSION.SDK_INT >= 19) {
            a = new ma();
        } else {
            a = new lz();
        }
    }

    public static void a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        a.a(popupWindow, view, i, i2, i3);
    }
}
