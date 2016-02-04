import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import ir.seraj.fanoos.Fragment.ConversationFragment;
import ir.seraj.fanoos3.R;
import java.util.Collections;

public class abz implements OnItemClickListener {
    final /* synthetic */ ConversationFragment a;

    public abz(ConversationFragment conversationFragment) {
        this.a = conversationFragment;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        yz yzVar = new yz();
        yzVar.b(String.valueOf(zf.a((this.a.ap + i) + 1)));
        if (this.a.ay.intValue() == 1) {
            yz.f(this.a.h(), yzVar, String.valueOf(this.a.ax));
            this.a.az = zc.b(this.a.h(), this.a.ax, this.a.az.size() + 50);
            Collections.reverse(this.a.az);
        } else {
            yz.b(this.a.h(), yzVar, this.a.ax);
            this.a.az = zc.a(this.a.h(), this.a.ax, this.a.az.size() + 50);
            Collections.reverse(this.a.az);
        }
        this.a.a();
        this.a.av.setVisibility(8);
        this.a.d.setVisibility(8);
        this.a.g.setVisibility(8);
        this.a.aL.setVisibility(8);
        this.a.aq.setImageResource(R.drawable.ic_add_media);
        this.a.ar.setImageResource(R.drawable.ic_action_sticky);
        this.a.au = Integer.valueOf(0);
        this.a.aA.a(this.a.az);
        Log.i("adaptor", "5");
        this.a.aB.setAdapter(this.a.aA);
    }
}
