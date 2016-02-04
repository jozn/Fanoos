import android.support.v7.widget.ActionMenuView;
import android.view.MenuItem;

public class sj implements oy {
    final /* synthetic */ ActionMenuView a;

    private sj(ActionMenuView actionMenuView) {
        this.a = actionMenuView;
    }

    public boolean a(ox oxVar, MenuItem menuItem) {
        return this.a.m != null && this.a.m.a(menuItem);
    }

    public void a(ox oxVar) {
        if (this.a.h != null) {
            this.a.h.a(oxVar);
        }
    }
}
