import android.content.Context;
import android.support.v7.internal.view.menu.ExpandedMenuView;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;

public class ov implements OnItemClickListener, pm {
    Context a;
    LayoutInflater b;
    ox c;
    ExpandedMenuView d;
    int e;
    int f;
    ow g;
    private int h;
    private pn i;

    public ov(Context context, int i) {
        this(i, 0);
        this.a = context;
        this.b = LayoutInflater.from(this.a);
    }

    public ov(int i, int i2) {
        this.f = i;
        this.e = i2;
    }

    public void a(Context context, ox oxVar) {
        if (this.e != 0) {
            this.a = new ContextThemeWrapper(context, this.e);
            this.b = LayoutInflater.from(this.a);
        } else if (this.a != null) {
            this.a = context;
            if (this.b == null) {
                this.b = LayoutInflater.from(this.a);
            }
        }
        this.c = oxVar;
        if (this.g != null) {
            this.g.notifyDataSetChanged();
        }
    }

    public po a(ViewGroup viewGroup) {
        if (this.d == null) {
            this.d = (ExpandedMenuView) this.b.inflate(ns.abc_expanded_menu_layout, viewGroup, false);
            if (this.g == null) {
                this.g = new ow(this);
            }
            this.d.setAdapter(this.g);
            this.d.setOnItemClickListener(this);
        }
        return this.d;
    }

    public ListAdapter a() {
        if (this.g == null) {
            this.g = new ow(this);
        }
        return this.g;
    }

    public void a(boolean z) {
        if (this.g != null) {
            this.g.notifyDataSetChanged();
        }
    }

    public void a(pn pnVar) {
        this.i = pnVar;
    }

    public boolean a(ps psVar) {
        if (!psVar.hasVisibleItems()) {
            return false;
        }
        new pa(psVar).a(null);
        if (this.i != null) {
            this.i.a(psVar);
        }
        return true;
    }

    public void a(ox oxVar, boolean z) {
        if (this.i != null) {
            this.i.a(oxVar, z);
        }
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.c.a(this.g.a(i), (pm) this, 0);
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
}
