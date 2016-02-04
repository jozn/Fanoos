import android.os.AsyncTask;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

class xy implements OnClickListener {
    final /* synthetic */ zc a;
    final /* synthetic */ int b;
    final /* synthetic */ yh c;
    final /* synthetic */ xv d;

    xy(xv xvVar, zc zcVar, int i, yh yhVar) {
        this.d = xvVar;
        this.a = zcVar;
        this.b = i;
        this.c = yhVar;
    }

    public void onClick(View view) {
        if (yz.g(this.a.d()).booleanValue()) {
            try {
                if (this.d.i != null) {
                    this.d.i.a();
                }
                if (this.b != this.d.c.intValue()) {
                    this.d.c = Integer.valueOf(this.b);
                    this.d.i = new afl(this.d.b, yz.j(this.a.d()), this.c.e, this.c.o);
                    this.d.i.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                    return;
                }
                this.d.c = Integer.valueOf(-1);
                return;
            } catch (Exception e) {
                Toast.makeText(this.d.b, "\u0639\u062f\u0645 \u067e\u0634\u062a\u06cc\u0628\u0627\u0646\u06cc \u0627\u0632 \u0641\u0631\u0645\u062a \u0641\u0627\u06cc\u0644", 1).show();
                return;
            }
        }
        new aev(this.c.c, this.c.k, this.a.d(), this.c.e, this.d.b).execute(new String[0]);
    }
}
