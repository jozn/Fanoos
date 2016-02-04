import android.graphics.Paint;
import android.view.View;

class hl extends hk {
    hl() {
    }

    long a() {
        return hv.a();
    }

    public void a(View view, int i, Paint paint) {
        hv.a(view, i, paint);
    }

    public int g(View view) {
        return hv.a(view);
    }

    public void a(View view, Paint paint) {
        a(view, g(view), paint);
        view.invalidate();
    }

    public int a(int i, int i2, int i3) {
        return hv.a(i, i2, i3);
    }

    public int j(View view) {
        return hv.b(view);
    }

    public float k(View view) {
        return hv.c(view);
    }

    public void b(View view, float f) {
        hv.a(view, f);
    }

    public void c(View view, float f) {
        hv.b(view, f);
    }

    public void d(View view, float f) {
        hv.c(view, f);
    }

    public void e(View view, float f) {
        hv.d(view, f);
    }

    public void q(View view) {
        hv.d(view);
    }
}
