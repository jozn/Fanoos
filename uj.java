import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

public class uj extends ff {
    final RecyclerView b;
    final ff c;

    public boolean a(View view, int i, Bundle bundle) {
        if (super.a(view, i, bundle)) {
            return true;
        }
        if (this.b.getLayoutManager() != null) {
            return this.b.getLayoutManager().a(i, bundle);
        }
        return false;
    }

    public void a(View view, jt jtVar) {
        super.a(view, jtVar);
        jtVar.a(RecyclerView.class.getName());
        if (this.b.getLayoutManager() != null) {
            this.b.getLayoutManager().a(jtVar);
        }
    }

    public void d(View view, AccessibilityEvent accessibilityEvent) {
        super.d(view, accessibilityEvent);
        accessibilityEvent.setClassName(RecyclerView.class.getName());
        if (view instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().a(accessibilityEvent);
            }
        }
    }

    ff b() {
        return this.c;
    }
}
