import android.app.AlertDialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;
import ir.seraj.fanoos.Activity.SettingActivity;
import java.util.ArrayList;
import java.util.List;

public class wu implements OnClickListener {
    final /* synthetic */ EditText a;
    final /* synthetic */ AlertDialog b;
    final /* synthetic */ SettingActivity c;

    public wu(SettingActivity settingActivity, EditText editText, AlertDialog alertDialog) {
        this.c = settingActivity;
        this.a = editText;
        this.b = alertDialog;
    }

    public void onClick(View view) {
        String g = zg.g(this.a.getText().toString());
        if (zg.h(g).booleanValue()) {
            List arrayList = new ArrayList();
            arrayList.add(g);
            new zt().a(arrayList, view.getContext());
        } else {
            Toast.makeText(view.getContext(), "\u0634\u0645\u0627\u0631\u0647 \u0645\u0648\u0628\u0627\u06cc\u0644 \u0635\u062d\u06cc\u062d \u0646\u0645\u06cc \u0628\u0627\u0634\u062f", 0).show();
        }
        this.b.dismiss();
    }
}
