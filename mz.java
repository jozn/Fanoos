import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarActivityDelegateBase;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public abstract class mz {
    public final ActionBarActivity a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    final nx f;
    private ActionBar g;
    private MenuInflater h;
    private nx i;
    private boolean j;

    public abstract ActionBar a();

    public abstract View a(String str, Context context, AttributeSet attributeSet);

    public abstract ru a(rv rvVar);

    public abstract void a(int i);

    public abstract void a(int i, Menu menu);

    public abstract void a(Configuration configuration);

    public abstract void a(View view);

    public abstract void a(View view, LayoutParams layoutParams);

    public abstract void a(CharSequence charSequence);

    public abstract boolean a(int i, View view, Menu menu);

    public abstract View b(int i);

    public abstract void b(View view, LayoutParams layoutParams);

    public abstract boolean b(int i, KeyEvent keyEvent);

    public abstract boolean b(int i, Menu menu);

    public abstract boolean c(int i, Menu menu);

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public abstract boolean h();

    public abstract void i();

    public static mz a(ActionBarActivity actionBarActivity) {
        if (VERSION.SDK_INT >= 11) {
            return new nj(actionBarActivity);
        }
        return new ActionBarActivityDelegateBase(actionBarActivity);
    }

    public mz(ActionBarActivity actionBarActivity) {
        this.f = new na(this);
        this.a = actionBarActivity;
        this.i = this.f;
    }

    public final ActionBar b() {
        if (this.b && this.g == null) {
            this.g = a();
        }
        return this.g;
    }

    public final ActionBar c() {
        return this.g;
    }

    public MenuInflater d() {
        if (this.h == null) {
            this.h = new ok(j());
        }
        return this.h;
    }

    public void a(Bundle bundle) {
        TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(nv.Theme);
        if (obtainStyledAttributes.hasValue(nv.Theme_windowActionBar)) {
            if (obtainStyledAttributes.getBoolean(nv.Theme_windowActionBar, false)) {
                this.b = true;
            }
            if (obtainStyledAttributes.getBoolean(nv.Theme_windowActionBarOverlay, false)) {
                this.c = true;
            }
            if (obtainStyledAttributes.getBoolean(nv.Theme_windowActionModeOverlay, false)) {
                this.d = true;
            }
            this.e = obtainStyledAttributes.getBoolean(nv.Theme_android_windowIsFloating, false);
            obtainStyledAttributes.recycle();
            return;
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    public boolean a(View view, Menu menu) {
        if (VERSION.SDK_INT < 16) {
            return this.a.onPrepareOptionsMenu(menu);
        }
        return this.a.b(view, menu);
    }

    public boolean a(int i, KeyEvent keyEvent) {
        return false;
    }

    public final Context j() {
        Context context = null;
        ActionBar b = b();
        if (b != null) {
            context = b.d();
        }
        if (context == null) {
            return this.a;
        }
        return context;
    }

    public final nx k() {
        return this.i;
    }

    public final void l() {
        this.j = true;
    }

    public final boolean m() {
        return this.j;
    }
}
