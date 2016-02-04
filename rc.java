import android.support.v7.internal.widget.SpinnerCompat;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

public class rc implements OnGlobalLayoutListener {
    final /* synthetic */ SpinnerCompat a;

    public rc(SpinnerCompat spinnerCompat) {
        this.a = spinnerCompat;
    }

    public void onGlobalLayout() {
        if (!this.a.G.b()) {
            this.a.G.c();
        }
        ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.removeGlobalOnLayoutListener(this);
        }
    }
}
