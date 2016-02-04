import android.view.View;
import android.view.View.OnClickListener;

class ya implements OnClickListener {
    final /* synthetic */ zc a;
    final /* synthetic */ yh b;
    final /* synthetic */ xv c;

    ya(xv xvVar, zc zcVar, yh yhVar) {
        this.c = xvVar;
        this.a = zcVar;
        this.b = yhVar;
    }

    public void onClick(View view) {
        yz.a(this.c.b, String.valueOf(this.a.c()), String.valueOf(this.a.g()));
        this.b.f.setVisibility(8);
        this.b.c.setVisibility(0);
    }
}
