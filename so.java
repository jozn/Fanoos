import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.List;

public class so {
    final sq a;
    final sp b;
    final List c;

    public void a(View view, boolean z) {
        a(view, -1, z);
    }

    void a(View view, int i, boolean z) {
        int a;
        if (i < 0) {
            a = this.a.a();
        } else {
            a = e(i);
        }
        this.a.a(view, a);
        this.b.a(a, z);
        if (z) {
            this.c.add(view);
        }
    }

    private int e(int i) {
        if (i < 0) {
            return -1;
        }
        int a = this.a.a();
        int i2 = i;
        while (i2 < a) {
            int e = i - (i2 - this.b.e(i2));
            if (e == 0) {
                while (this.b.c(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += e;
        }
        return -1;
    }

    void a(View view) {
        int a = this.a.a(view);
        if (a >= 0) {
            this.a.a(a);
            if (this.b.d(a)) {
                this.c.remove(view);
            }
        }
    }

    void a(int i) {
        int e = e(i);
        View b = this.a.b(e);
        if (b != null) {
            this.a.a(e);
            if (this.b.d(e)) {
                this.c.remove(b);
            }
        }
    }

    public View b(int i) {
        return this.a.b(e(i));
    }

    public void a() {
        this.a.b();
        this.b.a();
        this.c.clear();
    }

    View a(int i, int i2) {
        int size = this.c.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view = (View) this.c.get(i3);
            ui b = this.a.b(view);
            if (b.d() == i && !b.l() && (i2 == -1 || b.f() == i2)) {
                return view;
            }
        }
        return null;
    }

    public void a(View view, int i, LayoutParams layoutParams, boolean z) {
        int a;
        if (i < 0) {
            a = this.a.a();
        } else {
            a = e(i);
        }
        this.a.a(view, a, layoutParams);
        this.b.a(a, z);
        if (z) {
            this.c.add(view);
        }
    }

    public int b() {
        return this.a.a() - this.c.size();
    }

    public int c() {
        return this.a.a();
    }

    public View c(int i) {
        return this.a.b(i);
    }

    void d(int i) {
        int e = e(i);
        this.a.c(e);
        this.b.d(e);
    }

    int b(View view) {
        int a = this.a.a(view);
        if (a == -1 || this.b.c(a)) {
            return -1;
        }
        return a - this.b.e(a);
    }

    boolean c(View view) {
        return this.c.contains(view);
    }

    public void d(View view) {
        int a = this.a.a(view);
        if (a < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        this.b.a(a);
        this.c.add(view);
    }

    public String toString() {
        return this.b.toString() + ", hidden list:" + this.c.size();
    }
}
