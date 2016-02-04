import android.view.View;
import android.view.View.OnClickListener;
import ir.seraj.fanoos.Fragment.ConversationFragment;

public class acb implements OnClickListener {
    final /* synthetic */ ConversationFragment a;

    public acb(ConversationFragment conversationFragment) {
        this.a = conversationFragment;
    }

    public void onClick(View view) {
        this.a.h().finish();
    }
}
