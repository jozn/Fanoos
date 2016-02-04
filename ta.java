import android.os.SystemClock;
import android.support.v7.widget.ListPopupWindow;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;

public abstract class ta implements OnTouchListener {
    private final float a;
    private final int b;
    private final int c;
    private final View d;
    private Runnable e;
    private Runnable f;
    private boolean g;
    private boolean h;
    private int i;
    private final int[] j;

    public abstract ListPopupWindow a();

    public ta(View view) {
        this.j = new int[2];
        this.d = view;
        this.a = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.b = ViewConfiguration.getTapTimeout();
        this.c = (this.b + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean b;
        boolean z = this.g;
        if (z) {
            b = this.h ? b(motionEvent) : b(motionEvent) || !c();
        } else {
            boolean z2 = a(motionEvent) && b();
            if (z2) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                this.d.onTouchEvent(obtain);
                obtain.recycle();
            }
            b = z2;
        }
        this.g = b;
        if (b || z) {
            return true;
        }
        return false;
    }

    protected boolean b() {
        ListPopupWindow a = a();
        if (!(a == null || a.b())) {
            a.c();
        }
        return true;
    }

    protected boolean c() {
        ListPopupWindow a = a();
        if (a != null && a.b()) {
            a.a();
        }
        return true;
    }

    private boolean a(MotionEvent motionEvent) {
        View view = this.d;
        if (!view.isEnabled()) {
            return false;
        }
        switch (gu.a(motionEvent)) {
            case ve.CropImageView_guidelines /*0*/:
                this.i = motionEvent.getPointerId(0);
                this.h = false;
                if (this.e == null) {
                    this.e = new tb();
                }
                view.postDelayed(this.e, (long) this.b);
                if (this.f == null) {
                    this.f = new tc();
                }
                view.postDelayed(this.f, (long) this.c);
                return false;
            case ve.CropImageView_fixAspectRatio /*1*/:
            case ve.CropImageView_aspectRatioY /*3*/:
                d();
                return false;
            case ve.CropImageView_aspectRatioX /*2*/:
                int findPointerIndex = motionEvent.findPointerIndex(this.i);
                if (findPointerIndex < 0 || a(view, motionEvent.getX(findPointerIndex), motionEvent.getY(findPointerIndex), this.a)) {
                    return false;
                }
                d();
                view.getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            default:
                return false;
        }
    }

    private void d() {
        if (this.f != null) {
            this.d.removeCallbacks(this.f);
        }
        if (this.e != null) {
            this.d.removeCallbacks(this.e);
        }
    }

    private void e() {
        d();
        if (this.d.isEnabled() && b()) {
            this.d.getParent().requestDisallowInterceptTouchEvent(true);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            this.d.onTouchEvent(obtain);
            obtain.recycle();
            this.g = true;
            this.h = true;
        }
    }

    private boolean b(MotionEvent motionEvent) {
        boolean z = true;
        View view = this.d;
        ListPopupWindow a = a();
        if (a == null || !a.b()) {
            return false;
        }
        View a2 = a.f;
        if (a2 == null || !a2.isShown()) {
            return false;
        }
        MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        b(view, obtainNoHistory);
        a(a2, obtainNoHistory);
        boolean a3 = a2.a(obtainNoHistory, this.i);
        obtainNoHistory.recycle();
        int a4 = gu.a(motionEvent);
        boolean z2;
        if (a4 == 1 || a4 == 3) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!(a3 && r2)) {
            z = false;
        }
        return z;
    }

    private static boolean a(View view, float f, float f2, float f3) {
        return f >= (-f3) && f2 >= (-f3) && f < ((float) (view.getRight() - view.getLeft())) + f3 && f2 < ((float) (view.getBottom() - view.getTop())) + f3;
    }

    private boolean a(View view, MotionEvent motionEvent) {
        int[] iArr = this.j;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) (-iArr[0]), (float) (-iArr[1]));
        return true;
    }

    private boolean b(View view, MotionEvent motionEvent) {
        int[] iArr = this.j;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) iArr[0], (float) iArr[1]);
        return true;
    }
}
