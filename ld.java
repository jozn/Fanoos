class ld implements Runnable {
    final /* synthetic */ la a;

    private ld(la laVar) {
        this.a = laVar;
    }

    public void run() {
        if (this.a.o) {
            if (this.a.m) {
                this.a.m = false;
                this.a.a.a();
            }
            lc c = this.a.a;
            if (c.c() || !this.a.a()) {
                this.a.o = false;
                return;
            }
            if (this.a.n) {
                this.a.n = false;
                this.a.d();
            }
            c.d();
            this.a.a(c.g(), c.h());
            hg.a(this.a.c, (Runnable) this);
        }
    }
}
