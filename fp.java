import android.os.Bundle;
import android.view.View;
import android.view.View.AccessibilityDelegate;

class fp {
    public static Object a(fr frVar) {
        return new fq(frVar);
    }

    public static Object a(Object obj, View view) {
        return ((AccessibilityDelegate) obj).getAccessibilityNodeProvider(view);
    }

    public static boolean a(Object obj, View view, int i, Bundle bundle) {
        return ((AccessibilityDelegate) obj).performAccessibilityAction(view, i, bundle);
    }
}
