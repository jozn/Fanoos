import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

class mg implements mf {
    mg() {
    }

    public Object a(Context context, Interpolator interpolator) {
        return interpolator != null ? new Scroller(context, interpolator) : new Scroller(context);
    }

    public boolean a(Object obj) {
        return ((Scroller) obj).isFinished();
    }

    public int b(Object obj) {
        return ((Scroller) obj).getCurrX();
    }

    public int c(Object obj) {
        return ((Scroller) obj).getCurrY();
    }

    public float d(Object obj) {
        return 0.0f;
    }

    public boolean e(Object obj) {
        return ((Scroller) obj).computeScrollOffset();
    }

    public void a(Object obj, int i, int i2, int i3, int i4, int i5) {
        ((Scroller) obj).startScroll(i, i2, i3, i4, i5);
    }

    public void a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        ((Scroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8);
    }

    public void f(Object obj) {
        ((Scroller) obj).abortAnimation();
    }

    public int g(Object obj) {
        return ((Scroller) obj).getFinalX();
    }

    public int h(Object obj) {
        return ((Scroller) obj).getFinalY();
    }
}
