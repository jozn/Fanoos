import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import ir.seraj.fanoos.Fragment.AddGroupParticipantsFragment;

public class abj extends BroadcastReceiver {
    final /* synthetic */ AddGroupParticipantsFragment a;

    public abj(AddGroupParticipantsFragment addGroupParticipantsFragment) {
        this.a = addGroupParticipantsFragment;
    }

    public void onReceive(Context context, Intent intent) {
        this.a.j().c();
        this.a.j().c();
    }
}
