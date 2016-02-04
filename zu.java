import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import ir.seraj.fanoos.communication.IntentServiceGeneralCommand;
import ir.seraj.fanoos.communication.MyResultReceiver;

class zu implements OnClickListener {
    final /* synthetic */ Context a;
    final /* synthetic */ MyResultReceiver b;
    final /* synthetic */ AlertDialog c;
    final /* synthetic */ zt d;

    zu(zt ztVar, Context context, MyResultReceiver myResultReceiver, AlertDialog alertDialog) {
        this.d = ztVar;
        this.a = context;
        this.b = myResultReceiver;
        this.c = alertDialog;
    }

    public void onClick(View view) {
        Intent intent = new Intent(this.a, IntentServiceGeneralCommand.class);
        intent.putExtra("receiverTag", this.b);
        intent.putExtra("CommandCode", 1);
        this.a.startService(intent);
        this.c.dismiss();
    }
}
