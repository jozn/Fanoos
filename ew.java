import java.util.Iterator;

final class ew implements Iterator {
    final int a;
    int b;
    int c;
    boolean d;
    final /* synthetic */ ev e;

    ew(ev evVar, int i) {
        this.e = evVar;
        this.d = false;
        this.a = i;
        this.b = evVar.a();
    }

    public boolean hasNext() {
        return this.c < this.b;
    }

    public Object next() {
        Object a = this.e.a(this.c, this.a);
        this.c++;
        this.d = true;
        return a;
    }

    public void remove() {
        if (this.d) {
            this.c--;
            this.b--;
            this.d = false;
            this.e.a(this.c);
            return;
        }
        throw new IllegalStateException();
    }
}
