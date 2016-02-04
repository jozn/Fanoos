import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class uv implements sk {
    final /* synthetic */ Toolbar a;

    public uv(Toolbar toolbar) {
        this.a = toolbar;
    }

    public boolean a(MenuItem menuItem) {
        if (this.a.C != null) {
            return this.a.C.a(menuItem);
        }
        return false;
    }
}
