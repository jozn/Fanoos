import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.widget.ImageView;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.nio.channels.FileChannel;

public class afu extends AsyncTask {
    String a;
    Context b;
    FileInputStream c;
    private final WeakReference d;

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((Bitmap) obj);
    }

    public afu(ImageView imageView, String str, Context context) {
        this.c = null;
        this.d = new WeakReference(imageView);
        this.a = str;
        this.b = context;
    }

    protected Bitmap a(String... strArr) {
        try {
            String substring = this.a.substring(this.a.lastIndexOf("/") + 1);
            a(this.a);
            Bitmap a = a(this.c.getFD());
            if (a == null) {
                return a;
            }
            a(a, substring);
            return a;
        } catch (Exception e) {
            return null;
        }
    }

    private void a(Bitmap bitmap, String str) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.JPEG, 60, byteArrayOutputStream);
        try {
            File file = new File(zk.a);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, str);
            file2.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            fileOutputStream.write(byteArrayOutputStream.toByteArray());
            fileOutputStream.close();
        } catch (Exception e) {
            Log.i("imagedownloader", e.getMessage());
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap a(java.io.FileDescriptor r4) {
        /*
        r1 = new android.media.MediaMetadataRetriever;
        r1.<init>();
        r1.setDataSource(r4);	 Catch:{ IllegalArgumentException -> 0x0012, RuntimeException -> 0x001b }
        r2 = 10;
        r0 = r1.getFrameAtTime(r2);	 Catch:{ IllegalArgumentException -> 0x0012, RuntimeException -> 0x001b }
        r1.release();	 Catch:{ RuntimeException -> 0x002a }
    L_0x0011:
        return r0;
    L_0x0012:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x0025 }
        r1.release();	 Catch:{ RuntimeException -> 0x002c }
    L_0x0019:
        r0 = 0;
        goto L_0x0011;
    L_0x001b:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x0025 }
        r1.release();	 Catch:{ RuntimeException -> 0x0023 }
        goto L_0x0019;
    L_0x0023:
        r0 = move-exception;
        goto L_0x0019;
    L_0x0025:
        r0 = move-exception;
        r1.release();	 Catch:{ RuntimeException -> 0x002e }
    L_0x0029:
        throw r0;
    L_0x002a:
        r1 = move-exception;
        goto L_0x0011;
    L_0x002c:
        r0 = move-exception;
        goto L_0x0019;
    L_0x002e:
        r1 = move-exception;
        goto L_0x0029;
        */
        throw new UnsupportedOperationException("Method not decompiled: afu.a(java.io.FileDescriptor):android.graphics.Bitmap");
    }

    private void a(String str) {
        File externalStorageDirectory;
        FileChannel channel;
        try {
            externalStorageDirectory = Environment.getExternalStorageDirectory();
            Environment.getDataDirectory();
            if (externalStorageDirectory.canWrite()) {
                externalStorageDirectory = new File(str);
                channel = new FileInputStream(externalStorageDirectory).getChannel();
                this.c = new FileInputStream(externalStorageDirectory);
                channel.close();
                Long.valueOf(externalStorageDirectory.length());
            }
        } catch (Exception e) {
            try {
                externalStorageDirectory = Environment.getExternalStorageDirectory();
                File dataDirectory = Environment.getDataDirectory();
                if (externalStorageDirectory.canWrite()) {
                    externalStorageDirectory = new File(dataDirectory, str);
                    channel = new FileInputStream(externalStorageDirectory).getChannel();
                    this.c = new FileInputStream(externalStorageDirectory);
                    channel.close();
                }
            } catch (Exception e2) {
            }
        }
    }

    protected void a(Bitmap bitmap) {
        if (this.d != null && bitmap != null) {
            ImageView imageView = (ImageView) this.d.get();
            if (imageView != null) {
                imageView.setImageBitmap(bitmap);
            }
        }
    }
}
