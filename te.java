import android.database.DataSetObserver;
import android.support.v7.widget.ListPopupWindow;

public class te extends DataSetObserver {
    final /* synthetic */ ListPopupWindow a;

    private te(ListPopupWindow listPopupWindow) {
        this.a = listPopupWindow;
    }

    public void onChanged() {
        if (this.a.b()) {
            this.a.c();
        }
    }

    public void onInvalidated() {
        this.a.a();
    }
}
