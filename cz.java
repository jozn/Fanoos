import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

class cz {
    public static PendingIntent a(Context context, int i, Intent[] intentArr, int i2) {
        return PendingIntent.getActivities(context, i, intentArr, i2);
    }
}
