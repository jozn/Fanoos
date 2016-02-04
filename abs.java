import android.view.View;
import android.view.View.OnClickListener;
import ir.seraj.fanoos.Fragment.ConversationFragment;

public class abs implements OnClickListener {
    final /* synthetic */ ConversationFragment a;

    public abs(ConversationFragment conversationFragment) {
        this.a = conversationFragment;
    }

    public void onClick(View view) {
        this.a.a(5);
        this.a.h.setVisibility(4);
        this.a.i.setVisibility(0);
        this.a.a();
    }
}
