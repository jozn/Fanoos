import android.support.v7.app.ActionBarActivityDelegateBase;
import android.view.View;

public class nc implements gz {
    final /* synthetic */ ActionBarActivityDelegateBase a;

    public nc(ActionBarActivityDelegateBase actionBarActivityDelegateBase) {
        this.a = actionBarActivityDelegateBase;
    }

    public jn a(View view, jn jnVar) {
        int b = jnVar.b();
        int c = this.a.e(b);
        if (b != c) {
            return jnVar.a(jnVar.a(), c, jnVar.c(), jnVar.d());
        }
        return jnVar;
    }
}
