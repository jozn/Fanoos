import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;

class g implements OnPreDrawListener {
    final /* synthetic */ View a;
    final /* synthetic */ Object b;
    final /* synthetic */ ArrayList c;
    final /* synthetic */ j d;
    final /* synthetic */ boolean e;
    final /* synthetic */ Fragment f;
    final /* synthetic */ Fragment g;
    final /* synthetic */ e h;

    g(e eVar, View view, Object obj, ArrayList arrayList, j jVar, boolean z, Fragment fragment, Fragment fragment2) {
        this.h = eVar;
        this.a = view;
        this.b = obj;
        this.c = arrayList;
        this.d = jVar;
        this.e = z;
        this.f = fragment;
        this.g = fragment2;
    }

    public boolean onPreDraw() {
        this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        if (this.b != null) {
            ah.a(this.b, this.c);
            this.c.clear();
            ep a = this.h.a(this.d, this.e, this.f);
            if (a.isEmpty()) {
                this.c.add(this.d.d);
            } else {
                this.c.addAll(a.values());
            }
            ah.b(this.b, this.c);
            this.h.a(a, this.d);
            this.h.a(this.d, this.f, this.g, this.e, a);
        }
        return true;
    }
}
