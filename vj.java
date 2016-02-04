import android.graphics.Rect;

class vj extends vl {
    vj(vf vfVar, vf vfVar2) {
        super(vfVar, vfVar2);
    }

    void a(float f, float f2, float f3, Rect rect, float f4) {
        vh a = a(f, f2, f3);
        vf vfVar = a.a;
        vf vfVar2 = a.b;
        vfVar.a(f, f2, rect, f4, f3);
        vfVar2.c(f3);
        if (vfVar2.a(rect, f4)) {
            vfVar2.a(rect);
            vfVar.c(f3);
        }
    }
}
