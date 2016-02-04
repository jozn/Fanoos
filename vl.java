import android.graphics.Rect;

abstract class vl {
    private vf a;
    private vf b;
    private vh c;

    abstract void a(float f, float f2, float f3, Rect rect, float f4);

    vl(vf vfVar, vf vfVar2) {
        this.a = vfVar;
        this.b = vfVar2;
        this.c = new vh(this.a, this.b);
    }

    void a(float f, float f2, Rect rect, float f3) {
        vh a = a();
        vf vfVar = a.a;
        vf vfVar2 = a.b;
        if (vfVar != null) {
            vfVar.a(f, f2, rect, f3, 1.0f);
        }
        if (vfVar2 != null) {
            vfVar2.a(f, f2, rect, f3, 1.0f);
        }
    }

    vh a() {
        return this.c;
    }

    vh a(float f, float f2, float f3) {
        if (a(f, f2) > f3) {
            this.c.a = this.b;
            this.c.b = this.a;
        } else {
            this.c.a = this.a;
            this.c.b = this.b;
        }
        return this.c;
    }

    private float a(float f, float f2) {
        float a = this.b == vf.LEFT ? f : vf.LEFT.a();
        float a2 = this.a == vf.TOP ? f2 : vf.TOP.a();
        if (this.b != vf.RIGHT) {
            f = vf.RIGHT.a();
        }
        if (this.a != vf.BOTTOM) {
            f2 = vf.BOTTOM.a();
        }
        return vo.a(a, a2, f, f2);
    }
}
