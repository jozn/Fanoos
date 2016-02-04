import android.support.v4.app.Fragment;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class y implements AnimationListener {
    final /* synthetic */ Fragment a;
    final /* synthetic */ u b;

    y(u uVar, Fragment fragment) {
        this.b = uVar;
        this.a = fragment;
    }

    public void onAnimationEnd(Animation animation) {
        if (this.a.l != null) {
            this.a.l = null;
            this.b.a(this.a, this.a.m, 0, 0, false);
        }
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
