import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import ir.seraj.fanoos.Service.CheckNewMessageReceiver;
import ir.seraj.fanoos.Service.ReNewSocketReceiver;
import ir.seraj.fanoos.Service.ReReadReceiver;
import ir.seraj.fanoos.Service.ReSendMessageReceiver;
import ir.seraj.fanoos.communication.BootReceiver;
import org.xmlpull.v1.XmlPullParser;

public class ys {
    public static String a(Context context) {
        return zr.a(context);
    }

    public static String a(Context context, String str) {
        return zo.a(str, "fanoosapp1234982");
    }

    public static String b(Context context, String str) {
        return zo.b(str, "fanoosapp1234982").replace("\n", XmlPullParser.NO_NAMESPACE);
    }

    public static String c(Context context, String str) {
        return zo.a(str, aeq.n(context));
    }

    public static String d(Context context, String str) {
        return zo.a(str, aeq.o(context) + "35723");
    }

    public static String e(Context context, String str) {
        String n = aeq.n(context);
        String replace = zo.b(str, n).replace("\n", XmlPullParser.NO_NAMESPACE);
        return "$" + zo.b(String.valueOf(replace.length()), n).replace("\n", XmlPullParser.NO_NAMESPACE) + "$" + replace;
    }

    public static Boolean a(Context context, Boolean bool) {
        aeq.h(context, bool);
        return Boolean.valueOf(true);
    }

    public static Boolean b(Context context) {
        context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, BootReceiver.class), 1, 1);
        return Boolean.valueOf(true);
    }

    public static Boolean c(Context context) {
        d(context);
        h(context);
        f(context);
        return Boolean.valueOf(true);
    }

    public static Boolean d(Context context) {
        ((AlarmManager) context.getSystemService("alarm")).setInexactRepeating(0, System.currentTimeMillis(), (long) 300000, PendingIntent.getBroadcast(context, 0, new Intent(context, CheckNewMessageReceiver.class), 0));
        return Boolean.valueOf(true);
    }

    public static Boolean e(Context context) {
        ((AlarmManager) context.getSystemService("alarm")).cancel(PendingIntent.getBroadcast(context, 0, new Intent(context, CheckNewMessageReceiver.class), 0));
        return Boolean.valueOf(true);
    }

    public static Boolean f(Context context) {
        ((AlarmManager) context.getSystemService("alarm")).setInexactRepeating(0, System.currentTimeMillis(), (long) 8000, PendingIntent.getBroadcast(context, 0, new Intent(context, ReReadReceiver.class), 0));
        return Boolean.valueOf(true);
    }

    public static Boolean g(Context context) {
        ((AlarmManager) context.getSystemService("alarm")).cancel(PendingIntent.getBroadcast(context, 0, new Intent(context, ReReadReceiver.class), 0));
        return Boolean.valueOf(true);
    }

    public static Boolean h(Context context) {
        ((AlarmManager) context.getSystemService("alarm")).setInexactRepeating(0, System.currentTimeMillis(), (long) 600000, PendingIntent.getBroadcast(context, 0, new Intent(context, ReNewSocketReceiver.class), 0));
        return Boolean.valueOf(true);
    }

    public static Boolean i(Context context) {
        ((AlarmManager) context.getSystemService("alarm")).setInexactRepeating(0, System.currentTimeMillis(), (long) 8000, PendingIntent.getBroadcast(context, 0, new Intent(context, ReSendMessageReceiver.class), 0));
        return Boolean.valueOf(true);
    }

    public static Boolean j(Context context) {
        ((AlarmManager) context.getSystemService("alarm")).cancel(PendingIntent.getBroadcast(context, 0, new Intent(context, ReSendMessageReceiver.class), 0));
        return Boolean.valueOf(true);
    }

    public static Boolean f(Context context, String str) {
        aeq.e(context, str);
        return Boolean.valueOf(true);
    }

    public static Boolean k(Context context) {
        if (aeq.n(context).length() > 5) {
            return Boolean.valueOf(true);
        }
        return Boolean.valueOf(false);
    }

    public static Boolean l(Context context) {
        aeq.c(context, Boolean.valueOf(true));
        return Boolean.valueOf(false);
    }

    public static Boolean m(Context context) {
        return aeq.e(context);
    }

    public static Boolean b(Context context, Boolean bool) {
        aeq.g(context, bool);
        return Boolean.valueOf(false);
    }

    public static Boolean n(Context context) {
        return aeq.m(context);
    }

    public static Boolean o(Context context) {
        aeq.f(context, Boolean.valueOf(true));
        return Boolean.valueOf(true);
    }

    public static Boolean p(Context context) {
        return aeq.j(context);
    }

    public static Boolean a(Context context, String str, String str2) {
        aeq.a(context, str);
        aeq.b(context, str2.replace('#', '\n'));
        return Boolean.valueOf(true);
    }

    public static String q(Context context) {
        return aeq.h(context);
    }

    public static String r(Context context) {
        return aeq.i(context);
    }
}
