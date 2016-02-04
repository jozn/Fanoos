import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

class om {
    final /* synthetic */ ok a;
    private Menu b;
    private int c;
    private int d;
    private int e;
    private int f;
    private boolean g;
    private boolean h;
    private boolean i;
    private int j;
    private int k;
    private CharSequence l;
    private CharSequence m;
    private int n;
    private char o;
    private char p;
    private int q;
    private boolean r;
    private boolean s;
    private boolean t;
    private int u;
    private int v;
    private String w;
    private String x;
    private String y;
    private fs z;

    public om(ok okVar, Menu menu) {
        this.a = okVar;
        this.b = menu;
        a();
    }

    public void a() {
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = true;
        this.h = true;
    }

    public void a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.a.e.obtainStyledAttributes(attributeSet, nv.MenuGroup);
        this.c = obtainStyledAttributes.getResourceId(nv.MenuGroup_android_id, 0);
        this.d = obtainStyledAttributes.getInt(nv.MenuGroup_android_menuCategory, 0);
        this.e = obtainStyledAttributes.getInt(nv.MenuGroup_android_orderInCategory, 0);
        this.f = obtainStyledAttributes.getInt(nv.MenuGroup_android_checkableBehavior, 0);
        this.g = obtainStyledAttributes.getBoolean(nv.MenuGroup_android_visible, true);
        this.h = obtainStyledAttributes.getBoolean(nv.MenuGroup_android_enabled, true);
        obtainStyledAttributes.recycle();
    }

    public void b(AttributeSet attributeSet) {
        boolean z = true;
        TypedArray obtainStyledAttributes = this.a.e.obtainStyledAttributes(attributeSet, nv.MenuItem);
        this.j = obtainStyledAttributes.getResourceId(nv.MenuItem_android_id, 0);
        this.k = (obtainStyledAttributes.getInt(nv.MenuItem_android_menuCategory, this.d) & -65536) | (obtainStyledAttributes.getInt(nv.MenuItem_android_orderInCategory, this.e) & 65535);
        this.l = obtainStyledAttributes.getText(nv.MenuItem_android_title);
        this.m = obtainStyledAttributes.getText(nv.MenuItem_android_titleCondensed);
        this.n = obtainStyledAttributes.getResourceId(nv.MenuItem_android_icon, 0);
        this.o = a(obtainStyledAttributes.getString(nv.MenuItem_android_alphabeticShortcut));
        this.p = a(obtainStyledAttributes.getString(nv.MenuItem_android_numericShortcut));
        if (obtainStyledAttributes.hasValue(nv.MenuItem_android_checkable)) {
            this.q = obtainStyledAttributes.getBoolean(nv.MenuItem_android_checkable, false) ? 1 : 0;
        } else {
            this.q = this.f;
        }
        this.r = obtainStyledAttributes.getBoolean(nv.MenuItem_android_checked, false);
        this.s = obtainStyledAttributes.getBoolean(nv.MenuItem_android_visible, this.g);
        this.t = obtainStyledAttributes.getBoolean(nv.MenuItem_android_enabled, this.h);
        this.u = obtainStyledAttributes.getInt(nv.MenuItem_showAsAction, -1);
        this.y = obtainStyledAttributes.getString(nv.MenuItem_android_onClick);
        this.v = obtainStyledAttributes.getResourceId(nv.MenuItem_actionLayout, 0);
        this.w = obtainStyledAttributes.getString(nv.MenuItem_actionViewClass);
        this.x = obtainStyledAttributes.getString(nv.MenuItem_actionProviderClass);
        if (this.x == null) {
            z = false;
        }
        if (z && this.v == 0 && this.w == null) {
            this.z = (fs) a(this.x, ok.b, this.a.d);
        } else {
            if (z) {
                Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
            }
            this.z = null;
        }
        obtainStyledAttributes.recycle();
        this.i = false;
    }

    private char a(String str) {
        if (str == null) {
            return '\u0000';
        }
        return str.charAt(0);
    }

    private void a(MenuItem menuItem) {
        boolean z = true;
        menuItem.setChecked(this.r).setVisible(this.s).setEnabled(this.t).setCheckable(this.q >= 1).setTitleCondensed(this.m).setIcon(this.n).setAlphabeticShortcut(this.o).setNumericShortcut(this.p);
        if (this.u >= 0) {
            gm.a(menuItem, this.u);
        }
        if (this.y != null) {
            if (this.a.e.isRestricted()) {
                throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
            }
            menuItem.setOnMenuItemClickListener(new ol(this.a.c(), this.y));
        }
        if (menuItem instanceof pb) {
            pb pbVar = (pb) menuItem;
        }
        if (this.q >= 2) {
            if (menuItem instanceof pb) {
                ((pb) menuItem).a(true);
            } else if (menuItem instanceof pd) {
                ((pd) menuItem).a(true);
            }
        }
        if (this.w != null) {
            gm.a(menuItem, (View) a(this.w, ok.a, this.a.c));
        } else {
            z = false;
        }
        if (this.v > 0) {
            if (z) {
                Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
            } else {
                gm.b(menuItem, this.v);
            }
        }
        if (this.z != null) {
            gm.a(menuItem, this.z);
        }
    }

    public void b() {
        this.i = true;
        a(this.b.add(this.c, this.j, this.k, this.l));
    }

    public SubMenu c() {
        this.i = true;
        SubMenu addSubMenu = this.b.addSubMenu(this.c, this.j, this.k, this.l);
        a(addSubMenu.getItem());
        return addSubMenu;
    }

    public boolean d() {
        return this.i;
    }

    private Object a(String str, Class[] clsArr, Object[] objArr) {
        try {
            return this.a.e.getClassLoader().loadClass(str).getConstructor(clsArr).newInstance(objArr);
        } catch (Throwable e) {
            Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
            return null;
        }
    }
}
