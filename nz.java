import android.view.View;

class nz extends jl {
    final /* synthetic */ ny a;

    nz(ny nyVar) {
        this.a = nyVar;
    }

    public void b(View view) {
        if (this.a.C && this.a.r != null) {
            hg.b(this.a.r, 0.0f);
            hg.b(this.a.n, 0.0f);
        }
        if (this.a.q != null && this.a.z == 1) {
            this.a.q.setVisibility(8);
        }
        this.a.n.setVisibility(8);
        this.a.n.setTransitioning(false);
        this.a.H = null;
        this.a.g();
        if (this.a.m != null) {
            hg.o(this.a.m);
        }
    }
}
