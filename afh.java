import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
import java.net.HttpURLConnection;
import java.net.URL;

public class afh extends AsyncTask {
    Context a;
    TextView b;
    zc c;

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((Integer) obj);
    }

    public afh(zc zcVar, TextView textView, Context context) {
        this.a = context;
        this.c = zcVar;
        this.b = textView;
    }

    protected Integer a(String... strArr) {
        return a(this.c.d());
    }

    protected void onPreExecute() {
        Log.i("Async-Example", "onPreExecute Called");
    }

    protected void a(Integer num) {
        if (!num.equals(Integer.valueOf(0))) {
            yz.a(num, this.c.c(), this.a);
            if (this.b != null) {
                this.b.setText(yt.a(num.intValue()));
                this.b.setVisibility(0);
            }
        }
    }

    public Integer a(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            yt.a(httpURLConnection);
            return Integer.valueOf(yt.a(httpURLConnection));
        } catch (Exception e) {
            return Integer.valueOf(0);
        }
    }
}
