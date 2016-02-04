import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;

final class hs implements OnApplyWindowInsetsListener {
    final /* synthetic */ gz a;

    hs(gz gzVar) {
        this.a = gzVar;
    }

    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        return ((jo) this.a.a(view, new jo(windowInsets))).e();
    }
}
