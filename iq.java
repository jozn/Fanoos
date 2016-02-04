import android.database.DataSetObserver;
import android.support.v4.view.ViewPager;

public class iq extends DataSetObserver {
    final /* synthetic */ ViewPager a;

    private iq(ViewPager viewPager) {
        this.a = viewPager;
    }

    public void onChanged() {
        this.a.b();
    }

    public void onInvalidated() {
        this.a.b();
    }
}
