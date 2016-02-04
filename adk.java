import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import ir.seraj.fanoos.Activity.ConversationActivity;
import ir.seraj.fanoos.Fragment.RecentChatsFragment;

public class adk implements OnItemClickListener {
    final /* synthetic */ RecentChatsFragment a;

    public adk(RecentChatsFragment recentChatsFragment) {
        this.a = recentChatsFragment;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        Intent intent = new Intent(view.getContext(), ConversationActivity.class);
        if (((zd) this.a.a.get(i)).c().equals("1")) {
            intent.putExtra("MobileNumber", ((zd) this.a.a.get(i)).d());
            intent.putExtra("IsGroup", ((zd) this.a.a.get(i)).c());
        } else {
            intent.putExtra("MobileNumber", ((zd) this.a.a.get(i)).e());
            intent.putExtra("IsGroup", ((zd) this.a.a.get(i)).c());
        }
        this.a.a(intent);
    }
}
