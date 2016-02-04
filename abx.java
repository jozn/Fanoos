import android.view.View;
import android.view.View.OnClickListener;
import ir.seraj.fanoos.Fragment.ConversationFragment;

public class abx implements OnClickListener {
    final /* synthetic */ String[] a;
    final /* synthetic */ ConversationFragment b;

    public abx(ConversationFragment conversationFragment, String[] strArr) {
        this.b = conversationFragment;
        this.a = strArr;
    }

    public void onClick(View view) {
        this.b.a(4);
        this.b.ap = 74;
        this.b.h.setAdapter(new yq(this.b.h(), this.a, new Integer[]{Integer.valueOf(74), Integer.valueOf(97)}));
        this.b.h.setVisibility(0);
        this.b.i.setVisibility(4);
        this.b.a();
    }
}
