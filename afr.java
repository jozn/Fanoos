import android.content.Context;
import android.os.AsyncTask;

public class afr extends AsyncTask {
    static Context d;
    static Boolean e;
    String a;
    yz b;
    ze c;

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((String[]) objArr);
    }

    static {
        e = Boolean.valueOf(false);
    }

    public afr(yz yzVar, ze zeVar, Context context) {
        d = context;
        this.a = aeq.o(context);
        this.b = yzVar;
        this.c = zeVar;
    }

    protected Integer a(String... strArr) {
        String o = aeq.o(d);
        e = Boolean.valueOf(false);
        aer.a(zj.a(o, this.b, this.c, d));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ze.c(d, String.valueOf(this.c.a()));
        return Integer.valueOf(1);
    }
}
