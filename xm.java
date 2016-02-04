import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import ir.seraj.fanoos.Activity.UserInfoActivity;

public class xm implements OnClickListener {
    final /* synthetic */ UserInfoActivity a;

    public xm(UserInfoActivity userInfoActivity) {
        this.a = userInfoActivity;
    }

    public void onClick(View view) {
        this.a.startActivity(new Intent("android.intent.action.CALL", Uri.parse("tel:" + this.a.n.d())));
    }
}
