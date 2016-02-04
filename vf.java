import android.graphics.Rect;

public enum vf {
    LEFT,
    TOP,
    RIGHT,
    BOTTOM;
    
    private float e;

    public void a(float f) {
        this.e = f;
    }

    public void b(float f) {
        this.e += f;
    }

    public float a() {
        return this.e;
    }

    public void a(float f, float f2, Rect rect, float f3, float f4) {
        switch (vg.a[ordinal()]) {
            case ve.CropImageView_fixAspectRatio /*1*/:
                this.e = a(f, rect, f3, f4);
            case ve.CropImageView_aspectRatioX /*2*/:
                this.e = c(f2, rect, f3, f4);
            case ve.CropImageView_aspectRatioY /*3*/:
                this.e = b(f, rect, f3, f4);
            case ve.CropImageView_imageResource /*4*/:
                this.e = d(f2, rect, f3, f4);
            default:
        }
    }

    public void c(float f) {
        float a = LEFT.a();
        float a2 = TOP.a();
        float a3 = RIGHT.a();
        float a4 = BOTTOM.a();
        switch (vg.a[ordinal()]) {
            case ve.CropImageView_fixAspectRatio /*1*/:
                this.e = vo.b(a2, a3, a4, f);
            case ve.CropImageView_aspectRatioX /*2*/:
                this.e = vo.c(a, a3, a4, f);
            case ve.CropImageView_aspectRatioY /*3*/:
                this.e = vo.d(a, a2, a4, f);
            case ve.CropImageView_imageResource /*4*/:
                this.e = vo.e(a, a2, a3, f);
            default:
        }
    }

    public boolean a(vf vfVar, Rect rect, float f) {
        float b = vfVar.b(rect);
        float f2;
        float a;
        float a2;
        float f3;
        switch (vg.a[ordinal()]) {
            case ve.CropImageView_fixAspectRatio /*1*/:
                if (vfVar.equals(TOP)) {
                    f2 = (float) rect.top;
                    a = BOTTOM.a() - b;
                    a2 = RIGHT.a();
                    return a(f2, vo.b(f2, a2, a, f), a, a2, rect);
                } else if (vfVar.equals(BOTTOM)) {
                    a = (float) rect.bottom;
                    f2 = TOP.a() - b;
                    a2 = RIGHT.a();
                    return a(f2, vo.b(f2, a2, a, f), a, a2, rect);
                }
                break;
            case ve.CropImageView_aspectRatioX /*2*/:
                if (vfVar.equals(LEFT)) {
                    f3 = (float) rect.left;
                    a2 = RIGHT.a() - b;
                    a = BOTTOM.a();
                    return a(vo.c(f3, a2, a, f), f3, a, a2, rect);
                } else if (vfVar.equals(RIGHT)) {
                    a2 = (float) rect.right;
                    f3 = LEFT.a() - b;
                    a = BOTTOM.a();
                    return a(vo.c(f3, a2, a, f), f3, a, a2, rect);
                }
                break;
            case ve.CropImageView_aspectRatioY /*3*/:
                if (vfVar.equals(TOP)) {
                    f2 = (float) rect.top;
                    a = BOTTOM.a() - b;
                    f3 = LEFT.a();
                    return a(f2, f3, a, vo.d(f3, f2, a, f), rect);
                } else if (vfVar.equals(BOTTOM)) {
                    a = (float) rect.bottom;
                    f2 = TOP.a() - b;
                    f3 = LEFT.a();
                    return a(f2, f3, a, vo.d(f3, f2, a, f), rect);
                }
                break;
            case ve.CropImageView_imageResource /*4*/:
                if (vfVar.equals(LEFT)) {
                    f3 = (float) rect.left;
                    a2 = RIGHT.a() - b;
                    f2 = TOP.a();
                    return a(f2, f3, vo.e(f3, f2, a2, f), a2, rect);
                } else if (vfVar.equals(RIGHT)) {
                    a2 = (float) rect.right;
                    f3 = LEFT.a() - b;
                    f2 = TOP.a();
                    return a(f2, f3, vo.e(f3, f2, a2, f), a2, rect);
                }
                break;
        }
        return true;
    }

    private boolean a(float f, float f2, float f3, float f4, Rect rect) {
        return f < ((float) rect.top) || f2 < ((float) rect.left) || f3 > ((float) rect.bottom) || f4 > ((float) rect.right);
    }

    public float a(Rect rect) {
        float f = this.e;
        switch (vg.a[ordinal()]) {
            case ve.CropImageView_fixAspectRatio /*1*/:
                this.e = (float) rect.left;
                break;
            case ve.CropImageView_aspectRatioX /*2*/:
                this.e = (float) rect.top;
                break;
            case ve.CropImageView_aspectRatioY /*3*/:
                this.e = (float) rect.right;
                break;
            case ve.CropImageView_imageResource /*4*/:
                this.e = (float) rect.bottom;
                break;
        }
        return this.e - f;
    }

    public float b(Rect rect) {
        float f;
        float f2 = this.e;
        switch (vg.a[ordinal()]) {
            case ve.CropImageView_fixAspectRatio /*1*/:
                f = (float) rect.left;
                break;
            case ve.CropImageView_aspectRatioX /*2*/:
                f = (float) rect.top;
                break;
            case ve.CropImageView_aspectRatioY /*3*/:
                f = (float) rect.right;
                break;
            case ve.CropImageView_imageResource /*4*/:
                f = (float) rect.bottom;
                break;
            default:
                f = f2;
                break;
        }
        return f - f2;
    }

    public static float b() {
        return RIGHT.a() - LEFT.a();
    }

    public static float c() {
        return BOTTOM.a() - TOP.a();
    }

    public boolean a(Rect rect, float f) {
        switch (vg.a[ordinal()]) {
            case ve.CropImageView_fixAspectRatio /*1*/:
                if (this.e - ((float) rect.left) >= f) {
                    return false;
                }
                return true;
            case ve.CropImageView_aspectRatioX /*2*/:
                if (this.e - ((float) rect.top) >= f) {
                    return false;
                }
                return true;
            case ve.CropImageView_aspectRatioY /*3*/:
                if (((float) rect.right) - this.e >= f) {
                    return false;
                }
                return true;
            case ve.CropImageView_imageResource /*4*/:
                if (((float) rect.bottom) - this.e >= f) {
                    return false;
                }
                return true;
            default:
                return false;
        }
    }

    private static float a(float f, Rect rect, float f2, float f3) {
        float f4 = Float.POSITIVE_INFINITY;
        if (f - ((float) rect.left) < f2) {
            return (float) rect.left;
        }
        float a;
        if (f >= RIGHT.a() - 40.0f) {
            a = RIGHT.a() - 40.0f;
        } else {
            a = Float.POSITIVE_INFINITY;
        }
        if ((RIGHT.a() - f) / f3 <= 40.0f) {
            f4 = RIGHT.a() - (40.0f * f3);
        }
        return Math.min(f, Math.min(a, f4));
    }

    private static float b(float f, Rect rect, float f2, float f3) {
        float f4 = Float.NEGATIVE_INFINITY;
        if (((float) rect.right) - f < f2) {
            return (float) rect.right;
        }
        float a;
        if (f <= LEFT.a() + 40.0f) {
            a = LEFT.a() + 40.0f;
        } else {
            a = Float.NEGATIVE_INFINITY;
        }
        if ((f - LEFT.a()) / f3 <= 40.0f) {
            f4 = LEFT.a() + (40.0f * f3);
        }
        return Math.max(f, Math.max(a, f4));
    }

    private static float c(float f, Rect rect, float f2, float f3) {
        float f4 = Float.POSITIVE_INFINITY;
        if (f - ((float) rect.top) < f2) {
            return (float) rect.top;
        }
        float a;
        if (f >= BOTTOM.a() - 40.0f) {
            a = BOTTOM.a() - 40.0f;
        } else {
            a = Float.POSITIVE_INFINITY;
        }
        if ((BOTTOM.a() - f) * f3 <= 40.0f) {
            f4 = BOTTOM.a() - (40.0f / f3);
        }
        return Math.min(f, Math.min(a, f4));
    }

    private static float d(float f, Rect rect, float f2, float f3) {
        float f4 = Float.NEGATIVE_INFINITY;
        if (((float) rect.bottom) - f < f2) {
            return (float) rect.bottom;
        }
        float a;
        if (f <= TOP.a() + 40.0f) {
            a = TOP.a() + 40.0f;
        } else {
            a = Float.NEGATIVE_INFINITY;
        }
        if ((f - TOP.a()) * f3 <= 40.0f) {
            f4 = TOP.a() + (40.0f / f3);
        }
        return Math.max(f, Math.max(f4, a));
    }
}
