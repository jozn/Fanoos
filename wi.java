import android.view.View;
import android.view.View.OnClickListener;
import ir.seraj.fanoos.Activity.ImageEditorActivity;

public class wi implements OnClickListener {
    final /* synthetic */ ImageEditorActivity a;

    public wi(ImageEditorActivity imageEditorActivity) {
        this.a = imageEditorActivity;
    }

    public void onClick(View view) {
        this.a.finish();
    }
}
