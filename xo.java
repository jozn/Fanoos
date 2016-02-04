import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import ir.seraj.fanoos.Activity.UserInfoActivity;

public class xo extends BroadcastReceiver {
    final /* synthetic */ UserInfoActivity a;

    public xo(UserInfoActivity userInfoActivity) {
        this.a = userInfoActivity;
    }

    public void onReceive(Context context, Intent intent) {
        this.a.p.setText(intent.getStringExtra("ConversationEventStatus"));
    }
}
