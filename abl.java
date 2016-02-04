import android.text.Editable;
import android.text.TextWatcher;
import ir.seraj.fanoos.Fragment.AddGroupSingleParticipantsFragment;

public class abl implements TextWatcher {
    final /* synthetic */ AddGroupSingleParticipantsFragment a;

    public abl(AddGroupSingleParticipantsFragment addGroupSingleParticipantsFragment) {
        this.a = addGroupSingleParticipantsFragment;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.a.b = charSequence.toString();
        this.a.a = zg.a(this.a.h(), this.a.b, this.a.e);
        this.a.d = new xt(this.a.h(), this.a.a);
        this.a.c.setAdapter(this.a.d);
    }

    public void afterTextChanged(Editable editable) {
    }
}
