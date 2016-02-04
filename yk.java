import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import ir.seraj.fanoos3.R;
import java.util.List;

public class yk extends BaseAdapter {
    List a;
    Context b;
    public aay c;

    public /* synthetic */ Object getItem(int i) {
        return a(i);
    }

    public yk(Context context, List list) {
        this.b = context;
        this.a = list;
        this.c = new aay(context, null, Boolean.valueOf(true), Boolean.valueOf(false), zk.c);
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
        yl ylVar;
        zg zgVar = (zg) this.a.get(i);
        if (view == null) {
            View view2 = (ViewGroup) ((LayoutInflater) this.b.getSystemService("layout_inflater")).inflate(R.layout.list_item_start_new_conversation, null);
            yl ylVar2 = new yl();
            ylVar2.b = (TextView) view2.findViewById(R.id.startNewConversation_userName_textView);
            ylVar2.a = (ImageView) view2.findViewById(R.id.startNewConversation_item_imageContact_imageView);
            ylVar2.c = i;
            view2.setTag(ylVar2);
            view = view2;
            ylVar = ylVar2;
        } else {
            ylVar = (yl) view.getTag();
        }
        try {
            ylVar.b.setText(zgVar.h());
            ImageView imageView = ylVar.a;
            if (zgVar.g().lastIndexOf(".") > 0) {
                this.c.a(zgVar.g().substring(0, zgVar.g().lastIndexOf(".")) + "thumb" + ".jpg", imageView, Integer.valueOf(R.drawable.default_image_profile));
            } else {
                this.c.a(zgVar.g(), imageView, Integer.valueOf(R.drawable.default_image_profile));
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return view;
    }
}
