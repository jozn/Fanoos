import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import ir.seraj.fanoos.Activity.SmsVerificationActivity;
import ir.seraj.fanoos.communication.IntentServiceGeneralCommand;

public class xj implements OnClickListener {
    final /* synthetic */ SmsVerificationActivity a;

    public xj(SmsVerificationActivity smsVerificationActivity) {
        this.a = smsVerificationActivity;
    }

    public void onClick(View view) {
        if (zm.a(this.a).booleanValue()) {
            Intent intent = new Intent(view.getContext(), IntentServiceGeneralCommand.class);
            intent.putExtra("receiverTag", this.a.p);
            intent.putExtra("CommandCode", 2);
            intent.putExtra("VerificationCode", this.a.n.getText().toString());
            this.a.startService(intent);
            return;
        }
        Toast.makeText(this.a, "\u0639\u062f\u0645 \u0627\u062a\u0635\u0627\u0644 \u0628\u0647 \u0627\u06cc\u0646\u062a\u0631\u0646\u062a", 1).show();
    }
}
