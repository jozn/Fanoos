import android.util.Log;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class aeo {
    private Map a;
    private long b;
    private long c;

    public aeo() {
        this.a = Collections.synchronizedMap(new LinkedHashMap(10, 1.5f, true));
        this.b = 0;
        this.c = 1000000000;
        a(Runtime.getRuntime().maxMemory() / 4);
    }

    public void a(long j) {
        this.c = j;
        Log.i("MemoryCache", "MemoryCache will use up to " + ((((double) this.c) / 1024.0d) / 1024.0d) + "MB");
    }
}
