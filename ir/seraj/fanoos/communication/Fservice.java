package ir.seraj.fanoos.communication;

import aer;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import org.xmlpull.v1.XmlPullParser;
import ys;
import yz;
import zn;

public class Fservice extends IntentService {
    public Fservice() {
        super("Fservice");
    }

    protected void onHandleIntent(Intent intent) {
        if (!intent.equals(null)) {
            yz.j = Boolean.valueOf(true);
            String str = XmlPullParser.NO_NAMESPACE;
            Boolean.valueOf(true);
            if (ys.k(this).booleanValue()) {
                Log.i("step intentserviceWhile", zn.a());
                try {
                    aer.a((Context) this);
                } catch (Exception e) {
                    Log.i("step intentserviceWhil", "1" + e.getMessage());
                }
                yz.j = Boolean.valueOf(false);
            }
        }
    }
}
