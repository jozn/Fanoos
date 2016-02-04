import org.xmlpull.v1.XmlPullParser;

public class yv {
    public static String a(String str) {
        String str2 = XmlPullParser.NO_NAMESPACE;
        Long valueOf = Long.valueOf(zn.a(str, zn.a()));
        Long valueOf2 = Long.valueOf(valueOf.longValue() / 604800000);
        Long valueOf3 = Long.valueOf(valueOf.longValue() / 86400000);
        Long valueOf4 = Long.valueOf(valueOf.longValue() / 3600000);
        Long.valueOf(valueOf.longValue() / 60000);
        if (valueOf2.longValue() > 0) {
            return valueOf2 + "\u0647\u0641\u062a\u0647" + " \u0642\u0628\u0644";
        }
        if (valueOf3.longValue() > 0) {
            return valueOf3 + "\u0631\u0648\u0632" + " \u0642\u0628\u0644";
        }
        if (valueOf4.longValue() > 0) {
            return valueOf4 + "\u0633\u0627\u0639\u062a" + " \u0642\u0628\u0644";
        }
        return zn.b(str);
    }
}
