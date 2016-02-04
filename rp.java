import android.view.View;
import android.view.View.OnClickListener;

class rp implements OnClickListener {
    final op a;
    final /* synthetic */ ro b;

    rp(ro roVar) {
        this.b = roVar;
        this.a = new op(this.b.a.getContext(), 0, 16908332, 0, 0, this.b.j);
    }

    public void onClick(View view) {
        if (this.b.m != null && this.b.n) {
            this.b.m.a(0, this.a);
        }
    }
}
