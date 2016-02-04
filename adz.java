import android.annotation.TargetApi;
import android.content.Context;
import android.view.MotionEvent;
import org.kxml2.kdom.Node;

@TargetApi(5)
public class adz extends ady {
    private int f;
    private int g;

    public adz(Context context) {
        super(context);
        this.f = -1;
        this.g = 0;
    }

    float a(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.g);
        } catch (Exception e) {
            return motionEvent.getX();
        }
    }

    float b(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.g);
        } catch (Exception e) {
            return motionEvent.getY();
        }
    }

    public boolean c(MotionEvent motionEvent) {
        int i = 0;
        switch (motionEvent.getAction() & 255) {
            case ve.CropImageView_guidelines /*0*/:
                this.f = motionEvent.getPointerId(0);
                break;
            case ve.CropImageView_fixAspectRatio /*1*/:
            case ve.CropImageView_aspectRatioY /*3*/:
                this.f = -1;
                break;
            case Node.ENTITY_REF /*6*/:
                int a = adn.a(motionEvent.getAction());
                if (motionEvent.getPointerId(a) == this.f) {
                    if (a == 0) {
                        a = 1;
                    } else {
                        a = 0;
                    }
                    this.f = motionEvent.getPointerId(a);
                    this.b = motionEvent.getX(a);
                    this.c = motionEvent.getY(a);
                    break;
                }
                break;
        }
        if (this.f != -1) {
            i = this.f;
        }
        this.g = motionEvent.findPointerIndex(i);
        return super.c(motionEvent);
    }
}
