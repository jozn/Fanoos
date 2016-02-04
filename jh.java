import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

final class jh extends AnimatorListenerAdapter {
    final /* synthetic */ jk a;
    final /* synthetic */ View b;

    jh(jk jkVar, View view) {
        this.a = jkVar;
        this.b = view;
    }

    public void onAnimationCancel(Animator animator) {
        this.a.c(this.b);
    }

    public void onAnimationEnd(Animator animator) {
        this.a.b(this.b);
    }

    public void onAnimationStart(Animator animator) {
        this.a.a(this.b);
    }
}
