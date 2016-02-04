import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import org.xmlpull.v1.XmlPullParser;

class aan implements OnClickListener {
    final /* synthetic */ EditText a;
    final /* synthetic */ String b;
    final /* synthetic */ Context c;
    final /* synthetic */ String d;
    final /* synthetic */ AlertDialog e;
    final /* synthetic */ zt f;

    aan(zt ztVar, EditText editText, String str, Context context, String str2, AlertDialog alertDialog) {
        this.f = ztVar;
        this.a = editText;
        this.b = str;
        this.c = context;
        this.d = str2;
        this.e = alertDialog;
    }

    public void onClick(View view) {
        String k = yz.k(this.a.getText().toString());
        if (!k.equals(this.b)) {
            new aez(this.c, k, XmlPullParser.NO_NAMESPACE, this.d).execute(new String[0]);
        }
        this.e.dismiss();
    }
}
