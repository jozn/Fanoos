import android.support.v4.view.ViewPager;

public class ij implements Runnable {
    final /* synthetic */ ViewPager a;

    public ij(ViewPager viewPager) {
        this.a = viewPager;
    }

    public void run() {
        this.a.setScrollState(0);
        this.a.c();
    }
}
