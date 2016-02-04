import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import ir.seraj.fanoos.Fragment.RecentChatsFragment;
import org.xmlpull.v1.XmlPullParser;

public class adm extends BroadcastReceiver {
    final /* synthetic */ RecentChatsFragment a;

    public adm(RecentChatsFragment recentChatsFragment) {
        this.a = recentChatsFragment;
    }

    public void onReceive(Context context, Intent intent) {
        this.a.e = XmlPullParser.NO_NAMESPACE;
        this.a.h.setText(XmlPullParser.NO_NAMESPACE);
        this.a.a = zd.a(this.a.h(), this.a.e);
        this.a.c.a(this.a.a);
        this.a.b.setAdapter(this.a.c);
    }
}
