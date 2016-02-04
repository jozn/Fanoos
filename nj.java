import android.annotation.TargetApi;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarActivityDelegateBase;
import android.support.v7.internal.widget.NativeActionModeAwareLayout;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.KeyEvent;
import android.view.View;

@TargetApi(11)
class nj extends ActionBarActivityDelegateBase implements qt {
    private NativeActionModeAwareLayout k;

    nj(ActionBarActivity actionBarActivity) {
        super(actionBarActivity);
    }

    void o() {
        this.k = (NativeActionModeAwareLayout) this.a.findViewById(16908290);
        if (this.k != null) {
            this.k.setActionModeForChildListener(this);
        }
    }

    boolean a(int i, KeyEvent keyEvent) {
        return false;
    }

    public ActionMode a(View view, Callback callback) {
        ru b = b(new oj(view.getContext(), callback));
        if (b != null) {
            return new oi(this.a, b);
        }
        return null;
    }
}
