import android.content.Context;
import android.os.AsyncTask;

public class afc extends AsyncTask {
    Context a;
    String b;

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((Integer) obj);
    }

    public afc(Context context, String str) {
        this.a = context;
        this.b = str;
    }

    protected Integer a(String... strArr) {
        zi.b(this.b, this.a);
        return Integer.valueOf(1);
    }

    protected void a(Integer num) {
    }
}
