package ir.seraj.fanoos.Service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import ir.seraj.fanoos.communication.IntentServiceCheckNewMessage;
import yz;
import zn;

public class CheckNewMessageReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        Log.i("CheckNewMessageReceiver", zn.a());
        if (!yz.j.booleanValue()) {
            context.startService(new Intent(context, IntentServiceCheckNewMessage.class));
        }
    }
}
