import android.support.v7.widget.ActionMenuPresenter;
import android.view.View;

public class sa implements Runnable {
    final /* synthetic */ ActionMenuPresenter a;
    private sd b;

    public sa(ActionMenuPresenter actionMenuPresenter, sd sdVar) {
        this.a = actionMenuPresenter;
        this.b = sdVar;
    }

    public void run() {
        this.a.c.f();
        View view = (View) this.a.f;
        if (!(view == null || view.getWindowToken() == null || !this.b.d())) {
            this.a.v = this.b;
        }
        this.a.x = null;
    }
}
