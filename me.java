import android.content.Context;
import android.os.Build.VERSION;
import android.view.animation.Interpolator;

public class me {
    Object a;
    mf b;

    public static me a(Context context) {
        return a(context, null);
    }

    public static me a(Context context, Interpolator interpolator) {
        return new me(context, interpolator);
    }

    me(Context context, Interpolator interpolator) {
        this(VERSION.SDK_INT, context, interpolator);
    }

    private me(int i, Context context, Interpolator interpolator) {
        if (i >= 14) {
            this.b = new mi();
        } else if (i >= 9) {
            this.b = new mh();
        } else {
            this.b = new mg();
        }
        this.a = this.b.a(context, interpolator);
    }

    public boolean a() {
        return this.b.a(this.a);
    }

    public int b() {
        return this.b.b(this.a);
    }

    public int c() {
        return this.b.c(this.a);
    }

    public int d() {
        return this.b.g(this.a);
    }

    public int e() {
        return this.b.h(this.a);
    }

    public float f() {
        return this.b.d(this.a);
    }

    public boolean g() {
        return this.b.e(this.a);
    }

    public void a(int i, int i2, int i3, int i4, int i5) {
        this.b.a(this.a, i, i2, i3, i4, i5);
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.b.a(this.a, i, i2, i3, i4, i5, i6, i7, i8);
    }

    public void h() {
        this.b.f(this.a);
    }
}
