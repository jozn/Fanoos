import android.support.v4.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;
import ir.seraj.fanoos.Activity.ChatsActivity;
import ir.seraj.fanoos.Fragment.RecentChatsFragment;
import ir.seraj.fanoos3.R;
import org.xmlpull.v1.XmlPullParser;

public class vv implements OnClickListener {
    final /* synthetic */ ChatsActivity a;

    public vv(ChatsActivity chatsActivity) {
        this.a = chatsActivity;
    }

    public void onClick(View view) {
        Fragment a = this.a.f().a("RecentChatsFragment");
        if (a == null || !a.n()) {
            this.a.A.setText(XmlPullParser.NO_NAMESPACE);
            Object recentChatsFragment = new RecentChatsFragment();
            this.a.n = recentChatsFragment;
            this.a.f().a().b(R.id.container, recentChatsFragment, "RecentChatsFragment").b();
        }
        this.a.o.setBackgroundColor(this.a.getResources().getColor(R.color.toolBar_header_background_press));
        this.a.p.setBackgroundColor(this.a.getResources().getColor(R.color.toolBar_header_background_normal));
    }
}
