import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

public class afi extends AsyncTask {
    ProgressBar a;
    Context b;
    String c;
    String d;
    ProgressBar e;
    String f;
    private final WeakReference g;
    private final WeakReference h;

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((Bitmap) obj);
    }

    protected /* synthetic */ void onProgressUpdate(Object[] objArr) {
        a((Integer[]) objArr);
    }

    public afi(ProgressBar progressBar, ProgressBar progressBar2, String str, ImageView imageView, ImageView imageView2, Context context) {
        this.f = XmlPullParser.NO_NAMESPACE;
        this.b = context;
        this.a = progressBar;
        this.f = str;
        this.c = str.substring(str.lastIndexOf("/") + 1);
        this.d = str;
        this.g = new WeakReference(imageView);
        this.h = new WeakReference(imageView2);
        this.e = progressBar2;
    }

    protected Bitmap a(String... strArr) {
        File file = new File(yz.h(this.d));
        if (a(this.f, this.c).intValue() != 1) {
            return BitmapFactory.decodeResource(this.b.getResources(), R.drawable.default_image);
        }
        if (!file.exists()) {
            return BitmapFactory.decodeResource(this.b.getResources(), R.drawable.default_image);
        }
        Bitmap a = zq.a(file.getAbsolutePath(), 350, 600);
        file.exists();
        return a;
    }

    protected void onPreExecute() {
        Log.i("Async-Example", "onPreExecute Called");
        this.e.setVisibility(0);
    }

    protected void a(Bitmap bitmap) {
        Log.i("Async-Example", "onPostExecute Called");
        this.e.setVisibility(4);
        if (this.g != null && bitmap != null) {
            ImageView imageView = (ImageView) this.h.get();
            if (((ImageView) this.g.get()) != null) {
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
            } else if (imageView != null) {
                imageView.setVisibility(8);
            }
        }
    }

    public Integer a(String str, String str2) {
        try {
            File file = new File(zk.a);
            if (!file.exists()) {
                file.mkdirs();
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoOutput(false);
            httpURLConnection.connect();
            FileOutputStream fileOutputStream = new FileOutputStream(new File(file, str2));
            InputStream inputStream = httpURLConnection.getInputStream();
            this.e.setMax(Integer.valueOf(yt.a(httpURLConnection)).intValue() / 1024);
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
        this.e.setProgress(numArr[0].intValue());
    }
}
