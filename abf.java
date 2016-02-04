import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore.Audio;
import android.provider.MediaStore.Video.Media;

public class abf {
    public static Uri a() {
        if (Environment.getExternalStorageState().equalsIgnoreCase("mounted")) {
            return Media.EXTERNAL_CONTENT_URI;
        }
        return Media.INTERNAL_CONTENT_URI;
    }

    public static Uri b() {
        if (Environment.getExternalStorageState().equalsIgnoreCase("mounted")) {
            return Audio.Media.EXTERNAL_CONTENT_URI;
        }
        return Audio.Media.INTERNAL_CONTENT_URI;
    }
}
