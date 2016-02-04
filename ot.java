import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;

abstract class ot extends ou {
    final Context a;
    private Map c;
    private Map d;

    ot(Context context, Object obj) {
        super(obj);
        this.a = context;
    }

    final MenuItem a(MenuItem menuItem) {
        if (!(menuItem instanceof dy)) {
            return menuItem;
        }
        dy dyVar = (dy) menuItem;
        if (this.c == null) {
            this.c = new ep();
        }
        MenuItem menuItem2 = (MenuItem) this.c.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        menuItem2 = pq.a(this.a, dyVar);
        this.c.put(dyVar, menuItem2);
        return menuItem2;
    }

    final SubMenu a(SubMenu subMenu) {
        if (!(subMenu instanceof dz)) {
            return subMenu;
        }
        dz dzVar = (dz) subMenu;
        if (this.d == null) {
            this.d = new ep();
        }
        SubMenu subMenu2 = (SubMenu) this.d.get(dzVar);
        if (subMenu2 != null) {
            return subMenu2;
        }
        subMenu2 = pq.a(this.a, dzVar);
        this.d.put(dzVar, subMenu2);
        return subMenu2;
    }

    final void a() {
        if (this.c != null) {
            this.c.clear();
        }
        if (this.d != null) {
            this.d.clear();
        }
    }

    final void a(int i) {
        if (this.c != null) {
            Iterator it = this.c.keySet().iterator();
            while (it.hasNext()) {
                if (i == ((MenuItem) it.next()).getGroupId()) {
                    it.remove();
                }
            }
        }
    }

    final void b(int i) {
        if (this.c != null) {
            Iterator it = this.c.keySet().iterator();
            while (it.hasNext()) {
                if (i == ((MenuItem) it.next()).getItemId()) {
                    it.remove();
                    return;
                }
            }
        }
    }
}
