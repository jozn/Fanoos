import android.view.View;

class oo extends jl {
    final /* synthetic */ on a;
    private boolean b;
    private int c;

    oo(on onVar) {
        this.a = onVar;
        this.b = false;
        this.c = 0;
    }

    public void a(View view) {
        if (!this.b) {
            this.b = true;
            if (this.a.d != null) {
                this.a.d.a(null);
            }
        }
    }

    void a() {
        this.c = 0;
        this.b = false;
        this.a.c();
    }

    public void b(View view) {
        int i = this.c + 1;
        this.c = i;
        if (i == this.a.a.size()) {
            if (this.a.d != null) {
                this.a.d.b(null);
            }
            a();
        }
    }
}
