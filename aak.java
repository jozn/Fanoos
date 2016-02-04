import android.app.AlertDialog;
import android.view.View;
import android.view.View.OnClickListener;

class aak implements OnClickListener {
    final /* synthetic */ AlertDialog a;
    final /* synthetic */ zt b;

    aak(zt ztVar, AlertDialog alertDialog) {
        this.b = ztVar;
        this.a = alertDialog;
    }

    public void onClick(View view) {
        this.a.dismiss();
    }
}
