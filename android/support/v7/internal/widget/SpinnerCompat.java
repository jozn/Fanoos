package android.support.v7.internal.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.widget.Adapter;
import android.widget.SpinnerAdapter;
import fv;
import hg;
import nv;
import org.kxml2.kdom.Node;
import qj;
import rb;
import rc;
import rd;
import re;
import rf;
import rh;
import ri;
import rk;
import rn;
import ta;
import ve;

public class SpinnerCompat extends AbsSpinnerCompat implements OnClickListener {
    int E;
    private ta F;
    private ri G;
    private re H;
    private int I;
    private boolean J;
    private Rect K;
    private final rk L;

    public class SavedState extends android.support.v7.internal.widget.AbsSpinnerCompat.SavedState {
        public static final Creator CREATOR;
        boolean c;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.c = parcel.readByte() != null;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte((byte) (this.c ? 1 : 0));
        }

        static {
            CREATOR = new rh();
        }
    }

    public /* synthetic */ void setAdapter(Adapter adapter) {
        a((SpinnerAdapter) adapter);
    }

    public SpinnerCompat(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    SpinnerCompat(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.K = new Rect();
        rn a = rn.a(context, attributeSet, nv.Spinner, i, 0);
        setBackgroundDrawable(a.a(nv.Spinner_android_background));
        if (i2 == -1) {
            i2 = a.a(nv.Spinner_spinnerMode, 0);
        }
        switch (i2) {
            case ve.CropImageView_guidelines /*0*/:
                this.G = new rd();
                break;
            case ve.CropImageView_fixAspectRatio /*1*/:
                Object rfVar = new rf(this, context, attributeSet, i);
                this.E = a.e(nv.Spinner_android_dropDownWidth, -2);
                rfVar.a(a.a(nv.Spinner_android_popupBackground));
                this.G = rfVar;
                this.F = new rb(this, this, rfVar);
                break;
        }
        this.I = a.a(nv.Spinner_android_gravity, 17);
        this.G.a(a.c(nv.Spinner_prompt));
        this.J = a.a(nv.Spinner_disableChildrenWhenDisabled, false);
        a.b();
        if (this.H != null) {
            this.G.a(this.H);
            this.H = null;
        }
        this.L = a.c();
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (this.J) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).setEnabled(z);
            }
        }
    }

    public void a(SpinnerAdapter spinnerAdapter) {
        super.a(spinnerAdapter);
        this.i.a();
        if (getContext().getApplicationInfo().targetSdkVersion >= 21 && spinnerAdapter != null && spinnerAdapter.getViewTypeCount() != 1) {
            throw new IllegalArgumentException("Spinner adapter view type count must be 1");
        } else if (this.G != null) {
            this.G.a(new re(spinnerAdapter));
        } else {
            this.H = new re(spinnerAdapter);
        }
    }

    public int getBaseline() {
        View view = null;
        if (getChildCount() > 0) {
            view = getChildAt(0);
        } else if (this.a != null && this.a.getCount() > 0) {
            view = c(0, false);
            this.i.a(0, view);
        }
        if (view == null) {
            return -1;
        }
        int baseline = view.getBaseline();
        if (baseline >= 0) {
            return view.getTop() + baseline;
        }
        return -1;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.G != null && this.G.b()) {
            this.G.a();
        }
    }

    public void setOnItemClickListener(qj qjVar) {
        throw new RuntimeException("setOnItemClickListener cannot be used with a spinner.");
    }

    public void a(qj qjVar) {
        super.setOnItemClickListener(qjVar);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.F == null || !this.F.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.G != null && MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(c(), getBackground())), MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.q = true;
        a(0, false);
        this.q = false;
    }

    void a(int i, boolean z) {
        int i2 = this.h.left;
        int right = ((getRight() - getLeft()) - this.h.left) - this.h.right;
        if (this.u) {
            g();
        }
        if (this.z == 0) {
            a();
            return;
        }
        if (this.v >= 0) {
            setSelectedPositionInt(this.v);
        }
        b();
        removeAllViewsInLayout();
        this.j = this.x;
        if (this.a != null) {
            View c = c(this.x, true);
            int measuredWidth = c.getMeasuredWidth();
            switch (fv.a(this.I, hg.g(this)) & 7) {
                case ve.CropImageView_fixAspectRatio /*1*/:
                    i2 = (i2 + (right / 2)) - (measuredWidth / 2);
                    break;
                case Node.CDSECT /*5*/:
                    i2 = (i2 + right) - measuredWidth;
                    break;
            }
            c.offsetLeftAndRight(i2);
        }
        this.i.a();
        invalidate();
        h();
        this.u = false;
        this.o = false;
        setNextSelectedPositionInt(this.x);
    }

    private View c(int i, boolean z) {
        View a;
        if (!this.u) {
            a = this.i.a(i);
            if (a != null) {
                a(a, z);
                return a;
            }
        }
        a = this.a.getView(i, null, this);
        a(a, z);
        return a;
    }

    private void a(View view, boolean z) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = generateDefaultLayoutParams();
        }
        if (z) {
            addViewInLayout(view, 0, layoutParams);
        }
        view.setSelected(hasFocus());
        if (this.J) {
            view.setEnabled(isEnabled());
        }
        view.measure(ViewGroup.getChildMeasureSpec(this.c, this.h.left + this.h.right, layoutParams.width), ViewGroup.getChildMeasureSpec(this.b, this.h.top + this.h.bottom, layoutParams.height));
        int measuredHeight = this.h.top + ((((getMeasuredHeight() - this.h.bottom) - this.h.top) - view.getMeasuredHeight()) / 2);
        view.layout(0, measuredHeight, view.getMeasuredWidth() + 0, view.getMeasuredHeight() + measuredHeight);
    }

    public boolean performClick() {
        boolean performClick = super.performClick();
        if (!performClick) {
            performClick = true;
            if (!this.G.b()) {
                this.G.c();
            }
        }
        return performClick;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        setSelection(i);
        dialogInterface.dismiss();
    }

    int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        int max2 = Math.max(0, max - (15 - (min - max)));
        View view = null;
        int i = 0;
        max = 0;
        while (max2 < min) {
            View view2;
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != max) {
                view2 = null;
            } else {
                itemViewType = max;
                view2 = view;
            }
            view = spinnerAdapter.getView(max2, view2, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i = Math.max(i, view.getMeasuredWidth());
            max2++;
            max = itemViewType;
        }
        if (drawable == null) {
            return i;
        }
        drawable.getPadding(this.K);
        return (this.K.left + this.K.right) + i;
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        boolean z = this.G != null && this.G.b();
        savedState.c = z;
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.c) {
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnGlobalLayoutListener(new rc(this));
            }
        }
    }
}
