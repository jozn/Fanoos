import android.os.Build.VERSION;

public class kt {
    private static final kw a;
    private final Object b;

    static {
        if (VERSION.SDK_INT >= 16) {
            a = new kx();
        } else if (VERSION.SDK_INT >= 15) {
            a = new kv();
        } else if (VERSION.SDK_INT >= 14) {
            a = new ku();
        } else {
            a = new ky();
        }
    }

    public kt(Object obj) {
        this.b = obj;
    }

    public static kt a() {
        return new kt(a.a());
    }

    public void a(boolean z) {
        a.a(this.b, z);
    }

    public void a(int i) {
        a.b(this.b, i);
    }

    public void b(int i) {
        a.a(this.b, i);
    }

    public void c(int i) {
        a.c(this.b, i);
    }

    public int hashCode() {
        return this.b == null ? 0 : this.b.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        kt ktVar = (kt) obj;
        if (this.b == null) {
            if (ktVar.b != null) {
                return false;
            }
            return true;
        } else if (this.b.equals(ktVar.b)) {
            return true;
        } else {
            return false;
        }
    }
}
