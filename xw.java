import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import ir.seraj.fanoos.Activity.ImageViewerActivity;

class xw implements OnClickListener {
    final /* synthetic */ zc a;
    final /* synthetic */ yh b;
    final /* synthetic */ xv c;

    xw(xv xvVar, zc zcVar, yh yhVar) {
        this.c = xvVar;
        this.a = zcVar;
        this.b = yhVar;
    }

    public void onClick(View view) {
        if (yz.f(this.a.d()).booleanValue()) {
            try {
                Intent intent = new Intent(this.c.b, ImageViewerActivity.class);
                intent.putExtra("image", yz.h(this.a.d()));
                this.c.b.startActivity(intent);
                return;
            } catch (Exception e) {
                Toast.makeText(this.c.b, "\u0639\u062f\u0645 \u067e\u0634\u062a\u06cc\u0628\u0627\u0646\u06cc \u0627\u0632 \u0641\u0631\u0645\u062a \u0641\u0627\u06cc\u0644", 1).show();
                return;
            }
        }
        new afi(this.b.c, this.b.k, this.a.d(), this.b.b, this.b.p, this.c.b).execute(new String[0]);
    }
}
