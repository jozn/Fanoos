import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;

interface av {
    Intent a(Activity activity);

    String a(Context context, ActivityInfo activityInfo);

    boolean a(Activity activity, Intent intent);

    void b(Activity activity, Intent intent);
}
