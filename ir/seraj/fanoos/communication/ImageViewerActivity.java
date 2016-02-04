package ir.seraj.fanoos.communication;

import adq;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;
import ir.seraj.fanoos3.R;
import java.io.File;

public class ImageViewerActivity extends ActionBarActivity {
    adq n;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_image_viewer);
        ImageView imageView = (ImageView) findViewById(R.id.image_viewer_imageView);
        try {
            File file = new File(getIntent().getStringExtra("image"));
            if (file.exists()) {
                imageView.setImageBitmap(BitmapFactory.decodeFile(file.getAbsolutePath()));
                this.n = new adq(imageView);
            }
        } catch (Exception e) {
        }
    }
}
