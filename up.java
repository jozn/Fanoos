import android.support.v7.widget.StaggeredGridLayoutManager;

public class up {
    public int a;
    public int b;
    public boolean c;
    public boolean d;
    final /* synthetic */ StaggeredGridLayoutManager e;

    public void a() {
        this.a = -1;
        this.b = Integer.MIN_VALUE;
        this.c = false;
        this.d = false;
    }

    public void b() {
        this.b = this.c ? this.e.a.d() : this.e.a.c();
    }

    public void a(int i) {
        if (this.c) {
            this.b = this.e.a.d() - i;
        } else {
            this.b = this.e.a.c() + i;
        }
    }
}
