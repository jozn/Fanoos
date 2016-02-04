import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

public class oc extends ru implements oy {
    final /* synthetic */ ny a;
    private rv b;
    private ox c;
    private WeakReference d;

    public oc(ny nyVar, rv rvVar) {
        this.a = nyVar;
        this.b = rvVar;
        this.c = new ox(nyVar.d()).a(1);
        this.c.a((oy) this);
    }

    public MenuInflater a() {
        return new ok(this.a.d());
    }

    public Menu b() {
        return this.c;
    }

    public void c() {
        if (this.a.a == this) {
            if (ny.b(this.a.D, this.a.E, false)) {
                this.b.a(this);
            } else {
                this.a.b = this;
                this.a.c = this.b;
            }
            this.b = null;
            this.a.j(false);
            this.a.p.b();
            this.a.o.a().sendAccessibilityEvent(32);
            this.a.m.setHideOnContentScrollEnabled(this.a.d);
            this.a.a = null;
        }
    }

    public void d() {
        this.c.g();
        try {
            this.b.b(this, this.c);
        } finally {
            this.c.h();
        }
    }

    public boolean e() {
        this.c.g();
        try {
            boolean a = this.b.a((ru) this, this.c);
            return a;
        } finally {
            this.c.h();
        }
    }

    public void a(View view) {
        this.a.p.setCustomView(view);
        this.d = new WeakReference(view);
    }

    public void a(CharSequence charSequence) {
        this.a.p.setSubtitle(charSequence);
    }

    public void b(CharSequence charSequence) {
        this.a.p.setTitle(charSequence);
    }

    public void a(int i) {
        b(this.a.j.getResources().getString(i));
    }

    public void b(int i) {
        a(this.a.j.getResources().getString(i));
    }

    public CharSequence f() {
        return this.a.p.getTitle();
    }

    public CharSequence g() {
        return this.a.p.getSubtitle();
    }

    public void a(boolean z) {
        super.a(z);
        this.a.p.setTitleOptional(z);
    }

    public boolean h() {
        return this.a.p.d();
    }

    public View i() {
        return this.d != null ? (View) this.d.get() : null;
    }

    public boolean a(ox oxVar, MenuItem menuItem) {
        if (this.b != null) {
            return this.b.a((ru) this, menuItem);
        }
        return false;
    }

    public void a(ox oxVar) {
        if (this.b != null) {
            d();
            this.a.p.a();
        }
    }
}
