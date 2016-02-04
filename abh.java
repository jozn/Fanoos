import android.graphics.Color;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import ir.seraj.fanoos.Fragment.AddGroupParticipantsFragment;
import ir.seraj.fanoos3.R;

public class abh implements OnItemClickListener {
    final /* synthetic */ AddGroupParticipantsFragment a;

    public abh(AddGroupParticipantsFragment addGroupParticipantsFragment) {
        this.a = addGroupParticipantsFragment;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.addParticipants_add_CheckBox);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.addParticipants_frame_rr);
        if (((zg) this.a.a.get(i)).b().booleanValue()) {
            ((zg) this.a.a.get(i)).a(Boolean.valueOf(false));
            if (this.a.g.containsKey(((zg) this.a.a.get(i)).d())) {
                this.a.g.remove(((zg) this.a.a.get(i)).d());
            }
            checkBox.setChecked(false);
            relativeLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
            return;
        }
        ((zg) this.a.a.get(i)).a(Boolean.valueOf(true));
        checkBox.setChecked(true);
        relativeLayout.setBackgroundColor(Color.parseColor("#E6E6E6"));
        if (!this.a.g.containsKey(((zg) this.a.a.get(i)).d())) {
            this.a.g.put(((zg) this.a.a.get(i)).d(), "1");
        }
    }
}
