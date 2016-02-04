import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Interpolator;

public class uh implements Runnable {
    final /* synthetic */ RecyclerView a;
    private int b;
    private int c;
    private me d;
    private Interpolator e;
    private boolean f;
    private boolean g;

    public void run() {
        c();
        this.a.o();
        me meVar = this.d;
        ud udVar = this.a.p.j;
        if (meVar.g()) {
            int b;
            int i;
            int top;
            int e;
            int b2 = meVar.b();
            int c = meVar.c();
            int i2 = b2 - this.b;
            int i3 = c - this.c;
            int i4 = 0;
            int i5 = 0;
            this.b = b2;
            this.c = c;
            int i6 = 0;
            int i7 = 0;
            if (this.a.o != null) {
                this.a.a();
                this.a.C = true;
                if (i2 != 0) {
                    i4 = this.a.p.a(i2, this.a.a, this.a.f);
                    i6 = i2 - i4;
                }
                if (i3 != 0) {
                    i5 = this.a.p.b(i3, this.a.a, this.a.f);
                    i7 = i3 - i5;
                }
                if (this.a.s()) {
                    b = this.a.c.b();
                    for (i = 0; i < b; i++) {
                        View b3 = this.a.c.b(i);
                        ui a = this.a.a(b3);
                        if (!(a == null || a.h == null)) {
                            View view = a.h != null ? a.h.a : null;
                            if (view != null) {
                                int left = b3.getLeft();
                                top = b3.getTop();
                                if (left != view.getLeft() || top != view.getTop()) {
                                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                                }
                            }
                        }
                    }
                }
                if (!(udVar == null || udVar.b() || !udVar.c())) {
                    e = this.a.f.e();
                    if (e == 0) {
                        udVar.a();
                    } else if (udVar.d() >= e) {
                        udVar.a(e - 1);
                        udVar.a(i2 - i6, i3 - i7);
                    } else {
                        udVar.a(i2 - i6, i3 - i7);
                    }
                }
                this.a.C = false;
                this.a.a(false);
            }
            e = i7;
            i = i6;
            b = i5;
            top = i4;
            Object obj = (i2 == top && i3 == b) ? 1 : null;
            if (!this.a.r.isEmpty()) {
                this.a.invalidate();
            }
            if (hg.a(this.a) != 2) {
                this.a.f(i2, i3);
            }
            if (!(i == 0 && e == 0)) {
                i6 = (int) meVar.f();
                if (i != b2) {
                    i5 = i < 0 ? -i6 : i > 0 ? i6 : 0;
                    i4 = i5;
                } else {
                    i4 = 0;
                }
                if (e == c) {
                    i6 = 0;
                } else if (e < 0) {
                    i6 = -i6;
                } else if (e <= 0) {
                    i6 = 0;
                }
                if (hg.a(this.a) != 2) {
                    this.a.d(i4, i6);
                }
                if ((i4 != 0 || i == b2 || meVar.d() == 0) && (i6 != 0 || e == c || meVar.e() == 0)) {
                    meVar.h();
                }
            }
            if (!(top == 0 && b == 0)) {
                this.a.onScrollChanged(0, 0, 0, 0);
                if (this.a.S != null) {
                    this.a.S.a(this.a, top, b);
                }
            }
            if (!this.a.awakenScrollBars()) {
                this.a.invalidate();
            }
            if (meVar.a() || obj == null) {
                this.a.setScrollState(0);
            } else {
                a();
            }
        }
        if (udVar != null && udVar.b()) {
            udVar.a(0, 0);
        }
        d();
    }

    private void c() {
        this.g = false;
        this.f = true;
    }

    private void d() {
        this.f = false;
        if (this.g) {
            a();
        }
    }

    void a() {
        if (this.f) {
            this.g = true;
        } else {
            hg.a(this.a, (Runnable) this);
        }
    }

    public void a(int i, int i2) {
        this.a.setScrollState(2);
        this.c = 0;
        this.b = 0;
        this.d.a(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        a();
    }

    public void b(int i, int i2) {
        a(i, i2, 0, 0);
    }

    public void a(int i, int i2, int i3, int i4) {
        a(i, i2, b(i, i2, i3, i4));
    }

    private float a(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    private int b(int i, int i2, int i3, int i4) {
        int round;
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        Object obj = abs > abs2 ? 1 : null;
        int sqrt = (int) Math.sqrt((double) ((i3 * i3) + (i4 * i4)));
        int sqrt2 = (int) Math.sqrt((double) ((i * i) + (i2 * i2)));
        int width = obj != null ? this.a.getWidth() : this.a.getHeight();
        int i5 = width / 2;
        float a = (a(Math.min(1.0f, (((float) sqrt2) * 1.0f) / ((float) width))) * ((float) i5)) + ((float) i5);
        if (sqrt > 0) {
            round = Math.round(1000.0f * Math.abs(a / ((float) sqrt))) * 4;
        } else {
            if (obj != null) {
                round = abs;
            } else {
                round = abs2;
            }
            round = (int) (((((float) round) / ((float) width)) + 1.0f) * 300.0f);
        }
        return Math.min(round, 2000);
    }

    public void a(int i, int i2, int i3) {
        a(i, i2, i3, RecyclerView.aa);
    }

    public void a(int i, int i2, int i3, Interpolator interpolator) {
        if (this.e != interpolator) {
            this.e = interpolator;
            this.d = me.a(this.a.getContext(), interpolator);
        }
        this.a.setScrollState(2);
        this.c = 0;
        this.b = 0;
        this.d.a(0, 0, i, i2, i3);
        a();
    }

    public void b() {
        this.a.removeCallbacks(this);
        this.d.h();
    }
}
