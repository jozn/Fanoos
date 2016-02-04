import android.os.Build.VERSION;
import android.os.Bundle;

public class ch extends cp {
    public static final cq a;
    private static final cj g;
    private final String b;
    private final CharSequence c;
    private final CharSequence[] d;
    private final boolean e;
    private final Bundle f;

    public String a() {
        return this.b;
    }

    public CharSequence b() {
        return this.c;
    }

    public CharSequence[] c() {
        return this.d;
    }

    public boolean d() {
        return this.e;
    }

    public Bundle e() {
        return this.f;
    }

    static {
        if (VERSION.SDK_INT >= 20) {
            g = new ck();
        } else if (VERSION.SDK_INT >= 16) {
            g = new cm();
        } else {
            g = new cl();
        }
        a = new ci();
    }
}
