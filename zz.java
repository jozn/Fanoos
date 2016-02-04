import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioGroup;
import android.widget.Toast;
import java.util.List;

class zz implements OnClickListener {
    final /* synthetic */ Context a;
    final /* synthetic */ List b;
    final /* synthetic */ RadioGroup c;
    final /* synthetic */ AlertDialog d;
    final /* synthetic */ zt e;

    zz(zt ztVar, Context context, List list, RadioGroup radioGroup, AlertDialog alertDialog) {
        this.e = ztVar;
        this.a = context;
        this.b = list;
        this.c = radioGroup;
        this.d = alertDialog;
    }

    public void onClick(View view) {
        new afq(this.a, (String) this.b.get(this.c.getCheckedRadioButtonId())).execute(new String[0]);
        this.d.dismiss();
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.putExtra("sms_body", "\u062f\u0639\u0648\u062a\u0646\u0627\u0645\u0647 \u0639\u0636\u0648\u06cc\u062a \u062f\u0631 \u0646\u0631\u0645 \u0627\u0641\u0632\u0627\u0631 \u067e\u06cc\u0627\u0645 \u0631\u0633\u0627\u0646 \u0641\u0627\u0646\u0648\u0633 \u060c http://fanoosapp.ir/app ");
        intent.putExtra("address", (String) this.b.get(0));
        intent.setType("vnd.android-dir/mms-sms");
        try {
            this.a.startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this.a, "\u062f\u0633\u062a\u06af\u0627\u0647 \u0634\u0645\u0627 \u0642\u0627\u0628\u0644\u06cc\u062a \u0627\u0631\u0633\u0627\u0644 \u067e\u06cc\u0627\u0645 \u06a9\u0648\u062a\u0627\u0647 \u0631\u0627 \u0646\u062f\u0627\u0631\u062f", 0).show();
        }
    }
}
