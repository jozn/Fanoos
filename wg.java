import android.os.Bundle;
import android.support.v4.app.Fragment;
import ir.seraj.fanoos.Activity.ForwardActivity;
import ir.seraj.fanoos.Fragment.ForwardNewConversationFragment;
import ir.seraj.fanoos.Fragment.ForwardRecentChatsFragment;

public class wg extends ac {
    final /* synthetic */ ForwardActivity a;

    public wg(ForwardActivity forwardActivity, s sVar) {
        this.a = forwardActivity;
        super(sVar);
    }

    public Fragment a(int i) {
        if (i == 0) {
            Fragment forwardRecentChatsFragment = new ForwardRecentChatsFragment();
            Bundle bundle = new Bundle();
            bundle.putString("MessageId", this.a.p);
            forwardRecentChatsFragment.g(bundle);
            return forwardRecentChatsFragment;
        }
        forwardRecentChatsFragment = new ForwardNewConversationFragment();
        bundle = new Bundle();
        bundle.putString("MessageId", this.a.p);
        forwardRecentChatsFragment.g(bundle);
        return forwardRecentChatsFragment;
    }

    public int b() {
        return 2;
    }
}
