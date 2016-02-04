import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.view.View.OnClickListener;

class zw implements OnClickListener {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;
    final /* synthetic */ AlertDialog c;
    final /* synthetic */ zt d;

    zw(zt ztVar, Context context, String str, AlertDialog alertDialog) {
        this.d = ztVar;
        this.a = context;
        this.b = str;
        this.c = alertDialog;
    }

    public void onClick(View view) {
        new afj(this.a, String.valueOf(this.b)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        this.c.dismiss();
    }
}
