import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import ir.seraj.fanoos.Activity.ChatsActivity;
import ir.seraj.fanoos3.R;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class aep {
    public void a(Context context, Class cls, String str, String str2, HashMap hashMap) {
        if (!aeq.f(context).booleanValue()) {
            Intent intent = new Intent(context, cls);
            Iterator it = hashMap.entrySet().iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                intent.putExtra((String) entry.getKey(), (String) entry.getValue());
                it.remove();
            }
            cu a = cu.a(context);
            a.a(new Intent(context, ChatsActivity.class));
            a.a(intent);
            PendingIntent a2 = a.a(0, 1073741824);
            ((NotificationManager) context.getSystemService("notification")).notify(1, new bh(context).a((int) R.drawable.ic_launcher).a((CharSequence) str).a(a2).b(str2).a(true).a(RingtoneManager.getDefaultUri(2)).a());
        }
    }
}
