import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;

public class ss {
    public int a;
    public int b;
    public boolean c;
    final /* synthetic */ LinearLayoutManager d;

    public void a() {
        this.a = -1;
        this.b = Integer.MIN_VALUE;
        this.c = false;
    }

    public void b() {
        this.b = this.c ? this.d.b.d() : this.d.b.c();
    }

    public String toString() {
        return "AnchorInfo{mPosition=" + this.a + ", mCoordinate=" + this.b + ", mLayoutFromEnd=" + this.c + '}';
    }

    public boolean a(View view, uf ufVar) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.a() || layoutParams.c() < 0 || layoutParams.c() >= ufVar.e()) {
            return false;
        }
        a(view);
        return true;
    }

    public void a(View view) {
        if (this.c) {
            this.b = this.d.b.b(view) + this.d.b.b();
        } else {
            this.b = this.d.b.a(view);
        }
        this.a = this.d.d(view);
    }
}
