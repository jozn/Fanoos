import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import ir.seraj.fanoos.Activity.NotificationSettingActivity;
import ir.seraj.fanoos.Activity.SettingActivity;

public class xe implements OnClickListener {
    final /* synthetic */ SettingActivity a;

    public xe(SettingActivity settingActivity) {
        this.a = settingActivity;
    }

    public void onClick(View view) {
        this.a.startActivity(new Intent(view.getContext(), NotificationSettingActivity.class));
    }
}
