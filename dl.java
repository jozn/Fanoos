import android.content.ComponentName;
import android.content.Intent;

class dl {
    public static Intent a(ComponentName componentName) {
        return Intent.makeMainActivity(componentName);
    }
}
