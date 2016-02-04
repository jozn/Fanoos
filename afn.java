import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import ir.seraj.fanoos.Activity.ChatsActivity;
import org.xmlpull.v1.XmlPullParser;

public class afn extends AsyncTask {
    static String b;
    static Boolean g;
    Context a;
    String c;
    String d;
    ProgressDialog e;
    Bitmap f;
    private afo h;

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((Integer) obj);
    }

    static {
        b = XmlPullParser.NO_NAMESPACE;
        g = Boolean.valueOf(false);
    }

    public static void a(String str) {
        b = str;
        g = Boolean.valueOf(true);
    }

    protected Integer a(String... strArr) {
        g = Boolean.valueOf(false);
        aer.a(zj.a(this.c, this.d, this.a));
        int i = 0;
        while (!g.booleanValue()) {
            try {
                Thread.sleep(1000);
                i += 1000;
                if (i > 20000) {
                    return Integer.valueOf(0);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (b.equals("1")) {
            return Integer.valueOf("1");
        }
        return Integer.valueOf(0);
    }

    public afn(Context context, String str, Bitmap bitmap, afo afo) {
        this.a = context;
        this.c = aeq.o(this.a);
        this.e = new ProgressDialog(context);
        this.d = str;
        this.f = bitmap;
        this.h = afo;
    }

    protected void onPreExecute() {
        this.e.setCancelable(false);
        this.e.setMessage("\u062f\u0631\u062d\u0627\u0644 \u062b\u0628\u062a \u0627\u0637\u0644\u0627\u0639\u0627\u062a");
        this.e.show();
    }

    protected void a(Integer num) {
        this.e.dismiss();
        if (num.intValue() == 0) {
            new zt().b(this.a);
        } else if (!ys.p(this.a).booleanValue()) {
            ys.o(this.a);
            this.a.startActivity(new Intent(this.a, ChatsActivity.class));
        } else if (this.h != null) {
            this.h.a(this.d);
        }
    }
}
