import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;

public class p implements r {
    final /* synthetic */ FragmentActivity a;

    public p(FragmentActivity fragmentActivity) {
        this.a = fragmentActivity;
    }

    public View a(int i) {
        return this.a.findViewById(i);
    }

    public boolean a() {
        Window window = this.a.getWindow();
        return (window == null || window.peekDecorView() == null) ? false : true;
    }
}
