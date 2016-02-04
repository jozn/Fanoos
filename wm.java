import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import ir.seraj.fanoos.Activity.NotificationSettingActivity;
import ir.seraj.fanoos3.R;

public class wm implements OnCheckedChangeListener {
    final /* synthetic */ NotificationSettingActivity a;

    public wm(NotificationSettingActivity notificationSettingActivity) {
        this.a = notificationSettingActivity;
    }

    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        radioGroup.getCheckedRadioButtonId();
        switch (i) {
            case R.id.notification_on_user_radioButton:
                this.a.p = Boolean.valueOf(true);
            case R.id.notification_off_user_radioButton:
                this.a.p = Boolean.valueOf(false);
            default:
        }
    }
}
