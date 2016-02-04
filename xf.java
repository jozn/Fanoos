import android.app.AlertDialog;
import android.content.Intent;
import android.provider.ContactsContract.Contacts;
import android.view.View;
import android.view.View.OnClickListener;
import ir.seraj.fanoos.Activity.SettingActivity;

public class xf implements OnClickListener {
    final /* synthetic */ AlertDialog a;
    final /* synthetic */ SettingActivity b;

    public xf(SettingActivity settingActivity, AlertDialog alertDialog) {
        this.b = settingActivity;
        this.a = alertDialog;
    }

    public void onClick(View view) {
        Intent intent = new Intent("android.intent.action.PICK", Contacts.CONTENT_URI);
        new Intent("android.intent.action.GET_CONTENT").setType("vnd.android.cursor.item/phone_v2");
        this.b.startActivityForResult(intent, 1889);
        this.a.dismiss();
    }
}
