import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

class afm implements OnCompletionListener {
    final /* synthetic */ afl a;

    afm(afl afl) {
        this.a = afl;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        mediaPlayer.release();
    }
}
