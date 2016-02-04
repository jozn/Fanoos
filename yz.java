import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import java.io.File;
import java.util.Random;
import org.kxml2.kdom.Node;
import org.xmlpull.v1.XmlPullParser;

public class yz {
    public static Boolean i;
    public static Boolean j;
    static String k;
    Long a;
    String b;
    String c;
    int d;
    String e;
    int f;
    String g;
    int h;

    public yz() {
        this.d = -1;
    }

    static {
        i = Boolean.valueOf(true);
        j = Boolean.valueOf(false);
        k = "sendRecive";
    }

    public int a() {
        return this.h;
    }

    public void a(int i) {
        this.h = i;
    }

    public Long b() {
        return this.a;
    }

    public void a(Long l) {
        this.a = l;
    }

    public String c() {
        return this.b;
    }

    public void a(String str) {
        this.b = str;
    }

    public String d() {
        return this.c;
    }

    public void b(String str) {
        this.c = str;
    }

    public int e() {
        return this.d;
    }

    public void b(int i) {
        this.d = i;
    }

    public String f() {
        return this.e;
    }

    public void c(String str) {
        this.e = str;
    }

    public int g() {
        return this.f;
    }

    public void c(int i) {
        this.f = i;
    }

    public String h() {
        return this.g;
    }

    public void d(String str) {
        this.g = str;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static yz a(android.content.Context r6, yz r7) {
        /*
        r1 = new aau;
        r1.<init>(r6);
        r1.a();	 Catch:{ Exception -> 0x005e }
        r0 = r1.a(r7);	 Catch:{ Exception -> 0x005e }
        r0 = r0.b();	 Catch:{ Exception -> 0x005e }
        r2 = r0.longValue();	 Catch:{ Exception -> 0x005e }
        r4 = 1;
        r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r0 >= 0) goto L_0x005a;
    L_0x001a:
        r0 = new aas;	 Catch:{ Exception -> 0x005e }
        r0.<init>();	 Catch:{ Exception -> 0x005e }
        r2 = "ir.seraj.fanoos";
        r0.a(r2);	 Catch:{ Exception -> 0x005e }
        r2 = ys.a(r6);	 Catch:{ Exception -> 0x005e }
        r0.e(r2);	 Catch:{ Exception -> 0x005e }
        r2 = zn.a();	 Catch:{ Exception -> 0x005e }
        r0.d(r2);	 Catch:{ Exception -> 0x005e }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x005e }
        r2.<init>();	 Catch:{ Exception -> 0x005e }
        r3 = k;	 Catch:{ Exception -> 0x005e }
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x005e }
        r3 = "InsertDisciplinary";
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x005e }
        r2 = r2.toString();	 Catch:{ Exception -> 0x005e }
        r0.c(r2);	 Catch:{ Exception -> 0x005e }
        r2 = "have";
        r0.b(r2);	 Catch:{ Exception -> 0x005e }
        r2 = 0;
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ Exception -> 0x005e }
        r0.a(r2);	 Catch:{ Exception -> 0x005e }
        r0.a(r6);	 Catch:{ Exception -> 0x005e }
    L_0x005a:
        r1.b();
    L_0x005d:
        return r7;
    L_0x005e:
        r0 = move-exception;
        r2 = new aas;	 Catch:{ all -> 0x00a5 }
        r2.<init>();	 Catch:{ all -> 0x00a5 }
        r3 = "ir.seraj.fanoos";
        r2.a(r3);	 Catch:{ all -> 0x00a5 }
        r3 = ys.a(r6);	 Catch:{ all -> 0x00a5 }
        r2.e(r3);	 Catch:{ all -> 0x00a5 }
        r3 = zn.a();	 Catch:{ all -> 0x00a5 }
        r2.d(r3);	 Catch:{ all -> 0x00a5 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00a5 }
        r3.<init>();	 Catch:{ all -> 0x00a5 }
        r4 = k;	 Catch:{ all -> 0x00a5 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x00a5 }
        r4 = " InsertUsers";
        r3 = r3.append(r4);	 Catch:{ all -> 0x00a5 }
        r3 = r3.toString();	 Catch:{ all -> 0x00a5 }
        r2.c(r3);	 Catch:{ all -> 0x00a5 }
        r0 = r0.getMessage();	 Catch:{ all -> 0x00a5 }
        r2.b(r0);	 Catch:{ all -> 0x00a5 }
        r0 = 0;
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ all -> 0x00a5 }
        r2.a(r0);	 Catch:{ all -> 0x00a5 }
        r2.a(r6);	 Catch:{ all -> 0x00a5 }
        r1.b();
        goto L_0x005d;
    L_0x00a5:
        r0 = move-exception;
        r1.b();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: yz.a(android.content.Context, yz):yz");
    }

    public static int b(Context context, yz yzVar) {
        int b;
        Exception e;
        aas aas;
        aau aau = new aau(context);
        try {
            aau.a();
            b = aau.b(yzVar);
            if (b < 1) {
                try {
                    aas aas2 = new aas();
                    aas2.a("ir.seraj.fanoos");
                    aas2.e(ys.a(context));
                    aas2.d(zn.a());
                    aas2.c(k + "InsertDisciplinary");
                    aas2.b("have");
                    aas2.a(Integer.valueOf(0));
                    aas2.a(context);
                } catch (Exception e2) {
                    e = e2;
                    try {
                        aas = new aas();
                        aas.a("ir.seraj.fanoos");
                        aas.e(ys.a(context));
                        aas.d(zn.a());
                        aas.c(k + " InsertUsers");
                        aas.b(e.getMessage());
                        aas.a(Integer.valueOf(0));
                        aas.a(context);
                        return b;
                    } finally {
                        aau.b();
                    }
                }
            }
            aau.b();
        } catch (Exception e3) {
            Exception exception = e3;
            b = 0;
            e = exception;
            aas = new aas();
            aas.a("ir.seraj.fanoos");
            aas.e(ys.a(context));
            aas.d(zn.a());
            aas.c(k + " InsertUsers");
            aas.b(e.getMessage());
            aas.a(Integer.valueOf(0));
            aas.a(context);
            return b;
        }
        return b;
    }

    public static yz a(Context context, String str) {
        yz yzVar = new yz();
        aau aau = new aau(context);
        try {
            aau.a();
            yzVar = aau.a(Long.valueOf(str));
        } catch (Exception e) {
            aas aas = new aas();
            aas.a("ir.seraj.fanoos");
            aas.e(ys.a(context));
            aas.d(zn.a());
            aas.c(k + " InsertUsers");
            aas.b(e.getMessage());
            aas.a(Integer.valueOf(0));
            aas.a(context);
        } finally {
            aau.b();
        }
        return yzVar;
    }

    public static void a(Context context, yz yzVar, String str) {
        yzVar.c(String.valueOf(1));
        yz a = a(context, yzVar);
        if (a.b().longValue() > 0) {
            ze zeVar = new ze();
            zeVar.a(Integer.valueOf(0));
            zeVar.e(str);
            zeVar.c(Integer.valueOf(0));
            zeVar.d(Integer.valueOf(1));
            zeVar.d(String.valueOf("0"));
            zeVar.b(a.b());
            zeVar.e(ze.a);
            zeVar.f(zn.a());
            zeVar = ze.a(context, zeVar);
            if (zeVar.a().longValue() > 0) {
                new afr(a, zeVar, context).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
            }
        }
    }

    public static void b(Context context, yz yzVar, String str) {
        yzVar.c(String.valueOf(7));
        yz a = a(context, yzVar);
        if (a.b().longValue() > 0) {
            ze zeVar = new ze();
            zeVar.a(Integer.valueOf(0));
            zeVar.e(str);
            zeVar.c(Integer.valueOf(0));
            zeVar.d(Integer.valueOf(1));
            zeVar.d(String.valueOf("0"));
            zeVar.b(a.b());
            zeVar.e(ze.a);
            zeVar.f(zn.a());
            zeVar = ze.a(context, zeVar);
            if (zeVar.a().longValue() > 0) {
                new afr(a, zeVar, context).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
            }
        }
    }

    public static void a(Context context, yz yzVar, String str, String str2) {
        yz a = a(context, yzVar);
        if (a.b().longValue() > 1) {
            ze zeVar = new ze();
            zeVar.a(Integer.valueOf(0));
            zeVar.e(str2);
            zeVar.c(Integer.valueOf(0));
            zeVar.d(Integer.valueOf(1));
            zeVar.d(String.valueOf("0"));
            zeVar.b(a.b());
            zeVar.e(ze.a);
            zeVar.f(zn.a());
            zeVar = ze.a(context, zeVar);
            if (zeVar.a().longValue() > 0) {
                new afp(context, a, zeVar, str).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
            }
        }
    }

    public static void b(Context context, yz yzVar, String str, String str2) {
        yz a = a(context, yzVar);
        if (a.b().longValue() > 1) {
            ze zeVar = new ze();
            zeVar.a(Integer.valueOf(1));
            zeVar.e(String.valueOf(str2));
            zeVar.c("-2");
            zeVar.c(Integer.valueOf(0));
            zeVar.d(Integer.valueOf(1));
            zeVar.d(str2);
            zeVar.b(a.b());
            zeVar.e(ze.a);
            zeVar.f(zn.a());
            zeVar = ze.a(context, zeVar);
            if (zeVar.a().longValue() > 1) {
                new afp(context, a, zeVar, str).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
            }
        }
    }

    public static void a(Context context, String str, String str2) {
        yz a = a(context, str);
        ze f = ze.f(context, str2);
        f.c(Integer.valueOf(0));
        f.d(Integer.valueOf(1));
        f.e(ze.a);
        f.f(zn.a());
        ze.a(context, str2, ze.a.intValue());
        if (f.a().longValue() > 0) {
            new afp(context, a, f, a.d()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        }
    }

    public static void c(Context context, yz yzVar, String str) {
        yzVar.c(String.valueOf(1));
        yz a = a(context, yzVar);
        if (a.b().longValue() > 1) {
            ze zeVar = new ze();
            zeVar.a(Integer.valueOf(1));
            zeVar.e(String.valueOf(str));
            zeVar.c("-2");
            zeVar.c(Integer.valueOf(0));
            zeVar.d(Integer.valueOf(1));
            zeVar.d(str);
            zeVar.b(a.b());
            zeVar.e(ze.a);
            zeVar.f(zn.a());
            zeVar = ze.a(context, zeVar);
            if (zeVar.a().longValue() > 1) {
                new afr(a, zeVar, context).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
            }
        }
    }

    public static void d(Context context, yz yzVar, String str) {
        if (yzVar.b().longValue() > 0) {
            ze zeVar = new ze();
            zeVar.a(Integer.valueOf(0));
            zeVar.e(str);
            zeVar.c(Integer.valueOf(0));
            zeVar.d(Integer.valueOf(1));
            zeVar.d(String.valueOf("0"));
            zeVar.b(yzVar.b());
            zeVar.e(ze.a);
            zeVar.f(zn.a());
            zeVar = ze.a(context, zeVar);
            if (zeVar.a().longValue() > 0) {
                new afg(yzVar, zeVar, context).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
            }
        }
    }

    public static void e(Context context, yz yzVar, String str) {
        if (yzVar.b().longValue() > 1) {
            ze zeVar = new ze();
            zeVar.a(Integer.valueOf(1));
            zeVar.e(String.valueOf(str));
            zeVar.c("-2");
            zeVar.c(Integer.valueOf(0));
            zeVar.d(Integer.valueOf(1));
            zeVar.d(str);
            zeVar.b(yzVar.b());
            zeVar.e(ze.a);
            zeVar.f(zn.a());
            zeVar = ze.a(context, zeVar);
            if (zeVar.a().longValue() > 1) {
                new afg(yzVar, zeVar, context).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
            }
        }
    }

    public static void f(Context context, yz yzVar, String str) {
        yzVar.c(String.valueOf(7));
        yz a = a(context, yzVar);
        if (a.b().longValue() > 1) {
            ze zeVar = new ze();
            zeVar.a(Integer.valueOf(1));
            zeVar.e(String.valueOf(str));
            zeVar.c("-2");
            zeVar.c(Integer.valueOf(0));
            zeVar.d(Integer.valueOf(1));
            zeVar.d(str);
            zeVar.b(a.b());
            zeVar.e(ze.a);
            zeVar.f(zn.a());
            zeVar = ze.a(context, zeVar);
            if (zeVar.a().longValue() > 1) {
                new afr(a, zeVar, context).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
            }
        }
    }

    public static void a(Context context, yz yzVar, ze zeVar) {
        if (b(context, yzVar) > 0 && !ze.a(context, String.valueOf(zeVar.b())).booleanValue()) {
            ze.b(context, zeVar);
            context.sendBroadcast(new Intent("ir.dayasoft.BroadCastGetDeliverMessage"));
        }
    }

    public static void b(Context context, yz yzVar, ze zeVar) {
        Long b = a(context, yzVar).b();
        if (b.longValue() > 0) {
            zeVar.b(b);
            ze.a(context, zeVar);
            context.sendBroadcast(new Intent("com.mycompany.myapp.SOME_MESSAGE"));
        }
    }

    public static Boolean a(String str, String str2, Context context) {
        String k = aeq.k(context);
        Log.i("notifyGet", k);
        if (k.equals("-1")) {
            return Boolean.valueOf(false);
        }
        if (k.length() > 1) {
            String substring = k.substring(0, 1);
            k = k.substring(1);
            Log.i("notifyGet ", substring + " " + k + " " + str + " " + str2);
            if (substring.equals(str) && k.equals(str2)) {
                return Boolean.valueOf(true);
            }
        }
        return Boolean.valueOf(false);
    }

    public static Boolean b(String str, String str2, Context context) {
        String str3 = str + str2;
        aeq.c(context, str3);
        Log.i("notifySet", str3);
        return Boolean.valueOf(true);
    }

    public static Boolean a(Integer num, Long l, Context context) {
        aau aau = new aau(context);
        try {
            aau.a();
            aau.a(num, l);
        } catch (Exception e) {
            aas aas = new aas();
            aas.a("ir.seraj.fanoos");
            aas.e(ys.a(context));
            aas.d(zn.a());
            aas.c(k + " SetMessageSize");
            aas.b(e.getMessage());
            aas.a(Integer.valueOf(0));
            aas.a(context);
        } finally {
            aau.b();
        }
        return Boolean.valueOf(true);
    }

    public static Boolean a(Context context) {
        aeq.c(context, "-1");
        return Boolean.valueOf(true);
    }

    public static Boolean e(String str) {
        return zp.a(zk.d + File.separator + str.substring(str.lastIndexOf("/") + 1));
    }

    public static Boolean f(String str) {
        return zp.a(zk.a + File.separator + str.substring(str.lastIndexOf("/") + 1));
    }

    public static Boolean g(String str) {
        return zp.a(zk.e + File.separator + str.substring(str.lastIndexOf("/") + 1));
    }

    public static String h(String str) {
        return zk.a + File.separator + str.substring(str.lastIndexOf("/") + 1);
    }

    public static String i(String str) {
        return zk.d + File.separator + str.substring(str.lastIndexOf("/") + 1);
    }

    public static String j(String str) {
        return zk.e + File.separator + str.substring(str.lastIndexOf("/") + 1);
    }

    public static String a(yz yzVar) {
        switch (Integer.valueOf(yzVar.f()).intValue()) {
            case ve.CropImageView_fixAspectRatio /*1*/:
                return yzVar.d();
            case ve.CropImageView_aspectRatioX /*2*/:
                return "\u062a\u0635\u0648\u06cc\u0631";
            case ve.CropImageView_aspectRatioY /*3*/:
                return "\u0648\u06cc\u062f\u06cc\u0648";
            case ve.CropImageView_imageResource /*4*/:
                return "\u0635\u0648\u062a";
            default:
                return XmlPullParser.NO_NAMESPACE;
        }
    }

    public static String k(String str) {
        return str.replace(zh.b, XmlPullParser.NO_NAMESPACE).replace(zh.a, XmlPullParser.NO_NAMESPACE).replace(zh.c, XmlPullParser.NO_NAMESPACE).replace(zh.d, XmlPullParser.NO_NAMESPACE);
    }

    public static yz b(yz yzVar) {
        String str = XmlPullParser.NO_NAMESPACE;
        str = XmlPullParser.NO_NAMESPACE;
        switch (Integer.valueOf(yzVar.f()).intValue()) {
            case ve.CropImageView_aspectRatioX /*2*/:
                str = yzVar.d();
                yzVar.b(zk.a + File.separator + str.substring(str.lastIndexOf("/") + 1));
                break;
            case ve.CropImageView_aspectRatioY /*3*/:
                str = yzVar.d();
                yzVar.b(zk.d + File.separator + str.substring(str.lastIndexOf("/") + 1));
                break;
            case ve.CropImageView_imageResource /*4*/:
                str = yzVar.d();
                yzVar.b(zk.e + File.separator + str.substring(str.lastIndexOf("/") + 1));
                break;
            case Node.CDSECT /*5*/:
                str = yzVar.d();
                yzVar.b(zk.d + File.separator + str.substring(str.lastIndexOf("/") + 1));
                break;
        }
        return yzVar;
    }

    public static String i() {
        Random random = new Random(1233);
        return "record" + random.nextInt(10000) + random.nextInt(7000) + ".mp3";
    }

    public static String a(zc zcVar) {
        Long valueOf;
        if (zcVar.h().equals("-2")) {
            valueOf = Long.valueOf("0");
        } else {
            valueOf = zcVar.j();
        }
        if (valueOf.longValue() != 0) {
            switch (Integer.valueOf(zcVar.e()).intValue()) {
                case ve.CropImageView_fixAspectRatio /*1*/:
                    return XmlPullParser.NO_NAMESPACE;
                case ve.CropImageView_aspectRatioX /*2*/:
                    return h(zcVar.d());
                case ve.CropImageView_aspectRatioY /*3*/:
                    return i(zcVar.d());
                case ve.CropImageView_imageResource /*4*/:
                    return j(zcVar.d());
                case Node.IGNORABLE_WHITESPACE /*7*/:
                    return XmlPullParser.NO_NAMESPACE;
                default:
                    break;
            }
        }
        switch (Integer.valueOf(zcVar.e()).intValue()) {
            case ve.CropImageView_fixAspectRatio /*1*/:
                return XmlPullParser.NO_NAMESPACE;
            case ve.CropImageView_aspectRatioX /*2*/:
                return zcVar.d();
            case ve.CropImageView_aspectRatioY /*3*/:
                return zcVar.d();
            case ve.CropImageView_imageResource /*4*/:
                return XmlPullParser.NO_NAMESPACE;
            case Node.IGNORABLE_WHITESPACE /*7*/:
                return XmlPullParser.NO_NAMESPACE;
        }
        return XmlPullParser.NO_NAMESPACE;
    }

    public static Boolean b(zc zcVar) {
        return Boolean.valueOf(zcVar.k().startsWith(zh.e + zh.d));
    }
}
