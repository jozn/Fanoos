import android.view.View;
import android.view.View.OnClickListener;
import ir.seraj.fanoos.Activity.ChatsActivity;

public class vu implements OnClickListener {
    final /* synthetic */ ChatsActivity a;

    public vu(ChatsActivity chatsActivity) {
        this.a = chatsActivity;
    }

    public void onClick(View view) {
        this.a.a(Boolean.valueOf(true), Boolean.valueOf(true));
        new afs(view.getContext()).execute(new String[0]);
    }
}
