import android.view.View;
import android.view.View.OnFocusChangeListener;
import ir.seraj.fanoos.Fragment.ConversationFragment;
import ir.seraj.fanoos3.R;

public class ach implements OnFocusChangeListener {
    final /* synthetic */ ConversationFragment a;

    public ach(ConversationFragment conversationFragment) {
        this.a = conversationFragment;
    }

    public void onFocusChange(View view, boolean z) {
        if (z) {
            this.a.av.setVisibility(8);
            this.a.aq.setImageResource(R.drawable.ic_add_media);
        }
    }
}
