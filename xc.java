import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import ir.seraj.fanoos.Activity.AboutUsActivity;
import ir.seraj.fanoos.Activity.SettingActivity;

public class xc implements OnClickListener {
    final /* synthetic */ SettingActivity a;

    public xc(SettingActivity settingActivity) {
        this.a = settingActivity;
    }

    public void onClick(View view) {
        this.a.startActivity(new Intent(view.getContext(), AboutUsActivity.class));
    }
}
