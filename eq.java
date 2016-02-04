import java.util.Map;

class eq extends ev {
    final /* synthetic */ ep a;

    eq(ep epVar) {
        this.a = epVar;
    }

    protected int a() {
        return this.a.h;
    }

    protected Object a(int i, int i2) {
        return this.a.g[(i << 1) + i2];
    }

    protected int a(Object obj) {
        return this.a.a(obj);
    }

    protected int b(Object obj) {
        return this.a.b(obj);
    }

    protected Map b() {
        return this.a;
    }

    protected void a(Object obj, Object obj2) {
        this.a.put(obj, obj2);
    }

    protected Object a(int i, Object obj) {
        return this.a.a(i, obj);
    }

    protected void a(int i) {
        this.a.d(i);
    }

    protected void c() {
        this.a.clear();
    }
}
