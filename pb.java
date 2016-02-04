import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug.CapturedViewProperty;
import android.widget.LinearLayout;
import org.kxml2.kdom.Node;
import org.xmlpull.v1.XmlPullParser;

public final class pb implements dy {
    private static String w;
    private static String x;
    private static String y;
    private static String z;
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private CharSequence e;
    private CharSequence f;
    private Intent g;
    private char h;
    private char i;
    private Drawable j;
    private int k;
    private ox l;
    private ps m;
    private Runnable n;
    private OnMenuItemClickListener o;
    private int p;
    private int q;
    private View r;
    private fs s;
    private gr t;
    private boolean u;
    private ContextMenuInfo v;

    public /* synthetic */ MenuItem setActionView(int i) {
        return a(i);
    }

    public /* synthetic */ MenuItem setActionView(View view) {
        return a(view);
    }

    public /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        return b(i);
    }

    pb(ox oxVar, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.k = 0;
        this.p = 16;
        this.q = 0;
        this.u = false;
        this.l = oxVar;
        this.a = i2;
        this.b = i;
        this.c = i3;
        this.d = i4;
        this.e = charSequence;
        this.q = i5;
    }

    public boolean b() {
        if ((this.o != null && this.o.onMenuItemClick(this)) || this.l.a(this.l.p(), (MenuItem) this)) {
            return true;
        }
        if (this.n != null) {
            this.n.run();
            return true;
        }
        if (this.g != null) {
            try {
                this.l.e().startActivity(this.g);
                return true;
            } catch (Throwable e) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
            }
        }
        if (this.s == null || !this.s.d()) {
            return false;
        }
        return true;
    }

    public boolean isEnabled() {
        return (this.p & 16) != 0;
    }

    public MenuItem setEnabled(boolean z) {
        if (z) {
            this.p |= 16;
        } else {
            this.p &= -17;
        }
        this.l.b(false);
        return this;
    }

    public int getGroupId() {
        return this.b;
    }

    @CapturedViewProperty
    public int getItemId() {
        return this.a;
    }

    public int getOrder() {
        return this.c;
    }

    public int c() {
        return this.d;
    }

    public Intent getIntent() {
        return this.g;
    }

    public MenuItem setIntent(Intent intent) {
        this.g = intent;
        return this;
    }

    public char getAlphabeticShortcut() {
        return this.i;
    }

    public MenuItem setAlphabeticShortcut(char c) {
        if (this.i != c) {
            this.i = Character.toLowerCase(c);
            this.l.b(false);
        }
        return this;
    }

    public char getNumericShortcut() {
        return this.h;
    }

    public MenuItem setNumericShortcut(char c) {
        if (this.h != c) {
            this.h = c;
            this.l.b(false);
        }
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.h = c;
        this.i = Character.toLowerCase(c2);
        this.l.b(false);
        return this;
    }

    public char d() {
        return this.l.b() ? this.i : this.h;
    }

    public String e() {
        char d = d();
        if (d == '\u0000') {
            return XmlPullParser.NO_NAMESPACE;
        }
        StringBuilder stringBuilder = new StringBuilder(w);
        switch (d) {
            case Node.PROCESSING_INSTRUCTION /*8*/:
                stringBuilder.append(y);
                break;
            case Node.DOCDECL /*10*/:
                stringBuilder.append(x);
                break;
            case nv.Theme_actionModeShareDrawable /*32*/:
                stringBuilder.append(z);
                break;
            default:
                stringBuilder.append(d);
                break;
        }
        return stringBuilder.toString();
    }

    public boolean f() {
        return this.l.c() && d() != '\u0000';
    }

    public SubMenu getSubMenu() {
        return this.m;
    }

    public boolean hasSubMenu() {
        return this.m != null;
    }

    void a(ps psVar) {
        this.m = psVar;
        psVar.setHeaderTitle(getTitle());
    }

    @CapturedViewProperty
    public CharSequence getTitle() {
        return this.e;
    }

    public CharSequence a(pp ppVar) {
        return (ppVar == null || !ppVar.a()) ? getTitle() : getTitleCondensed();
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.e = charSequence;
        this.l.b(false);
        if (this.m != null) {
            this.m.setHeaderTitle(charSequence);
        }
        return this;
    }

    public MenuItem setTitle(int i) {
        return setTitle(this.l.e().getString(i));
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f != null ? this.f : this.e;
        if (VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) {
            return charSequence;
        }
        return charSequence.toString();
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f = charSequence;
        if (charSequence == null) {
            CharSequence charSequence2 = this.e;
        }
        this.l.b(false);
        return this;
    }

    public Drawable getIcon() {
        if (this.j != null) {
            return this.j;
        }
        if (this.k == 0) {
            return null;
        }
        Drawable a = rk.a(this.l.e(), this.k);
        this.k = 0;
        this.j = a;
        return a;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.k = 0;
        this.j = drawable;
        this.l.b(false);
        return this;
    }

    public MenuItem setIcon(int i) {
        this.j = null;
        this.k = i;
        this.l.b(false);
        return this;
    }

    public boolean isCheckable() {
        return (this.p & 1) == 1;
    }

    public MenuItem setCheckable(boolean z) {
        int i = this.p;
        this.p = (z ? 1 : 0) | (this.p & -2);
        if (i != this.p) {
            this.l.b(false);
        }
        return this;
    }

    public void a(boolean z) {
        this.p = (z ? 4 : 0) | (this.p & -5);
    }

    public boolean g() {
        return (this.p & 4) != 0;
    }

    public boolean isChecked() {
        return (this.p & 2) == 2;
    }

    public MenuItem setChecked(boolean z) {
        if ((this.p & 4) != 0) {
            this.l.a((MenuItem) this);
        } else {
            b(z);
        }
        return this;
    }

    void b(boolean z) {
        int i;
        int i2 = this.p;
        int i3 = this.p & -3;
        if (z) {
            i = 2;
        } else {
            i = 0;
        }
        this.p = i | i3;
        if (i2 != this.p) {
            this.l.b(false);
        }
    }

    public boolean isVisible() {
        if (this.s == null || !this.s.b()) {
            if ((this.p & 8) != 0) {
                return false;
            }
            return true;
        } else if ((this.p & 8) == 0 && this.s.c()) {
            return true;
        } else {
            return false;
        }
    }

    boolean c(boolean z) {
        int i = this.p;
        this.p = (z ? 0 : 8) | (this.p & -9);
        if (i != this.p) {
            return true;
        }
        return false;
    }

    public MenuItem setVisible(boolean z) {
        if (c(z)) {
            this.l.a(this);
        }
        return this;
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.o = onMenuItemClickListener;
        return this;
    }

    public String toString() {
        return this.e.toString();
    }

    void a(ContextMenuInfo contextMenuInfo) {
        this.v = contextMenuInfo;
    }

    public ContextMenuInfo getMenuInfo() {
        return this.v;
    }

    public void h() {
        this.l.b(this);
    }

    public boolean i() {
        return this.l.q();
    }

    public boolean j() {
        return (this.p & 32) == 32;
    }

    public boolean k() {
        return (this.q & 1) == 1;
    }

    public boolean l() {
        return (this.q & 2) == 2;
    }

    public void d(boolean z) {
        if (z) {
            this.p |= 32;
        } else {
            this.p &= -33;
        }
    }

    public boolean m() {
        return (this.q & 4) == 4;
    }

    public void setShowAsAction(int i) {
        switch (i & 3) {
            case ve.CropImageView_guidelines /*0*/:
            case ve.CropImageView_fixAspectRatio /*1*/:
            case ve.CropImageView_aspectRatioX /*2*/:
                this.q = i;
                this.l.b(this);
            default:
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
    }

    public dy a(View view) {
        this.r = view;
        this.s = null;
        if (view != null && view.getId() == -1 && this.a > 0) {
            view.setId(this.a);
        }
        this.l.b(this);
        return this;
    }

    public dy a(int i) {
        Context e = this.l.e();
        a(LayoutInflater.from(e).inflate(i, new LinearLayout(e), false));
        return this;
    }

    public View getActionView() {
        if (this.r != null) {
            return this.r;
        }
        if (this.s == null) {
            return null;
        }
        this.r = this.s.a((MenuItem) this);
        return this.r;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public fs a() {
        return this.s;
    }

    public dy a(fs fsVar) {
        if (this.s != null) {
            this.s.a(null);
        }
        this.r = null;
        this.s = fsVar;
        this.l.b(true);
        if (this.s != null) {
            this.s.a(new pc(this));
        }
        return this;
    }

    public dy b(int i) {
        setShowAsAction(i);
        return this;
    }

    public boolean expandActionView() {
        if (!n()) {
            return false;
        }
        if (this.t == null || this.t.a(this)) {
            return this.l.c(this);
        }
        return false;
    }

    public boolean collapseActionView() {
        if ((this.q & 8) == 0) {
            return false;
        }
        if (this.r == null) {
            return true;
        }
        if (this.t == null || this.t.b(this)) {
            return this.l.d(this);
        }
        return false;
    }

    public dy a(gr grVar) {
        this.t = grVar;
        return this;
    }

    public boolean n() {
        if ((this.q & 8) == 0) {
            return false;
        }
        if (this.r == null && this.s != null) {
            this.r = this.s.a((MenuItem) this);
        }
        if (this.r != null) {
            return true;
        }
        return false;
    }

    public void e(boolean z) {
        this.u = z;
        this.l.b(false);
    }

    public boolean isActionViewExpanded() {
        return this.u;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setOnActionExpandListener()");
    }
}
