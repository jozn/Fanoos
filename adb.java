import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import ir.seraj.fanoos.Fragment.GroupInfoFragment;

public class adb implements OnClickListener {
    final /* synthetic */ GroupInfoFragment a;

    public adb(GroupInfoFragment groupInfoFragment) {
        this.a = groupInfoFragment;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            this.a.ar = new Intent("android.intent.action.GET_CONTENT", null);
            this.a.ar.setType("image/*");
            this.a.ar.putExtra("return-data", true);
            this.a.a(this.a.ar, 112);
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
