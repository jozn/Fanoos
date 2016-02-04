import android.os.Environment;
import java.io.File;

public final class zk {
    public static final String a;
    public static final String b;
    public static final String c;
    public static final String d;
    public static final String e;
    public static final String f;

    static {
        a = Environment.getExternalStorageDirectory() + File.separator + "Fanoos" + File.separator + "Images";
        b = Environment.getExternalStorageDirectory() + File.separator + "Fanoos" + File.separator + "Images" + File.separator + ".thumb";
        c = Environment.getExternalStorageDirectory() + File.separator + "Fanoos" + File.separator + ".ProfileImages";
        d = Environment.getExternalStorageDirectory() + File.separator + "Fanoos" + File.separator + "Video";
        e = Environment.getExternalStorageDirectory() + File.separator + "Fanoos" + File.separator + "Audio";
        f = File.separator + "DBDev";
    }
}
