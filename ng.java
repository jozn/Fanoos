import android.support.v7.app.ActionBarActivityDelegateBase;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class ng implements rv {
    final /* synthetic */ ActionBarActivityDelegateBase a;
    private rv b;

    public ng(ActionBarActivityDelegateBase actionBarActivityDelegateBase, rv rvVar) {
        this.a = actionBarActivityDelegateBase;
        this.b = rvVar;
    }

    public boolean a(ru ruVar, Menu menu) {
        return this.b.a(ruVar, menu);
    }

    public boolean b(ru ruVar, Menu menu) {
        return this.b.b(ruVar, menu);
    }

    public boolean a(ru ruVar, MenuItem menuItem) {
        return this.b.a(ruVar, menuItem);
    }

    public void a(ru ruVar) {
        this.b.a(ruVar);
        if (this.a.i != null) {
            this.a.a.getWindow().getDecorView().removeCallbacks(this.a.j);
            this.a.i.dismiss();
        } else if (this.a.h != null) {
            this.a.h.setVisibility(8);
            if (this.a.h.getParent() != null) {
                hg.o((View) this.a.h.getParent());
            }
        }
        if (this.a.h != null) {
            this.a.h.removeAllViews();
        }
        if (this.a.a != null) {
            try {
                this.a.a.b(this.a.g);
            } catch (AbstractMethodError e) {
            }
        }
        this.a.g = null;
    }
}
