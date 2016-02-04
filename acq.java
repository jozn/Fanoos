import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import ir.seraj.fanoos.Fragment.CreateGroupFragment;

public class acq implements OnClickListener {
    final /* synthetic */ CreateGroupFragment a;

    public acq(CreateGroupFragment createGroupFragment) {
        this.a = createGroupFragment;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            this.a.d = new Intent("android.intent.action.GET_CONTENT", null);
            this.a.d.setType("image/*");
            this.a.d.putExtra("return-data", true);
            this.a.a(this.a.d, 112);
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
