import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

class aah implements OnClickListener {
    final /* synthetic */ Context a;
    final /* synthetic */ AlertDialog b;
    final /* synthetic */ LinearLayout c;
    final /* synthetic */ zt d;

    aah(zt ztVar, Context context, AlertDialog alertDialog, LinearLayout linearLayout) {
        this.d = ztVar;
        this.a = context;
        this.b = alertDialog;
        this.c = linearLayout;
    }

    public void onClick(View view) {
        new aey(this.a).execute(new String[0]);
        this.b.dismiss();
        this.c.setVisibility(8);
    }
}
