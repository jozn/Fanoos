import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import ir.seraj.fanoos.Activity.ChatsActivity;
import org.xmlpull.v1.XmlPullParser;

public class afj extends AsyncTask {
    static String b;
    static Boolean f;
    Context a;
    String c;
    String d;
    ProgressDialog e;

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((Integer) obj);
    }

    static {
        b = XmlPullParser.NO_NAMESPACE;
        f = Boolean.valueOf(false);
    }

    public afj(Context context, String str) {
        this.a = context;
        this.c = aeq.o(context);
        this.e = new ProgressDialog(context);
        this.d = str;
    }

    public static void a(String str) {
        b = str;
        f = Boolean.valueOf(true);
    }

    protected Integer a(String... strArr) {
        b = XmlPullParser.NO_NAMESPACE;
        f = Boolean.valueOf(false);
        aer.a(zj.d(this.c, this.d, this.a));
        int i = 0;
        while (!f.booleanValue()) {
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
            return Integer.valueOf(1);
        }
        return Integer.valueOf(0);
    }

    protected void onPreExecute() {
        this.e.setCancelable(false);
        this.e.setMessage("\u062f\u0631\u062d\u0627\u0644 \u062e\u0631\u0648\u062c \u0627\u0632 \u06af\u0631\u0648\u0647");
        this.e.show();
    }

    protected void a(Integer num) {
        this.e.dismiss();
        if (num.intValue() == 0) {
            new zt().b(this.a);
            return;
        }
        this.a.sendBroadcast(new Intent("ir.dayasoft.BroadCastUpdateGroupInfo"));
        yw.e(this.d, this.a);
        Intent intent = new Intent(this.a, ChatsActivity.class);
        intent.setFlags(67108864);
        this.a.startActivity(intent);
    }
}
