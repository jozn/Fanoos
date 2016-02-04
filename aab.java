import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class aab implements OnClickListener {
    final /* synthetic */ String a;
    final /* synthetic */ Context b;
    final /* synthetic */ String c;
    final /* synthetic */ AlertDialog d;
    final /* synthetic */ zt e;

    aab(zt ztVar, String str, Context context, String str2, AlertDialog alertDialog) {
        this.e = ztVar;
        this.a = str;
        this.b = context;
        this.c = str2;
        this.d = alertDialog;
    }

    public void onClick(View view) {
        aav aav;
        if (this.a.equals("0")) {
            aav = new aav(this.b);
            aav.a();
            aav.e(this.c);
            aav.b();
            this.b.sendBroadcast(new Intent("ir.dayasoft.BroadCastGetNewMessage"));
        } else {
            aav = new aav(this.b);
            aav.a();
            aav.f(this.c);
            aav.b();
            this.b.sendBroadcast(new Intent("ir.dayasoft.BroadCastGetNewMessage"));
        }
        this.d.dismiss();
    }
}
