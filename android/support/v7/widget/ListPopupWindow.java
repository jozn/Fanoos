package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.internal.widget.AppCompatPopupWindow;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import eo;
import java.lang.reflect.Method;
import ly;
import nv;
import sx;
import sy;
import sz;
import td;
import te;
import tf;
import tg;
import th;
import ve;

public class ListPopupWindow {
    private static Method a;
    private Handler A;
    private Rect B;
    private boolean C;
    private int D;
    public int b;
    private Context c;
    private PopupWindow d;
    private ListAdapter e;
    private sz f;
    private int g;
    private int h;
    private int i;
    private int j;
    private boolean k;
    private int l;
    private boolean m;
    private boolean n;
    private View o;
    private int p;
    private DataSetObserver q;
    private View r;
    private Drawable s;
    private OnItemClickListener t;
    private OnItemSelectedListener u;
    private final th v;
    private final tg w;
    private final tf x;
    private final td y;
    private Runnable z;

    static {
        try {
            a = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException e) {
            Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        this.g = -2;
        this.h = -2;
        this.l = 0;
        this.m = false;
        this.n = false;
        this.b = Integer.MAX_VALUE;
        this.p = 0;
        this.v = new th();
        this.w = new tg();
        this.x = new tf();
        this.y = new td();
        this.A = new Handler();
        this.B = new Rect();
        this.c = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, nv.ListPopupWindow, i, i2);
        this.i = obtainStyledAttributes.getDimensionPixelOffset(nv.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.j = obtainStyledAttributes.getDimensionPixelOffset(nv.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.j != 0) {
            this.k = true;
        }
        obtainStyledAttributes.recycle();
        this.d = new AppCompatPopupWindow(context, attributeSet, i);
        this.d.setInputMethodMode(1);
        this.D = eo.a(this.c.getResources().getConfiguration().locale);
    }

    public void a(ListAdapter listAdapter) {
        if (this.q == null) {
            this.q = new te();
        } else if (this.e != null) {
            this.e.unregisterDataSetObserver(this.q);
        }
        this.e = listAdapter;
        if (this.e != null) {
            listAdapter.registerDataSetObserver(this.q);
        }
        if (this.f != null) {
            this.f.setAdapter(this.e);
        }
    }

    public void a(int i) {
        this.p = i;
    }

    public void a(boolean z) {
        this.C = z;
        this.d.setFocusable(z);
    }

    public void a(Drawable drawable) {
        this.d.setBackgroundDrawable(drawable);
    }

    public View d() {
        return this.r;
    }

    public void a(View view) {
        this.r = view;
    }

    public void b(int i) {
        this.l = i;
    }

    public void c(int i) {
        this.h = i;
    }

    public void d(int i) {
        Drawable background = this.d.getBackground();
        if (background != null) {
            background.getPadding(this.B);
            this.h = (this.B.left + this.B.right) + i;
            return;
        }
        c(i);
    }

    public void a(OnItemClickListener onItemClickListener) {
        this.t = onItemClickListener;
    }

    public void c() {
        boolean z = true;
        boolean z2 = false;
        int i = -1;
        int i2 = i();
        boolean f = f();
        int i3;
        if (this.d.isShowing()) {
            if (this.h == -1) {
                i3 = -1;
            } else if (this.h == -2) {
                i3 = d().getWidth();
            } else {
                i3 = this.h;
            }
            if (this.g == -1) {
                if (!f) {
                    i2 = -1;
                }
                if (f) {
                    PopupWindow popupWindow = this.d;
                    if (this.h != -1) {
                        i = 0;
                    }
                    popupWindow.setWindowLayoutMode(i, 0);
                } else {
                    this.d.setWindowLayoutMode(this.h == -1 ? -1 : 0, -1);
                }
            } else if (this.g != -2) {
                i2 = this.g;
            }
            PopupWindow popupWindow2 = this.d;
            if (!(this.n || this.m)) {
                z2 = true;
            }
            popupWindow2.setOutsideTouchable(z2);
            this.d.update(d(), this.i, this.j, i3, i2);
            return;
        }
        int i4;
        if (this.h == -1) {
            i4 = -1;
        } else if (this.h == -2) {
            this.d.setWidth(d().getWidth());
            i4 = 0;
        } else {
            this.d.setWidth(this.h);
            i4 = 0;
        }
        if (this.g == -1) {
            i3 = -1;
        } else if (this.g == -2) {
            this.d.setHeight(i2);
            i3 = 0;
        } else {
            this.d.setHeight(this.g);
            i3 = 0;
        }
        this.d.setWindowLayoutMode(i4, i3);
        b(true);
        popupWindow = this.d;
        if (this.n || this.m) {
            z = false;
        }
        popupWindow.setOutsideTouchable(z);
        this.d.setTouchInterceptor(this.w);
        ly.a(this.d, d(), this.i, this.j, this.l);
        this.f.setSelection(-1);
        if (!this.C || this.f.isInTouchMode()) {
            e();
        }
        if (!this.C) {
            this.A.post(this.y);
        }
    }

    public void a() {
        this.d.dismiss();
        h();
        this.d.setContentView(null);
        this.f = null;
        this.A.removeCallbacks(this.v);
    }

    public void a(OnDismissListener onDismissListener) {
        this.d.setOnDismissListener(onDismissListener);
    }

    private void h() {
        if (this.o != null) {
            ViewParent parent = this.o.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.o);
            }
        }
    }

    public void e(int i) {
        this.d.setInputMethodMode(i);
    }

    public void e() {
        sz szVar = this.f;
        if (szVar != null) {
            szVar.f = true;
            szVar.requestLayout();
        }
    }

    public boolean b() {
        return this.d.isShowing();
    }

    public boolean f() {
        return this.d.getInputMethodMode() == 2;
    }

    public ListView g() {
        return this.f;
    }

    private int i() {
        int measuredHeight;
        int i;
        int i2;
        int maxAvailableHeight;
        LayoutParams layoutParams;
        View view;
        if (this.f == null) {
            Context context = this.c;
            this.z = new sx(this);
            this.f = new sz(context, !this.C);
            if (this.s != null) {
                this.f.setSelector(this.s);
            }
            this.f.setAdapter(this.e);
            this.f.setOnItemClickListener(this.t);
            this.f.setFocusable(true);
            this.f.setFocusableInTouchMode(true);
            this.f.setOnItemSelectedListener(new sy(this));
            this.f.setOnScrollListener(this.x);
            if (this.u != null) {
                this.f.setOnItemSelectedListener(this.u);
            }
            View view2 = this.f;
            View view3 = this.o;
            if (view3 != null) {
                View linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-1, 0, 1.0f);
                switch (this.p) {
                    case ve.CropImageView_guidelines /*0*/:
                        linearLayout.addView(view3);
                        linearLayout.addView(view2, layoutParams2);
                        break;
                    case ve.CropImageView_fixAspectRatio /*1*/:
                        linearLayout.addView(view2, layoutParams2);
                        linearLayout.addView(view3);
                        break;
                    default:
                        Log.e("ListPopupWindow", "Invalid hint position " + this.p);
                        break;
                }
                view3.measure(MeasureSpec.makeMeasureSpec(this.h, Integer.MIN_VALUE), 0);
                layoutParams = (LayoutParams) view3.getLayoutParams();
                measuredHeight = layoutParams.bottomMargin + (view3.getMeasuredHeight() + layoutParams.topMargin);
                view = linearLayout;
            } else {
                view = view2;
                measuredHeight = 0;
            }
            this.d.setContentView(view);
            i = measuredHeight;
        } else {
            ViewGroup viewGroup = (ViewGroup) this.d.getContentView();
            view = this.o;
            if (view != null) {
                layoutParams = (LayoutParams) view.getLayoutParams();
                i = layoutParams.bottomMargin + (view.getMeasuredHeight() + layoutParams.topMargin);
            } else {
                i = 0;
            }
        }
        Drawable background = this.d.getBackground();
        if (background != null) {
            background.getPadding(this.B);
            measuredHeight = this.B.top + this.B.bottom;
            if (this.k) {
                i2 = measuredHeight;
            } else {
                this.j = -this.B.top;
                i2 = measuredHeight;
            }
        } else {
            this.B.setEmpty();
            i2 = 0;
        }
        if (this.d.getInputMethodMode() == 2) {
            maxAvailableHeight = this.d.getMaxAvailableHeight(d(), this.j);
        } else {
            maxAvailableHeight = this.d.getMaxAvailableHeight(d(), this.j);
        }
        if (this.m || this.g == -1) {
            return maxAvailableHeight + i2;
        }
        int makeMeasureSpec;
        switch (this.h) {
            case -2:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.c.getResources().getDisplayMetrics().widthPixels - (this.B.left + this.B.right), Integer.MIN_VALUE);
                break;
            case -1:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.c.getResources().getDisplayMetrics().widthPixels - (this.B.left + this.B.right), 1073741824);
                break;
            default:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.h, 1073741824);
                break;
        }
        measuredHeight = this.f.a(makeMeasureSpec, 0, -1, maxAvailableHeight - i, -1);
        if (measuredHeight > 0) {
            i += i2;
        }
        return measuredHeight + i;
    }

    private void b(boolean z) {
        if (a != null) {
            try {
                a.invoke(this.d, new Object[]{Boolean.valueOf(z)});
            } catch (Exception e) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }
}
