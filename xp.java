import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import ir.seraj.fanoos3.R;

public class xp extends BaseAdapter {
    Integer[] a;
    Context b;

    public /* synthetic */ Object getItem(int i) {
        return a(i);
    }

    public xp(Context context) {
        this.a = new Integer[]{Integer.valueOf(R.drawable.ic_add_gallery), Integer.valueOf(R.drawable.ic_add_photo), Integer.valueOf(R.drawable.ic_add_video), Integer.valueOf(R.drawable.ic_add_sound), Integer.valueOf(R.drawable.ic_add_record)};
        this.b = context;
    }

    public int getCount() {
        if (this.a == null) {
            return 0;
        }
        return this.a.length;
    }

    public Integer a(int i) {
        Integer num = null;
        if (this.a != null) {
            try {
                num = this.a[i];
            } catch (Exception e) {
            }
        }
        return num;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        xq xqVar;
        Integer num = this.a[i];
        if (view == null) {
            View view2 = (ViewGroup) ((LayoutInflater) this.b.getSystemService("layout_inflater")).inflate(R.layout.list_item_add_media, null);
            xq xqVar2 = new xq();
            xqVar2.a = (ImageView) view2.findViewById(R.id.item_add_media_image_imageView);
            xqVar2.b = i;
            view2.setTag(xqVar2);
            view = view2;
            xqVar = xqVar2;
        } else {
            xqVar = (xq) view.getTag();
        }
        try {
            this.b.getResources();
            xqVar.a.setImageResource(num.intValue());
        } catch (Exception e) {
            e.getMessage();
        }
        return view;
    }
}
