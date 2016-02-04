import android.view.View;

class adt implements Runnable {
    final /* synthetic */ adq a;
    private final float b;
    private final float c;
    private final long d;
    private final float e;
    private final float f;

    public adt(adq adq, float f, float f2, float f3, float f4) {
        this.a = adq;
        this.b = f3;
        this.c = f4;
        this.d = System.currentTimeMillis();
        this.e = f;
        this.f = f2;
    }

    public void run() {
        View c = this.a.c();
        if (c != null) {
            float a = a();
            float g = (this.e + ((this.f - this.e) * a)) / this.a.g();
            this.a.m.postScale(g, g, this.b, this.c);
            this.a.n();
            if (a < 1.0f) {
                adn.a(c, this);
            }
        }
    }

    private float a() {
        return adq.a.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.d)) * 1.0f) / ((float) this.a.b)));
    }
}
