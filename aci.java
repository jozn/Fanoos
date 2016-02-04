import android.view.View;
import android.view.View.OnClickListener;
import ir.seraj.fanoos.Fragment.ConversationFragment;
import ir.seraj.fanoos3.R;

public class aci implements OnClickListener {
    final /* synthetic */ ConversationFragment a;

    public aci(ConversationFragment conversationFragment) {
        this.a = conversationFragment;
    }

    public void onClick(View view) {
        this.a.aB.post(new acj(this));
        if (this.a.au.intValue() == 0) {
            this.a.a();
            this.a.av.setVisibility(0);
            this.a.d.setVisibility(0);
            this.a.aL.setVisibility(8);
            this.a.aq.setImageResource(R.drawable.ic_remove_media);
            this.a.au = Integer.valueOf(1);
        } else if (this.a.au.intValue() == 1) {
            this.a.a();
            this.a.av.setVisibility(8);
            this.a.d.setVisibility(8);
            this.a.g.setVisibility(8);
            this.a.aL.setVisibility(8);
            this.a.au = Integer.valueOf(0);
            this.a.aq.setImageResource(R.drawable.ic_add_media);
        } else if (this.a.au.intValue() == 2) {
            this.a.a();
            this.a.d.setVisibility(0);
            this.a.g.setVisibility(8);
            this.a.aL.setVisibility(8);
            this.a.aq.setImageResource(R.drawable.ic_remove_media);
            this.a.ar.setImageResource(R.drawable.ic_action_sticky);
            this.a.au = Integer.valueOf(1);
        } else if (this.a.au.intValue() == 3) {
            this.a.aL.setVisibility(8);
            this.a.av.setVisibility(8);
            this.a.d.setVisibility(8);
            this.a.g.setVisibility(8);
            this.a.aL.setVisibility(8);
            this.a.au = Integer.valueOf(0);
            this.a.aq.setImageResource(R.drawable.ic_add_media);
        }
    }
}
