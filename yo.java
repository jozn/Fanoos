import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import ir.seraj.fanoos3.R;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class yo extends BaseAdapter {
    List a;
    Context b;
    public aay c;
    float d;
    private HashMap e;
    private HashMap f;

    public /* synthetic */ Object getItem(int i) {
        return a(i);
    }

    public yo(Context context, List list) {
        this.e = new HashMap();
        this.f = new HashMap();
        this.b = context;
        this.a = list;
        this.d = this.b.getResources().getDisplayMetrics().density;
        this.e.put(Integer.valueOf(1), Integer.valueOf(R.drawable.default_audio_download));
        this.e.put(Integer.valueOf(2), Integer.valueOf(R.drawable.default_audio_play));
        this.c = new aay(context, this.e, Boolean.valueOf(true), Boolean.valueOf(false), zk.c);
        this.f = abe.a();
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

    public zd a(int i) {
        if (this.a == null) {
            return null;
        }
        try {
            return (zd) this.a.get(i);
        } catch (Exception e) {
            return null;
        }
    }

    public long getItemId(int i) {
        if (this.a == null) {
            return -1;
        }
        try {
            zd zdVar = (zd) this.a.get(i);
            return (long) i;
        } catch (Exception e) {
            return -1;
        }
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        yp ypVar;
        zd zdVar = (zd) this.a.get(i);
        if (view == null) {
            View view2 = (ViewGroup) ((LayoutInflater) this.b.getSystemService("layout_inflater")).inflate(R.layout.list_item_current_conversation, null);
            yp ypVar2 = new yp();
            ypVar2.b = (TextView) view2.findViewById(R.id.currentConversation_userName_textView);
            ypVar2.a = (ImageView) view2.findViewById(R.id.currentConversation_item_imageContact_imageView);
            ypVar2.c = (TextView) view2.findViewById(R.id.currentConversation_date_time_textView);
            ypVar2.d = (TextView) view2.findViewById(R.id.currentConversation_last_Message_textView);
            ypVar2.e = (TextView) view2.findViewById(R.id.currentConversation_unread_msg_textView);
            ypVar2.f = (ImageView) view2.findViewById(R.id.currentConversation_last_Message_icon_textView);
            ypVar2.g = (RelativeLayout) view2.findViewById(R.id.currentConversation_item_main_frame);
            ypVar2.h = i;
            view2.setTag(ypVar2);
            view = view2;
            ypVar = ypVar2;
        } else {
            ypVar = (yp) view.getTag();
        }
        try {
            ypVar.b.setText(zdVar.f());
            ypVar.c.setText(yv.a(zdVar.h()));
            if (zdVar.a().equals(String.valueOf(1))) {
                ypVar.d.setText(a(zdVar.i()));
            } else {
                if (zdVar.a().equals(String.valueOf(2))) {
                    ypVar.d.setText("\u0639\u06a9\u0633");
                } else if (zdVar.a().equals(String.valueOf(3))) {
                    ypVar.d.setText("\u0648\u06cc\u062f\u06cc\u0648");
                } else if (zdVar.a().equals(String.valueOf(4))) {
                    ypVar.d.setText("\u0635\u0648\u062a");
                } else if (zdVar.a().equals(String.valueOf(7))) {
                    ypVar.d.setText("\u0634\u06a9\u0644\u06a9");
                }
                ypVar.f.setVisibility(0);
            }
            if (zdVar.b().intValue() > 0) {
                ypVar.g.setBackgroundColor(Color.parseColor("#ffffff"));
                if (zdVar.b().intValue() < 100) {
                    ypVar.e.setText(String.valueOf(zdVar.b()));
                } else {
                    ypVar.e.setText(String.valueOf("+99"));
                }
                ypVar.e.setVisibility(0);
                ypVar.d.setTextColor(Color.parseColor("#308bbd"));
                ypVar.c.setTextColor(Color.parseColor("#308bbd"));
            } else {
                ypVar.g.setBackgroundColor(Color.parseColor("#f6f6f6"));
                ypVar.e.setVisibility(4);
                ypVar.d.setTextColor(Color.parseColor("#707070"));
                ypVar.c.setTextColor(Color.parseColor("#707070"));
            }
            ImageView imageView = ypVar.a;
            if (zdVar.c().equals("1")) {
                if (zdVar.g().lastIndexOf(".") > 0) {
                    this.c.a(zdVar.g().substring(0, zdVar.g().lastIndexOf(".")) + "thumb" + ".jpg", imageView, Integer.valueOf(R.drawable.default_image_group));
                } else {
                    this.c.a(zdVar.g(), imageView, Integer.valueOf(R.drawable.default_image_group));
                }
            } else if (zdVar.g().lastIndexOf(".") > 0) {
                this.c.a(zdVar.g().substring(0, zdVar.g().lastIndexOf(".")) + "thumb" + ".jpg", imageView, Integer.valueOf(R.drawable.default_image_profile));
            } else {
                this.c.a(zdVar.g(), imageView, Integer.valueOf(R.drawable.default_image_profile));
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return view;
    }

    public Spannable a(String str) {
        Spannable spannableStringBuilder = new SpannableStringBuilder(str);
        if (this.f.size() > 0) {
            int i = 0;
            while (i < spannableStringBuilder.length()) {
                if (Character.toString(spannableStringBuilder.charAt(i)).equals("e")) {
                    for (Entry entry : this.f.entrySet()) {
                        int length = ((String) entry.getKey()).length();
                        if (i + length <= spannableStringBuilder.length() && spannableStringBuilder.subSequence(i, i + length).toString().equals(entry.getKey())) {
                            Drawable drawable = this.b.getResources().getDrawable(((Integer) entry.getValue()).intValue());
                            drawable.setBounds(0, 0, ((int) this.d) * 25, ((int) this.d) * 25);
                            spannableStringBuilder.setSpan(new ImageSpan(drawable, 1), i, i + length, 33);
                            i += length - 1;
                            break;
                        }
                    }
                }
                i++;
            }
        }
        return spannableStringBuilder;
    }
}
