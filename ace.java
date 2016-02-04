import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.util.Log;
import ir.seraj.fanoos.Fragment.ConversationFragment;
import java.util.Collections;

public class ace implements OnClickListener {
    final /* synthetic */ ConversationFragment a;

    public ace(ConversationFragment conversationFragment) {
        this.a = conversationFragment;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.a.aT.b(this.a.f);
        if (this.a.ay.intValue() == 1) {
            yz.b(this.a.h(), this.a.aT, this.a.f, String.valueOf(this.a.ax));
            this.a.az = zc.b(this.a.h(), this.a.ax, this.a.az.size() + 50);
        } else {
            yz.a(this.a.h(), this.a.aT, this.a.f, this.a.ax);
            this.a.az = zc.a(this.a.h(), this.a.ax, this.a.az.size() + 50);
        }
        Collections.reverse(this.a.az);
        this.a.aA.a(this.a.az);
        Log.i("adaptor", "10");
        this.a.aB.setAdapter(this.a.aA);
    }
}
