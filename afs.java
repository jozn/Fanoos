import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import java.util.Hashtable;
import java.util.List;

public class afs extends AsyncTask {
    static String c;
    static Boolean d;
    String a;
    Context b;

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((String[]) objArr);
    }

    static {
        d = Boolean.valueOf(false);
    }

    public static void a(String str) {
        c = str;
        d = Boolean.valueOf(true);
    }

    public afs(Context context) {
        this.b = context;
        this.a = aeq.o(context);
    }

    protected Integer a(String... strArr) {
        try {
            List<zg> a = yu.a(this.b);
            Hashtable hashtable = new Hashtable();
            for (zg zgVar : a) {
                hashtable.put(zgVar.d(), zgVar.h());
            }
            d = Boolean.valueOf(false);
            aer.a(zj.a(this.a, (List) a, this.b));
            int i = 0;
            do {
                if (d.booleanValue()) {
                    if (c.length() > 0) {
                        zg.a(this.b, zi.a(this.b, c, hashtable));
                    }
                    this.b.sendBroadcast(new Intent("ir.dayasoft.BroadCastSyncContact"));
                    return Integer.valueOf(1);
                }
                try {
                    Thread.sleep(1000);
                    i += 1000;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (i <= 20000);
            return Integer.valueOf(0);
        } catch (Exception e2) {
            aas aas = new aas();
            aas.a("ir.seraj.fanoos");
            aas.e(ys.a(this.b));
            aas.d(zn.a());
            aas.c("SyncContactImage");
            aas.b(e2.getMessage());
            aas.a(Integer.valueOf(0));
            aas.a(this.b);
        }
    }
}
