import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;

class rj extends qp {
    private final ColorStateList a;
    private final Mode b;
    private int c;

    public rj(Drawable drawable, ColorStateList colorStateList) {
        this(drawable, colorStateList, rk.a);
    }

    public rj(Drawable drawable, ColorStateList colorStateList, Mode mode) {
        super(drawable);
        this.a = colorStateList;
        this.b = mode;
    }

    public boolean isStateful() {
        return (this.a != null && this.a.isStateful()) || super.isStateful();
    }

    public boolean setState(int[] iArr) {
        return a(iArr) || super.setState(iArr);
    }

    private boolean a(int[] iArr) {
        if (this.a != null) {
            int colorForState = this.a.getColorForState(iArr, this.c);
            if (colorForState != this.c) {
                if (colorForState != 0) {
                    setColorFilter(colorForState, this.b);
                } else {
                    clearColorFilter();
                }
                this.c = colorForState;
                return true;
            }
        }
        return false;
    }
}
