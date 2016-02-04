import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import ir.seraj.fanoos3.R;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class aay {
    abc a;
    aax b;
    ExecutorService c;
    Boolean d;
    Boolean e;
    Context f;
    String g;
    Handler h;
    private HashMap i;
    private Map j;

    public aay(Context context, HashMap hashMap, Boolean bool, Boolean bool2, String str) {
        this.a = new abc();
        this.h = new Handler();
        this.i = new HashMap();
        this.j = Collections.synchronizedMap(new WeakHashMap());
        this.g = str;
        this.b = new aax(context, str);
        this.i = hashMap;
        this.d = bool;
        this.e = bool2;
        this.f = context;
        this.c = Executors.newFixedThreadPool(5);
    }

    public void a(String str, ImageView imageView, Integer num) {
        this.j.put(imageView, str);
        Bitmap a = this.a.a(str);
        if (a == null) {
            a(str, imageView);
            if (this.d.booleanValue()) {
                a(imageView, num.intValue());
            } else {
                imageView.setImageResource(num.intValue());
            }
        } else if (this.d.booleanValue()) {
            a(imageView, a);
        } else {
            imageView.setImageBitmap(a);
        }
    }

    private void a(String str, ImageView imageView) {
        this.c.submit(new abb(this, new aba(this, str, imageView)));
    }

    private Bitmap a(String str) {
        File a = this.b.a(str);
        Bitmap a2 = a(a);
        if (a2 != null) {
            return a2;
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setReadTimeout(30000);
            httpURLConnection.setInstanceFollowRedirects(true);
            InputStream inputStream = httpURLConnection.getInputStream();
            OutputStream fileOutputStream = new FileOutputStream(a);
            abd.a(inputStream, fileOutputStream);
            fileOutputStream.close();
            httpURLConnection.disconnect();
            return a(a);
        } catch (Throwable th) {
            th.printStackTrace();
            if (th instanceof OutOfMemoryError) {
                this.a.a();
            }
            return null;
        }
    }

    private Bitmap a(File file) {
        int i = 1;
        try {
            Options options = new Options();
            options.inJustDecodeBounds = true;
            InputStream fileInputStream = new FileInputStream(file);
            BitmapFactory.decodeStream(fileInputStream, null, options);
            fileInputStream.close();
            int i2 = options.outWidth;
            int i3 = options.outHeight;
            while (i2 / 2 >= 1000000 && i3 / 2 >= 1000000) {
                i2 /= 2;
                i3 /= 2;
                i *= 2;
            }
            options = new Options();
            options.inSampleSize = i;
            fileInputStream = new FileInputStream(file);
            Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream, null, options);
            fileInputStream.close();
            return decodeStream;
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    boolean a(aba aba) {
        String str = (String) this.j.get(aba.b);
        if (str == null || !str.equals(aba.a)) {
            return true;
        }
        return false;
    }

    public void a(ImageView imageView, int i) {
        Bitmap decodeResource = BitmapFactory.decodeResource(this.f.getResources(), i);
        Bitmap decodeResource2 = BitmapFactory.decodeResource(this.f.getResources(), R.drawable.maskconversation);
        Bitmap createBitmap = Bitmap.createBitmap(decodeResource2.getWidth(), decodeResource2.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        paint.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
        canvas.drawBitmap(decodeResource, 0.0f, 0.0f, null);
        canvas.drawBitmap(decodeResource2, 0.0f, 0.0f, paint);
        paint.setXfermode(null);
        imageView.setImageBitmap(createBitmap);
        imageView.setScaleType(ScaleType.FIT_XY);
        if (this.e.booleanValue()) {
            imageView.setBackgroundResource(R.drawable.maskconversationborder);
        }
    }

    public void a(ImageView imageView, Bitmap bitmap) {
        Bitmap decodeResource = BitmapFactory.decodeResource(this.f.getResources(), R.drawable.maskconversation);
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, decodeResource.getWidth(), decodeResource.getHeight(), true);
        Bitmap createBitmap = Bitmap.createBitmap(decodeResource.getWidth(), decodeResource.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        paint.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
        canvas.drawBitmap(createScaledBitmap, 0.0f, 0.0f, null);
        canvas.drawBitmap(decodeResource, 0.0f, 0.0f, paint);
        paint.setXfermode(null);
        imageView.setImageBitmap(createBitmap);
        imageView.setScaleType(ScaleType.FIT_XY);
        if (this.e.booleanValue()) {
            imageView.setBackgroundResource(R.drawable.maskconversationborder);
        }
    }
}
