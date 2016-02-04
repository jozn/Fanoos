import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

public class cu implements Iterable {
    private static final cw a;
    private final ArrayList b;
    private final Context c;

    static {
        if (VERSION.SDK_INT >= 11) {
            a = new cy();
        } else {
            a = new cx();
        }
    }

    private cu(Context context) {
        this.b = new ArrayList();
        this.c = context;
    }

    public static cu a(Context context) {
        return new cu(context);
    }

    public cu a(Intent intent) {
        this.b.add(intent);
        return this;
    }

    public cu a(Activity activity) {
        Intent a;
        Intent intent = null;
        if (activity instanceof cv) {
            intent = ((cv) activity).a();
        }
        if (intent == null) {
            a = au.a(activity);
        } else {
            a = intent;
        }
        if (a != null) {
            ComponentName component = a.getComponent();
            if (component == null) {
                component = a.resolveActivity(this.c.getPackageManager());
            }
            a(component);
            a(a);
        }
        return this;
    }

    public cu a(ComponentName componentName) {
        int size = this.b.size();
        try {
            Intent a = au.a(this.c, componentName);
            while (a != null) {
                this.b.add(size, a);
                a = au.a(this.c, a.getComponent());
            }
            return this;
        } catch (Throwable e) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    public Iterator iterator() {
        return this.b.iterator();
    }

    public void a() {
        a(null);
    }

    public void a(Bundle bundle) {
        if (this.b.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) this.b.toArray(new Intent[this.b.size()]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (!da.a(this.c, intentArr, bundle)) {
            Intent intent = new Intent(intentArr[intentArr.length - 1]);
            intent.addFlags(268435456);
            this.c.startActivity(intent);
        }
    }

    public PendingIntent a(int i, int i2) {
        return a(i, i2, null);
    }

    public PendingIntent a(int i, int i2, Bundle bundle) {
        if (this.b.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
        }
        Intent[] intentArr = (Intent[]) this.b.toArray(new Intent[this.b.size()]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        return a.a(this.c, intentArr, i, i2, bundle);
    }
}
