import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import ir.seraj.fanoos.Activity.ImageViewerActivity;

class yd implements OnClickListener {
    final /* synthetic */ zc a;
    final /* synthetic */ xv b;

    yd(xv xvVar, zc zcVar) {
        this.b = xvVar;
        this.a = zcVar;
    }

    public void onClick(View view) {
        Intent intent = new Intent(this.b.b, ImageViewerActivity.class);
        intent.putExtra("image", this.a.d());
        this.b.b.startActivity(intent);
    }
}
