import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewDebug.CapturedViewProperty;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Adapter;

public abstract class qg extends ViewGroup {
    public int A;
    public int B;
    public long C;
    public boolean D;
    private int a;
    private View b;
    private boolean c;
    private boolean d;
    private qm e;
    @ExportedProperty(category = "scrolling")
    public int j;
    int k;
    public int l;
    public long m;
    long n;
    public boolean o;
    public int p;
    public boolean q;
    ql r;
    qj s;
    qk t;
    public boolean u;
    @ExportedProperty(category = "list")
    public int v;
    long w;
    @ExportedProperty(category = "list")
    public int x;
    long y;
    @ExportedProperty(category = "list")
    public int z;

    public abstract Adapter getAdapter();

    public abstract View getSelectedView();

    public abstract void setAdapter(Adapter adapter);

    public abstract void setSelection(int i);

    public qg(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = 0;
        this.m = Long.MIN_VALUE;
        this.o = false;
        this.q = false;
        this.v = -1;
        this.w = Long.MIN_VALUE;
        this.x = -1;
        this.y = Long.MIN_VALUE;
        this.B = -1;
        this.C = Long.MIN_VALUE;
        this.D = false;
    }

    public void setOnItemClickListener(qj qjVar) {
        this.s = qjVar;
    }

    public final qj getOnItemClickListener() {
        return this.s;
    }

    public boolean a(View view, int i, long j) {
        if (this.s == null) {
            return false;
        }
        playSoundEffect(0);
        if (view != null) {
            view.sendAccessibilityEvent(1);
        }
        this.s.a(this, view, i, j);
        return true;
    }

    public void setOnItemLongClickListener(qk qkVar) {
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        this.t = qkVar;
    }

    public final qk getOnItemLongClickListener() {
        return this.t;
    }

    public void setOnItemSelectedListener(ql qlVar) {
        this.r = qlVar;
    }

    public final ql getOnItemSelectedListener() {
        return this.r;
    }

    public void addView(View view) {
        throw new UnsupportedOperationException("addView(View) is not supported in AdapterView");
    }

    public void addView(View view, int i) {
        throw new UnsupportedOperationException("addView(View, int) is not supported in AdapterView");
    }

    public void addView(View view, LayoutParams layoutParams) {
        throw new UnsupportedOperationException("addView(View, LayoutParams) is not supported in AdapterView");
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        throw new UnsupportedOperationException("addView(View, int, LayoutParams) is not supported in AdapterView");
    }

    public void removeView(View view) {
        throw new UnsupportedOperationException("removeView(View) is not supported in AdapterView");
    }

    public void removeViewAt(int i) {
        throw new UnsupportedOperationException("removeViewAt(int) is not supported in AdapterView");
    }

    public void removeAllViews() {
        throw new UnsupportedOperationException("removeAllViews() is not supported in AdapterView");
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.a = getHeight();
    }

    @CapturedViewProperty
    public int getSelectedItemPosition() {
        return this.v;
    }

    @CapturedViewProperty
    public long getSelectedItemId() {
        return this.w;
    }

    public Object getSelectedItem() {
        Adapter adapter = getAdapter();
        int selectedItemPosition = getSelectedItemPosition();
        if (adapter == null || adapter.getCount() <= 0 || selectedItemPosition < 0) {
            return null;
        }
        return adapter.getItem(selectedItemPosition);
    }

    @CapturedViewProperty
    public int getCount() {
        return this.z;
    }

    public int getFirstVisiblePosition() {
        return this.j;
    }

    public int getLastVisiblePosition() {
        return (this.j + getChildCount()) - 1;
    }

    public void setEmptyView(View view) {
        this.b = view;
        Adapter adapter = getAdapter();
        boolean z = adapter == null || adapter.isEmpty();
        a(z);
    }

    public View getEmptyView() {
        return this.b;
    }

    boolean d() {
        return false;
    }

    public void setFocusable(boolean z) {
        boolean z2 = true;
        Adapter adapter = getAdapter();
        boolean z3 = adapter == null || adapter.getCount() == 0;
        this.c = z;
        if (!z) {
            this.d = false;
        }
        if (!z || (z3 && !d())) {
            z2 = false;
        }
        super.setFocusable(z2);
    }

    public void setFocusableInTouchMode(boolean z) {
        boolean z2 = true;
        Adapter adapter = getAdapter();
        boolean z3 = adapter == null || adapter.getCount() == 0;
        this.d = z;
        if (z) {
            this.c = true;
        }
        if (!z || (z3 && !d())) {
            z2 = false;
        }
        super.setFocusableInTouchMode(z2);
    }

    public void e() {
        boolean z;
        boolean z2 = false;
        Adapter adapter = getAdapter();
        boolean z3 = adapter == null || adapter.getCount() == 0;
        if (!z3 || d()) {
            z = true;
        } else {
            z = false;
        }
        if (z && this.d) {
            z3 = true;
        } else {
            z3 = false;
        }
        super.setFocusableInTouchMode(z3);
        if (z && this.c) {
            z3 = true;
        } else {
            z3 = false;
        }
        super.setFocusable(z3);
        if (this.b != null) {
            if (adapter == null || adapter.isEmpty()) {
                z2 = true;
            }
            a(z2);
        }
    }

    private void a(boolean z) {
        if (d()) {
            z = false;
        }
        if (z) {
            if (this.b != null) {
                this.b.setVisibility(0);
                setVisibility(8);
            } else {
                setVisibility(0);
            }
            if (this.u) {
                onLayout(false, getLeft(), getTop(), getRight(), getBottom());
                return;
            }
            return;
        }
        if (this.b != null) {
            this.b.setVisibility(8);
        }
        setVisibility(0);
    }

    public long a(int i) {
        Adapter adapter = getAdapter();
        return (adapter == null || i < 0) ? Long.MIN_VALUE : adapter.getItemId(i);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        throw new RuntimeException("Don't call setOnClickListener for an AdapterView. You probably want setOnItemClickListener instead");
    }

    protected void dispatchSaveInstanceState(SparseArray sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    protected void dispatchRestoreInstanceState(SparseArray sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.e);
    }

    void f() {
        if (this.r != null) {
            if (this.q || this.D) {
                if (this.e == null) {
                    this.e = new qm();
                }
                post(this.e);
            } else {
                a();
            }
        }
        if (this.x != -1 && isShown() && !isInTouchMode()) {
            sendAccessibilityEvent(4);
        }
    }

    private void a() {
        if (this.r != null) {
            int selectedItemPosition = getSelectedItemPosition();
            if (selectedItemPosition >= 0) {
                View selectedView = getSelectedView();
                this.r.a(this, selectedView, selectedItemPosition, getAdapter().getItemId(selectedItemPosition));
                return;
            }
            this.r.a(this);
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        View selectedView = getSelectedView();
        if (selectedView != null && selectedView.getVisibility() == 0 && selectedView.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
            return true;
        }
        return false;
    }

    protected boolean canAnimate() {
        return super.canAnimate() && this.z > 0;
    }

    public void g() {
        boolean z;
        int i = this.z;
        if (i > 0) {
            int i2;
            boolean z2;
            if (this.o) {
                this.o = false;
                i2 = i();
                if (i2 >= 0 && b(i2, true) == i2) {
                    setNextSelectedPositionInt(i2);
                    z2 = true;
                    if (!z2) {
                        i2 = getSelectedItemPosition();
                        if (i2 >= i) {
                            i2 = i - 1;
                        }
                        if (i2 < 0) {
                            i2 = 0;
                        }
                        i = b(i2, true);
                        if (i >= 0) {
                            i2 = b(i2, false);
                        } else {
                            i2 = i;
                        }
                        if (i2 >= 0) {
                            setNextSelectedPositionInt(i2);
                            h();
                            z = true;
                        }
                    }
                    z = z2;
                }
            }
            z2 = false;
            if (z2) {
                i2 = getSelectedItemPosition();
                if (i2 >= i) {
                    i2 = i - 1;
                }
                if (i2 < 0) {
                    i2 = 0;
                }
                i = b(i2, true);
                if (i >= 0) {
                    i2 = i;
                } else {
                    i2 = b(i2, false);
                }
                if (i2 >= 0) {
                    setNextSelectedPositionInt(i2);
                    h();
                    z = true;
                }
            }
            z = z2;
        } else {
            z = false;
        }
        if (!z) {
            this.x = -1;
            this.y = Long.MIN_VALUE;
            this.v = -1;
            this.w = Long.MIN_VALUE;
            this.o = false;
            h();
        }
    }

    public void h() {
        if (this.x != this.B || this.y != this.C) {
            f();
            this.B = this.x;
            this.C = this.y;
        }
    }

    int i() {
        int i = this.z;
        if (i == 0) {
            return -1;
        }
        long j = this.m;
        int i2 = this.l;
        if (j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(i - 1, Math.max(0, i2));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        Object obj = null;
        Adapter adapter = getAdapter();
        if (adapter == null) {
            return -1;
        }
        int i3 = min;
        int i4 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (adapter.getItemId(i4) != j) {
                Object obj2 = min == i + -1 ? 1 : null;
                Object obj3 = i3 == 0 ? 1 : null;
                if (obj2 != null && obj3 != null) {
                    break;
                } else if (obj3 != null || (r0 != null && obj2 == null)) {
                    min++;
                    obj = null;
                    i4 = min;
                } else if (obj2 != null || (r0 == null && obj3 == null)) {
                    i3--;
                    obj = 1;
                    i4 = i3;
                }
            } else {
                return i4;
            }
        }
        return -1;
    }

    int b(int i, boolean z) {
        return i;
    }

    public void setSelectedPositionInt(int i) {
        this.x = i;
        this.y = a(i);
    }

    public void setNextSelectedPositionInt(int i) {
        this.v = i;
        this.w = a(i);
        if (this.o && this.p == 0 && i >= 0) {
            this.l = i;
            this.m = this.w;
        }
    }

    void j() {
        if (getChildCount() > 0) {
            this.o = true;
            this.n = (long) this.a;
            View childAt;
            if (this.x >= 0) {
                childAt = getChildAt(this.x - this.j);
                this.m = this.w;
                this.l = this.v;
                if (childAt != null) {
                    this.k = childAt.getTop();
                }
                this.p = 0;
                return;
            }
            childAt = getChildAt(0);
            Adapter adapter = getAdapter();
            if (this.j < 0 || this.j >= adapter.getCount()) {
                this.m = -1;
            } else {
                this.m = adapter.getItemId(this.j);
            }
            this.l = this.j;
            if (childAt != null) {
                this.k = childAt.getTop();
            }
            this.p = 1;
        }
    }
}
