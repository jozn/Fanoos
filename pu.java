import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v7.widget.ActionMenuPresenter;
import android.support.v7.widget.ActionMenuView;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

public abstract class pu extends ViewGroup {
    private static final Interpolator j;
    protected final pv a;
    public final Context b;
    public ActionMenuView c;
    public ActionMenuPresenter d;
    public ViewGroup e;
    public boolean f;
    protected boolean g;
    public int h;
    protected iu i;

    static {
        j = new DecelerateInterpolator();
    }

    pu(Context context) {
        this(context, null);
    }

    pu(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public pu(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new pv(this);
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(nl.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.b = context;
        } else {
            this.b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, nv.ActionBar, nl.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(nv.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        if (this.d != null) {
            this.d.a(configuration);
        }
    }

    public void setSplitToolbar(boolean z) {
        this.f = z;
    }

    public void setSplitWhenNarrow(boolean z) {
        this.g = z;
    }

    public void setContentHeight(int i) {
        this.h = i;
        requestLayout();
    }

    public int getContentHeight() {
        return this.h;
    }

    public void setSplitView(ViewGroup viewGroup) {
        this.e = viewGroup;
    }

    public int getAnimatedVisibility() {
        if (this.i != null) {
            return this.a.a;
        }
        return getVisibility();
    }

    public void a(int i) {
        if (this.i != null) {
            this.i.a();
        }
        iu a;
        if (i == 0) {
            if (getVisibility() != 0) {
                hg.c((View) this, 0.0f);
                if (!(this.e == null || this.c == null)) {
                    hg.c(this.c, 0.0f);
                }
            }
            a = hg.m(this).a(1.0f);
            a.a(200);
            a.a(j);
            if (this.e == null || this.c == null) {
                a.a(this.a.a(a, i));
                a.b();
                return;
            }
            on onVar = new on();
            iu a2 = hg.m(this.c).a(1.0f);
            a2.a(200);
            onVar.a(this.a.a(a, i));
            onVar.a(a).a(a2);
            onVar.a();
            return;
        }
        a = hg.m(this).a(0.0f);
        a.a(200);
        a.a(j);
        if (this.e == null || this.c == null) {
            a.a(this.a.a(a, i));
            a.b();
            return;
        }
        onVar = new on();
        a2 = hg.m(this.c).a(0.0f);
        a2.a(200);
        onVar.a(this.a.a(a, i));
        onVar.a(a).a(a2);
        onVar.a();
    }

    public boolean a() {
        if (this.d != null) {
            return this.d.c();
        }
        return false;
    }

    public int a(View view, int i, int i2, int i3) {
        view.measure(MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - i3);
    }

    public static int a(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    public int a(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = ((i3 - measuredHeight) / 2) + i2;
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }
}
