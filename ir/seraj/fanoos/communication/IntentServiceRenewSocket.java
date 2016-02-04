package ir.seraj.fanoos.communication;

import aeq;
import aer;
import android.app.IntentService;
import android.content.Intent;
import ys;
import zj;

public class IntentServiceRenewSocket extends IntentService {
    public IntentServiceRenewSocket() {
        super("IntentServiceRenewSocket");
    }

    protected void onHandleIntent(Intent intent) {
        if (!intent.equals(null) && ys.k(this).booleanValue()) {
            aer.a(zj.a(aeq.o(this), this));
        }
    }
}
