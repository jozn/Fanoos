import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import ir.seraj.fanoos.Activity.EnterPhoneNumberActivity;
import ir.seraj.fanoos.communication.IntentServiceGeneralCommand;

public class wd implements OnClickListener {
    final /* synthetic */ EnterPhoneNumberActivity a;

    public wd(EnterPhoneNumberActivity enterPhoneNumberActivity) {
        this.a = enterPhoneNumberActivity;
    }

    public void onClick(View view) {
        if (zm.a(this.a).booleanValue()) {
            String g = zg.g(this.a.n.getText().toString());
            if (zg.h(g).booleanValue() && ((g.length() == 11 && g.startsWith("09")) || ((g.length() == 12 && g.startsWith("989")) || (g.length() == 13 && g.startsWith("+989"))))) {
                aeq.f(this.a, g);
                Intent intent = new Intent(view.getContext(), IntentServiceGeneralCommand.class);
                intent.putExtra("receiverTag", this.a.o);
                intent.putExtra("CommandCode", 0);
                this.a.startService(intent);
                return;
            }
            Toast.makeText(this.a, "\u0634\u0645\u0627\u0631\u0647 \u0645\u0648\u0628\u0627\u06cc\u0644 \u0648\u0627\u0631\u062f \u0634\u062f\u0647 \u0646\u0627\u0645\u0639\u062a\u0628\u0631 \u0645\u06cc \u0628\u0627\u0634\u062f", 0).show();
            return;
        }
        Toast.makeText(this.a, "\u0639\u062f\u0645 \u0627\u062a\u0635\u0627\u0644 \u0628\u0647 \u0627\u06cc\u0646\u062a\u0631\u0646\u062a", 1).show();
    }
}
