import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.Toast;
import ir.seraj.fanoos.Activity.SmsVerificationActivity;

public class xk implements OnClickListener {
    final /* synthetic */ SmsVerificationActivity a;

    public xk(SmsVerificationActivity smsVerificationActivity) {
        this.a = smsVerificationActivity;
    }

    public void onClick(View view) {
        if (zm.a(this.a).booleanValue()) {
            new zt().a((LinearLayout) view, view.getContext());
        } else {
            Toast.makeText(this.a, "\u0639\u062f\u0645 \u0627\u062a\u0635\u0627\u0644 \u0628\u0647 \u0627\u06cc\u0646\u062a\u0631\u0646\u062a", 1).show();
        }
    }
}
