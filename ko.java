import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

final class ko extends AccessibilityNodeProvider {
    final /* synthetic */ kp a;

    ko(kp kpVar) {
        this.a = kpVar;
    }

    public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
        return (AccessibilityNodeInfo) this.a.a(i);
    }

    public List findAccessibilityNodeInfosByText(String str, int i) {
        return this.a.a(str, i);
    }

    public boolean performAction(int i, int i2, Bundle bundle) {
        return this.a.a(i, i2, bundle);
    }
}
