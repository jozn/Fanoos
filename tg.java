import android.support.v7.widget.ListPopupWindow;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class tg implements OnTouchListener {
    final /* synthetic */ ListPopupWindow a;

    private tg(ListPopupWindow listPopupWindow) {
        this.a = listPopupWindow;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (action == 0 && this.a.d != null && this.a.d.isShowing() && x >= 0 && x < this.a.d.getWidth() && y >= 0 && y < this.a.d.getHeight()) {
            this.a.A.postDelayed(this.a.v, 250);
        } else if (action == 1) {
            this.a.A.removeCallbacks(this.a.v);
        }
        return false;
    }
}
