import android.content.Context;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;

public class oj implements rv {
    final Callback a;
    final Context b;
    final fd c;
    final fd d;

    public oj(Context context, Callback callback) {
        this.b = context;
        this.a = callback;
        this.c = new fd();
        this.d = new fd();
    }

    public boolean a(ru ruVar, Menu menu) {
        return this.a.onCreateActionMode(b(ruVar), a(menu));
    }

    public boolean b(ru ruVar, Menu menu) {
        return this.a.onPrepareActionMode(b(ruVar), a(menu));
    }

    public boolean a(ru ruVar, MenuItem menuItem) {
        return this.a.onActionItemClicked(b(ruVar), pq.a(this.b, (dy) menuItem));
    }

    public void a(ru ruVar) {
        this.a.onDestroyActionMode(b(ruVar));
    }

    private Menu a(Menu menu) {
        Menu menu2 = (Menu) this.d.get(menu);
        if (menu2 != null) {
            return menu2;
        }
        menu2 = pq.a(this.b, (dx) menu);
        this.d.put(menu, menu2);
        return menu2;
    }

    private ActionMode b(ru ruVar) {
        oi oiVar = (oi) this.c.get(ruVar);
        if (oiVar != null) {
            return oiVar;
        }
        ActionMode oiVar2 = new oi(this.b, ruVar);
        this.c.put(ruVar, oiVar2);
        return oiVar2;
    }
}
