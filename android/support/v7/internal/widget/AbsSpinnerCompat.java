package android.support.v7.internal.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.Adapter;
import android.widget.SpinnerAdapter;
import hg;
import pw;
import px;
import qg;
import qi;

public abstract class AbsSpinnerCompat extends qg {
    private DataSetObserver E;
    SpinnerAdapter a;
    int b;
    int c;
    int d;
    int e;
    int f;
    int g;
    final Rect h;
    final pw i;

    public class SavedState extends BaseSavedState {
        public static final Creator CREATOR;
        long a;
        int b;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readLong();
            this.b = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.a);
            parcel.writeInt(this.b);
        }

        public String toString() {
            return "AbsSpinner.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.a + " position=" + this.b + "}";
        }

        static {
            CREATOR = new px();
        }
    }

    abstract void a(int i, boolean z);

    public /* synthetic */ Adapter getAdapter() {
        return c();
    }

    public /* synthetic */ void setAdapter(Adapter adapter) {
        a((SpinnerAdapter) adapter);
    }

    AbsSpinnerCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = new Rect();
        this.i = new pw(this);
        k();
    }

    private void k() {
        setFocusable(true);
        setWillNotDraw(false);
    }

    public void a(SpinnerAdapter spinnerAdapter) {
        int i = -1;
        if (this.a != null) {
            this.a.unregisterDataSetObserver(this.E);
            a();
        }
        this.a = spinnerAdapter;
        this.B = -1;
        this.C = Long.MIN_VALUE;
        if (this.a != null) {
            this.A = this.z;
            this.z = this.a.getCount();
            e();
            this.E = new qi(this);
            this.a.registerDataSetObserver(this.E);
            if (this.z > 0) {
                i = 0;
            }
            setSelectedPositionInt(i);
            setNextSelectedPositionInt(i);
            if (this.z == 0) {
                h();
            }
        } else {
            e();
            a();
            h();
        }
        requestLayout();
    }

    void a() {
        this.u = false;
        this.o = false;
        removeAllViewsInLayout();
        this.B = -1;
        this.C = Long.MIN_VALUE;
        setSelectedPositionInt(-1);
        setNextSelectedPositionInt(-1);
        invalidate();
    }

    protected void onMeasure(int i, int i2) {
        boolean z;
        int mode = MeasureSpec.getMode(i);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        Rect rect = this.h;
        if (paddingLeft <= this.d) {
            paddingLeft = this.d;
        }
        rect.left = paddingLeft;
        this.h.top = paddingTop > this.e ? paddingTop : this.e;
        this.h.right = paddingRight > this.f ? paddingRight : this.f;
        this.h.bottom = paddingBottom > this.g ? paddingBottom : this.g;
        if (this.u) {
            g();
        }
        paddingTop = getSelectedItemPosition();
        if (paddingTop >= 0 && this.a != null && paddingTop < this.a.getCount()) {
            View a = this.i.a(paddingTop);
            if (a == null) {
                a = this.a.getView(paddingTop, null, this);
            }
            if (a != null) {
                this.i.a(paddingTop, a);
                if (a.getLayoutParams() == null) {
                    this.D = true;
                    a.setLayoutParams(generateDefaultLayoutParams());
                    this.D = false;
                }
                measureChild(a, i, i2);
                paddingTop = (a(a) + this.h.top) + this.h.bottom;
                paddingLeft = (b(a) + this.h.left) + this.h.right;
                z = false;
                if (z) {
                    paddingTop = this.h.top + this.h.bottom;
                    if (mode == 0) {
                        paddingLeft = this.h.left + this.h.right;
                    }
                }
                setMeasuredDimension(hg.a(Math.max(paddingLeft, getSuggestedMinimumWidth()), i, 0), hg.a(Math.max(paddingTop, getSuggestedMinimumHeight()), i2, 0));
                this.b = i2;
                this.c = i;
            }
        }
        z = true;
        paddingLeft = 0;
        paddingTop = 0;
        if (z) {
            paddingTop = this.h.top + this.h.bottom;
            if (mode == 0) {
                paddingLeft = this.h.left + this.h.right;
            }
        }
        setMeasuredDimension(hg.a(Math.max(paddingLeft, getSuggestedMinimumWidth()), i, 0), hg.a(Math.max(paddingTop, getSuggestedMinimumHeight()), i2, 0));
        this.b = i2;
        this.c = i;
    }

    int a(View view) {
        return view.getMeasuredHeight();
    }

    int b(View view) {
        return view.getMeasuredWidth();
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    void b() {
        int childCount = getChildCount();
        pw pwVar = this.i;
        int i = this.j;
        for (int i2 = 0; i2 < childCount; i2++) {
            pwVar.a(i + i2, getChildAt(i2));
        }
    }

    public void setSelection(int i) {
        setNextSelectedPositionInt(i);
        requestLayout();
        invalidate();
    }

    public View getSelectedView() {
        if (this.z <= 0 || this.x < 0) {
            return null;
        }
        return getChildAt(this.x - this.j);
    }

    public void requestLayout() {
        if (!this.D) {
            super.requestLayout();
        }
    }

    public SpinnerAdapter c() {
        return this.a;
    }

    public int getCount() {
        return this.z;
    }

    public Parcelable onSaveInstanceState() {
        Object savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = getSelectedItemId();
        if (savedState.a >= 0) {
            savedState.b = getSelectedItemPosition();
        } else {
            savedState.b = -1;
        }
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.a >= 0) {
            this.u = true;
            this.o = true;
            this.m = savedState.a;
            this.l = savedState.b;
            this.p = 0;
            requestLayout();
        }
    }
}
