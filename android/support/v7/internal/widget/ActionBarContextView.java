package android.support.v7.internal.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.widget.ActionMenuPresenter;
import android.support.v7.widget.ActionMenuView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import hg;
import iu;
import jk;
import nl;
import nq;
import ns;
import nv;
import on;
import ox;
import pu;
import qa;
import rn;
import rt;
import ru;

public class ActionBarContextView extends pu implements jk {
    private CharSequence j;
    private CharSequence k;
    private View l;
    private View m;
    private LinearLayout n;
    private TextView o;
    private TextView p;
    private int q;
    private int r;
    private Drawable s;
    private boolean t;
    private int u;
    private on v;
    private boolean w;
    private int x;

    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public /* bridge */ /* synthetic */ void setSplitView(ViewGroup viewGroup) {
        super.setSplitView(viewGroup);
    }

    public /* bridge */ /* synthetic */ void setSplitWhenNarrow(boolean z) {
        super.setSplitWhenNarrow(z);
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, nl.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        rn a = rn.a(context, attributeSet, nv.ActionMode, i, 0);
        setBackgroundDrawable(a.a(nv.ActionMode_background));
        this.q = a.f(nv.ActionMode_titleTextStyle, 0);
        this.r = a.f(nv.ActionMode_subtitleTextStyle, 0);
        this.h = a.e(nv.ActionMode_height, 0);
        this.s = a.a(nv.ActionMode_backgroundSplit);
        this.u = a.f(nv.ActionMode_closeItemLayout, ns.abc_action_mode_close_item_material);
        a.b();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.d != null) {
            this.d.d();
            this.d.f();
        }
    }

    public void setSplitToolbar(boolean z) {
        if (this.f != z) {
            if (this.d != null) {
                LayoutParams layoutParams = new LayoutParams(-2, -1);
                ViewGroup viewGroup;
                if (z) {
                    this.d.a(getContext().getResources().getDisplayMetrics().widthPixels, true);
                    this.d.b(Integer.MAX_VALUE);
                    layoutParams.width = -1;
                    layoutParams.height = this.h;
                    this.c = (ActionMenuView) this.d.a((ViewGroup) this);
                    this.c.setBackgroundDrawable(this.s);
                    viewGroup = (ViewGroup) this.c.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(this.c);
                    }
                    this.e.addView(this.c, layoutParams);
                } else {
                    this.c = (ActionMenuView) this.d.a((ViewGroup) this);
                    this.c.setBackgroundDrawable(null);
                    viewGroup = (ViewGroup) this.c.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(this.c);
                    }
                    addView(this.c, layoutParams);
                }
            }
            super.setSplitToolbar(z);
        }
    }

    public void setContentHeight(int i) {
        this.h = i;
    }

    public void setCustomView(View view) {
        if (this.m != null) {
            removeView(this.m);
        }
        this.m = view;
        if (this.n != null) {
            removeView(this.n);
            this.n = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setTitle(CharSequence charSequence) {
        this.j = charSequence;
        e();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.k = charSequence;
        e();
    }

    public CharSequence getTitle() {
        return this.j;
    }

    public CharSequence getSubtitle() {
        return this.k;
    }

    private void e() {
        int i;
        int i2 = 8;
        Object obj = 1;
        if (this.n == null) {
            LayoutInflater.from(getContext()).inflate(ns.abc_action_bar_title_item, this);
            this.n = (LinearLayout) getChildAt(getChildCount() - 1);
            this.o = (TextView) this.n.findViewById(nq.action_bar_title);
            this.p = (TextView) this.n.findViewById(nq.action_bar_subtitle);
            if (this.q != 0) {
                this.o.setTextAppearance(getContext(), this.q);
            }
            if (this.r != 0) {
                this.p.setTextAppearance(getContext(), this.r);
            }
        }
        this.o.setText(this.j);
        this.p.setText(this.k);
        Object obj2 = !TextUtils.isEmpty(this.j) ? 1 : null;
        if (TextUtils.isEmpty(this.k)) {
            obj = null;
        }
        TextView textView = this.p;
        if (obj != null) {
            i = 0;
        } else {
            i = 8;
        }
        textView.setVisibility(i);
        LinearLayout linearLayout = this.n;
        if (!(obj2 == null && obj == null)) {
            i2 = 0;
        }
        linearLayout.setVisibility(i2);
        if (this.n.getParent() == null) {
            addView(this.n);
        }
    }

    public void a(ru ruVar) {
        if (this.l == null) {
            this.l = LayoutInflater.from(getContext()).inflate(this.u, this, false);
            addView(this.l);
        } else if (this.l.getParent() == null) {
            addView(this.l);
        }
        this.l.findViewById(nq.action_mode_close_button).setOnClickListener(new qa(this, ruVar));
        ox oxVar = (ox) ruVar.b();
        if (this.d != null) {
            this.d.e();
        }
        this.d = new ActionMenuPresenter(getContext());
        this.d.b(true);
        LayoutParams layoutParams = new LayoutParams(-2, -1);
        if (this.f) {
            this.d.a(getContext().getResources().getDisplayMetrics().widthPixels, true);
            this.d.b(Integer.MAX_VALUE);
            layoutParams.width = -1;
            layoutParams.height = this.h;
            oxVar.a(this.d, this.b);
            this.c = (ActionMenuView) this.d.a((ViewGroup) this);
            this.c.setBackgroundDrawable(this.s);
            this.e.addView(this.c, layoutParams);
        } else {
            oxVar.a(this.d, this.b);
            this.c = (ActionMenuView) this.d.a((ViewGroup) this);
            this.c.setBackgroundDrawable(null);
            addView(this.c, layoutParams);
        }
        this.w = true;
    }

    public void b() {
        if (this.x != 2) {
            if (this.l == null) {
                c();
                return;
            }
            f();
            this.x = 2;
            this.v = h();
            this.v.a();
        }
    }

    private void f() {
        on onVar = this.v;
        if (onVar != null) {
            this.v = null;
            onVar.b();
        }
    }

    public void c() {
        f();
        removeAllViews();
        if (this.e != null) {
            this.e.removeView(this.c);
        }
        this.m = null;
        this.c = null;
        this.w = false;
    }

    public boolean a() {
        if (this.d != null) {
            return this.d.c();
        }
        return false;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(-1, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new MarginLayoutParams(getContext(), attributeSet);
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 1073741824;
        int i4 = 0;
        if (MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_width=\"match_parent\" (or fill_parent)");
        } else if (MeasureSpec.getMode(i2) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_height=\"wrap_content\"");
        } else {
            int a;
            int size = MeasureSpec.getSize(i);
            int size2 = this.h > 0 ? this.h : MeasureSpec.getSize(i2);
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int i5 = size2 - paddingTop;
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE);
            if (this.l != null) {
                a = a(this.l, paddingLeft, makeMeasureSpec, 0);
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.l.getLayoutParams();
                paddingLeft = a - (marginLayoutParams.rightMargin + marginLayoutParams.leftMargin);
            }
            if (this.c != null && this.c.getParent() == this) {
                paddingLeft = a(this.c, paddingLeft, makeMeasureSpec, 0);
            }
            if (this.n != null && this.m == null) {
                if (this.t) {
                    this.n.measure(MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    a = this.n.getMeasuredWidth();
                    makeMeasureSpec = a <= paddingLeft ? 1 : 0;
                    if (makeMeasureSpec != 0) {
                        paddingLeft -= a;
                    }
                    this.n.setVisibility(makeMeasureSpec != 0 ? 0 : 8);
                } else {
                    paddingLeft = a(this.n, paddingLeft, makeMeasureSpec, 0);
                }
            }
            if (this.m != null) {
                int min;
                LayoutParams layoutParams = this.m.getLayoutParams();
                if (layoutParams.width != -2) {
                    makeMeasureSpec = 1073741824;
                } else {
                    makeMeasureSpec = Integer.MIN_VALUE;
                }
                if (layoutParams.width >= 0) {
                    paddingLeft = Math.min(layoutParams.width, paddingLeft);
                }
                if (layoutParams.height == -2) {
                    i3 = Integer.MIN_VALUE;
                }
                if (layoutParams.height >= 0) {
                    min = Math.min(layoutParams.height, i5);
                } else {
                    min = i5;
                }
                this.m.measure(MeasureSpec.makeMeasureSpec(paddingLeft, makeMeasureSpec), MeasureSpec.makeMeasureSpec(min, i3));
            }
            if (this.h <= 0) {
                makeMeasureSpec = getChildCount();
                size2 = 0;
                while (i4 < makeMeasureSpec) {
                    paddingLeft = getChildAt(i4).getMeasuredHeight() + paddingTop;
                    if (paddingLeft <= size2) {
                        paddingLeft = size2;
                    }
                    i4++;
                    size2 = paddingLeft;
                }
                setMeasuredDimension(size, size2);
                return;
            }
            setMeasuredDimension(size, size2);
        }
    }

    private on g() {
        hg.a(this.l, (float) ((-this.l.getWidth()) - ((MarginLayoutParams) this.l.getLayoutParams()).leftMargin));
        iu b = hg.m(this.l).b(0.0f);
        b.a(200);
        b.a((jk) this);
        b.a(new DecelerateInterpolator());
        on onVar = new on();
        onVar.a(b);
        if (this.c != null) {
            int childCount = this.c.getChildCount();
            if (childCount > 0) {
                int i = childCount - 1;
                childCount = 0;
                while (i >= 0) {
                    View childAt = this.c.getChildAt(i);
                    hg.d(childAt, 0.0f);
                    iu d = hg.m(childAt).d(1.0f);
                    d.a(300);
                    onVar.a(d);
                    i--;
                    childCount++;
                }
            }
        }
        return onVar;
    }

    private on h() {
        iu b = hg.m(this.l).b((float) ((-this.l.getWidth()) - ((MarginLayoutParams) this.l.getLayoutParams()).leftMargin));
        b.a(200);
        b.a((jk) this);
        b.a(new DecelerateInterpolator());
        on onVar = new on();
        onVar.a(b);
        return (this.c == null || this.c.getChildCount() > 0) ? onVar : onVar;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        boolean a = rt.a(this);
        int paddingRight = a ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        if (!(this.l == null || this.l.getVisibility() == 8)) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.l.getLayoutParams();
            i5 = a ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i6 = a ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            i5 = pu.a(paddingRight, i5, a);
            paddingRight = pu.a(a(this.l, i5, paddingTop, paddingTop2, a) + i5, i6, a);
            if (this.w) {
                this.x = 1;
                this.v = g();
                this.v.a();
                this.w = false;
            }
        }
        i5 = paddingRight;
        if (!(this.n == null || this.m != null || this.n.getVisibility() == 8)) {
            i5 += a(this.n, i5, paddingTop, paddingTop2, a);
        }
        if (this.m != null) {
            int a2 = a(this.m, i5, paddingTop, paddingTop2, a) + i5;
        }
        i5 = a ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        if (this.c != null) {
            View view = this.c;
            if (a) {
                a = false;
            } else {
                a = true;
            }
            a2 = a(view, i5, paddingTop, paddingTop2, a) + i5;
        }
    }

    public void a(View view) {
    }

    public void b(View view) {
        if (this.x == 2) {
            c();
        }
        this.x = 0;
    }

    public void c(View view) {
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (VERSION.SDK_INT < 14) {
            return;
        }
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(getClass().getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.j);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    public void setTitleOptional(boolean z) {
        if (z != this.t) {
            requestLayout();
        }
        this.t = z;
    }

    public boolean d() {
        return this.t;
    }
}
