import android.view.View;
import java.lang.reflect.Field;
import java.util.WeakHashMap;

class hm extends hl {
    static Field b;
    static boolean c;

    hm() {
    }

    static {
        c = false;
    }

    public boolean a(View view, int i) {
        return hw.a(view, i);
    }

    public boolean b(View view, int i) {
        return hw.b(view, i);
    }

    public void a(View view, ff ffVar) {
        hw.a(view, ffVar.a());
    }

    public boolean c(View view) {
        boolean z = true;
        if (c) {
            return false;
        }
        if (b == null) {
            try {
                b = View.class.getDeclaredField("mAccessibilityDelegate");
                b.setAccessible(true);
            } catch (Throwable th) {
                c = true;
                return false;
            }
        }
        try {
            if (b.get(view) == null) {
                z = false;
            }
            return z;
        } catch (Throwable th2) {
            c = true;
            return false;
        }
    }

    public iu n(View view) {
        if (this.a == null) {
            this.a = new WeakHashMap();
        }
        iu iuVar = (iu) this.a.get(view);
        if (iuVar != null) {
            return iuVar;
        }
        iuVar = new iu(view);
        this.a.put(view, iuVar);
        return iuVar;
    }
}
