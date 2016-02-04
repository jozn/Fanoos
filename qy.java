import android.view.View;
import android.view.View.OnClickListener;

class qy implements OnClickListener {
    final /* synthetic */ qv a;

    private qy(qv qvVar) {
        this.a = qvVar;
    }

    public void onClick(View view) {
        ((qz) view).b().e();
        int childCount = this.a.g.getChildCount();
        for (int i = 0; i < childCount; i++) {
            boolean z;
            View childAt = this.a.g.getChildAt(i);
            if (childAt == view) {
                z = true;
            } else {
                z = false;
            }
            childAt.setSelected(z);
        }
    }
}
