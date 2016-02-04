import android.view.View;
import android.view.animation.Interpolator;

class je {
    public static void a(View view, long j) {
        view.animate().setDuration(j);
    }

    public static void a(View view, float f) {
        view.animate().alpha(f);
    }

    public static void b(View view, float f) {
        view.animate().translationX(f);
    }

    public static void c(View view, float f) {
        view.animate().translationY(f);
    }

    public static void a(View view, Interpolator interpolator) {
        view.animate().setInterpolator(interpolator);
    }

    public static void d(View view, float f) {
        view.animate().scaleY(f);
    }

    public static void a(View view) {
        view.animate().cancel();
    }

    public static void b(View view) {
        view.animate().start();
    }

    public static void a(View view, jk jkVar) {
        if (jkVar != null) {
            view.animate().setListener(new jf(jkVar, view));
        } else {
            view.animate().setListener(null);
        }
    }
}
