package ir.seraj.fanoos.Activity;

import aas;
import aeq;
import afe;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import ir.seraj.fanoos3.R;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import wt;
import wu;
import wv;
import ww;
import wx;
import wz;
import xa;
import xb;
import xc;
import xd;
import xe;
import xf;
import ys;
import zg;
import zk;
import zn;
import zt;

public class SettingActivity extends ActionBarActivity {
    LinearLayout n;
    LinearLayout o;
    LinearLayout p;
    LinearLayout q;
    ImageView r;
    ImageView s;
    TextView t;
    public TextView u;
    ProgressBar v;
    Bitmap w;
    int x;
    private Intent y;

    public SettingActivity() {
        this.x = 0;
        this.y = null;
    }

    private void k() {
        ((ImageView) findViewById(R.id.toolbar_header_back_imageView)).setOnClickListener(new wt(this));
    }

    private void l() {
        this.r = (ImageView) findViewById(R.id.setting_profile_image_imageView);
        this.s = (ImageView) findViewById(R.id.setting_username_edit_imageView);
        this.u = (TextView) findViewById(R.id.setting_username_textView);
        this.t = (TextView) findViewById(R.id.setting_profile_image_change_imageView);
        this.v = (ProgressBar) findViewById(R.id.change_photo_progress);
        File file = new File(zk.a + File.separator + "myProfileImage.jpg");
        if (file.exists()) {
            this.r.setImageBitmap(BitmapFactory.decodeFile(file.getAbsolutePath()));
        }
        this.u.setText(aeq.l(this));
        this.s.setOnClickListener(new wx(this));
        this.r.setOnClickListener(new wz(this));
        this.t.setOnClickListener(new xa(this));
    }

    private void m() {
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse("content://contacts/people/"));
            startActivity(intent);
        } catch (Exception e) {
            aas aas = new aas();
            aas.a("ir.seraj.fanoos");
            aas.e(ys.a(this));
            aas.d(zn.a());
            aas.c("openContact");
            aas.b(e.getMessage());
            aas.a(Integer.valueOf(0));
            aas.a((Context) this);
        }
    }

    private void n() {
        this.n = (LinearLayout) findViewById(R.id.setting_contacts_linearLayout);
        this.o = (LinearLayout) findViewById(R.id.setting_invite_linearLayout);
        this.p = (LinearLayout) findViewById(R.id.setting_aboutUs_linearLayout);
        this.q = (LinearLayout) findViewById(R.id.setting_setting_linearLayout);
        this.n.setOnClickListener(new xb(this));
        this.p.setOnClickListener(new xc(this));
        this.o.setOnClickListener(new xd(this));
        this.q.setOnClickListener(new xe(this));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_setting);
        k();
        n();
        l();
    }

    public void j() {
        View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.dialog_send_invitation_option, null);
        TextView textView = (TextView) inflate.findViewById(R.id.dialog_send_invitation_option_number_button);
        TextView textView2 = (TextView) inflate.findViewById(R.id.dialog_send_invitation_option_contacts_button);
        EditText editText = (EditText) inflate.findViewById(R.id.dialog_send_invitation_option_cellPhoneNumber_editText);
        Builder builder = new Builder(this);
        builder.setView(inflate);
        AlertDialog create = builder.create();
        textView2.setOnClickListener(new xf(this, create));
        textView.setOnClickListener(new wu(this, editText, create));
        create.show();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1889 && i2 == -1) {
            try {
                Uri data = intent.getData();
                List arrayList = new ArrayList();
                ContentResolver contentResolver = getContentResolver();
                Cursor query = getContentResolver().query(data, null, null, null, null);
                if (query.moveToFirst()) {
                    String string = query.getString(query.getColumnIndex("_id"));
                    if (Integer.parseInt(query.getString(query.getColumnIndex("has_phone_number"))) > 0) {
                        String str = "data1";
                        Cursor query2 = contentResolver.query(Phone.CONTENT_URI, null, "contact_id" + " = ?", new String[]{string}, null);
                        Boolean valueOf = Boolean.valueOf(false);
                        while (query2.moveToNext()) {
                            String string2 = query2.getString(query2.getColumnIndex(str));
                            valueOf = Boolean.valueOf(true);
                            string2 = zg.g(string2);
                            if (zg.h(string2).booleanValue()) {
                                arrayList.add(string2);
                            } else {
                                Toast.makeText(this, "\u0634\u0645\u0627\u0631\u0647 \u0645\u0648\u0628\u0627\u06cc\u0644 \u0635\u062d\u06cc\u062d \u0646\u0645\u06cc \u0628\u0627\u0634\u062f", 0).show();
                            }
                        }
                        query2.close();
                        if (arrayList.size() < 1) {
                            Toast.makeText(this, "\u0634\u0645\u0627\u0631\u0647 \u0645\u0648\u0628\u0627\u06cc\u0644 \u0635\u062d\u06cc\u062d \u0646\u0645\u06cc \u0628\u0627\u0634\u062f", 0).show();
                        } else {
                            new zt().a(arrayList, (Context) this);
                        }
                        if (!valueOf.booleanValue()) {
                            Toast.makeText(this, "\u0645\u062e\u0627\u0637\u0628 \u0627\u0646\u062a\u062e\u0627\u0628\u06cc \u0634\u0645\u0627\u0631\u0647 \u0645\u0648\u0628\u0627\u06cc\u0644 \u0646\u062f\u0627\u0631\u062f", 0).show();
                        }
                    } else {
                        Toast.makeText(this, "\u0645\u062e\u0627\u0637\u0628 \u0627\u0646\u062a\u062e\u0627\u0628\u06cc \u0634\u0645\u0627\u0631\u0647 \u0645\u0648\u0628\u0627\u06cc\u0644 \u0646\u062f\u0627\u0631\u062f", 0).show();
                    }
                } else {
                    Toast.makeText(this, "\u0645\u062e\u0627\u0637\u0628 \u0627\u0646\u062a\u062e\u0627\u0628\u06cc \u0634\u0645\u0627\u0631\u0647 \u0645\u0648\u0628\u0627\u06cc\u0644 \u0646\u062f\u0627\u0631\u062f", 0).show();
                }
            } catch (Exception e) {
                Toast.makeText(this, "\u062e\u0637\u0627 \u062f\u0631 \u062e\u0648\u0627\u0646\u062f\u0646 \u0634\u0645\u0627\u0631\u0647 \u0645\u0648\u0628\u0627\u06cc\u0644", 0).show();
            }
        }
        if (i == 113 && i2 == -1 && intent != null) {
            try {
                Options options = new Options();
                options.inPreferredConfig = Config.ARGB_8888;
                this.w = BitmapFactory.decodeFile(intent.getStringExtra("ir.seraj.intent.ImageEditUri"), options);
                ((ImageView) findViewById(R.id.setting_profile_image_imageView)).setImageBitmap(this.w);
                new afe(this, this.v, intent.getStringExtra("ir.seraj.intent.ImageEditUri")).execute(new String[0]);
            } catch (Exception e2) {
                aas aas = new aas();
                aas.a("ir.seraj.fanoos");
                aas.e(ys.a(this));
                aas.d(zn.a());
                aas.c("openGallery");
                aas.b(e2.getMessage());
                aas.a(Integer.valueOf(0));
                aas.a((Context) this);
                return;
            }
        }
        if (i == 1888 && i2 == -1) {
            File file = new File(Environment.getExternalStorageDirectory() + File.separator + "image.jpg");
            this.y = new Intent(this, ImageEditorActivity.class);
            this.y.setType("image*//*");
            this.y.putExtra("return-data", true);
            this.y.putExtra("FixedAspectRatio", true);
            this.y.setData(Uri.fromFile(file));
            startActivityForResult(this.y, 113);
        }
        if (i == 112 && i2 == -1 && intent != null) {
            Uri data2 = intent.getData();
            this.y = new Intent(this, ImageEditorActivity.class);
            this.y.setType("image*//*");
            this.y.putExtra("return-data", true);
            this.y.putExtra("FixedAspectRatio", true);
            this.y.setData(data2);
            startActivityForResult(this.y, 113);
        }
    }

    private void o() {
        Builder builder = new Builder(this);
        builder.setTitle("\u0628\u0627\u0631\u06af\u0632\u0627\u0631\u06cc \u062a\u0635\u0648\u06cc\u0631 ");
        builder.setMessage("\u0627\u0632 \u0686\u0647 \u0637\u0631\u06cc\u0642\u06cc \u0645\u06cc \u062e\u0648\u0627\u0647\u06cc\u062f \u0639\u06a9\u0633 \u0622\u067e\u0644\u0648\u062f \u06a9\u0646\u06cc\u062f");
        builder.setPositiveButton("\u06af\u0627\u0644\u0631\u06cc", new wv(this));
        builder.setNegativeButton("\u062f\u0648\u0631\u0628\u06cc\u0646", new ww(this));
        builder.show();
    }
}
