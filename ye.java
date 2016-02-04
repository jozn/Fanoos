import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;

class ye implements OnClickListener {
    final /* synthetic */ zc a;
    final /* synthetic */ xv b;

    ye(xv xvVar, zc zcVar) {
        this.b = xvVar;
        this.a = zcVar;
    }

    public void onClick(View view) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.a.d()));
        intent.setDataAndType(Uri.parse(this.a.d()), "video/mp4");
        this.b.b.startActivity(intent);
    }
}
