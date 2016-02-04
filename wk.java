import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import ir.seraj.fanoos.Activity.NotificationSettingActivity;

public class wk implements OnClickListener {
    final /* synthetic */ NotificationSettingActivity a;

    public wk(NotificationSettingActivity notificationSettingActivity) {
        this.a = notificationSettingActivity;
    }

    public void onClick(View view) {
        aeq.b(this.a, this.a.q);
        aeq.a(this.a, this.a.p);
        Toast.makeText(this.a, "\u062a\u0646\u0638\u06cc\u0645\u0627\u062a \u062c\u062f\u06cc\u062f \u0630\u062e\u06cc\u0631\u0647 \u06af\u0631\u062f\u06cc\u062f", 1).show();
    }
}
