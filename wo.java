import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;
import ir.seraj.fanoos.Activity.ProfileCreateActivity;
import ir.seraj.fanoos.communication.IntentServiceGeneralCommand;

public class wo implements OnClickListener {
    final /* synthetic */ EditText a;
    final /* synthetic */ ProfileCreateActivity b;

    public wo(ProfileCreateActivity profileCreateActivity, EditText editText) {
        this.b = profileCreateActivity;
        this.a = editText;
    }

    public void onClick(View view) {
        String k = yz.k(this.a.getText().toString());
        if (k.length() > 0) {
            Intent intent = new Intent(view.getContext(), IntentServiceGeneralCommand.class);
            intent.putExtra("receiverTag", this.b.q);
            intent.putExtra("CommandCode", 4);
            intent.putExtra("nickName", k);
            this.b.startService(intent);
            return;
        }
        Toast.makeText(view.getContext(), "\u0646\u0627\u0645 \u062e\u0648\u062f \u0631\u0627 \u0648\u0627\u0631\u062f \u06a9\u0646\u06cc\u062f", 0).show();
    }
}
