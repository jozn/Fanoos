import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

class qx extends BaseAdapter {
    final /* synthetic */ qv a;

    private qx(qv qvVar) {
        this.a = qvVar;
    }

    public int getCount() {
        return this.a.g.getChildCount();
    }

    public Object getItem(int i) {
        return ((qz) this.a.g.getChildAt(i)).b();
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            return this.a.b((mx) getItem(i), true);
        }
        ((qz) view).a((mx) getItem(i));
        return view;
    }
}
