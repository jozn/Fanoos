import android.content.Context;
import android.os.Environment;
import java.io.File;

public class aem {
    private File a;

    public aem(Context context) {
        if (Environment.getExternalStorageState().equals("mounted")) {
            this.a = new File(Environment.getExternalStorageDirectory(), "LazyList");
        } else {
            this.a = context.getCacheDir();
        }
        if (!this.a.exists()) {
            this.a.mkdirs();
        }
    }
}
