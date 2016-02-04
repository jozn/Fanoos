import android.view.View;
import android.view.animation.Interpolator;
import java.util.WeakHashMap;

class iw implements jd {
    WeakHashMap a;

    iw() {
        this.a = null;
    }

    public void a(iu iuVar, View view, long j) {
    }

    public void a(iu iuVar, View view, float f) {
        d(iuVar, view);
    }

    public void b(iu iuVar, View view, float f) {
        d(iuVar, view);
    }

    public void c(iu iuVar, View view, float f) {
        d(iuVar, view);
    }

    public void a(iu iuVar, View view, Interpolator interpolator) {
    }

    public void d(iu iuVar, View view, float f) {
        d(iuVar, view);
    }

    public void a(iu iuVar, View view) {
        d(iuVar, view);
    }

    public void b(iu iuVar, View view) {
        a(view);
        c(iuVar, view);
    }

    public void a(iu iuVar, View view, jk jkVar) {
        view.setTag(2113929216, jkVar);
    }

    public void a(iu iuVar, View view, jm jmVar) {
    }

    private void c(iu iuVar, View view) {
        jk jkVar;
        Object tag = view.getTag(2113929216);
        if (tag instanceof jk) {
            jkVar = (jk) tag;
        } else {
            jkVar = null;
        }
        Runnable a = iuVar.c;
        Runnable b = iuVar.d;
        if (a != null) {
            a.run();
        }
        if (jkVar != null) {
            jkVar.a(view);
            jkVar.b(view);
        }
        if (b != null) {
            b.run();
        }
        if (this.a != null) {
            this.a.remove(view);
        }
    }

    private void a(View view) {
        if (this.a != null) {
            Runnable runnable = (Runnable) this.a.get(view);
            if (runnable != null) {
                view.removeCallbacks(runnable);
            }
        }
    }

    private void d(iu iuVar, View view) {
        Runnable runnable;
        if (this.a != null) {
            runnable = (Runnable) this.a.get(view);
        } else {
            runnable = null;
        }
        if (runnable == null) {
            runnable = new ix(iuVar, view, null);
            if (this.a == null) {
                this.a = new WeakHashMap();
            }
            this.a.put(view, runnable);
        }
        view.removeCallbacks(runnable);
        view.post(runnable);
    }
}
