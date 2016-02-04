import android.view.View;
import android.view.View.OnClickListener;
import ir.seraj.fanoos.Fragment.ConversationFragment;

public class abu implements OnClickListener {
    final /* synthetic */ String[] a;
    final /* synthetic */ ConversationFragment b;

    public abu(ConversationFragment conversationFragment, String[] strArr) {
        this.b = conversationFragment;
        this.a = strArr;
    }

    public void onClick(View view) {
        this.b.a(3);
        this.b.ap = 11;
        this.b.h.setAdapter(new yq(this.b.h(), this.a, new Integer[]{Integer.valueOf(11), Integer.valueOf(23)}));
        this.b.h.setVisibility(0);
        this.b.i.setVisibility(4);
        r0.a();
    }
}
