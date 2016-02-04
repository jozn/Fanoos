import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import ir.seraj.fanoos.Activity.SettingActivity;
import java.io.File;

public class ww implements OnClickListener {
    final /* synthetic */ SettingActivity a;

    public ww(SettingActivity settingActivity) {
        this.a = settingActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            this.a.y = new Intent("android.media.action.IMAGE_CAPTURE");
            this.a.y.putExtra("output", Uri.fromFile(new File(Environment.getExternalStorageDirectory() + File.separator + "image.jpg")));
            this.a.startActivityForResult(this.a.y, 1888);
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
