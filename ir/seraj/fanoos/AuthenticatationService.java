package ir.seraj.fanoos;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import vt;

public class AuthenticatationService extends Service {
    public IBinder onBind(Intent intent) {
        return new vt(this).getIBinder();
    }
}
