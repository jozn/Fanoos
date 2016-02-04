import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import ir.seraj.fanoos.Activity.ProfileCreateActivity;
import java.io.File;

public class wq implements OnClickListener {
    final /* synthetic */ ProfileCreateActivity a;

    public wq(ProfileCreateActivity profileCreateActivity) {
        this.a = profileCreateActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            this.a.s = new Intent("android.media.action.IMAGE_CAPTURE");
            this.a.s.putExtra("output", Uri.fromFile(new File(Environment.getExternalStorageDirectory() + File.separator + "image.jpg")));
            this.a.startActivityForResult(this.a.s, 1888);
        } catch (Exception e) {
            aas aas = new aas();
            aas.a("ir.seraj.fanoos");
            aas.e(ys.a(this.a));
            aas.d(zn.a());
            aas.c("openGallery");
            aas.b(e.getMessage());
            aas.a(Integer.valueOf(0));
            aas.a(this.a);
        }
    }
}
