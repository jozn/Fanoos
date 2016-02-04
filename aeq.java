import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import org.xmlpull.v1.XmlPullParser;

public class aeq {
    private static SharedPreferences a;
    private static String b;

    static {
        b = "MessagePrefs";
    }

    public static Integer a(Context context) {
        a = context.getSharedPreferences(b, 0);
        return Integer.valueOf(a.getInt("LastSendStatus", 0));
    }

    public static Integer a(Context context, Integer num) {
        a = context.getSharedPreferences(b, 0);
        Editor edit = a.edit();
        edit.putInt("LastSendStatus", num.intValue());
        edit.commit();
        return Integer.valueOf(1);
    }

    public static Integer b(Context context) {
        a = context.getSharedPreferences(b, 0);
        return Integer.valueOf(a.getInt("IsOnline", 0));
    }

    public static Integer b(Context context, Integer num) {
        a = context.getSharedPreferences(b, 0);
        Editor edit = a.edit();
        edit.putInt("IsOnline", num.intValue());
        edit.commit();
        return Integer.valueOf(1);
    }

    public static Boolean c(Context context) {
        a = context.getSharedPreferences(b, 0);
        return Boolean.valueOf(a.getBoolean("NotificationUser", true));
    }

    public static Integer a(Context context, Boolean bool) {
        a = context.getSharedPreferences(b, 0);
        Editor edit = a.edit();
        edit.putBoolean("NotificationUser", bool.booleanValue());
        edit.commit();
        return Integer.valueOf(1);
    }

    public static Boolean d(Context context) {
        a = context.getSharedPreferences(b, 0);
        return Boolean.valueOf(a.getBoolean("NotificationGroup", true));
    }

    public static Integer b(Context context, Boolean bool) {
        a = context.getSharedPreferences(b, 0);
        Editor edit = a.edit();
        edit.putBoolean("NotificationGroup", bool.booleanValue());
        edit.commit();
        return Integer.valueOf(1);
    }

    public static Boolean e(Context context) {
        a = context.getSharedPreferences(b, 0);
        return Boolean.valueOf(a.getBoolean("IsAgree", false));
    }

    public static Integer c(Context context, Boolean bool) {
        a = context.getSharedPreferences(b, 0);
        Editor edit = a.edit();
        edit.putBoolean("IsAgree", true);
        edit.commit();
        return Integer.valueOf(1);
    }

    public static synchronized Boolean f(Context context) {
        Boolean valueOf;
        synchronized (aeq.class) {
            a = context.getSharedPreferences(b, 0);
            valueOf = Boolean.valueOf(a.getBoolean("RestoringMessage", false));
        }
        return valueOf;
    }

    public static synchronized Integer d(Context context, Boolean bool) {
        Integer valueOf;
        synchronized (aeq.class) {
            Log.i("RestoringMessage", String.valueOf(bool) + zn.a());
            a = context.getSharedPreferences(b, 0);
            Editor edit = a.edit();
            edit.putBoolean("RestoringMessage", bool.booleanValue());
            edit.commit();
            valueOf = Integer.valueOf(1);
        }
        return valueOf;
    }

    public static Boolean g(Context context) {
        a = context.getSharedPreferences(b, 0);
        return Boolean.valueOf(a.getBoolean("IsFirstRefresh", true));
    }

    public static Integer e(Context context, Boolean bool) {
        a = context.getSharedPreferences(b, 0);
        Editor edit = a.edit();
        edit.putBoolean("IsFirstRefresh", bool.booleanValue());
        edit.commit();
        return Integer.valueOf(1);
    }

    public static String h(Context context) {
        a = context.getSharedPreferences(b, 0);
        return a.getString("IsOutOfDate", XmlPullParser.NO_NAMESPACE);
    }

    public static Integer a(Context context, String str) {
        a = context.getSharedPreferences(b, 0);
        Editor edit = a.edit();
        edit.putString("IsOutOfDate", str);
        edit.commit();
        return Integer.valueOf(1);
    }

    public static String i(Context context) {
        a = context.getSharedPreferences(b, 0);
        return a.getString("OutOfDateMessage", XmlPullParser.NO_NAMESPACE);
    }

    public static Integer b(Context context, String str) {
        a = context.getSharedPreferences(b, 0);
        Editor edit = a.edit();
        edit.putString("OutOfDateMessage", str);
        edit.commit();
        return Integer.valueOf(1);
    }

    public static Boolean j(Context context) {
        a = context.getSharedPreferences(b, 0);
        return Boolean.valueOf(a.getBoolean("IsCompleteInfo", false));
    }

    public static Integer f(Context context, Boolean bool) {
        a = context.getSharedPreferences(b, 0);
        Editor edit = a.edit();
        edit.putBoolean("IsCompleteInfo", bool.booleanValue());
        edit.commit();
        return Integer.valueOf(1);
    }

    public static String k(Context context) {
        a = context.getSharedPreferences(b, 0);
        return a.getString("CurrentConversation", "-1");
    }

    public static Integer c(Context context, String str) {
        a = context.getSharedPreferences(b, 0);
        Editor edit = a.edit();
        edit.putString("CurrentConversation", str);
        edit.commit();
        return Integer.valueOf(1);
    }

    public static String l(Context context) {
        a = context.getSharedPreferences(b, 0);
        return a.getString("NickName", XmlPullParser.NO_NAMESPACE);
    }

    public static Integer d(Context context, String str) {
        a = context.getSharedPreferences(b, 0);
        Editor edit = a.edit();
        edit.putString("NickName", str);
        edit.commit();
        return Integer.valueOf(1);
    }

    public static Boolean m(Context context) {
        a = context.getSharedPreferences(b, 0);
        return Boolean.valueOf(a.getBoolean("WaitForVerification", false));
    }

    public static Integer g(Context context, Boolean bool) {
        a = context.getSharedPreferences(b, 0);
        Editor edit = a.edit();
        edit.putBoolean("WaitForVerification", bool.booleanValue());
        edit.commit();
        return Integer.valueOf(1);
    }

    public static String n(Context context) {
        a = context.getSharedPreferences(b, 0);
        return a.getString("SecurityCode", XmlPullParser.NO_NAMESPACE);
    }

    public static Integer e(Context context, String str) {
        a = context.getSharedPreferences(b, 0);
        Editor edit = a.edit();
        edit.putString("SecurityCode", str);
        edit.commit();
        return Integer.valueOf(1);
    }

    public static Integer h(Context context, Boolean bool) {
        a = context.getSharedPreferences(b, 0);
        Editor edit = a.edit();
        edit.putBoolean("IsFirstTime", bool.booleanValue());
        edit.commit();
        return Integer.valueOf(1);
    }

    public static String o(Context context) {
        a = context.getSharedPreferences(b, 0);
        return a.getString("MobileNumber", "9387419323");
    }

    public static String f(Context context, String str) {
        a = context.getSharedPreferences(b, 0);
        Editor edit = a.edit();
        edit.putString("MobileNumber", str);
        edit.commit();
        return XmlPullParser.NO_NAMESPACE;
    }
}
