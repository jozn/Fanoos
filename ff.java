import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

public class ff {
    private static final fi b;
    private static final Object c;
    final Object a;

    static {
        if (VERSION.SDK_INT >= 16) {
            b = new fj();
        } else if (VERSION.SDK_INT >= 14) {
            b = new fg();
        } else {
            b = new fl();
        }
        c = b.a();
    }

    public ff() {
        this.a = b.a(this);
    }

    Object a() {
        return this.a;
    }

    public void a(View view, int i) {
        b.a(c, view, i);
    }

    public void a(View view, AccessibilityEvent accessibilityEvent) {
        b.d(c, view, accessibilityEvent);
    }

    public boolean b(View view, AccessibilityEvent accessibilityEvent) {
        return b.a(c, view, accessibilityEvent);
    }

    public void c(View view, AccessibilityEvent accessibilityEvent) {
        b.c(c, view, accessibilityEvent);
    }

    public void d(View view, AccessibilityEvent accessibilityEvent) {
        b.b(c, view, accessibilityEvent);
    }

    public void a(View view, jt jtVar) {
        b.a(c, view, jtVar);
    }

    public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return b.a(c, viewGroup, view, accessibilityEvent);
    }

    public kg a(View view) {
        return b.a(c, view);
    }

    public boolean a(View view, int i, Bundle bundle) {
        return b.a(c, view, i, bundle);
    }
}
