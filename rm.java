import android.content.res.Resources;
import android.graphics.drawable.Drawable;

class rm extends Resources {
    private final rk a;

    public rm(Resources resources, rk rkVar) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.a = rkVar;
    }

    public Drawable getDrawable(int i) {
        Drawable drawable = super.getDrawable(i);
        if (drawable != null) {
            this.a.a(i, drawable);
        }
        return drawable;
    }
}
