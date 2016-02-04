import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import ir.seraj.fanoos.Fragment.AddGroupSingleParticipantsFragment;

public class abk implements OnItemClickListener {
    final /* synthetic */ AddGroupSingleParticipantsFragment a;

    public abk(AddGroupSingleParticipantsFragment addGroupSingleParticipantsFragment) {
        this.a = addGroupSingleParticipantsFragment;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        new zt().a(((zg) this.a.a.get(i)).d(), String.valueOf(this.a.e), this.a.h, this.a.h());
    }
}
