import android.content.Context;
import android.os.Build.VERSION;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

public final class pq {
    public static Menu a(Context context, dx dxVar) {
        if (VERSION.SDK_INT >= 14) {
            return new pr(context, dxVar);
        }
        throw new UnsupportedOperationException();
    }

    public static MenuItem a(Context context, dy dyVar) {
        if (VERSION.SDK_INT >= 16) {
            return new pi(context, dyVar);
        }
        if (VERSION.SDK_INT >= 14) {
            return new pd(context, dyVar);
        }
        throw new UnsupportedOperationException();
    }

    public static SubMenu a(Context context, dz dzVar) {
        if (VERSION.SDK_INT >= 14) {
            return new pt(context, dzVar);
        }
        throw new UnsupportedOperationException();
    }
}
