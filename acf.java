import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import ir.seraj.fanoos.Fragment.ConversationFragment;
import java.util.Collections;

public class acf implements OnClickListener {
    final /* synthetic */ ConversationFragment a;

    public acf(ConversationFragment conversationFragment) {
        this.a = conversationFragment;
    }

    public void onClick(View view) {
        int size = this.a.az.size();
        if (this.a.ay.intValue() == 1) {
            this.a.az = zc.b(this.a.h(), this.a.ax, this.a.az.size() + 50);
        } else {
            this.a.az = zc.a(this.a.h(), this.a.ax, this.a.az.size() + 50);
        }
        if (size != this.a.az.size()) {
            this.a.aB.getLastVisiblePosition();
            Collections.reverse(this.a.az);
            Log.i("adaptor", "1");
            this.a.aA = new xv(this.a.h(), this.a.az);
            this.a.aA.notifyDataSetChanged();
            this.a.aB.setAdapter(this.a.aA);
            this.a.aB.setSelection(this.a.az.size() - size);
            if (this.a.az.size() % 50 != 0) {
                view.setVisibility(4);
                return;
            }
            return;
        }
        view.setVisibility(4);
    }
}
