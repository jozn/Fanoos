import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;

public class ls {
    private static final lv b;
    private Object a;

    static {
        if (VERSION.SDK_INT >= 14) {
            b = new lu();
        } else {
            b = new lt();
        }
    }

    public ls(Context context) {
        this.a = b.a(context);
    }

    public void a(int i, int i2) {
        b.a(this.a, i, i2);
    }

    public boolean a() {
        return b.a(this.a);
    }

    public void b() {
        b.b(this.a);
    }

    public boolean a(float f) {
        return b.a(this.a, f);
    }

    public boolean c() {
        return b.c(this.a);
    }

    public boolean a(int i) {
        return b.a(this.a, i);
    }

    public boolean a(Canvas canvas) {
        return b.a(this.a, canvas);
    }
}
