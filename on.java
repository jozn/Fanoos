import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

public class on {
    private final ArrayList a;
    private long b;
    private Interpolator c;
    private jk d;
    private boolean e;
    private final jl f;

    public on() {
        this.b = -1;
        this.f = new oo(this);
        this.a = new ArrayList();
    }

    public on a(iu iuVar) {
        if (!this.e) {
            this.a.add(iuVar);
        }
        return this;
    }

    public void a() {
        if (!this.e) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                iu iuVar = (iu) it.next();
                if (this.b >= 0) {
                    iuVar.a(this.b);
                }
                if (this.c != null) {
                    iuVar.a(this.c);
                }
                if (this.d != null) {
                    iuVar.a(this.f);
                }
                iuVar.b();
            }
            this.e = true;
        }
    }

    private void c() {
        this.e = false;
    }

    public void b() {
        if (this.e) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((iu) it.next()).a();
            }
            this.e = false;
        }
    }

    public on a(long j) {
        if (!this.e) {
            this.b = j;
        }
        return this;
    }

    public on a(Interpolator interpolator) {
        if (!this.e) {
            this.c = interpolator;
        }
        return this;
    }

    public on a(jk jkVar) {
        if (!this.e) {
            this.d = jkVar;
        }
        return this;
    }
}
