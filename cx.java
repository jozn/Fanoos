import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

class cx implements cw {
    cx() {
    }

    public PendingIntent a(Context context, Intent[] intentArr, int i, int i2, Bundle bundle) {
        Intent intent = new Intent(intentArr[intentArr.length - 1]);
        intent.addFlags(268435456);
        return PendingIntent.getActivity(context, i, intent, i2);
    }
}
