import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import ir.seraj.fanoos.Activity.NotificationSettingActivity;
import ir.seraj.fanoos3.R;

public class wl implements OnCheckedChangeListener {
    final /* synthetic */ NotificationSettingActivity a;

    public wl(NotificationSettingActivity notificationSettingActivity) {
        this.a = notificationSettingActivity;
    }

    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        radioGroup.getCheckedRadioButtonId();
        switch (i) {
            case R.id.notification_on_group_radioButton:
                this.a.q = Boolean.valueOf(true);
            case R.id.notification_off_group_radioButton:
                this.a.q = Boolean.valueOf(false);
            default:
        }
    }
}
