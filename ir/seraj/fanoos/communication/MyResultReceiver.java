package ir.seraj.fanoos.communication;

import afk;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

public class MyResultReceiver extends ResultReceiver {
    private afk a;

    public MyResultReceiver(Handler handler) {
        super(handler);
    }

    public void a(afk afk) {
        this.a = afk;
    }

    protected void onReceiveResult(int i, Bundle bundle) {
        if (this.a != null) {
            this.a.a(i, bundle);
        }
    }
}
