import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import ir.seraj.fanoos.Fragment.ConversationFragment;
import java.util.Collections;
import org.xmlpull.v1.XmlPullParser;

public class acl implements OnClickListener {
    final /* synthetic */ ConversationFragment a;

    public acl(ConversationFragment conversationFragment) {
        this.a = conversationFragment;
    }

    public void onClick(View view) {
        if (this.a.at.getText().length() != 0) {
            yz yzVar = new yz();
            yzVar.b(yz.k(this.a.at.getText().toString()));
            this.a.at.setText(XmlPullParser.NO_NAMESPACE);
            if (this.a.ay.intValue() == 1) {
                yz.c(this.a.h(), yzVar, String.valueOf(this.a.ax));
                this.a.az = zc.b(this.a.h(), this.a.ax, this.a.az.size() + 1);
            } else {
                yz.a(this.a.h(), yzVar, this.a.ax);
                this.a.az = zc.a(this.a.h(), this.a.ax, this.a.az.size() + 1);
            }
            Collections.reverse(this.a.az);
            this.a.aA.a(this.a.az);
            Log.i("adaptor", "3");
            this.a.aB.setAdapter(this.a.aA);
        }
    }
}
