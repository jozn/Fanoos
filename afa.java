import android.content.Context;
import android.os.AsyncTask;
import org.xmlpull.v1.XmlPullParser;

public class afa extends AsyncTask {
    String a;
    Context b;
    Integer c;
    Integer d;

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((String[]) objArr);
    }

    public afa(Context context, Integer num) {
        this.b = context;
        this.a = aeq.o(context);
        this.c = num;
        this.d = aeq.b(context);
        aeq.b(context, num);
    }

    protected Integer a(String... strArr) {
        try {
            Thread.sleep(1000);
            if (this.c == aeq.b(this.b) && this.c != aeq.a(this.b)) {
                String str = XmlPullParser.NO_NAMESPACE;
                if (this.c.intValue() == 0) {
                    str = "\u0622\u0641\u0644\u0627\u06cc\u0646";
                } else {
                    str = "\u0622\u0646\u0644\u0627\u06cc\u0646";
                }
                aer.a(zj.h(this.a, str, this.b));
                aeq.a(this.b, this.c);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Integer.valueOf(1);
    }
}
