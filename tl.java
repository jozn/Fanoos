import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;

final class tl extends tk {
    tl(tv tvVar) {
        super(null);
    }

    public int d() {
        return this.a.n() - this.a.r();
    }

    public int e() {
        return this.a.n();
    }

    public void a(int i) {
        this.a.e(i);
    }

    public int c() {
        return this.a.p();
    }

    public int c(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return layoutParams.rightMargin + (this.a.e(view) + layoutParams.leftMargin);
    }

    public int d(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return layoutParams.bottomMargin + (this.a.f(view) + layoutParams.topMargin);
    }

    public int b(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return layoutParams.rightMargin + this.a.i(view);
    }

    public int a(View view) {
        return this.a.g(view) - ((LayoutParams) view.getLayoutParams()).leftMargin;
    }

    public int f() {
        return (this.a.n() - this.a.p()) - this.a.r();
    }

    public int g() {
        return this.a.r();
    }
}
