import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

public class aey extends AsyncTask {
    static String c;
    static Boolean e;
    String a;
    Context b;
    ProgressDialog d;

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((Integer) obj);
    }

    static {
        e = Boolean.valueOf(false);
    }

    public static void a(String str) {
        c = str;
        e = Boolean.valueOf(true);
    }

    public aey(Context context) {
        this.b = context;
        this.a = aeq.o(context);
        this.d = new ProgressDialog(context);
    }

    protected Integer a(String... strArr) {
        String o = aeq.o(this.b);
        e = Boolean.valueOf(false);
        aer.a(zj.b(o, this.b));
        aer.b(this.b);
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
        if (c.equals("1")) {
            return Integer.valueOf(1);
        }
        return Integer.valueOf(0);
    }

    protected void onPreExecute() {
        this.d.setCancelable(false);
        this.d.setMessage("\u062f\u0631\u062d\u0627\u0644 \u0628\u0631\u0642\u0631\u0627\u0631\u06cc \u0627\u0631\u062a\u0628\u0627\u0637");
        this.d.show();
    }

    protected void a(Integer num) {
        this.d.dismiss();
        if (num.intValue() == 0) {
            new zt().b(this.b);
        }
    }
}
