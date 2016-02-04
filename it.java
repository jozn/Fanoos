import android.support.v4.view.ViewPager.LayoutParams;
import android.view.View;
import java.util.Comparator;

public class it implements Comparator {
    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((View) obj, (View) obj2);
    }

    public int a(View view, View view2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
        if (layoutParams.a != layoutParams2.a) {
            return layoutParams.a ? 1 : -1;
        } else {
            return layoutParams.e - layoutParams2.e;
        }
    }
}
