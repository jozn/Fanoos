import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;

class ax extends aw {
    ax() {
    }

    public Intent a(Activity activity) {
        Intent a = ay.a(activity);
        if (a == null) {
            return b(activity);
        }
        return a;
    }

    Intent b(Activity activity) {
        return super.a(activity);
    }

    public boolean a(Activity activity, Intent intent) {
        return ay.a(activity, intent);
    }

    public void b(Activity activity, Intent intent) {
        ay.b(activity, intent);
    }

    public String a(Context context, ActivityInfo activityInfo) {
        String a = ay.a(activityInfo);
        if (a == null) {
            return super.a(context, activityInfo);
        }
        return a;
    }
}
