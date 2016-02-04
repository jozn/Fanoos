import android.support.v7.internal.view.menu.ActionMenuItemView;
import android.support.v7.widget.ListPopupWindow;

public class oq extends ta {
    final /* synthetic */ ActionMenuItemView a;

    public oq(ActionMenuItemView actionMenuItemView) {
        this.a = actionMenuItemView;
        super(actionMenuItemView);
    }

    public ListPopupWindow a() {
        if (this.a.f != null) {
            return this.a.f.a();
        }
        return null;
    }

    protected boolean b() {
        if (this.a.d == null || !this.a.d.a(this.a.a)) {
            return false;
        }
        ListPopupWindow a = a();
        if (a == null || !a.b()) {
            return false;
        }
        return true;
    }

    protected boolean c() {
        ListPopupWindow a = a();
        if (a == null) {
            return false;
        }
        a.a();
        return true;
    }
}
