import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import ir.seraj.fanoos.Activity.ChatsActivity;
import ir.seraj.fanoos.Activity.SettingActivity;

public class wa implements OnClickListener {
    final /* synthetic */ ChatsActivity a;

    public wa(ChatsActivity chatsActivity) {
        this.a = chatsActivity;
    }

    public void onClick(View view) {
        this.a.startActivity(new Intent(view.getContext(), SettingActivity.class));
    }
}
