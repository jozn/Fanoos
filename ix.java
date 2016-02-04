import android.view.View;
import java.lang.ref.WeakReference;

class ix implements Runnable {
    WeakReference a;
    iu b;
    final /* synthetic */ iw c;

    private ix(iw iwVar, iu iuVar, View view) {
        this.c = iwVar;
        this.a = new WeakReference(view);
        this.b = iuVar;
    }

    public void run() {
        this.c.c(this.b, (View) this.a.get());
    }
}
