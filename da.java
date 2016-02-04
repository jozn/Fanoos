import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;

public class da {
    public static boolean a(Context context, Intent[] intentArr, Bundle bundle) {
        int i = VERSION.SDK_INT;
        if (i >= 16) {
            dd.a(context, intentArr, bundle);
            return true;
        } else if (i < 11) {
            return false;
        } else {
            dc.a(context, intentArr);
            return true;
        }
    }

    public static final Drawable a(Context context, int i) {
        if (VERSION.SDK_INT >= 21) {
            return db.a(context, i);
        }
        return context.getResources().getDrawable(i);
    }
}
