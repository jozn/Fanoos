import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;

class pg extends ou implements gr {
    final /* synthetic */ pd a;

    pg(pd pdVar, OnActionExpandListener onActionExpandListener) {
        this.a = pdVar;
        super(onActionExpandListener);
    }

    public boolean a(MenuItem menuItem) {
        return ((OnActionExpandListener) this.b).onMenuItemActionExpand(this.a.a(menuItem));
    }

    public boolean b(MenuItem menuItem) {
        return ((OnActionExpandListener) this.b).onMenuItemActionCollapse(this.a.a(menuItem));
    }
}
