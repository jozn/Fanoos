import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

class ow extends BaseAdapter {
    final /* synthetic */ ov a;
    private int b;

    public /* synthetic */ Object getItem(int i) {
        return a(i);
    }

    public ow(ov ovVar) {
        this.a = ovVar;
        this.b = -1;
        a();
    }

    public int getCount() {
        int size = this.a.c.l().size() - this.a.h;
        return this.b < 0 ? size : size - 1;
    }

    public pb a(int i) {
        ArrayList l = this.a.c.l();
        int a = this.a.h + i;
        if (this.b >= 0 && a >= this.b) {
            a++;
        }
        return (pb) l.get(a);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate;
        if (view == null) {
            inflate = this.a.b.inflate(this.a.f, viewGroup, false);
        } else {
            inflate = view;
        }
        ((pp) inflate).a(a(i), 0);
        return inflate;
    }

    void a() {
        pb r = this.a.c.r();
        if (r != null) {
            ArrayList l = this.a.c.l();
            int size = l.size();
            for (int i = 0; i < size; i++) {
                if (((pb) l.get(i)) == r) {
                    this.b = i;
                    return;
                }
            }
        }
        this.b = -1;
    }

    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
