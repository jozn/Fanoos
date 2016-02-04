import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import ir.seraj.fanoos.Fragment.GroupInfoFragment;

public class acx implements OnClickListener {
    final /* synthetic */ GroupInfoFragment a;

    public acx(GroupInfoFragment groupInfoFragment) {
        this.a = groupInfoFragment;
    }

    public void onClick(View view) {
        if (zm.a(this.a.h()).booleanValue()) {
            new zt().a(String.valueOf(this.a.c), this.a.h());
        } else {
            Toast.makeText(this.a.h(), "\u0639\u062f\u0645 \u0627\u062a\u0635\u0627\u0644 \u06cc\u0647 \u0627\u06cc\u0646\u062a\u0631\u0646\u062a", 0).show();
        }
    }
}
