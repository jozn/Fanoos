import android.view.View;
import android.view.View.OnClickListener;
import ir.seraj.fanoos.Activity.ChatsActivity;
import ir.seraj.fanoos.Fragment.NewConversationFragment;
import org.xmlpull.v1.XmlPullParser;

public class add implements OnClickListener {
    final /* synthetic */ NewConversationFragment a;

    public add(NewConversationFragment newConversationFragment) {
        this.a = newConversationFragment;
    }

    public void onClick(View view) {
        this.a.aj = XmlPullParser.NO_NAMESPACE;
        this.a.i.setText(XmlPullParser.NO_NAMESPACE);
        this.a.b = zg.b(this.a.h(), this.a.aj);
        this.a.d.a(this.a.b);
        this.a.c.setAdapter(this.a.d);
        this.a.f.setVisibility(8);
        ((ChatsActivity) this.a.h()).a(Boolean.valueOf(false));
    }
}
