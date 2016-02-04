package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v7.internal.view.menu.ActionMenuItemView;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import fs;
import ft;
import java.util.ArrayList;
import nr;
import ns;
import of;
import og;
import os;
import ox;
import pb;
import pk;
import po;
import pp;
import ps;
import ry;
import rz;
import sa;
import sb;
import sd;
import se;
import sf;

public class ActionMenuPresenter extends os implements ft {
    public final se g;
    public int h;
    private View i;
    private boolean j;
    private boolean k;
    private int l;
    private int m;
    private int n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private int s;
    private final SparseBooleanArray t;
    private View u;
    private sd v;
    private ry w;
    private sa x;
    private rz y;

    public class SavedState implements Parcelable {
        public static final Creator CREATOR;
        public int a;

        SavedState() {
        }

        public SavedState(Parcel parcel) {
            this.a = parcel.readInt();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.a);
        }

        static {
            CREATOR = new sf();
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context, ns.abc_action_menu_layout, ns.abc_action_menu_item_layout);
        this.t = new SparseBooleanArray();
        this.g = new se();
    }

    public void a(Context context, ox oxVar) {
        super.a(context, oxVar);
        Resources resources = context.getResources();
        og a = og.a(context);
        if (!this.k) {
            this.j = a.b();
        }
        if (!this.q) {
            this.l = a.c();
        }
        if (!this.o) {
            this.n = a.a();
        }
        int i = this.l;
        if (this.j) {
            if (this.i == null) {
                this.i = new sb(this, this.a);
                int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
                this.i.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.i.getMeasuredWidth();
        } else {
            this.i = null;
        }
        this.m = i;
        this.s = (int) (56.0f * resources.getDisplayMetrics().density);
        this.u = null;
    }

    public void a(Configuration configuration) {
        if (!this.o) {
            this.n = this.b.getResources().getInteger(nr.abc_max_action_buttons);
        }
        if (this.c != null) {
            this.c.b(true);
        }
    }

    public void a(int i, boolean z) {
        this.l = i;
        this.p = z;
        this.q = true;
    }

    public void b(boolean z) {
        this.j = z;
        this.k = true;
    }

    public void b(int i) {
        this.n = i;
        this.o = true;
    }

    public void c(boolean z) {
        this.r = z;
    }

    public po a(ViewGroup viewGroup) {
        po a = super.a(viewGroup);
        ((ActionMenuView) a).setPresenter(this);
        return a;
    }

    public View a(pb pbVar, View view, ViewGroup viewGroup) {
        View actionView = pbVar.getActionView();
        if (actionView == null || pbVar.n()) {
            actionView = super.a(pbVar, view, viewGroup);
        }
        actionView.setVisibility(pbVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.a(layoutParams));
        }
        return actionView;
    }

    public void a(pb pbVar, pp ppVar) {
        ppVar.a(pbVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) ppVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f);
        if (this.y == null) {
            this.y = new rz();
        }
        actionMenuItemView.setPopupCallback(this.y);
    }

    public boolean a(int i, pb pbVar) {
        return pbVar.j();
    }

    public void a(boolean z) {
        int i;
        int i2 = 1;
        int i3 = 0;
        ViewGroup viewGroup = (ViewGroup) ((View) this.f).getParent();
        if (viewGroup != null) {
            of.a(viewGroup);
        }
        super.a(z);
        ((View) this.f).requestLayout();
        if (this.c != null) {
            ArrayList k = this.c.k();
            int size = k.size();
            for (i = 0; i < size; i++) {
                fs a = ((pb) k.get(i)).a();
                if (a != null) {
                    a.a((ft) this);
                }
            }
        }
        ArrayList l = this.c != null ? this.c.l() : null;
        if (this.j && l != null) {
            i = l.size();
            if (i == 1) {
                int i4;
                if (((pb) l.get(0)).isActionViewExpanded()) {
                    i4 = 0;
                } else {
                    i4 = 1;
                }
                i3 = i4;
            } else {
                if (i <= 0) {
                    i2 = 0;
                }
                i3 = i2;
            }
        }
        if (i3 != 0) {
            if (this.i == null) {
                this.i = new sb(this, this.a);
            }
            viewGroup = (ViewGroup) this.i.getParent();
            if (viewGroup != this.f) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.i);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f;
                actionMenuView.addView(this.i, actionMenuView.c());
            }
        } else if (this.i != null && this.i.getParent() == this.f) {
            ((ViewGroup) this.f).removeView(this.i);
        }
        ((ActionMenuView) this.f).setOverflowReserved(this.j);
    }

    public boolean a(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.i) {
            return false;
        }
        return super.a(viewGroup, i);
    }

    public boolean a(ps psVar) {
        if (!psVar.hasVisibleItems()) {
            return false;
        }
        ps psVar2 = psVar;
        while (psVar2.s() != this.c) {
            psVar2 = (ps) psVar2.s();
        }
        View a = a(psVar2.getItem());
        if (a == null) {
            if (this.i == null) {
                return false;
            }
            a = this.i;
        }
        this.h = psVar.getItem().getItemId();
        this.w = new ry(this, this.b, psVar);
        this.w.a(a);
        this.w.a();
        super.a(psVar);
        return true;
    }

    private View a(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof pp) && ((pp) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public boolean c() {
        if (!this.j || g() || this.c == null || this.f == null || this.x != null || this.c.l().isEmpty()) {
            return false;
        }
        this.x = new sa(this, new sd(this, this.b, this.c, this.i, true));
        ((View) this.f).post(this.x);
        super.a(null);
        return true;
    }

    public boolean d() {
        if (this.x == null || this.f == null) {
            pk pkVar = this.v;
            if (pkVar == null) {
                return false;
            }
            pkVar.e();
            return true;
        }
        ((View) this.f).removeCallbacks(this.x);
        this.x = null;
        return true;
    }

    public boolean e() {
        return d() | f();
    }

    public boolean f() {
        if (this.w == null) {
            return false;
        }
        this.w.e();
        return true;
    }

    public boolean g() {
        return this.v != null && this.v.f();
    }

    public boolean h() {
        return this.x != null || g();
    }

    public boolean b() {
        int i;
        ArrayList i2 = this.c.i();
        int size = i2.size();
        int i3 = this.n;
        int i4 = this.m;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.f;
        int i5 = 0;
        int i6 = 0;
        Object obj = null;
        int i7 = 0;
        while (i7 < size) {
            pb pbVar = (pb) i2.get(i7);
            if (pbVar.l()) {
                i5++;
            } else if (pbVar.k()) {
                i6++;
            } else {
                obj = 1;
            }
            if (this.r && pbVar.isActionViewExpanded()) {
                i = 0;
            } else {
                i = i3;
            }
            i7++;
            i3 = i;
        }
        if (this.j && (r4 != null || i5 + i6 > i3)) {
            i3--;
        }
        i7 = i3 - i5;
        SparseBooleanArray sparseBooleanArray = this.t;
        sparseBooleanArray.clear();
        i = 0;
        if (this.p) {
            i = i4 / this.s;
            i6 = ((i4 % this.s) / i) + this.s;
        } else {
            i6 = 0;
        }
        int i8 = 0;
        i3 = 0;
        int i9 = i;
        while (i8 < size) {
            pbVar = (pb) i2.get(i8);
            int i10;
            if (pbVar.l()) {
                View a = a(pbVar, this.u, viewGroup);
                if (this.u == null) {
                    this.u = a;
                }
                if (this.p) {
                    i9 -= ActionMenuView.a(a, i6, i9, makeMeasureSpec, 0);
                } else {
                    a.measure(makeMeasureSpec, makeMeasureSpec);
                }
                i5 = a.getMeasuredWidth();
                i10 = i4 - i5;
                if (i3 != 0) {
                    i5 = i3;
                }
                i3 = pbVar.getGroupId();
                if (i3 != 0) {
                    sparseBooleanArray.put(i3, true);
                }
                pbVar.d(true);
                i = i10;
                i3 = i7;
            } else if (pbVar.k()) {
                boolean z;
                int groupId = pbVar.getGroupId();
                boolean z2 = sparseBooleanArray.get(groupId);
                boolean z3 = (i7 > 0 || z2) && i4 > 0 && (!this.p || i9 > 0);
                if (z3) {
                    View a2 = a(pbVar, this.u, viewGroup);
                    if (this.u == null) {
                        this.u = a2;
                    }
                    boolean z4;
                    if (this.p) {
                        int a3 = ActionMenuView.a(a2, i6, i9, makeMeasureSpec, 0);
                        i10 = i9 - a3;
                        if (a3 == 0) {
                            i9 = 0;
                        } else {
                            z4 = z3;
                        }
                        i5 = i10;
                    } else {
                        a2.measure(makeMeasureSpec, makeMeasureSpec);
                        boolean z5 = z3;
                        i5 = i9;
                        z4 = z5;
                    }
                    i10 = a2.getMeasuredWidth();
                    i4 -= i10;
                    if (i3 == 0) {
                        i3 = i10;
                    }
                    if (this.p) {
                        z = i9 & (i4 >= 0 ? 1 : 0);
                        i10 = i3;
                        i3 = i5;
                    } else {
                        z = i9 & (i4 + i3 > 0 ? 1 : 0);
                        i10 = i3;
                        i3 = i5;
                    }
                } else {
                    z = z3;
                    i10 = i3;
                    i3 = i9;
                }
                if (z && groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                    i9 = i7;
                } else if (z2) {
                    sparseBooleanArray.put(groupId, false);
                    i5 = i7;
                    for (i7 = 0; i7 < i8; i7++) {
                        pb pbVar2 = (pb) i2.get(i7);
                        if (pbVar2.getGroupId() == groupId) {
                            if (pbVar2.j()) {
                                i5++;
                            }
                            pbVar2.d(false);
                        }
                    }
                    i9 = i5;
                } else {
                    i9 = i7;
                }
                if (z) {
                    i9--;
                }
                pbVar.d(z);
                i5 = i10;
                i = i4;
                int i11 = i3;
                i3 = i9;
                i9 = i11;
            } else {
                pbVar.d(false);
                i5 = i3;
                i = i4;
                i3 = i7;
            }
            i8++;
            i4 = i;
            i7 = i3;
            i3 = i5;
        }
        return true;
    }

    public void a(ox oxVar, boolean z) {
        e();
        super.a(oxVar, z);
    }

    public void a(ActionMenuView actionMenuView) {
        this.f = actionMenuView;
        actionMenuView.a(this.c);
    }
}
