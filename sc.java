import android.support.v7.widget.ActionMenuPresenter;
import android.support.v7.widget.ListPopupWindow;
import android.view.View;

class sc extends ta {
    final /* synthetic */ ActionMenuPresenter a;
    final /* synthetic */ sb b;

    sc(sb sbVar, View view, ActionMenuPresenter actionMenuPresenter) {
        this.b = sbVar;
        this.a = actionMenuPresenter;
        super(view);
    }

    public ListPopupWindow a() {
        if (this.b.a.v == null) {
            return null;
        }
        return this.b.a.v.c();
    }

    public boolean b() {
        this.b.a.c();
        return true;
    }

    public boolean c() {
        if (this.b.a.x != null) {
            return false;
        }
        this.b.a.d();
        return true;
    }
}
