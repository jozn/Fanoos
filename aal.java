import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import ir.seraj.fanoos.communication.IntentServiceGeneralCommand;
import ir.seraj.fanoos.communication.MyResultReceiver;

class aal implements OnClickListener {
    final /* synthetic */ Context a;
    final /* synthetic */ MyResultReceiver b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ AlertDialog e;
    final /* synthetic */ zt f;

    aal(zt ztVar, Context context, MyResultReceiver myResultReceiver, String str, String str2, AlertDialog alertDialog) {
        this.f = ztVar;
        this.a = context;
        this.b = myResultReceiver;
        this.c = str;
        this.d = str2;
        this.e = alertDialog;
    }

    public void onClick(View view) {
        Intent intent = new Intent(this.a, IntentServiceGeneralCommand.class);
        intent.putExtra("receiverTag", this.b);
        intent.putExtra("CommandCode", 7);
        intent.putExtra("GroupId", this.c);
        intent.putExtra("Participants", this.d);
        intent.putExtra("IsRemove", false);
        this.a.startService(intent);
        this.e.dismiss();
    }
}
