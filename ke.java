import android.view.accessibility.AccessibilityNodeInfo;

class ke {
    public static String a(Object obj) {
        return ((AccessibilityNodeInfo) obj).getViewIdResourceName();
    }
}
