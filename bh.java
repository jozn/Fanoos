import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.widget.RemoteViews;
import java.util.ArrayList;

public class bh {
    Notification A;
    Notification B;
    public ArrayList C;
    Context a;
    CharSequence b;
    CharSequence c;
    PendingIntent d;
    PendingIntent e;
    RemoteViews f;
    Bitmap g;
    CharSequence h;
    int i;
    int j;
    boolean k;
    boolean l;
    bs m;
    CharSequence n;
    int o;
    int p;
    boolean q;
    String r;
    boolean s;
    String t;
    ArrayList u;
    boolean v;
    String w;
    Bundle x;
    int y;
    int z;

    public bh(Context context) {
        this.k = true;
        this.u = new ArrayList();
        this.v = false;
        this.y = 0;
        this.z = 0;
        this.B = new Notification();
        this.a = context;
        this.B.when = System.currentTimeMillis();
        this.B.audioStreamType = -1;
        this.j = 0;
        this.C = new ArrayList();
    }

    public bh a(int i) {
        this.B.icon = i;
        return this;
    }

    public bh a(CharSequence charSequence) {
        this.b = c(charSequence);
        return this;
    }

    public bh b(CharSequence charSequence) {
        this.c = c(charSequence);
        return this;
    }

    public bh a(PendingIntent pendingIntent) {
        this.d = pendingIntent;
        return this;
    }

    public bh a(Uri uri) {
        this.B.sound = uri;
        this.B.audioStreamType = -1;
        return this;
    }

    public bh a(boolean z) {
        a(16, z);
        return this;
    }

    private void a(int i, boolean z) {
        if (z) {
            Notification notification = this.B;
            notification.flags |= i;
            return;
        }
        notification = this.B;
        notification.flags &= i ^ -1;
    }

    public Notification a() {
        return bc.a.a(this);
    }

    protected static CharSequence c(CharSequence charSequence) {
        if (charSequence != null && charSequence.length() > 5120) {
            return charSequence.subSequence(0, 5120);
        }
        return charSequence;
    }
}
