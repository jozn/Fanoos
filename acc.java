import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import ir.seraj.fanoos.Activity.ConversationActivity;
import ir.seraj.fanoos.Fragment.ConversationFragment;
import org.xmlpull.v1.XmlPullParser;

public class acc extends BroadcastReceiver {
    final /* synthetic */ ConversationFragment a;

    public acc(ConversationFragment conversationFragment) {
        this.a = conversationFragment;
    }

    public void onReceive(Context context, Intent intent) {
        if (this.a.ay.intValue() == 0) {
            ((ConversationActivity) this.a.h()).a(this.a.b, intent.getStringExtra("ConversationEventStatus"), Boolean.valueOf(true));
        } else {
            ((ConversationActivity) this.a.h()).a(this.a.b, XmlPullParser.NO_NAMESPACE, Boolean.valueOf(false));
        }
    }
}
