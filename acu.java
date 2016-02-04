import android.view.View;
import android.view.View.OnClickListener;
import ir.seraj.fanoos.Fragment.GroupInfoFragment;

public class acu implements OnClickListener {
    final /* synthetic */ GroupInfoFragment a;

    public acu(GroupInfoFragment groupInfoFragment) {
        this.a = groupInfoFragment;
    }

    public void onClick(View view) {
        this.a.h().finish();
    }
}
