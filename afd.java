import android.content.Context;
import android.os.AsyncTask;

public class afd extends AsyncTask {
    String a;
    Context b;
    String c;
    Integer d;

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((String[]) objArr);
    }

    public afd(Context context, String str, Integer num) {
        this.b = context;
        this.a = aeq.o(context);
        this.c = str;
        this.d = num;
    }

    protected Integer a(String... strArr) {
        if (this.d.intValue() == 0) {
            aer.a(zj.g(this.a, this.c, this.b));
        } else {
            aer.a(zj.f(this.a, this.c, this.b));
        }
        return Integer.valueOf(1);
    }
}
