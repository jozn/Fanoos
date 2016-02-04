import android.view.View;
import android.view.View.OnClickListener;
import ir.seraj.fanoos.Fragment.ConversationFragment;

public class abt implements OnClickListener {
    final /* synthetic */ String[] a;
    final /* synthetic */ ConversationFragment b;

    public abt(ConversationFragment conversationFragment, String[] strArr) {
        this.b = conversationFragment;
        this.a = strArr;
    }

    public void onClick(View view) {
        this.b.a(3);
        this.b.ap = 0;
        this.b.h.setAdapter(new yq(this.b.h(), this.a, new Integer[]{Integer.valueOf(0), Integer.valueOf(11)}));
        this.b.h.setVisibility(0);
        this.b.i.setVisibility(4);
        this.b.a();
    }
}
