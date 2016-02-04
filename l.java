import android.support.v4.app.Fragment;
import android.view.View;

public class l implements r {
    final /* synthetic */ Fragment a;

    public l(Fragment fragment) {
        this.a = fragment;
    }

    public View a(int i) {
        if (this.a.S != null) {
            return this.a.S.findViewById(i);
        }
        throw new IllegalStateException("Fragment does not have a view");
    }

    public boolean a() {
        return this.a.S != null;
    }
}
