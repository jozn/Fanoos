import android.content.Intent;
import ir.seraj.fanoos.Activity.EnterPhoneNumberActivity;
import ir.seraj.fanoos.Activity.SplashActivity;
import java.io.File;

public class xl implements Runnable {
    final /* synthetic */ SplashActivity a;

    public xl(SplashActivity splashActivity) {
        this.a = splashActivity;
    }

    public void run() {
        ys.l(this.a);
        this.a.startActivity(new Intent(this.a, EnterPhoneNumberActivity.class));
        try {
            File file = new File(zk.a + File.separator + "myProfileImage.jpg");
            if (file.exists()) {
                file.delete();
            }
            file = new File(zk.e);
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Exception e) {
        }
    }
}
