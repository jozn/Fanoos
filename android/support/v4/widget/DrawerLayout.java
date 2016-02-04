package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import da;
import fv;
import ga;
import hg;
import lk;
import ll;
import lm;
import ln;
import lo;
import lp;
import lq;
import mt;
import nv;
import ve;

public class DrawerLayout extends ViewGroup {
    static final ll a;
    private static final int[] b;
    private static final boolean c;
    private boolean A;
    private final lk d;
    private int e;
    private int f;
    private float g;
    private Paint h;
    private final mt i;
    private final mt j;
    private final lq k;
    private final lq l;
    private int m;
    private boolean n;
    private boolean o;
    private int p;
    private int q;
    private boolean r;
    private boolean s;
    private lo t;
    private float u;
    private float v;
    private Drawable w;
    private Drawable x;
    private Drawable y;
    private Object z;

    public class LayoutParams extends MarginLayoutParams {
        public int a;
        float b;
        public boolean c;
        boolean d;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.b);
            this.a = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.a = 0;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 0;
            this.a = layoutParams.a;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 0;
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.a = 0;
        }
    }

    public class SavedState extends BaseSavedState {
        public static final Creator CREATOR;
        int a;
        int b;
        int c;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.a = 0;
            this.b = 0;
            this.c = 0;
            this.a = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
            this.a = 0;
            this.b = 0;
            this.c = 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
        }

        static {
            CREATOR = new lp();
        }
    }

    static {
        boolean z = true;
        b = new int[]{16842931};
        if (VERSION.SDK_INT < 19) {
            z = false;
        }
        c = z;
        if (VERSION.SDK_INT >= 21) {
            a = new lm();
        } else {
            a = new ln();
        }
    }

    public void setScrimColor(int i) {
        this.f = i;
        invalidate();
    }

    public void setDrawerListener(lo loVar) {
        this.t = loVar;
    }

    public void setDrawerLockMode(int i) {
        a(i, 3);
        a(i, 5);
    }

    public void a(int i, int i2) {
        int a = fv.a(i2, hg.g(this));
        if (a == 3) {
            this.p = i;
        } else if (a == 5) {
            this.q = i;
        }
        if (i != 0) {
            (a == 3 ? this.i : this.j).e();
        }
        View a2;
        switch (i) {
            case ve.CropImageView_fixAspectRatio /*1*/:
                a2 = a(a);
                if (a2 != null) {
                    i(a2);
                }
            case ve.CropImageView_aspectRatioX /*2*/:
                a2 = a(a);
                if (a2 != null) {
                    h(a2);
                }
            default:
        }
    }

    public int a(View view) {
        int e = e(view);
        if (e == 3) {
            return this.p;
        }
        if (e == 5) {
            return this.q;
        }
        return 0;
    }

    public void a(int i, int i2, View view) {
        int i3 = 1;
        int a = this.i.a();
        int a2 = this.j.a();
        if (!(a == 1 || a2 == 1)) {
            i3 = (a == 2 || a2 == 2) ? 2 : 0;
        }
        if (view != null && i2 == 0) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (layoutParams.b == 0.0f) {
                b(view);
            } else if (layoutParams.b == 1.0f) {
                c(view);
            }
        }
        if (i3 != this.m) {
            this.m = i3;
            if (this.t != null) {
                this.t.a(i3);
            }
        }
    }

    void b(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.d) {
            layoutParams.d = false;
            if (this.t != null) {
                this.t.b(view);
            }
            a(view, false);
            if (hasWindowFocus()) {
                View rootView = getRootView();
                if (rootView != null) {
                    rootView.sendAccessibilityEvent(32);
                }
            }
        }
    }

    void c(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.d) {
            layoutParams.d = true;
            if (this.t != null) {
                this.t.a(view);
            }
            a(view, true);
            view.requestFocus();
        }
    }

    private void a(View view, boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((z || g(childAt)) && !(z && childAt == view)) {
                hg.c(childAt, 4);
            } else {
                hg.c(childAt, 1);
            }
        }
    }

    void a(View view, float f) {
        if (this.t != null) {
            this.t.a(view, f);
        }
    }

    public void b(View view, float f) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f != layoutParams.b) {
            layoutParams.b = f;
            a(view, f);
        }
    }

    public float d(View view) {
        return ((LayoutParams) view.getLayoutParams()).b;
    }

    int e(View view) {
        return fv.a(((LayoutParams) view.getLayoutParams()).a, hg.g(this));
    }

    public boolean a(View view, int i) {
        return (e(view) & i) == i;
    }

    View a() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (((LayoutParams) childAt.getLayoutParams()).d) {
                return childAt;
            }
        }
        return null;
    }

    public View a(int i) {
        int a = fv.a(i, hg.g(this)) & 7;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((e(childAt) & 7) == a) {
                return childAt;
            }
        }
        return null;
    }

    static String b(int i) {
        if ((i & 3) == 3) {
            return "LEFT";
        }
        if ((i & 5) == 5) {
            return "RIGHT";
        }
        return Integer.toHexString(i);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.o = true;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.o = true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onMeasure(int r14, int r15) {
        /*
        r13 = this;
        r1 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        r7 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r4 = 0;
        r12 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r3 = android.view.View.MeasureSpec.getMode(r14);
        r5 = android.view.View.MeasureSpec.getMode(r15);
        r2 = android.view.View.MeasureSpec.getSize(r14);
        r0 = android.view.View.MeasureSpec.getSize(r15);
        if (r3 != r12) goto L_0x001b;
    L_0x0019:
        if (r5 == r12) goto L_0x0056;
    L_0x001b:
        r6 = r13.isInEditMode();
        if (r6 == 0) goto L_0x0058;
    L_0x0021:
        if (r3 != r7) goto L_0x0050;
    L_0x0023:
        if (r5 != r7) goto L_0x0054;
    L_0x0025:
        r1 = r0;
    L_0x0026:
        r13.setMeasuredDimension(r2, r1);
        r0 = r13.z;
        if (r0 == 0) goto L_0x0060;
    L_0x002d:
        r0 = hg.p(r13);
        if (r0 == 0) goto L_0x0060;
    L_0x0033:
        r0 = 1;
        r3 = r0;
    L_0x0035:
        r6 = hg.g(r13);
        r7 = r13.getChildCount();
        r5 = r4;
    L_0x003e:
        if (r5 >= r7) goto L_0x0138;
    L_0x0040:
        r8 = r13.getChildAt(r5);
        r0 = r8.getVisibility();
        r9 = 8;
        if (r0 != r9) goto L_0x0062;
    L_0x004c:
        r0 = r5 + 1;
        r5 = r0;
        goto L_0x003e;
    L_0x0050:
        if (r3 != 0) goto L_0x0023;
    L_0x0052:
        r2 = r1;
        goto L_0x0023;
    L_0x0054:
        if (r5 == 0) goto L_0x0026;
    L_0x0056:
        r1 = r0;
        goto L_0x0026;
    L_0x0058:
        r0 = new java.lang.IllegalArgumentException;
        r1 = "DrawerLayout must be measured with MeasureSpec.EXACTLY.";
        r0.<init>(r1);
        throw r0;
    L_0x0060:
        r3 = r4;
        goto L_0x0035;
    L_0x0062:
        r0 = r8.getLayoutParams();
        r0 = (android.support.v4.widget.DrawerLayout.LayoutParams) r0;
        if (r3 == 0) goto L_0x007d;
    L_0x006a:
        r9 = r0.a;
        r9 = fv.a(r9, r6);
        r10 = hg.p(r8);
        if (r10 == 0) goto L_0x009e;
    L_0x0076:
        r10 = a;
        r11 = r13.z;
        r10.a(r8, r11, r9);
    L_0x007d:
        r9 = r13.f(r8);
        if (r9 == 0) goto L_0x00a6;
    L_0x0083:
        r9 = r0.leftMargin;
        r9 = r2 - r9;
        r10 = r0.rightMargin;
        r9 = r9 - r10;
        r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r12);
        r10 = r0.topMargin;
        r10 = r1 - r10;
        r0 = r0.bottomMargin;
        r0 = r10 - r0;
        r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r12);
        r8.measure(r9, r0);
        goto L_0x004c;
    L_0x009e:
        r10 = a;
        r11 = r13.z;
        r10.a(r0, r11, r9);
        goto L_0x007d;
    L_0x00a6:
        r9 = r13.g(r8);
        if (r9 == 0) goto L_0x0109;
    L_0x00ac:
        r9 = r13.e(r8);
        r9 = r9 & 7;
        r10 = r4 & r9;
        if (r10 == 0) goto L_0x00eb;
    L_0x00b6:
        r0 = new java.lang.IllegalStateException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Child drawer has absolute gravity ";
        r1 = r1.append(r2);
        r2 = b(r9);
        r1 = r1.append(r2);
        r2 = " but this ";
        r1 = r1.append(r2);
        r2 = "DrawerLayout";
        r1 = r1.append(r2);
        r2 = " already has a ";
        r1 = r1.append(r2);
        r2 = "drawer view along that edge";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x00eb:
        r9 = r13.e;
        r10 = r0.leftMargin;
        r9 = r9 + r10;
        r10 = r0.rightMargin;
        r9 = r9 + r10;
        r10 = r0.width;
        r9 = getChildMeasureSpec(r14, r9, r10);
        r10 = r0.topMargin;
        r11 = r0.bottomMargin;
        r10 = r10 + r11;
        r0 = r0.height;
        r0 = getChildMeasureSpec(r15, r10, r0);
        r8.measure(r9, r0);
        goto L_0x004c;
    L_0x0109:
        r0 = new java.lang.IllegalStateException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Child ";
        r1 = r1.append(r2);
        r1 = r1.append(r8);
        r2 = " at index ";
        r1 = r1.append(r2);
        r1 = r1.append(r5);
        r2 = " does not have a valid layout_gravity - must be Gravity.LEFT, ";
        r1 = r1.append(r2);
        r2 = "Gravity.RIGHT or Gravity.NO_GRAVITY";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0138:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.DrawerLayout.onMeasure(int, int):void");
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.n = true;
        int i5 = i3 - i;
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (f(childAt)) {
                    childAt.layout(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.leftMargin + childAt.getMeasuredWidth(), layoutParams.topMargin + childAt.getMeasuredHeight());
                } else {
                    int i7;
                    float f;
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (a(childAt, 3)) {
                        i7 = ((int) (((float) measuredWidth) * layoutParams.b)) + (-measuredWidth);
                        f = ((float) (measuredWidth + i7)) / ((float) measuredWidth);
                    } else {
                        i7 = i5 - ((int) (((float) measuredWidth) * layoutParams.b));
                        f = ((float) (i5 - i7)) / ((float) measuredWidth);
                    }
                    Object obj = f != layoutParams.b ? 1 : null;
                    int i8;
                    switch (layoutParams.a & 112) {
                        case nv.Toolbar_maxButtonHeight /*16*/:
                            int i9 = i4 - i2;
                            i8 = (i9 - measuredHeight) / 2;
                            if (i8 < layoutParams.topMargin) {
                                i8 = layoutParams.topMargin;
                            } else if (i8 + measuredHeight > i9 - layoutParams.bottomMargin) {
                                i8 = (i9 - layoutParams.bottomMargin) - measuredHeight;
                            }
                            childAt.layout(i7, i8, measuredWidth + i7, measuredHeight + i8);
                            break;
                        case nv.Theme_colorControlHighlight /*80*/:
                            i8 = i4 - i2;
                            childAt.layout(i7, (i8 - layoutParams.bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i7, i8 - layoutParams.bottomMargin);
                            break;
                        default:
                            childAt.layout(i7, layoutParams.topMargin, measuredWidth + i7, measuredHeight + layoutParams.topMargin);
                            break;
                    }
                    if (obj != null) {
                        b(childAt, f);
                    }
                    int i10 = layoutParams.b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i10) {
                        childAt.setVisibility(i10);
                    }
                }
            }
        }
        this.n = false;
        this.o = false;
    }

    public void requestLayout() {
        if (!this.n) {
            super.requestLayout();
        }
    }

    public void computeScroll() {
        int childCount = getChildCount();
        float f = 0.0f;
        for (int i = 0; i < childCount; i++) {
            f = Math.max(f, ((LayoutParams) getChildAt(i).getLayoutParams()).b);
        }
        this.g = f;
        if ((this.i.a(true) | this.j.a(true)) != 0) {
            hg.d(this);
        }
    }

    private static boolean l(View view) {
        Drawable background = view.getBackground();
        if (background == null || background.getOpacity() != -1) {
            return false;
        }
        return true;
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.y = drawable;
    }

    public void setStatusBarBackground(int i) {
        this.y = i != 0 ? da.a(getContext(), i) : null;
    }

    public void setStatusBarBackgroundColor(int i) {
        this.y = new ColorDrawable(i);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.A && this.y != null) {
            int a = a.a(this.z);
            if (a > 0) {
                this.y.setBounds(0, 0, getWidth(), a);
                this.y.draw(canvas);
            }
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        int i;
        int height = getHeight();
        boolean f = f(view);
        int i2 = 0;
        int width = getWidth();
        int save = canvas.save();
        if (f) {
            int childCount = getChildCount();
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = getChildAt(i3);
                if (childAt != view && childAt.getVisibility() == 0 && l(childAt) && g(childAt)) {
                    if (childAt.getHeight() < height) {
                        i = width;
                    } else if (a(childAt, 3)) {
                        i = childAt.getRight();
                        if (i <= i2) {
                            i = i2;
                        }
                        i2 = i;
                        i = width;
                    } else {
                        i = childAt.getLeft();
                        if (i < width) {
                        }
                    }
                    i3++;
                    width = i;
                }
                i = width;
                i3++;
                width = i;
            }
            canvas.clipRect(i2, 0, width, getHeight());
        }
        i = width;
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        if (this.g > 0.0f && f) {
            this.h.setColor((((int) (((float) ((this.f & -16777216) >>> 24)) * this.g)) << 24) | (this.f & 16777215));
            canvas.drawRect((float) i2, 0.0f, (float) i, (float) getHeight(), this.h);
        } else if (this.w != null && a(view, 3)) {
            i = this.w.getIntrinsicWidth();
            i2 = view.getRight();
            r2 = Math.max(0.0f, Math.min(((float) i2) / ((float) this.i.b()), 1.0f));
            this.w.setBounds(i2, view.getTop(), i + i2, view.getBottom());
            this.w.setAlpha((int) (255.0f * r2));
            this.w.draw(canvas);
        } else if (this.x != null && a(view, 5)) {
            i = this.x.getIntrinsicWidth();
            i2 = view.getLeft();
            r2 = Math.max(0.0f, Math.min(((float) (getWidth() - i2)) / ((float) this.j.b()), 1.0f));
            this.x.setBounds(i2 - i, view.getTop(), i2, view.getBottom());
            this.x.setAlpha((int) (255.0f * r2));
            this.x.draw(canvas);
        }
        return drawChild;
    }

    boolean f(View view) {
        return ((LayoutParams) view.getLayoutParams()).a == 0;
    }

    public boolean g(View view) {
        return (fv.a(((LayoutParams) view.getLayoutParams()).a, hg.g(view)) & 7) != 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r8) {
        /*
        r7 = this;
        r1 = 1;
        r2 = 0;
        r0 = gu.a(r8);
        r3 = r7.i;
        r3 = r3.a(r8);
        r4 = r7.j;
        r4 = r4.a(r8);
        r3 = r3 | r4;
        switch(r0) {
            case 0: goto L_0x0027;
            case 1: goto L_0x0065;
            case 2: goto L_0x0050;
            case 3: goto L_0x0065;
            default: goto L_0x0016;
        };
    L_0x0016:
        r0 = r2;
    L_0x0017:
        if (r3 != 0) goto L_0x0025;
    L_0x0019:
        if (r0 != 0) goto L_0x0025;
    L_0x001b:
        r0 = r7.d();
        if (r0 != 0) goto L_0x0025;
    L_0x0021:
        r0 = r7.s;
        if (r0 == 0) goto L_0x0026;
    L_0x0025:
        r2 = r1;
    L_0x0026:
        return r2;
    L_0x0027:
        r0 = r8.getX();
        r4 = r8.getY();
        r7.u = r0;
        r7.v = r4;
        r5 = r7.g;
        r6 = 0;
        r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1));
        if (r5 <= 0) goto L_0x006d;
    L_0x003a:
        r5 = r7.i;
        r0 = (int) r0;
        r4 = (int) r4;
        r0 = r5.d(r0, r4);
        if (r0 == 0) goto L_0x006d;
    L_0x0044:
        r0 = r7.f(r0);
        if (r0 == 0) goto L_0x006d;
    L_0x004a:
        r0 = r1;
    L_0x004b:
        r7.r = r2;
        r7.s = r2;
        goto L_0x0017;
    L_0x0050:
        r0 = r7.i;
        r4 = 3;
        r0 = r0.d(r4);
        if (r0 == 0) goto L_0x0016;
    L_0x0059:
        r0 = r7.k;
        r0.a();
        r0 = r7.l;
        r0.a();
        r0 = r2;
        goto L_0x0017;
    L_0x0065:
        r7.a(r1);
        r7.r = r2;
        r7.s = r2;
        goto L_0x0016;
    L_0x006d:
        r0 = r2;
        goto L_0x004b;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.i.b(motionEvent);
        this.j.b(motionEvent);
        float x;
        float y;
        switch (motionEvent.getAction() & 255) {
            case ve.CropImageView_guidelines /*0*/:
                x = motionEvent.getX();
                y = motionEvent.getY();
                this.u = x;
                this.v = y;
                this.r = false;
                this.s = false;
                break;
            case ve.CropImageView_fixAspectRatio /*1*/:
                boolean z;
                x = motionEvent.getX();
                y = motionEvent.getY();
                View d = this.i.d((int) x, (int) y);
                if (d != null && f(d)) {
                    x -= this.u;
                    y -= this.v;
                    int d2 = this.i.d();
                    if ((x * x) + (y * y) < ((float) (d2 * d2))) {
                        View a = a();
                        if (a != null) {
                            z = a(a) == 2;
                            a(z);
                            this.r = false;
                            break;
                        }
                    }
                }
                z = true;
                a(z);
                this.r = false;
            case ve.CropImageView_aspectRatioY /*3*/:
                a(true);
                this.r = false;
                this.s = false;
                break;
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        this.r = z;
        if (z) {
            a(true);
        }
    }

    public void b() {
        a(false);
    }

    void a(boolean z) {
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (g(childAt) && (!z || layoutParams.c)) {
                int width = childAt.getWidth();
                if (a(childAt, 3)) {
                    i |= this.i.a(childAt, -width, childAt.getTop());
                } else {
                    i |= this.j.a(childAt, getWidth(), childAt.getTop());
                }
                layoutParams.c = false;
            }
        }
        this.k.a();
        this.l.a();
        if (i != 0) {
            invalidate();
        }
    }

    public void h(View view) {
        if (g(view)) {
            if (this.o) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                layoutParams.b = 1.0f;
                layoutParams.d = true;
                a(view, true);
            } else if (a(view, 3)) {
                this.i.a(view, 0, view.getTop());
            } else {
                this.j.a(view, getWidth() - view.getWidth(), view.getTop());
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public void i(View view) {
        if (g(view)) {
            if (this.o) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                layoutParams.b = 0.0f;
                layoutParams.d = false;
            } else if (a(view, 3)) {
                this.i.a(view, -view.getWidth(), view.getTop());
            } else {
                this.j.a(view, getWidth(), view.getTop());
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public boolean j(View view) {
        if (g(view)) {
            return ((LayoutParams) view.getLayoutParams()).b > 0.0f;
        } else {
            throw new IllegalArgumentException("View " + view + " is not a drawer");
        }
    }

    private boolean d() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((LayoutParams) getChildAt(i).getLayoutParams()).c) {
                return true;
            }
        }
        return false;
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        return layoutParams instanceof MarginLayoutParams ? new LayoutParams((MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    private boolean e() {
        return f() != null;
    }

    private View f() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (g(childAt) && j(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !e()) {
            return super.onKeyDown(i, keyEvent);
        }
        ga.b(keyEvent);
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        View f = f();
        if (f != null && a(f) == 0) {
            b();
        }
        return f != null;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.a != 0) {
            View a = a(savedState.a);
            if (a != null) {
                h(a);
            }
        }
        a(savedState.b, 3);
        a(savedState.c, 5);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        View a = a();
        if (a != null) {
            savedState.a = ((LayoutParams) a.getLayoutParams()).a;
        }
        savedState.b = this.p;
        savedState.c = this.q;
        return savedState;
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (a() != null || g(view)) {
            hg.c(view, 4);
        } else {
            hg.c(view, 1);
        }
        if (!c) {
            hg.a(view, this.d);
        }
    }

    private static boolean m(View view) {
        return (hg.e(view) == 4 || hg.e(view) == 2) ? false : true;
    }
}
