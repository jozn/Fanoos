import android.content.Context;
import android.util.Pair;
import android.util.TypedValue;
import com.edmodo.cropper.cropwindow.CropOverlayView;
import org.kxml2.kdom.Node;

public class vp {
    public static float a(Context context) {
        return TypedValue.applyDimension(1, 24.0f, context.getResources().getDisplayMetrics());
    }

    public static vk a(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        if (a(f, f2, f3, f4, f7)) {
            return vk.TOP_LEFT;
        }
        if (a(f, f2, f5, f4, f7)) {
            return vk.TOP_RIGHT;
        }
        if (a(f, f2, f3, f6, f7)) {
            return vk.BOTTOM_LEFT;
        }
        if (a(f, f2, f5, f6, f7)) {
            return vk.BOTTOM_RIGHT;
        }
        if (c(f, f2, f3, f4, f5, f6) && a()) {
            return vk.CENTER;
        }
        if (a(f, f2, f3, f5, f4, f7)) {
            return vk.TOP;
        }
        if (a(f, f2, f3, f5, f6, f7)) {
            return vk.BOTTOM;
        }
        if (b(f, f2, f3, f4, f6, f7)) {
            return vk.LEFT;
        }
        if (b(f, f2, f5, f4, f6, f7)) {
            return vk.RIGHT;
        }
        return (!c(f, f2, f3, f4, f5, f6) || a()) ? null : vk.CENTER;
    }

    public static Pair a(vk vkVar, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = 0.0f;
        if (vkVar == null) {
            return null;
        }
        float f8;
        switch (vq.a[vkVar.ordinal()]) {
            case ve.CropImageView_fixAspectRatio /*1*/:
                f8 = f3 - f;
                f7 = f4 - f2;
                break;
            case ve.CropImageView_aspectRatioX /*2*/:
                f8 = f5 - f;
                f7 = f4 - f2;
                break;
            case ve.CropImageView_aspectRatioY /*3*/:
                f8 = f3 - f;
                f7 = f6 - f2;
                break;
            case ve.CropImageView_imageResource /*4*/:
                f8 = f5 - f;
                f7 = f6 - f2;
                break;
            case Node.CDSECT /*5*/:
                f8 = f3 - f;
                break;
            case Node.ENTITY_REF /*6*/:
                f8 = 0.0f;
                f7 = f4 - f2;
                break;
            case Node.IGNORABLE_WHITESPACE /*7*/:
                f8 = f5 - f;
                break;
            case Node.PROCESSING_INSTRUCTION /*8*/:
                f8 = 0.0f;
                f7 = f6 - f2;
                break;
            case Node.COMMENT /*9*/:
                f8 = ((f5 + f3) / 2.0f) - f;
                f7 = ((f4 + f6) / 2.0f) - f2;
                break;
            default:
                f8 = 0.0f;
                break;
        }
        return new Pair(Float.valueOf(f8), Float.valueOf(f7));
    }

    private static boolean a(float f, float f2, float f3, float f4, float f5) {
        if (Math.abs(f - f3) > f5 || Math.abs(f2 - f4) > f5) {
            return false;
        }
        return true;
    }

    private static boolean a(float f, float f2, float f3, float f4, float f5, float f6) {
        if (f <= f3 || f >= f4 || Math.abs(f2 - f5) > f6) {
            return false;
        }
        return true;
    }

    private static boolean b(float f, float f2, float f3, float f4, float f5, float f6) {
        if (Math.abs(f - f3) > f6 || f2 <= f4 || f2 >= f5) {
            return false;
        }
        return true;
    }

    private static boolean c(float f, float f2, float f3, float f4, float f5, float f6) {
        if (f <= f3 || f >= f5 || f2 <= f4 || f2 >= f6) {
            return false;
        }
        return true;
    }

    private static boolean a() {
        return !CropOverlayView.b();
    }
}
