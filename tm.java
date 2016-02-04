import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;

final class tm extends tk {
    tm(tv tvVar) {
        super(null);
    }

    public int d() {
        return this.a.o() - this.a.s();
    }

    public int e() {
        return this.a.o();
    }

    public void a(int i) {
        this.a.f(i);
    }

    public int c() {
        return this.a.q();
    }

    public int c(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return layoutParams.bottomMargin + (this.a.f(view) + layoutParams.topMargin);
    }

    public int d(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return layoutParams.rightMargin + (this.a.e(view) + layoutParams.leftMargin);
    }

    public int b(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return layoutParams.bottomMargin + this.a.j(view);
    }

    public int a(View view) {
        return this.a.h(view) - ((LayoutParams) view.getLayoutParams()).topMargin;
    }

    public int f() {
        return (this.a.o() - this.a.q()) - this.a.s();
    }

    public int g() {
        return this.a.s();
    }
}
