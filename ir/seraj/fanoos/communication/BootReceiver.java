package ir.seraj.fanoos.communication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import ys;

public class BootReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
            ys.c(context);
        }
    }
}
