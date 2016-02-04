import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public abstract class fs {
    private final Context a;
    private ft b;
    private fu c;

    public abstract View a();

    public fs(Context context) {
        this.a = context;
    }

    public View a(MenuItem menuItem) {
        return a();
    }

    public boolean b() {
        return false;
    }

    public boolean c() {
        return true;
    }

    public boolean d() {
        return false;
    }

    public boolean e() {
        return false;
    }

    public void a(SubMenu subMenu) {
    }

    public void a(ft ftVar) {
        this.b = ftVar;
    }

    public void a(fu fuVar) {
        if (!(this.c == null || fuVar == null)) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.c = fuVar;
    }
}
