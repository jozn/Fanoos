import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.List;

public final class tz {
    final ArrayList a;
    final ArrayList b;
    final /* synthetic */ RecyclerView c;
    private ArrayList d;
    private final List e;
    private int f;
    private ty g;
    private ug h;

    public void a() {
        this.a.clear();
        c();
    }

    public void a(int i) {
        this.f = i;
        for (int size = this.b.size() - 1; size >= 0 && this.b.size() > i; size--) {
            c(size);
        }
        while (this.b.size() > i) {
            this.b.remove(this.b.size() - 1);
        }
    }

    public List b() {
        return this.e;
    }

    boolean a(ui uiVar) {
        if (uiVar.p()) {
            return true;
        }
        if (uiVar.b < 0 || uiVar.b >= this.c.o.a()) {
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + uiVar);
        } else if (!this.c.f.a() && this.c.o.a(uiVar.b) != uiVar.f()) {
            return false;
        } else {
            if (!this.c.o.b() || uiVar.e() == this.c.o.b(uiVar.b)) {
                return true;
            }
            return false;
        }
    }

    public View b(int i) {
        return a(i, false);
    }

    View a(int i, boolean z) {
        boolean z2 = true;
        if (i < 0 || i >= this.c.f.e()) {
            throw new IndexOutOfBoundsException("Invalid item position " + i + "(" + i + "). Item count:" + this.c.f.e());
        }
        boolean z3;
        ui uiVar;
        boolean z4;
        int a;
        ui uiVar2;
        boolean z5;
        LayoutParams layoutParams;
        RecyclerView.LayoutParams layoutParams2;
        if (this.c.f.a()) {
            ui e = e(i);
            ui uiVar3 = e;
            z3 = e != null;
            uiVar = uiVar3;
        } else {
            uiVar = null;
            z3 = false;
        }
        if (uiVar == null) {
            uiVar = a(i, -1, z);
            if (uiVar != null) {
                if (a(uiVar)) {
                    z4 = true;
                } else {
                    if (!z) {
                        uiVar.a(4);
                        if (uiVar.g()) {
                            this.c.removeDetachedView(uiVar.a, false);
                            uiVar.h();
                        } else if (uiVar.i()) {
                            uiVar.j();
                        }
                        b(uiVar);
                    }
                    uiVar = null;
                    z4 = z3;
                }
                if (uiVar == null) {
                    a = this.c.b.a(i);
                    if (a >= 0 || a >= this.c.o.a()) {
                        throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + a + ")." + "state:" + this.c.f.e());
                    }
                    int a2 = this.c.o.a(a);
                    if (this.c.o.b()) {
                        uiVar = a(this.c.o.b(a), a2, z);
                        if (uiVar != null) {
                            uiVar.b = a;
                            z4 = true;
                        }
                    }
                    if (uiVar == null && this.h != null) {
                        View a3 = this.h.a(this, i, a2);
                        if (a3 != null) {
                            uiVar = this.c.a(a3);
                            if (uiVar == null) {
                                throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
                            } else if (uiVar.c()) {
                                throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                            }
                        }
                    }
                    if (uiVar == null) {
                        uiVar = f().a(this.c.o.a(a));
                        if (uiVar != null) {
                            uiVar.r();
                            if (RecyclerView.i) {
                                e(uiVar);
                            }
                        }
                    }
                    if (uiVar == null) {
                        uiVar = this.c.o.b(this.c, this.c.o.a(a));
                        z3 = z4;
                        uiVar2 = uiVar;
                        if (!this.c.f.a() && uiVar2.o()) {
                            uiVar2.f = i;
                            z5 = false;
                        } else if (uiVar2.o() || uiVar2.m() || uiVar2.l()) {
                            this.c.o.b(uiVar2, this.c.b.a(i));
                            d(uiVar2.a);
                            if (this.c.f.a()) {
                                uiVar2.f = i;
                            }
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        layoutParams = uiVar2.a.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams2 = (RecyclerView.LayoutParams) this.c.generateDefaultLayoutParams();
                            uiVar2.a.setLayoutParams(layoutParams2);
                        } else if (this.c.checkLayoutParams(layoutParams)) {
                            layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
                        } else {
                            layoutParams2 = (RecyclerView.LayoutParams) this.c.generateLayoutParams(layoutParams);
                            uiVar2.a.setLayoutParams(layoutParams2);
                        }
                        layoutParams2.a = uiVar2;
                        if (!(z3 && r5)) {
                            z2 = false;
                        }
                        layoutParams2.d = z2;
                        return uiVar2.a;
                    }
                }
                z3 = z4;
                uiVar2 = uiVar;
                if (!this.c.f.a()) {
                }
                if (uiVar2.o()) {
                }
                this.c.o.b(uiVar2, this.c.b.a(i));
                d(uiVar2.a);
                if (this.c.f.a()) {
                    uiVar2.f = i;
                }
                z5 = true;
                layoutParams = uiVar2.a.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams2 = (RecyclerView.LayoutParams) this.c.generateDefaultLayoutParams();
                    uiVar2.a.setLayoutParams(layoutParams2);
                } else if (this.c.checkLayoutParams(layoutParams)) {
                    layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
                } else {
                    layoutParams2 = (RecyclerView.LayoutParams) this.c.generateLayoutParams(layoutParams);
                    uiVar2.a.setLayoutParams(layoutParams2);
                }
                layoutParams2.a = uiVar2;
                z2 = false;
                layoutParams2.d = z2;
                return uiVar2.a;
            }
        }
        z4 = z3;
        if (uiVar == null) {
            a = this.c.b.a(i);
            if (a >= 0) {
            }
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + a + ")." + "state:" + this.c.f.e());
        }
        z3 = z4;
        uiVar2 = uiVar;
        if (!this.c.f.a()) {
        }
        if (uiVar2.o()) {
        }
        this.c.o.b(uiVar2, this.c.b.a(i));
        d(uiVar2.a);
        if (this.c.f.a()) {
            uiVar2.f = i;
        }
        z5 = true;
        layoutParams = uiVar2.a.getLayoutParams();
        if (layoutParams != null) {
            layoutParams2 = (RecyclerView.LayoutParams) this.c.generateDefaultLayoutParams();
            uiVar2.a.setLayoutParams(layoutParams2);
        } else if (this.c.checkLayoutParams(layoutParams)) {
            layoutParams2 = (RecyclerView.LayoutParams) this.c.generateLayoutParams(layoutParams);
            uiVar2.a.setLayoutParams(layoutParams2);
        } else {
            layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
        }
        layoutParams2.a = uiVar2;
        z2 = false;
        layoutParams2.d = z2;
        return uiVar2.a;
    }

    private void d(View view) {
        if (this.c.A != null && this.c.A.isEnabled()) {
            if (hg.e(view) == 0) {
                hg.c(view, 1);
            }
            if (!hg.b(view)) {
                hg.a(view, this.c.V.b());
            }
        }
    }

    private void e(ui uiVar) {
        if (uiVar.a instanceof ViewGroup) {
            a((ViewGroup) uiVar.a, false);
        }
    }

    private void a(ViewGroup viewGroup, boolean z) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt instanceof ViewGroup) {
                a((ViewGroup) childAt, true);
            }
        }
        if (!z) {
            return;
        }
        if (viewGroup.getVisibility() == 4) {
            viewGroup.setVisibility(0);
            viewGroup.setVisibility(4);
            return;
        }
        int visibility = viewGroup.getVisibility();
        viewGroup.setVisibility(4);
        viewGroup.setVisibility(visibility);
    }

    public void a(View view) {
        ui b = RecyclerView.b(view);
        if (b.q()) {
            this.c.removeDetachedView(view, false);
        }
        if (b.g()) {
            b.h();
        } else if (b.i()) {
            b.j();
        }
        b(b);
    }

    void c() {
        for (int size = this.b.size() - 1; size >= 0; size--) {
            c(size);
        }
        this.b.clear();
    }

    boolean c(int i) {
        ui uiVar = (ui) this.b.get(i);
        if (!uiVar.s()) {
            return false;
        }
        f().a(uiVar);
        d(uiVar);
        this.b.remove(i);
        return true;
    }

    void b(ui uiVar) {
        boolean z = true;
        boolean z2 = false;
        if (uiVar.g() || uiVar.a.getParent() != null) {
            StringBuilder append = new StringBuilder().append("Scrapped or attached views may not be recycled. isScrap:").append(uiVar.g()).append(" isAttached:");
            if (uiVar.a.getParent() == null) {
                z = false;
            }
            throw new IllegalArgumentException(append.append(z).toString());
        } else if (uiVar.q()) {
            throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + uiVar);
        } else if (uiVar.c()) {
            throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
        } else {
            if (uiVar.s()) {
                if (!uiVar.l() && ((this.c.f.j || !uiVar.p()) && !uiVar.n())) {
                    if (this.b.size() == this.f && !this.b.isEmpty()) {
                        int i = 0;
                        while (i < this.b.size() && !c(i)) {
                            i++;
                        }
                    }
                    if (this.b.size() < this.f) {
                        this.b.add(uiVar);
                        z2 = true;
                    }
                }
                if (!z2) {
                    f().a(uiVar);
                    d(uiVar);
                }
            }
            this.c.f.a(uiVar);
        }
    }

    void b(View view) {
        ui b = RecyclerView.b(view);
        b.k = null;
        b.j();
        b(b);
    }

    void c(View view) {
        ui b = RecyclerView.b(view);
        b.a(this);
        if (b.n() && this.c.s()) {
            if (this.d == null) {
                this.d = new ArrayList();
            }
            this.d.add(b);
        } else if (!b.l() || b.p() || this.c.o.b()) {
            this.a.add(b);
        } else {
            throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
        }
    }

    public void c(ui uiVar) {
        if (uiVar.n() && this.c.s() && this.d != null) {
            this.d.remove(uiVar);
        } else {
            this.a.remove(uiVar);
        }
        uiVar.k = null;
        uiVar.j();
    }

    int d() {
        return this.a.size();
    }

    View d(int i) {
        return ((ui) this.a.get(i)).a;
    }

    void e() {
        this.a.clear();
    }

    ui e(int i) {
        int i2 = 0;
        if (this.d != null) {
            int size = this.d.size();
            if (size != 0) {
                ui uiVar;
                int i3 = 0;
                while (i3 < size) {
                    uiVar = (ui) this.d.get(i3);
                    if (uiVar.i() || uiVar.d() != i) {
                        i3++;
                    } else {
                        uiVar.a(32);
                        return uiVar;
                    }
                }
                if (this.c.o.b()) {
                    int a = this.c.b.a(i);
                    if (a > 0 && a < this.c.o.a()) {
                        long b = this.c.o.b(a);
                        while (i2 < size) {
                            uiVar = (ui) this.d.get(i2);
                            if (uiVar.i() || uiVar.e() != b) {
                                i2++;
                            } else {
                                uiVar.a(32);
                                return uiVar;
                            }
                        }
                    }
                }
                return null;
            }
        }
        return null;
    }

    ui a(int i, int i2, boolean z) {
        View a;
        int i3 = 0;
        int size = this.a.size();
        int i4 = 0;
        while (i4 < size) {
            ui uiVar = (ui) this.a.get(i4);
            if (uiVar.i() || uiVar.d() != i || uiVar.l() || (!this.c.f.j && uiVar.p())) {
                i4++;
            } else if (i2 == -1 || uiVar.f() == i2) {
                uiVar.a(32);
                return uiVar;
            } else {
                Log.e("RecyclerView", "Scrap view for position " + i + " isn't dirty but has" + " wrong view type! (found " + uiVar.f() + " but expected " + i2 + ")");
                if (!z) {
                    a = this.c.c.a(i, i2);
                    if (a != null) {
                        this.c.e.c(this.c.a(a));
                    }
                }
                i4 = this.b.size();
                while (i3 < i4) {
                    uiVar = (ui) this.b.get(i3);
                    if (uiVar.l() || uiVar.d() != i) {
                        i3++;
                    } else if (z) {
                        return uiVar;
                    } else {
                        this.b.remove(i3);
                        return uiVar;
                    }
                }
                return null;
            }
        }
        if (z) {
            a = this.c.c.a(i, i2);
            if (a != null) {
                this.c.e.c(this.c.a(a));
            }
        }
        i4 = this.b.size();
        while (i3 < i4) {
            uiVar = (ui) this.b.get(i3);
            if (uiVar.l()) {
            }
            i3++;
        }
        return null;
    }

    ui a(long j, int i, boolean z) {
        int size;
        for (size = this.a.size() - 1; size >= 0; size--) {
            ui uiVar = (ui) this.a.get(size);
            if (uiVar.e() == j && !uiVar.i()) {
                if (i == uiVar.f()) {
                    uiVar.a(32);
                    if (!uiVar.p() || this.c.f.a()) {
                        return uiVar;
                    }
                    uiVar.a(2, 14);
                    return uiVar;
                } else if (!z) {
                    this.a.remove(size);
                    this.c.removeDetachedView(uiVar.a, false);
                    b(uiVar.a);
                }
            }
        }
        for (size = this.b.size() - 1; size >= 0; size--) {
            uiVar = (ui) this.b.get(size);
            if (uiVar.e() == j) {
                if (i == uiVar.f()) {
                    if (z) {
                        return uiVar;
                    }
                    this.b.remove(size);
                    return uiVar;
                } else if (!z) {
                    c(size);
                }
            }
        }
        return null;
    }

    void d(ui uiVar) {
        if (this.c.q != null) {
            this.c.q.a(uiVar);
        }
        if (this.c.o != null) {
            this.c.o.a(uiVar);
        }
        if (this.c.f != null) {
            this.c.f.a(uiVar);
        }
    }

    public void a(to toVar, to toVar2, boolean z) {
        a();
        f().a(toVar, toVar2, z);
    }

    public void a(ug ugVar) {
        this.h = ugVar;
    }

    public void a(ty tyVar) {
        if (this.g != null) {
            this.g.b();
        }
        this.g = tyVar;
        if (tyVar != null) {
            this.g.a(this.c.getAdapter());
        }
    }

    public ty f() {
        if (this.g == null) {
            this.g = new ty();
        }
        return this.g;
    }

    public void g() {
        int size;
        if (this.c.o == null || !this.c.o.b()) {
            for (size = this.b.size() - 1; size >= 0; size--) {
                if (!c(size)) {
                    ((ui) this.b.get(size)).a(6);
                }
            }
            return;
        }
        int size2 = this.b.size();
        for (size = 0; size < size2; size++) {
            ui uiVar = (ui) this.b.get(size);
            if (uiVar != null) {
                uiVar.a(6);
            }
        }
    }

    public void h() {
        int i;
        int i2 = 0;
        int size = this.b.size();
        for (i = 0; i < size; i++) {
            ((ui) this.b.get(i)).a();
        }
        size = this.a.size();
        for (i = 0; i < size; i++) {
            ((ui) this.a.get(i)).a();
        }
        if (this.d != null) {
            i = this.d.size();
            while (i2 < i) {
                ((ui) this.d.get(i2)).a();
                i2++;
            }
        }
    }

    public void i() {
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) ((ui) this.b.get(i)).a.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.c = true;
            }
        }
    }
}
