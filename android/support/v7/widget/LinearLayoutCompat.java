package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import fv;
import hg;
import nv;
import org.kxml2.kdom.Node;
import rn;
import rt;
import ve;

public class LinearLayoutCompat extends ViewGroup {
    private boolean a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private float g;
    private boolean h;
    private int[] i;
    private int[] j;
    private Drawable k;
    private int l;
    private int m;
    private int n;
    private int o;

    public class LayoutParams extends MarginLayoutParams {
        public float g;
        public int h;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.h = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, nv.LinearLayoutCompat_Layout);
            this.g = obtainStyledAttributes.getFloat(nv.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
            this.h = obtainStyledAttributes.getInt(nv.LinearLayoutCompat_Layout_android_layout_gravity, -1);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.h = -1;
            this.g = 0.0f;
        }

        public LayoutParams(int i, int i2, float f) {
            super(i, i2);
            this.h = -1;
            this.g = f;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.h = -1;
        }
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return j();
    }

    public /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return b(attributeSet);
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return b(layoutParams);
    }

    public LinearLayoutCompat(Context context) {
        this(context, null);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = true;
        this.b = -1;
        this.c = 0;
        this.e = 8388659;
        rn a = rn.a(context, attributeSet, nv.LinearLayoutCompat, i, 0);
        int a2 = a.a(nv.LinearLayoutCompat_android_orientation, -1);
        if (a2 >= 0) {
            setOrientation(a2);
        }
        a2 = a.a(nv.LinearLayoutCompat_android_gravity, -1);
        if (a2 >= 0) {
            setGravity(a2);
        }
        boolean a3 = a.a(nv.LinearLayoutCompat_android_baselineAligned, true);
        if (!a3) {
            setBaselineAligned(a3);
        }
        this.g = a.a(nv.LinearLayoutCompat_android_weightSum, -1.0f);
        this.b = a.a(nv.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.h = a.a(nv.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(a.a(nv.LinearLayoutCompat_divider));
        this.n = a.a(nv.LinearLayoutCompat_showDividers, 0);
        this.o = a.d(nv.LinearLayoutCompat_dividerPadding, 0);
        a.b();
    }

    public void setShowDividers(int i) {
        if (i != this.n) {
            requestLayout();
        }
        this.n = i;
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public int getShowDividers() {
        return this.n;
    }

    public Drawable getDividerDrawable() {
        return this.k;
    }

    public void setDividerDrawable(Drawable drawable) {
        boolean z = false;
        if (drawable != this.k) {
            this.k = drawable;
            if (drawable != null) {
                this.l = drawable.getIntrinsicWidth();
                this.m = drawable.getIntrinsicHeight();
            } else {
                this.l = 0;
                this.m = 0;
            }
            if (drawable == null) {
                z = true;
            }
            setWillNotDraw(z);
            requestLayout();
        }
    }

    public void setDividerPadding(int i) {
        this.o = i;
    }

    public int getDividerPadding() {
        return this.o;
    }

    public int getDividerWidth() {
        return this.l;
    }

    protected void onDraw(Canvas canvas) {
        if (this.k != null) {
            if (this.d == 1) {
                a(canvas);
            } else {
                b(canvas);
            }
        }
    }

    void a(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        int i = 0;
        while (i < virtualChildCount) {
            View b = b(i);
            if (!(b == null || b.getVisibility() == 8 || !c(i))) {
                a(canvas, (b.getTop() - ((LayoutParams) b.getLayoutParams()).topMargin) - this.m);
            }
            i++;
        }
        if (c(virtualChildCount)) {
            int height;
            View b2 = b(virtualChildCount - 1);
            if (b2 == null) {
                height = (getHeight() - getPaddingBottom()) - this.m;
            } else {
                LayoutParams layoutParams = (LayoutParams) b2.getLayoutParams();
                height = layoutParams.bottomMargin + b2.getBottom();
            }
            a(canvas, height);
        }
    }

    void b(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        boolean a = rt.a(this);
        int i = 0;
        while (i < virtualChildCount) {
            LayoutParams layoutParams;
            int right;
            View b = b(i);
            if (!(b == null || b.getVisibility() == 8 || !c(i))) {
                layoutParams = (LayoutParams) b.getLayoutParams();
                if (a) {
                    right = layoutParams.rightMargin + b.getRight();
                } else {
                    right = (b.getLeft() - layoutParams.leftMargin) - this.l;
                }
                b(canvas, right);
            }
            i++;
        }
        if (c(virtualChildCount)) {
            View b2 = b(virtualChildCount - 1);
            if (b2 != null) {
                layoutParams = (LayoutParams) b2.getLayoutParams();
                if (a) {
                    right = (b2.getLeft() - layoutParams.leftMargin) - this.l;
                } else {
                    right = layoutParams.rightMargin + b2.getRight();
                }
            } else if (a) {
                right = getPaddingLeft();
            } else {
                right = (getWidth() - getPaddingRight()) - this.l;
            }
            b(canvas, right);
        }
    }

    void a(Canvas canvas, int i) {
        this.k.setBounds(getPaddingLeft() + this.o, i, (getWidth() - getPaddingRight()) - this.o, this.m + i);
        this.k.draw(canvas);
    }

    void b(Canvas canvas, int i) {
        this.k.setBounds(i, getPaddingTop() + this.o, this.l + i, (getHeight() - getPaddingBottom()) - this.o);
        this.k.draw(canvas);
    }

    public void setBaselineAligned(boolean z) {
        this.a = z;
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.h = z;
    }

    public int getBaseline() {
        if (this.b < 0) {
            return super.getBaseline();
        }
        if (getChildCount() <= this.b) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(this.b);
        int baseline = childAt.getBaseline();
        if (baseline != -1) {
            int i;
            int i2 = this.c;
            if (this.d == 1) {
                i = this.e & 112;
                if (i != 48) {
                    switch (i) {
                        case nv.Toolbar_maxButtonHeight /*16*/:
                            i = i2 + (((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f) / 2);
                            break;
                        case nv.Theme_colorControlHighlight /*80*/:
                            i = ((getBottom() - getTop()) - getPaddingBottom()) - this.f;
                            break;
                    }
                }
            }
            i = i2;
            return (((LayoutParams) childAt.getLayoutParams()).topMargin + i) + baseline;
        } else if (this.b == 0) {
            return -1;
        } else {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
    }

    public int getBaselineAlignedChildIndex() {
        return this.b;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i < 0 || i >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.b = i;
    }

    View b(int i) {
        return getChildAt(i);
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.g;
    }

    public void setWeightSum(float f) {
        this.g = Math.max(0.0f, f);
    }

    public void onMeasure(int i, int i2) {
        if (this.d == 1) {
            a(i, i2);
        } else {
            b(i, i2);
        }
    }

    protected boolean c(int i) {
        if (i == 0) {
            if ((this.n & 1) != 0) {
                return true;
            }
            return false;
        } else if (i == getChildCount()) {
            if ((this.n & 4) == 0) {
                return false;
            }
            return true;
        } else if ((this.n & 2) == 0) {
            return false;
        } else {
            for (int i2 = i - 1; i2 >= 0; i2--) {
                if (getChildAt(i2).getVisibility() != 8) {
                    return true;
                }
            }
            return false;
        }
    }

    void a(int i, int i2) {
        int i3;
        int i4;
        int i5;
        View b;
        this.f = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        Object obj = 1;
        float f = 0.0f;
        int virtualChildCount = getVirtualChildCount();
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        Object obj2 = null;
        Object obj3 = null;
        int i10 = this.b;
        boolean z = this.h;
        int i11 = Integer.MIN_VALUE;
        int i12 = 0;
        while (i12 < virtualChildCount) {
            Object obj4;
            Object obj5;
            int i13;
            View b2 = b(i12);
            if (b2 == null) {
                this.f += d(i12);
                i3 = i11;
                obj4 = obj3;
                obj5 = obj;
                i4 = i7;
                i13 = i6;
            } else if (b2.getVisibility() == 8) {
                i12 += a(b2, i12);
                i3 = i11;
                obj4 = obj3;
                obj5 = obj;
                i4 = i7;
                i13 = i6;
            } else {
                if (c(i12)) {
                    this.f += this.m;
                }
                LayoutParams layoutParams = (LayoutParams) b2.getLayoutParams();
                float f2 = f + layoutParams.g;
                if (mode2 == 1073741824 && layoutParams.height == 0 && layoutParams.g > 0.0f) {
                    i3 = this.f;
                    this.f = Math.max(i3, (layoutParams.topMargin + i3) + layoutParams.bottomMargin);
                    obj3 = 1;
                } else {
                    i3 = Integer.MIN_VALUE;
                    if (layoutParams.height == 0 && layoutParams.g > 0.0f) {
                        i3 = 0;
                        layoutParams.height = -2;
                    }
                    int i14 = i3;
                    a(b2, i12, i, 0, i2, f2 == 0.0f ? this.f : 0);
                    if (i14 != Integer.MIN_VALUE) {
                        layoutParams.height = i14;
                    }
                    i3 = b2.getMeasuredHeight();
                    int i15 = this.f;
                    this.f = Math.max(i15, (((i15 + i3) + layoutParams.topMargin) + layoutParams.bottomMargin) + b(b2));
                    if (z) {
                        i11 = Math.max(i3, i11);
                    }
                }
                if (i10 >= 0 && i10 == i12 + 1) {
                    this.c = this.f;
                }
                if (i12 >= i10 || layoutParams.g <= 0.0f) {
                    Object obj6;
                    Object obj7 = null;
                    if (mode == 1073741824 || layoutParams.width != -1) {
                        obj6 = obj2;
                    } else {
                        obj6 = 1;
                        obj7 = 1;
                    }
                    i4 = layoutParams.rightMargin + layoutParams.leftMargin;
                    i13 = b2.getMeasuredWidth() + i4;
                    i6 = Math.max(i6, i13);
                    int a = rt.a(i7, hg.i(b2));
                    obj5 = (obj == null || layoutParams.width != -1) ? null : 1;
                    if (layoutParams.g > 0.0f) {
                        if (obj7 != null) {
                            i3 = i4;
                        } else {
                            i3 = i13;
                        }
                        i3 = Math.max(i9, i3);
                        i4 = i8;
                    } else {
                        if (obj7 == null) {
                            i4 = i13;
                        }
                        i4 = Math.max(i8, i4);
                        i3 = i9;
                    }
                    i12 += a(b2, i12);
                    obj4 = obj3;
                    i9 = i3;
                    i8 = i4;
                    i13 = i6;
                    i3 = i11;
                    i4 = a;
                    obj2 = obj6;
                    f = f2;
                } else {
                    throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                }
            }
            i12++;
            i11 = i3;
            obj3 = obj4;
            obj = obj5;
            i7 = i4;
            i6 = i13;
        }
        if (this.f > 0 && c(virtualChildCount)) {
            this.f += this.m;
        }
        if (z && (mode2 == Integer.MIN_VALUE || mode2 == 0)) {
            this.f = 0;
            i5 = 0;
            while (i5 < virtualChildCount) {
                b = b(i5);
                if (b == null) {
                    this.f += d(i5);
                    i3 = i5;
                } else if (b.getVisibility() == 8) {
                    i3 = a(b, i5) + i5;
                } else {
                    LayoutParams layoutParams2 = (LayoutParams) b.getLayoutParams();
                    int i16 = this.f;
                    this.f = Math.max(i16, (layoutParams2.bottomMargin + ((i16 + i11) + layoutParams2.topMargin)) + b(b));
                    i3 = i5;
                }
                i5 = i3 + 1;
            }
        }
        this.f += getPaddingTop() + getPaddingBottom();
        int a2 = hg.a(Math.max(this.f, getSuggestedMinimumHeight()), i2, 0);
        i5 = (16777215 & a2) - this.f;
        int i17;
        if (obj3 != null || (i5 != 0 && f > 0.0f)) {
            if (this.g > 0.0f) {
                f = this.g;
            }
            this.f = 0;
            i11 = 0;
            float f3 = f;
            Object obj8 = obj;
            i17 = i8;
            i16 = i7;
            i9 = i6;
            i15 = i5;
            while (i11 < virtualChildCount) {
                View b3 = b(i11);
                if (b3.getVisibility() == 8) {
                    i3 = i17;
                    i5 = i16;
                    i4 = i9;
                    obj5 = obj8;
                } else {
                    float f4;
                    float f5;
                    layoutParams2 = (LayoutParams) b3.getLayoutParams();
                    float f6 = layoutParams2.g;
                    if (f6 > 0.0f) {
                        i5 = (int) ((((float) i15) * f6) / f3);
                        f3 -= f6;
                        i15 -= i5;
                        i4 = getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + layoutParams2.leftMargin) + layoutParams2.rightMargin, layoutParams2.width);
                        if (layoutParams2.height == 0 && mode2 == 1073741824) {
                            if (i5 <= 0) {
                                i5 = 0;
                            }
                            b3.measure(i4, MeasureSpec.makeMeasureSpec(i5, 1073741824));
                        } else {
                            i5 += b3.getMeasuredHeight();
                            if (i5 < 0) {
                                i5 = 0;
                            }
                            b3.measure(i4, MeasureSpec.makeMeasureSpec(i5, 1073741824));
                        }
                        f4 = f3;
                        i12 = i15;
                        i15 = rt.a(i16, hg.i(b3) & -256);
                        f5 = f4;
                    } else {
                        f5 = f3;
                        i12 = i15;
                        i15 = i16;
                    }
                    i16 = layoutParams2.leftMargin + layoutParams2.rightMargin;
                    i4 = b3.getMeasuredWidth() + i16;
                    i9 = Math.max(i9, i4);
                    Object obj9 = (mode == 1073741824 || layoutParams2.width != -1) ? null : 1;
                    if (obj9 == null) {
                        i16 = i4;
                    }
                    i4 = Math.max(i17, i16);
                    obj5 = (obj8 == null || layoutParams2.width != -1) ? null : 1;
                    i13 = this.f;
                    this.f = Math.max(i13, (layoutParams2.bottomMargin + ((b3.getMeasuredHeight() + i13) + layoutParams2.topMargin)) + b(b3));
                    i3 = i4;
                    i4 = i9;
                    f4 = f5;
                    i5 = i15;
                    i15 = i12;
                    f3 = f4;
                }
                i11++;
                i17 = i3;
                i9 = i4;
                obj8 = obj5;
                i16 = i5;
            }
            this.f += getPaddingTop() + getPaddingBottom();
            obj = obj8;
            i3 = i17;
            i7 = i16;
            i5 = i9;
        } else {
            i17 = Math.max(i8, i9);
            if (z && mode2 != 1073741824) {
                for (i5 = 0; i5 < virtualChildCount; i5++) {
                    b = b(i5);
                    if (!(b == null || b.getVisibility() == 8 || ((LayoutParams) b.getLayoutParams()).g <= 0.0f)) {
                        b.measure(MeasureSpec.makeMeasureSpec(b.getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(i11, 1073741824));
                    }
                }
            }
            i3 = i17;
            i5 = i6;
        }
        if (obj != null || mode == 1073741824) {
            i3 = i5;
        }
        setMeasuredDimension(hg.a(Math.max(i3 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, i7), a2);
        if (obj2 != null) {
            c(virtualChildCount, i2);
        }
    }

    private void c(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View b = b(i3);
            if (b.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) b.getLayoutParams();
                if (layoutParams.width == -1) {
                    int i4 = layoutParams.height;
                    layoutParams.height = b.getMeasuredHeight();
                    measureChildWithMargins(b, makeMeasureSpec, 0, i2, 0);
                    layoutParams.height = i4;
                }
            }
        }
    }

    void b(int i, int i2) {
        Object obj;
        int i3;
        int i4;
        int i5;
        LayoutParams layoutParams;
        this.f = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        Object obj2 = 1;
        float f = 0.0f;
        int virtualChildCount = getVirtualChildCount();
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        Object obj3 = null;
        Object obj4 = null;
        if (this.i == null || this.j == null) {
            this.i = new int[4];
            this.j = new int[4];
        }
        int[] iArr = this.i;
        int[] iArr2 = this.j;
        iArr[3] = -1;
        iArr[2] = -1;
        iArr[1] = -1;
        iArr[0] = -1;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        boolean z = this.a;
        boolean z2 = this.h;
        if (mode == 1073741824) {
            obj = 1;
        } else {
            obj = null;
        }
        int i10 = Integer.MIN_VALUE;
        int i11 = 0;
        while (i11 < virtualChildCount) {
            Object obj5;
            Object obj6;
            int i12;
            View b = b(i11);
            if (b == null) {
                this.f += d(i11);
                i3 = i10;
                obj5 = obj4;
                obj6 = obj2;
                i12 = i7;
                i4 = i6;
            } else if (b.getVisibility() == 8) {
                i11 += a(b, i11);
                i3 = i10;
                obj5 = obj4;
                obj6 = obj2;
                i12 = i7;
                i4 = i6;
            } else {
                Object obj7;
                if (c(i11)) {
                    this.f += this.l;
                }
                LayoutParams layoutParams2 = (LayoutParams) b.getLayoutParams();
                float f2 = f + layoutParams2.g;
                if (mode == 1073741824 && layoutParams2.width == 0 && layoutParams2.g > 0.0f) {
                    if (obj != null) {
                        this.f += layoutParams2.leftMargin + layoutParams2.rightMargin;
                    } else {
                        i3 = this.f;
                        this.f = Math.max(i3, (layoutParams2.leftMargin + i3) + layoutParams2.rightMargin);
                    }
                    if (z) {
                        i3 = MeasureSpec.makeMeasureSpec(0, 0);
                        b.measure(i3, i3);
                    } else {
                        obj4 = 1;
                    }
                } else {
                    i3 = Integer.MIN_VALUE;
                    if (layoutParams2.width == 0 && layoutParams2.g > 0.0f) {
                        i3 = 0;
                        layoutParams2.width = -2;
                    }
                    int i13 = i3;
                    a(b, i11, i, f2 == 0.0f ? this.f : 0, i2, 0);
                    if (i13 != Integer.MIN_VALUE) {
                        layoutParams2.width = i13;
                    }
                    i3 = b.getMeasuredWidth();
                    if (obj != null) {
                        this.f += ((layoutParams2.leftMargin + i3) + layoutParams2.rightMargin) + b(b);
                    } else {
                        int i14 = this.f;
                        this.f = Math.max(i14, (((i14 + i3) + layoutParams2.leftMargin) + layoutParams2.rightMargin) + b(b));
                    }
                    if (z2) {
                        i10 = Math.max(i3, i10);
                    }
                }
                Object obj8 = null;
                if (mode2 == 1073741824 || layoutParams2.height != -1) {
                    obj7 = obj3;
                } else {
                    obj7 = 1;
                    obj8 = 1;
                }
                i12 = layoutParams2.bottomMargin + layoutParams2.topMargin;
                i4 = b.getMeasuredHeight() + i12;
                int a = rt.a(i7, hg.i(b));
                if (z) {
                    i7 = b.getBaseline();
                    if (i7 != -1) {
                        int i15 = ((((layoutParams2.h < 0 ? this.e : layoutParams2.h) & 112) >> 4) & -2) >> 1;
                        iArr[i15] = Math.max(iArr[i15], i7);
                        iArr2[i15] = Math.max(iArr2[i15], i4 - i7);
                    }
                }
                i7 = Math.max(i6, i4);
                obj6 = (obj2 == null || layoutParams2.height != -1) ? null : 1;
                if (layoutParams2.g > 0.0f) {
                    if (obj8 != null) {
                        i3 = i12;
                    } else {
                        i3 = i4;
                    }
                    i3 = Math.max(i9, i3);
                    i12 = i8;
                } else {
                    if (obj8 == null) {
                        i12 = i4;
                    }
                    i12 = Math.max(i8, i12);
                    i3 = i9;
                }
                i11 += a(b, i11);
                obj5 = obj4;
                i9 = i3;
                i8 = i12;
                i4 = i7;
                i3 = i10;
                i12 = a;
                obj3 = obj7;
                f = f2;
            }
            i11++;
            i10 = i3;
            obj4 = obj5;
            obj2 = obj6;
            i7 = i12;
            i6 = i4;
        }
        if (this.f > 0 && c(virtualChildCount)) {
            this.f += this.l;
        }
        if (iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1) {
            i11 = i6;
        } else {
            i11 = Math.max(i6, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
        }
        if (z2 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.f = 0;
            i5 = 0;
            while (i5 < virtualChildCount) {
                View b2 = b(i5);
                if (b2 == null) {
                    this.f += d(i5);
                    i3 = i5;
                } else if (b2.getVisibility() == 8) {
                    i3 = a(b2, i5) + i5;
                } else {
                    layoutParams = (LayoutParams) b2.getLayoutParams();
                    if (obj != null) {
                        this.f = ((layoutParams.rightMargin + (layoutParams.leftMargin + i10)) + b(b2)) + this.f;
                        i3 = i5;
                    } else {
                        i12 = this.f;
                        this.f = Math.max(i12, (layoutParams.rightMargin + ((i12 + i10) + layoutParams.leftMargin)) + b(b2));
                        i3 = i5;
                    }
                }
                i5 = i3 + 1;
            }
        }
        this.f += getPaddingLeft() + getPaddingRight();
        int a2 = hg.a(Math.max(this.f, getSuggestedMinimumWidth()), i, 0);
        i5 = (16777215 & a2) - this.f;
        int i16;
        if (obj4 != null || (i5 != 0 && f > 0.0f)) {
            if (this.g > 0.0f) {
                f = this.g;
            }
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            this.f = 0;
            i10 = 0;
            float f3 = f;
            Object obj9 = obj2;
            i16 = i8;
            i15 = i7;
            i14 = i5;
            i8 = -1;
            while (i10 < virtualChildCount) {
                float f4;
                Object obj10;
                View b3 = b(i10);
                if (b3 == null) {
                    f4 = f3;
                    i5 = i14;
                    i12 = i8;
                    i14 = i16;
                    obj10 = obj9;
                } else if (b3.getVisibility() == 8) {
                    f4 = f3;
                    i5 = i14;
                    i12 = i8;
                    i14 = i16;
                    obj10 = obj9;
                } else {
                    float f5;
                    layoutParams = (LayoutParams) b3.getLayoutParams();
                    float f6 = layoutParams.g;
                    if (f6 > 0.0f) {
                        i5 = (int) ((((float) i14) * f6) / f3);
                        f3 -= f6;
                        i12 = i14 - i5;
                        i14 = getChildMeasureSpec(i2, ((getPaddingTop() + getPaddingBottom()) + layoutParams.topMargin) + layoutParams.bottomMargin, layoutParams.height);
                        if (layoutParams.width == 0 && mode == 1073741824) {
                            if (i5 <= 0) {
                                i5 = 0;
                            }
                            b3.measure(MeasureSpec.makeMeasureSpec(i5, 1073741824), i14);
                        } else {
                            i5 += b3.getMeasuredWidth();
                            if (i5 < 0) {
                                i5 = 0;
                            }
                            b3.measure(MeasureSpec.makeMeasureSpec(i5, 1073741824), i14);
                        }
                        i9 = rt.a(i15, hg.i(b3) & -16777216);
                        f5 = f3;
                    } else {
                        i12 = i14;
                        i9 = i15;
                        f5 = f3;
                    }
                    if (obj != null) {
                        this.f += ((b3.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin) + b(b3);
                    } else {
                        i5 = this.f;
                        this.f = Math.max(i5, (((b3.getMeasuredWidth() + i5) + layoutParams.leftMargin) + layoutParams.rightMargin) + b(b3));
                    }
                    obj5 = (mode2 == 1073741824 || layoutParams.height != -1) ? null : 1;
                    i11 = layoutParams.topMargin + layoutParams.bottomMargin;
                    i14 = b3.getMeasuredHeight() + i11;
                    i8 = Math.max(i8, i14);
                    if (obj5 != null) {
                        i5 = i11;
                    } else {
                        i5 = i14;
                    }
                    i11 = Math.max(i16, i5);
                    obj5 = (obj9 == null || layoutParams.height != -1) ? null : 1;
                    if (z) {
                        i4 = b3.getBaseline();
                        if (i4 != -1) {
                            i3 = ((((layoutParams.h < 0 ? this.e : layoutParams.h) & 112) >> 4) & -2) >> 1;
                            iArr[i3] = Math.max(iArr[i3], i4);
                            iArr2[i3] = Math.max(iArr2[i3], i14 - i4);
                        }
                    }
                    f4 = f5;
                    i14 = i11;
                    obj10 = obj5;
                    i15 = i9;
                    i5 = i12;
                    i12 = i8;
                }
                i10++;
                i16 = i14;
                i8 = i12;
                obj9 = obj10;
                i14 = i5;
                f3 = f4;
            }
            this.f += getPaddingLeft() + getPaddingRight();
            if (!(iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1)) {
                i8 = Math.max(i8, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
            }
            obj2 = obj9;
            i3 = i16;
            i7 = i15;
            i5 = i8;
        } else {
            i16 = Math.max(i8, i9);
            if (z2 && mode != 1073741824) {
                for (i5 = 0; i5 < virtualChildCount; i5++) {
                    View b4 = b(i5);
                    if (!(b4 == null || b4.getVisibility() == 8 || ((LayoutParams) b4.getLayoutParams()).g <= 0.0f)) {
                        b4.measure(MeasureSpec.makeMeasureSpec(i10, 1073741824), MeasureSpec.makeMeasureSpec(b4.getMeasuredHeight(), 1073741824));
                    }
                }
            }
            i3 = i16;
            i5 = i11;
        }
        if (obj2 != null || mode2 == 1073741824) {
            i3 = i5;
        }
        setMeasuredDimension((-16777216 & i7) | a2, hg.a(Math.max(i3 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i2, i7 << 16));
        if (obj3 != null) {
            d(virtualChildCount, i);
        }
    }

    private void d(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View b = b(i3);
            if (b.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) b.getLayoutParams();
                if (layoutParams.height == -1) {
                    int i4 = layoutParams.width;
                    layoutParams.width = b.getMeasuredWidth();
                    measureChildWithMargins(b, i2, 0, makeMeasureSpec, 0);
                    layoutParams.width = i4;
                }
            }
        }
    }

    int a(View view, int i) {
        return 0;
    }

    int d(int i) {
        return 0;
    }

    void a(View view, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    int a(View view) {
        return 0;
    }

    int b(View view) {
        return 0;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.d == 1) {
            a(i, i2, i3, i4);
        } else {
            b(i, i2, i3, i4);
        }
    }

    void a(int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int i5 = i3 - i;
        int paddingRight = i5 - getPaddingRight();
        int paddingRight2 = (i5 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i6 = this.e & 8388615;
        switch (this.e & 112) {
            case nv.Toolbar_maxButtonHeight /*16*/:
                i5 = getPaddingTop() + (((i4 - i2) - this.f) / 2);
                break;
            case nv.Theme_colorControlHighlight /*80*/:
                i5 = ((getPaddingTop() + i4) - i2) - this.f;
                break;
            default:
                i5 = getPaddingTop();
                break;
        }
        int i7 = 0;
        int i8 = i5;
        while (i7 < virtualChildCount) {
            View b = b(i7);
            if (b == null) {
                i8 += d(i7);
                i5 = i7;
            } else if (b.getVisibility() != 8) {
                int i9;
                int measuredWidth = b.getMeasuredWidth();
                int measuredHeight = b.getMeasuredHeight();
                LayoutParams layoutParams = (LayoutParams) b.getLayoutParams();
                i5 = layoutParams.h;
                if (i5 < 0) {
                    i5 = i6;
                }
                switch (fv.a(i5, hg.g(this)) & 7) {
                    case ve.CropImageView_fixAspectRatio /*1*/:
                        i9 = ((((paddingRight2 - measuredWidth) / 2) + paddingLeft) + layoutParams.leftMargin) - layoutParams.rightMargin;
                        break;
                    case Node.CDSECT /*5*/:
                        i9 = (paddingRight - measuredWidth) - layoutParams.rightMargin;
                        break;
                    default:
                        i9 = paddingLeft + layoutParams.leftMargin;
                        break;
                }
                if (c(i7)) {
                    i5 = this.m + i8;
                } else {
                    i5 = i8;
                }
                int i10 = i5 + layoutParams.topMargin;
                a(b, i9, i10 + a(b), measuredWidth, measuredHeight);
                i8 = i10 + ((layoutParams.bottomMargin + measuredHeight) + b(b));
                i5 = a(b, i7) + i7;
            } else {
                i5 = i7;
            }
            i7 = i5 + 1;
        }
    }

    void b(int i, int i2, int i3, int i4) {
        int paddingLeft;
        int i5;
        int i6;
        boolean a = rt.a(this);
        int paddingTop = getPaddingTop();
        int i7 = i4 - i2;
        int paddingBottom = i7 - getPaddingBottom();
        int paddingBottom2 = (i7 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        i7 = this.e & 8388615;
        int i8 = this.e & 112;
        boolean z = this.a;
        int[] iArr = this.i;
        int[] iArr2 = this.j;
        switch (fv.a(i7, hg.g(this))) {
            case ve.CropImageView_fixAspectRatio /*1*/:
                paddingLeft = getPaddingLeft() + (((i3 - i) - this.f) / 2);
                break;
            case Node.CDSECT /*5*/:
                paddingLeft = ((getPaddingLeft() + i3) - i) - this.f;
                break;
            default:
                paddingLeft = getPaddingLeft();
                break;
        }
        if (a) {
            i5 = -1;
            i6 = virtualChildCount - 1;
        } else {
            i5 = 1;
            i6 = 0;
        }
        int i9 = 0;
        while (i9 < virtualChildCount) {
            int i10 = i6 + (i5 * i9);
            View b = b(i10);
            if (b == null) {
                paddingLeft += d(i10);
                i7 = i9;
            } else if (b.getVisibility() != 8) {
                int i11;
                int measuredWidth = b.getMeasuredWidth();
                int measuredHeight = b.getMeasuredHeight();
                LayoutParams layoutParams = (LayoutParams) b.getLayoutParams();
                if (!z || layoutParams.height == -1) {
                    i7 = -1;
                } else {
                    i7 = b.getBaseline();
                }
                int i12 = layoutParams.h;
                if (i12 < 0) {
                    i12 = i8;
                }
                switch (i12 & 112) {
                    case nv.Toolbar_maxButtonHeight /*16*/:
                        i11 = ((((paddingBottom2 - measuredHeight) / 2) + paddingTop) + layoutParams.topMargin) - layoutParams.bottomMargin;
                        break;
                    case nv.Theme_dividerVertical /*48*/:
                        i11 = paddingTop + layoutParams.topMargin;
                        if (i7 != -1) {
                            i11 += iArr[1] - i7;
                            break;
                        }
                        break;
                    case nv.Theme_colorControlHighlight /*80*/:
                        i11 = (paddingBottom - measuredHeight) - layoutParams.bottomMargin;
                        if (i7 != -1) {
                            i11 -= iArr2[2] - (b.getMeasuredHeight() - i7);
                            break;
                        }
                        break;
                    default:
                        i11 = paddingTop;
                        break;
                }
                if (c(i10)) {
                    i7 = this.l + paddingLeft;
                } else {
                    i7 = paddingLeft;
                }
                paddingLeft = i7 + layoutParams.leftMargin;
                a(b, paddingLeft + a(b), i11, measuredWidth, measuredHeight);
                paddingLeft += (layoutParams.rightMargin + measuredWidth) + b(b);
                i7 = a(b, i10) + i9;
            } else {
                i7 = i9;
            }
            i9 = i7 + 1;
        }
    }

    private void a(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i + i3, i2 + i4);
    }

    public void setOrientation(int i) {
        if (this.d != i) {
            this.d = i;
            requestLayout();
        }
    }

    public int getOrientation() {
        return this.d;
    }

    public void setGravity(int i) {
        if (this.e != i) {
            int i2;
            if ((8388615 & i) == 0) {
                i2 = 8388611 | i;
            } else {
                i2 = i;
            }
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.e = i2;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & 8388615;
        if ((this.e & 8388615) != i2) {
            this.e = i2 | (this.e & -8388616);
            requestLayout();
        }
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        if ((this.e & 112) != i2) {
            this.e = i2 | (this.e & -113);
            requestLayout();
        }
    }

    public LayoutParams b(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected LayoutParams j() {
        if (this.d == 0) {
            return new LayoutParams(-2, -2);
        }
        if (this.d == 1) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }

    protected LayoutParams b(android.view.ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(LinearLayoutCompat.class.getName());
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(LinearLayoutCompat.class.getName());
        }
    }
}
