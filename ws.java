import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import ir.seraj.fanoos.Activity.RestoreActivity;
import ir.seraj.fanoos.communication.IntentServiceGeneralCommand;

public class ws implements OnClickListener {
    final /* synthetic */ RestoreActivity a;

    public ws(RestoreActivity restoreActivity) {
        this.a = restoreActivity;
    }

    public void onClick(View view) {
        ys.c(view.getContext());
        Intent intent = new Intent(view.getContext(), IntentServiceGeneralCommand.class);
        intent.putExtra("receiverTag", this.a.n);
        intent.putExtra("CommandCode", 3);
        this.a.startService(intent);
    }
}
