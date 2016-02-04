import android.content.Context;
import android.content.Intent;
import android.util.Log;
import java.util.List;

public class ze {
    public static final Integer a;
    public static final Integer b;
    public static final Integer c;
    public static final Integer d;
    public static final Integer e;
    public static final Integer f;
    public static Integer w;
    static String x;
    Long g;
    String h;
    String i;
    Long j;
    String k;
    Integer l;
    String m;
    String n;
    Integer o;
    String p;
    Integer q;
    String r;
    Integer s;
    String t;
    Integer u;
    Integer v;

    public ze() {
        this.g = Long.valueOf("-1");
        this.h = "-1";
        this.i = "-1";
        this.j = Long.valueOf("-1");
        this.k = "-1";
        this.l = Integer.valueOf(-1);
        this.m = String.valueOf("-1");
        this.n = "-1";
        this.o = Integer.valueOf(-1);
        this.p = "-1";
        this.q = Integer.valueOf(1);
        this.r = "-1";
        this.s = Integer.valueOf(1);
        this.t = "-1";
        this.u = Integer.valueOf(-1);
        this.v = Integer.valueOf(-1);
    }

    static {
        a = Integer.valueOf(0);
        b = Integer.valueOf(1);
        c = Integer.valueOf(2);
        d = Integer.valueOf(3);
        e = Integer.valueOf(0);
        f = Integer.valueOf(1);
        w = Integer.valueOf(0);
        x = "sendReceive";
    }

    public Long a() {
        return this.g;
    }

    public void a(Long l) {
        this.g = l;
    }

    public String b() {
        return this.h;
    }

    public void a(String str) {
        this.h = str;
    }

    public String c() {
        return this.i;
    }

    public void b(String str) {
        this.i = str;
    }

    public Long d() {
        return this.j;
    }

    public void b(Long l) {
        this.j = l;
    }

    public String e() {
        return this.k;
    }

    public void c(String str) {
        this.k = str;
    }

    public Integer f() {
        return this.l;
    }

    public void a(Integer num) {
        this.l = num;
    }

    public String g() {
        return this.m;
    }

    public void d(String str) {
        this.m = str;
    }

    public String h() {
        return this.n;
    }

    public void e(String str) {
        this.n = str;
    }

    public Integer i() {
        return this.o;
    }

    public void b(Integer num) {
        this.o = num;
    }

    public String j() {
        return this.p;
    }

    public void f(String str) {
        this.p = str;
    }

    public Integer k() {
        return this.q;
    }

    public void c(Integer num) {
        this.q = num;
    }

    public String l() {
        return this.r;
    }

    public void g(String str) {
        this.r = str;
    }

    public Integer m() {
        return this.s;
    }

    public void d(Integer num) {
        this.s = num;
    }

    public String n() {
        return this.t;
    }

    public void h(String str) {
        this.t = str;
    }

    public Integer o() {
        return this.u;
    }

    public void e(Integer num) {
    }

    public Integer p() {
        return this.v;
    }

    public void f(Integer num) {
        this.v = num;
    }

    public static synchronized ze a(Context context, ze zeVar) {
        ze zeVar2;
        synchronized (ze.class) {
            aav aav = new aav(context);
            try {
                aav.a();
                if (!aav.d(zeVar.b()).booleanValue() || zeVar.b().equals("-1")) {
                    zeVar = aav.a(zeVar);
                    if (zeVar.a().longValue() < 1) {
                        aas aas = new aas();
                        aas.a("ir.seraj.fanoos");
                        aas.e(ys.a(context));
                        aas.d(zn.a());
                        aas.c(x + "InsertDisciplinary");
                        aas.b("have problem in insert Users array. sizeOfUsers");
                        aas.a(Integer.valueOf(0));
                        aas.a(context);
                    }
                }
                zeVar2 = zeVar;
                aav.b();
            } catch (Exception e) {
                Exception exception = e;
                zeVar2 = zeVar;
                aas aas2 = new aas();
                aas2.a("ir.seraj.fanoos");
                aas2.e(ys.a(context));
                aas2.d(zn.a());
                aas2.c(x + " InsertUsers");
                aas2.b(exception.getMessage());
                aas2.a(Integer.valueOf(0));
                aas2.a(context);
                aav.b();
            } catch (Throwable th) {
                aav.b();
            }
        }
        return zeVar2;
    }

    public static int b(Context context, ze zeVar) {
        int i = 0;
        aav aav = new aav(context);
        try {
            aav.a();
            i = aav.b(zeVar);
        } catch (Exception e) {
            aas aas = new aas();
            aas.a("ir.seraj.fanoos");
            aas.e(ys.a(context));
            aas.d(zn.a());
            aas.c(x + " InsertUsers");
            aas.b(e.getMessage());
            aas.a(Integer.valueOf(0));
            aas.a(context);
        } finally {
            aav.b();
        }
        return i;
    }

    public static int c(Context context, ze zeVar) {
        int i = 0;
        aav aav = new aav(context);
        try {
            aav.a();
            i = aav.b(String.valueOf(zeVar.a()));
        } catch (Exception e) {
            aas aas = new aas();
            aas.a("ir.seraj.fanoos");
            aas.e(ys.a(context));
            aas.d(zn.a());
            aas.c(x + " InsertUsers");
            aas.b(e.getMessage());
            aas.a(Integer.valueOf(0));
            aas.a(context);
        } finally {
            aav.b();
        }
        return i;
    }

    public static void a(Context context, List list) {
        if (list.size() >= 1) {
            aav aav = new aav(context);
            try {
                aav.a();
                aav.a(list);
                context.sendBroadcast(new Intent("ir.dayasoft.BroadCastGetDeliverMessage"));
            } catch (Exception e) {
                Log.i("Id123E", e.getMessage());
                aas aas = new aas();
                aas.a("ir.seraj.fanoos");
                aas.e(ys.a(context));
                aas.d(zn.a());
                aas.c(x + " InsertUsers");
                aas.b(e.getMessage());
                aas.a(Integer.valueOf(0));
                aas.a(context);
            } finally {
                aav.b();
            }
        }
    }

    public static Boolean a(Context context, String str) {
        aav aav = new aav(context);
        Boolean valueOf = Boolean.valueOf(false);
        try {
            aav.a();
            valueOf = aav.d(str);
        } catch (Exception e) {
            aas aas = new aas();
            aas.a("ir.seraj.fanoos");
            aas.e(ys.a(context));
            aas.d(zn.a());
            aas.c(x + " CheckExistMessage");
            aas.b(e.getMessage());
            aas.a(Integer.valueOf(0));
            aas.a(context);
        } finally {
            aav.b();
        }
        return valueOf;
    }

    public static int b(Context context, String str) {
        int i = 0;
        aav aav = new aav(context);
        try {
            aav.a();
            i = aav.c(str);
        } catch (Exception e) {
            aas aas = new aas();
            aas.a("ir.seraj.fanoos");
            aas.e(ys.a(context));
            aas.d(zn.a());
            aas.c(x + " UnlockMessage");
            aas.b(e.getMessage());
            aas.a(Integer.valueOf(0));
            aas.a(context);
        } finally {
            aav.b();
        }
        return i;
    }

    public static int c(Context context, String str) {
        int i = 0;
        aav aav = new aav(context);
        try {
            aav.a();
            i = aav.a(str, context);
        } catch (Exception e) {
            aas aas = new aas();
            aas.a("ir.seraj.fanoos");
            aas.e(ys.a(context));
            aas.d(zn.a());
            aas.c(x + " UnlockMessage");
            aas.b(e.getMessage());
            aas.a(Integer.valueOf(0));
            aas.a(context);
        } finally {
            aav.b();
        }
        return i;
    }

    public static Boolean d(Context context, String str) {
        aav aav = new aav(context);
        try {
            aav.a();
            aav.g(str);
        } catch (Exception e) {
            aas aas = new aas();
            aas.a("ir.seraj.fanoos");
            aas.e(ys.a(context));
            aas.d(zn.a());
            aas.c(x + " SetMessageSize");
            aas.b(e.getMessage());
            aas.a(Integer.valueOf(0));
            aas.a(context);
        } finally {
            aav.b();
        }
        return Boolean.valueOf(true);
    }

    public static Boolean a(Context context, String str, int i) {
        aav aav = new aav(context);
        Boolean.valueOf(true);
        try {
            aav.a();
            aav.a(str, i);
        } catch (Exception e) {
            aas aas = new aas();
            aas.a("ir.seraj.fanoos");
            aas.e(ys.a(context));
            aas.d(zn.a());
            aas.c(x + " CheckExistMessage");
            aas.b(e.getMessage());
            aas.a(Integer.valueOf(0));
            aas.a(context);
        } finally {
            aav.b();
        }
        return Boolean.valueOf(true);
    }

    public static Boolean e(Context context, String str) {
        aav aav = new aav(context);
        Boolean.valueOf(true);
        try {
            aav.a();
            aav.a(str);
        } catch (Exception e) {
            aas aas = new aas();
            aas.a("ir.seraj.fanoos");
            aas.e(ys.a(context));
            aas.d(zn.a());
            aas.c(x + " CheckExistMessage");
            aas.b(e.getMessage());
            aas.a(Integer.valueOf(0));
            aas.a(context);
        } finally {
            aav.b();
        }
        return Boolean.valueOf(true);
    }

    public static ze f(Context context, String str) {
        aav aav = new aav(context);
        ze zeVar = new ze();
        try {
            aav.a();
            zeVar = aav.a(Long.valueOf(str));
        } catch (Exception e) {
            aas aas = new aas();
            aas.a("ir.seraj.fanoos");
            aas.e(ys.a(context));
            aas.d(zn.a());
            aas.c(x + " CheckExistMessage");
            aas.b(e.getMessage());
            aas.a(Integer.valueOf(0));
            aas.a(context);
        } finally {
            aav.b();
        }
        return zeVar;
    }
}
