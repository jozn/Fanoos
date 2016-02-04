import android.app.Notification.Action;
import android.app.Notification.Builder;
import android.app.RemoteInput;

class bt {
    public static void a(Builder builder, by byVar) {
        Action.Builder builder2 = new Action.Builder(byVar.a(), byVar.b(), byVar.c());
        if (byVar.f() != null) {
            for (RemoteInput addRemoteInput : cn.a(byVar.f())) {
                builder2.addRemoteInput(addRemoteInput);
            }
        }
        if (byVar.d() != null) {
            builder2.addExtras(byVar.d());
        }
        builder.addAction(builder2.build());
    }
}
