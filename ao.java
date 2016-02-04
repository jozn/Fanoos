import android.support.v4.app.ListFragment;

public class ao implements Runnable {
    final /* synthetic */ ListFragment a;

    public ao(ListFragment listFragment) {
        this.a = listFragment;
    }

    public void run() {
        this.a.b.focusableViewAvailable(this.a.b);
    }
}
