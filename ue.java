import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.animation.Interpolator;

public class ue {
    private int a;
    private int b;
    private int c;
    private Interpolator d;
    private boolean e;
    private int f;

    private void a(RecyclerView recyclerView) {
        if (this.e) {
            a();
            if (this.d != null) {
                recyclerView.R.a(this.a, this.b, this.c, this.d);
            } else if (this.c == Integer.MIN_VALUE) {
                recyclerView.R.b(this.a, this.b);
            } else {
                recyclerView.R.a(this.a, this.b, this.c);
            }
            this.f++;
            if (this.f > 10) {
                Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
            }
            this.e = false;
            return;
        }
        this.f = 0;
    }

    private void a() {
        if (this.d != null && this.c < 1) {
            throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
        } else if (this.c < 1) {
            throw new IllegalStateException("Scroll duration must be a positive number");
        }
    }
}
