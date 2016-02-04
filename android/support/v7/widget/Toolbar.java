package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import fv;
import gh;
import gm;
import gu;
import hg;
import java.util.ArrayList;
import java.util.List;
import nl;
import nv;
import ok;
import org.kxml2.kdom.Node;
import ox;
import oy;
import pb;
import pm;
import pn;
import qo;
import qu;
import rk;
import rn;
import ro;
import rt;
import sk;
import uv;
import uw;
import ux;
import uy;
import uz;
import va;
import ve;

public class Toolbar extends ViewGroup {
    private final ArrayList A;
    private final int[] B;
    private uz C;
    private final sk D;
    private ro E;
    private ActionMenuPresenter F;
    private uy G;
    private pn H;
    private oy I;
    private boolean J;
    private int K;
    private final Runnable L;
    private final rk M;
    public View a;
    private ActionMenuView b;
    private TextView c;
    private TextView d;
    private ImageButton e;
    private ImageView f;
    private Drawable g;
    private CharSequence h;
    private ImageButton i;
    private Context j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private final qu t;
    private int u;
    private CharSequence v;
    private CharSequence w;
    private int x;
    private int y;
    private boolean z;

    public class LayoutParams extends android.support.v7.app.ActionBar.LayoutParams {
        public int b;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.b = 0;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.b = 0;
            this.a = 8388627;
        }

        public LayoutParams(int i, int i2, int i3) {
            super(i, i2);
            this.b = 0;
            this.a = i3;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((android.support.v7.app.ActionBar.LayoutParams) layoutParams);
            this.b = 0;
            this.b = layoutParams.b;
        }

        public LayoutParams(android.support.v7.app.ActionBar.LayoutParams layoutParams) {
            super(layoutParams);
            this.b = 0;
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super((android.view.ViewGroup.LayoutParams) marginLayoutParams);
            this.b = 0;
            a(marginLayoutParams);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.b = 0;
        }

        void a(MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }
    }

    public class SavedState extends BaseSavedState {
        public static final Creator CREATOR;
        public int a;
        public boolean b;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readInt();
            this.b = parcel.readInt() != 0;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
            parcel.writeInt(this.b ? 1 : 0);
        }

        static {
            CREATOR = new va();
        }
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return i();
    }

    public /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return a(attributeSet);
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return a(layoutParams);
    }

    public Toolbar(Context context) {
        this(context, null);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, nl.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(a(context, attributeSet, i), attributeSet, i);
        this.t = new qu();
        this.u = 8388627;
        this.A = new ArrayList();
        this.B = new int[2];
        this.D = new uv(this);
        this.L = new uw(this);
        rn a = rn.a(getContext(), attributeSet, nv.Toolbar, i, 0);
        this.l = a.f(nv.Toolbar_titleTextAppearance, 0);
        this.m = a.f(nv.Toolbar_subtitleTextAppearance, 0);
        this.u = a.b(nv.Toolbar_android_gravity, this.u);
        this.n = 48;
        int c = a.c(nv.Toolbar_titleMargins, 0);
        this.s = c;
        this.r = c;
        this.q = c;
        this.p = c;
        c = a.c(nv.Toolbar_titleMarginStart, -1);
        if (c >= 0) {
            this.p = c;
        }
        c = a.c(nv.Toolbar_titleMarginEnd, -1);
        if (c >= 0) {
            this.q = c;
        }
        c = a.c(nv.Toolbar_titleMarginTop, -1);
        if (c >= 0) {
            this.r = c;
        }
        c = a.c(nv.Toolbar_titleMarginBottom, -1);
        if (c >= 0) {
            this.s = c;
        }
        this.o = a.d(nv.Toolbar_maxButtonHeight, -1);
        c = a.c(nv.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int c2 = a.c(nv.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        this.t.b(a.d(nv.Toolbar_contentInsetLeft, 0), a.d(nv.Toolbar_contentInsetRight, 0));
        if (!(c == Integer.MIN_VALUE && c2 == Integer.MIN_VALUE)) {
            this.t.a(c, c2);
        }
        this.g = a.a(nv.Toolbar_collapseIcon);
        this.h = a.b(nv.Toolbar_collapseContentDescription);
        CharSequence b = a.b(nv.Toolbar_title);
        if (!TextUtils.isEmpty(b)) {
            setTitle(b);
        }
        b = a.b(nv.Toolbar_subtitle);
        if (!TextUtils.isEmpty(b)) {
            setSubtitle(b);
        }
        this.j = getContext();
        setPopupTheme(a.f(nv.Toolbar_popupTheme, 0));
        Drawable a2 = a.a(nv.Toolbar_navigationIcon);
        if (a2 != null) {
            setNavigationIcon(a2);
        }
        b = a.b(nv.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(b)) {
            setNavigationContentDescription(b);
        }
        this.K = a.d(nv.Toolbar_android_minHeight, 0);
        a.b();
        this.M = a.c();
    }

    public void setPopupTheme(int i) {
        if (this.k != i) {
            this.k = i;
            if (i == 0) {
                this.j = getContext();
            } else {
                this.j = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public int getPopupTheme() {
        return this.k;
    }

    public void onRtlPropertiesChanged(int i) {
        boolean z = true;
        if (VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i);
        }
        qu quVar = this.t;
        if (i != 1) {
            z = false;
        }
        quVar.a(z);
    }

    public void setLogo(int i) {
        setLogo(this.M.a(i));
    }

    public boolean a() {
        return getVisibility() == 0 && this.b != null && this.b.a();
    }

    public boolean b() {
        return this.b != null && this.b.g();
    }

    public boolean c() {
        return this.b != null && this.b.h();
    }

    public boolean d() {
        return this.b != null && this.b.e();
    }

    public boolean e() {
        return this.b != null && this.b.f();
    }

    public void a(ox oxVar, ActionMenuPresenter actionMenuPresenter) {
        if (oxVar != null || this.b != null) {
            l();
            ox d = this.b.d();
            if (d != oxVar) {
                if (d != null) {
                    d.b(this.F);
                    d.b(this.G);
                }
                if (this.G == null) {
                    this.G = new uy();
                }
                actionMenuPresenter.c(true);
                if (oxVar != null) {
                    oxVar.a((pm) actionMenuPresenter, this.j);
                    oxVar.a(this.G, this.j);
                } else {
                    actionMenuPresenter.a(this.j, null);
                    this.G.a(this.j, null);
                    actionMenuPresenter.a(true);
                    this.G.a(true);
                }
                this.b.setPopupTheme(this.k);
                this.b.setPresenter(actionMenuPresenter);
                this.F = actionMenuPresenter;
            }
        }
    }

    public void f() {
        if (this.b != null) {
            this.b.i();
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            j();
            if (this.f.getParent() == null) {
                a(this.f);
                e(this.f);
            }
        } else if (!(this.f == null || this.f.getParent() == null)) {
            removeView(this.f);
        }
        if (this.f != null) {
            this.f.setImageDrawable(drawable);
        }
    }

    public Drawable getLogo() {
        return this.f != null ? this.f.getDrawable() : null;
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            j();
        }
        if (this.f != null) {
            this.f.setContentDescription(charSequence);
        }
    }

    public CharSequence getLogoDescription() {
        return this.f != null ? this.f.getContentDescription() : null;
    }

    private void j() {
        if (this.f == null) {
            this.f = new ImageView(getContext());
        }
    }

    public boolean g() {
        return (this.G == null || this.G.b == null) ? false : true;
    }

    public void h() {
        pb pbVar = this.G == null ? null : this.G.b;
        if (pbVar != null) {
            pbVar.collapseActionView();
        }
    }

    public CharSequence getTitle() {
        return this.v;
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.c == null) {
                Context context = getContext();
                this.c = new TextView(context);
                this.c.setSingleLine();
                this.c.setEllipsize(TruncateAt.END);
                if (this.l != 0) {
                    this.c.setTextAppearance(context, this.l);
                }
                if (this.x != 0) {
                    this.c.setTextColor(this.x);
                }
            }
            if (this.c.getParent() == null) {
                a(this.c);
                e(this.c);
            }
        } else if (!(this.c == null || this.c.getParent() == null)) {
            removeView(this.c);
        }
        if (this.c != null) {
            this.c.setText(charSequence);
        }
        this.v = charSequence;
    }

    public CharSequence getSubtitle() {
        return this.w;
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.d == null) {
                Context context = getContext();
                this.d = new TextView(context);
                this.d.setSingleLine();
                this.d.setEllipsize(TruncateAt.END);
                if (this.m != 0) {
                    this.d.setTextAppearance(context, this.m);
                }
                if (this.y != 0) {
                    this.d.setTextColor(this.y);
                }
            }
            if (this.d.getParent() == null) {
                a(this.d);
                e(this.d);
            }
        } else if (!(this.d == null || this.d.getParent() == null)) {
            removeView(this.d);
        }
        if (this.d != null) {
            this.d.setText(charSequence);
        }
        this.w = charSequence;
    }

    public void a(Context context, int i) {
        this.l = i;
        if (this.c != null) {
            this.c.setTextAppearance(context, i);
        }
    }

    public void b(Context context, int i) {
        this.m = i;
        if (this.d != null) {
            this.d.setTextAppearance(context, i);
        }
    }

    public void setTitleTextColor(int i) {
        this.x = i;
        if (this.c != null) {
            this.c.setTextColor(i);
        }
    }

    public void setSubtitleTextColor(int i) {
        this.y = i;
        if (this.d != null) {
            this.d.setTextColor(i);
        }
    }

    public CharSequence getNavigationContentDescription() {
        return this.e != null ? this.e.getContentDescription() : null;
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m();
        }
        if (this.e != null) {
            this.e.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(this.M.a(i));
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            m();
            if (this.e.getParent() == null) {
                a(this.e);
                e(this.e);
            }
        } else if (!(this.e == null || this.e.getParent() == null)) {
            removeView(this.e);
        }
        if (this.e != null) {
            this.e.setImageDrawable(drawable);
        }
    }

    public Drawable getNavigationIcon() {
        return this.e != null ? this.e.getDrawable() : null;
    }

    public void setNavigationOnClickListener(OnClickListener onClickListener) {
        m();
        this.e.setOnClickListener(onClickListener);
    }

    public Menu getMenu() {
        k();
        return this.b.getMenu();
    }

    private void k() {
        l();
        if (this.b.d() == null) {
            ox oxVar = (ox) this.b.getMenu();
            if (this.G == null) {
                this.G = new uy();
            }
            this.b.setExpandedActionViewsExclusive(true);
            oxVar.a(this.G, this.j);
        }
    }

    private void l() {
        if (this.b == null) {
            this.b = new ActionMenuView(getContext());
            this.b.setPopupTheme(this.k);
            this.b.setOnMenuItemClickListener(this.D);
            this.b.a(this.H, this.I);
            android.view.ViewGroup.LayoutParams i = i();
            i.a = 8388613 | (this.n & 112);
            this.b.setLayoutParams(i);
            a(this.b);
        }
    }

    private MenuInflater getMenuInflater() {
        return new ok(getContext());
    }

    public void setOnMenuItemClickListener(uz uzVar) {
        this.C = uzVar;
    }

    public void a(int i, int i2) {
        this.t.a(i, i2);
    }

    public int getContentInsetStart() {
        return this.t.c();
    }

    public int getContentInsetEnd() {
        return this.t.d();
    }

    public int getContentInsetLeft() {
        return this.t.a();
    }

    public int getContentInsetRight() {
        return this.t.b();
    }

    private void m() {
        if (this.e == null) {
            this.e = new ImageButton(getContext(), null, nl.toolbarNavigationButtonStyle);
            android.view.ViewGroup.LayoutParams i = i();
            i.a = 8388611 | (this.n & 112);
            this.e.setLayoutParams(i);
        }
    }

    private void n() {
        if (this.i == null) {
            this.i = new ImageButton(getContext(), null, nl.toolbarNavigationButtonStyle);
            this.i.setImageDrawable(this.g);
            this.i.setContentDescription(this.h);
            android.view.ViewGroup.LayoutParams i = i();
            i.a = 8388611 | (this.n & 112);
            i.b = 2;
            this.i.setLayoutParams(i);
            this.i.setOnClickListener(new ux(this));
        }
    }

    private void a(View view) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = i();
        } else if (checkLayoutParams(layoutParams)) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        } else {
            layoutParams = a(layoutParams);
        }
        layoutParams.b = 1;
        addView(view, layoutParams);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        if (!(this.G == null || this.G.b == null)) {
            savedState.a = this.G.b.getItemId();
        }
        savedState.b = b();
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        Menu d = this.b != null ? this.b.d() : null;
        if (!(savedState.a == 0 || this.G == null || d == null)) {
            MenuItem findItem = d.findItem(savedState.a);
            if (findItem != null) {
                gm.b(findItem);
            }
        }
        if (savedState.b) {
            o();
        }
    }

    private void o() {
        removeCallbacks(this.L);
        post(this.L);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.L);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = gu.a(motionEvent);
        if (a == 0) {
            this.z = false;
        }
        if (!this.z) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (a == 0 && !onTouchEvent) {
                this.z = true;
            }
        }
        if (a == 1 || a == 3) {
            this.z = false;
        }
        return true;
    }

    private void a(View view, int i, int i2, int i3, int i4, int i5) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width);
        int childMeasureSpec2 = getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + i4, marginLayoutParams.height);
        int mode = MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i5 >= 0) {
            if (mode != 0) {
                i5 = Math.min(MeasureSpec.getSize(childMeasureSpec2), i5);
            }
            childMeasureSpec2 = MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private int a(View view, int i, int i2, int i3, int i4, int[] iArr) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + max) + i2, marginLayoutParams.width), getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    private boolean p() {
        if (!this.J) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (b(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int max;
        int i5 = 0;
        int i6 = 0;
        int[] iArr = this.B;
        if (rt.a(this)) {
            i3 = 0;
            i4 = 1;
        } else {
            i3 = 1;
            i4 = 0;
        }
        int i7 = 0;
        if (b(this.e)) {
            a(this.e, i, 0, i2, 0, this.o);
            i7 = this.e.getMeasuredWidth() + c(this.e);
            max = Math.max(0, this.e.getMeasuredHeight() + d(this.e));
            i6 = rt.a(0, hg.i(this.e));
            i5 = max;
        }
        if (b(this.i)) {
            a(this.i, i, 0, i2, 0, this.o);
            i7 = this.i.getMeasuredWidth() + c(this.i);
            i5 = Math.max(i5, this.i.getMeasuredHeight() + d(this.i));
            i6 = rt.a(i6, hg.i(this.i));
        }
        int contentInsetStart = getContentInsetStart();
        int max2 = 0 + Math.max(contentInsetStart, i7);
        iArr[i4] = Math.max(0, contentInsetStart - i7);
        i7 = 0;
        if (b(this.b)) {
            a(this.b, i, max2, i2, 0, this.o);
            i7 = this.b.getMeasuredWidth() + c(this.b);
            i5 = Math.max(i5, this.b.getMeasuredHeight() + d(this.b));
            i6 = rt.a(i6, hg.i(this.b));
        }
        contentInsetStart = getContentInsetEnd();
        max2 += Math.max(contentInsetStart, i7);
        iArr[i3] = Math.max(0, contentInsetStart - i7);
        if (b(this.a)) {
            max2 += a(this.a, i, max2, i2, 0, iArr);
            i5 = Math.max(i5, this.a.getMeasuredHeight() + d(this.a));
            i6 = rt.a(i6, hg.i(this.a));
        }
        if (b(this.f)) {
            max2 += a(this.f, i, max2, i2, 0, iArr);
            i5 = Math.max(i5, this.f.getMeasuredHeight() + d(this.f));
            i6 = rt.a(i6, hg.i(this.f));
        }
        i4 = getChildCount();
        i3 = 0;
        int i8 = i5;
        i5 = i6;
        while (i3 < i4) {
            View childAt = getChildAt(i3);
            if (((LayoutParams) childAt.getLayoutParams()).b != 0) {
                i7 = i5;
                contentInsetStart = i8;
            } else if (b(childAt)) {
                max2 += a(childAt, i, max2, i2, 0, iArr);
                max = Math.max(i8, childAt.getMeasuredHeight() + d(childAt));
                i7 = rt.a(i5, hg.i(childAt));
                contentInsetStart = max;
            } else {
                i7 = i5;
                contentInsetStart = i8;
            }
            i3++;
            i5 = i7;
            i8 = contentInsetStart;
        }
        contentInsetStart = 0;
        i7 = 0;
        i6 = this.r + this.s;
        max = this.p + this.q;
        if (b(this.c)) {
            a(this.c, i, max2 + max, i2, i6, iArr);
            contentInsetStart = c(this.c) + this.c.getMeasuredWidth();
            i7 = this.c.getMeasuredHeight() + d(this.c);
            i5 = rt.a(i5, hg.i(this.c));
        }
        if (b(this.d)) {
            contentInsetStart = Math.max(contentInsetStart, a(this.d, i, max2 + max, i2, i6 + i7, iArr));
            i7 += this.d.getMeasuredHeight() + d(this.d);
            i5 = rt.a(i5, hg.i(this.d));
        }
        contentInsetStart += max2;
        i7 = Math.max(i8, i7) + (getPaddingTop() + getPaddingBottom());
        contentInsetStart = hg.a(Math.max(contentInsetStart + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, -16777216 & i5);
        i7 = hg.a(Math.max(i7, getSuggestedMinimumHeight()), i2, i5 << 16);
        if (p()) {
            i7 = 0;
        }
        setMeasuredDimension(contentInsetStart, i7);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Object obj;
        int i5;
        int i6;
        int i7;
        int measuredHeight;
        int measuredWidth;
        if (hg.g(this) == 1) {
            obj = 1;
        } else {
            obj = null;
        }
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i8 = width - paddingRight;
        int[] iArr = this.B;
        iArr[1] = 0;
        iArr[0] = 0;
        int minimumHeightCompat = getMinimumHeightCompat();
        if (!b(this.e)) {
            i5 = paddingLeft;
        } else if (obj != null) {
            i8 = b(this.e, i8, iArr, minimumHeightCompat);
            i5 = paddingLeft;
        } else {
            i5 = a(this.e, paddingLeft, iArr, minimumHeightCompat);
        }
        if (b(this.i)) {
            if (obj != null) {
                i8 = b(this.i, i8, iArr, minimumHeightCompat);
            } else {
                i5 = a(this.i, i5, iArr, minimumHeightCompat);
            }
        }
        if (b(this.b)) {
            if (obj != null) {
                i5 = a(this.b, i5, iArr, minimumHeightCompat);
            } else {
                i8 = b(this.b, i8, iArr, minimumHeightCompat);
            }
        }
        iArr[0] = Math.max(0, getContentInsetLeft() - i5);
        iArr[1] = Math.max(0, getContentInsetRight() - ((width - paddingRight) - i8));
        i5 = Math.max(i5, getContentInsetLeft());
        i8 = Math.min(i8, (width - paddingRight) - getContentInsetRight());
        if (b(this.a)) {
            if (obj != null) {
                i8 = b(this.a, i8, iArr, minimumHeightCompat);
            } else {
                i5 = a(this.a, i5, iArr, minimumHeightCompat);
            }
        }
        if (!b(this.f)) {
            i6 = i8;
            i7 = i5;
        } else if (obj != null) {
            i6 = b(this.f, i8, iArr, minimumHeightCompat);
            i7 = i5;
        } else {
            i6 = i8;
            i7 = a(this.f, i5, iArr, minimumHeightCompat);
        }
        boolean b = b(this.c);
        boolean b2 = b(this.d);
        i5 = 0;
        if (b) {
            LayoutParams layoutParams = (LayoutParams) this.c.getLayoutParams();
            i5 = 0 + (layoutParams.bottomMargin + (layoutParams.topMargin + this.c.getMeasuredHeight()));
        }
        if (b2) {
            layoutParams = (LayoutParams) this.d.getLayoutParams();
            measuredHeight = (layoutParams.bottomMargin + (layoutParams.topMargin + this.d.getMeasuredHeight())) + i5;
        } else {
            measuredHeight = i5;
        }
        if (b || b2) {
            int paddingTop2;
            layoutParams = (LayoutParams) (b ? this.c : this.d).getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) (b2 ? this.d : this.c).getLayoutParams();
            Object obj2 = ((!b || this.c.getMeasuredWidth() <= 0) && (!b2 || this.d.getMeasuredWidth() <= 0)) ? null : 1;
            switch (this.u & 112) {
                case nv.Theme_dividerVertical /*48*/:
                    paddingTop2 = (layoutParams.topMargin + getPaddingTop()) + this.r;
                    break;
                case nv.Theme_colorControlHighlight /*80*/:
                    paddingTop2 = (((height - paddingBottom) - layoutParams2.bottomMargin) - this.s) - measuredHeight;
                    break;
                default:
                    paddingTop2 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                    if (paddingTop2 < layoutParams.topMargin + this.r) {
                        i8 = layoutParams.topMargin + this.r;
                    } else {
                        measuredHeight = (((height - paddingBottom) - measuredHeight) - paddingTop2) - paddingTop;
                        if (measuredHeight < layoutParams.bottomMargin + this.s) {
                            i8 = Math.max(0, paddingTop2 - ((layoutParams2.bottomMargin + this.s) - measuredHeight));
                        } else {
                            i8 = paddingTop2;
                        }
                    }
                    paddingTop2 = paddingTop + i8;
                    break;
            }
            if (obj != null) {
                i8 = (obj2 != null ? this.p : 0) - iArr[1];
                i5 = i6 - Math.max(0, i8);
                iArr[1] = Math.max(0, -i8);
                if (b) {
                    layoutParams = (LayoutParams) this.c.getLayoutParams();
                    measuredWidth = i5 - this.c.getMeasuredWidth();
                    i6 = this.c.getMeasuredHeight() + paddingTop2;
                    this.c.layout(measuredWidth, paddingTop2, i5, i6);
                    paddingTop2 = i6 + layoutParams.bottomMargin;
                    i6 = measuredWidth - this.q;
                } else {
                    i6 = i5;
                }
                if (b2) {
                    layoutParams = (LayoutParams) this.d.getLayoutParams();
                    measuredWidth = layoutParams.topMargin + paddingTop2;
                    measuredHeight = this.d.getMeasuredHeight() + measuredWidth;
                    this.d.layout(i5 - this.d.getMeasuredWidth(), measuredWidth, i5, measuredHeight);
                    i8 = layoutParams.bottomMargin + measuredHeight;
                    i8 = i5 - this.q;
                } else {
                    i8 = i5;
                }
                if (obj2 != null) {
                    i8 = Math.min(i6, i8);
                } else {
                    i8 = i5;
                }
                i6 = i8;
            } else {
                i8 = (obj2 != null ? this.p : 0) - iArr[0];
                i7 += Math.max(0, i8);
                iArr[0] = Math.max(0, -i8);
                if (b) {
                    layoutParams = (LayoutParams) this.c.getLayoutParams();
                    i5 = this.c.getMeasuredWidth() + i7;
                    measuredWidth = this.c.getMeasuredHeight() + paddingTop2;
                    this.c.layout(i7, paddingTop2, i5, measuredWidth);
                    i8 = layoutParams.bottomMargin + measuredWidth;
                    measuredWidth = i5 + this.q;
                    i5 = i8;
                } else {
                    measuredWidth = i7;
                    i5 = paddingTop2;
                }
                if (b2) {
                    layoutParams = (LayoutParams) this.d.getLayoutParams();
                    i5 += layoutParams.topMargin;
                    paddingTop2 = this.d.getMeasuredWidth() + i7;
                    measuredHeight = this.d.getMeasuredHeight() + i5;
                    this.d.layout(i7, i5, paddingTop2, measuredHeight);
                    i8 = layoutParams.bottomMargin + measuredHeight;
                    i8 = this.q + paddingTop2;
                } else {
                    i8 = i7;
                }
                if (obj2 != null) {
                    i7 = Math.max(measuredWidth, i8);
                }
            }
        }
        a(this.A, 3);
        int size = this.A.size();
        i5 = i7;
        for (measuredWidth = 0; measuredWidth < size; measuredWidth++) {
            i5 = a((View) this.A.get(measuredWidth), i5, iArr, minimumHeightCompat);
        }
        a(this.A, 5);
        i7 = this.A.size();
        for (measuredWidth = 0; measuredWidth < i7; measuredWidth++) {
            i6 = b((View) this.A.get(measuredWidth), i6, iArr, minimumHeightCompat);
        }
        a(this.A, 1);
        measuredWidth = a(this.A, iArr);
        i8 = ((((width - paddingLeft) - paddingRight) / 2) + paddingLeft) - (measuredWidth / 2);
        measuredWidth += i8;
        if (i8 < i5) {
            i8 = i5;
        } else if (measuredWidth > i6) {
            i8 -= measuredWidth - i6;
        }
        paddingLeft = this.A.size();
        measuredWidth = i8;
        for (i5 = 0; i5 < paddingLeft; i5++) {
            measuredWidth = a((View) this.A.get(i5), measuredWidth, iArr, minimumHeightCompat);
        }
        this.A.clear();
    }

    private int a(List list, int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int size = list.size();
        int i3 = 0;
        int i4 = 0;
        int i5 = i2;
        int i6 = i;
        while (i3 < size) {
            View view = (View) list.get(i3);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            i6 = layoutParams.leftMargin - i6;
            i = layoutParams.rightMargin - i5;
            int max = Math.max(0, i6);
            int max2 = Math.max(0, i);
            i6 = Math.max(0, -i6);
            i5 = Math.max(0, -i);
            i3++;
            i4 += (view.getMeasuredWidth() + max) + max2;
        }
        return i4;
    }

    private int a(View view, int i, int[] iArr, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = layoutParams.leftMargin - iArr[0];
        int max = Math.max(0, i3) + i;
        iArr[0] = Math.max(0, -i3);
        i3 = a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, i3, max + measuredWidth, view.getMeasuredHeight() + i3);
        return (layoutParams.rightMargin + measuredWidth) + max;
    }

    private int b(View view, int i, int[] iArr, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = layoutParams.rightMargin - iArr[1];
        int max = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        i3 = a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, i3, max, view.getMeasuredHeight() + i3);
        return max - (layoutParams.leftMargin + measuredWidth);
    }

    private int a(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        switch (a(layoutParams.a)) {
            case nv.Theme_dividerVertical /*48*/:
                return getPaddingTop() - i2;
            case nv.Theme_colorControlHighlight /*80*/:
                return (((getHeight() - getPaddingBottom()) - measuredHeight) - layoutParams.bottomMargin) - i2;
            default:
                int i3;
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                i2 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                if (i2 < layoutParams.topMargin) {
                    i3 = layoutParams.topMargin;
                } else {
                    measuredHeight = (((height - paddingBottom) - measuredHeight) - i2) - paddingTop;
                    i3 = measuredHeight < layoutParams.bottomMargin ? Math.max(0, i2 - (layoutParams.bottomMargin - measuredHeight)) : i2;
                }
                return i3 + paddingTop;
        }
    }

    private int a(int i) {
        int i2 = i & 112;
        switch (i2) {
            case nv.Toolbar_maxButtonHeight /*16*/:
            case nv.Theme_dividerVertical /*48*/:
            case nv.Theme_colorControlHighlight /*80*/:
                return i2;
            default:
                return this.u & 112;
        }
    }

    private void a(List list, int i) {
        int i2 = 1;
        int i3 = 0;
        if (hg.g(this) != 1) {
            i2 = 0;
        }
        int childCount = getChildCount();
        int a = fv.a(i, hg.g(this));
        list.clear();
        LayoutParams layoutParams;
        if (i2 != 0) {
            for (i3 = childCount - 1; i3 >= 0; i3--) {
                View childAt = getChildAt(i3);
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.b == 0 && b(childAt) && b(layoutParams.a) == a) {
                    list.add(childAt);
                }
            }
            return;
        }
        while (i3 < childCount) {
            View childAt2 = getChildAt(i3);
            layoutParams = (LayoutParams) childAt2.getLayoutParams();
            if (layoutParams.b == 0 && b(childAt2) && b(layoutParams.a) == a) {
                list.add(childAt2);
            }
            i3++;
        }
    }

    private int b(int i) {
        int g = hg.g(this);
        int a = fv.a(i, g) & 7;
        switch (a) {
            case ve.CropImageView_fixAspectRatio /*1*/:
            case ve.CropImageView_aspectRatioY /*3*/:
            case Node.CDSECT /*5*/:
                return a;
            default:
                return g == 1 ? 5 : 3;
        }
    }

    private boolean b(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private int c(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return gh.b(marginLayoutParams) + gh.a(marginLayoutParams);
    }

    private int d(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
    }

    public LayoutParams a(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected LayoutParams a(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof android.support.v7.app.ActionBar.LayoutParams) {
            return new LayoutParams((android.support.v7.app.ActionBar.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof MarginLayoutParams) {
            return new LayoutParams((MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public LayoutParams i() {
        return new LayoutParams(-2, -2);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    public qo getWrapper() {
        if (this.E == null) {
            this.E = new ro(this, true);
        }
        return this.E;
    }

    private void setChildVisibilityForExpandedActionView(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (!(((LayoutParams) childAt.getLayoutParams()).b == 2 || childAt == this.b)) {
                int i2;
                if (z) {
                    i2 = 8;
                } else {
                    i2 = 0;
                }
                childAt.setVisibility(i2);
            }
        }
    }

    private void e(View view) {
        if (((LayoutParams) view.getLayoutParams()).b != 2 && view != this.b) {
            view.setVisibility(this.a != null ? 8 : 0);
        }
    }

    public void setCollapsible(boolean z) {
        this.J = z;
        requestLayout();
    }

    public void setMinimumHeight(int i) {
        this.K = i;
        super.setMinimumHeight(i);
    }

    private int getMinimumHeightCompat() {
        if (VERSION.SDK_INT >= 16) {
            return hg.l(this);
        }
        return this.K;
    }

    private static Context a(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, nv.Toolbar, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(nv.Toolbar_theme, 0);
        if (resourceId != 0) {
            context = new ContextThemeWrapper(context, resourceId);
        }
        obtainStyledAttributes.recycle();
        return context;
    }
}
