import android.content.Context;
import android.support.v7.widget.ActionMenuPresenter;
import android.view.View;

public class sd extends pk {
    final /* synthetic */ ActionMenuPresenter c;

    public sd(ActionMenuPresenter actionMenuPresenter, Context context, ox oxVar, View view, boolean z) {
        this.c = actionMenuPresenter;
        super(context, oxVar, view, z, nl.actionOverflowMenuStyle);
        a(8388613);
        a(actionMenuPresenter.g);
    }

    public void onDismiss() {
        super.onDismiss();
        this.c.c.close();
        this.c.v = null;
    }
}
