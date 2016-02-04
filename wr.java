import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import ir.seraj.fanoos.Activity.ProfileCreateActivity;
import ir.seraj.fanoos.Activity.RestoreActivity;

public class wr implements OnClickListener {
    final /* synthetic */ RestoreActivity a;

    public wr(RestoreActivity restoreActivity) {
        this.a = restoreActivity;
    }

    public void onClick(View view) {
        ys.c(view.getContext());
        this.a.startActivity(new Intent(view.getContext(), ProfileCreateActivity.class));
    }
}
