import android.view.View;
import android.view.View.OnClickListener;
import ir.seraj.fanoos.Activity.ChatsActivity;

public class vx implements OnClickListener {
    final /* synthetic */ ChatsActivity a;

    public vx(ChatsActivity chatsActivity) {
        this.a = chatsActivity;
    }

    public void onClick(View view) {
        this.a.y = Boolean.valueOf(true);
        this.a.x.setVisibility(0);
    }
}
