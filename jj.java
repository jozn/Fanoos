import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

final class jj implements AnimatorUpdateListener {
    final /* synthetic */ jm a;
    final /* synthetic */ View b;

    jj(jm jmVar, View view) {
        this.a = jmVar;
        this.b = view;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.a(this.b);
    }
}
