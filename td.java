import android.support.v7.widget.ListPopupWindow;

public class td implements Runnable {
    final /* synthetic */ ListPopupWindow a;

    private td(ListPopupWindow listPopupWindow) {
        this.a = listPopupWindow;
    }

    public void run() {
        this.a.e();
    }
}
