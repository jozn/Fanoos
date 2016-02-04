import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import ir.seraj.fanoos3.R;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class aew extends AsyncTask {
    Integer a;
    Boolean b;
    Context c;
    String d;
    String e;
    private final WeakReference f;
    private aex g;

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((Bitmap) obj);
    }

    public aew(aex aex, ImageView imageView, Integer num, Boolean bool, String str, Context context) {
        this.f = new WeakReference(imageView);
        this.a = num;
        this.b = bool;
        this.c = context;
        this.d = str;
        this.g = aex;
    }

    protected Bitmap a(String... strArr) {
        this.e = strArr[0];
        if (TextUtils.isEmpty(this.e)) {
            return null;
        }
        String substring = this.e.substring(this.e.lastIndexOf("/") + 1);
        File file = new File(this.d + File.separator + substring);
        if (file.exists()) {
            Bitmap a = zq.a(file.getAbsolutePath(), 350, 350);
            file.exists();
            return a;
        }
        a = a(this.e);
        a(a, substring);
        return a;
    }

    protected void a(Bitmap bitmap) {
        if (this.f != null) {
            ImageView imageView = (ImageView) this.f.get();
            if (bitmap != null) {
                this.g.a(this.e, bitmap);
                if (imageView == null) {
                    return;
                }
                if (this.b.booleanValue()) {
                    a(imageView, bitmap);
                } else {
                    imageView.setImageBitmap(bitmap);
                }
            } else if (this.b.booleanValue()) {
                a(imageView, this.a.intValue());
            } else {
                imageView.setImageResource(this.a.intValue());
            }
        }
    }

    protected void onPreExecute() {
        super.onPreExecute();
    }

    public void a(ImageView imageView, Bitmap bitmap) {
        Bitmap decodeResource = BitmapFactory.decodeResource(this.c.getResources(), R.drawable.maskconversation);
        Bitmap createBitmap = Bitmap.createBitmap(decodeResource.getWidth(), decodeResource.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        paint.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, null);
        canvas.drawBitmap(decodeResource, 0.0f, 0.0f, paint);
        paint.setXfermode(null);
        imageView.setImageBitmap(createBitmap);
        imageView.setScaleType(ScaleType.CENTER);
        imageView.setBackgroundResource(R.drawable.maskconversationborder);
    }

    public void a(ImageView imageView, int i) {
        Bitmap decodeResource = BitmapFactory.decodeResource(this.c.getResources(), i);
        Bitmap decodeResource2 = BitmapFactory.decodeResource(this.c.getResources(), R.drawable.maskconversation);
        Bitmap createBitmap = Bitmap.createBitmap(decodeResource2.getWidth(), decodeResource2.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        paint.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
        canvas.drawBitmap(decodeResource, 0.0f, 0.0f, null);
        canvas.drawBitmap(decodeResource2, 0.0f, 0.0f, paint);
        paint.setXfermode(null);
        imageView.setImageBitmap(createBitmap);
        imageView.setScaleType(ScaleType.CENTER);
        imageView.setBackgroundResource(R.drawable.maskconversationborder);
    }

    private Bitmap a(String str) {
        InputStream content;
        Throwable th;
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        Object httpGet = new HttpGet(str);
        try {
            HttpResponse execute = defaultHttpClient.execute(httpGet);
            int statusCode = execute.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                Log.w("ImageDownloader", "Error " + statusCode + " while retrieving bitmap from " + str);
                return null;
            }
            HttpEntity entity = execute.getEntity();
            if (entity == null) {
                return null;
            }
            try {
                content = entity.getContent();
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(content);
                    if (content != null) {
                        content.close();
                    }
                    entity.consumeContent();
                    return decodeStream;
                } catch (Throwable th2) {
                    th = th2;
                    if (content != null) {
                        content.close();
                    }
                    entity.consumeContent();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                content = null;
                if (content != null) {
                    content.close();
                }
                entity.consumeContent();
                throw th;
            }
        } catch (Exception e) {
            httpGet.abort();
            Log.e("ImageDownloader", "Something went wrong while retrieving bitmap from " + str + e.toString());
            return null;
        }
    }

    private void a(Bitmap bitmap, String str) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
        try {
            File file = new File(this.d);
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
}
