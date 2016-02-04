package com.edmodo.cropper;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.edmodo.cropper.cropwindow.CropOverlayView;
import vc;
import vd;
import ve;
import vf;
import vr;

public class CropImageView extends FrameLayout {
    private static final Rect a;
    private ImageView b;
    private CropOverlayView c;
    private Bitmap d;
    private int e;
    private int f;
    private int g;
    private int h;
    private boolean i;
    private int j;
    private int k;
    private int l;

    static {
        a = new Rect();
    }

    public CropImageView(Context context) {
        super(context);
        this.e = 0;
        this.h = 1;
        this.i = false;
        this.j = 1;
        this.k = 1;
        this.l = 0;
        a(context);
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = 0;
        this.h = 1;
        this.i = false;
        this.j = 1;
        this.k = 1;
        this.l = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ve.CropImageView, 0, 0);
        try {
            this.h = obtainStyledAttributes.getInteger(0, 1);
            this.i = obtainStyledAttributes.getBoolean(1, false);
            this.j = obtainStyledAttributes.getInteger(2, 1);
            this.k = obtainStyledAttributes.getInteger(3, 1);
            this.l = obtainStyledAttributes.getResourceId(4, 0);
            a(context);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public Parcelable onSaveInstanceState() {
        Parcelable bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putInt("DEGREES_ROTATED", this.e);
        return bundle;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            if (this.d != null) {
                this.e = bundle.getInt("DEGREES_ROTATED");
                int i = this.e;
                a(this.e);
                this.e = i;
            }
            super.onRestoreInstanceState(bundle.getParcelable("instanceState"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if (this.d != null) {
            this.c.setBitmapRect(vr.a(this.d, this));
            return;
        }
        this.c.setBitmapRect(a);
    }

    protected void onMeasure(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        if (this.d != null) {
            int width;
            int height;
            super.onMeasure(i, i2);
            if (size2 == 0) {
                size2 = this.d.getHeight();
            }
            double d = Double.POSITIVE_INFINITY;
            double d2 = Double.POSITIVE_INFINITY;
            if (size < this.d.getWidth()) {
                d = ((double) size) / ((double) this.d.getWidth());
            }
            if (size2 < this.d.getHeight()) {
                d2 = ((double) size2) / ((double) this.d.getHeight());
            }
            if (d == Double.POSITIVE_INFINITY && d2 == Double.POSITIVE_INFINITY) {
                width = this.d.getWidth();
                height = this.d.getHeight();
            } else if (d <= d2) {
                height = (int) (d * ((double) this.d.getHeight()));
                width = size;
            } else {
                width = (int) (((double) this.d.getWidth()) * d2);
                height = size2;
            }
            width = a(mode, size, width);
            size2 = a(mode2, size2, height);
            this.f = width;
            this.g = size2;
            this.c.setBitmapRect(vr.a(this.d.getWidth(), this.d.getHeight(), this.f, this.g));
            setMeasuredDimension(this.f, this.g);
            return;
        }
        this.c.setBitmapRect(a);
        setMeasuredDimension(size, size2);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f > 0 && this.g > 0) {
            LayoutParams layoutParams = getLayoutParams();
            layoutParams.width = this.f;
            layoutParams.height = this.g;
            setLayoutParams(layoutParams);
        }
    }

    public int getImageResource() {
        return this.l;
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.d = bitmap;
        this.b.setImageBitmap(this.d);
        if (this.c != null) {
            this.c.a();
        }
    }

    public void setImageResource(int i) {
        if (i != 0) {
            setImageBitmap(BitmapFactory.decodeResource(getResources(), i));
        }
    }

    public Bitmap getCroppedImage() {
        Rect a = vr.a(this.d, this.b);
        float width = ((float) this.d.getWidth()) / ((float) a.width());
        float height = ((float) this.d.getHeight()) / ((float) a.height());
        float a2 = vf.LEFT.a() - ((float) a.left);
        float a3 = vf.TOP.a() - ((float) a.top);
        return Bitmap.createBitmap(this.d, (int) (a2 * width), (int) (a3 * height), (int) (width * vf.b()), (int) (height * vf.c()));
    }

    public RectF getActualCropRect() {
        Rect a = vr.a(this.d, this.b);
        float width = ((float) this.d.getWidth()) / ((float) a.width());
        float height = ((float) this.d.getHeight()) / ((float) a.height());
        float a2 = vf.LEFT.a() - ((float) a.left);
        float a3 = vf.TOP.a() - ((float) a.top);
        a2 *= width;
        a3 *= height;
        return new RectF(Math.max(0.0f, a2), Math.max(0.0f, a3), Math.min((float) this.d.getWidth(), (width * vf.b()) + a2), Math.min((float) this.d.getHeight(), (height * vf.c()) + a3));
    }

    public void setFixedAspectRatio(boolean z) {
        this.c.setFixedAspectRatio(z);
    }

    public void setGuidelines(int i) {
        this.c.setGuidelines(i);
    }

    public void a(int i) {
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i);
        this.d = Bitmap.createBitmap(this.d, 0, 0, this.d.getWidth(), this.d.getHeight(), matrix, true);
        setImageBitmap(this.d);
        this.e += i;
        this.e %= 360;
    }

    private void a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(vd.crop_image_view, this, true);
        this.b = (ImageView) inflate.findViewById(vc.ImageView_image);
        setImageResource(this.l);
        this.c = (CropOverlayView) inflate.findViewById(vc.CropOverlayView);
        this.c.a(this.h, this.i, this.j, this.k);
    }

    private static int a(int i, int i2, int i3) {
        if (i == 1073741824) {
            return i2;
        }
        return i == Integer.MIN_VALUE ? Math.min(i3, i2) : i3;
    }
}
