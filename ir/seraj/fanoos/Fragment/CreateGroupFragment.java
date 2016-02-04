package ir.seraj.fanoos.Fragment;

import aas;
import aco;
import acp;
import acq;
import acr;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import ir.seraj.fanoos.Activity.CreateGroupActivity;
import ir.seraj.fanoos.Activity.ImageEditorActivity;
import ir.seraj.fanoos3.R;
import java.io.File;
import ys;
import zn;

public class CreateGroupFragment extends Fragment {
    public String a;
    Bitmap b;
    int c;
    private Intent d;

    public CreateGroupFragment() {
        this.c = 0;
        this.d = null;
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        c(true);
        View inflate = layoutInflater.inflate(R.layout.fragment_create_group, viewGroup, false);
        ((CreateGroupActivity) h()).b(true);
        ((ImageView) inflate.findViewById(R.id.create_group_icon_imageView)).setOnClickListener(new aco(this));
        ((Button) inflate.findViewById(R.id.create_group_submit_button)).setOnClickListener(new acp(this, (EditText) inflate.findViewById(R.id.create_group_name_editText)));
        return inflate;
    }

    public void a(int i, int i2, Intent intent) {
        if (i == 113 && i2 == -1 && intent != null) {
            try {
                Options options = new Options();
                options.inPreferredConfig = Config.ARGB_8888;
                this.b = BitmapFactory.decodeFile(intent.getStringExtra("ir.seraj.intent.ImageEditUri"), options);
                ((ImageView) h().findViewById(R.id.create_group_icon_imageView)).setImageBitmap(this.b);
                this.a = intent.getStringExtra("ir.seraj.intent.ImageEditUri");
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
                this.d = new Intent(h(), ImageEditorActivity.class);
                this.d.setType("image*//*");
                this.d.putExtra("return-data", true);
                this.d.putExtra("FixedAspectRatio", true);
                this.d.setData(Uri.fromFile(file));
                a(this.d, 113);
            }
        }
        if (i == 112) {
            h();
            if (i2 == -1 && intent != null) {
                Uri data = intent.getData();
                this.d = new Intent(h(), ImageEditorActivity.class);
                this.d.setType("image*//*");
                this.d.putExtra("return-data", true);
                this.d.putExtra("FixedAspectRatio", true);
                this.d.setData(data);
                a(this.d, 113);
            }
        }
    }

    private void a() {
        Builder builder = new Builder(h());
        builder.setTitle("\u0628\u0627\u0631\u06af\u0632\u0627\u0631\u06cc \u062a\u0635\u0648\u06cc\u0631 ");
        builder.setMessage("\u0627\u0632 \u0686\u0647 \u0637\u0631\u06cc\u0642\u06cc \u0645\u06cc \u062e\u0648\u0627\u0647\u06cc\u062f \u0639\u06a9\u0633 \u0622\u067e\u0644\u0648\u062f \u06a9\u0646\u06cc\u062f");
        builder.setPositiveButton("\u06af\u0627\u0644\u0631\u06cc", new acq(this));
        builder.setNegativeButton("\u062f\u0648\u0631\u0628\u06cc\u0646", new acr(this));
        builder.show();
    }
}
