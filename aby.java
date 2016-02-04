import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import ir.seraj.fanoos.Fragment.ConversationFragment;

public class aby implements OnItemClickListener {
    final /* synthetic */ String[] a;
    final /* synthetic */ ConversationFragment b;

    public aby(ConversationFragment conversationFragment, String[] strArr) {
        this.b = conversationFragment;
        this.a = strArr;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.b.aV.a(" " + this.a[i] + " ", ((Integer) this.b.aU.get(this.a[i])).intValue());
    }
}
