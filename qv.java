import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.support.v7.internal.widget.SpinnerCompat;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.HorizontalScrollView;

public class qv extends HorizontalScrollView implements qj {
    private static final Interpolator l;
    Runnable a;
    int b;
    int c;
    protected iu d;
    protected final ra e;
    private qy f;
    private LinearLayoutCompat g;
    private SpinnerCompat h;
    private boolean i;
    private int j;
    private int k;

    static {
        l = new DecelerateInterpolator();
    }

    public qv(Context context) {
        super(context);
        this.e = new ra(this);
        setHorizontalScrollBarEnabled(false);
        og a = og.a(context);
        setContentHeight(a.e());
        this.c = a.g();
        this.g = d();
        addView(this.g, new LayoutParams(-2, -1));
    }

    public void onMeasure(int i, int i2) {
        int i3 = 1;
        int mode = MeasureSpec.getMode(i);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.g.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.b = -1;
        } else {
            if (childCount > 2) {
                this.b = (int) (((float) MeasureSpec.getSize(i)) * 0.4f);
            } else {
                this.b = MeasureSpec.getSize(i) / 2;
            }
            this.b = Math.min(this.b, this.c);
        }
        mode = MeasureSpec.makeMeasureSpec(this.j, 1073741824);
        if (z || !this.i) {
            i3 = 0;
        }
        if (i3 != 0) {
            this.g.measure(0, mode);
            if (this.g.getMeasuredWidth() > MeasureSpec.getSize(i)) {
                b();
            } else {
                c();
            }
        } else {
            c();
        }
        i3 = getMeasuredWidth();
        super.onMeasure(i, mode);
        int measuredWidth = getMeasuredWidth();
        if (z && i3 != measuredWidth) {
            setTabSelected(this.k);
        }
    }

    private boolean a() {
        return this.h != null && this.h.getParent() == this;
    }

    public void setAllowCollapse(boolean z) {
        this.i = z;
    }

    private void b() {
        if (!a()) {
            if (this.h == null) {
                this.h = e();
            }
            removeView(this.g);
            addView(this.h, new LayoutParams(-2, -1));
            if (this.h.c() == null) {
                this.h.a(new qx());
            }
            if (this.a != null) {
                removeCallbacks(this.a);
                this.a = null;
            }
            this.h.setSelection(this.k);
        }
    }

    private boolean c() {
        if (a()) {
            removeView(this.h);
            addView(this.g, new LayoutParams(-2, -1));
            setTabSelected(this.h.getSelectedItemPosition());
        }
        return false;
    }

    public void setTabSelected(int i) {
        this.k = i;
        int childCount = this.g.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            boolean z;
            View childAt = this.g.getChildAt(i2);
            if (i2 == i) {
                z = true;
            } else {
                z = false;
            }
            childAt.setSelected(z);
            if (z) {
                a(i);
            }
        }
        if (this.h != null && i >= 0) {
            this.h.setSelection(i);
        }
    }

    public void setContentHeight(int i) {
        this.j = i;
        requestLayout();
    }

    private LinearLayoutCompat d() {
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(getContext(), null, nl.actionBarTabBarStyle);
        linearLayoutCompat.setMeasureWithLargestChildEnabled(true);
        linearLayoutCompat.setGravity(17);
        linearLayoutCompat.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        return linearLayoutCompat;
    }

    private SpinnerCompat e() {
        SpinnerCompat spinnerCompat = new SpinnerCompat(getContext(), null, nl.actionDropDownStyle);
        spinnerCompat.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        spinnerCompat.a((qj) this);
        return spinnerCompat;
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        og a = og.a(getContext());
        setContentHeight(a.e());
        this.c = a.g();
    }

    public void a(int i) {
        View childAt = this.g.getChildAt(i);
        if (this.a != null) {
            removeCallbacks(this.a);
        }
        this.a = new qw(this, childAt);
        post(this.a);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.a != null) {
            post(this.a);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.a != null) {
            removeCallbacks(this.a);
        }
    }

    private qz b(mx mxVar, boolean z) {
        qz qzVar = new qz(this, getContext(), mxVar, z);
        if (z) {
            qzVar.setBackgroundDrawable(null);
            qzVar.setLayoutParams(new AbsListView.LayoutParams(-1, this.j));
        } else {
            qzVar.setFocusable(true);
            if (this.f == null) {
                this.f = new qy();
            }
            qzVar.setOnClickListener(this.f);
        }
        return qzVar;
    }

    public void a(mx mxVar, boolean z) {
        View b = b(mxVar, false);
        this.g.addView(b, new LinearLayoutCompat.LayoutParams(0, -1, 1.0f));
        if (this.h != null) {
            ((qx) this.h.c()).notifyDataSetChanged();
        }
        if (z) {
            b.setSelected(true);
        }
        if (this.i) {
            requestLayout();
        }
    }

    public void b(int i) {
        ((qz) this.g.getChildAt(i)).a();
        if (this.h != null) {
            ((qx) this.h.c()).notifyDataSetChanged();
        }
        if (this.i) {
            requestLayout();
        }
    }

    public void a(qg qgVar, View view, int i, long j) {
        ((qz) view).b().e();
    }
}
