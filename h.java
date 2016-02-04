import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;

class h implements OnPreDrawListener {
    final /* synthetic */ View a;
    final /* synthetic */ j b;
    final /* synthetic */ int c;
    final /* synthetic */ Object d;
    final /* synthetic */ e e;

    h(e eVar, View view, j jVar, int i, Object obj) {
        this.e = eVar;
        this.a = view;
        this.b = jVar;
        this.c = i;
        this.d = obj;
    }

    public boolean onPreDraw() {
        this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        this.e.a(this.b, this.c, this.d);
        return true;
    }
}
