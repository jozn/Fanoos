import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;
import org.xmlpull.v1.XmlPullParser;

public class afq extends AsyncTask {
    static String b;
    static Boolean e;
    Context a;
    String c;
    String d;

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((Integer) obj);
    }

    static {
        b = XmlPullParser.NO_NAMESPACE;
        e = Boolean.valueOf(false);
    }

    public static void a(String str) {
        b = str;
        e = Boolean.valueOf(true);
    }

    public afq(Context context, String str) {
        this.a = context;
        this.c = aeq.o(context);
        this.d = str;
    }

    protected Integer a(String... strArr) {
        e = Boolean.valueOf(false);
        aer.a(zj.e(this.c, this.d, this.a));
        int i = 0;
        while (!e.booleanValue()) {
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
    }

    protected void a(Integer num) {
        if (num.intValue() != 1) {
            Toast.makeText(this.a, "\u062e\u0637\u0627 \u062f\u0631 \u0627\u0631\u0633\u0627\u0644 \u062f\u0639\u0648\u062a \u0646\u0627\u0645\u0647", 1).show();
        }
    }
}
