import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import org.kxml2.wap.Wbxml;

public class au {
    private static final av a;

    static {
        if (VERSION.SDK_INT >= 16) {
            a = new ax();
        } else {
            a = new aw();
        }
    }

    public static boolean a(Activity activity, Intent intent) {
        return a.a(activity, intent);
    }

    public static void b(Activity activity, Intent intent) {
        a.b(activity, intent);
    }

    public static Intent a(Activity activity) {
        return a.a(activity);
    }

    public static Intent a(Context context, ComponentName componentName) {
        String b = b(context, componentName);
        if (b == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), b);
        return b(context, componentName2) == null ? dg.a(componentName2) : new Intent().setComponent(componentName2);
    }

    public static String b(Activity activity) {
        try {
            return b((Context) activity, activity.getComponentName());
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String b(Context context, ComponentName componentName) {
        return a.a(context, context.getPackageManager().getActivityInfo(componentName, Wbxml.EXT_T_0));
    }
}
