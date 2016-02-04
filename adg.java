import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import ir.seraj.fanoos.Activity.ChatsActivity;
import ir.seraj.fanoos.Fragment.NewConversationFragment;

public class adg extends BroadcastReceiver {
    final /* synthetic */ NewConversationFragment a;

    public adg(NewConversationFragment newConversationFragment) {
        this.a = newConversationFragment;
    }

    public void onReceive(Context context, Intent intent) {
        this.a.b = zg.a(this.a.h());
        this.a.d = new yk(this.a.h(), this.a.b);
        ((ChatsActivity) this.a.h()).a(Boolean.valueOf(true), Boolean.valueOf(false));
        this.a.e.setOnClickListener(new adh(this));
        if (this.a.b.size() == 0) {
            this.a.e.setVisibility(0);
        } else {
            this.a.e.setVisibility(8);
        }
        this.a.c.setAdapter(this.a.d);
    }
}
