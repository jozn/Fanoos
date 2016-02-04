import android.support.v7.widget.ListPopupWindow;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

public class tf implements OnScrollListener {
    final /* synthetic */ ListPopupWindow a;

    private tf(ListPopupWindow listPopupWindow) {
        this.a = listPopupWindow;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1 && !this.a.f() && this.a.d.getContentView() != null) {
            this.a.A.removeCallbacks(this.a.v);
            this.a.v.run();
        }
    }
}
