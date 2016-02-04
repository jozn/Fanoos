package ir.seraj.fanoos.Service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import ir.seraj.fanoos.communication.Fservice;

public class ReReadReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        context.startService(new Intent(context, Fservice.class));
    }
}
