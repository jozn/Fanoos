import android.transition.Transition;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

final class aj implements OnPreDrawListener {
    final /* synthetic */ View a;
    final /* synthetic */ an b;
    final /* synthetic */ Map c;
    final /* synthetic */ Map d;
    final /* synthetic */ Transition e;
    final /* synthetic */ ArrayList f;

    aj(View view, an anVar, Map map, Map map2, Transition transition, ArrayList arrayList) {
        this.a = view;
        this.b = anVar;
        this.c = map;
        this.d = map2;
        this.e = transition;
        this.f = arrayList;
    }

    public boolean onPreDraw() {
        this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        View a = this.b.a();
        if (a != null) {
            if (!this.c.isEmpty()) {
                ah.a(this.d, a);
                this.d.keySet().retainAll(this.c.values());
                for (Entry entry : this.c.entrySet()) {
                    View view = (View) this.d.get((String) entry.getValue());
                    if (view != null) {
                        view.setTransitionName((String) entry.getKey());
                    }
                }
            }
            if (this.e != null) {
                ah.b(this.f, a);
                this.f.removeAll(this.d.values());
                ah.b(this.e, this.f);
            }
        }
        return true;
    }
}
