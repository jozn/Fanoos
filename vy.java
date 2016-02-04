import android.view.View;
import android.view.View.OnClickListener;
import ir.seraj.fanoos.Activity.ChatsActivity;
import org.xmlpull.v1.XmlPullParser;

public class vy implements OnClickListener {
    final /* synthetic */ ChatsActivity a;

    public vy(ChatsActivity chatsActivity) {
        this.a = chatsActivity;
    }

    public void onClick(View view) {
        new aff(view.getContext(), XmlPullParser.NO_NAMESPACE, XmlPullParser.NO_NAMESPACE, XmlPullParser.NO_NAMESPACE).execute(new String[0]);
    }
}
