import android.graphics.Rect;

class vi extends vl {
    vi() {
        super(null, null);
    }

    void a(float f, float f2, Rect rect, float f3) {
        float a = vf.LEFT.a();
        float a2 = vf.TOP.a();
        a = f - ((a + vf.RIGHT.a()) / 2.0f);
        a2 = f2 - ((a2 + vf.BOTTOM.a()) / 2.0f);
        vf.LEFT.b(a);
        vf.TOP.b(a2);
        vf.RIGHT.b(a);
        vf.BOTTOM.b(a2);
        if (vf.LEFT.a(rect, f3)) {
            vf.RIGHT.b(vf.LEFT.a(rect));
        } else if (vf.RIGHT.a(rect, f3)) {
            vf.LEFT.b(vf.RIGHT.a(rect));
        }
        if (vf.TOP.a(rect, f3)) {
            vf.BOTTOM.b(vf.TOP.a(rect));
        } else if (vf.BOTTOM.a(rect, f3)) {
            vf.TOP.b(vf.BOTTOM.a(rect));
        }
    }

    void a(float f, float f2, float f3, Rect rect, float f4) {
        a(f, f2, rect, f4);
    }
}
