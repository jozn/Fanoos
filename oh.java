import android.content.Context;
import android.support.v7.internal.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

public class oh extends ru implements oy {
    private Context a;
    private ActionBarContextView b;
    private rv c;
    private WeakReference d;
    private boolean e;
    private boolean f;
    private ox g;

    public oh(Context context, ActionBarContextView actionBarContextView, rv rvVar, boolean z) {
        this.a = context;
        this.b = actionBarContextView;
        this.c = rvVar;
        this.g = new ox(context).a(1);
        this.g.a((oy) this);
        this.f = z;
    }

    public void b(CharSequence charSequence) {
        this.b.setTitle(charSequence);
    }

    public void a(CharSequence charSequence) {
        this.b.setSubtitle(charSequence);
    }

    public void a(int i) {
        b(this.a.getString(i));
    }

    public void b(int i) {
        a(this.a.getString(i));
    }

    public void a(boolean z) {
        super.a(z);
        this.b.setTitleOptional(z);
    }

    public boolean h() {
        return this.b.d();
    }

    public void a(View view) {
        this.b.setCustomView(view);
        this.d = view != null ? new WeakReference(view) : null;
    }

    public void d() {
        this.c.b(this, this.g);
    }

    public void c() {
        if (!this.e) {
            this.e = true;
            this.b.sendAccessibilityEvent(32);
            this.c.a(this);
        }
    }

    public Menu b() {
        return this.g;
    }

    public CharSequence f() {
        return this.b.getTitle();
    }

    public CharSequence g() {
        return this.b.getSubtitle();
    }

    public View i() {
        return this.d != null ? (View) this.d.get() : null;
    }

    public MenuInflater a() {
        return new MenuInflater(this.a);
    }

    public boolean a(ox oxVar, MenuItem menuItem) {
        return this.c.a((ru) this, menuItem);
    }

    public void a(ox oxVar) {
        d();
        this.b.a();
    }
}
