import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import ir.seraj.fanoos.Activity.ProfileCreateActivity;

public class wp implements OnClickListener {
    final /* synthetic */ ProfileCreateActivity a;

    public wp(ProfileCreateActivity profileCreateActivity) {
        this.a = profileCreateActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            this.a.s = new Intent("android.intent.action.GET_CONTENT", null);
            this.a.s.setType("image/*");
            this.a.s.putExtra("return-data", true);
            this.a.startActivityForResult(this.a.s, 112);
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
