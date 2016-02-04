import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import ir.seraj.fanoos3.R;

public class yq extends BaseAdapter {
    String[] a;
    Context b;
    public aen c;

    public /* synthetic */ Object getItem(int i) {
        return a(i);
    }

    public yq(Context context, String[] strArr, Integer[] numArr) {
        int i;
        int i2 = 0;
        this.b = context;
        int i3 = 0;
        for (i = 0; i < numArr.length; i += 2) {
            i3 += (numArr[i + 1].intValue() - numArr[i].intValue()) + 1;
        }
        this.a = new String[i3];
        i = 0;
        while (i2 < numArr.length) {
            i3 = numArr[i2].intValue();
            while (i3 <= numArr[i2 + 1].intValue()) {
                this.a[i] = strArr[i3];
                i3++;
                i++;
            }
            i2 += 2;
        }
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
        yr yrVar;
        String str = this.a[i];
        if (view == null) {
            View view2 = (ViewGroup) ((LayoutInflater) this.b.getSystemService("layout_inflater")).inflate(R.layout.list_item_sticky, null);
            yr yrVar2 = new yr();
            yrVar2.a = (ImageView) view2.findViewById(R.id.sticky_imageView);
            yrVar2.b = i;
            view2.setTag(yrVar2);
            view = view2;
            yrVar = yrVar2;
        } else {
            yrVar = (yr) view.getTag();
        }
        try {
            yrVar.a.setImageResource(this.b.getResources().getIdentifier(str, "drawable", this.b.getPackageName()));
        } catch (Exception e) {
            e.getMessage();
        }
        return view;
    }
}
