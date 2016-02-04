package android.support.v7.internal.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.View;
import qt;

@TargetApi(11)
public class NativeActionModeAwareLayout extends ContentFrameLayout {
    private qt a;

    public NativeActionModeAwareLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setActionModeForChildListener(qt qtVar) {
        this.a = qtVar;
    }

    public ActionMode startActionModeForChild(View view, Callback callback) {
        if (this.a != null) {
            return this.a.a(view, callback);
        }
        return super.startActionModeForChild(view, callback);
    }
}
