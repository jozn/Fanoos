import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.List;

public class kg {
    private static final kh a;
    private final Object b;

    static {
        if (VERSION.SDK_INT >= 19) {
            a = new kk();
        } else if (VERSION.SDK_INT >= 16) {
            a = new ki();
        } else {
            a = new km();
        }
    }

    public kg() {
        this.b = a.a(this);
    }

    public kg(Object obj) {
        this.b = obj;
    }

    public Object a() {
        return this.b;
    }

    public jt a(int i) {
        return null;
    }

    public boolean a(int i, int i2, Bundle bundle) {
        return false;
    }

    public List a(String str, int i) {
        return null;
    }

    public jt b(int i) {
        return null;
    }
}
