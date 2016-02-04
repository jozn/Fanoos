import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import ir.seraj.fanoos.Activity.ConversationActivity;
import ir.seraj.fanoos.Fragment.ForwardRecentChatsFragment;

public class act implements OnItemClickListener {
    final /* synthetic */ ForwardRecentChatsFragment a;

    public act(ForwardRecentChatsFragment forwardRecentChatsFragment) {
        this.a = forwardRecentChatsFragment;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        Bundle bundle = new Bundle();
        Intent intent = new Intent(this.a.h(), ConversationActivity.class);
        if (this.a.g.equals("1")) {
            intent.putExtra("IsShare", this.a.g);
            intent.putExtra("ShareType", this.a.f);
            intent.putExtra("ShareFilePath", this.a.e);
        } else {
            intent.putExtra("MessageId", this.a.d);
        }
        if (((zd) this.a.a.get(i)).c().equals("1")) {
            intent.putExtra("MobileNumber", ((zd) this.a.a.get(i)).d());
            intent.putExtra("IsGroup", ((zd) this.a.a.get(i)).c());
            this.a.h().startActivity(intent);
            return;
        }
        intent.putExtra("MobileNumber", ((zd) this.a.a.get(i)).e());
        intent.putExtra("IsGroup", ((zd) this.a.a.get(i)).c());
        this.a.h().startActivity(intent);
    }
}
