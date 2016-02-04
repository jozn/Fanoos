import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import ir.seraj.fanoos3.R;

public class yi extends BaseAdapter {
    String[] a;
    Context b;
    public aen c;

    public /* synthetic */ Object getItem(int i) {
        return a(i);
    }

    public yi(Context context, String[] strArr) {
        this.b = context;
        this.a = strArr;
        this.c = new aen(context);
    }

    public int getCount() {
        if (this.a == null) {
            return 0;
        }
        return this.a.length;
    }

    public String a(int i) {
        String str = null;
        if (this.a != null) {
            try {
                str = this.a[i];
            } catch (Exception e) {
            }
        }
        return str;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        yj yjVar;
        String str = this.a[i];
        if (view == null) {
            View view2 = (ViewGroup) ((LayoutInflater) this.b.getSystemService("layout_inflater")).inflate(R.layout.list_item_emotion, null);
            yj yjVar2 = new yj();
            yjVar2.a = (ImageView) view2.findViewById(R.id.sticky_imageView);
            yjVar2.b = i;
            view2.setTag(yjVar2);
            view = view2;
            yjVar = yjVar2;
        } else {
            yjVar = (yj) view.getTag();
        }
        try {
            yjVar.a.setImageResource(this.b.getResources().getIdentifier(str, "drawable", this.b.getPackageName()));
        } catch (Exception e) {
            e.getMessage();
        }
        return view;
    }
}
