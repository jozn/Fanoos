import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyCharacterMap.KeyData;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ox implements dx {
    private static final int[] d;
    CharSequence a;
    Drawable b;
    View c;
    private final Context e;
    private final Resources f;
    private boolean g;
    private boolean h;
    private oy i;
    private ArrayList j;
    private ArrayList k;
    private boolean l;
    private ArrayList m;
    private ArrayList n;
    private boolean o;
    private int p;
    private ContextMenuInfo q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private ArrayList v;
    private CopyOnWriteArrayList w;
    private pb x;

    static {
        d = new int[]{1, 4, 5, 3, 2, 0};
    }

    public ox(Context context) {
        this.p = 0;
        this.r = false;
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = new ArrayList();
        this.w = new CopyOnWriteArrayList();
        this.e = context;
        this.f = context.getResources();
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.l = true;
        this.m = new ArrayList();
        this.n = new ArrayList();
        this.o = true;
        d(true);
    }

    public ox a(int i) {
        this.p = i;
        return this;
    }

    public void a(pm pmVar) {
        a(pmVar, this.e);
    }

    public void a(pm pmVar, Context context) {
        this.w.add(new WeakReference(pmVar));
        pmVar.a(context, this);
        this.o = true;
    }

    public void b(pm pmVar) {
        Iterator it = this.w.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            pm pmVar2 = (pm) weakReference.get();
            if (pmVar2 == null || pmVar2 == pmVar) {
                this.w.remove(weakReference);
            }
        }
    }

    private void c(boolean z) {
        if (!this.w.isEmpty()) {
            g();
            Iterator it = this.w.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                pm pmVar = (pm) weakReference.get();
                if (pmVar == null) {
                    this.w.remove(weakReference);
                } else {
                    pmVar.a(z);
                }
            }
            h();
        }
    }

    private boolean a(ps psVar, pm pmVar) {
        boolean z = false;
        if (this.w.isEmpty()) {
            return false;
        }
        if (pmVar != null) {
            z = pmVar.a(psVar);
        }
        Iterator it = this.w.iterator();
        boolean z2 = z;
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            pm pmVar2 = (pm) weakReference.get();
            if (pmVar2 == null) {
                this.w.remove(weakReference);
                z = z2;
            } else if (z2) {
                z = z2;
            } else {
                z = pmVar2.a(psVar);
            }
            z2 = z;
        }
        return z2;
    }

    public void a(Bundle bundle) {
        int size = size();
        int i = 0;
        SparseArray sparseArray = null;
        while (i < size) {
            MenuItem item = getItem(i);
            View a = gm.a(item);
            if (!(a == null || a.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                a.saveHierarchyState(sparseArray);
                if (gm.c(item)) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            SparseArray sparseArray2 = sparseArray;
            if (item.hasSubMenu()) {
                ((ps) item.getSubMenu()).a(bundle);
            }
            i++;
            sparseArray = sparseArray2;
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(a(), sparseArray);
        }
    }

    public void b(Bundle bundle) {
        if (bundle != null) {
            MenuItem item;
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(a());
            int size = size();
            for (int i = 0; i < size; i++) {
                item = getItem(i);
                View a = gm.a(item);
                if (!(a == null || a.getId() == -1)) {
                    a.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((ps) item.getSubMenu()).b(bundle);
                }
            }
            int i2 = bundle.getInt("android:menu:expandedactionview");
            if (i2 > 0) {
                item = findItem(i2);
                if (item != null) {
                    gm.b(item);
                }
            }
        }
    }

    protected String a() {
        return "android:menu:actionviewstates";
    }

    public void a(oy oyVar) {
        this.i = oyVar;
    }

    private MenuItem a(int i, int i2, int i3, CharSequence charSequence) {
        int d = d(i3);
        MenuItem a = a(i, i2, i3, d, charSequence, this.p);
        if (this.q != null) {
            a.a(this.q);
        }
        this.j.add(a(this.j, d), a);
        b(true);
        return a;
    }

    private pb a(int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        return new pb(this, i, i2, i3, i4, charSequence, i5);
    }

    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    public MenuItem add(int i) {
        return a(0, 0, 0, this.f.getString(i));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return a(i, i2, i3, charSequence);
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return a(i, i2, i3, this.f.getString(i4));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.f.getString(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        pb pbVar = (pb) a(i, i2, i3, charSequence);
        ps psVar = new ps(this.e, this, pbVar);
        pbVar.a(psVar);
        return psVar;
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.f.getString(i4));
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        PackageManager packageManager = this.e.getPackageManager();
        List queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i5 = 0; i5 < size; i5++) {
            Intent intent2;
            ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivityOptions.get(i5);
            if (resolveInfo.specificIndex < 0) {
                intent2 = intent;
            } else {
                intent2 = intentArr[resolveInfo.specificIndex];
            }
            Intent intent3 = new Intent(intent2);
            intent3.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent4 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent3);
            if (menuItemArr != null && resolveInfo.specificIndex >= 0) {
                menuItemArr[resolveInfo.specificIndex] = intent4;
            }
        }
        return size;
    }

    public void removeItem(int i) {
        a(b(i), true);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void removeGroup(int r6) {
        /*
        r5 = this;
        r1 = 0;
        r3 = r5.c(r6);
        if (r3 < 0) goto L_0x002b;
    L_0x0007:
        r0 = r5.j;
        r0 = r0.size();
        r4 = r0 - r3;
        r0 = r1;
    L_0x0010:
        r2 = r0 + 1;
        if (r0 >= r4) goto L_0x0027;
    L_0x0014:
        r0 = r5.j;
        r0 = r0.get(r3);
        r0 = (pb) r0;
        r0 = r0.getGroupId();
        if (r0 != r6) goto L_0x0027;
    L_0x0022:
        r5.a(r3, r1);
        r0 = r2;
        goto L_0x0010;
    L_0x0027:
        r0 = 1;
        r5.b(r0);
    L_0x002b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: ox.removeGroup(int):void");
    }

    private void a(int i, boolean z) {
        if (i >= 0 && i < this.j.size()) {
            this.j.remove(i);
            if (z) {
                b(true);
            }
        }
    }

    public void clear() {
        if (this.x != null) {
            d(this.x);
        }
        this.j.clear();
        b(true);
    }

    void a(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            MenuItem menuItem2 = (pb) this.j.get(i);
            if (menuItem2.getGroupId() == groupId && menuItem2.g() && menuItem2.isCheckable()) {
                menuItem2.b(menuItem2 == menuItem);
            }
        }
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.j.size();
        for (int i2 = 0; i2 < size; i2++) {
            pb pbVar = (pb) this.j.get(i2);
            if (pbVar.getGroupId() == i) {
                pbVar.a(z2);
                pbVar.setCheckable(z);
            }
        }
    }

    public void setGroupVisible(int i, boolean z) {
        int size = this.j.size();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < size) {
            boolean z3;
            pb pbVar = (pb) this.j.get(i2);
            if (pbVar.getGroupId() == i && pbVar.c(z)) {
                z3 = true;
            } else {
                z3 = z2;
            }
            i2++;
            z2 = z3;
        }
        if (z2) {
            b(true);
        }
    }

    public void setGroupEnabled(int i, boolean z) {
        int size = this.j.size();
        for (int i2 = 0; i2 < size; i2++) {
            pb pbVar = (pb) this.j.get(i2);
            if (pbVar.getGroupId() == i) {
                pbVar.setEnabled(z);
            }
        }
    }

    public boolean hasVisibleItems() {
        int size = size();
        for (int i = 0; i < size; i++) {
            if (((pb) this.j.get(i)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public MenuItem findItem(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            pb pbVar = (pb) this.j.get(i2);
            if (pbVar.getItemId() == i) {
                return pbVar;
            }
            if (pbVar.hasSubMenu()) {
                MenuItem findItem = pbVar.getSubMenu().findItem(i);
                if (findItem != null) {
                    return findItem;
                }
            }
        }
        return null;
    }

    public int b(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((pb) this.j.get(i2)).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    public int c(int i) {
        return a(i, 0);
    }

    public int a(int i, int i2) {
        int size = size();
        if (i2 < 0) {
            i2 = 0;
        }
        for (int i3 = i2; i3 < size; i3++) {
            if (((pb) this.j.get(i3)).getGroupId() == i) {
                return i3;
            }
        }
        return -1;
    }

    public int size() {
        return this.j.size();
    }

    public MenuItem getItem(int i) {
        return (MenuItem) this.j.get(i);
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return a(i, keyEvent) != null;
    }

    public void setQwertyMode(boolean z) {
        this.g = z;
        b(false);
    }

    private static int d(int i) {
        int i2 = (-65536 & i) >> 16;
        if (i2 >= 0 && i2 < d.length) {
            return (d[i2] << 16) | (65535 & i);
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    boolean b() {
        return this.g;
    }

    private void d(boolean z) {
        boolean z2 = true;
        if (!(z && this.f.getConfiguration().keyboard != 1 && this.f.getBoolean(nm.abc_config_showMenuShortcutsWhenKeyboardPresent))) {
            z2 = false;
        }
        this.h = z2;
    }

    public boolean c() {
        return this.h;
    }

    Resources d() {
        return this.f;
    }

    public Context e() {
        return this.e;
    }

    boolean a(ox oxVar, MenuItem menuItem) {
        return this.i != null && this.i.a(oxVar, menuItem);
    }

    public void f() {
        if (this.i != null) {
            this.i.a(this);
        }
    }

    private static int a(ArrayList arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((pb) arrayList.get(size)).c() <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        MenuItem a = a(i, keyEvent);
        boolean z = false;
        if (a != null) {
            z = a(a, i2);
        }
        if ((i2 & 2) != 0) {
            a(true);
        }
        return z;
    }

    void a(List list, int i, KeyEvent keyEvent) {
        boolean b = b();
        int metaState = keyEvent.getMetaState();
        KeyData keyData = new KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.j.size();
            for (int i2 = 0; i2 < size; i2++) {
                pb pbVar = (pb) this.j.get(i2);
                if (pbVar.hasSubMenu()) {
                    ((ox) pbVar.getSubMenu()).a(list, i, keyEvent);
                }
                char alphabeticShortcut = b ? pbVar.getAlphabeticShortcut() : pbVar.getNumericShortcut();
                if ((metaState & 5) == 0 && alphabeticShortcut != '\u0000' && ((alphabeticShortcut == keyData.meta[0] || alphabeticShortcut == keyData.meta[2] || (b && alphabeticShortcut == '\b' && i == 67)) && pbVar.isEnabled())) {
                    list.add(pbVar);
                }
            }
        }
    }

    pb a(int i, KeyEvent keyEvent) {
        List list = this.v;
        list.clear();
        a(list, i, keyEvent);
        if (list.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyData keyData = new KeyData();
        keyEvent.getKeyData(keyData);
        int size = list.size();
        if (size == 1) {
            return (pb) list.get(0);
        }
        boolean b = b();
        for (int i2 = 0; i2 < size; i2++) {
            pb pbVar = (pb) list.get(i2);
            char alphabeticShortcut = b ? pbVar.getAlphabeticShortcut() : pbVar.getNumericShortcut();
            if (alphabeticShortcut == keyData.meta[0] && (metaState & 2) == 0) {
                return pbVar;
            }
            if (alphabeticShortcut == keyData.meta[2] && (metaState & 2) != 0) {
                return pbVar;
            }
            if (b && alphabeticShortcut == '\b' && i == 67) {
                return pbVar;
            }
        }
        return null;
    }

    public boolean performIdentifierAction(int i, int i2) {
        return a(findItem(i), i2);
    }

    public boolean a(MenuItem menuItem, int i) {
        return a(menuItem, null, i);
    }

    public boolean a(MenuItem menuItem, pm pmVar, int i) {
        pb pbVar = (pb) menuItem;
        if (pbVar == null || !pbVar.isEnabled()) {
            return false;
        }
        boolean z;
        boolean b = pbVar.b();
        fs a = pbVar.a();
        if (a == null || !a.e()) {
            z = false;
        } else {
            z = true;
        }
        boolean expandActionView;
        if (pbVar.n()) {
            expandActionView = pbVar.expandActionView() | b;
            if (!expandActionView) {
                return expandActionView;
            }
            a(true);
            return expandActionView;
        } else if (pbVar.hasSubMenu() || z) {
            a(false);
            if (!pbVar.hasSubMenu()) {
                pbVar.a(new ps(e(), this, pbVar));
            }
            ps psVar = (ps) pbVar.getSubMenu();
            if (z) {
                a.a((SubMenu) psVar);
            }
            expandActionView = a(psVar, pmVar) | b;
            if (expandActionView) {
                return expandActionView;
            }
            a(true);
            return expandActionView;
        } else {
            if ((i & 1) == 0) {
                a(true);
            }
            return b;
        }
    }

    public final void a(boolean z) {
        if (!this.u) {
            this.u = true;
            Iterator it = this.w.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                pm pmVar = (pm) weakReference.get();
                if (pmVar == null) {
                    this.w.remove(weakReference);
                } else {
                    pmVar.a(this, z);
                }
            }
            this.u = false;
        }
    }

    public void close() {
        a(true);
    }

    public void b(boolean z) {
        if (this.r) {
            this.s = true;
            return;
        }
        if (z) {
            this.l = true;
            this.o = true;
        }
        c(z);
    }

    public void g() {
        if (!this.r) {
            this.r = true;
            this.s = false;
        }
    }

    public void h() {
        this.r = false;
        if (this.s) {
            this.s = false;
            b(true);
        }
    }

    void a(pb pbVar) {
        this.l = true;
        b(true);
    }

    void b(pb pbVar) {
        this.o = true;
        b(true);
    }

    public ArrayList i() {
        if (!this.l) {
            return this.k;
        }
        this.k.clear();
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            pb pbVar = (pb) this.j.get(i);
            if (pbVar.isVisible()) {
                this.k.add(pbVar);
            }
        }
        this.l = false;
        this.o = true;
        return this.k;
    }

    public void j() {
        ArrayList i = i();
        if (this.o) {
            Iterator it = this.w.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                int i3;
                WeakReference weakReference = (WeakReference) it.next();
                pm pmVar = (pm) weakReference.get();
                if (pmVar == null) {
                    this.w.remove(weakReference);
                    i3 = i2;
                } else {
                    i3 = pmVar.b() | i2;
                }
                i2 = i3;
            }
            if (i2 != 0) {
                this.m.clear();
                this.n.clear();
                i2 = i.size();
                for (int i4 = 0; i4 < i2; i4++) {
                    pb pbVar = (pb) i.get(i4);
                    if (pbVar.j()) {
                        this.m.add(pbVar);
                    } else {
                        this.n.add(pbVar);
                    }
                }
            } else {
                this.m.clear();
                this.n.clear();
                this.n.addAll(i());
            }
            this.o = false;
        }
    }

    public ArrayList k() {
        j();
        return this.m;
    }

    public ArrayList l() {
        j();
        return this.n;
    }

    public void clearHeader() {
        this.b = null;
        this.a = null;
        this.c = null;
        b(false);
    }

    private void a(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        Resources d = d();
        if (view != null) {
            this.c = view;
            this.a = null;
            this.b = null;
        } else {
            if (i > 0) {
                this.a = d.getText(i);
            } else if (charSequence != null) {
                this.a = charSequence;
            }
            if (i2 > 0) {
                this.b = da.a(e(), i2);
            } else if (drawable != null) {
                this.b = drawable;
            }
            this.c = null;
        }
        b(false);
    }

    protected ox a(CharSequence charSequence) {
        a(0, charSequence, 0, null, null);
        return this;
    }

    protected ox a(Drawable drawable) {
        a(0, null, 0, drawable, null);
        return this;
    }

    protected ox a(View view) {
        a(0, null, 0, null, view);
        return this;
    }

    public CharSequence m() {
        return this.a;
    }

    public Drawable n() {
        return this.b;
    }

    public View o() {
        return this.c;
    }

    public ox p() {
        return this;
    }

    boolean q() {
        return this.t;
    }

    public boolean c(pb pbVar) {
        boolean z = false;
        if (!this.w.isEmpty()) {
            g();
            Iterator it = this.w.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                pm pmVar = (pm) weakReference.get();
                if (pmVar == null) {
                    this.w.remove(weakReference);
                    z = z2;
                } else {
                    z = pmVar.a(this, pbVar);
                    if (z) {
                        break;
                    }
                }
                z2 = z;
            }
            z = z2;
            h();
            if (z) {
                this.x = pbVar;
            }
        }
        return z;
    }

    public boolean d(pb pbVar) {
        boolean z = false;
        if (!this.w.isEmpty() && this.x == pbVar) {
            g();
            Iterator it = this.w.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                pm pmVar = (pm) weakReference.get();
                if (pmVar == null) {
                    this.w.remove(weakReference);
                    z = z2;
                } else {
                    z = pmVar.b(this, pbVar);
                    if (z) {
                        break;
                    }
                }
                z2 = z;
            }
            z = z2;
            h();
            if (z) {
                this.x = null;
            }
        }
        return z;
    }

    public pb r() {
        return this.x;
    }
}
