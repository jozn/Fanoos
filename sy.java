import android.support.v7.widget.ListPopupWindow;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

public class sy implements OnItemSelectedListener {
    final /* synthetic */ ListPopupWindow a;

    public sy(ListPopupWindow listPopupWindow) {
        this.a = listPopupWindow;
    }

    public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        if (i != -1) {
            sz a = this.a.f;
            if (a != null) {
                a.f = false;
            }
        }
    }

    public void onNothingSelected(AdapterView adapterView) {
    }
}
