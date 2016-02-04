import android.support.v7.widget.ActionMenuPresenter;

public class se implements pn {
    final /* synthetic */ ActionMenuPresenter a;

    private se(ActionMenuPresenter actionMenuPresenter) {
        this.a = actionMenuPresenter;
    }

    public boolean a(ox oxVar) {
        if (oxVar == null) {
            return false;
        }
        this.a.h = ((ps) oxVar).getItem().getItemId();
        pn a = this.a.a();
        return a != null ? a.a(oxVar) : false;
    }

    public void a(ox oxVar, boolean z) {
        if (oxVar instanceof ps) {
            ((ps) oxVar).p().a(false);
        }
        pn a = this.a.a();
        if (a != null) {
            a.a(oxVar, z);
        }
    }
}
