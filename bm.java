import android.app.Notification;
import org.kxml2.wap.Wbxml;

class bm implements bj {
    bm() {
    }

    public Notification a(bh bhVar) {
        Notification notification = bhVar.B;
        notification.setLatestEventInfo(bhVar.a, bhVar.b, bhVar.c, bhVar.d);
        if (bhVar.j > 0) {
            notification.flags |= Wbxml.EXT_T_0;
        }
        return notification;
    }
}
