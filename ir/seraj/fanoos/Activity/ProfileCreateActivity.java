package ir.seraj.fanoos.Activity;

import aas;
import aeq;
import afe;
import afk;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import ir.seraj.fanoos.communication.MyResultReceiver;
import ir.seraj.fanoos3.R;
import java.io.File;
import org.xmlpull.v1.XmlPullParser;
import wn;
import wo;
import wp;
import wq;
import ys;
import zn;
import zt;

public class ProfileCreateActivity extends ActionBarActivity implements afk {
    ProgressBar n;
    Bitmap o;
    int p;
    public MyResultReceiver q;
    ProgressDialog r;
    private Intent s;

    public ProfileCreateActivity() {
        this.p = 0;
        this.s = null;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_profile_create);
        g().c();
        this.q = new MyResultReceiver(new Handler());
        this.r = new ProgressDialog(this);
        this.n = (ProgressBar) findViewById(R.id.change_photo_progress);
        ((ImageView) findViewById(R.id.profile_info_item_imageContact_imageView)).setOnClickListener(new wn(this));
        ((Button) findViewById(R.id.profile_info_submit)).setOnClickListener(new wo(this, (EditText) findViewById(R.id.profile_info_name_editText)));
    }

    protected void onResume() {
        this.q.a(this);
        if (ys.p(this).booleanValue()) {
            finish();
        }
        super.onPause();
    }

    protected void onPause() {
        this.q.a(null);
        super.onPause();
    }

    public void onBackPressed() {
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 113 && i2 == -1 && intent != null) {
            try {
                Options options = new Options();
                options.inPreferredConfig = Config.ARGB_8888;
                this.o = BitmapFactory.decodeFile(intent.getStringExtra("ir.seraj.intent.ImageEditUri"), options);
                ((ImageView) findViewById(R.id.profile_info_item_imageContact_imageView)).setImageBitmap(this.o);
                new afe(this, this.n, intent.getStringExtra("ir.seraj.intent.ImageEditUri")).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
            } catch (Exception e) {
                aas aas = new aas();
                aas.a("ir.seraj.fanoos");
                aas.e(ys.a(this));
                aas.d(zn.a());
                aas.c("openGallery");
                aas.b(e.getMessage());
                aas.a(Integer.valueOf(0));
                aas.a((Context) this);
                return;
            }
        }
        if (i == 1888 && i2 == -1) {
            File file = new File(Environment.getExternalStorageDirectory() + File.separator + "image.jpg");
            this.s = new Intent(this, ImageEditorActivity.class);
            this.s.setType("image*//*");
            this.s.putExtra("return-data", true);
            this.s.putExtra("FixedAspectRatio", true);
            this.s.setData(Uri.fromFile(file));
            startActivityForResult(this.s, 113);
        }
        if (i == 112 && i2 == -1 && intent != null) {
            Uri data = intent.getData();
            this.s = new Intent(this, ImageEditorActivity.class);
            this.s.setType("image*//*");
            this.s.putExtra("return-data", true);
            this.s.putExtra("FixedAspectRatio", true);
            this.s.setData(data);
            startActivityForResult(this.s, 113);
        }
    }

    private void j() {
        Builder builder = new Builder(this);
        builder.setTitle("\u0628\u0627\u0631\u06af\u0632\u0627\u0631\u06cc \u062a\u0635\u0648\u06cc\u0631 ");
        builder.setMessage("\u0627\u0632 \u0686\u0647 \u0637\u0631\u06cc\u0642\u06cc \u0645\u06cc \u062e\u0648\u0627\u0647\u06cc\u062f \u0639\u06a9\u0633 \u0622\u067e\u0644\u0648\u062f \u06a9\u0646\u06cc\u062f");
        builder.setPositiveButton("\u06af\u0627\u0644\u0631\u06cc", new wp(this));
        builder.setNegativeButton("\u062f\u0648\u0631\u0628\u06cc\u0646", new wq(this));
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
        aeq.o(this);
        if (i2 == 4) {
            str = bundle.getString("InsertOrEditNikName");
            if (i == 0) {
                this.r.setCancelable(false);
                this.r.setMessage("\u062f\u0631\u062d\u0627\u0644 \u0628\u0631\u0642\u0631\u0627\u0631\u06cc \u0627\u0631\u062a\u0628\u0627\u0637");
                this.r.show();
                return;
            }
            this.r.dismiss();
            if (str.equals("  ")) {
                startActivity(new Intent(this, ChatsActivity.class));
            } else {
                new zt().b(this);
            }
        }
    }
}
