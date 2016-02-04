import android.content.Context;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public class zj {
    public static String a(String str, String str2, String str3) {
        return str + 11 + str2 + zh.b + str3;
    }

    public static String b(String str, String str2, String str3) {
        return str + 12 + str2 + zh.b + str3;
    }

    public static String a(String str, String str2, String str3, String str4, Context context) {
        return str + 13 + ys.b(context, str2 + zh.b + str3 + zh.b + str4);
    }

    public static String a(String str, String str2, Context context) {
        return str + 20 + ys.e(context, str2);
    }

    public static String b(String str, String str2, Context context) {
        return str + 21 + ys.e(context, str2);
    }

    public static String a(String str, List list, Context context) {
        String str2 = XmlPullParser.NO_NAMESPACE;
        String str3 = str2;
        for (zg d : list) {
            str3 = str3 + d.d() + zh.b;
        }
        return str + 14 + ys.e(context, str3);
    }

    public static String a(String str, yz yzVar, ze zeVar, Context context) {
        return str + 18 + ys.e(context, yzVar.d() + zh.b + zeVar.f() + zh.b + zeVar.h() + zh.b + zn.a() + zh.b + zh.b + yzVar.f() + zh.b + zeVar.a() + zh.b + yzVar.b());
    }

    public static String c(String str, String str2, Context context) {
        return ys.e(context, str + zh.b + str2);
    }

    public static String a(String str, Context context) {
        return str + 16 + ys.e(context, str);
    }

    public static String b(String str, List list, Context context) {
        String str2 = str + 17 + zh.b;
        String str3 = XmlPullParser.NO_NAMESPACE;
        String str4 = str3;
        for (String str32 : list) {
            str4 = str4 + str32 + zh.b;
        }
        aer.a(str2 + ys.e(context, str4));
        return str2 + ys.e(context, str4);
    }

    public static String a(String str, String str2, String str3, List list, Context context) {
        String str4 = str + 22;
        String str5 = str2 + zh.b + str3 + zh.b;
        String str6 = str5;
        for (String str52 : list) {
            str6 = str6 + str52 + zh.a;
        }
        return str4 + ys.e(context, str6);
    }

    public static String a(String str, String str2, String str3, Context context) {
        return str + 27 + ys.e(context, str2 + zh.b + str3);
    }

    public static String a(String str, String str2, List list, Context context) {
        String str3 = str + 26;
        String str4 = str2 + zh.b;
        String str5 = str4;
        for (String str42 : list) {
            str5 = str5 + str42 + zh.b;
        }
        return str3 + ys.e(context, str5);
    }

    public static String d(String str, String str2, Context context) {
        return str + 28 + ys.e(context, str2);
    }

    public static String b(String str, String str2, String str3, Context context) {
        return str + 23 + ys.e(context, str2 + zh.b + str3);
    }

    public static String c(String str, String str2, String str3, Context context) {
        return str + 24 + ys.e(context, str2 + zh.b + str3);
    }

    public static String e(String str, String str2, Context context) {
        return str + 29 + ys.e(context, str + zh.b + str2);
    }

    public static String f(String str, String str2, Context context) {
        return str + 30 + ys.e(context, str + zh.b + str2);
    }

    public static String g(String str, String str2, Context context) {
        return str + 31 + ys.e(context, str + zh.b + str2);
    }

    public static String h(String str, String str2, Context context) {
        return str + 32 + ys.e(context, str + zh.b + str2);
    }

    public static String b(String str, Context context) {
        return str + 33 + ys.b(context, str + zh.b + "callmeyou");
    }

    public static String i(String str, String str2, Context context) {
        return str + 34 + ys.e(context, str + zh.b + str2);
    }

    public static String j(String str, String str2, Context context) {
        return str + 35 + ys.e(context, str + zh.b + str2 + zh.b + "3");
    }

    public static String k(String str, String str2, Context context) {
        return str + 36 + ys.e(context, str2);
    }

    public static String b(String str, yz yzVar, ze zeVar, Context context) {
        return str + 37 + ys.e(context, yzVar.c() + zh.b + zeVar.f() + zh.b + zeVar.h() + zh.b + zeVar.a() + zh.b + zeVar.d());
    }

    public static String l(String str, String str2, Context context) {
        return str + 38 + ys.e(context, str + zh.b + str2);
    }
}
