import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import ir.seraj.fanoos.Fragment.RecentChatsFragment;

public class adl extends BroadcastReceiver {
    final /* synthetic */ RecentChatsFragment a;

    public adl(RecentChatsFragment recentChatsFragment) {
        this.a = recentChatsFragment;
    }

    public void onReceive(Context context, Intent intent) {
        this.a.a = zd.a(this.a.h(), this.a.e);
        this.a.c.a(this.a.a);
        this.a.b.setAdapter(this.a.c);
    }
}
