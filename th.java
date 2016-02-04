import android.support.v7.widget.ListPopupWindow;

public class th implements Runnable {
    final /* synthetic */ ListPopupWindow a;

    private th(ListPopupWindow listPopupWindow) {
        this.a = listPopupWindow;
    }

    public void run() {
        if (this.a.f != null && this.a.f.getCount() > this.a.f.getChildCount() && this.a.f.getChildCount() <= this.a.b) {
            this.a.d.setInputMethodMode(2);
            this.a.c();
        }
    }
}
