import android.graphics.drawable.Drawable;
import android.view.View;

public class od extends mx {
    final /* synthetic */ ny a;
    private my b;
    private Drawable c;
    private CharSequence d;
    private CharSequence e;
    private int f;
    private View g;

    public od(ny nyVar) {
        this.a = nyVar;
        this.f = -1;
    }

    public my g() {
        return this.b;
    }

    public mx a(my myVar) {
        this.b = myVar;
        return this;
    }

    public View d() {
        return this.g;
    }

    public Drawable b() {
        return this.c;
    }

    public int a() {
        return this.f;
    }

    public void a(int i) {
        this.f = i;
    }

    public CharSequence c() {
        return this.d;
    }

    public mx a(CharSequence charSequence) {
        this.d = charSequence;
        if (this.f >= 0) {
            this.a.s.b(this.f);
        }
        return this;
    }

    public void e() {
        this.a.b((mx) this);
    }

    public CharSequence f() {
        return this.e;
    }
}
