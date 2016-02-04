import android.support.v7.internal.widget.SpinnerCompat;
import android.support.v7.widget.ListPopupWindow;
import android.view.View;

public class rb extends ta {
    final /* synthetic */ rf a;
    final /* synthetic */ SpinnerCompat b;

    public rb(SpinnerCompat spinnerCompat, View view, rf rfVar) {
        this.b = spinnerCompat;
        this.a = rfVar;
        super(view);
    }

    public ListPopupWindow a() {
        return this.a;
    }

    public boolean b() {
        if (!this.b.G.b()) {
            this.b.G.c();
        }
        return true;
    }
}
