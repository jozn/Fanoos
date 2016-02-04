import android.content.Context;
import android.support.v7.internal.widget.ListViewCompat;
import android.view.MotionEvent;
import android.view.View;

public class sz extends ListViewCompat {
    private boolean f;
    private boolean g;
    private boolean h;
    private iu i;
    private lx j;

    public sz(Context context, boolean z) {
        super(context, null, nl.dropDownListViewStyle);
        this.g = z;
        setCacheColorHint(0);
    }

    public boolean a(MotionEvent motionEvent, int i) {
        boolean z;
        boolean z2;
        int a = gu.a(motionEvent);
        switch (a) {
            case ve.CropImageView_fixAspectRatio /*1*/:
                z = false;
                break;
            case ve.CropImageView_aspectRatioX /*2*/:
                z = true;
                break;
            case ve.CropImageView_aspectRatioY /*3*/:
                z = false;
                z2 = false;
                break;
            default:
                z = false;
                z2 = true;
                break;
        }
        int findPointerIndex = motionEvent.findPointerIndex(i);
        if (findPointerIndex < 0) {
            z = false;
            z2 = false;
        } else {
            int x = (int) motionEvent.getX(findPointerIndex);
            findPointerIndex = (int) motionEvent.getY(findPointerIndex);
            int pointToPosition = pointToPosition(x, findPointerIndex);
            if (pointToPosition == -1) {
                z2 = z;
                z = true;
            } else {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                a(childAt, pointToPosition, (float) x, (float) findPointerIndex);
                if (a == 1) {
                    a(childAt, pointToPosition);
                }
                z = false;
                z2 = true;
            }
        }
        if (!z2 || r0) {
            d();
        }
        if (z2) {
            if (this.j == null) {
                this.j = new lx(this);
            }
            this.j.a(true);
            this.j.onTouch(this, motionEvent);
        } else if (this.j != null) {
            this.j.a(false);
        }
        return z2;
    }

    private void a(View view, int i) {
        performItemClick(view, i, getItemIdAtPosition(i));
    }

    private void d() {
        this.h = false;
        setPressed(false);
        drawableStateChanged();
        if (this.i != null) {
            this.i.a();
            this.i = null;
        }
    }

    private void a(View view, int i, float f, float f2) {
        this.h = true;
        setPressed(true);
        layoutChildren();
        setSelection(i);
        a(i, view, f, f2);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    protected boolean c() {
        return this.h || super.c();
    }

    public boolean isInTouchMode() {
        return (this.g && this.f) || super.isInTouchMode();
    }

    public boolean hasWindowFocus() {
        return this.g || super.hasWindowFocus();
    }

    public boolean isFocused() {
        return this.g || super.isFocused();
    }

    public boolean hasFocus() {
        return this.g || super.hasFocus();
    }
}
