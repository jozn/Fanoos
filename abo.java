import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import ir.seraj.fanoos.Fragment.ConversationFragment;
import ir.seraj.fanoos3.R;
import java.io.File;

public class abo implements OnTouchListener {
    final /* synthetic */ ConversationFragment a;

    public abo(ConversationFragment conversationFragment) {
        this.a = conversationFragment;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (!this.a.aI.booleanValue()) {
                this.a.aK = zk.e + File.separator + yz.i();
                this.a.aH = Boolean.valueOf(true);
                this.a.aG = new aes(this.a.aK, 1000);
                this.a.aI = Boolean.valueOf(true);
                this.a.aG.a(true);
                this.a.aN.setVisibility(0);
                this.a.aM.setImageResource(R.drawable.ic_action_hold_record);
                new abp(this).start();
            }
            return true;
        }
        if (1 == motionEvent.getAction()) {
            this.a.aH = Boolean.valueOf(false);
        }
        return true;
    }
}
