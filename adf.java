import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import ir.seraj.fanoos.Activity.ConversationActivity;
import ir.seraj.fanoos.Fragment.NewConversationFragment;

public class adf implements OnItemClickListener {
    final /* synthetic */ NewConversationFragment a;

    public adf(NewConversationFragment newConversationFragment) {
        this.a = newConversationFragment;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        Intent intent = new Intent(view.getContext(), ConversationActivity.class);
        intent.putExtra("MobileNumber", ((zg) this.a.b.get(i)).d());
        intent.putExtra("IsGroup", "0");
        this.a.a(intent);
    }
}
