import android.graphics.Bitmap;
import android.util.Log;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class abc {
    private Map a;
    private long b;
    private long c;

    public abc() {
        this.a = Collections.synchronizedMap(new LinkedHashMap(10, 1.5f, true));
        this.b = 0;
        this.c = 1000000000;
        a(Runtime.getRuntime().maxMemory() / 4);
    }

    public void a(long j) {
        this.c = j;
        Log.i("MemoryCache", "MemoryCache will use up to " + ((((double) this.c) / 1024.0d) / 1024.0d) + "MB");
    }

    public Bitmap a(String str) {
        try {
            if (this.a.containsKey(str)) {
                return (Bitmap) this.a.get(str);
            }
            return null;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void a(String str, Bitmap bitmap) {
        try {
            if (this.a.containsKey(str)) {
                this.b -= a((Bitmap) this.a.get(str));
            }
            this.a.put(str, bitmap);
            this.b += a(bitmap);
            b();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void b() {
        Log.i("MemoryCache", "cache size=" + this.b + " length=" + this.a.size());
        if (this.b > this.c) {
            Iterator it = this.a.entrySet().iterator();
            while (it.hasNext()) {
                this.b -= a((Bitmap) ((Entry) it.next()).getValue());
                it.remove();
                if (this.b <= this.c) {
                    break;
                }
            }
            Log.i("MemoryCache", "Clean cache. New size " + this.a.size());
        }
    }

    public void a() {
        try {
            this.a.clear();
            this.b = 0;
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    long a(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return (long) (bitmap.getRowBytes() * bitmap.getHeight());
    }
}
