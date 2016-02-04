import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;
import ir.seraj.fanoos.Fragment.AddGroupParticipantsFragment;
import ir.seraj.fanoos.Fragment.CreateGroupFragment;
import ir.seraj.fanoos3.R;

public class acp implements OnClickListener {
    final /* synthetic */ EditText a;
    final /* synthetic */ CreateGroupFragment b;

    public acp(CreateGroupFragment createGroupFragment, EditText editText) {
        this.b = createGroupFragment;
        this.a = editText;
    }

    public void onClick(View view) {
        if (this.a.getText().length() > 0) {
            Fragment addGroupParticipantsFragment = new AddGroupParticipantsFragment();
            Bundle bundle = new Bundle();
            bundle.putString("GroupName", yz.k(this.a.getText().toString()));
            bundle.putString("GroupImage", this.b.a);
            addGroupParticipantsFragment.g(bundle);
            this.b.h().f().a().a(null).b(R.id.container, addGroupParticipantsFragment).b();
            return;
        }
        Toast.makeText(view.getContext(), "\u0644\u0637\u0641\u0627 \u0646\u0627\u0645 \u06af\u0631\u0648\u0647 \u0631\u0627 \u0648\u0627\u0631\u062f \u0646\u0645\u0627\u06cc\u06cc\u062f", 1).show();
    }
}
