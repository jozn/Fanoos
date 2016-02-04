import android.graphics.Rect;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;

final class ai extends EpicenterCallback {
    final /* synthetic */ Rect a;

    ai(Rect rect) {
        this.a = rect;
    }

    public Rect onGetEpicenter(Transition transition) {
        return this.a;
    }
}
