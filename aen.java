import android.content.Context;
import android.os.Handler;
import ir.seraj.fanoos3.R;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class aen {
    final int a;
    aeo b;
    aem c;
    ExecutorService d;
    Handler e;
    private Map f;

    public aen(Context context) {
        this.a = R.drawable.default_image_group;
        this.b = new aeo();
        this.e = new Handler();
        this.f = Collections.synchronizedMap(new WeakHashMap());
        this.c = new aem(context);
        this.d = Executors.newFixedThreadPool(5);
    }
}
