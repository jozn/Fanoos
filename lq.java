import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.LayoutParams;
import android.view.View;

public class lq extends mv {
    final /* synthetic */ DrawerLayout a;
    private final int b;
    private mt c;
    private final Runnable d;

    public void a() {
        this.a.removeCallbacks(this.d);
    }

    public boolean a(View view, int i) {
        return this.a.g(view) && this.a.a(view, this.b) && this.a.a(view) == 0;
    }

    public void a(int i) {
        this.a.a(this.b, i, this.c.c());
    }

    public void a(View view, int i, int i2, int i3, int i4) {
        float f;
        int width = view.getWidth();
        if (this.a.a(view, 3)) {
            f = ((float) (width + i)) / ((float) width);
        } else {
            f = ((float) (this.a.getWidth() - i)) / ((float) width);
        }
        this.a.b(view, f);
        view.setVisibility(f == 0.0f ? 4 : 0);
        this.a.invalidate();
    }

    public void b(View view, int i) {
        ((LayoutParams) view.getLayoutParams()).c = false;
        b();
    }

    private void b() {
        int i = 3;
        if (this.b == 3) {
            i = 5;
        }
        View a = this.a.a(i);
        if (a != null) {
            this.a.i(a);
        }
    }

    public void a(View view, float f, float f2) {
        int i;
        float d = this.a.d(view);
        int width = view.getWidth();
        if (this.a.a(view, 3)) {
            i = (f > 0.0f || (f == 0.0f && d > 0.5f)) ? 0 : -width;
        } else {
            i = this.a.getWidth();
            if (f < 0.0f || (f == 0.0f && d > 0.5f)) {
                i -= width;
            }
        }
        this.c.a(i, view.getTop());
        this.a.invalidate();
    }

    public void a(int i, int i2) {
        this.a.postDelayed(this.d, 160);
    }

    public boolean b(int i) {
        return false;
    }

    public void b(int i, int i2) {
        View a;
        if ((i & 1) == 1) {
            a = this.a.a(3);
        } else {
            a = this.a.a(5);
        }
        if (a != null && this.a.a(a) == 0) {
            this.c.a(a, i2);
        }
    }

    public int a(View view) {
        return this.a.g(view) ? view.getWidth() : 0;
    }

    public int a(View view, int i, int i2) {
        if (this.a.a(view, 3)) {
            return Math.max(-view.getWidth(), Math.min(i, 0));
        }
        int width = this.a.getWidth();
        return Math.max(width - view.getWidth(), Math.min(i, width));
    }

    public int b(View view, int i, int i2) {
        return view.getTop();
    }
}
