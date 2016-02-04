package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import ep;
import gu;
import hb;
import hg;
import hz;
import java.util.ArrayList;
import java.util.List;
import ls;
import org.kxml2.kdom.Node;
import sl;
import so;
import tn;
import to;
import tr;
import ts;
import tt;
import tu;
import tv;
import tw;
import tx;
import ty;
import tz;
import ua;
import ub;
import uc;
import uf;
import ug;
import uh;
import ui;
import uj;
import ve;

public class RecyclerView extends ViewGroup {
    private static final Interpolator aa;
    private static final boolean i;
    private final AccessibilityManager A;
    private boolean B;
    private boolean C;
    private ls D;
    private ls E;
    private ls F;
    private ls G;
    private int H;
    private int I;
    private VelocityTracker J;
    private int K;
    private int L;
    private int M;
    private int N;
    private int O;
    private final int P;
    private final int Q;
    private final uh R;
    private tx S;
    private ts T;
    private boolean U;
    private uj V;
    private Runnable W;
    public final tz a;
    public sl b;
    public so c;
    final List d;
    public tr e;
    public final uf f;
    boolean g;
    boolean h;
    private final ub j;
    private SavedState k;
    private boolean l;
    private final Runnable m;
    private final Rect n;
    private to o;
    private tv p;
    private ua q;
    private final ArrayList r;
    private final ArrayList s;
    private tw t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean y;
    private boolean z;

    public class LayoutParams extends MarginLayoutParams {
        public ui a;
        public final Rect b;
        public boolean c;
        public boolean d;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.b = new Rect();
            this.c = true;
            this.d = false;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.b = new Rect();
            this.c = true;
            this.d = false;
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.b = new Rect();
            this.c = true;
            this.d = false;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.b = new Rect();
            this.c = true;
            this.d = false;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.b = new Rect();
            this.c = true;
            this.d = false;
        }

        public boolean a() {
            return this.a.p();
        }

        public boolean b() {
            return this.a.n();
        }

        public int c() {
            return this.a.d();
        }
    }

    public class SavedState extends BaseSavedState {
        public static final Creator CREATOR;
        Parcelable a;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readParcelable(tv.class.getClassLoader());
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.a, 0);
        }

        private void a(SavedState savedState) {
            this.a = savedState.a;
        }

        static {
            CREATOR = new uc();
        }
    }

    static {
        boolean z;
        if (VERSION.SDK_INT == 19 || VERSION.SDK_INT == 20) {
            z = true;
        } else {
            z = false;
        }
        i = z;
        aa = new tn();
    }

    public uj getCompatAccessibilityDelegate() {
        return this.V;
    }

    public void setAccessibilityDelegateCompat(uj ujVar) {
        this.V = ujVar;
        hg.a((View) this, this.V);
    }

    public void setHasFixedSize(boolean z) {
        this.v = z;
    }

    public void setClipToPadding(boolean z) {
        if (z != this.l) {
            g();
        }
        this.l = z;
        super.setClipToPadding(z);
        if (this.w) {
            requestLayout();
        }
    }

    public void setScrollingTouchSlop(int i) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        switch (i) {
            case ve.CropImageView_guidelines /*0*/:
                break;
            case ve.CropImageView_fixAspectRatio /*1*/:
                this.O = hz.a(viewConfiguration);
                return;
            default:
                Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i + "; using default value");
                break;
        }
        this.O = viewConfiguration.getScaledTouchSlop();
    }

    public void setAdapter(to toVar) {
        a(toVar, false, true);
        requestLayout();
    }

    private void a(to toVar, boolean z, boolean z2) {
        if (this.o != null) {
            this.o.b(this.j);
            this.o.b(this);
        }
        if (!z || z2) {
            if (this.e != null) {
                this.e.b();
            }
            if (this.p != null) {
                this.p.c(this.a);
                this.p.b(this.a);
            }
        }
        this.b.a();
        to toVar2 = this.o;
        this.o = toVar;
        if (toVar != null) {
            toVar.a(this.j);
            toVar.a(this);
        }
        if (this.p != null) {
            this.p.a(toVar2, this.o);
        }
        this.a.a(toVar2, this.o, z);
        this.f.i = true;
        l();
    }

    public to getAdapter() {
        return this.o;
    }

    public void setRecyclerListener(ua uaVar) {
        this.q = uaVar;
    }

    public void setLayoutManager(tv tvVar) {
        if (tvVar != this.p) {
            if (this.p != null) {
                if (this.u) {
                    this.p.a(this, this.a);
                }
                this.p.a(null);
            }
            this.a.a();
            this.c.a();
            this.p = tvVar;
            if (tvVar != null) {
                if (tvVar.i != null) {
                    throw new IllegalArgumentException("LayoutManager " + tvVar + " is already attached to a RecyclerView: " + tvVar.i);
                }
                this.p.a(this);
                if (this.u) {
                    this.p.b(this);
                }
            }
            requestLayout();
        }
    }

    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.k != null) {
            savedState.a(this.k);
        } else if (this.p != null) {
            savedState.a = this.p.b();
        } else {
            savedState.a = null;
        }
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        this.k = (SavedState) parcelable;
        super.onRestoreInstanceState(this.k.getSuperState());
        if (this.p != null && this.k.a != null) {
            this.p.a(this.k.a);
        }
    }

    private void b(ui uiVar) {
        View view = uiVar.a;
        boolean z = view.getParent() == this;
        this.a.c(a(view));
        if (uiVar.q()) {
            this.c.a(view, -1, view.getLayoutParams(), true);
        } else if (z) {
            this.c.d(view);
        } else {
            this.c.a(view, true);
        }
    }

    public tv getLayoutManager() {
        return this.p;
    }

    public ty getRecycledViewPool() {
        return this.a.f();
    }

    public void setRecycledViewPool(ty tyVar) {
        this.a.a(tyVar);
    }

    public void setViewCacheExtension(ug ugVar) {
        this.a.a(ugVar);
    }

    public void setItemViewCacheSize(int i) {
        this.a.a(i);
    }

    public int getScrollState() {
        return this.H;
    }

    private void setScrollState(int i) {
        if (i != this.H) {
            this.H = i;
            if (i != 2) {
                p();
            }
            if (this.S != null) {
                this.S.a(this, i);
            }
            this.p.g(i);
        }
    }

    public void setOnScrollListener(tx txVar) {
        this.S = txVar;
    }

    public void scrollTo(int i, int i2) {
        throw new UnsupportedOperationException("RecyclerView does not support scrolling to an absolute position.");
    }

    public void scrollBy(int i, int i2) {
        if (this.p == null) {
            throw new IllegalStateException("Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        }
        boolean c = this.p.c();
        boolean d = this.p.d();
        if (c || d) {
            if (!c) {
                i = 0;
            }
            if (!d) {
                i2 = 0;
            }
            a(i, i2);
        }
    }

    private void o() {
        this.m.run();
    }

    void a(int i, int i2) {
        int a;
        int i3;
        int b;
        int i4;
        o();
        if (this.o != null) {
            a();
            this.C = true;
            if (i != 0) {
                a = this.p.a(i, this.a, this.f);
                i3 = i - a;
            } else {
                a = 0;
                i3 = 0;
            }
            if (i2 != 0) {
                b = this.p.b(i2, this.a, this.f);
                i4 = i2 - b;
            } else {
                b = 0;
                i4 = 0;
            }
            if (s()) {
                int b2 = this.c.b();
                for (int i5 = 0; i5 < b2; i5++) {
                    View b3 = this.c.b(i5);
                    ui a2 = a(b3);
                    if (!(a2 == null || a2.h == null)) {
                        a2 = a2.h;
                        View view = a2 != null ? a2.a : null;
                        if (view != null) {
                            int left = b3.getLeft();
                            int top = b3.getTop();
                            if (left != view.getLeft() || top != view.getTop()) {
                                view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                            }
                        }
                    }
                }
            }
            this.C = false;
            a(false);
            int i6 = a;
            a = i4;
            i4 = i6;
        } else {
            b = 0;
            i4 = 0;
            a = 0;
            i3 = 0;
        }
        if (!this.r.isEmpty()) {
            invalidate();
        }
        if (hg.a(this) != 2) {
            f(i, i2);
            e(i3, a);
        }
        if (!(i4 == 0 && b == 0)) {
            onScrollChanged(0, 0, 0, 0);
            if (this.S != null) {
                this.S.a(this, i4, b);
            }
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
    }

    protected int computeHorizontalScrollOffset() {
        return this.p.c() ? this.p.b(this.f) : 0;
    }

    protected int computeHorizontalScrollExtent() {
        return this.p.c() ? this.p.d(this.f) : 0;
    }

    protected int computeHorizontalScrollRange() {
        return this.p.c() ? this.p.f(this.f) : 0;
    }

    protected int computeVerticalScrollOffset() {
        return this.p.d() ? this.p.c(this.f) : 0;
    }

    protected int computeVerticalScrollExtent() {
        return this.p.d() ? this.p.e(this.f) : 0;
    }

    protected int computeVerticalScrollRange() {
        return this.p.d() ? this.p.g(this.f) : 0;
    }

    public void a() {
        if (!this.x) {
            this.x = true;
            this.y = false;
        }
    }

    public void a(boolean z) {
        if (this.x) {
            if (z && this.y && this.p != null && this.o != null) {
                h();
            }
            this.x = false;
            this.y = false;
        }
    }

    public void b(int i, int i2) {
        if (i != 0 || i2 != 0) {
            this.R.b(i, i2);
        }
    }

    public boolean c(int i, int i2) {
        if (Math.abs(i) < this.P) {
            i = 0;
        }
        if (Math.abs(i2) < this.P) {
            i2 = 0;
        }
        int max = Math.max(-this.Q, Math.min(i, this.Q));
        int max2 = Math.max(-this.Q, Math.min(i2, this.Q));
        if (max == 0 && max2 == 0) {
            return false;
        }
        this.R.a(max, max2);
        return true;
    }

    public void b() {
        setScrollState(0);
        p();
    }

    private void p() {
        this.R.b();
        this.p.w();
    }

    private void e(int i, int i2) {
        if (i < 0) {
            c();
            this.D.a(((float) (-i)) / ((float) getWidth()));
        } else if (i > 0) {
            d();
            this.F.a(((float) i) / ((float) getWidth()));
        }
        if (i2 < 0) {
            e();
            this.E.a(((float) (-i2)) / ((float) getHeight()));
        } else if (i2 > 0) {
            f();
            this.G.a(((float) i2) / ((float) getHeight()));
        }
        if (i != 0 || i2 != 0) {
            hg.d(this);
        }
    }

    private void q() {
        int i = 0;
        if (this.D != null) {
            i = this.D.c();
        }
        if (this.E != null) {
            i |= this.E.c();
        }
        if (this.F != null) {
            i |= this.F.c();
        }
        if (this.G != null) {
            i |= this.G.c();
        }
        if (i != 0) {
            hg.d(this);
        }
    }

    private void f(int i, int i2) {
        int i3 = 0;
        if (!(this.D == null || this.D.a() || i <= 0)) {
            i3 = this.D.c();
        }
        if (!(this.F == null || this.F.a() || i >= 0)) {
            i3 |= this.F.c();
        }
        if (!(this.E == null || this.E.a() || i2 <= 0)) {
            i3 |= this.E.c();
        }
        if (!(this.G == null || this.G.a() || i2 >= 0)) {
            i3 |= this.G.c();
        }
        if (i3 != 0) {
            hg.d(this);
        }
    }

    public void d(int i, int i2) {
        if (i < 0) {
            c();
            this.D.a(-i);
        } else if (i > 0) {
            d();
            this.F.a(i);
        }
        if (i2 < 0) {
            e();
            this.E.a(-i2);
        } else if (i2 > 0) {
            f();
            this.G.a(i2);
        }
        if (i != 0 || i2 != 0) {
            hg.d(this);
        }
    }

    void c() {
        if (this.D == null) {
            this.D = new ls(getContext());
            if (this.l) {
                this.D.a((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.D.a(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    void d() {
        if (this.F == null) {
            this.F = new ls(getContext());
            if (this.l) {
                this.F.a((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.F.a(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    void e() {
        if (this.E == null) {
            this.E = new ls(getContext());
            if (this.l) {
                this.E.a((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.E.a(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    void f() {
        if (this.G == null) {
            this.G = new ls(getContext());
            if (this.l) {
                this.G.a((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.G.a(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    void g() {
        this.G = null;
        this.E = null;
        this.F = null;
        this.D = null;
    }

    public View focusSearch(View view, int i) {
        View d = this.p.d(view, i);
        if (d != null) {
            return d;
        }
        d = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (d == null && this.o != null) {
            a();
            d = this.p.a(view, i, this.a, this.f);
            a(false);
        }
        return d == null ? super.focusSearch(view, i) : d;
    }

    public void requestChildFocus(View view, View view2) {
        boolean z = false;
        if (!(this.p.a(this, this.f, view, view2) || view2 == null)) {
            this.n.set(0, 0, view2.getWidth(), view2.getHeight());
            offsetDescendantRectToMyCoords(view2, this.n);
            offsetRectIntoDescendantCoords(view, this.n);
            Rect rect = this.n;
            if (!this.w) {
                z = true;
            }
            requestChildRectangleOnScreen(view, rect, z);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.p.a(this, view, rect, z);
    }

    public void addFocusables(ArrayList arrayList, int i, int i2) {
        if (!this.p.a(this, arrayList, i, i2)) {
            super.addFocusables(arrayList, i, i2);
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.u = true;
        this.w = false;
        if (this.p != null) {
            this.p.b(this);
        }
        this.U = false;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.e != null) {
            this.e.b();
        }
        this.w = false;
        b();
        this.u = false;
        if (this.p != null) {
            this.p.a(this, this.a);
        }
        removeCallbacks(this.W);
    }

    public void a(String str) {
        if (!this.C) {
            return;
        }
        if (str == null) {
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling");
        }
        throw new IllegalStateException(str);
    }

    private boolean a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.t = null;
        }
        int size = this.s.size();
        int i = 0;
        while (i < size) {
            tw twVar = (tw) this.s.get(i);
            if (!twVar.a(this, motionEvent) || action == 3) {
                i++;
            } else {
                this.t = twVar;
                return true;
            }
        }
        return false;
    }

    private boolean b(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.t != null) {
            if (action == 0) {
                this.t = null;
            } else {
                this.t.b(this, motionEvent);
                if (action == 3 || action == 1) {
                    this.t = null;
                }
                return true;
            }
        }
        if (action != 0) {
            int size = this.s.size();
            for (int i = 0; i < size; i++) {
                tw twVar = (tw) this.s.get(i);
                if (twVar.a(this, motionEvent)) {
                    this.t = twVar;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int i = -1;
        if (a(motionEvent)) {
            r();
            return true;
        }
        boolean c = this.p.c();
        boolean d = this.p.d();
        if (this.J == null) {
            this.J = VelocityTracker.obtain();
        }
        this.J.addMovement(motionEvent);
        int a = gu.a(motionEvent);
        int b = gu.b(motionEvent);
        int x;
        switch (a) {
            case ve.CropImageView_guidelines /*0*/:
                this.I = gu.b(motionEvent, 0);
                x = (int) (motionEvent.getX() + 0.5f);
                this.M = x;
                this.K = x;
                x = (int) (motionEvent.getY() + 0.5f);
                this.N = x;
                this.L = x;
                if (this.H == 2) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    setScrollState(1);
                    break;
                }
                break;
            case ve.CropImageView_fixAspectRatio /*1*/:
                this.J.clear();
                break;
            case ve.CropImageView_aspectRatioX /*2*/:
                a = gu.a(motionEvent, this.I);
                if (a >= 0) {
                    b = (int) (gu.c(motionEvent, a) + 0.5f);
                    a = (int) (gu.d(motionEvent, a) + 0.5f);
                    if (this.H != 1) {
                        b -= this.K;
                        a -= this.L;
                        if (!c || Math.abs(b) <= this.O) {
                            c = false;
                        } else {
                            this.M = ((b < 0 ? -1 : 1) * this.O) + this.K;
                            c = true;
                        }
                        if (d && Math.abs(a) > this.O) {
                            x = this.L;
                            int i2 = this.O;
                            if (a >= 0) {
                                i = 1;
                            }
                            this.N = x + (i * i2);
                            c = true;
                        }
                        if (c) {
                            getParent().requestDisallowInterceptTouchEvent(true);
                            setScrollState(1);
                            break;
                        }
                    }
                }
                Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.I + " not found. Did any MotionEvents get skipped?");
                return false;
                break;
            case ve.CropImageView_aspectRatioY /*3*/:
                r();
                break;
            case Node.CDSECT /*5*/:
                this.I = gu.b(motionEvent, b);
                x = (int) (gu.c(motionEvent, b) + 0.5f);
                this.M = x;
                this.K = x;
                x = (int) (gu.d(motionEvent, b) + 0.5f);
                this.N = x;
                this.L = x;
                break;
            case Node.ENTITY_REF /*6*/:
                c(motionEvent);
                break;
        }
        if (this.H != 1) {
            return false;
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = -1;
        if (b(motionEvent)) {
            r();
            return true;
        }
        boolean c = this.p.c();
        boolean d = this.p.d();
        if (this.J == null) {
            this.J = VelocityTracker.obtain();
        }
        this.J.addMovement(motionEvent);
        int a = gu.a(motionEvent);
        int b = gu.b(motionEvent);
        switch (a) {
            case ve.CropImageView_guidelines /*0*/:
                this.I = gu.b(motionEvent, 0);
                a = (int) (motionEvent.getX() + 0.5f);
                this.M = a;
                this.K = a;
                a = (int) (motionEvent.getY() + 0.5f);
                this.N = a;
                this.L = a;
                return true;
            case ve.CropImageView_fixAspectRatio /*1*/:
                this.J.computeCurrentVelocity(1000, (float) this.Q);
                float f = c ? -hb.a(this.J, this.I) : 0.0f;
                float f2;
                if (d) {
                    f2 = -hb.b(this.J, this.I);
                } else {
                    f2 = 0.0f;
                }
                if ((f == 0.0f && r0 == 0.0f) || !c((int) f, (int) r0)) {
                    setScrollState(0);
                }
                this.J.clear();
                q();
                return true;
            case ve.CropImageView_aspectRatioX /*2*/:
                a = gu.a(motionEvent, this.I);
                if (a < 0) {
                    Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.I + " not found. Did any MotionEvents get skipped?");
                    return false;
                }
                int c2 = (int) (gu.c(motionEvent, a) + 0.5f);
                b = (int) (gu.d(motionEvent, a) + 0.5f);
                if (this.H != 1) {
                    boolean z;
                    a = c2 - this.K;
                    int i2 = b - this.L;
                    if (!c || Math.abs(a) <= this.O) {
                        z = false;
                    } else {
                        this.M = ((a < 0 ? -1 : 1) * this.O) + this.K;
                        z = true;
                    }
                    if (d && Math.abs(i2) > this.O) {
                        a = this.L;
                        int i3 = this.O;
                        if (i2 >= 0) {
                            i = 1;
                        }
                        this.N = a + (i * i3);
                        z = true;
                    }
                    if (z) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        setScrollState(1);
                    }
                }
                if (this.H == 1) {
                    a(c ? -(c2 - this.M) : 0, d ? -(b - this.N) : 0);
                }
                this.M = c2;
                this.N = b;
                return true;
            case ve.CropImageView_aspectRatioY /*3*/:
                r();
                return true;
            case Node.CDSECT /*5*/:
                this.I = gu.b(motionEvent, b);
                a = (int) (gu.c(motionEvent, b) + 0.5f);
                this.M = a;
                this.K = a;
                a = (int) (gu.d(motionEvent, b) + 0.5f);
                this.N = a;
                this.L = a;
                return true;
            case Node.ENTITY_REF /*6*/:
                c(motionEvent);
                return true;
            default:
                return true;
        }
    }

    private void r() {
        if (this.J != null) {
            this.J.clear();
        }
        q();
        setScrollState(0);
    }

    private void c(MotionEvent motionEvent) {
        int b = gu.b(motionEvent);
        if (gu.b(motionEvent, b) == this.I) {
            b = b == 0 ? 1 : 0;
            this.I = gu.b(motionEvent, b);
            int c = (int) (gu.c(motionEvent, b) + 0.5f);
            this.M = c;
            this.K = c;
            b = (int) (gu.d(motionEvent, b) + 0.5f);
            this.N = b;
            this.L = b;
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.z) {
            a();
            v();
            if (this.f.l) {
                this.f.j = true;
            } else {
                this.b.d();
                this.f.j = false;
            }
            this.z = false;
            a(false);
        }
        if (this.o != null) {
            this.f.d = this.o.a();
        } else {
            this.f.d = 0;
        }
        this.p.a(this.a, this.f, i, i2);
        this.f.j = false;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            g();
        }
    }

    public void setItemAnimator(tr trVar) {
        if (this.e != null) {
            this.e.b();
            this.e.a(null);
        }
        this.e = trVar;
        if (this.e != null) {
            this.e.a(this.T);
        }
    }

    public tr getItemAnimator() {
        return this.e;
    }

    private boolean s() {
        return this.e != null && this.e.a();
    }

    private void t() {
        if (!this.U && this.u) {
            hg.a((View) this, this.W);
            this.U = true;
        }
    }

    private boolean u() {
        return this.e != null && this.p.i();
    }

    private void v() {
        boolean z;
        boolean z2 = true;
        if (this.B) {
            this.b.a();
            l();
            this.p.d(this);
        }
        if (this.e == null || !this.p.i()) {
            this.b.d();
        } else {
            this.b.b();
        }
        boolean z3;
        if ((this.g && !this.h) || this.g || (this.h && s())) {
            z3 = true;
        } else {
            z3 = false;
        }
        uf ufVar = this.f;
        if (!this.w || this.e == null || (!(this.B || r0 || this.p.a) || (this.B && !this.o.b()))) {
            z = false;
        } else {
            z = true;
        }
        ufVar.k = z;
        uf ufVar2 = this.f;
        if (!(this.f.k && r0 && !this.B && u())) {
            z2 = false;
        }
        ufVar2.l = z2;
    }

    void h() {
        if (this.o == null) {
            Log.e("RecyclerView", "No adapter attached; skipping layout");
            return;
        }
        int b;
        int i;
        ui b2;
        int b3;
        int i2;
        boolean c;
        int i3;
        ep epVar;
        this.d.clear();
        a();
        this.C = true;
        v();
        uf ufVar = this.f;
        ep epVar2 = (this.f.k && this.h && s()) ? new ep() : null;
        ufVar.c = epVar2;
        this.h = false;
        this.g = false;
        this.f.j = this.f.l;
        this.f.d = this.o.a();
        if (this.f.k) {
            this.f.a.clear();
            this.f.b.clear();
            b = this.c.b();
            for (i = 0; i < b; i++) {
                b2 = b(this.c.b(i));
                if (!b2.c() && (!b2.l() || this.o.b())) {
                    View view = b2.a;
                    this.f.a.put(b2, new tu(b2, view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
                }
            }
        }
        ui b4;
        if (this.f.l) {
            j();
            if (this.f.c != null) {
                b3 = this.c.b();
                for (i2 = 0; i2 < b3; i2++) {
                    b4 = b(this.c.b(i2));
                    if (!(!b4.n() || b4.p() || b4.c())) {
                        this.f.c.put(Long.valueOf(a(b4)), b4);
                        this.f.a.remove(b4);
                    }
                }
            }
            c = this.f.i;
            this.f.i = false;
            this.p.a(this.a, this.f);
            this.f.i = c;
            ep epVar3 = new ep();
            for (b3 = 0; b3 < this.c.b(); b3++) {
                View b5 = this.c.b(b3);
                if (!b(b5).c()) {
                    for (i3 = 0; i3 < this.f.a.size(); i3++) {
                        if (((ui) this.f.a.b(i3)).a == b5) {
                            c = true;
                            break;
                        }
                    }
                    c = false;
                    if (!c) {
                        epVar3.put(b5, new Rect(b5.getLeft(), b5.getTop(), b5.getRight(), b5.getBottom()));
                    }
                }
            }
            k();
            this.b.c();
            epVar = epVar3;
        } else {
            k();
            this.b.d();
            if (this.f.c != null) {
                b3 = this.c.b();
                for (i2 = 0; i2 < b3; i2++) {
                    b4 = b(this.c.b(i2));
                    if (!(!b4.n() || b4.p() || b4.c())) {
                        this.f.c.put(Long.valueOf(a(b4)), b4);
                        this.f.a.remove(b4);
                    }
                }
            }
            epVar = null;
        }
        this.f.d = this.o.a();
        this.f.h = 0;
        this.f.j = false;
        this.p.a(this.a, this.f);
        this.f.i = false;
        this.k = null;
        ufVar = this.f;
        c = this.f.k && this.e != null;
        ufVar.k = c;
        if (this.f.k) {
            ep epVar4;
            ui uiVar;
            if (this.f.c != null) {
                epVar4 = new ep();
            } else {
                epVar4 = null;
            }
            int b6 = this.c.b();
            for (b = 0; b < b6; b++) {
                b2 = b(this.c.b(b));
                if (!b2.c()) {
                    view = b2.a;
                    long a = a(b2);
                    if (epVar4 == null || this.f.c.get(Long.valueOf(a)) == null) {
                        this.f.b.put(b2, new tu(b2, view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
                    } else {
                        epVar4.put(Long.valueOf(a), b2);
                    }
                }
            }
            a(epVar);
            for (b3 = this.f.a.size() - 1; b3 >= 0; b3--) {
                if (!this.f.b.containsKey((ui) this.f.a.b(b3))) {
                    tu tuVar = (tu) this.f.a.c(b3);
                    this.f.a.d(b3);
                    View view2 = tuVar.a.a;
                    this.a.c(tuVar.a);
                    a(tuVar);
                }
            }
            i2 = this.f.b.size();
            if (i2 > 0) {
                for (int i4 = i2 - 1; i4 >= 0; i4--) {
                    uiVar = (ui) this.f.b.b(i4);
                    tu tuVar2 = (tu) this.f.b.c(i4);
                    if (this.f.a.isEmpty() || !this.f.a.containsKey(uiVar)) {
                        Rect rect;
                        this.f.b.d(i4);
                        if (epVar != null) {
                            rect = (Rect) epVar.get(uiVar.a);
                        } else {
                            rect = null;
                        }
                        a(uiVar, rect, tuVar2.b, tuVar2.c);
                    }
                }
            }
            b = this.f.b.size();
            for (i = 0; i < b; i++) {
                b2 = (ui) this.f.b.b(i);
                tu tuVar3 = (tu) this.f.b.c(i);
                tu tuVar4 = (tu) this.f.a.get(b2);
                if (!(tuVar4 == null || tuVar3 == null || (tuVar4.b == tuVar3.b && tuVar4.c == tuVar3.c))) {
                    b2.a(false);
                    if (this.e.a(b2, tuVar4.b, tuVar4.c, tuVar3.b, tuVar3.c)) {
                        t();
                    }
                }
            }
            if (this.f.c != null) {
                i2 = this.f.c.size();
            } else {
                i2 = 0;
            }
            for (i3 = i2 - 1; i3 >= 0; i3--) {
                long longValue = ((Long) this.f.c.b(i3)).longValue();
                uiVar = (ui) this.f.c.get(Long.valueOf(longValue));
                View view3 = uiVar.a;
                if (!(uiVar.c() || this.a.d == null || !this.a.d.contains(uiVar))) {
                    a(uiVar, (ui) epVar4.get(Long.valueOf(longValue)));
                }
            }
        }
        a(false);
        this.p.b(this.a);
        this.f.g = this.f.d;
        this.B = false;
        this.f.k = false;
        this.f.l = false;
        this.C = false;
        this.p.a = false;
        if (this.a.d != null) {
            this.a.d.clear();
        }
        this.f.c = null;
    }

    public void removeDetachedView(View view, boolean z) {
        ui b = b(view);
        if (b != null) {
            if (b.q()) {
                b.k();
            } else if (!b.c()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + b);
            }
        }
        f(view);
        super.removeDetachedView(view, z);
    }

    long a(ui uiVar) {
        return this.o.b() ? uiVar.e() : (long) uiVar.b;
    }

    private void a(ep epVar) {
        int size = this.d.size();
        for (int i = 0; i < size; i++) {
            View view = (View) this.d.get(i);
            ui b = b(view);
            tu tuVar = (tu) this.f.a.remove(b);
            if (!this.f.a()) {
                this.f.b.remove(b);
            }
            if (epVar.remove(view) != null) {
                this.p.a(view, this.a);
            } else if (tuVar != null) {
                a(tuVar);
            } else {
                a(new tu(b, view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            }
        }
        this.d.clear();
    }

    private void a(ui uiVar, Rect rect, int i, int i2) {
        View view = uiVar.a;
        if (rect == null || (rect.left == i && rect.top == i2)) {
            uiVar.a(false);
            if (this.e.b(uiVar)) {
                t();
                return;
            }
            return;
        }
        uiVar.a(false);
        if (this.e.a(uiVar, rect.left, rect.top, i, i2)) {
            t();
        }
    }

    private void a(tu tuVar) {
        View view = tuVar.a.a;
        b(tuVar.a);
        int i = tuVar.b;
        int i2 = tuVar.c;
        int left = view.getLeft();
        int top = view.getTop();
        if (i == left && i2 == top) {
            tuVar.a.a(false);
            if (this.e.a(tuVar.a)) {
                t();
                return;
            }
            return;
        }
        tuVar.a.a(false);
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        if (this.e.a(tuVar.a, i, i2, left, top)) {
            t();
        }
    }

    private void a(ui uiVar, ui uiVar2) {
        int i;
        int i2;
        uiVar.a(false);
        b(uiVar);
        uiVar.g = uiVar2;
        this.a.c(uiVar);
        int left = uiVar.a.getLeft();
        int top = uiVar.a.getTop();
        if (uiVar2 == null || uiVar2.c()) {
            i = top;
            i2 = left;
        } else {
            i2 = uiVar2.a.getLeft();
            i = uiVar2.a.getTop();
            uiVar2.a(false);
            uiVar2.h = uiVar;
        }
        if (this.e.a(uiVar, uiVar2, left, top, i2, i)) {
            t();
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        a();
        h();
        a(false);
        this.w = true;
    }

    public void requestLayout() {
        if (this.x) {
            this.y = true;
        } else {
            super.requestLayout();
        }
    }

    void i() {
        int c = this.c.c();
        for (int i = 0; i < c; i++) {
            ((LayoutParams) this.c.c(i).getLayoutParams()).c = true;
        }
        this.a.i();
    }

    public void draw(Canvas canvas) {
        int i;
        int i2;
        int i3 = 1;
        int i4 = 0;
        super.draw(canvas);
        int size = this.r.size();
        for (i = 0; i < size; i++) {
            ((tt) this.r.get(i)).b(canvas, this, this.f);
        }
        if (this.D == null || this.D.a()) {
            i2 = 0;
        } else {
            i = canvas.save();
            i2 = this.l ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((float) (i2 + (-getHeight())), 0.0f);
            if (this.D == null || !this.D.a(canvas)) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            canvas.restoreToCount(i);
        }
        if (!(this.E == null || this.E.a())) {
            size = canvas.save();
            if (this.l) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            if (this.E == null || !this.E.a(canvas)) {
                i = 0;
            } else {
                i = 1;
            }
            i2 |= i;
            canvas.restoreToCount(size);
        }
        if (!(this.F == null || this.F.a())) {
            size = canvas.save();
            int width = getWidth();
            if (this.l) {
                i = getPaddingTop();
            } else {
                i = 0;
            }
            canvas.rotate(90.0f);
            canvas.translate((float) (-i), (float) (-width));
            if (this.F == null || !this.F.a(canvas)) {
                i = 0;
            } else {
                i = 1;
            }
            i2 |= i;
            canvas.restoreToCount(size);
        }
        if (!(this.G == null || this.G.a())) {
            i = canvas.save();
            canvas.rotate(180.0f);
            if (this.l) {
                canvas.translate((float) ((-getWidth()) + getPaddingRight()), (float) ((-getHeight()) + getPaddingBottom()));
            } else {
                canvas.translate((float) (-getWidth()), (float) (-getHeight()));
            }
            if (this.G != null && this.G.a(canvas)) {
                i4 = 1;
            }
            i2 |= i4;
            canvas.restoreToCount(i);
        }
        if (i2 != 0 || this.e == null || this.r.size() <= 0 || !this.e.c()) {
            i3 = i2;
        }
        if (i3 != 0) {
            hg.d(this);
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.r.size();
        for (int i = 0; i < size; i++) {
            ((tt) this.r.get(i)).a(canvas, this, this.f);
        }
    }

    public boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && this.p.a((LayoutParams) layoutParams);
    }

    public android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        if (this.p != null) {
            return this.p.a();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        if (this.p != null) {
            return this.p.a(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        if (this.p != null) {
            return this.p.a(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    void j() {
        int c = this.c.c();
        for (int i = 0; i < c; i++) {
            ui b = b(this.c.c(i));
            if (!b.c()) {
                b.b();
            }
        }
    }

    void k() {
        int c = this.c.c();
        for (int i = 0; i < c; i++) {
            ui b = b(this.c.c(i));
            if (!b.c()) {
                b.a();
            }
        }
        this.a.h();
    }

    void l() {
        int c = this.c.c();
        for (int i = 0; i < c; i++) {
            ui b = b(this.c.c(i));
            if (!(b == null || b.c())) {
                b.a(6);
            }
        }
        i();
        this.a.g();
    }

    public ui a(View view) {
        Object parent = view.getParent();
        if (parent == null || parent == this) {
            return b(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    public static ui b(View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).a;
    }

    public int c(View view) {
        ui b = b(view);
        return b != null ? b.d() : -1;
    }

    public void a(int i) {
        int b = this.c.b();
        for (int i2 = 0; i2 < b; i2++) {
            this.c.b(i2).offsetTopAndBottom(i);
        }
    }

    public void d(View view) {
    }

    public void b(int i) {
        int b = this.c.b();
        for (int i2 = 0; i2 < b; i2++) {
            this.c.b(i2).offsetLeftAndRight(i);
        }
    }

    public Rect e(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.c) {
            return layoutParams.b;
        }
        Rect rect = layoutParams.b;
        rect.set(0, 0, 0, 0);
        int size = this.r.size();
        for (int i = 0; i < size; i++) {
            this.n.set(0, 0, 0, 0);
            ((tt) this.r.get(i)).a(this.n, view, this, this.f);
            rect.left += this.n.left;
            rect.top += this.n.top;
            rect.right += this.n.right;
            rect.bottom += this.n.bottom;
        }
        layoutParams.c = false;
        return rect;
    }

    private void f(View view) {
        if (this.o != null) {
            this.o.b(b(view));
        }
        d(view);
    }

    private void g(View view) {
        this.d.remove(view);
    }

    private void h(View view) {
        if (!this.d.contains(view)) {
            this.d.add(view);
        }
    }
}
