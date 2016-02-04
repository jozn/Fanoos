import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

public class im extends ff {
    final /* synthetic */ ViewPager b;

    public im(ViewPager viewPager) {
        this.b = viewPager;
    }

    public void d(View view, AccessibilityEvent accessibilityEvent) {
        super.d(view, accessibilityEvent);
        accessibilityEvent.setClassName(ViewPager.class.getName());
        kt a = kt.a();
        a.a(b());
        if (accessibilityEvent.getEventType() == 4096 && this.b.h != null) {
            a.a(this.b.h.b());
            a.b(this.b.i);
            a.c(this.b.i);
        }
    }

    public void a(View view, jt jtVar) {
        super.a(view, jtVar);
        jtVar.a(ViewPager.class.getName());
        jtVar.a(b());
        if (this.b.canScrollHorizontally(1)) {
            jtVar.a(4096);
        }
        if (this.b.canScrollHorizontally(-1)) {
            jtVar.a(8192);
        }
    }

    public boolean a(View view, int i, Bundle bundle) {
        if (super.a(view, i, bundle)) {
            return true;
        }
        switch (i) {
            case 4096:
                if (!this.b.canScrollHorizontally(1)) {
                    return false;
                }
                this.b.setCurrentItem(this.b.i + 1);
                return true;
            case 8192:
                if (!this.b.canScrollHorizontally(-1)) {
                    return false;
                }
                this.b.setCurrentItem(this.b.i - 1);
                return true;
            default:
                return false;
        }
    }

    private boolean b() {
        return this.b.h != null && this.b.h.b() > 1;
    }
}
