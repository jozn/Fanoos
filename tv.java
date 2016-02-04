import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;

public abstract class tv {
    private boolean a;
    so h;
    public RecyclerView i;
    ud j;

    public abstract LayoutParams a();

    public tv() {
        this.a = false;
    }

    public void a(RecyclerView recyclerView) {
        if (recyclerView == null) {
            this.i = null;
            this.h = null;
            return;
        }
        this.i = recyclerView;
        this.h = recyclerView.c;
    }

    public void j() {
        if (this.i != null) {
            this.i.requestLayout();
        }
    }

    public void a(String str) {
        if (this.i != null) {
            this.i.a(str);
        }
    }

    public boolean i() {
        return false;
    }

    public void b(RecyclerView recyclerView) {
    }

    @Deprecated
    public void c(RecyclerView recyclerView) {
    }

    public void a(RecyclerView recyclerView, tz tzVar) {
        c(recyclerView);
    }

    public void a(tz tzVar, uf ufVar) {
        Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
    }

    public boolean a(LayoutParams layoutParams) {
        return layoutParams != null;
    }

    public LayoutParams a(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof MarginLayoutParams) {
            return new LayoutParams((MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public LayoutParams a(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public int a(int i, tz tzVar, uf ufVar) {
        return 0;
    }

    public int b(int i, tz tzVar, uf ufVar) {
        return 0;
    }

    public boolean c() {
        return false;
    }

    public boolean d() {
        return false;
    }

    public boolean k() {
        return this.j != null && this.j.c();
    }

    public int l() {
        return hg.g(this.i);
    }

    public void a(View view) {
        a(view, -1);
    }

    public void a(View view, int i) {
        a(view, i, true);
    }

    public void b(View view) {
        b(view, -1);
    }

    public void b(View view, int i) {
        a(view, i, false);
    }

    private void a(View view, int i, boolean z) {
        ui b = RecyclerView.b(view);
        if (z || b.p()) {
            this.i.h(view);
        } else {
            this.i.g(view);
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (b.i() || b.g()) {
            if (b.g()) {
                b.h();
            } else {
                b.j();
            }
            this.h.a(view, i, view.getLayoutParams(), false);
        } else if (view.getParent() == this.i) {
            int b2 = this.h.b(view);
            if (i == -1) {
                i = this.h.b();
            }
            if (b2 == -1) {
                throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.i.indexOfChild(view));
            } else if (b2 != i) {
                this.i.p.a(b2, i);
            }
        } else {
            this.h.a(view, i, false);
            layoutParams.c = true;
            if (this.j != null && this.j.c()) {
                this.j.b(view);
            }
        }
        if (layoutParams.d) {
            b.a.invalidate();
            layoutParams.d = false;
        }
    }

    public void c(View view) {
        this.h.a(view);
    }

    public void b(int i) {
        if (d(i) != null) {
            this.h.a(i);
        }
    }

    public int d(View view) {
        return ((LayoutParams) view.getLayoutParams()).c();
    }

    public View a(int i) {
        int m = m();
        for (int i2 = 0; i2 < m; i2++) {
            View d = d(i2);
            ui b = RecyclerView.b(d);
            if (b != null && b.d() == i && !b.c() && (this.i.f.a() || !b.p())) {
                return d;
            }
        }
        return null;
    }

    public void c(int i) {
        a(i, d(i));
    }

    private void a(int i, View view) {
        this.h.d(i);
    }

    public void a(View view, int i, LayoutParams layoutParams) {
        ui b = RecyclerView.b(view);
        if (b.p()) {
            this.i.h(view);
        } else {
            this.i.g(view);
        }
        this.h.a(view, i, layoutParams, b.p());
    }

    public void c(View view, int i) {
        a(view, i, (LayoutParams) view.getLayoutParams());
    }

    public void a(int i, int i2) {
        View d = d(i);
        if (d == null) {
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i);
        }
        c(i);
        c(d, i2);
    }

    public void a(View view, tz tzVar) {
        c(view);
        tzVar.a(view);
    }

    public void a(int i, tz tzVar) {
        View d = d(i);
        b(i);
        tzVar.a(d);
    }

    public int m() {
        return this.h != null ? this.h.b() : 0;
    }

    public View d(int i) {
        return this.h != null ? this.h.b(i) : null;
    }

    public int n() {
        return this.i != null ? this.i.getWidth() : 0;
    }

    public int o() {
        return this.i != null ? this.i.getHeight() : 0;
    }

    public int p() {
        return this.i != null ? this.i.getPaddingLeft() : 0;
    }

    public int q() {
        return this.i != null ? this.i.getPaddingTop() : 0;
    }

    public int r() {
        return this.i != null ? this.i.getPaddingRight() : 0;
    }

    public int s() {
        return this.i != null ? this.i.getPaddingBottom() : 0;
    }

    public View t() {
        if (this.i == null) {
            return null;
        }
        View focusedChild = this.i.getFocusedChild();
        if (focusedChild == null || this.h.c(focusedChild)) {
            return null;
        }
        return focusedChild;
    }

    public void e(int i) {
        if (this.i != null) {
            this.i.b(i);
        }
    }

    public void f(int i) {
        if (this.i != null) {
            this.i.a(i);
        }
    }

    public void a(tz tzVar) {
        for (int m = m() - 1; m >= 0; m--) {
            a(tzVar, m, d(m));
        }
    }

    private void a(tz tzVar, int i, View view) {
        ui b = RecyclerView.b(view);
        if (!b.c()) {
            if (!b.l() || b.p() || b.n() || this.i.o.b()) {
                c(i);
                tzVar.c(view);
                return;
            }
            b(i);
            tzVar.b(b);
        }
    }

    public void b(tz tzVar) {
        int d = tzVar.d();
        for (int i = 0; i < d; i++) {
            View d2 = tzVar.d(i);
            ui b = RecyclerView.b(d2);
            if (!b.c()) {
                if (b.q()) {
                    this.i.removeDetachedView(d2, false);
                }
                tzVar.b(d2);
            }
        }
        tzVar.e();
        if (d > 0) {
            this.i.invalidate();
        }
    }

    public void a(View view, int i, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect e = this.i.e(view);
        view.measure(a(n(), ((e.left + e.right) + i) + (((p() + r()) + layoutParams.leftMargin) + layoutParams.rightMargin), layoutParams.width, c()), a(o(), ((e.bottom + e.top) + i2) + (((q() + s()) + layoutParams.topMargin) + layoutParams.bottomMargin), layoutParams.height, d()));
    }

    public static int a(int i, int i2, int i3, boolean z) {
        int i4 = 1073741824;
        int max = Math.max(0, i - i2);
        if (z) {
            if (i3 < 0) {
                i4 = 0;
                i3 = 0;
            }
        } else if (i3 < 0) {
            if (i3 == -1) {
                i3 = max;
            } else if (i3 == -2) {
                i4 = Integer.MIN_VALUE;
                i3 = max;
            } else {
                i4 = 0;
                i3 = 0;
            }
        }
        return MeasureSpec.makeMeasureSpec(i3, i4);
    }

    public int e(View view) {
        Rect rect = ((LayoutParams) view.getLayoutParams()).b;
        return rect.right + (view.getMeasuredWidth() + rect.left);
    }

    public int f(View view) {
        Rect rect = ((LayoutParams) view.getLayoutParams()).b;
        return rect.bottom + (view.getMeasuredHeight() + rect.top);
    }

    public void a(View view, int i, int i2, int i3, int i4) {
        Rect rect = ((LayoutParams) view.getLayoutParams()).b;
        view.layout(rect.left + i, rect.top + i2, i3 - rect.right, i4 - rect.bottom);
    }

    public int g(View view) {
        return view.getLeft() - m(view);
    }

    public int h(View view) {
        return view.getTop() - k(view);
    }

    public int i(View view) {
        return view.getRight() + n(view);
    }

    public int j(View view) {
        return view.getBottom() + l(view);
    }

    public int k(View view) {
        return ((LayoutParams) view.getLayoutParams()).b.top;
    }

    public int l(View view) {
        return ((LayoutParams) view.getLayoutParams()).b.bottom;
    }

    public int m(View view) {
        return ((LayoutParams) view.getLayoutParams()).b.left;
    }

    public int n(View view) {
        return ((LayoutParams) view.getLayoutParams()).b.right;
    }

    public View a(View view, int i, tz tzVar, uf ufVar) {
        return null;
    }

    public View d(View view, int i) {
        return null;
    }

    public boolean a(RecyclerView recyclerView, View view, Rect rect, boolean z) {
        int p = p();
        int q = q();
        int n = n() - r();
        int o = o() - s();
        int left = view.getLeft() + rect.left;
        int top = view.getTop() + rect.top;
        int width = rect.width() + left;
        int height = rect.height() + top;
        left = Math.min(0, left - p);
        q = Math.min(0, top - q);
        p = Math.max(0, width - n);
        n = Math.max(0, height - o);
        if (hg.g(recyclerView) == 1) {
            if (p == 0) {
                p = left;
            }
            left = p;
        } else if (left == 0) {
            left = p;
        }
        if (q != 0) {
            p = q;
        } else {
            p = n;
        }
        if (left == 0 && p == 0) {
            return false;
        }
        if (z) {
            recyclerView.scrollBy(left, p);
        } else {
            recyclerView.b(left, p);
        }
        return true;
    }

    @Deprecated
    public boolean a(RecyclerView recyclerView, View view, View view2) {
        return k() || recyclerView.C;
    }

    public boolean a(RecyclerView recyclerView, uf ufVar, View view, View view2) {
        return a(recyclerView, view, view2);
    }

    public void a(to toVar, to toVar2) {
    }

    public boolean a(RecyclerView recyclerView, ArrayList arrayList, int i, int i2) {
        return false;
    }

    public void d(RecyclerView recyclerView) {
    }

    public int d(uf ufVar) {
        return 0;
    }

    public int b(uf ufVar) {
        return 0;
    }

    public int f(uf ufVar) {
        return 0;
    }

    public int e(uf ufVar) {
        return 0;
    }

    public int c(uf ufVar) {
        return 0;
    }

    public int g(uf ufVar) {
        return 0;
    }

    public void a(tz tzVar, uf ufVar, int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        switch (mode) {
            case Integer.MIN_VALUE:
            case 1073741824:
                break;
            default:
                size = u();
                break;
        }
        switch (mode2) {
            case Integer.MIN_VALUE:
            case 1073741824:
                break;
            default:
                size2 = v();
                break;
        }
        b(size, size2);
    }

    public void b(int i, int i2) {
        this.i.setMeasuredDimension(i, i2);
    }

    public int u() {
        return hg.k(this.i);
    }

    public int v() {
        return hg.l(this.i);
    }

    public Parcelable b() {
        return null;
    }

    public void a(Parcelable parcelable) {
    }

    public void w() {
        if (this.j != null) {
            this.j.a();
        }
    }

    private void a(ud udVar) {
        if (this.j == udVar) {
            this.j = null;
        }
    }

    public void g(int i) {
    }

    public void c(tz tzVar) {
        for (int m = m() - 1; m >= 0; m--) {
            if (!RecyclerView.b(d(m)).c()) {
                a(m, tzVar);
            }
        }
    }

    void a(jt jtVar) {
        a(this.i.a, this.i.f, jtVar);
    }

    public void a(tz tzVar, uf ufVar, jt jtVar) {
        jtVar.a(RecyclerView.class.getName());
        if (hg.b(this.i, -1) || hg.a(this.i, -1)) {
            jtVar.a(8192);
            jtVar.a(true);
        }
        if (hg.b(this.i, 1) || hg.a(this.i, 1)) {
            jtVar.a(4096);
            jtVar.a(true);
        }
        jtVar.a(kb.a(c(tzVar, ufVar), d(tzVar, ufVar), e(tzVar, ufVar), b(tzVar, ufVar)));
    }

    public void a(AccessibilityEvent accessibilityEvent) {
        a(this.i.a, this.i.f, accessibilityEvent);
    }

    public void a(tz tzVar, uf ufVar, AccessibilityEvent accessibilityEvent) {
        boolean z = true;
        kt a = jp.a(accessibilityEvent);
        if (this.i != null && a != null) {
            if (!(hg.b(this.i, 1) || hg.b(this.i, -1) || hg.a(this.i, -1) || hg.a(this.i, 1))) {
                z = false;
            }
            a.a(z);
            if (this.i.o != null) {
                a.a(this.i.o.a());
            }
        }
    }

    public void x() {
        this.a = true;
    }

    public int b(tz tzVar, uf ufVar) {
        return 0;
    }

    public int c(tz tzVar, uf ufVar) {
        if (this.i == null || this.i.o == null || !d()) {
            return 1;
        }
        return this.i.o.a();
    }

    public int d(tz tzVar, uf ufVar) {
        if (this.i == null || this.i.o == null || !c()) {
            return 1;
        }
        return this.i.o.a();
    }

    public boolean e(tz tzVar, uf ufVar) {
        return false;
    }

    boolean a(int i, Bundle bundle) {
        return a(this.i.a, this.i.f, i, bundle);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(tz r7, uf r8, int r9, android.os.Bundle r10) {
        /*
        r6 = this;
        r4 = -1;
        r2 = 1;
        r1 = 0;
        r0 = r6.i;
        if (r0 != 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        switch(r9) {
            case 4096: goto L_0x004a;
            case 8192: goto L_0x0018;
            default: goto L_0x000b;
        };
    L_0x000b:
        r0 = r1;
        r3 = r1;
    L_0x000d:
        if (r3 != 0) goto L_0x0011;
    L_0x000f:
        if (r0 == 0) goto L_0x0007;
    L_0x0011:
        r1 = r6.i;
        r1.scrollBy(r0, r3);
        r1 = r2;
        goto L_0x0007;
    L_0x0018:
        r0 = r6.i;
        r0 = hg.b(r0, r4);
        if (r0 == 0) goto L_0x007f;
    L_0x0020:
        r0 = r6.o();
        r3 = r6.q();
        r0 = r0 - r3;
        r3 = r6.s();
        r0 = r0 - r3;
        r0 = -r0;
    L_0x002f:
        r3 = r6.i;
        r3 = hg.a(r3, r4);
        if (r3 == 0) goto L_0x007a;
    L_0x0037:
        r3 = r6.n();
        r4 = r6.p();
        r3 = r3 - r4;
        r4 = r6.r();
        r3 = r3 - r4;
        r3 = -r3;
        r5 = r3;
        r3 = r0;
        r0 = r5;
        goto L_0x000d;
    L_0x004a:
        r0 = r6.i;
        r0 = hg.b(r0, r2);
        if (r0 == 0) goto L_0x007d;
    L_0x0052:
        r0 = r6.o();
        r3 = r6.q();
        r0 = r0 - r3;
        r3 = r6.s();
        r0 = r0 - r3;
    L_0x0060:
        r3 = r6.i;
        r3 = hg.a(r3, r2);
        if (r3 == 0) goto L_0x007a;
    L_0x0068:
        r3 = r6.n();
        r4 = r6.p();
        r3 = r3 - r4;
        r4 = r6.r();
        r3 = r3 - r4;
        r5 = r3;
        r3 = r0;
        r0 = r5;
        goto L_0x000d;
    L_0x007a:
        r3 = r0;
        r0 = r1;
        goto L_0x000d;
    L_0x007d:
        r0 = r1;
        goto L_0x0060;
    L_0x007f:
        r0 = r1;
        goto L_0x002f;
        */
        throw new UnsupportedOperationException("Method not decompiled: tv.a(tz, uf, int, android.os.Bundle):boolean");
    }
}
