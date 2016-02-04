package ir.seraj.fanoos.communication;

import aeq;
import aer;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import org.xmlpull.v1.XmlPullParser;
import ys;
import yz;
import zj;
import zn;

public class IntentServiceCheckNewMessage extends IntentService {
    public IntentServiceCheckNewMessage() {
        super("IntentServiceCheckNewMessage");
    }

    protected void onHandleIntent(Intent intent) {
        if (!intent.equals(null)) {
            yz.j = Boolean.valueOf(true);
            String str = XmlPullParser.NO_NAMESPACE;
            Boolean.valueOf(true);
            Log.i("cancelAlarm", zn.a());
            if (ys.k(this).booleanValue()) {
                Log.i("step intentserviceWhile", zn.a());
                try {
                    aer.a(zj.a(aeq.o(this), this));
                    aer.a((Context) this);
                } catch (Exception e) {
                    Log.i("step intentserviceWhil", "1" + e.getMessage());
                }
                yz.j = Boolean.valueOf(false);
            }
        }
    }
}
