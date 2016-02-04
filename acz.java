import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import ir.seraj.fanoos.Fragment.GroupInfoFragment;
import ir.seraj.fanoos3.R;

public class acz extends BroadcastReceiver {
    final /* synthetic */ GroupInfoFragment a;

    public acz(GroupInfoFragment groupInfoFragment) {
        this.a = groupInfoFragment;
    }

    public void onReceive(Context context, Intent intent) {
        this.a.b = yx.a(this.a.c, this.a.h());
        this.a.e = yw.c(this.a.c, this.a.h());
        this.a.d.a(this.a.b);
        this.a.a.setAdapter(this.a.d);
        this.a.am.a(this.a.e.a(), this.a.g, Integer.valueOf(R.drawable.default_image_group));
        this.a.i.setText(this.a.e.c());
    }
}
