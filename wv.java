import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import ir.seraj.fanoos.Activity.SettingActivity;

public class wv implements OnClickListener {
    final /* synthetic */ SettingActivity a;

    public wv(SettingActivity settingActivity) {
        this.a = settingActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            this.a.y = new Intent("android.intent.action.GET_CONTENT", null);
            this.a.y.setType("image/*");
            this.a.y.putExtra("return-data", true);
            this.a.startActivityForResult(this.a.y, 112);
        } catch (Exception e) {
            aas aas = new aas();
            aas.a("ir.seraj.fanoos");
            aas.e(ys.a(this.a.getBaseContext()));
            aas.d(zn.a());
            aas.c("openGallery");
            aas.b(e.getMessage());
            aas.a(Integer.valueOf(0));
            aas.a(this.a.getBaseContext());
        }
    }
}
