import android.support.v7.internal.widget.SpinnerCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class rg implements OnItemClickListener {
    final /* synthetic */ SpinnerCompat a;
    final /* synthetic */ rf b;

    rg(rf rfVar, SpinnerCompat spinnerCompat) {
        this.b = rfVar;
        this.a = spinnerCompat;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.b.a.setSelection(i);
        if (this.b.a.s != null) {
            this.b.a.a(view, i, this.b.d.getItemId(i));
        }
        this.b.a();
    }
}
