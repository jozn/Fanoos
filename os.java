import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class os implements pm {
    public Context a;
    public Context b;
    public ox c;
    protected LayoutInflater d;
    protected LayoutInflater e;
    public po f;
    private pn g;
    private int h;
    private int i;
    private int j;

    public abstract void a(pb pbVar, pp ppVar);

    public os(Context context, int i, int i2) {
        this.a = context;
        this.d = LayoutInflater.from(context);
        this.h = i;
        this.i = i2;
    }

    public void a(Context context, ox oxVar) {
        this.b = context;
        this.e = LayoutInflater.from(this.b);
        this.c = oxVar;
    }

    public po a(ViewGroup viewGroup) {
        if (this.f == null) {
            this.f = (po) this.d.inflate(this.h, viewGroup, false);
            this.f.a(this.c);
            a(true);
        }
        return this.f;
    }

    public void a(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.f;
        if (viewGroup != null) {
            int i;
            if (this.c != null) {
                this.c.j();
                ArrayList i2 = this.c.i();
                int size = i2.size();
                int i3 = 0;
                i = 0;
                while (i3 < size) {
                    int i4;
                    pb pbVar = (pb) i2.get(i3);
                    if (a(i, pbVar)) {
                        View childAt = viewGroup.getChildAt(i);
                        pb itemData = childAt instanceof pp ? ((pp) childAt).getItemData() : null;
                        View a = a(pbVar, childAt, viewGroup);
                        if (pbVar != itemData) {
                            a.setPressed(false);
                            hg.q(a);
                        }
                        if (a != childAt) {
                            a(a, i);
                        }
                        i4 = i + 1;
                    } else {
                        i4 = i;
                    }
                    i3++;
                    i = i4;
                }
            } else {
                i = 0;
            }
            while (i < viewGroup.getChildCount()) {
                if (!a(viewGroup, i)) {
                    i++;
                }
            }
        }
    }

    protected void a(View view, int i) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f).addView(view, i);
    }

    public boolean a(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    public void a(pn pnVar) {
        this.g = pnVar;
    }

    public pn a() {
        return this.g;
    }

    public pp b(ViewGroup viewGroup) {
        return (pp) this.d.inflate(this.i, viewGroup, false);
    }

    public View a(pb pbVar, View view, ViewGroup viewGroup) {
        pp ppVar;
        if (view instanceof pp) {
            ppVar = (pp) view;
        } else {
            ppVar = b(viewGroup);
        }
        a(pbVar, ppVar);
        return (View) ppVar;
    }

    public boolean a(int i, pb pbVar) {
        return true;
    }

    public void a(ox oxVar, boolean z) {
        if (this.g != null) {
            this.g.a(oxVar, z);
        }
    }

    public boolean a(ps psVar) {
        if (this.g != null) {
            return this.g.a(psVar);
        }
        return false;
    }

    public boolean b() {
        return false;
    }

    public boolean a(ox oxVar, pb pbVar) {
        return false;
    }

    public boolean b(ox oxVar, pb pbVar) {
        return false;
    }

    public void a(int i) {
        this.j = i;
    }
}
