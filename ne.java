import android.support.v7.app.ActionBarActivityDelegateBase;

public class ne implements Runnable {
    final /* synthetic */ ActionBarActivityDelegateBase a;

    public ne(ActionBarActivityDelegateBase actionBarActivityDelegateBase) {
        this.a = actionBarActivityDelegateBase;
    }

    public void run() {
        this.a.i.showAtLocation(this.a.h, 55, 0, 0);
    }
}
