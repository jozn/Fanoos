import android.view.InflateException;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import java.lang.reflect.Method;

class ol implements OnMenuItemClickListener {
    private static final Class[] a;
    private Object b;
    private Method c;

    static {
        a = new Class[]{MenuItem.class};
    }

    public ol(Object obj, String str) {
        this.b = obj;
        Class cls = obj.getClass();
        try {
            this.c = cls.getMethod(str, a);
        } catch (Throwable e) {
            InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
            inflateException.initCause(e);
            throw inflateException;
        }
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        try {
            if (this.c.getReturnType() == Boolean.TYPE) {
                return ((Boolean) this.c.invoke(this.b, new Object[]{menuItem})).booleanValue();
            }
            this.c.invoke(this.b, new Object[]{menuItem});
            return true;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
