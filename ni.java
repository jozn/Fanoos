import android.support.v7.app.ActionBarActivityDelegateBase;
import android.support.v7.app.ActionBarActivityDelegateBase.PanelFeatureState;
import android.view.Menu;

public final class ni implements pn {
    final /* synthetic */ ActionBarActivityDelegateBase a;

    private ni(ActionBarActivityDelegateBase actionBarActivityDelegateBase) {
        this.a = actionBarActivityDelegateBase;
    }

    public void a(ox oxVar, boolean z) {
        Menu menu;
        Menu p = oxVar.p();
        boolean z2 = p != oxVar;
        ActionBarActivityDelegateBase actionBarActivityDelegateBase = this.a;
        if (z2) {
            menu = p;
        }
        PanelFeatureState a = actionBarActivityDelegateBase.a(menu);
        if (a == null) {
            return;
        }
        if (z2) {
            this.a.a(a.a, a, p);
            this.a.a(a, true);
            return;
        }
        this.a.a.closeOptionsMenu();
        this.a.a(a, z);
    }

    public boolean a(ox oxVar) {
        if (oxVar == null && this.a.b) {
            nx k = this.a.k();
            if (!(k == null || this.a.m())) {
                k.c(8, oxVar);
            }
        }
        return true;
    }
}
