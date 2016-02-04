import android.support.v7.internal.widget.ActionBarOverlayLayout;

public class qe implements Runnable {
    final /* synthetic */ ActionBarOverlayLayout a;

    public qe(ActionBarOverlayLayout actionBarOverlayLayout) {
        this.a = actionBarOverlayLayout;
    }

    public void run() {
        this.a.k();
        this.a.y = hg.m(this.a.f).c((float) (-this.a.f.getHeight())).a(this.a.A);
        if (this.a.e != null && this.a.e.getVisibility() != 8) {
            this.a.z = hg.m(this.a.e).c((float) this.a.e.getHeight()).a(this.a.B);
        }
    }
}
