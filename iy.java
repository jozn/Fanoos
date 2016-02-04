import android.view.View;
import android.view.animation.Interpolator;
import java.util.WeakHashMap;

class iy extends iw {
    WeakHashMap b;

    iy() {
        this.b = null;
    }

    public void a(iu iuVar, View view, long j) {
        je.a(view, j);
    }

    public void a(iu iuVar, View view, float f) {
        je.a(view, f);
    }

    public void b(iu iuVar, View view, float f) {
        je.b(view, f);
    }

    public void c(iu iuVar, View view, float f) {
        je.c(view, f);
    }

    public void a(iu iuVar, View view, Interpolator interpolator) {
        je.a(view, interpolator);
    }

    public void d(iu iuVar, View view, float f) {
        je.d(view, f);
    }

    public void a(iu iuVar, View view) {
        je.a(view);
    }

    public void b(iu iuVar, View view) {
        je.b(view);
    }

    public void a(iu iuVar, View view, jk jkVar) {
        view.setTag(2113929216, jkVar);
        je.a(view, new iz(iuVar));
    }
}
