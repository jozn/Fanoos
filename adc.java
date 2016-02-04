import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import ir.seraj.fanoos.Fragment.GroupInfoFragment;
import java.io.File;

public class adc implements OnClickListener {
    final /* synthetic */ GroupInfoFragment a;

    public adc(GroupInfoFragment groupInfoFragment) {
        this.a = groupInfoFragment;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            this.a.ar = new Intent("android.media.action.IMAGE_CAPTURE");
            this.a.ar.putExtra("output", Uri.fromFile(new File(Environment.getExternalStorageDirectory() + File.separator + "image.jpg")));
            this.a.a(this.a.ar, 1888);
        } catch (Exception e) {
            aas aas = new aas();
            aas.a("ir.seraj.fanoos");
            aas.e(ys.a(this.a.h()));
            aas.d(zn.a());
            aas.c("openGallery");
            aas.b(e.getMessage());
            aas.a(Integer.valueOf(0));
            aas.a(this.a.h());
        }
    }
}
