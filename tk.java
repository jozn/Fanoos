import android.view.View;

public abstract class tk {
    protected final tv a;
    private int b;

    public abstract int a(View view);

    public abstract void a(int i);

    public abstract int b(View view);

    public abstract int c();

    public abstract int c(View view);

    public abstract int d();

    public abstract int d(View view);

    public abstract int e();

    public abstract int f();

    public abstract int g();

    private tk(tv tvVar) {
        this.b = Integer.MIN_VALUE;
        this.a = tvVar;
    }

    public void a() {
        this.b = f();
    }

    public int b() {
        return Integer.MIN_VALUE == this.b ? 0 : f() - this.b;
    }

    public static tk a(tv tvVar, int i) {
        switch (i) {
            case ve.CropImageView_guidelines /*0*/:
                return a(tvVar);
            case ve.CropImageView_fixAspectRatio /*1*/:
                return b(tvVar);
            default:
                throw new IllegalArgumentException("invalid orientation");
        }
    }

    public static tk a(tv tvVar) {
        return new tl(tvVar);
    }

    public static tk b(tv tvVar) {
        return new tm(tvVar);
    }
}
