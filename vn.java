import android.graphics.Rect;

class vn extends vl {
    private vf a;

    vn(vf vfVar) {
        super(null, vfVar);
        this.a = vfVar;
    }

    void a(float f, float f2, float f3, Rect rect, float f4) {
        this.a.a(f, f2, rect, f4, f3);
        float a = vf.LEFT.a();
        float a2 = vf.TOP.a();
        float a3 = vf.RIGHT.a();
        float a4 = vf.BOTTOM.a();
        a = (vo.b(a, a3, f3) - (a4 - a2)) / 2.0f;
        a2 -= a;
        a += a4;
        vf.TOP.a(a2);
        vf.BOTTOM.a(a);
        if (vf.TOP.a(rect, f4) && !this.a.a(vf.TOP, rect, f3)) {
            vf.BOTTOM.b(-vf.TOP.a(rect));
            this.a.c(f3);
        }
        if (vf.BOTTOM.a(rect, f4) && !this.a.a(vf.BOTTOM, rect, f3)) {
            vf.TOP.b(-vf.BOTTOM.a(rect));
            this.a.c(f3);
        }
    }
}
