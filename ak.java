import android.graphics.Rect;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;

final class ak extends EpicenterCallback {
    final /* synthetic */ am a;
    private Rect b;

    ak(am amVar) {
        this.a = amVar;
    }

    public Rect onGetEpicenter(Transition transition) {
        if (this.b == null && this.a.a != null) {
            this.b = ah.c(this.a.a);
        }
        return this.b;
    }
}
