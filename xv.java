import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import ir.seraj.fanoos3.R;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.kxml2.kdom.Node;

public class xv extends BaseAdapter {
    List a;
    Context b;
    Integer c;
    Bitmap d;
    aay e;
    String[] f;
    float g;
    aay h;
    afl i;
    aex j;
    private HashMap k;
    private MediaPlayer l;
    private Map m;

    public /* synthetic */ Object getItem(int i) {
        return a(i);
    }

    public void a(String str, Bitmap bitmap) {
        try {
            this.m.put(str, bitmap);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public xv(Context context, List list) {
        this.c = Integer.valueOf(-1);
        this.k = new HashMap();
        this.m = Collections.synchronizedMap(new LinkedHashMap(10, 1.5f, true));
        this.b = context;
        this.a = list;
        this.h = new aay(context, null, Boolean.valueOf(true), Boolean.valueOf(true), zk.c);
        this.e = new aay(context, null, Boolean.valueOf(false), Boolean.valueOf(false), zk.b);
        this.f = context.getResources().getStringArray(R.array.sticky_array);
        this.l = new MediaPlayer();
        this.g = this.b.getResources().getDisplayMetrics().density;
        this.k = abe.a();
        this.j = new xz(this);
        this.d = zq.a(zk.a + File.separator + "myProfileImage.jpg", this.b);
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

    public zc a(int i) {
        if (this.a == null) {
            return null;
        }
        try {
            return (zc) this.a.get(i);
        } catch (Exception e) {
            return null;
        }
    }

    public long getItemId(int i) {
        if (this.a == null) {
            return -1;
        }
        try {
            return ((zc) this.a.get(i)).g().longValue();
        } catch (Exception e) {
            return -1;
        }
    }

    public int getViewTypeCount() {
        return 11;
    }

    public int getItemViewType(int i) {
        if (((zc) this.a.get(i)).k().startsWith(zh.e + zh.d)) {
            return 8;
        }
        Long valueOf;
        int intValue = Integer.valueOf(((zc) this.a.get(i)).e()).intValue();
        if (((zc) this.a.get(i)).h().equals("-2")) {
            valueOf = Long.valueOf(0);
        } else {
            valueOf = ((zc) this.a.get(i)).j();
        }
        if (valueOf.longValue() != 0) {
            switch (intValue) {
                case ve.CropImageView_fixAspectRatio /*1*/:
                    return 4;
                case ve.CropImageView_aspectRatioX /*2*/:
                    return 5;
                case ve.CropImageView_aspectRatioY /*3*/:
                    return 6;
                case ve.CropImageView_imageResource /*4*/:
                    return 7;
                case Node.IGNORABLE_WHITESPACE /*7*/:
                    return 10;
                default:
                    break;
            }
        }
        switch (intValue) {
            case ve.CropImageView_fixAspectRatio /*1*/:
                return 0;
            case ve.CropImageView_aspectRatioX /*2*/:
                return 1;
            case ve.CropImageView_aspectRatioY /*3*/:
                return 2;
            case ve.CropImageView_imageResource /*4*/:
                return 3;
            case Node.IGNORABLE_WHITESPACE /*7*/:
                return 9;
        }
        return 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View getView(int r12, android.view.View r13, android.view.ViewGroup r14) {
        /*
        r11 = this;
        r4 = 0;
        r3 = 8;
        r10 = 1;
        r0 = "getView";
        r1 = "a";
        android.util.Log.i(r0, r1);
        r0 = r11.a;
        r0 = r0.get(r12);
        r7 = r0;
        r7 = (zc) r7;
        r2 = r11.getItemViewType(r12);
        if (r13 != 0) goto L_0x031c;
    L_0x001a:
        r0 = "getView";
        r1 = "b";
        android.util.Log.i(r0, r1);
        r0 = r11.b;
        r1 = "layout_inflater";
        r0 = r0.getSystemService(r1);
        r0 = (android.view.LayoutInflater) r0;
        switch(r2) {
            case 0: goto L_0x006d;
            case 1: goto L_0x0078;
            case 2: goto L_0x0083;
            case 3: goto L_0x008e;
            case 4: goto L_0x0099;
            case 5: goto L_0x00a4;
            case 6: goto L_0x00af;
            case 7: goto L_0x00bb;
            case 8: goto L_0x00c7;
            case 9: goto L_0x00d3;
            case 10: goto L_0x00df;
            default: goto L_0x002e;
        };
    L_0x002e:
        r1 = new yh;
        r1.<init>();
        if (r2 == r3) goto L_0x0056;
    L_0x0035:
        r0 = 2131362020; // 0x7f0a00e4 float:1.8343809E38 double:1.053032753E-314;
        r0 = r13.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r1.d = r0;
        r0 = 2131362019; // 0x7f0a00e3 float:1.8343807E38 double:1.0530327524E-314;
        r0 = r13.findViewById(r0);
        r0 = (android.widget.ImageView) r0;
        r1.a = r0;
        r0 = 2131362013; // 0x7f0a00dd float:1.8343795E38 double:1.0530327495E-314;
        r0 = r13.findViewById(r0);
        r0 = (android.widget.ImageView) r0;
        r1.h = r0;
    L_0x0056:
        switch(r2) {
            case 0: goto L_0x00eb;
            case 1: goto L_0x010e;
            case 2: goto L_0x0147;
            case 3: goto L_0x018b;
            case 4: goto L_0x01da;
            case 5: goto L_0x01fd;
            case 6: goto L_0x024c;
            case 7: goto L_0x029b;
            case 8: goto L_0x02ea;
            case 9: goto L_0x02f7;
            case 10: goto L_0x0304;
            default: goto L_0x0059;
        };
    L_0x0059:
        r1.q = r12;
        r13.setTag(r1);
        r9 = r1;
        r8 = r13;
    L_0x0060:
        if (r2 != r3) goto L_0x0326;
    L_0x0062:
        r0 = r9.g;	 Catch:{ Exception -> 0x03e9 }
        r1 = r7.d();	 Catch:{ Exception -> 0x03e9 }
        r0.setText(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r8;
    L_0x006c:
        return r0;
    L_0x006d:
        r1 = 2130903108; // 0x7f030044 float:1.7413025E38 double:1.0528060203E-314;
        r0 = r0.inflate(r1, r4);
        r0 = (android.view.ViewGroup) r0;
        r13 = r0;
        goto L_0x002e;
    L_0x0078:
        r1 = 2130903106; // 0x7f030042 float:1.741302E38 double:1.0528060193E-314;
        r0 = r0.inflate(r1, r4);
        r0 = (android.view.ViewGroup) r0;
        r13 = r0;
        goto L_0x002e;
    L_0x0083:
        r1 = 2130903112; // 0x7f030048 float:1.7413033E38 double:1.0528060223E-314;
        r0 = r0.inflate(r1, r4);
        r0 = (android.view.ViewGroup) r0;
        r13 = r0;
        goto L_0x002e;
    L_0x008e:
        r1 = 2130903104; // 0x7f030040 float:1.7413017E38 double:1.0528060183E-314;
        r0 = r0.inflate(r1, r4);
        r0 = (android.view.ViewGroup) r0;
        r13 = r0;
        goto L_0x002e;
    L_0x0099:
        r1 = 2130903107; // 0x7f030043 float:1.7413023E38 double:1.05280602E-314;
        r0 = r0.inflate(r1, r4);
        r0 = (android.view.ViewGroup) r0;
        r13 = r0;
        goto L_0x002e;
    L_0x00a4:
        r1 = 2130903105; // 0x7f030041 float:1.7413019E38 double:1.052806019E-314;
        r0 = r0.inflate(r1, r4);
        r0 = (android.view.ViewGroup) r0;
        r13 = r0;
        goto L_0x002e;
    L_0x00af:
        r1 = 2130903111; // 0x7f030047 float:1.741303E38 double:1.052806022E-314;
        r0 = r0.inflate(r1, r4);
        r0 = (android.view.ViewGroup) r0;
        r13 = r0;
        goto L_0x002e;
    L_0x00bb:
        r1 = 2130903103; // 0x7f03003f float:1.7413015E38 double:1.052806018E-314;
        r0 = r0.inflate(r1, r4);
        r0 = (android.view.ViewGroup) r0;
        r13 = r0;
        goto L_0x002e;
    L_0x00c7:
        r1 = 2130903115; // 0x7f03004b float:1.7413039E38 double:1.0528060237E-314;
        r0 = r0.inflate(r1, r4);
        r0 = (android.view.ViewGroup) r0;
        r13 = r0;
        goto L_0x002e;
    L_0x00d3:
        r1 = 2130903110; // 0x7f030046 float:1.7413029E38 double:1.0528060213E-314;
        r0 = r0.inflate(r1, r4);
        r0 = (android.view.ViewGroup) r0;
        r13 = r0;
        goto L_0x002e;
    L_0x00df:
        r1 = 2130903109; // 0x7f030045 float:1.7413027E38 double:1.052806021E-314;
        r0 = r0.inflate(r1, r4);
        r0 = (android.view.ViewGroup) r0;
        r13 = r0;
        goto L_0x002e;
    L_0x00eb:
        r0 = 2131362028; // 0x7f0a00ec float:1.8343825E38 double:1.053032757E-314;
        r0 = r13.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r1.g = r0;
        r0 = 2131362030; // 0x7f0a00ee float:1.834383E38 double:1.053032758E-314;
        r0 = r13.findViewById(r0);
        r0 = (android.widget.LinearLayout) r0;
        r1.l = r0;
        r0 = 2131362023; // 0x7f0a00e7 float:1.8343815E38 double:1.0530327544E-314;
        r0 = r13.findViewById(r0);
        r0 = (android.widget.RelativeLayout) r0;
        r1.n = r0;
        goto L_0x0059;
    L_0x010e:
        r0 = 2131362025; // 0x7f0a00e9 float:1.8343819E38 double:1.0530327554E-314;
        r0 = r13.findViewById(r0);
        r0 = (android.widget.ImageView) r0;
        r1.b = r0;
        r0 = 2131362017; // 0x7f0a00e1 float:1.8343803E38 double:1.0530327515E-314;
        r0 = r13.findViewById(r0);
        r0 = (android.widget.ProgressBar) r0;
        r1.c = r0;
        r0 = 2131362024; // 0x7f0a00e8 float:1.8343817E38 double:1.053032755E-314;
        r0 = r13.findViewById(r0);
        r0 = (android.widget.ImageView) r0;
        r1.f = r0;
        r0 = 2131362021; // 0x7f0a00e5 float:1.834381E38 double:1.0530327534E-314;
        r0 = r13.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r1.j = r0;
        r0 = 2131362012; // 0x7f0a00dc float:1.8343793E38 double:1.053032749E-314;
        r0 = r13.findViewById(r0);
        r0 = (android.widget.RelativeLayout) r0;
        r1.m = r0;
        goto L_0x0059;
    L_0x0147:
        r0 = 2131362025; // 0x7f0a00e9 float:1.8343819E38 double:1.0530327554E-314;
        r0 = r13.findViewById(r0);
        r0 = (android.widget.ImageView) r0;
        r1.b = r0;
        r0 = 2131362031; // 0x7f0a00ef float:1.8343831E38 double:1.0530327584E-314;
        r0 = r13.findViewById(r0);
        r0 = (android.widget.ImageView) r0;
        r1.e = r0;
        r0 = 2131362017; // 0x7f0a00e1 float:1.8343803E38 double:1.0530327515E-314;
        r0 = r13.findViewById(r0);
        r0 = (android.widget.ProgressBar) r0;
        r1.c = r0;
        r0 = 2131362024; // 0x7f0a00e8 float:1.8343817E38 double:1.053032755E-314;
        r0 = r13.findViewById(r0);
        r0 = (android.widget.ImageView) r0;
        r1.f = r0;
        r0 = 2131362021; // 0x7f0a00e5 float:1.834381E38 double:1.0530327534E-314;
        r0 = r13.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r1.j = r0;
        r0 = 2131362012; // 0x7f0a00dc float:1.8343793E38 double:1.053032749E-314;
        r0 = r13.findViewById(r0);
        r0 = (android.widget.RelativeLayout) r0;
        r1.m = r0;
        goto L_0x0059;
    L_0x018b:
        r0 = 2131362016; // 0x7f0a00e0 float:1.83438E38 double:1.053032751E-314;
        r0 = r13.findViewById(r0);
        r0 = (android.widget.ImageView) r0;
        r1.e = r0;
        r0 = 2131362017; // 0x7f0a00e1 float:1.8343803E38 double:1.0530327515E-314;
        r0 = r13.findViewById(r0);
        r0 = (android.widget.ProgressBar) r0;
        r1.c = r0;
        r0 = 2131362024; // 0x7f0a00e8 float:1.8343817E38 double:1.053032755E-314;
        r0 = r13.findViewById(r0);
        r0 = (android.widget.ImageView) r0;
        r1.f = r0;
        r0 = 2131362021; // 0x7f0a00e5 float:1.834381E38 double:1.0530327534E-314;
        r0 = r13.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r1.j = r0;
        r0 = 2131362012; // 0x7f0a00dc float:1.8343793E38 double:1.053032749E-314;
        r0 = r13.findViewById(r0);
        r0 = (android.widget.RelativeLayout) r0;
        r1.m = r0;
        r0 = 2131362018; // 0x7f0a00e2 float:1.8343805E38 double:1.053032752E-314;
        r0 = r13.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r1.o = r0;
        r0 = 2131362023; // 0x7f0a00e7 float:1.8343815E38 double:1.0530327544E-314;
        r0 = r13.findViewById(r0);
        r0 = (android.widget.RelativeLayout) r0;
        r1.n = r0;
        goto L_0x0059;
    L_0x01da:
        r0 = 2131362028; // 0x7f0a00ec float:1.8343825E38 double:1.053032757E-314;
        r0 = r13.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r1.g = r0;
        r0 = 2131362014; // 0x7f0a00de float:1.8343797E38 double:1.05303275E-314;
        r0 = r13.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r1.i = r0;
        r0 = 2131362027; // 0x7f0a00eb float:1.8343823E38 double:1.0530327564E-314;
        r0 = r13.findViewById(r0);
        r0 = (android.widget.LinearLayout) r0;
        r1.l = r0;
        goto L_0x0059;
    L_0x01fd:
        r0 = 2131362025; // 0x7f0a00e9 float:1.8343819E38 double:1.0530327554E-314;
        r0 = r13.findViewById(r0);
        r0 = (android.widget.ImageView) r0;
        r1.b = r0;
        r0 = 2131362017; // 0x7f0a00e1 float:1.8343803E38 double:1.0530327515E-314;
        r0 = r13.findViewById(r0);
        r0 = (android.widget.ProgressBar) r0;
        r1.c = r0;
        r0 = 2131362014; // 0x7f0a00de float:1.8343797E38 double:1.05303275E-314;
        r0 = r13.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r1.i = r0;
        r0 = 2131362021; // 0x7f0a00e5 float:1.834381E38 double:1.0530327534E-314;
        r0 = r13.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r1.j = r0;
        r0 = 2131362022; // 0x7f0a00e6 float:1.8343813E38 double:1.053032754E-314;
        r0 = r13.findViewById(r0);
        r0 = (android.widget.ProgressBar) r0;
        r1.k = r0;
        r0 = 2131362012; // 0x7f0a00dc float:1.8343793E38 double:1.053032749E-314;
        r0 = r13.findViewById(r0);
        r0 = (android.widget.RelativeLayout) r0;
        r1.m = r0;
        r0 = 2131362026; // 0x7f0a00ea float:1.834382E38 double:1.053032756E-314;
        r0 = r13.findViewById(r0);
        r0 = (android.widget.ImageView) r0;
        r1.p = r0;
        goto L_0x0059;
    L_0x024c:
        r0 = 2131362025; // 0x7f0a00e9 float:1.8343819E38 double:1.0530327554E-314;
        r0 = r13.findViewById(r0);
        r0 = (android.widget.ImageView) r0;
        r1.b = r0;
        r0 = 2131362031; // 0x7f0a00ef float:1.8343831E38 double:1.0530327584E-314;
        r0 = r13.findViewById(r0);
        r0 = (android.widget.ImageView) r0;
        r1.e = r0;
        r0 = 2131362017; // 0x7f0a00e1 float:1.8343803E38 double:1.0530327515E-314;
        r0 = r13.findViewById(r0);
        r0 = (android.widget.ProgressBar) r0;
        r1.c = r0;
        r0 = 2131362014; // 0x7f0a00de float:1.8343797E38 double:1.05303275E-314;
        r0 = r13.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r1.i = r0;
        r0 = 2131362021; // 0x7f0a00e5 float:1.834381E38 double:1.0530327534E-314;
        r0 = r13.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r1.j = r0;
        r0 = 2131362022; // 0x7f0a00e6 float:1.8343813E38 double:1.053032754E-314;
        r0 = r13.findViewById(r0);
        r0 = (android.widget.ProgressBar) r0;
        r1.k = r0;
        r0 = 2131362012; // 0x7f0a00dc float:1.8343793E38 double:1.053032749E-314;
        r0 = r13.findViewById(r0);
        r0 = (android.widget.RelativeLayout) r0;
        r1.m = r0;
        goto L_0x0059;
    L_0x029b:
        r0 = 2131362016; // 0x7f0a00e0 float:1.83438E38 double:1.053032751E-314;
        r0 = r13.findViewById(r0);
        r0 = (android.widget.ImageView) r0;
        r1.e = r0;
        r0 = 2131362017; // 0x7f0a00e1 float:1.8343803E38 double:1.0530327515E-314;
        r0 = r13.findViewById(r0);
        r0 = (android.widget.ProgressBar) r0;
        r1.c = r0;
        r0 = 2131362014; // 0x7f0a00de float:1.8343797E38 double:1.05303275E-314;
        r0 = r13.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r1.i = r0;
        r0 = 2131362021; // 0x7f0a00e5 float:1.834381E38 double:1.0530327534E-314;
        r0 = r13.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r1.j = r0;
        r0 = 2131362022; // 0x7f0a00e6 float:1.8343813E38 double:1.053032754E-314;
        r0 = r13.findViewById(r0);
        r0 = (android.widget.ProgressBar) r0;
        r1.k = r0;
        r0 = 2131362018; // 0x7f0a00e2 float:1.8343805E38 double:1.053032752E-314;
        r0 = r13.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r1.o = r0;
        r0 = 2131362012; // 0x7f0a00dc float:1.8343793E38 double:1.053032749E-314;
        r0 = r13.findViewById(r0);
        r0 = (android.widget.RelativeLayout) r0;
        r1.m = r0;
        goto L_0x0059;
    L_0x02ea:
        r0 = 2131362041; // 0x7f0a00f9 float:1.8343851E38 double:1.0530327633E-314;
        r0 = r13.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r1.g = r0;
        goto L_0x0059;
    L_0x02f7:
        r0 = 2131362025; // 0x7f0a00e9 float:1.8343819E38 double:1.0530327554E-314;
        r0 = r13.findViewById(r0);
        r0 = (android.widget.ImageView) r0;
        r1.b = r0;
        goto L_0x0059;
    L_0x0304:
        r0 = 2131362025; // 0x7f0a00e9 float:1.8343819E38 double:1.0530327554E-314;
        r0 = r13.findViewById(r0);
        r0 = (android.widget.ImageView) r0;
        r1.b = r0;
        r0 = 2131362014; // 0x7f0a00de float:1.8343797E38 double:1.05303275E-314;
        r0 = r13.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r1.i = r0;
        goto L_0x0059;
    L_0x031c:
        r0 = r13.getTag();
        r0 = (yh) r0;
        r9 = r0;
        r8 = r13;
        goto L_0x0060;
    L_0x0326:
        if (r2 == 0) goto L_0x0334;
    L_0x0328:
        if (r2 == r10) goto L_0x0334;
    L_0x032a:
        r0 = 2;
        if (r2 == r0) goto L_0x0334;
    L_0x032d:
        r0 = 3;
        if (r2 == r0) goto L_0x0334;
    L_0x0330:
        r0 = 9;
        if (r2 != r0) goto L_0x0427;
    L_0x0334:
        if (r2 == r10) goto L_0x033c;
    L_0x0336:
        r0 = 2;
        if (r2 == r0) goto L_0x033c;
    L_0x0339:
        r0 = 3;
        if (r2 != r0) goto L_0x0342;
    L_0x033c:
        r0 = r9.j;	 Catch:{ Exception -> 0x03e9 }
        r1 = 4;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x03e9 }
    L_0x0342:
        r0 = r7.m();	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x03e9 }
        if (r0 != r10) goto L_0x03ce;
    L_0x034c:
        r0 = r9.a;	 Catch:{ Exception -> 0x03e9 }
        r1 = 2130837740; // 0x7f0200ec float:1.7280443E38 double:1.052773724E-314;
        r0.setImageResource(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.a;	 Catch:{ Exception -> 0x03e9 }
        r1 = 0;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x03e9 }
    L_0x035a:
        r0 = r9.d;	 Catch:{ Exception -> 0x03e9 }
        r1 = r7.l();	 Catch:{ Exception -> 0x03e9 }
        r1 = zn.a(r1);	 Catch:{ Exception -> 0x03e9 }
        r0.setText(r1);	 Catch:{ Exception -> 0x03e9 }
        if (r2 == 0) goto L_0x0375;
    L_0x0369:
        if (r2 == r10) goto L_0x0375;
    L_0x036b:
        r0 = 2;
        if (r2 == r0) goto L_0x0375;
    L_0x036e:
        r0 = 3;
        if (r2 == r0) goto L_0x0375;
    L_0x0371:
        r0 = 9;
        if (r2 != r0) goto L_0x0430;
    L_0x0375:
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = new yb;	 Catch:{ Exception -> 0x03e9 }
        r1.<init>(r11);	 Catch:{ Exception -> 0x03e9 }
        r0.setOnClickListener(r1);	 Catch:{ Exception -> 0x03e9 }
    L_0x037f:
        r0 = "Imagetest";
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x03e9 }
        r1.<init>();	 Catch:{ Exception -> 0x03e9 }
        r3 = "main";
        r1 = r1.append(r3);	 Catch:{ Exception -> 0x03e9 }
        r3 = r7.a();	 Catch:{ Exception -> 0x03e9 }
        r1 = r1.append(r3);	 Catch:{ Exception -> 0x03e9 }
        r3 = " ";
        r1 = r1.append(r3);	 Catch:{ Exception -> 0x03e9 }
        r1 = r1.append(r12);	 Catch:{ Exception -> 0x03e9 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x03e9 }
        android.util.Log.i(r0, r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r7.a();	 Catch:{ Exception -> 0x03e9 }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Exception -> 0x03e9 }
        if (r0 != 0) goto L_0x04fa;
    L_0x03af:
        if (r2 == 0) goto L_0x03bd;
    L_0x03b1:
        if (r2 == r10) goto L_0x03bd;
    L_0x03b3:
        r0 = 2;
        if (r2 == r0) goto L_0x03bd;
    L_0x03b6:
        r0 = 3;
        if (r2 == r0) goto L_0x03bd;
    L_0x03b9:
        r0 = 9;
        if (r2 != r0) goto L_0x0445;
    L_0x03bd:
        r0 = r11.d;	 Catch:{ Exception -> 0x03e9 }
        if (r0 == 0) goto L_0x043c;
    L_0x03c1:
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = r11.d;	 Catch:{ Exception -> 0x03e9 }
        r11.a(r0, r1);	 Catch:{ Exception -> 0x03e9 }
    L_0x03c8:
        switch(r2) {
            case 0: goto L_0x0529;
            case 1: goto L_0x0608;
            case 2: goto L_0x07fa;
            case 3: goto L_0x0937;
            case 4: goto L_0x0a5f;
            case 5: goto L_0x0b6d;
            case 6: goto L_0x0dba;
            case 7: goto L_0x0f06;
            case 8: goto L_0x03cb;
            case 9: goto L_0x074a;
            case 10: goto L_0x0cf7;
            default: goto L_0x03cb;
        };	 Catch:{ Exception -> 0x03e9 }
    L_0x03cb:
        r0 = r8;
        goto L_0x006c;
    L_0x03ce:
        r0 = r7.m();	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x03e9 }
        r1 = 2;
        if (r0 != r1) goto L_0x03f7;
    L_0x03d9:
        r0 = r9.a;	 Catch:{ Exception -> 0x03e9 }
        r1 = 2130837741; // 0x7f0200ed float:1.7280445E38 double:1.0527737247E-314;
        r0.setImageResource(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.a;	 Catch:{ Exception -> 0x03e9 }
        r1 = 0;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x035a;
    L_0x03e9:
        r0 = move-exception;
        r0.getMessage();
        r1 = "ConversationAdaptor";
        r0 = r0.getMessage();
        android.util.Log.i(r1, r0);
        goto L_0x03cb;
    L_0x03f7:
        r0 = r7.n();	 Catch:{ Exception -> 0x03e9 }
        r1 = ze.d;	 Catch:{ Exception -> 0x03e9 }
        if (r0 != r1) goto L_0x0419;
    L_0x03ff:
        r0 = r9.f;	 Catch:{ Exception -> 0x03e9 }
        r1 = 0;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.f;	 Catch:{ Exception -> 0x03e9 }
        r1 = new ya;	 Catch:{ Exception -> 0x03e9 }
        r1.<init>(r11, r7, r9);	 Catch:{ Exception -> 0x03e9 }
        r0.setOnClickListener(r1);	 Catch:{ Exception -> 0x03e9 }
    L_0x040f:
        r0 = r9.a;	 Catch:{ Exception -> 0x03e9 }
        r1 = 2130837743; // 0x7f0200ef float:1.7280449E38 double:1.0527737257E-314;
        r0.setImageResource(r1);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x035a;
    L_0x0419:
        if (r2 == 0) goto L_0x040f;
    L_0x041b:
        r0 = 9;
        if (r2 == r0) goto L_0x040f;
    L_0x041f:
        r0 = r9.f;	 Catch:{ Exception -> 0x03e9 }
        r1 = 8;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x040f;
    L_0x0427:
        r0 = r9.a;	 Catch:{ Exception -> 0x03e9 }
        r1 = 8;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x035a;
    L_0x0430:
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = new yc;	 Catch:{ Exception -> 0x03e9 }
        r1.<init>(r11, r7);	 Catch:{ Exception -> 0x03e9 }
        r0.setOnClickListener(r1);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x037f;
    L_0x043c:
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = 2130837594; // 0x7f02005a float:1.7280146E38 double:1.052773652E-314;
        r11.a(r0, r1);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x03c8;
    L_0x0445:
        r0 = r7.a();	 Catch:{ Exception -> 0x03e9 }
        r1 = ".";
        r0 = r0.lastIndexOf(r1);	 Catch:{ Exception -> 0x03e9 }
        if (r0 <= 0) goto L_0x04ad;
    L_0x0451:
        r0 = r11.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x03e9 }
        r1.<init>();	 Catch:{ Exception -> 0x03e9 }
        r3 = r7.a();	 Catch:{ Exception -> 0x03e9 }
        r4 = 0;
        r5 = r7.a();	 Catch:{ Exception -> 0x03e9 }
        r6 = ".";
        r5 = r5.lastIndexOf(r6);	 Catch:{ Exception -> 0x03e9 }
        r3 = r3.substring(r4, r5);	 Catch:{ Exception -> 0x03e9 }
        r1 = r1.append(r3);	 Catch:{ Exception -> 0x03e9 }
        r3 = "thumb";
        r1 = r1.append(r3);	 Catch:{ Exception -> 0x03e9 }
        r3 = ".jpg";
        r1 = r1.append(r3);	 Catch:{ Exception -> 0x03e9 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x03e9 }
        r3 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r4 = 2130837594; // 0x7f02005a float:1.7280146E38 double:1.052773652E-314;
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x03e9 }
        r0.a(r1, r3, r4);	 Catch:{ Exception -> 0x03e9 }
        r0 = "Imagetest";
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x03e9 }
        r1.<init>();	 Catch:{ Exception -> 0x03e9 }
        r3 = r7.a();	 Catch:{ Exception -> 0x03e9 }
        r1 = r1.append(r3);	 Catch:{ Exception -> 0x03e9 }
        r3 = " ";
        r1 = r1.append(r3);	 Catch:{ Exception -> 0x03e9 }
        r1 = r1.append(r12);	 Catch:{ Exception -> 0x03e9 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x03e9 }
        android.util.Log.i(r0, r1);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x03c8;
    L_0x04ad:
        r0 = r11.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x03e9 }
        r1.<init>();	 Catch:{ Exception -> 0x03e9 }
        r3 = r7.a();	 Catch:{ Exception -> 0x03e9 }
        r1 = r1.append(r3);	 Catch:{ Exception -> 0x03e9 }
        r3 = ".jpg";
        r1 = r1.append(r3);	 Catch:{ Exception -> 0x03e9 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x03e9 }
        r3 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r4 = 2130837594; // 0x7f02005a float:1.7280146E38 double:1.052773652E-314;
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x03e9 }
        r0.a(r1, r3, r4);	 Catch:{ Exception -> 0x03e9 }
        r0 = "Imagetest";
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x03e9 }
        r1.<init>();	 Catch:{ Exception -> 0x03e9 }
        r3 = " else ";
        r1 = r1.append(r3);	 Catch:{ Exception -> 0x03e9 }
        r3 = r7.a();	 Catch:{ Exception -> 0x03e9 }
        r1 = r1.append(r3);	 Catch:{ Exception -> 0x03e9 }
        r3 = " ";
        r1 = r1.append(r3);	 Catch:{ Exception -> 0x03e9 }
        r1 = r1.append(r12);	 Catch:{ Exception -> 0x03e9 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x03e9 }
        android.util.Log.i(r0, r1);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x03c8;
    L_0x04fa:
        if (r2 == 0) goto L_0x0508;
    L_0x04fc:
        if (r2 == r10) goto L_0x0508;
    L_0x04fe:
        r0 = 2;
        if (r2 == r0) goto L_0x0508;
    L_0x0501:
        r0 = 3;
        if (r2 == r0) goto L_0x0508;
    L_0x0504:
        r0 = 9;
        if (r2 != r0) goto L_0x051f;
    L_0x0508:
        r0 = r11.d;	 Catch:{ Exception -> 0x03e9 }
        if (r0 == 0) goto L_0x0515;
    L_0x050c:
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = r11.d;	 Catch:{ Exception -> 0x03e9 }
        r11.a(r0, r1);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x03c8;
    L_0x0515:
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = 2130837594; // 0x7f02005a float:1.7280146E38 double:1.052773652E-314;
        r11.a(r0, r1);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x03c8;
    L_0x051f:
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = 2130837594; // 0x7f02005a float:1.7280146E38 double:1.052773652E-314;
        r11.a(r0, r1);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x03c8;
    L_0x0529:
        r0 = r9.g;	 Catch:{ Exception -> 0x03e9 }
        r1 = r7.d();	 Catch:{ Exception -> 0x03e9 }
        r1 = r11.a(r1);	 Catch:{ Exception -> 0x03e9 }
        r0.setText(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r7.i();	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x03e9 }
        if (r0 != r10) goto L_0x05a4;
    L_0x0540:
        if (r12 <= 0) goto L_0x0588;
    L_0x0542:
        r0 = r11.a;	 Catch:{ Exception -> 0x03e9 }
        r1 = r12 + -1;
        r0 = r0.get(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = (zc) r0;	 Catch:{ Exception -> 0x03e9 }
        r1 = r0.h();	 Catch:{ Exception -> 0x03e9 }
        r0 = r11.a;	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.get(r12);	 Catch:{ Exception -> 0x03e9 }
        r0 = (zc) r0;	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.h();	 Catch:{ Exception -> 0x03e9 }
        r0 = r1.equals(r0);	 Catch:{ Exception -> 0x03e9 }
        if (r0 == 0) goto L_0x0588;
    L_0x0562:
        r0 = yz.b(r7);	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.booleanValue();	 Catch:{ Exception -> 0x03e9 }
        if (r0 != 0) goto L_0x0588;
    L_0x056c:
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = 4;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.l;	 Catch:{ Exception -> 0x03e9 }
        r1 = 2130837571; // 0x7f020043 float:1.72801E38 double:1.0527736407E-314;
        r0.setBackgroundResource(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = r9.l;	 Catch:{ Exception -> 0x03e9 }
        r2 = 1;
        r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x03e9 }
        r11.a(r0, r1, r2);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x03cb;
    L_0x0588:
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = 0;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.l;	 Catch:{ Exception -> 0x03e9 }
        r1 = 2130837572; // 0x7f020044 float:1.7280102E38 double:1.052773641E-314;
        r0.setBackgroundResource(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = r9.l;	 Catch:{ Exception -> 0x03e9 }
        r2 = 1;
        r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x03e9 }
        r11.b(r0, r1, r2);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x03cb;
    L_0x05a4:
        if (r12 <= 0) goto L_0x05ec;
    L_0x05a6:
        r0 = r11.a;	 Catch:{ Exception -> 0x03e9 }
        r1 = r12 + -1;
        r0 = r0.get(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = (zc) r0;	 Catch:{ Exception -> 0x03e9 }
        r1 = r0.j();	 Catch:{ Exception -> 0x03e9 }
        r0 = r11.a;	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.get(r12);	 Catch:{ Exception -> 0x03e9 }
        r0 = (zc) r0;	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.j();	 Catch:{ Exception -> 0x03e9 }
        r0 = r1.equals(r0);	 Catch:{ Exception -> 0x03e9 }
        if (r0 == 0) goto L_0x05ec;
    L_0x05c6:
        r0 = yz.b(r7);	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.booleanValue();	 Catch:{ Exception -> 0x03e9 }
        if (r0 != 0) goto L_0x05ec;
    L_0x05d0:
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = 4;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = r9.l;	 Catch:{ Exception -> 0x03e9 }
        r2 = 1;
        r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x03e9 }
        r11.a(r0, r1, r2);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.l;	 Catch:{ Exception -> 0x03e9 }
        r1 = 2130837571; // 0x7f020043 float:1.72801E38 double:1.0527736407E-314;
        r0.setBackgroundResource(r1);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x03cb;
    L_0x05ec:
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = 0;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.l;	 Catch:{ Exception -> 0x03e9 }
        r1 = 2130837572; // 0x7f020044 float:1.7280102E38 double:1.052773641E-314;
        r0.setBackgroundResource(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = r9.l;	 Catch:{ Exception -> 0x03e9 }
        r2 = 1;
        r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x03e9 }
        r11.b(r0, r1, r2);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x03cb;
    L_0x0608:
        r0 = r9.j;	 Catch:{ Exception -> 0x03e9 }
        r1 = r7.f();	 Catch:{ Exception -> 0x03e9 }
        r1 = yt.a(r1);	 Catch:{ Exception -> 0x03e9 }
        r0.setText(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = new aew;	 Catch:{ Exception -> 0x03e9 }
        r1 = r11.j;	 Catch:{ Exception -> 0x03e9 }
        r2 = r9.b;	 Catch:{ Exception -> 0x03e9 }
        r3 = 2130837592; // 0x7f020058 float:1.7280142E38 double:1.052773651E-314;
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ Exception -> 0x03e9 }
        r4 = 0;
        r4 = java.lang.Boolean.valueOf(r4);	 Catch:{ Exception -> 0x03e9 }
        r5 = zk.a;	 Catch:{ Exception -> 0x03e9 }
        r6 = r11.b;	 Catch:{ Exception -> 0x03e9 }
        r0.<init>(r1, r2, r3, r4, r5, r6);	 Catch:{ Exception -> 0x03e9 }
        r1 = 1;
        r1 = new java.lang.String[r1];	 Catch:{ Exception -> 0x03e9 }
        r2 = 0;
        r3 = r7.d();	 Catch:{ Exception -> 0x03e9 }
        r1[r2] = r3;	 Catch:{ Exception -> 0x03e9 }
        r0.execute(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.b;	 Catch:{ Exception -> 0x03e9 }
        r1 = new yd;	 Catch:{ Exception -> 0x03e9 }
        r1.<init>(r11, r7);	 Catch:{ Exception -> 0x03e9 }
        r0.setOnClickListener(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r7.m();	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x03e9 }
        if (r0 == r10) goto L_0x0657;
    L_0x064f:
        r0 = r7.n();	 Catch:{ Exception -> 0x03e9 }
        r1 = ze.d;	 Catch:{ Exception -> 0x03e9 }
        if (r0 != r1) goto L_0x06b0;
    L_0x0657:
        r0 = r9.c;	 Catch:{ Exception -> 0x03e9 }
        r1 = 8;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x03e9 }
    L_0x065e:
        r0 = r7.i();	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x03e9 }
        if (r0 != r10) goto L_0x06e6;
    L_0x0668:
        if (r12 <= 0) goto L_0x06ca;
    L_0x066a:
        r0 = r11.a;	 Catch:{ Exception -> 0x03e9 }
        r1 = r12 + -1;
        r0 = r0.get(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = (zc) r0;	 Catch:{ Exception -> 0x03e9 }
        r1 = r0.h();	 Catch:{ Exception -> 0x03e9 }
        r0 = r11.a;	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.get(r12);	 Catch:{ Exception -> 0x03e9 }
        r0 = (zc) r0;	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.h();	 Catch:{ Exception -> 0x03e9 }
        r0 = r1.equals(r0);	 Catch:{ Exception -> 0x03e9 }
        if (r0 == 0) goto L_0x06ca;
    L_0x068a:
        r0 = yz.b(r7);	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.booleanValue();	 Catch:{ Exception -> 0x03e9 }
        if (r0 != 0) goto L_0x06ca;
    L_0x0694:
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = 4;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.m;	 Catch:{ Exception -> 0x03e9 }
        r1 = 2130837571; // 0x7f020043 float:1.72801E38 double:1.0527736407E-314;
        r0.setBackgroundResource(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = r9.m;	 Catch:{ Exception -> 0x03e9 }
        r2 = 1;
        r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x03e9 }
        r11.a(r0, r1, r2);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x03cb;
    L_0x06b0:
        r0 = r7.m();	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x03e9 }
        r1 = 2;
        if (r0 != r1) goto L_0x06c3;
    L_0x06bb:
        r0 = r9.c;	 Catch:{ Exception -> 0x03e9 }
        r1 = 8;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x065e;
    L_0x06c3:
        r0 = r9.c;	 Catch:{ Exception -> 0x03e9 }
        r1 = 0;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x065e;
    L_0x06ca:
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = 0;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.m;	 Catch:{ Exception -> 0x03e9 }
        r1 = 2130837572; // 0x7f020044 float:1.7280102E38 double:1.052773641E-314;
        r0.setBackgroundResource(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = r9.m;	 Catch:{ Exception -> 0x03e9 }
        r2 = 1;
        r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x03e9 }
        r11.b(r0, r1, r2);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x03cb;
    L_0x06e6:
        if (r12 <= 0) goto L_0x072e;
    L_0x06e8:
        r0 = r11.a;	 Catch:{ Exception -> 0x03e9 }
        r1 = r12 + -1;
        r0 = r0.get(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = (zc) r0;	 Catch:{ Exception -> 0x03e9 }
        r1 = r0.j();	 Catch:{ Exception -> 0x03e9 }
        r0 = r11.a;	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.get(r12);	 Catch:{ Exception -> 0x03e9 }
        r0 = (zc) r0;	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.j();	 Catch:{ Exception -> 0x03e9 }
        r0 = r1.equals(r0);	 Catch:{ Exception -> 0x03e9 }
        if (r0 == 0) goto L_0x072e;
    L_0x0708:
        r0 = yz.b(r7);	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.booleanValue();	 Catch:{ Exception -> 0x03e9 }
        if (r0 != 0) goto L_0x072e;
    L_0x0712:
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = 4;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.m;	 Catch:{ Exception -> 0x03e9 }
        r1 = 2130837571; // 0x7f020043 float:1.72801E38 double:1.0527736407E-314;
        r0.setBackgroundResource(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = r9.m;	 Catch:{ Exception -> 0x03e9 }
        r2 = 1;
        r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x03e9 }
        r11.a(r0, r1, r2);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x03cb;
    L_0x072e:
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = 0;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.m;	 Catch:{ Exception -> 0x03e9 }
        r1 = 2130837572; // 0x7f020044 float:1.7280102E38 double:1.052773641E-314;
        r0.setBackgroundResource(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = r9.m;	 Catch:{ Exception -> 0x03e9 }
        r2 = 1;
        r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x03e9 }
        r11.b(r0, r1, r2);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x03cb;
    L_0x074a:
        r0 = r11.b;	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.getResources();	 Catch:{ Exception -> 0x03e9 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x03e9 }
        r1.<init>();	 Catch:{ Exception -> 0x03e9 }
        r2 = "sl";
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x03e9 }
        r2 = r7.d();	 Catch:{ Exception -> 0x03e9 }
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x03e9 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x03e9 }
        r2 = "drawable";
        r3 = r11.b;	 Catch:{ Exception -> 0x03e9 }
        r3 = r3.getPackageName();	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.getIdentifier(r1, r2, r3);	 Catch:{ Exception -> 0x03e9 }
        r1 = r9.b;	 Catch:{ Exception -> 0x03e9 }
        r1.setImageResource(r0);	 Catch:{ Exception -> 0x03e9 }
        r0 = r7.i();	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x03e9 }
        if (r0 != r10) goto L_0x07be;
    L_0x0782:
        if (r12 <= 0) goto L_0x07b6;
    L_0x0784:
        r0 = r11.a;	 Catch:{ Exception -> 0x03e9 }
        r1 = r12 + -1;
        r0 = r0.get(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = (zc) r0;	 Catch:{ Exception -> 0x03e9 }
        r1 = r0.h();	 Catch:{ Exception -> 0x03e9 }
        r0 = r11.a;	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.get(r12);	 Catch:{ Exception -> 0x03e9 }
        r0 = (zc) r0;	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.h();	 Catch:{ Exception -> 0x03e9 }
        r0 = r1.equals(r0);	 Catch:{ Exception -> 0x03e9 }
        if (r0 == 0) goto L_0x07b6;
    L_0x07a4:
        r0 = yz.b(r7);	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.booleanValue();	 Catch:{ Exception -> 0x03e9 }
        if (r0 != 0) goto L_0x07b6;
    L_0x07ae:
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = 4;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x03cb;
    L_0x07b6:
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = 0;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x03cb;
    L_0x07be:
        if (r12 <= 0) goto L_0x07f2;
    L_0x07c0:
        r0 = r11.a;	 Catch:{ Exception -> 0x03e9 }
        r1 = r12 + -1;
        r0 = r0.get(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = (zc) r0;	 Catch:{ Exception -> 0x03e9 }
        r1 = r0.j();	 Catch:{ Exception -> 0x03e9 }
        r0 = r11.a;	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.get(r12);	 Catch:{ Exception -> 0x03e9 }
        r0 = (zc) r0;	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.j();	 Catch:{ Exception -> 0x03e9 }
        r0 = r1.equals(r0);	 Catch:{ Exception -> 0x03e9 }
        if (r0 == 0) goto L_0x07f2;
    L_0x07e0:
        r0 = yz.b(r7);	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.booleanValue();	 Catch:{ Exception -> 0x03e9 }
        if (r0 != 0) goto L_0x07f2;
    L_0x07ea:
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = 4;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x03cb;
    L_0x07f2:
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = 0;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x03cb;
    L_0x07fa:
        r0 = r9.j;	 Catch:{ Exception -> 0x03e9 }
        r1 = r7.f();	 Catch:{ Exception -> 0x03e9 }
        r1 = yt.a(r1);	 Catch:{ Exception -> 0x03e9 }
        r0.setText(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = new afu;	 Catch:{ Exception -> 0x03e9 }
        r1 = r9.b;	 Catch:{ Exception -> 0x03e9 }
        r2 = r7.d();	 Catch:{ Exception -> 0x03e9 }
        r3 = r11.b;	 Catch:{ Exception -> 0x03e9 }
        r0.<init>(r1, r2, r3);	 Catch:{ Exception -> 0x03e9 }
        r1 = 0;
        r1 = new java.lang.String[r1];	 Catch:{ Exception -> 0x03e9 }
        r0.execute(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.b;	 Catch:{ Exception -> 0x03e9 }
        r1 = 2130837597; // 0x7f02005d float:1.7280153E38 double:1.0527736535E-314;
        r0.setImageResource(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r7.d();	 Catch:{ Exception -> 0x03e9 }
        r0 = zp.a(r0);	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.booleanValue();	 Catch:{ Exception -> 0x03e9 }
        if (r0 == 0) goto L_0x083a;
    L_0x0830:
        r0 = r9.b;	 Catch:{ Exception -> 0x03e9 }
        r1 = new ye;	 Catch:{ Exception -> 0x03e9 }
        r1.<init>(r11, r7);	 Catch:{ Exception -> 0x03e9 }
        r0.setOnClickListener(r1);	 Catch:{ Exception -> 0x03e9 }
    L_0x083a:
        r0 = r7.m();	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x03e9 }
        if (r0 == r10) goto L_0x0857;
    L_0x0844:
        r0 = r7.m();	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x03e9 }
        r1 = 2;
        if (r0 == r1) goto L_0x0857;
    L_0x084f:
        r0 = r7.n();	 Catch:{ Exception -> 0x03e9 }
        r1 = ze.d;	 Catch:{ Exception -> 0x03e9 }
        if (r0 != r1) goto L_0x08b0;
    L_0x0857:
        r0 = r9.c;	 Catch:{ Exception -> 0x03e9 }
        r1 = 8;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x03e9 }
    L_0x085e:
        r0 = r7.i();	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x03e9 }
        if (r0 != r10) goto L_0x08d3;
    L_0x0868:
        if (r12 <= 0) goto L_0x08b7;
    L_0x086a:
        r0 = r11.a;	 Catch:{ Exception -> 0x03e9 }
        r1 = r12 + -1;
        r0 = r0.get(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = (zc) r0;	 Catch:{ Exception -> 0x03e9 }
        r1 = r0.h();	 Catch:{ Exception -> 0x03e9 }
        r0 = r11.a;	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.get(r12);	 Catch:{ Exception -> 0x03e9 }
        r0 = (zc) r0;	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.h();	 Catch:{ Exception -> 0x03e9 }
        r0 = r1.equals(r0);	 Catch:{ Exception -> 0x03e9 }
        if (r0 == 0) goto L_0x08b7;
    L_0x088a:
        r0 = yz.b(r7);	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.booleanValue();	 Catch:{ Exception -> 0x03e9 }
        if (r0 != 0) goto L_0x08b7;
    L_0x0894:
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = 4;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.m;	 Catch:{ Exception -> 0x03e9 }
        r1 = 2130837571; // 0x7f020043 float:1.72801E38 double:1.0527736407E-314;
        r0.setBackgroundResource(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = r9.m;	 Catch:{ Exception -> 0x03e9 }
        r2 = 1;
        r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x03e9 }
        r11.a(r0, r1, r2);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x03cb;
    L_0x08b0:
        r0 = r9.c;	 Catch:{ Exception -> 0x03e9 }
        r1 = 0;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x085e;
    L_0x08b7:
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = 0;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.m;	 Catch:{ Exception -> 0x03e9 }
        r1 = 2130837572; // 0x7f020044 float:1.7280102E38 double:1.052773641E-314;
        r0.setBackgroundResource(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = r9.m;	 Catch:{ Exception -> 0x03e9 }
        r2 = 1;
        r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x03e9 }
        r11.b(r0, r1, r2);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x03cb;
    L_0x08d3:
        if (r12 <= 0) goto L_0x091b;
    L_0x08d5:
        r0 = r11.a;	 Catch:{ Exception -> 0x03e9 }
        r1 = r12 + -1;
        r0 = r0.get(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = (zc) r0;	 Catch:{ Exception -> 0x03e9 }
        r1 = r0.j();	 Catch:{ Exception -> 0x03e9 }
        r0 = r11.a;	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.get(r12);	 Catch:{ Exception -> 0x03e9 }
        r0 = (zc) r0;	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.j();	 Catch:{ Exception -> 0x03e9 }
        r0 = r1.equals(r0);	 Catch:{ Exception -> 0x03e9 }
        if (r0 == 0) goto L_0x091b;
    L_0x08f5:
        r0 = yz.b(r7);	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.booleanValue();	 Catch:{ Exception -> 0x03e9 }
        if (r0 != 0) goto L_0x091b;
    L_0x08ff:
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = 4;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.m;	 Catch:{ Exception -> 0x03e9 }
        r1 = 2130837571; // 0x7f020043 float:1.72801E38 double:1.0527736407E-314;
        r0.setBackgroundResource(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = r9.m;	 Catch:{ Exception -> 0x03e9 }
        r2 = 1;
        r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x03e9 }
        r11.a(r0, r1, r2);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x03cb;
    L_0x091b:
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = 0;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.m;	 Catch:{ Exception -> 0x03e9 }
        r1 = 2130837572; // 0x7f020044 float:1.7280102E38 double:1.052773641E-314;
        r0.setBackgroundResource(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = r9.m;	 Catch:{ Exception -> 0x03e9 }
        r2 = 1;
        r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x03e9 }
        r11.b(r0, r1, r2);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x03cb;
    L_0x0937:
        r0 = r9.j;	 Catch:{ Exception -> 0x03e9 }
        r1 = r7.f();	 Catch:{ Exception -> 0x03e9 }
        r1 = yt.a(r1);	 Catch:{ Exception -> 0x03e9 }
        r0.setText(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r11.c;	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x03e9 }
        if (r12 == r0) goto L_0x09d4;
    L_0x094c:
        r0 = r9.e;	 Catch:{ Exception -> 0x03e9 }
        r1 = 2130837566; // 0x7f02003e float:1.728009E38 double:1.052773638E-314;
        r0.setImageResource(r1);	 Catch:{ Exception -> 0x03e9 }
    L_0x0954:
        r0 = r9.e;	 Catch:{ Exception -> 0x03e9 }
        r1 = new yf;	 Catch:{ Exception -> 0x03e9 }
        r1.<init>(r11, r7, r12, r9);	 Catch:{ Exception -> 0x03e9 }
        r0.setOnClickListener(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r7.m();	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x03e9 }
        if (r0 == r10) goto L_0x097b;
    L_0x0968:
        r0 = r7.m();	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x03e9 }
        r1 = 2;
        if (r0 == r1) goto L_0x097b;
    L_0x0973:
        r0 = r7.n();	 Catch:{ Exception -> 0x03e9 }
        r1 = ze.d;	 Catch:{ Exception -> 0x03e9 }
        if (r0 != r1) goto L_0x09de;
    L_0x097b:
        r0 = r9.c;	 Catch:{ Exception -> 0x03e9 }
        r1 = 8;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x03e9 }
    L_0x0982:
        r0 = r7.i();	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x03e9 }
        if (r0 != r10) goto L_0x0a01;
    L_0x098c:
        if (r12 <= 0) goto L_0x09e5;
    L_0x098e:
        r0 = r11.a;	 Catch:{ Exception -> 0x03e9 }
        r1 = r12 + -1;
        r0 = r0.get(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = (zc) r0;	 Catch:{ Exception -> 0x03e9 }
        r1 = r0.h();	 Catch:{ Exception -> 0x03e9 }
        r0 = r11.a;	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.get(r12);	 Catch:{ Exception -> 0x03e9 }
        r0 = (zc) r0;	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.h();	 Catch:{ Exception -> 0x03e9 }
        r0 = r1.equals(r0);	 Catch:{ Exception -> 0x03e9 }
        if (r0 == 0) goto L_0x09e5;
    L_0x09ae:
        r0 = yz.b(r7);	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.booleanValue();	 Catch:{ Exception -> 0x03e9 }
        if (r0 != 0) goto L_0x09e5;
    L_0x09b8:
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = 4;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.m;	 Catch:{ Exception -> 0x03e9 }
        r1 = 2130837571; // 0x7f020043 float:1.72801E38 double:1.0527736407E-314;
        r0.setBackgroundResource(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = r9.m;	 Catch:{ Exception -> 0x03e9 }
        r2 = 1;
        r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x03e9 }
        r11.a(r0, r1, r2);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x03cb;
    L_0x09d4:
        r0 = r9.e;	 Catch:{ Exception -> 0x03e9 }
        r1 = 2130837565; // 0x7f02003d float:1.7280088E38 double:1.0527736377E-314;
        r0.setImageResource(r1);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x0954;
    L_0x09de:
        r0 = r9.c;	 Catch:{ Exception -> 0x03e9 }
        r1 = 0;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x0982;
    L_0x09e5:
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = 0;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.m;	 Catch:{ Exception -> 0x03e9 }
        r1 = 2130837572; // 0x7f020044 float:1.7280102E38 double:1.052773641E-314;
        r0.setBackgroundResource(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = r9.m;	 Catch:{ Exception -> 0x03e9 }
        r2 = 1;
        r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x03e9 }
        r11.b(r0, r1, r2);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x03cb;
    L_0x0a01:
        if (r12 <= 0) goto L_0x0a43;
    L_0x0a03:
        r0 = r11.a;	 Catch:{ Exception -> 0x03e9 }
        r1 = r12 + -1;
        r0 = r0.get(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = (zc) r0;	 Catch:{ Exception -> 0x03e9 }
        r1 = r0.j();	 Catch:{ Exception -> 0x03e9 }
        r0 = r11.a;	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.get(r12);	 Catch:{ Exception -> 0x03e9 }
        r0 = (zc) r0;	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.j();	 Catch:{ Exception -> 0x03e9 }
        r0 = r1.equals(r0);	 Catch:{ Exception -> 0x03e9 }
        if (r0 == 0) goto L_0x0a43;
    L_0x0a23:
        r0 = yz.b(r7);	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.booleanValue();	 Catch:{ Exception -> 0x03e9 }
        if (r0 != 0) goto L_0x0a43;
    L_0x0a2d:
        r0 = r9.m;	 Catch:{ Exception -> 0x03e9 }
        r1 = 2130837571; // 0x7f020043 float:1.72801E38 double:1.0527736407E-314;
        r0.setBackgroundResource(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = r9.m;	 Catch:{ Exception -> 0x03e9 }
        r2 = 1;
        r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x03e9 }
        r11.a(r0, r1, r2);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x03cb;
    L_0x0a43:
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = 0;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.m;	 Catch:{ Exception -> 0x03e9 }
        r1 = 2130837572; // 0x7f020044 float:1.7280102E38 double:1.052773641E-314;
        r0.setBackgroundResource(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = r9.m;	 Catch:{ Exception -> 0x03e9 }
        r2 = 1;
        r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x03e9 }
        r11.b(r0, r1, r2);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x03cb;
    L_0x0a5f:
        r0 = r9.g;	 Catch:{ Exception -> 0x03e9 }
        r1 = r7.d();	 Catch:{ Exception -> 0x03e9 }
        r1 = r11.a(r1);	 Catch:{ Exception -> 0x03e9 }
        r0.setText(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r7.i();	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x03e9 }
        if (r0 != r10) goto L_0x0adb;
    L_0x0a76:
        r0 = r9.i;	 Catch:{ Exception -> 0x03e9 }
        r1 = r7.b();	 Catch:{ Exception -> 0x03e9 }
        r0.setText(r1);	 Catch:{ Exception -> 0x03e9 }
    L_0x0a7f:
        r0 = r7.i();	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x03e9 }
        if (r0 != r10) goto L_0x0aff;
    L_0x0a89:
        if (r12 <= 0) goto L_0x0ae3;
    L_0x0a8b:
        r0 = r11.a;	 Catch:{ Exception -> 0x03e9 }
        r1 = r12 + -1;
        r0 = r0.get(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = (zc) r0;	 Catch:{ Exception -> 0x03e9 }
        r1 = r0.k();	 Catch:{ Exception -> 0x03e9 }
        r0 = r11.a;	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.get(r12);	 Catch:{ Exception -> 0x03e9 }
        r0 = (zc) r0;	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.k();	 Catch:{ Exception -> 0x03e9 }
        r0 = r1.equals(r0);	 Catch:{ Exception -> 0x03e9 }
        if (r0 == 0) goto L_0x0ae3;
    L_0x0aab:
        r0 = r11.a;	 Catch:{ Exception -> 0x03e9 }
        r1 = r12 + -1;
        r0 = r0.get(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = (zc) r0;	 Catch:{ Exception -> 0x03e9 }
        r0 = yz.b(r0);	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.booleanValue();	 Catch:{ Exception -> 0x03e9 }
        if (r0 != 0) goto L_0x0ae3;
    L_0x0abf:
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = 4;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.l;	 Catch:{ Exception -> 0x03e9 }
        r1 = 2130837569; // 0x7f020041 float:1.7280096E38 double:1.0527736397E-314;
        r0.setBackgroundResource(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = r9.l;	 Catch:{ Exception -> 0x03e9 }
        r2 = 0;
        r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x03e9 }
        r11.a(r0, r1, r2);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x03cb;
    L_0x0adb:
        r0 = r9.i;	 Catch:{ Exception -> 0x03e9 }
        r1 = 8;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x0a7f;
    L_0x0ae3:
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = 0;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.l;	 Catch:{ Exception -> 0x03e9 }
        r1 = 2130837570; // 0x7f020042 float:1.7280098E38 double:1.05277364E-314;
        r0.setBackgroundResource(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = r9.l;	 Catch:{ Exception -> 0x03e9 }
        r2 = 0;
        r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x03e9 }
        r11.b(r0, r1, r2);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x03cb;
    L_0x0aff:
        if (r12 <= 0) goto L_0x0b51;
    L_0x0b01:
        r0 = r11.a;	 Catch:{ Exception -> 0x03e9 }
        r1 = r12 + -1;
        r0 = r0.get(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = (zc) r0;	 Catch:{ Exception -> 0x03e9 }
        r1 = r0.j();	 Catch:{ Exception -> 0x03e9 }
        r0 = r11.a;	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.get(r12);	 Catch:{ Exception -> 0x03e9 }
        r0 = (zc) r0;	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.j();	 Catch:{ Exception -> 0x03e9 }
        r0 = r1.equals(r0);	 Catch:{ Exception -> 0x03e9 }
        if (r0 == 0) goto L_0x0b51;
    L_0x0b21:
        r0 = r11.a;	 Catch:{ Exception -> 0x03e9 }
        r1 = r12 + -1;
        r0 = r0.get(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = (zc) r0;	 Catch:{ Exception -> 0x03e9 }
        r0 = yz.b(r0);	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.booleanValue();	 Catch:{ Exception -> 0x03e9 }
        if (r0 != 0) goto L_0x0b51;
    L_0x0b35:
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = 4;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.l;	 Catch:{ Exception -> 0x03e9 }
        r1 = 2130837569; // 0x7f020041 float:1.7280096E38 double:1.0527736397E-314;
        r0.setBackgroundResource(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = r9.l;	 Catch:{ Exception -> 0x03e9 }
        r2 = 0;
        r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x03e9 }
        r11.a(r0, r1, r2);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x03cb;
    L_0x0b51:
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = 0;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.l;	 Catch:{ Exception -> 0x03e9 }
        r1 = 2130837570; // 0x7f020042 float:1.7280098E38 double:1.05277364E-314;
        r0.setBackgroundResource(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = r9.l;	 Catch:{ Exception -> 0x03e9 }
        r2 = 0;
        r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x03e9 }
        r11.b(r0, r1, r2);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x03cb;
    L_0x0b6d:
        r0 = r7.f();	 Catch:{ Exception -> 0x03e9 }
        if (r0 <= r10) goto L_0x0c4f;
    L_0x0b73:
        r0 = r9.j;	 Catch:{ Exception -> 0x03e9 }
        r1 = r7.f();	 Catch:{ Exception -> 0x03e9 }
        r1 = yt.a(r1);	 Catch:{ Exception -> 0x03e9 }
        r0.setText(r1);	 Catch:{ Exception -> 0x03e9 }
    L_0x0b80:
        r0 = r9.i;	 Catch:{ Exception -> 0x03e9 }
        r1 = r7.b();	 Catch:{ Exception -> 0x03e9 }
        r0.setText(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r11.e;	 Catch:{ Exception -> 0x03e9 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x03e9 }
        r1.<init>();	 Catch:{ Exception -> 0x03e9 }
        r2 = r7.d();	 Catch:{ Exception -> 0x03e9 }
        r3 = 0;
        r4 = r7.d();	 Catch:{ Exception -> 0x03e9 }
        r5 = ".";
        r4 = r4.lastIndexOf(r5);	 Catch:{ Exception -> 0x03e9 }
        r2 = r2.substring(r3, r4);	 Catch:{ Exception -> 0x03e9 }
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x03e9 }
        r2 = "thumb";
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x03e9 }
        r2 = ".jpg";
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x03e9 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x03e9 }
        r2 = r9.b;	 Catch:{ Exception -> 0x03e9 }
        r3 = 2130837592; // 0x7f020058 float:1.7280142E38 double:1.052773651E-314;
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ Exception -> 0x03e9 }
        r0.a(r1, r2, r3);	 Catch:{ Exception -> 0x03e9 }
        r0 = r7.d();	 Catch:{ Exception -> 0x03e9 }
        r0 = yz.f(r0);	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.booleanValue();	 Catch:{ Exception -> 0x03e9 }
        if (r0 == 0) goto L_0x0c6f;
    L_0x0bd1:
        r0 = r9.p;	 Catch:{ Exception -> 0x0c60 }
        r1 = 8;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x0c60 }
        r0 = r9.c;	 Catch:{ Exception -> 0x0c60 }
        r1 = 8;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x0c60 }
    L_0x0bdf:
        r0 = r9.p;	 Catch:{ Exception -> 0x03e9 }
        r1 = new yg;	 Catch:{ Exception -> 0x03e9 }
        r1.<init>(r11, r9, r7);	 Catch:{ Exception -> 0x03e9 }
        r0.setOnClickListener(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.b;	 Catch:{ Exception -> 0x03e9 }
        r1 = new xw;	 Catch:{ Exception -> 0x03e9 }
        r1.<init>(r11, r7, r9);	 Catch:{ Exception -> 0x03e9 }
        r0.setOnClickListener(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r7.i();	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x03e9 }
        if (r0 != r10) goto L_0x0c93;
    L_0x0bfd:
        if (r12 <= 0) goto L_0x0c77;
    L_0x0bff:
        r0 = r11.a;	 Catch:{ Exception -> 0x03e9 }
        r1 = r12 + -1;
        r0 = r0.get(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = (zc) r0;	 Catch:{ Exception -> 0x03e9 }
        r1 = r0.k();	 Catch:{ Exception -> 0x03e9 }
        r0 = r11.a;	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.get(r12);	 Catch:{ Exception -> 0x03e9 }
        r0 = (zc) r0;	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.k();	 Catch:{ Exception -> 0x03e9 }
        r0 = r1.equals(r0);	 Catch:{ Exception -> 0x03e9 }
        if (r0 == 0) goto L_0x0c77;
    L_0x0c1f:
        r0 = r11.a;	 Catch:{ Exception -> 0x03e9 }
        r1 = r12 + -1;
        r0 = r0.get(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = (zc) r0;	 Catch:{ Exception -> 0x03e9 }
        r0 = yz.b(r0);	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.booleanValue();	 Catch:{ Exception -> 0x03e9 }
        if (r0 != 0) goto L_0x0c77;
    L_0x0c33:
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = 4;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.m;	 Catch:{ Exception -> 0x03e9 }
        r1 = 2130837569; // 0x7f020041 float:1.7280096E38 double:1.0527736397E-314;
        r0.setBackgroundResource(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = r9.m;	 Catch:{ Exception -> 0x03e9 }
        r2 = 1;
        r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x03e9 }
        r11.a(r0, r1, r2);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x03cb;
    L_0x0c4f:
        r0 = new afh;	 Catch:{ Exception -> 0x03e9 }
        r1 = r9.j;	 Catch:{ Exception -> 0x03e9 }
        r2 = r11.b;	 Catch:{ Exception -> 0x03e9 }
        r0.<init>(r7, r1, r2);	 Catch:{ Exception -> 0x03e9 }
        r1 = 0;
        r1 = new java.lang.String[r1];	 Catch:{ Exception -> 0x03e9 }
        r0.execute(r1);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x0b80;
    L_0x0c60:
        r0 = move-exception;
        r0 = r11.b;	 Catch:{ Exception -> 0x03e9 }
        r1 = "\u0639\u062f\u0645 \u067e\u0634\u062a\u06cc\u0628\u0627\u0646\u06cc \u0627\u0632 \u0641\u0631\u0645\u062a \u0641\u0627\u06cc\u0644";
        r2 = 1;
        r0 = android.widget.Toast.makeText(r0, r1, r2);	 Catch:{ Exception -> 0x03e9 }
        r0.show();	 Catch:{ Exception -> 0x03e9 }
        goto L_0x0bdf;
    L_0x0c6f:
        r0 = r9.p;	 Catch:{ Exception -> 0x03e9 }
        r1 = 0;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x0bdf;
    L_0x0c77:
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = 0;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.m;	 Catch:{ Exception -> 0x03e9 }
        r1 = 2130837570; // 0x7f020042 float:1.7280098E38 double:1.05277364E-314;
        r0.setBackgroundResource(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = r9.m;	 Catch:{ Exception -> 0x03e9 }
        r2 = 1;
        r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x03e9 }
        r11.b(r0, r1, r2);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x03cb;
    L_0x0c93:
        if (r12 <= 0) goto L_0x0cdb;
    L_0x0c95:
        r0 = r11.a;	 Catch:{ Exception -> 0x03e9 }
        r1 = r12 + -1;
        r0 = r0.get(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = (zc) r0;	 Catch:{ Exception -> 0x03e9 }
        r1 = r0.j();	 Catch:{ Exception -> 0x03e9 }
        r0 = r11.a;	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.get(r12);	 Catch:{ Exception -> 0x03e9 }
        r0 = (zc) r0;	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.j();	 Catch:{ Exception -> 0x03e9 }
        r0 = r1.equals(r0);	 Catch:{ Exception -> 0x03e9 }
        if (r0 == 0) goto L_0x0cdb;
    L_0x0cb5:
        r0 = yz.b(r7);	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.booleanValue();	 Catch:{ Exception -> 0x03e9 }
        if (r0 != 0) goto L_0x0cdb;
    L_0x0cbf:
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = 4;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.m;	 Catch:{ Exception -> 0x03e9 }
        r1 = 2130837569; // 0x7f020041 float:1.7280096E38 double:1.0527736397E-314;
        r0.setBackgroundResource(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = r9.m;	 Catch:{ Exception -> 0x03e9 }
        r2 = 1;
        r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x03e9 }
        r11.a(r0, r1, r2);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x03cb;
    L_0x0cdb:
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = 0;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.m;	 Catch:{ Exception -> 0x03e9 }
        r1 = 2130837570; // 0x7f020042 float:1.7280098E38 double:1.05277364E-314;
        r0.setBackgroundResource(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = r9.m;	 Catch:{ Exception -> 0x03e9 }
        r2 = 1;
        r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x03e9 }
        r11.b(r0, r1, r2);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x03cb;
    L_0x0cf7:
        r0 = r9.i;	 Catch:{ Exception -> 0x03e9 }
        r1 = r7.b();	 Catch:{ Exception -> 0x03e9 }
        r0.setText(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r11.b;	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.getResources();	 Catch:{ Exception -> 0x03e9 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x03e9 }
        r1.<init>();	 Catch:{ Exception -> 0x03e9 }
        r2 = "sl";
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x03e9 }
        r2 = r7.d();	 Catch:{ Exception -> 0x03e9 }
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x03e9 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x03e9 }
        r2 = "drawable";
        r3 = r11.b;	 Catch:{ Exception -> 0x03e9 }
        r3 = r3.getPackageName();	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.getIdentifier(r1, r2, r3);	 Catch:{ Exception -> 0x03e9 }
        r1 = r9.b;	 Catch:{ Exception -> 0x03e9 }
        r1.setImageResource(r0);	 Catch:{ Exception -> 0x03e9 }
        r0 = r7.i();	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x03e9 }
        if (r0 != r10) goto L_0x0d7e;
    L_0x0d38:
        if (r12 <= 0) goto L_0x0d76;
    L_0x0d3a:
        r0 = r11.a;	 Catch:{ Exception -> 0x03e9 }
        r1 = r12 + -1;
        r0 = r0.get(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = (zc) r0;	 Catch:{ Exception -> 0x03e9 }
        r1 = r0.k();	 Catch:{ Exception -> 0x03e9 }
        r0 = r11.a;	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.get(r12);	 Catch:{ Exception -> 0x03e9 }
        r0 = (zc) r0;	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.k();	 Catch:{ Exception -> 0x03e9 }
        r0 = r1.equals(r0);	 Catch:{ Exception -> 0x03e9 }
        if (r0 == 0) goto L_0x0d76;
    L_0x0d5a:
        r0 = r11.a;	 Catch:{ Exception -> 0x03e9 }
        r1 = r12 + -1;
        r0 = r0.get(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = (zc) r0;	 Catch:{ Exception -> 0x03e9 }
        r0 = yz.b(r0);	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.booleanValue();	 Catch:{ Exception -> 0x03e9 }
        if (r0 != 0) goto L_0x0d76;
    L_0x0d6e:
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = 4;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x03cb;
    L_0x0d76:
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = 0;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x03cb;
    L_0x0d7e:
        if (r12 <= 0) goto L_0x0db2;
    L_0x0d80:
        r0 = r11.a;	 Catch:{ Exception -> 0x03e9 }
        r1 = r12 + -1;
        r0 = r0.get(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = (zc) r0;	 Catch:{ Exception -> 0x03e9 }
        r1 = r0.j();	 Catch:{ Exception -> 0x03e9 }
        r0 = r11.a;	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.get(r12);	 Catch:{ Exception -> 0x03e9 }
        r0 = (zc) r0;	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.j();	 Catch:{ Exception -> 0x03e9 }
        r0 = r1.equals(r0);	 Catch:{ Exception -> 0x03e9 }
        if (r0 == 0) goto L_0x0db2;
    L_0x0da0:
        r0 = yz.b(r7);	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.booleanValue();	 Catch:{ Exception -> 0x03e9 }
        if (r0 != 0) goto L_0x0db2;
    L_0x0daa:
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = 4;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x03cb;
    L_0x0db2:
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = 0;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x03cb;
    L_0x0dba:
        r0 = r7.f();	 Catch:{ Exception -> 0x03e9 }
        if (r0 <= r10) goto L_0x0e6c;
    L_0x0dc0:
        r0 = r9.j;	 Catch:{ Exception -> 0x03e9 }
        r1 = r7.f();	 Catch:{ Exception -> 0x03e9 }
        r1 = yt.a(r1);	 Catch:{ Exception -> 0x03e9 }
        r0.setText(r1);	 Catch:{ Exception -> 0x03e9 }
    L_0x0dcd:
        r0 = r9.i;	 Catch:{ Exception -> 0x03e9 }
        r1 = r7.b();	 Catch:{ Exception -> 0x03e9 }
        r0.setText(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.b;	 Catch:{ Exception -> 0x03e9 }
        r1 = new xx;	 Catch:{ Exception -> 0x03e9 }
        r1.<init>(r11, r7, r9);	 Catch:{ Exception -> 0x03e9 }
        r0.setOnClickListener(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r11.e;	 Catch:{ Exception -> 0x03e9 }
        r1 = r7.d();	 Catch:{ Exception -> 0x03e9 }
        r2 = ".mp4";
        r3 = "thumb.jpg";
        r1 = r1.replace(r2, r3);	 Catch:{ Exception -> 0x03e9 }
        r2 = r9.b;	 Catch:{ Exception -> 0x03e9 }
        r3 = 2130837592; // 0x7f020058 float:1.7280142E38 double:1.052773651E-314;
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ Exception -> 0x03e9 }
        r0.a(r1, r2, r3);	 Catch:{ Exception -> 0x03e9 }
        r0 = r7.d();	 Catch:{ Exception -> 0x03e9 }
        r0 = yz.e(r0);	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.booleanValue();	 Catch:{ Exception -> 0x03e9 }
        if (r0 == 0) goto L_0x0e7d;
    L_0x0e08:
        r0 = r9.e;	 Catch:{ Exception -> 0x03e9 }
        r1 = 2130837896; // 0x7f020188 float:1.728076E38 double:1.0527738013E-314;
        r0.setImageResource(r1);	 Catch:{ Exception -> 0x03e9 }
    L_0x0e10:
        r0 = r7.i();	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x03e9 }
        if (r0 != r10) goto L_0x0ea2;
    L_0x0e1a:
        if (r12 <= 0) goto L_0x0e86;
    L_0x0e1c:
        r0 = r11.a;	 Catch:{ Exception -> 0x03e9 }
        r1 = r12 + -1;
        r0 = r0.get(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = (zc) r0;	 Catch:{ Exception -> 0x03e9 }
        r1 = r0.k();	 Catch:{ Exception -> 0x03e9 }
        r0 = r11.a;	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.get(r12);	 Catch:{ Exception -> 0x03e9 }
        r0 = (zc) r0;	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.k();	 Catch:{ Exception -> 0x03e9 }
        r0 = r1.equals(r0);	 Catch:{ Exception -> 0x03e9 }
        if (r0 == 0) goto L_0x0e86;
    L_0x0e3c:
        r0 = r11.a;	 Catch:{ Exception -> 0x03e9 }
        r1 = r12 + -1;
        r0 = r0.get(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = (zc) r0;	 Catch:{ Exception -> 0x03e9 }
        r0 = yz.b(r0);	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.booleanValue();	 Catch:{ Exception -> 0x03e9 }
        if (r0 != 0) goto L_0x0e86;
    L_0x0e50:
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = 4;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.m;	 Catch:{ Exception -> 0x03e9 }
        r1 = 2130837569; // 0x7f020041 float:1.7280096E38 double:1.0527736397E-314;
        r0.setBackgroundResource(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = r9.m;	 Catch:{ Exception -> 0x03e9 }
        r2 = 1;
        r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x03e9 }
        r11.a(r0, r1, r2);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x03cb;
    L_0x0e6c:
        r0 = new afh;	 Catch:{ Exception -> 0x03e9 }
        r1 = r9.j;	 Catch:{ Exception -> 0x03e9 }
        r2 = r11.b;	 Catch:{ Exception -> 0x03e9 }
        r0.<init>(r7, r1, r2);	 Catch:{ Exception -> 0x03e9 }
        r1 = 0;
        r1 = new java.lang.String[r1];	 Catch:{ Exception -> 0x03e9 }
        r0.execute(r1);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x0dcd;
    L_0x0e7d:
        r0 = r9.e;	 Catch:{ Exception -> 0x03e9 }
        r1 = 2130837895; // 0x7f020187 float:1.7280757E38 double:1.052773801E-314;
        r0.setImageResource(r1);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x0e10;
    L_0x0e86:
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = 0;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.m;	 Catch:{ Exception -> 0x03e9 }
        r1 = 2130837570; // 0x7f020042 float:1.7280098E38 double:1.05277364E-314;
        r0.setBackgroundResource(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = r9.m;	 Catch:{ Exception -> 0x03e9 }
        r2 = 1;
        r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x03e9 }
        r11.b(r0, r1, r2);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x03cb;
    L_0x0ea2:
        if (r12 <= 0) goto L_0x0eea;
    L_0x0ea4:
        r0 = r11.a;	 Catch:{ Exception -> 0x03e9 }
        r1 = r12 + -1;
        r0 = r0.get(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = (zc) r0;	 Catch:{ Exception -> 0x03e9 }
        r1 = r0.j();	 Catch:{ Exception -> 0x03e9 }
        r0 = r11.a;	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.get(r12);	 Catch:{ Exception -> 0x03e9 }
        r0 = (zc) r0;	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.j();	 Catch:{ Exception -> 0x03e9 }
        r0 = r1.equals(r0);	 Catch:{ Exception -> 0x03e9 }
        if (r0 == 0) goto L_0x0eea;
    L_0x0ec4:
        r0 = yz.b(r7);	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.booleanValue();	 Catch:{ Exception -> 0x03e9 }
        if (r0 != 0) goto L_0x0eea;
    L_0x0ece:
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = 4;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.m;	 Catch:{ Exception -> 0x03e9 }
        r1 = 2130837569; // 0x7f020041 float:1.7280096E38 double:1.0527736397E-314;
        r0.setBackgroundResource(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = r9.m;	 Catch:{ Exception -> 0x03e9 }
        r2 = 1;
        r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x03e9 }
        r11.a(r0, r1, r2);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x03cb;
    L_0x0eea:
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = 0;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.m;	 Catch:{ Exception -> 0x03e9 }
        r1 = 2130837570; // 0x7f020042 float:1.7280098E38 double:1.05277364E-314;
        r0.setBackgroundResource(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = r9.m;	 Catch:{ Exception -> 0x03e9 }
        r2 = 1;
        r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x03e9 }
        r11.b(r0, r1, r2);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x03cb;
    L_0x0f06:
        r0 = r7.f();	 Catch:{ Exception -> 0x03e9 }
        if (r0 <= r10) goto L_0x0f9e;
    L_0x0f0c:
        r0 = r9.j;	 Catch:{ Exception -> 0x03e9 }
        r1 = r7.f();	 Catch:{ Exception -> 0x03e9 }
        r1 = yt.a(r1);	 Catch:{ Exception -> 0x03e9 }
        r0.setText(r1);	 Catch:{ Exception -> 0x03e9 }
    L_0x0f19:
        r0 = r9.i;	 Catch:{ Exception -> 0x03e9 }
        r1 = r7.b();	 Catch:{ Exception -> 0x03e9 }
        r0.setText(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.e;	 Catch:{ Exception -> 0x03e9 }
        r1 = new xy;	 Catch:{ Exception -> 0x03e9 }
        r1.<init>(r11, r7, r12, r9);	 Catch:{ Exception -> 0x03e9 }
        r0.setOnClickListener(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r7.d();	 Catch:{ Exception -> 0x03e9 }
        r0 = yz.g(r0);	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.booleanValue();	 Catch:{ Exception -> 0x03e9 }
        if (r0 == 0) goto L_0x0faf;
    L_0x0f3a:
        r0 = r9.e;	 Catch:{ Exception -> 0x03e9 }
        r1 = 2130837566; // 0x7f02003e float:1.728009E38 double:1.052773638E-314;
        r0.setImageResource(r1);	 Catch:{ Exception -> 0x03e9 }
    L_0x0f42:
        r0 = r7.i();	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x03e9 }
        if (r0 != r10) goto L_0x0fd4;
    L_0x0f4c:
        if (r12 <= 0) goto L_0x0fb8;
    L_0x0f4e:
        r0 = r11.a;	 Catch:{ Exception -> 0x03e9 }
        r1 = r12 + -1;
        r0 = r0.get(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = (zc) r0;	 Catch:{ Exception -> 0x03e9 }
        r1 = r0.k();	 Catch:{ Exception -> 0x03e9 }
        r0 = r11.a;	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.get(r12);	 Catch:{ Exception -> 0x03e9 }
        r0 = (zc) r0;	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.k();	 Catch:{ Exception -> 0x03e9 }
        r0 = r1.equals(r0);	 Catch:{ Exception -> 0x03e9 }
        if (r0 == 0) goto L_0x0fb8;
    L_0x0f6e:
        r0 = r11.a;	 Catch:{ Exception -> 0x03e9 }
        r1 = r12 + -1;
        r0 = r0.get(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = (zc) r0;	 Catch:{ Exception -> 0x03e9 }
        r0 = yz.b(r0);	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.booleanValue();	 Catch:{ Exception -> 0x03e9 }
        if (r0 != 0) goto L_0x0fb8;
    L_0x0f82:
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = 4;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.m;	 Catch:{ Exception -> 0x03e9 }
        r1 = 2130837569; // 0x7f020041 float:1.7280096E38 double:1.0527736397E-314;
        r0.setBackgroundResource(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = r9.m;	 Catch:{ Exception -> 0x03e9 }
        r2 = 1;
        r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x03e9 }
        r11.a(r0, r1, r2);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x03cb;
    L_0x0f9e:
        r0 = new afh;	 Catch:{ Exception -> 0x03e9 }
        r1 = r9.j;	 Catch:{ Exception -> 0x03e9 }
        r2 = r11.b;	 Catch:{ Exception -> 0x03e9 }
        r0.<init>(r7, r1, r2);	 Catch:{ Exception -> 0x03e9 }
        r1 = 0;
        r1 = new java.lang.String[r1];	 Catch:{ Exception -> 0x03e9 }
        r0.execute(r1);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x0f19;
    L_0x0faf:
        r0 = r9.e;	 Catch:{ Exception -> 0x03e9 }
        r1 = 2130837564; // 0x7f02003c float:1.7280086E38 double:1.052773637E-314;
        r0.setImageResource(r1);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x0f42;
    L_0x0fb8:
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = 0;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.m;	 Catch:{ Exception -> 0x03e9 }
        r1 = 2130837570; // 0x7f020042 float:1.7280098E38 double:1.05277364E-314;
        r0.setBackgroundResource(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = r9.m;	 Catch:{ Exception -> 0x03e9 }
        r2 = 1;
        r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x03e9 }
        r11.b(r0, r1, r2);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x03cb;
    L_0x0fd4:
        if (r12 <= 0) goto L_0x101c;
    L_0x0fd6:
        r0 = r11.a;	 Catch:{ Exception -> 0x03e9 }
        r1 = r12 + -1;
        r0 = r0.get(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = (zc) r0;	 Catch:{ Exception -> 0x03e9 }
        r1 = r0.j();	 Catch:{ Exception -> 0x03e9 }
        r0 = r11.a;	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.get(r12);	 Catch:{ Exception -> 0x03e9 }
        r0 = (zc) r0;	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.j();	 Catch:{ Exception -> 0x03e9 }
        r0 = r1.equals(r0);	 Catch:{ Exception -> 0x03e9 }
        if (r0 == 0) goto L_0x101c;
    L_0x0ff6:
        r0 = yz.b(r7);	 Catch:{ Exception -> 0x03e9 }
        r0 = r0.booleanValue();	 Catch:{ Exception -> 0x03e9 }
        if (r0 != 0) goto L_0x101c;
    L_0x1000:
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = 4;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.m;	 Catch:{ Exception -> 0x03e9 }
        r1 = 2130837569; // 0x7f020041 float:1.7280096E38 double:1.0527736397E-314;
        r0.setBackgroundResource(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = r9.m;	 Catch:{ Exception -> 0x03e9 }
        r2 = 1;
        r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x03e9 }
        r11.a(r0, r1, r2);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x03cb;
    L_0x101c:
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = 0;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.m;	 Catch:{ Exception -> 0x03e9 }
        r1 = 2130837570; // 0x7f020042 float:1.7280098E38 double:1.05277364E-314;
        r0.setBackgroundResource(r1);	 Catch:{ Exception -> 0x03e9 }
        r0 = r9.h;	 Catch:{ Exception -> 0x03e9 }
        r1 = r9.m;	 Catch:{ Exception -> 0x03e9 }
        r2 = 1;
        r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x03e9 }
        r11.b(r0, r1, r2);	 Catch:{ Exception -> 0x03e9 }
        goto L_0x03cb;
        */
        throw new UnsupportedOperationException("Method not decompiled: xv.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    public Spannable a(String str) {
        Spannable spannableStringBuilder = new SpannableStringBuilder(str);
        if (this.k.size() > 0) {
            int i = 0;
            while (i < spannableStringBuilder.length()) {
                if (Character.toString(spannableStringBuilder.charAt(i)).equals("e")) {
                    for (Entry entry : this.k.entrySet()) {
                        int length = ((String) entry.getKey()).length();
                        if (i + length <= spannableStringBuilder.length() && spannableStringBuilder.subSequence(i, i + length).toString().equals(entry.getKey())) {
                            Drawable drawable = this.b.getResources().getDrawable(((Integer) entry.getValue()).intValue());
                            drawable.setBounds(0, 0, ((int) this.g) * 25, ((int) this.g) * 25);
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

    public void a(ImageView imageView, int i) {
        Bitmap decodeResource = BitmapFactory.decodeResource(this.b.getResources(), i);
        Bitmap decodeResource2 = BitmapFactory.decodeResource(this.b.getResources(), R.drawable.maskconversation);
        decodeResource = Bitmap.createScaledBitmap(decodeResource, decodeResource2.getWidth(), decodeResource2.getHeight(), true);
        Bitmap createBitmap = Bitmap.createBitmap(decodeResource2.getWidth(), decodeResource2.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        paint.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
        canvas.drawBitmap(decodeResource, 0.0f, 0.0f, null);
        canvas.drawBitmap(decodeResource2, 0.0f, 0.0f, paint);
        paint.setXfermode(null);
        imageView.setImageBitmap(createBitmap);
        imageView.setScaleType(ScaleType.CENTER);
        imageView.setBackgroundResource(R.drawable.maskconversationborder);
    }

    public void a(ImageView imageView, Bitmap bitmap) {
        Bitmap decodeResource = BitmapFactory.decodeResource(this.b.getResources(), R.drawable.maskconversation);
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, decodeResource.getWidth(), decodeResource.getHeight(), true);
        Bitmap createBitmap = Bitmap.createBitmap(decodeResource.getWidth(), decodeResource.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        paint.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
        canvas.drawBitmap(createScaledBitmap, 0.0f, 0.0f, null);
        canvas.drawBitmap(decodeResource, 0.0f, 0.0f, paint);
        paint.setXfermode(null);
        imageView.setImageBitmap(createBitmap);
        imageView.setScaleType(ScaleType.CENTER);
        imageView.setBackgroundResource(R.drawable.maskconversationborder);
    }

    public void a(ImageView imageView, LinearLayout linearLayout, Boolean bool) {
        if (bool.booleanValue()) {
            LayoutParams layoutParams = (LayoutParams) linearLayout.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) imageView.getLayoutParams();
            layoutParams.setMargins(0, (int) (this.g * 5.0f), 0, 0);
            layoutParams2.setMargins(0, -20, 0, 0);
            linearLayout.setLayoutParams(layoutParams);
            imageView.setLayoutParams(layoutParams2);
            return;
        }
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams3.setMargins(0, (int) (this.g * 5.0f), 0, 0);
        layoutParams4.setMargins(0, -20, 0, 0);
        linearLayout.setLayoutParams(layoutParams3);
        imageView.setLayoutParams(layoutParams4);
    }

    public void b(ImageView imageView, LinearLayout linearLayout, Boolean bool) {
        if (bool.booleanValue()) {
            LayoutParams layoutParams = (LayoutParams) linearLayout.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) imageView.getLayoutParams();
            layoutParams.setMargins(0, (int) (this.g * 19.0f), 0, 0);
            layoutParams2.setMargins(0, 0, 0, 0);
            linearLayout.setLayoutParams(layoutParams);
            imageView.setLayoutParams(layoutParams2);
            return;
        }
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams3.setMargins(0, (int) (this.g * 19.0f), 0, 0);
        layoutParams4.setMargins(0, 0, 0, 0);
        linearLayout.setLayoutParams(layoutParams3);
        imageView.setLayoutParams(layoutParams4);
    }

    public void a(ImageView imageView, RelativeLayout relativeLayout, Boolean bool) {
        if (bool.booleanValue()) {
            LayoutParams layoutParams = (LayoutParams) relativeLayout.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) imageView.getLayoutParams();
            layoutParams.setMargins(0, (int) (this.g * 5.0f), 0, 0);
            layoutParams2.setMargins(0, -20, 0, 0);
            relativeLayout.setLayoutParams(layoutParams);
            imageView.setLayoutParams(layoutParams2);
            return;
        }
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) relativeLayout.getLayoutParams();
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams3.setMargins(0, (int) (this.g * 5.0f), 0, 0);
        layoutParams4.setMargins(0, -20, 0, 0);
        relativeLayout.setLayoutParams(layoutParams3);
        imageView.setLayoutParams(layoutParams4);
    }

    public void b(ImageView imageView, RelativeLayout relativeLayout, Boolean bool) {
        if (bool.booleanValue()) {
            LayoutParams layoutParams = (LayoutParams) relativeLayout.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) imageView.getLayoutParams();
            layoutParams.setMargins(0, (int) (this.g * 19.0f), 0, 0);
            layoutParams2.setMargins(0, 0, 0, 0);
            relativeLayout.setLayoutParams(layoutParams);
            imageView.setLayoutParams(layoutParams2);
            return;
        }
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) relativeLayout.getLayoutParams();
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams3.setMargins(0, (int) (this.g * 19.0f), 0, 0);
        layoutParams4.setMargins(0, 0, 0, 0);
        relativeLayout.setLayoutParams(layoutParams3);
        imageView.setLayoutParams(layoutParams4);
    }
}
