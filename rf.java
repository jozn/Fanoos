import android.content.Context;
import android.support.v7.internal.widget.SpinnerCompat;
import android.support.v7.widget.ListPopupWindow;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListAdapter;

public class rf extends ListPopupWindow implements ri {
    final /* synthetic */ SpinnerCompat a;
    private CharSequence c;
    private ListAdapter d;

    public rf(SpinnerCompat spinnerCompat, Context context, AttributeSet attributeSet, int i) {
        this.a = spinnerCompat;
        super(context, attributeSet, i);
        a((View) spinnerCompat);
        a(true);
        a(0);
        a(new rg(this, spinnerCompat));
    }

    public void a(ListAdapter listAdapter) {
        super.a(listAdapter);
        this.d = listAdapter;
    }

    public void a(CharSequence charSequence) {
        this.c = charSequence;
    }
}
