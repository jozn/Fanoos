import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import ir.seraj.fanoos3.R;
import java.util.List;

public class xt extends BaseAdapter {
    List a;
    Context b;
    public aay c;

    public /* synthetic */ Object getItem(int i) {
        return a(i);
    }

    public xt(Context context, List list) {
        this.b = context;
        this.a = list;
        this.c = new aay(context, null, Boolean.valueOf(true), Boolean.valueOf(false), zk.c);
    }

    public int getCount() {
        if (this.a == null) {
            return 0;
        }
        return this.a.size();
    }

    public zg a(int i) {
        if (this.a == null) {
            return null;
        }
        try {
            return (zg) this.a.get(i);
        } catch (Exception e) {
            return null;
        }
    }

    public long getItemId(int i) {
        if (this.a == null) {
            return -1;
        }
        try {
            return ((zg) this.a.get(i)).c().longValue();
        } catch (Exception e) {
            return -1;
        }
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        xu xuVar;
        zg zgVar = (zg) this.a.get(i);
        if (view == null) {
            View view2 = (ViewGroup) ((LayoutInflater) this.b.getSystemService("layout_inflater")).inflate(R.layout.list_item_add_single_participants, null);
            xu xuVar2 = new xu();
            xuVar2.b = (TextView) view2.findViewById(R.id.addParticipants_item_userName_textView);
            xuVar2.a = (ImageView) view2.findViewById(R.id.addParticipants_item_imageContact_imageView);
            xuVar2.c = i;
            view2.setTag(xuVar2);
            view = view2;
            xuVar = xuVar2;
        } else {
            xuVar = (xu) view.getTag();
        }
        try {
            xuVar.b.setText(zgVar.h());
            this.c.a(zgVar.g(), xuVar.a, Integer.valueOf(R.drawable.default_image_profile));
        } catch (Exception e) {
            e.getMessage();
        }
        return view;
    }
}
