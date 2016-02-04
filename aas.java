import android.content.Context;

public class aas {
    static final Integer a;
    static final Integer b;
    Long c;
    String d;
    String e;
    String f;
    String g;
    String h;
    Integer i;

    static {
        a = Integer.valueOf(0);
        b = Integer.valueOf(1);
    }

    public void a(Long l) {
        this.c = l;
    }

    public String a() {
        return this.d;
    }

    public void a(String str) {
        this.d = str;
    }

    public String b() {
        return this.e;
    }

    public void b(String str) {
        this.e = str;
    }

    public String c() {
        return this.f;
    }

    public void c(String str) {
        this.f = str;
    }

    public String d() {
        return this.g;
    }

    public void d(String str) {
        this.g = str;
    }

    public String e() {
        return this.h;
    }

    public void e(String str) {
        this.h = str;
    }

    public Integer f() {
        return this.i;
    }

    public void a(Integer num) {
        this.i = num;
    }

    public void a(Context context) {
        aat aat = new aat(context);
        try {
            aat.a();
            aat.a(this);
        } catch (Exception e) {
        } finally {
            aat.b();
        }
    }
}
