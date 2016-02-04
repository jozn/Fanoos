import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

public abstract class ud {
    private int a;
    private RecyclerView b;
    private tv c;
    private boolean d;
    private boolean e;
    private View f;
    private final ue g;

    protected abstract void a(int i, int i2, uf ufVar, ue ueVar);

    protected abstract void a(View view, uf ufVar, ue ueVar);

    protected abstract void e();

    public void a(int i) {
        this.a = i;
    }

    protected final void a() {
        if (this.e) {
            e();
            this.b.f.e = -1;
            this.f = null;
            this.a = -1;
            this.d = false;
            this.e = false;
            this.c.a(this);
            this.c = null;
            this.b = null;
        }
    }

    public boolean b() {
        return this.d;
    }

    public boolean c() {
        return this.e;
    }

    public int d() {
        return this.a;
    }

    private void a(int i, int i2) {
        if (!this.e || this.a == -1) {
            a();
        }
        this.d = false;
        if (this.f != null) {
            if (a(this.f) == this.a) {
                a(this.f, this.b.f, this.g);
                this.g.a(this.b);
                a();
            } else {
                Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                this.f = null;
            }
        }
        if (this.e) {
            a(i, i2, this.b.f, this.g);
            this.g.a(this.b);
        }
    }

    public int a(View view) {
        return this.b.c(view);
    }

    protected void b(View view) {
        if (a(view) == d()) {
            this.f = view;
        }
    }
}
