import android.text.Editable;
import android.text.TextWatcher;
import ir.seraj.fanoos.Activity.ChatsActivity;

public class wb implements TextWatcher {
    final /* synthetic */ ChatsActivity a;

    public wb(ChatsActivity chatsActivity) {
        this.a = chatsActivity;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.a.n.a(charSequence.toString());
    }

    public void afterTextChanged(Editable editable) {
    }
}
