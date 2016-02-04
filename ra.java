import android.view.View;

public class ra implements jk {
    final /* synthetic */ qv a;
    private boolean b;
    private int c;

    protected ra(qv qvVar) {
        this.a = qvVar;
        this.b = false;
    }

    public void a(View view) {
        this.a.setVisibility(0);
        this.b = false;
    }

    public void b(View view) {
        if (!this.b) {
            this.a.d = null;
            this.a.setVisibility(this.c);
        }
    }

    public void c(View view) {
        this.b = true;
    }
}
