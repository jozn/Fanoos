import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.support.v7.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem;
import android.view.View;
import java.util.ArrayList;

public class us {
    int a;
    int b;
    int c;
    public final int d;
    final /* synthetic */ StaggeredGridLayoutManager e;
    private ArrayList f;

    public int a(int i) {
        if (this.a != Integer.MIN_VALUE) {
            return this.a;
        }
        if (this.f.size() == 0) {
            return i;
        }
        a();
        return this.a;
    }

    void a() {
        View view = (View) this.f.get(0);
        LayoutParams c = c(view);
        this.a = this.e.a.a(view);
        if (c.f) {
            FullSpanItem f = this.e.f.f(c.c());
            if (f != null && f.b == -1) {
                this.a -= f.a(this.d);
            }
        }
    }

    public int b() {
        if (this.a != Integer.MIN_VALUE) {
            return this.a;
        }
        a();
        return this.a;
    }

    public int b(int i) {
        if (this.b != Integer.MIN_VALUE) {
            return this.b;
        }
        if (this.f.size() == 0) {
            return i;
        }
        c();
        return this.b;
    }

    void c() {
        View view = (View) this.f.get(this.f.size() - 1);
        LayoutParams c = c(view);
        this.b = this.e.a.b(view);
        if (c.f) {
            FullSpanItem f = this.e.f.f(c.c());
            if (f != null && f.b == 1) {
                this.b = f.a(this.d) + this.b;
            }
        }
    }

    public int d() {
        if (this.b != Integer.MIN_VALUE) {
            return this.b;
        }
        c();
        return this.b;
    }

    public void a(View view) {
        LayoutParams c = c(view);
        c.e = this;
        this.f.add(0, view);
        this.a = Integer.MIN_VALUE;
        if (this.f.size() == 1) {
            this.b = Integer.MIN_VALUE;
        }
        if (c.a() || c.b()) {
            this.c += this.e.a.c(view);
        }
    }

    public void b(View view) {
        LayoutParams c = c(view);
        c.e = this;
        this.f.add(view);
        this.b = Integer.MIN_VALUE;
        if (this.f.size() == 1) {
            this.a = Integer.MIN_VALUE;
        }
        if (c.a() || c.b()) {
            this.c += this.e.a.c(view);
        }
    }

    public void a(boolean z, int i) {
        int b;
        if (z) {
            b = b(Integer.MIN_VALUE);
        } else {
            b = a(Integer.MIN_VALUE);
        }
        e();
        if (b != Integer.MIN_VALUE) {
            if (z && b < this.e.a.d()) {
                return;
            }
            if (z || b <= this.e.a.c()) {
                if (i != Integer.MIN_VALUE) {
                    b += i;
                }
                this.b = b;
                this.a = b;
            }
        }
    }

    public void e() {
        this.f.clear();
        f();
        this.c = 0;
    }

    void f() {
        this.a = Integer.MIN_VALUE;
        this.b = Integer.MIN_VALUE;
    }

    public void c(int i) {
        this.a = i;
        this.b = i;
    }

    public void g() {
        int size = this.f.size();
        View view = (View) this.f.remove(size - 1);
        LayoutParams c = c(view);
        c.e = null;
        if (c.a() || c.b()) {
            this.c -= this.e.a.c(view);
        }
        if (size == 1) {
            this.a = Integer.MIN_VALUE;
        }
        this.b = Integer.MIN_VALUE;
    }

    public void h() {
        View view = (View) this.f.remove(0);
        LayoutParams c = c(view);
        c.e = null;
        if (this.f.size() == 0) {
            this.b = Integer.MIN_VALUE;
        }
        if (c.a() || c.b()) {
            this.c -= this.e.a.c(view);
        }
        this.a = Integer.MIN_VALUE;
    }

    public int i() {
        return this.c;
    }

    LayoutParams c(View view) {
        return (LayoutParams) view.getLayoutParams();
    }

    public void d(int i) {
        if (this.a != Integer.MIN_VALUE) {
            this.a += i;
        }
        if (this.b != Integer.MIN_VALUE) {
            this.b += i;
        }
    }
}
