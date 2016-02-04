import android.content.Context;
import android.support.v7.widget.ActionMenuPresenter;
import android.view.MenuItem;
import android.view.View;

public class ry extends pk {
    final /* synthetic */ ActionMenuPresenter c;
    private ps d;

    public ry(ActionMenuPresenter actionMenuPresenter, Context context, ps psVar) {
        boolean z = false;
        this.c = actionMenuPresenter;
        super(context, psVar, null, false, nl.actionOverflowMenuStyle);
        this.d = psVar;
        if (!((pb) psVar.getItem()).j()) {
            a(actionMenuPresenter.i == null ? (View) actionMenuPresenter.f : actionMenuPresenter.i);
        }
        a(actionMenuPresenter.g);
        int size = psVar.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = psVar.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
        }
        b(z);
    }

    public void onDismiss() {
        super.onDismiss();
        this.c.w = null;
        this.c.h = 0;
    }
}
