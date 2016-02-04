import android.view.WindowInsets;

class jo extends jn {
    private final WindowInsets a;

    jo(WindowInsets windowInsets) {
        this.a = windowInsets;
    }

    public int a() {
        return this.a.getSystemWindowInsetLeft();
    }

    public int b() {
        return this.a.getSystemWindowInsetTop();
    }

    public int c() {
        return this.a.getSystemWindowInsetRight();
    }

    public int d() {
        return this.a.getSystemWindowInsetBottom();
    }

    public jn a(int i, int i2, int i3, int i4) {
        return new jo(this.a.replaceSystemWindowInsets(i, i2, i3, i4));
    }

    WindowInsets e() {
        return this.a;
    }
}
