package ir.seraj.fanoos.Service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import ir.seraj.fanoos.communication.IntentServiceRenewSocket;
import zn;

public class ReNewSocketReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        Log.i("ReNewSocketReceiver", zn.a());
        context.startService(new Intent(context, IntentServiceRenewSocket.class));
    }
}
