import android.view.View;
import android.view.View.OnClickListener;
import ir.seraj.fanoos.Activity.NotificationSettingActivity;

public class wj implements OnClickListener {
    final /* synthetic */ NotificationSettingActivity a;

    public wj(NotificationSettingActivity notificationSettingActivity) {
        this.a = notificationSettingActivity;
    }

    public void onClick(View view) {
        this.a.finish();
    }
}
