package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.util.SparseArray;

public abstract class WakefulBroadcastReceiver extends BroadcastReceiver {
    private static final SparseArray a;
    private static int b;

    static {
        a = new SparseArray();
        b = 1;
    }
}
