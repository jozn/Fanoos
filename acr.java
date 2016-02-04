import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import ir.seraj.fanoos.Fragment.CreateGroupFragment;
import java.io.File;

public class acr implements OnClickListener {
    final /* synthetic */ CreateGroupFragment a;

    public acr(CreateGroupFragment createGroupFragment) {
        this.a = createGroupFragment;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            this.a.d = new Intent("android.media.action.IMAGE_CAPTURE");
            this.a.d.putExtra("output", Uri.fromFile(new File(Environment.getExternalStorageDirectory() + File.separator + "image.jpg")));
            this.a.a(this.a.d, 1888);
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
