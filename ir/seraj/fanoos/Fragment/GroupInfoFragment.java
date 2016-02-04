package ir.seraj.fanoos.Fragment;

import aas;
import aay;
import acu;
import acv;
import acw;
import acx;
import acy;
import acz;
import ada;
import adb;
import adc;
import aeq;
import aez;
import afk;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import ir.seraj.fanoos.Activity.ChatsActivity;
import ir.seraj.fanoos.Activity.ConversationActivity;
import ir.seraj.fanoos.Activity.ImageEditorActivity;
import ir.seraj.fanoos.communication.IntentServiceGeneralCommand;
import ir.seraj.fanoos.communication.MyResultReceiver;
import ir.seraj.fanoos3.R;
import java.io.File;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import ym;
import ys;
import yw;
import yx;
import zk;
import zm;
import zn;
import zt;

public class GroupInfoFragment extends Fragment implements afk {
    public ListView a;
    TextView aj;
    View ak;
    BroadcastReceiver al;
    public aay am;
    Bitmap an;
    int ao;
    public MyResultReceiver ap;
    ProgressDialog aq;
    private Intent ar;
    public List b;
    public String c;
    public ym d;
    public yw e;
    Boolean f;
    public ImageView g;
    ImageView h;
    public TextView i;

    public GroupInfoFragment() {
        this.f = Boolean.valueOf(false);
        this.al = new acz(this);
        this.ar = null;
        this.ao = 0;
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_group_info, viewGroup, false);
        this.ap = new MyResultReceiver(new Handler());
        this.aq = new ProgressDialog(h());
        this.g = (ImageView) inflate.findViewById(R.id.group_info_item_imageContact_imageView);
        this.h = (ImageView) inflate.findViewById(R.id.group_info_item_edit_imageView);
        this.i = (TextView) inflate.findViewById(R.id.group_info_name_textView);
        this.am = new aay(h(), null, Boolean.valueOf(true), Boolean.valueOf(true), zk.c);
        ((ImageView) h().findViewById(R.id.toolbar_header_back_imageView)).setOnClickListener(new acu(this));
        this.h.setOnClickListener(new acv(this));
        this.g.setOnClickListener(new acw(this));
        this.c = g().getString("GroupId");
        this.e = yw.c(this.c, h());
        this.b = yx.a(this.c, h());
        this.aj = (TextView) inflate.findViewById(R.id.group_info_item_participate_Count_textView);
        this.a = (ListView) inflate.findViewById(R.id.addParticipants_list);
        this.ak = ((LayoutInflater) h().getSystemService("layout_inflater")).inflate(R.layout.list_item_participants_footer, null);
        ((Button) this.ak.findViewById(R.id.participants_item_footer_exit_button)).setOnClickListener(new acx(this));
        if (aeq.o(h()).equals(this.e.g())) {
            Button button = (Button) this.ak.findViewById(R.id.participants_item_footer_add_button);
            button.setVisibility(0);
            button.setOnClickListener(new acy(this));
        }
        return inflate;
    }

    public void r() {
        this.ap.a(null);
        if (this.f.booleanValue()) {
            h().unregisterReceiver(this.al);
            this.f = Boolean.valueOf(false);
        }
        super.r();
    }

    public void q() {
        this.ap.a(this);
        this.b = yx.a(this.c, h());
        this.d = new ym(h(), this.b, this.e.g());
        this.a.addFooterView(this.ak);
        this.a.setAdapter(this.d);
        this.aj.setText(this.b.size() + " \u0627\u0632" + "110");
        this.a.setOnItemClickListener(new ada(this));
        this.am.a(this.e.a(), this.g, Integer.valueOf(R.drawable.default_image_group));
        this.i.setText(this.e.c());
        a(this.a);
        if (!this.f.booleanValue()) {
            h().registerReceiver(this.al, new IntentFilter("ir.dayasoft.BroadCastUpdateGroupInfo"));
            this.f = Boolean.valueOf(true);
        }
        super.q();
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        if (view.getId() == R.id.addParticipants_list) {
            yx yxVar = (yx) ((ListView) view).getItemAtPosition(((AdapterContextMenuInfo) contextMenuInfo).position);
            if (!aeq.o(h()).equals(yxVar.a()) && aeq.o(h()).equals(this.e.g())) {
                contextMenu.add(0, 445, 0, "\u0645\u06a9\u0627\u0644\u0645\u0647 \u062e\u0635\u0648\u0635\u06cc");
                contextMenu.add(0, 446, 0, "\u062d\u0630\u0641 \u0627\u0632 \u06af\u0631\u0648\u0647");
            } else if (!aeq.o(h()).equals(yxVar.a())) {
                contextMenu.add(0, 445, 0, "\u0645\u06a9\u0627\u0644\u0645\u0647 \u062e\u0635\u0648\u0635\u06cc");
            }
        }
    }

    public boolean b(MenuItem menuItem) {
        int i = ((AdapterContextMenuInfo) menuItem.getMenuInfo()).position;
        Intent intent;
        if (menuItem.getItemId() == 446) {
            if (zm.a(h()).booleanValue()) {
                intent = new Intent(h(), IntentServiceGeneralCommand.class);
                intent.putExtra("receiverTag", this.ap);
                intent.putExtra("CommandCode", 7);
                intent.putExtra("GroupId", String.valueOf(this.c));
                intent.putExtra("Participants", ((yx) this.b.get(i)).a());
                intent.putExtra("IsRemove", true);
                h().startService(intent);
            } else {
                Toast.makeText(h(), "\u0639\u062f\u0645 \u0627\u062a\u0635\u0627\u0644 \u06cc\u0647 \u0627\u06cc\u0646\u062a\u0631\u0646\u062a", 0).show();
            }
        } else if (menuItem.getItemId() == 445) {
            intent = new Intent(h(), ConversationActivity.class);
            intent.putExtra("IsGroup", "0");
            intent.putExtra("MobileNumber", ((yx) this.b.get(i)).a());
            h().startActivity(intent);
        }
        return super.b(menuItem);
    }

    public void a(int i, int i2, Intent intent) {
        if (i == 113 && i2 == -1 && intent != null) {
            try {
                Options options = new Options();
                options.inPreferredConfig = Config.ARGB_8888;
                this.an = BitmapFactory.decodeFile(intent.getStringExtra("ir.seraj.intent.ImageEditUri"), options);
                ((ImageView) h().findViewById(R.id.group_info_item_imageContact_imageView)).setImageBitmap(this.an);
                new aez(h(), XmlPullParser.NO_NAMESPACE, intent.getStringExtra("ir.seraj.intent.ImageEditUri"), String.valueOf(this.e.b())).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
            } catch (Exception e) {
                aas aas = new aas();
                aas.a("ir.seraj.fanoos");
                aas.e(ys.a(h()));
                aas.d(zn.a());
                aas.c("openGallery");
                aas.b(e.getMessage());
                aas.a(Integer.valueOf(0));
                aas.a(h());
                return;
            }
        }
        if (i == 1888) {
            h();
            if (i2 == -1) {
                File file = new File(Environment.getExternalStorageDirectory() + File.separator + "image.jpg");
                this.ar = new Intent(h(), ImageEditorActivity.class);
                this.ar.setType("image*//*");
                this.ar.putExtra("return-data", true);
                this.ar.putExtra("FixedAspectRatio", true);
                this.ar.setData(Uri.fromFile(file));
                a(this.ar, 113);
            }
        }
        if (i == 112) {
            h();
            if (i2 == -1 && intent != null) {
                Uri data = intent.getData();
                this.ar = new Intent(h(), ImageEditorActivity.class);
                this.ar.setType("image*//*");
                this.ar.putExtra("return-data", true);
                this.ar.putExtra("FixedAspectRatio", true);
                this.ar.setData(data);
                a(this.ar, 113);
            }
        }
    }

    private void a() {
        Builder builder = new Builder(h());
        builder.setTitle("\u0628\u0627\u0631\u06af\u0632\u0627\u0631\u06cc \u062a\u0635\u0648\u06cc\u0631 ");
        builder.setMessage("\u0627\u0632 \u0686\u0647 \u0637\u0631\u06cc\u0642\u06cc \u0645\u06cc \u062e\u0648\u0627\u0647\u06cc\u062f \u0639\u06a9\u0633 \u0622\u067e\u0644\u0648\u062f \u06a9\u0646\u06cc\u062f");
        builder.setPositiveButton("\u06af\u0627\u0644\u0631\u06cc", new adb(this));
        builder.setNegativeButton("\u062f\u0648\u0631\u0628\u06cc\u0646", new adc(this));
        builder.show();
    }

    public void a(int i, Bundle bundle) {
        int i2;
        String str = XmlPullParser.NO_NAMESPACE;
        if (bundle != null) {
            i2 = bundle.getInt("CommandCode");
        } else {
            i2 = 0;
        }
        aeq.o(h());
        if (i2 == 7) {
            str = bundle.getString("ParticipantsManegmentAsyncTask");
            if (i == 0) {
                this.aq.setCancelable(false);
                this.aq.setMessage("\u062f\u0631 \u062d\u0627\u0644 \u062d\u0630\u0641 \u0627\u0632 \u06af\u0631\u0648\u0647");
                this.aq.show();
                return;
            }
            this.aq.dismiss();
            if (str.equals("1")) {
                h().sendBroadcast(new Intent("ir.dayasoft.BroadCastUpdateGroupInfo"));
                Intent intent = new Intent(h(), ChatsActivity.class);
                intent.setFlags(67108864);
                h().startActivity(intent);
                return;
            }
            new zt().b(h());
        }
    }
}
