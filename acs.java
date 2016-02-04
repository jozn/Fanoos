import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import ir.seraj.fanoos.Activity.ConversationActivity;
import ir.seraj.fanoos.Fragment.ForwardNewConversationFragment;

public class acs implements OnItemClickListener {
    final /* synthetic */ ForwardNewConversationFragment a;

    public acs(ForwardNewConversationFragment forwardNewConversationFragment) {
        this.a = forwardNewConversationFragment;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        Intent intent = new Intent(this.a.h(), ConversationActivity.class);
        intent.putExtra("MobileNumber", ((zg) this.a.a.get(i)).d());
        intent.putExtra("IsGroup", "0");
        if (this.a.g.equals("1")) {
            intent.putExtra("IsShare", this.a.g);
            intent.putExtra("ShareType", this.a.f);
            intent.putExtra("ShareFilePath", this.a.e);
        } else {
            intent.putExtra("MessageId", this.a.d);
        }
        this.a.h().startActivity(intent);
    }
}
