import android.view.View;

class rq extends jl {
    final /* synthetic */ ro a;
    private boolean b;

    rq(ro roVar) {
        this.a = roVar;
        this.b = false;
    }

    public void b(View view) {
        if (!this.b) {
            this.a.a.setVisibility(8);
        }
    }

    public void c(View view) {
        this.b = true;
    }
}
