import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ProgressBar;
import ir.seraj.fanoos3.R;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import org.xmlpull.v1.XmlPullParser;

public class aev extends AsyncTask {
    ProgressBar a;
    Context b;
    String c;
    ProgressBar d;
    String e;
    private final WeakReference f;

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((Integer) obj);
    }

    protected /* synthetic */ void onProgressUpdate(Object[] objArr) {
        a((Integer[]) objArr);
    }

    public aev(ProgressBar progressBar, ProgressBar progressBar2, String str, ImageView imageView, Context context) {
        this.e = XmlPullParser.NO_NAMESPACE;
        this.b = context;
        this.a = progressBar;
        this.e = str;
        this.c = str.substring(str.lastIndexOf("/") + 1);
        this.f = new WeakReference(imageView);
        this.d = progressBar2;
    }

    protected Integer a(String... strArr) {
        return a(this.e, this.c);
    }

    protected void onPreExecute() {
        Log.i("Async-Example", "onPreExecute Called");
        this.d.setVisibility(0);
    }

    protected void a(Integer num) {
        Log.i("Async-Example", "onPostExecute Called");
        this.d.setVisibility(4);
        if (!num.equals(Integer.valueOf(0)) && this.f != null) {
            ImageView imageView = (ImageView) this.f.get();
            if (imageView != null) {
                imageView.setImageResource(R.drawable.audio_play);
            }
        }
    }

    public Integer a(String str, String str2) {
        try {
            File file = new File(zk.e);
            if (!file.exists()) {
                file.mkdirs();
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoOutput(false);
            httpURLConnection.connect();
            FileOutputStream fileOutputStream = new FileOutputStream(new File(file, str2));
            InputStream inputStream = httpURLConnection.getInputStream();
            this.d.setMax(Integer.valueOf(yt.a(httpURLConnection)).intValue() / 1024);
            byte[] bArr = new byte[1024];
            Integer valueOf = Integer.valueOf(0);
            while (true) {
                int read = inputStream.read(bArr);
                if (read > 0) {
                    fileOutputStream.write(bArr, 0, read);
                    Integer[] numArr = new Integer[1];
                    Integer valueOf2 = Integer.valueOf(valueOf.intValue() + 1);
                    numArr[0] = valueOf;
                    publishProgress(numArr);
                    valueOf = valueOf2;
                } else {
                    fileOutputStream.close();
                    return Integer.valueOf(1);
                }
            }
        } catch (Exception e) {
            return Integer.valueOf(0);
        }
    }

    protected void a(Integer... numArr) {
        this.d.setProgress(numArr[0].intValue());
    }
}
