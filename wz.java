import android.view.View;
import android.view.View.OnClickListener;
import ir.seraj.fanoos.Activity.SettingActivity;

public class wz implements OnClickListener {
    final /* synthetic */ SettingActivity a;

    public wz(SettingActivity settingActivity) {
        this.a = settingActivity;
    }

    public void onClick(View view) {
        this.a.o();
    }
}
