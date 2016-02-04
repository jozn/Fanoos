import android.content.Context;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup.LayoutParams;

public class uy implements pm {
    ox a;
    public pb b;
    final /* synthetic */ Toolbar c;

    private uy(Toolbar toolbar) {
        this.c = toolbar;
    }

    public void a(Context context, ox oxVar) {
        if (!(this.a == null || this.b == null)) {
            this.a.d(this.b);
        }
        this.a = oxVar;
    }

    public void a(boolean z) {
        Object obj = null;
        if (this.b != null) {
            if (this.a != null) {
                int size = this.a.size();
                for (int i = 0; i < size; i++) {
                    if (this.a.getItem(i) == this.b) {
                        obj = 1;
                        break;
                    }
                }
            }
            if (obj == null) {
                b(this.a, this.b);
            }
        }
    }

    public boolean a(ps psVar) {
        return false;
    }

    public void a(ox oxVar, boolean z) {
    }

    public boolean b() {
        return false;
    }

    public boolean a(ox oxVar, pb pbVar) {
        this.c.n();
        if (this.c.i.getParent() != this.c) {
            this.c.addView(this.c.i);
        }
        this.c.a = pbVar.getActionView();
        this.b = pbVar;
        if (this.c.a.getParent() != this.c) {
            LayoutParams i = this.c.i();
            i.a = 8388611 | (this.c.n & 112);
            i.b = 2;
            this.c.a.setLayoutParams(i);
            this.c.addView(this.c.a);
        }
        this.c.setChildVisibilityForExpandedActionView(true);
        this.c.requestLayout();
        pbVar.e(true);
        if (this.c.a instanceof rw) {
            ((rw) this.c.a).a();
        }
        return true;
    }

    public boolean b(ox oxVar, pb pbVar) {
        if (this.c.a instanceof rw) {
            ((rw) this.c.a).b();
        }
        this.c.removeView(this.c.a);
        this.c.removeView(this.c.i);
        this.c.a = null;
        this.c.setChildVisibilityForExpandedActionView(false);
        this.b = null;
        this.c.requestLayout();
        pbVar.e(false);
        return true;
    }
}
