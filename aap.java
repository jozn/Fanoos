import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

class aap implements OnClickListener {
    final /* synthetic */ EditText a;
    final /* synthetic */ String b;
    final /* synthetic */ Context c;
    final /* synthetic */ afo d;
    final /* synthetic */ AlertDialog e;
    final /* synthetic */ zt f;

    aap(zt ztVar, EditText editText, String str, Context context, afo afo, AlertDialog alertDialog) {
        this.f = ztVar;
        this.a = editText;
        this.b = str;
        this.c = context;
        this.d = afo;
        this.e = alertDialog;
    }

    public void onClick(View view) {
        String k = yz.k(this.a.getText().toString());
        if (!k.equals(this.b)) {
            new afn(this.c, k, null, this.d).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        }
        this.e.dismiss();
    }
}
