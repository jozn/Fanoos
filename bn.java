import android.app.Notification;
import org.kxml2.wap.Wbxml;

class bn extends bm {
    bn() {
    }

    public Notification a(bh bhVar) {
        Notification notification = bhVar.B;
        notification.setLatestEventInfo(bhVar.a, bhVar.b, bhVar.c, bhVar.d);
        notification = ca.a(notification, bhVar.a, bhVar.b, bhVar.c, bhVar.d, bhVar.e);
        if (bhVar.j > 0) {
            notification.flags |= Wbxml.EXT_T_0;
        }
        return notification;
    }
}
