import android.graphics.Rect;

class vm extends vl {
    private vf a;

    vm(vf vfVar) {
        super(vfVar, null);
        this.a = vfVar;
    }

    void a(float f, float f2, float f3, Rect rect, float f4) {
        this.a.a(f, f2, rect, f4, f3);
        float a = vf.LEFT.a();
        float a2 = vf.TOP.a();
        float a3 = vf.RIGHT.a();
        a2 = (vo.a(a2, vf.BOTTOM.a(), f3) - (a3 - a)) / 2.0f;
        a -= a2;
        a2 += a3;
        vf.LEFT.a(a);
        vf.RIGHT.a(a2);
        if (vf.LEFT.a(rect, f4) && !this.a.a(vf.LEFT, rect, f3)) {
            vf.RIGHT.b(-vf.LEFT.a(rect));
            this.a.c(f3);
        }
        if (vf.RIGHT.a(rect, f4) && !this.a.a(vf.RIGHT, rect, f3)) {
            vf.LEFT.b(-vf.RIGHT.a(rect));
            this.a.c(f3);
        }
    }
}
