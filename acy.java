import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import ir.seraj.fanoos.Fragment.AddGroupSingleParticipantsFragment;
import ir.seraj.fanoos.Fragment.GroupInfoFragment;
import ir.seraj.fanoos3.R;

public class acy implements OnClickListener {
    final /* synthetic */ GroupInfoFragment a;

    public acy(GroupInfoFragment groupInfoFragment) {
        this.a = groupInfoFragment;
    }

    public void onClick(View view) {
        if (this.a.b.size() >= 110) {
            Toast.makeText(this.a.h(), "\u0638\u0631\u0641\u06cc\u062a \u06af\u0631\u0648\u0647 \u062a\u06a9\u0645\u06cc\u0644 \u0645\u06cc \u0628\u0627\u0634\u062f.", 0).show();
        } else if (zm.a(this.a.h()).booleanValue()) {
            Fragment addGroupSingleParticipantsFragment = new AddGroupSingleParticipantsFragment();
            Bundle bundle = new Bundle();
            bundle.putString("GroupId", String.valueOf(this.a.c));
            addGroupSingleParticipantsFragment.g(bundle);
            this.a.h().f().a().a(null).a(R.id.container, addGroupSingleParticipantsFragment).b();
        } else {
            Toast.makeText(this.a.h(), "\u0639\u062f\u0645 \u0627\u062a\u0635\u0627\u0644 \u06cc\u0647 \u0627\u06cc\u0646\u062a\u0631\u0646\u062a", 0).show();
        }
    }
}
