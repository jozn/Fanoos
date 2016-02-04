import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import ir.seraj.fanoos3.R;
import java.util.List;

public class xr extends BaseAdapter {
    List a;
    Context b;
    public aay c;

    public /* synthetic */ Object getItem(int i) {
        return a(i);
    }

    public xr(Context context, List list) {
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
        xs xsVar;
        zg zgVar = (zg) this.a.get(i);
        if (view == null) {
            View view2 = (ViewGroup) ((LayoutInflater) this.b.getSystemService("layout_inflater")).inflate(R.layout.list_item_add_participants, null);
            xs xsVar2 = new xs();
            xsVar2.b = (TextView) view2.findViewById(R.id.addParticipants_item_userName_textView);
            xsVar2.a = (ImageView) view2.findViewById(R.id.addParticipants_item_imageContact_imageView);
            xsVar2.c = (CheckBox) view2.findViewById(R.id.addParticipants_add_CheckBox);
            xsVar2.d = i;
            view2.setTag(xsVar2);
            view = view2;
            xsVar = xsVar2;
        } else {
            xsVar = (xs) view.getTag();
        }
        try {
            xsVar.b.setText(zgVar.h());
            if (zgVar.b().booleanValue()) {
                xsVar.c.setChecked(true);
            } else {
                xsVar.c.setChecked(false);
            }
            this.c.a(zgVar.g(), xsVar.a, Integer.valueOf(R.drawable.default_image_profile));
        } catch (Exception e) {
            e.getMessage();
        }
        return view;
    }
}
