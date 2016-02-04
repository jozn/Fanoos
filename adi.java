import android.view.View;
import android.view.View.OnClickListener;
import ir.seraj.fanoos.Activity.ChatsActivity;
import ir.seraj.fanoos.Fragment.RecentChatsFragment;
import org.xmlpull.v1.XmlPullParser;

public class adi implements OnClickListener {
    final /* synthetic */ RecentChatsFragment a;

    public adi(RecentChatsFragment recentChatsFragment) {
        this.a = recentChatsFragment;
    }

    public void onClick(View view) {
        this.a.e = XmlPullParser.NO_NAMESPACE;
        this.a.h.setText(XmlPullParser.NO_NAMESPACE);
        this.a.a = zd.a(this.a.h(), this.a.e);
        this.a.c.a(this.a.a);
        this.a.b.setAdapter(this.a.c);
        this.a.f.setVisibility(8);
        ((ChatsActivity) this.a.h()).a(Boolean.valueOf(false));
    }
}
