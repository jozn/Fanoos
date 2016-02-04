import android.graphics.Paint;
import android.os.Build.VERSION;
import android.view.View;

public class hg {
    static final hq a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            a = new hh();
        } else if (i >= 19) {
            a = new hp();
        } else if (i >= 17) {
            a = new ho();
        } else if (i >= 16) {
            a = new hn();
        } else if (i >= 14) {
            a = new hm();
        } else if (i >= 11) {
            a = new hl();
        } else if (i >= 9) {
            a = new hk();
        } else if (i >= 7) {
            a = new hj();
        } else {
            a = new hi();
        }
    }

    public static boolean a(View view, int i) {
        return a.a(view, i);
    }

    public static boolean b(View view, int i) {
        return a.b(view, i);
    }

    public static int a(View view) {
        return a.b(view);
    }

    public static void a(View view, ff ffVar) {
        a.a(view, ffVar);
    }

    public static boolean b(View view) {
        return a.c(view);
    }

    public static boolean c(View view) {
        return a.d(view);
    }

    public static void d(View view) {
        a.e(view);
    }

    public static void a(View view, int i, int i2, int i3, int i4) {
        a.a(view, i, i2, i3, i4);
    }

    public static void a(View view, Runnable runnable) {
        a.a(view, runnable);
    }

    public static void a(View view, Runnable runnable, long j) {
        a.a(view, runnable, j);
    }

    public static int e(View view) {
        return a.f(view);
    }

    public static void c(View view, int i) {
        a.c(view, i);
    }

    public static void a(View view, int i, Paint paint) {
        a.a(view, i, paint);
    }

    public static int f(View view) {
        return a.g(view);
    }

    public static void a(View view, Paint paint) {
        a.a(view, paint);
    }

    public static int g(View view) {
        return a.h(view);
    }

    public static boolean h(View view) {
        return a.i(view);
    }

    public static int a(int i, int i2, int i3) {
        return a.a(i, i2, i3);
    }

    public static int i(View view) {
        return a.j(view);
    }

    public static float j(View view) {
        return a.k(view);
    }

    public static int k(View view) {
        return a.l(view);
    }

    public static int l(View view) {
        return a.m(view);
    }

    public static iu m(View view) {
        return a.n(view);
    }

    public static void a(View view, float f) {
        a.b(view, f);
    }

    public static void b(View view, float f) {
        a.c(view, f);
    }

    public static void c(View view, float f) {
        a.d(view, f);
    }

    public static void d(View view, float f) {
        a.e(view, f);
    }

    public static void e(View view, float f) {
        a.a(view, f);
    }

    public static int n(View view) {
        return a.o(view);
    }

    public static void o(View view) {
        a.a(view);
    }

    public static boolean p(View view) {
        return a.p(view);
    }

    public static void q(View view) {
        a.q(view);
    }

    public static void a(View view, gz gzVar) {
        a.a(view, gzVar);
    }
}
