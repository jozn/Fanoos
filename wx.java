import android.view.View;
import android.view.View.OnClickListener;
import ir.seraj.fanoos.Activity.SettingActivity;

public class wx implements OnClickListener {
    final /* synthetic */ SettingActivity a;

    public wx(SettingActivity settingActivity) {
        this.a = settingActivity;
    }

    public void onClick(View view) {
        new zt().a(aeq.l(view.getContext()), new wy(this), view.getContext());
    }
}
