import android.graphics.RectF;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.MotionEvent;
import android.view.View;

public class ado implements OnDoubleTapListener {
    private adq a;

    public ado(adq adq) {
        a(adq);
    }

    public void a(adq adq) {
        this.a = adq;
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        if (this.a == null) {
            return false;
        }
        View c = this.a.c();
        if (this.a.h() != null) {
            RectF b = this.a.b();
            if (b != null) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (b.contains(x, y)) {
                    this.a.h().a(c, (x - b.left) / b.width(), (y - b.top) / b.height());
                    return true;
                }
            }
        }
        if (this.a.i() == null) {
            return false;
        }
        this.a.i().a(c, motionEvent.getX(), motionEvent.getY());
        return false;
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        if (this.a == null) {
            return false;
        }
        try {
            float g = this.a.g();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (g < this.a.e()) {
                this.a.a(this.a.e(), x, y, true);
                return true;
            } else if (g < this.a.e() || g >= this.a.f()) {
                this.a.a(this.a.d(), x, y, true);
                return true;
            } else {
                this.a.a(this.a.f(), x, y, true);
                return true;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return true;
        }
    }

    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }
}
