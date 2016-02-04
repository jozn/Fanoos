import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ph extends ou implements OnMenuItemClickListener {
    final /* synthetic */ pd a;

    ph(pd pdVar, OnMenuItemClickListener onMenuItemClickListener) {
        this.a = pdVar;
        super(onMenuItemClickListener);
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        return ((OnMenuItemClickListener) this.b).onMenuItemClick(this.a.a(menuItem));
    }
}
