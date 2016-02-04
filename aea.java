import android.annotation.TargetApi;
import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

@TargetApi(8)
public class aea extends adz {
    protected final ScaleGestureDetector f;

    public aea(Context context) {
        super(context);
        this.f = new ScaleGestureDetector(context, new aeb(this));
    }

    public boolean a() {
        return this.f.isInProgress();
    }

    public boolean c(MotionEvent motionEvent) {
        this.f.onTouchEvent(motionEvent);
        return super.c(motionEvent);
    }
}
