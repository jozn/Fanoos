import android.view.View;
import android.view.View.OnClickListener;
import ir.seraj.fanoos.Fragment.ConversationFragment;

public class abv implements OnClickListener {
    final /* synthetic */ String[] a;
    final /* synthetic */ ConversationFragment b;

    public abv(ConversationFragment conversationFragment, String[] strArr) {
        this.b = conversationFragment;
        this.a = strArr;
    }

    public void onClick(View view) {
        this.b.a(1);
        this.b.ap = 24;
        this.b.h.setAdapter(new yq(this.b.h(), this.a, new Integer[]{Integer.valueOf(24), Integer.valueOf(36), Integer.valueOf(63), Integer.valueOf(73)}));
        this.b.h.setVisibility(0);
        this.b.i.setVisibility(4);
        this.b.a();
    }
}
