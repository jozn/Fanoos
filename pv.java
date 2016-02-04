import android.view.View;

public class pv implements jk {
    int a;
    final /* synthetic */ pu b;
    private boolean c;

    protected pv(pu puVar) {
        this.b = puVar;
        this.c = false;
    }

    public pv a(iu iuVar, int i) {
        this.b.i = iuVar;
        this.a = i;
        return this;
    }

    public void a(View view) {
        this.b.setVisibility(0);
        this.c = false;
    }

    public void b(View view) {
        if (!this.c) {
            this.b.i = null;
            this.b.setVisibility(this.a);
            if (this.b.e != null && this.b.c != null) {
                this.b.c.setVisibility(this.a);
            }
        }
    }

    public void c(View view) {
        this.c = true;
    }
}
