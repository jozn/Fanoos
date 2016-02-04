import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import ir.seraj.fanoos.Activity.UserInfoActivity;
import ir.seraj.fanoos.Fragment.GroupInfoFragment;

public class ada implements OnItemClickListener {
    final /* synthetic */ GroupInfoFragment a;

    public ada(GroupInfoFragment groupInfoFragment) {
        this.a = groupInfoFragment;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        if (!aeq.o(this.a.h()).equals(((yx) this.a.b.get(i)).a())) {
            Intent intent = new Intent(this.a.h(), UserInfoActivity.class);
            intent.putExtra("MobileNumber", ((yx) this.a.b.get(i)).a());
            this.a.a(intent);
        }
    }
}
