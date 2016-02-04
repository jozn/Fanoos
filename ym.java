import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import ir.seraj.fanoos3.R;
import java.util.List;

public class ym extends BaseAdapter {
    List a;
    Context b;
    String c;
    String d;
    public aay e;

    public /* synthetic */ Object getItem(int i) {
        return a(i);
    }

    public ym(Context context, List list, String str) {
        this.b = context;
        this.a = list;
        this.e = new aay(context, null, Boolean.valueOf(true), Boolean.valueOf(false), zk.c);
        this.c = str;
        this.d = aeq.o(context);
    }

    public void a(List list) {
        this.a = list;
        notifyDataSetChanged();
    }

    public int getCount() {
        if (this.a == null) {
            return 0;
        }
        return this.a.size();
    }

    public yx a(int i) {
        if (this.a == null) {
            return null;
        }
        try {
            return (yx) this.a.get(i);
        } catch (Exception e) {
            return null;
        }
    }

    public long getItemId(int i) {
        if (this.a == null) {
            return -1;
        }
        try {
            yx yxVar = (yx) this.a.get(i);
            return (long) i;
        } catch (Exception e) {
            return -1;
        }
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        yn ynVar;
        yx yxVar = (yx) this.a.get(i);
        if (view == null) {
            View view2 = (ViewGroup) ((LayoutInflater) this.b.getSystemService("layout_inflater")).inflate(R.layout.list_item_participants, null);
            yn ynVar2 = new yn();
            ynVar2.b = (TextView) view2.findViewById(R.id.Participants_item_userName_textView);
            ynVar2.a = (ImageView) view2.findViewById(R.id.Participants_item_imageContact_imageView);
            ynVar2.c = (TextView) view2.findViewById(R.id.Participants_item_adminName_textView);
            ynVar2.d = i;
            view2.setTag(ynVar2);
            view = view2;
            ynVar = ynVar2;
        } else {
            ynVar = (yn) view.getTag();
        }
        try {
            if (yxVar.a().equals(this.c)) {
                ynVar.c.setVisibility(0);
            } else {
                ynVar.c.setVisibility(8);
            }
            if (yxVar.a().equals(this.d)) {
                ynVar.b.setText("\u0634\u0645\u0627");
            } else {
                ynVar.b.setText(yxVar.c());
            }
            this.e.a(yxVar.d(), ynVar.a, Integer.valueOf(R.drawable.default_image_profile));
        } catch (Exception e) {
            e.getMessage();
        }
        return view;
    }
}
