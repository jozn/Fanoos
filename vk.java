import android.graphics.Rect;

public enum vk {
    TOP_LEFT(new vj(vf.TOP, vf.LEFT)),
    TOP_RIGHT(new vj(vf.TOP, vf.RIGHT)),
    BOTTOM_LEFT(new vj(vf.BOTTOM, vf.LEFT)),
    BOTTOM_RIGHT(new vj(vf.BOTTOM, vf.RIGHT)),
    LEFT(new vn(vf.LEFT)),
    TOP(new vm(vf.TOP)),
    RIGHT(new vn(vf.RIGHT)),
    BOTTOM(new vm(vf.BOTTOM)),
    CENTER(new vi());
    
    private vl j;

    private vk(vl vlVar) {
        this.j = vlVar;
    }

    public void a(float f, float f2, Rect rect, float f3) {
        this.j.a(f, f2, rect, f3);
    }

    public void a(float f, float f2, float f3, Rect rect, float f4) {
        this.j.a(f, f2, f3, rect, f4);
    }
}
