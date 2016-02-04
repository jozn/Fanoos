import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

public interface fo {
    void a(View view, int i);

    void a(View view, Object obj);

    boolean a(View view, AccessibilityEvent accessibilityEvent);

    boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent);

    void b(View view, AccessibilityEvent accessibilityEvent);

    void c(View view, AccessibilityEvent accessibilityEvent);

    void d(View view, AccessibilityEvent accessibilityEvent);
}
