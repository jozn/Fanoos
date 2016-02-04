import android.app.AlertDialog;
import android.view.View;
import android.view.View.OnClickListener;

class aaj implements OnClickListener {
    final /* synthetic */ AlertDialog a;
    final /* synthetic */ zt b;

    aaj(zt ztVar, AlertDialog alertDialog) {
        this.b = ztVar;
        this.a = alertDialog;
    }

    public void onClick(View view) {
        this.a.dismiss();
    }
}
