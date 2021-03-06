import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.RemoteViews;
import java.util.ArrayList;
import org.kxml2.wap.Wbxml;

public class bu implements ba, bb {
    private Builder a;
    private Bundle b;

    public bu(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, ArrayList arrayList, Bundle bundle, String str, boolean z5, String str2) {
        boolean z6;
        Builder lights = new Builder(context).setWhen(notification.when).setShowWhen(z2).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS);
        if ((notification.flags & 2) != 0) {
            z6 = true;
        } else {
            z6 = false;
        }
        lights = lights.setOngoing(z6);
        if ((notification.flags & 8) != 0) {
            z6 = true;
        } else {
            z6 = false;
        }
        lights = lights.setOnlyAlertOnce(z6);
        if ((notification.flags & 16) != 0) {
            z6 = true;
        } else {
            z6 = false;
        }
        lights = lights.setAutoCancel(z6).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent);
        if ((notification.flags & Wbxml.EXT_T_0) != 0) {
            z6 = true;
        } else {
            z6 = false;
        }
        this.a = lights.setFullScreenIntent(pendingIntent2, z6).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z).setLocalOnly(z4).setGroup(str).setGroupSummary(z5).setSortKey(str2);
        this.b = new Bundle();
        if (bundle != null) {
            this.b.putAll(bundle);
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            this.b.putStringArray("android.people", (String[]) arrayList.toArray(new String[arrayList.size()]));
        }
    }

    public void a(by byVar) {
        bt.a(this.a, byVar);
    }

    public Builder a() {
        return this.a;
    }

    public Notification b() {
        this.a.setExtras(this.b);
        return this.a.build();
    }
}
