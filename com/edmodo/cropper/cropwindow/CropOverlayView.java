package com.edmodo.cropper.cropwindow;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import ve;
import vf;
import vk;
import vo;
import vp;
import vs;

public class CropOverlayView extends View {
    private static final float a;
    private static final float b;
    private static final float c;
    private static final float d;
    private Paint e;
    private Paint f;
    private Paint g;
    private Paint h;
    private Rect i;
    private float j;
    private float k;
    private Pair l;
    private vk m;
    private boolean n;
    private int o;
    private int p;
    private float q;
    private int r;
    private boolean s;
    private float t;
    private float u;
    private float v;

    static {
        a = vs.b();
        b = vs.c();
        c = (a / 2.0f) - (b / 2.0f);
        d = (a / 2.0f) + c;
    }

    public CropOverlayView(Context context) {
        super(context);
        this.n = false;
        this.o = 1;
        this.p = 1;
        this.q = ((float) this.o) / ((float) this.p);
        this.s = false;
        a(context);
    }

    public CropOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.n = false;
        this.o = 1;
        this.p = 1;
        this.q = ((float) this.o) / ((float) this.p);
        this.s = false;
        a(context);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        a(this.i);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas, this.i);
        if (b()) {
            if (this.r == 2) {
                a(canvas);
            } else if (this.r == 1) {
                if (this.m != null) {
                    a(canvas);
                }
            } else if (this.r == 0) {
            }
        }
        canvas.drawRect(vf.LEFT.a(), vf.TOP.a(), vf.RIGHT.a(), vf.BOTTOM.a(), this.e);
        b(canvas);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case ve.CropImageView_guidelines /*0*/:
                a(motionEvent.getX(), motionEvent.getY());
                return true;
            case ve.CropImageView_fixAspectRatio /*1*/:
            case ve.CropImageView_aspectRatioY /*3*/:
                getParent().requestDisallowInterceptTouchEvent(false);
                c();
                return true;
            case ve.CropImageView_aspectRatioX /*2*/:
                b(motionEvent.getX(), motionEvent.getY());
                getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            default:
                return false;
        }
    }

    public void setBitmapRect(Rect rect) {
        this.i = rect;
        a(this.i);
    }

    public void a() {
        if (this.s) {
            a(this.i);
            invalidate();
        }
    }

    public void setGuidelines(int i) {
        if (i < 0 || i > 2) {
            throw new IllegalArgumentException("Guideline value must be set between 0 and 2. See documentation.");
        }
        this.r = i;
        if (this.s) {
            a(this.i);
            invalidate();
        }
    }

    public void setFixedAspectRatio(boolean z) {
        this.n = z;
        if (this.s) {
            a(this.i);
            invalidate();
        }
    }

    public void setAspectRatioX(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        }
        this.o = i;
        this.q = ((float) this.o) / ((float) this.p);
        if (this.s) {
            a(this.i);
            invalidate();
        }
    }

    public void setAspectRatioY(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        }
        this.p = i;
        this.q = ((float) this.o) / ((float) this.p);
        if (this.s) {
            a(this.i);
            invalidate();
        }
    }

    public void a(int i, boolean z, int i2, int i3) {
        if (i < 0 || i > 2) {
            throw new IllegalArgumentException("Guideline value must be set between 0 and 2. See documentation.");
        }
        this.r = i;
        this.n = z;
        if (i2 <= 0) {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        }
        this.o = i2;
        this.q = ((float) this.o) / ((float) this.p);
        if (i3 <= 0) {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        }
        this.p = i3;
        this.q = ((float) this.o) / ((float) this.p);
    }

    private void a(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.j = vp.a(context);
        this.k = TypedValue.applyDimension(1, 6.0f, displayMetrics);
        this.e = vs.a(context);
        this.f = vs.a();
        this.h = vs.b(context);
        this.g = vs.c(context);
        this.u = TypedValue.applyDimension(1, c, displayMetrics);
        this.t = TypedValue.applyDimension(1, d, displayMetrics);
        this.v = TypedValue.applyDimension(1, 20.0f, displayMetrics);
        this.r = 1;
    }

    private void a(Rect rect) {
        if (!this.s) {
            this.s = true;
        }
        float width;
        float height;
        if (!this.n) {
            width = ((float) rect.width()) * 0.1f;
            height = ((float) rect.height()) * 0.1f;
            vf.LEFT.a(((float) rect.left) + width);
            vf.TOP.a(((float) rect.top) + height);
            vf.RIGHT.a(((float) rect.right) - width);
            vf.BOTTOM.a(((float) rect.bottom) - height);
        } else if (vo.a(rect) > this.q) {
            vf.TOP.a((float) rect.top);
            vf.BOTTOM.a((float) rect.bottom);
            width = ((float) getWidth()) / 2.0f;
            height = Math.max(40.0f, vo.a(vf.TOP.a(), vf.BOTTOM.a(), this.q));
            if (height == 40.0f) {
                this.q = 40.0f / (vf.BOTTOM.a() - vf.TOP.a());
            }
            height /= 2.0f;
            vf.LEFT.a(width - height);
            vf.RIGHT.a(width + height);
        } else {
            vf.LEFT.a((float) rect.left);
            vf.RIGHT.a((float) rect.right);
            width = ((float) getHeight()) / 2.0f;
            height = Math.max(40.0f, vo.b(vf.LEFT.a(), vf.RIGHT.a(), this.q));
            if (height == 40.0f) {
                this.q = (vf.RIGHT.a() - vf.LEFT.a()) / 40.0f;
            }
            height /= 2.0f;
            vf.TOP.a(width - height);
            vf.BOTTOM.a(width + height);
        }
    }

    public static boolean b() {
        if (Math.abs(vf.LEFT.a() - vf.RIGHT.a()) < 100.0f || Math.abs(vf.TOP.a() - vf.BOTTOM.a()) < 100.0f) {
            return false;
        }
        return true;
    }

    private void a(Canvas canvas) {
        float a = vf.LEFT.a();
        float a2 = vf.TOP.a();
        float a3 = vf.RIGHT.a();
        float a4 = vf.BOTTOM.a();
        float b = vf.b() / 3.0f;
        float f = a + b;
        canvas.drawLine(f, a2, f, a4, this.f);
        f = a3 - b;
        canvas.drawLine(f, a2, f, a4, this.f);
        float c = vf.c() / 3.0f;
        b = a2 + c;
        canvas.drawLine(a, b, a3, b, this.f);
        b = a4 - c;
        canvas.drawLine(a, b, a3, b, this.f);
    }

    private void a(Canvas canvas, Rect rect) {
        float a = vf.LEFT.a();
        float a2 = vf.TOP.a();
        float a3 = vf.RIGHT.a();
        float a4 = vf.BOTTOM.a();
        canvas.drawRect((float) rect.left, (float) rect.top, (float) rect.right, a2, this.h);
        canvas.drawRect((float) rect.left, a4, (float) rect.right, (float) rect.bottom, this.h);
        canvas.drawRect((float) rect.left, a2, a, a4, this.h);
        canvas.drawRect(a3, a2, (float) rect.right, a4, this.h);
    }

    private void b(Canvas canvas) {
        float a = vf.LEFT.a();
        float a2 = vf.TOP.a();
        float a3 = vf.RIGHT.a();
        float a4 = vf.BOTTOM.a();
        canvas.drawLine(a - this.u, a2 - this.t, a - this.u, a2 + this.v, this.g);
        canvas.drawLine(a, a2 - this.u, a + this.v, a2 - this.u, this.g);
        canvas.drawLine(a3 + this.u, a2 - this.t, a3 + this.u, a2 + this.v, this.g);
        canvas.drawLine(a3, a2 - this.u, a3 - this.v, a2 - this.u, this.g);
        canvas.drawLine(a - this.u, a4 + this.t, a - this.u, a4 - this.v, this.g);
        canvas.drawLine(a, a4 + this.u, a + this.v, a4 + this.u, this.g);
        canvas.drawLine(a3 + this.u, a4 + this.t, a3 + this.u, a4 - this.v, this.g);
        canvas.drawLine(a3, a4 + this.u, a3 - this.v, a4 + this.u, this.g);
    }

    private void a(float f, float f2) {
        float a = vf.LEFT.a();
        float a2 = vf.TOP.a();
        float a3 = vf.RIGHT.a();
        float a4 = vf.BOTTOM.a();
        this.m = vp.a(f, f2, a, a2, a3, a4, this.j);
        if (this.m != null) {
            this.l = vp.a(this.m, f, f2, a, a2, a3, a4);
            invalidate();
        }
    }

    private void c() {
        if (this.m != null) {
            this.m = null;
            invalidate();
        }
    }

    private void b(float f, float f2) {
        if (this.m != null) {
            float floatValue = f + ((Float) this.l.first).floatValue();
            float floatValue2 = f2 + ((Float) this.l.second).floatValue();
            if (this.n) {
                this.m.a(floatValue, floatValue2, this.q, this.i, this.k);
            } else {
                this.m.a(floatValue, floatValue2, this.i, this.k);
            }
            invalidate();
        }
    }
}
