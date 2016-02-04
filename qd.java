import android.support.v7.internal.widget.ActionBarOverlayLayout;

public class qd implements Runnable {
    final /* synthetic */ ActionBarOverlayLayout a;

    public qd(ActionBarOverlayLayout actionBarOverlayLayout) {
        this.a = actionBarOverlayLayout;
    }

    public void run() {
        this.a.k();
        this.a.y = hg.m(this.a.f).c(0.0f).a(this.a.A);
        if (this.a.e != null && this.a.e.getVisibility() != 8) {
            this.a.z = hg.m(this.a.e).c(0.0f).a(this.a.B);
        }
    }
}
