import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public class zd {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private Integer h;
    private String i;

    public zd() {
        this.h = Integer.valueOf(0);
        this.i = "0";
    }

    public String a() {
        return this.i;
    }

    public void a(String str) {
        this.i = str;
    }

    public Integer b() {
        return this.h;
    }

    public void a(Integer num) {
        this.h = num;
    }

    public String c() {
        return this.e;
    }

    public void b(String str) {
        this.e = str;
    }

    public String d() {
        return this.f;
    }

    public void c(String str) {
        this.f = str;
    }

    public String e() {
        return this.a;
    }

    public void d(String str) {
        this.a = str;
    }

    public String f() {
        return this.b;
    }

    public void e(String str) {
        this.b = str;
    }

    public String g() {
        return this.c;
    }

    public void f(String str) {
        this.c = str;
    }

    public String h() {
        return this.d;
    }

    public void g(String str) {
        this.d = str;
    }

    public String i() {
        return this.g;
    }

    public void h(String str) {
        this.g = str;
    }

    public static List a(Context context, String str) {
        List arrayList = new ArrayList();
        za zaVar = new za(context);
        try {
            zaVar.a();
            arrayList = zaVar.a(str);
        } catch (Exception e) {
            aas aas = new aas();
            aas.a("ir.seraj.fanoos");
            aas.e(ys.a(context));
            aas.d(zn.a());
            aas.c(" InsertUsers");
            aas.b(e.getMessage());
            aas.a(Integer.valueOf(0));
            aas.a(context);
        } finally {
            zaVar.b();
        }
        return arrayList;
    }
}
