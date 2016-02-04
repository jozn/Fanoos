import android.os.Bundle;
import android.view.View;

class fj extends fg {
    fj() {
    }

    public Object a(ff ffVar) {
        return fp.a(new fk(this, ffVar));
    }

    public kg a(Object obj, View view) {
        Object a = fp.a(obj, view);
        if (a != null) {
            return new kg(a);
        }
        return null;
    }

    public boolean a(Object obj, View view, int i, Bundle bundle) {
        return fp.a(obj, view, i, bundle);
    }
}
