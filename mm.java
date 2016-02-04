import android.support.v4.widget.SlidingPaneLayout;
import android.view.View;

public class mm implements Runnable {
    final View a;
    final /* synthetic */ SlidingPaneLayout b;

    public mm(SlidingPaneLayout slidingPaneLayout, View view) {
        this.b = slidingPaneLayout;
        this.a = view;
    }

    public void run() {
        if (this.a.getParent() == this.b) {
            hg.a(this.a, 0, null);
            this.b.d(this.a);
        }
        this.b.u.remove(this);
    }
}
