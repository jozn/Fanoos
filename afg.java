import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

public class afg extends AsyncTask {
    String a;
    yz b;
    ze c;
    Context d;

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((String[]) objArr);
    }

    public afg(yz yzVar, ze zeVar, Context context) {
        this.d = context;
        this.a = aeq.o(context);
        this.b = yzVar;
        this.c = zeVar;
        Log.i("startnavid1", zn.a());
    }

    protected Integer a(String... strArr) {
        aer.a(zj.b(aeq.o(this.d), this.b, this.c, this.d));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Integer.valueOf(1);
    }
}
