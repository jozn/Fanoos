import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;

public class o extends Handler {
    final /* synthetic */ FragmentActivity a;

    public o(FragmentActivity fragmentActivity) {
        this.a = fragmentActivity;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case ve.CropImageView_fixAspectRatio /*1*/:
                if (this.a.f) {
                    this.a.a(false);
                }
            case ve.CropImageView_aspectRatioX /*2*/:
                this.a.b();
                this.a.b.f();
            default:
                super.handleMessage(message);
        }
    }
}
