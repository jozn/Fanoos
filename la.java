import android.content.res.Resources;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;

public abstract class la implements OnTouchListener {
    private static final int r;
    private final lc a;
    private final Interpolator b;
    private final View c;
    private Runnable d;
    private float[] e;
    private float[] f;
    private int g;
    private int h;
    private float[] i;
    private float[] j;
    private float[] k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;

    public abstract void a(int i, int i2);

    public abstract boolean e(int i);

    public abstract boolean f(int i);

    static {
        r = ViewConfiguration.getTapTimeout();
    }

    public la(View view) {
        this.a = new lc();
        this.b = new AccelerateInterpolator();
        this.e = new float[]{0.0f, 0.0f};
        this.f = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
        this.i = new float[]{0.0f, 0.0f};
        this.j = new float[]{0.0f, 0.0f};
        this.k = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
        this.c = view;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        int i = (int) ((1575.0f * displayMetrics.density) + 0.5f);
        int i2 = (int) ((displayMetrics.density * 315.0f) + 0.5f);
        a((float) i, (float) i);
        b((float) i2, (float) i2);
        a(1);
        e(Float.MAX_VALUE, Float.MAX_VALUE);
        d(0.2f, 0.2f);
        c(1.0f, 1.0f);
        b(r);
        c(500);
        d(500);
    }

    public la a(boolean z) {
        if (this.p && !z) {
            c();
        }
        this.p = z;
        return this;
    }

    public la a(float f, float f2) {
        this.k[0] = f / 1000.0f;
        this.k[1] = f2 / 1000.0f;
        return this;
    }

    public la b(float f, float f2) {
        this.j[0] = f / 1000.0f;
        this.j[1] = f2 / 1000.0f;
        return this;
    }

    public la c(float f, float f2) {
        this.i[0] = f / 1000.0f;
        this.i[1] = f2 / 1000.0f;
        return this;
    }

    public la a(int i) {
        this.g = i;
        return this;
    }

    public la d(float f, float f2) {
        this.e[0] = f;
        this.e[1] = f2;
        return this;
    }

    public la e(float f, float f2) {
        this.f[0] = f;
        this.f[1] = f2;
        return this;
    }

    public la b(int i) {
        this.h = i;
        return this;
    }

    public la c(int i) {
        this.a.a(i);
        return this;
    }

    public la d(int i) {
        this.a.b(i);
        return this;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z = true;
        if (!this.p) {
            return false;
        }
        switch (gu.a(motionEvent)) {
            case ve.CropImageView_guidelines /*0*/:
                this.n = true;
                this.l = false;
                break;
            case ve.CropImageView_fixAspectRatio /*1*/:
            case ve.CropImageView_aspectRatioY /*3*/:
                c();
                break;
            case ve.CropImageView_aspectRatioX /*2*/:
                break;
        }
        this.a.a(a(0, motionEvent.getX(), (float) view.getWidth(), (float) this.c.getWidth()), a(1, motionEvent.getY(), (float) view.getHeight(), (float) this.c.getHeight()));
        if (!this.o && a()) {
            b();
        }
        if (!(this.q && this.o)) {
            z = false;
        }
        return z;
    }

    private boolean a() {
        lc lcVar = this.a;
        int f = lcVar.f();
        int e = lcVar.e();
        return (f != 0 && f(f)) || (e != 0 && e(e));
    }

    private void b() {
        if (this.d == null) {
            this.d = new ld();
        }
        this.o = true;
        this.m = true;
        if (this.l || this.h <= 0) {
            this.d.run();
        } else {
            hg.a(this.c, this.d, (long) this.h);
        }
        this.l = true;
    }

    private void c() {
        if (this.m) {
            this.o = false;
        } else {
            this.a.b();
        }
    }

    private float a(int i, float f, float f2, float f3) {
        float a = a(this.e[i], f2, this.f[i], f);
        if (a == 0.0f) {
            return 0.0f;
        }
        float f4 = this.i[i];
        float f5 = this.j[i];
        float f6 = this.k[i];
        f4 *= f3;
        if (a > 0.0f) {
            return b(a * f4, f5, f6);
        }
        return -b((-a) * f4, f5, f6);
    }

    private float a(float f, float f2, float f3, float f4) {
        float f5;
        float b = b(f * f2, 0.0f, f3);
        b = f(f2 - f4, b) - f(f4, b);
        if (b < 0.0f) {
            f5 = -this.b.getInterpolation(-b);
        } else if (b <= 0.0f) {
            return 0.0f;
        } else {
            f5 = this.b.getInterpolation(b);
        }
        return b(f5, -1.0f, 1.0f);
    }

    private float f(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        switch (this.g) {
            case ve.CropImageView_guidelines /*0*/:
            case ve.CropImageView_fixAspectRatio /*1*/:
                if (f >= f2) {
                    return 0.0f;
                }
                if (f >= 0.0f) {
                    return 1.0f - (f / f2);
                }
                if (this.o && this.g == 1) {
                    return 1.0f;
                }
                return 0.0f;
            case ve.CropImageView_aspectRatioX /*2*/:
                if (f < 0.0f) {
                    return f / (-f2);
                }
                return 0.0f;
            default:
                return 0.0f;
        }
    }

    private static int b(int i, int i2, int i3) {
        if (i > i3) {
            return i3;
        }
        if (i < i2) {
            return i2;
        }
        return i;
    }

    private static float b(float f, float f2, float f3) {
        if (f > f3) {
            return f3;
        }
        if (f < f2) {
            return f2;
        }
        return f;
    }

    private void d() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.c.onTouchEvent(obtain);
        obtain.recycle();
    }
}
