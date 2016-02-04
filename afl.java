import android.content.Context;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import ir.seraj.fanoos3.R;
import org.xmlpull.v1.XmlPullParser;

public class afl extends AsyncTask {
    Context a;
    TextView b;
    ImageView c;
    String d;
    Boolean e;
    private MediaPlayer f;

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((Integer) obj);
    }

    protected /* synthetic */ void onProgressUpdate(Object[] objArr) {
        a((Integer[]) objArr);
    }

    public void a() {
        this.e = Boolean.valueOf(false);
    }

    public afl(Context context, String str, ImageView imageView, TextView textView) {
        this.a = context;
        this.c = imageView;
        this.b = textView;
        this.d = str;
        this.e = Boolean.valueOf(true);
    }

    protected Integer a(String... strArr) {
        try {
            this.f = new MediaPlayer();
            this.f.reset();
            this.f.setDataSource(this.d);
            this.f.prepare();
            this.f.start();
            this.f.setOnCompletionListener(new afm(this));
            while (this.f.isPlaying() && this.e.booleanValue()) {
                publishProgress(new Integer[]{Integer.valueOf(this.f.getCurrentPosition())});
            }
            if (this.f.isPlaying()) {
                this.f.stop();
                this.f.release();
            }
        } catch (Exception e) {
            Log.i("play", e.getMessage());
        }
        return null;
    }

    protected void a(Integer... numArr) {
        int intValue = numArr[0].intValue() / 1000;
        this.b.setText(String.valueOf(intValue / 60) + ":" + String.valueOf(intValue % 60));
    }

    protected void onPreExecute() {
        this.c.setImageResource(R.drawable.audio_pause);
        super.onPreExecute();
    }

    protected void a(Integer num) {
        this.c.setImageResource(R.drawable.audio_play);
        this.b.setText(XmlPullParser.NO_NAMESPACE);
        super.onPostExecute(num);
    }
}
