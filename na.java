import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

class na implements nx {
    final /* synthetic */ mz a;

    na(mz mzVar) {
        this.a = mzVar;
    }

    public boolean a(int i, MenuItem menuItem) {
        return this.a.a.onMenuItemSelected(i, menuItem);
    }

    public boolean a(int i, Menu menu) {
        return this.a.a.a(i, menu);
    }

    public boolean a(int i, View view, Menu menu) {
        return this.a.a.a(i, view, menu);
    }

    public void b(int i, Menu menu) {
        this.a.a.onPanelClosed(i, menu);
    }

    public boolean c(int i, Menu menu) {
        return this.a.a.onMenuOpened(i, menu);
    }

    public View a(int i) {
        return null;
    }
}
