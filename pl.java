import android.support.v7.internal.view.menu.ListMenuItemView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

class pl extends BaseAdapter {
    final /* synthetic */ pk a;
    private ox b;
    private int c;

    public /* synthetic */ Object getItem(int i) {
        return a(i);
    }

    public pl(pk pkVar, ox oxVar) {
        this.a = pkVar;
        this.c = -1;
        this.b = oxVar;
        a();
    }

    public int getCount() {
        ArrayList l = this.a.g ? this.b.l() : this.b.i();
        if (this.c < 0) {
            return l.size();
        }
        return l.size() - 1;
    }

    public pb a(int i) {
        ArrayList l = this.a.g ? this.b.l() : this.b.i();
        if (this.c >= 0 && i >= this.c) {
            i++;
        }
        return (pb) l.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate;
        if (view == null) {
            inflate = this.a.d.inflate(pk.a, viewGroup, false);
        } else {
            inflate = view;
        }
        pp ppVar = (pp) inflate;
        if (this.a.b) {
            ((ListMenuItemView) inflate).setForceShowIcon(true);
        }
        ppVar.a(a(i), 0);
        return inflate;
    }

    void a() {
        pb r = this.a.e.r();
        if (r != null) {
            ArrayList l = this.a.e.l();
            int size = l.size();
            for (int i = 0; i < size; i++) {
                if (((pb) l.get(i)) == r) {
                    this.c = i;
                    return;
                }
            }
        }
        this.c = -1;
    }

    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
