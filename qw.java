import android.view.View;

class qw implements Runnable {
    final /* synthetic */ View a;
    final /* synthetic */ qv b;

    qw(qv qvVar, View view) {
        this.b = qvVar;
        this.a = view;
    }

    public void run() {
        this.b.smoothScrollTo(this.a.getLeft() - ((this.b.getWidth() - this.a.getWidth()) / 2), 0);
        this.b.a = null;
    }
}
