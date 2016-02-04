import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

public abstract class to {
    private final tp a;
    private boolean b;

    public abstract int a();

    public abstract ui a(ViewGroup viewGroup, int i);

    public abstract void a(ui uiVar, int i);

    public final ui b(ViewGroup viewGroup, int i) {
        ui a = a(viewGroup, i);
        a.e = i;
        return a;
    }

    public final void b(ui uiVar, int i) {
        uiVar.b = i;
        if (b()) {
            uiVar.d = b(i);
        }
        a(uiVar, i);
        uiVar.a(1, 7);
    }

    public int a(int i) {
        return 0;
    }

    public long b(int i) {
        return -1;
    }

    public final boolean b() {
        return this.b;
    }

    public void a(ui uiVar) {
    }

    public void b(ui uiVar) {
    }

    public void a(tq tqVar) {
        this.a.registerObserver(tqVar);
    }

    public void b(tq tqVar) {
        this.a.unregisterObserver(tqVar);
    }

    public void a(RecyclerView recyclerView) {
    }

    public void b(RecyclerView recyclerView) {
    }
}
