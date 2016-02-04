import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.FloatMath;
import android.util.Log;
import android.view.GestureDetector;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import java.lang.ref.WeakReference;
import org.kxml2.kdom.Node;

public class adq implements adp, aed, OnTouchListener, OnGlobalLayoutListener {
    static final Interpolator a;
    private static final boolean c;
    private ScaleType A;
    int b;
    private float d;
    private float e;
    private float f;
    private boolean g;
    private WeakReference h;
    private GestureDetector i;
    private aec j;
    private final Matrix k;
    private final Matrix l;
    private final Matrix m;
    private final RectF n;
    private final float[] o;
    private adv p;
    private adw q;
    private adx r;
    private OnLongClickListener s;
    private int t;
    private int u;
    private int v;
    private int w;
    private adu x;
    private int y;
    private boolean z;

    static {
        c = Log.isLoggable("PhotoViewAttacher", 3);
        a = new AccelerateDecelerateInterpolator();
    }

    private static boolean a(ImageView imageView) {
        return (imageView == null || imageView.getDrawable() == null) ? false : true;
    }

    private static void b(ImageView imageView) {
        if (imageView != null && !(imageView instanceof adp) && !ScaleType.MATRIX.equals(imageView.getScaleType())) {
            imageView.setScaleType(ScaleType.MATRIX);
        }
    }

    public adq(ImageView imageView) {
        this.b = 200;
        this.d = 1.0f;
        this.e = 1.75f;
        this.f = 3.0f;
        this.g = true;
        this.k = new Matrix();
        this.l = new Matrix();
        this.m = new Matrix();
        this.n = new RectF();
        this.o = new float[9];
        this.y = 2;
        this.A = ScaleType.FIT_CENTER;
        this.h = new WeakReference(imageView);
        imageView.setDrawingCacheEnabled(true);
        imageView.setOnTouchListener(this);
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        b(imageView);
        if (!imageView.isInEditMode()) {
            this.j = aee.a(imageView.getContext(), this);
            this.i = new GestureDetector(imageView.getContext(), new adr(this));
            this.i.setOnDoubleTapListener(new ado(this));
            a(true);
        }
    }

    public void a() {
        if (this.h != null) {
            ImageView imageView = (ImageView) this.h.get();
            if (imageView != null) {
                ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                imageView.setOnTouchListener(null);
                m();
            }
            if (this.i != null) {
                this.i.setOnDoubleTapListener(null);
            }
            this.p = null;
            this.q = null;
            this.r = null;
            this.h = null;
        }
    }

    public RectF b() {
        p();
        return a(k());
    }

    public ImageView c() {
        ImageView imageView = null;
        if (this.h != null) {
            imageView = (ImageView) this.h.get();
        }
        if (imageView == null) {
            a();
            Log.i("PhotoViewAttacher", "ImageView no longer exists. You should not use this PhotoViewAttacher any more.");
        }
        return imageView;
    }

    public float d() {
        return this.d;
    }

    public float e() {
        return this.e;
    }

    public float f() {
        return this.f;
    }

    public float g() {
        return FloatMath.sqrt(((float) Math.pow((double) a(this.m, 0), 2.0d)) + ((float) Math.pow((double) a(this.m, 3), 2.0d)));
    }

    public void a(float f, float f2) {
        if (!this.j.a()) {
            if (c) {
                aef.a().a("PhotoViewAttacher", String.format("onDrag: dx: %.2f. dy: %.2f", new Object[]{Float.valueOf(f), Float.valueOf(f2)}));
            }
            ImageView c = c();
            this.m.postTranslate(f, f2);
            n();
            ViewParent parent = c.getParent();
            if (!this.g || this.j.a()) {
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            } else if ((this.y == 2 || ((this.y == 0 && f >= 1.0f) || (this.y == 1 && f <= -1.0f))) && parent != null) {
                parent.requestDisallowInterceptTouchEvent(false);
            }
        }
    }

    public void a(float f, float f2, float f3, float f4) {
        if (c) {
            aef.a().a("PhotoViewAttacher", "onFling. sX: " + f + " sY: " + f2 + " Vx: " + f3 + " Vy: " + f4);
        }
        ImageView c = c();
        this.x = new adu(this, c.getContext());
        this.x.a(c(c), d(c), (int) f3, (int) f4);
        c.post(this.x);
    }

    public void onGlobalLayout() {
        ImageView c = c();
        if (c == null) {
            return;
        }
        if (this.z) {
            int top = c.getTop();
            int right = c.getRight();
            int bottom = c.getBottom();
            int left = c.getLeft();
            if (top != this.t || bottom != this.v || left != this.w || right != this.u) {
                a(c.getDrawable());
                this.t = top;
                this.u = right;
                this.v = bottom;
                this.w = left;
                return;
            }
            return;
        }
        a(c.getDrawable());
    }

    public void a(float f, float f2, float f3) {
        if (c) {
            aef.a().a("PhotoViewAttacher", String.format("onScale: scale: %.2f. fX: %.2f. fY: %.2f", new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)}));
        }
        if (g() < this.f || f < 1.0f) {
            this.m.postScale(f, f, f2, f3);
            n();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(android.view.View r8, android.view.MotionEvent r9) {
        /*
        r7 = this;
        r6 = 1;
        r1 = 0;
        r0 = r7.z;
        if (r0 == 0) goto L_0x0071;
    L_0x0006:
        r0 = r8;
        r0 = (android.widget.ImageView) r0;
        r0 = a(r0);
        if (r0 == 0) goto L_0x0071;
    L_0x000f:
        r0 = r8.getParent();
        r2 = r9.getAction();
        switch(r2) {
            case 0: goto L_0x0036;
            case 1: goto L_0x0048;
            case 2: goto L_0x001a;
            case 3: goto L_0x0048;
            default: goto L_0x001a;
        };
    L_0x001a:
        r0 = r1;
    L_0x001b:
        r1 = r7.j;
        if (r1 == 0) goto L_0x0028;
    L_0x001f:
        r1 = r7.j;
        r1 = r1.c(r9);
        if (r1 == 0) goto L_0x0028;
    L_0x0027:
        r0 = r6;
    L_0x0028:
        r1 = r7.i;
        if (r1 == 0) goto L_0x0035;
    L_0x002c:
        r1 = r7.i;
        r1 = r1.onTouchEvent(r9);
        if (r1 == 0) goto L_0x0035;
    L_0x0034:
        r0 = r6;
    L_0x0035:
        return r0;
    L_0x0036:
        if (r0 == 0) goto L_0x0040;
    L_0x0038:
        r0.requestDisallowInterceptTouchEvent(r6);
    L_0x003b:
        r7.m();
        r0 = r1;
        goto L_0x001b;
    L_0x0040:
        r0 = "PhotoViewAttacher";
        r2 = "onTouch getParent() returned null";
        android.util.Log.i(r0, r2);
        goto L_0x003b;
    L_0x0048:
        r0 = r7.g();
        r2 = r7.d;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 >= 0) goto L_0x001a;
    L_0x0052:
        r5 = r7.b();
        if (r5 == 0) goto L_0x001a;
    L_0x0058:
        r0 = new adt;
        r2 = r7.g();
        r3 = r7.d;
        r4 = r5.centerX();
        r5 = r5.centerY();
        r1 = r7;
        r0.<init>(r1, r2, r3, r4, r5);
        r8.post(r0);
        r0 = r6;
        goto L_0x001b;
    L_0x0071:
        r0 = r1;
        goto L_0x0035;
        */
        throw new UnsupportedOperationException("Method not decompiled: adq.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public adw h() {
        return this.q;
    }

    public adx i() {
        return this.r;
    }

    public void a(float f, float f2, float f3, boolean z) {
        ImageView c = c();
        if (c == null) {
            return;
        }
        if (f < this.d || f > this.f) {
            aef.a().b("PhotoViewAttacher", "Scale must be within the range of minScale and maxScale");
        } else if (z) {
            c.post(new adt(this, g(), f, f2, f3));
        } else {
            this.m.setScale(f, f, f2, f3);
            n();
        }
    }

    public void a(boolean z) {
        this.z = z;
        j();
    }

    public void j() {
        ImageView c = c();
        if (c == null) {
            return;
        }
        if (this.z) {
            b(c);
            a(c.getDrawable());
            return;
        }
        q();
    }

    public Matrix k() {
        this.l.set(this.k);
        this.l.postConcat(this.m);
        return this.l;
    }

    private void m() {
        if (this.x != null) {
            this.x.a();
            this.x = null;
        }
    }

    private void n() {
        if (p()) {
            b(k());
        }
    }

    private void o() {
        ImageView c = c();
        if (c != null && !(c instanceof adp) && !ScaleType.MATRIX.equals(c.getScaleType())) {
            throw new IllegalStateException("The ImageView's ScaleType has been changed since attaching a PhotoViewAttacher");
        }
    }

    private boolean p() {
        float f = 0.0f;
        ImageView c = c();
        if (c == null) {
            return false;
        }
        RectF a = a(k());
        if (a == null) {
            return false;
        }
        float height = a.height();
        float width = a.width();
        int d = d(c);
        if (height <= ((float) d)) {
            switch (ads.a[this.A.ordinal()]) {
                case ve.CropImageView_aspectRatioX /*2*/:
                    height = -a.top;
                    break;
                case ve.CropImageView_aspectRatioY /*3*/:
                    height = (((float) d) - height) - a.top;
                    break;
                default:
                    height = ((((float) d) - height) / 2.0f) - a.top;
                    break;
            }
        } else if (a.top > 0.0f) {
            height = -a.top;
        } else if (a.bottom < ((float) d)) {
            height = ((float) d) - a.bottom;
        } else {
            height = 0.0f;
        }
        int c2 = c(c);
        if (width <= ((float) c2)) {
            switch (ads.a[this.A.ordinal()]) {
                case ve.CropImageView_aspectRatioX /*2*/:
                    f = -a.left;
                    break;
                case ve.CropImageView_aspectRatioY /*3*/:
                    f = (((float) c2) - width) - a.left;
                    break;
                default:
                    f = ((((float) c2) - width) / 2.0f) - a.left;
                    break;
            }
            this.y = 2;
        } else if (a.left > 0.0f) {
            this.y = 0;
            f = -a.left;
        } else if (a.right < ((float) c2)) {
            f = ((float) c2) - a.right;
            this.y = 1;
        } else {
            this.y = -1;
        }
        this.m.postTranslate(f, height);
        return true;
    }

    private RectF a(Matrix matrix) {
        ImageView c = c();
        if (c != null) {
            Drawable drawable = c.getDrawable();
            if (drawable != null) {
                this.n.set(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
                matrix.mapRect(this.n);
                return this.n;
            }
        }
        return null;
    }

    private float a(Matrix matrix, int i) {
        matrix.getValues(this.o);
        return this.o[i];
    }

    private void q() {
        this.m.reset();
        b(k());
        p();
    }

    private void b(Matrix matrix) {
        ImageView c = c();
        if (c != null) {
            o();
            c.setImageMatrix(matrix);
            if (this.p != null) {
                RectF a = a(matrix);
                if (a != null) {
                    this.p.a(a);
                }
            }
        }
    }

    private void a(Drawable drawable) {
        ImageView c = c();
        if (c != null && drawable != null) {
            float c2 = (float) c(c);
            float d = (float) d(c);
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.k.reset();
            float f = c2 / ((float) intrinsicWidth);
            float f2 = d / ((float) intrinsicHeight);
            if (this.A != ScaleType.CENTER) {
                if (this.A != ScaleType.CENTER_CROP) {
                    if (this.A != ScaleType.CENTER_INSIDE) {
                        RectF rectF = new RectF(0.0f, 0.0f, (float) intrinsicWidth, (float) intrinsicHeight);
                        RectF rectF2 = new RectF(0.0f, 0.0f, c2, d);
                        switch (ads.a[this.A.ordinal()]) {
                            case ve.CropImageView_aspectRatioX /*2*/:
                                this.k.setRectToRect(rectF, rectF2, ScaleToFit.START);
                                break;
                            case ve.CropImageView_aspectRatioY /*3*/:
                                this.k.setRectToRect(rectF, rectF2, ScaleToFit.END);
                                break;
                            case ve.CropImageView_imageResource /*4*/:
                                this.k.setRectToRect(rectF, rectF2, ScaleToFit.CENTER);
                                break;
                            case Node.CDSECT /*5*/:
                                this.k.setRectToRect(rectF, rectF2, ScaleToFit.FILL);
                                break;
                            default:
                                break;
                        }
                    }
                    f = Math.min(1.0f, Math.min(f, f2));
                    this.k.postScale(f, f);
                    this.k.postTranslate((c2 - (((float) intrinsicWidth) * f)) / 2.0f, (d - (((float) intrinsicHeight) * f)) / 2.0f);
                } else {
                    f = Math.max(f, f2);
                    this.k.postScale(f, f);
                    this.k.postTranslate((c2 - (((float) intrinsicWidth) * f)) / 2.0f, (d - (((float) intrinsicHeight) * f)) / 2.0f);
                }
            } else {
                this.k.postTranslate((c2 - ((float) intrinsicWidth)) / 2.0f, (d - ((float) intrinsicHeight)) / 2.0f);
            }
            q();
        }
    }

    private int c(ImageView imageView) {
        if (imageView == null) {
            return 0;
        }
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    private int d(ImageView imageView) {
        if (imageView == null) {
            return 0;
        }
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }
}
