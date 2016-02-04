import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.ListPopupWindow;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;

public class pk implements OnKeyListener, OnGlobalLayoutListener, OnItemClickListener, OnDismissListener, pm {
    static final int a;
    boolean b;
    private final Context c;
    private final LayoutInflater d;
    private final ox e;
    private final pl f;
    private final boolean g;
    private final int h;
    private final int i;
    private final int j;
    private View k;
    private ListPopupWindow l;
    private ViewTreeObserver m;
    private pn n;
    private ViewGroup o;
    private boolean p;
    private int q;
    private int r;

    static {
        a = ns.abc_popup_menu_item_layout;
    }

    public pk(Context context, ox oxVar, View view) {
        this(context, oxVar, view, false, nl.popupMenuStyle);
    }

    public pk(Context context, ox oxVar, View view, boolean z, int i) {
        this(context, oxVar, view, z, i, 0);
    }

    public pk(Context context, ox oxVar, View view, boolean z, int i, int i2) {
        this.r = 0;
        this.c = context;
        this.d = LayoutInflater.from(context);
        this.e = oxVar;
        this.f = new pl(this, this.e);
        this.g = z;
        this.i = i;
        this.j = i2;
        Resources resources = context.getResources();
        this.h = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(no.abc_config_prefDialogWidth));
        this.k = view;
        oxVar.a((pm) this, context);
    }

    public void a(View view) {
        this.k = view;
    }

    public void b(boolean z) {
        this.b = z;
    }

    public void a(int i) {
        this.r = i;
    }

    public void a() {
        if (!d()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public ListPopupWindow c() {
        return this.l;
    }

    public boolean d() {
        boolean z = false;
        this.l = new ListPopupWindow(this.c, null, this.i, this.j);
        this.l.a((OnDismissListener) this);
        this.l.a((OnItemClickListener) this);
        this.l.a(this.f);
        this.l.a(true);
        View view = this.k;
        if (view == null) {
            return false;
        }
        if (this.m == null) {
            z = true;
        }
        this.m = view.getViewTreeObserver();
        if (z) {
            this.m.addOnGlobalLayoutListener(this);
        }
        this.l.a(view);
        this.l.b(this.r);
        if (!this.p) {
            this.q = g();
            this.p = true;
        }
        this.l.d(this.q);
        this.l.e(2);
        this.l.c();
        this.l.g().setOnKeyListener(this);
        return true;
    }

    public void e() {
        if (f()) {
            this.l.a();
        }
    }

    public void onDismiss() {
        this.l = null;
        this.e.close();
        if (this.m != null) {
            if (!this.m.isAlive()) {
                this.m = this.k.getViewTreeObserver();
            }
            this.m.removeGlobalOnLayoutListener(this);
            this.m = null;
        }
    }

    public boolean f() {
        return this.l != null && this.l.b();
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        pl plVar = this.f;
        plVar.b.a(plVar.a(i), 0);
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        e();
        return true;
    }

    private int g() {
        ListAdapter listAdapter = this.f;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i = 0;
        int i2 = 0;
        View view = null;
        int i3 = 0;
        while (i < count) {
            View view2;
            int itemViewType = listAdapter.getItemViewType(i);
            if (itemViewType != i2) {
                i2 = itemViewType;
                view2 = null;
            } else {
                view2 = view;
            }
            if (this.o == null) {
                this.o = new FrameLayout(this.c);
            }
            view = listAdapter.getView(i, view2, this.o);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            itemViewType = view.getMeasuredWidth();
            if (itemViewType >= this.h) {
                return this.h;
            }
            if (itemViewType <= i3) {
                itemViewType = i3;
            }
            i++;
            i3 = itemViewType;
        }
        return i3;
    }

    public void onGlobalLayout() {
        if (f()) {
            View view = this.k;
            if (view == null || !view.isShown()) {
                e();
            } else if (f()) {
                this.l.c();
            }
        }
    }

    public void a(Context context, ox oxVar) {
    }

    public void a(boolean z) {
        this.p = false;
        if (this.f != null) {
            this.f.notifyDataSetChanged();
        }
    }

    public void a(pn pnVar) {
        this.n = pnVar;
    }

    public boolean a(ps psVar) {
        if (psVar.hasVisibleItems()) {
            boolean z;
            pk pkVar = new pk(this.c, psVar, this.k);
            pkVar.a(this.n);
            int size = psVar.size();
            for (int i = 0; i < size; i++) {
                MenuItem item = psVar.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
            }
            z = false;
            pkVar.b(z);
            if (pkVar.d()) {
                if (this.n == null) {
                    return true;
                }
                this.n.a(psVar);
                return true;
            }
        }
        return false;
    }

    public void a(ox oxVar, boolean z) {
        if (oxVar == this.e) {
            e();
            if (this.n != null) {
                this.n.a(oxVar, z);
            }
        }
    }

    public boolean b() {
        return false;
    }

    public boolean a(ox oxVar, pb pbVar) {
        return false;
    }

    public boolean b(ox oxVar, pb pbVar) {
        return false;
    }
}
