import android.view.View;
import android.view.View.OnClickListener;
import ir.seraj.fanoos.Fragment.GroupInfoFragment;

public class acv implements OnClickListener {
    final /* synthetic */ GroupInfoFragment a;

    public acv(GroupInfoFragment groupInfoFragment) {
        this.a = groupInfoFragment;
    }

    public void onClick(View view) {
        new zt().a(this.a.e.c(), String.valueOf(this.a.e.b()), this.a.h());
    }
}
