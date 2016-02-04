import android.support.v7.widget.ListPopupWindow;
import android.view.View;

public class sx implements Runnable {
    final /* synthetic */ ListPopupWindow a;

    public sx(ListPopupWindow listPopupWindow) {
        this.a = listPopupWindow;
    }

    public void run() {
        View d = this.a.d();
        if (d != null && d.getWindowToken() != null) {
            this.a.c();
        }
    }
}
