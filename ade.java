import android.content.Intent;
import android.provider.ContactsContract.Contacts;
import android.view.View;
import android.view.View.OnClickListener;
import ir.seraj.fanoos.Fragment.NewConversationFragment;

public class ade implements OnClickListener {
    final /* synthetic */ NewConversationFragment a;

    public ade(NewConversationFragment newConversationFragment) {
        this.a = newConversationFragment;
    }

    public void onClick(View view) {
        Intent intent = new Intent("android.intent.action.PICK", Contacts.CONTENT_URI);
        new Intent("android.intent.action.GET_CONTENT").setType("vnd.android.cursor.item/phone_v2");
        this.a.a(intent, 1888);
    }
}
