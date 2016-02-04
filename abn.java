import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import ir.seraj.fanoos.Activity.GroupInfoActivity;
import ir.seraj.fanoos.Fragment.ConversationFragment;

public class abn implements OnClickListener {
    final /* synthetic */ ConversationFragment a;

    public abn(ConversationFragment conversationFragment) {
        this.a = conversationFragment;
    }

    public void onClick(View view) {
        if (yw.c(String.valueOf(this.a.ax), this.a.h()).f().equals(yw.m)) {
            Toast.makeText(this.a.h(), "\u0634\u0645\u0627 \u0639\u0636\u0648 \u0627\u06cc\u0646 \u06af\u0631\u0648\u0647 \u0646\u0645\u06cc \u0628\u0627\u0634\u06cc\u062f", 0).show();
            return;
        }
        Intent intent = new Intent(this.a.h(), GroupInfoActivity.class);
        intent.putExtra("GroupId", String.valueOf(this.a.ax));
        this.a.h().startActivity(intent);
    }
}
