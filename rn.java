import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

public class rn {
    private final Context a;
    private final TypedArray b;
    private rk c;

    public static rn a(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new rn(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    private rn(Context context, TypedArray typedArray) {
        this.a = context;
        this.b = typedArray;
    }

    public Drawable a(int i) {
        if (this.b.hasValue(i)) {
            int resourceId = this.b.getResourceId(i, 0);
            if (resourceId != 0) {
                return c().a(resourceId);
            }
        }
        return this.b.getDrawable(i);
    }

    public int a() {
        return this.b.length();
    }

    public CharSequence b(int i) {
        return this.b.getText(i);
    }

    public String c(int i) {
        return this.b.getString(i);
    }

    public boolean a(int i, boolean z) {
        return this.b.getBoolean(i, z);
    }

    public int a(int i, int i2) {
        return this.b.getInt(i, i2);
    }

    public float a(int i, float f) {
        return this.b.getFloat(i, f);
    }

    public int b(int i, int i2) {
        return this.b.getInteger(i, i2);
    }

    public int c(int i, int i2) {
        return this.b.getDimensionPixelOffset(i, i2);
    }

    public int d(int i, int i2) {
        return this.b.getDimensionPixelSize(i, i2);
    }

    public int e(int i, int i2) {
        return this.b.getLayoutDimension(i, i2);
    }

    public int f(int i, int i2) {
        return this.b.getResourceId(i, i2);
    }

    public boolean d(int i) {
        return this.b.hasValue(i);
    }

    public void b() {
        this.b.recycle();
    }

    public rk c() {
        if (this.c == null) {
            this.c = new rk(this.a);
        }
        return this.c;
    }
}
