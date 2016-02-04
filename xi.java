import android.os.Bundle;
import android.support.v4.app.Fragment;
import ir.seraj.fanoos.Activity.ShareActivity;
import ir.seraj.fanoos.Fragment.ForwardNewConversationFragment;
import ir.seraj.fanoos.Fragment.ForwardRecentChatsFragment;

public class xi extends ac {
    final /* synthetic */ ShareActivity a;

    public xi(ShareActivity shareActivity, s sVar) {
        this.a = shareActivity;
        super(sVar);
    }

    public Fragment a(int i) {
        if (i == 0) {
            Fragment forwardRecentChatsFragment = new ForwardRecentChatsFragment();
            Bundle bundle = new Bundle();
            bundle.putString("ShareFilePath", this.a.q);
            bundle.putString("ShareType", String.valueOf(this.a.r));
            bundle.putString("IsShare", "1");
            forwardRecentChatsFragment.g(bundle);
            return forwardRecentChatsFragment;
        }
        forwardRecentChatsFragment = new ForwardNewConversationFragment();
        bundle = new Bundle();
        bundle.putString("ShareFilePath", this.a.q);
        bundle.putString("ShareType", String.valueOf(this.a.r));
        bundle.putString("IsShare", "1");
        forwardRecentChatsFragment.g(bundle);
        return forwardRecentChatsFragment;
    }

    public int b() {
        return 2;
    }
}
