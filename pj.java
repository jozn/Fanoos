import android.content.Context;
import android.view.ActionProvider;
import android.view.ActionProvider.VisibilityListener;
import android.view.MenuItem;
import android.view.View;

class pj extends pe implements VisibilityListener {
    fu c;
    final /* synthetic */ pi d;

    public pj(pi piVar, Context context, ActionProvider actionProvider) {
        this.d = piVar;
        super(piVar, context, actionProvider);
    }

    public View a(MenuItem menuItem) {
        return this.a.onCreateActionView(menuItem);
    }

    public boolean b() {
        return this.a.overridesItemVisibility();
    }

    public boolean c() {
        return this.a.isVisible();
    }

    public void a(fu fuVar) {
        VisibilityListener visibilityListener;
        this.c = fuVar;
        ActionProvider actionProvider = this.a;
        if (fuVar == null) {
            visibilityListener = null;
        }
        actionProvider.setVisibilityListener(visibilityListener);
    }

    public void onActionProviderVisibilityChanged(boolean z) {
        if (this.c != null) {
            this.c.a(z);
        }
    }
}
