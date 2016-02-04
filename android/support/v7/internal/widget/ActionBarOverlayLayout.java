package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import hg;
import iu;
import jk;
import me;
import nl;
import nq;
import nw;
import nx;
import org.kxml2.kdom.Node;
import pn;
import qb;
import qc;
import qd;
import qe;
import qf;
import qn;
import qo;
import rt;
import ve;

public class ActionBarOverlayLayout extends ViewGroup implements qn {
    static final int[] a;
    private final jk A;
    private final jk B;
    private final Runnable C;
    private final Runnable D;
    private int b;
    private int c;
    private ContentFrameLayout d;
    private ActionBarContainer e;
    private ActionBarContainer f;
    private qo g;
    private Drawable h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;
    private int n;
    private int o;
    private final Rect p;
    private final Rect q;
    private final Rect r;
    private final Rect s;
    private final Rect t;
    private final Rect u;
    private qf v;
    private final int w;
    private me x;
    private iu y;
    private iu z;

    public class LayoutParams extends MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return b();
    }

    public /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return a(attributeSet);
    }

    static {
        a = new int[]{nl.actionBarSize, 16842841};
    }

    public ActionBarOverlayLayout(Context context) {
        super(context);
        this.c = 0;
        this.p = new Rect();
        this.q = new Rect();
        this.r = new Rect();
        this.s = new Rect();
        this.t = new Rect();
        this.u = new Rect();
        this.w = 600;
        this.A = new qb(this);
        this.B = new qc(this);
        this.C = new qd(this);
        this.D = new qe(this);
        a(context);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = 0;
        this.p = new Rect();
        this.q = new Rect();
        this.r = new Rect();
        this.s = new Rect();
        this.t = new Rect();
        this.u = new Rect();
        this.w = 600;
        this.A = new qb(this);
        this.B = new qc(this);
        this.C = new qd(this);
        this.D = new qe(this);
        a(context);
    }

    private void a(Context context) {
        boolean z = true;
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(a);
        this.b = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.h = obtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.h == null);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion >= 19) {
            z = false;
        }
        this.i = z;
        this.x = me.a(context);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        k();
    }

    public void setActionBarVisibilityCallback(qf qfVar) {
        this.v = qfVar;
        if (getWindowToken() != null) {
            this.v.c(this.c);
            if (this.o != 0) {
                onWindowSystemUiVisibilityChanged(this.o);
                hg.o(this);
            }
        }
    }

    public void setOverlayMode(boolean z) {
        this.j = z;
        boolean z2 = z && getContext().getApplicationInfo().targetSdkVersion < 19;
        this.i = z2;
    }

    public boolean a() {
        return this.j;
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.k = z;
    }

    public void setShowingForActionMode(boolean z) {
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        a(getContext());
        hg.o(this);
    }

    public void onWindowSystemUiVisibilityChanged(int i) {
        boolean z;
        boolean z2 = true;
        if (VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        c();
        int i2 = this.o ^ i;
        this.o = i;
        boolean z3 = (i & 4) == 0;
        if ((i & 256) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.v != null) {
            qf qfVar = this.v;
            if (z) {
                z2 = false;
            }
            qfVar.g(z2);
            if (z3 || !z) {
                this.v.i();
            } else {
                this.v.j();
            }
        }
        if ((i2 & 256) != 0 && this.v != null) {
            hg.o(this);
        }
    }

    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.c = i;
        if (this.v != null) {
            this.v.c(i);
        }
    }

    private boolean a(View view, Rect rect, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5 = false;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (z && layoutParams.leftMargin != rect.left) {
            layoutParams.leftMargin = rect.left;
            z5 = true;
        }
        if (z2 && layoutParams.topMargin != rect.top) {
            layoutParams.topMargin = rect.top;
            z5 = true;
        }
        if (z4 && layoutParams.rightMargin != rect.right) {
            layoutParams.rightMargin = rect.right;
            z5 = true;
        }
        if (!z3 || layoutParams.bottomMargin == rect.bottom) {
            return z5;
        }
        layoutParams.bottomMargin = rect.bottom;
        return true;
    }

    protected boolean fitSystemWindows(Rect rect) {
        c();
        boolean a = (hg.n(this) & 256) != 0 ? a(this.f, rect, true, true, false, true) : a(this.f, rect, true, true, false, true);
        if (this.e != null) {
            a |= a(this.e, rect, true, false, true, true);
        }
        this.s.set(rect);
        rt.a(this, this.s, this.p);
        if (!this.q.equals(this.p)) {
            this.q.set(this.p);
            a = true;
        }
        if (a) {
            requestLayout();
        }
        return true;
    }

    protected LayoutParams b() {
        return new LayoutParams(-1, -1);
    }

    public LayoutParams a(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    protected void onMeasure(int i, int i2) {
        int max;
        int max2;
        int i3;
        Object obj;
        int i4;
        c();
        measureChildWithMargins(this.f, i, 0, i2, 0);
        LayoutParams layoutParams = (LayoutParams) this.f.getLayoutParams();
        int max3 = Math.max(0, (this.f.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin);
        int max4 = Math.max(0, layoutParams.bottomMargin + (this.f.getMeasuredHeight() + layoutParams.topMargin));
        int a = rt.a(0, hg.i(this.f));
        if (this.e != null) {
            measureChildWithMargins(this.e, i, 0, i2, 0);
            layoutParams = (LayoutParams) this.e.getLayoutParams();
            max = Math.max(max3, (this.e.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin);
            max2 = Math.max(max4, layoutParams.bottomMargin + (this.e.getMeasuredHeight() + layoutParams.topMargin));
            max3 = rt.a(a, hg.i(this.e));
            max4 = max;
            i3 = max2;
        } else {
            i3 = max4;
            max4 = max3;
            max3 = a;
        }
        if ((hg.n(this) & 256) != 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            i4 = this.b;
            if (this.k && this.f.getTabContainer() != null) {
                i4 += this.b;
            }
        } else {
            i4 = this.f.getVisibility() != 8 ? this.f.getMeasuredHeight() : 0;
        }
        if (!this.g.c() || this.e == null) {
            max = 0;
        } else if (obj != null) {
            max = this.b;
        } else {
            max = this.e.getMeasuredHeight();
        }
        this.r.set(this.p);
        this.t.set(this.s);
        Rect rect;
        Rect rect2;
        if (this.j || obj != null) {
            rect = this.t;
            rect.top = i4 + rect.top;
            rect2 = this.t;
            rect2.bottom = max + rect2.bottom;
        } else {
            rect = this.r;
            rect.top = i4 + rect.top;
            rect2 = this.r;
            rect2.bottom = max + rect2.bottom;
        }
        a(this.d, this.r, true, true, true, true);
        if (!this.u.equals(this.t)) {
            this.u.set(this.t);
            this.d.a(this.t);
        }
        measureChildWithMargins(this.d, i, 0, i2, 0);
        layoutParams = (LayoutParams) this.d.getLayoutParams();
        max = Math.max(max4, (this.d.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin);
        i4 = Math.max(i3, layoutParams.bottomMargin + (this.d.getMeasuredHeight() + layoutParams.topMargin));
        max2 = rt.a(max3, hg.i(this.d));
        setMeasuredDimension(hg.a(Math.max(max + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, max2), hg.a(Math.max(i4 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i2, max2 << 16));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingRight = (i3 - i) - getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = (i4 - i2) - getPaddingBottom();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i6 = layoutParams.leftMargin + paddingLeft;
                if (childAt == this.e) {
                    paddingRight = (paddingBottom - measuredHeight) - layoutParams.bottomMargin;
                } else {
                    paddingRight = layoutParams.topMargin + paddingTop;
                }
                childAt.layout(i6, paddingRight, measuredWidth + i6, measuredHeight + paddingRight);
            }
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.h != null && !this.i) {
            int bottom = this.f.getVisibility() == 0 ? (int) ((((float) this.f.getBottom()) + hg.j(this.f)) + 0.5f) : 0;
            this.h.setBounds(0, bottom, getWidth(), this.h.getIntrinsicHeight() + bottom);
            this.h.draw(canvas);
        }
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.f.getVisibility() != 0) {
            return false;
        }
        return this.l;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        super.onNestedScrollAccepted(view, view2, i);
        this.n = getActionBarHideOffset();
        k();
        if (this.v != null) {
            this.v.k();
        }
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        this.n += i2;
        setActionBarHideOffset(this.n);
    }

    public void onStopNestedScroll(View view) {
        super.onStopNestedScroll(view);
        if (this.l && !this.m) {
            if (this.n <= this.f.getHeight()) {
                l();
            } else {
                m();
            }
        }
        if (this.v != null) {
            this.v.l();
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (!this.l || !z) {
            return false;
        }
        if (a(f, f2)) {
            o();
        } else {
            n();
        }
        this.m = true;
        return true;
    }

    void c() {
        if (this.d == null) {
            this.d = (ContentFrameLayout) findViewById(nq.action_bar_activity_content);
            this.f = (ActionBarContainer) findViewById(nq.action_bar_container);
            this.g = a(findViewById(nq.action_bar));
            this.e = (ActionBarContainer) findViewById(nq.split_action_bar);
        }
    }

    private qo a(View view) {
        if (view instanceof qo) {
            return (qo) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.l) {
            this.l = z;
            if (!z) {
                if (nw.a()) {
                    stopNestedScroll();
                }
                k();
                setActionBarHideOffset(0);
            }
        }
    }

    public int getActionBarHideOffset() {
        return this.f != null ? -((int) hg.j(this.f)) : 0;
    }

    public void setActionBarHideOffset(int i) {
        k();
        int height = this.f.getHeight();
        int max = Math.max(0, Math.min(i, height));
        hg.b(this.f, (float) (-max));
        if (this.e != null && this.e.getVisibility() != 8) {
            hg.b(this.e, (float) ((int) ((((float) max) / ((float) height)) * ((float) this.e.getHeight()))));
        }
    }

    private void k() {
        removeCallbacks(this.C);
        removeCallbacks(this.D);
        if (this.y != null) {
            this.y.a();
        }
        if (this.z != null) {
            this.z.a();
        }
    }

    private void l() {
        k();
        postDelayed(this.C, 600);
    }

    private void m() {
        k();
        postDelayed(this.D, 600);
    }

    private void n() {
        k();
        this.C.run();
    }

    private void o() {
        k();
        this.D.run();
    }

    private boolean a(float f, float f2) {
        this.x.a(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (this.x.e() > this.f.getHeight()) {
            return true;
        }
        return false;
    }

    public void setWindowCallback(nx nxVar) {
        c();
        this.g.a(nxVar);
    }

    public void setWindowTitle(CharSequence charSequence) {
        c();
        this.g.a(charSequence);
    }

    public CharSequence getTitle() {
        c();
        return this.g.f();
    }

    public void a(int i) {
        c();
        switch (i) {
            case ve.CropImageView_aspectRatioX /*2*/:
                this.g.g();
            case Node.CDSECT /*5*/:
                this.g.h();
            case Node.COMMENT /*9*/:
                setOverlayMode(true);
            default:
        }
    }

    public void setUiOptions(int i) {
    }

    public void setIcon(int i) {
        c();
        this.g.a(i);
    }

    public void setIcon(Drawable drawable) {
        c();
        this.g.a(drawable);
    }

    public void setLogo(int i) {
        c();
        this.g.b(i);
    }

    public boolean d() {
        c();
        return this.g.i();
    }

    public boolean e() {
        c();
        return this.g.j();
    }

    public boolean f() {
        c();
        return this.g.k();
    }

    public boolean g() {
        c();
        return this.g.l();
    }

    public boolean h() {
        c();
        return this.g.m();
    }

    public void i() {
        c();
        this.g.n();
    }

    public void a(Menu menu, pn pnVar) {
        c();
        this.g.a(menu, pnVar);
    }

    public void j() {
        c();
        this.g.o();
    }
}
