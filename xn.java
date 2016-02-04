import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import ir.seraj.fanoos.Activity.ConversationActivity;
import ir.seraj.fanoos.Activity.UserInfoActivity;

public class xn implements OnClickListener {
    final /* synthetic */ UserInfoActivity a;

    public xn(UserInfoActivity userInfoActivity) {
        this.a = userInfoActivity;
    }

    public void onClick(View view) {
        Intent intent = new Intent(view.getContext(), ConversationActivity.class);
        intent.setFlags(67108864);
        intent.putExtra("MobileNumber", this.a.n.d());
        intent.putExtra("IsGroup", "0");
        this.a.startActivity(intent);
    }
}
