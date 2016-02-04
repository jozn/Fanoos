import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

public class iu {
    static final jd a;
    private WeakReference b;
    private Runnable c;
    private Runnable d;
    private int e;

    iu(View view) {
        this.c = null;
        this.d = null;
        this.e = -1;
        this.b = new WeakReference(view);
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 19) {
            a = new jc();
        } else if (i >= 18) {
            a = new ja();
        } else if (i >= 16) {
            a = new jb();
        } else if (i >= 14) {
            a = new iy();
        } else {
            a = new iw();
        }
    }

    public iu a(long j) {
        View view = (View) this.b.get();
        if (view != null) {
            a.a(this, view, j);
        }
        return this;
    }

    public iu a(float f) {
        View view = (View) this.b.get();
        if (view != null) {
            a.a(this, view, f);
        }
        return this;
    }

    public iu b(float f) {
        View view = (View) this.b.get();
        if (view != null) {
            a.b(this, view, f);
        }
        return this;
    }

    public iu c(float f) {
        View view = (View) this.b.get();
        if (view != null) {
            a.c(this, view, f);
        }
        return this;
    }

    public iu a(Interpolator interpolator) {
        View view = (View) this.b.get();
        if (view != null) {
            a.a(this, view, interpolator);
        }
        return this;
    }

    public iu d(float f) {
        View view = (View) this.b.get();
        if (view != null) {
            a.d(this, view, f);
        }
        return this;
    }

    public void a() {
        View view = (View) this.b.get();
        if (view != null) {
            a.a(this, view);
        }
    }

    public void b() {
        View view = (View) this.b.get();
        if (view != null) {
            a.b(this, view);
        }
    }

    public iu a(jk jkVar) {
        View view = (View) this.b.get();
        if (view != null) {
            a.a(this, view, jkVar);
        }
        return this;
    }

    public iu a(jm jmVar) {
        View view = (View) this.b.get();
        if (view != null) {
            a.a(this, view, jmVar);
        }
        return this;
    }
}
