import android.support.v7.internal.widget.AbsSpinnerCompat;
import android.util.SparseArray;
import android.view.View;

public class pw {
    final /* synthetic */ AbsSpinnerCompat a;
    private final SparseArray b;

    public pw(AbsSpinnerCompat absSpinnerCompat) {
        this.a = absSpinnerCompat;
        this.b = new SparseArray();
    }

    public void a(int i, View view) {
        this.b.put(i, view);
    }

    public View a(int i) {
        View view = (View) this.b.get(i);
        if (view != null) {
            this.b.delete(i);
        }
        return view;
    }

    public void a() {
        SparseArray sparseArray = this.b;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            View view = (View) sparseArray.valueAt(i);
            if (view != null) {
                this.a.removeDetachedView(view, true);
            }
        }
        sparseArray.clear();
    }
}
