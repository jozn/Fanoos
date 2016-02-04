import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityEvent;

public class jp {
    private static final js a;

    static {
        if (VERSION.SDK_INT >= 14) {
            a = new jq();
        } else {
            a = new jr();
        }
    }

    public static kt a(AccessibilityEvent accessibilityEvent) {
        return new kt(accessibilityEvent);
    }
}
