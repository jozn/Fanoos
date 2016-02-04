import android.view.View;

class hx {
    public static boolean a(View view) {
        return view.hasTransientState();
    }

    public static void b(View view) {
        view.postInvalidateOnAnimation();
    }

    public static void a(View view, int i, int i2, int i3, int i4) {
        view.postInvalidate(i, i2, i3, i4);
    }

    public static void a(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static void a(View view, Runnable runnable, long j) {
        view.postOnAnimationDelayed(runnable, j);
    }

    public static int c(View view) {
        return view.getImportantForAccessibility();
    }

    public static void a(View view, int i) {
        view.setImportantForAccessibility(i);
    }

    public static int d(View view) {
        return view.getMinimumWidth();
    }

    public static int e(View view) {
        return view.getMinimumHeight();
    }

    public static void f(View view) {
        view.requestFitSystemWindows();
    }

    public static boolean g(View view) {
        return view.getFitsSystemWindows();
    }
}
