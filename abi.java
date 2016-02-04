import android.text.Editable;
import android.text.TextWatcher;
import ir.seraj.fanoos.Fragment.AddGroupParticipantsFragment;

public class abi implements TextWatcher {
    final /* synthetic */ AddGroupParticipantsFragment a;

    public abi(AddGroupParticipantsFragment addGroupParticipantsFragment) {
        this.a = addGroupParticipantsFragment;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.a.d = charSequence.toString();
        this.a.a = zg.b(this.a.h(), this.a.d);
        for (int i4 = 0; i4 < this.a.a.size(); i4++) {
            if (this.a.g.containsKey(((zg) this.a.a.get(i4)).d())) {
                ((zg) this.a.a.get(i4)).a(Boolean.valueOf(true));
            }
        }
        this.a.f = new xr(this.a.h(), this.a.a);
        this.a.e.setAdapter(this.a.f);
    }

    public void afterTextChanged(Editable editable) {
    }
}
