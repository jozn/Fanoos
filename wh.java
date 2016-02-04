import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import ir.seraj.fanoos.Activity.ImageEditorActivity;
import java.io.File;

public class wh implements OnClickListener {
    final /* synthetic */ ImageEditorActivity a;

    public wh(ImageEditorActivity imageEditorActivity) {
        this.a = imageEditorActivity;
    }

    public void onClick(View view) {
        Bitmap croppedImage = this.a.n.getCroppedImage();
        this.a.o = yy.a("editeImagef");
        zq.a(croppedImage, this.a.o);
        String str = zk.a + "/" + this.a.o;
        Intent intent = new Intent("ir.seraj.intent.ImageEditUri", Uri.fromFile(new File(zk.a, this.a.o)));
        intent.putExtra("ir.seraj.intent.ImageEditUri", str);
        this.a.setResult(-1, intent);
        this.a.finish();
    }
}
