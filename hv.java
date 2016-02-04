import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.view.View;

class hv {
    static long a() {
        return ValueAnimator.getFrameDelay();
    }

    public static void a(View view, int i, Paint paint) {
        view.setLayerType(i, paint);
    }

    public static int a(View view) {
        return view.getLayerType();
    }

    public static int a(int i, int i2, int i3) {
        return View.resolveSizeAndState(i, i2, i3);
    }

    public static int b(View view) {
        return view.getMeasuredState();
    }

    public static float c(View view) {
        return view.getTranslationY();
    }

    public static void a(View view, float f) {
        view.setTranslationX(f);
    }

    public static void b(View view, float f) {
        view.setTranslationY(f);
    }

    public static void c(View view, float f) {
        view.setAlpha(f);
    }

    public static void d(View view, float f) {
        view.setScaleY(f);
    }

    public static void d(View view) {
        view.jumpDrawablesToCurrentState();
    }
}
