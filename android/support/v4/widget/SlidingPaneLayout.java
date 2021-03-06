package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import hg;
import java.util.ArrayList;
import mm;
import mn;
import mo;
import mp;
import mq;
import mr;
import ms;
import mt;
import ve;

public class SlidingPaneLayout extends ViewGroup {
    static final mp a;
    private int b;
    private int c;
    private Drawable d;
    private Drawable e;
    private final int f;
    private boolean g;
    private View h;
    private float i;
    private float j;
    private int k;
    private boolean l;
    private int m;
    private float n;
    private float o;
    private mn p;
    private final mt q;
    private boolean r;
    private boolean s;
    private final Rect t;
    private final ArrayList u;

    public class LayoutParams extends MarginLayoutParams {
        private static final int[] e;
        public float a;
        boolean b;
        boolean c;
        public Paint d;

        static {
            e = new int[]{16843137};
        }

        public LayoutParams() {
            super(-1, -1);
            this.a = 0.0f;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 0.0f;
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.a = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e);
            this.a = obtainStyledAttributes.getFloat(0, 0.0f);
            obtainStyledAttributes.recycle();
        }
    }

    public class SavedState extends BaseSavedState {
        public static final Creator CREATOR;
        boolean a;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readInt() != 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a ? 1 : 0);
        }

        static {
            CREATOR = new mo();
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 17) {
            a = new ms();
        } else if (i >= 16) {
            a = new mr();
        } else {
            a = new mq();
        }
    }

    public void setParallaxDistance(int i) {
        this.m = i;
        requestLayout();
    }

    public int getParallaxDistance() {
        return this.m;
    }

    public void setSliderFadeColor(int i) {
        this.b = i;
    }

    public int getSliderFadeColor() {
        return this.b;
    }

    public void setCoveredFadeColor(int i) {
        this.c = i;
    }

    public int getCoveredFadeColor() {
        return this.c;
    }

    public void setPanelSlideListener(mn mnVar) {
        this.p = mnVar;
    }

    void a(View view) {
        int paddingLeft;
        int i;
        boolean f = f();
        int width = f ? getWidth() - getPaddingRight() : getPaddingLeft();
        if (f) {
            paddingLeft = getPaddingLeft();
        } else {
            paddingLeft = getWidth() - getPaddingRight();
        }
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        int i2;
        int i3;
        int i4;
        if (view == null || !c(view)) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i = 0;
        } else {
            i = view.getLeft();
            i4 = view.getRight();
            i3 = view.getTop();
            i2 = view.getBottom();
        }
        int childCount = getChildCount();
        int i5 = 0;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt != view) {
                int i6;
                if (f) {
                    i6 = paddingLeft;
                } else {
                    i6 = width;
                }
                int max = Math.max(i6, childAt.getLeft());
                int max2 = Math.max(paddingTop, childAt.getTop());
                if (f) {
                    i6 = width;
                } else {
                    i6 = paddingLeft;
                }
                i6 = Math.min(i6, childAt.getRight());
                int min = Math.min(height, childAt.getBottom());
                if (max < i || max2 < r3 || i6 > r4 || min > r2) {
                    i6 = 0;
                } else {
                    i6 = 4;
                }
                childAt.setVisibility(i6);
                i5++;
            } else {
                return;
            }
        }
    }

    void a() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    private static boolean c(View view) {
        if (hg.h(view)) {
            return true;
        }
        if (VERSION.SDK_INT >= 18) {
            return false;
        }
        Drawable background = view.getBackground();
        if (background == null) {
            return false;
        }
        if (background.getOpacity() != -1) {
            return false;
        }
        return true;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.s = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.s = true;
        int size = this.u.size();
        for (int i = 0; i < size; i++) {
            ((mm) this.u.get(i)).run();
        }
        this.u.clear();
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            if (mode2 == 0) {
                if (!isInEditMode()) {
                    throw new IllegalStateException("Height must not be UNSPECIFIED");
                } else if (mode2 == 0) {
                    i3 = Integer.MIN_VALUE;
                    i4 = size;
                    size = 300;
                }
            }
            i3 = mode2;
            i4 = size;
            size = size2;
        } else if (!isInEditMode()) {
            throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
        } else if (mode == Integer.MIN_VALUE) {
            i3 = mode2;
            i4 = size;
            size = size2;
        } else {
            if (mode == 0) {
                i3 = mode2;
                i4 = 300;
                size = size2;
            }
            i3 = mode2;
            i4 = size;
            size = size2;
        }
        switch (i3) {
            case Integer.MIN_VALUE:
                size2 = 0;
                mode2 = (size - getPaddingTop()) - getPaddingBottom();
                break;
            case 1073741824:
                size2 = (size - getPaddingTop()) - getPaddingBottom();
                mode2 = size2;
                break;
            default:
                size2 = 0;
                mode2 = -1;
                break;
        }
        boolean z = false;
        int paddingLeft = (i4 - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        if (childCount > 2) {
            Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
        }
        this.h = null;
        int i5 = 0;
        int i6 = paddingLeft;
        int i7 = size2;
        float f = 0.0f;
        while (i5 < childCount) {
            float f2;
            int i8;
            boolean z2;
            View childAt = getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() == 8) {
                layoutParams.c = false;
                size2 = i6;
                f2 = f;
                i8 = i7;
                z2 = z;
            } else {
                if (layoutParams.a > 0.0f) {
                    f += layoutParams.a;
                    if (layoutParams.width == 0) {
                        size2 = i6;
                        f2 = f;
                        i8 = i7;
                        z2 = z;
                    }
                }
                mode = layoutParams.leftMargin + layoutParams.rightMargin;
                if (layoutParams.width == -2) {
                    mode = MeasureSpec.makeMeasureSpec(paddingLeft - mode, Integer.MIN_VALUE);
                } else if (layoutParams.width == -1) {
                    mode = MeasureSpec.makeMeasureSpec(paddingLeft - mode, 1073741824);
                } else {
                    mode = MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824);
                }
                if (layoutParams.height == -2) {
                    i8 = MeasureSpec.makeMeasureSpec(mode2, Integer.MIN_VALUE);
                } else if (layoutParams.height == -1) {
                    i8 = MeasureSpec.makeMeasureSpec(mode2, 1073741824);
                } else {
                    i8 = MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
                }
                childAt.measure(mode, i8);
                mode = childAt.getMeasuredWidth();
                i8 = childAt.getMeasuredHeight();
                if (i3 == Integer.MIN_VALUE && i8 > i7) {
                    i7 = Math.min(i8, mode2);
                }
                i8 = i6 - mode;
                boolean z3 = i8 < 0;
                layoutParams.b = z3;
                z3 |= z;
                if (layoutParams.b) {
                    this.h = childAt;
                }
                size2 = i8;
                i8 = i7;
                float f3 = f;
                z2 = z3;
                f2 = f3;
            }
            i5++;
            z = z2;
            i7 = i8;
            f = f2;
            i6 = size2;
        }
        if (z || f > 0.0f) {
            int i9 = paddingLeft - this.f;
            for (i3 = 0; i3 < childCount; i3++) {
                View childAt2 = getChildAt(i3);
                if (childAt2.getVisibility() != 8) {
                    layoutParams = (LayoutParams) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() != 8) {
                        Object obj = (layoutParams.width != 0 || layoutParams.a <= 0.0f) ? null : 1;
                        i8 = obj != null ? 0 : childAt2.getMeasuredWidth();
                        if (!z || childAt2 == this.h) {
                            if (layoutParams.a > 0.0f) {
                                if (layoutParams.width != 0) {
                                    mode = MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                                } else if (layoutParams.height == -2) {
                                    mode = MeasureSpec.makeMeasureSpec(mode2, Integer.MIN_VALUE);
                                } else if (layoutParams.height == -1) {
                                    mode = MeasureSpec.makeMeasureSpec(mode2, 1073741824);
                                } else {
                                    mode = MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
                                }
                                if (z) {
                                    size2 = paddingLeft - (layoutParams.rightMargin + layoutParams.leftMargin);
                                    i5 = MeasureSpec.makeMeasureSpec(size2, 1073741824);
                                    if (i8 != size2) {
                                        childAt2.measure(i5, mode);
                                    }
                                } else {
                                    childAt2.measure(MeasureSpec.makeMeasureSpec(((int) ((layoutParams.a * ((float) Math.max(0, i6))) / f)) + i8, 1073741824), mode);
                                }
                            }
                        } else if (layoutParams.width < 0 && (i8 > i9 || layoutParams.a > 0.0f)) {
                            if (obj == null) {
                                size2 = MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                            } else if (layoutParams.height == -2) {
                                size2 = MeasureSpec.makeMeasureSpec(mode2, Integer.MIN_VALUE);
                            } else if (layoutParams.height == -1) {
                                size2 = MeasureSpec.makeMeasureSpec(mode2, 1073741824);
                            } else {
                                size2 = MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
                            }
                            childAt2.measure(MeasureSpec.makeMeasureSpec(i9, 1073741824), size2);
                        }
                    }
                }
            }
        }
        setMeasuredDimension(i4, (getPaddingTop() + i7) + getPaddingBottom());
        this.g = z;
        if (this.q.a() != 0 && !z) {
            this.q.f();
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean f = f();
        if (f) {
            this.q.a(2);
        } else {
            this.q.a(1);
        }
        int i5 = i3 - i;
        int paddingRight = f ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = f ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.s) {
            float f2 = (this.g && this.r) ? 1.0f : 0.0f;
            this.i = f2;
        }
        int i6 = 0;
        int i7 = paddingRight;
        while (i6 < childCount) {
            int i8;
            int i9;
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() == 8) {
                i8 = paddingRight;
                i9 = i7;
            } else {
                int i10;
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (layoutParams.b) {
                    int min = (Math.min(paddingRight, (i5 - paddingLeft) - this.f) - i7) - (layoutParams.leftMargin + layoutParams.rightMargin);
                    this.k = min;
                    i9 = f ? layoutParams.rightMargin : layoutParams.leftMargin;
                    layoutParams.c = ((i7 + i9) + min) + (measuredWidth / 2) > i5 - paddingLeft;
                    i8 = (int) (((float) min) * this.i);
                    i10 = i7 + (i9 + i8);
                    this.i = ((float) i8) / ((float) this.k);
                    i8 = 0;
                } else if (!this.g || this.m == 0) {
                    i8 = 0;
                    i10 = paddingRight;
                } else {
                    i8 = (int) ((1.0f - this.i) * ((float) this.m));
                    i10 = paddingRight;
                }
                if (f) {
                    i9 = (i5 - i10) + i8;
                    i8 = i9 - measuredWidth;
                } else {
                    i8 = i10 - i8;
                    i9 = i8 + measuredWidth;
                }
                childAt.layout(i8, paddingTop, i9, childAt.getMeasuredHeight() + paddingTop);
                i8 = childAt.getWidth() + paddingRight;
                i9 = i10;
            }
            i6++;
            paddingRight = i8;
            i7 = i9;
        }
        if (this.s) {
            if (this.g) {
                if (this.m != 0) {
                    a(this.i);
                }
                if (((LayoutParams) this.h.getLayoutParams()).c) {
                    a(this.h, this.i, this.b);
                }
            } else {
                for (i8 = 0; i8 < childCount; i8++) {
                    a(getChildAt(i8), 0.0f, this.b);
                }
            }
            a(this.h);
        }
        this.s = false;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            this.s = true;
        }
    }

    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (!isInTouchMode() && !this.g) {
            this.r = view == this.h;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r8) {
        /*
        r7 = this;
        r2 = 0;
        r1 = 1;
        r3 = gu.a(r8);
        r0 = r7.g;
        if (r0 != 0) goto L_0x002d;
    L_0x000a:
        if (r3 != 0) goto L_0x002d;
    L_0x000c:
        r0 = r7.getChildCount();
        if (r0 <= r1) goto L_0x002d;
    L_0x0012:
        r0 = r7.getChildAt(r1);
        if (r0 == 0) goto L_0x002d;
    L_0x0018:
        r4 = r7.q;
        r5 = r8.getX();
        r5 = (int) r5;
        r6 = r8.getY();
        r6 = (int) r6;
        r0 = r4.b(r0, r5, r6);
        if (r0 != 0) goto L_0x0041;
    L_0x002a:
        r0 = r1;
    L_0x002b:
        r7.r = r0;
    L_0x002d:
        r0 = r7.g;
        if (r0 == 0) goto L_0x0037;
    L_0x0031:
        r0 = r7.l;
        if (r0 == 0) goto L_0x0043;
    L_0x0035:
        if (r3 == 0) goto L_0x0043;
    L_0x0037:
        r0 = r7.q;
        r0.e();
        r2 = super.onInterceptTouchEvent(r8);
    L_0x0040:
        return r2;
    L_0x0041:
        r0 = r2;
        goto L_0x002b;
    L_0x0043:
        r0 = 3;
        if (r3 == r0) goto L_0x0048;
    L_0x0046:
        if (r3 != r1) goto L_0x004e;
    L_0x0048:
        r0 = r7.q;
        r0.e();
        goto L_0x0040;
    L_0x004e:
        switch(r3) {
            case 0: goto L_0x005e;
            case 1: goto L_0x0051;
            case 2: goto L_0x0082;
            default: goto L_0x0051;
        };
    L_0x0051:
        r0 = r2;
    L_0x0052:
        r3 = r7.q;
        r3 = r3.a(r8);
        if (r3 != 0) goto L_0x005c;
    L_0x005a:
        if (r0 == 0) goto L_0x0040;
    L_0x005c:
        r2 = r1;
        goto L_0x0040;
    L_0x005e:
        r7.l = r2;
        r0 = r8.getX();
        r3 = r8.getY();
        r7.n = r0;
        r7.o = r3;
        r4 = r7.q;
        r5 = r7.h;
        r0 = (int) r0;
        r3 = (int) r3;
        r0 = r4.b(r5, r0, r3);
        if (r0 == 0) goto L_0x0051;
    L_0x0078:
        r0 = r7.h;
        r0 = r7.b(r0);
        if (r0 == 0) goto L_0x0051;
    L_0x0080:
        r0 = r1;
        goto L_0x0052;
    L_0x0082:
        r0 = r8.getX();
        r3 = r8.getY();
        r4 = r7.n;
        r0 = r0 - r4;
        r0 = java.lang.Math.abs(r0);
        r4 = r7.o;
        r3 = r3 - r4;
        r3 = java.lang.Math.abs(r3);
        r4 = r7.q;
        r4 = r4.d();
        r4 = (float) r4;
        r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r4 <= 0) goto L_0x0051;
    L_0x00a3:
        r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1));
        if (r0 <= 0) goto L_0x0051;
    L_0x00a7:
        r0 = r7.q;
        r0.e();
        r7.l = r1;
        goto L_0x0040;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.SlidingPaneLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.g) {
            return super.onTouchEvent(motionEvent);
        }
        this.q.b(motionEvent);
        float x;
        float y;
        switch (motionEvent.getAction() & 255) {
            case ve.CropImageView_guidelines /*0*/:
                x = motionEvent.getX();
                y = motionEvent.getY();
                this.n = x;
                this.o = y;
                return true;
            case ve.CropImageView_fixAspectRatio /*1*/:
                if (!b(this.h)) {
                    return true;
                }
                x = motionEvent.getX();
                y = motionEvent.getY();
                float f = x - this.n;
                float f2 = y - this.o;
                int d = this.q.d();
                if ((f * f) + (f2 * f2) >= ((float) (d * d)) || !this.q.b(this.h, (int) x, (int) y)) {
                    return true;
                }
                a(this.h, 0);
                return true;
            default:
                return true;
        }
    }

    private boolean a(View view, int i) {
        if (!this.s && !a(0.0f, i)) {
            return false;
        }
        this.r = false;
        return true;
    }

    private boolean b(View view, int i) {
        if (!this.s && !a(1.0f, i)) {
            return false;
        }
        this.r = true;
        return true;
    }

    public boolean b() {
        return b(this.h, 0);
    }

    public boolean c() {
        return a(this.h, 0);
    }

    public boolean d() {
        return !this.g || this.i == 1.0f;
    }

    public boolean e() {
        return this.g;
    }

    private void a(View view, float f, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f > 0.0f && i != 0) {
            int i2 = (((int) (((float) ((-16777216 & i) >>> 24)) * f)) << 24) | (16777215 & i);
            if (layoutParams.d == null) {
                layoutParams.d = new Paint();
            }
            layoutParams.d.setColorFilter(new PorterDuffColorFilter(i2, Mode.SRC_OVER));
            if (hg.f(view) != 2) {
                hg.a(view, 2, layoutParams.d);
            }
            d(view);
        } else if (hg.f(view) != 0) {
            if (layoutParams.d != null) {
                layoutParams.d.setColorFilter(null);
            }
            Runnable mmVar = new mm(this, view);
            this.u.add(mmVar);
            hg.a((View) this, mmVar);
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean drawChild;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int save = canvas.save(2);
        if (!(!this.g || layoutParams.b || this.h == null)) {
            canvas.getClipBounds(this.t);
            if (f()) {
                this.t.left = Math.max(this.t.left, this.h.getRight());
            } else {
                this.t.right = Math.min(this.t.right, this.h.getLeft());
            }
            canvas.clipRect(this.t);
        }
        if (VERSION.SDK_INT >= 11) {
            drawChild = super.drawChild(canvas, view, j);
        } else if (!layoutParams.c || this.i <= 0.0f) {
            if (view.isDrawingCacheEnabled()) {
                view.setDrawingCacheEnabled(false);
            }
            drawChild = super.drawChild(canvas, view, j);
        } else {
            if (!view.isDrawingCacheEnabled()) {
                view.setDrawingCacheEnabled(true);
            }
            Bitmap drawingCache = view.getDrawingCache();
            if (drawingCache != null) {
                canvas.drawBitmap(drawingCache, (float) view.getLeft(), (float) view.getTop(), layoutParams.d);
                drawChild = false;
            } else {
                Log.e("SlidingPaneLayout", "drawChild: child view " + view + " returned null drawing cache");
                drawChild = super.drawChild(canvas, view, j);
            }
        }
        canvas.restoreToCount(save);
        return drawChild;
    }

    private void d(View view) {
        a.a(this, view);
    }

    boolean a(float f, int i) {
        if (!this.g) {
            return false;
        }
        int width;
        LayoutParams layoutParams = (LayoutParams) this.h.getLayoutParams();
        if (f()) {
            width = (int) (((float) getWidth()) - ((((float) (layoutParams.rightMargin + getPaddingRight())) + (((float) this.k) * f)) + ((float) this.h.getWidth())));
        } else {
            width = (int) (((float) (layoutParams.leftMargin + getPaddingLeft())) + (((float) this.k) * f));
        }
        if (!this.q.a(this.h, width, this.h.getTop())) {
            return false;
        }
        a();
        hg.d(this);
        return true;
    }

    public void computeScroll() {
        if (!this.q.a(true)) {
            return;
        }
        if (this.g) {
            hg.d(this);
        } else {
            this.q.f();
        }
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(Drawable drawable) {
        this.d = drawable;
    }

    public void setShadowDrawableRight(Drawable drawable) {
        this.e = drawable;
    }

    @Deprecated
    public void setShadowResource(int i) {
        setShadowDrawable(getResources().getDrawable(i));
    }

    public void setShadowResourceLeft(int i) {
        setShadowDrawableLeft(getResources().getDrawable(i));
    }

    public void setShadowResourceRight(int i) {
        setShadowDrawableRight(getResources().getDrawable(i));
    }

    public void draw(Canvas canvas) {
        Drawable drawable;
        super.draw(canvas);
        if (f()) {
            drawable = this.e;
        } else {
            drawable = this.d;
        }
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt != null && drawable != null) {
            int right;
            int i;
            int top = childAt.getTop();
            int bottom = childAt.getBottom();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (f()) {
                right = childAt.getRight();
                i = right + intrinsicWidth;
            } else {
                i = childAt.getLeft();
                right = i - intrinsicWidth;
            }
            drawable.setBounds(right, top, i, bottom);
            drawable.draw(canvas);
        }
    }

    private void a(float f) {
        Object obj;
        int childCount;
        int i;
        View childAt;
        int i2;
        boolean f2 = f();
        LayoutParams layoutParams = (LayoutParams) this.h.getLayoutParams();
        if (layoutParams.c) {
            if ((f2 ? layoutParams.rightMargin : layoutParams.leftMargin) <= 0) {
                obj = 1;
                childCount = getChildCount();
                for (i = 0; i < childCount; i++) {
                    childAt = getChildAt(i);
                    if (childAt == this.h) {
                        i2 = (int) ((1.0f - this.j) * ((float) this.m));
                        this.j = f;
                        i2 -= (int) ((1.0f - f) * ((float) this.m));
                        if (f2) {
                            i2 = -i2;
                        }
                        childAt.offsetLeftAndRight(i2);
                        if (obj == null) {
                            a(childAt, f2 ? this.j - 1.0f : 1.0f - this.j, this.c);
                        }
                    }
                }
            }
        }
        obj = null;
        childCount = getChildCount();
        for (i = 0; i < childCount; i++) {
            childAt = getChildAt(i);
            if (childAt == this.h) {
                i2 = (int) ((1.0f - this.j) * ((float) this.m));
                this.j = f;
                i2 -= (int) ((1.0f - f) * ((float) this.m));
                if (f2) {
                    i2 = -i2;
                }
                childAt.offsetLeftAndRight(i2);
                if (obj == null) {
                    if (f2) {
                    }
                    a(childAt, f2 ? this.j - 1.0f : 1.0f - this.j, this.c);
                }
            }
        }
    }

    boolean b(View view) {
        if (view == null) {
            return false;
        }
        boolean z = this.g && ((LayoutParams) view.getLayoutParams()).c && this.i > 0.0f;
        return z;
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof MarginLayoutParams ? new LayoutParams((MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = e() ? d() : this.r;
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.a) {
            b();
        } else {
            c();
        }
        this.r = savedState.a;
    }

    private boolean f() {
        return hg.g(this) == 1;
    }
}
