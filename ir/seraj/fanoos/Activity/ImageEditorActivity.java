package ir.seraj.fanoos.Activity;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Images.Media;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import com.edmodo.cropper.CropImageView;
import ir.seraj.fanoos3.R;
import java.io.File;
import wh;
import wi;

public class ImageEditorActivity extends ActionBarActivity {
    public CropImageView n;
    public String o;
    Boolean p;

    public ImageEditorActivity() {
        this.p = Boolean.valueOf(false);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_image_editor);
        Uri data = getIntent().getData();
        this.p = Boolean.valueOf(getIntent().getBooleanExtra("FixedAspectRatio", false));
        try {
            File file = new File(data.getPath());
            Bitmap bitmap = Media.getBitmap(getContentResolver(), data);
            this.n = (CropImageView) findViewById(R.id.CropImageView);
            if (this.p.booleanValue()) {
                this.n.setFixedAspectRatio(true);
            }
            this.n.setGuidelines(1);
            this.n.setImageBitmap(bitmap);
        } catch (Exception e) {
        }
        ((Button) findViewById(R.id.image_editor_ok_button)).setOnClickListener(new wh(this));
        ((Button) findViewById(R.id.image_editor_cancel_button)).setOnClickListener(new wi(this));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
