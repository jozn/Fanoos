import android.support.v7.app.ActionBarActivityDelegateBase;

public class nb implements Runnable {
    final /* synthetic */ ActionBarActivityDelegateBase a;

    public nb(ActionBarActivityDelegateBase actionBarActivityDelegateBase) {
        this.a = actionBarActivityDelegateBase;
    }

    public void run() {
        if ((this.a.y & 1) != 0) {
            this.a.d(0);
        }
        if ((this.a.y & 256) != 0) {
            this.a.d(8);
        }
        this.a.x = false;
        this.a.y = 0;
    }
}
