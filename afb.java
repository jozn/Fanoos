import android.content.Context;
import android.os.AsyncTask;
import org.xmlpull.v1.XmlPullParser;

public class afb extends AsyncTask {
    static String b;
    static Boolean d;
    Context a;
    String c;

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((Integer) obj);
    }

    protected /* synthetic */ void onProgressUpdate(Object[] objArr) {
        a((Integer[]) objArr);
    }

    static {
        b = XmlPullParser.NO_NAMESPACE;
        d = Boolean.valueOf(false);
    }

    public static void a(String str) {
        b = str;
        d = Boolean.valueOf(true);
    }

    protected Integer a(String... strArr) {
        d = Boolean.valueOf(false);
        aer.a(zj.l(this.c, "22", this.a));
        int i = 0;
        while (!d.booleanValue()) {
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
        if (b.equals("-1")) {
            ys.a(this.a, XmlPullParser.NO_NAMESPACE, XmlPullParser.NO_NAMESPACE);
        } else {
            String[] split = b.split(zh.b);
            if (split.length == 2) {
                ys.a(this.a, split[1], split[0]);
            }
        }
        return Integer.valueOf(1);
    }

    public afb(Context context) {
        this.a = context;
        this.c = aeq.o(this.a);
    }

    protected void a(Integer num) {
    }

    protected void a(Integer... numArr) {
    }
}
