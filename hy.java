import android.graphics.Paint;
import android.view.View;

class hy {
    public static void a(View view, Paint paint) {
        view.setLayerPaint(paint);
    }

    public static int a(View view) {
        return view.getLayoutDirection();
    }

    public static int b(View view) {
        return view.getWindowSystemUiVisibility();
    }
}
