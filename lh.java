import android.database.DataSetObserver;

class lh extends DataSetObserver {
    final /* synthetic */ le a;

    private lh(le leVar) {
        this.a = leVar;
    }

    public void onChanged() {
        this.a.a = true;
        this.a.notifyDataSetChanged();
    }

    public void onInvalidated() {
        this.a.a = false;
        this.a.notifyDataSetInvalidated();
    }
}
