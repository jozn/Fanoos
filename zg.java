import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public class zg {
    public static final Integer k;
    public static final Integer l;
    static String m;
    Long a;
    String b;
    String c;
    String d;
    String e;
    String f;
    Integer g;
    String h;
    Boolean i;
    Integer j;

    public zg() {
        this.a = Long.valueOf("-1");
        this.b = XmlPullParser.NO_NAMESPACE;
        this.c = XmlPullParser.NO_NAMESPACE;
        this.d = XmlPullParser.NO_NAMESPACE;
        this.e = XmlPullParser.NO_NAMESPACE;
        this.f = XmlPullParser.NO_NAMESPACE;
        this.g = Integer.valueOf(-1);
        this.h = XmlPullParser.NO_NAMESPACE;
        this.i = Boolean.valueOf(false);
        this.j = Integer.valueOf(-1);
    }

    static {
        k = Integer.valueOf(0);
        l = Integer.valueOf(1);
        m = "user";
    }

    public Integer a() {
        return this.j;
    }

    public void a(Integer num) {
        this.j = num;
    }

    public Boolean b() {
        return this.i;
    }

    public void a(Boolean bool) {
        this.i = bool;
    }

    public Long c() {
        return this.a;
    }

    public void a(Long l) {
        this.a = l;
    }

    public String d() {
        return this.b;
    }

    public void a(String str) {
        this.b = str;
    }

    public String e() {
        return this.c;
    }

    public void b(String str) {
        this.c = str;
    }

    public String f() {
        return this.d;
    }

    public void c(String str) {
        this.d = str;
    }

    public String g() {
        return this.e;
    }

    public void d(String str) {
        this.e = str;
    }

    public String h() {
        return this.f;
    }

    public void e(String str) {
        this.f = str;
    }

    public Integer i() {
        return this.g;
    }

    public void b(Integer num) {
        this.g = num;
    }

    public String j() {
        return this.h;
    }

    public void f(String str) {
        this.h = str;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r5, java.util.List r6) {
        /*
        r0 = r6.size();
        r1 = 1;
        if (r0 >= r1) goto L_0x0008;
    L_0x0007:
        return;
    L_0x0008:
        r1 = new aaw;
        r1.<init>(r5);
        r1.a();	 Catch:{ Exception -> 0x007d }
        r0 = r1.a(r6);	 Catch:{ Exception -> 0x007d }
        r2 = r6.size();	 Catch:{ Exception -> 0x007d }
        if (r0 == r2) goto L_0x0079;
    L_0x001a:
        r2 = new aas;	 Catch:{ Exception -> 0x007d }
        r2.<init>();	 Catch:{ Exception -> 0x007d }
        r3 = "ir.seraj.fanoos";
        r2.a(r3);	 Catch:{ Exception -> 0x007d }
        r3 = ys.a(r5);	 Catch:{ Exception -> 0x007d }
        r2.e(r3);	 Catch:{ Exception -> 0x007d }
        r3 = zn.a();	 Catch:{ Exception -> 0x007d }
        r2.d(r3);	 Catch:{ Exception -> 0x007d }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x007d }
        r3.<init>();	 Catch:{ Exception -> 0x007d }
        r4 = m;	 Catch:{ Exception -> 0x007d }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x007d }
        r4 = "InsertDisciplinary";
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x007d }
        r3 = r3.toString();	 Catch:{ Exception -> 0x007d }
        r2.c(r3);	 Catch:{ Exception -> 0x007d }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x007d }
        r3.<init>();	 Catch:{ Exception -> 0x007d }
        r4 = "have problem in insert Users array. sizeOfUsers:";
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x007d }
        r4 = r6.size();	 Catch:{ Exception -> 0x007d }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x007d }
        r4 = " Size of sucsses insert:";
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x007d }
        r0 = r3.append(r0);	 Catch:{ Exception -> 0x007d }
        r0 = r0.toString();	 Catch:{ Exception -> 0x007d }
        r2.b(r0);	 Catch:{ Exception -> 0x007d }
        r0 = 0;
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x007d }
        r2.a(r0);	 Catch:{ Exception -> 0x007d }
        r2.a(r5);	 Catch:{ Exception -> 0x007d }
    L_0x0079:
        r1.b();
        goto L_0x0007;
    L_0x007d:
        r0 = move-exception;
        r2 = new aas;	 Catch:{ all -> 0x00c5 }
        r2.<init>();	 Catch:{ all -> 0x00c5 }
        r3 = "ir.seraj.fanoos";
        r2.a(r3);	 Catch:{ all -> 0x00c5 }
        r3 = ys.a(r5);	 Catch:{ all -> 0x00c5 }
        r2.e(r3);	 Catch:{ all -> 0x00c5 }
        r3 = zn.a();	 Catch:{ all -> 0x00c5 }
        r2.d(r3);	 Catch:{ all -> 0x00c5 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c5 }
        r3.<init>();	 Catch:{ all -> 0x00c5 }
        r4 = m;	 Catch:{ all -> 0x00c5 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x00c5 }
        r4 = " InsertUsers";
        r3 = r3.append(r4);	 Catch:{ all -> 0x00c5 }
        r3 = r3.toString();	 Catch:{ all -> 0x00c5 }
        r2.c(r3);	 Catch:{ all -> 0x00c5 }
        r0 = r0.getMessage();	 Catch:{ all -> 0x00c5 }
        r2.b(r0);	 Catch:{ all -> 0x00c5 }
        r0 = 0;
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ all -> 0x00c5 }
        r2.a(r0);	 Catch:{ all -> 0x00c5 }
        r2.a(r5);	 Catch:{ all -> 0x00c5 }
        r1.b();
        goto L_0x0007;
    L_0x00c5:
        r0 = move-exception;
        r1.b();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: zg.a(android.content.Context, java.util.List):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r6, zg r7) {
        /*
        r1 = new aaw;
        r1.<init>(r6);
        r0 = "0";
        r0 = java.lang.Long.valueOf(r0);
        r1.a();	 Catch:{ Exception -> 0x00a0 }
        r2 = r7.d();	 Catch:{ Exception -> 0x00a0 }
        r2 = r1.b(r2);	 Catch:{ Exception -> 0x00a0 }
        r2 = r2.booleanValue();	 Catch:{ Exception -> 0x00a0 }
        if (r2 != 0) goto L_0x008e;
    L_0x001c:
        r0 = r7.d();	 Catch:{ Exception -> 0x00a0 }
        r7.e(r0);	 Catch:{ Exception -> 0x00a0 }
        r0 = 0;
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x00a0 }
        r7.a(r0);	 Catch:{ Exception -> 0x00a0 }
        r0 = r1.a(r7);	 Catch:{ Exception -> 0x00a0 }
    L_0x002f:
        r2 = r0.longValue();	 Catch:{ Exception -> 0x00a0 }
        r4 = 1;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 == 0) goto L_0x008a;
    L_0x0039:
        r2 = new aas;	 Catch:{ Exception -> 0x00a0 }
        r2.<init>();	 Catch:{ Exception -> 0x00a0 }
        r3 = "ir.seraj.fanoos";
        r2.a(r3);	 Catch:{ Exception -> 0x00a0 }
        r3 = ys.a(r6);	 Catch:{ Exception -> 0x00a0 }
        r2.e(r3);	 Catch:{ Exception -> 0x00a0 }
        r3 = zn.a();	 Catch:{ Exception -> 0x00a0 }
        r2.d(r3);	 Catch:{ Exception -> 0x00a0 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00a0 }
        r3.<init>();	 Catch:{ Exception -> 0x00a0 }
        r4 = m;	 Catch:{ Exception -> 0x00a0 }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x00a0 }
        r4 = "InsertDisciplinary";
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x00a0 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x00a0 }
        r2.c(r3);	 Catch:{ Exception -> 0x00a0 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00a0 }
        r3.<init>();	 Catch:{ Exception -> 0x00a0 }
        r4 = "have problem in insert Users array. sizeOfUsers:1 Size of sucsses insert:";
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x00a0 }
        r0 = r3.append(r0);	 Catch:{ Exception -> 0x00a0 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x00a0 }
        r2.b(r0);	 Catch:{ Exception -> 0x00a0 }
        r0 = 0;
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x00a0 }
        r2.a(r0);	 Catch:{ Exception -> 0x00a0 }
        r2.a(r6);	 Catch:{ Exception -> 0x00a0 }
    L_0x008a:
        r1.b();
    L_0x008d:
        return;
    L_0x008e:
        r2 = aeq.f(r6);	 Catch:{ Exception -> 0x00a0 }
        r2 = r2.booleanValue();	 Catch:{ Exception -> 0x00a0 }
        if (r2 != 0) goto L_0x002f;
    L_0x0098:
        r2 = r7.d();	 Catch:{ Exception -> 0x00a0 }
        r1.d(r2);	 Catch:{ Exception -> 0x00a0 }
        goto L_0x002f;
    L_0x00a0:
        r0 = move-exception;
        r2 = new aas;	 Catch:{ all -> 0x00e7 }
        r2.<init>();	 Catch:{ all -> 0x00e7 }
        r3 = "ir.seraj.fanoos";
        r2.a(r3);	 Catch:{ all -> 0x00e7 }
        r3 = ys.a(r6);	 Catch:{ all -> 0x00e7 }
        r2.e(r3);	 Catch:{ all -> 0x00e7 }
        r3 = zn.a();	 Catch:{ all -> 0x00e7 }
        r2.d(r3);	 Catch:{ all -> 0x00e7 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00e7 }
        r3.<init>();	 Catch:{ all -> 0x00e7 }
        r4 = m;	 Catch:{ all -> 0x00e7 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x00e7 }
        r4 = " InsertUsers";
        r3 = r3.append(r4);	 Catch:{ all -> 0x00e7 }
        r3 = r3.toString();	 Catch:{ all -> 0x00e7 }
        r2.c(r3);	 Catch:{ all -> 0x00e7 }
        r0 = r0.getMessage();	 Catch:{ all -> 0x00e7 }
        r2.b(r0);	 Catch:{ all -> 0x00e7 }
        r0 = 0;
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ all -> 0x00e7 }
        r2.a(r0);	 Catch:{ all -> 0x00e7 }
        r2.a(r6);	 Catch:{ all -> 0x00e7 }
        r1.b();
        goto L_0x008d;
    L_0x00e7:
        r0 = move-exception;
        r1.b();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: zg.a(android.content.Context, zg):void");
    }

    public static zg a(Context context, String str) {
        zg zgVar = new zg();
        aaw aaw = new aaw(context);
        try {
            aaw.a();
            zgVar = aaw.a(str);
        } catch (Exception e) {
            aas aas = new aas();
            aas.a("ir.seraj.fanoos");
            aas.e(ys.a(context));
            aas.d(zn.a());
            aas.c(m + " InsertUsers");
            aas.b(e.getMessage());
            aas.a(Integer.valueOf(0));
            aas.a(context);
        } finally {
            aaw.b();
        }
        return zgVar;
    }

    public static List a(Context context) {
        List arrayList = new ArrayList();
        aaw aaw = new aaw(context);
        try {
            aaw.a();
            arrayList = aaw.a(l.intValue());
        } catch (Exception e) {
            aas aas = new aas();
            aas.a("ir.seraj.fanoos");
            aas.e(ys.a(context));
            aas.d(zn.a());
            aas.c(m + " InsertUsers");
            aas.b(e.getMessage());
            aas.a(Integer.valueOf(0));
            aas.a(context);
        } finally {
            aaw.b();
        }
        return arrayList;
    }

    public static List b(Context context, String str) {
        List arrayList = new ArrayList();
        aaw aaw = new aaw(context);
        try {
            aaw.a();
            arrayList = aaw.a(str, l.intValue());
        } catch (Exception e) {
            aas aas = new aas();
            aas.a("ir.seraj.fanoos");
            aas.e(ys.a(context));
            aas.d(zn.a());
            aas.c(m + " InsertUsers");
            aas.b(e.getMessage());
            aas.a(Integer.valueOf(0));
            aas.a(context);
        } finally {
            aaw.b();
        }
        return arrayList;
    }

    public static List a(Context context, String str, String str2) {
        List arrayList = new ArrayList();
        aaw aaw = new aaw(context);
        try {
            aaw.a();
            arrayList = aaw.a(str, l.intValue(), str2);
        } catch (Exception e) {
            aas aas = new aas();
            aas.a("ir.seraj.fanoos");
            aas.e(ys.a(context));
            aas.d(zn.a());
            aas.c(m + " InsertUsers");
            aas.b(e.getMessage());
            aas.a(Integer.valueOf(0));
            aas.a(context);
        } finally {
            aaw.b();
        }
        return arrayList;
    }

    public static int c(Context context, String str) {
        int i = 0;
        aaw aaw = new aaw(context);
        try {
            aaw.a();
            i = aaw.c(str);
        } catch (Exception e) {
            aas aas = new aas();
            aas.a("ir.seraj.fanoos");
            aas.e(ys.a(context));
            aas.d(zn.a());
            aas.c(m + " ResetUserUnreadMessage");
            aas.b(e.getMessage());
            aas.a(Integer.valueOf(0));
            aas.a(context);
        } finally {
            aaw.b();
        }
        return i;
    }

    public static int d(Context context, String str) {
        int i = 0;
        aaw aaw = new aaw(context);
        try {
            aaw.a();
            i = aaw.e(str);
        } catch (Exception e) {
            aas aas = new aas();
            aas.a("ir.seraj.fanoos");
            aas.e(ys.a(context));
            aas.d(zn.a());
            aas.c(m + " ResetUserUnreadMessage");
            aas.b(e.getMessage());
            aas.a(Integer.valueOf(0));
            aas.a(context);
        } finally {
            aaw.b();
        }
        return i;
    }

    public static String g(String str) {
        String str2 = "0";
        String replace = str.replace(" ", XmlPullParser.NO_NAMESPACE).replace("-", XmlPullParser.NO_NAMESPACE).replace("(", XmlPullParser.NO_NAMESPACE).replace(")", XmlPullParser.NO_NAMESPACE);
        if (replace.length() >= 11) {
            return "0" + replace.substring(replace.length() - 10);
        }
        if (replace.length() == 10) {
            return "0" + replace;
        }
        return str2;
    }

    public static Boolean h(String str) {
        String str2 = "0";
        String str3 = "0123456789+";
        if (str.substring(1).contains("+")) {
            return Boolean.valueOf(false);
        }
        for (char valueOf : str.toCharArray()) {
            if (!str3.contains(String.valueOf(valueOf))) {
                return Boolean.valueOf(false);
            }
        }
        return Boolean.valueOf(true);
    }
}
