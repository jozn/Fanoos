import android.content.Context;
import android.view.ActionProvider;
import android.view.SubMenu;
import android.view.View;

class pe extends fs {
    final ActionProvider a;
    final /* synthetic */ pd b;

    public pe(pd pdVar, Context context, ActionProvider actionProvider) {
        this.b = pdVar;
        super(context);
        this.a = actionProvider;
    }

    public View a() {
        return this.a.onCreateActionView();
    }

    public boolean d() {
        return this.a.onPerformDefaultAction();
    }

    public boolean e() {
        return this.a.hasSubMenu();
    }

    public void a(SubMenu subMenu) {
        this.a.onPrepareSubMenu(this.b.a(subMenu));
    }
}
