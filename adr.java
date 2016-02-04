import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class adr extends SimpleOnGestureListener {
    final /* synthetic */ adq a;

    adr(adq adq) {
        this.a = adq;
    }

    public void onLongPress(MotionEvent motionEvent) {
        if (this.a.s != null) {
            this.a.s.onLongClick(this.a.c());
        }
    }
}
