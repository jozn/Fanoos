package ir.seraj.fanoos;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.util.Log;
import ys;
import yz;

public class NetworkReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo() != null) {
            yz.i = Boolean.valueOf(true);
            ys.d(context);
            ys.i(context);
            ys.h(context);
            ys.f(context);
            return;
        }
        yz.i = Boolean.valueOf(false);
        Log.i("NetworkReceiver", "0");
        ys.e(context);
        ys.j(context);
        ys.g(context);
    }
}
