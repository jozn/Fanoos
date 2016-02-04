import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import ir.seraj.fanoos.Activity.UserInfoActivity;

class yc implements OnClickListener {
    final /* synthetic */ zc a;
    final /* synthetic */ xv b;

    yc(xv xvVar, zc zcVar) {
        this.b = xvVar;
        this.a = zcVar;
    }

    public void onClick(View view) {
        Intent intent = new Intent(this.b.b, UserInfoActivity.class);
        intent.putExtra("MobileNumber", this.a.k());
        this.b.b.startActivity(intent);
    }
}
