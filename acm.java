import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import ir.seraj.fanoos.Fragment.ConversationFragment;

public class acm implements OnItemClickListener {
    final /* synthetic */ ConversationFragment a;

    public acm(ConversationFragment conversationFragment) {
        this.a = conversationFragment;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        switch (i) {
            case ve.CropImageView_guidelines /*0*/:
                this.a.U();
            case ve.CropImageView_fixAspectRatio /*1*/:
                this.a.W();
            case ve.CropImageView_aspectRatioX /*2*/:
                this.a.V();
            case ve.CropImageView_aspectRatioY /*3*/:
                this.a.X();
            case ve.CropImageView_imageResource /*4*/:
                this.a.aL.setVisibility(0);
                this.a.d.setVisibility(8);
                this.a.aM.setVisibility(0);
                this.a.aN.setVisibility(0);
                this.a.au = Integer.valueOf(3);
            default:
        }
    }
}
