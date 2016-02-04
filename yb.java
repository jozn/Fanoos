import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import ir.seraj.fanoos.Activity.SettingActivity;

class yb implements OnClickListener {
    final /* synthetic */ xv a;

    yb(xv xvVar) {
        this.a = xvVar;
    }

    public void onClick(View view) {
        this.a.b.startActivity(new Intent(this.a.b, SettingActivity.class));
    }
}
