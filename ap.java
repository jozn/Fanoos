import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class ap implements OnItemClickListener {
    final /* synthetic */ ListFragment a;

    public ap(ListFragment listFragment) {
        this.a = listFragment;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.a.a((ListView) adapterView, view, i, j);
    }
}
