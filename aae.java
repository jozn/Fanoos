import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import org.xmlpull.v1.XmlPullParser;

class aae implements OnClickListener {
    final /* synthetic */ String a;
    final /* synthetic */ Context b;
    final /* synthetic */ AlertDialog c;
    final /* synthetic */ zt d;

    aae(zt ztVar, String str, Context context, AlertDialog alertDialog) {
        this.d = ztVar;
        this.a = str;
        this.b = context;
        this.c = alertDialog;
    }

    public void onClick(View view) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(this.a));
            this.b.startActivity(intent);
            ys.a(this.b, XmlPullParser.NO_NAMESPACE, XmlPullParser.NO_NAMESPACE);
        } catch (Exception e) {
        }
        this.c.dismiss();
    }
}
