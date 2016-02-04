import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.util.Log;
import android.widget.SeekBar;
import java.io.IOException;

public class aes {
    private static String a;
    private MediaRecorder b;
    private SeekBar c;
    private MediaPlayer d;

    public aes(String str, int i) {
        this.b = null;
        this.c = null;
        this.d = null;
        a = str;
    }

    static {
        a = null;
    }

    public synchronized void a(boolean z) {
        if (z) {
            b();
        } else {
            c();
        }
    }

    private void b() {
        this.b = new MediaRecorder();
        this.b.setAudioSource(1);
        this.b.setOutputFormat(1);
        this.b.setOutputFile(a);
        this.b.setAudioEncoder(1);
        this.b.setMaxDuration(61000);
        try {
            this.b.prepare();
        } catch (IOException e) {
            Log.e("AudioRecordTest", e.getMessage());
        }
        Log.i("startRecord", "1");
        this.b.start();
    }

    private void c() {
        Log.i("stopRecord", "1");
        this.b.stop();
        this.b.release();
        this.b = null;
    }

    public void a() {
        if (this.b != null) {
            this.b.release();
            this.b = null;
        }
        if (this.d != null) {
            this.d.release();
            this.d = null;
        }
    }
}
