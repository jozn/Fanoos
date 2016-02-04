import android.content.Context;
import android.os.Environment;
import java.io.File;

public class aax {
    private File a;
    private String b;

    public aax(Context context, String str) {
        this.b = str;
        if (Environment.getExternalStorageState().equals("mounted")) {
            this.a = new File(str);
        } else {
            this.a = context.getCacheDir();
        }
        if (!this.a.exists()) {
            this.a.mkdirs();
        }
    }

    public File a(String str) {
        return new File(this.a, String.valueOf(str.hashCode()));
    }
}
