import android.content.Context;
import java.util.List;
import org.kxml2.kdom.Node;
import org.xmlpull.v1.XmlPullParser;

public class yw {
    public static final Integer k;
    public static final Integer l;
    public static final Integer m;
    String a;
    String b;
    Integer c;
    String d;
    String e;
    Integer f;
    Integer g;
    String h;
    String i;
    Integer j;

    public yw() {
        this.j = Integer.valueOf(-1);
    }

    public void a(Integer num) {
        this.j = num;
    }

    public String a() {
        return this.i;
    }

    public void a(String str) {
        this.i = str;
    }

    public String b() {
        return this.a;
    }

    public void b(String str) {
        this.a = str;
    }

    public String c() {
        return this.b;
    }

    public void c(String str) {
        this.b = str;
    }

    public void b(Integer num) {
        this.c = num;
    }

    public String d() {
        return this.d;
    }

    public void d(String str) {
        this.d = str;
    }

    public String e() {
        return this.e;
    }

    public void e(String str) {
        this.e = str;
    }

    public void c(Integer num) {
        this.f = num;
    }

    public Integer f() {
        return this.g;
    }

    public void d(Integer num) {
        this.g = num;
    }

    public String g() {
        return this.h;
    }

    public void f(String str) {
        this.h = str;
    }

    static {
        k = Integer.valueOf(-1);
        l = Integer.valueOf(1);
        m = Integer.valueOf(0);
    }

    public static Integer a(String str, Context context) {
        Integer num = k;
        aar aar = new aar(context);
        try {
            aar.a();
            num = aar.d(str);
        } catch (Exception e) {
            aas aas = new aas();
            aas.a("ir.seraj.fanoos");
            aas.e(ys.a(context));
            aas.d(zn.a());
            aas.c(" InsertGroup");
            aas.b(e.getMessage());
            aas.a(Integer.valueOf(0));
            aas.a(context);
        } finally {
            aar.b();
        }
        return num;
    }

    public static Integer b(String str, Context context) {
        Integer valueOf = Integer.valueOf(0);
        aar aar = new aar(context);
        try {
            aar.a();
            valueOf = aar.e(str);
        } catch (Exception e) {
            aas aas = new aas();
            aas.a("ir.seraj.fanoos");
            aas.e(ys.a(context));
            aas.d(zn.a());
            aas.c(" InsertGroup");
            aas.b(e.getMessage());
            aas.a(Integer.valueOf(0));
            aas.a(context);
        } finally {
            aar.b();
        }
        return valueOf;
    }

    public static yw c(String str, Context context) {
        yw ywVar = new yw();
        aar aar = new aar(context);
        try {
            aar.a();
            ywVar = aar.c(str);
        } catch (Exception e) {
            aas aas = new aas();
            aas.a("ir.seraj.fanoos");
            aas.e(ys.a(context));
            aas.d(zn.a());
            aas.c(" InsertGroup");
            aas.b(e.getMessage());
            aas.a(Integer.valueOf(0));
            aas.a(context);
        } finally {
            aar.b();
        }
        return ywVar;
    }

    public static Boolean d(String str, Context context) {
        aar aar = new aar(context);
        Boolean valueOf;
        try {
            aar.a();
            if (a(str, context) == k) {
                valueOf = Boolean.valueOf(false);
                return valueOf;
            }
            if (!aeq.f(context).booleanValue()) {
                aar.g(String.valueOf(str));
            }
            valueOf = Boolean.valueOf(true);
            aar.b();
            return valueOf;
        } catch (Exception e) {
            valueOf = e;
            return Boolean.valueOf(false);
        } finally {
            aar.b();
        }
    }

    public static String a(yw ywVar, Context context) {
        String b;
        Exception e;
        aas aas;
        if (ywVar.b().length() < 1) {
            return String.valueOf("-1");
        }
        aar aar = new aar(context);
        String valueOf = String.valueOf("0");
        try {
            aar.a();
            b = aar.a(ywVar).b();
            try {
                if (b.length() < 3) {
                    aar.b(String.valueOf(ywVar.b()));
                }
                if (b.length() < 3) {
                    aas aas2 = new aas();
                    aas2.a("ir.seraj.fanoos");
                    aas2.e(ys.a(context));
                    aas2.d(zn.a());
                    aas2.c("InsertDisciplinary");
                    aas2.b("have");
                    aas2.a(Integer.valueOf(0));
                    aas2.a(context);
                }
                aar.b();
                return b;
            } catch (Exception e2) {
                e = e2;
                try {
                    aas = new aas();
                    aas.a("ir.seraj.fanoos");
                    aas.e(ys.a(context));
                    aas.d(zn.a());
                    aas.c(" InsertUsers");
                    aas.b(e.getMessage());
                    aas.a(Integer.valueOf(0));
                    aas.a(context);
                    return b;
                } finally {
                    aar.b();
                }
            }
        } catch (Exception e3) {
            Exception exception = e3;
            b = valueOf;
            e = exception;
            aas = new aas();
            aas.a("ir.seraj.fanoos");
            aas.e(ys.a(context));
            aas.d(zn.a());
            aas.c(" InsertUsers");
            aas.b(e.getMessage());
            aas.a(Integer.valueOf(0));
            aas.a(context);
            return b;
        }
    }

    public static Boolean a(yw ywVar, List list, Context context) {
        aar aar = new aar(context);
        try {
            aar.a();
            aar.b(ywVar);
            aar.a(list);
        } catch (Exception e) {
            aas aas = new aas();
            aas.a("ir.seraj.fanoos");
            aas.e(ys.a(context));
            aas.d(zn.a());
            aas.c("UpdateGroupInfo");
            aas.b(e.getMessage());
            aas.a(Integer.valueOf(0));
            aas.a(context);
        } finally {
            aar.b();
        }
        return Boolean.valueOf(true);
    }

    public static int a(Context context, String str) {
        int i = 0;
        aar aar = new aar(context);
        try {
            aar.a();
            i = aar.f(str);
        } catch (Exception e) {
            aas aas = new aas();
            aas.a("ir.seraj.fanoos");
            aas.e(ys.a(context));
            aas.d(zn.a());
            aas.c(" ResetGroupUnreadMessage");
            aas.b(e.getMessage());
            aas.a(Integer.valueOf(0));
            aas.a(context);
        } finally {
            aar.b();
        }
        return i;
    }

    public static int a(String str, String str2, Context context) {
        aar aar = new aar(context);
        try {
            aar.a();
            aar.a(str2, str);
        } catch (Exception e) {
            aas aas = new aas();
            aas.a("ir.seraj.fanoos");
            aas.e(ys.a(context));
            aas.d(zn.a());
            aas.c("ChangeGroupName");
            aas.b(e.getMessage());
            aas.a(Integer.valueOf(0));
            aas.a(context);
        } finally {
            aar.b();
        }
        return 1;
    }

    public static int b(String str, String str2, Context context) {
        aar aar = new aar(context);
        try {
            aar.a();
            aar.b(str, str2);
        } catch (Exception e) {
            aas aas = new aas();
            aas.a("ir.seraj.fanoos");
            aas.e(ys.a(context));
            aas.d(zn.a());
            aas.c("ChangeGroupName");
            aas.b(e.getMessage());
            aas.a(Integer.valueOf(0));
            aas.a(context);
        } finally {
            aar.b();
        }
        return 1;
    }

    public static int c(String str, String str2, Context context) {
        aar aar = new aar(context);
        try {
            aar.a();
            aar.c(str, str2);
        } catch (Exception e) {
            aas aas = new aas();
            aas.a("ir.seraj.fanoos");
            aas.e(ys.a(context));
            aas.d(zn.a());
            aas.c("ChangeGroupImage");
            aas.b(e.getMessage());
            aas.a(Integer.valueOf(0));
            aas.a(context);
        } finally {
            aar.b();
        }
        return 1;
    }

    public static int e(String str, Context context) {
        aar aar = new aar(context);
        try {
            aar.a();
            aar.a(str);
        } catch (Exception e) {
            aas aas = new aas();
            aas.a("ir.seraj.fanoos");
            aas.e(ys.a(context));
            aas.d(zn.a());
            aas.c("ChangeGroupImage");
            aas.b(e.getMessage());
            aas.a(Integer.valueOf(0));
            aas.a(context);
        } finally {
            aar.b();
        }
        return 1;
    }

    public static int f(String str, Context context) {
        aar aar = new aar(context);
        try {
            aar.a();
            aar.b(str);
        } catch (Exception e) {
            aas aas = new aas();
            aas.a("ir.seraj.fanoos");
            aas.e(ys.a(context));
            aas.d(zn.a());
            aas.c("ChangeGroupImage");
            aas.b(e.getMessage());
            aas.a(Integer.valueOf(0));
            aas.a(context);
        } finally {
            aar.b();
        }
        return 1;
    }

    public static int a(yx yxVar, Context context) {
        aar aar = new aar(context);
        try {
            aar.a();
            aar.b(yxVar);
            aar.b();
        } catch (Exception e) {
            aas aas = new aas();
            aas.a("ir.seraj.fanoos");
            aas.e(ys.a(context));
            aas.d(zn.a());
            aas.c("UpdateGroupInfo");
            aas.b(e.getMessage());
            aas.a(Integer.valueOf(0));
            aas.a(context);
        } finally {
            aar.b();
        }
        return 1;
    }

    public static int d(String str, String str2, Context context) {
        aar aar = new aar(context);
        try {
            aar.a();
            yx yxVar = new yx();
            yxVar.b(String.valueOf(str));
            yxVar.a(str2);
            aar.a(yxVar);
            aar.b();
        } catch (Exception e) {
            aas aas = new aas();
            aas.a("ir.seraj.fanoos");
            aas.e(ys.a(context));
            aas.d(zn.a());
            aas.c("UpdateGroupInfo");
            aas.b(e.getMessage());
            aas.a(Integer.valueOf(0));
            aas.a(context);
        } finally {
            aar.b();
        }
        return 1;
    }

    public static int e(String str, String str2, Context context) {
        aar aar = new aar(context);
        try {
            aar.a();
            yx yxVar = new yx();
            yxVar.b(String.valueOf(str));
            yxVar.a(str2);
            aar.a(yxVar);
            aar.b();
        } catch (Exception e) {
            aas aas = new aas();
            aas.a("ir.seraj.fanoos");
            aas.e(ys.a(context));
            aas.d(zn.a());
            aas.c("UpdateGroupInfo");
            aas.b(e.getMessage());
            aas.a(Integer.valueOf(0));
            aas.a(context);
        } finally {
            aar.b();
        }
        return 1;
    }

    public static int f(String str, String str2, Context context) {
        String[] split = str.split(zh.d);
        String str3 = XmlPullParser.NO_NAMESPACE;
        try {
            int intValue = Integer.valueOf(split[1]).intValue();
            String str4 = split[2];
            yx yxVar;
            switch (intValue) {
                case ve.CropImageView_fixAspectRatio /*1*/:
                    yw ywVar = new yw();
                    ywVar.b(String.valueOf(str2));
                    ywVar.c(split[2]);
                    ywVar.a(split[3]);
                    ywVar.f(split[4]);
                    ywVar.d(l);
                    a(ywVar, context);
                    yxVar = new yx();
                    yxVar.b(String.valueOf(str2));
                    yxVar.a(split[4]);
                    yxVar.c(split[5]);
                    yxVar.d(split[6]);
                    a(yxVar, context);
                    return 1;
                case ve.CropImageView_aspectRatioX /*2*/:
                    a(str4, str2, context);
                    return 1;
                case ve.CropImageView_aspectRatioY /*3*/:
                    c(str2, str4, context);
                    return 1;
                case ve.CropImageView_imageResource /*4*/:
                    yxVar = new yx();
                    yxVar.b(String.valueOf(str2));
                    yxVar.a(str4);
                    yxVar.c(split[3]);
                    yxVar.d(split[4]);
                    a(yxVar, context);
                    if (!str4.equals(aeq.o(context))) {
                        return 1;
                    }
                    f(str2, context);
                    return 1;
                case Node.CDSECT /*5*/:
                    d(str2, str4, context);
                    if (!str4.equals(aeq.o(context))) {
                        return 1;
                    }
                    e(str2, context);
                    ze.d(context, str2);
                    return 1;
                case Node.ENTITY_REF /*6*/:
                    e(str2, split[2], context);
                    b(str2, split[3], context);
                    ze.d(context, str2);
                    return 1;
                case Node.IGNORABLE_WHITESPACE /*7*/:
                    b(str2, split[2], context);
                    return 1;
                default:
                    return 1;
            }
        } catch (Exception e) {
            return 0;
        }
    }
}
