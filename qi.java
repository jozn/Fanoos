import android.database.DataSetObserver;
import android.os.Parcelable;

public class qi extends DataSetObserver {
    final /* synthetic */ qg a;
    private Parcelable b;

    public qi(qg qgVar) {
        this.a = qgVar;
        this.b = null;
    }

    public void onChanged() {
        this.a.u = true;
        this.a.A = this.a.z;
        this.a.z = this.a.getAdapter().getCount();
        if (!this.a.getAdapter().hasStableIds() || this.b == null || this.a.A != 0 || this.a.z <= 0) {
            this.a.j();
        } else {
            this.a.onRestoreInstanceState(this.b);
            this.b = null;
        }
        this.a.e();
        this.a.requestLayout();
    }

    public void onInvalidated() {
        this.a.u = true;
        if (this.a.getAdapter().hasStableIds()) {
            this.b = this.a.onSaveInstanceState();
        }
        this.a.A = this.a.z;
        this.a.z = 0;
        this.a.x = -1;
        this.a.y = Long.MIN_VALUE;
        this.a.v = -1;
        this.a.w = Long.MIN_VALUE;
        this.a.o = false;
        this.a.e();
        this.a.requestLayout();
    }
}
