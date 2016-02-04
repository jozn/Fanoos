import android.os.AsyncTask;
import android.view.View;
import android.view.View.OnClickListener;

class yf implements OnClickListener {
    final /* synthetic */ zc a;
    final /* synthetic */ int b;
    final /* synthetic */ yh c;
    final /* synthetic */ xv d;

    yf(xv xvVar, zc zcVar, int i, yh yhVar) {
        this.d = xvVar;
        this.a = zcVar;
        this.b = i;
        this.c = yhVar;
    }

    public void onClick(View view) {
        if (zp.a(this.a.d()).booleanValue()) {
            if (this.d.i != null) {
                this.d.i.a();
            }
            if (this.b != this.d.c.intValue()) {
                this.d.c = Integer.valueOf(this.b);
                this.d.i = new afl(this.d.b, this.a.d(), this.c.e, this.c.o);
                this.d.i.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                return;
            }
            this.d.c = Integer.valueOf(-1);
        }
    }
}
