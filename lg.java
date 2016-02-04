import android.database.ContentObserver;
import android.os.Handler;

class lg extends ContentObserver {
    final /* synthetic */ le a;

    public lg(le leVar) {
        this.a = leVar;
        super(new Handler());
    }

    public boolean deliverSelfNotifications() {
        return true;
    }

    public void onChange(boolean z) {
        this.a.b();
    }
}
