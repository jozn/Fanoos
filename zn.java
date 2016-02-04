import android.text.format.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParser;

public class zn {
    private static String a;
    private static String b;
    private static String c;

    static {
        a = "yyyy-MM-dd kk:mm:ss";
        b = "MM/dd/yyyy kk:mm:ss";
        c = "hh:mm";
    }

    public static String a() {
        return DateFormat.format(a, new GregorianCalendar(Locale.ENGLISH).getTime().getTime()).toString();
    }

    public static long a(String str, String str2) {
        Date date = new Date();
        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(a, Locale.US);
        try {
            date = simpleDateFormat.parse(str);
            date2 = simpleDateFormat.parse(str2);
        } catch (Exception e) {
        }
        long time = date.getTime();
        long time2 = date2.getTime();
        return time > time2 ? time - time2 : time2 - time;
    }

    public static String a(String str) {
        try {
            Date parse = new SimpleDateFormat(a, Locale.US).parse(str);
            aet aet = new aet();
            aet.getClass();
            aeu aeu = new aeu(aet, parse);
            Locale locale = new Locale("en_US");
            return String.format(locale, "%d", new Object[]{Integer.valueOf(aeu.d)}) + "/" + String.format(locale, "%d", new Object[]{Integer.valueOf(aeu.c)}) + " " + String.format(locale, "%d", new Object[]{Integer.valueOf(parse.getHours())}) + ":" + String.format(locale, "%d", new Object[]{Integer.valueOf(parse.getMinutes())});
        } catch (ParseException e) {
            e.printStackTrace();
            return XmlPullParser.NO_NAMESPACE;
        }
    }

    public static String b(String str) {
        try {
            Date parse = new SimpleDateFormat(a, Locale.US).parse(str);
            Locale locale = new Locale("en_US");
            return String.format(locale, "%02d", new Object[]{Integer.valueOf(parse.getHours())}) + ":" + String.format(locale, "%02d", new Object[]{Integer.valueOf(parse.getMinutes())});
        } catch (ParseException e) {
            e.printStackTrace();
            return XmlPullParser.NO_NAMESPACE;
        }
    }
}
