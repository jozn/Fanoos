import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;
import org.kxml2.wap.Wbxml;

public class bw implements ba, bb {
    private Builder a;

    public bw(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, String str, ArrayList arrayList, Bundle bundle, int i5, int i6, Notification notification2, String str2, boolean z5, String str3) {
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
        this.a = lights.setFullScreenIntent(pendingIntent2, z6).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z).setLocalOnly(z4).setExtras(bundle).setGroup(str2).setGroupSummary(z5).setSortKey(str3).setCategory(str).setColor(i5).setVisibility(i6).setPublicVersion(notification2);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.a.addPerson((String) it.next());
        }
    }

    public void a(by byVar) {
        bt.a(this.a, byVar);
    }

    public Builder a() {
        return this.a;
    }

    public Notification b() {
        return this.a.build();
    }
}
